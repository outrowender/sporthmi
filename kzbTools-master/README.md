# `kzbTools`   

Forked from `BigUncleMax's` https://github.com/bigunclemax/kzbTools and upgraded to allow for repacking of `.kzb` files.

## Build
### Linux: 
```
g++ -std=c++17 kzbTools.cpp -o kzbTools
```

### Windows (MSVC): 
```
cl /std:c++17 kzbTools.cpp Ws2_32.lib
```

## How to use
Unpack:
```
./kzbTools <input.kzb>
```

Pack:
```
./kzbTools pack <extracted_dir> <output.kzb>
``` 
The directory should look like what your extractor produced (subdirs named Folder_<name>, files inside are elements).
