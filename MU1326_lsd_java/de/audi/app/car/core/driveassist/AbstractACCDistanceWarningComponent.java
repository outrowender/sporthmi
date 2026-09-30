/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.metrics.DateMetric;
import java.util.Date;
import org.dsi.ifc.cardriverassistance.ACCDistanceWarning;
import org.dsi.ifc.cardriverassistance.ACCViewOptions;

public abstract class AbstractACCDistanceWarningComponent
extends AbstractDSICarDriverAssistanceAdapter
implements RangeListener {
    public static final short CODING_ID = 0;
    private static final String LOGCHANNEL_NAME = "App.Car.DistanceWarning";
    private volatile ACCViewOptions currentViewOptions;
    public static final int STEP_TIME_GAP = 2;
    public static final int OFF_TIME_GAP = 0;
    public static final int MIN_TIME_GAP = 4;
    public static final int MAX_TIME_GAP = 30;
    private static final int SPEEDO_NONE = 0;
    private static final int SPEEDO_HALF = 1;
    private static final int SPEEDO_QUARTER = 2;
    private static final int TIMEGAP_SPEEDO_HALF = 18;
    private static final int TIMEGAP_SPEEDO_QUARTER = 10;
    private RangeModelWatcherTimer distanceModelTimer;

    public AbstractACCDistanceWarningComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void initModels() {
        this.distanceModelTimer = new RangeModelWatcherTimer("Car DistanceWarning", this.getRangeModel(600759), 1000L, this.getLogChannel());
        this.getRangeModel(600759).setRangeListener(this);
        this.getRangeModel(600759).setLimits(4, 30, 2);
    }

    protected void deinitModels() {
        this.getRangeModel(600759).resetListener();
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("[AbstractACCDistanceWarningComponent#keyPressed]", n, n2, true);
        this.getRangeModel(n).fireEvent(n3);
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void decrement(int n, int n2, int n3) {
        this.logModelData("[AbstractACCDistanceWarningComponent#decrement]", n, n2, true);
        this.setDistanceWarning(-n2);
    }

    public void increment(int n, int n2, int n3) {
        this.logModelData("[AbstractACCDistanceWarningComponent#increment]", n, n2, true);
        this.setDistanceWarning(n2);
    }

    private void setDistanceWarning(int n) {
        ACCDistanceWarning aCCDistanceWarning = new ACCDistanceWarning();
        int n2 = this.getRangeModel(600759).getValue() + n;
        aCCDistanceWarning.systemState = n2 > 4;
        n2 = aCCDistanceWarning.systemState ? AbstractACCDistanceWarningComponent.clip(n2, 6, 30) : 0;
        this.distanceModelTimer.setTempValue(n2);
        aCCDistanceWarning.timeGap = (short)n2;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractACCDistanceWarningComponent#setDistanceWarning] dsi.setACCDistanceWarning : warning='%1'", (Object)aCCDistanceWarning);
        }
        this.getDSI().setACCDistanceWarning(aCCDistanceWarning);
    }

    private void updateSpeedoLabel(int n) {
        int n2 = 0;
        if (n == 18) {
            n2 = 1;
        } else if (n == 10) {
            n2 = 2;
        }
        if (this.getChoiceModel(601201).getValue() != n2) {
            this.getChoiceModel(601201).setValue(n2);
        }
    }

    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractACCDistanceWarningComponent#updateACCViewOptions] viewOptions='%1', valid='%2'", (Object)(aCCViewOptions != null ? this.formatViewOptionsLog(aCCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && aCCViewOptions != null) {
            this.currentViewOptions = aCCViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractACCDistanceWarningComponent#updateACCDistanceWarning] warning='%1', valid='%2'", (Object)aCCDistanceWarning, (long)n);
        }
        if (n == 1) {
            int n2 = 4;
            if (aCCDistanceWarning.isSystemState()) {
                n2 = AbstractACCDistanceWarningComponent.clip(aCCDistanceWarning.getTimeGap(), 4, 30);
            }
            this.distanceModelTimer.setValidValue(n2);
            if (n2 == 4) {
                this.getMetricsModel(601240).setStatus(2);
            }
            this.updateSpeedoLabel(n2);
            DateMetric dateMetric = new DateMetric(new Date(n2 * 100), 10);
            this.getMetricsModel(601240).setMetric(dateMetric);
            if (n2 != 4) {
                this.getMetricsModel(601240).setStatus(1);
            }
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{24}, new int[]{51})};
    }

    protected abstract void updateMenuEntryVisibility(ACCViewOptions var1);

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public String getName() {
        return "Car ACC Distance Warning";
    }
}

