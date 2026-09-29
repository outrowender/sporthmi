/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class RemoteProcessKind {
    public static final int NONE;
    public static final int UPDATE_USER_LIST;
    public static final int DELETE_USER_LIST;
    public static final int PAIR_MAIN_USER_USING_PAIRING_CODE;
    public static final int PAIR_MAIN_USER_USING_VEHICLE_PIN;
    public static final int CONFIRM_SERVICE_EXPIRY_WARNING;
    public static final int GET_MOBILE_DEVICE_KEY_COUNT;
    public static final int GET_VTAN;
    public static final int DEACTIVATE_ACTIVATE_PRIVACY_MODE;

    private RemoteProcessKind() {
        throw new AssertionError((Object)"RemoteProcessKind is not intended to be instantiated.");
    }
}

