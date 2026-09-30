/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.generalvehiclestates.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStates;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStatesC;
import de.esolutions.fw.comm.dsi.generalvehiclestates.DSIGeneralVehicleStatesReply;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.DSIGeneralVehicleStatesReplyService;
import de.esolutions.fw.comm.dsi.generalvehiclestates.impl.TLOInfoElementSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.generalvehiclestates.TLOInfoElement;

public class DSIGeneralVehicleStatesProxy
implements DSIGeneralVehicleStates,
DSIGeneralVehicleStatesC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.generalvehiclestates.DSIGeneralVehicleStates");
    private Proxy proxy;

    public DSIGeneralVehicleStatesProxy(int n, DSIGeneralVehicleStatesReply dSIGeneralVehicleStatesReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b42dbadf-a9fa-5690-a989-ecb909b18555", n, "9f1abdbc-e5ef-576b-8e65-c0aaee0e2484", "dsi.generalvehiclestates.DSIGeneralVehicleStates");
        DSIGeneralVehicleStatesReplyService dSIGeneralVehicleStatesReplyService = new DSIGeneralVehicleStatesReplyService(dSIGeneralVehicleStatesReply);
        this.proxy = new Proxy(serviceInstanceID, dSIGeneralVehicleStatesReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setDSSSKombiWarning(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    public void setTLOData(final int n, final int n2, final TLOInfoElement[] tLOInfoElementArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                TLOInfoElementSerializer.putOptionalTLOInfoElementVarArray(iSerializer, tLOInfoElementArray);
            }
        };
        this.proxy.remoteCallMethod((short)36, iSerializable);
    }

    public void setAppConnectState(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
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
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }
}

