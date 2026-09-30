/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.generic.impl;

import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGeneric;
import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericC;
import de.esolutions.fw.comm.asi.hmisync.generic.ASIHMISyncGenericReply;
import de.esolutions.fw.comm.asi.hmisync.generic.GenericPacket;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.ASIHMISyncGenericReplyService;
import de.esolutions.fw.comm.asi.hmisync.generic.impl.GenericPacketSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncGenericProxy
implements ASIHMISyncGeneric,
ASIHMISyncGenericC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.generic.ASIHMISyncGeneric");
    private Proxy proxy;

    public ASIHMISyncGenericProxy(int n, ASIHMISyncGenericReply aSIHMISyncGenericReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8240215d-ce8b-4cad-8c1c-31b07f57874c", n, "acbc4ddf-b980-5af2-a38a-506f1125c975", "asi.hmisync.generic.ASIHMISyncGeneric");
        ASIHMISyncGenericReplyService aSIHMISyncGenericReplyService = new ASIHMISyncGenericReplyService(aSIHMISyncGenericReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncGenericReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void sendDataToUnit(final GenericPacket genericPacket) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                GenericPacketSerializer.putOptionalGenericPacket(iSerializer, genericPacket);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
    }

    public void setNotification(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setNotification(long[] lArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
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

