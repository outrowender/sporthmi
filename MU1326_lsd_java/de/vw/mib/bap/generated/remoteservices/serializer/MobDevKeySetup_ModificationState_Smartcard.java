/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.remoteservices.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobDevKeySetup_ModificationState_Smartcard
implements BAPEntity {
    private static final int RESERVED_BIT_1__3_BITSIZE = 3;
    public boolean canBeModified;

    public MobDevKeySetup_ModificationState_Smartcard() {
        this.internalReset();
        this.customInitialization();
    }

    public MobDevKeySetup_ModificationState_Smartcard(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.canBeModified = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobDevKeySetup_ModificationState_Smartcard mobDevKeySetup_ModificationState_Smartcard = (MobDevKeySetup_ModificationState_Smartcard)bAPEntity;
        return this.canBeModified == mobDevKeySetup_ModificationState_Smartcard.canBeModified;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobDevKeySetup_ModificationState_Smartcard");
        stringBuffer.append("\n - canBeModified:").append(this.canBeModified);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(3);
        bitStream.pushBoolean(this.canBeModified);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(3);
        this.canBeModified = bitStream.popFrontBoolean();
    }
}

