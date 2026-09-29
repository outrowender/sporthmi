/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.listhandling.ListHandlingHelper;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$AuxCoolerButtonListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$AuxCoolerChoiceListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$AuxCoolerMetricsListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$BCCommunicationTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractAuxACComponent$BatteryControlListHandling;
import de.audi.app.earlyfunc.core.hybrid.CarNetworkPlatformInfo;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IBattCtrlCommunicationService;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import java.util.Date;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerErrorReason;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlExpiredTimer;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;

public abstract class AbstractAuxACComponent
extends AbstractDSICarHybridAdapter {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    private static final int TIMER_ID_TIMER1;
    private static final int TIMER_ID_TIMER2;
    private static final int PROFILE_ID_TIMER1;
    private static final int PROFILE_ID_TIMER2;
    private static final int PROFILE_ID_IMMEDIATE;
    protected static final int IMMEDIATE_CONTROL_STOP;
    protected static final int IMMEDIATE_CONTROL_START;
    private static final int ERROR_REASON_NONE;
    private static final int ERROR_REASON_GENERALDEVICEERROR;
    private static final int ERROR_REASON_BATTERY_LOW;
    private static final int ERROR_REASON_FUEL_LOW;
    protected volatile BatteryControlViewOptions currViewOptions;
    private BatteryControlTimerState currentTimerState;
    private AbstractAuxACComponent$BatteryControlListHandling bcListHandling;
    protected volatile int climateStateLastError = 0;
    private volatile BatteryControlClimateState climateState;
    private volatile BatteryControlChargeState chargeState;
    private Object stateMutex = new Object();
    private CarNetworkPlatformInfo networkPlatformInfo;
    public static final int INFOBOX_STATE_INACTIVE;
    public static final int INFOBOX_STATE_ACTIVE;
    public static final int INFOBOX_STATE_ERROR;
    public static final int INFOBOX_ACTIVE_STATE_HEATING;
    public static final int INFOBOX_ACTIVE_STATE_VENTILATION;
    public static final int INFOBOX_ACTIVE_STATE_NONE;
    public static final int INFOBOX_ACTIVE_STATE_NO_ICON;
    public static final int INFOBOX_ERROR_STATE_GENERAL_DEFECT;
    public static final int INFOBOX_ERROR_STATE_BATTERY_LOW;
    public static final int INFOBOX_ERROR_STATE_FUEL_LOW;
    public static final int POPUP_AUXCOMBINED_TEXT_VALUE_SHIFT_BY;
    protected volatile AuxHeaterCoolerErrorReason pastAuxHeaterCoolerError = new AuxHeaterCoolerErrorReason();
    private IBattCtrlCommunicationService bcCommunicationService = null;
    private CarServiceTracker bcComminicationSeviceTracker;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBattCtrlCommunicationService;

    public AbstractAuxACComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.AuxCooler");
        this.currentTimerState = new BatteryControlTimerState(new BatteryControlProgrammedTimer(), new BatteryControlExpiredTimer());
        this.bcListHandling = new AbstractAuxACComponent$BatteryControlListHandling(this);
        this.networkPlatformInfo = new CarNetworkPlatformInfo(this.getApplication().getFrameworkAccess());
    }

    @Override
    public String getName() {
        return "AuxCooler";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{9, 8, 10, 13, 14, 22})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currViewOptions == null) {
            return "no view options received yet";
        }
        return this.currViewOptions.toString();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.bcListHandling.deinit();
        this.bcComminicationSeviceTracker.stopTracking();
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        this.bcListHandling.init();
        this.bcComminicationSeviceTracker = new CarServiceTracker(new AbstractAuxACComponent$BCCommunicationTrackerListener(this, this), this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcComminicationSeviceTracker.startTracking();
    }

    @Override
    protected void initModels() {
        AbstractAuxACComponent$AuxCoolerButtonListener abstractAuxACComponent$AuxCoolerButtonListener = new AbstractAuxACComponent$AuxCoolerButtonListener(this, null);
        AbstractAuxACComponent$AuxCoolerChoiceListener abstractAuxACComponent$AuxCoolerChoiceListener = new AbstractAuxACComponent$AuxCoolerChoiceListener(this, null);
        AbstractAuxACComponent$AuxCoolerMetricsListener abstractAuxACComponent$AuxCoolerMetricsListener = new AbstractAuxACComponent$AuxCoolerMetricsListener(this, null);
        this.getButtonModel(-1442045952).setButtonListener(abstractAuxACComponent$AuxCoolerButtonListener);
        this.getButtonModel(-1425268736).setButtonListener(abstractAuxACComponent$AuxCoolerButtonListener);
        this.getChoiceModel(-1861476352).setChoiceListener(abstractAuxACComponent$AuxCoolerChoiceListener);
        this.getChoiceModel(-1978916864).setChoiceListener(abstractAuxACComponent$AuxCoolerChoiceListener);
        this.getMetricsModel(-1962139648).setMetricsListener(abstractAuxACComponent$AuxCoolerMetricsListener);
        this.getMetricsModel(-1945362432).setMetricsListener(abstractAuxACComponent$AuxCoolerMetricsListener);
        this.getChoiceModel(-1291051008).setChoiceListener(abstractAuxACComponent$AuxCoolerChoiceListener);
        this.getChoiceModel(-1811144704).setChoiceListener(abstractAuxACComponent$AuxCoolerChoiceListener);
        this.getChoiceModel(-1307828224).setChoiceListener(abstractAuxACComponent$AuxCoolerChoiceListener);
        this.getChoiceModel(336470016).setValue(-1);
    }

    @Override
    protected void deinitModels() {
        this.getButtonModel(-1442045952).resetListener();
        this.getButtonModel(-1425268736).resetListener();
        this.getChoiceModel(-1861476352).resetListener();
        this.getChoiceModel(-1978916864).resetListener();
        this.getMetricsModel(-1962139648).resetListener();
        this.getMetricsModel(-1945362432).resetListener();
        this.getChoiceModel(-1291051008).resetListener();
        this.getChoiceModel(-1811144704).resetListener();
        this.getChoiceModel(-1307828224).resetListener();
    }

    private void checkProfileSettings(int n) {
        if (!this.bcListHandling.getService().isProfileXOperationClimate(n)) {
            this.bcListHandling.getService().setProfileXOperationClimate(n, true);
        }
        if (this.bcListHandling.getService().isProfileXOperationCharge(n)) {
            this.bcListHandling.getService().setProfileXOperationCharge(n, false);
        }
    }

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
    }

    protected abstract void updateEntryVisibilityForStateChange(BatteryControlClimateState batteryControlClimateState, BatteryControlChargeState batteryControlChargeState, BatteryControlViewOptions batteryControlViewOptions) {
    }

    protected abstract void updateAuxACImmediateVisibilityState(int n) {
    }

    protected abstract void updateAuxACImmediateOn(boolean bl) {
    }

    protected abstract void updateThermometerIconVisibility(int n, int n2) {
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlViewOptions(%1), valid:%2", (Object)batteryControlViewOptions, (long)n);
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
    @Override
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1078071040, "[AbstractAuxACComponent:updateBatteryControlClimateState] climateMode=%1, validFlag=%2", (Object)batteryControlClimateState.climateMode, (long)n);
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
                        object = new DateMetric(new Date(batteryControlClimateState.climatingTime * 1625948160), 5);
                        this.getMetricsModel(1326260224).setMetric((AbstractMetrics)object);
                    } else {
                        object = new DateMetric(new Date(0L), 5);
                        this.getMetricsModel(1326260224).setMetric((AbstractMetrics)object);
                    }
                } else {
                    object = new DateMetric(new Date(0L), 5);
                    this.getMetricsModel(1326260224).setMetric((AbstractMetrics)object);
                }
                object = this.stateMutex;
                synchronized (object) {
                    this.climateState = batteryControlClimateState;
                }
            }
        }
    }

    @Override
    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlTimerState: timerState=%1, validFlag=%2", (Object)batteryControlTimerState, (long)n);
        if (n == 1) {
            this.currentTimerState = batteryControlTimerState;
            this.getChoiceModel(-1861476352).setValue(this.currentTimerState.programmedTimer.timer3 ? 1 : 0);
            this.getChoiceModel(-1978916864).setValue(this.currentTimerState.programmedTimer.timer4 ? 1 : 0);
        }
    }

    @Override
    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        if (n == 1) {
            this.updateBatteryControlTimer(batteryControlTimer, -1962139648);
        }
    }

    @Override
    public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
        if (n == 1) {
            this.updateBatteryControlTimer(batteryControlTimer, -1945362432);
        }
    }

    private void updateBatteryControlTimer(BatteryControlTimer batteryControlTimer, int n) {
        TimerHelper timerHelper = new TimerHelper(this.getApplication(), this.getLogChannel());
        timerHelper.setTimerMetric(timerHelper.castTimerToGeneralObject(batteryControlTimer), this.getMetricsModel(n), "updateBatteryControlTimer");
    }

    @Override
    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        this.getLogChannel().log(-2137614336, "acknowledgeBatteryControlImmediately: success=%1, control=%2", bl, (long)n);
        if (this.climateState != null && this.climateState.climateMode != null) {
            boolean bl2 = this.climateState.climateMode.isClimating();
            this.getChoiceModel(336470016).setValue(this.climateState.climateMode.fuelBasedHeating ? 1 : 0);
            if (this.climateState.climateState == 10 && !this.climateState.climateMode.fuelBasedHeating) {
                this.updatePastErrorDisclaimerModel(10);
            } else {
                this.getChoiceModel(-1324605440).setValue(bl2 ? 1 : 0);
            }
        }
        switch (n) {
            case 0: {
                this.getLogChannel().log(-2137614336, "acknowledgeBatteryControlImmediately: stop - %1", (Object)(bl ? "successful" : "unsuccessful"));
                break;
            }
            case 1: {
                this.getLogChannel().log(-2137614336, "acknowledgeBatteryControlImmediately: start - %1", (Object)(bl ? "successful" : "unsuccessful"));
                this.getButtonModel(-1442045952).fireEvent(0);
                this.getChoiceModel(51257344).setValue(this.getChoiceModel(-1291051008).getValue());
                break;
            }
            default: {
                this.getLogChannel().log(10000, "acknowledgeBatteryControlImmediately: invalid control=%1", (long)n);
            }
        }
    }

    @Override
    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1078071040, "updateBatteryControlPastErrorReason: climateStateLastError=%1, validFlag=%2", (long)n2, (long)n4);
        if (this.climateState != null && this.climateState.climateMode != null) {
            this.getChoiceModel(336470016).setValue(this.climateState.climateMode.fuelBasedHeating ? 1 : 0);
        }
        if (n4 == 1) {
            this.setClimateStatePastError(n2);
            this.updatePastErrorDisclaimerModel(n2);
        }
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannel().log(1078071040, "[AbstractAuxACComponent#updateBatteryControlChargeState] dsiChargeState=%1, validFlag=%2", (Object)batteryControlChargeState, (long)n);
        if (n == 1 && batteryControlChargeState != null) {
            if (batteryControlChargeState.chargeState == 7) {
                this.getChoiceModel(51257344).setValue(this.getChoiceModel(-1291051008).getValue() + 3);
            }
            BatteryControlChargeState batteryControlChargeState2 = new BatteryControlChargeState();
            batteryControlChargeState2 = (BatteryControlChargeState)ListHandlingHelper.cloneTo(batteryControlChargeState, batteryControlChargeState2);
            batteryControlChargeState2.chargeState = 1;
            this.chargeState = batteryControlChargeState2;
            this.getLogChannel().log(1078071040, "calling -> updateEntryVisibilityForError with climateState %1 and chargeState %2", (Object)this.climateState, (Object)this.chargeState);
            this.updateEntryVisibilityForStateChange(this.climateState, this.chargeState, this.currViewOptions);
        }
    }

    protected synchronized void updatePastErrorDisclaimerModel(int n) {
        if (n == 18 || n == 0) {
            this.getChoiceModel(-250863616).setValue(0);
            return;
        }
        if (n == 10) {
            this.getLogChannel().log(1078071040, "SHOW BATTERY LOW");
            this.getChoiceModel(-250863616).setValue(2);
            return;
        }
        if (n == 3) {
            this.getLogChannel().log(1078071040, "SHOW FUEL LOW");
            this.getChoiceModel(-250863616).setValue(3);
            return;
        }
        this.getChoiceModel(-250863616).setValue(1);
        this.getLogChannel().log(1078071040, "SHOW GENERALDEVICE ERROR");
    }

    private void setClimateStatePastError(int n) {
        this.climateStateLastError = n;
    }

    protected void resetPastError() {
        this.getLogChannel().log(1078071040, "[AbstractAuxAcComponent#resetPastError] screen with past error entered, resetting the error until next bus cycle");
        this.getDSI().setBatteryControlPastErrorReason(0);
        this.getChoiceModel(-2044065536).setValue(0);
    }

    protected synchronized void updateInfobox(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1078071040, "[AbstractAuxAcComponent#updateInfobox] last received: state='%1', error='%2'", (Object)batteryControlClimateState, (long)n);
        if (batteryControlClimateState.climateState == 7) {
            this.getLogChannel().log(1078071040, "SHOW GENERALDEVICE ERROR");
            this.getChoiceModel(-49537024).setValue(2);
            this.getChoiceModel(-66314240).setValue(0);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else if (batteryControlClimateState.climateState == 10) {
            this.getLogChannel().log(1078071040, "SHOW BATTERY LOW");
            this.getChoiceModel(-49537024).setValue(2);
            this.getChoiceModel(-66314240).setValue(1);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else if (batteryControlClimateState.climateState == 3) {
            this.getLogChannel().log(1078071040, "SHOW FUEL LOW");
            this.getChoiceModel(-49537024).setValue(2);
            this.getChoiceModel(-66314240).setValue(2);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else if (batteryControlClimateState.climateState == 12) {
            this.getLogChannel().log(1078071040, "SHOW NO ERROR. STATE ACTIVE");
            this.getChoiceModel(-49537024).setValue(1);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        } else {
            this.getChoiceModel(-49537024).setValue(0);
            this.updateEntryVisibilityForStateChange(batteryControlClimateState, this.chargeState, this.currViewOptions);
        }
        this.getLogChannel().log(1078071040, "currentClimateMode is: %1", (long)n);
        switch (n) {
            case 0: {
                this.getLogChannel().log(1078071040, "SHOW HEATING ICON");
                this.getChoiceModel(-99868672).setValue(0);
                break;
            }
            case 1: {
                this.getLogChannel().log(1078071040, "SHOW THERMOMETER ICON");
                this.getChoiceModel(-99868672).setValue(1);
                break;
            }
            default: {
                this.getLogChannel().log(1078071040, "DEFAULT CASE");
                this.getChoiceModel(-99868672).setValue(2);
            }
        }
    }

    static /* synthetic */ ICarApplication access$000(AbstractAuxACComponent abstractAuxACComponent) {
        return abstractAuxACComponent.getApplication();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ChoiceModelApp access$100(AbstractAuxACComponent abstractAuxACComponent, int n) {
        return abstractAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$200(AbstractAuxACComponent abstractAuxACComponent, int n) {
        return abstractAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$300(AbstractAuxACComponent abstractAuxACComponent, int n) {
        return abstractAuxACComponent.getChoiceModel(n);
    }

    static /* synthetic */ void access$400(AbstractAuxACComponent abstractAuxACComponent, String string, int n, int n2, boolean bl) {
        abstractAuxACComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ void access$500(AbstractAuxACComponent abstractAuxACComponent, int n) {
        abstractAuxACComponent.checkProfileSettings(n);
    }

    static /* synthetic */ void access$600(AbstractAuxACComponent abstractAuxACComponent, String string, int n, int n2, boolean bl) {
        abstractAuxACComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ AbstractAuxACComponent$BatteryControlListHandling access$700(AbstractAuxACComponent abstractAuxACComponent) {
        return abstractAuxACComponent.bcListHandling;
    }

    static /* synthetic */ void access$800(AbstractAuxACComponent abstractAuxACComponent, String string, int n, int n2, boolean bl) {
        abstractAuxACComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ BatteryControlTimerState access$900(AbstractAuxACComponent abstractAuxACComponent) {
        return abstractAuxACComponent.currentTimerState;
    }

    static /* synthetic */ void access$1000(AbstractAuxACComponent abstractAuxACComponent, String string, int n, int n2, boolean bl) {
        abstractAuxACComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ DateMetric access$1100(AbstractAuxACComponent abstractAuxACComponent, int n) {
        return abstractAuxACComponent.getDateMetric(n);
    }

    static /* synthetic */ DateMetric access$1200(AbstractAuxACComponent abstractAuxACComponent, int n) {
        return abstractAuxACComponent.getDateMetric(n);
    }

    static /* synthetic */ void access$1300(AbstractAuxACComponent abstractAuxACComponent, String string, int n, int n2, boolean bl) {
        abstractAuxACComponent.logModelData(string, n, n2, bl);
    }

    static /* synthetic */ IBattCtrlCommunicationService access$1400(AbstractAuxACComponent abstractAuxACComponent) {
        return abstractAuxACComponent.bcCommunicationService;
    }

    static /* synthetic */ IBattCtrlCommunicationService access$1402(AbstractAuxACComponent abstractAuxACComponent, IBattCtrlCommunicationService iBattCtrlCommunicationService) {
        abstractAuxACComponent.bcCommunicationService = iBattCtrlCommunicationService;
        return abstractAuxACComponent.bcCommunicationService;
    }
}

