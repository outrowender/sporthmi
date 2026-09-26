/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class VoiceGuidance_SetGet
implements SetGetProperty {
    public int voiceGuidance_State;
    private static final int VOICE_GUIDANCE_STATE_BITSIZE;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_FULL_COMPLETE_ANNOUNCEMENTS;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_OFF;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_REDUCED_ANNOUNCEMENTS_REDUCED_MODE;
    public static final int VOICE_GUIDANCE_STATE_VOICE_GUIDANCE_ON_REDUCED_ANNOUNCEMENT_TRAFFIC_DF4_1;

    public VoiceGuidance_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public VoiceGuidance_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.voiceGuidance_State = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        VoiceGuidance_SetGet voiceGuidance_SetGet = (VoiceGuidance_SetGet)bAPEntity;
        return this.voiceGuidance_State == voiceGuidance_SetGet.voiceGuidance_State;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VoiceGuidance_SetGet:");
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.voiceGuidance_State);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.voiceGuidance_State = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 36;
    }

    @Override
    public int getFunctionId() {
        return VoiceGuidance_SetGet.functionId();
    }
}

