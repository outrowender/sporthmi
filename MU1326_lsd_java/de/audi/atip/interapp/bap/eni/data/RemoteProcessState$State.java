/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class RemoteProcessState$State {
    public static final int UNKNOWN;
    public static final int IDLE;
    public static final int IN_PROGRESS;
    public static final int SUCCEEDED;
    public static final int FAILED_SEE_EXCEPTION_STATE;
    public static final int SEARCHING_NETWORK;
    public static final int CONNECTING_TO_SERVER;
    public static final int WAITING_FOR_AUTHENTICATION;
    public static final int TRANSMITTING_DATA;
    public static final int TERMINATED_BY_USER;

    private RemoteProcessState$State() {
        throw new AssertionError((Object)"RemoteProcessState.State is not intended to be instantiated.");
    }
}

