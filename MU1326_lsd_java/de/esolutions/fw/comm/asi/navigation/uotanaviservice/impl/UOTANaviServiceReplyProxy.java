/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice.impl;

import de.esolutions.fw.comm.asi.navigation.uotanaviservice.UOTANaviServiceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class UOTANaviServiceReplyProxy
implements UOTANaviServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.uotanaviservice.UOTANaviService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public UOTANaviServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("0d894ae4-0f7c-48e6-a7e3-0b9f0d32c51a", -1, "5e467618-909a-51d8-837e-36f5bbfa36a1", "asi.navigation.uotanaviservice.UOTANaviService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void getVersionInfo(final short s) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt16(s);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }
}

