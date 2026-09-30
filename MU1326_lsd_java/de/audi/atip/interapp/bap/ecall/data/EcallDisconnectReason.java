/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class EcallDisconnectReason {
    public static final int REGULAR_DISCONNECTION = 0;
    public static final int NO_LINE = 1;
    public static final int CONNECTED_LINE_BUSY = 2;
    public static final int SYSTEM_BUSY = 3;
    public static final int LINE_OR_NUMBER_BUSY = 4;
    public static final int NUMBER_NOT_ASSIGNED = 5;
    public static final int NUMBER_NOT_REACHABLE = 6;
    public static final int NETWORK_FAILURE = 7;
    public static final int CALL_BARRING_ACTIVE = 8;
    public static final int USER_NOT_RESPONDING = 9;
    public static final int CALL_REJECTED = 10;
    public static final int NUMBER_HAS_CHANGED = 11;
    public static final int NUMBER_INVALID_OR_INCOMPLETE = 12;
    public static final int SERVICE_NOT_AVAILABLE = 13;
    public static final int UNKNOWN = 14;
    public static final int TEMPORARY_BLOCKED_OR_NOT_AVAILABLE = 15;

    private EcallDisconnectReason() {
        throw new AssertionError((Object)"EcallDisconnectReason is not intended to be instantiated.");
    }
}

