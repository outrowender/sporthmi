#!/usr/bin/env python3
import argparse
import pathlib
import struct
import sys
import zlib


PNG_SIGNATURE = b"\x89PNG\r\n\x1a\n"
CHANNELS_BY_COLOR_TYPE = {0: 1, 2: 3, 3: 1, 4: 2, 6: 4}


def read_png(data):
    if not data.startswith(PNG_SIGNATURE):
        raise ValueError("input is not a PNG")

    offset = len(PNG_SIGNATURE)
    ihdr = None
    palette = None
    transparency = None
    idat = bytearray()
    dropped = []
    saw_iend = False

    while offset + 12 <= len(data):
        length = struct.unpack_from(">I", data, offset)[0]
        end = offset + length + 12
        if end > len(data):
            raise ValueError("truncated PNG chunk")

        chunk_type = data[offset + 4:offset + 8]
        chunk_data = data[offset + 8:offset + 8 + length]
        stored_crc = struct.unpack_from(">I", data, offset + 8 + length)[0]
        actual_crc = zlib.crc32(chunk_type + chunk_data) & 0xffffffff
        if stored_crc != actual_crc:
            raise ValueError("invalid CRC in %s chunk" % chunk_type.decode("ascii", "replace"))

        if chunk_type == b"IHDR":
            if ihdr is not None or offset != len(PNG_SIGNATURE) or length != 13:
                raise ValueError("invalid IHDR chunk")
            ihdr = chunk_data
        elif chunk_type == b"PLTE":
            if palette is not None:
                raise ValueError("duplicate PLTE chunk")
            palette = chunk_data
        elif chunk_type == b"tRNS":
            if transparency is not None:
                raise ValueError("duplicate tRNS chunk")
            transparency = chunk_data
        elif chunk_type == b"IDAT":
            idat.extend(chunk_data)
        elif chunk_type == b"IEND":
            if length != 0:
                raise ValueError("invalid IEND chunk")
            saw_iend = True
            offset = end
            break
        else:
            if not (chunk_type[0] & 0x20):
                raise ValueError("unsupported critical PNG chunk %s" % chunk_type.decode("ascii", "replace"))
            dropped.append(chunk_type.decode("ascii", "replace"))

        offset = end

    if ihdr is None or not idat or not saw_iend or offset != len(data):
        raise ValueError("incomplete PNG")
    return ihdr, palette, transparency, bytes(idat), dropped


def paeth_predictor(left, up, upper_left):
    estimate = left + up - upper_left
    distance_left = abs(estimate - left)
    distance_up = abs(estimate - up)
    distance_upper_left = abs(estimate - upper_left)
    if distance_left <= distance_up and distance_left <= distance_upper_left:
        return left
    if distance_up <= distance_upper_left:
        return up
    return upper_left


def png_chunk(chunk_type, chunk_data):
    crc = zlib.crc32(chunk_type + chunk_data) & 0xffffffff
    return struct.pack(">I", len(chunk_data)) + chunk_type + chunk_data + struct.pack(">I", crc)


def filter_zero_png(data):
    ihdr, palette, transparency, compressed, dropped = read_png(data)
    width, height, bit_depth, color_type, compression, filtering, interlace = struct.unpack(">IIBBBBB", ihdr)
    channels = CHANNELS_BY_COLOR_TYPE.get(color_type)
    if not width or not height or bit_depth != 8 or channels is None:
        raise ValueError("only non-empty 8-bit PNGs are supported")
    if compression != 0 or filtering != 0 or interlace != 0:
        raise ValueError("only non-interlaced standard PNGs are supported")
    if color_type == 3 and palette is None:
        raise ValueError("indexed PNG is missing PLTE")

    stride = width * channels
    expected_size = height * (stride + 1)
    try:
        filtered = zlib.decompress(compressed)
    except zlib.error as error:
        raise ValueError("invalid compressed image data: %s" % error) from error
    if len(filtered) != expected_size:
        raise ValueError("unexpected decompressed image size")

    pixels = bytearray(height * stride)
    for y in range(height):
        filtered_row = y * (stride + 1)
        pixel_row = y * stride
        filter_type = filtered[filtered_row]
        if filter_type > 4:
            raise ValueError("invalid PNG filter type %d" % filter_type)

        for x in range(stride):
            left = pixels[pixel_row + x - channels] if x >= channels else 0
            up = pixels[pixel_row - stride + x] if y else 0
            upper_left = pixels[pixel_row - stride + x - channels] if y and x >= channels else 0
            if filter_type == 0:
                predictor = 0
            elif filter_type == 1:
                predictor = left
            elif filter_type == 2:
                predictor = up
            elif filter_type == 3:
                predictor = (left + up) // 2
            else:
                predictor = paeth_predictor(left, up, upper_left)
            pixels[pixel_row + x] = (filtered[filtered_row + 1 + x] + predictor) & 0xff

    filter_zero = bytearray(expected_size)
    for y in range(height):
        filtered_row = y * (stride + 1)
        pixel_row = y * stride
        filter_zero[filtered_row] = 0
        filter_zero[filtered_row + 1:filtered_row + stride + 1] = pixels[pixel_row:pixel_row + stride]

    chunks = [png_chunk(b"IHDR", ihdr)]
    if palette is not None:
        chunks.append(png_chunk(b"PLTE", palette))
    if transparency is not None:
        chunks.append(png_chunk(b"tRNS", transparency))
    chunks.append(png_chunk(b"IDAT", zlib.compress(filter_zero, 9)))
    chunks.append(png_chunk(b"IEND", b""))
    return PNG_SIGNATURE + b"".join(chunks), dropped, width, height


def main():
    parser = argparse.ArgumentParser(description="Re-encode an 8-bit PNG using filter 0 and remove ancillary chunks.")
    parser.add_argument("input", type=pathlib.Path, help="input PNG")
    parser.add_argument("output", nargs="?", type=pathlib.Path,
                        help="output PNG (default: INPUT_filter0.png)")
    args = parser.parse_args()

    output = args.output
    if output is None:
        output = args.input.with_name(args.input.stem + "_filter0" + args.input.suffix)
    if args.input.resolve() == output.resolve():
        parser.error("input and output must differ; the source is never overwritten")

    try:
        result, dropped, width, height = filter_zero_png(args.input.read_bytes())
        output.write_bytes(result)
    except (OSError, ValueError) as error:
        parser.exit(2, "png_filter0.py: error: %s\n" % error)

    print("Wrote %s (%d x %d, filter 0)" % (output, width, height))
    if dropped:
        print("Removed ancillary chunks: %s" % ", ".join(dropped))


if __name__ == "__main__":
    main()