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
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private volatile ACCViewOptions currentViewOptions;
    public static final int STEP_TIME_GAP;
    public static final int OFF_TIME_GAP;
    public static final int MIN_TIME_GAP;
    public static final int MAX_TIME_GAP;
    private static final int SPEEDO_NONE;
    private static final int SPEEDO_HALF;
    private static final int SPEEDO_QUARTER;
    private static final int TIMEGAP_SPEEDO_HALF;
    private static final int TIMEGAP_SPEEDO_QUARTER;
    private RangeModelWatcherTimer distanceModelTimer;

    public AbstractACCDistanceWarningComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.DistanceWarning");
    }

    @Override
    protected void initModels() {
        this.distanceModelTimer = new RangeModelWatcherTimer("Car DistanceWarning", this.getRangeModel(-1221981952), 0, this.getLogChannel());
        this.getRangeModel(-1221981952).setRangeListener(this);
        this.getRangeModel(-1221981952).setLimits(4, 30, 2);
    }

    @Override
    protected void deinitModels() {
        this.getRangeModel(-1221981952).resetListener();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        this.logModelData("[AbstractACCDistanceWarningComponent#keyPressed]", n, n2, true);
        this.getRangeModel(n).fireEvent(n3);
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void decrement(int n, int n2, int n3) {
        this.logModelData("[AbstractACCDistanceWarningComponent#decrement]", n, n2, true);
        this.setDistanceWarning(-n2);
    }

    @Override
    public void increment(int n, int n2, int n3) {
        this.logModelData("[AbstractACCDistanceWarningComponent#increment]", n, n2, true);
        this.setDistanceWarning(n2);
    }

    private void setDistanceWarning(int n) {
        ACCDistanceWarning aCCDistanceWarning = new ACCDistanceWarning();
        int n2 = this.getRangeModel(-1221981952).getValue() + n;
        aCCDistanceWarning.systemState = n2 > 4;
        n2 = aCCDistanceWarning.systemState ? AbstractACCDistanceWarningComponent.clip(n2, 6, 30) : 0;
        this.distanceModelTimer.setTempValue(n2);
        aCCDistanceWarning.timeGap = (short)n2;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractACCDistanceWarningComponent#setDistanceWarning] dsi.setACCDistanceWarning : warning='%1'", (Object)aCCDistanceWarning);
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
        if (this.getChoiceModel(1898711296).getValue() != n2) {
            this.getChoiceModel(1898711296).setValue(n2);
        }
    }

    @Override
    public void updateACCViewOptions(ACCViewOptions aCCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractACCDistanceWarningComponent#updateACCViewOptions] viewOptions='%1', valid='%2'", (Object)(aCCViewOptions != null ? this.formatViewOptionsLog(aCCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && aCCViewOptions != null) {
            this.currentViewOptions = aCCViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateACCDistanceWarning(ACCDistanceWarning aCCDistanceWarning, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractACCDistanceWarningComponent#updateACCDistanceWarning] warning='%1', valid='%2'", (Object)aCCDistanceWarning, (long)n);
        }
        if (n == 1) {
            int n2 = 4;
            if (aCCDistanceWarning.isSystemState()) {
                n2 = AbstractACCDistanceWarningComponent.clip(aCCDistanceWarning.getTimeGap(), 4, 30);
            }
            this.distanceModelTimer.setValidValue(n2);
            if (n2 == 4) {
                this.getMetricsModel(-1741944576).setStatus(2);
            }
            this.updateSpeedoLabel(n2);
            DateMetric dateMetric = new DateMetric(new Date(n2 * 100), 10);
            this.getMetricsModel(-1741944576).setMetric(dateMetric);
            if (n2 != 4) {
                this.getMetricsModel(-1741944576).setStatus(1);
            }
        }
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{24}, new int[]{51})};
    }

    protected abstract void updateMenuEntryVisibility(ACCViewOptions aCCViewOptions) {
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    @Override
    public String getName() {
        return "Car ACC Distance Warning";
    }
}

