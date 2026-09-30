/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.DateTime;

public class DateTimeSerializer {
    public static void putOptionalDateTime(ISerializer iSerializer, DateTime dateTime) throws SerializerException {
        boolean bl = dateTime == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = dateTime.getTime();
            iSerializer.putInt64(l);
        }
    }

    public static void putOptionalDateTimeVarArray(ISerializer iSerializer, DateTime[] dateTimeArray) throws SerializerException {
        boolean bl = dateTimeArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dateTimeArray.length);
            for (int i2 = 0; i2 < dateTimeArray.length; ++i2) {
                DateTimeSerializer.putOptionalDateTime(iSerializer, dateTimeArray[i2]);
            }
        }
    }

    public static DateTime getOptionalDateTime(IDeserializer iDeserializer) throws SerializerException {
        DateTime dateTime = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            dateTime = new DateTime();
            dateTime.time = l = iDeserializer.getInt64();
        }
        return dateTime;
    }

    public static DateTime[] getOptionalDateTimeVarArray(IDeserializer iDeserializer) throws SerializerException {
        DateTime[] dateTimeArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dateTimeArray = new DateTime[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dateTimeArray[i2] = DateTimeSerializer.getOptionalDateTime(iDeserializer);
            }
        }
        return dateTimeArray;
    }
}

