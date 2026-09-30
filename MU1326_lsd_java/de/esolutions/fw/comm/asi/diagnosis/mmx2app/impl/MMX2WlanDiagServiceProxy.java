/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.diagtypes.impl.sClientResponseErrorSerializer;
import de.esolutions.fw.comm.asi.diagnosis.diagtypes.sClientResponseError;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagService;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceC;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2WlanDiagServiceReply;
import de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl.MMX2WlanDiagServiceReplyService;
import de.esolutions.fw.comm.asi.diagnosis.wlan.impl.sWlanPropertiesSerializer;
import de.esolutions.fw.comm.asi.diagnosis.wlan.sWlanProperties;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2WlanDiagServiceProxy
implements MMX2WlanDiagService,
MMX2WlanDiagServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2WlanDiagService");
    private Proxy proxy;

    public MMX2WlanDiagServiceProxy(int n, MMX2WlanDiagServiceReply mMX2WlanDiagServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2ffff5fe-3ecc-4e5e-a640-76dd6851b878", n, "1be1b0ee-6e07-530b-8fc9-ff8327651d0c", "asi.diagnosis.mmx2app.MMX2WlanDiagService");
        MMX2WlanDiagServiceReplyService mMX2WlanDiagServiceReplyService = new MMX2WlanDiagServiceReplyService(mMX2WlanDiagServiceReply);
        this.proxy = new Proxy(serviceInstanceID, mMX2WlanDiagServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseErrorWlan(final sClientResponseError sClientResponseError2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sClientResponseErrorSerializer.putOptionalsClientResponseError(iSerializer, sClientResponseError2);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void responseWlanProperties(final sWlanProperties sWlanProperties2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sWlanPropertiesSerializer.putOptionalsWlanProperties(iSerializer, sWlanProperties2);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void responseSetWlanHotSpotActive(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void responseWlanHotSpotActive(long l, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void responseWlanConnectToAP(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }
}

