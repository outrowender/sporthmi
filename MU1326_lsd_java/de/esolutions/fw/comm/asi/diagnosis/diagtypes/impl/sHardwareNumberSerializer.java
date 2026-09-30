/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sHardwareNumber;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class sHardwareNumberSerializer {
    public static void putOptionalsHardwareNumber(ISerializer iSerializer, sHardwareNumber sHardwareNumber2) throws SerializerException {
        boolean bl = sHardwareNumber2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sHardwareNumber2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sHardwareNumber2.getNumber();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsHardwareNumberVarArray(ISerializer iSerializer, sHardwareNumber[] sHardwareNumberArray) throws SerializerException {
        boolean bl = sHardwareNumberArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sHardwareNumberArray.length);
            for (int i2 = 0; i2 < sHardwareNumberArray.length; ++i2) {
                sHardwareNumberSerializer.putOptionalsHardwareNumber(iSerializer, sHardwareNumberArray[i2]);
            }
        }
    }

    public static sHardwareNumber getOptionalsHardwareNumber(IDeserializer iDeserializer) throws SerializerException {
        sHardwareNumber sHardwareNumber2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sHardwareNumber2 = new sHardwareNumber();
            sHardwareNumber2.msg_id = l = iDeserializer.getUInt32();
            sHardwareNumber2.number = string = iDeserializer.getOptionalString();
        }
        return sHardwareNumber2;
    }

    public static sHardwareNumber[] getOptionalsHardwareNumberVarArray(IDeserializer iDeserializer) throws SerializerException {
        sHardwareNumber[] sHardwareNumberArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sHardwareNumberArray = new sHardwareNumber[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sHardwareNumberArray[i2] = sHardwareNumberSerializer.getOptionalsHardwareNumber(iDeserializer);
            }
        }
        return sHardwareNumberArray;
    }
}

