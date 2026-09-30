/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public interface MobileKeyStatusDisplayService {
    public static final int MOBILE_KEY_BACKEND_STATE_KEY_COUNT_AVAILABLE = 0;
    public static final int MOBILE_KEY_BACKEND_STATE_UNKNOWN = 1;
    public static final int MOBILE_KEY_BACKEND_STATE_DELETING_KEY = 2;
    public static final int MOBILE_KEY_BACKEND_STATE_SERVICE_DEACTIVATED = 3;

    public void updateServiceActiveState(boolean var1);

    public void updateFleetModeState(boolean var1);

    public void updateBackendState(int var1);

    public void updateKeyCount(int var1);
}

