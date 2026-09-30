/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_Setup_Status
implements StatusProperty {
    public final PhoneCharacteristics phoneCharacteristics = new PhoneCharacteristics();
    public int mobileConnectionType;
    private static final int MOBILE_CONNECTION_TYPE_BITSIZE = 8;
    public static final int MOBILE_CONNECTION_TYPE_NO_CONNECTION = 0;
    public static final int MOBILE_CONNECTION_TYPE_INTERNAL_SIM_CARD_READER = 1;
    public static final int MOBILE_CONNECTION_TYPE_CABLE_CONNECTION = 2;
    public static final int MOBILE_CONNECTION_TYPE_HANDS_FREE_PROFILE = 3;
    public static final int MOBILE_CONNECTION_TYPE_REMOTE_SIM_ACCESS_PROFILE = 4;
    public static final int MOBILE_CONNECTION_TYPE_APPLE_LINK_DF4_2 = 5;
    public static final int MOBILE_CONNECTION_TYPE_GOOGLE_LINK_DF4_2 = 6;
    public static final int MOBILE_CONNECTION_TYPE_BAIDU_LINK_DF4_3 = 7;

    public FSG_Setup_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_Setup_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.mobileConnectionType = 0;
    }

    public void reset() {
        this.internalReset();
        this.phoneCharacteristics.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_Setup_Status fSG_Setup_Status = (FSG_Setup_Status)bAPEntity;
        return this.phoneCharacteristics.equalTo(fSG_Setup_Status.phoneCharacteristics) && this.mobileConnectionType == fSG_Setup_Status.mobileConnectionType;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_Setup_Status:");
        stringBuffer.append("\n - PhoneCharacteristics - ");
        stringBuffer.append(this.phoneCharacteristics.toString());
        stringBuffer.append("\n - MobileConnectionType: ");
        switch (this.mobileConnectionType) {
            case 0: {
                stringBuffer.append("0x00 (NoConnection)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (InternalSIMCardReader)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (CableConnection)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (HandsFreeProfile)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (RemoteSIMAccessProfile)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (AppleLink (DF4.2))");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (GoogleLink (DF4.2))");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (BaiduLink (DF4.3))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += this.phoneCharacteristics.bitSize();
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        this.phoneCharacteristics.serialize(bitStream);
        bitStream.pushByte((byte)this.mobileConnectionType);
    }

    public void deserialize(BitStream bitStream) {
        this.phoneCharacteristics.deserialize(bitStream);
        this.mobileConnectionType = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 14;
    }

    public int getFunctionId() {
        return FSG_Setup_Status.functionId();
    }

    public static final class PhoneCharacteristics
    implements BAPEntity {
        public boolean reserved_bit_7;
        public boolean baiduLinkConnectionToMobilePossible;
        public boolean googleLinkConnectionToMobilePossible;
        public boolean appleLinkConnectionToMobilePossible;
        public boolean rsapConnectionToMobilePossible;
        public boolean hfpConnectionToMobilePossible;
        public boolean cableConnectionToMobilePossible;
        public boolean internalSimcardReader;
        private static final int PHONE_CHARACTERISTICS_BITSIZE = 8;

        public PhoneCharacteristics() {
            this.internalReset();
            this.customInitialization();
        }

        public PhoneCharacteristics(BitStream bitStream) {
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

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            PhoneCharacteristics phoneCharacteristics = (PhoneCharacteristics)bAPEntity;
            return this.reserved_bit_7 == phoneCharacteristics.reserved_bit_7 && this.baiduLinkConnectionToMobilePossible == phoneCharacteristics.baiduLinkConnectionToMobilePossible && this.googleLinkConnectionToMobilePossible == phoneCharacteristics.googleLinkConnectionToMobilePossible && this.appleLinkConnectionToMobilePossible == phoneCharacteristics.appleLinkConnectionToMobilePossible && this.rsapConnectionToMobilePossible == phoneCharacteristics.rsapConnectionToMobilePossible && this.hfpConnectionToMobilePossible == phoneCharacteristics.hfpConnectionToMobilePossible && this.cableConnectionToMobilePossible == phoneCharacteristics.cableConnectionToMobilePossible && this.internalSimcardReader == phoneCharacteristics.internalSimcardReader;
        }

        private void customInitialization() {
        }

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

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

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
}

