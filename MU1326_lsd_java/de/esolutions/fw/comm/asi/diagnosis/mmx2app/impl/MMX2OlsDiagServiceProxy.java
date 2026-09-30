/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2OlsDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2OlsDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.ols.impl.sActivationStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ols.impl.sConnectionStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.ols.sActivationState;
import de.esolutions.fw.comm.asi.diagnosis.ols.sConnectionState;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2OlsDiagServiceProxy
implements MMX2OlsDiagService,
MMX2OlsDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2OlsDiagService");
    private Proxy proxy;

    public MMX2OlsDiagServiceProxy(int n, MMX2OlsDiagServiceReply mMX2OlsDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("424a4ae2-a7c9-4146-810b-30406bca0fdc", n, "e8d46886-db30-5882-ad53-07b965ab808b", "asi.diagnosis.mmx2app.MMX2OlsDiagService");
        MMX2OlsDiagServiceReplyService mMX2OlsDiagServiceReplyService = new MMX2OlsDiagServiceReplyService(mMX2OlsDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2OlsDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorOls(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void responseConnectionState(final sConnectionState sConnectionState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sConnectionStateSerializer.putOptionalsConnectionState(iSerializer, sConnectionState2);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void responseActivationState(final sActivationState sActivationState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sActivationStateSerializer.putOptionalsActivationState(iSerializer, sActivationState2);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }
}

