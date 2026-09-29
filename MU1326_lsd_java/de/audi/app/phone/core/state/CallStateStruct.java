/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.state;

import de.audi.app.phone.core.calllist.AbstractPhoneCall;
import de.audi.app.phone.core.calllist.ConferenceCall;
import de.audi.app.phone.core.calllist.SingleCall;
import de.audi.app.phone.core.state.CallState;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.telephoneng.CallInformation;

public class CallStateStruct {
    private final AbstractPhoneCall[] phoneCalls;
    private final CallInformation[] dsiCallList;
    private final boolean hasActiveSingleCall;
    private final boolean hasActiveConferenceCall;
    private final boolean hasActiveCall;
    private final boolean hasOutgoingCall;
    private final boolean hasDisconnectingSingleCall;
    private final boolean hasDisconnectingCall;
    private final boolean hasOnHoldSingleCall;
    private final boolean hasOnHoldCall;
    private final boolean hasOnHoldConferenceCall;
    private final boolean hasDisconnectingConferenceCall;
    private final boolean hasIncomingCall;
    private final boolean hasEmergencyCall;
    private final boolean hasInfoCall;
    private final boolean hasBreakdownCall;
    private final boolean hasOperatorCall;
    private final boolean multipartyActive;
    private final int mpCallState;
    private final int previousMPCallState;
    private final AbstractPhoneCall activeCall;
    private final AbstractPhoneCall outgoingCall;
    private final AbstractPhoneCall heldCall;
    private final AbstractPhoneCall incomingCall;
    private final AbstractPhoneCall disconnectingCall;
    private final AbstractPhoneCall emergencyCall;
    private final ConferenceCall conferenceCall;
    private final int transition;
    private final int callStateChoiceValue;
    private final boolean hasBCall;
    private final boolean hasCCall;
    private final boolean hasPCall;

    public CallStateStruct(CallState callState) {
        AbstractPhoneCall[] abstractPhoneCallArray = callState.getPhoneCalls();
        CallInformation[] callInformationArray = callState.getDsiCallList();
        this.phoneCalls = abstractPhoneCallArray != null ? (AbstractPhoneCall[])abstractPhoneCallArray.clone() : null;
        this.dsiCallList = callInformationArray != null ? (CallInformation[])callInformationArray.clone() : null;
        this.hasActiveSingleCall = callState.hasActiveSingleCall();
        this.hasActiveConferenceCall = callState.hasActiveConferenceCall();
        this.hasActiveCall = callState.hasActiveCall();
        this.hasOutgoingCall = callState.hasOutgoingCall();
        this.hasDisconnectingSingleCall = callState.hasDisconnectingSingleCall();
        this.hasDisconnectingCall = callState.hasDisconnectingCall();
        this.hasOnHoldSingleCall = callState.hasOnHoldSingleCall();
        this.hasOnHoldCall = callState.hasOnHoldCall();
        this.hasOnHoldConferenceCall = callState.hasOnHoldConferenceCall();
        this.hasDisconnectingConferenceCall = callState.hasDisconnectingConferenceCall();
        this.hasIncomingCall = callState.hasIncomingCall();
        this.hasEmergencyCall = callState.hasEmergencyCall();
        this.hasInfoCall = callState.hasInfoCall();
        this.hasBreakdownCall = callState.hasBreakdownCall();
        this.hasOperatorCall = callState.hasOperatorCall();
        this.multipartyActive = callState.isMultipartyActive();
        this.mpCallState = callState.getMpCallState();
        this.previousMPCallState = callState.getPreviousMPCallState();
        this.activeCall = callState.getActiveCall();
        this.outgoingCall = callState.getOutgoingCall();
        this.heldCall = callState.getHeldCall();
        this.incomingCall = callState.getIncomingCall();
        this.disconnectingCall = callState.getDisconnectingCall();
        this.emergencyCall = callState.getEmergencyCall();
        this.conferenceCall = callState.getConferenceCall();
        this.transition = callState.getTransition();
        this.callStateChoiceValue = callState.getCallStateChoiceValue();
        this.hasBCall = callState.hasBCall();
        this.hasPCall = callState.hasPCall();
        this.hasCCall = callState.hasCCall();
    }

    public AbstractPhoneCall[] getPhoneCalls() {
        return this.phoneCalls;
    }

    public CallInformation[] getDsiCallList() {
        return this.dsiCallList;
    }

    public boolean isHasActiveSingleCall() {
        return this.hasActiveSingleCall;
    }

    public boolean isHasActiveConferenceCall() {
        return this.hasActiveConferenceCall;
    }

    public boolean isHasActiveCall() {
        return this.hasActiveCall;
    }

    public boolean isHasOutgoingCall() {
        return this.hasOutgoingCall;
    }

    public boolean isHasDisconnectingSingleCall() {
        return this.hasDisconnectingSingleCall;
    }

    public boolean isHasDisconnectingCall() {
        return this.hasDisconnectingCall;
    }

    public boolean isHasOnHoldSingleCall() {
        return this.hasOnHoldSingleCall;
    }

    public boolean isHasOnHoldCall() {
        return this.hasOnHoldCall;
    }

    public boolean isHasOnHoldConferenceCall() {
        return this.hasOnHoldConferenceCall;
    }

    public boolean isHasDisconnectingConferenceCall() {
        return this.hasDisconnectingConferenceCall;
    }

    public boolean isHasIncomingCall() {
        return this.hasIncomingCall;
    }

    public boolean isHasEmergencyCall() {
        return this.hasEmergencyCall;
    }

    public boolean isHasInfoCall() {
        return this.hasInfoCall;
    }

    public boolean isHasBreakdownCall() {
        return this.hasBreakdownCall;
    }

    public boolean isHasOperatorCall() {
        return this.hasOperatorCall || this.hasBCall || this.hasPCall || this.hasCCall;
    }

    public boolean isHasBCall() {
        return this.hasBCall;
    }

    public boolean isHasCCall() {
        return this.hasCCall;
    }

    public boolean isHasPCall() {
        return this.hasPCall;
    }

    public boolean isMultipartyActive() {
        return this.multipartyActive;
    }

    public int getMpCallState() {
        return this.mpCallState;
    }

    public int getPreviousMPCallState() {
        return this.previousMPCallState;
    }

    public int getNrCalls() {
        return this.phoneCalls.length;
    }

    public AbstractPhoneCall getActiveCall() {
        return this.activeCall;
    }

    public AbstractPhoneCall getOutgoingCall() {
        return this.outgoingCall;
    }

    public AbstractPhoneCall getHeldCall() {
        return this.heldCall;
    }

    public AbstractPhoneCall getIncomingCall() {
        return this.incomingCall;
    }

    public AbstractPhoneCall getDisconnectingCall() {
        return this.disconnectingCall;
    }

    public AbstractPhoneCall getEmergencyCall() {
        return this.emergencyCall;
    }

    public ConferenceCall getConferenceCall() {
        return this.conferenceCall;
    }

    public AbstractPhoneCall getCall(short s) {
        AbstractPhoneCall abstractPhoneCall = null;
        if (this.phoneCalls != null) {
            for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                AbstractPhoneCall abstractPhoneCall2 = this.phoneCalls[i2];
                if (abstractPhoneCall2 instanceof SingleCall && abstractPhoneCall2.getTelCallID() == s) {
                    abstractPhoneCall = abstractPhoneCall2;
                    continue;
                }
                if (!(abstractPhoneCall2 instanceof ConferenceCall)) continue;
                ConferenceCall conferenceCall = (ConferenceCall)abstractPhoneCall2;
                AbstractPhoneCall[] abstractPhoneCallArray = conferenceCall.getMembers();
                abstractPhoneCall = this.determineMember(abstractPhoneCallArray, s);
            }
        }
        return abstractPhoneCall;
    }

    private AbstractPhoneCall determineMember(AbstractPhoneCall[] abstractPhoneCallArray, short s) {
        AbstractPhoneCall abstractPhoneCall = null;
        for (int i2 = 0; i2 < abstractPhoneCallArray.length; ++i2) {
            abstractPhoneCall = abstractPhoneCallArray[i2];
            if (abstractPhoneCall == null || abstractPhoneCall.getTelCallID() != s) continue;
            return abstractPhoneCall;
        }
        return abstractPhoneCall;
    }

    public boolean isIdle() {
        return this.phoneCalls == null || this.phoneCalls.length == 0;
    }

    public int getTransition() {
        return this.transition;
    }

    public int getCallStateChoiceValue() {
        return this.callStateChoiceValue;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Current Call State\n");
        buffer.append("--------------------------------------\n");
        buffer.append("hasActiveSingleCall=");
        buffer.append(this.hasActiveSingleCall);
        buffer.append("\n");
        buffer.append("hasActiveConferenceCall=");
        buffer.append(this.hasActiveConferenceCall);
        buffer.append("\n");
        buffer.append("hasActiveCall=");
        buffer.append(this.hasActiveCall);
        buffer.append("\n");
        buffer.append("hasOutgoingCall=");
        buffer.append(this.hasOutgoingCall);
        buffer.append("\n");
        buffer.append("hasDisconnectingSingleCall=");
        buffer.append(this.hasDisconnectingSingleCall);
        buffer.append("\n");
        buffer.append("hasDisconnectingCall=");
        buffer.append(this.hasDisconnectingCall);
        buffer.append("\n");
        buffer.append("hasOnHoldSingleCall=");
        buffer.append(this.hasOnHoldSingleCall);
        buffer.append("\n");
        buffer.append("hasOnHoldCall=");
        buffer.append(this.hasOnHoldCall);
        buffer.append("\n");
        buffer.append("hasOnHoldConferenceCall=");
        buffer.append(this.hasOnHoldConferenceCall);
        buffer.append("\n");
        buffer.append("hasDisconnectingConferenceCall=");
        buffer.append(this.hasDisconnectingConferenceCall);
        buffer.append("\n");
        buffer.append("hasIncomingCall=");
        buffer.append(this.hasIncomingCall);
        buffer.append("\n");
        buffer.append("hasEmergencyCall=");
        buffer.append(this.hasEmergencyCall);
        buffer.append("\n");
        buffer.append("hasInfoCall=");
        buffer.append(this.hasInfoCall);
        buffer.append("\n");
        buffer.append("hasBreakdownCall=");
        buffer.append(this.hasBreakdownCall);
        buffer.append("\n");
        buffer.append("hasOperatorCall=");
        buffer.append(this.hasOperatorCall);
        buffer.append("\n");
        buffer.append("hasBCall=");
        buffer.append(this.hasBCall);
        buffer.append("\n");
        buffer.append("hasPCall=");
        buffer.append(this.hasPCall);
        buffer.append("\n");
        buffer.append("hasCCall=");
        buffer.append(this.hasCCall);
        buffer.append("\n");
        buffer.append("multipartyActive=");
        buffer.append(this.multipartyActive);
        buffer.append("\n");
        buffer.append("mpCallState=");
        buffer.append(this.mpCallState);
        buffer.append("\n");
        buffer.append("previousMPCallState=");
        buffer.append(this.previousMPCallState);
        buffer.append("\n");
        buffer.append("activeCall=");
        buffer.append(this.activeCall);
        buffer.append("\n");
        buffer.append("outgoingCall=");
        buffer.append(this.outgoingCall);
        buffer.append("\n");
        buffer.append("heldCall=");
        buffer.append(this.heldCall);
        buffer.append("\n");
        buffer.append("incomingCall=");
        buffer.append(this.incomingCall);
        buffer.append("\n");
        buffer.append("disconnectingCall=");
        buffer.append(this.disconnectingCall);
        buffer.append("\n");
        buffer.append("emergencyCall=");
        buffer.append(this.emergencyCall);
        buffer.append("\n");
        buffer.append("transition=");
        buffer.append(CallState.getTransitionString(this.transition));
        buffer.append("\n");
        buffer.append("--------------------------------------");
        return buffer.toString();
    }
}

