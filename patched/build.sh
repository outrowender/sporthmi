#!/bin/bash
set -e
. ../process.sh

# Order matters! Dependency/library files first.
FILES="\
de/esolutions/hmi/widgets/audi/evo/widgets/sport/OilTemperatureGaugeController.java \
de/audi/tghu/car/hmi/evohighscale/CarScreenBag1.java \
de/audi/tghu/car/sm/CarSMMInitStates.java \
de/audi/tghu/car/sm/CarSMMInitTransitions.java \
de/audi/app/car/evo/sport/SportComponentEvo.java \
de/audi/app/car/evo/sport/SportKombiComponentEvo.java
"

rm -f SportHMI.jar

for j in $FILES; do
echo "Compiling $j"
${JAVA_HOME}/bin/javac -source 1.2 -target 1.2 -cp ".:${JAR}" $j
done

CLASSES=$(echo $FILES | sed -r 's:\.java:.class:g')

${JAVA_HOME}/bin/jar cvf SportHMI.jar $CLASSES

printf 'SportHMI.jar size: %s bytes\n' "$(wc -c < SportHMI.jar)"