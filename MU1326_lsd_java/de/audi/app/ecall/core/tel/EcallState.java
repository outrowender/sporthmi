/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.tel;

import de.audi.app.ecall.core.state.IEcallStateStruct;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.IEcallState;
import de.esolutions.fw.util.commons.Buffer;

class EcallState
implements IEcallState {
    private final boolean hasActiveCall;
    private final boolean isServiceActive;
    private final int serviceKind;
    private final PhoneCall phoneCall;
    private final String emergencyNumberToBeDialed;
    private final EmergencyNumber[] allowedEmergencyNumbers;

    public EcallState(IEcallStateStruct iEcallStateStruct) {
        this.hasActiveCall = iEcallStateStruct.isCallActive();
        this.isServiceActive = iEcallStateStruct.isServiceActive();
        this.serviceKind = iEcallStateStruct.getServiceCallKind();
        PhoneCall phoneCall = iEcallStateStruct.getCurrentPhoneCall();
        this.phoneCall = phoneCall == null ? PhoneCall.getNullInstance() : phoneCall;
        this.emergencyNumberToBeDialed = iEcallStateStruct.getEmergencyNumberToBeDialed();
        this.allowedEmergencyNumbers = iEcallStateStruct.getAllowedEmergencyNumbersList();
    }

    public boolean hasActiveCall() {
        return this.hasActiveCall;
    }

    public boolean isServiceActive() {
        return this.isServiceActive;
    }

    public PhoneCall getCall() {
        return this.phoneCall;
    }

    public boolean isEmergencyCallType() {
        return this.serviceKind == 5 || this.serviceKind == 4;
    }

    public boolean isLowPrioritySOSEmergencyCallType() {
        return this.phoneCall != null && this.phoneCall.isLowPrioritySOSCall();
    }

    public boolean isCustomerCallNotAllowed() {
        return this.isServiceActive && (this.isEmergencyCallType() || this.isLowPrioritySOSEmergencyCallType());
    }

    public boolean isCustomerCallAllowed() {
        return !this.isCustomerCallNotAllowed();
    }

    public int getServiceKind() {
        return this.serviceKind;
    }

    public String getEmergencyNumberToBeDialed() {
        return this.emergencyNumberToBeDialed;
    }

    public EmergencyNumber[] getAllowedEmergencyNumbers() {
        return this.allowedEmergencyNumbers;
    }

    public String toString() {
        return new Buffer().append("EcallState [isServiceActive=").append(this.isServiceActive).append(", hasActiveCall=").append(this.hasActiveCall).append(", serviceKind=").append(this.serviceKind).append("]").toString();
    }
}

