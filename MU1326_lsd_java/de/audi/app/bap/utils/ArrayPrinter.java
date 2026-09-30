/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.utils;

import de.esolutions.fw.util.commons.Buffer;

public final class ArrayPrinter {
    private final Object[] array;

    private ArrayPrinter(Object[] objectArray) {
        this.array = objectArray;
    }

    public static ArrayPrinter forArray(Object[] objectArray) {
        return new ArrayPrinter(objectArray);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ArrayPrinter:\n");
        if (this.array == null) {
            buffer.append("array is null");
        } else {
            if (this.array.length == 0) {
                buffer.append("array is empty");
            }
            for (int i2 = 0; i2 < this.array.length; ++i2) {
                buffer.append(i2 + ": ");
                buffer.append(this.array[i2].toString());
                buffer.append("\n");
            }
        }
        return buffer.toString();
    }
}

