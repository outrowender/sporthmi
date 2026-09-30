/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.ftp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

class FtpURLInputStream
extends InputStream {
    InputStream is;
    Socket controlSocket;

    public FtpURLInputStream(InputStream inputStream, Socket socket) {
        this.is = inputStream;
        this.controlSocket = socket;
    }

    public int read() throws IOException {
        return this.is.read();
    }

    public int read(byte[] byArray, int n, int n2) throws IOException {
        return this.is.read(byArray, n, n2);
    }

    public synchronized void reset() throws IOException {
        this.is.reset();
    }

    public synchronized void mark(int n) {
        this.is.mark(n);
    }

    public boolean markSupported() {
        return this.is.markSupported();
    }

    public void close() {
        try {
            this.is.close();
        }
        catch (Exception exception) {}
        try {
            this.controlSocket.close();
        }
        catch (Exception exception) {}
    }

    public int available() throws IOException {
        return this.is.available();
    }

    public long skip(long l) throws IOException {
        return this.is.skip(l);
    }
}

