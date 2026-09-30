/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swap.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.swap.SFscStatus;

public class SFscStatusSerializer {
    public static void putOptionalSFscStatus(ISerializer iSerializer, SFscStatus sFscStatus) throws SerializerException {
        boolean bl = sFscStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = sFscStatus.getSwid();
            iSerializer.putInt32(n);
            int n2 = sFscStatus.getState();
            iSerializer.putInt32(n2);
            int n3 = sFscStatus.getIndex();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalSFscStatusVarArray(ISerializer iSerializer, SFscStatus[] sFscStatusArray) throws SerializerException {
        boolean bl = sFscStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sFscStatusArray.length);
            for (int i2 = 0; i2 < sFscStatusArray.length; ++i2) {
                SFscStatusSerializer.putOptionalSFscStatus(iSerializer, sFscStatusArray[i2]);
            }
        }
    }

    public static SFscStatus getOptionalSFscStatus(IDeserializer iDeserializer) throws SerializerException {
        SFscStatus sFscStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            sFscStatus = new SFscStatus();
            sFscStatus.swid = n3 = iDeserializer.getInt32();
            sFscStatus.state = n2 = iDeserializer.getInt32();
            sFscStatus.index = n = iDeserializer.getInt32();
        }
        return sFscStatus;
    }

    public static SFscStatus[] getOptionalSFscStatusVarArray(IDeserializer iDeserializer) throws SerializerException {
        SFscStatus[] sFscStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sFscStatusArray = new SFscStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sFscStatusArray[i2] = SFscStatusSerializer.getOptionalSFscStatus(iDeserializer);
            }
        }
        return sFscStatusArray;
    }
}

