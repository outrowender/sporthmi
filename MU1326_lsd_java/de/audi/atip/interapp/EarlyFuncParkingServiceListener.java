/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface EarlyFuncParkingServiceListener
extends AbstractSDSApplicationService {
    public static final int PARKING_SYSTEM_INVALID = 0;
    public static final int PARKING_SYSTEM_RVC_ONLY = 1;
    public static final int PARKING_SYSTEM_APS_RVC = 2;
    public static final int PARKING_SYSTEM_APS_OPS = 3;
    public static final int PARKING_SYSTEM_APS_OPS_RVC = 4;
    public static final int PARKING_SYSTEM_APS_OPS360 = 5;
    public static final int PARKING_SYSTEM_APS_OPS360_RVC = 6;
    public static final int PARKING_SYSTEM_APS_ONLY = 7;

    public void updateSettingsVisibility(int var1, int var2);
}

