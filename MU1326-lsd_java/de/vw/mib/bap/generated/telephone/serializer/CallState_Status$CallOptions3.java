/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class CallState_Status$CallOptions3
implements BAPEntity {
    public boolean ccsplit;
    public boolean ccjoin;
    public boolean mpswap;
    public boolean resumeCall;
    public boolean callHold;
    public boolean mpreleaseActiceCallAcceptWaitingCall;
    public boolean mpcallHoldAcceptWaitingCall;
    public boolean acceptCall;
    private static final int CALL_OPTIONS3_BITSIZE;

    public CallState_Status$CallOptions3() {
        this.internalReset();
        this.customInitialization();
    }

    public CallState_Status$CallOptions3(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.ccsplit = false;
        this.ccjoin = false;
        this.mpswap = false;
        this.resumeCall = false;
        this.callHold = false;
        this.mpreleaseActiceCallAcceptWaitingCall = false;
        this.mpcallHoldAcceptWaitingCall = false;
        this.acceptCall = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        CallState_Status$CallOptions3 callState_Status$CallOptions3 = (CallState_Status$CallOptions3)bAPEntity;
        return this.ccsplit == callState_Status$CallOptions3.ccsplit && this.ccjoin == callState_Status$CallOptions3.ccjoin && this.mpswap == callState_Status$CallOptions3.mpswap && this.resumeCall == callState_Status$CallOptions3.resumeCall && this.callHold == callState_Status$CallOptions3.callHold && this.mpreleaseActiceCallAcceptWaitingCall == callState_Status$CallOptions3.mpreleaseActiceCallAcceptWaitingCall && this.mpcallHoldAcceptWaitingCall == callState_Status$CallOptions3.mpcallHoldAcceptWaitingCall && this.acceptCall == callState_Status$CallOptions3.acceptCall;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("CallOptions3:");
        stringBuffer.append("\n - Bit 7: ");
        if (this.ccsplit) {
            stringBuffer.append("true  (CCSplit");
        } else {
            stringBuffer.append("false  (option not available");
        }
        stringBuffer.append("\n - Bit 6: ");
        if (this.ccjoin) {
            stringBuffer.append("true  (CCJoin");
        } else {
            stringBuffer.append("false  (option not available");
        }
        stringBuffer.append("\n - Bit 5: ");
        if (this.mpswap) {
            stringBuffer.append("true  (MPSwap");
        } else {
            stringBuffer.append("false  (option not available");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.resumeCall) {
            stringBuffer.append("true  (ResumeCall");
        } else {
            stringBuffer.append("false  (option not available");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.callHold) {
            stringBuffer.append("true  (CallHold");
        } else {
            stringBuffer.append("false  (option not available");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.mpreleaseActiceCallAcceptWaitingCall) {
            stringBuffer.append("true  (MPReleaseActiceCallAcceptWaitingCall");
        } else {
            stringBuffer.append("false  (option not available");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.mpcallHoldAcceptWaitingCall) {
            stringBuffer.append("true  (MPCallHoldAcceptWaitingCall");
        } else {
            stringBuffer.append("false  (option not available");
        }
        stringBuffer.append("\n - Bit 0: ");
        if (this.acceptCall) {
            stringBuffer.append("true  (AcceptCall");
        } else {
            stringBuffer.append("false  (option not available");
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
        bitStream.pushBoolean(this.ccsplit);
        bitStream.pushBoolean(this.ccjoin);
        bitStream.pushBoolean(this.mpswap);
        bitStream.pushBoolean(this.resumeCall);
        bitStream.pushBoolean(this.callHold);
        bitStream.pushBoolean(this.mpreleaseActiceCallAcceptWaitingCall);
        bitStream.pushBoolean(this.mpcallHoldAcceptWaitingCall);
        bitStream.pushBoolean(this.acceptCall);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.ccsplit = bitStream.popFrontBoolean();
        this.ccjoin = bitStream.popFrontBoolean();
        this.mpswap = bitStream.popFrontBoolean();
        this.resumeCall = bitStream.popFrontBoolean();
        this.callHold = bitStream.popFrontBoolean();
        this.mpreleaseActiceCallAcceptWaitingCall = bitStream.popFrontBoolean();
        this.mpcallHoldAcceptWaitingCall = bitStream.popFrontBoolean();
        this.acceptCall = bitStream.popFrontBoolean();
    }
}

