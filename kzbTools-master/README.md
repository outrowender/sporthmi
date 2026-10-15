# `kzbTools`   

Forked from `BigUncleMax's` https://github.com/bigunclemax/kzbTools and upgraded to allow for repacking of `.kzb` files.

## Build
```
./build.sh
```
The script uses `${CXX:-c++}`; for example, run `CXX=g++ ./build.sh` to choose a compiler.
It requires the zlib development library.

### Windows (MSVC): 
```
cl /std:c++17 main.cpp Ws2_32.lib zlib.lib
```

## How to use
Unpack:
```
./kzbTools <input.kzb>
./kzbTools unpack <input.kzb> <output_dir>
```

Pack:
```
./kzbTools pack <extracted_dir> <output.kzb>
``` 
This rebuilds a generic KZB tree. It does not preserve archive-specific metadata.

For an archive that needs its original metadata and texture table preserved, use:
```
./kzbTools pack <original.kzb> <extracted_dir> <output.kzb>
```
This mode rebuilds resource data from the extracted tree, updates resource offsets, texture descriptors, and the archive size, and preserves the original folder metadata. Unsupported ancillary PNG chunks are removed during packing. Run `png_filter0.py` separately when a changed PNG also needs filter-0 encoding. The extracted tree should use the structure produced by `unpack`.
The archive-aware repacker supports the KZB metadata layouts recognized by the parser. KZBF files can be unpacked, but archive-aware repacking of KZBF is not supported yet.
Resources are kept in their original locations when their updated sizes fit within the available data area. Otherwise the resource area is rebuilt and offsets are updated.

To re-encode a PNG independently, run:
```
python3 png_filter0.py <input.png> [output.png]
```
If `output.png` is omitted, the script writes a sibling named `<input>_filter0.png` and leaves the input untouched.
