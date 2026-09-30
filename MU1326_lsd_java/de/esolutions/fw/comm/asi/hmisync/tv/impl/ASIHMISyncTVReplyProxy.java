/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv.impl;

import de.esolutions.fw.comm.asi.hmisync.tv.ASIHMISyncTVReply;
import de.esolutions.fw.comm.asi.hmisync.tv.ActiveStationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.KeySet;
import de.esolutions.fw.comm.asi.hmisync.tv.ParentalSettings;
import de.esolutions.fw.comm.asi.hmisync.tv.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ActiveStationInfoSerializer;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.KeySetSerializer;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.ParentalSettingsSerializer;
import de.esolutions.fw.comm.asi.hmisync.tv.impl.StationInfoSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncTVReplyProxy
implements ASIHMISyncTVReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.tv.ASIHMISyncTV");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncTVReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f3fc2e4b-d25f-4479-9da4-6be3da7c1a1e", -1, "7b078b73-244f-5129-b88a-1c945501d223", "asi.hmisync.tv.ASIHMISyncTV");
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
        this.proxy.remoteCallMethod((short)12, iSerializable);
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

    public void updateStationInfo(final StationInfo[] stationInfoArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                StationInfoSerializer.putOptionalStationInfoVarArray(iSerializer, stationInfoArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void updateActiveStationInfo(final ActiveStationInfo activeStationInfo, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ActiveStationInfoSerializer.putOptionalActiveStationInfo(iSerializer, activeStationInfo);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updateActiveTVStationState(final long l, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void updateTunerConfig(final long l, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void updatePanelKeySet(final KeySet[] keySetArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                KeySetSerializer.putOptionalKeySetVarArray(iSerializer, keySetArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void updateSeekStatus(final byte by, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt8(by);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void updateTerminalMode(final byte by, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt8(by);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void updateParentalSettings(final ParentalSettings parentalSettings, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ParentalSettingsSerializer.putOptionalParentalSettings(iSerializer, parentalSettings);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }
}

