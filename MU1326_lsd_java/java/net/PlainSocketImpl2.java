/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.net.InetAddress;
import java.net.PlainSocketImpl;
import java.net.Socket;
import java.net.SocketException;

class PlainSocketImpl2
extends PlainSocketImpl {
    PlainSocketImpl2() {
    }

    static native void createStreamSocketImpl2(FileDescriptor var0, boolean var1);

    static native void connectStreamSocketImpl2(FileDescriptor var0, int var1, int var2, InetAddress var3);

    static native void connectStreamWithTimeoutSocketImpl2(FileDescriptor var0, int var1, int var2, int var3, InetAddress var4);

    protected void create(boolean bl) throws SocketException {
        PlainSocketImpl2.createStreamSocketImpl2(this.fd, Socket.preferIPv4Stack());
    }

    static native int sendDatagramImpl2(FileDescriptor var0, byte[] var1, int var2, int var3, int var4, InetAddress var5);

    static native void socketBindImpl2(FileDescriptor var0, int var1, InetAddress var2);
}

