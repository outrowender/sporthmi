/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.phone;

import de.audi.app.bap.fw.AbstractFunctionList;
import de.audi.app.bap.fw.arrays.ArrayHandler;
import de.audi.app.bap.fw.functiontypes.BAPFunctionMethodFSG;
import de.audi.app.bap.fw.functiontypes.BAPFunctionPropertyFSG;
import de.audi.app.bap.utils.ArrayPrinter;
import de.audi.app.combi.bap.app.kombipictures.IPictureProvider;
import de.audi.app.combi.bap.app.phone.AbstractAppConnectorPhone;
import de.audi.app.combi.bap.app.phone.CombiModulePhone;
import de.audi.app.combi.bap.app.phone.list.CombinedNumbersListHandler;
import de.audi.app.combi.bap.app.phone.list.FavoriteNumbersListHandler;
import de.audi.app.combi.bap.fw.AbstractCombiModule;
import de.audi.atip.interapp.bap.BAPServiceListener;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.combi.bap.phone.data.CallStartTime;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallInfo;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallStackEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPCallState;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPFavoriteNumberEntry;
import de.audi.atip.interapp.combi.bap.phone.data.CombiBAPhoneMobileBatteryLevel;
import de.audi.atip.interapp.combi.bap.phone.data.FsgSetup;
import de.vw.mib.bap.generated.telephone.serializer.AcceptCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedialExtendedInfo_Status;
import de.vw.mib.bap.generated.telephone.serializer.AutomaticRedial_Status;
import de.vw.mib.bap.generated.telephone.serializer.CCJoin_Result;
import de.vw.mib.bap.generated.telephone.serializer.CCSplit_Result;
import de.vw.mib.bap.generated.telephone.serializer.CallDurationSync_Status;
import de.vw.mib.bap.generated.telephone.serializer.CallHold_Result;
import de.vw.mib.bap.generated.telephone.serializer.CallInfo_Status;
import de.vw.mib.bap.generated.telephone.serializer.CallState_Status;
import de.vw.mib.bap.generated.telephone.serializer.ConfirmEmergencyCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.DialNumber_Result;
import de.vw.mib.bap.generated.telephone.serializer.DialService_Result;
import de.vw.mib.bap.generated.telephone.serializer.DisconnectReason_Status;
import de.vw.mib.bap.generated.telephone.serializer.FSG_OperationState_Status;
import de.vw.mib.bap.generated.telephone.serializer.FSG_Setup_Status;
import de.vw.mib.bap.generated.telephone.serializer.HangupCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.LockState_Status;
import de.vw.mib.bap.generated.telephone.serializer.MPCallHoldAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPRelActiveCallAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPRelAllCallsAcceptWC_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPSetWaitingCallOnHold_Result;
import de.vw.mib.bap.generated.telephone.serializer.MPSwap_Result;
import de.vw.mib.bap.generated.telephone.serializer.MicroMuteOnOff_Status;
import de.vw.mib.bap.generated.telephone.serializer.MissedCallIndication_Status;
import de.vw.mib.bap.generated.telephone.serializer.MobileBatteryLevel_Status;
import de.vw.mib.bap.generated.telephone.serializer.MobileServiceSupport_Status;
import de.vw.mib.bap.generated.telephone.serializer.NetworkProvider_Status;
import de.vw.mib.bap.generated.telephone.serializer.RegisterState_Status;
import de.vw.mib.bap.generated.telephone.serializer.ResumeCall_Result;
import de.vw.mib.bap.generated.telephone.serializer.RingToneMuteOnOff_Status;
import de.vw.mib.bap.generated.telephone.serializer.SignalQuality_Status;
import de.vw.mib.bap.generated.telephone.serializer.SupportedServiceNumbers_Status;
import org.dsi.ifc.global.ResourceLocator;

public class AppConnectorPhone
extends AbstractAppConnectorPhone
implements CombiBAPServicePhone {
    private static final int NO_OF_CALL_SLOTS = 7;
    private static final String EMPTY_STRING = "";
    private static final CombiBAPCallState[] EMPTY_CALL_STATES;
    private static final CombiBAPCallInfo[] EMPTY_CALL_INFOS;
    private volatile CombiBAPCallState[] combiCallStates;
    private volatile CombiBAPCallInfo[] combiCallInfos;

    protected AppConnectorPhone(CombiModulePhone combiModulePhone) {
        super(combiModulePhone);
        combiModulePhone.getPictureManager().registerPictureProvider(2, new CallPictureProvider());
        this.combiCallStates = EMPTY_CALL_STATES;
        this.combiCallInfos = EMPTY_CALL_INFOS;
    }

    public void setAppServiceListener(BAPServiceListener bAPServiceListener) {
        super.setAppServiceListener(bAPServiceListener);
        this.moduleFsg.getInitializationManager().notifyAppServiceChanged(bAPServiceListener != null);
    }

    public void updateFsgSetup(FsgSetup fsgSetup) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateFsgSetup] called (fsgSetup=%1)", (Object)fsgSetup);
        FSG_Setup_Status fSG_Setup_Status = new FSG_Setup_Status();
        fSG_Setup_Status.phoneCharacteristics.internalSimcardReader = fsgSetup.isInternalSimCardReaderPresent();
        fSG_Setup_Status.phoneCharacteristics.cableConnectionToMobilePossible = fsgSetup.isCableConnectionPossible();
        fSG_Setup_Status.phoneCharacteristics.hfpConnectionToMobilePossible = fsgSetup.isHfpConnectionPossible();
        fSG_Setup_Status.phoneCharacteristics.rsapConnectionToMobilePossible = fsgSetup.isRsapConnectionPossible();
        fSG_Setup_Status.phoneCharacteristics.appleLinkConnectionToMobilePossible = fsgSetup.isAppleLinkConnectionPossible();
        fSG_Setup_Status.phoneCharacteristics.googleLinkConnectionToMobilePossible = fsgSetup.isGoogleLinkConnectionPossible();
        fSG_Setup_Status.mobileConnectionType = fsgSetup.getMobileConnectionType();
        this.sendPropertyStatus(14, fSG_Setup_Status);
    }

    public void updateFSGOperationState(int n, boolean bl, boolean bl2) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateFSGOperationState] called (telState=%1)", (long)n);
        BAPFunctionPropertyFSG bAPFunctionPropertyFSG = this.moduleFsg.getBAPFunctionPropertyFSG(15);
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPFunctionPropertyFSG.getLastStatus();
        if (fSG_OperationState_Status.tel_State != n || fSG_OperationState_Status.privacyMode.privacyModeActive != bl || fSG_OperationState_Status.privacyMode.enhancedPrivacyModeActive != bl2) {
            fSG_OperationState_Status.tel_State = n;
            fSG_OperationState_Status.privacyMode.privacyModeActive = bl;
            fSG_OperationState_Status.privacyMode.enhancedPrivacyModeActive = bl2;
            bAPFunctionPropertyFSG.sendStatus(fSG_OperationState_Status);
        } else {
            bAPFunctionPropertyFSG.sendStatusIfChanged(fSG_OperationState_Status);
        }
    }

    public void updateMobileServiceSupport(boolean[] blArray) {
        this.logChannel.log(10000000, "[AppConnectorPhone#updateMobileServiceSupport] called");
        MobileServiceSupport_Status mobileServiceSupport_Status = this.getMobileServiceSupportStatusCopy();
        if (blArray.length < 44) {
            this.logChannel.log(10000, "[AppConnectorPhone#updateMobileServiceSupport] fctList array too short (length=%1)", (long)blArray.length);
            return;
        }
        AbstractFunctionList abstractFunctionList = this.moduleFsg.getFunctionList();
        mobileServiceSupport_Status.fctList.fctActiveUserSupported = blArray[0] && abstractFunctionList.isFunctionSupported(17);
        mobileServiceSupport_Status.fctList.fctRegisterStateSupported = blArray[1] && abstractFunctionList.isFunctionSupported(18);
        mobileServiceSupport_Status.fctList.fctLockStateSupported = blArray[2] && abstractFunctionList.isFunctionSupported(19);
        mobileServiceSupport_Status.fctList.fctNetworkProviderSupported = blArray[3] && abstractFunctionList.isFunctionSupported(20);
        mobileServiceSupport_Status.fctList.fctSignalQualitySupported = blArray[4] && abstractFunctionList.isFunctionSupported(21);
        mobileServiceSupport_Status.fctList.fctCallStateSupported = blArray[5] && abstractFunctionList.isFunctionSupported(22);
        mobileServiceSupport_Status.fctList.fctCallInfoSupported = blArray[6] && abstractFunctionList.isFunctionSupported(23);
        mobileServiceSupport_Status.fctList.fctCallDurationSyncSupported = blArray[7] && abstractFunctionList.isFunctionSupported(24);
        mobileServiceSupport_Status.fctList.fctDisconnectReasonSupported = blArray[8] && abstractFunctionList.isFunctionSupported(25);
        mobileServiceSupport_Status.fctList.fctDialNumberSupported = blArray[9] && abstractFunctionList.isFunctionSupported(26);
        mobileServiceSupport_Status.fctList.fctDialServiceSupported = blArray[10] && abstractFunctionList.isFunctionSupported(27);
        mobileServiceSupport_Status.fctList.fctConfirmEmergencyCallSupported = blArray[11] && abstractFunctionList.isFunctionSupported(28);
        mobileServiceSupport_Status.fctList.fctHangupCallSupported = blArray[12] && abstractFunctionList.isFunctionSupported(29);
        mobileServiceSupport_Status.fctList.fctAcceptCallSupported = blArray[13] && abstractFunctionList.isFunctionSupported(30);
        mobileServiceSupport_Status.fctList.fctCallHoldSupported = blArray[14] && abstractFunctionList.isFunctionSupported(31);
        mobileServiceSupport_Status.fctList.fctResumeCallSupported = blArray[15] && abstractFunctionList.isFunctionSupported(32);
        mobileServiceSupport_Status.fctList.fctHandsFreeOnOffSupported = blArray[16] && abstractFunctionList.isFunctionSupported(33);
        mobileServiceSupport_Status.fctList.fctMicroMuteOnOffSupported = blArray[17] && abstractFunctionList.isFunctionSupported(34);
        mobileServiceSupport_Status.fctList.fctMpreleaseActiveCallAcceptWaitingCallSupported = blArray[18] && abstractFunctionList.isFunctionSupported(35);
        mobileServiceSupport_Status.fctList.fctMpswapSupported = blArray[19] && abstractFunctionList.isFunctionSupported(36);
        mobileServiceSupport_Status.fctList.fctMpcallHoldAcceptWaitingCallSupported = blArray[20] && abstractFunctionList.isFunctionSupported(37);
        mobileServiceSupport_Status.fctList.fctMpreleaseAllCallsAcceptWaitingCallSupported = blArray[21] && abstractFunctionList.isFunctionSupported(38);
        mobileServiceSupport_Status.fctList.fctMpsetWaitingCallOnHoldSupported = blArray[22] && abstractFunctionList.isFunctionSupported(39);
        mobileServiceSupport_Status.fctList.fctCcjoinSupported = blArray[23] && abstractFunctionList.isFunctionSupported(40);
        mobileServiceSupport_Status.fctList.fctCcsplitSupported = blArray[24] && abstractFunctionList.isFunctionSupported(41);
        mobileServiceSupport_Status.fctList.fctKeypadSupported = blArray[25] && abstractFunctionList.isFunctionSupported(42);
        mobileServiceSupport_Status.fctList.fctMobileBatteryLevelSupported = blArray[26] && abstractFunctionList.isFunctionSupported(43);
        mobileServiceSupport_Status.fctList.fctMissedCallIndicationSupported = blArray[28] && abstractFunctionList.isFunctionSupported(45);
        mobileServiceSupport_Status.fctList.fctMissedCallsSupported = blArray[29] && abstractFunctionList.isFunctionSupported(46);
        mobileServiceSupport_Status.fctList.fctReceivedCallsSupported = blArray[30] && abstractFunctionList.isFunctionSupported(47);
        mobileServiceSupport_Status.fctList.fctDialedNumbersSupported = blArray[31] && abstractFunctionList.isFunctionSupported(48);
        mobileServiceSupport_Status.fctList.fctCombinedNumbersSupported = blArray[32] && abstractFunctionList.isFunctionSupported(49);
        mobileServiceSupport_Status.fctList.fctCallStackDeleteAllSupported = blArray[33] && abstractFunctionList.isFunctionSupported(50);
        mobileServiceSupport_Status.fctList.fctGetNextListPosSupported = blArray[37] && abstractFunctionList.isFunctionSupported(54);
        mobileServiceSupport_Status.fctList.fctRingToneMuteOnOffSupported = blArray[39] && abstractFunctionList.isFunctionSupported(56);
        mobileServiceSupport_Status.fctList.fctAutomaticRedialSupported = blArray[40] && abstractFunctionList.isFunctionSupported(57);
        mobileServiceSupport_Status.fctList.fctAutomaticRedialExtendedInfoSupported = blArray[41] && abstractFunctionList.isFunctionSupported(58);
        mobileServiceSupport_Status.fctList.fctSupportedServiceNumbersSupported = blArray[42] && abstractFunctionList.isFunctionSupported(59);
        mobileServiceSupport_Status.fctList.fctFavoriteListSupported = blArray[43] && abstractFunctionList.isFunctionSupported(60);
        this.logChannel.log(1000000, "[AppConnectorPhone#updateMobileServiceSupport] %1", (Object)mobileServiceSupport_Status);
        this.sendPropertyStatus(16, mobileServiceSupport_Status);
    }

    public void updateRegisterState(int n, int n2, int n3) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateRegisterState] called (registerState=%1, networkType=%2, packetDataNetworkType=%3", (long)n, (long)n2, (long)n3);
        RegisterState_Status registerState_Status = new RegisterState_Status();
        registerState_Status.registerState = n;
        registerState_Status.networkType = n2;
        registerState_Status.packetDataNetworkType = n3;
        this.sendPropertyStatus(18, registerState_Status);
    }

    public void updateLockState(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateLockState] called (lockState=%1)", (long)n);
        LockState_Status lockState_Status = new LockState_Status();
        lockState_Status.lockState = n;
        this.sendPropertyStatus(19, lockState_Status);
    }

    public void updateNetworkProvider(int n, String string, int n2, String string2) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateNetworkProvider] called (networkProviderState=%2, networkProviderName=%1 ...", (Object)string, (long)n);
        this.logChannel.log(1000000, "[AppConnectorPhone#updateNetworkProvider] ... serviceProviderState=%2, serviceProviderName=%1", (Object)string2, (long)n2);
        NetworkProvider_Status networkProvider_Status = new NetworkProvider_Status();
        networkProvider_Status.networkProviderState = n;
        networkProvider_Status.networkProviderName.setContent(string);
        networkProvider_Status.serviceProviderState = n2;
        networkProvider_Status.serviceProviderName.setContent(string2);
        this.sendPropertyStatus(20, networkProvider_Status);
    }

    public void updateSignalQuality(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateSignalQuality] called (signalQuality=%1)", (long)n);
        SignalQuality_Status signalQuality_Status = new SignalQuality_Status();
        signalQuality_Status.quality = n;
        this.sendPropertyStatus(21, signalQuality_Status);
    }

    public void updateCallStates(CombiBAPCallState[] combiBAPCallStateArray, boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateCallStates] called");
        CallState_Status callState_Status = new CallState_Status();
        callState_Status.callOutgoingDiverted_eCallConfirmationPending.eCallConfirmationPending = bl;
        if (combiBAPCallStateArray == null) {
            this.logChannel.log(100000, "[AppConnectorPhone#updateCallStates] callStates==null, use EMPTY_CALL_STATES");
            combiBAPCallStateArray = EMPTY_CALL_STATES;
        }
        this.fillCallStateStatus(combiBAPCallStateArray, callState_Status);
        this.combiCallStates = combiBAPCallStateArray;
        this.sendPropertyStatus(22, callState_Status);
    }

    private void fillCallStateStatus(CombiBAPCallState[] combiBAPCallStateArray, CallState_Status callState_Status) {
        int n = combiBAPCallStateArray.length;
        if (n != 7) {
            this.logChannel.log(100000, "[AppConnectorPhone#fillCallStateStatus] callStates array has wrong size: %1 (expected %2)", (long)n, 7L);
        }
        block9: for (int i2 = 0; i2 < n; ++i2) {
            if (combiBAPCallStateArray[i2] == null) {
                this.setCallStateIdle(callState_Status, i2);
                continue;
            }
            switch (i2) {
                case 0: {
                    callState_Status.callState0 = combiBAPCallStateArray[i2].getCallState();
                    callState_Status.callType0 = combiBAPCallStateArray[i2].getCallType();
                    callState_Status.callOptions0.acceptCall = combiBAPCallStateArray[i2].isCallOptionAcceptCallEnabled();
                    callState_Status.callOptions0.mpholdAcceptWaiting = combiBAPCallStateArray[i2].isCallOptionMPCallHoldAcceptWaitingCallEnabled();
                    callState_Status.callOptions0.mpreleaseActiceCallAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled();
                    callState_Status.callOptions0.callHold = combiBAPCallStateArray[i2].isCallOptionCallHoldEnabled();
                    callState_Status.callOptions0.resumeCall = combiBAPCallStateArray[i2].isCallOptionResumeCallEnabled();
                    callState_Status.callOptions0.mpswap = combiBAPCallStateArray[i2].isCallOptionMPSwapEnabled();
                    callState_Status.callOptions0.ccjoin = combiBAPCallStateArray[i2].isCallOptionCCJoinEnabled();
                    callState_Status.callOptions0.ccsplit = combiBAPCallStateArray[i2].isCallOptionCCSplitEnabled();
                    callState_Status.callIncomingDiverted.call0Diverted = combiBAPCallStateArray[i2].isCallIncomingDiverted();
                    callState_Status.callOutgoingDiverted_eCallConfirmationPending.call0Diverted = combiBAPCallStateArray[i2].isCallOutgoingDiverted();
                    continue block9;
                }
                case 1: {
                    callState_Status.callState1 = combiBAPCallStateArray[i2].getCallState();
                    callState_Status.callType1 = combiBAPCallStateArray[i2].getCallType();
                    callState_Status.callOptions1.acceptCall = combiBAPCallStateArray[i2].isCallOptionAcceptCallEnabled();
                    callState_Status.callOptions1.mpcallHoldAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPCallHoldAcceptWaitingCallEnabled();
                    callState_Status.callOptions1.mpreleaseActiceCallAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled();
                    callState_Status.callOptions1.callHold = combiBAPCallStateArray[i2].isCallOptionCallHoldEnabled();
                    callState_Status.callOptions1.resumeCall = combiBAPCallStateArray[i2].isCallOptionResumeCallEnabled();
                    callState_Status.callOptions1.mpswap = combiBAPCallStateArray[i2].isCallOptionMPSwapEnabled();
                    callState_Status.callOptions1.ccjoin = combiBAPCallStateArray[i2].isCallOptionCCJoinEnabled();
                    callState_Status.callOptions1.ccsplit = combiBAPCallStateArray[i2].isCallOptionCCSplitEnabled();
                    callState_Status.callIncomingDiverted.call1Diverted = combiBAPCallStateArray[i2].isCallIncomingDiverted();
                    callState_Status.callOutgoingDiverted_eCallConfirmationPending.call1Diverted = combiBAPCallStateArray[i2].isCallOutgoingDiverted();
                    continue block9;
                }
                case 2: {
                    callState_Status.callState2 = combiBAPCallStateArray[i2].getCallState();
                    callState_Status.callType2 = combiBAPCallStateArray[i2].getCallType();
                    callState_Status.callOptions2.acceptCall = combiBAPCallStateArray[i2].isCallOptionAcceptCallEnabled();
                    callState_Status.callOptions2.mpcallHoldAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPCallHoldAcceptWaitingCallEnabled();
                    callState_Status.callOptions2.mpreleaseActiceCallAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled();
                    callState_Status.callOptions2.callHold = combiBAPCallStateArray[i2].isCallOptionCallHoldEnabled();
                    callState_Status.callOptions2.resumeCall = combiBAPCallStateArray[i2].isCallOptionResumeCallEnabled();
                    callState_Status.callOptions2.mpswap = combiBAPCallStateArray[i2].isCallOptionMPSwapEnabled();
                    callState_Status.callOptions2.ccjoin = combiBAPCallStateArray[i2].isCallOptionCCJoinEnabled();
                    callState_Status.callOptions2.ccsplit = combiBAPCallStateArray[i2].isCallOptionCCSplitEnabled();
                    callState_Status.callIncomingDiverted.call2Diverted = combiBAPCallStateArray[i2].isCallIncomingDiverted();
                    callState_Status.callOutgoingDiverted_eCallConfirmationPending.call2Diverted = combiBAPCallStateArray[i2].isCallOutgoingDiverted();
                    continue block9;
                }
                case 3: {
                    callState_Status.callState3 = combiBAPCallStateArray[i2].getCallState();
                    callState_Status.callType3 = combiBAPCallStateArray[i2].getCallType();
                    callState_Status.callOptions3.acceptCall = combiBAPCallStateArray[i2].isCallOptionAcceptCallEnabled();
                    callState_Status.callOptions3.mpcallHoldAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPCallHoldAcceptWaitingCallEnabled();
                    callState_Status.callOptions3.mpreleaseActiceCallAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled();
                    callState_Status.callOptions3.callHold = combiBAPCallStateArray[i2].isCallOptionCallHoldEnabled();
                    callState_Status.callOptions3.resumeCall = combiBAPCallStateArray[i2].isCallOptionResumeCallEnabled();
                    callState_Status.callOptions3.mpswap = combiBAPCallStateArray[i2].isCallOptionMPSwapEnabled();
                    callState_Status.callOptions3.ccjoin = combiBAPCallStateArray[i2].isCallOptionCCJoinEnabled();
                    callState_Status.callOptions3.ccsplit = combiBAPCallStateArray[i2].isCallOptionCCSplitEnabled();
                    callState_Status.callIncomingDiverted.call3Diverted = combiBAPCallStateArray[i2].isCallIncomingDiverted();
                    callState_Status.callOutgoingDiverted_eCallConfirmationPending.call3Diverted = combiBAPCallStateArray[i2].isCallOutgoingDiverted();
                    continue block9;
                }
                case 4: {
                    callState_Status.callState4 = combiBAPCallStateArray[i2].getCallState();
                    callState_Status.callType4 = combiBAPCallStateArray[i2].getCallType();
                    callState_Status.callOptions4.acceptCall = combiBAPCallStateArray[i2].isCallOptionAcceptCallEnabled();
                    callState_Status.callOptions4.mpcallHoldAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPCallHoldAcceptWaitingCallEnabled();
                    callState_Status.callOptions4.mpreleaseActiceCallAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled();
                    callState_Status.callOptions4.callHold = combiBAPCallStateArray[i2].isCallOptionCallHoldEnabled();
                    callState_Status.callOptions4.resumeCall = combiBAPCallStateArray[i2].isCallOptionResumeCallEnabled();
                    callState_Status.callOptions4.mpswap = combiBAPCallStateArray[i2].isCallOptionMPSwapEnabled();
                    callState_Status.callOptions4.ccjoin = combiBAPCallStateArray[i2].isCallOptionCCJoinEnabled();
                    callState_Status.callOptions4.ccsplit = combiBAPCallStateArray[i2].isCallOptionCCSplitEnabled();
                    callState_Status.callIncomingDiverted.call4Diverted = combiBAPCallStateArray[i2].isCallIncomingDiverted();
                    callState_Status.callOutgoingDiverted_eCallConfirmationPending.call4Diverted = combiBAPCallStateArray[i2].isCallOutgoingDiverted();
                    continue block9;
                }
                case 5: {
                    callState_Status.callState5 = combiBAPCallStateArray[i2].getCallState();
                    callState_Status.callType5 = combiBAPCallStateArray[i2].getCallType();
                    callState_Status.callOptions5.acceptCall = combiBAPCallStateArray[i2].isCallOptionAcceptCallEnabled();
                    callState_Status.callOptions5.mpcallHoldAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPCallHoldAcceptWaitingCallEnabled();
                    callState_Status.callOptions5.mpreleaseActiceCallAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled();
                    callState_Status.callOptions5.callHold = combiBAPCallStateArray[i2].isCallOptionCallHoldEnabled();
                    callState_Status.callOptions5.resumeCall = combiBAPCallStateArray[i2].isCallOptionResumeCallEnabled();
                    callState_Status.callOptions5.mpswap = combiBAPCallStateArray[i2].isCallOptionMPSwapEnabled();
                    callState_Status.callOptions5.ccjoin = combiBAPCallStateArray[i2].isCallOptionCCJoinEnabled();
                    callState_Status.callOptions5.ccsplit = combiBAPCallStateArray[i2].isCallOptionCCSplitEnabled();
                    callState_Status.callIncomingDiverted.call5Diverted = combiBAPCallStateArray[i2].isCallIncomingDiverted();
                    callState_Status.callOutgoingDiverted_eCallConfirmationPending.call5Diverted = combiBAPCallStateArray[i2].isCallOutgoingDiverted();
                    continue block9;
                }
                case 6: {
                    callState_Status.callState6 = combiBAPCallStateArray[i2].getCallState();
                    callState_Status.callType6 = combiBAPCallStateArray[i2].getCallType();
                    callState_Status.callOptions6.acceptCall = combiBAPCallStateArray[i2].isCallOptionAcceptCallEnabled();
                    callState_Status.callOptions6.mpcallHoldAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPCallHoldAcceptWaitingCallEnabled();
                    callState_Status.callOptions6.mpreleaseActiceCallAcceptWaitingCall = combiBAPCallStateArray[i2].isCallOptionMPReleaseActiceCallAcceptWaitingCallEnabled();
                    callState_Status.callOptions6.callHold = combiBAPCallStateArray[i2].isCallOptionCallHoldEnabled();
                    callState_Status.callOptions6.resumeCall = combiBAPCallStateArray[i2].isCallOptionResumeCallEnabled();
                    callState_Status.callOptions6.mpswap = combiBAPCallStateArray[i2].isCallOptionMPSwapEnabled();
                    callState_Status.callOptions6.ccjoin = combiBAPCallStateArray[i2].isCallOptionCCJoinEnabled();
                    callState_Status.callOptions6.ccsplit = combiBAPCallStateArray[i2].isCallOptionCCSplitEnabled();
                    callState_Status.callIncomingDiverted.call6Diverted = combiBAPCallStateArray[i2].isCallIncomingDiverted();
                    callState_Status.callOutgoingDiverted_eCallConfirmationPending.call6Diverted = combiBAPCallStateArray[i2].isCallOutgoingDiverted();
                    continue block9;
                }
                default: {
                    this.logChannel.log(10000, "[AppConnectorPhone#fillCallStateStatus] unsupported call state entry: %1. Only 0-6 are supported", (long)i2);
                }
            }
        }
    }

    private void setCallStateIdle(CallState_Status callState_Status, int n) {
        switch (n) {
            case 0: {
                callState_Status.callState0 = 0;
                callState_Status.callType0 = 0;
                callState_Status.callIncomingDiverted.call0Diverted = false;
                callState_Status.callOutgoingDiverted_eCallConfirmationPending.call0Diverted = false;
                break;
            }
            case 1: {
                callState_Status.callState1 = 0;
                callState_Status.callType1 = 0;
                callState_Status.callIncomingDiverted.call1Diverted = false;
                callState_Status.callOutgoingDiverted_eCallConfirmationPending.call1Diverted = false;
                break;
            }
            case 2: {
                callState_Status.callState2 = 0;
                callState_Status.callType2 = 0;
                callState_Status.callIncomingDiverted.call2Diverted = false;
                callState_Status.callOutgoingDiverted_eCallConfirmationPending.call2Diverted = false;
                break;
            }
            case 3: {
                callState_Status.callState3 = 0;
                callState_Status.callType3 = 0;
                callState_Status.callIncomingDiverted.call3Diverted = false;
                callState_Status.callOutgoingDiverted_eCallConfirmationPending.call3Diverted = false;
                break;
            }
            case 4: {
                callState_Status.callState4 = 0;
                callState_Status.callType4 = 0;
                callState_Status.callIncomingDiverted.call4Diverted = false;
                callState_Status.callOutgoingDiverted_eCallConfirmationPending.call4Diverted = false;
                break;
            }
            case 5: {
                callState_Status.callState5 = 0;
                callState_Status.callType5 = 0;
                callState_Status.callIncomingDiverted.call5Diverted = false;
                callState_Status.callOutgoingDiverted_eCallConfirmationPending.call5Diverted = false;
                break;
            }
            case 6: {
                callState_Status.callState6 = 0;
                callState_Status.callType6 = 0;
                callState_Status.callIncomingDiverted.call6Diverted = false;
                callState_Status.callOutgoingDiverted_eCallConfirmationPending.call6Diverted = false;
                break;
            }
            default: {
                this.logChannel.log(10000, "[AppConnectorPhone#setCallStateIdle] unsupported call state entry: %1. Only 0-6 are supported", (long)n);
            }
        }
    }

    public void updateCallInfo(CombiBAPCallInfo[] combiBAPCallInfoArray) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateCallInfo] called");
        CallInfo_Status callInfo_Status = new CallInfo_Status();
        if (combiBAPCallInfoArray == null) {
            this.logChannel.log(100000, "[AppConnectorPhone#updateCallInfo] callInfo==null, use EMPTY_CALL_INFOS");
            combiBAPCallInfoArray = EMPTY_CALL_INFOS;
        }
        this.fillCallInfoStatus(combiBAPCallInfoArray, callInfo_Status);
        this.updateCallPictures(combiBAPCallInfoArray);
        this.combiCallInfos = combiBAPCallInfoArray;
        this.sendPropertyStatus(23, callInfo_Status);
    }

    public void updateCallDurations(CallStartTime[] callStartTimeArray) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateCallDurations] callStartTimes: %1", (Object)ArrayPrinter.forArray(callStartTimeArray));
        CallDurationSync_Status callDurationSync_Status = new CallDurationSync_Status();
        callDurationSync_Status.timeStampCall0 = callStartTimeArray[0].getTimeStamp();
        callDurationSync_Status.timeStampCall1 = callStartTimeArray[1].getTimeStamp();
        callDurationSync_Status.timeStampCall2 = callStartTimeArray[2].getTimeStamp();
        callDurationSync_Status.timeStampCall3 = callStartTimeArray[3].getTimeStamp();
        callDurationSync_Status.timeStampCall4 = callStartTimeArray[4].getTimeStamp();
        callDurationSync_Status.timeStampCall5 = callStartTimeArray[5].getTimeStamp();
        callDurationSync_Status.timeStampCall6 = callStartTimeArray[6].getTimeStamp();
        this.sendPropertyStatus(24, callDurationSync_Status);
    }

    private void fillCallInfoStatus(CombiBAPCallInfo[] combiBAPCallInfoArray, CallInfo_Status callInfo_Status) {
        StringBuffer stringBuffer = new StringBuffer();
        int n = combiBAPCallInfoArray.length;
        if (n != 7) {
            this.logChannel.log(100000, "[AppConnectorPhone#fillCallInfoStatus] callInfo array has wrong size: %1 (expected %2)", (long)n, 7L);
        }
        block9: for (int i2 = 0; i2 < n; ++i2) {
            if (this.logChannel.isDebug()) {
                stringBuffer.append("call ");
                stringBuffer.append(i2);
                stringBuffer.append(": ");
                stringBuffer.append(combiBAPCallInfoArray[i2]);
                stringBuffer.append('\n');
            }
            if (combiBAPCallInfoArray[i2] == null) {
                this.setCallInfoNotUsed(callInfo_Status, i2);
                continue;
            }
            String string = combiBAPCallInfoArray[i2].getPbName();
            String string2 = combiBAPCallInfoArray[i2].getTelNumber();
            int n2 = combiBAPCallInfoArray[i2].getCategory();
            switch (i2) {
                case 0: {
                    callInfo_Status.pbName0.setContent(string);
                    callInfo_Status.telNumber0.setContent(string2);
                    callInfo_Status.category0 = n2;
                    continue block9;
                }
                case 1: {
                    callInfo_Status.pbName1.setContent(string);
                    callInfo_Status.telNumber1.setContent(string2);
                    callInfo_Status.category1 = n2;
                    continue block9;
                }
                case 2: {
                    callInfo_Status.pbName2.setContent(string);
                    callInfo_Status.telNumber2.setContent(string2);
                    callInfo_Status.category2 = n2;
                    continue block9;
                }
                case 3: {
                    callInfo_Status.pbName3.setContent(string);
                    callInfo_Status.telNumber3.setContent(string2);
                    callInfo_Status.category3 = n2;
                    continue block9;
                }
                case 4: {
                    callInfo_Status.pbName4.setContent(string);
                    callInfo_Status.telNumber4.setContent(string2);
                    callInfo_Status.category4 = n2;
                    continue block9;
                }
                case 5: {
                    callInfo_Status.pbName5.setContent(string);
                    callInfo_Status.telNumber5.setContent(string2);
                    callInfo_Status.category5 = n2;
                    continue block9;
                }
                case 6: {
                    callInfo_Status.pbName6.setContent(string);
                    callInfo_Status.telNumber6.setContent(string2);
                    callInfo_Status.category6 = n2;
                    continue block9;
                }
                default: {
                    this.logChannel.log(10000, "[AppConnectorPhone#fillCallInfoStatus] unsupported call info entry: %1. Only 0-6 are supported", (long)i2);
                }
            }
        }
        this.logChannel.log(10000000, "[AppConnectorPhone#fillCallInfoStatus] callInfo:\n%1", (Object)stringBuffer);
    }

    private void setCallInfoNotUsed(CallInfo_Status callInfo_Status, int n) {
        switch (n) {
            case 0: {
                callInfo_Status.pbName0.setContent(EMPTY_STRING);
                callInfo_Status.telNumber0.setContent(EMPTY_STRING);
                callInfo_Status.category0 = 0;
                break;
            }
            case 1: {
                callInfo_Status.pbName1.setContent(EMPTY_STRING);
                callInfo_Status.telNumber1.setContent(EMPTY_STRING);
                callInfo_Status.category1 = 0;
                break;
            }
            case 2: {
                callInfo_Status.pbName2.setContent(EMPTY_STRING);
                callInfo_Status.telNumber2.setContent(EMPTY_STRING);
                callInfo_Status.category2 = 0;
                break;
            }
            case 3: {
                callInfo_Status.pbName3.setContent(EMPTY_STRING);
                callInfo_Status.telNumber3.setContent(EMPTY_STRING);
                callInfo_Status.category3 = 0;
                break;
            }
            case 4: {
                callInfo_Status.pbName4.setContent(EMPTY_STRING);
                callInfo_Status.telNumber4.setContent(EMPTY_STRING);
                callInfo_Status.category4 = 0;
                break;
            }
            case 5: {
                callInfo_Status.pbName5.setContent(EMPTY_STRING);
                callInfo_Status.telNumber5.setContent(EMPTY_STRING);
                callInfo_Status.category5 = 0;
                break;
            }
            case 6: {
                callInfo_Status.pbName6.setContent(EMPTY_STRING);
                callInfo_Status.telNumber6.setContent(EMPTY_STRING);
                callInfo_Status.category6 = 0;
                break;
            }
            default: {
                this.logChannel.log(10000, "[AppConnectorPhone#setCallInfoNotUsed] unsupported call info entry: %1. Only 0-6 are supported", (long)n);
            }
        }
    }

    private void updateCallPictures(CombiBAPCallInfo[] combiBAPCallInfoArray) {
        for (int i2 = 0; i2 < combiBAPCallInfoArray.length; ++i2) {
            int n;
            ResourceLocator resourceLocator;
            if (combiBAPCallInfoArray[i2] == null) {
                if (this.combiCallInfos[i2] == null) {
                    return;
                }
                resourceLocator = new ResourceLocator();
                this.logChannel.log(10000000, "[AppConnectorPhone#updateCallPictures] callInfo at index=%1 is null", (long)i2);
                n = 0;
            } else {
                resourceLocator = new ResourceLocator(combiBAPCallInfoArray[i2].getPictureID(), combiBAPCallInfoArray[i2].getPictureURL());
                n = combiBAPCallInfoArray[i2].getTelCallType();
            }
            if (this.combiCallInfos[i2] != null && this.combiCallInfos[i2].getPictureID() == resourceLocator.getId() && this.combiCallInfos[i2].getPictureURL().equals(resourceLocator.getUrl()) && this.combiCallInfos[i2].getTelCallType() == n) {
                this.logChannel.log(10000000, "[AppConnectorPhone#updateCallPictures] call picture for index=%1 didn't change", (long)i2);
                continue;
            }
            ((AbstractCombiModule)this.moduleFsg).getPictureManager().responseActiveCallPicture(i2, n, resourceLocator, true);
        }
    }

    public void updateDisconnectReason(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateDisconnectReason] called (disconnectReason=%1)", (long)n);
        DisconnectReason_Status disconnectReason_Status = new DisconnectReason_Status();
        disconnectReason_Status.disconnectReason = n;
        this.sendPropertyStatus(25, disconnectReason_Status);
    }

    public void dialNumberResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#dialNumberResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(26);
        if (n == 144) {
            this.moduleFsg.getRequestHandler().requestErrorCode(this.moduleFsg.getLSGID(), 26, n);
            bAPFunctionMethodFSG.reset();
        } else {
            DialNumber_Result dialNumber_Result = (DialNumber_Result)this.moduleFsg.createResultSerializer(26);
            dialNumber_Result.dialNumber_Result = n;
            bAPFunctionMethodFSG.resultREQ(dialNumber_Result);
        }
    }

    public void dialNumberFromAdbEntryResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#dialNumbeFromAdbEntry] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(26);
        if (n == 144) {
            this.moduleFsg.getRequestHandler().requestErrorCode(this.moduleFsg.getLSGID(), 26, n);
            bAPFunctionMethodFSG.reset();
        } else {
            DialNumber_Result dialNumber_Result = (DialNumber_Result)this.moduleFsg.createResultSerializer(26);
            dialNumber_Result.dialNumber_Result = n;
            bAPFunctionMethodFSG.resultREQ(dialNumber_Result);
        }
    }

    public void dialServiceResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#dialServiceResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(27);
        DialService_Result dialService_Result = (DialService_Result)this.moduleFsg.createResultSerializer(27);
        dialService_Result.dialService_Result = n;
        bAPFunctionMethodFSG.resultREQ(dialService_Result);
    }

    public void confirmEmergencyCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#confirmEmergencyCallResult] called (confirmEmergencyCallResult=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(28);
        ConfirmEmergencyCall_Result confirmEmergencyCall_Result = (ConfirmEmergencyCall_Result)this.moduleFsg.createResultSerializer(28);
        confirmEmergencyCall_Result.confirmErmergencyCall_Result = n;
        bAPFunctionMethodFSG.resultREQ(confirmEmergencyCall_Result);
    }

    public void hangupCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#hangupCallResult] called (hangupCallResult=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(29);
        HangupCall_Result hangupCall_Result = (HangupCall_Result)this.moduleFsg.createResultSerializer(29);
        hangupCall_Result.hangupCall_Result = n;
        bAPFunctionMethodFSG.resultREQ(hangupCall_Result);
    }

    public void acceptCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#acceptCallResult] called (acceptCallResult=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(30);
        AcceptCall_Result acceptCall_Result = (AcceptCall_Result)this.moduleFsg.createResultSerializer(30);
        acceptCall_Result.acceptCall_Result = n;
        bAPFunctionMethodFSG.resultREQ(acceptCall_Result);
    }

    public void callHoldResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#callHoldResult] called (callHoldResult=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(31);
        CallHold_Result callHold_Result = (CallHold_Result)this.moduleFsg.createResultSerializer(31);
        callHold_Result.callHold_Result = n;
        bAPFunctionMethodFSG.resultREQ(callHold_Result);
    }

    public void resumeCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#resumeCallResult] called (resumeCallResult=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(32);
        ResumeCall_Result resumeCall_Result = (ResumeCall_Result)this.moduleFsg.createResultSerializer(32);
        resumeCall_Result.resumeCall_Result = n;
        bAPFunctionMethodFSG.resultREQ(resumeCall_Result);
    }

    public void updateMicMuteState(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateMicMuteState] called (micMuteState=%1)", bl);
        MicroMuteOnOff_Status microMuteOnOff_Status = new MicroMuteOnOff_Status();
        microMuteOnOff_Status.microMuteOnOff.on = bl;
        this.sendPropertyStatus(34, microMuteOnOff_Status);
    }

    public void releaseActiveCallAcceptWaitingCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#releaseActiveCallAcceptWaitingCallResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(35);
        MPRelActiveCallAcceptWC_Result mPRelActiveCallAcceptWC_Result = (MPRelActiveCallAcceptWC_Result)this.moduleFsg.createResultSerializer(35);
        mPRelActiveCallAcceptWC_Result.mpracawc_Result = n;
        bAPFunctionMethodFSG.resultREQ(mPRelActiveCallAcceptWC_Result);
    }

    public void swapCallsResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#swapCallsResult] called (swapCallsResult=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(36);
        MPSwap_Result mPSwap_Result = (MPSwap_Result)this.moduleFsg.createResultSerializer(36);
        mPSwap_Result.mpswap_Result = n;
        bAPFunctionMethodFSG.resultREQ(mPSwap_Result);
    }

    public void callHoldAcceptWaitingCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#callHoldAcceptWaitingCallResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(37);
        MPCallHoldAcceptWC_Result mPCallHoldAcceptWC_Result = (MPCallHoldAcceptWC_Result)this.moduleFsg.createResultSerializer(37);
        mPCallHoldAcceptWC_Result.mpchawc_Result = n;
        bAPFunctionMethodFSG.resultREQ(mPCallHoldAcceptWC_Result);
    }

    public void releaseAllCallsAcceptWaitingCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#releaseAllCallsAcceptWaitingCallResult] called (result=$1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(38);
        MPRelAllCallsAcceptWC_Result mPRelAllCallsAcceptWC_Result = (MPRelAllCallsAcceptWC_Result)this.moduleFsg.createResultSerializer(38);
        mPRelAllCallsAcceptWC_Result.mpracawc_Result = n;
        bAPFunctionMethodFSG.resultREQ(mPRelAllCallsAcceptWC_Result);
    }

    public void setWaitingCallOnHoldResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#setWaitingCallOnHoldResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(39);
        MPSetWaitingCallOnHold_Result mPSetWaitingCallOnHold_Result = (MPSetWaitingCallOnHold_Result)this.moduleFsg.createResultSerializer(39);
        mPSetWaitingCallOnHold_Result.mpswcoh_Result = n;
        bAPFunctionMethodFSG.resultREQ(mPSetWaitingCallOnHold_Result);
    }

    public void joinCallsResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#joinCallsResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(40);
        CCJoin_Result cCJoin_Result = (CCJoin_Result)this.moduleFsg.createResultSerializer(40);
        cCJoin_Result.ccjoin_Result = n;
        bAPFunctionMethodFSG.resultREQ(cCJoin_Result);
    }

    public void splitCallResult(int n) {
        this.logChannel.log(1000000, "[AppConnectorPhone#splitCallResult] called (result=%1)", (long)n);
        BAPFunctionMethodFSG bAPFunctionMethodFSG = this.moduleFsg.getBAPFunctionMethodFSG(41);
        CCSplit_Result cCSplit_Result = (CCSplit_Result)this.moduleFsg.createResultSerializer(41);
        cCSplit_Result.ccsplit_Result = n;
        bAPFunctionMethodFSG.resultREQ(cCSplit_Result);
    }

    public void updateMobileBatteryLevel(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateMobileBatteryLevel] called (mobile1ChargeLevelCritical=%1, mobile2ChargeLevelCritical=%2", bl, bl2);
        this.logChannel.log(1000000, "[AppConnectorPhone#updateMobileBatteryLevel] called (handset1ChargeLevelCritical=%1, handset2ChargeLevelCritical=%2", bl3, bl4);
        CombiBAPhoneMobileBatteryLevel.ChargeLevel chargeLevel = new CombiBAPhoneMobileBatteryLevel.ChargeLevel(254, bl);
        CombiBAPhoneMobileBatteryLevel.ChargeLevel chargeLevel2 = new CombiBAPhoneMobileBatteryLevel.ChargeLevel(254, bl2);
        CombiBAPhoneMobileBatteryLevel.ChargeLevel chargeLevel3 = new CombiBAPhoneMobileBatteryLevel.ChargeLevel(254, bl3);
        CombiBAPhoneMobileBatteryLevel.ChargeLevel chargeLevel4 = new CombiBAPhoneMobileBatteryLevel.ChargeLevel(254, bl4);
        CombiBAPhoneMobileBatteryLevel combiBAPhoneMobileBatteryLevel = new CombiBAPhoneMobileBatteryLevel(chargeLevel, chargeLevel2, chargeLevel3, chargeLevel4);
        this.updateMobileBatteryLevel(combiBAPhoneMobileBatteryLevel);
    }

    public void updateMobileBatteryLevel(CombiBAPhoneMobileBatteryLevel combiBAPhoneMobileBatteryLevel) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateMobileBatteryLevel] batteryLevel: %1", (Object)combiBAPhoneMobileBatteryLevel);
        MobileBatteryLevel_Status mobileBatteryLevel_Status = new MobileBatteryLevel_Status();
        mobileBatteryLevel_Status.chargeLevel_Mobile1 = combiBAPhoneMobileBatteryLevel.getMobileChargeLevel1().getChargeLevelPercent();
        mobileBatteryLevel_Status.chargeLevel_Mobile2 = combiBAPhoneMobileBatteryLevel.getMobileChargeLevel2().getChargeLevelPercent();
        mobileBatteryLevel_Status.chargeLevel_Handset1 = combiBAPhoneMobileBatteryLevel.getHandsetChargeLevel1().getChargeLevelPercent();
        mobileBatteryLevel_Status.chargeLevel_Handset2 = combiBAPhoneMobileBatteryLevel.getHandsetChargeLevel2().getChargeLevelPercent();
        mobileBatteryLevel_Status.warningLevel.mobile1ChargeLevelCritical = combiBAPhoneMobileBatteryLevel.getMobileChargeLevel1().isCritical();
        mobileBatteryLevel_Status.warningLevel.mobile2ChargeLevelCritical = combiBAPhoneMobileBatteryLevel.getMobileChargeLevel2().isCritical();
        mobileBatteryLevel_Status.warningLevel.handset1ChargeLevelCritical = combiBAPhoneMobileBatteryLevel.getHandsetChargeLevel1().isCritical();
        mobileBatteryLevel_Status.warningLevel.handset2ChargeLevelCritical = combiBAPhoneMobileBatteryLevel.getHandsetChargeLevel2().isCritical();
        this.sendPropertyStatus(43, mobileBatteryLevel_Status);
    }

    public void updateMissedCallIndication(int n, int n2) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateMissedCallIndication] missedCalls=%1, missedNumbers=%2", (long)n, (long)n2);
        MissedCallIndication_Status missedCallIndication_Status = new MissedCallIndication_Status();
        missedCallIndication_Status.missedCalls = n;
        missedCallIndication_Status.missedNumbers = n2;
        this.moduleFsg.getBAPFunctionPropertyFSG(45).sendStatus(missedCallIndication_Status);
    }

    public void updateMissedCalls(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
        this.logChannel.log(100000, "[AppConnectorPhone#updateMissedCalls] function not supported -> only CombinedNumbers is supported");
    }

    public void updateReceivedCalls(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
        this.logChannel.log(100000, "[AppConnectorPhone#updateReceivedCalls] function not supported -> only CombinedNumbers is supported");
    }

    public void updateDialedNumbers(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
        this.logChannel.log(100000, "[AppConnectorPhone#updateDialedNumbers] function not supported -> only CombinedNumbers is supported");
    }

    public void updateCombinedNumbers(CombiBAPCallStackEntry[] combiBAPCallStackEntryArray) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateCombinedNumbers] called (listSize=%1)", (long)combiBAPCallStackEntryArray.length);
        ArrayHandler arrayHandler = this.moduleFsg.getBAPFunctionArrayFSG(49).getArrayHandler();
        if (arrayHandler != null) {
            ((CombinedNumbersListHandler)arrayHandler).updateList(combiBAPCallStackEntryArray);
        } else {
            this.logChannel.log(10000, "[AppConnectorPhone#updateCombinedNumbers] no array handler available for 'CombinedNumbers'");
        }
    }

    public void updateRingToneMuteState(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateRingToneMuteState] ringToneMuted=%1", bl);
        RingToneMuteOnOff_Status ringToneMuteOnOff_Status = new RingToneMuteOnOff_Status();
        ringToneMuteOnOff_Status.ringToneMuteOnOff.on = bl;
        this.sendPropertyStatus(56, ringToneMuteOnOff_Status);
    }

    public void updateAutomaticRedialActive(boolean bl) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateAutomaticRedialActive] called (automaticRedialActive=%1)", bl);
        AutomaticRedial_Status automaticRedial_Status = new AutomaticRedial_Status();
        automaticRedial_Status.automaticRedialState.automaticRedialActive = bl;
        this.sendPropertyStatus(57, automaticRedial_Status);
    }

    public void updateAutomaticRedialExtendedInfo(int n, String string, String string2, int n2) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateAutomaticRedialExtendedInfo] redialTimeStamp=%1, category=%2, ...", (long)n, (long)n2);
        this.logChannel.log(1000000, "[AppConnectorPhone#updateAutomaticRedialExtendedInfo] ..., pbName=%1, telNumber=%2", (Object)string, (Object)string2);
        AutomaticRedialExtendedInfo_Status automaticRedialExtendedInfo_Status = new AutomaticRedialExtendedInfo_Status();
        automaticRedialExtendedInfo_Status.redial_TimeStamp = n;
        automaticRedialExtendedInfo_Status.pbName.setContent(string);
        automaticRedialExtendedInfo_Status.telNumber.setContent(string2);
        automaticRedialExtendedInfo_Status.category = n2;
        this.sendPropertyStatus(58, automaticRedialExtendedInfo_Status);
    }

    public void updateSupportedServiceNumbers(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateSupportedServiceNumbers] voiceMailboxSupported=%1, infoCallSupported=%2, ...", bl, bl2);
        this.logChannel.log(1000000, "[AppConnectorPhone#updateSupportedServiceNumbers] ..., serviceCallSupported=%1, emergencyCallSupported=%2", bl3, bl4);
        SupportedServiceNumbers_Status supportedServiceNumbers_Status = new SupportedServiceNumbers_Status();
        supportedServiceNumbers_Status.serviceNumbers.voiceMailboxSupported = bl;
        supportedServiceNumbers_Status.serviceNumbers.infoCallSupported = bl2;
        supportedServiceNumbers_Status.serviceNumbers.serviceCallSupported = bl3;
        supportedServiceNumbers_Status.serviceNumbers.emergencyCallSupported = bl4;
        this.sendPropertyStatus(59, supportedServiceNumbers_Status);
    }

    public void updateFavoriteList(CombiBAPFavoriteNumberEntry[] combiBAPFavoriteNumberEntryArray) {
        this.logChannel.log(1000000, "[AppConnectorPhone#updateFavoriteList] called (listSize=%1)", (long)combiBAPFavoriteNumberEntryArray.length);
        ArrayHandler arrayHandler = this.moduleFsg.getBAPFunctionArrayFSG(60).getArrayHandler();
        if (arrayHandler != null) {
            ((FavoriteNumbersListHandler)arrayHandler).updateList(combiBAPFavoriteNumberEntryArray);
        } else {
            this.logChannel.log(10000, "[AppConnectorPhone#updateFavoriteList] no array handler available for 'FavoriteList'");
        }
    }

    static {
        EMPTY_CALL_INFOS = new CombiBAPCallInfo[7];
        EMPTY_CALL_STATES = new CombiBAPCallState[7];
        for (int i2 = 0; i2 < 7; ++i2) {
            AppConnectorPhone.EMPTY_CALL_INFOS[i2] = new CombiBAPCallInfo();
            AppConnectorPhone.EMPTY_CALL_STATES[i2] = new CombiBAPCallState();
        }
    }

    private class CallPictureProvider
    implements IPictureProvider {
        private CallPictureProvider() {
        }

        public void requestPicture(long l) {
            int n = (int)l;
            if (n >= 0 && n < 7) {
                int n2 = AppConnectorPhone.this.combiCallStates != null && AppConnectorPhone.this.combiCallStates[n] != null ? AppConnectorPhone.this.combiCallStates[n].getCallType() : 0;
                ResourceLocator resourceLocator = AppConnectorPhone.this.combiCallInfos != null && AppConnectorPhone.this.combiCallInfos[n] != null ? new ResourceLocator(AppConnectorPhone.this.combiCallInfos[n].getPictureID(), AppConnectorPhone.this.combiCallInfos[n].getPictureURL()) : new ResourceLocator();
                ((AbstractCombiModule)AppConnectorPhone.this.moduleFsg).getPictureManager().responseActiveCallPicture(n, n2, resourceLocator, false);
            } else {
                AppConnectorPhone.this.logChannel.log(100000, "[AppConnectorPhone.CallPictureProvider#requestPicture] invalid callID: %1", (long)n);
            }
        }

        public void requestPicture(long l, int n) {
            this.requestPicture(l);
        }
    }
}

