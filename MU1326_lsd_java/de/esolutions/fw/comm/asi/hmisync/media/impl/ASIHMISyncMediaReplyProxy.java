/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaActiveSourceState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlayTime;
import de.esolutions.fw.comm.asi.hmisync.media.MediaPlaylistState;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaActiveSourceStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaEntrySerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaPlayTimeSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaPlaylistStateSerializer;
import de.esolutions.fw.comm.asi.hmisync.media.impl.MediaSourceSlotSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaReplyProxy
implements ASIHMISyncMediaReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.media.ASIHMISyncMedia");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncMediaReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("d4078ff5-09f8-41d6-bc52-9680f105aea0", -1, "bfc935bd-08a4-581a-85b9-c997454d068b", "asi.hmisync.media.ASIHMISyncMedia");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void indicationCmdBlocked(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void responsePlayList(final boolean bl, final int n, final MediaEntry[] mediaEntryArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putInt32(n);
                MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, mediaEntryArray);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void responseSetPlaySelection(final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void responsePlayMoreFrom(final long l, final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt64(l);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void updateSourceList(final MediaSourceSlot[] mediaSourceSlotArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaSourceSlotSerializer.putOptionalMediaSourceSlotVarArray(iSerializer, mediaSourceSlotArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)30, iSerializable);
    }

    public void updateActiveSlotState(final MediaActiveSourceState mediaActiveSourceState, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaActiveSourceStateSerializer.putOptionalMediaActiveSourceState(iSerializer, mediaActiveSourceState);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void updatePlaybackState(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void updateListState(final MediaPlaylistState mediaPlaylistState, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaPlaylistStateSerializer.putOptionalMediaPlaylistState(iSerializer, mediaPlaylistState);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void updatePlayerCapabilities(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void updateMix(final boolean bl, final boolean bl2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void updateRepeatTitle(final boolean bl, final boolean bl2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void updateRepeatState(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)41, iSerializable);
    }

    public void updateShuffleState(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)42, iSerializable);
    }

    public void updatePlayingTrack(final MediaEntry mediaEntry, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaEntrySerializer.putOptionalMediaEntry(iSerializer, mediaEntry);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void updatePlayPosition(final MediaPlayTime mediaPlayTime, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaPlayTimeSerializer.putOptionalMediaPlayTime(iSerializer, mediaPlayTime);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void updatePlaybackFolder(final MediaEntry[] mediaEntryArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                MediaEntrySerializer.putOptionalMediaEntryVarArray(iSerializer, mediaEntryArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void updatePlaybackPossible(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)37, iSerializable);
    }
}

