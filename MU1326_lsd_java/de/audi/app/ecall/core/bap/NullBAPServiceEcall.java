/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.atip.interapp.bap.ecall.BAPServiceEcall;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

class NullBAPServiceEcall
extends NullService
implements BAPServiceEcall {
    protected NullBAPServiceEcall(LogChannel logChannel) {
        super(logChannel, "BAPServiceEcall");
    }

    public void setAudioSource(int n) {
        this.log();
    }

    public void hangupCall(PhoneCall phoneCall) {
        this.log();
    }

    public void hangupAllActiveCalls() {
        this.log();
    }

    public void hangupAllHeldCalls() {
        this.log();
    }

    public void hangupAllActiveAndHeldCalls() {
        this.log();
    }

    public void hangupAllCalls() {
        this.log();
    }

    public void acceptCall() {
        this.log();
    }

    public void acceptServiceRequest(int n) {
        this.log();
    }

    public void rejectServiceRequest(int n) {
        this.log();
    }

    public void rejectAllServiceRequests() {
        this.log();
    }

    public void terminateServiceRequest(int n) {
        this.log();
    }

    public void startBreakdownCall() {
        this.log();
    }

    public void startInfoCall() {
        this.log();
    }

    public void startManualEmergencyCall() {
        this.log();
    }

    public void startTestMode() {
        this.log();
    }

    public void getCallState() {
        this.log();
    }

    public void getServiceRequest() {
        this.log();
    }

    public void getServiceState() {
        this.log();
    }

    public void getSupportedServices() {
        this.log();
    }

    public void getFunctionalState() {
        this.log();
    }

    public void dialNumber(String string) {
        this.log();
    }
}

