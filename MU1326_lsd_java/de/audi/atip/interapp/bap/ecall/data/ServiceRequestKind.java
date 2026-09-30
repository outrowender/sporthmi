/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class ServiceRequestKind {
    public static final int NONE = 0;
    public static final int BREAKDOWN_SERVICE = 1;
    public static final int ACCIDENTAL_DAMAGE_MANAGEMENT = 2;
    public static final int INFO_CALL = 3;
    public static final int AUTOMATIC_CRASH_NOTIFICATION = 4;
    public static final int MANUAL_EMERGENCY_CALL = 5;
    public static final int TEST_MODE = 6;

    private ServiceRequestKind() {
        throw new AssertionError((Object)"ServiceRequestKind is not intended to be instantiated.");
    }
}

