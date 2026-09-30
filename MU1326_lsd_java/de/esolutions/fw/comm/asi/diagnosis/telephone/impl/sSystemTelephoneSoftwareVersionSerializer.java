/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.telephone.impl;

import de.esolutions.fw.comm.asi.diagnosis.telephone.sSystemTelephoneSoftwareVersion;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class sSystemTelephoneSoftwareVersionSerializer {
    public static void putOptionalsSystemTelephoneSoftwareVersion(ISerializer iSerializer, sSystemTelephoneSoftwareVersion sSystemTelephoneSoftwareVersion2) throws SerializerException {
        boolean bl = sSystemTelephoneSoftwareVersion2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sSystemTelephoneSoftwareVersion2.getMsg_id();
            iSerializer.putUInt32(l);
            String string = sSystemTelephoneSoftwareVersion2.getVersion();
            iSerializer.putOptionalString(string);
        }
    }

    public static void putOptionalsSystemTelephoneSoftwareVersionVarArray(ISerializer iSerializer, sSystemTelephoneSoftwareVersion[] sSystemTelephoneSoftwareVersionArray) throws SerializerException {
        boolean bl = sSystemTelephoneSoftwareVersionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sSystemTelephoneSoftwareVersionArray.length);
            for (int i2 = 0; i2 < sSystemTelephoneSoftwareVersionArray.length; ++i2) {
                sSystemTelephoneSoftwareVersionSerializer.putOptionalsSystemTelephoneSoftwareVersion(iSerializer, sSystemTelephoneSoftwareVersionArray[i2]);
            }
        }
    }

    public static sSystemTelephoneSoftwareVersion getOptionalsSystemTelephoneSoftwareVersion(IDeserializer iDeserializer) throws SerializerException {
        sSystemTelephoneSoftwareVersion sSystemTelephoneSoftwareVersion2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            long l;
            sSystemTelephoneSoftwareVersion2 = new sSystemTelephoneSoftwareVersion();
            sSystemTelephoneSoftwareVersion2.msg_id = l = iDeserializer.getUInt32();
            sSystemTelephoneSoftwareVersion2.version = string = iDeserializer.getOptionalString();
        }
        return sSystemTelephoneSoftwareVersion2;
    }

    public static sSystemTelephoneSoftwareVersion[] getOptionalsSystemTelephoneSoftwareVersionVarArray(IDeserializer iDeserializer) throws SerializerException {
        sSystemTelephoneSoftwareVersion[] sSystemTelephoneSoftwareVersionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sSystemTelephoneSoftwareVersionArray = new sSystemTelephoneSoftwareVersion[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sSystemTelephoneSoftwareVersionArray[i2] = sSystemTelephoneSoftwareVersionSerializer.getOptionalsSystemTelephoneSoftwareVersion(iDeserializer);
            }
        }
        return sSystemTelephoneSoftwareVersionArray;
    }
}

