/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IBatteryControlListHandlingConstants;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

public interface IBatteryControlListHandlingCallback
extends IBatteryControlListHandlingConstants {
    public void updateClimateSystemType(int var1, int var2);

    public void updateChargeTimerClimateChoice(int var1, int var2);

    public void onBatteryControlProfileOperationChanged(int var1, BatteryControlProfileOperation var2);
}

