/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.IServerSocket;
import de.esolutions.fw.util.transport.socket.ISocket;
import de.esolutions.fw.util.transport.socket.SocketWrapper;
import java.io.IOException;
import java.net.ServerSocket;

public class ServerSocketWrapper
implements IServerSocket {
    private final ServerSocket serverSocket;

    public ServerSocketWrapper(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public ISocket accept() throws IOException {
        return new SocketWrapper(this.serverSocket.accept());
    }

    public void close() throws IOException {
        this.serverSocket.close();
    }
}

