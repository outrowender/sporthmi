/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2SwdlDiagServiceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2SwdlDiagServiceReplyProxy
implements MMX2SwdlDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2SwdlDiagService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public MMX2SwdlDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("26548633-0750-4d14-a851-46e73b79a1c8", -1, "ab446ad8-f728-5ed0-a70c-e5dcfab87f63", "asi.diagnosis.mmx2app.MMX2SwdlDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestModuleVersionNumbers(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }
}

