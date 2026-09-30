/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

import de.esolutions.fw.comm.asi.hmisync.car.service.WheelPressures;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelStates;
import de.esolutions.fw.comm.asi.hmisync.car.service.WheelTemperatures;

public class TireDisplayData {
    public WheelStates wheelStates;
    public WheelPressures wheelPressures;
    public WheelPressures requiredWheelPressures;
    public WheelTemperatures wheelTemperatures;

    public WheelStates getWheelStates() {
        return this.wheelStates;
    }

    public void setWheelStates(WheelStates wheelStates) {
        this.wheelStates = wheelStates;
    }

    public WheelPressures getWheelPressures() {
        return this.wheelPressures;
    }

    public void setWheelPressures(WheelPressures wheelPressures) {
        this.wheelPressures = wheelPressures;
    }

    public WheelPressures getRequiredWheelPressures() {
        return this.requiredWheelPressures;
    }

    public void setRequiredWheelPressures(WheelPressures wheelPressures) {
        this.requiredWheelPressures = wheelPressures;
    }

    public WheelTemperatures getWheelTemperatures() {
        return this.wheelTemperatures;
    }

    public void setWheelTemperatures(WheelTemperatures wheelTemperatures) {
        this.wheelTemperatures = wheelTemperatures;
    }

    public TireDisplayData() {
        this.wheelStates = null;
        this.wheelPressures = null;
        this.requiredWheelPressures = null;
        this.wheelTemperatures = null;
    }

    public TireDisplayData(WheelStates wheelStates, WheelPressures wheelPressures, WheelPressures wheelPressures2, WheelTemperatures wheelTemperatures) {
        this.wheelStates = wheelStates;
        this.wheelPressures = wheelPressures;
        this.requiredWheelPressures = wheelPressures2;
        this.wheelTemperatures = wheelTemperatures;
    }

    public String toString() {
        return "TireDisplayData{" + "wheelStates=" + this.wheelStates + ", wheelPressures=" + this.wheelPressures + ", requiredWheelPressures=" + this.requiredWheelPressures + ", wheelTemperatures=" + this.wheelTemperatures + "}";
    }
}

