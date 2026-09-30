/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.impl;

import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGeneric;
import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericC;
import de.esolutions.fw.comm.asi.hmisync.car.ASIHMISyncCarGenericReply;
import de.esolutions.fw.comm.asi.hmisync.car.impl.ASIHMISyncCarGenericReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarGenericProxy
implements ASIHMISyncCarGeneric,
ASIHMISyncCarGenericC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.ASIHMISyncCarGeneric");
    private Proxy proxy;

    public ASIHMISyncCarGenericProxy(int n, ASIHMISyncCarGenericReply aSIHMISyncCarGenericReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5b840a23-d8e1-48db-bd23-f4040e6a7520", n, "53d5f21b-54ec-5e84-8236-10ea0e3da972", "asi.hmisync.car.ASIHMISyncCarGeneric");
        ASIHMISyncCarGenericReplyService aSIHMISyncCarGenericReplyService = new ASIHMISyncCarGenericReplyService(aSIHMISyncCarGenericReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncCarGenericReplyService, context);
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

