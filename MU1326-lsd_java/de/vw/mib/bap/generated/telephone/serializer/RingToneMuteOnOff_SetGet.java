/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.RingToneMuteOnOff_RingToneMuteOnOff;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class RingToneMuteOnOff_SetGet
implements SetGetProperty {
    public final RingToneMuteOnOff_RingToneMuteOnOff ringToneMuteOnOff = new RingToneMuteOnOff_RingToneMuteOnOff();

    public RingToneMuteOnOff_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public RingToneMuteOnOff_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    @Override
    public void reset() {
        this.internalReset();
        this.ringToneMuteOnOff.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        RingToneMuteOnOff_SetGet ringToneMuteOnOff_SetGet = (RingToneMuteOnOff_SetGet)bAPEntity;
        return this.ringToneMuteOnOff.equalTo(ringToneMuteOnOff_SetGet.ringToneMuteOnOff);
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RingToneMuteOnOff_SetGet:");
        stringBuffer.append("\n - RingToneMuteOnOff - ");
        stringBuffer.append(this.ringToneMuteOnOff.toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        return n += this.ringToneMuteOnOff.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        this.ringToneMuteOnOff.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.ringToneMuteOnOff.deserialize(bitStream);
    }

    public static int functionId() {
        return 56;
    }

    @Override
    public int getFunctionId() {
        return RingToneMuteOnOff_SetGet.functionId();
    }
}

