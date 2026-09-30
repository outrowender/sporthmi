/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.AbstractDSICarVehicleStatesAdapter;
import de.audi.app.car.common.util.CarDistance;
import de.audi.atip.metrics.Volume;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoSCR;
import org.dsi.ifc.carvehiclestates.VehicleInfoViewOptions;
import org.dsi.ifc.global.CarViewOption;

public abstract class AbstractAdBlueComponent
extends AbstractDSICarVehicleStatesAdapter {
    public static final short CODING_ID = 53;
    private static final String LOGCHANNEL_NAME = "App.Car.AdBlue";
    private volatile DynamicVehicleInfoSCR data = new DynamicVehicleInfoSCR();
    private static final int STATE_NORMAL = 0;
    private static final int STATE_HINT = 1;
    private static final int STATE_WARNING = 2;
    private static final int STATE_ERROR = 3;
    private static final int STATE_TILT = 4;
    private static final int STATE_FROZEN = 5;
    private static final int STATE_INIT = 6;
    private volatile VehicleInfoViewOptions viewOptions;
    private static final int[] tankSegments12l = new int[]{0, 16, 33, 50, 66, 83, 100};
    private static final int[] tankSegments24l = new int[]{0, 8, 16, 25, 33, 41, 50, 58, 66, 75, 83, 91, 100};
    private static final int MAX_SEGMENTS_BIG_TANK = 12;
    private static final int MAX_SEGMENTS_SMALL_TANK = 6;

    public AbstractAdBlueComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.getMetricsModel(601199).setMetric(new CarDistance(0.0f, 1));
        this.getMetricsModel(601199).formatChanged();
        this.getMetricsModel(601198).setMetric(new Volume(0.0f, 1));
        this.getMetricsModel(601198).formatChanged();
        this.getMetricsModel(601200).setMetric(new Volume(0.0f, 1));
        this.getMetricsModel(601200).formatChanged();
    }

    protected void deinitModels() {
    }

    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAdBlueComponent#updateDynamicVehicleInfoSCR] -> data='%1', valid='%2'", (Object)(dynamicVehicleInfoSCR != null ? this.formatViewOptionsLog(dynamicVehicleInfoSCR.toString()) : "null"), (long)n);
        }
        if (n == 1) {
            this.data = dynamicVehicleInfoSCR;
            this.updateValues();
        }
    }

    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAdBlueComponent#updateVehicleInfoViewOptions] -> viewOptions='%1', valid='%1'", (Object)(vehicleInfoViewOptions != null ? this.formatViewOptionsLog(vehicleInfoViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && vehicleInfoViewOptions != null) {
            this.updateMenuEntryVisibility(vehicleInfoViewOptions.getScrInfo());
            this.viewOptions = vehicleInfoViewOptions;
            this.primaryAttributeFirstSetReceived();
        }
    }

    private void updateValues() {
        this.getChoiceModel(600686).setValue(this.getAdBlueState());
        this.getChoiceModel(600680).setValue(this.isRangeUnitMiles() ? 1 : 0);
        this.getChoiceModel(600679).setValue(this.isFuelUnitGallon() ? 1 : 0);
        this.getLabelModel(600683).setText(Integer.toString(this.data.getRange()));
        this.updateDistanceMetrics(this.data.getRange(), this.data.getRangeUnit(), 601199);
        this.getChoiceModel(600685).setValue(this.getTotalNumberOfSegments());
        this.getChoiceModel(600684).setValue(this.getCurrentNumberOfSegments());
        this.updateTankSizeMetrics();
        this.updateVolumeMetrics(this.data.getRefillLevelMin(), this.data.getVolumeUnit(), 601198);
        this.updateVolumeMetrics(this.data.getRefillLevelMax(), this.data.getVolumeUnit(), 601200);
        this.getLabelModel(600682).setText(Float.toString(this.data.getRefillLevelMin()));
        this.getLabelModel(600681).setText(Float.toString(this.data.getRefillLevelMax()));
    }

    private void updateDistanceMetrics(float f2, int n, int n2) {
        CarDistance carDistance = new CarDistance(f2, n == 0 ? 1 : 2);
        carDistance.setUseInstanceUnit(true);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAdBlueComponent#updateDistanceMetrics] update adBlue range distance metric: distanceValue=%1, unit=%2, model=%3", (Object)String.valueOf(f2), (Object)(n == 0 ? "km" : "mi"), (Object)new Integer(n2));
        }
        this.getMetricsModel(n2).setMetric(carDistance);
        this.getMetricsModel(n2).formatChanged();
    }

    private void updateVolumeMetrics(float f2, int n, int n2) {
        Volume volume = new Volume(f2, this.isFuelUnitGallon() ? 2 : 1);
        volume.setUseInstanceUnit(true);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractAdBlueComponent#updateVolumeMetrics] update adBlue fuel volume metric: volumeValue=%1, unit=%2, model=%3", (Object)String.valueOf(f2), (Object)new Integer(volume.getUnit()), (Object)new Integer(n2));
        }
        this.getMetricsModel(n2).setMetric(volume);
        this.getMetricsModel(n2).formatChanged();
    }

    private int getAdBlueState() {
        switch (this.data.getStatus()) {
            case 1: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 3: {
                return 2;
            }
            case 7: {
                return 2;
            }
            case 5: {
                return 4;
            }
            case 6: {
                return 5;
            }
            case 0: {
                return 6;
            }
        }
        return 3;
    }

    private void updateTankSizeMetrics() {
        if (this.isFuelUnitGallon()) {
            if (this.data.getTankVolume() <= 3.0f) {
                this.updateVolumeMetrics(3.0f, this.data.getVolumeUnit(), 601222);
                this.updateVolumeMetrics(1.5f, this.data.getVolumeUnit(), 601223);
                this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), 601224);
            } else {
                this.updateVolumeMetrics(6.0f, this.data.getVolumeUnit(), 601222);
                this.updateVolumeMetrics(3.0f, this.data.getVolumeUnit(), 601223);
                this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), 601224);
            }
        } else if (this.data.getTankVolume() <= 12.0f) {
            this.updateVolumeMetrics(12.0f, this.data.getVolumeUnit(), 601222);
            this.updateVolumeMetrics(6.0f, this.data.getVolumeUnit(), 601223);
            this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), 601224);
        } else {
            this.updateVolumeMetrics(24.0f, this.data.getVolumeUnit(), 601222);
            this.updateVolumeMetrics(12.0f, this.data.getVolumeUnit(), 601223);
            this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), 601224);
        }
    }

    private int getTotalNumberOfSegments() {
        if (this.isFuelUnitGallon()) {
            if (this.data.getTankVolume() <= 3.0f) {
                return 6;
            }
            return 12;
        }
        if (this.data.getTankVolume() <= 12.0f) {
            return 6;
        }
        return 12;
    }

    private int getCurrentNumberOfSegments() {
        byte by = this.data.getLevel();
        boolean bl = this.getTotalNumberOfSegments() == 12;
        int[] nArray = bl ? tankSegments24l : tankSegments12l;
        int n = bl ? 12 : 6;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (by > nArray[i2]) continue;
            return i2;
        }
        return n;
    }

    private boolean isFuelUnitGallon() {
        return this.data.getVolumeUnit() == 4;
    }

    private boolean isRangeUnitMiles() {
        return this.data.getRangeUnit() == 1;
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{11}, new int[]{18})};
    }

    public String getCurrentViewOptions() {
        if (this.viewOptions == null) {
            return "no view options received yet";
        }
        return this.viewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(CarViewOption var1);

    public String getName() {
        return "AdBlue";
    }
}

