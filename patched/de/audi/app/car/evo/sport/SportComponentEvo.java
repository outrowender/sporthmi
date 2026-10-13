/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.sport;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;
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

    public SportComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getRangeModel(602115).setLimits(0, 100, 1);
        this.getRangeModel(602112).setLimits(0, 100, 1);
        this.getRangeModel(602111).setLimits(0, 100, 1);
        this.getLabelModel(602123).setText("sport debug ready");
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

            this.getRangeModel(602115).setValue(pwPct); // power
            this.getRangeModel(602112).setValue(tqPct); // torque
            this.getRangeModel(602111).setValue(pedal); // boost

            this.getLabelModel(602123).setText(this.buildDebugText());
        }
    }

    private String buildDebugText() {
        StringBuffer b = new StringBuffer(512);
        DynamicVehicleInfoHighFrequent h = this.currentInfoHighFrequent;
        if (h != null) {
            b.append("longitudinalAcceleration=").append(h.longitudinalAcceleration).append('\n');
            b.append("             engineSpeed=").append(h.engineSpeed).append('\n');
            b.append("              powermeter=").append(h.powermeter).append('\n');
            b.append("     lateralAcceleration=").append(h.lateralAcceleration).append('\n');
            b.append("  relChargingAirPressure=").append(h.relChargingAirPressure).append('\n');
            b.append("  absChargingAirPressure=").append(h.absChargingAirPressure).append('\n');
            b.append("      currentOutputPower=").append(h.currentOutputPower).append('\n');
            b.append("                 yawRate=").append(h.yawRate).append('\n');
            b.append("           brakePressure=").append(h.brakePressure).append('\n');
            b.append("              wheelAngle=").append(h.wheelAngle).append('\n');
            b.append("     acceleratorPosition=").append(h.acceleratorPosition).append('\n');
            b.append("            vehicleSpeed=").append(String.valueOf(h.vehicleSpeed)).append('\n');
            b.append("           currentTorque=").append(h.currentTorque).append('\n');
            b.append("              sysCycDist=").append(h.systemCycleDistance).append('\n');
            b.append("     systemCycleDistance=").append(h.torqueDistributionFrontLeft).append('\n');
            b.append("        realVehicleSpeed=").append(String.valueOf(h.realVehicleSpeed)).append('\n');
            b.append("              shiftLight=").append(h.shiftLight).append('\n');
            b.append("  relAllWheelDriveTorque=").append(h.relAllWheelDriveTorque).append('\n');
        } else {
            b.append("                highFreq=null\n");
        }
        SemiStaticDataViewOptions v = this.currentSemiStaticDataViewOptions;
        if (v != null) {
            b.append("  maxChargingAirPressure=").append(String.valueOf(v.maxChargingAirPressure)).append('\n');
            b.append("          maxOutputPower=").append(String.valueOf(v.maxOutputPower)).append('\n');
            b.append("               maxTorque=").append(String.valueOf(v.maxTorque)).append('\n');
            b.append("      engineDisplacement=").append(String.valueOf(v.engineDisplacement)).append('\n');
            b.append("   typeOfInjectionSystem=").append(String.valueOf(v.typeOfInjectionSystem));
        } else {
            b.append("            semiStaticVO=null");
        }
        return b.toString();
    }

    private static final int[] rpmPoints = new int[]{750, 1000, 1400, 4000, 4500, 5000, 5500, 6000};
    private static final int[] tqPercent = new int[]{  0,   50,  100,  100,   96,   86,   78,   71};

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
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{16, 12}, new int[]{17, 14})};
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

