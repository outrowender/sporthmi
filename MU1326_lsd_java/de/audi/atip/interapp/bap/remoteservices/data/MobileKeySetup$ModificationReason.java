/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices.data;

public final class MobileKeySetup$ModificationReason {
    public static final int NO_REASON;
    public static final int CLAMP_15_NOT_ACTIVE;
    public static final int CLAMP_15_ON_WITH_PHYSICAL_KEY;
    public static final int CLAMP_15_ON_WITH_MOBILE_DEVICE_KEY;
    public static final int CLAMP_15_ON_WITH_SMARTCARD;
    public static final int AUTHENTICATION_REQUIRED_PHYSICAL_KEY;
    public static final int AUTHENTICATION_REQUIRED_MOBILE_DEVICE_KEY;
    public static final int AUTHENTICATION_REQUIRED_SMARTCARD;
    public static final int AUTHENTICATION_REQUIRED_PHYSICAL_OR_MOBILE_DEVICE_KEY;
    public static final int DEFECTIVE;

    private MobileKeySetup$ModificationReason() {
        throw new AssertionError((Object)"MobileKeySetup.ModificationReason is not intended to be instantiated.");
    }
}

