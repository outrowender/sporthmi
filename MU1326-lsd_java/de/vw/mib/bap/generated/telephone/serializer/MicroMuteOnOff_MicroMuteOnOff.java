/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MicroMuteOnOff_MicroMuteOnOff
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean on;
    private static final int MICRO_MUTE_ON_OFF_MICRO_MUTE_ON_OFF_BITSIZE;

    public MicroMuteOnOff_MicroMuteOnOff() {
        this.internalReset();
        this.customInitialization();
    }

    public MicroMuteOnOff_MicroMuteOnOff(BitStream bitStream) {
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
        MicroMuteOnOff_MicroMuteOnOff microMuteOnOff_MicroMuteOnOff = (MicroMuteOnOff_MicroMuteOnOff)bAPEntity;
        return this.on == microMuteOnOff_MicroMuteOnOff.on;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MicroMuteOnOff_MicroMuteOnOff:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.on) {
            stringBuffer.append("true  (On");
        } else {
            stringBuffer.append("false  (Off");
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

