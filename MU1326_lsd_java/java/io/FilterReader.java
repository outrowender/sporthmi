/*
 * Decompiled with CFR 0.152.
 */
package java.io;

import java.io.IOException;
import java.io.Reader;

public abstract class FilterReader
extends Reader {
    protected Reader in;

    protected FilterReader(Reader reader) {
        super(reader);
        this.in = reader;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void close() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            this.in.close();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public synchronized void mark(int n) throws IOException {
        Object object = this.lock;
        synchronized (object) {
            this.in.mark(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean markSupported() {
        Object object = this.lock;
        synchronized (object) {
            return this.in.markSupported();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            return this.in.read();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int read(char[] cArray, int n, int n2) throws IOException {
        Object object = this.lock;
        synchronized (object) {
            return this.in.read(cArray, n, n2);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean ready() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            return this.in.ready();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reset() throws IOException {
        Object object = this.lock;
        synchronized (object) {
            this.in.reset();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public long skip(long l) throws IOException {
        Object object = this.lock;
        synchronized (object) {
            return this.in.skip(l);
        }
    }
}

