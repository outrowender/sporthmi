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
    private static final int LOCK_STATE_BITSIZE;
    public static final int LOCK_STATE_NO_LOCK;
    public static final int LOCK_STATE_REQUIRE_PIN;
    public static final int LOCK_STATE_REQUIRE_PIN2;
    public static final int LOCK_STATE_PI_NBLOCKED_REQUIRE_PUK;
    public static final int LOCK_STATE_PIN2BLOCKED_REQUIRE_PUK2;
    public static final int LOCK_STATE_PU_KBLOCKED;
    public static final int LOCK_STATE_PUK2BLOCKED;
    public static final int LOCK_STATE_KEYPAD_BLOCKED;
    public static final int LOCK_STATE_SIM_NOT_AVAILABLE_NOT_PLUGGED_IN;
    public static final int LOCK_STATE_PI_NINVALID;
    public static final int LOCK_STATE_PIN2INVALID;
    public static final int LOCK_STATE_SI_MNOT_FUNCTIONAL_NOT_READABLE_OR_NOT_FUNCTIONAL;
    public static final int LOCK_STATE_SI_MNOT_READY_CHECKING_SIM_CARD;
    public static final int LOCK_STATE_REQUIRE_LOCK_CODE_CDMA_TDMA;
    public static final int LOCK_STATE_REQUIRE_SECURITY_CODE;
    public static final int LOCK_STATE_SECURITY_CODE_BLOCKED;

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

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        LockState2_Status lockState2_Status = (LockState2_Status)bAPEntity;
        return this.lockState == lockState2_Status.lockState;
    }

    private void customInitialization() {
    }

    @Override
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

    @Override
    public int bitSize() {
        int n = 0;
        return n += 8;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.lockState);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        this.lockState = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 18;
    }

    @Override
    public int getFunctionId() {
        return LockState2_Status.functionId();
    }
}

