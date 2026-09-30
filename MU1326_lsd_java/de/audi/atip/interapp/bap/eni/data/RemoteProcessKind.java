/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.eni.data;

public final class RemoteProcessKind {
    public static final int NONE = 0;
    public static final int UPDATE_USER_LIST = 1;
    public static final int DELETE_USER_LIST = 2;
    public static final int PAIR_MAIN_USER_USING_PAIRING_CODE = 3;
    public static final int PAIR_MAIN_USER_USING_VEHICLE_PIN = 4;
    public static final int CONFIRM_SERVICE_EXPIRY_WARNING = 5;
    public static final int GET_MOBILE_DEVICE_KEY_COUNT = 7;
    public static final int GET_VTAN = 8;
    public static final int DEACTIVATE_ACTIVATE_PRIVACY_MODE = 18;

    private RemoteProcessKind() {
        throw new AssertionError((Object)"RemoteProcessKind is not intended to be instantiated.");
    }
}

