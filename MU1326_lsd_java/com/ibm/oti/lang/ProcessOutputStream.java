/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.OutputStream;

class ProcessOutputStream
extends OutputStream {
    private long handle;
    private FileDescriptor fd = new FileDescriptor();

    static {
        ProcessOutputStream.oneTimeInitialization();
    }

    private static native void oneTimeInitialization();

    protected ProcessOutputStream(long l) {
        this.setFDImpl(this.fd, l);
        this.handle = l;
    }

    protected void finalize() throws Throwable {
        this.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            if (this.handle == -1L) {
                return;
            }
            this.closeImpl();
            this.handle = -1L;
        }
    }

    private native void closeImpl();

    private native void setFDImpl(FileDescriptor var1, long var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(byte[] byArray) throws IOException {
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            this.writeImpl(byArray, 0, byArray.length, this.handle);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(byte[] byArray, int n, int n2) throws IOException {
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            if (this.handle == -1L) {
                return;
            }
            this.writeImpl(byArray, n, n2, this.handle);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void write(int n) throws IOException {
        byte[] byArray = new byte[]{(byte)n};
        ProcessOutputStream processOutputStream = this;
        synchronized (processOutputStream) {
            this.writeImpl(byArray, 0, 1, this.handle);
        }
    }

    private native void writeImpl(byte[] var1, int var2, int var3, long var4);
}

