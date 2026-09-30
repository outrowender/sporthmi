/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;

public abstract class Reader {
    protected Object lock;

    protected Reader() {
        this.lock = this;
    }

    protected Reader(Object object) {
        if (object == null) {
            throw new NullPointerException();
        }
        this.lock = object;
    }

    public abstract void close() throws IOException;

    public void mark(int n) throws IOException {
        throw new IOException();
    }

    public boolean markSupported() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            char[] cArray = new char[1];
            if (this.read(cArray, 0, 1) != -1) {
                return cArray[0];
            }
            return -1;
        }
    }

    public int read(char[] cArray) throws IOException {
        return this.read(cArray, 0, cArray.length);
    }

    public abstract int read(char[] var1, int var2, int var3) throws IOException;

    public boolean ready() throws IOException {
        return false;
    }

    public void reset() throws IOException {
        throw new IOException();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long skip(long l) throws IOException {
        if (l >= 0L) {
            Object object = this.lock;
            synchronized (object) {
                long l2 = 0L;
                int n = l < 512L ? (int)l : 512;
                char[] cArray = new char[n];
                while (l2 < l) {
                    int n2 = this.read(cArray, 0, n);
                    if (n2 == -1) {
                        return l2;
                    }
                    l2 += (long)n2;
                    if (n2 < n) {
                        return l2;
                    }
                    if (l - l2 >= (long)n) continue;
                    n = (int)(l - l2);
                }
                return l2;
            }
        }
        throw new IllegalArgumentException();
    }
}

