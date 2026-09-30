/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.RingToneMuteOnOff_RingToneMuteOnOff;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RingToneMuteOnOff_Status
implements StatusProperty {
    public final RingToneMuteOnOff_RingToneMuteOnOff ringToneMuteOnOff = new RingToneMuteOnOff_RingToneMuteOnOff();

    public RingToneMuteOnOff_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public RingToneMuteOnOff_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.ringToneMuteOnOff.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RingToneMuteOnOff_Status ringToneMuteOnOff_Status = (RingToneMuteOnOff_Status)bAPEntity;
        return this.ringToneMuteOnOff.equalTo(ringToneMuteOnOff_Status.ringToneMuteOnOff);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RingToneMuteOnOff_Status:");
        stringBuffer.append("\n - RingToneMuteOnOff - ");
        stringBuffer.append(this.ringToneMuteOnOff.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.ringToneMuteOnOff.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.ringToneMuteOnOff.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.ringToneMuteOnOff.deserialize(bitStream);
    }

    public static int functionId() {
        return 56;
    }

    public int getFunctionId() {
        return RingToneMuteOnOff_Status.functionId();
    }
}

