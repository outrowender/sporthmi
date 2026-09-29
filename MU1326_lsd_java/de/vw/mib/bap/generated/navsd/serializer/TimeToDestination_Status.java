/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.navsd.serializer.TimeToDestination_Status$TimeInfo;
import de.vw.mib.bap.generated.navsd.serializer.TimeToDestination_Status$ValidityInformation;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class TimeToDestination_Status
implements StatusProperty {
    public final TimeToDestination_Status$TimeInfo timeInfo = new TimeToDestination_Status$TimeInfo();
    public final TimeToDestination_Status$ValidityInformation validityInformation = new TimeToDestination_Status$ValidityInformation();

    public TimeToDestination_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public TimeToDestination_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.timeInfo.reset();
        this.validityInformation.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        TimeToDestination_Status timeToDestination_Status = (TimeToDestination_Status)bAPEntity;
        return this.timeInfo.equalTo(timeToDestination_Status.timeInfo) && this.validityInformation.equalTo(timeToDestination_Status.validityInformation);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("TimeToDestination_Status:");
        stringBuffer.append("\n - TimeInfo - ");
        stringBuffer.append(this.timeInfo.toString());
        stringBuffer.append("\n - ValidityInformation - ");
        stringBuffer.append(this.validityInformation.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += this.timeInfo.bitSize();
        return n += this.validityInformation.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.timeInfo.serialize(bitStream);
        this.validityInformation.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.timeInfo.deserialize(bitStream);
        this.validityInformation.deserialize(bitStream);
    }

    public static int functionId() {
        return 22;
    }

    @Override
    public int getFunctionId() {
        return TimeToDestination_Status.functionId();
    }
}

