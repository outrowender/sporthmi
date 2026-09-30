/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall;

import de.audi.atip.interapp.bap.BAPService;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;

public interface BAPServiceEcall
extends BAPService {
    public void setAudioSource(int var1);

    public void hangupCall(PhoneCall var1);

    public void hangupAllActiveCalls();

    public void hangupAllHeldCalls();

    public void hangupAllActiveAndHeldCalls();

    public void hangupAllCalls();

    public void acceptCall();

    public void acceptServiceRequest(int var1);

    public void rejectServiceRequest(int var1);

    public void rejectAllServiceRequests();

    public void terminateServiceRequest(int var1);

    public void startBreakdownCall();

    public void startInfoCall();

    public void startManualEmergencyCall();

    public void startTestMode();

    public void getCallState();

    public void getServiceRequest();

    public void getServiceState();

    public void getSupportedServices();

    public void getFunctionalState();

    public void dialNumber(String var1);
}

