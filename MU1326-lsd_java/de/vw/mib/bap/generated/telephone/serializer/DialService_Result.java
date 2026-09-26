/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class DialService_Result
implements ResultMethod {
    public int dialService_Result;
    private static final int DIAL_SERVICE_RESULT_BITSIZE;
    public static final int DIAL_SERVICE_RESULT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_ABORT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_ABORT_NOT_SUCCESSFUL;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_SERVICE_NOT_AVAILABLE;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NO_NETWORK;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_NETWORK;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED_BY_MOBILE;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_CONFIRM_EMERGENCY_CALL;
    public static final int DIAL_SERVICE_RESULT_NOT_SUCCESSFUL_AUTOMATIC_REDIAL_ACTIVE;

    @Override
    public int getResultCode() {
        return this.dialService_Result;
    }

    public DialService_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public DialService_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.dialService_Result = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        DialService_Result dialService_Result = (DialService_Result)bAPEntity;
        return this.dialService_Result == dialService_Result.dialService_Result;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DialService_Result:");
        stringBuffer.append("\n - DialService_Result: ");
        switch (this.dialService_Result) {
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
                stringBuffer.append("0x04 (not successful - service not available)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (not successful - no network)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (not successful - not supported by network)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (not successful - not supported by mobile)");
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
        bitStream.pushByte((byte)this.dialService_Result);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.dialService_Result = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 27;
    }

    @Override
    public int getFunctionId() {
        return DialService_Result.functionId();
    }
}

