/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OocDiagServiceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2OocDiagServiceReplyProxy
implements MMX2OocDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2OocDiagService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public MMX2OocDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("04ffae27-a8b4-4847-ae17-d9c692c6e219", -1, "70c9dba5-1723-5b89-8b9c-0e21ad580cf1", "asi.diagnosis.mmx2app.MMX2OocDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestTemperatureMMX(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void requestDeleteMemory(final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }
}

