#!/bin/sh
set -eu

cd "$(dirname "$0")"
compiler=${CXX:-c++}
"$compiler" -std=c++17 main.cpp -o kzbTools -lz