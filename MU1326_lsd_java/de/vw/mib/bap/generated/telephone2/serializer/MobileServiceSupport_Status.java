/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

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
        public boolean reserved_bit_0;
        public boolean fctGetAllSupported;
        public boolean fctBapConfigSupported;
        public boolean fctFunctionListSupported;
        public boolean fctHeartbeatSupported;
        private static final int RESERVED_BIT_5__13_BITSIZE = 9;
        public boolean fctFsg_SetupSupported;
        public boolean fctFsg_OperationStateSupported;
        public boolean fctMobileServiceSupportSupported;
        public boolean fctRegisterState2Supported;
        public boolean fctLockState2Supported;
        public boolean fctNetworkProvider2Supported;
        public boolean fctSignalQuality2Supported;
        public boolean fctDataConnectionIndication2Supported;
        public boolean fctEmailStateSupported;
        public boolean fctPhoneModuleStateSupported;
        public boolean fctConnectionStateSupported;
        public boolean fctAutomaticCallForwardingSupported;
        public boolean fctPhonebookDownloadProcessSupported;
        private static final int RESERVED_BIT_27__63_BITSIZE = 37;
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
            this.reserved_bit_0 = false;
            this.fctGetAllSupported = false;
            this.fctBapConfigSupported = false;
            this.fctFunctionListSupported = false;
            this.fctHeartbeatSupported = false;
            this.fctFsg_SetupSupported = false;
            this.fctFsg_OperationStateSupported = false;
            this.fctMobileServiceSupportSupported = false;
            this.fctRegisterState2Supported = false;
            this.fctLockState2Supported = false;
            this.fctNetworkProvider2Supported = false;
            this.fctSignalQuality2Supported = false;
            this.fctDataConnectionIndication2Supported = false;
            this.fctEmailStateSupported = false;
            this.fctPhoneModuleStateSupported = false;
            this.fctConnectionStateSupported = false;
            this.fctAutomaticCallForwardingSupported = false;
            this.fctPhonebookDownloadProcessSupported = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            FctList fctList = (FctList)bAPEntity;
            return this.reserved_bit_0 == fctList.reserved_bit_0 && this.fctGetAllSupported == fctList.fctGetAllSupported && this.fctBapConfigSupported == fctList.fctBapConfigSupported && this.fctFunctionListSupported == fctList.fctFunctionListSupported && this.fctHeartbeatSupported == fctList.fctHeartbeatSupported && this.fctFsg_SetupSupported == fctList.fctFsg_SetupSupported && this.fctFsg_OperationStateSupported == fctList.fctFsg_OperationStateSupported && this.fctMobileServiceSupportSupported == fctList.fctMobileServiceSupportSupported && this.fctRegisterState2Supported == fctList.fctRegisterState2Supported && this.fctLockState2Supported == fctList.fctLockState2Supported && this.fctNetworkProvider2Supported == fctList.fctNetworkProvider2Supported && this.fctSignalQuality2Supported == fctList.fctSignalQuality2Supported && this.fctDataConnectionIndication2Supported == fctList.fctDataConnectionIndication2Supported && this.fctEmailStateSupported == fctList.fctEmailStateSupported && this.fctPhoneModuleStateSupported == fctList.fctPhoneModuleStateSupported && this.fctConnectionStateSupported == fctList.fctConnectionStateSupported && this.fctAutomaticCallForwardingSupported == fctList.fctAutomaticCallForwardingSupported && this.fctPhonebookDownloadProcessSupported == fctList.fctPhonebookDownloadProcessSupported;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("FctList:");
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
            if (this.fctMobileServiceSupportSupported) {
                stringBuffer.append("true  (Fct \"MobileServiceSupport\" supported");
            } else {
                stringBuffer.append("false  (Fct \"MobileServiceSupport\" not supported");
            }
            stringBuffer.append("\n - Bit 17: ");
            if (this.fctRegisterState2Supported) {
                stringBuffer.append("true  (Fct \"RegisterState2\" supported");
            } else {
                stringBuffer.append("false  (Fct \"RegisterState2\" not supported");
            }
            stringBuffer.append("\n - Bit 18: ");
            if (this.fctLockState2Supported) {
                stringBuffer.append("true  (Fct \"LockState2\" supported");
            } else {
                stringBuffer.append("false  (Fct \"LockState2\" not supported");
            }
            stringBuffer.append("\n - Bit 19: ");
            if (this.fctNetworkProvider2Supported) {
                stringBuffer.append("true  (Fct \"NetworkProvider2\" supported");
            } else {
                stringBuffer.append("false  (Fct \"NetworkProvider2\" not supported");
            }
            stringBuffer.append("\n - Bit 20: ");
            if (this.fctSignalQuality2Supported) {
                stringBuffer.append("true  (Fct \"SignalQuality2\" supported");
            } else {
                stringBuffer.append("false  (Fct \"SignalQuality2\" not supported");
            }
            stringBuffer.append("\n - Bit 21: ");
            if (this.fctDataConnectionIndication2Supported) {
                stringBuffer.append("true  (Fct \"DataConnectionIndication2\" supported");
            } else {
                stringBuffer.append("false  (Fct \"DataConnectionIndication2\" not supported");
            }
            stringBuffer.append("\n - Bit 22: ");
            if (this.fctEmailStateSupported) {
                stringBuffer.append("true  (Fct \"EmailState\" supported");
            } else {
                stringBuffer.append("false  (Fct \"EmailState\" not supported");
            }
            stringBuffer.append("\n - Bit 23: ");
            if (this.fctPhoneModuleStateSupported) {
                stringBuffer.append("true  (Fct \"PhoneModuleState\" supported");
            } else {
                stringBuffer.append("false  (Fct \"PhoneModuleState\" not supported");
            }
            stringBuffer.append("\n - Bit 24: ");
            if (this.fctConnectionStateSupported) {
                stringBuffer.append("true  (Fct \"ConnectionState\" supported");
            } else {
                stringBuffer.append("false  (Fct \"ConnectionState\" not supported");
            }
            stringBuffer.append("\n - Bit 25: ");
            if (this.fctAutomaticCallForwardingSupported) {
                stringBuffer.append("true  (Fct \"AutomaticCallForwarding\" supported");
            } else {
                stringBuffer.append("false  (Fct \"AutomaticCallForwarding\" not supported");
            }
            stringBuffer.append("\n - Bit 26: ");
            if (this.fctPhonebookDownloadProcessSupported) {
                stringBuffer.append("true  (Fct \"PhonebookDownloadProcess\" supported");
            } else {
                stringBuffer.append("false  (Fct \"PhonebookDownloadProcess\" not supported");
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
            bitStream.pushBoolean(this.fctMobileServiceSupportSupported);
            bitStream.pushBoolean(this.fctRegisterState2Supported);
            bitStream.pushBoolean(this.fctLockState2Supported);
            bitStream.pushBoolean(this.fctNetworkProvider2Supported);
            bitStream.pushBoolean(this.fctSignalQuality2Supported);
            bitStream.pushBoolean(this.fctDataConnectionIndication2Supported);
            bitStream.pushBoolean(this.fctEmailStateSupported);
            bitStream.pushBoolean(this.fctPhoneModuleStateSupported);
            bitStream.pushBoolean(this.fctConnectionStateSupported);
            bitStream.pushBoolean(this.fctAutomaticCallForwardingSupported);
            bitStream.pushBoolean(this.fctPhonebookDownloadProcessSupported);
            bitStream.resetBits(37);
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
            this.fctMobileServiceSupportSupported = bitStream.popFrontBoolean();
            this.fctRegisterState2Supported = bitStream.popFrontBoolean();
            this.fctLockState2Supported = bitStream.popFrontBoolean();
            this.fctNetworkProvider2Supported = bitStream.popFrontBoolean();
            this.fctSignalQuality2Supported = bitStream.popFrontBoolean();
            this.fctDataConnectionIndication2Supported = bitStream.popFrontBoolean();
            this.fctEmailStateSupported = bitStream.popFrontBoolean();
            this.fctPhoneModuleStateSupported = bitStream.popFrontBoolean();
            this.fctConnectionStateSupported = bitStream.popFrontBoolean();
            this.fctAutomaticCallForwardingSupported = bitStream.popFrontBoolean();
            this.fctPhonebookDownloadProcessSupported = bitStream.popFrontBoolean();
            bitStream.discardBits(37);
        }
    }
}

