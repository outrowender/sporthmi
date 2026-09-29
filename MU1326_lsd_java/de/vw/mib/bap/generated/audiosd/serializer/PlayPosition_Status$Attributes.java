/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class PlayPosition_Status$Attributes
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean variableBitRateActive;
    private static final int ATTRIBUTES_BITSIZE;

    public PlayPosition_Status$Attributes() {
        this.internalReset();
        this.customInitialization();
    }

    public PlayPosition_Status$Attributes(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.variableBitRateActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PlayPosition_Status$Attributes playPosition_Status$Attributes = (PlayPosition_Status$Attributes)bAPEntity;
        return this.variableBitRateActive == playPosition_Status$Attributes.variableBitRateActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Attributes:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.variableBitRateActive) {
            stringBuffer.append("true  (variable bit rate active");
        } else {
            stringBuffer.append("false  (variable bit rate not active");
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
        bitStream.pushBoolean(this.variableBitRateActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.variableBitRateActive = bitStream.popFrontBoolean();
    }
}

