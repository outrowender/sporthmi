/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl;

import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionC;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmissionReply;
import de.esolutions.fw.comm.asi.hmisync.car.zeroemission.impl.ASIHMISyncCarZeroEmissionReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarZeroEmissionProxy
implements ASIHMISyncCarZeroEmission,
ASIHMISyncCarZeroEmissionC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
    private Proxy proxy;

    public ASIHMISyncCarZeroEmissionProxy(int n, ASIHMISyncCarZeroEmissionReply aSIHMISyncCarZeroEmissionReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ca36882d-502d-46af-ab3e-d2c6400c0f8f", n, "a6b4ab1f-6788-5ff8-830d-83712694c53c", "asi.hmisync.car.zeroemission.ASIHMISyncCarZeroEmission");
        ASIHMISyncCarZeroEmissionReplyService aSIHMISyncCarZeroEmissionReplyService = new ASIHMISyncCarZeroEmissionReplyService(aSIHMISyncCarZeroEmissionReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncCarZeroEmissionReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
    }

    public void setNotification(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void setNotification(long[] lArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)0, null);
    }

    public void clearNotification(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    public void clearNotification(long[] lArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }
}

