/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToDestination_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean distanceToDestinationValid;
    private static final int VALIDITY_INFORMATION_BITSIZE;

    public DistanceToDestination_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToDestination_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distanceToDestinationValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToDestination_Status$ValidityInformation distanceToDestination_Status$ValidityInformation = (DistanceToDestination_Status$ValidityInformation)bAPEntity;
        return this.distanceToDestinationValid == distanceToDestination_Status$ValidityInformation.distanceToDestinationValid;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ValidityInformation:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.distanceToDestinationValid) {
            stringBuffer.append("true  (DistanceToDestination valid");
        } else {
            stringBuffer.append("false  (DistanceToDestination invalid");
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
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.distanceToDestinationValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.distanceToDestinationValid = bitStream.popFrontBoolean();
    }
}

