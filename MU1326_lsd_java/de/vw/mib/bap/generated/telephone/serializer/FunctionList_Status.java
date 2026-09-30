/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FunctionList_Status
implements StatusProperty {
    public boolean reserved_bit_0;
    public boolean fctGetAllSupported;
    public boolean fctBapConfigSupported;
    public boolean fctFunctionListSupported;
    public boolean fctHeartbeatSupported;
    private static final int RESERVED_BIT_5__13_BITSIZE = 9;
    public boolean fctFsg_SetupSupported;
    public boolean fctFsg_OperationStateSupported;
    public boolean fctMobileServiceSupportAvailable;
    public boolean fctActiveUserSupported;
    public boolean fctRegisterStateSupported;
    public boolean fctLockStateSupported;
    public boolean fctNetworkProviderSupported;
    public boolean fctSignalQualitySupported;
    public boolean fctCallStateSupported;
    public boolean fctCallInfoSupported;
    public boolean fctCallDurationSyncSupported;
    public boolean fctDisconnectReasonSupported;
    public boolean fctDialNumberSupported;
    public boolean fctDialServiceSupported;
    public boolean fctConfirmEmergencyCallSupported;
    public boolean fctHangupCallSupported;
    public boolean fctAcceptCallSupported;
    public boolean fctCallHoldSupported;
    public boolean fctResumeCallSupported;
    public boolean fctHandsFreeOnOffSupported;
    public boolean fctMicroMuteOnOffSupported;
    public boolean fctMpreleaseActiveCallAcceptWaitingCallSupported;
    public boolean fctMpswapSupported;
    public boolean fctMpcallHoldAcceptWaitingCallSupported;
    public boolean fctMpreleaseAllCallsAcceptWaitingCallSupported;
    public boolean fctMpsetWaitingCallOnHoldSupported;
    public boolean fctCcjoinSupported;
    public boolean fctCcsplitSupported;
    public boolean fctKeypadSupported;
    public boolean fctMobileBatteryLevelSupported;
    public boolean fctDataConnectionIndicationSupported;
    public boolean fctMissedCallIndicationSupported;
    public boolean fctMissedCallsSupported;
    public boolean fctReceivedCallsSupported;
    public boolean fctDialedNumbersSupported;
    public boolean fctCombinedNumbersSupported;
    public boolean fctCallStackDeleteAllSupported;
    public boolean fctPbStateSupported;
    public boolean fctPhonebookSupported;
    public boolean fctPbSpellerSupported;
    public boolean fctGetNextListPosSupported;
    public boolean fctSmsstateSupported;
    public boolean fctRingToneMuteOnOffSupported;
    public boolean fctAutomaticRedialSupported;
    public boolean fctAutomaticRedialExtendedInfoSupported;
    public boolean fctSupportedServiceNumbersSupported;
    public boolean fctFavoriteListSupported;
    private static final int RESERVED_BIT_61__63_BITSIZE = 3;
    private static final int FUNCTION_LIST_STATUS_BITSIZE = 64;

    public FunctionList_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FunctionList_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.reserved_bit_0 = false;
        this.fctGetAllSupported = false;
        this.fctBapConfigSupported = false;
        this.fctFunctionListSupported = false;
        this.fctHeartbeatSupported = false;
        this.fctFsg_SetupSupported = false;
        this.fctFsg_OperationStateSupported = false;
        this.fctMobileServiceSupportAvailable = false;
        this.fctActiveUserSupported = false;
        this.fctRegisterStateSupported = false;
        this.fctLockStateSupported = false;
        this.fctNetworkProviderSupported = false;
        this.fctSignalQualitySupported = false;
        this.fctCallStateSupported = false;
        this.fctCallInfoSupported = false;
        this.fctCallDurationSyncSupported = false;
        this.fctDisconnectReasonSupported = false;
        this.fctDialNumberSupported = false;
        this.fctDialServiceSupported = false;
        this.fctConfirmEmergencyCallSupported = false;
        this.fctHangupCallSupported = false;
        this.fctAcceptCallSupported = false;
        this.fctCallHoldSupported = false;
        this.fctResumeCallSupported = false;
        this.fctHandsFreeOnOffSupported = false;
        this.fctMicroMuteOnOffSupported = false;
        this.fctMpreleaseActiveCallAcceptWaitingCallSupported = false;
        this.fctMpswapSupported = false;
        this.fctMpcallHoldAcceptWaitingCallSupported = false;
        this.fctMpreleaseAllCallsAcceptWaitingCallSupported = false;
        this.fctMpsetWaitingCallOnHoldSupported = false;
        this.fctCcjoinSupported = false;
        this.fctCcsplitSupported = false;
        this.fctKeypadSupported = false;
        this.fctMobileBatteryLevelSupported = false;
        this.fctDataConnectionIndicationSupported = false;
        this.fctMissedCallIndicationSupported = false;
        this.fctMissedCallsSupported = false;
        this.fctReceivedCallsSupported = false;
        this.fctDialedNumbersSupported = false;
        this.fctCombinedNumbersSupported = false;
        this.fctCallStackDeleteAllSupported = false;
        this.fctPbStateSupported = false;
        this.fctPhonebookSupported = false;
        this.fctPbSpellerSupported = false;
        this.fctGetNextListPosSupported = false;
        this.fctSmsstateSupported = false;
        this.fctRingToneMuteOnOffSupported = false;
        this.fctAutomaticRedialSupported = false;
        this.fctAutomaticRedialExtendedInfoSupported = false;
        this.fctSupportedServiceNumbersSupported = false;
        this.fctFavoriteListSupported = false;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FunctionList_Status functionList_Status = (FunctionList_Status)bAPEntity;
        return this.reserved_bit_0 == functionList_Status.reserved_bit_0 && this.fctGetAllSupported == functionList_Status.fctGetAllSupported && this.fctBapConfigSupported == functionList_Status.fctBapConfigSupported && this.fctFunctionListSupported == functionList_Status.fctFunctionListSupported && this.fctHeartbeatSupported == functionList_Status.fctHeartbeatSupported && this.fctFsg_SetupSupported == functionList_Status.fctFsg_SetupSupported && this.fctFsg_OperationStateSupported == functionList_Status.fctFsg_OperationStateSupported && this.fctMobileServiceSupportAvailable == functionList_Status.fctMobileServiceSupportAvailable && this.fctActiveUserSupported == functionList_Status.fctActiveUserSupported && this.fctRegisterStateSupported == functionList_Status.fctRegisterStateSupported && this.fctLockStateSupported == functionList_Status.fctLockStateSupported && this.fctNetworkProviderSupported == functionList_Status.fctNetworkProviderSupported && this.fctSignalQualitySupported == functionList_Status.fctSignalQualitySupported && this.fctCallStateSupported == functionList_Status.fctCallStateSupported && this.fctCallInfoSupported == functionList_Status.fctCallInfoSupported && this.fctCallDurationSyncSupported == functionList_Status.fctCallDurationSyncSupported && this.fctDisconnectReasonSupported == functionList_Status.fctDisconnectReasonSupported && this.fctDialNumberSupported == functionList_Status.fctDialNumberSupported && this.fctDialServiceSupported == functionList_Status.fctDialServiceSupported && this.fctConfirmEmergencyCallSupported == functionList_Status.fctConfirmEmergencyCallSupported && this.fctHangupCallSupported == functionList_Status.fctHangupCallSupported && this.fctAcceptCallSupported == functionList_Status.fctAcceptCallSupported && this.fctCallHoldSupported == functionList_Status.fctCallHoldSupported && this.fctResumeCallSupported == functionList_Status.fctResumeCallSupported && this.fctHandsFreeOnOffSupported == functionList_Status.fctHandsFreeOnOffSupported && this.fctMicroMuteOnOffSupported == functionList_Status.fctMicroMuteOnOffSupported && this.fctMpreleaseActiveCallAcceptWaitingCallSupported == functionList_Status.fctMpreleaseActiveCallAcceptWaitingCallSupported && this.fctMpswapSupported == functionList_Status.fctMpswapSupported && this.fctMpcallHoldAcceptWaitingCallSupported == functionList_Status.fctMpcallHoldAcceptWaitingCallSupported && this.fctMpreleaseAllCallsAcceptWaitingCallSupported == functionList_Status.fctMpreleaseAllCallsAcceptWaitingCallSupported && this.fctMpsetWaitingCallOnHoldSupported == functionList_Status.fctMpsetWaitingCallOnHoldSupported && this.fctCcjoinSupported == functionList_Status.fctCcjoinSupported && this.fctCcsplitSupported == functionList_Status.fctCcsplitSupported && this.fctKeypadSupported == functionList_Status.fctKeypadSupported && this.fctMobileBatteryLevelSupported == functionList_Status.fctMobileBatteryLevelSupported && this.fctDataConnectionIndicationSupported == functionList_Status.fctDataConnectionIndicationSupported && this.fctMissedCallIndicationSupported == functionList_Status.fctMissedCallIndicationSupported && this.fctMissedCallsSupported == functionList_Status.fctMissedCallsSupported && this.fctReceivedCallsSupported == functionList_Status.fctReceivedCallsSupported && this.fctDialedNumbersSupported == functionList_Status.fctDialedNumbersSupported && this.fctCombinedNumbersSupported == functionList_Status.fctCombinedNumbersSupported && this.fctCallStackDeleteAllSupported == functionList_Status.fctCallStackDeleteAllSupported && this.fctPbStateSupported == functionList_Status.fctPbStateSupported && this.fctPhonebookSupported == functionList_Status.fctPhonebookSupported && this.fctPbSpellerSupported == functionList_Status.fctPbSpellerSupported && this.fctGetNextListPosSupported == functionList_Status.fctGetNextListPosSupported && this.fctSmsstateSupported == functionList_Status.fctSmsstateSupported && this.fctRingToneMuteOnOffSupported == functionList_Status.fctRingToneMuteOnOffSupported && this.fctAutomaticRedialSupported == functionList_Status.fctAutomaticRedialSupported && this.fctAutomaticRedialExtendedInfoSupported == functionList_Status.fctAutomaticRedialExtendedInfoSupported && this.fctSupportedServiceNumbersSupported == functionList_Status.fctSupportedServiceNumbersSupported && this.fctFavoriteListSupported == functionList_Status.fctFavoriteListSupported;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FunctionList_Status:");
        stringBuffer.append("\n - Bit 0: ");
        if (this.reserved_bit_0) {
            stringBuffer.append("true  (reserved");
        } else {
            stringBuffer.append("false  (reserved");
        }
        stringBuffer.append("\n - Bit 1: ");
        if (this.fctGetAllSupported) {
            stringBuffer.append("true  (Fct \"GetAll\" supported");
        } else {
            stringBuffer.append("false  (Fct \"GetAll\" not supported");
        }
        stringBuffer.append("\n - Bit 2: ");
        if (this.fctBapConfigSupported) {
            stringBuffer.append("true  (Fct \"BAP-Config\" supported");
        } else {
            stringBuffer.append("false  (Fct \"BAP-Config\" not supported");
        }
        stringBuffer.append("\n - Bit 3: ");
        if (this.fctFunctionListSupported) {
            stringBuffer.append("true  (Fct \"FunctionList\" supported");
        } else {
            stringBuffer.append("false  (Fct \"FunctionList\" not supported");
        }
        stringBuffer.append("\n - Bit 4: ");
        if (this.fctHeartbeatSupported) {
            stringBuffer.append("true  (Fct \"Heartbeat\" supported");
        } else {
            stringBuffer.append("false  (Fct \"Heartbeat\" not supported");
        }
        stringBuffer.append("\n - Bit 14: ");
        if (this.fctFsg_SetupSupported) {
            stringBuffer.append("true  (Fct \"FSG_Setup\" supported");
        } else {
            stringBuffer.append("false  (Fct \"FSG_Setup\" not supported");
        }
        stringBuffer.append("\n - Bit 15: ");
        if (this.fctFsg_OperationStateSupported) {
            stringBuffer.append("true  (Fct \"FSG_OperationState\" supported");
        } else {
            stringBuffer.append("false  (Fct \"FSG_OperationState\" not supported");
        }
        stringBuffer.append("\n - Bit 16: ");
        if (this.fctMobileServiceSupportAvailable) {
            stringBuffer.append("true  (Fct \"MobileServiceSupport\" available");
        } else {
            stringBuffer.append("false  (Fct \"MobileServiceSupport\" not supported");
        }
        stringBuffer.append("\n - Bit 17: ");
        if (this.fctActiveUserSupported) {
            stringBuffer.append("true  (Fct \"ActiveUser\" supported");
        } else {
            stringBuffer.append("false  (Fct \"ActiveUser\" not supported");
        }
        stringBuffer.append("\n - Bit 18: ");
        if (this.fctRegisterStateSupported) {
            stringBuffer.append("true  (Fct \"RegisterState\" supported");
        } else {
            stringBuffer.append("false  (Fct \"RegisterState\" not supported");
        }
        stringBuffer.append("\n - Bit 19: ");
        if (this.fctLockStateSupported) {
            stringBuffer.append("true  (Fct \"LockState\" supported");
        } else {
            stringBuffer.append("false  (Fct \"LockState\" not supported");
        }
        stringBuffer.append("\n - Bit 20: ");
        if (this.fctNetworkProviderSupported) {
            stringBuffer.append("true  (Fct \"NetworkProvider\" supported");
        } else {
            stringBuffer.append("false  (Fct \"NetworkProvider\" not supported");
        }
        stringBuffer.append("\n - Bit 21: ");
        if (this.fctSignalQualitySupported) {
            stringBuffer.append("true  (Fct \"SignalQuality\" supported");
        } else {
            stringBuffer.append("false  (Fct \"SignalQuality\" not supported");
        }
        stringBuffer.append("\n - Bit 22: ");
        if (this.fctCallStateSupported) {
            stringBuffer.append("true  (Fct \"CallState\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CallState\" not supported");
        }
        stringBuffer.append("\n - Bit 23: ");
        if (this.fctCallInfoSupported) {
            stringBuffer.append("true  (Fct \"CallInfo\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CallInfo\" not supported");
        }
        stringBuffer.append("\n - Bit 24: ");
        if (this.fctCallDurationSyncSupported) {
            stringBuffer.append("true  (Fct \"CallDurationSync\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CallDurationSync\" not supported");
        }
        stringBuffer.append("\n - Bit 25: ");
        if (this.fctDisconnectReasonSupported) {
            stringBuffer.append("true  (Fct \"DisconnectReason\" supported");
        } else {
            stringBuffer.append("false  (Fct \"DisconnectReason\" not supported");
        }
        stringBuffer.append("\n - Bit 26: ");
        if (this.fctDialNumberSupported) {
            stringBuffer.append("true  (Fct \"DialNumber\" supported");
        } else {
            stringBuffer.append("false  (Fct \"DialNumber\" not supported");
        }
        stringBuffer.append("\n - Bit 27: ");
        if (this.fctDialServiceSupported) {
            stringBuffer.append("true  (Fct \"DialService\" supported");
        } else {
            stringBuffer.append("false  (Fct \"DialService\" not supported");
        }
        stringBuffer.append("\n - Bit 28: ");
        if (this.fctConfirmEmergencyCallSupported) {
            stringBuffer.append("true  (Fct \"ConfirmEmergencyCall\" supported");
        } else {
            stringBuffer.append("false  (Fct \"ConfirmEmergencyCall\" not supported");
        }
        stringBuffer.append("\n - Bit 29: ");
        if (this.fctHangupCallSupported) {
            stringBuffer.append("true  (Fct \"HangupCall\" supported");
        } else {
            stringBuffer.append("false  (Fct \"HangupCall\" not supported");
        }
        stringBuffer.append("\n - Bit 30: ");
        if (this.fctAcceptCallSupported) {
            stringBuffer.append("true  (Fct \"AcceptCall\" supported");
        } else {
            stringBuffer.append("false  (Fct \"AcceptCall\" not supported");
        }
        stringBuffer.append("\n - Bit 31: ");
        if (this.fctCallHoldSupported) {
            stringBuffer.append("true  (Fct \"CallHold\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CallHold\" not supported");
        }
        stringBuffer.append("\n - Bit 32: ");
        if (this.fctResumeCallSupported) {
            stringBuffer.append("true  (Fct \"ResumeCall\" supported");
        } else {
            stringBuffer.append("false  (Fct \"ResumeCall\" not supported");
        }
        stringBuffer.append("\n - Bit 33: ");
        if (this.fctHandsFreeOnOffSupported) {
            stringBuffer.append("true  (Fct \"HandsFreeOnOff\" supported");
        } else {
            stringBuffer.append("false  (Fct \"HandsFreeOnOff\" not supported");
        }
        stringBuffer.append("\n - Bit 34: ");
        if (this.fctMicroMuteOnOffSupported) {
            stringBuffer.append("true  (Fct \"MicroMuteOnOff\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MicroMuteOnOff\" not supported");
        }
        stringBuffer.append("\n - Bit 35: ");
        if (this.fctMpreleaseActiveCallAcceptWaitingCallSupported) {
            stringBuffer.append("true  (Fct \"MPReleaseActiveCallAcceptWaitingCall\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MPReleaseActiveCallAcceptWaitingCall\" not supported");
        }
        stringBuffer.append("\n - Bit 36: ");
        if (this.fctMpswapSupported) {
            stringBuffer.append("true  (Fct \"MPSwap\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MPSwap\" not supported");
        }
        stringBuffer.append("\n - Bit 37: ");
        if (this.fctMpcallHoldAcceptWaitingCallSupported) {
            stringBuffer.append("true  (Fct \"MPCallHoldAcceptWaitingCall\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MPCallHoldAcceptWaitingCall\" not supported");
        }
        stringBuffer.append("\n - Bit 38: ");
        if (this.fctMpreleaseAllCallsAcceptWaitingCallSupported) {
            stringBuffer.append("true  (Fct \"MPReleaseAllCallsAcceptWaitingCall\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MPReleaseAllCallsAcceptWaitingCall\" not supported");
        }
        stringBuffer.append("\n - Bit 39: ");
        if (this.fctMpsetWaitingCallOnHoldSupported) {
            stringBuffer.append("true  (Fct \"MPSetWaitingCallOnHold\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MPSetWaitingCallOnHold\" not supported");
        }
        stringBuffer.append("\n - Bit 40: ");
        if (this.fctCcjoinSupported) {
            stringBuffer.append("true  (Fct \"CCJoin\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CCJoin\" not supported");
        }
        stringBuffer.append("\n - Bit 41: ");
        if (this.fctCcsplitSupported) {
            stringBuffer.append("true  (Fct \"CCSplit\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CCSplit\" not supported");
        }
        stringBuffer.append("\n - Bit 42: ");
        if (this.fctKeypadSupported) {
            stringBuffer.append("true  (Fct \"Keypad\" supported");
        } else {
            stringBuffer.append("false  (Fct \"Keypad\" not supported");
        }
        stringBuffer.append("\n - Bit 43: ");
        if (this.fctMobileBatteryLevelSupported) {
            stringBuffer.append("true  (Fct \"MobileBatteryLevel\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MobileBatteryLevel\" not supported");
        }
        stringBuffer.append("\n - Bit 44: ");
        if (this.fctDataConnectionIndicationSupported) {
            stringBuffer.append("true  (Fct \"DataConnectionIndication\" supported");
        } else {
            stringBuffer.append("false  (Fct \"DataConnectionIndication\" not supported");
        }
        stringBuffer.append("\n - Bit 45: ");
        if (this.fctMissedCallIndicationSupported) {
            stringBuffer.append("true  (Fct \"MissedCallIndication\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MissedCallIndication\" not supported");
        }
        stringBuffer.append("\n - Bit 46: ");
        if (this.fctMissedCallsSupported) {
            stringBuffer.append("true  (Fct \"MissedCalls\" supported");
        } else {
            stringBuffer.append("false  (Fct \"MissedCalls\" not supported");
        }
        stringBuffer.append("\n - Bit 47: ");
        if (this.fctReceivedCallsSupported) {
            stringBuffer.append("true  (Fct \"ReceivedCalls\" supported");
        } else {
            stringBuffer.append("false  (Fct \"ReceivedCalls\" not supported");
        }
        stringBuffer.append("\n - Bit 48: ");
        if (this.fctDialedNumbersSupported) {
            stringBuffer.append("true  (Fct \"DialedNumbers\" supported");
        } else {
            stringBuffer.append("false  (Fct \"DialedNumbers\" not supported");
        }
        stringBuffer.append("\n - Bit 49: ");
        if (this.fctCombinedNumbersSupported) {
            stringBuffer.append("true  (Fct \"CombinedNumbers\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CombinedNumbers\" not supported");
        }
        stringBuffer.append("\n - Bit 50: ");
        if (this.fctCallStackDeleteAllSupported) {
            stringBuffer.append("true  (Fct \"CallStackDeleteAll\" supported");
        } else {
            stringBuffer.append("false  (Fct \"CallStackDeleteAll\" not supported");
        }
        stringBuffer.append("\n - Bit 51: ");
        if (this.fctPbStateSupported) {
            stringBuffer.append("true  (Fct \"PbState\" supported");
        } else {
            stringBuffer.append("false  (Fct \"PbState\" not supported");
        }
        stringBuffer.append("\n - Bit 52: ");
        if (this.fctPhonebookSupported) {
            stringBuffer.append("true  (Fct \"Phonebook\" supported");
        } else {
            stringBuffer.append("false  (Fct \"Phonebook\" not supported");
        }
        stringBuffer.append("\n - Bit 53: ");
        if (this.fctPbSpellerSupported) {
            stringBuffer.append("true  (Fct \"PbSpeller\" supported");
        } else {
            stringBuffer.append("false  (Fct \"PbSpeller\" not supported");
        }
        stringBuffer.append("\n - Bit 54: ");
        if (this.fctGetNextListPosSupported) {
            stringBuffer.append("true  (Fct \"GetNextListPos\" supported");
        } else {
            stringBuffer.append("false  (Fct \"GetNextListPos\" not supported");
        }
        stringBuffer.append("\n - Bit 55: ");
        if (this.fctSmsstateSupported) {
            stringBuffer.append("true  (Fct \"SMSState\" supported");
        } else {
            stringBuffer.append("false  (Fct \"SMSState\" not supported");
        }
        stringBuffer.append("\n - Bit 56: ");
        if (this.fctRingToneMuteOnOffSupported) {
            stringBuffer.append("true  (Fct \"RingToneMuteOnOff\" supported");
        } else {
            stringBuffer.append("false  (Fct \"RingToneMuteOnOff\" not supported");
        }
        stringBuffer.append("\n - Bit 57: ");
        if (this.fctAutomaticRedialSupported) {
            stringBuffer.append("true  (Fct \"AutomaticRedial\" supported");
        } else {
            stringBuffer.append("false  (Fct \"AutomaticRedial\" not supported");
        }
        stringBuffer.append("\n - Bit 58: ");
        if (this.fctAutomaticRedialExtendedInfoSupported) {
            stringBuffer.append("true  (Fct \"AutomaticRedialExtendedInfo\" supported");
        } else {
            stringBuffer.append("false  (Fct \"AutomaticRedialExtendedInfo\" not supported");
        }
        stringBuffer.append("\n - Bit 59: ");
        if (this.fctSupportedServiceNumbersSupported) {
            stringBuffer.append("true  (Fct \"SupportedServiceNumbers\" supported");
        } else {
            stringBuffer.append("false  (Fct \"SupportedServiceNumbers\" not supported");
        }
        stringBuffer.append("\n - Bit 60: ");
        if (this.fctFavoriteListSupported) {
            stringBuffer.append("true  (Fct \"FavoriteList\" supported");
        } else {
            stringBuffer.append("false  (Fct \"FavoriteList\" not supported");
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 64;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushBoolean(this.reserved_bit_0);
        bitStream.pushBoolean(this.fctGetAllSupported);
        bitStream.pushBoolean(this.fctBapConfigSupported);
        bitStream.pushBoolean(this.fctFunctionListSupported);
        bitStream.pushBoolean(this.fctHeartbeatSupported);
        bitStream.resetBits(9);
        bitStream.pushBoolean(this.fctFsg_SetupSupported);
        bitStream.pushBoolean(this.fctFsg_OperationStateSupported);
        bitStream.pushBoolean(this.fctMobileServiceSupportAvailable);
        bitStream.pushBoolean(this.fctActiveUserSupported);
        bitStream.pushBoolean(this.fctRegisterStateSupported);
        bitStream.pushBoolean(this.fctLockStateSupported);
        bitStream.pushBoolean(this.fctNetworkProviderSupported);
        bitStream.pushBoolean(this.fctSignalQualitySupported);
        bitStream.pushBoolean(this.fctCallStateSupported);
        bitStream.pushBoolean(this.fctCallInfoSupported);
        bitStream.pushBoolean(this.fctCallDurationSyncSupported);
        bitStream.pushBoolean(this.fctDisconnectReasonSupported);
        bitStream.pushBoolean(this.fctDialNumberSupported);
        bitStream.pushBoolean(this.fctDialServiceSupported);
        bitStream.pushBoolean(this.fctConfirmEmergencyCallSupported);
        bitStream.pushBoolean(this.fctHangupCallSupported);
        bitStream.pushBoolean(this.fctAcceptCallSupported);
        bitStream.pushBoolean(this.fctCallHoldSupported);
        bitStream.pushBoolean(this.fctResumeCallSupported);
        bitStream.pushBoolean(this.fctHandsFreeOnOffSupported);
        bitStream.pushBoolean(this.fctMicroMuteOnOffSupported);
        bitStream.pushBoolean(this.fctMpreleaseActiveCallAcceptWaitingCallSupported);
        bitStream.pushBoolean(this.fctMpswapSupported);
        bitStream.pushBoolean(this.fctMpcallHoldAcceptWaitingCallSupported);
        bitStream.pushBoolean(this.fctMpreleaseAllCallsAcceptWaitingCallSupported);
        bitStream.pushBoolean(this.fctMpsetWaitingCallOnHoldSupported);
        bitStream.pushBoolean(this.fctCcjoinSupported);
        bitStream.pushBoolean(this.fctCcsplitSupported);
        bitStream.pushBoolean(this.fctKeypadSupported);
        bitStream.pushBoolean(this.fctMobileBatteryLevelSupported);
        bitStream.pushBoolean(this.fctDataConnectionIndicationSupported);
        bitStream.pushBoolean(this.fctMissedCallIndicationSupported);
        bitStream.pushBoolean(this.fctMissedCallsSupported);
        bitStream.pushBoolean(this.fctReceivedCallsSupported);
        bitStream.pushBoolean(this.fctDialedNumbersSupported);
        bitStream.pushBoolean(this.fctCombinedNumbersSupported);
        bitStream.pushBoolean(this.fctCallStackDeleteAllSupported);
        bitStream.pushBoolean(this.fctPbStateSupported);
        bitStream.pushBoolean(this.fctPhonebookSupported);
        bitStream.pushBoolean(this.fctPbSpellerSupported);
        bitStream.pushBoolean(this.fctGetNextListPosSupported);
        bitStream.pushBoolean(this.fctSmsstateSupported);
        bitStream.pushBoolean(this.fctRingToneMuteOnOffSupported);
        bitStream.pushBoolean(this.fctAutomaticRedialSupported);
        bitStream.pushBoolean(this.fctAutomaticRedialExtendedInfoSupported);
        bitStream.pushBoolean(this.fctSupportedServiceNumbersSupported);
        bitStream.pushBoolean(this.fctFavoriteListSupported);
        bitStream.resetBits(3);
    }

    public void deserialize(BitStream bitStream) {
        this.reserved_bit_0 = bitStream.popFrontBoolean();
        this.fctGetAllSupported = bitStream.popFrontBoolean();
        this.fctBapConfigSupported = bitStream.popFrontBoolean();
        this.fctFunctionListSupported = bitStream.popFrontBoolean();
        this.fctHeartbeatSupported = bitStream.popFrontBoolean();
        bitStream.discardBits(9);
        this.fctFsg_SetupSupported = bitStream.popFrontBoolean();
        this.fctFsg_OperationStateSupported = bitStream.popFrontBoolean();
        this.fctMobileServiceSupportAvailable = bitStream.popFrontBoolean();
        this.fctActiveUserSupported = bitStream.popFrontBoolean();
        this.fctRegisterStateSupported = bitStream.popFrontBoolean();
        this.fctLockStateSupported = bitStream.popFrontBoolean();
        this.fctNetworkProviderSupported = bitStream.popFrontBoolean();
        this.fctSignalQualitySupported = bitStream.popFrontBoolean();
        this.fctCallStateSupported = bitStream.popFrontBoolean();
        this.fctCallInfoSupported = bitStream.popFrontBoolean();
        this.fctCallDurationSyncSupported = bitStream.popFrontBoolean();
        this.fctDisconnectReasonSupported = bitStream.popFrontBoolean();
        this.fctDialNumberSupported = bitStream.popFrontBoolean();
        this.fctDialServiceSupported = bitStream.popFrontBoolean();
        this.fctConfirmEmergencyCallSupported = bitStream.popFrontBoolean();
        this.fctHangupCallSupported = bitStream.popFrontBoolean();
        this.fctAcceptCallSupported = bitStream.popFrontBoolean();
        this.fctCallHoldSupported = bitStream.popFrontBoolean();
        this.fctResumeCallSupported = bitStream.popFrontBoolean();
        this.fctHandsFreeOnOffSupported = bitStream.popFrontBoolean();
        this.fctMicroMuteOnOffSupported = bitStream.popFrontBoolean();
        this.fctMpreleaseActiveCallAcceptWaitingCallSupported = bitStream.popFrontBoolean();
        this.fctMpswapSupported = bitStream.popFrontBoolean();
        this.fctMpcallHoldAcceptWaitingCallSupported = bitStream.popFrontBoolean();
        this.fctMpreleaseAllCallsAcceptWaitingCallSupported = bitStream.popFrontBoolean();
        this.fctMpsetWaitingCallOnHoldSupported = bitStream.popFrontBoolean();
        this.fctCcjoinSupported = bitStream.popFrontBoolean();
        this.fctCcsplitSupported = bitStream.popFrontBoolean();
        this.fctKeypadSupported = bitStream.popFrontBoolean();
        this.fctMobileBatteryLevelSupported = bitStream.popFrontBoolean();
        this.fctDataConnectionIndicationSupported = bitStream.popFrontBoolean();
        this.fctMissedCallIndicationSupported = bitStream.popFrontBoolean();
        this.fctMissedCallsSupported = bitStream.popFrontBoolean();
        this.fctReceivedCallsSupported = bitStream.popFrontBoolean();
        this.fctDialedNumbersSupported = bitStream.popFrontBoolean();
        this.fctCombinedNumbersSupported = bitStream.popFrontBoolean();
        this.fctCallStackDeleteAllSupported = bitStream.popFrontBoolean();
        this.fctPbStateSupported = bitStream.popFrontBoolean();
        this.fctPhonebookSupported = bitStream.popFrontBoolean();
        this.fctPbSpellerSupported = bitStream.popFrontBoolean();
        this.fctGetNextListPosSupported = bitStream.popFrontBoolean();
        this.fctSmsstateSupported = bitStream.popFrontBoolean();
        this.fctRingToneMuteOnOffSupported = bitStream.popFrontBoolean();
        this.fctAutomaticRedialSupported = bitStream.popFrontBoolean();
        this.fctAutomaticRedialExtendedInfoSupported = bitStream.popFrontBoolean();
        this.fctSupportedServiceNumbersSupported = bitStream.popFrontBoolean();
        this.fctFavoriteListSupported = bitStream.popFrontBoolean();
        bitStream.discardBits(3);
    }

    public static int functionId() {
        return 3;
    }

    public int getFunctionId() {
        return FunctionList_Status.functionId();
    }
}

