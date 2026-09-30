/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.socket.IByteTransport;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamTransport
implements IByteTransport {
    private static final int BUFFER_SIZE = 8192;
    private ITransportDebug debug;
    private final OutputStream out;

    public OutputStreamTransport(OutputStream outputStream) {
        this.out = outputStream;
    }

    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    public void send(byte[] byArray, int n, Object object) throws IOException {
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 265, n, object);
        }
        this.out.write(byArray, 0, n);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 273, n, object);
        }
    }

    public int recv(byte[] byArray, Object object) throws IOException, TransportException {
        return 0;
    }

    public void open() throws IOException {
    }

    public void close(boolean bl) throws IOException {
        this.out.close();
    }

    public int getSendBufferSize() {
        return 8192;
    }

    public int getReceiveBufferSize() {
        return 0;
    }

    public boolean isReliable() {
        return true;
    }

    public boolean detectsPeerReset() {
        return true;
    }

    public String getDescription() {
        return "[OutputStream;" + this.out + "]";
    }
}

