/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSync;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSyncC;
import de.esolutions.fw.comm.dsi.kombisync2.DSIKombiSyncReply;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DSIKombiSyncReplyService;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayIdentificationSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayRequestResponseSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.DisplayStatusSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.MenuStateSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupActionRequestResponseSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupRegisterRequestResponseSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupStatusSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombisync2.DisplayIdentification;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.DisplayStatus;
import org.dsi.ifc.kombisync2.MenuState;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatus;

public class DSIKombiSyncProxy
implements DSIKombiSync,
DSIKombiSyncC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombisync2.DSIKombiSync");
    private Proxy proxy;

    public DSIKombiSyncProxy(int n, DSIKombiSyncReply dSIKombiSyncReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6bda2552-d7b7-52c8-947c-ac3ec12ded8c", n, "a7f6ba8f-bf72-5749-a74f-39e04ad0dd56", "dsi.kombisync2.DSIKombiSync");
        DSIKombiSyncReplyService dSIKombiSyncReplyService = new DSIKombiSyncReplyService(dSIKombiSyncReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKombiSyncReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setMMIDisplayRequestResponse(final DisplayRequestResponse displayRequestResponse) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DisplayRequestResponseSerializer.putOptionalDisplayRequestResponse(iSerializer, displayRequestResponse);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void setMMIDisplayStatus(final DisplayStatus displayStatus) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DisplayStatusSerializer.putOptionalDisplayStatus(iSerializer, displayStatus);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void setMenuState(final MenuState menuState) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MenuStateSerializer.putOptionalMenuState(iSerializer, menuState);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void setMMIPopupRegisterRequest(final PopupRegisterRequestResponse popupRegisterRequestResponse) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PopupRegisterRequestResponseSerializer.putOptionalPopupRegisterRequestResponse(iSerializer, popupRegisterRequestResponse);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void setMMIPopupActionResponse(final PopupActionRequestResponse popupActionRequestResponse) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PopupActionRequestResponseSerializer.putOptionalPopupActionRequestResponse(iSerializer, popupActionRequestResponse);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void setMMIPopupStatus(final PopupStatus popupStatus) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PopupStatusSerializer.putOptionalPopupStatus(iSerializer, popupStatus);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void setMMIDisplayIdentification(final DisplayIdentification displayIdentification) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DisplayIdentificationSerializer.putOptionalDisplayIdentification(iSerializer, displayIdentification);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void setHMIIsReady(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)18, null);
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
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }
}

