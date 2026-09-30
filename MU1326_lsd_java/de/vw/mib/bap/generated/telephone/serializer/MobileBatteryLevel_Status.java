/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobileBatteryLevel_Status
implements StatusProperty {
    public int chargeLevel_Mobile1;
    private static final int CHARGE_LEVEL_MOBILE1_BITSIZE = 8;
    public int chargeLevel_Mobile2;
    private static final int CHARGE_LEVEL_MOBILE2_BITSIZE = 8;
    public int chargeLevel_Handset1;
    private static final int CHARGE_LEVEL_HANDSET1_BITSIZE = 8;
    public int chargeLevel_Handset2;
    private static final int CHARGE_LEVEL_HANDSET2_BITSIZE = 8;
    public final WarningLevel warningLevel = new WarningLevel();

    public MobileBatteryLevel_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileBatteryLevel_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.chargeLevel_Mobile1 = 0;
        this.chargeLevel_Mobile2 = 0;
        this.chargeLevel_Handset1 = 0;
        this.chargeLevel_Handset2 = 0;
    }

    public void reset() {
        this.internalReset();
        this.warningLevel.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobileBatteryLevel_Status mobileBatteryLevel_Status = (MobileBatteryLevel_Status)bAPEntity;
        return this.chargeLevel_Mobile1 == mobileBatteryLevel_Status.chargeLevel_Mobile1 && this.chargeLevel_Mobile2 == mobileBatteryLevel_Status.chargeLevel_Mobile2 && this.chargeLevel_Handset1 == mobileBatteryLevel_Status.chargeLevel_Handset1 && this.chargeLevel_Handset2 == mobileBatteryLevel_Status.chargeLevel_Handset2 && this.warningLevel.equalTo(mobileBatteryLevel_Status.warningLevel);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobileBatteryLevel_Status:");
        stringBuffer.append("\n - ChargeLevel_Mobile1 - ");
        stringBuffer.append(this.chargeLevel_Mobile1);
        stringBuffer.append("\n - ChargeLevel_Mobile2 - ");
        stringBuffer.append(this.chargeLevel_Mobile2);
        stringBuffer.append("\n - ChargeLevel_Handset1 - ");
        stringBuffer.append(this.chargeLevel_Handset1);
        stringBuffer.append("\n - ChargeLevel_Handset2 - ");
        stringBuffer.append(this.chargeLevel_Handset2);
        stringBuffer.append("\n - WarningLevel - ");
        stringBuffer.append(this.warningLevel.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += this.warningLevel.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.chargeLevel_Mobile1);
        bitStream.pushByte((byte)this.chargeLevel_Mobile2);
        bitStream.pushByte((byte)this.chargeLevel_Handset1);
        bitStream.pushByte((byte)this.chargeLevel_Handset2);
        this.warningLevel.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.chargeLevel_Mobile1 = bitStream.popFrontByte();
        this.chargeLevel_Mobile2 = bitStream.popFrontByte();
        this.chargeLevel_Handset1 = bitStream.popFrontByte();
        this.chargeLevel_Handset2 = bitStream.popFrontByte();
        this.warningLevel.deserialize(bitStream);
    }

    public static int functionId() {
        return 43;
    }

    public int getFunctionId() {
        return MobileBatteryLevel_Status.functionId();
    }

    public static final class WarningLevel
    implements BAPEntity {
        private static final int RESERVED_BIT_4__7_BITSIZE = 4;
        public boolean handset2ChargeLevelCritical;
        public boolean handset1ChargeLevelCritical;
        public boolean mobile2ChargeLevelCritical;
        public boolean mobile1ChargeLevelCritical;
        private static final int WARNING_LEVEL_BITSIZE = 8;

        public WarningLevel() {
            this.internalReset();
            this.customInitialization();
        }

        public WarningLevel(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.handset2ChargeLevelCritical = false;
            this.handset1ChargeLevelCritical = false;
            this.mobile2ChargeLevelCritical = false;
            this.mobile1ChargeLevelCritical = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            WarningLevel warningLevel = (WarningLevel)bAPEntity;
            return this.handset2ChargeLevelCritical == warningLevel.handset2ChargeLevelCritical && this.handset1ChargeLevelCritical == warningLevel.handset1ChargeLevelCritical && this.mobile2ChargeLevelCritical == warningLevel.mobile2ChargeLevelCritical && this.mobile1ChargeLevelCritical == warningLevel.mobile1ChargeLevelCritical;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("WarningLevel:");
            stringBuffer.append("\n - Bit 3: ");
            if (this.handset2ChargeLevelCritical) {
                stringBuffer.append("true  (handset2 charge level critical");
            } else {
                stringBuffer.append("false  (handest2 charge level not critical");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.handset1ChargeLevelCritical) {
                stringBuffer.append("true  (handset1 charge level critical");
            } else {
                stringBuffer.append("false  (handset1 charge level not critical");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.mobile2ChargeLevelCritical) {
                stringBuffer.append("true  (mobile2 charge level critical");
            } else {
                stringBuffer.append("false  (mobile2 charge level not critical");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.mobile1ChargeLevelCritical) {
                stringBuffer.append("true  (mobile1 charge level critical");
            } else {
                stringBuffer.append("false  (mobile1 charge level not critical");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.resetBits(4);
            bitStream.pushBoolean(this.handset2ChargeLevelCritical);
            bitStream.pushBoolean(this.handset1ChargeLevelCritical);
            bitStream.pushBoolean(this.mobile2ChargeLevelCritical);
            bitStream.pushBoolean(this.mobile1ChargeLevelCritical);
        }

        public void deserialize(BitStream bitStream) {
            bitStream.discardBits(4);
            this.handset2ChargeLevelCritical = bitStream.popFrontBoolean();
            this.handset1ChargeLevelCritical = bitStream.popFrontBoolean();
            this.mobile2ChargeLevelCritical = bitStream.popFrontBoolean();
            this.mobile1ChargeLevelCritical = bitStream.popFrontBoolean();
        }
    }
}

