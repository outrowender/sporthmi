/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall;

import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.bap.ecall.data.EcallProvider;
import de.audi.atip.interapp.bap.ecall.data.EmergencyNumber;
import de.audi.atip.interapp.bap.ecall.data.FunctionalState;
import de.audi.atip.interapp.bap.ecall.data.MdsTransmissionResult;
import de.audi.atip.interapp.bap.ecall.data.NetworkRegistrationData;
import de.audi.atip.interapp.bap.ecall.data.NetworkRegistrationVoice;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.bap.ecall.data.SignalQuality;
import de.audi.atip.interapp.bap.ecall.data.SupportedServices;

public interface BAPServiceEcallListener
extends BAPServiceListener {
    default public void onCommunicationUp() {
    }

    default public void onAudioSourceRequested(int n) {
    }

    default public void onCallState(PhoneCall[] phoneCallArray) {
    }

    default public void onHangupCallResult(boolean bl) {
    }

    default public void onAcceptCallResult(boolean bl) {
    }

    default public void onDisconnectReason(int n) {
    }

    default public void onNetworkRegistrationState(NetworkRegistrationVoice networkRegistrationVoice, NetworkRegistrationData networkRegistrationData) {
    }

    default public void onNetworkProviderInfo(EcallProvider ecallProvider, EcallProvider ecallProvider2) {
    }

    default public void onSignalQuality(SignalQuality signalQuality) {
    }

    default public void onServiceRequests(PendingServiceRequests pendingServiceRequests) {
    }

    default public void onServiceRequestResult(int n) {
    }

    default public void onServiceState(int n, int n2, MdsTransmissionResult mdsTransmissionResult) {
    }

    default public void onSupportedServices(SupportedServices supportedServices) {
    }

    default public void onFunctionalState(FunctionalState functionalState) {
    }

    default public void onDialNumberResult(int n) {
    }

    default public void onAllowedEmergencyNumbers(EmergencyNumber[] emergencyNumberArray) {
    }
}

