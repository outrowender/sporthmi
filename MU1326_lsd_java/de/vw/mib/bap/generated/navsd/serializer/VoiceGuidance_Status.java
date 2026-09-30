/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class VoiceGuidance_Status
implements StatusProperty {
    public int voiceGuidance_State;
    private static final int VOICE_GUIDANCE_STATE_BITSIZE = 8;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_FULL_COMPLETE_ANNOUNCEMENTS = 0;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_OFF = 1;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_REDUCED_ANNOUNCEMENTS_REDUCED_MODE = 2;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_REDUCED_ANNOUNCEMENT_TRAFFIC_DF4_1 = 3;

    public VoiceGuidance_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public VoiceGuidance_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.voiceGuidance_State = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        VoiceGuidance_Status voiceGuidance_Status = (VoiceGuidance_Status)bAPEntity;
        return this.voiceGuidance_State == voiceGuidance_Status.voiceGuidance_State;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VoiceGuidance_Status:");
        stringBuffer.append("\n - VoiceGuidance_State: ");
        switch (this.voiceGuidance_State) {
            case 0: {
                stringBuffer.append("0x00 (VoiceGuidance ON (full / complete announcements))");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (VoiceGuidance OFF)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (VoiceGuidance ON (reduced announcements / reduced mode))");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (VoiceGuidance ON (reduced announcement traffic) (DF4.1))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.voiceGuidance_State);
    }

    public void deserialize(BitStream bitStream) {
        this.voiceGuidance_State = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 36;
    }

    public int getFunctionId() {
        return VoiceGuidance_Status.functionId();
    }
}

