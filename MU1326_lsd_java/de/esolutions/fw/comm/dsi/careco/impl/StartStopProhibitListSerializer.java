/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.careco.StartStopProhibitList;

public class StartStopProhibitListSerializer {
    public static void putOptionalStartStopProhibitList(ISerializer iSerializer, StartStopProhibitList startStopProhibitList) throws SerializerException {
        boolean bl = startStopProhibitList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = startStopProhibitList.getListPosition();
            iSerializer.putInt8(by);
            int n = startStopProhibitList.getReason();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalStartStopProhibitListVarArray(ISerializer iSerializer, StartStopProhibitList[] startStopProhibitListArray) throws SerializerException {
        boolean bl = startStopProhibitListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(startStopProhibitListArray.length);
            for (int i2 = 0; i2 < startStopProhibitListArray.length; ++i2) {
                StartStopProhibitListSerializer.putOptionalStartStopProhibitList(iSerializer, startStopProhibitListArray[i2]);
            }
        }
    }

    public static StartStopProhibitList getOptionalStartStopProhibitList(IDeserializer iDeserializer) throws SerializerException {
        StartStopProhibitList startStopProhibitList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            byte by;
            startStopProhibitList = new StartStopProhibitList();
            startStopProhibitList.listPosition = by = iDeserializer.getInt8();
            startStopProhibitList.reason = n = iDeserializer.getInt32();
        }
        return startStopProhibitList;
    }

    public static StartStopProhibitList[] getOptionalStartStopProhibitListVarArray(IDeserializer iDeserializer) throws SerializerException {
        StartStopProhibitList[] startStopProhibitListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            startStopProhibitListArray = new StartStopProhibitList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                startStopProhibitListArray[i2] = StartStopProhibitListSerializer.getOptionalStartStopProhibitList(iDeserializer);
            }
        }
        return startStopProhibitListArray;
    }
}

