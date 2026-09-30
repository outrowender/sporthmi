/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FloatBaseTypeSerializer {
    public static void putOptionalFloatBaseType(ISerializer iSerializer, FloatBaseType floatBaseType) throws SerializerException {
        boolean bl = floatBaseType == null;
        iSerializer.putBool(bl);
        if (!bl) {
            float f2 = floatBaseType.getValue();
            iSerializer.putFloat(f2);
            int n = floatBaseType.getUnit();
            iSerializer.putInt32(n);
            int n2 = floatBaseType.getStatus();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalFloatBaseTypeVarArray(ISerializer iSerializer, FloatBaseType[] floatBaseTypeArray) throws SerializerException {
        boolean bl = floatBaseTypeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(floatBaseTypeArray.length);
            for (int i2 = 0; i2 < floatBaseTypeArray.length; ++i2) {
                FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, floatBaseTypeArray[i2]);
            }
        }
    }

    public static FloatBaseType getOptionalFloatBaseType(IDeserializer iDeserializer) throws SerializerException {
        FloatBaseType floatBaseType = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            float f2;
            floatBaseType = new FloatBaseType();
            floatBaseType.value = f2 = iDeserializer.getFloat();
            floatBaseType.unit = n2 = iDeserializer.getInt32();
            floatBaseType.status = n = iDeserializer.getInt32();
        }
        return floatBaseType;
    }

    public static FloatBaseType[] getOptionalFloatBaseTypeVarArray(IDeserializer iDeserializer) throws SerializerException {
        FloatBaseType[] floatBaseTypeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            floatBaseTypeArray = new FloatBaseType[n];
            for (int i2 = 0; i2 < n; ++i2) {
                floatBaseTypeArray[i2] = FloatBaseTypeSerializer.getOptionalFloatBaseType(iDeserializer);
            }
        }
        return floatBaseTypeArray;
    }
}

