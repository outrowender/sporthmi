/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;
import java.io.InputStream;

public class FilterInputStream
extends InputStream {
    protected InputStream in;

    protected FilterInputStream(InputStream inputStream) {
        this.in = inputStream;
    }

    public int available() throws IOException {
        return this.in.available();
    }

    public void close() throws IOException {
        this.in.close();
    }

    public synchronized void mark(int n) {
        this.in.mark(n);
    }

    public boolean markSupported() {
        return this.in.markSupported();
    }

    public int read() throws IOException {
        return this.in.read();
    }

    public int read(byte[] byArray) throws IOException {
        return this.read(byArray, 0, byArray.length);
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        return this.in.read(byArray, n, n2);
    }

    public synchronized void reset() throws IOException {
        this.in.reset();
    }

    public long skip(long l) throws IOException {
        return this.in.skip(l);
    }
}

