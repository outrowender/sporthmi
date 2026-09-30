/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_OperationState_Status
implements StatusProperty {
    public int op_State;
    private static final int OP_STATE_BITSIZE = 8;
    public static final int OP_STATE_NORMAL_OPRATION = 0;
    public static final int OP_STATE_OFF_STAND_BY = 1;
    public static final int OP_STATE_INITIALIZING = 3;
    public static final int OP_STATE_DEFECT = 15;
    public int tel_State;
    private static final int TEL_STATE_BITSIZE = 8;
    public static final int TEL_STATE_PHONE_INITILISATION_DEFAULT_AFTER_POWER_ON_REBOOT = 0;
    public static final int TEL_STATE_PHONE_DEFECT = 1;
    public static final int TEL_STATE_PHONE_CONNECTING = 2;
    public static final int TEL_STATE_PHONE_DISCONNECTING = 3;
    public static final int TEL_STATE_PHONE_AUTOMATIC_RECONNECT = 4;
    public static final int TEL_STATE_PHONE_MODULE_OFF = 5;
    public static final int TEL_STATE_PHONE_MODULE_SWITCHING_ON = 6;
    public static final int TEL_STATE_PHONE_MODULE_ON = 7;
    public static final int TEL_STATE_PHONE_MODULE_SWITCHING_OFF = 8;
    public static final int TEL_STATE_PHONE_MODULE_OFF_HIGH_TEMP = 9;
    public static final int TEL_STATE_MOBILE_CONNECTING = 10;
    public static final int TEL_STATE_MOBILE_DISCONNECTING = 11;
    public static final int TEL_STATE_MOBILE_AUTOMATIC_RECONNECT = 12;
    public static final int TEL_STATE_MOBILE_OFF = 13;
    public static final int TEL_STATE_MOBILE_SWITCHING_ON = 14;
    public static final int TEL_STATE_MOBILE_ON = 15;
    public static final int TEL_STATE_MOBILE_SWITCHING_OFF = 16;
    public static final int TEL_STATE_MOBILE_OFF_NO_SWITCH_ON = 17;
    public static final int TEL_STATE_MOBILE_NOT_ATTACHED = 18;
    public static final int TEL_STATE_MOBILE_ATTACHED_NOT_READY = 19;
    public static final int TEL_STATE_MOBILE_ATTACHED_NOT_FUNCTIONAL = 20;
    public final PrivacyMode privacyMode = new PrivacyMode();

    public FSG_OperationState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public FSG_OperationState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.op_State = 0;
        this.tel_State = 0;
    }

    public void reset() {
        this.internalReset();
        this.privacyMode.reset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPEntity;
        return this.op_State == fSG_OperationState_Status.op_State && this.tel_State == fSG_OperationState_Status.tel_State && this.privacyMode.equalTo(fSG_OperationState_Status.privacyMode);
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("FSG_OperationState_Status:");
        stringBuffer.append("\n - OP_State: ");
        switch (this.op_State) {
            case 0: {
                stringBuffer.append("0x00 (normal opration)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (OFF / Stand-by)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (initializing)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (defect)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - Tel_State: ");
        switch (this.tel_State) {
            case 0: {
                stringBuffer.append("0x00 (PhoneInitilisation (default after power on / reboot))");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (PhoneDefect)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (PhoneConnecting)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (PhoneDisconnecting)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (PhoneAutomaticReconnect)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (PhoneModuleOff)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (PhoneModuleSwitchingOn)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (PhoneModuleOn)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (PhoneModuleSwitchingOff)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (PhoneModuleOffHighTemp (the phone is switched off due to high temperature detection))");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (MobileConnecting)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (MobileDisconnecting)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (MobileAutomaticReconnect)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (MobileOff)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (MobileSwitchingOn)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (MobileOn)");
                break;
            }
            case 16: {
                stringBuffer.append("0x10 (MobileSwitchingOff)");
                break;
            }
            case 17: {
                stringBuffer.append("0x11 (MobileOffNoSwitchOn (the phone is switched off, but is not able to be switched on by ASG))");
                break;
            }
            case 18: {
                stringBuffer.append("0x12 (MobileNotAttached (the cellular phone is not attached to the car))");
                break;
            }
            case 19: {
                stringBuffer.append("0x13 (MobileAttachedNotReady (mobile is attached, the power state of the phone is being checked))");
                break;
            }
            case 20: {
                stringBuffer.append("0x14 (MobileAttachedNotFunctional (the cellular phone is attached, but there is no stable communication with the phone and therefore the phone status is unknown))");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        stringBuffer.append("\n - PrivacyMode - ");
        stringBuffer.append(this.privacyMode.toString());
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        return n += this.privacyMode.bitSize();
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.op_State);
        bitStream.pushByte((byte)this.tel_State);
        this.privacyMode.serialize(bitStream);
    }

    public void deserialize(BitStream bitStream) {
        this.op_State = bitStream.popFrontByte();
        this.tel_State = bitStream.popFrontByte();
        this.privacyMode.deserialize(bitStream);
    }

    public static int functionId() {
        return 15;
    }

    public int getFunctionId() {
        return FSG_OperationState_Status.functionId();
    }

    public static final class PrivacyMode
    implements BAPEntity {
        public boolean reserved_bit_7;
        public boolean reserved_bit_6;
        public boolean reserved_bit_5;
        public boolean reserved_bit_4;
        public boolean reserved_bit_3;
        public boolean reserved_bit_2;
        public boolean enhancedPrivacyModeActive;
        public boolean privacyModeActive;
        private static final int PRIVACY_MODE_BITSIZE = 8;

        public PrivacyMode() {
            this.internalReset();
            this.customInitialization();
        }

        public PrivacyMode(BitStream bitStream) {
            this();
            this.deserialize(bitStream);
        }

        private void internalReset() {
            this.reserved_bit_7 = false;
            this.reserved_bit_6 = false;
            this.reserved_bit_5 = false;
            this.reserved_bit_4 = false;
            this.reserved_bit_3 = false;
            this.reserved_bit_2 = false;
            this.enhancedPrivacyModeActive = false;
            this.privacyModeActive = false;
        }

        public void reset() {
            this.internalReset();
        }

        public boolean equalTo(BAPEntity bAPEntity) {
            PrivacyMode privacyMode = (PrivacyMode)bAPEntity;
            return this.reserved_bit_7 == privacyMode.reserved_bit_7 && this.reserved_bit_6 == privacyMode.reserved_bit_6 && this.reserved_bit_5 == privacyMode.reserved_bit_5 && this.reserved_bit_4 == privacyMode.reserved_bit_4 && this.reserved_bit_3 == privacyMode.reserved_bit_3 && this.reserved_bit_2 == privacyMode.reserved_bit_2 && this.enhancedPrivacyModeActive == privacyMode.enhancedPrivacyModeActive && this.privacyModeActive == privacyMode.privacyModeActive;
        }

        private void customInitialization() {
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("PrivacyMode:");
            stringBuffer.append("\n - Bit 7: ");
            if (this.reserved_bit_7) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 6: ");
            if (this.reserved_bit_6) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 5: ");
            if (this.reserved_bit_5) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 4: ");
            if (this.reserved_bit_4) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 3: ");
            if (this.reserved_bit_3) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 2: ");
            if (this.reserved_bit_2) {
                stringBuffer.append("true  (reserved");
            } else {
                stringBuffer.append("false  (reserved");
            }
            stringBuffer.append("\n - Bit 1: ");
            if (this.enhancedPrivacyModeActive) {
                stringBuffer.append("true  (EnhancedPrivacyMode active");
            } else {
                stringBuffer.append("false  (EnhancedPrivacyMode inactive");
            }
            stringBuffer.append("\n - Bit 0: ");
            if (this.privacyModeActive) {
                stringBuffer.append("true  (PrivacyMode active");
            } else {
                stringBuffer.append("false  (PrivacyMode inactive");
            }
            return stringBuffer.toString();
        }

        public int bitSize() {
            int n = 0;
            return n += 8;
        }

        public void serialize(BitStream bitStream) {
            bitStream.pushBoolean(this.reserved_bit_7);
            bitStream.pushBoolean(this.reserved_bit_6);
            bitStream.pushBoolean(this.reserved_bit_5);
            bitStream.pushBoolean(this.reserved_bit_4);
            bitStream.pushBoolean(this.reserved_bit_3);
            bitStream.pushBoolean(this.reserved_bit_2);
            bitStream.pushBoolean(this.enhancedPrivacyModeActive);
            bitStream.pushBoolean(this.privacyModeActive);
        }

        public void deserialize(BitStream bitStream) {
            this.reserved_bit_7 = bitStream.popFrontBoolean();
            this.reserved_bit_6 = bitStream.popFrontBoolean();
            this.reserved_bit_5 = bitStream.popFrontBoolean();
            this.reserved_bit_4 = bitStream.popFrontBoolean();
            this.reserved_bit_3 = bitStream.popFrontBoolean();
            this.reserved_bit_2 = bitStream.popFrontBoolean();
            this.enhancedPrivacyModeActive = bitStream.popFrontBoolean();
            this.privacyModeActive = bitStream.popFrontBoolean();
        }
    }
}

