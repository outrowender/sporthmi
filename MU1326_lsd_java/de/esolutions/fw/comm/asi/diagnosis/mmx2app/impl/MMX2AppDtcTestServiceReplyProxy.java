/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2AppDtcTestServiceReplyProxy
implements MMX2AppDtcTestServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2AppDtcTestService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public MMX2AppDtcTestServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9e79c740-f61e-42bd-a575-c0c06d5f623b", -1, "48e93f98-718a-5f3c-9e06-ed7a0c0371b1", "asi.diagnosis.mmx2app.MMX2AppDtcTestService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void registerForDiagnosisAck(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void performTest(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void performAllTests() throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

