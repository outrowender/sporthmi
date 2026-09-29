/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.esolutions.fw.util.commons.Buffer;

public class Arrays2 {
    public static String toString(Object[] objectArray) {
        if (objectArray == null) {
            return "null";
        }
        if (objectArray.length == 0) {
            return "[]";
        }
        String string = Arrays2.toString(objectArray[0]);
        Buffer buffer = new Buffer((string.length() + 2 + 10) * objectArray.length + 10).append("[").append(string).append(objectArray.length > 1 ? ", " : "]");
        int n = objectArray.length - 1;
        for (int i2 = 1; i2 < objectArray.length; ++i2) {
            buffer.append(Arrays2.toString(objectArray[i2])).append(i2 < n ? ", " : "]");
        }
        return buffer.toString();
    }

    public static String toString(int[] nArray) {
        if (nArray == null) {
            return "null";
        }
        if (nArray.length == 0) {
            return "[]";
        }
        String string = Integer.toString(nArray[0]);
        Buffer buffer = new Buffer((string.length() + 2 + 10) * nArray.length + 10).append("[").append(string).append(nArray.length > 1 ? ", " : "]");
        int n = nArray.length - 1;
        for (int i2 = 1; i2 < nArray.length; ++i2) {
            buffer.append(nArray[i2]).append(i2 < n ? ", " : "]");
        }
        return buffer.toString();
    }

    private static String toString(Object object) {
        return object != null ? object.toString() : "null";
    }
}

