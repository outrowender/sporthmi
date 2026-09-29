/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.AbstractBAPApplication;
import de.audi.app.bap.ecall.BAPModuleEcall;
import de.audi.app.bap.fw.AbstractBAPModule;
import de.audi.app.bap.fw.AbstractBAPModuleASG;
import de.audi.app.bap.utils.LSGIDs;
import de.audi.app.bap.utils.LoggingUtils;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcall;
import de.audi.atip.interapp.bap.ecall.BAPServiceEcallListener;
import de.audi.atip.interapp.bap.ecall.data.EcallProvider;
import de.audi.atip.interapp.bap.ecall.data.FunctionalState;
import de.audi.atip.interapp.bap.ecall.data.FunctionalState$Builder;
import de.audi.atip.interapp.bap.ecall.data.MdsTransmissionResult;
import de.audi.atip.interapp.bap.ecall.data.MdsTransmissionResult$Builder;
import de.audi.atip.interapp.bap.ecall.data.NetworkRegistrationData;
import de.audi.atip.interapp.bap.ecall.data.NetworkRegistrationVoice;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests;
import de.audi.atip.interapp.bap.ecall.data.PendingServiceRequests$Builder;
import de.audi.atip.interapp.bap.ecall.data.PhoneCall;
import de.audi.atip.interapp.bap.ecall.data.SignalQuality;
import de.audi.atip.interapp.bap.ecall.data.SupportedServices;
import de.audi.atip.interapp.bap.ecall.data.SupportedServices$Builder;
import de.esolutions.fw.util.commons.Buffer;
import de.mib.swdiagnosis.bap.AbstractBAPDiagnosisConnectorASG;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Reset;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.ecall.serializer.FunctionList_Status;
import java.util.Iterator;

public final class BAPDiagnosisConnectorEcall
extends AbstractBAPDiagnosisConnectorASG {
    public BAPDiagnosisConnectorEcall(AbstractBAPApplication abstractBAPApplication, AbstractBAPModuleASG abstractBAPModuleASG) {
        super(abstractBAPApplication, abstractBAPModuleASG, "AppBapEcall");
    }

    protected void initKeyDescriptions() {
    }

    protected void initCmdDescriptions() {
        this.cmdDescriptionMap.put("cmdSetAudioSource", "App -> cGW: Set Audio Source. cmdSetAudioSource(int audioSourceKind)");
        this.cmdDescriptionMap.put("cmdHangupCall", "App -> cGW: Hang Up Call. cmdHangupCall(int phoneCallId | int phoneCallKind | int phoneCallState)");
        this.cmdDescriptionMap.put("cmdHangupAllActiveCalls", "App -> cGW: Hangup All Active Calls. cmdHangupAllActiveCalls()");
        this.cmdDescriptionMap.put("cmdHangupAllHeldCalls", "App -> cGW: Hangup All Held Calls. cmdHangupAllHeldCalls()");
        this.cmdDescriptionMap.put("cmdHangupAllActiveAndHeldCalls", "App -> cGW: Hangup All Active And Held Calls. cmdHangupAllActiveAndHeldCalls()");
        this.cmdDescriptionMap.put("cmdHangupAllCalls", "App -> cGW: Hangup All Calls. cmdHangupAllCalls()");
        this.cmdDescriptionMap.put("cmdAcceptCall", "App -> cGW: Accept Call. cmdAcceptCall()");
        this.cmdDescriptionMap.put("cmdAcceptServiceRequest", "App -> cGW: Accept Service Request. cmdAcceptServiceRequest(int serviceRequestKind)");
        this.cmdDescriptionMap.put("cmdRejectServiceRequest", "App -> cGW: Reject Service Request. cmdRejectServiceRequest(int serviceRequestKind)");
        this.cmdDescriptionMap.put("cmdRejectAllServiceRequests", "App -> cGW: Reject All Service Requests. cmdRejectAllServiceRequests()");
        this.cmdDescriptionMap.put("cmdTerminateServiceRequest", "App -> cGW: Terminate Service Request. cmdTerminateServiceRequest(int serviceRequestKind)");
        this.cmdDescriptionMap.put("cmdStartBreakdownCall", "App -> cGW: Start a Breakdown Call. cmdStartBreakdownCall()");
        this.cmdDescriptionMap.put("cmdStartInfoCall", "App -> cGW: Start an Info Call. cmdStartInfoCall()");
        this.cmdDescriptionMap.put("cmdStartManualEmergencyCall", "App -> cGW: Start a Manual Emergency Call. cmdStartManualEmergencyCall()");
        this.cmdDescriptionMap.put("cmdStartTestMode", "App -> cGW: Start Test Mode. cmdStartTestMode()");
        this.cmdDescriptionMap.put("cmdGetCallState", "App -> cGW: Start Test Mode. cmdGetCallState()");
        this.cmdDescriptionMap.put("cmdGetServiceRequest", "App -> cGW: Start Test Mode. cmdGetServiceRequest()");
        this.cmdDescriptionMap.put("cmdGetServiceState", "App -> cGW: Start Test Mode. cmdGetServiceState()");
        this.cmdDescriptionMap.put("cmdGetSupportedServices", "App -> cGW: Start Test Mode. cmdGetSupportedServices()");
        this.cmdDescriptionMap.put("cmdGetFunctionalState", "App -> cGW: Start Test Mode. cmdGetFunctionalState()");
        this.cmdDescriptionMap.put("cmdOnAudioSourceRequested", "cGW -> App: Audio Source Requested. cmdOnAudioSourceRequested(int audioSourceRequest)");
        this.cmdDescriptionMap.put("cmdOnCallState", "cGW -> App: Call State Changed. cmdOnCallState(int phoneCallId | int phoneCallKind | int phoneCallState)");
        this.cmdDescriptionMap.put("cmdOnHangupCallResult", "cGW -> App: Hangup Call Result. cmdOnHangupCallResult(boolean succeeded)");
        this.cmdDescriptionMap.put("cmdOnAcceptCallResult", "cGW -> App: Accept Call Result. cmdOnAcceptCallResult(boolean succeeded)");
        this.cmdDescriptionMap.put("cmdOnDisconnectReason", "cGW -> App: Call Disconnected. cmdOnDisconnectReason(int eCallDisconnectReason)");
        this.cmdDescriptionMap.put("cmdOnNetworkRegistrationState", "cGW -> App: Network Registration State Changed. cmdOnNetworkRegistrationState(int registrationStateVoice | int networkKindVoice | int registrationStateData | int networkKindData)");
        this.cmdDescriptionMap.put("cmdOnNetworkProviderInfo", "cGW -> App: Network Provider Info Changed. cmdOnNetworkProviderInfo(boolean networkProviderNameAvailable | String networkProviderName | boolean serviceProviderNameAvailable | String serviceProviderName)");
        this.cmdDescriptionMap.put("cmdOnSignalQuality", "cGW -> App: Signal Quality Changed. cmdOnSignalQuality(int signalStrengthPercent)");
        this.cmdDescriptionMap.put("cmdOnServiceRequests", "cGW -> App: Service Request Pending. cmdOnServiceRequests(boolean accidentalDamageManagement | boolean automaticCrashNotification | boolean breakdownServicePending | boolean infoCallPending | boolean manualEmergencyCallPending | boolean testModePending)");
        this.cmdDescriptionMap.put("cmdOnServiceRequestResult", "cGW -> App: Service Request Result. cmdOnServiceRequestResult(int serviceRequestResult)");
        this.cmdDescriptionMap.put("cmdOnServiceState", "cGW -> App: Service State Changed. cmdOnServiceState(int serviceRequestKind | int serviceRequestState | boolean MdsSentPerSMSOk | boolean MdsSentPerSMSFailed | boolean MdsReceivedOnBackEndOk | boolean MdsReceivedOnBackEndFailed | boolean MdsSentViaIpOk | boolean MdsSentViaIpFailed | boolean MdsSentViaInbandModemOk | boolean MdsSentViaInbandModemFailed)");
        this.cmdDescriptionMap.put("cmdOnSupportedServices", "cGW -> App: Service State Changed. cmdOnSupportedServices(boolean breakdownCallSupported | boolean infoCallSupported | boolean manualEmergencyCallSupported)");
        this.cmdDescriptionMap.put("cmdOnFunctionalStates", "cGW -> App: Functional State Changed. cmdOnFunctionalStates(boolean audioFunctional | boolean audioUplinkFunctional | boolean audioDownlinkFunctional)");
    }

    public String getBAPStackStates() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.application.getModules().iterator();
        while (iterator.hasNext()) {
            AbstractBAPModule abstractBAPModule = (AbstractBAPModule)iterator.next();
            buffer.append(LSGIDs.getDescription(abstractBAPModule.getLSGID()));
            buffer.append(" - ");
            buffer.append(LoggingUtils.getBAPStackStateDescription(abstractBAPModule.getInitializationManager().getBapStackState()));
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public Object getHMIStates() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.application.getModules().iterator();
        while (iterator.hasNext()) {
            AbstractBAPModule abstractBAPModule = (AbstractBAPModule)iterator.next();
            buffer.append(LSGIDs.getDescription(abstractBAPModule.getLSGID()));
            buffer.append(" - ");
            buffer.append(LoggingUtils.getHMIStateDescription(abstractBAPModule.getInitializationManager().getHMIState()));
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public Object getInitStates() {
        Buffer buffer = new Buffer();
        Iterator iterator = this.application.getModules().iterator();
        while (iterator.hasNext()) {
            AbstractBAPModule abstractBAPModule = (AbstractBAPModule)iterator.next();
            buffer.append(LSGIDs.getDescription(abstractBAPModule.getLSGID()));
            buffer.append(" - ");
            buffer.append(LoggingUtils.getInitStateDescription(abstractBAPModule.getInitializationManager().getInitState()));
            buffer.append("\n");
        }
        return buffer.toString();
    }

    public void cmdSetAudioSource(int n) {
        this.eCall().setAudioSource(n);
    }

    public void cmdHangupCall(int n, int n2, int n3) {
        this.eCall().hangupCall(PhoneCall.getInstance(n, n2, n3));
    }

    public void cmdHangupAllActiveCalls() {
        this.eCall().hangupAllActiveCalls();
    }

    public void cmdHangupAllHeldCalls() {
        this.eCall().hangupAllHeldCalls();
    }

    public void cmdHangupAllActiveAndHeldCalls() {
        this.eCall().hangupAllActiveAndHeldCalls();
    }

    public void cmdHangupAllCalls() {
        this.eCall().hangupAllCalls();
    }

    public void cmdAcceptCall() {
        this.eCall().acceptCall();
    }

    public void cmdAcceptServiceRequest(int n) {
        this.eCall().acceptServiceRequest(n);
    }

    public void cmdRejectServiceRequest(int n) {
        this.eCall().rejectServiceRequest(n);
    }

    public void cmdRejectAllServiceRequests() {
        this.eCall().rejectAllServiceRequests();
    }

    public void cmdTerminateServiceRequest(int n) {
        this.eCall().terminateServiceRequest(n);
    }

    public void cmdStartBreakdownCall() {
        this.eCall().startBreakdownCall();
    }

    public void cmdStartInfoCall() {
        this.eCall().startInfoCall();
    }

    public void cmdStartManualEmergencyCall() {
        this.eCall().startManualEmergencyCall();
    }

    public void cmdStartTestMode() {
        this.eCall().startTestMode();
    }

    public void cmdGetCallState() {
        this.eCall().getCallState();
    }

    public void cmdGetServiceRequest() {
        this.eCall().getServiceRequest();
    }

    public void cmdGetServiceState() {
        this.eCall().getServiceState();
    }

    public void cmdGetSupportedServices() {
        this.eCall().getSupportedServices();
    }

    public void cmdGetFunctionalState() {
        this.eCall().getFunctionalState();
    }

    public void cmdOnAudioSourceRequested(int n) {
        this.eCallListener().onAudioSourceRequested(n);
    }

    public void cmdOnCallState(int n, int n2, int n3) {
        PhoneCall[] phoneCallArray = new PhoneCall[]{PhoneCall.getInstance(n, n2, n3)};
        this.eCallListener().onCallState(phoneCallArray);
    }

    public void cmdOnHangupCallResult(boolean bl) {
        this.eCallListener().onHangupCallResult(bl);
    }

    public void cmdOnAcceptCallResult(boolean bl) {
        this.eCallListener().onAcceptCallResult(bl);
    }

    public void cmdOnDisconnectReason(int n) {
        this.eCallListener().onDisconnectReason(n);
    }

    public void cmdOnNetworkRegistrationState(int n, int n2, int n3, int n4) {
        NetworkRegistrationVoice networkRegistrationVoice = NetworkRegistrationVoice.getInstance(n, n2);
        NetworkRegistrationData networkRegistrationData = NetworkRegistrationData.getInstance(n3, n4);
        this.eCallListener().onNetworkRegistrationState(networkRegistrationVoice, networkRegistrationData);
    }

    public void cmdOnNetworkProviderInfo(boolean bl, String string, boolean bl2, String string2) {
        EcallProvider ecallProvider = EcallProvider.getInstance(bl, string);
        EcallProvider ecallProvider2 = EcallProvider.getInstance(bl2, string2);
        this.eCallListener().onNetworkProviderInfo(ecallProvider, ecallProvider2);
    }

    public void cmdOnSignalQuality(int n) {
        SignalQuality signalQuality = SignalQuality.getInstanceFromSignalStrengthPercent(n);
        this.eCallListener().onSignalQuality(signalQuality);
    }

    public void cmdOnServiceRequests(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6) {
        PendingServiceRequests$Builder pendingServiceRequests$Builder = PendingServiceRequests.builder();
        pendingServiceRequests$Builder.setAccidentalDamageManagementPending(bl);
        pendingServiceRequests$Builder.setAutomaticCrashNotificationPending(bl2);
        pendingServiceRequests$Builder.setBreakdownServicePending(bl3);
        pendingServiceRequests$Builder.setInfoCallPending(bl4);
        pendingServiceRequests$Builder.setManualEmergencyCallPending(bl5);
        pendingServiceRequests$Builder.setTestModePending(bl6);
        this.eCallListener().onServiceRequests(pendingServiceRequests$Builder.build());
    }

    public void cmdOnServiceRequestResult(int n) {
        this.eCallListener().onServiceRequestResult(n);
    }

    public void cmdOnServiceState(int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8) {
        MdsTransmissionResult$Builder mdsTransmissionResult$Builder = MdsTransmissionResult.builder();
        mdsTransmissionResult$Builder.setMininumDataSetSentViaSmsSuceeded(bl);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaSmsFailed(bl2);
        mdsTransmissionResult$Builder.setMininumDataSetReceptionAcknowledgedSuceeded(bl3);
        mdsTransmissionResult$Builder.setMininumDataSetReceptionAcknowledgedFailed(bl4);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInternetProtocolSuceeded(bl5);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInternetProtocolFailed(bl6);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInbandModemSuceeded(bl7);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInbandModemFailed(bl8);
        this.eCallListener().onServiceState(n, n2, mdsTransmissionResult$Builder.build());
    }

    public void cmdOnSupportedServices(boolean bl, boolean bl2, boolean bl3) {
        SupportedServices$Builder supportedServices$Builder = SupportedServices.builder();
        supportedServices$Builder.setBreakdownCallSupported(bl);
        supportedServices$Builder.setInfoCallSupported(bl2);
        supportedServices$Builder.setManualEmergencyCallSupported(bl3);
        this.eCallListener().onSupportedServices(supportedServices$Builder.build());
    }

    public void cmdOnFunctionalStates(boolean bl, boolean bl2, boolean bl3) {
        FunctionalState$Builder functionalState$Builder = FunctionalState.builder();
        functionalState$Builder.setAudioFunctional(bl);
        functionalState$Builder.setAudioUplinkFunctional(bl2);
        functionalState$Builder.setAudioDownlinkFunctional(bl3);
        this.eCallListener().onFunctionalState(functionalState$Builder.build());
    }

    public void cmdSendBAPConfigStatusWithSupportedConfig() {
        BAP_Config_Status bAP_Config_Status = new BAP_Config_Status();
        bAP_Config_Status.bap_VersionMajor = 3;
        bAP_Config_Status.bap_VersionMinor = 1;
        bAP_Config_Status.lsg_Class = 51;
        bAP_Config_Status.lsg_SubClass = 0;
        bAP_Config_Status.lsg_VersionMajor = 3;
        bAP_Config_Status.lsg_VersionMinor = 3;
        this.sendIndication(this.moduleAsg.getLSGID(), 2, 9, bAP_Config_Status);
    }

    public void cmdSendBAPConfigStatusWithNotSupportedConfig() {
        BAP_Config_Status bAP_Config_Status = new BAP_Config_Status();
        bAP_Config_Status.bap_VersionMajor = 3;
        bAP_Config_Status.bap_VersionMinor = 1;
        bAP_Config_Status.lsg_Class = 51;
        bAP_Config_Status.lsg_SubClass = 0;
        bAP_Config_Status.lsg_VersionMajor = 10;
        bAP_Config_Status.lsg_VersionMinor = 0;
        this.sendIndication(this.moduleAsg.getLSGID(), 2, 9, bAP_Config_Status);
    }

    public void cmdSendBAPConfigResetWithSupportedConfig() {
        BAP_Config_Reset bAP_Config_Reset = new BAP_Config_Reset();
        bAP_Config_Reset.bap_VersionMajor = 3;
        bAP_Config_Reset.bap_VersionMinor = 1;
        bAP_Config_Reset.lsg_Class = 51;
        bAP_Config_Reset.lsg_SubClass = 0;
        bAP_Config_Reset.lsg_VersionMajor = 3;
        bAP_Config_Reset.lsg_VersionMinor = 3;
        this.sendIndication(this.moduleAsg.getLSGID(), 2, 13, bAP_Config_Reset);
    }

    public void cmdSendBAPConfigResetWithNotSupportedConfig() {
        BAP_Config_Reset bAP_Config_Reset = new BAP_Config_Reset();
        bAP_Config_Reset.bap_VersionMajor = 3;
        bAP_Config_Reset.bap_VersionMinor = 1;
        bAP_Config_Reset.lsg_Class = 51;
        bAP_Config_Reset.lsg_SubClass = 0;
        bAP_Config_Reset.lsg_VersionMajor = 10;
        bAP_Config_Reset.lsg_VersionMinor = 0;
        this.sendIndication(this.moduleAsg.getLSGID(), 2, 13, bAP_Config_Reset);
    }

    public void cmdSendFunctionList() {
        FunctionList_Status functionList_Status = new FunctionList_Status();
        functionList_Status.fctList.fct_GetAllAvailable = false;
        functionList_Status.fctList.fct_Bap_ConfigAvailable = false;
        functionList_Status.fctList.fct_FunctionListAvailable = false;
        functionList_Status.fctList.fct_HeartBeatAvailable = false;
        functionList_Status.fctList.fct_Fsg_SetupAvailable = false;
        functionList_Status.fctList.fct_Fsg_OperationStateAvailable = false;
        functionList_Status.fctList.fct_AudioStateAvailable = false;
        functionList_Status.fctList.fct_CallStateAvailable = true;
        functionList_Status.fctList.fct_HangupCallAvailable = true;
        functionList_Status.fctList.fct_AcceptCallAvailable = false;
        functionList_Status.fctList.fct_DisconnectReasonAvailable = false;
        functionList_Status.fctList.fct_RegisterStateAvailable = false;
        functionList_Status.fctList.fct_NetworkProviderAvailable = false;
        functionList_Status.fctList.fct_SignalQualityAvailable = false;
        functionList_Status.fctList.fct_ServiceRequestAvailable = false;
        functionList_Status.fctList.fct_ServiceControlAvailable = false;
        functionList_Status.fctList.fct_ServiceStateAvailable = false;
        functionList_Status.fctList.fct_SupportedServicesAvailable = false;
        this.sendIndication(this.moduleAsg.getLSGID(), 3, 9, functionList_Status);
    }

    public void cmdSendStatusAll() {
        this.sendIndication(this.moduleAsg.getLSGID(), 1, 9);
    }

    private BAPServiceEcall eCall() {
        return ((BAPModuleEcall)this.moduleAsg).getAppServiceEcall();
    }

    private BAPServiceEcallListener eCallListener() {
        return ((BAPModuleEcall)this.moduleAsg).getAppServiceListenerEcall();
    }
}

