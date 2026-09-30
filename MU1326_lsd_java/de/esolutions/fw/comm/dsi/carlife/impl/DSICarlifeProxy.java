/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carlife.DSICarlife;
import de.esolutions.fw.comm.dsi.carlife.DSICarlifeC;
import de.esolutions.fw.comm.dsi.carlife.DSICarlifeReply;
import de.esolutions.fw.comm.dsi.carlife.impl.AppStateSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.DSICarlifeReplyService;
import de.esolutions.fw.comm.dsi.carlife.impl.ResourceSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.ServiceConfigurationSerializer;
import de.esolutions.fw.comm.dsi.carlife.impl.TouchEventSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.ServiceConfiguration;
import org.dsi.ifc.carlife.TouchEvent;

public class DSICarlifeProxy
implements DSICarlife,
DSICarlifeC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carlife.DSICarlife");
    private Proxy proxy;

    public DSICarlifeProxy(int n, DSICarlifeReply dSICarlifeReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("cb507d49-a334-5d1c-a54e-98b3813496f3", n, "d18a17d8-40d1-5e95-ae5e-3766d4fdba21", "dsi.carlife.DSICarlife");
        DSICarlifeReplyService dSICarlifeReplyService = new DSICarlifeReplyService(dSICarlifeReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarlifeReplyService, context);
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
        this.proxy.remoteCallMethod((short)16, iSerializable);
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

    public void postTouchEvent(final int n, final TouchEvent[] touchEventArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                TouchEventSerializer.putOptionalTouchEventVarArray(iSerializer, touchEventArray);
                iSerializer.putInt32(n2);
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

    public void setMode(final Resource[] resourceArray, final AppState[] appStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceSerializer.putOptionalResourceVarArray(iSerializer, resourceArray);
                AppStateSerializer.putOptionalAppStateVarArray(iSerializer, appStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void requestNightMode(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void responseModeChange(final Resource[] resourceArray, final AppState[] appStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceSerializer.putOptionalResourceVarArray(iSerializer, resourceArray);
                AppStateSerializer.putOptionalAppStateVarArray(iSerializer, appStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }
}

