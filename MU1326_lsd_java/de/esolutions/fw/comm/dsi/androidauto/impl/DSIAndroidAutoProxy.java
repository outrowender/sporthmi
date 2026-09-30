/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAuto;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAutoC;
import de.esolutions.fw.comm.dsi.androidauto.DSIAndroidAutoReply;
import de.esolutions.fw.comm.dsi.androidauto.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.DSIAndroidAutoReplyService;
import de.esolutions.fw.comm.dsi.androidauto.impl.ResourceSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.ServiceConfigurationSerializer;
import de.esolutions.fw.comm.dsi.androidauto.impl.TouchEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ServiceConfiguration;
import org.dsi.ifc.androidauto.TouchEvent;

public class DSIAndroidAutoProxy
implements DSIAndroidAuto,
DSIAndroidAutoC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.androidauto.DSIAndroidAuto");
    private Proxy proxy;

    public DSIAndroidAutoProxy(int n, DSIAndroidAutoReply dSIAndroidAutoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("56c4920d-793f-525f-85a8-8f22d26bea9c", n, "c1be70e5-c44d-508b-a79a-90d0b4d8659a", "dsi.androidauto.DSIAndroidAuto");
        DSIAndroidAutoReplyService dSIAndroidAutoReplyService = new DSIAndroidAutoReplyService(dSIAndroidAutoReply);
        this.proxy = new Proxy(serviceInstanceID, dSIAndroidAutoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void startService(final ServiceConfiguration serviceConfiguration) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ServiceConfigurationSerializer.putOptionalServiceConfiguration(iSerializer, serviceConfiguration);
            }
        };
        this.proxy.remoteCallMethod((short)37, iSerializable);
    }

    public void postButtonEvent(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void postTouchEvent(final int n, final TouchEvent[] touchEventArray, final int n2, final int n3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                TouchEventSerializer.putOptionalTouchEventVarArray(iSerializer, touchEventArray);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void postRotaryEvent(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setMode(final Resource[] resourceArray, final AppState[] appStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceSerializer.putOptionalResourceVarArray(iSerializer, resourceArray);
                AppStateSerializer.putOptionalAppStateVarArray(iSerializer, appStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void responseModeChange(final Resource[] resourceArray, final AppState[] appStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceSerializer.putOptionalResourceVarArray(iSerializer, resourceArray);
                AppStateSerializer.putOptionalAppStateVarArray(iSerializer, appStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void requestNightMode(boolean bl) throws MethodException {
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)13, null);
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

