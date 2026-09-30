/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.generalvehiclestates.AirbagData;

public class AirbagDataSerializer {
    public static void putOptionalAirbagData(ISerializer iSerializer, AirbagData airbagData) throws SerializerException {
        boolean bl = airbagData == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = airbagData.getCrashIntensity();
            iSerializer.putInt32(n);
            boolean bl2 = airbagData.isDiagnosis();
            iSerializer.putBool(bl2);
            boolean bl3 = airbagData.isActuatorTest();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalAirbagDataVarArray(ISerializer iSerializer, AirbagData[] airbagDataArray) throws SerializerException {
        boolean bl = airbagDataArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(airbagDataArray.length);
            for (int i2 = 0; i2 < airbagDataArray.length; ++i2) {
                AirbagDataSerializer.putOptionalAirbagData(iSerializer, airbagDataArray[i2]);
            }
        }
    }

    public static AirbagData getOptionalAirbagData(IDeserializer iDeserializer) throws SerializerException {
        AirbagData airbagData = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            int n;
            airbagData = new AirbagData();
            airbagData.crashIntensity = n = iDeserializer.getInt32();
            airbagData.diagnosis = bl3 = iDeserializer.getBool();
            airbagData.actuatorTest = bl2 = iDeserializer.getBool();
        }
        return airbagData;
    }

    public static AirbagData[] getOptionalAirbagDataVarArray(IDeserializer iDeserializer) throws SerializerException {
        AirbagData[] airbagDataArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            airbagDataArray = new AirbagData[n];
            for (int i2 = 0; i2 < n; ++i2) {
                airbagDataArray[i2] = AirbagDataSerializer.getOptionalAirbagData(iDeserializer);
            }
        }
        return airbagDataArray;
    }
}

