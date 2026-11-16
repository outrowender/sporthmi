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
    private static /*final*/ int STORAGE_AREA_CAR = 1006;
    private static /*final*/ int STORAGE_KEY_DEV_MODE = 900;
    private static /*final*/ int STORAGE_KEY_SIM_VALUES = 901;
    private volatile int lastPersistedDevMode = -1;
    private volatile int lastPersistedSimValues = -1;

    private static /*final*/ int[] SIM_RPM = new int[]{1000, 1500, 2000, 3000, 4000, 5000, 6000, 6500};
    // Max boost % the turbo can reach at each rpm.
    private static /*final*/ int[] SIM_BOOST_LIMIT = new int[]{10, 45, 85, 100, 100, 95, 85, 75};
    // Torque % at full boost for each rpm.
    private static /*final*/ int[] SIM_TORQUE_CURVE = new int[]{45, 70, 95, 100, 100, 90, 78, 70};
    // Share of torque produced from throttle alone, before boost.
    private static /*final*/ float SIM_NA_TORQUE_SHARE = 0.35f;
    private static /*final*/ float SIM_SPOOL_UP_MS = 700.0f;
    private static /*final*/ float SIM_SPOOL_DOWN_MS = 350.0f;
    private static /*final*/ int SIM_DEFAULT_MAX_POWER_KW = 90;
    private float simBoost = 0.0f;
    private long lastSimTime = 0L;

    public SportComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getRangeModel(602115).setLimits(0, 100, 1);
        this.getRangeModel(602112).setLimits(0, 100, 1);
        this.getRangeModel(602111).setLimits(0, 100, 1);
        int savedDevMode = this.getApplication().getFrameworkAccess().getStorageMgr().getInt(STORAGE_AREA_CAR, STORAGE_KEY_DEV_MODE, 0);
        int savedSimValues = this.getApplication().getFrameworkAccess().getStorageMgr().getInt(STORAGE_AREA_CAR, STORAGE_KEY_SIM_VALUES, 0);
        this.lastPersistedDevMode = savedDevMode;
        this.lastPersistedSimValues = savedSimValues;
        this.getChoiceModel(602738).setValue(savedDevMode);
        this.getChoiceModel(602739).setValue(savedSimValues);
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

        if (this.getChoiceModel(602739).getValue() == 1) {
            this.updateSimulatedValues();
        } else {
            this.updateRealValues();
        }

        this.checkConfigurations();
    }

    private void updateRealValues() {
        int torque = this.currentInfoHighFrequent.currentTorque;
        int calculatedTorque = torque * 100 / maxSimulatedTorque;

        float power = this.currentInfoHighFrequent.currentOutputPower;
        int maxPower = this.currentSemiStaticData.maxOutputPower;
        int calculatedPower = Math.round(power * 100.0f / (float)maxPower);
        
        int boost = this.currentInfoHighFrequent.relChargingAirPressure;
        
        this.getRangeModel(602112).setValue(calculatedTorque);
        this.getRangeModel(602115).setValue(calculatedPower);
        this.getRangeModel(602111).setValue(boost);
    }

    private void updateSimulatedValues() {
        int rpm = this.currentInfoHighFrequent.engineSpeed;
        int pedal = this.clampPercent(this.currentInfoHighFrequent.acceleratorPosition & 0xFF);

        float boost = this.updateSimulatedBoost(pedal, rpm);
        int torque = this.simulateTorquePercent(boost, pedal, rpm);
        int power = this.simulatePowerPercent(torque, rpm);

        this.getRangeModel(602112).setValue(torque);
        this.getRangeModel(602115).setValue(power);
        this.getRangeModel(602111).setValue(this.clampPercent(Math.round(boost)));
    }

    private float updateSimulatedBoost(int pedal, int rpm) {
        long now = System.currentTimeMillis();
        long dt = this.lastSimTime == 0L ? 0L : now - this.lastSimTime;
        this.lastSimTime = now;
        if (dt > 500L) {
            dt = 500L;
        }

        float target = pedal * this.interpolate(SIM_RPM, SIM_BOOST_LIMIT, rpm) / 100.0f;
        float spoolMs = target > this.simBoost ? SIM_SPOOL_UP_MS : SIM_SPOOL_DOWN_MS;
        this.simBoost += (target - this.simBoost) * Math.min(1.0f, dt / spoolMs);
        return this.simBoost;
    }

    private int simulateTorquePercent(float boost, int pedal, int rpm) {
        float load = SIM_NA_TORQUE_SHARE * pedal / 100.0f + (1.0f - SIM_NA_TORQUE_SHARE) * boost / 100.0f;
        return this.clampPercent(Math.round(this.interpolate(SIM_RPM, SIM_TORQUE_CURVE, rpm) * load));
    }

    private int simulatePowerPercent(int torquePercent, int rpm) {
        int maxPowerKw = this.currentSemiStaticData.maxOutputPower > 0 ? this.currentSemiStaticData.maxOutputPower : SIM_DEFAULT_MAX_POWER_KW;
        float torqueNm = torquePercent * maxSimulatedTorque / 100.0f;
        float powerKw = torqueNm * rpm / 9549.0f;
        return this.clampPercent(Math.round(powerKw * 100.0f / maxPowerKw));
    }

    private float interpolate(int[] xs, int[] ys, int x) {
        if (x <= xs[0]) {
            return ys[0];
        }
        for (int i = 1; i < xs.length; ++i) {
            if (x <= xs[i]) {
                float t = (float)(x - xs[i - 1]) / (float)(xs[i] - xs[i - 1]);
                return ys[i - 1] + (ys[i] - ys[i - 1]) * t;
            }
        }
        return ys[ys.length - 1];
    }

    private int clampPercent(int value) {
        if (value < 0) {
            return 0;
        }
        return value > 100 ? 100 : value;
    }

    private void checkConfigurations() {
        int devMode = this.getChoiceModel(602738).getValue();
        int simValues = this.getChoiceModel(602739).getValue();
        if (devMode != this.lastPersistedDevMode) {
            this.lastPersistedDevMode = devMode;
            this.getApplication().getFrameworkAccess().getStorageMgr().setInt(STORAGE_AREA_CAR, STORAGE_KEY_DEV_MODE, devMode);
        }
        if (simValues != this.lastPersistedSimValues) {
            this.lastPersistedSimValues = simValues;
            this.getApplication().getFrameworkAccess().getStorageMgr().setInt(STORAGE_AREA_CAR, STORAGE_KEY_SIM_VALUES, simValues);
        }
        if (devMode == 1) {
            this.getLabelModel(602123).setText(this.buildDebugText());
        } else {
            this.getLabelModel(602123).setText("");
        }
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

