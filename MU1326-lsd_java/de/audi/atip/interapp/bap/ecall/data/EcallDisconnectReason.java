/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class EcallDisconnectReason {
    public static final int REGULAR_DISCONNECTION;
    public static final int NO_LINE;
    public static final int CONNECTED_LINE_BUSY;
    public static final int SYSTEM_BUSY;
    public static final int LINE_OR_NUMBER_BUSY;
    public static final int NUMBER_NOT_ASSIGNED;
    public static final int NUMBER_NOT_REACHABLE;
    public static final int NETWORK_FAILURE;
    public static final int CALL_BARRING_ACTIVE;
    public static final int USER_NOT_RESPONDING;
    public static final int CALL_REJECTED;
    public static final int NUMBER_HAS_CHANGED;
    public static final int NUMBER_INVALID_OR_INCOMPLETE;
    public static final int SERVICE_NOT_AVAILABLE;
    public static final int UNKNOWN;
    public static final int TEMPORARY_BLOCKED_OR_NOT_AVAILABLE;

    private EcallDisconnectReason() {
        throw new AssertionError((Object)"EcallDisconnectReason is not intended to be instantiated.");
    }
}

