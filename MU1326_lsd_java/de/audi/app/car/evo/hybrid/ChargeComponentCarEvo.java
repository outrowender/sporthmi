/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class ChargeComponentCarEvo
extends AbstractDSICarHybridAdapter {
    public static final short CODING_ID = 41;
    BatteryControlViewOptions currViewOptions = null;

    public ChargeComponentCarEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Charge");
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(511, (short)41);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(512, (short)41);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(511);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(512);
    }

    public int getID() {
        return 47;
    }

    protected void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(511, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer1()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(512, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer2()));
    }

    public int getPopUpID() {
        return -1;
    }

    public String getName() {
        return null;
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[0])};
    }

    public String getCurrentViewOptions() {
        return null;
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (n == 1) {
            this.currViewOptions = batteryControlViewOptions;
            this.updateMenuEntryVisibility(batteryControlViewOptions);
        }
    }
}

