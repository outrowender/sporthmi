/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import java.io.FileDescriptor;
import java.net.PlainDatagramSocketImpl;
import java.net.Socket;
import java.net.SocketException;

class PlainMulticastSocketImpl
extends PlainDatagramSocketImpl {
    PlainMulticastSocketImpl() {
    }

    static native void createMulticastSocketImpl(FileDescriptor var0, boolean var1);

    protected void create() throws SocketException {
        PlainMulticastSocketImpl.createMulticastSocketImpl(this.fd, Socket.preferIPv4Stack());
        this.reuseAddr = true;
    }
}

