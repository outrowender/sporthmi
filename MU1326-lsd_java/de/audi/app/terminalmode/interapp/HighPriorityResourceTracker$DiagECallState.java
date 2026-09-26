/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.interapp.HighPriorityResourceTracker;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.phone.IEcallState;

class HighPriorityResourceTracker$DiagECallState
implements IEcallState {
    private final boolean serviceActive;
    private final /* synthetic */ HighPriorityResourceTracker this$0;

    public HighPriorityResourceTracker$DiagECallState(HighPriorityResourceTracker highPriorityResourceTracker, boolean bl) {
        this.this$0 = highPriorityResourceTracker;
        this.serviceActive = bl;
    }

    @Override
    public boolean hasActiveCall() {
        return this.serviceActive;
    }

    @Override
    public boolean isServiceActive() {
        return this.serviceActive;
    }

    @Override
    public int getServiceKind() {
        return 0;
    }

    @Override
    public PhoneCall getCall() {
        return null;
    }

    @Override
    public boolean isEmergencyCallType() {
        return false;
    }

    @Override
    public boolean isCustomerCallNotAllowed() {
        return false;
    }

    @Override
    public boolean isCustomerCallAllowed() {
        return false;
    }

    @Override
    public boolean isLowPrioritySOSEmergencyCallType() {
        return false;
    }

    @Override
    public EmergencyNumber[] getAllowedEmergencyNumbers() {
        return new EmergencyNumber[0];
    }

    @Override
    public String getEmergencyNumberToBeDialed() {
        return null;
    }
}

