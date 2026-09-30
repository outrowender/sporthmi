/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.app.AbstractAppConnectorASG;
import de.audi.app.bap.ecall.BAPModuleEcall;
import de.audi.app.bap.fw.IFunctionRegistrationASG;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcall;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_SetGet;
import de.vw.mib.bap.generated.ecall.serializer.DialNumber_StartResult;
import de.vw.mib.bap.generated.ecall.serializer.HangupCall_StartResult;
import de.vw.mib.bap.generated.ecall.serializer.ServiceControl_StartResult;

public final class AppConnectorEcall
extends AbstractAppConnectorASG
implements BAPServiceEcall {
    private final BAPModuleEcall eCallModule;
    static final int ALLOWED_EMERGENCY_NUMBERS_MAX_ELEMENTS_TO_REQUEST = 20;
    static final boolean ALLOWED_EMERGENCY_NUMBERS_INDEX_BIT_SIZE = false;

    public AppConnectorEcall(BAPModuleEcall bAPModuleEcall, IFunctionRegistrationASG iFunctionRegistrationASG) {
        super(bAPModuleEcall.getLogChannel(), iFunctionRegistrationASG);
        this.eCallModule = bAPModuleEcall;
    }

    public void setAudioSource(int n) {
        this.logChannel.log(10000000, "[AppConnectorEcall#setAudioSource] audioSourceKind: %1", (long)n);
        this.eCallModule.getDataEcall().setCurrentAudioSource(n);
        AudioState_SetGet audioState_SetGet = new AudioState_SetGet();
        audioState_SetGet.currentAudioSource = n;
        this.getProperty(16).setGetREQ(audioState_SetGet);
    }

    public void hangupCall(PhoneCall phoneCall) {
        this.logChannel.log(10000000, "[AppConnectorEcall#hangupCall] phoneCall: %1", (Object)phoneCall);
        this.hangup(phoneCall.getId());
    }

    public void hangupAllActiveCalls() {
        this.logChannel.log(10000000, "[AppConnectorEcall#hangupAllActiveCalls]");
        this.hangup(252);
    }

    public void hangupAllHeldCalls() {
        this.logChannel.log(10000000, "[AppConnectorEcall#hangupAllHeldCalls]");
        this.hangup(253);
    }

    public void hangupAllActiveAndHeldCalls() {
        this.logChannel.log(10000000, "[AppConnectorEcall#hangupAllActiveAndHeldCalls]");
        this.hangup(254);
    }

    public void hangupAllCalls() {
        this.logChannel.log(10000000, "[AppConnectorEcall#hangupAllCalls]");
        this.hangup(255);
    }

    public void acceptCall() {
        this.logChannel.log(10000000, "[AppConnectorEcall#acceptCall]");
        this.getMethod(19).startResultREQ();
    }

    public void acceptServiceRequest(int n) {
        this.logChannel.log(10000000, "[AppConnectorEcall#acceptServiceRequest] serviceRequestKind: %1", (long)n);
        this.serviceControl(0, n);
    }

    public void rejectServiceRequest(int n) {
        this.logChannel.log(10000000, "[AppConnectorEcall#rejectServiceRequest] serviceRequestKind: %1", (long)n);
        this.serviceControl(1, n);
    }

    public void rejectAllServiceRequests() {
        this.logChannel.log(10000000, "[AppConnectorEcall#rejectAllServiceRequests]");
        this.serviceControl(1, 255);
    }

    public void terminateServiceRequest(int n) {
        this.logChannel.log(10000000, "[AppConnectorEcall#terminateServiceRequest] serviceRequestKind: %1", (long)n);
        this.serviceControl(2, n);
    }

    public void startBreakdownCall() {
        this.logChannel.log(10000000, "[AppConnectorEcall#startBreakdownCall]");
        this.serviceControl(3, 1);
    }

    public void startInfoCall() {
        this.logChannel.log(10000000, "[AppConnectorEcall#startInfoCall]");
        this.serviceControl(3, 3);
    }

    public void startManualEmergencyCall() {
        this.logChannel.log(10000000, "[AppConnectorEcall#startManualEmergencyCall]");
        this.serviceControl(3, 5);
    }

    public void startTestMode() {
        this.logChannel.log(10000000, "[AppConnectorEcall#startTestMode]");
        this.serviceControl(3, 6);
    }

    public void getCallState() {
        this.logChannel.log(10000000, "[AppConnectorEcall#getCallState]");
        this.getProperty(17).getREQ();
    }

    public void getServiceRequest() {
        this.logChannel.log(10000000, "[AppConnectorEcall#getServiceRequest]");
        this.getProperty(24).getREQ();
    }

    public void getServiceState() {
        this.logChannel.log(10000000, "[AppConnectorEcall#getServiceState]");
        this.getProperty(26).getREQ();
    }

    public void getSupportedServices() {
        this.logChannel.log(10000000, "[AppConnectorEcall#getSupportedServices]");
        this.getProperty(27).getREQ();
    }

    public void getFunctionalState() {
        this.logChannel.log(10000000, "[AppConnectorEcall#getFunctionalState]");
        this.getProperty(28).getREQ();
    }

    public void dialNumber(String string) {
        DialNumber_StartResult dialNumber_StartResult = new DialNumber_StartResult();
        dialNumber_StartResult.telNumber.setContent(string);
        this.getMethod(30).startResultREQ(dialNumber_StartResult);
    }

    private void hangup(int n) {
        HangupCall_StartResult hangupCall_StartResult = new HangupCall_StartResult();
        hangupCall_StartResult.callId = n;
        this.getMethod(18).startResultREQ(hangupCall_StartResult);
    }

    private void serviceControl(int n, int n2) {
        ServiceControl_StartResult serviceControl_StartResult = new ServiceControl_StartResult();
        serviceControl_StartResult.serviceType = n2;
        serviceControl_StartResult.controlCode = n;
        this.getMethod(25).startResultREQ(serviceControl_StartResult);
    }
}

