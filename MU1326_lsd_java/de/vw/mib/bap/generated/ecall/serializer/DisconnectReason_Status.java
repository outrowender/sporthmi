/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.generated.ecall.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class DisconnectReason_Status
implements StatusProperty {
    public int disconnectReason;
    public static final int DISCONNECT_REASON_TEMPORARY_BLOCKED_NOT_AVAILABLE = 15;
    public static final int DISCONNECT_REASON_NO_INFO_AVAILABLE_DISCONNECT_REASON_UNKNOWN = 14;
    public static final int DISCONNECT_REASON_SERVICE_NOT_AVAILABLE = 13;
    public static final int DISCONNECT_REASON_NUMBER_INVALID_INCOMPLETE = 12;
    public static final int DISCONNECT_REASON_NUMBER_CHANGED = 11;
    public static final int DISCONNECT_REASON_CALL_REJECT = 10;
    public static final int DISCONNECT_REASON_USER_NOT_RESPONDING = 9;
    public static final int DISCONNECT_REASON_CALL_BARRING_ACTIVE = 8;
    public static final int DISCONNECT_REASON_NETWORK_FAILURE = 7;
    public static final int DISCONNECT_REASON_NUMBER_NOT_REACHABLE = 6;
    public static final int DISCONNECT_REASON_NUMBER_NOT_ASSIGNED = 5;
    public static final int DISCONNECT_REASON_LINE_BUSY_NUMBER_BUSY = 4;
    public static final int DISCONNECT_REASON_SYSTEM_BUSY = 3;
    public static final int DISCONNECT_REASON_CONNECTED_LINE_BUSY = 2;
    public static final int DISCONNECT_REASON_NO_LINE = 1;
    public static final int DISCONNECT_REASON_REGULAR_DISCONNECTING_DEFAULT_VALUE = 0;

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
        stringBuffer.append("DisconnectReason_Status");
        stringBuffer.append("\n - disconnectReason:").append(this.disconnectReason);
        return stringBuffer.toString();
    }

    public int bitSize() {
        return 0;
    }

    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.disconnectReason);
    }

    public void deserialize(BitStream bitStream) {
        this.disconnectReason = bitStream.popFrontByte();
    }

    public static int functionId() {
        return 20;
    }

    public int getFunctionId() {
        return DisconnectReason_Status.functionId();
    }
}

