/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent$AuxHeaterButtonListener;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent$AuxHeaterChoiceListener;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent$AuxHeaterMetricsListener;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent$AuxHeaterRangeListener;
import de.audi.app.car.core.auxheater.AbstractAuxheaterComponent$AuxheaterRangeToChoiceModelMapper;
import de.audi.app.car.core.auxheater.AbstractDSICarAuxheaterCoolerAdapter;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.msg.MsgListener;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerViewOptions;

public abstract class AbstractAuxheaterComponent
extends AbstractDSICarAuxheaterCoolerAdapter
implements MsgListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private static final int AUXHEATER_RUNNING_TIME_RANGE_MIN;
    private static final int AUXHEATER_RUNNING_TIME_RANGE_MAX;
    private static final int AUXHEATER_RUNNING_TIME_RANGE_STEP;
    private static final long AUXHEATER_RUNNING_TIME_WATCHER_TIMEOUT;
    public static final int INFOBOX_STATE_INACTIVE;
    public static final int INFOBOX_STATE_ACTIVE;
    public static final int INFOBOX_STATE_ERROR;
    public static final int INFOBOX_ACTIVE_STATE_HEATING;
    public static final int INFOBOX_ACTIVE_STATE_VENTILATION;
    public static final int INFOBOX_ERROR_STATE_GENERAL_DEFECT;
    public static final int INFOBOX_ERROR_STATE_BATTERY_LOW;
    public static final int INFOBOX_ERROR_STATE_FUEL_LOW;
    public static final int ERROR_REASON_NONE;
    public static final int ERROR_REASON_DEFECT;
    public static final int ERROR_REASON_BATTERY_LOW;
    public static final int ERROR_REASON_FUEL_LOW;
    public static final int CLIMATE_SYSTEM_VARIANT_NONE;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED;
    private static final int SHOW_AUX_HEATER_SWITCH_ON_BUTTON;
    private static final int SHOW_AUX_HEATER_SWITCH_OFF_BUTTON;
    protected volatile AuxHeaterCoolerViewOptions currViewOptions;
    protected volatile AuxHeaterCoolerErrorReason currentAuxHeatError = new AuxHeaterCoolerErrorReason();
    protected volatile AuxHeaterCoolerErrorReason pastAuxHeatError = new AuxHeaterCoolerErrorReason();
    private volatile int currentAuxHeatState;
    private boolean switchedOnAuxheatNow;
    protected final int climateSystemVariant = this.getClimateSystemVariant();
    protected boolean stepOffValidRange = true;
    private AbstractAuxheaterComponent$AuxheaterRangeToChoiceModelMapper runningTimeModelMapper;
    private RangeModelWatcherTimer runningTimeRangeWatcher;
    private RangeModelWatcherTimer runningTimeMenuRangeWatcher;
    private volatile boolean block;

    protected void setTimer(int n, Date date) {
        Calendar calendar = TimerHelper.getCorrectCalendarFromDate(date);
        calendar.setTime(date);
        AuxHeaterCoolerTimer auxHeaterCoolerTimer = new AuxHeaterCoolerTimer((short)calendar.get(11), (short)calendar.get(12), (short)calendar.get(13), (short)calendar.get(1), (short)(calendar.get(2) + 1), (short)calendar.get(5), 0);
        this.getLogChannel().log(1078071040, "setTimer dsi.setAUXTimer(%2) %1", (Object)auxHeaterCoolerTimer, (long)n);
        switch (n) {
            case 1: {
                this.getDSI().setAuxHeaterCoolerTimer1(auxHeaterCoolerTimer);
                break;
            }
            case 2: {
                this.getDSI().setAuxHeaterCoolerTimer2(auxHeaterCoolerTimer);
                break;
            }
            case 3: {
                this.getDSI().setAuxHeaterCoolerTimer3(auxHeaterCoolerTimer);
                break;
            }
        }
    }

    private void setTempValuesForRunningTime(int n) {
        this.runningTimeRangeWatcher.setTempValue(n);
        this.runningTimeMenuRangeWatcher.setTempValue(n);
    }

    public AbstractAuxheaterComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.Car.Auxheat");
    }

    protected void activateInstantAuxHeater(int n) {
        if (this.isRangeAtMinimum()) {
            this.getRangeModel(-1943402240).fireEvent(n);
        } else {
            this.switchedOnAuxheatNow = true;
            this.getLogChannel().log(1078071040, "keyPressedModifyRunningTime dsi.setAuxHeaterCoolerOnOff(true)");
            this.getDSI().setAuxHeaterCoolerOnOff(true);
        }
    }

    private int getClimateSystemVariant() {
        boolean bl = this.getApplication().getCarMenuCoding().isMenuDisplayActivated((short)9);
        boolean bl2 = this.getApplication().getCarMenuCoding().isMenuDisplayActivated((short)46);
        if (bl && bl2) {
            return 3;
        }
        if (bl) {
            return 1;
        }
        if (bl2) {
            return 2;
        }
        return 0;
    }

    protected synchronized void setCurrentAuxHeatError(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.currentAuxHeatError = auxHeaterCoolerErrorReason;
    }

    protected synchronized AuxHeaterCoolerErrorReason getPastAuxHeatError() {
        return this.pastAuxHeatError;
    }

    protected synchronized void setPastAuxHeatError(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.pastAuxHeatError = auxHeaterCoolerErrorReason;
    }

    @Override
    public void init() {
        super.init();
        this.getApplication().getMessageDispatcher().addMessageListener(79, this);
    }

    @Override
    public void deinit() {
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this);
        super.deinit();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(1177422080).setValue(this.climateSystemVariant);
        this.getRangeModel(-1943402240).setLimits(this.stepOffValidRange ? 0 : 10, 60, 10);
        this.getRangeModel(-1909847808).setLimits(this.stepOffValidRange ? 0 : 10, 60, 10);
        this.runningTimeModelMapper = new AbstractAuxheaterComponent$AuxheaterRangeToChoiceModelMapper(this, this.getChoiceModel(-1926625024), this.stepOffValidRange ? 0 : 10, 60, 10);
        this.runningTimeRangeWatcher = new RangeModelWatcherTimer("AUXHEATER_RUNNING_TIME_RANGE", this.getRangeModel(-1943402240), 0, this.runningTimeModelMapper, this.getLogChannel());
        this.runningTimeMenuRangeWatcher = new RangeModelWatcherTimer("AUXHEATER_RUNNING_TIME_MENU_RANGE", this.getRangeModel(-1909847808), 0, this.runningTimeModelMapper, this.getLogChannel());
        AbstractAuxheaterComponent$AuxHeaterButtonListener abstractAuxheaterComponent$AuxHeaterButtonListener = new AbstractAuxheaterComponent$AuxHeaterButtonListener(this, null);
        AbstractAuxheaterComponent$AuxHeaterChoiceListener abstractAuxheaterComponent$AuxHeaterChoiceListener = this.getNewAuxHeaterChoiceListener();
        AbstractAuxheaterComponent$AuxHeaterRangeListener abstractAuxheaterComponent$AuxHeaterRangeListener = new AbstractAuxheaterComponent$AuxHeaterRangeListener(this, null);
        AbstractAuxheaterComponent$AuxHeaterMetricsListener abstractAuxheaterComponent$AuxHeaterMetricsListener = this.getNewAuxHeaterMetricsListener();
        this.getButtonModel(-1859516160).setButtonListener(abstractAuxheaterComponent$AuxHeaterButtonListener);
        this.getRangeModel(-1943402240).setRangeListener(abstractAuxheaterComponent$AuxHeaterRangeListener);
        this.getRangeModel(-1909847808).setRangeListener(abstractAuxheaterComponent$AuxHeaterRangeListener);
        this.getChoiceModel(-1775630080).setChoiceListener(abstractAuxheaterComponent$AuxHeaterChoiceListener);
        this.getChoiceModel(-1708521216).setChoiceListener(abstractAuxheaterComponent$AuxHeaterChoiceListener);
        this.getChoiceModel(-1641412352).setChoiceListener(abstractAuxheaterComponent$AuxHeaterChoiceListener);
        this.getChoiceModel(-1591080704).setChoiceListener(abstractAuxheaterComponent$AuxHeaterChoiceListener);
        this.getMetricsModel(-1792407296).setMetricsListener(abstractAuxheaterComponent$AuxHeaterMetricsListener);
        this.getMetricsModel(-1725298432).setMetricsListener(abstractAuxheaterComponent$AuxHeaterMetricsListener);
        this.getMetricsModel(-1658189568).setMetricsListener(abstractAuxheaterComponent$AuxHeaterMetricsListener);
    }

    public int getAuxheaterTimer1ChoiceId() {
        return -1775630080;
    }

    public int getAuxheaterTimer2ChoiceId() {
        return -1708521216;
    }

    public int getAuxheaterTimer3ChoiceId() {
        return -1641412352;
    }

    public int getAuxheaterTimer1MetricsId() {
        return -1792407296;
    }

    public int getAuxheaterTimer2MetricsId() {
        return -1725298432;
    }

    public int getAuxheaterTimer3MetricsId() {
        return -1658189568;
    }

    protected AbstractAuxheaterComponent$AuxHeaterMetricsListener getNewAuxHeaterMetricsListener() {
        return new AbstractAuxheaterComponent$AuxHeaterMetricsListener(this);
    }

    protected AbstractAuxheaterComponent$AuxHeaterChoiceListener getNewAuxHeaterChoiceListener() {
        return new AbstractAuxheaterComponent$AuxHeaterChoiceListener(this);
    }

    @Override
    protected void deinitModels() {
        this.getButtonModel(-1859516160).resetListener();
        this.getRangeModel(-1943402240).resetListener();
        this.getRangeModel(-1909847808).resetListener();
        this.getChoiceModel(-1775630080).resetListener();
        this.getChoiceModel(-1708521216).resetListener();
        this.getChoiceModel(-1641412352).resetListener();
        this.getChoiceModel(-1591080704).resetListener();
        this.getMetricsModel(-1792407296).resetListener();
        this.getMetricsModel(-1725298432).resetListener();
        this.getMetricsModel(-1658189568).resetListener();
    }

    protected void resetPastError() {
        this.getLogChannel().log(1078071040, "[AbstractAuxheaterComponent#resetPastError] screen with past error entered, resetting the error until next bus cycle");
        this.getChoiceModel(-2044065536).setValue(0);
    }

    protected void setAuxHeaterOnOffState(boolean bl) {
        this.getLogChannel().log(1078071040, "setAuxHeaterOnOffState: dsi.setAuxHeaterCoolerOnOff(%1)", bl);
        this.getDSI().setAuxHeaterCoolerOnOff(bl);
    }

    private void updateRunningTimeRangeModels(int n, boolean bl) {
        this.runningTimeRangeWatcher.setValidValue(n, bl);
        this.runningTimeMenuRangeWatcher.setValidValue(n, bl);
    }

    @Override
    public String getName() {
        return "AuxHeater";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{4, 10, 11, 12, 6, 5, 7, 9, 14, 15, 3})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public AuxHeaterCoolerViewOptions getViewOptions() {
        return this.currViewOptions;
    }

    public RangeListener createRangeListener() {
        return new AbstractAuxheaterComponent$AuxHeaterRangeListener(this, null);
    }

    public ButtonListener createButtonListener() {
        return new AbstractAuxheaterComponent$AuxHeaterButtonListener(this, null);
    }

    public ChoiceListener createChoiceListener() {
        return new AbstractAuxheaterComponent$AuxHeaterChoiceListener(this);
    }

    protected synchronized void updateInfobox() {
        this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] last received: state='%2', error='%1'", (Object)this.currentAuxHeatError, (long)this.currentAuxHeatState);
        if (this.currentAuxHeatError.isHeaterDefect()) {
            this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] HeaterDefect");
            this.getChoiceModel(-1876162304).setValue(0);
            this.getChoiceModel(-1976956672).setValue(2);
        } else if (this.currentAuxHeatError.isBatteryLow()) {
            this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] BatteryLow");
            this.getChoiceModel(-1876162304).setValue(1);
            this.getChoiceModel(-1976956672).setValue(2);
        } else if (this.currentAuxHeatError.isFuelLow()) {
            this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] FuelLow");
            this.getChoiceModel(-1876162304).setValue(2);
            this.getChoiceModel(-1976956672).setValue(2);
        } else {
            switch (this.currentAuxHeatState) {
                case 0: {
                    this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] AUXHEATERCOOLERSTATE_OFF");
                    this.getChoiceModel(-1976956672).setValue(0);
                    break;
                }
                case 1: {
                    this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] AUXHEATERCOOLERSTATE_HEATING");
                    this.getChoiceModel(-2010511104).setValue(0);
                    this.getChoiceModel(-1976956672).setValue(1);
                    break;
                }
                case 2: {
                    this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] AUXHEATERCOOLERSTATE_VENTILATION");
                    this.getChoiceModel(-2010511104).setValue(1);
                    this.getChoiceModel(-1976956672).setValue(1);
                    break;
                }
                default: {
                    this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateInfobox] default: INFOBOX_STATE_INACTIVE");
                    this.getChoiceModel(-1976956672).setValue(0);
                }
            }
        }
    }

    protected synchronized void updateCurrentErrorDisclaimerModel(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updateCurrentErrorDisclaimerModel] Update the error disclaimer model");
        if (auxHeaterCoolerErrorReason == null) {
            this.getChoiceModel(-2060842752).setValue(0);
            return;
        }
        if (auxHeaterCoolerErrorReason.isHeaterDefect()) {
            this.getChoiceModel(-2060842752).setValue(1);
        } else if (auxHeaterCoolerErrorReason.isBatteryLow()) {
            this.getChoiceModel(-2060842752).setValue(2);
        } else if (auxHeaterCoolerErrorReason.isFuelLow()) {
            this.getChoiceModel(-2060842752).setValue(3);
        } else {
            this.getChoiceModel(-2060842752).setValue(0);
        }
        this.updateMenuEntryVisibilityForError(auxHeaterCoolerErrorReason);
    }

    protected synchronized void updatePastErrorDisclaimerModel(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.getLogChannel().log(1078071040, "[AbstractAuxHeaterComponent#updatePastErrorDisclaimerModel] Update the error disclaimer model");
        if (auxHeaterCoolerErrorReason == null) {
            this.getChoiceModel(-2044065536).setValue(0);
            return;
        }
        if (auxHeaterCoolerErrorReason.isHeaterDefect()) {
            this.getChoiceModel(-2044065536).setValue(1);
        } else if (auxHeaterCoolerErrorReason.isBatteryLow()) {
            this.getChoiceModel(-2044065536).setValue(2);
        } else if (auxHeaterCoolerErrorReason.isFuelLow()) {
            this.getChoiceModel(-2044065536).setValue(3);
        } else {
            this.getChoiceModel(-2044065536).setValue(0);
        }
    }

    @Override
    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerViewOptions(%1), valid:%2", (Object)auxHeaterCoolerViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = auxHeaterCoolerViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.handleHeaterCoolerError(this.currentAuxHeatError);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerCurrentHeaterState: heaterState=%1, validFlag=%2", (Object)auxHeaterCoolerErrorReason, (long)n);
        if (n == 1) {
            this.setCurrentAuxHeatError(auxHeaterCoolerErrorReason);
            this.handleHeaterCoolerError(auxHeaterCoolerErrorReason);
        }
    }

    @Override
    public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerErrorReason: errorReason=%1, validFlag=%2", (Object)auxHeaterCoolerErrorReason, (long)n);
        if (n == 1) {
            this.setPastAuxHeatError(auxHeaterCoolerErrorReason);
            this.updatePastErrorDisclaimerModel(auxHeaterCoolerErrorReason);
        }
    }

    @Override
    public void updateAuxHeaterCoolerState(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerState: state=%1, validflag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.currentAuxHeatState = n;
            if (!this.deferInfoBoxUpdate(this.currentAuxHeatError)) {
                this.updateInfobox();
            }
        }
    }

    @Override
    public void updateAuxHeaterCoolerOnOff(boolean bl, int n) {
        if (n == 1) {
            this.getLogChannel().log(1078071040, "[AbstractAuxheaterComponent:updateAuxHeaterCoolerOnOff] on=%1, validFlag=%2", bl, (long)n);
            this.getChoiceModel(-1825961728).setValue(bl ? 1 : 0);
            this.updateAuxHeatNowOn(bl);
            if (bl && this.getRangeModel(-1943402240).getValue() > 0) {
                this.getRangeModel(-1943402240).fireEvent(0);
            }
            if (this.switchedOnAuxheatNow) {
                this.getRangeModel(-1943402240).fireEvent(0);
                this.switchedOnAuxheatNow = false;
            }
        }
    }

    @Override
    public void updateAuxHeaterCoolerRemainingTime(short s, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerRemainingTime: remainingTime=%1, validFlag=%2", (long)s, (long)n);
        if (n == 1) {
            DateMetric dateMetric = new DateMetric(new Date(s * 1625948160), 5);
            this.getMetricsModel(170920192).setMetric(dateMetric);
        }
    }

    @Override
    public void updateAuxHeaterCoolerRunningTime(short s, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerRunningTime: runningTime=%1, validFlag=%2", (long)s, (long)n);
        if (n == 1) {
            if (this.block) {
                this.runningTimeRangeWatcher.forceCancelTimer();
            } else {
                this.updateRunningTimeRangeModels(s, false);
            }
        }
    }

    @Override
    public void updateAuxHeaterCoolerActiveTimer(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerActiveTimer: activeTimer=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            switch (n) {
                case 0: {
                    this.getChoiceModel(-1775630080).setValue(0);
                    this.getChoiceModel(-1708521216).setValue(0);
                    this.getChoiceModel(-1641412352).setValue(0);
                    break;
                }
                case 1: {
                    this.getChoiceModel(-1775630080).setValue(1);
                    this.getChoiceModel(-1708521216).setValue(0);
                    this.getChoiceModel(-1641412352).setValue(0);
                    break;
                }
                case 2: {
                    this.getChoiceModel(-1775630080).setValue(0);
                    this.getChoiceModel(-1708521216).setValue(1);
                    this.getChoiceModel(-1641412352).setValue(0);
                    break;
                }
                case 3: {
                    this.getChoiceModel(-1775630080).setValue(0);
                    this.getChoiceModel(-1708521216).setValue(0);
                    this.getChoiceModel(-1641412352).setValue(1);
                    break;
                }
            }
        }
    }

    @Override
    public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerTimer1: timer=%1, validFlag=%2", (Object)auxHeaterCoolerTimer, (long)n);
        if (n == 1) {
            this.updateAuxHeaterCoolerTimer(1, auxHeaterCoolerTimer);
        }
    }

    @Override
    public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerTimer2: timer=%1, validFlag=%2", (Object)auxHeaterCoolerTimer, (long)n);
        if (n == 1) {
            this.updateAuxHeaterCoolerTimer(2, auxHeaterCoolerTimer);
        }
    }

    @Override
    public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.getLogChannel().log(1078071040, "updateAuxHeaterCoolerTimer3: timer=%1, validFlag=%2", (Object)auxHeaterCoolerTimer, (long)n);
        if (n == 1) {
            this.updateAuxHeaterCoolerTimer(3, auxHeaterCoolerTimer);
        }
    }

    protected void updateAuxHeaterCoolerTimer(int n, AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        int n2;
        switch (n) {
            case 2: {
                n2 = -1725298432;
                break;
            }
            case 3: {
                n2 = -1658189568;
                break;
            }
            default: {
                n2 = -1792407296;
            }
        }
        TimerHelper timerHelper = new TimerHelper(this.getApplication(), this.getLogChannel());
        timerHelper.setTimerMetric(timerHelper.castTimerToGeneralObject(auxHeaterCoolerTimer), this.getMetricsModel(n2), "updateAuxHeaterCoolerTimer");
    }

    @Override
    public void updateAuxHeaterCoolerMode(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateAUXHeaterCoolerMode: mode=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            int n3 = n == 0 ? 0 : 1;
            this.getChoiceModel(-1591080704).setValue(n3);
        }
    }

    private void handleHeaterCoolerError(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.getLogChannel().log(1078071040, "[AbstractAuxheaterComponent:handleHeaterCoolerError] heaterState=%1", (Object)auxHeaterCoolerErrorReason);
        if (!this.deferInfoBoxUpdate(auxHeaterCoolerErrorReason)) {
            this.updateInfobox();
        }
        if (!this.deferCurrentErrorDisclaimerUpdate(auxHeaterCoolerErrorReason)) {
            this.updateCurrentErrorDisclaimerModel(auxHeaterCoolerErrorReason);
        }
    }

    protected abstract void updateMenuEntryVisibility(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions) {
    }

    protected abstract boolean deferCurrentErrorDisclaimerUpdate(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
    }

    protected abstract boolean deferInfoBoxUpdate(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
    }

    protected abstract void updateAuxHeatNowOn(boolean bl) {
    }

    protected abstract void updateMenuEntryVisibilityForError(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
    }

    @Override
    public void processMsg(int n) {
        if (n == 79 && this.getChoiceModel(395).getValue() == 1) {
            this.getButtonModel(-1859450624).setButtonListener(new AbstractAuxheaterComponent$AuxHeaterButtonListener(this, null));
        }
    }

    public RangeModelWatcherTimer getRunningTimeRangeWatcher() {
        return this.runningTimeRangeWatcher;
    }

    public void setRunningTimeRangeWatcher(RangeModelWatcherTimer rangeModelWatcherTimer) {
        this.runningTimeRangeWatcher = rangeModelWatcherTimer;
    }

    protected boolean isRangeAtMinimum() {
        return this.getRangeModel(-1943402240).getValue() == 0;
    }

    static /* synthetic */ void access$000(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$100(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getChoiceModel(n);
    }

    static /* synthetic */ ICarApplication access$300(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        return abstractAuxheaterComponent.getApplication();
    }

    static /* synthetic */ ICarApplication access$400(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        return abstractAuxheaterComponent.getApplication();
    }

    static /* synthetic */ ICarApplication access$500(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        return abstractAuxheaterComponent.getApplication();
    }

    static /* synthetic */ ChoiceModelApp access$600(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getChoiceModel(n);
    }

    static /* synthetic */ ICarApplication access$700(AbstractAuxheaterComponent abstractAuxheaterComponent) {
        return abstractAuxheaterComponent.getApplication();
    }

    static /* synthetic */ void access$800(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$900(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ RangeModelApp access$1000(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getRangeModel(n);
    }

    static /* synthetic */ void access$1100(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ RangeModelApp access$1200(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getRangeModel(n);
    }

    static /* synthetic */ void access$1300(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        abstractAuxheaterComponent.setTempValuesForRunningTime(n);
    }

    static /* synthetic */ boolean access$1402(AbstractAuxheaterComponent abstractAuxheaterComponent, boolean bl) {
        abstractAuxheaterComponent.block = bl;
        return abstractAuxheaterComponent.block;
    }

    static /* synthetic */ void access$1500(AbstractAuxheaterComponent abstractAuxheaterComponent, int n, boolean bl) {
        abstractAuxheaterComponent.updateRunningTimeRangeModels(n, bl);
    }

    static /* synthetic */ void access$1600(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ RangeModelApp access$1700(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getRangeModel(n);
    }

    static /* synthetic */ RangeModelApp access$1800(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getRangeModel(n);
    }

    static /* synthetic */ void access$1900(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$2000(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$2100(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ DateMetric access$2200(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getDateMetric(n);
    }

    static /* synthetic */ DateMetric access$2300(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getDateMetric(n);
    }

    static /* synthetic */ DateMetric access$2400(AbstractAuxheaterComponent abstractAuxheaterComponent, int n) {
        return abstractAuxheaterComponent.getDateMetric(n);
    }

    static /* synthetic */ void access$2500(AbstractAuxheaterComponent abstractAuxheaterComponent, String string, int n, int n2, boolean bl) {
        abstractAuxheaterComponent.logModelData(string, n, n2, bl);
    }
}

