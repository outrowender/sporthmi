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
    public static final short CODING_ID;
    private boolean auxAcImmediateOn = false;
    private int auxACImmediateVisiblityState = 0;
    private Object climateSystemVariant;
    public static final int CLIMATE_SYSTEM_VARIANT_NONE;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED;

    public AuxACComponentCarEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AuxAc");
    }

    @Override
    public int getID() {
        return 48;
    }

    @Override
    protected void initVisibility() {
        if (this.getClimateSystemVariant() == 3) {
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1825961728, (short)46);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1809184512, (short)46);
        } else if (this.getClimateSystemVariant() == 2) {
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(-47642368, (short)46);
            this.getApplication().getMenuEntryRegistry().registerMenuEntry(1361709312, (short)46);
        }
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-165213952, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-148436736, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(222, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(223, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(225, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(226, (short)46);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(227, (short)46);
    }

    @Override
    protected void deinitVisibility() {
        if (this.getClimateSystemVariant() == 3) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1825961728);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1809184512);
        } else if (this.getClimateSystemVariant() == 2) {
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-47642368);
            this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1361709312);
        }
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(222);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(223);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(225);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(226);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(227);
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlViewOptions(%1), valid:%2", (Object)batteryControlViewOptions, (long)n);
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
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1825961728, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1809184512, n);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1825961728, n);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1809184512, 1);
            }
        } else if (this.getClimateSystemVariant() == 2) {
            if (bl) {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-47642368, 1);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1361709312, n);
            } else {
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-47642368, n);
                this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1361709312, 1);
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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[0])};
    }

    @Override
    public String getCurrentViewOptions() {
        return null;
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }
}

