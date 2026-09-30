/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.net.PlainSocketImpl;
import java.net.Socket;
import java.net.SocketException;

class PlainServerSocketImpl
extends PlainSocketImpl {
    PlainServerSocketImpl() {
    }

    static native void createServerStreamSocketImpl(FileDescriptor var0, boolean var1);

    protected void create(boolean bl) throws SocketException {
        PlainServerSocketImpl.createServerStreamSocketImpl(this.fd, Socket.preferIPv4Stack());
    }
}

