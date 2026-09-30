/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.calllist;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.interapp.phone.ITelCallInformation;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Stack;
import org.dsi.ifc.telephoneng.CallInformation;

public abstract class AbstractPhoneCall
extends CallInformation
implements ITelCallInformation {
    private static final int DISCONNECT_REASON_UNKNOWN = -1;
    private int disconnectReason = -1;
    private final Stack callStateHistory = new Stack();
    private int callDuration;
    private boolean hangupByUser;
    private int previousCallState;
    private final boolean isConferenceCall;

    protected AbstractPhoneCall(CallInformation callInformation, boolean bl) {
        this.isConferenceCall = bl;
        this.setCallInformationState(callInformation);
    }

    private void setCallInformationState(CallInformation callInformation) {
        this.telCallID = callInformation.telCallID;
        this.telCallStartingTime = callInformation.telCallStartingTime;
        this.telCallState = callInformation.telCallState;
        this.telCallType = callInformation.telCallType;
        this.telMpty = callInformation.telMpty;
        this.telNumType = callInformation.telNumType;
        this.telRemEntryId = callInformation.telRemEntryId;
        this.telRemName = callInformation.telRemName;
        this.telRemLastName = callInformation.telRemLastName;
        this.telRemFirstName = callInformation.telRemFirstName;
        this.telRemOrganization = callInformation.telRemOrganization;
        this.telRemNumber = callInformation.telRemNumber;
        this.telRemNumberType = callInformation.telRemNumberType;
        this.telRemPictureId = callInformation.telRemPictureId;
        this.extendedCallInformation = callInformation.extendedCallInformation;
        this.updateCallStateHistory(this.telCallState);
    }

    public void updateCall(CallInformation callInformation) {
        this.setCallInformationState(callInformation);
    }

    public boolean isConferenceCall() {
        return this.isConferenceCall;
    }

    private void updateCallStateHistory(int n) {
        Integer n2 = new Integer(n);
        if (this.callStateHistory.empty()) {
            this.callStateHistory.push(n2);
        } else {
            Integer n3 = (Integer)this.callStateHistory.peek();
            if (!n2.equals(n3)) {
                this.previousCallState = n3;
                this.callStateHistory.push(n2);
            }
        }
    }

    public void setDisconnectReason(int n) {
        this.disconnectReason = n;
    }

    public int getDisconnectReason() {
        return this.disconnectReason;
    }

    public void setCallDuration(int n) {
        this.callDuration = n;
    }

    public int getCallDuration() {
        return this.callDuration;
    }

    public boolean callWasActive() {
        return this.isStateInHistory(4);
    }

    public boolean isOutgoingCall() {
        return this.isStateInHistory(1);
    }

    private boolean isStateInHistory(int n) {
        return this.callStateHistory.contains(new Integer(n));
    }

    public void setHangupByUser() {
        this.hangupByUser = true;
    }

    public boolean isHangupByUser() {
        return this.hangupByUser;
    }

    public boolean isConferenceMember() {
        return this.telCallType != 4 && this.telMpty == 1;
    }

    boolean hasCallTransitionedToState(int n) {
        return this.callStateHistory.contains(new Integer(n));
    }

    int getCallStateHistorySize() {
        return this.callStateHistory.size();
    }

    public int getPreviousCallState() {
        return this.previousCallState;
    }

    public abstract HMIResourceLocator getHMIResourceLocator();

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("telCallID");
        buffer.append('=');
        buffer.append(this.telCallID);
        buffer.append(',');
        buffer.append("telCallState");
        buffer.append('=');
        buffer.append(this.telCallState);
        buffer.append(',');
        buffer.append("telMpty");
        buffer.append('=');
        buffer.append(this.telMpty);
        buffer.append(',');
        buffer.append("telRemName");
        buffer.append('=');
        buffer.append('\"');
        buffer.append(this.telRemName);
        buffer.append('\"');
        buffer.append(',');
        buffer.append("telRemNumber");
        buffer.append('=');
        buffer.append('\"');
        buffer.append(this.telRemNumber);
        buffer.append('\"');
        buffer.append(',');
        buffer.append("telRemPictureId");
        buffer.append('=');
        buffer.append(this.telRemPictureId);
        buffer.append(',');
        buffer.append("telNumType");
        buffer.append('=');
        buffer.append(this.telNumType);
        buffer.append(',');
        buffer.append("telCallType");
        buffer.append('=');
        buffer.append(this.telCallType);
        buffer.append(',');
        buffer.append("telRemEntryId");
        buffer.append('=');
        buffer.append(this.telRemEntryId);
        buffer.append(',');
        buffer.append("telRemNumberType");
        buffer.append('=');
        buffer.append(this.telRemNumberType);
        buffer.append(',');
        buffer.append("telCallStartingTime");
        buffer.append('=');
        buffer.append(this.telCallStartingTime);
        buffer.append(',');
        buffer.append("extendedCallInformation");
        buffer.append('=');
        buffer.append(this.extendedCallInformation);
        buffer.append(',');
        buffer.append("telCallCarrier");
        buffer.append('=');
        buffer.append(this.telCallCarrier);
        buffer.append(',');
        buffer.append("callDuration");
        buffer.append('=');
        buffer.append(this.callDuration);
        buffer.append(',');
        buffer.append("disconnectReason");
        buffer.append('=');
        buffer.append(this.disconnectReason);
        buffer.append(',');
        buffer.append("previousCallState");
        buffer.append('=');
        buffer.append(this.previousCallState);
        return buffer.toString();
    }
}

