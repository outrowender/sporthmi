/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.lang;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;

class ProcessInputStream
extends InputStream {
    private long handle;
    private FileDescriptor fd = new FileDescriptor();

    static {
        ProcessInputStream.oneTimeInitialization();
    }

    private static native void oneTimeInitialization();

    protected ProcessInputStream(long l) {
        this.setFDImpl(this.fd, l);
        this.handle = l;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int available() throws IOException {
        ProcessInputStream processInputStream = this;
        synchronized (processInputStream) {
            block4: {
                if (this.handle != -1L) break block4;
                return -1;
            }
            return this.availableImpl();
        }
    }

    private native int availableImpl();

    protected void finalize() throws Throwable {
        this.close();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        ProcessInputStream processInputStream = this;
        synchronized (processInputStream) {
            if (this.handle == -1L) {
                return;
            }
            this.closeImpl();
            this.handle = -1L;
        }
    }

    private native void closeImpl();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read() throws IOException {
        byte[] byArray = new byte[1];
        ProcessInputStream processInputStream = this;
        synchronized (processInputStream) {
            block4: {
                if (this.readImpl(byArray, 0, 1, this.handle) != -1) break block4;
                return -1;
            }
        }
        return byArray[0];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read(byte[] byArray) throws IOException {
        ProcessInputStream processInputStream = this;
        synchronized (processInputStream) {
            return this.readImpl(byArray, 0, byArray.length, this.handle);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read(byte[] byArray, int n, int n2) throws IOException {
        ProcessInputStream processInputStream = this;
        synchronized (processInputStream) {
            block5: {
                if (this.handle != -1L) break block5;
                return -1;
            }
            if (n2 < 0 || n2 > byArray.length || n < 0 || n > byArray.length || n2 + n > byArray.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            return this.readImpl(byArray, n, n2, this.handle);
        }
    }

    private native int readImpl(byte[] var1, int var2, int var3, long var4);

    private native void setFDImpl(FileDescriptor var1, long var2);
}

