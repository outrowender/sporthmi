/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class ServiceRequestKind {
    public static final int NONE;
    public static final int BREAKDOWN_SERVICE;
    public static final int ACCIDENTAL_DAMAGE_MANAGEMENT;
    public static final int INFO_CALL;
    public static final int AUTOMATIC_CRASH_NOTIFICATION;
    public static final int MANUAL_EMERGENCY_CALL;
    public static final int TEST_MODE;

    private ServiceRequestKind() {
        throw new AssertionError((Object)"ServiceRequestKind is not intended to be instantiated.");
    }
}

