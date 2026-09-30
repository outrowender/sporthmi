/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone2.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class LockState2_Status
implements StatusProperty {
    public int lockState;
    private static final int LOCK_STATE_BITSIZE = 8;
    public static final int LOCK_STATE_NO_LOCK = 0;
    public static final int LOCK_STATE_REQUIRE_PIN = 1;
    public static final int LOCK_STATE_REQUIRE_PIN2 = 2;
    public static final int LOCK_STATE_PI_NBLOCKED_REQUIRE_PUK = 3;
    public static final int LOCK_STATE_PIN2BLOCKED_REQUIRE_PUK2 = 4;
    public static final int LOCK_STATE_PU_KBLOCKED = 5;
    public static final int LOCK_STATE_PUK2BLOCKED = 6;
    public static final int LOCK_STATE_KEYPAD_BLOCKED = 7;
    public static final int LOCK_STATE_SIM_NOT_AVAILABLE_NOT_PLUGGED_IN = 8;
    public static final int LOCK_STATE_PI_NINVALID = 9;
    public static final int LOCK_STATE_PIN2INVALID = 10;
    public static final int LOCK_STATE_SI_MNOT_FUNCTIONAL_NOT_READABLE_OR_NOT_FUNCTIONAL = 11;
    public static final int LOCK_STATE_SI_MNOT_READY_CHECKING_SIM_CARD = 12;
    public static final int LOCK_STATE_REQUIRE_LOCK_CODE_CDMA_TDMA = 13;
    public static final int LOCK_STATE_REQUIRE_SECURITY_CODE = 14;
    public static final int LOCK_STATE_SECURITY_CODE_BLOCKED = 15;

    public LockState2_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public LockState2_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.lockState = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        LockState2_Status lockState2_Status = (LockState2_Status)bAPEntity;
        return this.lockState == lockState2_Status.lockState;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("LockState2_Status:");
        stringBuffer.append("\n - LockState: ");
        switch (this.lockState) {
            case 0: {
                stringBuffer.append("0x00 (NoLock)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (RequirePIN)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (RequirePIN2)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (PINblockedRequirePUK)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (PIN2blockedRequirePUK2)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (PUKblocked)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (PUK2blocked)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (KeypadBlocked)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (SIMNotAvailable (not plugged in))");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (PINinvalid)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (PIN2invalid)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (SIMnotFunctional (not readable or not functional))");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (SIMnotReady (checking SIM card))");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (RequireLockCode (CDMA/TDMA))");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (RequireSecurityCode)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (SecurityCodeBlocked)");
                break;
            }
            default: {
                stringBuffer.append("UNKNOWN ENUM");
            }
        }
        return stringBuffer.toString();
    }

    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.lockState);
    }

    public void deserialize(BitStream bitStream) {
        this.lockState = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    public int getFunctionId() {
        return LockState2_Status.functionId();
    }
}

