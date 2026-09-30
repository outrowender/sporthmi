/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTraffic;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficC;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineTrafficReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIOnlineTrafficProxy
implements DSIOnlineTraffic,
DSIOnlineTrafficC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.online.DSIOnlineTraffic");
    private Proxy proxy;

    public DSIOnlineTrafficProxy(int n, DSIOnlineTrafficReply dSIOnlineTrafficReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("12bc15c1-5424-583d-92e1-5442fafc4f7f", n, "f3a652c2-a019-53a6-b8d4-710ffeff48f3", "dsi.online.DSIOnlineTraffic");
        DSIOnlineTrafficReplyService dSIOnlineTrafficReplyService = new DSIOnlineTrafficReplyService(dSIOnlineTrafficReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOnlineTrafficReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setOnlineTrafficDataStatus(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void getNewData() throws MethodException {
        this.proxy.remoteCallMethod((short)12, null);
    }

    public void setNewData(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void setTimeoutForFallback(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setNewSession() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
    }

    public void getNewFCDInformation() throws MethodException {
        this.proxy.remoteCallMethod((short)15, null);
    }

    public void getInventory() throws MethodException {
        this.proxy.remoteCallMethod((short)14, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)6, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)0, null);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }
}

