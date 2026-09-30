/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybrid;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybridC;
import de.esolutions.fw.comm.dsi.carhybrid.DSICarHybridReply;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA0Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA1Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRA2Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlPowerProviderRAESerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA0Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA1Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA2Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA3Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA4Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA5Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA6Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfileRA7Serializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProfilesAHSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlProgrammedTimerSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.BatteryControlWeekdaysSerializer;
import de.esolutions.fw.comm.dsi.carhybrid.impl.DSICarHybridReplyService;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class DSICarHybridProxy
implements DSICarHybrid,
DSICarHybridC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carhybrid.DSICarHybrid");
    private Proxy proxy;

    public DSICarHybridProxy(int n, DSICarHybridReply dSICarHybridReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("9944bcd7-b459-5760-a9db-0c4cfcdff553", n, "78efa6f4-d9c1-5ee2-ae03-237bc421fed4", "dsi.carhybrid.DSICarHybrid");
        DSICarHybridReplyService dSICarHybridReplyService = new DSICarHybridReplyService(dSICarHybridReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarHybridReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setBatteryControlImmediately(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)68, genericSerializable);
    }

    public void setBatteryControlTimerState(final BatteryControlProgrammedTimer batteryControlProgrammedTimer) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProgrammedTimerSerializer.putOptionalBatteryControlProgrammedTimer(iSerializer, batteryControlProgrammedTimer);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void setBatteryControlTimer(final int n, final int n2, final int n3, final int n4, final int n5, final int n6, final BatteryControlWeekdays batteryControlWeekdays, final int n7) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
                iSerializer.putInt32(n4);
                iSerializer.putInt32(n5);
                iSerializer.putInt32(n6);
                BatteryControlWeekdaysSerializer.putOptionalBatteryControlWeekdays(iSerializer, batteryControlWeekdays);
                iSerializer.putInt32(n7);
            }
        };
        this.proxy.remoteCallMethod((short)83, iSerializable);
    }

    public void setBatteryControlSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)26, null);
    }

    public void setHybridTargetRange(short s, int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)104, genericSerializable);
    }

    public void setHybridEnergyAssistControl(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)119, genericSerializable);
    }

    public void requestBatteryControlProfileList(final BatteryControlProfilesAH batteryControlProfilesAH) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
            }
        };
        this.proxy.remoteCallMethod((short)131, iSerializable);
    }

    public void setBatteryControlProfileListRA0(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA0[] batteryControlProfileRA0Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA0Serializer.putOptionalBatteryControlProfileRA0VarArray(iSerializer, batteryControlProfileRA0Array);
            }
        };
        this.proxy.remoteCallMethod((short)151, iSerializable);
    }

    public void setBatteryControlProfileListRA1(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA1[] batteryControlProfileRA1Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA1Serializer.putOptionalBatteryControlProfileRA1VarArray(iSerializer, batteryControlProfileRA1Array);
            }
        };
        this.proxy.remoteCallMethod((short)152, iSerializable);
    }

    public void setBatteryControlProfileListRA2(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA2[] batteryControlProfileRA2Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA2Serializer.putOptionalBatteryControlProfileRA2VarArray(iSerializer, batteryControlProfileRA2Array);
            }
        };
        this.proxy.remoteCallMethod((short)153, iSerializable);
    }

    public void setBatteryControlProfileListRA3(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA3[] batteryControlProfileRA3Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA3Serializer.putOptionalBatteryControlProfileRA3VarArray(iSerializer, batteryControlProfileRA3Array);
            }
        };
        this.proxy.remoteCallMethod((short)154, iSerializable);
    }

    public void setBatteryControlProfileListRA4(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA4[] batteryControlProfileRA4Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA4Serializer.putOptionalBatteryControlProfileRA4VarArray(iSerializer, batteryControlProfileRA4Array);
            }
        };
        this.proxy.remoteCallMethod((short)155, iSerializable);
    }

    public void setBatteryControlProfileListRA5(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA5[] batteryControlProfileRA5Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA5Serializer.putOptionalBatteryControlProfileRA5VarArray(iSerializer, batteryControlProfileRA5Array);
            }
        };
        this.proxy.remoteCallMethod((short)156, iSerializable);
    }

    public void setBatteryControlProfileListRA6(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA6[] batteryControlProfileRA6Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA6Serializer.putOptionalBatteryControlProfileRA6VarArray(iSerializer, batteryControlProfileRA6Array);
            }
        };
        this.proxy.remoteCallMethod((short)157, iSerializable);
    }

    public void setBatteryControlProfileListRA7(final BatteryControlProfilesAH batteryControlProfilesAH, final BatteryControlProfileRA7[] batteryControlProfileRA7Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                BatteryControlProfileRA7Serializer.putOptionalBatteryControlProfileRA7VarArray(iSerializer, batteryControlProfileRA7Array);
            }
        };
        this.proxy.remoteCallMethod((short)158, iSerializable);
    }

    public void setBatteryControlProfileListRAF(final BatteryControlProfilesAH batteryControlProfilesAH, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlProfilesAHSerializer.putOptionalBatteryControlProfilesAH(iSerializer, batteryControlProfilesAH);
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)159, iSerializable);
    }

    public void setBatteryControlPowerProviderRA0(final BatteryControlPowerProviderAH batteryControlPowerProviderAH, final BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, batteryControlPowerProviderAH);
                BatteryControlPowerProviderRA0Serializer.putOptionalBatteryControlPowerProviderRA0VarArray(iSerializer, batteryControlPowerProviderRA0Array);
            }
        };
        this.proxy.remoteCallMethod((short)146, iSerializable);
    }

    public void setBatteryControlPowerProviderRA1(final BatteryControlPowerProviderAH batteryControlPowerProviderAH, final BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, batteryControlPowerProviderAH);
                BatteryControlPowerProviderRA1Serializer.putOptionalBatteryControlPowerProviderRA1VarArray(iSerializer, batteryControlPowerProviderRA1Array);
            }
        };
        this.proxy.remoteCallMethod((short)147, iSerializable);
    }

    public void setBatteryControlPowerProviderRA2(final BatteryControlPowerProviderAH batteryControlPowerProviderAH, final BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, batteryControlPowerProviderAH);
                BatteryControlPowerProviderRA2Serializer.putOptionalBatteryControlPowerProviderRA2VarArray(iSerializer, batteryControlPowerProviderRA2Array);
            }
        };
        this.proxy.remoteCallMethod((short)148, iSerializable);
    }

    public void setBatteryControlPowerProviderRAE(final BatteryControlPowerProviderAH batteryControlPowerProviderAH, final BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, batteryControlPowerProviderAH);
                BatteryControlPowerProviderRAESerializer.putOptionalBatteryControlPowerProviderRAEVarArray(iSerializer, batteryControlPowerProviderRAEArray);
            }
        };
        this.proxy.remoteCallMethod((short)149, iSerializable);
    }

    public void setBatteryControlPowerProviderRAF(final BatteryControlPowerProviderAH batteryControlPowerProviderAH, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, batteryControlPowerProviderAH);
                iSerializer.putOptionalInt32VarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)150, iSerializable);
    }

    public void requestBatteryControlPowerProviderList(final BatteryControlPowerProviderAH batteryControlPowerProviderAH) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BatteryControlPowerProviderAHSerializer.putOptionalBatteryControlPowerProviderAH(iSerializer, batteryControlPowerProviderAH);
            }
        };
        this.proxy.remoteCallMethod((short)130, iSerializable);
    }

    public void setBatteryControlPastErrorReason(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)113, genericSerializable);
    }

    public void setBatteryControlRemainingChargeTime(int n, short s, int n2, short s2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt16(s2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)118, genericSerializable);
    }

    public void setHybridActivePedal(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)160, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)29, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)51, genericSerializable);
    }
}

