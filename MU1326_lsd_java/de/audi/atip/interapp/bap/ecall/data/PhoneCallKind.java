/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class PhoneCallKind {
    public static final int UNKNOWN;
    public static final int SINGLE_VOICE_CALL;
    public static final int UNSUPPORTED;
    public static final int UNSUPPORTED_2;
    public static final int MANUAL_EMERGENCY_CALL_WITHOUT_DATA_TRANSMISSION;
    public static final int UNSUPPORTED_3;
    public static final int INFO_CALL;
    public static final int SERVICE_CALL;
    public static final int AUTOMATIC_CRASH_NOTIFICATION;
    public static final int MANUAL_EMERGENCY_CALL;
    public static final int MANUAL_EMERGENCY_CALL_LEGAL;

    private PhoneCallKind() {
        throw new AssertionError((Object)"PhoneCallKind is not intended to be instantiated.");
    }
}

