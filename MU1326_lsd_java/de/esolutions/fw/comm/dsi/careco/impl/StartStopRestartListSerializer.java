/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.careco.StartStopRestartList;

public class StartStopRestartListSerializer {
    public static void putOptionalStartStopRestartList(ISerializer iSerializer, StartStopRestartList startStopRestartList) throws SerializerException {
        boolean bl = startStopRestartList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            byte by = startStopRestartList.getListPosition();
            iSerializer.putInt8(by);
            int n = startStopRestartList.getReason();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalStartStopRestartListVarArray(ISerializer iSerializer, StartStopRestartList[] startStopRestartListArray) throws SerializerException {
        boolean bl = startStopRestartListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(startStopRestartListArray.length);
            for (int i2 = 0; i2 < startStopRestartListArray.length; ++i2) {
                StartStopRestartListSerializer.putOptionalStartStopRestartList(iSerializer, startStopRestartListArray[i2]);
            }
        }
    }

    public static StartStopRestartList getOptionalStartStopRestartList(IDeserializer iDeserializer) throws SerializerException {
        StartStopRestartList startStopRestartList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            byte by;
            startStopRestartList = new StartStopRestartList();
            startStopRestartList.listPosition = by = iDeserializer.getInt8();
            startStopRestartList.reason = n = iDeserializer.getInt32();
        }
        return startStopRestartList;
    }

    public static StartStopRestartList[] getOptionalStartStopRestartListVarArray(IDeserializer iDeserializer) throws SerializerException {
        StartStopRestartList[] startStopRestartListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            startStopRestartListArray = new StartStopRestartList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                startStopRestartListArray[i2] = StartStopRestartListSerializer.getOptionalStartStopRestartList(iDeserializer);
            }
        }
        return startStopRestartListArray;
    }
}

