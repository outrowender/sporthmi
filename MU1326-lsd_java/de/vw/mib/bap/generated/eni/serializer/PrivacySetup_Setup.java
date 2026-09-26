/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class PrivacySetup_Setup
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PrivacySetup_Setup privacySetup_Setup = (PrivacySetup_Setup)bAPEntity;
        return this.privacyModeIsActive == privacySetup_Setup.privacyModeIsActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PrivacySetup_Setup");
        stringBuffer.append(new StringBuffer().append("\n - privacyModeIsActive:").append(this.privacyModeIsActive).toString());
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.privacyModeIsActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.privacyModeIsActive = bitStream.popFrontBoolean();
    }
}

