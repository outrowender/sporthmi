/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sNumberHandsetsHUCs;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class sNumberHandsetsHUCsSerializer {
    public static void putOptionalsNumberHandsetsHUCs(ISerializer iSerializer, sNumberHandsetsHUCs sNumberHandsetsHUCs2) throws SerializerException {
        boolean bl = sNumberHandsetsHUCs2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sNumberHandsetsHUCs2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sNumberHandsetsHUCs2.getNumberHandsets();
            iSerializer.putUInt8(s);
            short s2 = sNumberHandsetsHUCs2.getNumberHUCs();
            iSerializer.putUInt8(s2);
        }
    }

    public static void putOptionalsNumberHandsetsHUCsVarArray(ISerializer iSerializer, sNumberHandsetsHUCs[] sNumberHandsetsHUCsArray) throws SerializerException {
        boolean bl = sNumberHandsetsHUCsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sNumberHandsetsHUCsArray.length);
            for (int i2 = 0; i2 < sNumberHandsetsHUCsArray.length; ++i2) {
                sNumberHandsetsHUCsSerializer.putOptionalsNumberHandsetsHUCs(iSerializer, sNumberHandsetsHUCsArray[i2]);
            }
        }
    }

    public static sNumberHandsetsHUCs getOptionalsNumberHandsetsHUCs(IDeserializer iDeserializer) throws SerializerException {
        sNumberHandsetsHUCs sNumberHandsetsHUCs2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            long l;
            sNumberHandsetsHUCs2 = new sNumberHandsetsHUCs();
            sNumberHandsetsHUCs2.msg_id = l = iDeserializer.getUInt32();
            sNumberHandsetsHUCs2.numberHandsets = s2 = iDeserializer.getUInt8();
            sNumberHandsetsHUCs2.numberHUCs = s = iDeserializer.getUInt8();
        }
        return sNumberHandsetsHUCs2;
    }

    public static sNumberHandsetsHUCs[] getOptionalsNumberHandsetsHUCsVarArray(IDeserializer iDeserializer) throws SerializerException {
        sNumberHandsetsHUCs[] sNumberHandsetsHUCsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sNumberHandsetsHUCsArray = new sNumberHandsetsHUCs[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sNumberHandsetsHUCsArray[i2] = sNumberHandsetsHUCsSerializer.getOptionalsNumberHandsetsHUCs(iDeserializer);
            }
        }
        return sNumberHandsetsHUCsArray;
    }
}

