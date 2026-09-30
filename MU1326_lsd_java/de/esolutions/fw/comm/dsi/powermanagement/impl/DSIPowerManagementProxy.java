/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.powermanagement.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.powermanagement.DSIPowerManagement;
import de.esolutions.fw.comm.dsi.powermanagement.DSIPowerManagementC;
import de.esolutions.fw.comm.dsi.powermanagement.DSIPowerManagementReply;
import de.esolutions.fw.comm.dsi.powermanagement.impl.DSIPowerManagementReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIPowerManagementProxy
implements DSIPowerManagement,
DSIPowerManagementC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.powermanagement.DSIPowerManagement");
    private Proxy proxy;

    public DSIPowerManagementProxy(int n, DSIPowerManagementReply dSIPowerManagementReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("61e1c5fa-94ae-558d-afb5-945bc71781da", n, "9e7a46a4-594a-549f-a3ef-11ea5b2199fe", "dsi.powermanagement.DSIPowerManagement");
        DSIPowerManagementReplyService dSIPowerManagementReplyService = new DSIPowerManagementReplyService(dSIPowerManagementReply);
        this.proxy = new Proxy(serviceInstanceID, dSIPowerManagementReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setHMIReady() throws MethodException {
        this.proxy.remoteCallMethod((short)7, null);
    }

    public void rebootSystem() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void displayReady() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
    }

    public void rebootSystemCritical() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
    }

    public void setChildLockRSE(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setLastOn(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
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
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }
}

