/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carauxheatercooler.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCooler;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCoolerC;
import de.esolutions.fw.comm.dsi.carauxheatercooler.DSICarAuxHeaterCoolerReply;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerExtendedConditioningSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.AuxHeaterCoolerTimerSerializer;
import de.esolutions.fw.comm.dsi.carauxheatercooler.impl.DSICarAuxHeaterCoolerReplyService;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;

public class DSICarAuxHeaterCoolerProxy
implements DSICarAuxHeaterCooler,
DSICarAuxHeaterCoolerC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carauxheatercooler.DSICarAuxHeaterCooler");
    private Proxy proxy;

    public DSICarAuxHeaterCoolerProxy(int n, DSICarAuxHeaterCoolerReply dSICarAuxHeaterCoolerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b8841165-76a0-5918-9127-09550decc09b", n, "4b52ea2b-e87d-526f-bc2b-ce1fcada6f92", "dsi.carauxheatercooler.DSICarAuxHeaterCooler");
        DSICarAuxHeaterCoolerReplyService dSICarAuxHeaterCoolerReplyService = new DSICarAuxHeaterCoolerReplyService(dSICarAuxHeaterCoolerReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarAuxHeaterCoolerReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setAuxHeaterCoolerOnOff(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void setAuxHeaterCoolerRunningTime(short s) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setAuxHeaterCoolerMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    public void setAuxHeaterCoolerDefaultStartMode(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setAuxHeaterCoolerEngineHeater(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setAuxHeaterCoolerActiveTimer(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void setAuxHeaterCoolerTimer1(final AuxHeaterCoolerTimer auxHeaterCoolerTimer) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AuxHeaterCoolerTimerSerializer.putOptionalAuxHeaterCoolerTimer(iSerializer, auxHeaterCoolerTimer);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void setAuxHeaterCoolerTimer2(final AuxHeaterCoolerTimer auxHeaterCoolerTimer) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AuxHeaterCoolerTimerSerializer.putOptionalAuxHeaterCoolerTimer(iSerializer, auxHeaterCoolerTimer);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void setAuxHeaterCoolerTimer3(final AuxHeaterCoolerTimer auxHeaterCoolerTimer) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AuxHeaterCoolerTimerSerializer.putOptionalAuxHeaterCoolerTimer(iSerializer, auxHeaterCoolerTimer);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void setAuxHeaterCoolerPopup(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    public void setAuxHeaterSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)14, null);
    }

    public void setAuxHeaterCoolerExtendedConditioning(final AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AuxHeaterCoolerExtendedConditioningSerializer.putOptionalAuxHeaterCoolerExtendedConditioning(iSerializer, auxHeaterCoolerExtendedConditioning);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void setAuxHeaterCoolerWindowHeating(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

    public void setAuxHeaterCoolerUnlockClimating(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)41, genericSerializable);
    }

    public void setAuxHeaterCoolerTargetTemperature(float f2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)40, genericSerializable);
    }

    public void setAuxHeaterCoolerAirQuality(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)15, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }
}

