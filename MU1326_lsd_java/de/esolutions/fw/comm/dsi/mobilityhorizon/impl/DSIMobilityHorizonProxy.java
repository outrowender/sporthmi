/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizon;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizonC;
import de.esolutions.fw.comm.dsi.mobilityhorizon.DSIMobilityHorizonReply;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.ConsumptionInfoSerializer;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.DSIMobilityHorizonReplyService;
import de.esolutions.fw.comm.dsi.mobilityhorizon.impl.MobilityHorizonLocationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.mobilityhorizon.ConsumptionInfo;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class DSIMobilityHorizonProxy
implements DSIMobilityHorizon,
DSIMobilityHorizonC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.mobilityhorizon.DSIMobilityHorizon");
    private Proxy proxy;

    public DSIMobilityHorizonProxy(int n, DSIMobilityHorizonReply dSIMobilityHorizonReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("10a21fa2-845e-5f9f-8283-ef042ff3cd6c", n, "5c4cdaf2-76e9-5a4d-980c-50fd93963747", "dsi.mobilityhorizon.DSIMobilityHorizon");
        DSIMobilityHorizonReplyService dSIMobilityHorizonReplyService = new DSIMobilityHorizonReplyService(dSIMobilityHorizonReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMobilityHorizonReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setConsumptionInfo(final ConsumptionInfo[] consumptionInfoArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ConsumptionInfoSerializer.putOptionalConsumptionInfoVarArray(iSerializer, consumptionInfoArray);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void setLocations(final MobilityHorizonLocation[] mobilityHorizonLocationArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MobilityHorizonLocationSerializer.putOptionalMobilityHorizonLocationVarArray(iSerializer, mobilityHorizonLocationArray);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void setConsideredLocationTypes(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void setDriveTrainMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void requestLocationRangeLevel(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)7, null);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }
}

