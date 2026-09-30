/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public interface IHybridEnergyMonitorViewController {
    public static final int INVALID = -1;

    public void initialize();

    public void setWheelDriveType(int var1);

    public void updateHybridViewOptions(HybridViewOptions var1);

    public void updateHybridEnergyFlowState(HybridEnergyFlowState var1);

    public void updateHybridCharge(int var1);

    public void updateBatteryControlChargeState(BatteryControlChargeState var1);
}

