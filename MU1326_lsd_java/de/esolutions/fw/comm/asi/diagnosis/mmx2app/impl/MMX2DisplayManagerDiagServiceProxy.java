/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl.sTrunkOfferFBASSerializer;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.impl.sVideoInputStateSerializer;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sTrunkOfferFBAS;
import de.esolutions.fw.comm.asi.diagnosis.displaymanager.sVideoInputState;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2DisplayManagerDiagServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2DisplayManagerDiagServiceProxy
implements MMX2DisplayManagerDiagService,
MMX2DisplayManagerDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
    private Proxy proxy;

    public MMX2DisplayManagerDiagServiceProxy(int n, MMX2DisplayManagerDiagServiceReply mMX2DisplayManagerDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("d9796ad7-dbdb-4a6a-91b8-87d2003632af", n, "ce357906-130f-5933-baca-79721aa7173a", "asi.diagnosis.mmx2app.MMX2DisplayManagerDiagService");
        MMX2DisplayManagerDiagServiceReplyService mMX2DisplayManagerDiagServiceReplyService = new MMX2DisplayManagerDiagServiceReplyService(mMX2DisplayManagerDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2DisplayManagerDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorDisplayManager(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void responseVideoInputState(final sVideoInputState sVideoInputState2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sVideoInputStateSerializer.putOptionalsVideoInputState(iSerializer, sVideoInputState2);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void responseTrunkOfferFBAS(final sTrunkOfferFBAS sTrunkOfferFBAS2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sTrunkOfferFBASSerializer.putOptionalsTrunkOfferFBAS(iSerializer, sTrunkOfferFBAS2);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }
}

