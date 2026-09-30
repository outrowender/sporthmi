/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carplay.DSICarplay;
import de.esolutions.fw.comm.dsi.carplay.DSICarplayC;
import de.esolutions.fw.comm.dsi.carplay.DSICarplayReply;
import de.esolutions.fw.comm.dsi.carplay.impl.AppStateRequestSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayReplyService;
import de.esolutions.fw.comm.dsi.carplay.impl.ResourceRequestSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.ResourceSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.ServiceConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carplay.impl.TouchEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public class DSICarplayProxy
implements DSICarplay,
DSICarplayC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carplay.DSICarplay");
    private Proxy proxy;

    public DSICarplayProxy(int n, DSICarplayReply dSICarplayReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b60ff3e0-c276-5843-8023-5aba5e2ac150", n, "44e3fa4c-73e2-5fd1-a140-725298101c75", "dsi.carplay.DSICarplay");
        DSICarplayReplyService dSICarplayReplyService = new DSICarplayReplyService(dSICarplayReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarplayReplyService, context);
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
        this.proxy.remoteCallMethod((short)46, iSerializable);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void postTouchEvent(final int n, final int n2, final TouchEvent[] touchEventArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                TouchEventSerializer.putOptionalTouchEventVarArray(iSerializer, touchEventArray);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void postRotaryEvent(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void postCharacterEvent(int n, String[] stringArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void requestModeChange(final ResourceRequest[] resourceRequestArray, final AppStateRequest[] appStateRequestArray, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceRequestSerializer.putOptionalResourceRequestVarArray(iSerializer, resourceRequestArray);
                AppStateRequestSerializer.putOptionalAppStateRequestVarArray(iSerializer, appStateRequestArray);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void responseUpdateMode(final Resource[] resourceArray, final AppState[] appStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceSerializer.putOptionalResourceVarArray(iSerializer, resourceArray);
                AppStateSerializer.putOptionalAppStateVarArray(iSerializer, appStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void responseBTDeactivation() throws MethodException {
        this.proxy.remoteCallMethod((short)12, null);
    }

    public void requestUI(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
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

    public void requestSIRIAction(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

    public void responseUpdateMainAudioType(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    public void requestUI2(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)14, null);
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
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }
}

