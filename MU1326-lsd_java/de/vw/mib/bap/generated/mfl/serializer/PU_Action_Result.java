/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class PU_Action_Result
implements ResultMethod {
    public int pu_ActionResult;
    private static final int PU_ACTION_RESULT_BITSIZE;
    public static final int PU_ACTION_RESULT_SUCCESSFUL;
    public static final int PU_ACTION_RESULT_NOT_SUCCESSFUL_NOT_SUPPORTED;
    public static final int PU_ACTION_RESULT_ABORT_SUCCESSFUL;
    public static final int PU_ACTION_RESULT_ABORT_NOT_SUCCESSFUL;

    @Override
    public int getResultCode() {
        return this.pu_ActionResult;
    }

    public PU_Action_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public PU_Action_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.pu_ActionResult = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        PU_Action_Result pU_Action_Result = (PU_Action_Result)bAPEntity;
        return this.pu_ActionResult == pU_Action_Result.pu_ActionResult;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PU_Action_Result:");
        stringBuffer.append("\n - PU_ActionResult: ");
        switch (this.pu_ActionResult) {
            case 0: {
                stringBuffer.append("0x00 (successful)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (not successful / not supported)");
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.pu_ActionResult);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.pu_ActionResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    @Override
    public int getFunctionId() {
        return PU_Action_Result.functionId();
    }
}

