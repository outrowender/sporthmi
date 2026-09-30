/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.komoview.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.komoview.TrafficInfo;

public class TrafficInfoSerializer {
    public static void putOptionalTrafficInfo(ISerializer iSerializer, TrafficInfo trafficInfo) throws SerializerException {
        boolean bl = trafficInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = trafficInfo.getTrafficOffset();
            iSerializer.putOptionalString(string);
            String string2 = trafficInfo.getTrafficOffsetAffix();
            iSerializer.putOptionalString(string2);
            boolean bl2 = trafficInfo.isAffixPlacementBefore();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalTrafficInfoVarArray(ISerializer iSerializer, TrafficInfo[] trafficInfoArray) throws SerializerException {
        boolean bl = trafficInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(trafficInfoArray.length);
            for (int i2 = 0; i2 < trafficInfoArray.length; ++i2) {
                TrafficInfoSerializer.putOptionalTrafficInfo(iSerializer, trafficInfoArray[i2]);
            }
        }
    }

    public static TrafficInfo getOptionalTrafficInfo(IDeserializer iDeserializer) throws SerializerException {
        TrafficInfo trafficInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            String string;
            String string2;
            trafficInfo = new TrafficInfo();
            trafficInfo.trafficOffset = string2 = iDeserializer.getOptionalString();
            trafficInfo.trafficOffsetAffix = string = iDeserializer.getOptionalString();
            trafficInfo.affixPlacementBefore = bl2 = iDeserializer.getBool();
        }
        return trafficInfo;
    }

    public static TrafficInfo[] getOptionalTrafficInfoVarArray(IDeserializer iDeserializer) throws SerializerException {
        TrafficInfo[] trafficInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            trafficInfoArray = new TrafficInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                trafficInfoArray[i2] = TrafficInfoSerializer.getOptionalTrafficInfo(iDeserializer);
            }
        }
        return trafficInfoArray;
    }
}

