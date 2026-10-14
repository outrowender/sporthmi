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
This mode rebuilds resource data from the extracted tree, updates resource offsets, texture descriptors, and the archive size, and preserves the original folder metadata. PNG metadata unsupported by the target decoder is removed during packing; changed PNGs are re-encoded with filter 0, while unchanged PNGs retain their original image data. The extracted tree should use the structure produced by `unpack`.
When every resource fits in its original slot, the archive size and resource offsets remain unchanged. If a resource grows beyond its original slot, later resource offsets are updated.

To re-encode a PNG independently, run:
```
python3 png_filter0.py <input.png> [output.png]
```
If `output.png` is omitted, the script writes a sibling named `<input>_filter0.png` and leaves the input untouched.
