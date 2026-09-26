/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car;

import de.audi.atip.interapp.car.AudiEnergyAssistStateListener;

public interface AudiEnergyAssistService {
    public static final int AVAILABLE_STATE_INVALID;
    public static final int AVAILABLE_STATE_AVAILABLE;
    public static final int AVAILABLE_STATE_NOTAVAILABLE;
    public static final int AVAILABLE_STATE_TEMP_DISABLED;
    public static final int SYSTEM_STATE_INVALID;
    public static final int SYSTEM_STATE_NOT_ACTIVE;
    public static final int SYSTEM_STATE_ACTIVE;
    public static final int SYSTEM_STATE_CALCULATION_ACTIVE;
    public static final int SYSTEM_STATE_ROUTEGUIDANCE_NOT_ACTIVE;
    public static final int SYSTEM_STATE_TEMP_NOTAVAILABLE;
    public static final int SYSTEM_STATE_DEFECTIVE;

    default public void registerStateListener(AudiEnergyAssistStateListener audiEnergyAssistStateListener) {
    }

    default public void deRegisterStateListener(AudiEnergyAssistStateListener audiEnergyAssistStateListener) {
    }

    default public void setAEASystemActive(boolean bl) {
    }
}

