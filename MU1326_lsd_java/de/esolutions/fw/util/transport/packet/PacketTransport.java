/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.packet;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.WriteableWindow;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.exception.TransportPartialPacketException;
import de.esolutions.fw.util.transport.exception.TransportTimeoutException;
import de.esolutions.fw.util.transport.packet.PacketHeader;
import de.esolutions.fw.util.transport.socket.IByteTransport;
import java.io.IOException;

public class PacketTransport
implements ITransport {
    private ITransportDebug debug;
    protected IByteTransport stream;
    protected TransportBuffer rxData;
    protected int rxBufferPos;
    protected int rxBufferAvailable;
    protected byte[] rxHeaderData;
    protected TransportBuffer txData;
    protected boolean isOpen;
    private final int maxRxSize;
    private final int maxTxSize;

    protected void initRxData(int n) {
        this.rxData = new TransportBuffer(n);
        this.rxBufferPos = 0;
        this.rxBufferAvailable = 0;
    }

    protected void initTxData(int n) {
        this.txData = new TransportBuffer(n);
    }

    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
        this.stream.setDebug(iTransportDebug);
    }

    public PacketTransport(IByteTransport iByteTransport) {
        this.maxRxSize = 8192;
        this.maxTxSize = 8192;
        this.stream = iByteTransport;
        this.rxHeaderData = new byte[4];
    }

    public void open() throws IOException {
        if (this.isOpen) {
            return;
        }
        this.stream.open();
        int n = this.stream.getReceiveBufferSize();
        if (n > 8192) {
            n = 8192;
        }
        this.initRxData(n);
        int n2 = this.stream.getSendBufferSize();
        if (n2 > 8192) {
            n2 = 8192;
        }
        this.initTxData(n2);
        this.isOpen = true;
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void close(boolean bl) throws IOException {
        if (!this.isOpen) {
            return;
        }
        this.stream.close(bl);
        this.isOpen = false;
    }

    public void flush() throws IOException, TransportException, InterruptedException {
    }

    public void send(IWriter iWriter) throws IOException, TransportException {
        byte[] byArray;
        int n;
        if (!this.isOpen) {
            throw new TransportException("Transport send without open!");
        }
        int n2 = iWriter.size();
        int n3 = n2 + (n = (byArray = PacketHeader.encode(n2)).length);
        TransportBuffer transportBuffer = n3 > this.txData.size() ? new TransportBuffer(n3) : this.txData;
        transportBuffer.setData(0, byArray);
        if (n2 > 0) {
            WriteableWindow writeableWindow = transportBuffer.setLocalWindow(n, n2);
            iWriter.write(transportBuffer);
            transportBuffer.setWindow(writeableWindow);
        }
        this.stream.send(transportBuffer.data(), n3, iWriter.getDebugTag());
        transportBuffer.resetWindow();
    }

    public void sendSync(IWriter iWriter) throws IOException, TransportException {
        this.send(iWriter);
    }

    public IReadable recv() throws IOException, TransportException {
        int n;
        if (!this.isOpen) {
            throw new TransportException("Transport recv without open!");
        }
        long l = System.currentTimeMillis();
        Long l2 = new Long(l);
        if (this.debug != null) {
            this.debug.log(l, 522, 0, l2);
        }
        if ((n = this.read(this.rxHeaderData, 4, l2)) == 0) {
            throw new TransportTimeoutException("No header!");
        }
        if (n < 4) {
            throw new TransportPartialPacketException("Partial header: " + n + " of " + 4);
        }
        int n2 = PacketHeader.decode(this.rxHeaderData);
        if (n2 < 0) {
            throw new TransportException("Negative recv size! Invalid stream!");
        }
        TransportBuffer transportBuffer = new TransportBuffer(n2);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 518, n2, l2);
        }
        if ((n = this.read(transportBuffer.data(), n2, l2)) < n2) {
            throw new TransportPartialPacketException("Partial payload: " + n + " of " + n2);
        }
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 530, n2, l2);
            transportBuffer.setDebugTag(l2);
        }
        return transportBuffer;
    }

    protected int read(byte[] byArray, int n, Object object) throws IOException, TransportException {
        if (n <= this.rxBufferAvailable) {
            System.arraycopy((Object)this.rxData.data(), this.rxBufferPos, (Object)byArray, 0, n);
            this.rxBufferAvailable -= n;
            this.rxBufferPos += n;
            return n;
        }
        int n2 = n;
        int n3 = 0;
        while (n2 > 0) {
            int n4 = this.rxBufferAvailable;
            if (n4 > n2) {
                n4 = n2;
            }
            if (n4 > 0) {
                System.arraycopy((Object)this.rxData.data(), this.rxBufferPos, (Object)byArray, n3, n4);
                n3 += n4;
                n2 -= n4;
                this.rxBufferPos += n4;
                this.rxBufferAvailable -= n4;
            }
            if (n2 <= 0 || this.rxBufferAvailable != 0) continue;
            this.rxBufferPos = 0;
            this.rxBufferAvailable = this.stream.recv(this.rxData.data(), object);
            if (this.rxBufferAvailable != 0) continue;
            break;
        }
        return n - n2;
    }

    public int maxMsgSize() {
        return this.stream.getSendBufferSize() - 4;
    }

    public boolean isReliable() {
        return this.stream.isReliable();
    }

    public boolean detectsPeerReset() {
        return this.stream.detectsPeerReset();
    }

    public boolean keepsRecordBoundaries() {
        return true;
    }

    public String getDescription() {
        return "[Packet:" + this.stream.getDescription() + "]";
    }
}

