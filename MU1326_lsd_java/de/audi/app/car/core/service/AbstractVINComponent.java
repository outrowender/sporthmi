/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractVINComponent
extends AbstractDSICarVehicleStatesAdapter {
    public static final short CODING_ID = 19;
    private static final String LOGCHANNEL_NAME = "App.Car.VIN";
    private volatile CarViewOption currentViewOptions;

    public AbstractVINComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public void updateVINViewOption(CarViewOption carViewOption, int n) {
        this.getLogChannel().log(1000000, "updateVINViewOption(%1), valid:%2", (Object)carViewOption, (long)n);
        if (n == 1) {
            this.currentViewOptions = carViewOption;
            this.updateMenuEntryVisibility(carViewOption);
            this.primaryAttributeFirstSetReceived();
            this.sendContentToSDIS(0, carViewOption);
        }
    }

    public void updateVINData(String string, int n) {
        this.getLogChannel().log(1000000, "updateVINData(%1), valid:%2", (Object)string, (long)n);
        if (n == 1) {
            this.getLabelModel(49).setText(string);
            this.getChoiceModel(46).setValue(1);
            this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(84);
            this.sendContentToSDIS(4000, string);
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{3}, new int[]{4})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(CarViewOption var1);

    public String getName() {
        return "VIN";
    }
}

