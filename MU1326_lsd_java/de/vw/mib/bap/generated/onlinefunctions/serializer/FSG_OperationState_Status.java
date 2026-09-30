/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.onlinefunctions.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_OperationState_Status
implements StatusProperty {
    public int op_State;
    private static final int OP_STATE_BITSIZE = 8;
    public static final int OP_STATE_NORMAL_OPERATION = 0;
    public static final int OP_STATE_OFF_STANDBY = 1;
    public static final int OP_STATE_INITIALISING = 3;
    public static final int OP_STATE_DEFECTIVE = 15;
    public static final int EXTENSION1_MIN = 0;
    public int extension1;
    private static final int EXTENSION1_BITSIZE = 8;

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
        this.extension1 = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPEntity;
        return this.op_State == fSG_OperationState_Status.op_State && this.extension1 == fSG_OperationState_Status.extension1;
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
                stringBuffer.append("0x01 (off/standby)");
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
        stringBuffer.append("\n - Extension1 - ");
        stringBuffer.append(this.extension1);
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.op_State);
        bitStream.pushByte((byte)this.extension1);
    }

    public void deserialize(BitStream bitStream) {
        this.op_State = bitStream.popFrontByte();
        this.extension1 = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 15;
    }

    public int getFunctionId() {
        return FSG_OperationState_Status.functionId();
    }
}

