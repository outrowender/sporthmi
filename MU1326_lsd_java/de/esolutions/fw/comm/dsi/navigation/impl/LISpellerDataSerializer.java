/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.navigation.LISpellerData;

public class LISpellerDataSerializer {
    public static void putOptionalLISpellerData(ISerializer iSerializer, LISpellerData lISpellerData) throws SerializerException {
        boolean bl = lISpellerData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short[] sArray = lISpellerData.getSpellerStateData();
            iSerializer.putOptionalInt16VarArray(sArray);
        }
    }

    public static void putOptionalLISpellerDataVarArray(ISerializer iSerializer, LISpellerData[] lISpellerDataArray) throws SerializerException {
        boolean bl = lISpellerDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lISpellerDataArray.length);
            for (int i2 = 0; i2 < lISpellerDataArray.length; ++i2) {
                LISpellerDataSerializer.putOptionalLISpellerData(iSerializer, lISpellerDataArray[i2]);
            }
        }
    }

    public static LISpellerData getOptionalLISpellerData(IDeserializer iDeserializer) throws SerializerException {
        LISpellerData lISpellerData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            lISpellerData = new LISpellerData();
            short[] sArray = iDeserializer.getOptionalInt16VarArray();
            lISpellerData.spellerStateData = sArray;
        }
        return lISpellerData;
    }

    public static LISpellerData[] getOptionalLISpellerDataVarArray(IDeserializer iDeserializer) throws SerializerException {
        LISpellerData[] lISpellerDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lISpellerDataArray = new LISpellerData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lISpellerDataArray[i2] = LISpellerDataSerializer.getOptionalLISpellerData(iDeserializer);
            }
        }
        return lISpellerDataArray;
    }
}

