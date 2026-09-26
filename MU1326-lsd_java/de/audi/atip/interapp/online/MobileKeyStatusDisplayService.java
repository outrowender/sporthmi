/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public interface MobileKeyStatusDisplayService {
    public static final int MOBILE_KEY_BACKEND_STATE_KEY_COUNT_AVAILABLE;
    public static final int MOBILE_KEY_BACKEND_STATE_UNKNOWN;
    public static final int MOBILE_KEY_BACKEND_STATE_DELETING_KEY;
    public static final int MOBILE_KEY_BACKEND_STATE_SERVICE_DEACTIVATED;

    default public void updateServiceActiveState(boolean bl) {
    }

    default public void updateFleetModeState(boolean bl) {
    }

    default public void updateBackendState(int n) {
    }

    default public void updateKeyCount(int n) {
    }
}

