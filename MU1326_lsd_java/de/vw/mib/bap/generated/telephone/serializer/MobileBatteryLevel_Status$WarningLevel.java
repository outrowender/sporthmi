/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class MobileBatteryLevel_Status$WarningLevel
implements BAPEntity {
    private static final int RESERVED_BIT_4__7_BITSIZE;
    public boolean handset2ChargeLevelCritical;
    public boolean handset1ChargeLevelCritical;
    public boolean mobile2ChargeLevelCritical;
    public boolean mobile1ChargeLevelCritical;
    private static final int WARNING_LEVEL_BITSIZE;

    public MobileBatteryLevel_Status$WarningLevel() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileBatteryLevel_Status$WarningLevel(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.handset2ChargeLevelCritical = false;
        this.handset1ChargeLevelCritical = false;
        this.mobile2ChargeLevelCritical = false;
        this.mobile1ChargeLevelCritical = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileBatteryLevel_Status$WarningLevel mobileBatteryLevel_Status$WarningLevel = (MobileBatteryLevel_Status$WarningLevel)bAPEntity;
        return this.handset2ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.handset2ChargeLevelCritical && this.handset1ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.handset1ChargeLevelCritical && this.mobile2ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.mobile2ChargeLevelCritical && this.mobile1ChargeLevelCritical == mobileBatteryLevel_Status$WarningLevel.mobile1ChargeLevelCritical;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(4);
        bitStream.pushBoolean(this.handset2ChargeLevelCritical);
        bitStream.pushBoolean(this.handset1ChargeLevelCritical);
        bitStream.pushBoolean(this.mobile2ChargeLevelCritical);
        bitStream.pushBoolean(this.mobile1ChargeLevelCritical);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(4);
        this.handset2ChargeLevelCritical = bitStream.popFrontBoolean();
        this.handset1ChargeLevelCritical = bitStream.popFrontBoolean();
        this.mobile2ChargeLevelCritical = bitStream.popFrontBoolean();
        this.mobile1ChargeLevelCritical = bitStream.popFrontBoolean();
    }
}

