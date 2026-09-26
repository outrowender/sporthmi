/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class PhoneCallState {
    public static final int IDLE;
    public static final int RINGING_WAITING;
    public static final int ACTIVE;
    public static final int DIALING;
    public static final int DISCONNECTING;
    public static final int ON_HOLD;
    public static final int CONNECTED_TO_CONNECTED_GATEWAY;
    public static final int REMOTE_SIDE_BUSY;
    public static final int INCOMING_ON_HOLD;

    private PhoneCallState() {
        throw new AssertionError((Object)"PhoneCallState is not intended to be instantiated.");
    }
}

