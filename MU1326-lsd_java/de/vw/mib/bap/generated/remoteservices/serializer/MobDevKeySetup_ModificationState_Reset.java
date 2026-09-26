/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeySetup_ModificationState_Reset
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE;
    public boolean canBeModified;

    public MobDevKeySetup_ModificationState_Reset() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeySetup_ModificationState_Reset(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.canBeModified = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeySetup_ModificationState_Reset mobDevKeySetup_ModificationState_Reset = (MobDevKeySetup_ModificationState_Reset)bAPEntity;
        return this.canBeModified == mobDevKeySetup_ModificationState_Reset.canBeModified;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeySetup_ModificationState_Reset");
        stringBuffer.append("\n - canBeModified:").append(this.canBeModified);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.canBeModified);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.canBeModified = bitStream.popFrontBoolean();
    }
}

