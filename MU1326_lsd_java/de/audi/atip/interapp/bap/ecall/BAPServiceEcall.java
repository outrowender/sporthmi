/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall;

import de.audi.atip.interapp.bap.BAPService;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public interface BAPServiceEcall
extends BAPService {
    default public void setAudioSource(int n) {
    }

    default public void hangupCall(PhoneCall phoneCall) {
    }

    default public void hangupAllActiveCalls() {
    }

    default public void hangupAllHeldCalls() {
    }

    default public void hangupAllActiveAndHeldCalls() {
    }

    default public void hangupAllCalls() {
    }

    default public void acceptCall() {
    }

    default public void acceptServiceRequest(int n) {
    }

    default public void rejectServiceRequest(int n) {
    }

    default public void rejectAllServiceRequests() {
    }

    default public void terminateServiceRequest(int n) {
    }

    default public void startBreakdownCall() {
    }

    default public void startInfoCall() {
    }

    default public void startManualEmergencyCall() {
    }

    default public void startTestMode() {
    }

    default public void getCallState() {
    }

    default public void getServiceRequest() {
    }

    default public void getServiceState() {
    }

    default public void getSupportedServices() {
    }

    default public void getFunctionalState() {
    }

    default public void dialNumber(String string) {
    }
}

