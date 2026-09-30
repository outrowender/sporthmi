/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.mfl.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class PU_Action_StartResult
implements StartResultMethod {
    public int taid;
    private static final int TAID_BITSIZE = 8;
    public int option;
    private static final int OPTION_BITSIZE = 8;
    public static final int OPTION_QUIT = 0;
    public static final int OPTION_OPTION_1 = 1;
    public static final int OPTION_OPTION_2 = 2;
    public static final int OPTION_OPTION_3 = 3;
    public static final int OPTION_OPTION_4 = 4;

    public int getTransactionId() {
        return this.taid;
    }

    public void setTransactionId(int n) {
        this.taid = n;
    }

    public PU_Action_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public PU_Action_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.taid = 0;
        this.option = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        PU_Action_StartResult pU_Action_StartResult = (PU_Action_StartResult)bAPEntity;
        return this.taid == pU_Action_StartResult.taid && this.option == pU_Action_StartResult.option;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("PU_Action_StartResult:");
        stringBuffer.append("\n - TAID - ");
        stringBuffer.append(this.taid);
        stringBuffer.append("\n - Option: ");
        switch (this.option) {
            case 0: {
                stringBuffer.append("0x00 (quit)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Option_1)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Option_2)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Option_3)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Option_4)");
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
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.taid);
        bitStream.pushByte((byte)this.option);
    }

    public void deserialize(BitStream bitStream) {
        this.taid = bitStream.popFrontByte();
        this.option = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    public int getFunctionId() {
        return PU_Action_StartResult.functionId();
    }
}

