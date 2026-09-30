/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOptions;

public abstract class DatagramSocketImpl
implements SocketOptions {
    protected FileDescriptor fd;
    protected int localPort;
    int receiveTimeout;

    public DatagramSocketImpl() {
        this.initializeSocket();
    }

    protected abstract void bind(int var1, InetAddress var2) throws SocketException;

    protected abstract void close();

    protected abstract void create() throws SocketException;

    protected FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    abstract InetAddress getLocalAddress();

    protected int getLocalPort() {
        return this.localPort;
    }

    public abstract Object getOption(int var1) throws SocketException;

    protected abstract int getTimeToLive() throws IOException;

    void initializeSocket() {
        this.fd = new FileDescriptor();
        this.localPort = -1;
        this.receiveTimeout = 0;
    }

    protected abstract void join(InetAddress var1) throws IOException;

    protected abstract void joinGroup(SocketAddress var1, NetworkInterface var2) throws IOException;

    protected abstract void leave(InetAddress var1) throws IOException;

    protected abstract void leaveGroup(SocketAddress var1, NetworkInterface var2) throws IOException;

    protected abstract int peek(InetAddress var1) throws IOException;

    protected abstract void receive(DatagramPacket var1) throws IOException;

    protected abstract void send(DatagramPacket var1) throws IOException;

    public abstract void setOption(int var1, Object var2) throws SocketException;

    protected abstract void setTimeToLive(int var1) throws IOException;

    protected void connect(InetAddress inetAddress, int n) throws SocketException {
    }

    protected void disconnect() {
    }

    protected abstract int peekData(DatagramPacket var1) throws IOException;
}

