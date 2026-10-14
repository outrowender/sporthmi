#!/usr/bin/env python3
"""
kzb_repack.py - size-safe texture replacer for Harman/Kanzi monolithic .KZB files
(verified against Audi MIB2 SPORT_HMI.kzb, MU1326).

The .KZB stores a resource directory near the top of the file. Each texture has a
16-byte descriptor located immediately before its name string:

    offset  u32 BE   chunkOffset  (== PNG signature - 4; points at the 4-byte separator)
    +4      u32 BE   chunkSize    (== raw PNG byte length)
    +8      u32 BE   type         (10 for PNG)
    +12     u32 BE   flags        (0)
    +16     u16 BE   nameLen
    +18     ...      name (e.g. "labels_atlas_g21.png")

Textures are packed back-to-back as [4-byte 0x00000000 separator][PNG] ... with a
trailing footer after the last one. Because the directory stores ABSOLUTE offsets,
replacing a texture with one of a different byte length shifts every following
texture and corrupts the file unless the directory is rewritten. This script does
exactly that: it rebuilds the texture region and patches every descriptor's
offset + size, preserving the header, node graph, separators and footer.

Usage:
    kzb_repack.py IN.kzb --list
    kzb_repack.py IN.kzb OUT.kzb NAME=new.png [NAME2=new2.png ...]

Example:
    kzb_repack.py SPORT_HMI.kzb SPORT_HMI_new.kzb labels_atlas_g21.png=mylabels.png
"""

import struct
import sys

PNG_SIG = b"\x89PNG\r\n\x1a\n"


def find_all(buf, sub):
    out = []
    i = buf.find(sub)
    while i != -1:
        out.append(i)
        i = buf.find(sub, i + 1)
    return out


def parse(kzb):
    """Return list of texture dicts and the offset where the texture region starts."""
    sigs = find_all(kzb, PNG_SIG)
    if not sigs:
        raise SystemExit("no PNG resources found; not a monolithic KZB?")

    # name string start for each ".png"
    name_starts = []
    for p in find_all(kzb, b".png"):
        st = p
        while st > 0 and 32 <= kzb[st - 1] < 127:
            st -= 1
        name_starts.append(st)
    name_starts.sort()

    if len(name_starts) != len(sigs):
        raise SystemExit("name/PNG count mismatch (%d names, %d PNGs)"
                         % (len(name_starts), len(sigs)))

    textures = []
    for k, st in enumerate(name_starts):
        ds = st - 18  # 16-byte descriptor + u16 nameLen
        off, size, typ, flags = struct.unpack(">IIII", kzb[ds:ds + 16])
        nl = struct.unpack(">H", kzb[ds + 16:ds + 18])[0]
        name = kzb[st:st + nl].decode("latin1")
        sig = sigs[k]
        if off != sig - 4:
            raise SystemExit("descriptor/offset mismatch for %s "
                             "(desc 0x%X, sig-4 0x%X)" % (name, off, sig - 4))
        png = kzb[sig:sig + size]  # exact raw PNG bytes
        if not png.startswith(PNG_SIG):
            raise SystemExit("extracted bytes for %s are not a PNG" % name)
        sep = kzb[off:off + 4]  # 4-byte separator that precedes this PNG
        textures.append(dict(name=name, desc_pos=ds, off=off, size=size,
                             sig=sig, sep=sep, png=png))
    return textures, sigs


def main():
    if len(sys.argv) < 3:
        print(__doc__)
        sys.exit(1)

    in_path = sys.argv[1]
    kzb = open(in_path, "rb").read()
    textures, sigs = parse(kzb)

    if sys.argv[2] == "--list":
        print("%-30s %-10s %-10s" % ("name", "offset", "size"))
        for t in textures:
            print("%-30s 0x%08X %10d" % (t["name"], t["off"], t["size"]))
        return

    out_path = sys.argv[2]

    # parse NAME=path replacements
    repl = {}
    for arg in sys.argv[3:]:
        if "=" not in arg:
            raise SystemExit("bad replacement (need NAME=file.png): %r" % arg)
        name, path = arg.split("=", 1)
        data = open(path, "rb").read()
        if not data.startswith(PNG_SIG):
            raise SystemExit("%s is not a PNG" % path)
        repl[name] = data

    known = set(t["name"] for t in textures)
    for name in repl:
        if name not in known:
            raise SystemExit("unknown texture %r; use --list. known: %s"
                             % (name, ", ".join(sorted(known))))

    # safety: each old offset must be referenced only by its own descriptor
    for t in textures:
        hits = find_all(kzb, struct.pack(">I", t["off"]))
        extra = [h for h in hits if h != t["desc_pos"]]
        if extra:
            print("WARNING: offset of %s (0x%X) also appears at %s - repack may "
                  "be unsafe" % (t["name"], t["off"], [hex(x) for x in extra]),
                  file=sys.stderr)

    first_off = textures[0]["off"]
    last = textures[-1]
    tail_start = last["sig"] + last["size"]
    head = bytearray(kzb[:first_off])
    tail = kzb[tail_start:]

    # rebuild texture region, recording new offsets/sizes
    out = bytearray(head)
    new = []
    for t in textures:
        png = repl.get(t["name"], t["png"])
        new_off = len(out)
        out += t["sep"]          # preserve original 4-byte separator
        out += png               # replaced or original PNG
        new.append((t["desc_pos"], new_off, len(png)))
    out += tail

    # patch descriptors (offset @+0, size @+4) in the header copy inside out
    for desc_pos, new_off, new_size in new:
        struct.pack_into(">II", out, desc_pos, new_off, new_size)

    # validate the result by re-parsing
    verify, _ = parse(bytes(out))
    for t in verify:
        exp = repl.get(t["name"])
        if exp is not None and t["png"] != exp:
            raise SystemExit("verify failed: %s payload mismatch" % t["name"])

    open(out_path, "wb").write(out)
    changed = ", ".join(sorted(repl)) if repl else "(none)"
    print("wrote %s  (%d -> %d bytes)  replaced: %s"
          % (out_path, len(kzb), len(out), changed))


if __name__ == "__main__":
    main()
