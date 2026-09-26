/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.DistanceToNextManeuver_Status$BargraphInfo;
import de.vw.mib.bap.generated.navsd.serializer.DistanceToNextManeuver_Status$DistanceToNextManeuver;
import de.vw.mib.bap.generated.navsd.serializer.DistanceToNextManeuver_Status$ValidityInformation;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DistanceToNextManeuver_Status
implements StatusProperty {
    public final DistanceToNextManeuver_Status$DistanceToNextManeuver distanceToNextManeuver = new DistanceToNextManeuver_Status$DistanceToNextManeuver();
    public final DistanceToNextManeuver_Status$BargraphInfo bargraphInfo = new DistanceToNextManeuver_Status$BargraphInfo();
    public final DistanceToNextManeuver_Status$ValidityInformation validityInformation = new DistanceToNextManeuver_Status$ValidityInformation();

    public DistanceToNextManeuver_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DistanceToNextManeuver_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.distanceToNextManeuver.reset();
        this.bargraphInfo.reset();
        this.validityInformation.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DistanceToNextManeuver_Status distanceToNextManeuver_Status = (DistanceToNextManeuver_Status)bAPEntity;
        return this.distanceToNextManeuver.equalTo(distanceToNextManeuver_Status.distanceToNextManeuver) && this.bargraphInfo.equalTo(distanceToNextManeuver_Status.bargraphInfo) && this.validityInformation.equalTo(distanceToNextManeuver_Status.validityInformation);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DistanceToNextManeuver_Status:");
        stringBuffer.append("\n - DistanceToNextManeuver - ");
        stringBuffer.append(this.distanceToNextManeuver.toString());
        stringBuffer.append("\n - BargraphInfo - ");
        stringBuffer.append(this.bargraphInfo.toString());
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.distanceToNextManeuver.bitSize();
        n += this.bargraphInfo.bitSize();
        return n += this.validityInformation.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.distanceToNextManeuver.serialize(bitStream);
        this.bargraphInfo.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.distanceToNextManeuver.deserialize(bitStream);
        this.bargraphInfo.deserialize(bitStream);
        this.validityInformation.deserialize(bitStream);
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return DistanceToNextManeuver_Status.functionId();
    }
}

