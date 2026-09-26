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

    @Override
    public void setAudioSource(int n) {
        this.log();
    }

    @Override
    public void hangupCall(PhoneCall phoneCall) {
        this.log();
    }

    @Override
    public void hangupAllActiveCalls() {
        this.log();
    }

    @Override
    public void hangupAllHeldCalls() {
        this.log();
    }

    @Override
    public void hangupAllActiveAndHeldCalls() {
        this.log();
    }

    @Override
    public void hangupAllCalls() {
        this.log();
    }

    @Override
    public void acceptCall() {
        this.log();
    }

    @Override
    public void acceptServiceRequest(int n) {
        this.log();
    }

    @Override
    public void rejectServiceRequest(int n) {
        this.log();
    }

    @Override
    public void rejectAllServiceRequests() {
        this.log();
    }

    @Override
    public void terminateServiceRequest(int n) {
        this.log();
    }

    @Override
    public void startBreakdownCall() {
        this.log();
    }

    @Override
    public void startInfoCall() {
        this.log();
    }

    @Override
    public void startManualEmergencyCall() {
        this.log();
    }

    @Override
    public void startTestMode() {
        this.log();
    }

    @Override
    public void getCallState() {
        this.log();
    }

    @Override
    public void getServiceRequest() {
        this.log();
    }

    @Override
    public void getServiceState() {
        this.log();
    }

    @Override
    public void getSupportedServices() {
        this.log();
    }

    @Override
    public void getFunctionalState() {
        this.log();
    }

    @Override
    public void dialNumber(String string) {
        this.log();
    }
}

