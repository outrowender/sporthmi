/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreService;
import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceC;
import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceReply;
import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyService;
import de.esolutions.fw.comm.asi.online.coreservice.impl.KeyValPairSerializer;
import de.esolutions.fw.comm.asi.online.coreservice.impl.RequestDescriptorSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ExtOnlineCoreServiceProxy
implements ExtOnlineCoreService,
ExtOnlineCoreServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.online.coreservice.ExtOnlineCoreService");
    private Proxy proxy;

    public ExtOnlineCoreServiceProxy(int n, ExtOnlineCoreServiceReply extOnlineCoreServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4e35da00-907d-11e2-9e96-0800200c9a66", n, "81036f67-c3c8-5bbe-adb0-befcec466919", "asi.online.coreservice.ExtOnlineCoreService");
        ExtOnlineCoreServiceReplyService extOnlineCoreServiceReplyService = new ExtOnlineCoreServiceReplyService(extOnlineCoreServiceReply);
        this.proxy = new Proxy(serviceInstanceID, extOnlineCoreServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void init(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void init(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void registerService(String string, String string2, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    public void getServiceListEntry(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    public void precheckOnlineServiceServiceID(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void precheckOnlineService() throws MethodException {
        this.proxy.remoteCallMethod((short)26, null);
    }

    public void requestUpdateKeyStore() throws MethodException {
        this.proxy.remoteCallMethod((short)14, null);
    }

    public void getToken(String string, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    public void onlineRequest(final RequestDescriptor requestDescriptor, final int n, final KeyValPair[] keyValPairArray, final KeyValPair[] keyValPairArray2, final byte[] byArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RequestDescriptorSerializer.putOptionalRequestDescriptor(iSerializer, requestDescriptor);
                iSerializer.putInt32(n);
                KeyValPairSerializer.putOptionalKeyValPairVarArray(iSerializer, keyValPairArray);
                KeyValPairSerializer.putOptionalKeyValPairVarArray(iSerializer, keyValPairArray2);
                iSerializer.putOptionalInt8VarArray(byArray);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void registerForCredentialUpdates(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalEnumVarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }
}

