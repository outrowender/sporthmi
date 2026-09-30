/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SdisConfigProviderReplyProxy
implements SdisConfigProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.sdisConfigProvider.SdisConfigProvider");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public SdisConfigProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4005e13e-09f0-11e5-94dc-54ee7547f476", -1, "417013af-3c71-5487-8fc9-6d656a950fc5", "asi.sdisConfigProvider.SdisConfigProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateConfig(final int n, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }
}

