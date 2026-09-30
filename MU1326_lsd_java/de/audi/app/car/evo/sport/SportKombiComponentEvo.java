/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.sport;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.metrics.Temperature;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCTemperature;

public class SportKombiComponentEvo
extends AbstractDSICarKombiAdapter {
    public static final short CODING_ID = 52;
    private volatile BCViewOptions currentBCViewOptions;
    private static final String LOGCHANNEL_NAME = "App.Car.Sport";

    public SportKombiComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(607, (short)52);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(607);
    }

    public void updateBCOilTemperatureValue(CarBCTemperature carBCTemperature, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCOilTemperatureValue:%1, valid:%2", (Object)carBCTemperature, (long)n);
        }
        if (n == 1) {
            if (carBCTemperature.state == 0) {
                Temperature temperature = new Temperature(0.0f, carBCTemperature.temperatureUnit == 0 ? 1 : 2);
                temperature.setUseInstanceUnit(true);
                this.getMetricsModel(602117).setMetric(temperature);
            } else {
                Temperature temperature = new Temperature(carBCTemperature.temperatureValue, carBCTemperature.temperatureUnit == 0 ? 1 : 2);
                temperature.setUseInstanceUnit(true);
                this.getMetricsModel(602117).setMetric(temperature);
            }
        }
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCViewOptions:%1, valid:%2", (Object)bCViewOptions, (long)n);
        }
        if (n == 1) {
            this.currentBCViewOptions = bCViewOptions;
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(607, this.getMenuEntryVisibilityState(bCViewOptions.oilTemperatureValue));
            this.primaryAttributeFirstSetReceived();
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{64})};
    }

    public String getCurrentViewOptions() {
        if (this.currentBCViewOptions != null) {
            return this.currentBCViewOptions.toString();
        }
        return "not yet received";
    }

    public String getName() {
        return "SportHMI-Kombi";
    }

    public int getID() {
        return 53;
    }
}

