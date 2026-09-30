/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.sport;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;

public class SportComponentEvo
extends AbstractDSICarVehicleStatesAdapter {
    private static final String LOGCHANNEL_NAME = "App.Car.Sport";
    public static final short CODING_ID = 52;
    private volatile DynamicVehicleInfoHighFrequent currentInfoHighFrequent;
    private volatile SemiStaticVehicleData currentSemiStaticData;
    private volatile SemiStaticDataViewOptions currentSemiStaticDataViewOptions;
    private volatile DynamicVehicleInfoHighFrequentViewOptions currentDynamicVehicleInfoHighFrequentViewOptions;

    public SportComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getRangeModel(602115).setLimits(0, 100, 1);
        this.getRangeModel(602112).setLimits(0, 100, 1);
        this.getRangeModel(602111).setLimits(0, 100, 1);
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(608, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(603, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(606, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(602, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(605, (short)52);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(608);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(602);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(605);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(603);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(606);
    }

    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateDynamicVehicleInfoHighFrequentViewOptions:%1, valid:%2", (Object)dynamicVehicleInfoHighFrequentViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentDynamicVehicleInfoHighFrequentViewOptions = dynamicVehicleInfoHighFrequentViewOptions;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(606, this.getMenuEntryVisibilityState(dynamicVehicleInfoHighFrequentViewOptions.currentTorque));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(603, this.getMenuEntryVisibilityState(dynamicVehicleInfoHighFrequentViewOptions.currentOutputPower));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(608, this.getMenuEntryVisibilityState(dynamicVehicleInfoHighFrequentViewOptions.relChargingAirPressure));
            this.primaryAttributeReceived(0, 12);
        }
    }

    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateDynamicVehicleInfoHighFrequent:%1, valid:%2", (Object)dynamicVehicleInfoHighFrequent, (long)n);
        }
        if (n == 1) {
            this.currentInfoHighFrequent = dynamicVehicleInfoHighFrequent;
            this.updateVisibleValues();
        }
    }

    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateSemiStaticVehicleDataViewOptions:%1, valid:%2", (Object)semiStaticDataViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentSemiStaticDataViewOptions = semiStaticDataViewOptions;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(605, this.getMenuEntryVisibilityState(semiStaticDataViewOptions.maxTorque));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(602, this.getMenuEntryVisibilityState(semiStaticDataViewOptions.maxOutputPower));
            this.primaryAttributeReceived(0, 16);
        }
    }

    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateSemiStaticVehicleData:%1, valid:%2", (Object)semiStaticVehicleData, (long)n);
        }
        if (n == 1) {
            this.currentSemiStaticData = semiStaticVehicleData;
            this.updateVisibleValues();
        }
    }

    private void updateVisibleValues() {
        if (this.currentInfoHighFrequent != null && this.currentSemiStaticData != null && this.currentSemiStaticData.maxTorque != 0 && this.currentSemiStaticData.maxOutputPower != 0) {
            int n = this.currentInfoHighFrequent.currentTorque * 100 / this.currentSemiStaticData.maxTorque;
            int n2 = Math.round(this.currentInfoHighFrequent.currentOutputPower * 100.0f / (float)this.currentSemiStaticData.maxOutputPower);
            this.getRangeModel(602115).setValue(n2);
            this.getRangeModel(602112).setValue(n);
            this.getRangeModel(602111).setValue(this.currentInfoHighFrequent.relChargingAirPressure);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1000000, "updateVisibleValues: currentTorquePercentage=%1, currentPowerPercentage=%2", (long)n, (long)n2);
            }
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{16, 12}, new int[]{17, 14})};
    }

    public String getCurrentViewOptions() {
        if (this.currentDynamicVehicleInfoHighFrequentViewOptions != null && this.currentSemiStaticDataViewOptions != null) {
            return this.currentDynamicVehicleInfoHighFrequentViewOptions.toString() + this.currentSemiStaticDataViewOptions.toString();
        }
        return "not yet received";
    }

    public int getID() {
        return 52;
    }

    public String getName() {
        return "SportHMI";
    }
}

