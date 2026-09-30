/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sTestStatusSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sTestStatus;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2AppDtcTestServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2AppDtcTestServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2AppDtcTestServiceProxy
implements MMX2AppDtcTestService,
MMX2AppDtcTestServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2AppDtcTestService");
    private Proxy proxy;

    public MMX2AppDtcTestServiceProxy(int n, MMX2AppDtcTestServiceReply mMX2AppDtcTestServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4ab484de-3b10-4a6a-aa60-18bfc5c3235b", n, "45d3480f-8a52-5f5e-a109-695d43a1f88e", "asi.diagnosis.mmx2app.MMX2AppDtcTestService");
        MMX2AppDtcTestServiceReplyService mMX2AppDtcTestServiceReplyService = new MMX2AppDtcTestServiceReplyService(mMX2AppDtcTestServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2AppDtcTestServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void registerForDiagnosis(int n, long[] lArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putEnum(n);
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void deregisterForDiagnosis() throws MethodException {
        this.proxy.remoteCallMethod((short)0, null);
    }

    public void testStatus(final sTestStatus sTestStatus2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTestStatusSerializer.putOptionalsTestStatus(iSerializer, sTestStatus2);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }
}

