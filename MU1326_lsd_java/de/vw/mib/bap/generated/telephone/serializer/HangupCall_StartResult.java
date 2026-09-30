/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StartResultMethod;
import de.vw.mib.bap.stream.BitStream;

public final class HangupCall_StartResult
implements StartResultMethod {
    public int callId;
    private static final int CALL_ID_BITSIZE = 8;
    public static final int CALL_ID_CALL0 = 0;
    public static final int CALL_ID_CALL1 = 1;
    public static final int CALL_ID_CALL2 = 2;
    public static final int CALL_ID_CALL3 = 3;
    public static final int CALL_ID_CALL4 = 4;
    public static final int CALL_ID_CALL5 = 5;
    public static final int CALL_ID_CALL6 = 6;
    public static final int CALL_ID_ALL_ACTIVE_CALLS = 252;
    public static final int CALL_ID_ALL_HELD_CALLS = 253;
    public static final int CALL_ID_ALL_ACTIVE_HELD_CALLS = 254;
    public static final int CALL_ID_ALL_CALLS = 255;

    public HangupCall_StartResult() {
        this.internalReset();
        this.customInitialization();
    }

    public HangupCall_StartResult(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.callId = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        HangupCall_StartResult hangupCall_StartResult = (HangupCall_StartResult)bAPEntity;
        return this.callId == hangupCall_StartResult.callId;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("HangupCall_StartResult:");
        stringBuffer.append("\n - CallID: ");
        switch (this.callId) {
            case 0: {
                stringBuffer.append("0x00 (Call0)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (Call1)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (Call2)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (Call3)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (Call4)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (Call5)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (Call6)");
                break;
            }
            case 252: {
                stringBuffer.append("0xFC (all active calls)");
                break;
            }
            case 253: {
                stringBuffer.append("0xFD (all held calls)");
                break;
            }
            case 254: {
                stringBuffer.append("0xFE (all active & held calls)");
                break;
            }
            case 255: {
                stringBuffer.append("0xFF (all calls)");
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
        bitStream.pushByte((byte)this.callId);
    }

    public void deserialize(BitStream bitStream) {
        this.callId = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 29;
    }

    public int getFunctionId() {
        return HangupCall_StartResult.functionId();
    }
}

