/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.socket.ISocket;
import java.io.IOException;

public interface IServerSocket {
    public ISocket accept() throws IOException;

    public void close() throws IOException;
}

