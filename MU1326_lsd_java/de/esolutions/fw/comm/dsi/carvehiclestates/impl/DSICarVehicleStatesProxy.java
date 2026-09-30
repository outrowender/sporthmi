/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carvehiclestates.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carvehiclestates.DSICarVehicleStates;
import de.esolutions.fw.comm.dsi.carvehiclestates.DSICarVehicleStatesC;
import de.esolutions.fw.comm.dsi.carvehiclestates.DSICarVehicleStatesReply;
import de.esolutions.fw.comm.dsi.carvehiclestates.impl.DSICarVehicleStatesReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSICarVehicleStatesProxy
implements DSICarVehicleStates,
DSICarVehicleStatesC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carvehiclestates.DSICarVehicleStates");
    private Proxy proxy;

    public DSICarVehicleStatesProxy(int n, DSICarVehicleStatesReply dSICarVehicleStatesReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("529dbcfc-8a30-59cd-9267-87ca78828718", n, "0d2c16a0-aed7-5c28-9333-eba1913d09ab", "dsi.carvehiclestates.DSICarVehicleStates");
        DSICarVehicleStatesReplyService dSICarVehicleStatesReplyService = new DSICarVehicleStatesReplyService(dSICarVehicleStatesReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarVehicleStatesReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setCarMenuState(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
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
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }
}

