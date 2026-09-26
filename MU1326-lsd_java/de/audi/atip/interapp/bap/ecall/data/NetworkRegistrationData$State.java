/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.ecall.data;

public final class NetworkRegistrationData$State {
    public static final int NOT_REGISTERED_AND_NOT_SEARCHING;
    public static final int REGISTERED;
    public static final int NOT_REGISTERED_AND_SEARCHING;
    public static final int REGISTRATION_DENIED;
    public static final int REGISTERED_AND_ROAMING;
    public static final int REGISTERED_AND_ROAMING_ALTERNATIVE;
    public static final int FUNCTION_NOT_SUPPORTED_BY_MOBILE_EQUIPEMENT;

    private NetworkRegistrationData$State() {
        throw new AssertionError((Object)"NetworkRegistrationData.State is not intended to be instantiated.");
    }
}

