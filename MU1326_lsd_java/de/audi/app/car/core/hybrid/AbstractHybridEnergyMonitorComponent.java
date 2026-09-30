/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.hybrid.AbstractHybridBaseComponent;
import de.audi.app.car.core.hybrid.IHybridEnergyMonitorViewController;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public abstract class AbstractHybridEnergyMonitorComponent
extends AbstractHybridBaseComponent {
    public AbstractHybridEnergyMonitorComponent(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void setWheelDriveType(int n) {
        this.getViewController().setWheelDriveType(n);
    }

    protected abstract IHybridEnergyMonitorViewController getViewController();

    public String getName() {
        return "HybridEnergyMonitor";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{3, 2, 8})};
    }

    protected void initModels() {
        this.getViewController().initialize();
    }

    protected void deinitModels() {
    }

    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        super.updateHybridViewOptions(hybridViewOptions, n);
        if (1 == n) {
            this.getViewController().updateHybridViewOptions(hybridViewOptions);
        }
    }

    public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
        if (1 == n) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractHybridEnergyMonitorComponent#updateHybridEnergyFlowState] energyFlowState='%1'", (Object)hybridEnergyFlowState);
            }
            this.getViewController().updateHybridEnergyFlowState(hybridEnergyFlowState);
        }
    }

    public void updateHybridCharge(int n, int n2) {
        if (1 == n2) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractHybridEnergyMonitorComponent#updateHybridCharge] currentCharge=%1, validFlag=%2", (long)n, (long)n2);
            }
            this.getViewController().updateHybridCharge(n);
        }
    }

    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        if (1 == n) {
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "[AbstractHybridEnergyMonitorComponent#updateBatteryControlChargeState] chargeState=%1, validFlag=%2", (Object)batteryControlChargeState, (long)n);
            }
            this.getViewController().updateBatteryControlChargeState(batteryControlChargeState);
        }
    }
}

