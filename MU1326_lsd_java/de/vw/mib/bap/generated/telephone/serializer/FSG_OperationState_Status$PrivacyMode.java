/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_OperationState_Status$PrivacyMode
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean reserved_bit_6;
    public boolean reserved_bit_5;
    public boolean reserved_bit_4;
    public boolean reserved_bit_3;
    public boolean reserved_bit_2;
    public boolean enhancedPrivacyModeActive;
    public boolean privacyModeActive;
    private static final int PRIVACY_MODE_BITSIZE;

    public FSG_OperationState_Status$PrivacyMode() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_OperationState_Status$PrivacyMode(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.reserved_bit_6 = false;
        this.reserved_bit_5 = false;
        this.reserved_bit_4 = false;
        this.reserved_bit_3 = false;
        this.reserved_bit_2 = false;
        this.enhancedPrivacyModeActive = false;
        this.privacyModeActive = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_OperationState_Status$PrivacyMode fSG_OperationState_Status$PrivacyMode = (FSG_OperationState_Status$PrivacyMode)bAPEntity;
        return this.reserved_bit_7 == fSG_OperationState_Status$PrivacyMode.reserved_bit_7 && this.reserved_bit_6 == fSG_OperationState_Status$PrivacyMode.reserved_bit_6 && this.reserved_bit_5 == fSG_OperationState_Status$PrivacyMode.reserved_bit_5 && this.reserved_bit_4 == fSG_OperationState_Status$PrivacyMode.reserved_bit_4 && this.reserved_bit_3 == fSG_OperationState_Status$PrivacyMode.reserved_bit_3 && this.reserved_bit_2 == fSG_OperationState_Status$PrivacyMode.reserved_bit_2 && this.enhancedPrivacyModeActive == fSG_OperationState_Status$PrivacyMode.enhancedPrivacyModeActive && this.privacyModeActive == fSG_OperationState_Status$PrivacyMode.privacyModeActive;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PrivacyMode:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.reserved_bit_7) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.reserved_bit_6) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.reserved_bit_5) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.reserved_bit_4) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.reserved_bit_3) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.reserved_bit_2) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.enhancedPrivacyModeActive) {
            stringBuffer.append("true  (EnhancedPrivacyMode active");
        } else {
            stringBuffer.append("false  (EnhancedPrivacyMode inactive");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.privacyModeActive) {
            stringBuffer.append("true  (PrivacyMode active");
        } else {
            stringBuffer.append("false  (PrivacyMode inactive");
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
        bitStream.pushBoolean(this.reserved_bit_7);
        bitStream.pushBoolean(this.reserved_bit_6);
        bitStream.pushBoolean(this.reserved_bit_5);
        bitStream.pushBoolean(this.reserved_bit_4);
        bitStream.pushBoolean(this.reserved_bit_3);
        bitStream.pushBoolean(this.reserved_bit_2);
        bitStream.pushBoolean(this.enhancedPrivacyModeActive);
        bitStream.pushBoolean(this.privacyModeActive);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.reserved_bit_6 = bitStream.popFrontBoolean();
        this.reserved_bit_5 = bitStream.popFrontBoolean();
        this.reserved_bit_4 = bitStream.popFrontBoolean();
        this.reserved_bit_3 = bitStream.popFrontBoolean();
        this.reserved_bit_2 = bitStream.popFrontBoolean();
        this.enhancedPrivacyModeActive = bitStream.popFrontBoolean();
        this.privacyModeActive = bitStream.popFrontBoolean();
    }
}

