/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public class AuxACComponentCarEvo
extends AbstractDSICarHybridAdapter {
    public static final short CODING_ID = 46;
    private boolean auxAcImmediateOn = false;
    private int auxACImmediateVisiblityState = 0;
    private Object climateSystemVariant;
    public static final int CLIMATE_SYSTEM_VARIANT_NONE = 0;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER = 1;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER = 2;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED = 3;

    public AuxACComponentCarEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AuxAc");
    }

    public int getID() {
        return 48;
    }

    protected void initVisibility() {
        if (this.getClimateSystemVariant() == 3) {
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(600723, (short)46);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(600724, (short)46);
        } else if (this.getClimateSystemVariant() == 2) {
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(600573, (short)46);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(600657, (short)46);
        }
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600054, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600055, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(222, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(223, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(225, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(226, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(227, (short)46);
    }

    protected void deinitVisibility() {
        if (this.getClimateSystemVariant() == 3) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600723);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600724);
        } else if (this.getClimateSystemVariant() == 2) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600573);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600657);
        }
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(222);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(223);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(225);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(226);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(227);
    }

    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlViewOptions(%1), valid:%2", (Object)batteryControlViewOptions, (long)n);
        if (n == 1) {
            this.updateMenuEntryVisibility(batteryControlViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    protected void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
        this.updateAuxACImmediateVisibilityState(this.getMenuEntryVisibilityState(batteryControlViewOptions.getImmediately()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(222, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer3()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(223, this.getMenuEntryVisibilityState(batteryControlViewOptions.getTimer4()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(225, batteryControlViewOptions.configuration.climateOperationModeInstallation.operationModeImmediatly ? 0 : 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(226, batteryControlViewOptions.configuration.climateOperationModeInstallation.operationModeTimer3 ? 0 : 1);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(227, batteryControlViewOptions.configuration.climateOperationModeInstallation.operationModeTimer4 ? 0 : 1);
    }

    private void updateMenuEntryVisibilityNow(boolean bl, int n) {
        if (this.getClimateSystemVariant() == 3) {
            if (bl) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600723, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600724, n);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600723, n);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600724, 1);
            }
        } else if (this.getClimateSystemVariant() == 2) {
            if (bl) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600573, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600657, n);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600573, n);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600657, 1);
            }
        }
    }

    protected void updateAuxACImmediateOn(boolean bl) {
        this.auxAcImmediateOn = bl;
        this.updateMenuEntryVisibilityNow(bl, this.auxACImmediateVisiblityState);
    }

    private void updateAuxACImmediateVisibilityState(int n) {
        this.auxACImmediateVisiblityState = n;
        this.updateMenuEntryVisibilityNow(this.auxAcImmediateOn, n);
    }

    private int getClimateSystemVariant() {
        boolean bl = this.getApplication().getCarMenuCoding().isMenuDisplayActivated((short)9);
        boolean bl2 = this.getApplication().getCarMenuCoding().isMenuDisplayActivated((short)46);
        if (bl && bl2) {
            return 3;
        }
        if (bl) {
            return 1;
        }
        if (bl2) {
            return 2;
        }
        return 0;
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
}

