/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class RingToneMuteOnOff_RingToneMuteOnOff
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean on;
    private static final int RING_TONE_MUTE_ON_OFF_RING_TONE_MUTE_ON_OFF_BITSIZE;

    public RingToneMuteOnOff_RingToneMuteOnOff() {
        this.internalReset();
        this.customInitialization();
    }

    public RingToneMuteOnOff_RingToneMuteOnOff(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.on = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RingToneMuteOnOff_RingToneMuteOnOff ringToneMuteOnOff_RingToneMuteOnOff = (RingToneMuteOnOff_RingToneMuteOnOff)bAPEntity;
        return this.on == ringToneMuteOnOff_RingToneMuteOnOff.on;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RingToneMuteOnOff_RingToneMuteOnOff:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.on) {
            stringBuffer.append("true  (on");
        } else {
            stringBuffer.append("false  (off");
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
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.on);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.on = bitStream.popFrontBoolean();
    }
}

