/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSync;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSyncC;
import de.esolutions.fw.comm.dsi.kombisync.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync.impl.DSIKombiSyncReplyService;
import de.esolutions.fw.comm.dsi.kombisync.impl.MMIDisplayRequestSerializer;
import de.esolutions.fw.comm.dsi.kombisync.impl.MMIDisplayStatusSerializer;
import de.esolutions.fw.comm.dsi.kombisync.impl.MMIPopupRequestSerializer;
import de.esolutions.fw.comm.dsi.kombisync.impl.MenuStateSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MMIPopupRequest;
import org.dsi.ifc.kombisync.MenuState;

public class DSIKombiSyncProxy
implements DSIKombiSync,
DSIKombiSyncC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombisync.DSIKombiSync");
    private Proxy proxy;

    public DSIKombiSyncProxy(int n, DSIKombiSyncReply dSIKombiSyncReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("10fe841e-7d8c-5802-8d40-e4219083c9e7", n, "d02e08c1-ad26-5243-b8ad-ac9dfee27dca", "dsi.kombisync.DSIKombiSync");
        DSIKombiSyncReplyService dSIKombiSyncReplyService = new DSIKombiSyncReplyService(dSIKombiSyncReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKombiSyncReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setMMIDisplayStatus(final MMIDisplayStatus mMIDisplayStatus) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MMIDisplayStatusSerializer.putOptionalMMIDisplayStatus(iSerializer, mMIDisplayStatus);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void setMMIDisplayRequest(final MMIDisplayRequest mMIDisplayRequest) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MMIDisplayRequestSerializer.putOptionalMMIDisplayRequest(iSerializer, mMIDisplayRequest);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void setMenuState(final MenuState menuState) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MenuStateSerializer.putOptionalMenuState(iSerializer, menuState);
            }
        };
        this.proxy.remoteCallMethod((short)41, iSerializable);
    }

    public void setMMIPopupRequest(final MMIPopupRequest mMIPopupRequest) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MMIPopupRequestSerializer.putOptionalMMIPopupRequest(iSerializer, mMIPopupRequest);
            }
        };
        this.proxy.remoteCallMethod((short)40, iSerializable);
    }

    public void setHMIIsReady(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)12, null);
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
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }
}

