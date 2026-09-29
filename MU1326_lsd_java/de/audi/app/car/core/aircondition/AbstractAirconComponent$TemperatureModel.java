/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.core.aircondition.AbstractAirconComponent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.metrics.Temperature;
import org.dsi.ifc.caraircondition.AirconTemp;

class AbstractAirconComponent$TemperatureModel {
    private static final int LABEL_TEMP_VALUE;
    private static final int LABEL_LO_SYMBOL;
    private static final int LABEL_HI_SYMBOL;
    private final float tempStartCelsius;
    private final float tempEndCelsius;
    private final float tempStepCelsius;
    private final float tempStartFahrenheit;
    private final float tempEndFahrenheit;
    private final float tempStepFahrenheit;
    private RangeModelApp celsiusRange = null;
    private RangeModelApp fahrenheitRange = null;
    private ChoiceModelApp labelChoice = null;
    private MetricsModelApp tempMetric = null;
    private int currentTemperature = 0;
    private final /* synthetic */ AbstractAirconComponent this$0;

    public AbstractAirconComponent$TemperatureModel(AbstractAirconComponent abstractAirconComponent, RangeModelApp rangeModelApp, RangeModelApp rangeModelApp2, ChoiceModelApp choiceModelApp, MetricsModelApp metricsModelApp, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.this$0 = abstractAirconComponent;
        this.celsiusRange = rangeModelApp;
        this.fahrenheitRange = rangeModelApp2;
        this.labelChoice = choiceModelApp;
        this.tempMetric = metricsModelApp;
        this.tempStartCelsius = f2;
        this.tempEndCelsius = f3;
        this.tempStepCelsius = f4;
        this.tempStartFahrenheit = f5;
        this.tempEndFahrenheit = f6;
        this.tempStepFahrenheit = f7;
    }

    private float dsiToCelsius(int n) {
        float f2 = (n - this.celsiusRange.getMinimum()) / this.celsiusRange.getStep();
        float f3 = this.tempStartCelsius + f2 * this.tempStepCelsius;
        return AbstractCarComponent.clip(f3, this.tempStartCelsius, this.tempEndCelsius);
    }

    private float dsiToFahrenheit(int n) {
        float f2 = (n - this.fahrenheitRange.getMinimum()) / this.fahrenheitRange.getStep();
        float f3 = this.tempStartFahrenheit + f2 * this.tempStepFahrenheit;
        return AbstractCarComponent.clip(f3, this.tempStartFahrenheit, this.tempEndFahrenheit);
    }

    private void updateTemperatureModels(float f2, float f3, float f4, int n) {
        float f5 = AbstractCarComponent.clip(f2, f3, f4);
        int n2 = f5 == f3 ? 1 : (f5 == f4 ? 2 : 0);
        Temperature temperature = new Temperature(f2, n);
        this.labelChoice.setValue(n2);
        this.tempMetric.setMetric(temperature);
    }

    public int getCurrentTemperature() {
        return this.currentTemperature;
    }

    public void updateHMI(AirconTemp airconTemp) {
        switch (airconTemp.getTempUnit()) {
            case 0: {
                this.currentTemperature = AbstractCarComponent.clip(airconTemp.getTempValue(), this.celsiusRange.getMinimum(), this.celsiusRange.getMaximum());
                this.celsiusRange.setValue(this.currentTemperature);
                this.updateTemperatureModels(this.dsiToCelsius(this.currentTemperature), this.tempStartCelsius, this.tempEndCelsius, 1);
                break;
            }
            case 1: {
                this.currentTemperature = AbstractCarComponent.clip(airconTemp.getTempValue(), this.fahrenheitRange.getMinimum(), this.fahrenheitRange.getMaximum());
                this.fahrenheitRange.setValue(this.currentTemperature);
                this.updateTemperatureModels(this.dsiToFahrenheit(this.currentTemperature), this.tempStartFahrenheit, this.tempEndFahrenheit, 2);
                break;
            }
        }
    }
}

