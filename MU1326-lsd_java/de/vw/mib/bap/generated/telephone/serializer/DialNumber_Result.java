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
    private static final int DIAL_NUMBER_RESULT_BITSIZE;
    public static final int DIAL_NUMBER_RESULT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_ABORT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NUMBER_INVALID;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_NO_NETWORK;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL;
    public static final int DIAL_NUMBER_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE;

    @Override
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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialNumber_Result dialNumber_Result = (DialNumber_Result)bAPEntity;
        return this.dialNumber_Result == dialNumber_Result.dialNumber_Result;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.dialNumber_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.dialNumber_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 26;
    }

    @Override
    public int getFunctionId() {
        return DialNumber_Result.functionId();
    }
}

