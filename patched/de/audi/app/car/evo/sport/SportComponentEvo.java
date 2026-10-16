/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.sport;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import de.audi.atip.metrics.Temperature;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequent;
import org.dsi.ifc.carvehiclestates.SemiStaticDataViewOptions;
import org.dsi.ifc.carvehiclestates.SemiStaticVehicleData;

public class SportComponentEvo
extends AbstractDSICarVehicleStatesAdapter {
    private static /*final*/ String LOGCHANNEL_NAME = "App.Car.Sport";
    public static /*final*/ short CODING_ID = 52;
    private volatile DynamicVehicleInfoHighFrequent currentInfoHighFrequent;
    private volatile DynamicVehicleInfoHighFrequentViewOptions currentDynamicVehicleInfoHighFrequentViewOptions;
    private volatile SemiStaticVehicleData currentSemiStaticData;
    private volatile SemiStaticDataViewOptions currentSemiStaticDataViewOptions;
    private volatile DynamicVehicleInfoMidFrequent currentMidFrequent;
    private volatile int maxSimulatedTorque = 250;

    public SportComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getRangeModel(602115).setLimits(0, 100, 1);
        this.getRangeModel(602112).setLimits(0, 100, 1);
        this.getRangeModel(602111).setLimits(0, 100, 1);
    }

    protected void deinitModels() { }

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

    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        if (n == 1) {
            this.currentMidFrequent = dynamicVehicleInfoMidFrequent;
            Temperature temperature = new Temperature(dynamicVehicleInfoMidFrequent.gearboxOilTemperature, Temperature.CELSIUS); // TODO: fix temperature units
            temperature.setUseInstanceUnit(true);
            this.getMetricsModel(602117).setMetric(temperature);
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
            this.calculateMissingStaticValues();
        }
    }

    private void calculateMissingStaticValues() {
        if (this.currentSemiStaticData == null) { 
            return; 
        }

        if (this.currentSemiStaticData.maxTorque > 0) {
            maxSimulatedTorque = this.currentSemiStaticData.maxTorque;
            return;
        }

        if (this.currentSemiStaticData.engineDisplacement == 2.0f) {
            maxSimulatedTorque = 350;
        } else {
            maxSimulatedTorque = 250;
        }
    }


    private void updateVisibleValues() {
        if (this.currentInfoHighFrequent == null || this.currentSemiStaticData == null) { 
            return;
        }

        int torque = this.currentInfoHighFrequent.currentTorque;
        int calculatedTorque = torque * 100 / maxSimulatedTorque;

        float power = this.currentInfoHighFrequent.currentOutputPower;
        int maxPower = this.currentSemiStaticData.maxOutputPower;
        int calculatedPower = Math.round(power * 100.0f / (float)maxPower);
        
        int boost = this.currentInfoHighFrequent.relChargingAirPressure;
        
        this.getRangeModel(602112).setValue(calculatedTorque);
        this.getRangeModel(602115).setValue(calculatedPower);
        this.getRangeModel(602111).setValue(boost);

        this.getLabelModel(602123).setText(this.buildDebugText());
    }

    private String buildDebugText() {
        StringBuffer b = new StringBuffer(512);

        SemiStaticVehicleData v = this.currentSemiStaticData;
        if (v != null) {
            b.append("maxBoost=").append(v.maxChargingAirPressure).append('\n');
            b.append("maxPower=").append(v.maxOutputPower).append('\n');
            b.append("maxTorque=").append(v.maxTorque).append('\n');
            b.append("maxSimulatedTorque=").append(maxSimulatedTorque).append('\n');
            b.append("engineSize=").append(v.engineDisplacement).append('\n');
        }

        DynamicVehicleInfoHighFrequent h = this.currentInfoHighFrequent;
        if (h != null) {
            b.append("longAccel=").append(h.longitudinalAcceleration).append('\n');
            b.append("latAccel=").append(h.lateralAcceleration).append('\n');
            b.append("yawRate=").append(h.yawRate).append('\n');

            b.append("pedalPosition=").append(h.acceleratorPosition).append('\n');
            b.append("engineSpeed=").append(h.engineSpeed).append('\n');
            b.append("carSpeed=").append(String.valueOf(h.vehicleSpeed.speedValue)).append('\n');
            
            b.append("boostRelative=").append(h.relChargingAirPressure).append('\n');
            b.append("boostAbsolute=").append(h.absChargingAirPressure).append('\n');            
            
            b.append("powerMeter=").append(h.powermeter).append('\n');
            b.append("outputPower=").append(h.currentOutputPower).append('\n');
            b.append("currentTorque=").append(h.currentTorque).append('\n');         
        }

        DynamicVehicleInfoMidFrequent m = this.currentMidFrequent;
        if (m != null) {
            b.append("gearboxOilTemp=").append(m.gearboxOilTemperature).append('\n');
            b.append("currentGear=").append(m.currentGear);
        }
        return b.toString();
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{16, 12}, new int[]{17, 14, 15})};
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

