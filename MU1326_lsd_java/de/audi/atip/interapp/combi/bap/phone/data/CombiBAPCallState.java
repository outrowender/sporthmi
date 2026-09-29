/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.phone.data;

import de.esolutions.fw.util.commons.Buffer;

public final class CombiBAPCallState {
    private int callState = 0;
    private int callType = 0;
    public static final int CALL_OPTION_ACCEPT_CALL;
    public static final int CALL_OPTION_MP_CALL_HOLD_ACCEPT_WAITING_CALL;
    public static final int CALL_OPTION_MP_RELEASE_ACTIVE_CALL_ACCEPT_WAITING_CALL;
    public static final int CALL_OPTION_CALL_HOLD;
    public static final int CALL_OPTION_RESUME_CALL;
    public static final int CALL_OPTION_MP_SWAP;
    public static final int CALL_OPTION_CC_JOIN;
    public static final int CALL_OPTION_CC_SPLIT;
    private int callOptions = 0;
    private boolean callIncomingDiverted;
    private boolean callOutgoingDiverted;
    private int telMpty;

    public CombiBAPCallState() {
        this(0, 0, 0);
    }

    public CombiBAPCallState(int n, int n2, int n3) {
        this.callState = n;
        this.callType = n2;
        this.telMpty = n3;
    }

    public int getCallState() {
        return this.callState;
    }

    public void setCallState(int n) {
        this.callState = n;
    }

    public int getCallType() {
        return this.callType;
    }

    public void setCallType(int n) {
        this.callType = n;
    }

    public void setCallOptions(int n) {
        this.callOptions = n;
    }

    private void setCallOptionEnabled(int n, boolean bl) {
        if (bl) {
            this.callOptions |= n;
        } else if (this.isCallOptionEnabled(n)) {
            this.callOptions ^= n;
        }
    }

    private boolean isCallOptionEnabled(int n) {
        return (this.callOptions & n) == n;
    }

    public boolean isCallOptionAcceptCallEnabled() {
        return this.isCallOptionEnabled(1);
    }

    public void setCallOptionAcceptCallEnabled(boolean bl) {
        this.setCallOptionEnabled(1, bl);
    }

    public boolean isCallOptionMPCallHoldAcceptWaitingCallEnabled() {
        return this.isCallOptionEnabled(2);
    }

    public void setCallOptionMPCallHoldAcceptWaitingCallEnabled(boolean bl) {
        this.setCallOptionEnabled(2, bl);
    }

    public boolean isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled() {
        return this.isCallOptionEnabled(4);
    }

    public void setCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled(boolean bl) {
        this.setCallOptionEnabled(4, bl);
    }

    public boolean isCallOptionCallHoldEnabled() {
        return this.isCallOptionEnabled(8);
    }

    public void setCallOptionCallHoldEnabled(boolean bl) {
        this.setCallOptionEnabled(8, bl);
    }

    public boolean isCallOptionResumeCallEnabled() {
        return this.isCallOptionEnabled(16);
    }

    public void setCallOptionResumeCallEnabled(boolean bl) {
        this.setCallOptionEnabled(16, bl);
    }

    public boolean isCallOptionMPSwapEnabled() {
        return this.isCallOptionEnabled(32);
    }

    public void setCallOptionMPSwapEnabled(boolean bl) {
        this.setCallOptionEnabled(32, bl);
    }

    public boolean isCallOptionCCJoinEnabled() {
        return this.isCallOptionEnabled(64);
    }

    public void setCallOptionCCJoinEnabled(boolean bl) {
        this.setCallOptionEnabled(64, bl);
    }

    public boolean isCallOptionCCSplitEnabled() {
        return this.isCallOptionEnabled(128);
    }

    public void setCallOptionCCSplitEnabled(boolean bl) {
        this.setCallOptionEnabled(128, bl);
    }

    public boolean isCallIncomingDiverted() {
        return this.callIncomingDiverted;
    }

    public void setCallIncomingDiverted(boolean bl) {
        this.callIncomingDiverted = bl;
    }

    public boolean isCallOutgoingDiverted() {
        return this.callOutgoingDiverted;
    }

    public void setCallOutgoingDiverted(boolean bl) {
        this.callOutgoingDiverted = bl;
    }

    public int getTelMpty() {
        return this.telMpty;
    }

    public boolean equals(Object object) {
        if (object instanceof CombiBAPCallState) {
            CombiBAPCallState combiBAPCallState = (CombiBAPCallState)object;
            if (this.callState == combiBAPCallState.callState && this.callType == combiBAPCallState.callType && this.callOptions == combiBAPCallState.callOptions && this.telMpty == combiBAPCallState.telMpty && this.callIncomingDiverted == combiBAPCallState.callIncomingDiverted && this.callOutgoingDiverted == combiBAPCallState.callOutgoingDiverted) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int n = 11;
        int n2 = 29;
        n = n * n2 + this.callState;
        n = n * n2 + this.callType;
        n = n * n2 + this.callOptions;
        n = n * n2 + this.telMpty;
        n = n * n2 + (this.callIncomingDiverted ? 0 : 1);
        n = n * n2 + (this.callOutgoingDiverted ? 0 : 1);
        return n;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CombiBAPCallState(");
        buffer.append("callIncomingDiverted=");
        buffer.append(this.callIncomingDiverted);
        buffer.append(", callOutgoingDiverted=");
        buffer.append(this.callOutgoingDiverted);
        buffer.append(", callState=");
        buffer.append(this.callState);
        buffer.append(", callType=");
        buffer.append(this.callType);
        buffer.append(", telMpty=");
        buffer.append(this.telMpty);
        buffer.append(", callOptions=");
        buffer.append(this.callOptions);
        buffer.append(")");
        return buffer.toString();
    }
}

