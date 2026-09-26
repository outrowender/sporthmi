/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ConfirmEmergencyCall_Result
implements ResultMethod {
    public int confirmErmergencyCall_Result;
    private static final int CONFIRM_ERMERGENCY_CALL_RESULT_BITSIZE;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_ABORT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int CONFIRM_ERMERGENCY_CALL_RESULT_NOT_SUCCESSFUL_NO_EMERGENCY_CALL_PENDING;

    @Override
    public int getResultCode() {
        return this.confirmErmergencyCall_Result;
    }

    public ConfirmEmergencyCall_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public ConfirmEmergencyCall_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.confirmErmergencyCall_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        ConfirmEmergencyCall_Result confirmEmergencyCall_Result = (ConfirmEmergencyCall_Result)bAPEntity;
        return this.confirmErmergencyCall_Result == confirmEmergencyCall_Result.confirmErmergencyCall_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ConfirmEmergencyCall_Result:");
        stringBuffer.append("\n - ConfirmErmergencyCall_Result: ");
        switch (this.confirmErmergencyCall_Result) {
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
                stringBuffer.append("0x04 (not successful - no emergency call pending)");
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
        bitStream.pushByte((byte)this.confirmErmergencyCall_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.confirmErmergencyCall_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 28;
    }

    @Override
    public int getFunctionId() {
        return ConfirmEmergencyCall_Result.functionId();
    }
}

