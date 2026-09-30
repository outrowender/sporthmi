/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.telephone.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DisconnectReason_Status
implements StatusProperty {
    public int disconnectReason;
    private static final int DISCONNECT_REASON_BITSIZE = 8;
    public static final int DISCONNECT_REASON_REGULAR_DISCONNECTING_DEFAULT_VALUE = 0;
    public static final int DISCONNECT_REASON_NO_LINE = 1;
    public static final int DISCONNECT_REASON_CONNECTED_LINE_BUSY = 2;
    public static final int DISCONNECT_REASON_SYSTEM_BUSY = 3;
    public static final int DISCONNECT_REASON_LINE_BUSY_NUMBER_BUSY = 4;
    public static final int DISCONNECT_REASON_NUMBER_NOT_ASSIGNED = 5;
    public static final int DISCONNECT_REASON_NUMBER_NOT_REACHABLE = 6;
    public static final int DISCONNECT_REASON_NETWORK_FAILURE = 7;
    public static final int DISCONNECT_REASON_CALL_BARRING_ACTIVE = 8;
    public static final int DISCONNECT_REASON_USER_NOT_RESPONDING = 9;
    public static final int DISCONNECT_REASON_CALL_REJECT = 10;
    public static final int DISCONNECT_REASON_NUMBER_CHANGED = 11;
    public static final int DISCONNECT_REASON_NUMBER_INVALID_INCOMPLETE = 12;
    public static final int DISCONNECT_REASON_SERVICE_NOT_AVAILABLE = 13;
    public static final int DISCONNECT_REASON_NO_INFO_AVAILABLE_DISCONNECT_REASON_UNKNOWN = 14;
    public static final int DISCONNECT_REASON_TEMPORARY_BLOCKED_NOT_AVAILABLE = 15;

    public DisconnectReason_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public DisconnectReason_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.disconnectReason = 0;
    }

    public void reset() {
        this.internalReset();
    }

    public boolean equalTo(BAPEntity bAPEntity) {
        DisconnectReason_Status disconnectReason_Status = (DisconnectReason_Status)bAPEntity;
        return this.disconnectReason == disconnectReason_Status.disconnectReason;
    }

    private void customInitialization() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DisconnectReason_Status:");
        stringBuffer.append("\n - DisconnectReason: ");
        switch (this.disconnectReason) {
            case 0: {
                stringBuffer.append("0x00 (RegularDisconnecting/DefaultValue)");
                break;
            }
            case 1: {
                stringBuffer.append("0x01 (NoLine)");
                break;
            }
            case 2: {
                stringBuffer.append("0x02 (ConnectedLine/Busy)");
                break;
            }
            case 3: {
                stringBuffer.append("0x03 (SystemBusy)");
                break;
            }
            case 4: {
                stringBuffer.append("0x04 (LineBusy/NumberBusy)");
                break;
            }
            case 5: {
                stringBuffer.append("0x05 (NumberNotAssigned)");
                break;
            }
            case 6: {
                stringBuffer.append("0x06 (NumberNotReachable)");
                break;
            }
            case 7: {
                stringBuffer.append("0x07 (NetworkFailure)");
                break;
            }
            case 8: {
                stringBuffer.append("0x08 (CallBarringActive)");
                break;
            }
            case 9: {
                stringBuffer.append("0x09 (UserNotResponding)");
                break;
            }
            case 10: {
                stringBuffer.append("0x0A (CallReject)");
                break;
            }
            case 11: {
                stringBuffer.append("0x0B (NumberChanged)");
                break;
            }
            case 12: {
                stringBuffer.append("0x0C (NumberInvalidIncomplete)");
                break;
            }
            case 13: {
                stringBuffer.append("0x0D (ServiceNotAvailable)");
                break;
            }
            case 14: {
                stringBuffer.append("0x0E (NoInfoAvailable / disconnect reason unknown)");
                break;
            }
            case 15: {
                stringBuffer.append("0x0F (temporary blocked/not available)");
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
        bitStream.pushByte((byte)this.disconnectReason);
    }

    public void deserialize(BitStream bitStream) {
        this.disconnectReason = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 25;
    }

    public int getFunctionId() {
        return DisconnectReason_Status.functionId();
    }
}

