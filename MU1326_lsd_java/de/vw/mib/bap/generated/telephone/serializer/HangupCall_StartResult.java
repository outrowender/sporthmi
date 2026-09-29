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
    private static final int CALL_ID_BITSIZE;
    public static final int CALL_ID_CALL0;
    public static final int CALL_ID_CALL1;
    public static final int CALL_ID_CALL2;
    public static final int CALL_ID_CALL3;
    public static final int CALL_ID_CALL4;
    public static final int CALL_ID_CALL5;
    public static final int CALL_ID_CALL6;
    public static final int CALL_ID_ALL_ACTIVE_CALLS;
    public static final int CALL_ID_ALL_HELD_CALLS;
    public static final int CALL_ID_ALL_ACTIVE_HELD_CALLS;
    public static final int CALL_ID_ALL_CALLS;

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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        HangupCall_StartResult hangupCall_StartResult = (HangupCall_StartResult)bAPEntity;
        return this.callId == hangupCall_StartResult.callId;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.callId);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.callId = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 29;
    }

    @Override
    public int getFunctionId() {
        return HangupCall_StartResult.functionId();
    }
}

