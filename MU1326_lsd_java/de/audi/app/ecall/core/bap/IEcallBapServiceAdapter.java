/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap;

import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public interface IEcallBapServiceAdapter {
    default public void terminateBreakdownService() {
    }

    default public void endEmergencyCall(PhoneCall phoneCall) {
    }

    default public void endBreakdownCall(PhoneCall phoneCall) {
    }

    default public void acceptBreakdownCall() {
    }

    default public void rejectBreakdownCall() {
    }

    default public void acceptEmergencyServiceCall() {
    }

    default public void dialEmergencyNumber(String string) {
    }

    default public void setAudioSource(int n) {
    }

    default public void sendMainUnitAudioSource(boolean bl) {
    }

    default public void onCommunicationUp() {
    }

    default public void startTestMode() {
    }
}

