/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.socket;

import de.esolutions.fw.util.transport.IReadable;
import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.IWriter;
import de.esolutions.fw.util.transport.buffer.TransportBuffer;
import de.esolutions.fw.util.transport.debug.ITransportDebug;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpTransport
implements ITransport {
    private DatagramSocket socket = null;
    private InetAddress srcAddr;
    private InetAddress tgtAddr;
    private int srcPort;
    private int tgtPort;
    private int timeOut;
    private boolean isOpen;
    private ITransportDebug debug;

    public UdpTransport(InetAddress inetAddress, int n, InetAddress inetAddress2, int n2, int n3) {
        this.srcAddr = inetAddress;
        this.tgtAddr = inetAddress2;
        this.srcPort = n;
        this.tgtPort = n2;
        this.timeOut = n3;
    }

    public void setDebug(ITransportDebug iTransportDebug) {
        this.debug = iTransportDebug;
    }

    public IReadable recv() throws IOException, TransportException {
        int n = this.getReceiveBufferSize();
        TransportBuffer transportBuffer = new TransportBuffer(n);
        DatagramPacket datagramPacket = new DatagramPacket(transportBuffer.data(), transportBuffer.size());
        if (this.debug != null) {
            long l = System.currentTimeMillis();
            Long l2 = new Long(l);
            transportBuffer.setDebugTag(l2);
            this.debug.log(l, 266, n, l2);
        }
        this.socket.receive(datagramPacket);
        int n2 = datagramPacket.getLength();
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 274, n2, transportBuffer.getDebugTag());
        }
        if (n2 < n) {
            return transportBuffer.createSubBuffer(0, n2);
        }
        return transportBuffer;
    }

    public void open() throws IOException {
        if (!this.isOpen) {
            this.isOpen = true;
            this.socket = new DatagramSocket(this.srcPort, this.srcAddr);
            this.socket.setSoTimeout(this.timeOut);
        }
    }

    public boolean isOpen() {
        return this.isOpen;
    }

    public void close(boolean bl) {
        if (this.isOpen) {
            this.isOpen = false;
            this.socket.close();
            this.socket = null;
        }
    }

    public void flush() {
    }

    public void send(IWriter iWriter) throws IOException, TransportException {
        int n = iWriter.size();
        TransportBuffer transportBuffer = new TransportBuffer(n);
        iWriter.write(transportBuffer);
        DatagramPacket datagramPacket = new DatagramPacket(transportBuffer.data(), n, this.tgtAddr, this.tgtPort);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 265, n, iWriter.getDebugTag());
        }
        this.socket.send(datagramPacket);
        if (this.debug != null) {
            this.debug.log(System.currentTimeMillis(), 273, n, iWriter.getDebugTag());
        }
    }

    public void sendSync(IWriter iWriter) throws IOException, TransportException {
        this.send(iWriter);
    }

    public int maxMsgSize() {
        try {
            return this.socket.getSendBufferSize();
        }
        catch (SocketException socketException) {
            return 0;
        }
    }

    public int getReceiveBufferSize() {
        try {
            return this.socket.getReceiveBufferSize();
        }
        catch (SocketException socketException) {
            return 0;
        }
    }

    public boolean isReliable() {
        return false;
    }

    public boolean detectsPeerReset() {
        return true;
    }

    public boolean keepsRecordBoundaries() {
        return true;
    }

    public String getDescription() {
        return "[UDP:src=" + this.srcAddr + ":" + this.srcPort + ",tgt=" + this.tgtAddr + ":" + this.tgtPort + "]";
    }
}

