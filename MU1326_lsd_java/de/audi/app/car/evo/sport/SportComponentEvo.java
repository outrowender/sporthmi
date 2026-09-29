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
    private static final String LOGCHANNEL_NAME;
    public static final short CODING_ID;
    private volatile DynamicVehicleInfoHighFrequent currentInfoHighFrequent;
    private volatile SemiStaticVehicleData currentSemiStaticData;
    private volatile SemiStaticDataViewOptions currentSemiStaticDataViewOptions;
    private volatile DynamicVehicleInfoHighFrequentViewOptions currentDynamicVehicleInfoHighFrequentViewOptions;

    public SportComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Sport");
    }

    @Override
    protected void initModels() {
        this.getRangeModel(0x3300900).setLimits(0, 100, 1);
        this.getRangeModel(0x300900).setLimits(0, 100, 1);
        this.getRangeModel(-13694720).setLimits(0, 100, 1);
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(608, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(603, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(606, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(602, (short)52);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(605, (short)52);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(608);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(602);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(605);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(603);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(606);
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequentViewOptions(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoHighFrequentViewOptions:%1, valid:%2", (Object)dynamicVehicleInfoHighFrequentViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentDynamicVehicleInfoHighFrequentViewOptions = dynamicVehicleInfoHighFrequentViewOptions;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(606, this.getMenuEntryVisibilityState(dynamicVehicleInfoHighFrequentViewOptions.currentTorque));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(603, this.getMenuEntryVisibilityState(dynamicVehicleInfoHighFrequentViewOptions.currentOutputPower));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(608, this.getMenuEntryVisibilityState(dynamicVehicleInfoHighFrequentViewOptions.relChargingAirPressure));
            this.primaryAttributeReceived(0, 12);
        }
    }

    @Override
    public void updateDynamicVehicleInfoHighFrequent(DynamicVehicleInfoHighFrequent dynamicVehicleInfoHighFrequent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoHighFrequent:%1, valid:%2", (Object)dynamicVehicleInfoHighFrequent, (long)n);
        }
        if (n == 1) {
            this.currentInfoHighFrequent = dynamicVehicleInfoHighFrequent;
            this.updateVisibleValues();
        }
    }

    @Override
    public void updateSemiStaticVehicleDataViewOptions(SemiStaticDataViewOptions semiStaticDataViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateSemiStaticVehicleDataViewOptions:%1, valid:%2", (Object)semiStaticDataViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentSemiStaticDataViewOptions = semiStaticDataViewOptions;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(605, this.getMenuEntryVisibilityState(semiStaticDataViewOptions.maxTorque));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(602, this.getMenuEntryVisibilityState(semiStaticDataViewOptions.maxOutputPower));
            this.primaryAttributeReceived(0, 16);
        }
    }

    @Override
    public void updateSemiStaticVehicleData(SemiStaticVehicleData semiStaticVehicleData, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateSemiStaticVehicleData:%1, valid:%2", (Object)semiStaticVehicleData, (long)n);
        }
        if (n == 1) {
            this.currentSemiStaticData = semiStaticVehicleData;
            this.updateVisibleValues();
        }
    }

    private void updateVisibleValues() {
        if (this.currentInfoHighFrequent != null && this.currentSemiStaticData != null && this.currentSemiStaticData.maxTorque != 0 && this.currentSemiStaticData.maxOutputPower != 0) {
            int n = this.currentInfoHighFrequent.currentTorque * 100 / this.currentSemiStaticData.maxTorque;
            int n2 = Math.round(this.currentInfoHighFrequent.currentOutputPower * 51266 / (float)this.currentSemiStaticData.maxOutputPower);
            this.getRangeModel(0x3300900).setValue(n2);
            this.getRangeModel(0x300900).setValue(n);
            this.getRangeModel(-13694720).setValue(this.currentInfoHighFrequent.relChargingAirPressure);
            if (this.getLogChannel().isInfo()) {
                this.getLogChannel().log(1078071040, "updateVisibleValues: currentTorquePercentage=%1, currentPowerPercentage=%2", (long)n, (long)n2);
            }
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{16, 12}, new int[]{17, 14})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentDynamicVehicleInfoHighFrequentViewOptions != null && this.currentSemiStaticDataViewOptions != null) {
            return new StringBuffer().append(this.currentDynamicVehicleInfoHighFrequentViewOptions.toString()).append(this.currentSemiStaticDataViewOptions.toString()).toString();
        }
        return "not yet received";
    }

    @Override
    public int getID() {
        return 52;
    }

    @Override
    public String getName() {
        return "SportHMI";
    }
}

