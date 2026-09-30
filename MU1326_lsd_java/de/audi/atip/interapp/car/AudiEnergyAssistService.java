/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car;

import de.audi.atip.interapp.car.AudiEnergyAssistStateListener;

public interface AudiEnergyAssistService {
    public static final int AVAILABLE_STATE_INVALID = -1;
    public static final int AVAILABLE_STATE_AVAILABLE = 0;
    public static final int AVAILABLE_STATE_NOTAVAILABLE = 1;
    public static final int AVAILABLE_STATE_TEMP_DISABLED = 2;
    public static final int SYSTEM_STATE_INVALID = -1;
    public static final int SYSTEM_STATE_NOT_ACTIVE = 0;
    public static final int SYSTEM_STATE_ACTIVE = 1;
    public static final int SYSTEM_STATE_CALCULATION_ACTIVE = 2;
    public static final int SYSTEM_STATE_ROUTEGUIDANCE_NOT_ACTIVE = 3;
    public static final int SYSTEM_STATE_TEMP_NOTAVAILABLE = 4;
    public static final int SYSTEM_STATE_DEFECTIVE = 5;

    public void registerStateListener(AudiEnergyAssistStateListener var1);

    public void deRegisterStateListener(AudiEnergyAssistStateListener var1);

    public void setAEASystemActive(boolean var1);
}

