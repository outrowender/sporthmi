#!/bin/bash
set -e
. ../process.sh

FILES="\
de/audi/app/car/evo/sport/SportComponentEvo.java \
de/audi/app/car/evo/sport/SportKombiComponentEvo.java \
"

for j in $FILES; do
echo "Compiling $j"
${JAVA_HOME}/bin/javac -sourcepath "" -source 1.2 -target 1.2 -cp ".:${JAR}" $j
done

#python2 ../Krakatau/assemble.py de/vw/mib/asl/internal/mostkombi/streamsink/usecases/ChangeDataRateSequence.j

#javac -source 1.2 -target 1.2 de/vw/mib/log4mib/internal/LoggingThread.java
#jar cvf LoggingPatcher.jar de/vw/mib/log4mib/internal/LoggingThread.class

CLASSES=$(echo $FILES | sed -r 's:\.java:.class:g')
# echo "$CLASSES"

jar cvf SportHMI.jar $CLASSES

#ssh mibw sh -l /root/.profile
#scp LoggingPatcher.jar mibw:/mnt/app/eso/hmi/lsd/jars/
#scp SportHMI.jar mibw:/mnt/app/eso/hmi/lsd/jars/
