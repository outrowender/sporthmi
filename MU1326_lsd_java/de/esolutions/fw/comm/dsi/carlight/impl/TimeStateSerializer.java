/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carlight.TimeState;

public class TimeStateSerializer {
    public static void putOptionalTimeState(ISerializer iSerializer, TimeState timeState) throws SerializerException {
        boolean bl = timeState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = timeState.getTime();
            iSerializer.putInt32(n);
            boolean bl2 = timeState.isState();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalTimeStateVarArray(ISerializer iSerializer, TimeState[] timeStateArray) throws SerializerException {
        boolean bl = timeStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(timeStateArray.length);
            for (int i2 = 0; i2 < timeStateArray.length; ++i2) {
                TimeStateSerializer.putOptionalTimeState(iSerializer, timeStateArray[i2]);
            }
        }
    }

    public static TimeState getOptionalTimeState(IDeserializer iDeserializer) throws SerializerException {
        TimeState timeState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            timeState = new TimeState();
            timeState.time = n = iDeserializer.getInt32();
            timeState.state = bl2 = iDeserializer.getBool();
        }
        return timeState;
    }

    public static TimeState[] getOptionalTimeStateVarArray(IDeserializer iDeserializer) throws SerializerException {
        TimeState[] timeStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            timeStateArray = new TimeState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                timeStateArray[i2] = TimeStateSerializer.getOptionalTimeState(iDeserializer);
            }
        }
        return timeStateArray;
    }
}

