/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class Phonebook_Data$VoiceTag
implements BAPEntity {
    public boolean voiceTagAvailable;
    private static final int VOICE_TAG_BITSIZE;
    private static final int VOICE_TAG_NOT_DEFINED_BITSIZE;

    public Phonebook_Data$VoiceTag() {
        this.internalReset();
        this.customInitialization();
    }

    public Phonebook_Data$VoiceTag(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.voiceTagAvailable = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        Phonebook_Data$VoiceTag phonebook_Data$VoiceTag = (Phonebook_Data$VoiceTag)bAPEntity;
        return this.voiceTagAvailable == phonebook_Data$VoiceTag.voiceTagAvailable;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VoiceTag:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.voiceTagAvailable) {
            stringBuffer.append("true  (voice tag available");
        } else {
            stringBuffer.append("false  (no voice tag available");
        }
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += 4;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushBits(3, 0);
        bitStream.pushBoolean(this.voiceTagAvailable);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.popFrontBits(3);
        this.voiceTagAvailable = bitStream.popFrontBoolean();
    }
}

