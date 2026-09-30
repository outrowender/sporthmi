/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.EndOfTransportException;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.socket.IByteTransport;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamTransport
implements IByteTransport {
    private static final int BUFFER_SIZE = 8192;
    private ITransportDebug debug;
    private final InputStream in;

    public InputStreamTransport(InputStream inputStream) {
        this.in = inputStream;
    }

    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    public void send(byte[] byArray, int n, Object object) throws IOException {
    }

    public int recv(byte[] byArray, Object object) throws IOException, TransportException {
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 266, byArray.length, object);
        }
        int n = this.in.read(byArray);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 274, n, object);
        }
        if (n == -1) {
            throw new EndOfTransportException("EOT");
        }
        return n;
    }

    public void open() throws IOException {
    }

    public void close(boolean bl) throws IOException {
        if (this.in != null) {
            this.in.close();
        }
    }

    public int getSendBufferSize() {
        return 0;
    }

    public int getReceiveBufferSize() {
        return 8192;
    }

    public boolean isReliable() {
        return true;
    }

    public boolean detectsPeerReset() {
        return true;
    }

    public String getDescription() {
        return "[InputStream;" + this.in + "]";
    }
}

