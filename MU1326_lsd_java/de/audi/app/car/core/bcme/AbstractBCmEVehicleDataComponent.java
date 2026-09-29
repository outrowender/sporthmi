/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;

public abstract class AbstractBCmEVehicleDataComponent
extends AbstractDSICarVehicleStatesAdapter {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private DynamicVehicleInfoMidFrequentViewOptions currViewOptions;

    public AbstractBCmEVehicleDataComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.BCmEStates");
    }

    @Override
    public String getName() {
        return "BCmEStates";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{13}, new int[]{15})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    protected void initModels() {
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequentViewOptions(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoHighFrequentViewOptions: %1 ", (Object)(dynamicVehicleInfoMidFrequentViewOptions != null ? dynamicVehicleInfoMidFrequentViewOptions.toString() : "null"));
        }
        if (n == 1) {
            this.currViewOptions = dynamicVehicleInfoMidFrequentViewOptions;
            this.updateMenuEntryVisibility(dynamicVehicleInfoMidFrequentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateDynamicVehicleInfoMidFrequent: %1, valid=%2, no action performed on this update", (Object)(dynamicVehicleInfoMidFrequent != null ? dynamicVehicleInfoMidFrequent.toString() : null), (long)n);
        }
    }

    protected abstract void updateMenuEntryVisibility(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions) {
    }
}

