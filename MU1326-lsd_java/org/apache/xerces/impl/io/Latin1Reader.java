/*
 * Decompiled with CFR 0.152.
 */
package org.apache.xerces.impl.io;

import java.io.InputStream;
import java.io.Reader;

public class Latin1Reader
extends Reader {
    public static final int DEFAULT_BUFFER_SIZE;
    protected final InputStream fInputStream;
    protected final byte[] fBuffer;

    public Latin1Reader(InputStream inputStream) {
        this(inputStream, 2048);
    }

    public Latin1Reader(InputStream inputStream, int n) {
        this(inputStream, new byte[n]);
    }

    public Latin1Reader(InputStream inputStream, byte[] byArray) {
        this.fInputStream = inputStream;
        this.fBuffer = byArray;
    }

    @Override
    public int read() {
        return this.fInputStream.read();
    }

    @Override
    public int read(char[] cArray, int n, int n2) {
        if (n2 > this.fBuffer.length) {
            n2 = this.fBuffer.length;
        }
        int n3 = this.fInputStream.read(this.fBuffer, 0, n2);
        for (int i2 = 0; i2 < n3; ++i2) {
            cArray[n + i2] = (char)(this.fBuffer[i2] & 0xFF);
        }
        return n3;
    }

    @Override
    public long skip(long l) {
        return this.fInputStream.skip(l);
    }

    @Override
    public boolean ready() {
        return false;
    }

    @Override
    public boolean markSupported() {
        return this.fInputStream.markSupported();
    }

    @Override
    public void mark(int n) {
        this.fInputStream.mark(n);
    }

    @Override
    public void reset() {
        this.fInputStream.reset();
    }

    @Override
    public void close() {
        this.fInputStream.close();
    }
}

