/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialNumber_Result
implements ResultMethod {
    public int dialNumber_Result;
    private static final int DIAL_NUMBER_RESULT_BITSIZE = 8;
    public static final int DIAL_NUMBER_RESULT_SUCCESSFUL = 0;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL = 1;
    public static final int DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL = 3;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID = 4;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK = 5;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL = 10;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE = 12;

    public int getResultCode() {
        return this.dialNumber_Result;
    }

    public DialNumber_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public DialNumber_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dialNumber_Result = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_Result dialNumber_Result = (DialNumber_Result)bAPEntity;
        return this.dialNumber_Result == dialNumber_Result.dialNumber_Result;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialNumber_Result:");
        stringBuffer.append("\n - DialNumber_Result: ");
        switch (this.dialNumber_Result) {
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
            case 4: {
                stringBuffer.append("0x04 (not successful - number invalid)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (not successful - no network)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (not successful - confirm emergency call)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (not successful - automatic redial active)");
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
        bitStream.pushByte((byte)this.dialNumber_Result);
    }

    public void deserialize(BitStream bitStream) {
        this.dialNumber_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    public int getFunctionId() {
        return DialNumber_Result.functionId();
    }
}

