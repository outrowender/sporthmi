/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.util.MiscHybridHelper;
import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.earlyfunc.core.hybrid.AbstractChargeComponent$BCCommunicationTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractChargeComponent$BCListHandlingTrackerListener;
import de.audi.app.earlyfunc.core.hybrid.CarNetworkPlatformInfo;
import de.audi.app.earlyfunc.core.hybrid.ChargeSubCarTimeUnitsLanguageComponent;
import de.audi.app.earlyfunc.core.hybrid.IDateTimeChangeListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.interapp.IBattCtrlCommunicationService;
import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingService;
import de.audi.atip.metrics.DateMetric;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlConfiguration;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public abstract class AbstractChargeComponent
extends AbstractDSICarHybridAdapter
implements ChoiceListener,
MetricsListener,
IBatteryControlListHandlingCallback,
IDateTimeChangeListener {
    public static final short CODING_ID;
    private static final String LOGCHANNEL_NAME;
    static final int TIMER_TYPE_CYCLIC;
    private static final int BATTERY_CHARGE_STATE_NOT_RUNNING;
    private static final int BATTERY_CHARGE_STATE_RUNNING;
    private static final int BATTERY_PLUG_STATE_NOT_PLUGGED;
    private static final int BATTERY_PLUG_STATE_PLUGGED;
    private static final int BATTERY_PLUG_COLOR_GREY;
    private static final int BATTERY_PLUG_COLOR_GREEN;
    private static final int BATTERY_PLUG_COLOR_YELLOW;
    private static final int BATTERY_PLUG_COLOR_RED;
    private static final int BATTERY_PLUG_ANIMATION_NONE;
    private static final int BATTERY_PLUG_ANIMATION_BLINK;
    private static final int BATTERY_PLUG_ANIMATION_PULSE;
    private static final int BATTERY_PLUG_ANIMATION_FLASH;
    private static final int ERROR_REASON_NONE;
    private static final int ERROR_REASON_GENERALDEVICEERROR;
    private static final int TIMER_VALUE_INVALID;
    private static final int TIMER_1;
    private static final int TIMER_2;
    private static final int TIMER_3;
    private static final int TIMER_4;
    private BatteryControlViewOptions currBConViewOptions;
    private BatteryControlConfiguration bcConfig = null;
    private BatteryControlWeekdays selectedWeekdaysTimer1 = new BatteryControlWeekdays();
    private BatteryControlWeekdays selectedWeekdaysTimer2 = new BatteryControlWeekdays();
    private BatteryControlWeekdays selectedWeekdaysTimer3 = new BatteryControlWeekdays();
    private CarServiceTracker bcListHandlingTracker;
    private IBatteryControlListHandlingService bcListHandlingService = null;
    private IBattCtrlCommunicationService bcCommunicationService = null;
    private CarServiceTracker bcComminicationSeviceTracker;
    private TimerHelper timerHelper = null;
    private BatteryControlTimerState currentTimerState;
    protected BatteryControlChargeState chargeState;
    private CarNetworkPlatformInfo carNetworkPlatformInfo = null;
    private ChargeSubCarTimeUnitsLanguageComponent carTimeUnitsLanguageSubComponent = null;
    private BatteryControlTimer batteryControlTimer1 = null;
    private BatteryControlTimer batteryControlTimer2 = null;
    private BatteryControlTimer batteryControlTimer3 = null;
    private ClockTime clockTime = new ClockTime();
    private ClockDate clockDate = new ClockDate();
    Calendar dsiCalendar = Calendar.getInstance();
    ArrayList choiceModelList = new ArrayList();
    ArrayList metricsModelList = new ArrayList();
    private static final int PROFILE_ID_TIMER1;
    private static final int PROFILE_ID_TIMER2;
    private static final int PROFILE_ID_TIMER3;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBattCtrlCommunicationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;

    public abstract int getPopUpID() {
    }

    public AbstractChargeComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.Charge");
        this.carTimeUnitsLanguageSubComponent = new ChargeSubCarTimeUnitsLanguageComponent(this, iCarApplication, "App.EarlyFunc.Charge");
        this.timerHelper = new TimerHelper(iCarApplication, this.getLogChannel());
        this.carNetworkPlatformInfo = new CarNetworkPlatformInfo(iCarApplication.getFrameworkAccess());
    }

    @Override
    public void init() {
        super.init();
        this.carTimeUnitsLanguageSubComponent.init();
        this.bcComminicationSeviceTracker = new CarServiceTracker(new AbstractChargeComponent$BCCommunicationTrackerListener(this, this), this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcComminicationSeviceTracker.startTracking();
    }

    @Override
    public void deinit() {
        this.carTimeUnitsLanguageSubComponent.deinit();
        super.deinit();
        this.bcComminicationSeviceTracker.stopTracking();
        this.bcListHandlingTracker.stopTracking();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-1995694080).setChoiceListener(this);
        this.getChoiceModel(-1878253568).setChoiceListener(this);
        this.getChoiceModel(1024270336).setChoiceListener(this);
        this.getChoiceModel(-1022615552).setChoiceListener(this);
        this.getMetricsModel(-1827921920).setMetricsListener(this);
        this.getMetricsModel(-1844699136).setMetricsListener(this);
        this.getMetricsModel(1074601984).setMetricsListener(this);
        this.getMetricsModel(-888397824).setMetricsListener(this);
        this.getMetricsModel(-921952256).setMetricsListener(this);
        this.getChoiceModel(-905175040).setChoiceListener(this);
        this.getChoiceModel(-1140056064).setChoiceListener(this);
        this.getChoiceModel(973938688).setChoiceListener(this);
        this.getChoiceModel(-804511744).setChoiceListener(this);
        this.getChoiceModel(-1123278848).setChoiceListener(this);
        this.getChoiceModel(-821288960).setChoiceListener(this);
        this.getChoiceModel(-1039392768).setChoiceListener(this);
        this.getChoiceModel(-854843392).setChoiceListener(this);
        this.getChoiceModel(-938729472).setChoiceListener(this);
        this.getChoiceModel(-770957312).setChoiceListener(this);
        this.getChoiceModel(-838066176).setChoiceListener(this);
        this.getChoiceModel(-972283904).setChoiceListener(this);
        this.getChoiceModel(-955506688).setChoiceListener(this);
        this.getChoiceModel(-1173610496).setChoiceListener(this);
        this.getChoiceModel(-1056169984).setChoiceListener(this);
        this.getChoiceModel(-1072947200).setChoiceListener(this);
        this.getChoiceModel(-1106501632).setChoiceListener(this);
        this.getChoiceModel(-989061120).setChoiceListener(this);
        this.getChoiceModel(-1207164928).setChoiceListener(this);
        this.getChoiceModel(940384256).setChoiceListener(this);
        this.getChoiceModel(1057824768).setChoiceListener(this);
        this.getChoiceModel(923607040).setChoiceListener(this);
        this.getChoiceModel(1007493120).setChoiceListener(this);
        this.getChoiceModel(1091379200).setChoiceListener(this);
        this.getChoiceModel(1041047552).setChoiceListener(this);
        this.getChoiceModel(1108156416).setChoiceListener(this);
        DateMetric dateMetric = (DateMetric)this.getMetricsModel(-1005838336).getMetric();
        DateMetric dateMetric2 = (DateMetric)this.getMetricsModel(-1156833280).getMetric();
        DateMetric dateMetric3 = (DateMetric)this.getMetricsModel(-871620608).getMetric();
        DateMetric dateMetric4 = (DateMetric)this.getMetricsModel(-1190387712).getMetric();
        if (dateMetric == null) {
            dateMetric = new DateMetric(new Date(), 2);
            dateMetric.setDate(new Date());
            dateMetric3 = new DateMetric(new Date(), 2);
            dateMetric3.setDate(new Date());
            dateMetric2 = new DateMetric(new Date(), 2);
            dateMetric2.setDate(new Date());
            dateMetric4 = new DateMetric(new Date(), 2);
            dateMetric4.setDate(new Date());
            this.getMetricsModel(-1005838336).setMetric(dateMetric);
            this.getMetricsModel(-1156833280).setMetric(dateMetric2);
            this.getMetricsModel(-871620608).setMetric(dateMetric3);
            this.getMetricsModel(-1190387712).setMetric(dateMetric4);
        }
        this.getMetricsModel(-1005838336).setMetricsListener(this);
        this.getMetricsModel(-1156833280).setMetricsListener(this);
        this.getMetricsModel(-871620608).setMetricsListener(this);
        this.getMetricsModel(-1190387712).setMetricsListener(this);
        this.getChoiceModel(-787734528).setChoiceListener(this);
        this.getChoiceModel(-1089724416).setChoiceListener(this);
        this.getChoiceModel(990715904).setChoiceListener(this);
        this.choiceModelList.add(this.getChoiceModel(-1995694080));
        this.choiceModelList.add(this.getChoiceModel(-1878253568));
        this.choiceModelList.add(this.getChoiceModel(1024270336));
        this.metricsModelList.add(this.getMetricsModel(-1827921920));
        this.metricsModelList.add(this.getMetricsModel(-1844699136));
        this.metricsModelList.add(this.getMetricsModel(1074601984));
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(-1995694080).resetListener();
        this.getChoiceModel(-1878253568).resetListener();
        this.getChoiceModel(1024270336).resetListener();
        this.getChoiceModel(-1022615552).resetListener();
        this.getMetricsModel(-1827921920).resetListener();
        this.getMetricsModel(-1844699136).resetListener();
        this.getMetricsModel(1074601984).resetListener();
        this.getMetricsModel(-888397824).resetListener();
        this.getMetricsModel(-921952256).resetListener();
        this.getChoiceModel(-905175040).resetListener();
        this.getChoiceModel(-1140056064).resetListener();
        this.getChoiceModel(-804511744).resetListener();
        this.getChoiceModel(-1123278848).resetListener();
        this.getChoiceModel(-821288960).resetListener();
        this.getChoiceModel(-1039392768).resetListener();
        this.getChoiceModel(-854843392).resetListener();
        this.getChoiceModel(-938729472).resetListener();
        this.getChoiceModel(-770957312).resetListener();
        this.getChoiceModel(-838066176).resetListener();
        this.getChoiceModel(-972283904).resetListener();
        this.getChoiceModel(-955506688).resetListener();
        this.getChoiceModel(-1173610496).resetListener();
        this.getChoiceModel(-1056169984).resetListener();
        this.getChoiceModel(-1072947200).resetListener();
        this.getChoiceModel(-1106501632).resetListener();
        this.getChoiceModel(-989061120).resetListener();
        this.getChoiceModel(-1207164928).resetListener();
        this.getChoiceModel(940384256).resetListener();
        this.getChoiceModel(1057824768).resetListener();
        this.getChoiceModel(923607040).resetListener();
        this.getChoiceModel(1007493120).resetListener();
        this.getChoiceModel(1091379200).resetListener();
        this.getChoiceModel(1041047552).resetListener();
        this.getChoiceModel(1108156416).resetListener();
        this.getMetricsModel(-1005838336).resetListener();
        this.getMetricsModel(-1156833280).resetListener();
        this.getMetricsModel(-871620608).resetListener();
        this.getMetricsModel(-1190387712).resetListener();
        this.getChoiceModel(-787734528).resetListener();
        this.getChoiceModel(-1089724416).resetListener();
        this.getChoiceModel(990715904).resetListener();
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        this.getLogChannel().log(1078071040, "DSI available, starting BCListHandling Service...");
        this.bcListHandlingTracker = new CarServiceTracker(new AbstractChargeComponent$BCListHandlingTrackerListener(this, this), this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcListHandlingTracker.startTracking();
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{7, 24, 11, 12, 13, 10, 23, 19, 18, 15, 17, 9, 8, 22, 2})};
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currBConViewOptions == null) {
            return "no view options received yet";
        }
        return this.currBConViewOptions.toString();
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "updateBatteryControlViewOptions(%1), valid=%2", (Object)(batteryControlViewOptions != null ? this.formatViewOptionsLog(batteryControlViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && batteryControlViewOptions != null) {
            this.currBConViewOptions = batteryControlViewOptions;
            if (this.chargeState == null) {
                this.updateMenuEntryVisibility(this.currBConViewOptions);
            } else {
                this.updateEntryVisibilityForError(this.chargeState, this.currBConViewOptions);
            }
            if (batteryControlViewOptions.getConfiguration() != null) {
                this.bcConfig = batteryControlViewOptions.getConfiguration();
            }
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void updateBatteryControlPlugDisplayState(int n, int n2, int n3) {
        this.getLogChannel().log(1078071040, "updateBatteryControlPlugDisplayState: color=%1, state=%2, validFlag=%3", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            switch (n) {
                case 0: {
                    this.getChoiceModel(-653516800).setValue(0);
                    break;
                }
                case 1: {
                    this.getChoiceModel(-653516800).setValue(1);
                    break;
                }
                case 3: {
                    this.getChoiceModel(-653516800).setValue(3);
                    break;
                }
                case 2: {
                    this.getChoiceModel(-653516800).setValue(2);
                    break;
                }
                default: {
                    this.getLogChannel().log(-1601830656, "updateBatteryControlPlugDisplayState: Unknown color=%1", (long)n);
                }
            }
            switch (n2) {
                case 0: 
                case 1: {
                    this.getChoiceModel(860160).setValue(0);
                    break;
                }
                case 2: {
                    this.getChoiceModel(860160).setValue(1);
                    break;
                }
                case 3: {
                    this.getChoiceModel(860160).setValue(2);
                    break;
                }
                case 4: {
                    this.getChoiceModel(860160).setValue(3);
                    break;
                }
                default: {
                    this.getLogChannel().log(-1601830656, "updateBatteryControlPlugDisplayState: Unknown animation state=%1", (long)n2);
                }
            }
        }
    }

    @Override
    public void updateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlPlug: plug=%1", (Object)batteryControlPlug);
        if (n == 1) {
            if (batteryControlPlug.plugState == 1) {
                this.getChoiceModel(-737402880).setValue(1);
            } else if (batteryControlPlug.plugState == 0 || batteryControlPlug.plugState == 15) {
                this.getChoiceModel(-737402880).setValue(0);
            }
        }
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlChargeState: chargeState=%1, validFlag=%2", (Object)batteryControlChargeState, (long)n);
        if (n == 1) {
            if (this.carNetworkPlatformInfo.isMLBEvo()) {
                this.updateBatterySegmetModel(batteryControlChargeState.getCurrentChargeLevel());
            }
            if (batteryControlChargeState.getChargeState() == 2) {
                this.getChoiceModel(-15982592).setValue(2);
            } else {
                this.getChoiceModel(-15982592).setValue(1);
            }
            if (batteryControlChargeState.remainingChargeTime == -65536 || batteryControlChargeState.chargeState != 2) {
                this.getChoiceModel(-720625664).setValue(1);
            } else {
                this.getChoiceModel(-720625664).setValue(0);
                DateMetric dateMetric = new DateMetric(new Date(batteryControlChargeState.remainingChargeTime * 1625948160), 11);
                dateMetric.setUseInstanceUnit(true);
                this.getMetricsModel(-921952256).setMetric(dateMetric);
                this.getMetricsModel(-921952256).formatChanged();
            }
        }
        this.updateEntryVisibilityForError(batteryControlChargeState, this.currBConViewOptions);
        this.chargeState = batteryControlChargeState;
        this.updateCurrentErrorDisclaimer(batteryControlChargeState);
    }

    @Override
    public void updateHybridCharge(int n, int n2) {
        this.getLogChannel().log(1078071040, "updateHybridCharge: currentCharge=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1 && !this.carNetworkPlatformInfo.isMLBEvo()) {
            this.updateBatterySegmetModel(n);
        }
    }

    private void updateBatterySegmetModel(int n) {
        int n2 = MiscHybridHelper.getBatterySegmentForPercentage(n);
        this.getChoiceModel(-754180096).setValue(n2);
    }

    @Override
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlClimateState: climateState=%1, validFlag=%2", (Object)batteryControlClimateState, (long)n);
    }

    @Override
    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlTimerState: timer=%1, validflag=%2", (Object)batteryControlTimerState, (long)n);
        if (n == 1) {
            this.currentTimerState = batteryControlTimerState;
            this.getChoiceModel(-1995694080).setValue(batteryControlTimerState.getProgrammedTimer().isTimer1() ? 1 : 0);
            this.getChoiceModel(-1878253568).setValue(batteryControlTimerState.getProgrammedTimer().isTimer2() ? 1 : 0);
            this.getChoiceModel(1024270336).setValue(batteryControlTimerState.getProgrammedTimer().isTimer3() ? 1 : 0);
        }
    }

    @Override
    public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlTimer1: timer=%1, validFlag=%2", (Object)batteryControlTimer, (long)n);
        if (n == 1) {
            this.updateBatteryControlTimer(1, batteryControlTimer);
            this.getChoiceModel(-670294016).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 0 : 9);
        }
    }

    @Override
    public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlTimer2: timer=%1, validFlag=%2", (Object)batteryControlTimer, (long)n);
        if (n == 1) {
            this.getChoiceModel(-703848448).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 0 : 9);
            this.updateBatteryControlTimer(2, batteryControlTimer);
        }
    }

    @Override
    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannel().log(1078071040, "updateBatteryControlTimer3: timer=%1, validFlag=%2", (Object)batteryControlTimer, (long)n);
        if (n == 1) {
            this.updateBatteryControlTimer(3, batteryControlTimer);
        }
    }

    private void updateBatteryControlTimer(int n, BatteryControlTimer batteryControlTimer) {
        int n2;
        String string = "updateBatteryControlTimer";
        switch (n) {
            case 1: {
                n2 = -1827921920;
                this.batteryControlTimer1 = batteryControlTimer;
                this.getChoiceModel(-821288960).setValue(batteryControlTimer.getWeekdays().monday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(2, batteryControlTimer.getWeekdays().monday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-1039392768).setValue(batteryControlTimer.getWeekdays().tuesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(3, batteryControlTimer.getWeekdays().tuesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-854843392).setValue(batteryControlTimer.getWeekdays().wednesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(4, batteryControlTimer.getWeekdays().wednesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-938729472).setValue(batteryControlTimer.getWeekdays().thursday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(5, batteryControlTimer.getWeekdays().thursday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-770957312).setValue(batteryControlTimer.getWeekdays().friday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(6, batteryControlTimer.getWeekdays().friday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-838066176).setValue(batteryControlTimer.getWeekdays().saturday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(7, batteryControlTimer.getWeekdays().saturday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-972283904).setValue(batteryControlTimer.getWeekdays().sunday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(1, batteryControlTimer.getWeekdays().sunday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-905175040).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 1 : 0);
                if (this.areAllWeekdaysSelected(batteryControlTimer.getWeekdays())) {
                    this.getChoiceModel(-804511744).setValue(1);
                } else {
                    this.getChoiceModel(-804511744).setValue(0);
                }
                this.prepareWeekdaysObject(this.selectedWeekdaysTimer1, batteryControlTimer);
                break;
            }
            case 2: {
                n2 = -1844699136;
                this.batteryControlTimer2 = batteryControlTimer;
                this.getChoiceModel(-955506688).setValue(batteryControlTimer.getWeekdays().monday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(2, batteryControlTimer.getWeekdays().monday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-1173610496).setValue(batteryControlTimer.getWeekdays().tuesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(3, batteryControlTimer.getWeekdays().tuesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-1056169984).setValue(batteryControlTimer.getWeekdays().wednesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(4, batteryControlTimer.getWeekdays().wednesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-1072947200).setValue(batteryControlTimer.getWeekdays().thursday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(5, batteryControlTimer.getWeekdays().thursday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-1106501632).setValue(batteryControlTimer.getWeekdays().friday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(6, batteryControlTimer.getWeekdays().friday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-989061120).setValue(batteryControlTimer.getWeekdays().saturday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(7, batteryControlTimer.getWeekdays().saturday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-1207164928).setValue(batteryControlTimer.getWeekdays().sunday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(1, batteryControlTimer.getWeekdays().sunday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(-1140056064).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 1 : 0);
                if (this.areAllWeekdaysSelected(batteryControlTimer.getWeekdays())) {
                    this.getChoiceModel(-1123278848).setValue(1);
                } else {
                    this.getChoiceModel(-1123278848).setValue(0);
                }
                this.prepareWeekdaysObject(this.selectedWeekdaysTimer2, batteryControlTimer);
                break;
            }
            case 3: {
                n2 = 1074601984;
                this.batteryControlTimer3 = batteryControlTimer;
                this.getChoiceModel(940384256).setValue(batteryControlTimer.getWeekdays().monday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(2, batteryControlTimer.getWeekdays().monday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(1057824768).setValue(batteryControlTimer.getWeekdays().tuesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(3, batteryControlTimer.getWeekdays().tuesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(923607040).setValue(batteryControlTimer.getWeekdays().wednesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(4, batteryControlTimer.getWeekdays().wednesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(1007493120).setValue(batteryControlTimer.getWeekdays().thursday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(5, batteryControlTimer.getWeekdays().thursday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(1091379200).setValue(batteryControlTimer.getWeekdays().friday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(6, batteryControlTimer.getWeekdays().friday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(1041047552).setValue(batteryControlTimer.getWeekdays().saturday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(7, batteryControlTimer.getWeekdays().saturday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(1108156416).setValue(batteryControlTimer.getWeekdays().sunday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(1, batteryControlTimer.getWeekdays().sunday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(973938688).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 1 : 0);
                if (this.areAllWeekdaysSelected(batteryControlTimer.getWeekdays())) {
                    this.getChoiceModel(957161472).setValue(1);
                } else {
                    this.getChoiceModel(957161472).setValue(0);
                }
                this.prepareWeekdaysObject(this.selectedWeekdaysTimer3, batteryControlTimer);
                break;
            }
            default: {
                n2 = -1827921920;
            }
        }
        BatteryControlTimer batteryControlTimer2 = batteryControlTimer;
        if (batteryControlTimer.getWeekdays().isCyclic()) {
            Calendar calendar = this.getCalendarForWeekdayOfNextTimer(batteryControlTimer);
            batteryControlTimer2.year = calendar.get(1);
            batteryControlTimer2.month = calendar.get(2) + 1;
            batteryControlTimer2.day = calendar.get(5);
        }
        this.timerHelper.setTimerMetric(this.timerHelper.castTimerToGeneralObject(batteryControlTimer2), this.getMetricsModel(n2), string);
        if (this.bcCommunicationService != null) {
            this.bcCommunicationService.chargeTimerMetricsUpdated(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void prepareWeekdaysObject(BatteryControlWeekdays batteryControlWeekdays, BatteryControlTimer batteryControlTimer) {
        BatteryControlWeekdays batteryControlWeekdays2 = batteryControlWeekdays;
        synchronized (batteryControlWeekdays2) {
            batteryControlWeekdays.monday = batteryControlTimer.getWeekdays().monday;
            batteryControlWeekdays.tuesday = batteryControlTimer.getWeekdays().tuesday;
            batteryControlWeekdays.wednesday = batteryControlTimer.getWeekdays().wednesday;
            batteryControlWeekdays.thursday = batteryControlTimer.getWeekdays().thursday;
            batteryControlWeekdays.friday = batteryControlTimer.getWeekdays().friday;
            batteryControlWeekdays.saturday = batteryControlTimer.getWeekdays().saturday;
            batteryControlWeekdays.sunday = batteryControlTimer.getWeekdays().sunday;
            batteryControlWeekdays.cyclic = batteryControlTimer.getWeekdays().cyclic;
        }
    }

    private boolean areAllWeekdaysSelected(BatteryControlWeekdays batteryControlWeekdays) {
        return batteryControlWeekdays.monday && batteryControlWeekdays.tuesday && batteryControlWeekdays.wednesday && batteryControlWeekdays.thursday && batteryControlWeekdays.friday && batteryControlWeekdays.saturday && batteryControlWeekdays.sunday;
    }

    private Calendar getCalendarForWeekdayOfNextTimer(BatteryControlTimer batteryControlTimer) {
        int n;
        BatteryControlWeekdays batteryControlWeekdays = batteryControlTimer.getWeekdays();
        Date date = this.dsiCalendar.getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        batteryControlTimer.year = calendar.get(1);
        batteryControlTimer.month = calendar.get(2) + 1;
        batteryControlTimer.day = calendar.get(5);
        int[] nArray = new int[]{7, 1, 2, 3, 4, 5, 6};
        int n2 = nArray[calendar.get(7) - 1];
        boolean[] blArray = new boolean[]{false, batteryControlWeekdays.monday, batteryControlWeekdays.tuesday, batteryControlWeekdays.wednesday, batteryControlWeekdays.thursday, batteryControlWeekdays.friday, batteryControlWeekdays.saturday, batteryControlWeekdays.sunday};
        int n3 = 0;
        int n4 = 0;
        for (n = 1; n < blArray.length; ++n) {
            if (!this.timerHelper.getCalendarFromTimer(batteryControlTimer).getTime().before(date) && n2 == n || n2 < n) {
                if (!blArray[n] || n3 != 0) continue;
                n3 = n;
                continue;
            }
            if (!blArray[n] || n4 != 0) continue;
            n4 = n;
        }
        if (n3 == 0) {
            n3 = n4;
        }
        n = (n3 - n2 + 7) % 7;
        n = n2 == n4 && n3 == n4 ? 7 : n;
        calendar.add(5, n);
        return calendar;
    }

    private boolean shouldBeCheckedForNonCyclicTimer(int n, boolean bl, BatteryControlTimer batteryControlTimer) {
        if (!batteryControlTimer.getWeekdays().cyclic) {
            Calendar calendar = this.timerHelper.getCalendarFromTimer(batteryControlTimer);
            return n == calendar.get(7);
        }
        return bl;
    }

    private void onDateTimeChange() {
        if (this.batteryControlTimer1 != null && this.batteryControlTimer1.getWeekdays().isCyclic()) {
            this.updateBatteryControlTimer(1, this.batteryControlTimer1);
        }
        if (this.batteryControlTimer2 != null && this.batteryControlTimer2.getWeekdays().isCyclic()) {
            this.updateBatteryControlTimer(2, this.batteryControlTimer2);
        }
        if (this.batteryControlTimer3 != null && this.batteryControlTimer3.getWeekdays().isCyclic()) {
            this.updateBatteryControlTimer(3, this.batteryControlTimer3);
        }
    }

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
    }

    protected abstract void updateThermometerIconVisibility(int n, boolean bl) {
    }

    protected abstract void updateHeatCoilIconVisibility(int n, int n2) {
    }

    protected abstract void updateEntryVisibilityForError(BatteryControlChargeState batteryControlChargeState, BatteryControlViewOptions batteryControlViewOptions) {
    }

    @Override
    public String getName() {
        return "Charge";
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logModelData("itemSelected:", n, n2, true);
        switch (n) {
            case 2100361: {
                if (this.bcListHandlingService.getProfileListLength() > 1) {
                    if (!this.bcListHandlingService.isProfileXOperationCharge(1)) {
                        this.bcListHandlingService.setProfileXOperationCharge(1, true);
                    }
                    if (this.bcListHandlingService.getProfileXProviderDataId(1) != this.bcListHandlingService.getProfile1Pos()) {
                        this.bcListHandlingService.setProfile1ProviderDataId(this.bcListHandlingService.getProfile1Pos());
                    }
                }
                this.switchChargeTimerActivation(1, n2 == 1);
                break;
            }
            case 2100368: {
                if (this.bcListHandlingService.getProfileListLength() > 1) {
                    if (!this.bcListHandlingService.isProfileXOperationCharge(2)) {
                        this.bcListHandlingService.setProfileXOperationCharge(2, true);
                    }
                    if (this.bcListHandlingService.getProfileXProviderDataId(2) != this.bcListHandlingService.getProfile2Pos()) {
                        this.bcListHandlingService.setProfile2ProviderDataId(this.bcListHandlingService.getProfile2Pos());
                    }
                }
                this.switchChargeTimerActivation(2, n2 == 1);
                break;
            }
            case 2100541: {
                if (this.bcListHandlingService.getProfileListLength() > 1) {
                    if (!this.bcListHandlingService.isProfileXOperationCharge(3)) {
                        this.bcListHandlingService.setProfileXOperationCharge(3, true);
                    }
                    if (this.bcListHandlingService.getProfileXProviderDataId(3) != this.bcListHandlingService.getProfile3Pos()) {
                        this.bcListHandlingService.setProfile2ProviderDataId(this.bcListHandlingService.getProfile3Pos());
                    }
                }
                this.switchChargeTimerActivation(3, n2 == 1);
                break;
            }
            case 2100426: {
                this.itemSelectedTimerType(n, n2);
                break;
            }
            case 2100412: {
                this.itemSelectedTimerType(n, n2);
                break;
            }
            case 2100538: {
                this.itemSelectedTimerType(n, n2);
                break;
            }
            case 0x200CC2: 
            case 2100422: 
            case 2100424: 
            case 2100429: 
            case 2100430: 
            case 2100431: 
            case 2100434: {
                this.itemSelectedWeekday(this.selectedWeekdaysTimer1, n2, n, 1);
                break;
            }
            case 2100408: 
            case 2100410: 
            case 2100414: 
            case 0x200CC0: 
            case 2100417: 
            case 2100421: 
            case 2100423: {
                this.itemSelectedWeekday(this.selectedWeekdaysTimer2, n2, n, 2);
                break;
            }
            case 2100535: 
            case 2100536: 
            case 2100540: 
            case 2100542: 
            case 2100543: 
            case 2100545: 
            case 2100546: {
                this.itemSelectedWeekday(this.selectedWeekdaysTimer3, n2, n, 3);
                break;
            }
            case 2100413: 
            case 2100432: 
            case 2100537: {
                this.itemSelectedWeekDayAll(n, n2);
                break;
            }
            case 2100415: 
            case 2100433: 
            case 2100539: {
                this.itemSelectedElectricalClimate(n, n2);
                break;
            }
        }
    }

    private void switchChargeTimerActivation(int n, boolean bl) {
        boolean bl2 = true;
        boolean bl3 = true;
        boolean bl4 = true;
        boolean bl5 = true;
        switch (n) {
            case 1: {
                if (this.currentTimerState != null && this.currentTimerState.programmedTimer != null) {
                    bl3 = this.currentTimerState.programmedTimer.timer2;
                    bl4 = this.currentTimerState.programmedTimer.timer3;
                    bl5 = this.currentTimerState.programmedTimer.timer4;
                }
                bl2 = bl;
                break;
            }
            case 2: {
                if (this.currentTimerState != null && this.currentTimerState.programmedTimer != null) {
                    bl2 = this.currentTimerState.programmedTimer.timer1;
                    bl4 = this.currentTimerState.programmedTimer.timer3;
                    bl5 = this.currentTimerState.programmedTimer.timer4;
                }
                bl3 = bl;
                break;
            }
            case 3: {
                if (this.currentTimerState != null && this.currentTimerState.programmedTimer != null) {
                    bl2 = this.currentTimerState.programmedTimer.timer1;
                    bl3 = this.currentTimerState.programmedTimer.timer2;
                    bl5 = this.currentTimerState.programmedTimer.timer4;
                }
                bl4 = bl;
                break;
            }
            case 4: {
                if (this.currentTimerState != null && this.currentTimerState.programmedTimer != null) {
                    bl2 = this.currentTimerState.programmedTimer.timer1;
                    bl3 = this.currentTimerState.programmedTimer.timer2;
                    bl4 = this.currentTimerState.programmedTimer.timer3;
                }
                bl5 = bl;
                break;
            }
        }
        BatteryControlProgrammedTimer batteryControlProgrammedTimer = new BatteryControlProgrammedTimer(bl2, bl3, bl4, bl5);
        this.getLogChannel().log(1078071040, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
        this.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void itemSelectedWeekday(BatteryControlWeekdays batteryControlWeekdays, int n, int n2, int n3) {
        BatteryControlWeekdays batteryControlWeekdays2 = batteryControlWeekdays;
        synchronized (batteryControlWeekdays2) {
            this.logModelData("itemSelectedWeekDay", n2, n, true);
            boolean bl = this.shouldUnSelecetWeekday(batteryControlWeekdays, n);
            if (!bl) {
                switch (n2) {
                    case 2100423: 
                    case 2100431: 
                    case 2100536: {
                        batteryControlWeekdays.monday = n == 1;
                        break;
                    }
                    case 2100410: 
                    case 0x200CC2: 
                    case 2100543: {
                        batteryControlWeekdays.tuesday = n == 1;
                        break;
                    }
                    case 2100417: 
                    case 2100429: 
                    case 2100535: {
                        batteryControlWeekdays.wednesday = n == 1;
                        break;
                    }
                    case 0x200CC0: 
                    case 2100424: 
                    case 2100540: {
                        batteryControlWeekdays.thursday = n == 1;
                        break;
                    }
                    case 2100414: 
                    case 2100434: 
                    case 2100545: {
                        batteryControlWeekdays.friday = n == 1;
                        break;
                    }
                    case 2100421: 
                    case 2100430: 
                    case 2100542: {
                        batteryControlWeekdays.saturday = n == 1;
                        break;
                    }
                    case 2100408: 
                    case 2100422: 
                    case 2100546: {
                        batteryControlWeekdays.sunday = n == 1;
                        break;
                    }
                }
            }
        }
        switch (n3) {
            case 1: {
                this.setTimer(1, this.getDateMetric(-1827921920).getDate());
                break;
            }
            case 2: {
                this.setTimer(2, this.getDateMetric(-1844699136).getDate());
                break;
            }
            case 3: {
                this.setTimer(3, this.getDateMetric(1074601984).getDate());
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractChargeComponent#itemSelectedWeekday] Trying to set invalid timer!");
            }
        }
    }

    private synchronized boolean shouldUnSelecetWeekday(BatteryControlWeekdays batteryControlWeekdays, int n) {
        int n2 = 7;
        n2 -= batteryControlWeekdays.monday ? 0 : 1;
        n2 -= batteryControlWeekdays.tuesday ? 0 : 1;
        n2 -= batteryControlWeekdays.wednesday ? 0 : 1;
        n2 -= batteryControlWeekdays.thursday ? 0 : 1;
        n2 -= batteryControlWeekdays.friday ? 0 : 1;
        n2 -= batteryControlWeekdays.saturday ? 0 : 1;
        if ((n2 -= batteryControlWeekdays.sunday ? 0 : 1) < 2) {
            return n == 0;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void itemSelectedWeekDayAll(int n, int n2) {
        this.logModelData("itemSelectedWeekDayAll", n, n2, true);
        boolean bl = n2 == 1;
        switch (n) {
            case 2100432: {
                BatteryControlWeekdays batteryControlWeekdays = this.selectedWeekdaysTimer1;
                synchronized (batteryControlWeekdays) {
                    if (bl) {
                        this.selectedWeekdaysTimer1.monday = bl;
                        this.selectedWeekdaysTimer1.tuesday = bl;
                        this.selectedWeekdaysTimer1.wednesday = bl;
                        this.selectedWeekdaysTimer1.thursday = bl;
                        this.selectedWeekdaysTimer1.friday = bl;
                        this.selectedWeekdaysTimer1.saturday = bl;
                        this.selectedWeekdaysTimer1.sunday = bl;
                    }
                }
                this.setTimer(1, this.getDateMetric(-1827921920).getDate());
                break;
            }
            case 2100413: {
                BatteryControlWeekdays batteryControlWeekdays = this.selectedWeekdaysTimer2;
                synchronized (batteryControlWeekdays) {
                    if (bl) {
                        this.selectedWeekdaysTimer2.monday = bl;
                        this.selectedWeekdaysTimer2.tuesday = bl;
                        this.selectedWeekdaysTimer2.wednesday = bl;
                        this.selectedWeekdaysTimer2.thursday = bl;
                        this.selectedWeekdaysTimer2.friday = bl;
                        this.selectedWeekdaysTimer2.saturday = bl;
                        this.selectedWeekdaysTimer2.sunday = bl;
                    }
                }
                this.setTimer(2, this.getDateMetric(-1844699136).getDate());
                break;
            }
            case 2100537: {
                BatteryControlWeekdays batteryControlWeekdays = this.selectedWeekdaysTimer3;
                synchronized (batteryControlWeekdays) {
                    if (bl) {
                        this.selectedWeekdaysTimer3.monday = bl;
                        this.selectedWeekdaysTimer3.tuesday = bl;
                        this.selectedWeekdaysTimer3.wednesday = bl;
                        this.selectedWeekdaysTimer3.thursday = bl;
                        this.selectedWeekdaysTimer3.friday = bl;
                        this.selectedWeekdaysTimer3.saturday = bl;
                        this.selectedWeekdaysTimer3.sunday = bl;
                    }
                }
                this.setTimer(3, this.getDateMetric(1074601984).getDate());
                break;
            }
        }
    }

    private void itemSelectedElectricalClimate(int n, int n2) {
        this.logModelData("itemSelectedElectricalClimate", n, n2, true);
        int n3 = 0;
        switch (n) {
            case 2100433: {
                n3 = 1;
                break;
            }
            case 2100415: {
                n3 = 2;
                break;
            }
            case 2100539: {
                n3 = 3;
                break;
            }
        }
        this.bcListHandlingService.setProfileXOperationClimate(n3, n2 == 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void itemSelectedTimerType(int n, int n2) {
        this.logModelData("itemSelectedTimerType", n, n2, true);
        boolean bl = n2 == 1;
        switch (n) {
            case 2100426: {
                this.selectedWeekdaysTimer1.cyclic = bl;
                BatteryControlWeekdays batteryControlWeekdays = this.selectedWeekdaysTimer1;
                synchronized (batteryControlWeekdays) {
                    if (bl) {
                        this.selectedWeekdaysTimer1.monday = bl;
                        this.selectedWeekdaysTimer1.tuesday = bl;
                        this.selectedWeekdaysTimer1.wednesday = bl;
                        this.selectedWeekdaysTimer1.thursday = bl;
                        this.selectedWeekdaysTimer1.friday = bl;
                        this.selectedWeekdaysTimer1.saturday = bl;
                        this.selectedWeekdaysTimer1.sunday = bl;
                    }
                }
                Date date = this.getDateForTimerTypeChanged(-1827921920, bl);
                this.setTimer(1, date);
                break;
            }
            case 2100412: {
                this.selectedWeekdaysTimer2.cyclic = bl;
                BatteryControlWeekdays batteryControlWeekdays = this.selectedWeekdaysTimer2;
                synchronized (batteryControlWeekdays) {
                    if (bl) {
                        this.selectedWeekdaysTimer2.monday = bl;
                        this.selectedWeekdaysTimer2.tuesday = bl;
                        this.selectedWeekdaysTimer2.wednesday = bl;
                        this.selectedWeekdaysTimer2.thursday = bl;
                        this.selectedWeekdaysTimer2.friday = bl;
                        this.selectedWeekdaysTimer2.saturday = bl;
                        this.selectedWeekdaysTimer2.sunday = bl;
                    }
                }
                Date date = this.getDateForTimerTypeChanged(-1844699136, bl);
                this.setTimer(2, date);
                break;
            }
            case 2100538: {
                this.selectedWeekdaysTimer3.cyclic = bl;
                BatteryControlWeekdays batteryControlWeekdays = this.selectedWeekdaysTimer3;
                synchronized (batteryControlWeekdays) {
                    if (bl) {
                        this.selectedWeekdaysTimer3.monday = bl;
                        this.selectedWeekdaysTimer3.tuesday = bl;
                        this.selectedWeekdaysTimer3.wednesday = bl;
                        this.selectedWeekdaysTimer3.thursday = bl;
                        this.selectedWeekdaysTimer3.friday = bl;
                        this.selectedWeekdaysTimer3.saturday = bl;
                        this.selectedWeekdaysTimer3.sunday = bl;
                    }
                }
                Date date = this.getDateForTimerTypeChanged(1074601984, bl);
                this.setTimer(3, date);
                break;
            }
        }
    }

    private Date getDateForTimerTypeChanged(int n, boolean bl) {
        Date date = this.getDateForTimer(n, bl);
        return bl ? date : this.timerHelper.getTomorrowCurrentTime(date);
    }

    private Date getDateForTimer(int n, boolean bl) {
        Date date = this.getDateMetric(n).getDate();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (bl) {
            if (this.timerHelper.isDateInThePast(date, "getDateForTimer")) {
                calendar.add(5, 1);
            }
        } else if (this.timerHelper.isDateInThePast(date, "getDateForTimer")) {
            calendar.setTime(this.timerHelper.getTomorrowCurrentTime(date));
        }
        return calendar.getTime();
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
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
    public void metricsUpdated(int n, int n2) {
        this.getLogChannel().log(1078071040, "metricsUpdated: DATE_METRIC FOR MODELID %1 is  %2", (Object)String.valueOf(n), (Object)this.getDateMetric(n).getDate());
        switch (n) {
            case 2100371: {
                this.setTimer(1, this.getDateForTimer(n, this.selectedWeekdaysTimer1.cyclic));
                break;
            }
            case 2100370: {
                this.setTimer(2, this.getDateForTimer(n, this.selectedWeekdaysTimer2.cyclic));
                break;
            }
            case 2100420: {
                this.bcListHandlingService.setPreferredLoadingTimer1();
                break;
            }
            case 2100411: {
                this.bcListHandlingService.setPreferredLoadingTimer1();
                break;
            }
            case 0x200CCC: {
                this.bcListHandlingService.setPreferredLoadingTimer2();
                break;
            }
            case 2100409: {
                this.bcListHandlingService.setPreferredLoadingTimer2();
                break;
            }
            default: {
                this.logModelData("metricsUpdated", n, 0, false);
            }
        }
    }

    private void setTimer(int n, Date date) {
        BatteryControlWeekdays batteryControlWeekdays = null;
        int n2 = -1;
        boolean bl = false;
        switch (n) {
            case 1: {
                batteryControlWeekdays = this.selectedWeekdaysTimer1;
                n2 = 1;
                bl = this.selectedWeekdaysTimer1.isCyclic();
                break;
            }
            case 2: {
                batteryControlWeekdays = this.selectedWeekdaysTimer2;
                n2 = 2;
                bl = this.selectedWeekdaysTimer2.isCyclic();
                break;
            }
            case 3: {
                batteryControlWeekdays = this.selectedWeekdaysTimer3;
                n2 = 2;
                bl = this.selectedWeekdaysTimer3.isCyclic();
                break;
            }
        }
        Calendar calendar = TimerHelper.getCorrectCalendarFromDate(date);
        if (this.timerHelper.getNowInOneYear().getTime().before(date)) {
            calendar = TimerHelper.getCorrectCalendarFromDate(this.timerHelper.getNowInOneYear().getTime());
        }
        this.getLogChannel().log(1078071040, "setTimer: timerId=%1, date=%2", (Object)String.valueOf(n), (Object)date.toString());
        int n3 = calendar.get(1);
        int n4 = calendar.get(2) + 1;
        int n5 = calendar.get(5);
        if (bl) {
            n3 = 255;
            n4 = 255;
            n5 = 255;
            this.getLogChannel().log(1078071040, "setTimer: Cyclic timer year=%1, month=%1, day=%1", (long)0);
        }
        this.getDSI().setBatteryControlTimer(n, n3, n4, n5, calendar.get(11), calendar.get(12), batteryControlWeekdays, n2);
    }

    @Override
    protected void initVisibility() {
    }

    @Override
    protected void deinitVisibility() {
    }

    @Override
    public void updateClimateSystemType(int n, int n2) {
        switch (n) {
            case 1: {
                this.updateHeatCoilIconVisibility(1, n2);
                break;
            }
            case 2: {
                this.updateHeatCoilIconVisibility(2, n2);
                break;
            }
            case 3: {
                this.updateHeatCoilIconVisibility(3, n2);
                break;
            }
            default: {
                this.getLogChannel().log(-2137614336, "[AbstractAuxCoolerComponent.BatteryControlListHandling#setClimateSystemType] profileId=%1 not handled", (long)n);
            }
        }
    }

    @Override
    public void updateChargeTimerClimateChoice(int n, int n2) {
        switch (n) {
            case 1: {
                this.getChoiceModel(-787734528).setValue(n2);
                this.updateThermometerIconVisibility(1, n2 == 1);
                break;
            }
            case 2: {
                this.getChoiceModel(-1089724416).setValue(n2);
                this.updateThermometerIconVisibility(2, n2 == 1);
                break;
            }
            case 3: {
                this.getChoiceModel(990715904).setValue(n2);
                this.updateThermometerIconVisibility(3, n2 == 1);
                break;
            }
        }
    }

    @Override
    public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
    }

    public void updateCurrentErrorDisclaimer(BatteryControlChargeState batteryControlChargeState) {
        if (batteryControlChargeState.getChargeState() == 7) {
            this.getLogChannel().log(1078071040, "updateCurrentErrorDisclaimer: chargeState=%1; Show Disclaimer with ERROR_REASON_GENERALDEVICEERROR", (Object)batteryControlChargeState);
            this.getChoiceModel(118300672).setValue(1);
        } else {
            this.getLogChannel().log(1078071040, "updateCurrentErrorDisclaimer: chargeState=%1; Show Disclaimer with ERROR_REASON_NONE", (Object)batteryControlChargeState);
            this.getChoiceModel(118300672).setValue(0);
        }
    }

    @Override
    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1078071040, "updateBatteryControlPastErrorReason: climateStateLastError=%1, validFlag=%2", (long)n2, (long)n4);
        if (n4 == 1) {
            this.updatePastErrorDisclaimerModel(n3);
        }
    }

    protected synchronized void updatePastErrorDisclaimerModel(int n) {
        this.getLogChannel().log(1078071040, "updatePastErrorDisclaimerModel: errorReason=%1", (long)n);
        if (n == 16 || n == 0) {
            this.getChoiceModel(135077888).setValue(0);
            return;
        }
        this.getChoiceModel(135077888).setValue(1);
    }

    public void resetPastError() {
        this.getChoiceModel(135077888).setValue(0);
        this.getLogChannel().log(1078071040, "[AbstractAuxheaterComponent#resetPastError] screen with past error entered, resetting the error until next bus cycle");
        this.getDSI().setBatteryControlPastErrorReason(0);
    }

    @Override
    public void onTimeChange(ClockTime clockTime) {
        if (this.clockTime.getMinutes() != clockTime.getMinutes() || this.clockTime.getHours() != clockTime.getHours()) {
            this.storeRemainingTimeTillTimerActivation(clockTime);
            this.getLogChannel().log(-2137614336, "onTimeChange: time = %1", (Object)clockTime);
            this.clockTime = clockTime;
            this.dsiCalendar.set(11, clockTime.getHours());
            this.dsiCalendar.set(12, clockTime.getMinutes());
            this.onDateTimeChange();
        } else {
            this.clockTime = clockTime;
        }
    }

    private void storeRemainingTimeTillTimerActivation(ClockTime clockTime) {
        long l = this.calcRemainingTimeTillTimerActivation(clockTime);
        DateMetric dateMetric = new DateMetric(new Date(l), 5);
        dateMetric.setUseInstanceUnit(true);
        this.getMetricsModel(1141710848).setMetric(dateMetric);
        this.getMetricsModel(1141710848).formatChanged();
    }

    private long calcRemainingTimeTillTimerActivation(ClockTime clockTime) {
        Object[] objectArray = this.timerHelper.getNextChargeTimerAsArray(this.choiceModelList, this.metricsModelList);
        Date date = (Date)objectArray[1];
        Date date2 = this.dsiCalendar.getTime();
        long l = 0L;
        if (date.after(date2)) {
            l = date.getTime() - date2.getTime();
        }
        return l;
    }

    @Override
    public void onDateChange(ClockDate clockDate) {
        if (this.clockDate.getDay() != clockDate.getDay() || this.clockDate.getMonth() != clockDate.getMonth() || this.clockDate.getYear() != clockDate.getYear()) {
            this.getLogChannel().log(-2137614336, "onDateChange: date = %1", (Object)clockDate);
            this.clockDate = clockDate;
            this.dsiCalendar.set(1, clockDate.getYear() + 2000);
            this.dsiCalendar.set(2, clockDate.getMonth() - 1);
            this.dsiCalendar.set(5, clockDate.getDay());
            this.onDateTimeChange();
        } else {
            this.clockDate = clockDate;
        }
    }

    static /* synthetic */ IBattCtrlCommunicationService access$002(AbstractChargeComponent abstractChargeComponent, IBattCtrlCommunicationService iBattCtrlCommunicationService) {
        abstractChargeComponent.bcCommunicationService = iBattCtrlCommunicationService;
        return abstractChargeComponent.bcCommunicationService;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IBatteryControlListHandlingService access$102(AbstractChargeComponent abstractChargeComponent, IBatteryControlListHandlingService iBatteryControlListHandlingService) {
        abstractChargeComponent.bcListHandlingService = iBatteryControlListHandlingService;
        return abstractChargeComponent.bcListHandlingService;
    }

    static /* synthetic */ IBatteryControlListHandlingService access$100(AbstractChargeComponent abstractChargeComponent) {
        return abstractChargeComponent.bcListHandlingService;
    }
}

