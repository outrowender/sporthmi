/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.BindException;
import java.net.DatagramPacket;
import java.net.DatagramSocketImpl;
import java.net.GenericIPMreq;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.util.Hashtable;

class PlainDatagramSocketImpl
extends DatagramSocketImpl {
    private static final int SO_BROADCAST = 32;
    static final int IP_MULTICAST_ADD = 19;
    static final int IP_MULTICAST_DROP = 20;
    static final int IP_MULTICAST_TTL = 17;
    private boolean bindToDevice;
    private byte[] ipaddress = new byte[4];
    private int ttl = 1;
    private volatile boolean isNativeConnected = false;
    static final int REUSEADDR_AND_REUSEPORT = 10001;
    private InetAddress connectedAddress = null;
    private int connectedPort = -1;
    private int trafficClass = 0;
    private static boolean fixBind = false;
    private static Hashtable checkBind;
    boolean reuseAddr = false;

    static {
        PlainDatagramSocketImpl.oneTimeInitialization(true);
        String string = (String)AccessController.doPrivileged(new PriviAction("uniqueBindFix"));
        boolean bl = fixBind = string != null && string.toLowerCase().equals("true");
        if (fixBind) {
            checkBind = new Hashtable();
        }
    }

    PlainDatagramSocketImpl() {
    }

    private static native void oneTimeInitialization(boolean var0);

    protected void bind(int n, InetAddress inetAddress) throws SocketException {
        boolean bl;
        String string = (String)AccessController.doPrivileged(new PriviAction("bindToDevice"));
        boolean bl2 = bl = string != null && string.toLowerCase().equals("true");
        if (fixBind && !this.reuseAddr && n != 0 && checkBind.get(new Integer(n)) != null) {
            throw new BindException(Msg.getString("K03ba", n));
        }
        try {
            this.bindToDevice = PlainDatagramSocketImpl.socketBindImpl2(this.fd, n, bl, inetAddress);
        }
        catch (BindException bindException) {
            throw new BindException(inetAddress + ":" + n + " - " + bindException.getMessage());
        }
        this.localPort = n != 0 ? n : Socket.getSocketLocalPortImpl(this.fd, InetAddress.preferIPv6Addresses());
        if (fixBind) {
            Integer n2 = new Integer(this.localPort);
            checkBind.put(n2, n2);
        }
        try {
            this.setOption(32, Boolean.TRUE);
        }
        catch (IOException iOException) {}
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void close() {
        FileDescriptor fileDescriptor = this.fd;
        synchronized (fileDescriptor) {
            if (this.fd.valid()) {
                Socket.socketCloseImpl(this.fd);
                if (fixBind) {
                    checkBind.remove(new Integer(this.localPort));
                }
                this.initializeSocket();
            }
        }
    }

    protected void create() throws SocketException {
        PlainDatagramSocketImpl.createDatagramSocketImpl(this.fd, Socket.preferIPv4Stack());
    }

    protected void finalize() {
        this.close();
    }

    InetAddress getLocalAddress() {
        return Socket.getSocketLocalAddressImpl(this.fd, InetAddress.preferIPv6Addresses());
    }

    public Object getOption(int n) throws SocketException {
        if (n == 4102) {
            return new Integer(this.receiveTimeout);
        }
        if (n == 3) {
            return new Integer(this.trafficClass);
        }
        Object object = Socket.getSocketOptionImpl(this.fd, n);
        if (n == 16 && (Socket.getSocketFlags() & 1) != 0) {
            return new Inet4Address(this.ipaddress);
        }
        return object;
    }

    protected int getTimeToLive() throws IOException {
        int n = (Byte)this.getOption(17) & 0xFF;
        if ((Socket.getSocketFlags() & 2) != 0) {
            return this.ttl;
        }
        return n;
    }

    protected byte getTTL() throws IOException {
        byte by = (Byte)this.getOption(17);
        if ((Socket.getSocketFlags() & 2) != 0) {
            return (byte)this.ttl;
        }
        return by;
    }

    protected void join(InetAddress inetAddress) throws IOException {
        this.setOption(19, new GenericIPMreq(inetAddress));
    }

    protected void joinGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            InetAddress inetAddress = ((InetSocketAddress)socketAddress).getAddress();
            this.setOption(19, new GenericIPMreq(inetAddress, networkInterface));
        }
    }

    protected void leave(InetAddress inetAddress) throws IOException {
        this.setOption(20, new GenericIPMreq(inetAddress));
    }

    protected void leaveGroup(SocketAddress socketAddress, NetworkInterface networkInterface) throws IOException {
        if (socketAddress instanceof InetSocketAddress) {
            InetAddress inetAddress = ((InetSocketAddress)socketAddress).getAddress();
            this.setOption(20, new GenericIPMreq(inetAddress, networkInterface));
        }
    }

    protected static native void connectDatagramImpl2(FileDescriptor var0, int var1, int var2, InetAddress var3);

    protected static native void disconnectDatagramImpl(FileDescriptor var0);

    protected static native void createDatagramSocketImpl(FileDescriptor var0, boolean var1);

    protected static native boolean socketBindImpl2(FileDescriptor var0, int var1, boolean var2, InetAddress var3);

    protected static native int peekDatagramImpl(FileDescriptor var0, InetAddress var1, int var2);

    protected static native int receiveDatagramImpl2(FileDescriptor var0, DatagramPacket var1, byte[] var2, int var3, int var4, int var5, boolean var6);

    protected static native int recvConnectedDatagramImpl(FileDescriptor var0, DatagramPacket var1, byte[] var2, int var3, int var4, int var5, boolean var6);

    protected static native int sendDatagramImpl2(FileDescriptor var0, byte[] var1, int var2, int var3, int var4, boolean var5, int var6, InetAddress var7);

    protected static native int sendConnectedDatagramImpl(FileDescriptor var0, byte[] var1, int var2, int var3, boolean var4);

    protected int peek(InetAddress inetAddress) throws IOException {
        if (this.isNativeConnected) {
            byte[] byArray = new byte[10];
            DatagramPacket datagramPacket = new DatagramPacket(byArray, byArray.length);
            PlainDatagramSocketImpl.recvConnectedDatagramImpl(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, true);
            inetAddress.ipaddress = this.connectedAddress.getAddress();
            return this.connectedPort;
        }
        return PlainDatagramSocketImpl.peekDatagramImpl(this.fd, inetAddress, this.receiveTimeout);
    }

    protected void receive(DatagramPacket datagramPacket) throws IOException {
        boolean bl;
        try {
            if (this.isNativeConnected) {
                PlainDatagramSocketImpl.recvConnectedDatagramImpl(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, false);
                this.updatePacketRecvAddress(datagramPacket);
            } else {
                PlainDatagramSocketImpl.receiveDatagramImpl2(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, false);
            }
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new SocketTimeoutException(interruptedIOException.getMessage());
        }
        byte[] byArray = InetAddress.LOOPBACK.ipaddress;
        boolean bl2 = bl = byArray.length == this.ipaddress.length;
        if (bl) {
            int n = 0;
            while (n < byArray.length) {
                if (byArray[n] != this.ipaddress[n]) {
                    bl = false;
                    break;
                }
                ++n;
            }
        }
        if (bl) {
            try {
                if (datagramPacket.getAddress().equals(InetAddress.getLocalHost())) {
                    datagramPacket.setAddress(InetAddress.LOOPBACK);
                }
            }
            catch (UnknownHostException unknownHostException) {}
        }
    }

    protected void send(DatagramPacket datagramPacket) throws IOException {
        if (this.isNativeConnected) {
            PlainDatagramSocketImpl.sendConnectedDatagramImpl(this.fd, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.bindToDevice);
        } else {
            PlainDatagramSocketImpl.sendDatagramImpl2(this.fd, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), datagramPacket.getPort(), this.bindToDevice, this.trafficClass, datagramPacket.getAddress());
        }
    }

    public void setOption(int n, Object object) throws SocketException {
        if (n == 512) {
            this.reuseAddr = (Boolean)object;
        } else if (n == 4) {
            n = 10001;
            this.reuseAddr = (Boolean)object;
        }
        if (n == 4102) {
            this.receiveTimeout = (Integer)object;
        } else {
            int n2;
            block15: {
                n2 = Socket.getSocketFlags();
                try {
                    Socket.setSocketOptionImpl(this.fd, n | n2 << 16, object);
                }
                catch (SocketException socketException) {
                    if (n == 3) break block15;
                    throw socketException;
                }
            }
            if (n == 16 && (n2 & 1) != 0) {
                InetAddress inetAddress = (InetAddress)object;
                if (inetAddress.ipaddress.length == 4 && InetAddress.bytesToInt(inetAddress.ipaddress, 0) == 0 || inetAddress.equals(InetAddress.LOOPBACK)) {
                    this.ipaddress = ((InetAddress)object).getAddress();
                } else {
                    InetAddress inetAddress2 = null;
                    try {
                        inetAddress2 = InetAddress.getLocalHost();
                    }
                    catch (UnknownHostException unknownHostException) {
                        throw new SocketException("getLocalHost(): " + unknownHostException.toString());
                    }
                    if (inetAddress.equals(inetAddress2)) {
                        this.ipaddress = ((InetAddress)object).getAddress();
                    } else {
                        throw new SocketException(object + " != getLocalHost(): " + inetAddress2);
                    }
                }
            }
            if (n == 3) {
                this.trafficClass = (Integer)object;
            }
        }
    }

    protected void setTimeToLive(int n) throws IOException {
        this.setOption(17, new Byte((byte)(n & 0xFF)));
        if ((Socket.getSocketFlags() & 2) != 0) {
            this.ttl = n;
        }
    }

    protected void setTTL(byte by) throws IOException {
        this.setOption(17, new Byte(by));
        if ((Socket.getSocketFlags() & 2) != 0) {
            this.ttl = by;
        }
    }

    protected void connect(InetAddress inetAddress, int n) throws SocketException {
        PlainDatagramSocketImpl.connectDatagramImpl2(this.fd, n, this.trafficClass, inetAddress);
        try {
            this.connectedAddress = InetAddress.getByAddress(inetAddress.getAddress());
        }
        catch (UnknownHostException unknownHostException) {
            throw new SocketException(Msg.getString("K0317", inetAddress.getHostName()));
        }
        this.connectedPort = n;
        this.isNativeConnected = true;
    }

    protected void disconnect() {
        try {
            PlainDatagramSocketImpl.disconnectDatagramImpl(this.fd);
        }
        catch (Exception exception) {}
        this.connectedPort = -1;
        this.connectedAddress = null;
        this.isNativeConnected = false;
    }

    protected int peekData(DatagramPacket datagramPacket) throws IOException {
        try {
            if (this.isNativeConnected) {
                PlainDatagramSocketImpl.recvConnectedDatagramImpl(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, true);
                this.updatePacketRecvAddress(datagramPacket);
            } else {
                PlainDatagramSocketImpl.receiveDatagramImpl2(this.fd, datagramPacket, datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength(), this.receiveTimeout, true);
            }
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new SocketTimeoutException(interruptedIOException.getMessage());
        }
        return datagramPacket.getPort();
    }

    private void updatePacketRecvAddress(DatagramPacket datagramPacket) {
        datagramPacket.setAddress(this.connectedAddress);
        datagramPacket.port = this.connectedPort;
    }
}

