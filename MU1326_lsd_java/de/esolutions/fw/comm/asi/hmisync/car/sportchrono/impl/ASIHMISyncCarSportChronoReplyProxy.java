/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl;

import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChronoReply;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.RecordingRange;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapData;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.SCRefLapHeader;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.TransferState;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.RecordingRangeSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCHeaderSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCRefLapDataSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.SCRefLapHeaderSerializer;
import de.esolutions.fw.comm.asi.hmisync.car.sportchrono.impl.TransferStateSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncCarSportChronoReplyProxy
implements ASIHMISyncCarSportChronoReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncCarSportChronoReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("38295c72-4d73-4857-919d-548f4e0abbdd", -1, "98008024-b4e6-5a1f-8cf9-1c1a2dc9dad6", "asi.hmisync.car.sportchrono.ASIHMISyncCarSportChrono");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseRecordData(final SCData[] sCDataArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SCDataSerializer.putOptionalSCDataVarArray(iSerializer, sCDataArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void responseTrackData(final int n, final SCData[] sCDataArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SCDataSerializer.putOptionalSCDataVarArray(iSerializer, sCDataArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void responseInitTrackTransfer(final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void responseSetTrackData(final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void responseSetReferenceLap(final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void responseReferenceLapData(final int n, final SCRefLapData[] sCRefLapDataArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                SCRefLapDataSerializer.putOptionalSCRefLapDataVarArray(iSerializer, sCRefLapDataArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void responseSaveReferenceLap(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void updateSCVisibilityState(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updateActiveRecord(final SCHeader sCHeader, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SCHeaderSerializer.putOptionalSCHeader(iSerializer, sCHeader);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void updateActiveRecordData(final SCData sCData, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SCDataSerializer.putOptionalSCData(iSerializer, sCData);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void updateRecordMode(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void updateTrackList(final SCHeader[] sCHeaderArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SCHeaderSerializer.putOptionalSCHeaderVarArray(iSerializer, sCHeaderArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void updateTransferState(final TransferState transferState, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                TransferStateSerializer.putOptionalTransferState(iSerializer, transferState);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void updateRecordingTime(final long l, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void updateRecordingRange(final RecordingRange recordingRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RecordingRangeSerializer.putOptionalRecordingRange(iSerializer, recordingRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void updateSelectedReferenceLapUid(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)33, iSerializable);
    }

    public void updateReferenceLapList(final SCRefLapHeader[] sCRefLapHeaderArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SCRefLapHeaderSerializer.putOptionalSCRefLapHeaderVarArray(iSerializer, sCRefLapHeaderArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }
}

