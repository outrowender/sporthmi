/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.util;

import de.audi.app.messaging.core.util.IFormatter;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public final class Arrays {
    public static String toMultiLineString(Object[] objectArray) {
        return Arrays.toMultiLineString(objectArray, IFormatter.SIMPLE_FORMATTER);
    }

    public static String toMultiLineString(Object[] objectArray, IFormatter iFormatter) {
        return Arrays.toString(objectArray, "\n\t", ",", "\n", iFormatter);
    }

    public static String toString(Object[] objectArray) {
        return Arrays.toString(objectArray, IFormatter.SIMPLE_FORMATTER);
    }

    public static String toString(Object[] objectArray, IFormatter iFormatter) {
        return Arrays.toString(objectArray, "", ", ", "", iFormatter);
    }

    private static String toString(Object[] objectArray, String string, String string2, String string3, IFormatter iFormatter) {
        String string4 = String.valueOf((Object)null);
        if (objectArray != null) {
            Buffer buffer = new Buffer();
            buffer.append('[');
            if (objectArray.length > 0) {
                for (int i2 = 0; i2 < objectArray.length; ++i2) {
                    buffer.append(string);
                    buffer.append('[');
                    buffer.append(i2);
                    buffer.append("] = ");
                    buffer.append(iFormatter.format(objectArray[i2]));
                    if (i2 < objectArray.length - 1) {
                        buffer.append(string2);
                        continue;
                    }
                    buffer.append(string3);
                }
            }
            buffer.append(']');
            string4 = buffer.toString();
        }
        return string4;
    }

    public static String toString(int[] nArray) {
        return Arrays.toString(Arrays.toObjectArray(nArray));
    }

    public static Object[] toObjectArray(int[] nArray) {
        Object[] objectArray = null;
        if (nArray != null) {
            objectArray = new Object[nArray.length];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                objectArray[i2] = Util.createInteger(nArray[i2]);
            }
        }
        return objectArray;
    }

    public static String getLengthAsString(Object[] objectArray) {
        return objectArray == null ? String.valueOf(objectArray) : String.valueOf(objectArray.length);
    }
}

