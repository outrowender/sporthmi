/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.ecall;

import de.audi.app.bap.ecall.BAPModuleEcall;
import de.audi.app.bap.fw.arrays.ArrayUtilsASG;
import de.audi.app.bap.fw.functiontypes.AbstractBAPFunction;
import de.audi.app.bap.fw.functiontypes.BAPFunctionArrayASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodASG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyASG;
import de.audi.app.bap.generated.ecall.AbstractBAPIndicationHandlerEcall;
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
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.generated.ecall.serializer.AcceptCall_Result;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_ChangedArray;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_GetArray;
import de.vw.mib.bap.generated.ecall.serializer.AllowedEmergencyNumbers_StatusArray;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_Ack;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_Status;
import de.vw.mib.bap.generated.ecall.serializer.AudioState_StatusAck;
import de.vw.mib.bap.generated.ecall.serializer.BAP_Config_Status;
import de.vw.mib.bap.generated.ecall.serializer.CallState_Ack;
import de.vw.mib.bap.generated.ecall.serializer.CallState_Status;
import de.vw.mib.bap.generated.ecall.serializer.CallState_StatusAck;
import de.vw.mib.bap.generated.ecall.serializer.DialNumber_Result;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_ChangedArray;
import de.vw.mib.bap.generated.ecall.serializer.DisasterWarning_StatusArray;
import de.vw.mib.bap.generated.ecall.serializer.DisconnectReason_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Control_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.ecall.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.ecall.serializer.FunctionList_Status;
import de.vw.mib.bap.generated.ecall.serializer.FunctionalRestrictions_Status;
import de.vw.mib.bap.generated.ecall.serializer.HangupCall_Result;
import de.vw.mib.bap.generated.ecall.serializer.NetworkProvider_Status;
import de.vw.mib.bap.generated.ecall.serializer.RegisterState_Status;
import de.vw.mib.bap.generated.ecall.serializer.ServiceControl_Result;
import de.vw.mib.bap.generated.ecall.serializer.ServiceRequest_Status;
import de.vw.mib.bap.generated.ecall.serializer.ServiceState_Status;
import de.vw.mib.bap.generated.ecall.serializer.SignalQuality_Status;
import de.vw.mib.bap.generated.ecall.serializer.SupportedServices_Status;
import de.vw.mib.bap.requests.StatusArray;

public final class BAPIndicationHandlerEcall
extends AbstractBAPIndicationHandlerEcall {
    private static final int PHONE_CALLS_COUNT;
    private static final int SERVICE_CONTROL_RESULT_RESERVED_VALUE_MIN;
    private static final int SERVICE_CONTROL_RESULT_RESERVED_VALUE_MAX;
    private static final int DIAL_NUMBER_RESULT_RESERVED_VALUE_MIN;
    private static final int DIAL_NUMBER_RESULT_RESERVED_VALUE_MAX;
    private final BAPModuleEcall eCallModule;

    public BAPIndicationHandlerEcall(BAPModuleEcall bAPModuleEcall) {
        super(bAPModuleEcall, bAPModuleEcall.getLogChannel());
        this.eCallModule = bAPModuleEcall;
    }

    @Override
    public void processIndicationStatusArrayAck(BAPFunctionArrayASG bAPFunctionArrayASG, StatusArray statusArray) {
        this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processIndicationStatusArrayAck] not supported.");
    }

    @Override
    protected void processBapConfigStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, BAP_Config_Status bAP_Config_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processBapConfigStatus]");
    }

    @Override
    protected void processFunctionListStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FunctionList_Status functionList_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processFunctionListStatus]");
    }

    @Override
    protected void processFsgControlStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Control_Status fSG_Control_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processFsgControlStatus]");
    }

    @Override
    protected void processFsgSetupStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_Setup_Status fSG_Setup_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processFsgSetupStatus]");
    }

    @Override
    protected void processFsgOperationStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FSG_OperationState_Status fSG_OperationState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processFsgOperationStateStatus] state: %1", (long)fSG_OperationState_Status.op_State);
        this.eCallModule.setFsgOperationState(fSG_OperationState_Status.op_State);
    }

    @Override
    protected void processAudioStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, AudioState_Status audioState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processAudioStateStatus] serializer.audioRequest: %1", (long)audioState_Status.audioRequest);
        if (BAPIndicationHandlerEcall.reservedValueUsed(audioState_Status)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processAudioStateStatusAck] Reserved Value Used. serializer: %1", (Object)audioState_Status);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyASG);
            return;
        }
        int n = this.eCallModule.getDataEcall().getCurrentAudioSource();
        if (BAPIndicationHandlerEcall.eCallAppNeedsToKnowAboutThisRequest(audioState_Status.audioRequest, n)) {
            this.eCallModule.getAppServiceListenerEcall().onAudioSourceRequested(audioState_Status.audioRequest);
        }
    }

    private static boolean eCallAppNeedsToKnowAboutThisRequest(int n, int n2) {
        if (n == 0) {
            if (n2 == 0) {
                return false;
            }
            if (BAPIndicationHandlerEcall.currentSourceIsMainUnit(n2)) {
                return false;
            }
        } else if (n == n2) {
            return false;
        }
        return true;
    }

    private static boolean currentSourceIsMainUnit(int n) {
        return n == 5 || n == 6;
    }

    private static boolean reservedValueUsed(AudioState_Status audioState_Status) {
        return BAPIndicationHandlerEcall.audioRequestValueIsReserved(audioState_Status.audioRequest);
    }

    @Override
    protected void processAudioStateStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, AudioState_StatusAck audioState_StatusAck) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processAudioStateStatusAck] serializer.audioRequest: %1", (long)audioState_StatusAck.audioRequest);
        if (BAPIndicationHandlerEcall.reservedValueUsed(audioState_StatusAck)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processAudioStateStatusAck] Reserved Value Used. serializer: %1", (Object)audioState_StatusAck);
            this.sendAppErrorOutOfRange(bAPFunctionPropertyASG);
            return;
        }
        int n = this.eCallModule.getDataEcall().getCurrentAudioSource();
        bAPFunctionPropertyASG.ackREQ(BAPIndicationHandlerEcall.ackSerializerFromStatusAckSerializer(audioState_StatusAck, n));
        this.eCallModule.getAppServiceListenerEcall().onAudioSourceRequested(audioState_StatusAck.audioRequest);
    }

    private static boolean reservedValueUsed(AudioState_StatusAck audioState_StatusAck) {
        return BAPIndicationHandlerEcall.audioRequestValueIsReserved(audioState_StatusAck.audioRequest);
    }

    private static boolean audioRequestValueIsReserved(int n) {
        return n >= 5 && n <= 6 || n >= 8 && n <= 255;
    }

    @Override
    protected void processCallStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, CallState_Status callState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processCallStateStatus]");
        this.eCallModule.getAppServiceListenerEcall().onCallState(BAPIndicationHandlerEcall.getPhoneCallsArray(callState_Status));
    }

    @Override
    protected void processCallStateStatusAck(BAPFunctionPropertyASG bAPFunctionPropertyASG, CallState_StatusAck callState_StatusAck) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processCallStateStatusAck]");
        this.eCallModule.getAppServiceListenerEcall().onCallState(BAPIndicationHandlerEcall.getPhoneCallsArray(callState_StatusAck));
        bAPFunctionPropertyASG.ackREQ(BAPIndicationHandlerEcall.ackSerializerFromStatusAckSerializer(callState_StatusAck));
    }

    @Override
    protected void processHangupCallResult(BAPFunctionMethodASG bAPFunctionMethodASG, HangupCall_Result hangupCall_Result) {
        if (BAPIndicationHandlerEcall.reservedValueUsed(hangupCall_Result)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processHangupCallResult] Reserved Value Used. serializer: %1", (Object)hangupCall_Result);
            this.sendAppErrorOutOfRange(bAPFunctionMethodASG);
            return;
        }
        boolean bl = hangupCall_Result == null ? false : hangupCall_Result.hangupCall_Result == 0;
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processHangupCallResult] succeeded: %1", bl);
        this.eCallModule.getAppServiceListenerEcall().onHangupCallResult(bl);
    }

    private static boolean reservedValueUsed(HangupCall_Result hangupCall_Result) {
        return hangupCall_Result != null && hangupCall_Result.hangupCall_Result >= 4 && hangupCall_Result.hangupCall_Result <= 255;
    }

    @Override
    protected void processAcceptCallResult(BAPFunctionMethodASG bAPFunctionMethodASG, AcceptCall_Result acceptCall_Result) {
        boolean bl = acceptCall_Result == null ? false : acceptCall_Result.acceptCall_Result == 0;
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processAcceptCallResult] succeeded: %1", bl);
        this.eCallModule.getAppServiceListenerEcall().onAcceptCallResult(bl);
    }

    @Override
    protected void processDisconnectReasonStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, DisconnectReason_Status disconnectReason_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processDisconnectReasonStatus] serializer.disconnectReason: %1", (long)disconnectReason_Status.disconnectReason);
        this.eCallModule.getAppServiceListenerEcall().onDisconnectReason(disconnectReason_Status.disconnectReason);
    }

    @Override
    protected void processRegisterStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, RegisterState_Status registerState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processRegisterStateStatus]");
        NetworkRegistrationVoice networkRegistrationVoice = NetworkRegistrationVoice.getInstance(registerState_Status.registerStateVoice, registerState_Status.networkType);
        NetworkRegistrationData networkRegistrationData = NetworkRegistrationData.getInstance(registerState_Status.registerStateData, registerState_Status.packetDataNetworkType);
        this.eCallModule.getAppServiceListenerEcall().onNetworkRegistrationState(networkRegistrationVoice, networkRegistrationData);
    }

    @Override
    protected void processNetworkProviderStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, NetworkProvider_Status networkProvider_Status) {
        boolean bl = networkProvider_Status.networkProviderState == 1;
        boolean bl2 = networkProvider_Status.serviceProviderState == 1;
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processNetworkProviderStatus] networkProviderNameAvailable: %1 serviceProviderNameAvailable: %2", bl, bl2);
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processNetworkProviderStatus] networkProviderName: %1 serviceProviderName: %2", (Object)networkProvider_Status.networkProviderName.toString(), (Object)networkProvider_Status.serviceProviderName.toString());
        String string = bl ? networkProvider_Status.networkProviderName.toString() : "";
        String string2 = bl2 ? networkProvider_Status.serviceProviderName.toString() : "";
        EcallProvider ecallProvider = EcallProvider.getInstance(bl, string);
        EcallProvider ecallProvider2 = EcallProvider.getInstance(bl2, string2);
        this.eCallModule.getAppServiceListenerEcall().onNetworkProviderInfo(ecallProvider, ecallProvider2);
    }

    @Override
    protected void processSignalQualityStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, SignalQuality_Status signalQuality_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processSignalQualityStatus] serializer.quality: %1", (long)signalQuality_Status.quality);
        this.eCallModule.getAppServiceListenerEcall().onSignalQuality(SignalQuality.getInstanceFromSignalStrengthPercent(signalQuality_Status.quality));
    }

    @Override
    protected void processServiceRequestStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ServiceRequest_Status serviceRequest_Status) {
        PendingServiceRequests$Builder pendingServiceRequests$Builder = PendingServiceRequests.builder();
        pendingServiceRequests$Builder.setBreakdownServicePending(serviceRequest_Status.serviceType.serviceBreakdownCallPending);
        pendingServiceRequests$Builder.setAccidentalDamageManagementPending(serviceRequest_Status.serviceType.usmPending);
        pendingServiceRequests$Builder.setInfoCallPending(serviceRequest_Status.serviceType.infoCallPending);
        pendingServiceRequests$Builder.setAutomaticCrashNotificationPending(serviceRequest_Status.serviceType.acnPending);
        pendingServiceRequests$Builder.setManualEmergencyCallPending(serviceRequest_Status.serviceType.mecPending);
        pendingServiceRequests$Builder.setTestModePending(serviceRequest_Status.serviceType.testModePendingDf3_4);
        PendingServiceRequests pendingServiceRequests = pendingServiceRequests$Builder.build();
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processServiceRequestStatus] serviceRequest: %1", (Object)pendingServiceRequests);
        this.eCallModule.getAppServiceListenerEcall().onServiceRequests(pendingServiceRequests);
    }

    @Override
    protected void processServiceControlResult(BAPFunctionMethodASG bAPFunctionMethodASG, ServiceControl_Result serviceControl_Result) {
        if (BAPIndicationHandlerEcall.reservedValueUsed(serviceControl_Result)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processServiceControlResult] Reserved Value Used. serializer: %1", (Object)serviceControl_Result);
            this.sendAppErrorOutOfRange(bAPFunctionMethodASG);
            return;
        }
        if (serviceControl_Result != null) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processServiceControlResult] serializer.controlResult: %1", (long)serviceControl_Result.controlResult);
            this.eCallModule.getAppServiceListenerEcall().onServiceRequestResult(serviceControl_Result.controlResult);
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processServiceControlResult] call not forwarded due to BAP error");
        }
    }

    private static boolean reservedValueUsed(ServiceControl_Result serviceControl_Result) {
        return serviceControl_Result != null && serviceControl_Result.controlResult >= 5 && serviceControl_Result.controlResult <= 255;
    }

    @Override
    protected void processServiceStateStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, ServiceState_Status serviceState_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processServiceStateStatus] serviceType: %1 serviceState: %2", (long)serviceState_Status.serviceType, (long)serviceState_Status.serviceState);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsSentViaSmsSuceeded: %1", serviceState_Status.dataTransmissionState.mdsMinimumDataSetSentViaSmsSuccessfully);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsSentViaSmsFailed: %1", serviceState_Status.dataTransmissionState.mdsTransmissionViaSmsFailedE_g_NoNet);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsReceptionAcknowledgedSuceeded: %1", serviceState_Status.dataTransmissionState.mdsReceivedOnBackEndSuccessfully);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsReceptionAcknowledgedFailed: %1", serviceState_Status.dataTransmissionState.mdsReceptionOnBackEndFailed);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsSentViaInternetProtocolSuceeded: %1", serviceState_Status.dataTransmissionState.dataSentSuccessfully);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsSentViaInternetProtocolFailed: %1", serviceState_Status.dataTransmissionState.dataTransmissionViaIpConnectionFailed);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsSentViaInbandModemSuceeded: %1", serviceState_Status.dataTransmissionState.dataSentViaInbandModemSuccessfully);
        this.logChannel.log(14808325, "[BAPIndicationHandlerEcall#processServiceStateStatus] MdsSentViaInbandModemFailed: %1", serviceState_Status.dataTransmissionState.dataTransmissionViaInbandModemFailed);
        MdsTransmissionResult$Builder mdsTransmissionResult$Builder = MdsTransmissionResult.builder();
        mdsTransmissionResult$Builder.setMininumDataSetSentViaSmsSuceeded(serviceState_Status.dataTransmissionState.mdsMinimumDataSetSentViaSmsSuccessfully);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaSmsFailed(serviceState_Status.dataTransmissionState.mdsTransmissionViaSmsFailedE_g_NoNet);
        mdsTransmissionResult$Builder.setMininumDataSetReceptionAcknowledgedSuceeded(serviceState_Status.dataTransmissionState.mdsReceivedOnBackEndSuccessfully);
        mdsTransmissionResult$Builder.setMininumDataSetReceptionAcknowledgedFailed(serviceState_Status.dataTransmissionState.mdsReceptionOnBackEndFailed);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInternetProtocolSuceeded(serviceState_Status.dataTransmissionState.dataSentSuccessfully);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInternetProtocolFailed(serviceState_Status.dataTransmissionState.dataTransmissionViaIpConnectionFailed);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInbandModemSuceeded(serviceState_Status.dataTransmissionState.dataSentViaInbandModemSuccessfully);
        mdsTransmissionResult$Builder.setMininumDataSetSentViaInbandModemFailed(serviceState_Status.dataTransmissionState.dataTransmissionViaInbandModemFailed);
        this.eCallModule.getAppServiceListenerEcall().onServiceState(serviceState_Status.serviceType, serviceState_Status.serviceState, mdsTransmissionResult$Builder.build());
    }

    @Override
    protected void processSupportedServicesStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, SupportedServices_Status supportedServices_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processSupportedServicesStatus]");
        SupportedServices$Builder supportedServices$Builder = SupportedServices.builder();
        supportedServices$Builder.setBreakdownCallSupported(supportedServices_Status.services.serviceBreakdownCallSupported);
        supportedServices$Builder.setInfoCallSupported(supportedServices_Status.services.infoCallSupported);
        supportedServices$Builder.setManualEmergencyCallSupported(supportedServices_Status.services.mecSupported);
        supportedServices$Builder.setTestModeSupported(supportedServices_Status.services.testModeSupportedDf3_4);
        this.eCallModule.getAppServiceListenerEcall().onSupportedServices(supportedServices$Builder.build());
    }

    @Override
    protected void processFunctionalRestrictionsStatus(BAPFunctionPropertyASG bAPFunctionPropertyASG, FunctionalRestrictions_Status functionalRestrictions_Status) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processFunctionalRestrictionsStatus]");
        FunctionalState$Builder functionalState$Builder = FunctionalState.builder();
        functionalState$Builder.setAudioFunctional(!functionalRestrictions_Status.restrictions.audioNotFullyFunctional);
        functionalState$Builder.setAudioUplinkFunctional(!functionalRestrictions_Status.restrictions.audioUplinkNotFullyFunctional);
        functionalState$Builder.setAudioDownlinkFunctional(!functionalRestrictions_Status.restrictions.audioDownlinkNotFullyFunctional);
        this.eCallModule.getAppServiceListenerEcall().onFunctionalState(functionalState$Builder.build());
    }

    private static PhoneCall[] getPhoneCallsArray(CallState_Status callState_Status) {
        PhoneCall[] phoneCallArray = new PhoneCall[]{PhoneCall.getInstance(0, callState_Status.callType0, callState_Status.callState0), PhoneCall.getInstance(1, callState_Status.callType1, callState_Status.callState1), PhoneCall.getInstance(2, callState_Status.callType2, callState_Status.callState2), PhoneCall.getInstance(3, callState_Status.callType3, callState_Status.callState3), PhoneCall.getInstance(4, callState_Status.callType4, callState_Status.callState4), PhoneCall.getInstance(5, callState_Status.callType5, callState_Status.callState5), PhoneCall.getInstance(6, callState_Status.callType6, callState_Status.callState6)};
        return phoneCallArray;
    }

    private static PhoneCall[] getPhoneCallsArray(CallState_StatusAck callState_StatusAck) {
        PhoneCall[] phoneCallArray = new PhoneCall[]{PhoneCall.getInstance(0, callState_StatusAck.callType0, callState_StatusAck.callState0), PhoneCall.getInstance(1, callState_StatusAck.callType1, callState_StatusAck.callState1), PhoneCall.getInstance(2, callState_StatusAck.callType2, callState_StatusAck.callState2), PhoneCall.getInstance(3, callState_StatusAck.callType3, callState_StatusAck.callState3), PhoneCall.getInstance(4, callState_StatusAck.callType4, callState_StatusAck.callState4), PhoneCall.getInstance(5, callState_StatusAck.callType5, callState_StatusAck.callState5), PhoneCall.getInstance(6, callState_StatusAck.callType6, callState_StatusAck.callState6)};
        return phoneCallArray;
    }

    private static AudioState_Ack ackSerializerFromStatusAckSerializer(AudioState_StatusAck audioState_StatusAck, int n) {
        AudioState_Ack audioState_Ack = new AudioState_Ack();
        audioState_Ack.audioRequest = audioState_StatusAck.audioRequest;
        audioState_Ack.currentAudioSource = n;
        return audioState_Ack;
    }

    private static CallState_Ack ackSerializerFromStatusAckSerializer(CallState_StatusAck callState_StatusAck) {
        CallState_Ack callState_Ack = new CallState_Ack();
        callState_Ack.callType0 = callState_StatusAck.callType0;
        callState_Ack.callState0 = callState_StatusAck.callState0;
        callState_Ack.callType1 = callState_StatusAck.callType1;
        callState_Ack.callState1 = callState_StatusAck.callState1;
        callState_Ack.callType2 = callState_StatusAck.callType2;
        callState_Ack.callState2 = callState_StatusAck.callState2;
        callState_Ack.callType3 = callState_StatusAck.callType3;
        callState_Ack.callState3 = callState_StatusAck.callState3;
        callState_Ack.callType4 = callState_StatusAck.callType4;
        callState_Ack.callState4 = callState_StatusAck.callState4;
        callState_Ack.callType5 = callState_StatusAck.callType5;
        callState_Ack.callState5 = callState_StatusAck.callState5;
        callState_Ack.callType6 = callState_StatusAck.callType6;
        callState_Ack.callState6 = callState_StatusAck.callState6;
        callState_Ack.additionalStates.hangupCallAllowedDf3_1 = callState_StatusAck.additionalStates.hangupCallAllowedDf3_1;
        return callState_Ack;
    }

    private void sendAppErrorOutOfRange(AbstractBAPFunction abstractBAPFunction) {
        this.module.getRequestHandler().requestErrorCode(this.module.getLSGID(), abstractBAPFunction.getFctID(), 65);
        abstractBAPFunction.reset();
    }

    private static int lastPosIdAlreadyReceived(BAPArrayData bAPArrayData) {
        if (bAPArrayData.size() == 0) {
            return 0;
        }
        return bAPArrayData.get(bAPArrayData.size() - 1).getPos();
    }

    @Override
    protected void processAllowedEmergencyNumbersChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, AllowedEmergencyNumbers_ChangedArray allowedEmergencyNumbers_ChangedArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processAllowedEmergencyNumbersChangedArray]");
        this.eCallModule.getDataEcall().getAllowedEmergencyNumbers().clear();
        ArrayUtilsASG.requestArrayElements(bAPFunctionArrayASG, 20, 1, false, new AllowedEmergencyNumbers_GetArray());
    }

    @Override
    protected void processAllowedEmergencyNumbersStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, AllowedEmergencyNumbers_StatusArray allowedEmergencyNumbers_StatusArray) {
        this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processAllowedEmergencyNumbersStatusArray]");
        this.eCallModule.getDataEcall().getAllowedEmergencyNumbers().mergeElementsInList(allowedEmergencyNumbers_StatusArray);
        if (this.eCallModule.getDataEcall().getAllowedEmergencyNumbers().hasMoreElementsToRequest(allowedEmergencyNumbers_StatusArray)) {
            ArrayUtilsASG.requestNextArrayElements(bAPFunctionArrayASG, BAPIndicationHandlerEcall.lastPosIdAlreadyReceived(allowedEmergencyNumbers_StatusArray.getArrayData()), 20, 1, false, new AllowedEmergencyNumbers_GetArray());
        } else {
            this.eCallModule.getAppServiceListenerEcall().onAllowedEmergencyNumbers(this.eCallModule.getDataEcall().emergencyNumbers());
        }
    }

    @Override
    protected void processDialNumberResult(BAPFunctionMethodASG bAPFunctionMethodASG, DialNumber_Result dialNumber_Result) {
        if (BAPIndicationHandlerEcall.reservedValueUsed(dialNumber_Result)) {
            this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processDialNumberResult] Reserved Value Used. serializer: %1", (Object)dialNumber_Result);
            this.sendAppErrorOutOfRange(bAPFunctionMethodASG);
            return;
        }
        if (dialNumber_Result != null) {
            this.logChannel.log(-2137614336, "[BAPIndicationHandlerEcall#processDialNumberResult] serializer.dialNumber_Result: %1", (long)dialNumber_Result.dialNumber_Result);
            this.eCallModule.getAppServiceListenerEcall().onDialNumberResult(dialNumber_Result.dialNumber_Result);
        } else {
            this.logChannel.log(10000, "[BAPIndicationHandlerEcall#processDialNumberResult] call not forwarded due to BAP error");
        }
    }

    private static boolean reservedValueUsed(DialNumber_Result dialNumber_Result) {
        return dialNumber_Result != null && dialNumber_Result.dialNumber_Result >= 6 && dialNumber_Result.dialNumber_Result <= 255;
    }

    @Override
    protected void processDisasterWarningChangedArray(BAPFunctionArrayASG bAPFunctionArrayASG, DisasterWarning_ChangedArray disasterWarning_ChangedArray) {
    }

    @Override
    protected void processDisasterWarningStatusArray(BAPFunctionArrayASG bAPFunctionArrayASG, DisasterWarning_StatusArray disasterWarning_StatusArray) {
    }
}

