/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.climate.impl;

import de.esolutions.fw.comm.asi.hmisync.car.IntBaseType;
import de.esolutions.fw.comm.asi.hmisync.car.climate.ASIHMISyncCarClimateReply;
import de.esolutions.fw.comm.asi.hmisync.car.impl.IntBaseTypeSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarClimateReplyProxy
implements ASIHMISyncCarClimateReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.climate.ASIHMISyncCarClimate");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncCarClimateReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5ffc8a82-9fd6-4d5f-9e5b-b7d05d798bc3", -1, "b433dc69-1912-5b9a-900b-83fe40f977cc", "asi.hmisync.car.climate.ASIHMISyncCarClimate");
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
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void updateAirconTempZone1(final IntBaseType intBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, intBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void updateAirconTempZone2(final IntBaseType intBaseType, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                IntBaseTypeSerializer.putOptionalIntBaseType(iSerializer, intBaseType);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void updateAirconMaxAC(final boolean bl, final boolean bl2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }
}

