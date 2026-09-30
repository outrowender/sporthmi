/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class PrivacySetup_Setup
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE = 7;
    public boolean privacyModeIsActive;

    public PrivacySetup_Setup() {
        this.internalReset();
        this.customInitialization();
    }

    public PrivacySetup_Setup(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.privacyModeIsActive = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PrivacySetup_Setup privacySetup_Setup = (PrivacySetup_Setup)bAPEntity;
        return this.privacyModeIsActive == privacySetup_Setup.privacyModeIsActive;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PrivacySetup_Setup");
        stringBuffer.append("\n - privacyModeIsActive:" + this.privacyModeIsActive);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.privacyModeIsActive);
    }

    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.privacyModeIsActive = bitStream.popFrontBoolean();
    }
}

