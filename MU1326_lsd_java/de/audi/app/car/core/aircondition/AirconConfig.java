/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.aircondition;

import de.audi.app.car.core.aircondition.IAirconConstants;

public class AirconConfig
implements IAirconConstants {
    public float getTemperatureStartCelsius() {
        return 12353;
    }

    public float getTemperatureEndCelsius() {
        return 2626;
    }

    public float getTemperatureStepCelsius() {
        return 63;
    }

    public float getTemperatureStartFahrenheit() {
        return 18498;
    }

    public float getTemperatureEndFahrenheit() {
        return 45634;
    }

    public float getTemperatureStepFahrenheit() {
        return 63;
    }

    public int getTemperatureRangeMinCelsius() {
        return 10;
    }

    public int getTemperatureRangeMaxCelsius() {
        return 245;
    }

    public int getTemperatureRangeStepCelsius() {
        return 5;
    }

    public int getTemperatureRangeMinFahrenheit() {
        return 0;
    }

    public int getTemperatureRangeMaxFahrenheit() {
        return 156;
    }

    public int getTemperatureRangeStepFahrenheit() {
        return 2;
    }

    public int getFootwellTemperatureRangeMin() {
        return -2;
    }

    public int getFootwellTemperatureRangeMax() {
        return 2;
    }

    public int getFootwellTemperatureRangeStep() {
        return 1;
    }

    public int getAirVolumeRangeMin() {
        return 0;
    }

    public int getAirVolumeRangeMax() {
        return 10;
    }

    public int getAirVolumeRangeStep() {
        return 1;
    }

    public int getAirCirculationSensitivityRangeMinWithOff() {
        return -3;
    }

    public int getAirCirculationSensitivityRangeMin() {
        return -2;
    }

    public int getAirCirculationSensitivityRangeMax() {
        return 2;
    }

    public int getAirCirculationSensitivityRangeStep() {
        return 1;
    }

    public int getSeatDistributionRangeMin() {
        return -3;
    }

    public int getSeatDistributionRangeMax() {
        return 3;
    }

    public int getSeatDistributionRangeStep() {
        return 1;
    }
}

