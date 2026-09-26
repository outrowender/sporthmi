/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status$ValidityInformation
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean distanceToNextManeuverValid;
    private static final int VALIDITY_INFORMATION_BITSIZE;

    public DistanceToNextManeuver_Status$ValidityInformation() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status$ValidityInformation(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.distanceToNextManeuverValid = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status$ValidityInformation distanceToNextManeuver_Status$ValidityInformation = (DistanceToNextManeuver_Status$ValidityInformation)bAPEntity;
        return this.distanceToNextManeuverValid == distanceToNextManeuver_Status$ValidityInformation.distanceToNextManeuverValid;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ValidityInformation:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.distanceToNextManeuverValid) {
            stringBuffer.append("true  (DistanceToNextManeuver valid");
        } else {
            stringBuffer.append("false  (DistanceToNextManeuver invalid");
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
        bitStream.pushBoolean(this.distanceToNextManeuverValid);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.distanceToNextManeuverValid = bitStream.popFrontBoolean();
    }
}

