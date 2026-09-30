/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.osgi;

import java.io.IOException;
import java.io.OutputStream;

public class MuteableOutputStream
extends OutputStream {
    private OutputStream stream;
    private boolean allowWrites;

    public MuteableOutputStream(OutputStream outputStream) {
        this.stream = outputStream;
        this.allowWrites = true;
    }

    public synchronized void close() throws IOException {
        if (this.stream != null) {
            this.stream.close();
            this.allowWrites = false;
            this.stream = null;
        }
    }

    public synchronized void disableWrites() {
        this.allowWrites = false;
    }

    public synchronized void write(byte[] byArray) throws IOException {
        if (this.allowWrites && this.stream != null) {
            this.stream.write(byArray);
        }
    }

    public synchronized void write(byte[] byArray, int n, int n2) throws IOException {
        if (this.allowWrites && this.stream != null) {
            this.stream.write(byArray, n, n2);
        }
    }

    public synchronized void write(int n) throws IOException {
        if (this.allowWrites && this.stream != null) {
            this.stream.write(n);
        }
    }
}

