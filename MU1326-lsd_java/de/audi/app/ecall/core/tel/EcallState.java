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

    @Override
    public boolean hasActiveCall() {
        return this.hasActiveCall;
    }

    @Override
    public boolean isServiceActive() {
        return this.isServiceActive;
    }

    @Override
    public PhoneCall getCall() {
        return this.phoneCall;
    }

    @Override
    public boolean isEmergencyCallType() {
        return this.serviceKind == 5 || this.serviceKind == 4;
    }

    @Override
    public boolean isLowPrioritySOSEmergencyCallType() {
        return this.phoneCall != null && this.phoneCall.isLowPrioritySOSCall();
    }

    @Override
    public boolean isCustomerCallNotAllowed() {
        return this.isServiceActive && (this.isEmergencyCallType() || this.isLowPrioritySOSEmergencyCallType());
    }

    @Override
    public boolean isCustomerCallAllowed() {
        return !this.isCustomerCallNotAllowed();
    }

    @Override
    public int getServiceKind() {
        return this.serviceKind;
    }

    @Override
    public String getEmergencyNumberToBeDialed() {
        return this.emergencyNumberToBeDialed;
    }

    @Override
    public EmergencyNumber[] getAllowedEmergencyNumbers() {
        return this.allowedEmergencyNumbers;
    }

    public String toString() {
        return new Buffer().append("EcallState [isServiceActive=").append(this.isServiceActive).append(", hasActiveCall=").append(this.hasActiveCall).append(", serviceKind=").append(this.serviceKind).append("]").toString();
    }
}

