/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.metrics.Temperature;
import org.dsi.ifc.global.CarBCTemperature;

public abstract class AbstractBCComponent
extends AbstractDSICarKombiAdapter {
    private static final String LOGCHANNEL_NAME;

    public AbstractBCComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.BC");
    }

    @Override
    public String getName() {
        return "Boardcomputer";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{65}, new int[0])};
    }

    @Override
    public void updateBCOutsideTemperature(CarBCTemperature carBCTemperature, int n) {
        if (n == 1) {
            Temperature temperature = new Temperature(carBCTemperature.getTemperatureValue(), carBCTemperature.getTemperatureUnit() == 0 ? 1 : 2);
            this.getMetricsModel(406).setMetric(temperature);
        }
    }

    public MetricsModel getTemperatureMetrics() {
        return (MetricsModel)this.getMetricsModel(406);
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

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }
}

