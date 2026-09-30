/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class MobileServiceSupport_Status
implements StatusProperty {
    public final FctList fctList = new FctList();

    public MobileServiceSupport_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public MobileServiceSupport_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
    }

    public void reset() {
        this.internalReset();
        this.fctList.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        MobileServiceSupport_Status mobileServiceSupport_Status = (MobileServiceSupport_Status)bAPEntity;
        return this.fctList.equalTo(mobileServiceSupport_Status.fctList);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("MobileServiceSupport_Status:");
        stringBuffer.append("\n - FctList - ");
        stringBuffer.append(this.fctList.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += this.fctList.bitSize();
    }

    public void serialize(BitStream bitStream) {
        this.fctList.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.fctList.deserialize(bitStream);
    }

    public static int functionId() {
        return 16;
    }

    public int getFunctionId() {
        return MobileServiceSupport_Status.functionId();
    }

    public static final class FctList
    implements BAPEntity {
        private static final int RESERVED_BIT_0__15_BITSIZE = 16;
        public boolean reserved_bit_16;
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
        private static final int FCT_LIST_BITSIZE = 64;

        public FctList() {
            this.internalReset();
            this.customInitialization();
        }

        public FctList(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_16 = false;
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
            FctList fctList = (FctList)bAPEntity;
            return this.reserved_bit_16 == fctList.reserved_bit_16 && this.fctActiveUserSupported == fctList.fctActiveUserSupported && this.fctRegisterStateSupported == fctList.fctRegisterStateSupported && this.fctLockStateSupported == fctList.fctLockStateSupported && this.fctNetworkProviderSupported == fctList.fctNetworkProviderSupported && this.fctSignalQualitySupported == fctList.fctSignalQualitySupported && this.fctCallStateSupported == fctList.fctCallStateSupported && this.fctCallInfoSupported == fctList.fctCallInfoSupported && this.fctCallDurationSyncSupported == fctList.fctCallDurationSyncSupported && this.fctDisconnectReasonSupported == fctList.fctDisconnectReasonSupported && this.fctDialNumberSupported == fctList.fctDialNumberSupported && this.fctDialServiceSupported == fctList.fctDialServiceSupported && this.fctConfirmEmergencyCallSupported == fctList.fctConfirmEmergencyCallSupported && this.fctHangupCallSupported == fctList.fctHangupCallSupported && this.fctAcceptCallSupported == fctList.fctAcceptCallSupported && this.fctCallHoldSupported == fctList.fctCallHoldSupported && this.fctResumeCallSupported == fctList.fctResumeCallSupported && this.fctHandsFreeOnOffSupported == fctList.fctHandsFreeOnOffSupported && this.fctMicroMuteOnOffSupported == fctList.fctMicroMuteOnOffSupported && this.fctMpreleaseActiveCallAcceptWaitingCallSupported == fctList.fctMpreleaseActiveCallAcceptWaitingCallSupported && this.fctMpswapSupported == fctList.fctMpswapSupported && this.fctMpcallHoldAcceptWaitingCallSupported == fctList.fctMpcallHoldAcceptWaitingCallSupported && this.fctMpreleaseAllCallsAcceptWaitingCallSupported == fctList.fctMpreleaseAllCallsAcceptWaitingCallSupported && this.fctMpsetWaitingCallOnHoldSupported == fctList.fctMpsetWaitingCallOnHoldSupported && this.fctCcjoinSupported == fctList.fctCcjoinSupported && this.fctCcsplitSupported == fctList.fctCcsplitSupported && this.fctKeypadSupported == fctList.fctKeypadSupported && this.fctMobileBatteryLevelSupported == fctList.fctMobileBatteryLevelSupported && this.fctDataConnectionIndicationSupported == fctList.fctDataConnectionIndicationSupported && this.fctMissedCallIndicationSupported == fctList.fctMissedCallIndicationSupported && this.fctMissedCallsSupported == fctList.fctMissedCallsSupported && this.fctReceivedCallsSupported == fctList.fctReceivedCallsSupported && this.fctDialedNumbersSupported == fctList.fctDialedNumbersSupported && this.fctCombinedNumbersSupported == fctList.fctCombinedNumbersSupported && this.fctCallStackDeleteAllSupported == fctList.fctCallStackDeleteAllSupported && this.fctPbStateSupported == fctList.fctPbStateSupported && this.fctPhonebookSupported == fctList.fctPhonebookSupported && this.fctPbSpellerSupported == fctList.fctPbSpellerSupported && this.fctGetNextListPosSupported == fctList.fctGetNextListPosSupported && this.fctSmsstateSupported == fctList.fctSmsstateSupported && this.fctRingToneMuteOnOffSupported == fctList.fctRingToneMuteOnOffSupported && this.fctAutomaticRedialSupported == fctList.fctAutomaticRedialSupported && this.fctAutomaticRedialExtendedInfoSupported == fctList.fctAutomaticRedialExtendedInfoSupported && this.fctSupportedServiceNumbersSupported == fctList.fctSupportedServiceNumbersSupported && this.fctFavoriteListSupported == fctList.fctFavoriteListSupported;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("FctList:");
            stringBuffer.append("\n - Bit 16: ");
            if (this.reserved_bit_16) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
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
            bitStream.resetBits(16);
            bitStream.pushBoolean(this.reserved_bit_16);
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
            bitStream.discardBits(16);
            this.reserved_bit_16 = bitStream.popFrontBoolean();
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
    }
}

