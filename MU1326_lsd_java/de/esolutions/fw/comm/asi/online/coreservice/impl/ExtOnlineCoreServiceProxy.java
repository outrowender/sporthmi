/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice.impl;

import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreService;
import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceC;
import de.esolutions.fw.comm.asi.online.coreservice.ExtOnlineCoreServiceReply;
import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceProxy$1;
import de.esolutions.fw.comm.asi.online.coreservice.impl.ExtOnlineCoreServiceReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
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

    @Override
    public void init(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void init(String string, String string2) {
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

    @Override
    public void registerService(String string, String string2, boolean bl) {
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

    @Override
    public void getServiceListEntry(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void precheckOnlineServiceServiceID(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void precheckOnlineService() {
        this.proxy.remoteCallMethod((short)26, null);
    }

    @Override
    public void requestUpdateKeyStore() {
        this.proxy.remoteCallMethod((short)14, null);
    }

    @Override
    public void getToken(String string, boolean bl) {
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

    @Override
    public void onlineRequest(RequestDescriptor requestDescriptor, int n, KeyValPair[] keyValPairArray, KeyValPair[] keyValPairArray2, byte[] byArray) {
        ExtOnlineCoreServiceProxy$1 extOnlineCoreServiceProxy$1 = new ExtOnlineCoreServiceProxy$1(this, requestDescriptor, n, keyValPairArray, keyValPairArray2, byArray);
        this.proxy.remoteCallMethod((short)10, extOnlineCoreServiceProxy$1);
    }

    @Override
    public void registerForCredentialUpdates(int[] nArray) {
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

