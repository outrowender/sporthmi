/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public interface IHybridEnergyMonitorViewController {
    public static final int INVALID;

    default public void initialize() {
    }

    default public void setWheelDriveType(int n) {
    }

    default public void updateHybridViewOptions(HybridViewOptions hybridViewOptions) {
    }

    default public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState) {
    }

    default public void updateHybridCharge(int n) {
    }

    default public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState) {
    }
}

