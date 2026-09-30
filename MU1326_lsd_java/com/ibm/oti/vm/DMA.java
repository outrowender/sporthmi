/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.vm.VM;

public class DMA {
    public DMA() {
        if (VM.callerClassLoader() != null) {
            throw new SecurityException();
        }
    }

    public native byte readByte(long var1);

    public native void writeByte(long var1, byte var3);

    public native short readShort(long var1);

    public native void writeShort(long var1, short var3);

    public native int readInt(long var1);

    public native void writeInt(long var1, int var3);

    public native long readLong(long var1);

    public native void writeLong(long var1, long var3);
}

