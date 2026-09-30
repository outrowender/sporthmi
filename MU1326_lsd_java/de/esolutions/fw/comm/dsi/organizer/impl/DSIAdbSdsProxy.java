/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSds;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSdsC;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbSdsReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbSdsReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIAdbSdsProxy
implements DSIAdbSds,
DSIAdbSdsC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.organizer.DSIAdbSds");
    private Proxy proxy;

    public DSIAdbSdsProxy(int n, DSIAdbSdsReply dSIAdbSdsReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("95866028-7a0c-5fd7-aa0f-56a04dc56422", n, "53f55b6e-b9b1-5a20-9897-4f5d8edf3bce", "dsi.organizer.DSIAdbSds");
        DSIAdbSdsReplyService dSIAdbSdsReplyService = new DSIAdbSdsReplyService(dSIAdbSdsReply);
        this.proxy = new Proxy(serviceInstanceID, dSIAdbSdsReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void getAllVoiceTags() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void deleteVoiceTags(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }
}

