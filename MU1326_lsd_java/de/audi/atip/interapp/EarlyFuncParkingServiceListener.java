/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;

public interface EarlyFuncParkingServiceListener
extends AbstractSDSApplicationService {
    public static final int PARKING_SYSTEM_INVALID;
    public static final int PARKING_SYSTEM_RVC_ONLY;
    public static final int PARKING_SYSTEM_APS_RVC;
    public static final int PARKING_SYSTEM_APS_OPS;
    public static final int PARKING_SYSTEM_APS_OPS_RVC;
    public static final int PARKING_SYSTEM_APS_OPS360;
    public static final int PARKING_SYSTEM_APS_OPS360_RVC;
    public static final int PARKING_SYSTEM_APS_ONLY;

    default public void updateSettingsVisibility(int n, int n2) {
    }
}

