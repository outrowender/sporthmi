/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public interface ISocket {
    public InputStream getInputStream() throws IOException;

    public OutputStream getOutputStream() throws IOException;

    public void close() throws IOException;

    public Socket getSocket();

    public boolean isPlainSocket();
}

