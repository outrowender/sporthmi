/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CurrentVolumeExtended_Status$VolumeState
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean volumeIsNotLocked;
    private static final int VOLUME_STATE_BITSIZE;

    public CurrentVolumeExtended_Status$VolumeState() {
        this.internalReset();
        this.customInitialization();
    }

    public CurrentVolumeExtended_Status$VolumeState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.volumeIsNotLocked = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CurrentVolumeExtended_Status$VolumeState currentVolumeExtended_Status$VolumeState = (CurrentVolumeExtended_Status$VolumeState)bAPEntity;
        return this.volumeIsNotLocked == currentVolumeExtended_Status$VolumeState.volumeIsNotLocked;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("VolumeState:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.volumeIsNotLocked) {
            stringBuffer.append("true  (Volume is not locked");
        } else {
            stringBuffer.append("false  (Volume is locked");
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
        bitStream.pushBoolean(this.volumeIsNotLocked);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.volumeIsNotLocked = bitStream.popFrontBoolean();
    }
}

