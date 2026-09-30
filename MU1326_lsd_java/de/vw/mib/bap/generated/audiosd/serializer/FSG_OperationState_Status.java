/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.audiosd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_OperationState_Status
implements StatusProperty {
    public int op_State;
    private static final int OP_STATE_BITSIZE = 8;
    public static final int OP_STATE_NORMAL_OPERATION = 0;
    public static final int OP_STATE_OFF_STAND_BY = 1;
    public static final int OP_STATE_INITIALISING = 3;
    public static final int OP_STATE_DEFECTIVE = 15;
    public int hmi_State;
    private static final int HMI_STATE_BITSIZE = 8;
    public static final int HMI_STATE_NO_ANIMATION_RUNNING_ON_FSG_HMI_STATE_UNKNOWN = 0;
    public static final int HMI_STATE_WELCOME_ANIMATION_RUNNING_ON_FSG = 1;

    public FSG_OperationState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_OperationState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.op_State = 0;
        this.hmi_State = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPEntity;
        return this.op_State == fSG_OperationState_Status.op_State && this.hmi_State == fSG_OperationState_Status.hmi_State;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_OperationState_Status:");
        stringBuffer.append("\n - OP_State: ");
        switch (this.op_State) {
            case 0: {
                stringBuffer.append("0x00 (normal operation)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (OFF / stand-by)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (initialising)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (defective)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - HMI_State: ");
        switch (this.hmi_State) {
            case 0: {
                stringBuffer.append("0x00 (no animation running on FSG / HMI state unknown)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (\\\"welcome\\\" animation running on FSG)");
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
        bitStream.pushByte((byte)this.op_State);
        bitStream.pushByte((byte)this.hmi_State);
    }

    public void deserialize(BitStream bitStream) {
        this.op_State = bitStream.popFrontByte();
        this.hmi_State = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 15;
    }

    public int getFunctionId() {
        return FSG_OperationState_Status.functionId();
    }
}

