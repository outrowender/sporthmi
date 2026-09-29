/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.MobileBatteryLevel_Status$WarningLevel;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobileBatteryLevel_Status
implements StatusProperty {
    public int chargeLevel_Mobile1;
    private static final int CHARGE_LEVEL_MOBILE1_BITSIZE;
    public int chargeLevel_Mobile2;
    private static final int CHARGE_LEVEL_MOBILE2_BITSIZE;
    public int chargeLevel_Handset1;
    private static final int CHARGE_LEVEL_HANDSET1_BITSIZE;
    public int chargeLevel_Handset2;
    private static final int CHARGE_LEVEL_HANDSET2_BITSIZE;
    public final MobileBatteryLevel_Status$WarningLevel warningLevel = new MobileBatteryLevel_Status$WarningLevel();

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

    @Override
    public void reset() {
        this.internalReset();
        this.warningLevel.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        MobileBatteryLevel_Status mobileBatteryLevel_Status = (MobileBatteryLevel_Status)bAPEntity;
        return this.chargeLevel_Mobile1 == mobileBatteryLevel_Status.chargeLevel_Mobile1 && this.chargeLevel_Mobile2 == mobileBatteryLevel_Status.chargeLevel_Mobile2 && this.chargeLevel_Handset1 == mobileBatteryLevel_Status.chargeLevel_Handset1 && this.chargeLevel_Handset2 == mobileBatteryLevel_Status.chargeLevel_Handset2 && this.warningLevel.equalTo(mobileBatteryLevel_Status.warningLevel);
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        n += 8;
        n += 8;
        return n += this.warningLevel.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.chargeLevel_Mobile1);
        bitStream.pushByte((byte)this.chargeLevel_Mobile2);
        bitStream.pushByte((byte)this.chargeLevel_Handset1);
        bitStream.pushByte((byte)this.chargeLevel_Handset2);
        this.warningLevel.serialize(bitStream);
    }

    @Override
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

    @Override
    public int getFunctionId() {
        return MobileBatteryLevel_Status.functionId();
    }
}

