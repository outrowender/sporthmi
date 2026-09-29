/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.state;

import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.ITelState;

public interface IEcallStateStruct {
    default public int getBapAudioSource() {
    }

    default public PendingServiceRequests getPendingServiceCalls() {
    }

    default public int getServiceCallKind() {
    }

    default public int getServiceState() {
    }

    default public PhoneCall[] getPhoneCalls() {
    }

    default public PhoneCall getCurrentPhoneCall() {
    }

    default public PhoneCall getCurrentPhoneCallByKind(int n) {
    }

    default public PhoneCall getCurrentHighPriorityPhoneCall() {
    }

    default public ITelState getCustomerTelState() {
    }

    default public String getEmergencyNumberToBeDialed() {
    }

    default public EmergencyNumber[] getAllowedEmergencyNumbersList() {
    }

    default public boolean isUSMRequestPresent() {
    }

    default public boolean getCustomerCallActive() {
    }

    default public boolean isActiveCustomerCallPresent() {
    }

    default public boolean isCallActive() {
    }

    default public boolean isCallActive(int n) {
    }

    default public boolean isServiceActive() {
    }

    default public boolean isEmergencyConnecting() {
    }

    default public boolean isEmergencyConnected() {
    }

    default public boolean isEmergencyCallBackIncoming() {
    }

    default public boolean isServiceIDLE() {
    }
}

