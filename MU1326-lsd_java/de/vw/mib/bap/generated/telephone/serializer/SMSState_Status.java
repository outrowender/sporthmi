/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SMSState_Status
implements StatusProperty {
    public int simready;
    private static final int SIM_READY_BITSIZE;
    public static final int SIM_READY_SIM_DATA_NOT_YET_AVAILABLE;
    public static final int SIM_READY_SIM_DATA_AVAILABLE;
    public int storageState;
    private static final int STORAGE_STATE_BITSIZE;
    public static final int STORAGE_STATE_SMS_STORAGE_AVAILABLE;
    public static final int STORAGE_STATE_SMS_STORAGE_FULL;
    public static final int STORAGE_STATE_SMS_STORAGE_FULL_SMS_PENDING_1;
    public static final int STORAGE_STATE_SMS_STORAGE_FULL_SMS_PENDING_2;
    public int numberOfNewSms;
    private static final int NUMBER_OF_NEW_SMS_BITSIZE;

    public SMSState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public SMSState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.simready = 0;
        this.storageState = 0;
        this.numberOfNewSms = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SMSState_Status sMSState_Status = (SMSState_Status)bAPEntity;
        return this.simready == sMSState_Status.simready && this.storageState == sMSState_Status.storageState && this.numberOfNewSms == sMSState_Status.numberOfNewSms;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SMSState_Status:");
        stringBuffer.append("\n - SIMReady: ");
        switch (this.simready) {
            case 0: {
                stringBuffer.append("0x00 (SIM data not (yet) available)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (SIM data available)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - StorageState: ");
        switch (this.storageState) {
            case 0: {
                stringBuffer.append("0x00 (SMS storage available)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (SMS storage full)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (SMS storage full, SMS pending_1)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (SMS storage full, SMS pending_2)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - NumberOfNewSMS - ");
        stringBuffer.append(this.numberOfNewSms);
        return stringBuffer.toString();
    }

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        return n += 16;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.simready);
        bitStream.pushByte((byte)this.storageState);
        bitStream.pushShort((short)this.numberOfNewSms);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.simready = bitStream.popFrontByte();
        this.storageState = bitStream.popFrontByte();
        this.numberOfNewSms = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 55;
    }

    @Override
    public int getFunctionId() {
        return SMSState_Status.functionId();
    }
}

