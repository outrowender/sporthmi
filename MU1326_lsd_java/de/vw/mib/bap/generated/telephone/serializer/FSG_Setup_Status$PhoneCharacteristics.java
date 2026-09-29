/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status$PhoneCharacteristics
implements BAPEntity {
    public boolean reserved_bit_7;
    public boolean baiduLinkConnectionToMobilePossible;
    public boolean googleLinkConnectionToMobilePossible;
    public boolean appleLinkConnectionToMobilePossible;
    public boolean rsapConnectionToMobilePossible;
    public boolean hfpConnectionToMobilePossible;
    public boolean cableConnectionToMobilePossible;
    public boolean internalSimcardReader;
    private static final int PHONE_CHARACTERISTICS_BITSIZE;

    public FSG_Setup_Status$PhoneCharacteristics() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status$PhoneCharacteristics(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_7 = false;
        this.baiduLinkConnectionToMobilePossible = false;
        this.googleLinkConnectionToMobilePossible = false;
        this.appleLinkConnectionToMobilePossible = false;
        this.rsapConnectionToMobilePossible = false;
        this.hfpConnectionToMobilePossible = false;
        this.cableConnectionToMobilePossible = false;
        this.internalSimcardReader = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status$PhoneCharacteristics fSG_Setup_Status$PhoneCharacteristics = (FSG_Setup_Status$PhoneCharacteristics)bAPEntity;
        return this.reserved_bit_7 == fSG_Setup_Status$PhoneCharacteristics.reserved_bit_7 && this.baiduLinkConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.baiduLinkConnectionToMobilePossible && this.googleLinkConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.googleLinkConnectionToMobilePossible && this.appleLinkConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.appleLinkConnectionToMobilePossible && this.rsapConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.rsapConnectionToMobilePossible && this.hfpConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.hfpConnectionToMobilePossible && this.cableConnectionToMobilePossible == fSG_Setup_Status$PhoneCharacteristics.cableConnectionToMobilePossible && this.internalSimcardReader == fSG_Setup_Status$PhoneCharacteristics.internalSimcardReader;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PhoneCharacteristics:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.reserved_bit_7) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.baiduLinkConnectionToMobilePossible) {
            stringBuffer.append("true  (BaiduLink connection to Mobile possible (DF4.3)");
        } else {
            stringBuffer.append("false  (No BaiduLink connection to Mobile possible");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.googleLinkConnectionToMobilePossible) {
            stringBuffer.append("true  (GoogleLink connection to Mobile possible (DF4.2)");
        } else {
            stringBuffer.append("false  (No GoogleLink connection to Mobile possible");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.appleLinkConnectionToMobilePossible) {
            stringBuffer.append("true  (AppleLink connection to Mobile possible  (DF4.2)");
        } else {
            stringBuffer.append("false  (No AppleLink connection to Mobile possible");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.rsapConnectionToMobilePossible) {
            stringBuffer.append("true  (RSAP connection to Mobile possible");
        } else {
            stringBuffer.append("false  (No RSAP connection to Mobile possible");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.hfpConnectionToMobilePossible) {
            stringBuffer.append("true  (HFP connection to Mobile possible");
        } else {
            stringBuffer.append("false  (No HFP connection to Mobile possible");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.cableConnectionToMobilePossible) {
            stringBuffer.append("true  (Cable connection to Mobile possible");
        } else {
            stringBuffer.append("false  (No cable connection to Mobile possible");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.internalSimcardReader) {
            stringBuffer.append("true  (Internal SIMCardReader");
        } else {
            stringBuffer.append("false  (No internal SIMCardReader");
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
        bitStream.pushBoolean(this.baiduLinkConnectionToMobilePossible);
        bitStream.pushBoolean(this.googleLinkConnectionToMobilePossible);
        bitStream.pushBoolean(this.appleLinkConnectionToMobilePossible);
        bitStream.pushBoolean(this.rsapConnectionToMobilePossible);
        bitStream.pushBoolean(this.hfpConnectionToMobilePossible);
        bitStream.pushBoolean(this.cableConnectionToMobilePossible);
        bitStream.pushBoolean(this.internalSimcardReader);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserved_bit_7 = bitStream.popFrontBoolean();
        this.baiduLinkConnectionToMobilePossible = bitStream.popFrontBoolean();
        this.googleLinkConnectionToMobilePossible = bitStream.popFrontBoolean();
        this.appleLinkConnectionToMobilePossible = bitStream.popFrontBoolean();
        this.rsapConnectionToMobilePossible = bitStream.popFrontBoolean();
        this.hfpConnectionToMobilePossible = bitStream.popFrontBoolean();
        this.cableConnectionToMobilePossible = bitStream.popFrontBoolean();
        this.internalSimcardReader = bitStream.popFrontBoolean();
    }
}

