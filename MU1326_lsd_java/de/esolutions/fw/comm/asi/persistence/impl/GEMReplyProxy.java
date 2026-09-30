/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.GEMReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class GEMReplyProxy
implements GEMReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.persistence.GEM");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public GEMReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("116d951a-df12-5d02-93b4-69573b9d69b5", -1, "eddb9230-0b3c-558e-b321-dbb0a049fbfb", "asi.persistence.GEM");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void gemActive(final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }
}

