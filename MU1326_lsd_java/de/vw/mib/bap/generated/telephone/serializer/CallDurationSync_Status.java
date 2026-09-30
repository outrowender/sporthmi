/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class CallDurationSync_Status
implements StatusProperty {
    public int timeStampCall0;
    private static final int TIME_STAMP_CALL0_BITSIZE = 16;
    public int timeStampCall1;
    private static final int TIME_STAMP_CALL1_BITSIZE = 16;
    public int timeStampCall2;
    private static final int TIME_STAMP_CALL2_BITSIZE = 16;
    public int timeStampCall3;
    private static final int TIME_STAMP_CALL3_BITSIZE = 16;
    public int timeStampCall4;
    private static final int TIME_STAMP_CALL4_BITSIZE = 16;
    public int timeStampCall5;
    private static final int TIME_STAMP_CALL5_BITSIZE = 16;
    public int timeStampCall6;
    private static final int TIME_STAMP_CALL6_BITSIZE = 16;

    public CallDurationSync_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public CallDurationSync_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.timeStampCall0 = 0;
        this.timeStampCall1 = 0;
        this.timeStampCall2 = 0;
        this.timeStampCall3 = 0;
        this.timeStampCall4 = 0;
        this.timeStampCall5 = 0;
        this.timeStampCall6 = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        CallDurationSync_Status callDurationSync_Status = (CallDurationSync_Status)bAPEntity;
        return this.timeStampCall0 == callDurationSync_Status.timeStampCall0 && this.timeStampCall1 == callDurationSync_Status.timeStampCall1 && this.timeStampCall2 == callDurationSync_Status.timeStampCall2 && this.timeStampCall3 == callDurationSync_Status.timeStampCall3 && this.timeStampCall4 == callDurationSync_Status.timeStampCall4 && this.timeStampCall5 == callDurationSync_Status.timeStampCall5 && this.timeStampCall6 == callDurationSync_Status.timeStampCall6;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallDurationSync_Status:");
        stringBuffer.append("\n - TimeStampCall0 - ");
        stringBuffer.append(this.timeStampCall0);
        stringBuffer.append("\n - TimeStampCall1 - ");
        stringBuffer.append(this.timeStampCall1);
        stringBuffer.append("\n - TimeStampCall2 - ");
        stringBuffer.append(this.timeStampCall2);
        stringBuffer.append("\n - TimeStampCall3 - ");
        stringBuffer.append(this.timeStampCall3);
        stringBuffer.append("\n - TimeStampCall4 - ");
        stringBuffer.append(this.timeStampCall4);
        stringBuffer.append("\n - TimeStampCall5 - ");
        stringBuffer.append(this.timeStampCall5);
        stringBuffer.append("\n - TimeStampCall6 - ");
        stringBuffer.append(this.timeStampCall6);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 16;
        n += 16;
        n += 16;
        n += 16;
        n += 16;
        n += 16;
        return n += 16;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushShort((short)this.timeStampCall0);
        bitStream.pushShort((short)this.timeStampCall1);
        bitStream.pushShort((short)this.timeStampCall2);
        bitStream.pushShort((short)this.timeStampCall3);
        bitStream.pushShort((short)this.timeStampCall4);
        bitStream.pushShort((short)this.timeStampCall5);
        bitStream.pushShort((short)this.timeStampCall6);
    }

    public void deserialize(BitStream bitStream) {
        this.timeStampCall0 = bitStream.popFrontShort();
        this.timeStampCall1 = bitStream.popFrontShort();
        this.timeStampCall2 = bitStream.popFrontShort();
        this.timeStampCall3 = bitStream.popFrontShort();
        this.timeStampCall4 = bitStream.popFrontShort();
        this.timeStampCall5 = bitStream.popFrontShort();
        this.timeStampCall6 = bitStream.popFrontShort();
    }

    public static int functionId() {
        return 24;
    }

    public int getFunctionId() {
        return CallDurationSync_Status.functionId();
    }
}

