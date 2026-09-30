/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.aggregate;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.aggregate.AggregateDecoder;
import de.esolutions.fw.util.transport.aggregate.AggregateEncoder;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public class AggregateTransport
implements ITransport {
    protected ITransport transport;
    protected AggregateDecoder decoder;
    protected AggregateEncoder encoder;
    protected int maxPacketSize;
    protected boolean isOpen;

    public AggregateTransport(ITransport iTransport) {
        this.transport = iTransport;
        this.encoder = new AggregateEncoder(iTransport);
        this.decoder = new AggregateDecoder(iTransport);
        this.maxPacketSize = 0;
    }

    public AggregateTransport(ITransport iTransport, int n) {
        this.transport = iTransport;
        this.encoder = new AggregateEncoder(iTransport);
        this.decoder = new AggregateDecoder(iTransport);
        this.maxPacketSize = n;
    }

    public void flush() throws IOException, TransportException, InterruptedException {
        if (this.encoder == null) {
            throw new RuntimeException("No Transmitter in Transport!");
        }
        this.encoder.flushPacket();
    }

    public void send(IWriter iWriter) throws IOException, TransportException, InterruptedException {
        if (this.encoder == null) {
            throw new RuntimeException("No Transmitter in Transport!");
        }
        this.encoder.putMessage(iWriter);
    }

    public void sendSync(IWriter iWriter) throws IOException, TransportException, InterruptedException {
        if (this.encoder == null) {
            throw new RuntimeException("No Transmitter in Transport!");
        }
        this.encoder.putMessageCopy(iWriter);
    }

    public IReadable recv() throws IOException, TransportException, InterruptedException {
        if (this.decoder == null) {
            throw new RuntimeException("No Receiver in Transport!");
        }
        return this.decoder.getMessage();
    }

    public void open() throws IOException {
        if (this.isOpen) {
            return;
        }
        this.isOpen = true;
        this.transport.open();
        if (this.encoder != null) {
            this.encoder.init(this.maxPacketSize);
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void close(boolean bl) throws IOException {
        if (!this.isOpen) {
            return;
        }
        this.isOpen = false;
        this.transport.close(bl);
    }

    public int maxMsgSize() {
        if (this.encoder != null) {
            return this.encoder.getMaxMessageSize();
        }
        return 0;
    }

    public boolean isReliable() {
        return this.transport.isReliable();
    }

    public boolean detectsPeerReset() {
        return this.transport.detectsPeerReset();
    }

    public boolean keepsRecordBoundaries() {
        return this.transport.keepsRecordBoundaries();
    }

    public String getDescription() {
        return "[Aggregate:" + this.transport.getDescription() + "]";
    }

    public void setDebug(ITransportDebug iTransportDebug) {
    }
}

