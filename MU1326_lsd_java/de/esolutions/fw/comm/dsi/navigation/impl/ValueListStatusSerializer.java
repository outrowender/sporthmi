/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.navigation.ValueListStatus;

public class ValueListStatusSerializer {
    public static void putOptionalValueListStatus(ISerializer iSerializer, ValueListStatus valueListStatus) throws SerializerException {
        boolean bl = valueListStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = valueListStatus.getStatus();
            iSerializer.putInt32(n);
            int n2 = valueListStatus.getNumberOfAvailableItems();
            iSerializer.putInt32(n2);
            int n3 = valueListStatus.getDistance();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalValueListStatusVarArray(ISerializer iSerializer, ValueListStatus[] valueListStatusArray) throws SerializerException {
        boolean bl = valueListStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(valueListStatusArray.length);
            for (int i2 = 0; i2 < valueListStatusArray.length; ++i2) {
                ValueListStatusSerializer.putOptionalValueListStatus(iSerializer, valueListStatusArray[i2]);
            }
        }
    }

    public static ValueListStatus getOptionalValueListStatus(IDeserializer iDeserializer) throws SerializerException {
        ValueListStatus valueListStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            valueListStatus = new ValueListStatus();
            valueListStatus.status = n3 = iDeserializer.getInt32();
            valueListStatus.numberOfAvailableItems = n2 = iDeserializer.getInt32();
            valueListStatus.distance = n = iDeserializer.getInt32();
        }
        return valueListStatus;
    }

    public static ValueListStatus[] getOptionalValueListStatusVarArray(IDeserializer iDeserializer) throws SerializerException {
        ValueListStatus[] valueListStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            valueListStatusArray = new ValueListStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                valueListStatusArray[i2] = ValueListStatusSerializer.getOptionalValueListStatus(iDeserializer);
            }
        }
        return valueListStatusArray;
    }
}

