/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$VoiceGuidance
implements BAPEntity {
    private static final int RESERVED_BIT_3__7_BITSIZE;
    public boolean voiceGuidanceOnTrafficAvailable;
    public boolean voiceGuidanceOnReducedAvailable;
    public boolean voiceGuidanceOnAvailable;
    private static final int VOICE_GUIDANCE_BITSIZE;

    public FSG_Setup_Status$VoiceGuidance() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$VoiceGuidance(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.voiceGuidanceOnTrafficAvailable = false;
        this.voiceGuidanceOnReducedAvailable = false;
        this.voiceGuidanceOnAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$VoiceGuidance fSG_Setup_Status$VoiceGuidance = (FSG_Setup_Status$VoiceGuidance)bAPEntity;
        return this.voiceGuidanceOnTrafficAvailable == fSG_Setup_Status$VoiceGuidance.voiceGuidanceOnTrafficAvailable && this.voiceGuidanceOnReducedAvailable == fSG_Setup_Status$VoiceGuidance.voiceGuidanceOnReducedAvailable && this.voiceGuidanceOnAvailable == fSG_Setup_Status$VoiceGuidance.voiceGuidanceOnAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VoiceGuidance:");
        stringBuffer.append("\n - Bit 2: ");
        if (this.voiceGuidanceOnTrafficAvailable) {
            stringBuffer.append("true  (VoiceGuidance ON traffic (reduced announcement traffic) available");
        } else {
            stringBuffer.append("false  (VoiceGuidance ON traffic (reduced announcement traffic) (DF4.1) not available");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.voiceGuidanceOnReducedAvailable) {
            stringBuffer.append("true  (VoiceGuidance ON reduced (reduced announcements / reduced mode) available");
        } else {
            stringBuffer.append("false  (VoiceGuidance ON reduced (reduced announcements / reduced mode) not available");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.voiceGuidanceOnAvailable) {
            stringBuffer.append("true  (VoiceGuidance ON (full / complete announcements)  available");
        } else {
            stringBuffer.append("false  (VoiceGuidance ON (full / complete announcements) not available");
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
        bitStream.resetBits(5);
        bitStream.pushBoolean(this.voiceGuidanceOnTrafficAvailable);
        bitStream.pushBoolean(this.voiceGuidanceOnReducedAvailable);
        bitStream.pushBoolean(this.voiceGuidanceOnAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(5);
        this.voiceGuidanceOnTrafficAvailable = bitStream.popFrontBoolean();
        this.voiceGuidanceOnReducedAvailable = bitStream.popFrontBoolean();
        this.voiceGuidanceOnAvailable = bitStream.popFrontBoolean();
    }
}

