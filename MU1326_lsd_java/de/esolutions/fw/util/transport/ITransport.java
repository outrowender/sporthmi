/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public interface ITransport {
    public void send(IWriter var1) throws IOException, TransportException, InterruptedException;

    public void sendSync(IWriter var1) throws IOException, TransportException, InterruptedException;

    public IReadable recv() throws IOException, TransportException, InterruptedException;

    public void flush() throws IOException, TransportException, InterruptedException;

    public void open() throws IOException;

    public boolean isOpen();

    public void close(boolean var1) throws IOException;

    public int maxMsgSize();

    public boolean keepsRecordBoundaries();

    public boolean isReliable();

    public boolean detectsPeerReset();

    public String getDescription();

    public void setDebug(ITransportDebug var1);
}

