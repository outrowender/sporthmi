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
    static final int ALLOWED_EMERGENCY_NUMBERS_MAX_ELEMENTS_TO_REQUEST;
    static final boolean ALLOWED_EMERGENCY_NUMBERS_INDEX_BIT_SIZE;

    public AppConnectorEcall(BAPModuleEcall bAPModuleEcall, IFunctionRegistrationASG iFunctionRegistrationASG) {
        super(bAPModuleEcall.getLogChannel(), iFunctionRegistrationASG);
        this.eCallModule = bAPModuleEcall;
    }

    @Override
    public void setAudioSource(int n) {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#setAudioSource] audioSourceKind: %1", (long)n);
        this.eCallModule.getDataEcall().setCurrentAudioSource(n);
        AudioState_SetGet audioState_SetGet = new AudioState_SetGet();
        audioState_SetGet.currentAudioSource = n;
        this.getProperty(16).setGetREQ(audioState_SetGet);
    }

    @Override
    public void hangupCall(PhoneCall phoneCall) {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#hangupCall] phoneCall: %1", (Object)phoneCall);
        this.hangup(phoneCall.getId());
    }

    @Override
    public void hangupAllActiveCalls() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#hangupAllActiveCalls]");
        this.hangup(252);
    }

    @Override
    public void hangupAllHeldCalls() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#hangupAllHeldCalls]");
        this.hangup(253);
    }

    @Override
    public void hangupAllActiveAndHeldCalls() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#hangupAllActiveAndHeldCalls]");
        this.hangup(254);
    }

    @Override
    public void hangupAllCalls() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#hangupAllCalls]");
        this.hangup(255);
    }

    @Override
    public void acceptCall() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#acceptCall]");
        this.getMethod(19).startResultREQ();
    }

    @Override
    public void acceptServiceRequest(int n) {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#acceptServiceRequest] serviceRequestKind: %1", (long)n);
        this.serviceControl(0, n);
    }

    @Override
    public void rejectServiceRequest(int n) {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#rejectServiceRequest] serviceRequestKind: %1", (long)n);
        this.serviceControl(1, n);
    }

    @Override
    public void rejectAllServiceRequests() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#rejectAllServiceRequests]");
        this.serviceControl(1, 255);
    }

    @Override
    public void terminateServiceRequest(int n) {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#terminateServiceRequest] serviceRequestKind: %1", (long)n);
        this.serviceControl(2, n);
    }

    @Override
    public void startBreakdownCall() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#startBreakdownCall]");
        this.serviceControl(3, 1);
    }

    @Override
    public void startInfoCall() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#startInfoCall]");
        this.serviceControl(3, 3);
    }

    @Override
    public void startManualEmergencyCall() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#startManualEmergencyCall]");
        this.serviceControl(3, 5);
    }

    @Override
    public void startTestMode() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#startTestMode]");
        this.serviceControl(3, 6);
    }

    @Override
    public void getCallState() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#getCallState]");
        this.getProperty(17).getREQ();
    }

    @Override
    public void getServiceRequest() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#getServiceRequest]");
        this.getProperty(24).getREQ();
    }

    @Override
    public void getServiceState() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#getServiceState]");
        this.getProperty(26).getREQ();
    }

    @Override
    public void getSupportedServices() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#getSupportedServices]");
        this.getProperty(27).getREQ();
    }

    @Override
    public void getFunctionalState() {
        this.logChannel.log(-2137614336, "[AppConnectorEcall#getFunctionalState]");
        this.getProperty(28).getREQ();
    }

    @Override
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

