/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.datagram;

import com.ibm.oti.connection.ConnectionUtil;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.connection.datagram.DatagramPacket;
import com.ibm.oti.connection.socket.SocketHelper;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import javax.microedition.io.Datagram;
import javax.microedition.io.UDPDatagramConnection;

public class Connection
implements CreateConnection,
UDPDatagramConnection {
    static final int DEFAULT_TIMEOUT = 8000;
    private String server;
    private boolean closed = false;
    private int access;
    private int port;
    private int timeout = 0;
    private DatagramSocket socket;

    public void close() throws IOException {
        this.closed = true;
        this.socket.close();
    }

    private static native int netMaxDatagramImpl(DatagramSocket var0);

    private static native int netNominalDatagramImpl(DatagramSocket var0);

    public int getMaximumLength() throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return Connection.netMaxDatagramImpl(this.socket);
    }

    public int getNominalLength() throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return Connection.netNominalDatagramImpl(this.socket);
    }

    public Datagram newDatagram(byte[] byArray, int n) throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (n < 0 || this.isOverMaxLength(n)) {
            throw new IllegalArgumentException();
        }
        DatagramPacket datagramPacket = new DatagramPacket();
        datagramPacket.setData(byArray, 0, n);
        StringBuffer stringBuffer = new StringBuffer("datagram://");
        if (this.server != null) {
            stringBuffer.append(this.server);
        }
        stringBuffer.append(':');
        stringBuffer.append(this.port);
        datagramPacket.setAddress(stringBuffer.toString());
        return datagramPacket;
    }

    public Datagram newDatagram(byte[] byArray, int n, String string) throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (n < 0 || this.isOverMaxLength(n)) {
            throw new IllegalArgumentException();
        }
        DatagramPacket datagramPacket = new DatagramPacket();
        datagramPacket.setData(byArray, 0, n);
        datagramPacket.setAddress(string);
        return datagramPacket;
    }

    public Datagram newDatagram(int n) throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (n < 0 || this.isOverMaxLength(n)) {
            throw new IllegalArgumentException();
        }
        return this.newDatagram(new byte[n], n);
    }

    public Datagram newDatagram(int n, String string) throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (n < 0 || this.isOverMaxLength(n)) {
            throw new IllegalArgumentException();
        }
        DatagramPacket datagramPacket = new DatagramPacket();
        datagramPacket.setData(new byte[n], 0, n);
        datagramPacket.setAddress(string);
        return datagramPacket;
    }

    private boolean isOverMaxLength(int n) {
        try {
            if (this.getMaximumLength() < n) {
                return true;
            }
        }
        catch (IOException iOException) {}
        return false;
    }

    public void receive(Datagram datagram) throws IOException {
        DatagramPacket datagramPacket;
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 1 && this.access != 3) {
            throw new IOException(Msg.getString("K00a9"));
        }
        if (datagram instanceof DatagramPacket) {
            datagramPacket = (DatagramPacket)datagram;
        } else {
            datagramPacket = new DatagramPacket();
            datagramPacket.setData(datagram.getData(), datagram.getOffset(), datagram.getLength());
            datagramPacket.setAddress(datagram.getAddress());
        }
        try {
            this.socket.receive(datagramPacket.getNetPacket());
            datagramPacket.setData(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength());
            if (datagramPacket != datagram) {
                datagram.setAddress(datagramPacket.getAddress());
            }
        }
        catch (SocketException socketException) {
            throw new IOException(socketException.getMessage());
        }
    }

    public void send(Datagram datagram) throws IOException {
        DatagramPacket datagramPacket;
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 2 && this.access != 3) {
            throw new IOException(Msg.getString("K00aa"));
        }
        if (datagram instanceof DatagramPacket) {
            datagramPacket = (DatagramPacket)datagram;
        } else {
            datagramPacket = new DatagramPacket();
            datagramPacket.setData(datagram.getData(), datagram.getOffset(), datagram.getLength());
            datagramPacket.setAddress(datagram.getAddress());
        }
        String string = datagramPacket.getAddress();
        if (string == null) {
            if (this.server == null) {
                return;
            }
            if (datagramPacket == datagram) {
                datagramPacket = new DatagramPacket();
                datagramPacket.setData(datagram.getData(), datagram.getOffset(), datagram.getLength());
            }
            datagramPacket.setAddress("datagram://" + this.server + ":" + this.port);
        }
        try {
            this.socket.send(datagramPacket.getNetPacket());
        }
        catch (SocketException socketException) {
            throw new IOException(socketException.getMessage());
        }
    }

    public javax.microedition.io.Connection setParameters2(String string, int n, boolean bl) throws IOException {
        String[][] stringArray = ConnectionUtil.NO_PARAMETERS;
        int n2 = string.indexOf(59);
        if (n2 != -1) {
            stringArray = ConnectionUtil.getParameters(string.substring(n2 + 1));
            string = string.substring(0, n2);
        }
        this.setParameters(string, stringArray, n, bl);
        return this;
    }

    private void setParameters(String string, String[][] stringArray, int n, boolean bl) throws IOException {
        this.access = n;
        int n2 = 0;
        int n3 = 0;
        int[] nArray = new int[1];
        int n4 = 0;
        while (n4 < stringArray.length) {
            String string2 = stringArray[n4][0];
            stringArray[n4][0] = stringArray[n4][0].toLowerCase();
            if (ConnectionUtil.intParam("so_timeout", stringArray[n4], 1, nArray)) {
                this.timeout = nArray[0];
            } else if (ConnectionUtil.intParam("so_rcvbuf", stringArray[n4], 2, nArray)) {
                n2 = nArray[0];
            } else if (ConnectionUtil.intParam("so_sndbuf", stringArray[n4], 2, nArray)) {
                n3 = nArray[0];
            } else {
                throw new IllegalArgumentException(Msg.getString("K00a5", string2));
            }
            ++n4;
        }
        if (bl && this.timeout == 0) {
            this.timeout = 8000;
        }
        if (!string.startsWith("//")) {
            throw new IllegalArgumentException(Msg.getString("K00a1"));
        }
        String string3 = SocketHelper.parseURL(string, nArray, true, true);
        if (string3.length() != 0) {
            this.server = string3;
        }
        this.port = nArray[0];
        try {
            this.socket = new DatagramSocket(this.server == null ? this.port : 0);
            if (n2 != 0) {
                this.socket.setReceiveBufferSize(n2);
            }
            if (n3 != 0) {
                this.socket.setSendBufferSize(n3);
            }
            if (this.timeout != 0) {
                this.socket.setSoTimeout(this.timeout);
            }
        }
        catch (SocketException socketException) {
            if (this.socket != null) {
                this.socket.close();
            }
            throw new IOException(socketException.getMessage());
        }
    }

    private boolean addressZero(byte[] byArray) {
        boolean bl = true;
        int n = 0;
        while (n < byArray.length) {
            if (byArray[n] != 0) {
                bl = false;
                break;
            }
            ++n;
        }
        return bl;
    }

    public String getLocalAddress() throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        InetAddress inetAddress = this.socket.getLocalAddress();
        if (!this.addressZero(inetAddress.getAddress())) {
            return inetAddress.getHostAddress();
        }
        inetAddress = InetAddress.getLocalHost();
        if (!this.addressZero(inetAddress.getAddress())) {
            return inetAddress.getHostAddress();
        }
        return "127.0.0.1";
    }

    public int getLocalPort() throws IOException {
        if (this.closed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        return this.socket.getLocalPort();
    }
}

