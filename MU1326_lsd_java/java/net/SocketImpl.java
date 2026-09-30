/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketOptions;
import java.net.SocketTimeoutException;

public abstract class SocketImpl
implements SocketOptions {
    protected InetAddress address;
    protected int port;
    protected FileDescriptor fd;
    protected int localport;
    int receiveTimeout;
    boolean shutdownInput = false;

    static {
        SocketImpl.oneTimeInitialization(true);
    }

    private static native void oneTimeInitialization(boolean var0);

    public SocketImpl() {
        this.initializeSocket();
    }

    protected abstract void accept(SocketImpl var1) throws IOException;

    protected abstract int available() throws IOException;

    protected abstract void bind(InetAddress var1, int var2) throws IOException;

    protected abstract void close() throws IOException;

    protected abstract void connect(String var1, int var2) throws IOException;

    protected abstract void connect(InetAddress var1, int var2) throws IOException;

    protected abstract void create(boolean var1) throws IOException;

    protected FileDescriptor getFileDescriptor() {
        return this.fd;
    }

    protected InetAddress getInetAddress() {
        return this.address;
    }

    protected abstract InputStream getInputStream() throws IOException;

    protected int getLocalPort() {
        return this.localport;
    }

    public abstract Object getOption(int var1) throws SocketException;

    protected abstract OutputStream getOutputStream() throws IOException;

    protected int getPort() {
        return this.port;
    }

    void initializeSocket() {
        this.fd = new FileDescriptor();
        this.receiveTimeout = 0;
    }

    protected abstract void listen(int var1) throws IOException;

    static native void acceptStreamSocketImpl(FileDescriptor var0, SocketImpl var1, FileDescriptor var2, int var3);

    static native int availableStreamImpl(FileDescriptor var0);

    static native void createStreamSocketImpl(FileDescriptor var0, boolean var1);

    static native void createDatagramSocketImpl(FileDescriptor var0, boolean var1);

    static native void listenStreamSocketImpl(FileDescriptor var0, int var1);

    static native int receiveStreamImpl(FileDescriptor var0, byte[] var1, int var2, int var3, int var4);

    static native int sendStreamImpl(FileDescriptor var0, byte[] var1, int var2, int var3);

    int read(byte[] byArray, int n, int n2) throws IOException {
        if (this.shutdownInput) {
            return -1;
        }
        try {
            int n3 = SocketImpl.receiveStreamImpl(this.fd, byArray, n, n2, this.receiveTimeout);
            if (n3 == -1) {
                this.shutdownInput = true;
            }
            return n3;
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new SocketTimeoutException(interruptedIOException.getMessage());
        }
    }

    public abstract void setOption(int var1, Object var2) throws SocketException;

    public String toString() {
        return new StringBuffer(100).append("Socket[addr=").append(this.getInetAddress()).append(",port=").append(this.port).append(",localport=").append(this.getLocalPort()).append("]").toString();
    }

    int write(byte[] byArray, int n, int n2) throws IOException {
        return SocketImpl.sendStreamImpl(this.fd, byArray, n, n2);
    }

    protected void shutdownInput() throws IOException {
        this.shutdownInput = true;
        this.shutdownInputImpl(this.fd);
    }

    private native void shutdownInputImpl(FileDescriptor var1);

    protected void shutdownOutput() throws IOException {
        this.shutdownOutputImpl(this.fd);
    }

    private native void shutdownOutputImpl(FileDescriptor var1);

    protected abstract void connect(SocketAddress var1, int var2) throws IOException;

    protected boolean supportsUrgentData() {
        return false;
    }

    protected abstract void sendUrgentData(int var1) throws IOException;

    static native boolean supportsUrgentDataImpl(FileDescriptor var0);

    static native boolean sendUrgentDataImpl(FileDescriptor var0, byte var1);
}

