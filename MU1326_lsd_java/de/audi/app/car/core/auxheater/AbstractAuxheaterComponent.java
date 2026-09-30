/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.auxheater;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.car.core.app.AbstractRangeToChoiceModelMapper;
import de.audi.app.car.core.app.RangeModelWatcherTimer;
import de.audi.app.car.core.auxheater.AbstractDSICarAuxheaterCoolerAdapter;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.model.RangeListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
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
    public static final short CODING_ID = 9;
    private static final String LOGCHANNEL_NAME = "App.Car.Auxheat";
    private static final int AUXHEATER_RUNNING_TIME_RANGE_MIN = 0;
    private static final int AUXHEATER_RUNNING_TIME_RANGE_MAX = 60;
    private static final int AUXHEATER_RUNNING_TIME_RANGE_STEP = 10;
    private static final long AUXHEATER_RUNNING_TIME_WATCHER_TIMEOUT = 1000L;
    public static final int INFOBOX_STATE_INACTIVE = 0;
    public static final int INFOBOX_STATE_ACTIVE = 1;
    public static final int INFOBOX_STATE_ERROR = 2;
    public static final int INFOBOX_ACTIVE_STATE_HEATING = 0;
    public static final int INFOBOX_ACTIVE_STATE_VENTILATION = 1;
    public static final int INFOBOX_ERROR_STATE_GENERAL_DEFECT = 0;
    public static final int INFOBOX_ERROR_STATE_BATTERY_LOW = 1;
    public static final int INFOBOX_ERROR_STATE_FUEL_LOW = 2;
    public static final int ERROR_REASON_NONE = 0;
    public static final int ERROR_REASON_DEFECT = 1;
    public static final int ERROR_REASON_BATTERY_LOW = 2;
    public static final int ERROR_REASON_FUEL_LOW = 3;
    public static final int CLIMATE_SYSTEM_VARIANT_NONE = 0;
    public static final int CLIMATE_SYSTEM_VARIANT_HEATER = 1;
    public static final int CLIMATE_SYSTEM_VARIANT_COOLER = 2;
    public static final int CLIMATE_SYSTEM_VARIANT_COMBINED = 3;
    private static final int SHOW_AUX_HEATER_SWITCH_ON_BUTTON = 0;
    private static final int SHOW_AUX_HEATER_SWITCH_OFF_BUTTON = 1;
    protected volatile AuxHeaterCoolerViewOptions currViewOptions;
    protected volatile AuxHeaterCoolerErrorReason currentAuxHeatError = new AuxHeaterCoolerErrorReason();
    protected volatile AuxHeaterCoolerErrorReason pastAuxHeatError = new AuxHeaterCoolerErrorReason();
    private volatile int currentAuxHeatState;
    private boolean switchedOnAuxheatNow;
    protected final int climateSystemVariant = this.getClimateSystemVariant();
    protected boolean stepOffValidRange = true;
    private AuxheaterRangeToChoiceModelMapper runningTimeModelMapper;
    private RangeModelWatcherTimer runningTimeRangeWatcher;
    private RangeModelWatcherTimer runningTimeMenuRangeWatcher;
    private volatile boolean block;

    protected void setTimer(int n, Date date) {
        Calendar calendar = TimerHelper.getCorrectCalendarFromDate(date);
        calendar.setTime(date);
        AuxHeaterCoolerTimer auxHeaterCoolerTimer = new AuxHeaterCoolerTimer((short)calendar.get(11), (short)calendar.get(12), (short)calendar.get(13), (short)calendar.get(1), (short)(calendar.get(2) + 1), (short)calendar.get(5), 0);
        this.getLogChannel().log(1000000, "setTimer dsi.setAUXTimer(%2) %1", (Object)auxHeaterCoolerTimer, (long)n);
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
        super(iCarApplication, LOGCHANNEL_NAME);
    }

    protected void activateInstantAuxHeater(int n) {
        if (this.isRangeAtMinimum()) {
            this.getRangeModel(600716).fireEvent(n);
        } else {
            this.switchedOnAuxheatNow = true;
            this.getLogChannel().log(1000000, "keyPressedModifyRunningTime dsi.setAuxHeaterCoolerOnOff(true)");
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

    public void init() {
        super.init();
        this.getApplication().getMessageDispatcher().addMessageListener(79, this);
    }

    public void deinit() {
        this.getApplication().getMessageDispatcher().removeMessageListener(79, this);
        super.deinit();
    }

    protected void initModels() {
        this.getChoiceModel(601670).setValue(this.climateSystemVariant);
        this.getRangeModel(600716).setLimits(this.stepOffValidRange ? 0 : 10, 60, 10);
        this.getRangeModel(600718).setLimits(this.stepOffValidRange ? 0 : 10, 60, 10);
        this.runningTimeModelMapper = new AuxheaterRangeToChoiceModelMapper(this.getChoiceModel(600717), this.stepOffValidRange ? 0 : 10, 60, 10);
        this.runningTimeRangeWatcher = new RangeModelWatcherTimer("AUXHEATER_RUNNING_TIME_RANGE", this.getRangeModel(600716), 1000L, this.runningTimeModelMapper, this.getLogChannel());
        this.runningTimeMenuRangeWatcher = new RangeModelWatcherTimer("AUXHEATER_RUNNING_TIME_MENU_RANGE", this.getRangeModel(600718), 1000L, this.runningTimeModelMapper, this.getLogChannel());
        AuxHeaterButtonListener auxHeaterButtonListener = new AuxHeaterButtonListener();
        AuxHeaterChoiceListener auxHeaterChoiceListener = this.getNewAuxHeaterChoiceListener();
        AuxHeaterRangeListener auxHeaterRangeListener = new AuxHeaterRangeListener();
        AuxHeaterMetricsListener auxHeaterMetricsListener = this.getNewAuxHeaterMetricsListener();
        this.getButtonModel(600721).setButtonListener(auxHeaterButtonListener);
        this.getRangeModel(600716).setRangeListener(auxHeaterRangeListener);
        this.getRangeModel(600718).setRangeListener(auxHeaterRangeListener);
        this.getChoiceModel(600726).setChoiceListener(auxHeaterChoiceListener);
        this.getChoiceModel(600730).setChoiceListener(auxHeaterChoiceListener);
        this.getChoiceModel(600734).setChoiceListener(auxHeaterChoiceListener);
        this.getChoiceModel(600737).setChoiceListener(auxHeaterChoiceListener);
        this.getMetricsModel(600725).setMetricsListener(auxHeaterMetricsListener);
        this.getMetricsModel(600729).setMetricsListener(auxHeaterMetricsListener);
        this.getMetricsModel(600733).setMetricsListener(auxHeaterMetricsListener);
    }

    public int getAuxheaterTimer1ChoiceId() {
        return 600726;
    }

    public int getAuxheaterTimer2ChoiceId() {
        return 600730;
    }

    public int getAuxheaterTimer3ChoiceId() {
        return 600734;
    }

    public int getAuxheaterTimer1MetricsId() {
        return 600725;
    }

    public int getAuxheaterTimer2MetricsId() {
        return 600729;
    }

    public int getAuxheaterTimer3MetricsId() {
        return 600733;
    }

    protected AuxHeaterMetricsListener getNewAuxHeaterMetricsListener() {
        return new AuxHeaterMetricsListener();
    }

    protected AuxHeaterChoiceListener getNewAuxHeaterChoiceListener() {
        return new AuxHeaterChoiceListener();
    }

    protected void deinitModels() {
        this.getButtonModel(600721).resetListener();
        this.getRangeModel(600716).resetListener();
        this.getRangeModel(600718).resetListener();
        this.getChoiceModel(600726).resetListener();
        this.getChoiceModel(600730).resetListener();
        this.getChoiceModel(600734).resetListener();
        this.getChoiceModel(600737).resetListener();
        this.getMetricsModel(600725).resetListener();
        this.getMetricsModel(600729).resetListener();
        this.getMetricsModel(600733).resetListener();
    }

    protected void resetPastError() {
        this.getLogChannel().log(1000000, "[AbstractAuxheaterComponent#resetPastError] screen with past error entered, resetting the error until next bus cycle");
        this.getChoiceModel(600710).setValue(0);
    }

    protected void setAuxHeaterOnOffState(boolean bl) {
        this.getLogChannel().log(1000000, "setAuxHeaterOnOffState: dsi.setAuxHeaterCoolerOnOff(%1)", bl);
        this.getDSI().setAuxHeaterCoolerOnOff(bl);
    }

    private void updateRunningTimeRangeModels(int n, boolean bl) {
        this.runningTimeRangeWatcher.setValidValue(n, bl);
        this.runningTimeMenuRangeWatcher.setValidValue(n, bl);
    }

    public String getName() {
        return "AuxHeater";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{4, 10, 11, 12, 6, 5, 7, 9, 14, 15, 3})};
    }

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
        return new AuxHeaterRangeListener();
    }

    public ButtonListener createButtonListener() {
        return new AuxHeaterButtonListener();
    }

    public ChoiceListener createChoiceListener() {
        return new AuxHeaterChoiceListener();
    }

    protected synchronized void updateInfobox() {
        this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] last received: state='%2', error='%1'", (Object)this.currentAuxHeatError, (long)this.currentAuxHeatState);
        if (this.currentAuxHeatError.isHeaterDefect()) {
            this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] HeaterDefect");
            this.getChoiceModel(601232).setValue(0);
            this.getChoiceModel(600714).setValue(2);
        } else if (this.currentAuxHeatError.isBatteryLow()) {
            this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] BatteryLow");
            this.getChoiceModel(601232).setValue(1);
            this.getChoiceModel(600714).setValue(2);
        } else if (this.currentAuxHeatError.isFuelLow()) {
            this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] FuelLow");
            this.getChoiceModel(601232).setValue(2);
            this.getChoiceModel(600714).setValue(2);
        } else {
            switch (this.currentAuxHeatState) {
                case 0: {
                    this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] AUXHEATERCOOLERSTATE_OFF");
                    this.getChoiceModel(600714).setValue(0);
                    break;
                }
                case 1: {
                    this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] AUXHEATERCOOLERSTATE_HEATING");
                    this.getChoiceModel(600712).setValue(0);
                    this.getChoiceModel(600714).setValue(1);
                    break;
                }
                case 2: {
                    this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] AUXHEATERCOOLERSTATE_VENTILATION");
                    this.getChoiceModel(600712).setValue(1);
                    this.getChoiceModel(600714).setValue(1);
                    break;
                }
                default: {
                    this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateInfobox] default: INFOBOX_STATE_INACTIVE");
                    this.getChoiceModel(600714).setValue(0);
                }
            }
        }
    }

    protected synchronized void updateCurrentErrorDisclaimerModel(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updateCurrentErrorDisclaimerModel] Update the error disclaimer model");
        if (auxHeaterCoolerErrorReason == null) {
            this.getChoiceModel(600709).setValue(0);
            return;
        }
        if (auxHeaterCoolerErrorReason.isHeaterDefect()) {
            this.getChoiceModel(600709).setValue(1);
        } else if (auxHeaterCoolerErrorReason.isBatteryLow()) {
            this.getChoiceModel(600709).setValue(2);
        } else if (auxHeaterCoolerErrorReason.isFuelLow()) {
            this.getChoiceModel(600709).setValue(3);
        } else {
            this.getChoiceModel(600709).setValue(0);
        }
        this.updateMenuEntryVisibilityForError(auxHeaterCoolerErrorReason);
    }

    protected synchronized void updatePastErrorDisclaimerModel(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.getLogChannel().log(1000000, "[AbstractAuxHeaterComponent#updatePastErrorDisclaimerModel] Update the error disclaimer model");
        if (auxHeaterCoolerErrorReason == null) {
            this.getChoiceModel(600710).setValue(0);
            return;
        }
        if (auxHeaterCoolerErrorReason.isHeaterDefect()) {
            this.getChoiceModel(600710).setValue(1);
        } else if (auxHeaterCoolerErrorReason.isBatteryLow()) {
            this.getChoiceModel(600710).setValue(2);
        } else if (auxHeaterCoolerErrorReason.isFuelLow()) {
            this.getChoiceModel(600710).setValue(3);
        } else {
            this.getChoiceModel(600710).setValue(0);
        }
    }

    public void updateAuxHeaterCoolerViewOptions(AuxHeaterCoolerViewOptions auxHeaterCoolerViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerViewOptions(%1), valid:%2", (Object)auxHeaterCoolerViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = auxHeaterCoolerViewOptions;
            this.updateMenuEntryVisibility(this.currViewOptions);
            this.handleHeaterCoolerError(this.currentAuxHeatError);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateAuxHeaterCoolerCurrentHeaterState(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerCurrentHeaterState: heaterState=%1, validFlag=%2", (Object)auxHeaterCoolerErrorReason, (long)n);
        if (n == 1) {
            this.setCurrentAuxHeatError(auxHeaterCoolerErrorReason);
            this.handleHeaterCoolerError(auxHeaterCoolerErrorReason);
        }
    }

    public void updateAuxHeaterCoolerErrorReason(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerErrorReason: errorReason=%1, validFlag=%2", (Object)auxHeaterCoolerErrorReason, (long)n);
        if (n == 1) {
            this.setPastAuxHeatError(auxHeaterCoolerErrorReason);
            this.updatePastErrorDisclaimerModel(auxHeaterCoolerErrorReason);
        }
    }

    public void updateAuxHeaterCoolerState(int n, int n2) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerState: state=%1, validflag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            this.currentAuxHeatState = n;
            if (!this.deferInfoBoxUpdate(this.currentAuxHeatError)) {
                this.updateInfobox();
            }
        }
    }

    public void updateAuxHeaterCoolerOnOff(boolean bl, int n) {
        if (n == 1) {
            this.getLogChannel().log(1000000, "[AbstractAuxheaterComponent:updateAuxHeaterCoolerOnOff] on=%1, validFlag=%2", bl, (long)n);
            this.getChoiceModel(600723).setValue(bl ? 1 : 0);
            this.updateAuxHeatNowOn(bl);
            if (bl && this.getRangeModel(600716).getValue() > 0) {
                this.getRangeModel(600716).fireEvent(0);
            }
            if (this.switchedOnAuxheatNow) {
                this.getRangeModel(600716).fireEvent(0);
                this.switchedOnAuxheatNow = false;
            }
        }
    }

    public void updateAuxHeaterCoolerRemainingTime(short s, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerRemainingTime: remainingTime=%1, validFlag=%2", (long)s, (long)n);
        if (n == 1) {
            DateMetric dateMetric = new DateMetric(new Date(s * 60000), 5);
            this.getMetricsModel(602122).setMetric(dateMetric);
        }
    }

    public void updateAuxHeaterCoolerRunningTime(short s, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerRunningTime: runningTime=%1, validFlag=%2", (long)s, (long)n);
        if (n == 1) {
            if (this.block) {
                this.runningTimeRangeWatcher.forceCancelTimer();
            } else {
                this.updateRunningTimeRangeModels(s, false);
            }
        }
    }

    public void updateAuxHeaterCoolerActiveTimer(int n, int n2) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerActiveTimer: activeTimer=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            switch (n) {
                case 0: {
                    this.getChoiceModel(600726).setValue(0);
                    this.getChoiceModel(600730).setValue(0);
                    this.getChoiceModel(600734).setValue(0);
                    break;
                }
                case 1: {
                    this.getChoiceModel(600726).setValue(1);
                    this.getChoiceModel(600730).setValue(0);
                    this.getChoiceModel(600734).setValue(0);
                    break;
                }
                case 2: {
                    this.getChoiceModel(600726).setValue(0);
                    this.getChoiceModel(600730).setValue(1);
                    this.getChoiceModel(600734).setValue(0);
                    break;
                }
                case 3: {
                    this.getChoiceModel(600726).setValue(0);
                    this.getChoiceModel(600730).setValue(0);
                    this.getChoiceModel(600734).setValue(1);
                    break;
                }
            }
        }
    }

    public void updateAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerTimer1: timer=%1, validFlag=%2", (Object)auxHeaterCoolerTimer, (long)n);
        if (n == 1) {
            this.updateAuxHeaterCoolerTimer(1, auxHeaterCoolerTimer);
        }
    }

    public void updateAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerTimer2: timer=%1, validFlag=%2", (Object)auxHeaterCoolerTimer, (long)n);
        if (n == 1) {
            this.updateAuxHeaterCoolerTimer(2, auxHeaterCoolerTimer);
        }
    }

    public void updateAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer auxHeaterCoolerTimer, int n) {
        this.getLogChannel().log(1000000, "updateAuxHeaterCoolerTimer3: timer=%1, validFlag=%2", (Object)auxHeaterCoolerTimer, (long)n);
        if (n == 1) {
            this.updateAuxHeaterCoolerTimer(3, auxHeaterCoolerTimer);
        }
    }

    protected void updateAuxHeaterCoolerTimer(int n, AuxHeaterCoolerTimer auxHeaterCoolerTimer) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 600729;
                break;
            }
            case 3: {
                n2 = 600733;
                break;
            }
            default: {
                n2 = 600725;
            }
        }
        TimerHelper timerHelper = new TimerHelper(this.getApplication(), this.getLogChannel());
        timerHelper.setTimerMetric(timerHelper.castTimerToGeneralObject(auxHeaterCoolerTimer), this.getMetricsModel(n2), "updateAuxHeaterCoolerTimer");
    }

    public void updateAuxHeaterCoolerMode(int n, int n2) {
        this.getLogChannel().log(1000000, "updateAUXHeaterCoolerMode: mode=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1) {
            int n3 = n == 0 ? 0 : 1;
            this.getChoiceModel(600737).setValue(n3);
        }
    }

    private void handleHeaterCoolerError(AuxHeaterCoolerErrorReason auxHeaterCoolerErrorReason) {
        this.getLogChannel().log(1000000, "[AbstractAuxheaterComponent:handleHeaterCoolerError] heaterState=%1", (Object)auxHeaterCoolerErrorReason);
        if (!this.deferInfoBoxUpdate(auxHeaterCoolerErrorReason)) {
            this.updateInfobox();
        }
        if (!this.deferCurrentErrorDisclaimerUpdate(auxHeaterCoolerErrorReason)) {
            this.updateCurrentErrorDisclaimerModel(auxHeaterCoolerErrorReason);
        }
    }

    protected abstract void updateMenuEntryVisibility(AuxHeaterCoolerViewOptions var1);

    protected abstract boolean deferCurrentErrorDisclaimerUpdate(AuxHeaterCoolerErrorReason var1);

    protected abstract boolean deferInfoBoxUpdate(AuxHeaterCoolerErrorReason var1);

    protected abstract void updateAuxHeatNowOn(boolean var1);

    protected abstract void updateMenuEntryVisibilityForError(AuxHeaterCoolerErrorReason var1);

    public void processMsg(int n) {
        if (n == 79 && this.getChoiceModel(395).getValue() == 1) {
            this.getButtonModel(600977).setButtonListener(new AuxHeaterButtonListener());
        }
    }

    public RangeModelWatcherTimer getRunningTimeRangeWatcher() {
        return this.runningTimeRangeWatcher;
    }

    public void setRunningTimeRangeWatcher(RangeModelWatcherTimer rangeModelWatcherTimer) {
        this.runningTimeRangeWatcher = rangeModelWatcherTimer;
    }

    protected boolean isRangeAtMinimum() {
        return this.getRangeModel(600716).getValue() == 0;
    }

    private final class AuxHeaterRangeListener
    extends DefaultRangeListener {
        private AuxHeaterRangeListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            AbstractAuxheaterComponent.this.logModelData("keyPressed", n, n2, true);
            switch (n) {
                case 600716: {
                    AbstractAuxheaterComponent.this.activateInstantAuxHeater(n3);
                    break;
                }
                case 600718: {
                    this.keyPressedStartModifyRunningTime(n3);
                    break;
                }
                default: {
                    AbstractAuxheaterComponent.this.logModelData("keyPressed", n, n2, false);
                }
            }
        }

        private void keyPressedStartModifyRunningTime(int n) {
            AbstractAuxheaterComponent.this.getRangeModel(600718).fireEvent(n);
        }

        public void decrement(int n, int n2, int n3) {
            AbstractAuxheaterComponent.this.logModelData("decrement", n, n2, true);
            if (n == 600716) {
                this.decrementRunningTime(n2);
            }
        }

        private void decrementRunningTime(int n) {
            int n2 = AbstractCarComponent.clip(AbstractAuxheaterComponent.this.getRangeModel(600716).getValue() - n, 0, 60);
            AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "decrementRunningTime :  steps: %1, newValue: %2", (long)n, (long)n2);
            if (n2 > 0) {
                AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "decrementRunningTime : dsi.setAUXHeaterCoolerRunningTime(%1)", (long)n2);
                AbstractAuxheaterComponent.this.setTempValuesForRunningTime(n2);
                AbstractAuxheaterComponent.this.getDSI().setAuxHeaterCoolerRunningTime((short)n2);
                AbstractAuxheaterComponent.this.block = false;
            } else {
                AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "decrementRunningTime: rotary switched from on to off");
                AbstractAuxheaterComponent.this.setTempValuesForRunningTime(n2);
                AbstractAuxheaterComponent.this.updateRunningTimeRangeModels(n2, false);
                AbstractAuxheaterComponent.this.block = true;
                if (n > 10) {
                    AbstractAuxheaterComponent.this.getDSI().setAuxHeaterCoolerRunningTime((short)10);
                }
            }
        }

        public void increment(int n, int n2, int n3) {
            AbstractAuxheaterComponent.this.logModelData("increment", n, n2, true);
            if (n == 600716) {
                this.incrementRunningTime(n2);
            }
        }

        private void incrementRunningTime(int n) {
            AbstractAuxheaterComponent.this.block = false;
            int n2 = AbstractCarComponent.clip(AbstractAuxheaterComponent.this.getRangeModel(600716).getValue() + n, 0, 60);
            AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "incrementRunningTime :  steps: %1 newValue: %2", (long)n, (long)n2);
            if (AbstractAuxheaterComponent.this.getRangeModel(600716).getValue() == 0 && n == 10) {
                AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "incrementRunningTime: rotary switched from off to on");
                AbstractAuxheaterComponent.this.setTempValuesForRunningTime(n2);
                AbstractAuxheaterComponent.this.updateRunningTimeRangeModels(10, false);
            } else {
                AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "incrementRunningTime: dsi.setAUXHeaterCoolerRunningTime(%1)", (long)n2);
                AbstractAuxheaterComponent.this.setTempValuesForRunningTime(n2);
                AbstractAuxheaterComponent.this.getDSI().setAuxHeaterCoolerRunningTime((short)n2);
            }
        }
    }

    private final class AuxHeaterButtonListener
    extends DefaultButtonListener {
        private AuxHeaterButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            AbstractAuxheaterComponent.this.logModelData("keyPressed", n, n2, true);
            switch (n) {
                case 600721: {
                    AbstractAuxheaterComponent.this.setAuxHeaterOnOffState(false);
                    break;
                }
                case 600977: {
                    break;
                }
                default: {
                    AbstractAuxheaterComponent.this.logModelData("keyPressed", n, n2, false);
                }
            }
        }

        public void keyReleased(int n, int n2, int n3) {
            switch (n) {
                case 600721: {
                    AbstractAuxheaterComponent.this.setAuxHeaterOnOffState(false);
                    break;
                }
                case 600977: {
                    if (AbstractAuxheaterComponent.this.getChoiceModel(395).getValue() != 1) break;
                    this.toggleOnOffByJokerKey();
                    break;
                }
            }
        }

        private void toggleOnOffByJokerKey() {
            if (AbstractAuxheaterComponent.this.currentAuxHeatError.isBatteryLow()) {
                AbstractAuxheaterComponent.this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(76);
            } else if (AbstractAuxheaterComponent.this.currentAuxHeatError.isFuelLow()) {
                AbstractAuxheaterComponent.this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(75);
            } else if (AbstractAuxheaterComponent.this.currentAuxHeatError.isHeaterDefect()) {
                AbstractAuxheaterComponent.this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(74);
            } else if (AbstractAuxheaterComponent.this.currViewOptions != null && AbstractAuxheaterComponent.this.currViewOptions.getAuxHeaterCoolerOnOff().getState() == 2) {
                boolean bl = AbstractAuxheaterComponent.this.getChoiceModel(600723).getValue() == 0;
                AbstractAuxheaterComponent.this.setAuxHeaterOnOffState(bl);
                AbstractAuxheaterComponent.this.getApplication().getFrameworkAccess().getMsgDistrib().sendMessage(bl ? 69 : 70);
            }
        }
    }

    protected class AuxHeaterChoiceListener
    extends DefaultChoiceListener {
        protected AuxHeaterChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractAuxheaterComponent.this.logModelData("itemSelected:", n, n2, true);
            switch (n) {
                case 600726: {
                    this.switchTimerActivation(1, n2 == 1);
                    break;
                }
                case 600730: {
                    this.switchTimerActivation(2, n2 == 1);
                    break;
                }
                case 600734: {
                    this.switchTimerActivation(3, n2 == 1);
                    break;
                }
                case 600737: {
                    this.itemSelectedHeatEffect(n2);
                    break;
                }
                default: {
                    AbstractAuxheaterComponent.this.logModelData("itemSelected:", n, n2, false);
                }
            }
        }

        protected void switchTimerActivation(int n, boolean bl) {
            int n2 = bl ? n : 0;
            AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "setTimer: dsi.setAuxHeaterCoolerActiveTimer(%1)", (long)n2);
            AbstractAuxheaterComponent.this.getDSI().setAuxHeaterCoolerActiveTimer(n2);
        }

        private void itemSelectedHeatEffect(int n) {
            int n2 = n == 0 ? 0 : 2;
            AbstractAuxheaterComponent.this.getLogChannel().log(1000000, "dsi.setAuxHeaterCoolerMode(%1)", (long)n2);
            AbstractAuxheaterComponent.this.getDSI().setAuxHeaterCoolerMode(n2);
        }
    }

    protected class AuxHeaterMetricsListener
    implements MetricsListener {
        protected AuxHeaterMetricsListener() {
        }

        public void metricsUpdated(int n, int n2) {
            AbstractAuxheaterComponent.this.logModelData("metricsUpdated", n, 0, true);
            switch (n) {
                case 600725: {
                    this.setTimer(1, AbstractAuxheaterComponent.this.getDateMetric(n).getDate());
                    break;
                }
                case 600729: {
                    this.setTimer(2, AbstractAuxheaterComponent.this.getDateMetric(n).getDate());
                    break;
                }
                case 600733: {
                    this.setTimer(3, AbstractAuxheaterComponent.this.getDateMetric(n).getDate());
                    break;
                }
                default: {
                    AbstractAuxheaterComponent.this.logModelData("metricsUpdated", n, 0, false);
                }
            }
        }

        public void setTimer(int n, Date date) {
            AbstractAuxheaterComponent.this.setTimer(n, date);
        }
    }

    private final class AuxheaterRangeToChoiceModelMapper
    extends AbstractRangeToChoiceModelMapper {
        private static final int OFF = 0;
        private static final int ON = 1;

        public AuxheaterRangeToChoiceModelMapper(ChoiceModelApp choiceModelApp, int n, int n2, int n3) {
            super(choiceModelApp, n, n2, n3);
        }

        public int getMapping(int n) {
            return 0 < n ? 1 : 0;
        }
    }
}

