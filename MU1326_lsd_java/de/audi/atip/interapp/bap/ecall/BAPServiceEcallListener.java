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
    public void onCommunicationUp();

    public void onAudioSourceRequested(int var1);

    public void onCallState(PhoneCall[] var1);

    public void onHangupCallResult(boolean var1);

    public void onAcceptCallResult(boolean var1);

    public void onDisconnectReason(int var1);

    public void onNetworkRegistrationState(NetworkRegistrationVoice var1, NetworkRegistrationData var2);

    public void onNetworkProviderInfo(EcallProvider var1, EcallProvider var2);

    public void onSignalQuality(SignalQuality var1);

    public void onServiceRequests(PendingServiceRequests var1);

    public void onServiceRequestResult(int var1);

    public void onServiceState(int var1, int var2, MdsTransmissionResult var3);

    public void onSupportedServices(SupportedServices var1);

    public void onFunctionalState(FunctionalState var1);

    public void onDialNumberResult(int var1);

    public void onAllowedEmergencyNumbers(EmergencyNumber[] var1);
}

