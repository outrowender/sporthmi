/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanDevice;
import de.esolutions.fw.comm.asi.connectivity.networking.WlanServiceReply;
import de.esolutions.fw.comm.asi.connectivity.networking.impl.WlanDeviceSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class WlanServiceReplyProxy
implements WlanServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.WlanService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public WlanServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("24fd4522-b997-4cd5-b2f8-890d6c224eb0", -1, "7475049f-9ea8-5f56-ab00-5c258cd1be7f", "asi.connectivity.networking.WlanService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateWlanReady(final boolean bl, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void updateWLANDevice(final WlanDevice wlanDevice) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                WlanDeviceSerializer.putOptionalWlanDevice(iSerializer, wlanDevice);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }
}

