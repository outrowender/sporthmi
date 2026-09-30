/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.ISocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketWrapper
implements ISocket {
    private final Socket socket;

    public SocketWrapper(Socket socket) {
        this.socket = socket;
    }

    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }

    public OutputStream getOutputStream() throws IOException {
        return this.socket.getOutputStream();
    }

    public void close() throws IOException {
        this.socket.close();
    }

    public Socket getSocket() {
        return this.socket;
    }

    public boolean isPlainSocket() {
        return true;
    }
}

