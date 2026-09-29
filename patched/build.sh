#!/bin/bash
set -e
. ../process.sh

# Order matters! Dependency/library files first.
FILES="\
de/audi/app/car/evo/mer/CarEvoMenuEntryStructure.java \
"

for j in $FILES; do
echo "Compiling $j"
${JAVA_HOME}/bin/javac -source 1.2 -target 1.2 -cp ".:${JAR}" $j
done

CLASSES=$(echo $FILES | sed -r 's:\.java:.class:g')

${JAVA_HOME}/bin/jar cvf SportHMI.jar $CLASSES
