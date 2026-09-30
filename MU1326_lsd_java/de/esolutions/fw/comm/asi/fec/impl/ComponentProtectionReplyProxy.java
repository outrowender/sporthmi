/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.ComponentProtectionReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ComponentProtectionReplyProxy
implements ComponentProtectionReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.ComponentProtection");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ComponentProtectionReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9e66ab21-39b4-11e0-9e42-0800200c9a66", -1, "73f457d8-4826-5389-912d-2ec567427974", "asi.fec.ComponentProtection");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void authStringResult(final String string, final String string2, final byte by) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putInt8(by);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

