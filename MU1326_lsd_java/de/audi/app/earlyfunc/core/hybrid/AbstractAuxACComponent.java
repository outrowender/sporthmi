/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.listhandling.ListHandlingHelper;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.earlyfunc.core.hybrid.CarNetworkPlatformInfo;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.interapp.IBattCtrlCommunicationService;
import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingService;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlExpiredTimer;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public abstract class AbstractAuxACComponent
extends AbstractDSICarHybridAdapter {
    public static final short CODING_ID = 46;
    private static final String LOGCHANNEL_NAME = "App.EarlyFunc.AuxCooler";
    private static final int TIMER_ID_TIMER1 = 3;
    private static final int TIMER_ID_TIMER2 = 4;
    private static final int PROFILE_ID_TIMER1 = 3;
    private static final int PROFILE_ID_TIMER2 = 4;
    private static final int PROFILE_ID_IMMEDIATE = 6;
    protected static final int IMMEDIATE_CONTROL_STOP = 0;
    protected static final int IMMEDIATE_CONTROL_START = 1;
    private static final int ERROR_REASON_NONE = 0;
    private static final int ERROR_REASON_GENERALDEVICEERROR = 1;
    private static final int ERROR_REASON_BATTERY_LOW = 2;
    private static final int ERROR_REASON_FUEL_LOW = 3;
    protected volatile BatteryControlViewOptions currViewOptions;
    private BatteryControlTimerState currentTimerState;
    private BatteryControlListHandling bcListHandling;
    protected volatile int climateStateLastError = 0;
    private volatile BatteryControlClimateState climateState;
    private volatile BatteryControlChargeState chargeState;
    private Object stateMutex = new Object();
    private CarNetworkPlatformInfo networkPlatformInfo;
    public static final int INFOBOX_STATE_INACTIVE = 0;
    public static final int INFOBOX_STATE_ACTIVE = 1;
    public static final int INFOBOX_STATE_ERROR = 2;
    public static final int INFOBOX_ACTIVE_STATE_HEATING = 0;
    public static final int INFOBOX_ACTIVE_STATE_VENTILATION = 1;
    public static final int INFOBOX_ACTIVE_STATE_NONE = 2;
    public static final int INFOBOX_ACTIVE_STATE_NO_ICON = 2;
    public static final int INFOBOX_ERROR_STATE_GENERAL_DEFECT = 0;
    public static final int INFOBOX_ERROR_STATE_BATTERY_LOW = 1;
    public static final int INFOBOX_ERROR_STATE_FUEL_LOW = 2;
    public static final int POPUP_AUXCOMBINED_TEXT_VALUE_SHIFT_BY = 3;
    protected volatile AuxHeaterCoolerErrorReason pastAuxHeaterCoolerError = new AuxHeaterCoolerErrorReason();
    private IBattCtrlCommunicationService bcCommunicationService = null;
    private CarServiceTracker bcComminicationSeviceTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBattCtrlCommunicationService;

    public AbstractAuxACComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.currentTimerState = new BatteryControlTimerState(new BatteryControlProgrammedTimer(), new BatteryControlExpiredTimer());
        this.bcListHandling = new BatteryControlListHandling();
        this.networkPlatformInfo = new CarNetworkPlatformInfo(this.getApplication().getFrameworkAccess());
    }

    public String getName() {
        return "AuxCooler";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{9, 8, 10, 13, 14, 22})};
    }

    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    public void deinit() {
        super.deinit();
        this.bcListHandling.deinit();
        this.bcComminicationSeviceTracker.stopTracking();
    }

    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        this.bcListHandling.init();
        this.bcComminicationSeviceTracker = new CarServiceTracker(new BCCommunicationTrackerListener(this), this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcComminicationSeviceTracker.startTracking();
    }

    protected void initModels() {
        AuxCoolerButtonListener auxCoolerButtonListener = new AuxCoolerButtonListener();
        AuxCoolerChoiceListener auxCoolerChoiceListener = new AuxCoolerChoiceListener();
        AuxCoolerMetricsListener auxCoolerMetricsListener = new AuxCoolerMetricsListener();
        this.getButtonModel(2100394).setButtonListener(auxCoolerButtonListener);
        this.getButtonModel(2100395).setButtonListener(auxCoolerButtonListener);
        this.getChoiceModel(2100369).setChoiceListener(auxCoolerChoiceListener);
        this.getChoiceModel(2100362).setChoiceListener(auxCoolerChoiceListener);
        this.getMetricsModel(2100363).setMetricsListener(auxCoolerMetricsListener);
        this.getMetricsModel(2100364).setMetricsListener(auxCoolerMetricsListener);
        this.getChoiceModel(2100403).setChoiceListener(auxCoolerChoiceListener);
        this.getChoiceModel(2100372).setChoiceListener(auxCoolerChoiceListener);
        this.getChoiceModel(2100402).setChoiceListener(auxCoolerChoiceListener);
        this.getChoiceModel(2100756).setValue(-1);
    }

    protected void deinitModels() {
        this.getButtonModel(2100394).resetListener();
        this.getButtonModel(2100395).resetListener();
        this.getChoiceModel(2100369).resetListener();
        this.getChoiceModel(2100362).resetListener();
        this.getMetricsModel(2100363).resetListener();
        this.getMetricsModel(2100364).resetListener();
        this.getChoiceModel(2100403).resetListener();
        this.getChoiceModel(2100372).resetListener();
        this.getChoiceModel(2100402).resetListener();
    }

    private void checkProfileSettings(int n) {
        if (!this.bcListHandling.getService().isProfileXOperationClimate(n)) {
            this.bcListHandling.getService().setProfileXOperationClimate(n, true);
        }
        if (this.bcListHandling.getService().isProfileXOperationCharge(n)) {
            this.bcListHandling.getService().setProfileXOperationCharge(n, false);
        }
    }

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions var1);

    protected abstract void updateEntryVisibilityForStateChange(BatteryControlClimateState var1, BatteryControlChargeState var2, BatteryControlViewOptions var3);

    protected abstract void updateAuxACImmediateVisibilityState(int var1);

    protected abstract void updateAuxACImmediateOn(boolean var1);

    protected abstract void updateThermometerIconVisibility(int var1, int var2);

    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlViewOptions(%1), valid:%2", (Object)batteryControlViewOptions, (long)n);
        if (n == 1) {
            this.currViewOptions = batteryControlViewOptions;
            if (this.climateState == null && this.chargeState == null) {
                this.updateMenuEntryVisibility(this.currViewOptions);
            } else {
                this.updateEntryVisibilityForStateChange(this.climateState, this.chargeState, this.currViewOptions);
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1000000, "[AbstractAuxACComponent:updateBatteryControlClimateState] climateMode=%1, validFlag=%2", (Object)batteryControlClimateState.climateMode, (long)n);
        if (n == 1) {
            int n2 = -1;
            if (batteryControlClimateState != null) {
                Object object;
                if (batteryControlClimateState.climateMode != null) {
                    boolean bl = batteryControlClimateState.climateMode.isClimating();
                    n2 = batteryControlClimateState.climateState;
                    int n3 = batteryControlClimateState.climateMode.ventilation || batteryControlClimateState.climateMode.fuelBasedHeating ? 0 : (batteryControlClimateState.climateMode.heating || batteryControlClimateState.climateMode.cooling ? 1 : 2);
                    this.updateInfobox(batteryControlClimateState, n3);
                }
                if (batteryControlClimateState.climateState == 12) {
                    if (batteryControlClimateState.getClimatingTime() <= 1500 && batteryControlClimateState.getClimatingTime() > 0 && !this.networkPlatformInfo.isAU37x()) {
                        object = new DateMetric(new Date(batteryControlClimateState.climatingTime * 60000), 5);
                        this.getMetricsModel(2100559).setMetric((AbstractMetrics)object);
                    } else {
                        object = new DateMetric(new Date(0L), 5);
                        this.getMetricsModel(2100559).setMetric((AbstractMetrics)object);
                    }
                } else {
                    object = new DateMetric(new Date(0L), 5);
                    this.getMetricsModel(2100559).setMetric((AbstractMetrics)object);
                }
                object = this.stateMutex;
                synchronized (object) {
                    this.climateState = batteryControlClimateState;
                }
            }
        }
    }

    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlTimerState: timerState=%1, validFlag=%2", (Object)batteryControlTimerState, (long)n);
        if (n == 1) {
            this.currentTimerState = batteryControlTimerState;
            this.getChoiceModel(2100369).setValue(this.currentTimerState.programmedTimer.timer3 ? 1 : 0);
            this.getChoiceModel(2100362).setValue(this.currentTimerState.programmedTimer.timer4 ? 1 : 0);
        }
    }

    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        if (n == 1) {
            this.updateBatteryControlTimer(batteryControlTimer, 2100363);
        }
    }

    public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
        if (n == 1) {
            this.updateBatteryControlTimer(batteryControlTimer, 2100364);
        }
    }

    private void updateBatteryControlTimer(BatteryControlTimer batteryControlTimer, int n) {
        TimerHelper timerHelper = new TimerHelper(this.getApplication(), this.getLogChannel());
        timerHelper.setTimerMetric(timerHelper.castTimerToGeneralObject(batteryControlTimer), this.getMetricsModel(n), "updateBatteryControlTimer");
    }

    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        this.getLogChannel().log(10000000, "acknowledgeBatteryControlImmediately: success=%1, control=%2", bl, (long)n);
        if (this.climateState != null && this.climateState.climateMode != null) {
            boolean bl2 = this.climateState.climateMode.isClimating();
            this.getChoiceModel(2100756).setValue(this.climateState.climateMode.fuelBasedHeating ? 1 : 0);
            if (this.climateState.climateState == 10 && !this.climateState.climateMode.fuelBasedHeating) {
                this.updatePastErrorDisclaimerModel(10);
            } else {
                this.getChoiceModel(2100401).setValue(bl2 ? 1 : 0);
            }
        }
        switch (n) {
            case 0: {
                this.getLogChannel().log(10000000, "acknowledgeBatteryControlImmediately: stop - %1", (Object)(bl ? "successful" : "unsuccessful"));
                break;
            }
            case 1: {
                this.getLogChannel().log(10000000, "acknowledgeBatteryControlImmediately: start - %1", (Object)(bl ? "successful" : "unsuccessful"));
                this.getButtonModel(2100394).fireEvent(0);
                this.getChoiceModel(2100739).setValue(this.getChoiceModel(2100403).getValue());
                break;
            }
            default: {
                this.getLogChannel().log(10000, "acknowledgeBatteryControlImmediately: invalid control=%1", (long)n);
            }
        }
    }

    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1000000, "updateBatteryControlPastErrorReason: climateStateLastError=%1, validFlag=%2", (long)n2, (long)n4);
        if (this.climateState != null && this.climateState.climateMode != null) {
            this.getChoiceModel(2100756).setValue(this.climateState.climateMode.fuelBasedHeating ? 1 : 0);
        }
        if (n4 == 1) {
            this.setClimateStatePastError(n2);
            this.updatePastErrorDisclaimerModel(n2);
        }
    }

    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannel().log(1000000, "[AbstractAuxACComponent#updateBatteryControlChargeState] dsiChargeState=%1, validFlag=%2", (Object)batteryControlChargeState, (long)n);
        if (n == 1 && batteryControlChargeState != null) {
            if (batteryControlChargeState.chargeState == 7) {
                this.getChoiceModel(2100739).setValue(this.getChoiceModel(2100403).getValue() + 3);
            }
            BatteryControlChargeState batteryControlChargeState2 = new BatteryControlChargeState();
            batteryControlChargeState2 = (BatteryControlChargeState)ListHandlingHelper.cloneTo(batteryControlChargeState, batteryControlChargeState2);
            batteryControlChargeState2.chargeState = 1;
            this.chargeState = batteryControlChargeState2;
            this.getLogChannel().log(1000000, "calling -> updateEntryVisibilityForError with climateState %1 and chargeState %2", (Object)this.climateState, (Object)this.chargeState);
            this.updateEntryVisibilityForStateChange(this.climateState, this.chargeState, this.currViewOptions);
        }
    }

    protected synchronized void updatePastErrorDisclaimerModel(int n) {
        if (n == 18 || n == 0) {
            this.getChoiceModel(2100465).setValue(0);
            return;
        }
        if (n == 10) {
            this.getLogChannel().log(1000000, "SHOW BATTERY LOW");
            this.getChoiceModel(2100465).setValue(2);
            return;
        }
        if (n == 3) {
            this.getLogChannel().log(1000000, "SHOW FUEL LOW");
            this.getChoiceModel(2100465).setValue(3);
            return;
        }
        this.getChoiceModel(2100465).setValue(1);
        this.getLogChannel().log(1000000, "SHOW GENERALDEVICE ERROR");
    }

    private void setClimateStatePastError(int n) {
        this.climateStateLastError = n;
    }

    protected void resetPastError() {
        this.getLogChannel().log(1000000, "[AbstractAuxAcComponent#resetPastError] screen with past error entered, resetting the error until next bus cycle");
        this.getDSI().setBatteryControlPastErrorReason(0);
        this.getChoiceModel(600710).setValue(0);
    }

    protected synchronized void updateInfobox(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1000000, "[AbstractAuxAcComponent#updateInfobox] last received: state='%1', error='%2'", (Object)batteryControlClimateState, (long)n);
        if (batteryControlClimateState.climateState == 7) {
            this.getLogChannel().log(1000000, "SHOW GENERALDEVICE ERROR");
            this.getChoiceModel(2100477).setValue(2);
            this.getChoiceModel(2100476).setValue(0);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else if (batteryControlClimateState.climateState == 10) {
            this.getLogChannel().log(1000000, "SHOW BATTERY LOW");
            this.getChoiceModel(2100477).setValue(2);
            this.getChoiceModel(2100476).setValue(1);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else if (batteryControlClimateState.climateState == 3) {
            this.getLogChannel().log(1000000, "SHOW FUEL LOW");
            this.getChoiceModel(2100477).setValue(2);
            this.getChoiceModel(2100476).setValue(2);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else if (batteryControlClimateState.climateState == 12) {
            this.getLogChannel().log(1000000, "SHOW NO ERROR. STATE ACTIVE");
            this.getChoiceModel(2100477).setValue(1);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else {
            this.getChoiceModel(2100477).setValue(0);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        }
        this.getLogChannel().log(1000000, "currentClimateMode is: %1", (long)n);
        switch (n) {
            case 0: {
                this.getLogChannel().log(1000000, "SHOW HEATING ICON");
                this.getChoiceModel(2100474).setValue(0);
                break;
            }
            case 1: {
                this.getLogChannel().log(1000000, "SHOW THERMOMETER ICON");
                this.getChoiceModel(2100474).setValue(1);
                break;
            }
            default: {
                this.getLogChannel().log(1000000, "DEFAULT CASE");
                this.getChoiceModel(2100474).setValue(2);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class AuxCoolerButtonListener
    extends DefaultButtonListener {
        private AuxCoolerButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            AbstractAuxACComponent.this.logModelData("keyPressed", n, n2, true);
            switch (n) {
                case 2100394: {
                    this.switchImmediate(1);
                    break;
                }
                case 2100395: {
                    this.switchImmediate(0);
                    break;
                }
            }
        }

        private void switchImmediate(int n) {
            AbstractAuxACComponent.this.checkProfileSettings(6);
            AbstractAuxACComponent.this.getLogChannel().log(1000000, "dsi.setBatteryControlImmediately(6,%1)", (long)n);
            AbstractAuxACComponent.this.getDSI().setBatteryControlImmediately(6, n);
        }
    }

    private final class AuxCoolerChoiceListener
    extends DefaultChoiceListener {
        private AuxCoolerChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractAuxACComponent.this.logModelData("itemSelected:", n, n2, true);
            switch (n) {
                case 2100369: {
                    AbstractAuxACComponent.this.getLogChannel().log(1000000, "%1 timer1 ", (Object)(n2 == 1 ? "activate" : "deactivate"));
                    this.switchTimerActivation(n2 == 1, false);
                    break;
                }
                case 2100362: {
                    AbstractAuxACComponent.this.getLogChannel().log(1000000, "%1 timer2 ", (Object)(n2 == 1 ? "activate" : "deactivate"));
                    this.switchTimerActivation(false, n2 == 1);
                    break;
                }
                case 2100403: {
                    AbstractAuxACComponent.this.bcListHandling.getService().setAuxAcClimateSystem(6, n2);
                    break;
                }
                case 2100372: {
                    AbstractAuxACComponent.this.bcListHandling.getService().setAuxAcClimateSystem(3, n2);
                    break;
                }
                case 2100402: {
                    AbstractAuxACComponent.this.bcListHandling.getService().setAuxAcClimateSystem(4, n2);
                    break;
                }
                default: {
                    AbstractAuxACComponent.this.logModelData("itemSelected:", n, n2, false);
                }
            }
        }

        private void switchTimerActivation(boolean bl, boolean bl2) {
            BatteryControlProgrammedTimer batteryControlProgrammedTimer = new BatteryControlProgrammedTimer(((AbstractAuxACComponent)AbstractAuxACComponent.this).currentTimerState.programmedTimer.timer1, ((AbstractAuxACComponent)AbstractAuxACComponent.this).currentTimerState.programmedTimer.timer2, bl, bl2);
            AbstractAuxACComponent.this.getLogChannel().log(1000000, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
            AbstractAuxACComponent.this.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
        }
    }

    private final class AuxCoolerMetricsListener
    implements MetricsListener {
        private AuxCoolerMetricsListener() {
        }

        public void metricsUpdated(int n, int n2) {
            AbstractAuxACComponent.this.logModelData("metricsUpdated", n, 0, true);
            switch (n) {
                case 2100363: {
                    this.setTimer(3, AbstractAuxACComponent.this.getDateMetric(n).getDate());
                    break;
                }
                case 2100364: {
                    this.setTimer(4, AbstractAuxACComponent.this.getDateMetric(n).getDate());
                    break;
                }
                default: {
                    AbstractAuxACComponent.this.logModelData("metricsUpdated", n, 0, false);
                }
            }
        }

        private void setTimer(int n, Date date) {
            int n2;
            Calendar calendar = TimerHelper.getCorrectCalendarFromDate(date);
            switch (n) {
                case 3: {
                    n2 = 3;
                    break;
                }
                case 4: {
                    n2 = 4;
                    break;
                }
                default: {
                    AbstractAuxACComponent.this.getLogChannel().log(10000000, "[AbstractAuxACComponent.AuxCoolerMetricsListener#setTimer] invalid timerID=%1", (long)n);
                    return;
                }
            }
            AbstractAuxACComponent.this.checkProfileSettings(n2);
            AbstractAuxACComponent.this.getLogChannel().log(1000000, "setTimer: dsi.setBatteryControlTimer(timerID=%2, profileID=%3, date=%1)", (Object)date, (long)n, (long)n2);
            AbstractAuxACComponent.this.getDSI().setBatteryControlTimer(n, calendar.get(1), calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), new BatteryControlWeekdays(), n2);
            if (AbstractAuxACComponent.this.bcCommunicationService != null) {
                AbstractAuxACComponent.this.bcCommunicationService.climateTimerMetricsUpdated(n);
            }
        }
    }

    private class BatteryControlListHandling
    implements IBatteryControlListHandlingCallback,
    CarServiceTrackerListener {
        private CarServiceTracker bcListHandlingTracker;
        private IBatteryControlListHandlingService bcListHandlingService = null;

        public void init() {
            this.bcListHandlingTracker = new CarServiceTracker(this, AbstractAuxACComponent.this.getApplication().getBundleContext(), AbstractAuxACComponent.this.getLogChannel());
            this.bcListHandlingTracker.startTracking();
        }

        public void deinit() {
            this.bcListHandlingTracker.stopTracking();
        }

        public IBatteryControlListHandlingService getService() {
            return this.bcListHandlingService;
        }

        public void serviceAvailable(Object object) {
            this.bcListHandlingService = (IBatteryControlListHandlingService)object;
            this.bcListHandlingService.registerCalledBackComponent(this);
        }

        public void serviceRemoved() {
            this.bcListHandlingService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractAuxACComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
        }

        public void updateClimateSystemType(int n, int n2) {
            switch (n) {
                case 6: {
                    AbstractAuxACComponent.this.getChoiceModel(2100403).setValue(n2);
                    break;
                }
                case 3: {
                    AbstractAuxACComponent.this.getChoiceModel(2100372).setValue(n2);
                    AbstractAuxACComponent.this.updateThermometerIconVisibility(1, n2);
                    break;
                }
                case 4: {
                    AbstractAuxACComponent.this.getChoiceModel(2100402).setValue(n2);
                    AbstractAuxACComponent.this.updateThermometerIconVisibility(2, n2);
                }
                default: {
                    AbstractAuxACComponent.this.getLogChannel().log(10000000, "[AbstractAuxCoolerComponent.BatteryControlListHandling#setClimateSystemType] profileId=%1 not handled", (long)n);
                }
            }
        }

        public void updateChargeTimerClimateChoice(int n, int n2) {
        }

        public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
        }
    }

    private class BCCommunicationTrackerListener
    implements CarServiceTrackerListener {
        private AbstractAuxACComponent component;

        public BCCommunicationTrackerListener(AbstractAuxACComponent abstractAuxACComponent2) {
            this.component = abstractAuxACComponent2;
        }

        public void serviceAvailable(Object object) {
            AbstractAuxACComponent.this.bcCommunicationService = (IBattCtrlCommunicationService)object;
        }

        public void serviceRemoved() {
            AbstractAuxACComponent.this.bcCommunicationService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$IBattCtrlCommunicationService == null ? (class$de$audi$atip$interapp$IBattCtrlCommunicationService = AbstractAuxACComponent.class$("de.audi.atip.interapp.IBattCtrlCommunicationService")) : class$de$audi$atip$interapp$IBattCtrlCommunicationService).getName()};
        }
    }
}

