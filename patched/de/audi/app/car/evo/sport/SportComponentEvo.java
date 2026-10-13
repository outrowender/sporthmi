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
    private volatile SemiStaticVehicleData currentSemiStaticData;
    private volatile SemiStaticDataViewOptions currentSemiStaticDataViewOptions;
    private volatile DynamicVehicleInfoHighFrequentViewOptions currentDynamicVehicleInfoHighFrequentViewOptions;
    private volatile DynamicVehicleInfoMidFrequent currentMidFrequent;
    private volatile float boostEstimate;
    private volatile float torqueEstimate;
    private volatile float powerEstimate;
    private volatile float idlePhase;

    public SportComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getRangeModel(602115).setLimits(0, 100, 1);
        this.getRangeModel(602112).setLimits(0, 100, 1);
        this.getRangeModel(602111).setLimits(0, 100, 1);
        //this.getLabelModel(602123).setText("sport debug ready");
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

    public void updateDynamicVehicleInfoMidFrequent(DynamicVehicleInfoMidFrequent dynamicVehicleInfoMidFrequent, int n) {
        if (n == 1) {
            this.currentMidFrequent = dynamicVehicleInfoMidFrequent;
            Temperature temperature = new Temperature(dynamicVehicleInfoMidFrequent.gearboxOilTemperature, Temperature.CELSIUS);
            temperature.setUseInstanceUnit(true);
            this.getMetricsModel(602117).setMetric(temperature);
            //this.getLabelModel(602123).setText(this.buildDebugText());
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
        if (this.currentInfoHighFrequent != null) {
            int rpm = this.currentInfoHighFrequent.engineSpeed;
            int pedal = this.currentInfoHighFrequent.acceleratorPosition;

            int wotTorque = this.wotTorquePercent(rpm);
            int tqPct = this.clampPercent(Math.round(wotTorque * pedal / 100.0f));
            int pwPct = this.clampPercent(tqPct * rpm / 4297);

            // idle: engine running, no throttle -> torque floats 8..10% (power stays 0)
            if (pedal == 0 && rpm > 400) {
                this.idlePhase += 0.15f;
                tqPct = 9 + Math.round((float)Math.sin(this.idlePhase));
            }

            // power/torque lag up slowly, fall ~1s (100->0 in ~10 ticks)
            float tqA = (float)tqPct > this.torqueEstimate ? 0.20f : 0.42f;
            float pwA = (float)pwPct > this.powerEstimate ? 0.20f : 0.42f;
            this.torqueEstimate += ((float)tqPct - this.torqueEstimate) * tqA;
            this.powerEstimate += ((float)pwPct - this.powerEstimate) * pwA;
            this.getRangeModel(602112).setValue(this.clampPercent(Math.round(this.torqueEstimate))); // torque (lagged)
            this.getRangeModel(602115).setValue(this.clampPercent(Math.round(this.powerEstimate))); // power (lagged)

            // simulated turbo lag: spool up slowly, dump to pedal instantly on lift
            if ((float)pedal < this.boostEstimate) {
                this.boostEstimate = pedal;
            } else {
                this.boostEstimate += ((float)pedal - this.boostEstimate) * 0.12f;
            }
            this.getRangeModel(602111).setValue(this.clampPercent(Math.round(this.boostEstimate))); // boost (lagged)

            //this.getLabelModel(602123).setText(this.buildDebugText());
        }
    }

    private String buildDebugText() {
        StringBuffer b = new StringBuffer(512);
        DynamicVehicleInfoHighFrequent h = this.currentInfoHighFrequent;
        if (h != null) {
            b.append("SportCompEv").append('\n');
            b.append("longAccele=").append(h.longitudinalAcceleration).append('\n');
            b.append("latAcceler=").append(h.lateralAcceleration).append('\n');
            b.append("yawRate=").append(h.yawRate).append('\n');
            b.append("wheelAngle=").append(h.wheelAngle).append('\n');
            b.append("bkPressure=").append(h.brakePressure).append('\n');

            b.append("enginSpeed=").append(h.engineSpeed).append('\n');
            b.append("powerMeter=").append(h.powermeter).append('\n');
            b.append("outptPower=").append(h.currentOutputPower).append('\n');
            b.append("currTorque=").append(h.currentTorque).append('\n');
            
            b.append("relatBoost=").append(h.relChargingAirPressure).append('\n');
            b.append("absolBoost=").append(h.absChargingAirPressure).append('\n');
            
            b.append("pedalPosit=").append(h.acceleratorPosition).append('\n');
            b.append("vehicSpeed=").append(String.valueOf(h.vehicleSpeed.speedValue)).append('\n');
            b.append("speedValue=").append(String.valueOf(h.realVehicleSpeed.speedValue)).append('\n');
            
            b.append("cycleDista=").append(h.systemCycleDistance).append('\n');            
            b.append("shiftLight=").append(h.shiftLight).append('\n');
        } else {
            b.append("highFreque=null\n");
        }
        SemiStaticVehicleData v = this.currentSemiStaticData;
        if (v != null) {
            b.append("maxBoost=").append(v.maxChargingAirPressure).append('\n');
            b.append("maxPower=").append(v.maxOutputPower).append('\n');
            b.append("maxTorque=").append(v.maxTorque).append('\n');
            b.append("enginDispl=").append(v.engineDisplacement).append('\n');
            b.append("injcSystem=").append(v.typeOfInjectionSystem);
        } else {
            b.append("semiFData=null");
        }
        DynamicVehicleInfoMidFrequent m = this.currentMidFrequent;
        if (m != null) {
            b.append('\n');
            b.append("gearbxTemp=").append(m.gearboxOilTemperature).append('\n');
            b.append("currntGear=").append(m.currentGear);
        } else {
            b.append("midFData=null");
        }
        return b.toString();
    }

    private static final int[] rpmPoints = new int[]{750, 1000, 1400, 4000, 4500, 5000, 5500, 6000};
    private static final int[] tqPercent = new int[]{  0,   50,  100,  100,   96,   92,   89,   86};

    private int wotTorquePercent(int rpm) {
        int last = rpmPoints.length - 1;

        if (rpm <= rpmPoints[0]) {
            return tqPercent[0];
        }

        if (rpm >= rpmPoints[last]) {
            return tqPercent[last];
        }

        for (int i2 = 1; i2 <= last; ++i2){
            if (rpm > rpmPoints[i2]) continue;
            int r0 = rpmPoints[i2 - 1];
            int r1 = rpmPoints[i2];
            int p0 = tqPercent[i2 - 1];
            int p1 = tqPercent[i2];
            return p0 + (p1 - p0) * (rpm - r0) / (r1 - r0);
        }

        return tqPercent[last];
    }

    private int clampPercent(int n) {
        if (n < 0) {
            return 0;
        }
        if (n > 100) {
            return 100;
        }
        return n;
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

