/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound.impl;

import de.esolutions.fw.comm.asi.hmisync.sound.ASIHMISyncSoundReply;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeRange;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundShapeValue;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.SoundRangeSerializer;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.SoundShapeRangeSerializer;
import de.esolutions.fw.comm.asi.hmisync.sound.impl.SoundShapeValueSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncSoundReplyProxy
implements ASIHMISyncSoundReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.sound.ASIHMISyncSound");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncSoundReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("7ba5c63b-4ccf-465c-abe4-f731a4967351", -1, "da12fd01-0f0a-58b3-ba2e-73b6664e9062", "asi.hmisync.sound.ASIHMISyncSound");
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
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)27, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)26, iSerializable);
    }

    public void updateSoundState(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)28, iSerializable);
    }

    public void updateAmplifier(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void updateBassRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void updateBassValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void updateTrebleRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)33, iSerializable);
    }

    public void updateTrebleValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void updateBalanceRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void updateBalanceValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void updateFaderRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void updateFaderValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updateSubwooferRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)29, iSerializable);
    }

    public void updateSubwooferValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)30, iSerializable);
    }

    public void updateSurroundRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)31, iSerializable);
    }

    public void updateSurroundValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void updateNoiseCompensationRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)22, iSerializable);
    }

    public void updateNoiseCompensationValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)23, iSerializable);
    }

    public void updateThreeDModeRange(final SoundRange soundRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundRangeSerializer.putOptionalSoundRange(iSerializer, soundRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)39, iSerializable);
    }

    public void updateThreeDModeValue(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)40, iSerializable);
    }

    public void updateSoundShapeRange(final SoundShapeRange soundShapeRange, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundShapeRangeSerializer.putOptionalSoundShapeRange(iSerializer, soundShapeRange);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)42, iSerializable);
    }

    public void updateSoundShapeValue(final SoundShapeValue soundShapeValue, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SoundShapeValueSerializer.putOptionalSoundShapeValue(iSerializer, soundShapeValue);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)43, iSerializable);
    }

    public void updatePresetPositionList(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void updatePresetPosition(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)24, iSerializable);
    }

    public void updatePresetEQList(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)38, iSerializable);
    }

    public void updatePresetEQ(final int n, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)37, iSerializable);
    }
}

