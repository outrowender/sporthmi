/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficLightInfo;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficLightInfoC;
import de.esolutions.fw.comm.dsi.online.DSIOnlineTrafficLightInfoReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIOnlineTrafficLightInfoReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIOnlineTrafficLightInfoProxy
implements DSIOnlineTrafficLightInfo,
DSIOnlineTrafficLightInfoC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.online.DSIOnlineTrafficLightInfo");
    private Proxy proxy;

    public DSIOnlineTrafficLightInfoProxy(int n, DSIOnlineTrafficLightInfoReply dSIOnlineTrafficLightInfoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1817f3af-6d77-5567-be24-fef71392bf1c", n, "7a038976-6dcc-5132-bd8b-3fd9c5196d35", "dsi.online.DSIOnlineTrafficLightInfo");
        DSIOnlineTrafficLightInfoReplyService dSIOnlineTrafficLightInfoReplyService = new DSIOnlineTrafficLightInfoReplyService(dSIOnlineTrafficLightInfoReply);
        this.proxy = new Proxy(serviceInstanceID, dSIOnlineTrafficLightInfoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)1, null);
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

