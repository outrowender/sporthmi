/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public interface IByteTransport {
    public void send(byte[] var1, int var2, Object var3) throws IOException;

    public int recv(byte[] var1, Object var2) throws IOException, TransportException;

    public void open() throws IOException;

    public void close(boolean var1) throws IOException;

    public int getSendBufferSize();

    public int getReceiveBufferSize();

    public boolean isReliable();

    public boolean detectsPeerReset();

    public String getDescription();

    public void setDebug(ITransportDebug var1);
}

