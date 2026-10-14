#!/bin/bash
input=$1
output_dir=${input##*/}
output_dir=${output_dir%.*}
mkdir -p "$output_dir"

part=1
prev=0
for offset in $( LC_ALL=C grep -abo --binary-files=text $'\x89PNG' "$input" )
do
offset=${offset%%:*}
if [ ${offset} = 0 ]; then continue; fi
extension=png
if [ "$prev" -eq 0 ]; then extension=bin; fi
output_file="$output_dir/part_${part}.${extension}"
echo dd from ${prev} to ${offset} into "$output_file"
dd if="$input" of="$output_file" bs=1 skip=${prev} count=$((${offset}-${prev})) status=noxfer
prev=${offset}
let part+=1
done
output_file="$output_dir/part_${part}.png"
echo dd from ${prev} to end into "$output_file"
dd if="$input" of="$output_file" bs=1 skip=${prev} status=noxfer
