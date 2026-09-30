/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class PhoneCallState {
    public static final int IDLE = 0;
    public static final int RINGING_WAITING = 1;
    public static final int ACTIVE = 2;
    public static final int DIALING = 3;
    public static final int DISCONNECTING = 4;
    public static final int ON_HOLD = 5;
    public static final int CONNECTED_TO_CONNECTED_GATEWAY = 6;
    public static final int REMOTE_SIDE_BUSY = 7;
    public static final int INCOMING_ON_HOLD = 8;

    private PhoneCallState() {
        throw new AssertionError((Object)"PhoneCallState is not intended to be instantiated.");
    }
}

