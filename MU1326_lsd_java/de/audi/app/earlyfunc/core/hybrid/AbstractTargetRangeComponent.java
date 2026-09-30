/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.util.CarDistance;
import de.audi.atip.metrics.AbstractMetrics;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCCurrentRange;

public abstract class AbstractTargetRangeComponent
extends AbstractDSICarKombiAdapter {
    private BCViewOptions bcViewOpts;
    private static final String LOGCHANNEL_NAME = "App.Car.Charge.TargetRange";
    public static final short CODING_ID = 41;

    public AbstractTargetRangeComponent(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
        this.getLogChannel().log(1000000, "Initiate TargetRangeComponent");
    }

    public AbstractTargetRangeComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    public String getName() {
        return null;
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{8, 9})};
    }

    public String getCurrentViewOptions() {
        return null;
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "AbstractTargetRangeComponent#updateBatteryControlViewOptions(%1), valid=%2", (Object)(bCViewOptions != null ? this.formatViewOptionsLog(bCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && bCViewOptions != null) {
            this.bcViewOpts = bCViewOptions;
            this.updateMenuEntryVisibility(this.bcViewOpts);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        this.getLogChannel().log(1000000, "AbstractTargetRangeComponent#updateBCCurrentRange1: currentRange=%1, validFlag=%2", (Object)carBCCurrentRange, (long)n);
        if (n == 1 && this.bcViewOpts.getConfiguration() != null && this.bcViewOpts.getConfiguration().primaryEngineType == 3) {
            this.refreshBCCurrentRangeDistanceMetric(carBCCurrentRange);
            this.getLogChannel().log(1000000, "AbstractTargetRangeComponent#updateBCCurrentRange1: currentRange.getState() is %1", (long)carBCCurrentRange.getState());
            this.updateVisibilityForRangeAtStateChange(carBCCurrentRange.getState());
        }
    }

    public void updateBCCurrentRange2(CarBCCurrentRange carBCCurrentRange, int n) {
        this.getLogChannel().log(1000000, "AbstractTargetRangeComponent#updateBCCurrentRange2: currentRange=%1, validFlag=%2", (Object)carBCCurrentRange, (long)n);
        if (n == 1 && this.bcViewOpts.getConfiguration() != null && this.bcViewOpts.getConfiguration().secondaryEngineType == 3) {
            this.refreshBCCurrentRangeDistanceMetric(carBCCurrentRange);
            this.getLogChannel().log(1000000, "AbstractTargetRangeComponent#updateBCCurrentRange2: currentRange.getState() is %1", (long)carBCCurrentRange.getState());
            this.updateVisibilityForRangeAtStateChange(carBCCurrentRange.getState());
        }
    }

    private void refreshBCCurrentRangeDistanceMetric(CarBCCurrentRange carBCCurrentRange) {
        if (carBCCurrentRange.getState() == 1) {
            AbstractMetrics abstractMetrics = null;
            if (carBCCurrentRange.getCurrentRangeUnit() == 0) {
                abstractMetrics = new CarDistance(carBCCurrentRange.getCurrentRangeValue(), 1);
            } else if (carBCCurrentRange.getCurrentRangeUnit() == 1) {
                CarDistance.setSystemUnit(2);
                abstractMetrics = new CarDistance(carBCCurrentRange.getCurrentRangeValue(), 2);
            }
            abstractMetrics.setUseInstanceUnit(true);
            this.getMetricsModel(2100379).setMetric(abstractMetrics);
            this.getMetricsModel(2100379).formatChanged();
        }
    }

    protected abstract void updateMenuEntryVisibility(BCViewOptions var1);

    protected abstract void updateVisibilityForRangeAtStateChange(int var1);
}

