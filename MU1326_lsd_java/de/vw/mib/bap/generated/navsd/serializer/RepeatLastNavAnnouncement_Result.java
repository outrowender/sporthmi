/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class RepeatLastNavAnnouncement_Result
implements ResultMethod {
    public int repeatLna_Result;
    private static final int REPEAT_LNA_RESULT_BITSIZE = 8;
    public static final int REPEAT_LNA_RESULT_SUCCESSFUL = 0;
    public static final int REPEAT_LNA_RESULT_NOT_SUCCESSFUL = 1;
    public static final int REPEAT_LNA_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int REPEAT_LNA_RESULT_ABORT_NOT_SUCCESSFUL = 3;

    public int getResultCode() {
        return this.repeatLna_Result;
    }

    public RepeatLastNavAnnouncement_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public RepeatLastNavAnnouncement_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.repeatLna_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        RepeatLastNavAnnouncement_Result repeatLastNavAnnouncement_Result = (RepeatLastNavAnnouncement_Result)bAPEntity;
        return this.repeatLna_Result == repeatLastNavAnnouncement_Result.repeatLna_Result;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("RepeatLastNavAnnouncement_Result:");
        stringBuffer.append("\n - RepeatLNA_Result: ");
        switch (this.repeatLna_Result) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (abort successful)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (abort not successful)");
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
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.repeatLna_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.repeatLna_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 35;
    }

    public int getFunctionId() {
        return RepeatLastNavAnnouncement_Result.functionId();
    }
}

