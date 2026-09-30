/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.radio.impl;

import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.CurrentStationSerializer;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.StationInfoSerializer;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.WavebandInfoSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncRadioReplyProxy
implements ASIHMISyncRadioReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.radio.ASIHMISyncRadio");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncRadioReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("c43514a0-a79e-4e4d-905c-816fe72baa19", -1, "5825259e-363b-5404-81a4-012a1205c9db", "asi.hmisync.radio.ASIHMISyncRadio");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void stationDetailsUpdated(final CurrentStation[] currentStationArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CurrentStationSerializer.putOptionalCurrentStationVarArray(iSerializer, currentStationArray);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void updateBandList(final int[] nArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt32VarArray(nArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void updateActiveBand(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void updateRadioStationList(final StationInfo[] stationInfoArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                StationInfoSerializer.putOptionalStationInfoVarArray(iSerializer, stationInfoArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void updateActiveStation(final CurrentStation currentStation, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CurrentStationSerializer.putOptionalCurrentStation(iSerializer, currentStation);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updateSeekStatus(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void updateWavebands(final WavebandInfo[] wavebandInfoArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                WavebandInfoSerializer.putOptionalWavebandInfoVarArray(iSerializer, wavebandInfoArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }
}

