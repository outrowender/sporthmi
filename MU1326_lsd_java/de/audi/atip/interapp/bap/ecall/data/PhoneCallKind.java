/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class PhoneCallKind {
    public static final int UNKNOWN = 0;
    public static final int SINGLE_VOICE_CALL = 1;
    public static final int UNSUPPORTED = 2;
    public static final int UNSUPPORTED_2 = 3;
    public static final int MANUAL_EMERGENCY_CALL_WITHOUT_DATA_TRANSMISSION = 4;
    public static final int UNSUPPORTED_3 = 5;
    public static final int INFO_CALL = 6;
    public static final int SERVICE_CALL = 7;
    public static final int AUTOMATIC_CRASH_NOTIFICATION = 8;
    public static final int MANUAL_EMERGENCY_CALL = 9;
    public static final int MANUAL_EMERGENCY_CALL_LEGAL = 10;

    private PhoneCallKind() {
        throw new AssertionError((Object)"PhoneCallKind is not intended to be instantiated.");
    }
}

