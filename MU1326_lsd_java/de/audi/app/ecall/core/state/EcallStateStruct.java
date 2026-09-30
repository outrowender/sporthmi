/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.state;

import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.ITelState;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Arrays;

public class EcallStateStruct
implements IEcallStateStruct {
    private final int bapAudioSource;
    private final PendingServiceRequests pendingServiceCalls;
    private final int serviceCallKind;
    private final int serviceState;
    private final PhoneCall[] phoneCalls;
    private final ITelState customerTelState;
    private final String emergencyNumberToBeDialed;
    private final EmergencyNumber[] allowedEmergencyNumbersList;

    public EcallStateStruct(int n, PendingServiceRequests pendingServiceRequests, int n2, int n3, PhoneCall[] phoneCallArray, ITelState iTelState, String string, EmergencyNumber[] emergencyNumberArray) {
        this.bapAudioSource = n;
        this.pendingServiceCalls = pendingServiceRequests;
        this.serviceCallKind = n2;
        this.serviceState = n3;
        this.phoneCalls = phoneCallArray;
        this.customerTelState = iTelState;
        this.emergencyNumberToBeDialed = string;
        this.allowedEmergencyNumbersList = emergencyNumberArray;
    }

    public int getBapAudioSource() {
        return this.bapAudioSource;
    }

    public PendingServiceRequests getPendingServiceCalls() {
        return this.pendingServiceCalls;
    }

    public int getServiceCallKind() {
        return this.serviceCallKind;
    }

    public int getServiceState() {
        return this.serviceState;
    }

    public boolean isUSMRequestPresent() {
        return this.pendingServiceCalls != null && this.pendingServiceCalls.isBreakdownServicePending() && this.pendingServiceCalls.isManualEmergencyCallPending();
    }

    public PhoneCall[] getPhoneCalls() {
        return this.phoneCalls;
    }

    public PhoneCall getCurrentPhoneCall() {
        return this.phoneCalls == null ? null : this.phoneCalls[0];
    }

    public PhoneCall getCurrentPhoneCallByKind(int n) {
        if (this.phoneCalls != null) {
            for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                if (this.phoneCalls[i2].getKind() != n) continue;
                return this.phoneCalls[i2];
            }
        }
        return null;
    }

    public PhoneCall getCurrentHighPriorityPhoneCall() {
        if (this.phoneCalls != null) {
            for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                if (this.phoneCalls[i2].isLowPrioritySOSCall()) continue;
                return this.phoneCalls[i2];
            }
        }
        return null;
    }

    public ITelState getCustomerTelState() {
        return this.customerTelState;
    }

    public boolean getCustomerCallActive() {
        return this.customerTelState != null && this.customerTelState.getCallActive();
    }

    public boolean isActiveCustomerCallPresent() {
        return this.customerTelState != null && (this.customerTelState.isActiveCallPresent() || this.customerTelState.isOutgoingCallPresent());
    }

    private boolean isEcallNotIdle() {
        if (this.phoneCalls != null) {
            for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                if (EcallStateStruct.isEcallIdle(this.phoneCalls[i2])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isServiceActive() {
        return this.serviceCallKind == 0 ? this.isEcallNotIdle() : true;
    }

    public boolean isCallActive() {
        if (this.phoneCalls != null) {
            for (int i2 = 0; i2 < this.phoneCalls.length; ++i2) {
                if (!EcallStateStruct.isEcallActive(this.phoneCalls[i2])) continue;
                return true;
            }
        }
        return false;
    }

    public boolean isCallActive(int n) {
        PhoneCall phoneCall = this.getCurrentPhoneCallByKind(n);
        return EcallStateStruct.isEcallActive(phoneCall);
    }

    public boolean isEmergencyConnecting() {
        return this.serviceState == 5 || this.serviceState == 18 || this.serviceState == 7;
    }

    public boolean isEmergencyConnected() {
        return this.serviceState == 6 && this.hasEmergencyCallValidState(2);
    }

    public boolean isEmergencyCallBackIncoming() {
        return this.serviceState == 6 && this.hasEmergencyCallValidState(1);
    }

    public boolean isServiceIDLE() {
        return this.serviceState == 0 && this.serviceCallKind == 0;
    }

    private boolean hasEmergencyCallValidState(int n) {
        return this.hasState(this.getCurrentPhoneCallByKind(9), n) || this.hasState(this.getCurrentPhoneCallByKind(4), n) || this.hasState(this.getCurrentPhoneCallByKind(10), n) || this.hasState(this.getCurrentPhoneCallByKind(8), n);
    }

    private boolean hasState(PhoneCall phoneCall, int n) {
        if (phoneCall != null) {
            return phoneCall.getState() == n;
        }
        return false;
    }

    private static boolean isEcallActive(PhoneCall phoneCall) {
        if (phoneCall == null) {
            return false;
        }
        int n = phoneCall.getState();
        return n == 3 || n == 2;
    }

    private static boolean isEcallIdle(PhoneCall phoneCall) {
        if (phoneCall == null) {
            return true;
        }
        return phoneCall.getState() == 0;
    }

    public String getEmergencyNumberToBeDialed() {
        return this.emergencyNumberToBeDialed;
    }

    public EmergencyNumber[] getAllowedEmergencyNumbersList() {
        return this.allowedEmergencyNumbersList;
    }

    public String toString() {
        return new Buffer().append("EcallStateStruct [bapAudioSource=").append(this.bapAudioSource).append(", pendingServiceCalls=").append(this.pendingServiceCalls).append(", serviceState=").append(this.serviceState).append(", serviceCallKind=").append(this.serviceCallKind).append(", serviceCallState=").append(this.isServiceActive()).append(", phoneCalls=").append(this.phoneCalls != null ? Arrays.asList(this.phoneCalls) : null).append(", allowedEmergencyNumbers=").append(this.allowedEmergencyNumbersList != null ? Arrays.asList(this.allowedEmergencyNumbersList) : null).append(", emergencyNumberToBeDialed=").append(this.emergencyNumberToBeDialed).append(", customerTelState=").append(this.customerTelState).append("]").toString();
    }
}

