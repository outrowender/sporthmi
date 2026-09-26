/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServicePhone;
import de.audi.atip.interapp.phone.IEcallState;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BAPPropertyTelMobileServiceSupport
extends AbstractTel1EnqueuedBAPPropertyHandler {
    private static final Map SERVICE_STRING_MAPPING = new HashMap();
    private volatile boolean[] supportedServices = new boolean[44];

    private static String getServiceString(int n) {
        String string = (String)SERVICE_STRING_MAPPING.get(new Integer(n));
        if (string == null) {
            string = new StringBuffer().append("UnhandledService(").append(n).append(")").toString();
        }
        return string;
    }

    private static Buffer getSupportedServiceArrayBuffer(boolean[] blArray) {
        Buffer buffer = new Buffer();
        buffer.append("[");
        for (int i2 = 0; i2 < blArray.length; ++i2) {
            buffer.append(BAPPropertyTelMobileServiceSupport.getServiceString(i2));
            buffer.append("=");
            buffer.append(blArray[i2]);
            if (i2 >= blArray.length - 1) continue;
            buffer.append(", ");
        }
        buffer.append("]");
        return buffer;
    }

    private static boolean isNADforSOSAvailable(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationState() != null && iGlobalTelephoneStateStruct.getPhoneModuleState() == 2 || iGlobalTelephoneStateStruct.getNadMode() == 1;
    }

    private static boolean isNetworkProviderSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() : false;
    }

    private static boolean isSignalQualitySupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() : false;
    }

    private static boolean isCallStateSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
    }

    private static boolean isCallDurationSyncSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
    }

    private static boolean isCallInfoSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
    }

    private static boolean isDisconnectReasonSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
    }

    private static boolean isDialNumberSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() && iGlobalTelephoneStateStruct.isDialingPossible() : false;
    }

    private static boolean isConfirmEmergencyCallSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() || BAPPropertyTelMobileServiceSupport.isNADforSOSAvailable(iGlobalTelephoneStateStruct) : false;
    }

    private static boolean isHangupCallCallSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getCallLeadingDevice().isPhoneReady() || BAPPropertyTelMobileServiceSupport.isNADforSOSAvailable(iGlobalTelephoneStateStruct) : false;
    }

    private static boolean isDialServiceSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getCallLeadingDevice() != null && iGlobalTelephoneStateStruct.getCallLeadingDevice().isPhoneReady() && iGlobalTelephoneStateStruct.isDialingPossible() && (iGlobalTelephoneStateStruct.isAudiServiceAvailable() || iGlobalTelephoneStateStruct.isMailboxNumberAvailable());
    }

    private static boolean isAcceptCallSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
    }

    private static boolean isCallHoldSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() && iTelDSIMobileEquipmentDeviceState.isMultipartySupported() : false;
    }

    private static boolean isResumeCallSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() && iTelDSIMobileEquipmentDeviceState.isMultipartySupported() : false;
    }

    private static boolean isMicroMuteOnOffSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState, IEcallState iEcallState) {
        boolean bl;
        boolean bl2 = bl = iEcallState != null && iEcallState.getCall() != null ? iEcallState.getCall().isServiceCall() : false;
        if (bl) {
            return false;
        }
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
    }

    private static boolean isMPReleaseActiveCallAcceptWaitingCallSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() : false;
    }

    private static boolean isMPSwapSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() && iTelDSIMobileEquipmentDeviceState.isMultipartySupported() : false;
    }

    private static boolean isMPCallHoldAcceptWaitingCallSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() && iTelDSIMobileEquipmentDeviceState.isMultipartySupported() : false;
    }

    private static boolean isMPSetWaitingCallOnHoldSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() && iTelDSIMobileEquipmentDeviceState.isResponseAndHoldSupported() : false;
    }

    private static boolean isCCJoinSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.isPhoneReady() && iTelDSIMobileEquipmentDeviceState.isMultipartySupported() && iTelDSIMobileEquipmentDeviceState.isAddToConferenceSupported() : false;
    }

    private static boolean isMobileBatteryLevelSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() && (iGlobalTelephoneStateStruct.getTelMode() == 3 || iGlobalTelephoneStateStruct.getTelMode() == 2) : false;
    }

    private static boolean isMissedCallIndicationSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() : false;
    }

    private static boolean isCombinedNumbersSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() : false;
    }

    private static boolean isGetNextListPosSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() : false;
    }

    private static boolean isRingToneMuteOnOffSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null ? iTelDSIMobileEquipmentDeviceState.getCallState() != null && (iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() == 15 || iTelDSIMobileEquipmentDeviceState.getCallState().getMpCallState() == 27) : false;
    }

    private static boolean isSupportedServiceNumbers(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() && (iGlobalTelephoneStateStruct.isAudiServiceAvailable() || iGlobalTelephoneStateStruct.isMailboxNumberAvailable()) : false;
    }

    private static boolean isFavoriteListSupported(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isPhoneReady() : false;
    }

    private static boolean isSplitCallSupported(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        return iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.isPhoneReady() && iTelDSIMobileEquipmentDeviceState.isMultipartySupported() && iTelDSIMobileEquipmentDeviceState.isEnhancedCallFeaturesSupported();
    }

    public BAPPropertyTelMobileServiceSupport(ITelApplication iTelApplication, DispatcherBase dispatcherBase) {
        super(iTelApplication, dispatcherBase);
    }

    @Override
    protected boolean doProcessGlobalTelephoneStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null;
    }

    @Override
    protected void updateAsync() {
        CombiBAPServicePhone combiBAPServicePhone = this.getCombiService();
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState = this.getCallLeadingDeviceState();
        if (combiBAPServicePhone != null) {
            if (iGlobalTelephoneStateStruct != null) {
                IEcallState iEcallState = iGlobalTelephoneStateStruct.getConnectedGatewayState();
                boolean[] blArray = new boolean[44];
                blArray[0] = false;
                blArray[1] = true;
                blArray[2] = true;
                blArray[3] = BAPPropertyTelMobileServiceSupport.isNetworkProviderSupported(iGlobalTelephoneStateStruct);
                blArray[4] = BAPPropertyTelMobileServiceSupport.isSignalQualitySupported(iGlobalTelephoneStateStruct);
                blArray[5] = BAPPropertyTelMobileServiceSupport.isCallStateSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[6] = BAPPropertyTelMobileServiceSupport.isCallInfoSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[7] = BAPPropertyTelMobileServiceSupport.isCallDurationSyncSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[8] = BAPPropertyTelMobileServiceSupport.isDisconnectReasonSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[9] = BAPPropertyTelMobileServiceSupport.isDialNumberSupported(iGlobalTelephoneStateStruct);
                blArray[10] = BAPPropertyTelMobileServiceSupport.isDialServiceSupported(iGlobalTelephoneStateStruct);
                blArray[11] = BAPPropertyTelMobileServiceSupport.isConfirmEmergencyCallSupported(iGlobalTelephoneStateStruct);
                blArray[12] = BAPPropertyTelMobileServiceSupport.isHangupCallCallSupported(iGlobalTelephoneStateStruct);
                blArray[13] = BAPPropertyTelMobileServiceSupport.isAcceptCallSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[14] = BAPPropertyTelMobileServiceSupport.isCallHoldSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[15] = BAPPropertyTelMobileServiceSupport.isResumeCallSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[16] = false;
                blArray[17] = BAPPropertyTelMobileServiceSupport.isMicroMuteOnOffSupported(iTelDSIMobileEquipmentDeviceState, iEcallState);
                blArray[18] = BAPPropertyTelMobileServiceSupport.isMPReleaseActiveCallAcceptWaitingCallSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[19] = BAPPropertyTelMobileServiceSupport.isMPSwapSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[20] = BAPPropertyTelMobileServiceSupport.isMPCallHoldAcceptWaitingCallSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[21] = false;
                blArray[22] = BAPPropertyTelMobileServiceSupport.isMPSetWaitingCallOnHoldSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[23] = BAPPropertyTelMobileServiceSupport.isCCJoinSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[24] = BAPPropertyTelMobileServiceSupport.isSplitCallSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[25] = false;
                blArray[26] = BAPPropertyTelMobileServiceSupport.isMobileBatteryLevelSupported(iGlobalTelephoneStateStruct);
                blArray[28] = BAPPropertyTelMobileServiceSupport.isMissedCallIndicationSupported(iGlobalTelephoneStateStruct);
                blArray[29] = false;
                blArray[30] = false;
                blArray[31] = false;
                blArray[32] = BAPPropertyTelMobileServiceSupport.isCombinedNumbersSupported(iGlobalTelephoneStateStruct);
                blArray[33] = false;
                blArray[37] = BAPPropertyTelMobileServiceSupport.isGetNextListPosSupported(iGlobalTelephoneStateStruct);
                blArray[39] = BAPPropertyTelMobileServiceSupport.isRingToneMuteOnOffSupported(iTelDSIMobileEquipmentDeviceState);
                blArray[40] = false;
                blArray[41] = false;
                blArray[42] = BAPPropertyTelMobileServiceSupport.isSupportedServiceNumbers(iGlobalTelephoneStateStruct);
                blArray[43] = BAPPropertyTelMobileServiceSupport.isFavoriteListSupported(iGlobalTelephoneStateStruct);
                if (this.checkSupportedServicesChanged(blArray)) {
                    this.log.log(1078071040, "[BAPPropertyTelMobileServiceSupport#update] %1", (Object)BAPPropertyTelMobileServiceSupport.getSupportedServiceArrayBuffer(this.supportedServices));
                    combiBAPServicePhone.updateMobileServiceSupport(this.supportedServices);
                }
            } else {
                this.log.log(-1601830656, "[BAPPropertyTelMobileServiceSupport#update] state is null --> NOP!");
            }
        } else {
            this.log.log(-1601830656, "[BAPPropertyTelMobileServiceSupport#update] CombiBAPServicePhone is null --> NOP!");
        }
    }

    private boolean checkSupportedServicesChanged(boolean[] blArray) {
        if (!Arrays.equals(this.supportedServices, blArray)) {
            this.supportedServices = blArray;
            return true;
        }
        return false;
    }

    static {
        SERVICE_STRING_MAPPING.put(new Integer(0), "ActiveUser");
        SERVICE_STRING_MAPPING.put(new Integer(1), "RegisterState");
        SERVICE_STRING_MAPPING.put(new Integer(2), "LockState");
        SERVICE_STRING_MAPPING.put(new Integer(3), "NetworkProvider");
        SERVICE_STRING_MAPPING.put(new Integer(4), "SignalQuality");
        SERVICE_STRING_MAPPING.put(new Integer(5), "CallState");
        SERVICE_STRING_MAPPING.put(new Integer(6), "CallInfo");
        SERVICE_STRING_MAPPING.put(new Integer(7), "CallDurationSync");
        SERVICE_STRING_MAPPING.put(new Integer(8), "DisconnectReason");
        SERVICE_STRING_MAPPING.put(new Integer(9), "DialNumber");
        SERVICE_STRING_MAPPING.put(new Integer(10), "DialService");
        SERVICE_STRING_MAPPING.put(new Integer(11), "ConfirmEmergencyCall");
        SERVICE_STRING_MAPPING.put(new Integer(12), "HangupCall");
        SERVICE_STRING_MAPPING.put(new Integer(13), "AcceptCall");
        SERVICE_STRING_MAPPING.put(new Integer(14), "CallHold");
        SERVICE_STRING_MAPPING.put(new Integer(15), "ResumeCall");
        SERVICE_STRING_MAPPING.put(new Integer(16), "HandsfreeOnOff");
        SERVICE_STRING_MAPPING.put(new Integer(17), "MicroMuteOnOff");
        SERVICE_STRING_MAPPING.put(new Integer(18), "MPReleaseActiveCallAcceptWaitingCall");
        SERVICE_STRING_MAPPING.put(new Integer(19), "MPSwap");
        SERVICE_STRING_MAPPING.put(new Integer(20), "MPCallHoldAcceptWaitingCall");
        SERVICE_STRING_MAPPING.put(new Integer(21), "MPReleaseAllCallsAcceptWaitingCall");
        SERVICE_STRING_MAPPING.put(new Integer(22), "MPSetWaitingCallOnHold");
        SERVICE_STRING_MAPPING.put(new Integer(23), "CCJoin");
        SERVICE_STRING_MAPPING.put(new Integer(24), "CCSplit");
        SERVICE_STRING_MAPPING.put(new Integer(25), "Keypad");
        SERVICE_STRING_MAPPING.put(new Integer(26), "MobileBatteryLevel");
        SERVICE_STRING_MAPPING.put(new Integer(28), "MissedCallIndication");
        SERVICE_STRING_MAPPING.put(new Integer(29), "MissedCalls");
        SERVICE_STRING_MAPPING.put(new Integer(30), "ReceivedCalls");
        SERVICE_STRING_MAPPING.put(new Integer(31), "DialedNumbers");
        SERVICE_STRING_MAPPING.put(new Integer(32), "CombinedNumbers");
        SERVICE_STRING_MAPPING.put(new Integer(33), "CallStackDeleteAll");
        SERVICE_STRING_MAPPING.put(new Integer(37), "GetNextListPos");
        SERVICE_STRING_MAPPING.put(new Integer(39), "RingToneMuteOnOff");
        SERVICE_STRING_MAPPING.put(new Integer(40), "AutomaticRedial");
        SERVICE_STRING_MAPPING.put(new Integer(41), "AutomaticRedialExtendedInfo");
    }
}

