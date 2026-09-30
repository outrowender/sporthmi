/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.bc.impl;

import de.esolutions.fw.comm.asi.hmisync.car.FloatBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.bc.ASIHMISyncCarBordComputerReply;
import de.esolutions.fw.comm.asi.hmisync.car.bc.BCTermGeneralData;
import de.esolutions.fw.comm.asi.hmisync.car.bc.impl.BCTermGeneralDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.impl.FloatBaseTypeSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarBordComputerReplyProxy
implements ASIHMISyncCarBordComputerReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncCarBordComputerReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6d65ca53-0148-4329-8b3c-e8cd1fbade7a", -1, "d1b91a1b-f081-5c4c-bc68-8c00a93879a4", "asi.hmisync.car.bc.ASIHMISyncCarBordComputer");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void updateBCShortTermAverageConsumption1Visibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void updateBCShortTermAverageConsumption1(final FloatBaseType floatBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, floatBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void updateBCShortTermAverageConsumption2Visibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void updateBCShortTermAverageConsumption2(final FloatBaseType floatBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, floatBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void updateBCLongTermAverageConsumption1Visibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void updateBCLongTermAverageConsumption1(final FloatBaseType floatBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, floatBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void updateBCLongTermAverageConsumption2Visibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void updateBCLongTermAverageConsumption2(final FloatBaseType floatBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                FloatBaseTypeSerializer.putOptionalFloatBaseType(iSerializer, floatBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void updateBCCurrentRange1Visibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void updateBCCurrentRange1(final IntBaseType intBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, intBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void updateBCCurrentRange2Visibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void updateBCCurrentRange2(final IntBaseType intBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, intBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void updateBCShortTermGeneralVisibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void updateBCShortTermGeneral(final BCTermGeneralData bCTermGeneralData, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCTermGeneralDataSerializer.putOptionalBCTermGeneralData(iSerializer, bCTermGeneralData);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updateBCLongTermGeneralVisibility(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void updateBCLongTermGeneral(final BCTermGeneralData bCTermGeneralData, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCTermGeneralDataSerializer.putOptionalBCTermGeneralData(iSerializer, bCTermGeneralData);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }
}

