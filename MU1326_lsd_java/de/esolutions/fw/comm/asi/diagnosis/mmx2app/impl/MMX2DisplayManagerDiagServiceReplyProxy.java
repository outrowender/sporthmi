/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2DisplayManagerDiagServiceReplyProxy
implements MMX2DisplayManagerDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public MMX2DisplayManagerDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("900f45af-5513-436c-bd60-0747c447c61f", -1, "e2f5022d-4f99-5bb8-b4a4-a30a4c93d62a", "asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestVideoInputState(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void requestTrunkOfferFBAS(final long l, final int n, final int n2, final short s) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
                iSerializer.putEnum(n2);
                iSerializer.putUInt8(s);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }
}

