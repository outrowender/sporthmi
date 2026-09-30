/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SCDataSerializer {
    public static void putOptionalSCData(ISerializer iSerializer, SCData sCData) throws SerializerException {
        boolean bl = sCData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sCData.getUid();
            iSerializer.putInt64(l);
            byte[] byArray = sCData.getData();
            iSerializer.putOptionalInt8VarArray(byArray);
        }
    }

    public static void putOptionalSCDataVarArray(ISerializer iSerializer, SCData[] sCDataArray) throws SerializerException {
        boolean bl = sCDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sCDataArray.length);
            for (int i2 = 0; i2 < sCDataArray.length; ++i2) {
                SCDataSerializer.putOptionalSCData(iSerializer, sCDataArray[i2]);
            }
        }
    }

    public static SCData getOptionalSCData(IDeserializer iDeserializer) throws SerializerException {
        SCData sCData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            sCData = new SCData();
            sCData.uid = l = iDeserializer.getInt64();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            sCData.data = byArray;
        }
        return sCData;
    }

    public static SCData[] getOptionalSCDataVarArray(IDeserializer iDeserializer) throws SerializerException {
        SCData[] sCDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sCDataArray = new SCData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sCDataArray[i2] = SCDataSerializer.getOptionalSCData(iDeserializer);
            }
        }
        return sCDataArray;
    }
}

