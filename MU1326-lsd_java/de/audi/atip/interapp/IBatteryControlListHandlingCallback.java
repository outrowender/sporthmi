/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IBatteryControlListHandlingConstants;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

public interface IBatteryControlListHandlingCallback
extends IBatteryControlListHandlingConstants {
    default public void updateClimateSystemType(int n, int n2) {
    }

    default public void updateChargeTimerClimateChoice(int n, int n2) {
    }

    default public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
    }
}

