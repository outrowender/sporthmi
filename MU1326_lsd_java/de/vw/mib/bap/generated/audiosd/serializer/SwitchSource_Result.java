/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.ResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class SwitchSource_Result
implements ResultMethod {
    public int switchSourceResult;
    private static final int SWITCH_SOURCE_RESULT_BITSIZE = 8;
    public static final int SWITCH_SOURCE_RESULT_SUCCESSFUL = 0;
    public static final int SWITCH_SOURCE_RESULT_NOT_SUCCESSFUL = 1;
    public static final int SWITCH_SOURCE_RESULT_ABORT_SUCCESSFUL = 2;
    public static final int SWITCH_SOURCE_RESULT_ABORT_NOT_SUCCESSFUL = 3;

    public int getResultCode() {
        return this.switchSourceResult;
    }

    public SwitchSource_Result() {
        this.internalReset();
        this.customInitialization();
    }

    public SwitchSource_Result(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.switchSourceResult = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        SwitchSource_Result switchSource_Result = (SwitchSource_Result)bAPEntity;
        return this.switchSourceResult == switchSource_Result.switchSourceResult;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SwitchSource_Result:");
        stringBuffer.append("\n - SwitchSourceResult: ");
        switch (this.switchSourceResult) {
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
        bitStream.pushByte((byte)this.switchSourceResult);
    }

    public void deserialize(BitStream bitStream) {
        this.switchSourceResult = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 34;
    }

    public int getFunctionId() {
        return SwitchSource_Result.functionId();
    }
}

