/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class ConfirmEmergencyCall_StartResult
implements StartResultMethod {
    public int control;
    private static final int CONTROL_BITSIZE = 8;
    public static final int CONTROL_CONFIRM = 0;
    public static final int CONTROL_CANCEL = 1;

    public ConfirmEmergencyCall_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public ConfirmEmergencyCall_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.control = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        ConfirmEmergencyCall_StartResult confirmEmergencyCall_StartResult = (ConfirmEmergencyCall_StartResult)bAPEntity;
        return this.control == confirmEmergencyCall_StartResult.control;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("ConfirmEmergencyCall_StartResult:");
        stringBuffer.append("\n - Control: ");
        switch (this.control) {
            case 0: {
                stringBuffer.append("0x00 (confirm)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (cancel)");
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
        bitStream.pushByte((byte)this.control);
    }

    public void deserialize(BitStream bitStream) {
        this.control = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 28;
    }

    public int getFunctionId() {
        return ConfirmEmergencyCall_StartResult.functionId();
    }
}

