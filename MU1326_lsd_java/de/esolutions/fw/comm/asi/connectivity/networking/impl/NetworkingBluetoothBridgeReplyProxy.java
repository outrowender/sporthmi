/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingBluetoothBridgeReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NetworkingBluetoothBridgeReplyProxy
implements NetworkingBluetoothBridgeReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.NetworkingBluetoothBridge");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public NetworkingBluetoothBridgeReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("455c3e9a-730d-4285-979c-61c4a9648fa2", -1, "473aed0f-a08a-5fd6-ab32-16d904233133", "asi.connectivity.networking.NetworkingBluetoothBridge");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setConnectionState(final long l, final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putEnum(n);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void setProfileConnectable(final long l, final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putEnum(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

