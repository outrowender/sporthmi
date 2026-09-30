/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import java.io.IOException;

public interface JxeOutputStream {
    public byte read8(int var1) throws IOException;

    public short read16(int var1) throws IOException;

    public int read32(int var1) throws IOException;

    public long read64(int var1) throws IOException;

    public void write(byte[] var1, int var2, int var3) throws IOException;
}

