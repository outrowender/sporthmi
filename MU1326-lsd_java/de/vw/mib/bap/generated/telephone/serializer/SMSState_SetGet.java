/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.SetGetProperty;
import de.vw.mib.bap.stream.BitStream;

public final class SMSState_SetGet
implements SetGetProperty {
    public int reserve_1;
    private static final int RESERVE_1_BITSIZE;
    public int reserve_2;
    private static final int RESERVE_2_BITSIZE;
    public int numberOfNewSms;
    private static final int NUMBER_OF_NEW_SMS_BITSIZE;

    public SMSState_SetGet() {
        this.internalReset();
        this.customInitialization();
    }

    public SMSState_SetGet(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserve_1 = 0;
        this.reserve_2 = 0;
        this.numberOfNewSms = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        SMSState_SetGet sMSState_SetGet = (SMSState_SetGet)bAPEntity;
        return this.reserve_1 == sMSState_SetGet.reserve_1 && this.reserve_2 == sMSState_SetGet.reserve_2 && this.numberOfNewSms == sMSState_SetGet.numberOfNewSms;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SMSState_SetGet:");
        stringBuffer.append("\n - Reserve_1 - ");
        stringBuffer.append(this.reserve_1);
        stringBuffer.append("\n - Reserve_2 - ");
        stringBuffer.append(this.reserve_2);
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
        bitStream.pushByte((byte)this.reserve_1);
        bitStream.pushByte((byte)this.reserve_2);
        bitStream.pushShort((short)this.numberOfNewSms);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.reserve_1 = bitStream.popFrontByte();
        this.reserve_2 = bitStream.popFrontByte();
        this.numberOfNewSms = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 55;
    }

    @Override
    public int getFunctionId() {
        return SMSState_SetGet.functionId();
    }
}

