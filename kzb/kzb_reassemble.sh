#!/bin/bash

set -euo pipefail

if [ "$#" -lt 1 ] || [ "$#" -gt 2 ]; then
    echo "Usage: $0 OUTPUT_DIRECTORY [OUTPUT_FILE]" >&2
    exit 1
fi

input_dir=${1%/}
if [ ! -d "$input_dir" ]; then
    echo "Error: directory not found: $input_dir" >&2
    exit 1
fi

if [ "$#" -eq 2 ]; then
    output_file=$2
else
    output_file="${input_dir}.kzb"
fi

part=1
found=0

: > "$output_file"

while :; do
    part_file=""

    if [ -f "$input_dir/part_${part}.bin" ]; then
        part_file="$input_dir/part_${part}.bin"
    elif [ -f "$input_dir/part_${part}.png" ]; then
        part_file="$input_dir/part_${part}.png"
    else
        break
    fi

    echo "Appending $part_file"
    cat "$part_file" >> "$output_file"
    found=1
    part=$((part + 1))
done

if [ "$found" -eq 0 ]; then
    rm -f "$output_file"
    echo "Error: no part files found in $input_dir" >&2
    exit 1
fi

echo "Reassembled: $output_file"
