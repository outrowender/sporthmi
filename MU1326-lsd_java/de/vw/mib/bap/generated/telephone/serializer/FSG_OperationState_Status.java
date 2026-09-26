/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.generated.telephone.serializer.FSG_OperationState_Status$PrivacyMode;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class FSG_OperationState_Status
implements StatusProperty {
    public int op_State;
    private static final int OP_STATE_BITSIZE;
    public static final int OP_STATE_NORMAL_OPRATION;
    public static final int OP_STATE_OFF_STAND_BY;
    public static final int OP_STATE_INITIALIZING;
    public static final int OP_STATE_DEFECT;
    public int tel_State;
    private static final int TEL_STATE_BITSIZE;
    public static final int TEL_STATE_PHONE_INITILISATION_DEFAULT_AFTER_POWER_ON_REBOOT;
    public static final int TEL_STATE_PHONE_DEFECT;
    public static final int TEL_STATE_PHONE_CONNECTING;
    public static final int TEL_STATE_PHONE_DISCONNECTING;
    public static final int TEL_STATE_PHONE_AUTOMATIC_RECONNECT;
    public static final int TEL_STATE_PHONE_MODULE_OFF;
    public static final int TEL_STATE_PHONE_MODULE_SWITCHING_ON;
    public static final int TEL_STATE_PHONE_MODULE_ON;
    public static final int TEL_STATE_PHONE_MODULE_SWITCHING_OFF;
    public static final int TEL_STATE_PHONE_MODULE_OFF_HIGH_TEMP;
    public static final int TEL_STATE_MOBILE_CONNECTING;
    public static final int TEL_STATE_MOBILE_DISCONNECTING;
    public static final int TEL_STATE_MOBILE_AUTOMATIC_RECONNECT;
    public static final int TEL_STATE_MOBILE_OFF;
    public static final int TEL_STATE_MOBILE_SWITCHING_ON;
    public static final int TEL_STATE_MOBILE_ON;
    public static final int TEL_STATE_MOBILE_SWITCHING_OFF;
    public static final int TEL_STATE_MOBILE_OFF_NO_SWITCH_ON;
    public static final int TEL_STATE_MOBILE_NOT_ATTACHED;
    public static final int TEL_STATE_MOBILE_ATTACHED_NOT_READY;
    public static final int TEL_STATE_MOBILE_ATTACHED_NOT_FUNCTIONAL;
    public final FSG_OperationState_Status$PrivacyMode privacyMode = new FSG_OperationState_Status$PrivacyMode();

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

    @Override
    public void reset() {
        this.internalReset();
        this.privacyMode.reset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        FSG_OperationState_Status fSG_OperationState_Status = (FSG_OperationState_Status)bAPEntity;
        return this.op_State == fSG_OperationState_Status.op_State && this.tel_State == fSG_OperationState_Status.tel_State && this.privacyMode.equalTo(fSG_OperationState_Status.privacyMode);
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        n += 8;
        n += 8;
        return n += this.privacyMode.bitSize();
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.op_State);
        bitStream.pushByte((byte)this.tel_State);
        this.privacyMode.serialize(bitStream);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.op_State = bitStream.popFrontByte();
        this.tel_State = bitStream.popFrontByte();
        this.privacyMode.deserialize(bitStream);
    }

    public static int functionId() {
        return 15;
    }

    @Override
    public int getFunctionId() {
        return FSG_OperationState_Status.functionId();
    }
}

