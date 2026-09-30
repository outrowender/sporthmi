/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.has.DSIHAS;
import de.esolutions.fw.comm.dsi.has.DSIHASC;
import de.esolutions.fw.comm.dsi.has.DSIHASReply;
import de.esolutions.fw.comm.dsi.has.impl.DSIHASReplyService;
import de.esolutions.fw.comm.dsi.has.impl.HASDataContainerSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.has.HASDataContainer;

public class DSIHASProxy
implements DSIHAS,
DSIHASC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.has.DSIHAS");
    private Proxy proxy;

    public DSIHASProxy(int n, DSIHASReply dSIHASReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9aa7fbc8-ef68-52c8-b441-39d5bc8cc9e1", n, "569dc367-0d8b-5f26-9c24-740e5ab0b2d5", "dsi.has.DSIHAS");
        DSIHASReplyService dSIHASReplyService = new DSIHASReplyService(dSIHASReply);
        this.proxy = new Proxy(serviceInstanceID, dSIHASReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void hmiReady() throws MethodException {
        this.proxy.remoteCallMethod((short)7, null);
    }

    public void actionResult(final int n, final int n2, final HASDataContainer[] hASDataContainerArray, final int n3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                HASDataContainerSerializer.putOptionalHASDataContainerVarArray(iSerializer, hASDataContainerArray);
                iSerializer.putInt32(n3);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void propertyUpdate(final int n, final HASDataContainer[] hASDataContainerArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                HASDataContainerSerializer.putOptionalHASDataContainerVarArray(iSerializer, hASDataContainerArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void subscribeResult(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)9, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }
}

