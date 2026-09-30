/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.OSMemoryAccessor;
import java.io.IOException;
import java.io.InputStream;

class MemInputStream
extends InputStream
implements OSMemoryAccessor {
    private long pointer;
    private int size;
    private int offset;
    private int mark;
    private Jxe jxe;

    MemInputStream(long l, int n, Jxe jxe) {
        this.pointer = l;
        this.size = n;
        this.offset = 0;
        this.jxe = jxe;
    }

    public int available() throws IOException {
        if (this.pointer == 0L) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.offset >= this.size) {
            return 0;
        }
        return this.size - this.offset;
    }

    public void close() throws IOException {
        this.pointer = 0L;
    }

    public long getPointer() {
        return this.pointer;
    }

    public int getSize() {
        return this.size;
    }

    public synchronized void mark(int n) {
        this.mark = this.offset;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        if (this.pointer == 0L) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.offset >= this.size) {
            return -1;
        }
        if (this.jxe != null && this.jxe.getJxePointer() == 0L) {
            throw new IOException(Msg.getString("K0059"));
        }
        return this.nativeGetByte(this.pointer, this.offset++) & 0xFF;
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        if (this.pointer == 0L) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (n >= 0 && n2 >= 0 && n2 <= byArray.length - n) {
            if (this.offset >= this.size) {
                return -1;
            }
            int n3 = MemInputStream.min(n2, this.size - this.offset);
            if (this.jxe != null && this.jxe.getJxePointer() == 0L) {
                throw new IOException(Msg.getString("K0059"));
            }
            this.nativeMemcpy(byArray, n, this.pointer + (long)this.offset, n3);
            this.offset += n3;
            return n3;
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public synchronized void reset() {
        this.offset = this.mark;
    }

    public long skip(long l) throws IOException {
        if (l <= 0L) {
            return 0L;
        }
        if (this.pointer == 0L) {
            throw new IOException(Msg.getString("K0059"));
        }
        int n = MemInputStream.min((int)l, this.size - this.offset);
        this.offset += n;
        return n;
    }

    static int min(int n, int n2) {
        return n < n2 ? n : n2;
    }

    private native byte nativeGetByte(long var1, int var3);

    private native void nativeMemcpy(byte[] var1, int var2, long var3, int var5);
}

