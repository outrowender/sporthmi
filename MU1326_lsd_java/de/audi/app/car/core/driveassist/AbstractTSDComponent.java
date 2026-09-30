/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.driveassist;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.driveassist.AbstractDSICarDriverAssistanceAdapter;
import de.audi.app.car.core.app.IRangeModelSyncListener;
import de.audi.app.car.core.app.IRangeModelSyncParameterAccess;
import de.audi.app.car.core.app.RangeModelSynchronizer;
import de.audi.app.car.core.helper.SpeedWarningManualHandler;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.metrics.Speed;
import org.dsi.ifc.cardriverassistance.TSDRoadSignFilter;
import org.dsi.ifc.cardriverassistance.TSDViewOptions;
import org.dsi.ifc.global.CarBCSpeed;

public abstract class AbstractTSDComponent
extends AbstractDSICarDriverAssistanceAdapter
implements ChoiceListener,
RangeListener,
IRangeModelSyncListener {
    public static final short CODING_ID = 30;
    private static final String LOGCHANNEL_NAME = "App.Car.TSD";
    private volatile TSDViewOptions currViewOptions;
    private ModelGroup trailerModelGroup;
    private final SpeedWarningManualHandler speedLimitHandler;
    private final RangeModelSynchronizer trailerSpeedRangeModelSync;
    public static final int OFF_KMH = 50;
    public static final int MAX_KMH = 130;
    public static final int STEP_KMH = 10;
    public static final int OFF_MPH = 30;
    public static final int MAX_MPH = 80;
    public static final int STEP_MPH = 5;
    public static final int SHOW_OFF = 0;
    public static final int SHOW_UNIT = 1;
    private static final String TEXT_KM_PER_HOUR = " km/h";
    private static final String TEXT_MILES_PER_HOUR = " mph";

    public AbstractTSDComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.speedLimitHandler = new SpeedWarningManualHandler(50, 130, 10, 30, 80, 5, iCarApplication.getFrameworkAccess().getLogChannel(LOGCHANNEL_NAME));
        this.trailerSpeedRangeModelSync = new RangeModelSynchronizer("TrailerSpeedRange", this, 1000L, this.getLogChannel());
    }

    protected void initModels() {
        this.getChoiceModel(600410).setChoiceListener(this);
        this.getRangeModel(600463).setLimits(50, 130, 10, 50);
        this.getRangeModel(600463).setRangeListener(this);
        this.trailerSpeedRangeModelSync.addWatchedAttribute(53, true, this.getRangeModel(600463));
        Speed speed = new Speed(130.0f, 1);
        speed.setUseInstanceUnit(true);
        this.getMetricsModel(601104).setMetric(speed);
        this.getMetricsModel(601104).formatChanged();
        this.trailerModelGroup = new ModelGroup();
        this.trailerModelGroup.add(this.getMetricsModel(601104));
        this.trailerModelGroup.add(this.getRangeModel(600463));
        this.trailerModelGroup.add(this.getChoiceModel(601105));
    }

    protected void deinitModels() {
        this.getChoiceModel(600410).resetListener();
        this.trailerSpeedRangeModelSync.clear();
        this.getRangeModel(600463).resetListener();
    }

    private void itemSelectedTrailerDetection(boolean bl) {
        TSDRoadSignFilter tSDRoadSignFilter = new TSDRoadSignFilter(bl);
        this.getLogChannel().log(1000000, "dsi.setTSDRoadSignFilter(%1)", (Object)tSDRoadSignFilter);
        this.getDSI().setTSDRoadSignFilter(tSDRoadSignFilter);
    }

    public void keyPressed(int n, int n2, int n3) {
        switch (n) {
            case 600463: {
                this.getLogChannel().log(1000000, "[AbstractTSDComponent#keyPressed] modelID = TRAFFICSIGN_TRAILER_SPEED_LIMIT_RANGE with keyID = %1 and terminalID = %2", (long)n2, (long)n3);
                this.getRangeModel(600463).fireEvent(n3);
                break;
            }
            default: {
                this.getLogChannel().log(1000000, "[AbstractTSDComponent#keyPressed] modelID = %1 with keyID = %2 and terminalID = %3", (long)n, (long)n2, (long)n3);
            }
        }
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 600410: {
                this.itemSelectedTrailerDetection(n2 == 1);
                break;
            }
            default: {
                this.logModelData("itemSelected:", n, n2, false);
            }
        }
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void decrement(int n, int n2, int n3) {
        this.logModelData("[AbstractTSDComponent#decrement]", n, n2, true);
        this.trailerSpeedRangeModelSync.notifyDecrement(53, n2);
    }

    public void increment(int n, int n2, int n3) {
        this.logModelData("[AbstractTSDComponent#increment]", n, n2, true);
        this.trailerSpeedRangeModelSync.notifyIncrement(53, n2);
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{35}, new int[]{53, 43})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void updateTSDViewOptions(TSDViewOptions tSDViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractTSDComponent#updateTSDViewOptions] tSDViewOptions=%1, valid=%2", (Object)(tSDViewOptions == null ? "null" : this.formatViewOptionsLog(tSDViewOptions.toString())), (long)n);
        }
        if (n == 1 && tSDViewOptions != null) {
            this.currViewOptions = tSDViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateTSDRoadSignFilter(TSDRoadSignFilter tSDRoadSignFilter, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractTSDComponent#updateTSDRoadSignFilter] roadSignFilter=%1, valid=%2", (Object)tSDRoadSignFilter, (long)n);
        }
        if (n == 1) {
            this.getChoiceModel(600410).setValue(tSDRoadSignFilter.trailerLimits ? 1 : 0);
        }
    }

    public void updateTSDTrailerDetection(boolean bl, int n) {
        this.getLogChannel().log(1000000, "[AbstractTSDComponent#updateTSDTrailerDetection] trailerDetection=%1, valid=%2", bl, (long)n);
    }

    public void updateTSDTrailerSpeedLimit(CarBCSpeed carBCSpeed, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractTSDComponent#updateTSDTrailerSpeedLimit] speed=%1, valid=%2", (Object)carBCSpeed, (long)n);
        }
        if (n == 1) {
            Float f2 = new Float(carBCSpeed.getSpeedValue());
            this.speedLimitHandler.setCurrentValues(carBCSpeed.getSpeedValueState() == 1, f2.intValue(), carBCSpeed.getSpeedUnit());
            boolean bl = this.speedLimitHandler.unitHasChanged();
            if (bl) {
                this.getRangeModel(600463).setLimits(this.speedLimitHandler.getOffValue(), this.speedLimitHandler.getMaxValue(), this.speedLimitHandler.getStepValue(), this.speedLimitHandler.getSpeedWarningValue());
                this.updateSpeedLimitMetrics(this.speedLimitHandler.getMaxValue(), this.speedLimitHandler.getSpeedWarningUnit(), 601104, bl);
            }
            this.updateSpeedLimitMetrics(this.speedLimitHandler.getSpeedWarningValue(), this.speedLimitHandler.getSpeedWarningUnit(), 601103, bl);
            this.trailerSpeedRangeModelSync.notifyUpdateReceived(53, this.speedLimitHandler.getSpeedWarningValue());
        }
    }

    public void setDSIParameter(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        CarBCSpeed carBCSpeed = new CarBCSpeed();
        Integer n = new Integer(iRangeModelSyncParameterAccess.getCurrentValue() > this.speedLimitHandler.getOffValue() ? iRangeModelSyncParameterAccess.getCurrentValue() : 0);
        carBCSpeed.speedValue = n.floatValue();
        carBCSpeed.speedUnit = this.speedLimitHandler.getSpeedWarningUnit();
        carBCSpeed.speedValueState = 1;
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractTSDComponent#setDSIParameter] dsi.setTSDTrailerSpeedLimit(%1)", (Object)carBCSpeed);
        }
        this.getDSI().setTSDTrailerSpeedLimit(carBCSpeed);
    }

    public void updateRangeModelByTurningRotary(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        this.updateRangeModel(iRangeModelSyncParameterAccess);
    }

    public void updateRangeModelByDSINotitification(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        this.updateRangeModel(iRangeModelSyncParameterAccess);
    }

    private void updateRangeModel(IRangeModelSyncParameterAccess iRangeModelSyncParameterAccess) {
        if (iRangeModelSyncParameterAccess.getCurrentValue() == this.speedLimitHandler.getOffValue()) {
            this.getChoiceModel(601105).setValue(0);
        } else {
            this.getChoiceModel(601105).setValue(1);
        }
        if (this.getLogChannel().isInfo()) {
            this.logModelData("[AbstractTSDComponent#updateRangeModel]", iRangeModelSyncParameterAccess.getRangeModelID(), iRangeModelSyncParameterAccess.getCurrentValue(), true);
        }
        this.getRangeModel(iRangeModelSyncParameterAccess.getRangeModelID()).setValue(iRangeModelSyncParameterAccess.getCurrentValue());
        this.trailerModelGroup.flush();
    }

    protected abstract void updateMenuEntryVisibility(TSDViewOptions var1);

    public String getName() {
        return "Traffic sign detection";
    }

    private void updateSpeedLimitMetrics(int n, int n2, int n3, boolean bl) {
        Speed speed = new Speed(n, n2 == 0 ? 1 : 2);
        speed.setUseInstanceUnit(true);
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractTSDComponent#updateSpeedLimitMetrics] speedValue=%1, unit=%2, model=%3", (Object)new Integer(n), (Object)(n2 == 0 ? TEXT_KM_PER_HOUR : TEXT_MILES_PER_HOUR), (Object)new Integer(n3));
        }
        this.getMetricsModel(n3).setMetric(speed);
        if (bl) {
            this.getMetricsModel(n3).formatChanged();
        }
    }
}

