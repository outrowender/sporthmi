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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile DynamicVehicleInfoSCR data = new DynamicVehicleInfoSCR();
    private static final int STATE_NORMAL;
    private static final int STATE_HINT;
    private static final int STATE_WARNING;
    private static final int STATE_ERROR;
    private static final int STATE_TILT;
    private static final int STATE_FROZEN;
    private static final int STATE_INIT;
    private volatile VehicleInfoViewOptions viewOptions;
    private static final int[] tankSegments12l;
    private static final int[] tankSegments24l;
    private static final int MAX_SEGMENTS_BIG_TANK;
    private static final int MAX_SEGMENTS_SMALL_TANK;

    public AbstractAdBlueComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.AdBlue");
    }

    @Override
    protected void initModels() {
        this.getMetricsModel(1865156864).setMetric(new CarDistance(0.0f, 1));
        this.getMetricsModel(1865156864).formatChanged();
        this.getMetricsModel(1848379648).setMetric(new Volume(0.0f, 1));
        this.getMetricsModel(1848379648).formatChanged();
        this.getMetricsModel(1881934080).setMetric(new Volume(0.0f, 1));
        this.getMetricsModel(1881934080).formatChanged();
    }

    @Override
    protected void deinitModels() {
    }

    @Override
    public void updateDynamicVehicleInfoSCR(DynamicVehicleInfoSCR dynamicVehicleInfoSCR, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAdBlueComponent#updateDynamicVehicleInfoSCR] -> data='%1', valid='%2'", (Object)(dynamicVehicleInfoSCR != null ? this.formatViewOptionsLog(dynamicVehicleInfoSCR.toString()) : "null"), (long)n);
        }
        if (n == 1) {
            this.data = dynamicVehicleInfoSCR;
            this.updateValues();
        }
    }

    @Override
    public void updateVehicleInfoViewOptions(VehicleInfoViewOptions vehicleInfoViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAdBlueComponent#updateVehicleInfoViewOptions] -> viewOptions='%1', valid='%1'", (Object)(vehicleInfoViewOptions != null ? this.formatViewOptionsLog(vehicleInfoViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && vehicleInfoViewOptions != null) {
            this.updateMenuEntryVisibility(vehicleInfoViewOptions.getScrInfo());
            this.viewOptions = vehicleInfoViewOptions;
            this.primaryAttributeFirstSetReceived();
        }
    }

    private void updateValues() {
        this.getChoiceModel(1848248576).setValue(this.getAdBlueState());
        this.getChoiceModel(1747585280).setValue(this.isRangeUnitMiles() ? 1 : 0);
        this.getChoiceModel(1730808064).setValue(this.isFuelUnitGallon() ? 1 : 0);
        this.getLabelModel(1797916928).setText(Integer.toString(this.data.getRange()));
        this.updateDistanceMetrics(this.data.getRange(), this.data.getRangeUnit(), 1865156864);
        this.getChoiceModel(1831471360).setValue(this.getTotalNumberOfSegments());
        this.getChoiceModel(1814694144).setValue(this.getCurrentNumberOfSegments());
        this.updateTankSizeMetrics();
        this.updateVolumeMetrics(this.data.getRefillLevelMin(), this.data.getVolumeUnit(), 1848379648);
        this.updateVolumeMetrics(this.data.getRefillLevelMax(), this.data.getVolumeUnit(), 1881934080);
        this.getLabelModel(1781139712).setText(Float.toString(this.data.getRefillLevelMin()));
        this.getLabelModel(1764362496).setText(Float.toString(this.data.getRefillLevelMax()));
    }

    private void updateDistanceMetrics(float f2, int n, int n2) {
        CarDistance carDistance = new CarDistance(f2, n == 0 ? 1 : 2);
        carDistance.setUseInstanceUnit(true);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAdBlueComponent#updateDistanceMetrics] update adBlue range distance metric: distanceValue=%1, unit=%2, model=%3", (Object)String.valueOf(f2), (Object)(n == 0 ? "km" : "mi"), (Object)new Integer(n2));
        }
        this.getMetricsModel(n2).setMetric(carDistance);
        this.getMetricsModel(n2).formatChanged();
    }

    private void updateVolumeMetrics(float f2, int n, int n2) {
        Volume volume = new Volume(f2, this.isFuelUnitGallon() ? 2 : 1);
        volume.setUseInstanceUnit(true);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractAdBlueComponent#updateVolumeMetrics] update adBlue fuel volume metric: volumeValue=%1, unit=%2, model=%3", (Object)String.valueOf(f2), (Object)new Integer(volume.getUnit()), (Object)new Integer(n2));
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
            if (this.data.getTankVolume() <= 16448) {
                this.updateVolumeMetrics(16448, this.data.getVolumeUnit(), -2043934464);
                this.updateVolumeMetrics(49215, this.data.getVolumeUnit(), -2027157248);
                this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), -2010380032);
            } else {
                this.updateVolumeMetrics(49216, this.data.getVolumeUnit(), -2043934464);
                this.updateVolumeMetrics(16448, this.data.getVolumeUnit(), -2027157248);
                this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), -2010380032);
            }
        } else if (this.data.getTankVolume() <= 16449) {
            this.updateVolumeMetrics(16449, this.data.getVolumeUnit(), -2043934464);
            this.updateVolumeMetrics(49216, this.data.getVolumeUnit(), -2027157248);
            this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), -2010380032);
        } else {
            this.updateVolumeMetrics(49217, this.data.getVolumeUnit(), -2043934464);
            this.updateVolumeMetrics(16449, this.data.getVolumeUnit(), -2027157248);
            this.updateVolumeMetrics(0.0f, this.data.getVolumeUnit(), -2010380032);
        }
    }

    private int getTotalNumberOfSegments() {
        if (this.isFuelUnitGallon()) {
            if (this.data.getTankVolume() <= 16448) {
                return 6;
            }
            return 12;
        }
        if (this.data.getTankVolume() <= 16449) {
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

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{11}, new int[]{18})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.viewOptions == null) {
            return "no view options received yet";
        }
        return this.viewOptions.toString();
    }

    protected abstract void updateMenuEntryVisibility(CarViewOption carViewOption) {
    }

    @Override
    public String getName() {
        return "AdBlue";
    }

    static {
        tankSegments12l = new int[]{0, 16, 33, 50, 66, 83, 100};
        tankSegments24l = new int[]{0, 8, 16, 25, 33, 41, 50, 58, 66, 75, 83, 91, 100};
    }
}

