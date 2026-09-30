/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.common.util.MiscHybridHelper;
import de.audi.app.car.common.util.TimerHelper;
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
    public static final short CODING_ID = 41;
    private static final String LOGCHANNEL_NAME = "App.EarlyFunc.Charge";
    static final int TIMER_TYPE_CYCLIC = 1;
    private static final int BATTERY_CHARGE_STATE_NOT_RUNNING = 1;
    private static final int BATTERY_CHARGE_STATE_RUNNING = 2;
    private static final int BATTERY_PLUG_STATE_NOT_PLUGGED = 0;
    private static final int BATTERY_PLUG_STATE_PLUGGED = 1;
    private static final int BATTERY_PLUG_COLOR_GREY = 0;
    private static final int BATTERY_PLUG_COLOR_GREEN = 1;
    private static final int BATTERY_PLUG_COLOR_YELLOW = 2;
    private static final int BATTERY_PLUG_COLOR_RED = 3;
    private static final int BATTERY_PLUG_ANIMATION_NONE = 0;
    private static final int BATTERY_PLUG_ANIMATION_BLINK = 1;
    private static final int BATTERY_PLUG_ANIMATION_PULSE = 2;
    private static final int BATTERY_PLUG_ANIMATION_FLASH = 3;
    private static final int ERROR_REASON_NONE = 0;
    private static final int ERROR_REASON_GENERALDEVICEERROR = 1;
    private static final int TIMER_VALUE_INVALID = 255;
    private static final int TIMER_1 = 1;
    private static final int TIMER_2 = 2;
    private static final int TIMER_3 = 3;
    private static final int TIMER_4 = 4;
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
    private static final int PROFILE_ID_TIMER1 = 1;
    private static final int PROFILE_ID_TIMER2 = 2;
    private static final int PROFILE_ID_TIMER3 = 3;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBattCtrlCommunicationService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;

    public abstract int getPopUpID();

    public AbstractChargeComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.carTimeUnitsLanguageSubComponent = new ChargeSubCarTimeUnitsLanguageComponent(this, iCarApplication, LOGCHANNEL_NAME);
        this.timerHelper = new TimerHelper(iCarApplication, this.getLogChannel());
        this.carNetworkPlatformInfo = new CarNetworkPlatformInfo(iCarApplication.getFrameworkAccess());
    }

    public void init() {
        super.init();
        this.carTimeUnitsLanguageSubComponent.init();
        this.bcComminicationSeviceTracker = new CarServiceTracker(new BCCommunicationTrackerListener(this), this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcComminicationSeviceTracker.startTracking();
    }

    public void deinit() {
        this.carTimeUnitsLanguageSubComponent.deinit();
        super.deinit();
        this.bcComminicationSeviceTracker.stopTracking();
        this.bcListHandlingTracker.stopTracking();
    }

    protected void initModels() {
        this.getChoiceModel(2100361).setChoiceListener(this);
        this.getChoiceModel(2100368).setChoiceListener(this);
        this.getChoiceModel(2100541).setChoiceListener(this);
        this.getChoiceModel(2100419).setChoiceListener(this);
        this.getMetricsModel(2100371).setMetricsListener(this);
        this.getMetricsModel(2100370).setMetricsListener(this);
        this.getMetricsModel(2100544).setMetricsListener(this);
        this.getMetricsModel(2100427).setMetricsListener(this);
        this.getMetricsModel(2100425).setMetricsListener(this);
        this.getChoiceModel(2100426).setChoiceListener(this);
        this.getChoiceModel(2100412).setChoiceListener(this);
        this.getChoiceModel(2100538).setChoiceListener(this);
        this.getChoiceModel(2100432).setChoiceListener(this);
        this.getChoiceModel(2100413).setChoiceListener(this);
        this.getChoiceModel(2100431).setChoiceListener(this);
        this.getChoiceModel(0x200CC2).setChoiceListener(this);
        this.getChoiceModel(2100429).setChoiceListener(this);
        this.getChoiceModel(2100424).setChoiceListener(this);
        this.getChoiceModel(2100434).setChoiceListener(this);
        this.getChoiceModel(2100430).setChoiceListener(this);
        this.getChoiceModel(2100422).setChoiceListener(this);
        this.getChoiceModel(2100423).setChoiceListener(this);
        this.getChoiceModel(2100410).setChoiceListener(this);
        this.getChoiceModel(2100417).setChoiceListener(this);
        this.getChoiceModel(0x200CC0).setChoiceListener(this);
        this.getChoiceModel(2100414).setChoiceListener(this);
        this.getChoiceModel(2100421).setChoiceListener(this);
        this.getChoiceModel(2100408).setChoiceListener(this);
        this.getChoiceModel(2100536).setChoiceListener(this);
        this.getChoiceModel(2100543).setChoiceListener(this);
        this.getChoiceModel(2100535).setChoiceListener(this);
        this.getChoiceModel(2100540).setChoiceListener(this);
        this.getChoiceModel(2100545).setChoiceListener(this);
        this.getChoiceModel(2100542).setChoiceListener(this);
        this.getChoiceModel(2100546).setChoiceListener(this);
        DateMetric dateMetric = (DateMetric)this.getMetricsModel(2100420).getMetric();
        DateMetric dateMetric2 = (DateMetric)this.getMetricsModel(2100411).getMetric();
        DateMetric dateMetric3 = (DateMetric)this.getMetricsModel(0x200CCC).getMetric();
        DateMetric dateMetric4 = (DateMetric)this.getMetricsModel(2100409).getMetric();
        if (dateMetric == null) {
            dateMetric = new DateMetric(new Date(), 2);
            dateMetric.setDate(new Date());
            dateMetric3 = new DateMetric(new Date(), 2);
            dateMetric3.setDate(new Date());
            dateMetric2 = new DateMetric(new Date(), 2);
            dateMetric2.setDate(new Date());
            dateMetric4 = new DateMetric(new Date(), 2);
            dateMetric4.setDate(new Date());
            this.getMetricsModel(2100420).setMetric(dateMetric);
            this.getMetricsModel(2100411).setMetric(dateMetric2);
            this.getMetricsModel(0x200CCC).setMetric(dateMetric3);
            this.getMetricsModel(2100409).setMetric(dateMetric4);
        }
        this.getMetricsModel(2100420).setMetricsListener(this);
        this.getMetricsModel(2100411).setMetricsListener(this);
        this.getMetricsModel(0x200CCC).setMetricsListener(this);
        this.getMetricsModel(2100409).setMetricsListener(this);
        this.getChoiceModel(2100433).setChoiceListener(this);
        this.getChoiceModel(2100415).setChoiceListener(this);
        this.getChoiceModel(2100539).setChoiceListener(this);
        this.choiceModelList.add(this.getChoiceModel(2100361));
        this.choiceModelList.add(this.getChoiceModel(2100368));
        this.choiceModelList.add(this.getChoiceModel(2100541));
        this.metricsModelList.add(this.getMetricsModel(2100371));
        this.metricsModelList.add(this.getMetricsModel(2100370));
        this.metricsModelList.add(this.getMetricsModel(2100544));
    }

    protected void deinitModels() {
        this.getChoiceModel(2100361).resetListener();
        this.getChoiceModel(2100368).resetListener();
        this.getChoiceModel(2100541).resetListener();
        this.getChoiceModel(2100419).resetListener();
        this.getMetricsModel(2100371).resetListener();
        this.getMetricsModel(2100370).resetListener();
        this.getMetricsModel(2100544).resetListener();
        this.getMetricsModel(2100427).resetListener();
        this.getMetricsModel(2100425).resetListener();
        this.getChoiceModel(2100426).resetListener();
        this.getChoiceModel(2100412).resetListener();
        this.getChoiceModel(2100432).resetListener();
        this.getChoiceModel(2100413).resetListener();
        this.getChoiceModel(2100431).resetListener();
        this.getChoiceModel(0x200CC2).resetListener();
        this.getChoiceModel(2100429).resetListener();
        this.getChoiceModel(2100424).resetListener();
        this.getChoiceModel(2100434).resetListener();
        this.getChoiceModel(2100430).resetListener();
        this.getChoiceModel(2100422).resetListener();
        this.getChoiceModel(2100423).resetListener();
        this.getChoiceModel(2100410).resetListener();
        this.getChoiceModel(2100417).resetListener();
        this.getChoiceModel(0x200CC0).resetListener();
        this.getChoiceModel(2100414).resetListener();
        this.getChoiceModel(2100421).resetListener();
        this.getChoiceModel(2100408).resetListener();
        this.getChoiceModel(2100536).resetListener();
        this.getChoiceModel(2100543).resetListener();
        this.getChoiceModel(2100535).resetListener();
        this.getChoiceModel(2100540).resetListener();
        this.getChoiceModel(2100545).resetListener();
        this.getChoiceModel(2100542).resetListener();
        this.getChoiceModel(2100546).resetListener();
        this.getMetricsModel(2100420).resetListener();
        this.getMetricsModel(2100411).resetListener();
        this.getMetricsModel(0x200CCC).resetListener();
        this.getMetricsModel(2100409).resetListener();
        this.getChoiceModel(2100433).resetListener();
        this.getChoiceModel(2100415).resetListener();
        this.getChoiceModel(2100539).resetListener();
    }

    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        this.getLogChannel().log(1000000, "DSI available, starting BCListHandling Service...");
        this.bcListHandlingTracker = new CarServiceTracker(new BCListHandlingTrackerListener(this), this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcListHandlingTracker.startTracking();
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{7, 24, 11, 12, 13, 10, 23, 19, 18, 15, 17, 9, 8, 22, 2})};
    }

    public String getCurrentViewOptions() {
        if (this.currBConViewOptions == null) {
            return "no view options received yet";
        }
        return this.currBConViewOptions.toString();
    }

    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBatteryControlViewOptions(%1), valid=%2", (Object)(batteryControlViewOptions != null ? this.formatViewOptionsLog(batteryControlViewOptions.toString()) : "null"), (long)n);
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

    public void updateBatteryControlPlugDisplayState(int n, int n2, int n3) {
        this.getLogChannel().log(1000000, "updateBatteryControlPlugDisplayState: color=%1, state=%2, validFlag=%3", (long)n, (long)n2, (long)n3);
        if (n3 == 1) {
            switch (n) {
                case 0: {
                    this.getChoiceModel(2100441).setValue(0);
                    break;
                }
                case 1: {
                    this.getChoiceModel(2100441).setValue(1);
                    break;
                }
                case 3: {
                    this.getChoiceModel(2100441).setValue(3);
                    break;
                }
                case 2: {
                    this.getChoiceModel(2100441).setValue(2);
                    break;
                }
                default: {
                    this.getLogChannel().log(100000, "updateBatteryControlPlugDisplayState: Unknown color=%1", (long)n);
                }
            }
            switch (n2) {
                case 0: 
                case 1: {
                    this.getChoiceModel(0x200D00).setValue(0);
                    break;
                }
                case 2: {
                    this.getChoiceModel(0x200D00).setValue(1);
                    break;
                }
                case 3: {
                    this.getChoiceModel(0x200D00).setValue(2);
                    break;
                }
                case 4: {
                    this.getChoiceModel(0x200D00).setValue(3);
                    break;
                }
                default: {
                    this.getLogChannel().log(100000, "updateBatteryControlPlugDisplayState: Unknown animation state=%1", (long)n2);
                }
            }
        }
    }

    public void updateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlPlug: plug=%1", (Object)batteryControlPlug);
        if (n == 1) {
            if (batteryControlPlug.plugState == 1) {
                this.getChoiceModel(2100436).setValue(1);
            } else if (batteryControlPlug.plugState == 0 || batteryControlPlug.plugState == 15) {
                this.getChoiceModel(2100436).setValue(0);
            }
        }
    }

    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlChargeState: chargeState=%1, validFlag=%2", (Object)batteryControlChargeState, (long)n);
        if (n == 1) {
            if (this.carNetworkPlatformInfo.isMLBEvo()) {
                this.updateBatterySegmetModel(batteryControlChargeState.getCurrentChargeLevel());
            }
            if (batteryControlChargeState.getChargeState() == 2) {
                this.getChoiceModel(2100479).setValue(2);
            } else {
                this.getChoiceModel(2100479).setValue(1);
            }
            if (batteryControlChargeState.remainingChargeTime == 65535 || batteryControlChargeState.chargeState != 2) {
                this.getChoiceModel(2100437).setValue(1);
            } else {
                this.getChoiceModel(2100437).setValue(0);
                DateMetric dateMetric = new DateMetric(new Date(batteryControlChargeState.remainingChargeTime * 60000), 11);
                dateMetric.setUseInstanceUnit(true);
                this.getMetricsModel(2100425).setMetric(dateMetric);
                this.getMetricsModel(2100425).formatChanged();
            }
        }
        this.updateEntryVisibilityForError(batteryControlChargeState, this.currBConViewOptions);
        this.chargeState = batteryControlChargeState;
        this.updateCurrentErrorDisclaimer(batteryControlChargeState);
    }

    public void updateHybridCharge(int n, int n2) {
        this.getLogChannel().log(1000000, "updateHybridCharge: currentCharge=%1, validFlag=%2", (long)n, (long)n2);
        if (n2 == 1 && !this.carNetworkPlatformInfo.isMLBEvo()) {
            this.updateBatterySegmetModel(n);
        }
    }

    private void updateBatterySegmetModel(int n) {
        int n2 = MiscHybridHelper.getBatterySegmentForPercentage(n);
        this.getChoiceModel(2100435).setValue(n2);
    }

    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlClimateState: climateState=%1, validFlag=%2", (Object)batteryControlClimateState, (long)n);
    }

    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlTimerState: timer=%1, validflag=%2", (Object)batteryControlTimerState, (long)n);
        if (n == 1) {
            this.currentTimerState = batteryControlTimerState;
            this.getChoiceModel(2100361).setValue(batteryControlTimerState.getProgrammedTimer().isTimer1() ? 1 : 0);
            this.getChoiceModel(2100368).setValue(batteryControlTimerState.getProgrammedTimer().isTimer2() ? 1 : 0);
            this.getChoiceModel(2100541).setValue(batteryControlTimerState.getProgrammedTimer().isTimer3() ? 1 : 0);
        }
    }

    public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlTimer1: timer=%1, validFlag=%2", (Object)batteryControlTimer, (long)n);
        if (n == 1) {
            this.updateBatteryControlTimer(1, batteryControlTimer);
            this.getChoiceModel(2100440).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 0 : 9);
        }
    }

    public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlTimer2: timer=%1, validFlag=%2", (Object)batteryControlTimer, (long)n);
        if (n == 1) {
            this.getChoiceModel(2100438).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 0 : 9);
            this.updateBatteryControlTimer(2, batteryControlTimer);
        }
    }

    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannel().log(1000000, "updateBatteryControlTimer3: timer=%1, validFlag=%2", (Object)batteryControlTimer, (long)n);
        if (n == 1) {
            this.updateBatteryControlTimer(3, batteryControlTimer);
        }
    }

    private void updateBatteryControlTimer(int n, BatteryControlTimer batteryControlTimer) {
        int n2;
        String string = "updateBatteryControlTimer";
        switch (n) {
            case 1: {
                n2 = 2100371;
                this.batteryControlTimer1 = batteryControlTimer;
                this.getChoiceModel(2100431).setValue(batteryControlTimer.getWeekdays().monday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(2, batteryControlTimer.getWeekdays().monday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(0x200CC2).setValue(batteryControlTimer.getWeekdays().tuesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(3, batteryControlTimer.getWeekdays().tuesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100429).setValue(batteryControlTimer.getWeekdays().wednesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(4, batteryControlTimer.getWeekdays().wednesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100424).setValue(batteryControlTimer.getWeekdays().thursday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(5, batteryControlTimer.getWeekdays().thursday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100434).setValue(batteryControlTimer.getWeekdays().friday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(6, batteryControlTimer.getWeekdays().friday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100430).setValue(batteryControlTimer.getWeekdays().saturday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(7, batteryControlTimer.getWeekdays().saturday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100422).setValue(batteryControlTimer.getWeekdays().sunday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(1, batteryControlTimer.getWeekdays().sunday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100426).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 1 : 0);
                if (this.areAllWeekdaysSelected(batteryControlTimer.getWeekdays())) {
                    this.getChoiceModel(2100432).setValue(1);
                } else {
                    this.getChoiceModel(2100432).setValue(0);
                }
                this.prepareWeekdaysObject(this.selectedWeekdaysTimer1, batteryControlTimer);
                break;
            }
            case 2: {
                n2 = 2100370;
                this.batteryControlTimer2 = batteryControlTimer;
                this.getChoiceModel(2100423).setValue(batteryControlTimer.getWeekdays().monday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(2, batteryControlTimer.getWeekdays().monday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100410).setValue(batteryControlTimer.getWeekdays().tuesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(3, batteryControlTimer.getWeekdays().tuesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100417).setValue(batteryControlTimer.getWeekdays().wednesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(4, batteryControlTimer.getWeekdays().wednesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(0x200CC0).setValue(batteryControlTimer.getWeekdays().thursday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(5, batteryControlTimer.getWeekdays().thursday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100414).setValue(batteryControlTimer.getWeekdays().friday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(6, batteryControlTimer.getWeekdays().friday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100421).setValue(batteryControlTimer.getWeekdays().saturday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(7, batteryControlTimer.getWeekdays().saturday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100408).setValue(batteryControlTimer.getWeekdays().sunday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(1, batteryControlTimer.getWeekdays().sunday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100412).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 1 : 0);
                if (this.areAllWeekdaysSelected(batteryControlTimer.getWeekdays())) {
                    this.getChoiceModel(2100413).setValue(1);
                } else {
                    this.getChoiceModel(2100413).setValue(0);
                }
                this.prepareWeekdaysObject(this.selectedWeekdaysTimer2, batteryControlTimer);
                break;
            }
            case 3: {
                n2 = 2100544;
                this.batteryControlTimer3 = batteryControlTimer;
                this.getChoiceModel(2100536).setValue(batteryControlTimer.getWeekdays().monday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(2, batteryControlTimer.getWeekdays().monday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100543).setValue(batteryControlTimer.getWeekdays().tuesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(3, batteryControlTimer.getWeekdays().tuesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100535).setValue(batteryControlTimer.getWeekdays().wednesday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(4, batteryControlTimer.getWeekdays().wednesday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100540).setValue(batteryControlTimer.getWeekdays().thursday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(5, batteryControlTimer.getWeekdays().thursday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100545).setValue(batteryControlTimer.getWeekdays().friday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(6, batteryControlTimer.getWeekdays().friday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100542).setValue(batteryControlTimer.getWeekdays().saturday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(7, batteryControlTimer.getWeekdays().saturday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100546).setValue(batteryControlTimer.getWeekdays().sunday ? 1 : (this.shouldBeCheckedForNonCyclicTimer(1, batteryControlTimer.getWeekdays().sunday, batteryControlTimer) ? 1 : 0));
                this.getChoiceModel(2100538).setValue(batteryControlTimer.getWeekdays().isCyclic() ? 1 : 0);
                if (this.areAllWeekdaysSelected(batteryControlTimer.getWeekdays())) {
                    this.getChoiceModel(2100537).setValue(1);
                } else {
                    this.getChoiceModel(2100537).setValue(0);
                }
                this.prepareWeekdaysObject(this.selectedWeekdaysTimer3, batteryControlTimer);
                break;
            }
            default: {
                n2 = 2100371;
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

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions var1);

    protected abstract void updateThermometerIconVisibility(int var1, boolean var2);

    protected abstract void updateHeatCoilIconVisibility(int var1, int var2);

    protected abstract void updateEntryVisibilityForError(BatteryControlChargeState var1, BatteryControlViewOptions var2);

    public String getName() {
        return "Charge";
    }

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
        this.getLogChannel().log(1000000, "switchTimerActivation: dsi.setBatteryControlTimerState(timer=%1)", (Object)batteryControlProgrammedTimer);
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
                this.setTimer(1, this.getDateMetric(2100371).getDate());
                break;
            }
            case 2: {
                this.setTimer(2, this.getDateMetric(2100370).getDate());
                break;
            }
            case 3: {
                this.setTimer(3, this.getDateMetric(2100544).getDate());
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
                this.setTimer(1, this.getDateMetric(2100371).getDate());
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
                this.setTimer(2, this.getDateMetric(2100370).getDate());
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
                this.setTimer(3, this.getDateMetric(2100544).getDate());
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
                Date date = this.getDateForTimerTypeChanged(2100371, bl);
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
                Date date = this.getDateForTimerTypeChanged(2100370, bl);
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
                Date date = this.getDateForTimerTypeChanged(2100544, bl);
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

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void metricsUpdated(int n, int n2) {
        this.getLogChannel().log(1000000, "metricsUpdated: DATE_METRIC FOR MODELID %1 is  %2", (Object)String.valueOf(n), (Object)this.getDateMetric(n).getDate());
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
        this.getLogChannel().log(1000000, "setTimer: timerId=%1, date=%2", (Object)String.valueOf(n), (Object)date.toString());
        int n3 = calendar.get(1);
        int n4 = calendar.get(2) + 1;
        int n5 = calendar.get(5);
        if (bl) {
            n3 = 255;
            n4 = 255;
            n5 = 255;
            this.getLogChannel().log(1000000, "setTimer: Cyclic timer year=%1, month=%1, day=%1", 255L);
        }
        this.getDSI().setBatteryControlTimer(n, n3, n4, n5, calendar.get(11), calendar.get(12), batteryControlWeekdays, n2);
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

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
                this.getLogChannel().log(10000000, "[AbstractAuxCoolerComponent.BatteryControlListHandling#setClimateSystemType] profileId=%1 not handled", (long)n);
            }
        }
    }

    public void updateChargeTimerClimateChoice(int n, int n2) {
        switch (n) {
            case 1: {
                this.getChoiceModel(2100433).setValue(n2);
                this.updateThermometerIconVisibility(1, n2 == 1);
                break;
            }
            case 2: {
                this.getChoiceModel(2100415).setValue(n2);
                this.updateThermometerIconVisibility(2, n2 == 1);
                break;
            }
            case 3: {
                this.getChoiceModel(2100539).setValue(n2);
                this.updateThermometerIconVisibility(3, n2 == 1);
                break;
            }
        }
    }

    public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
    }

    public void updateCurrentErrorDisclaimer(BatteryControlChargeState batteryControlChargeState) {
        if (batteryControlChargeState.getChargeState() == 7) {
            this.getLogChannel().log(1000000, "updateCurrentErrorDisclaimer: chargeState=%1; Show Disclaimer with ERROR_REASON_GENERALDEVICEERROR", (Object)batteryControlChargeState);
            this.getChoiceModel(2100487).setValue(1);
        } else {
            this.getLogChannel().log(1000000, "updateCurrentErrorDisclaimer: chargeState=%1; Show Disclaimer with ERROR_REASON_NONE", (Object)batteryControlChargeState);
            this.getChoiceModel(2100487).setValue(0);
        }
    }

    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(1000000, "updateBatteryControlPastErrorReason: climateStateLastError=%1, validFlag=%2", (long)n2, (long)n4);
        if (n4 == 1) {
            this.updatePastErrorDisclaimerModel(n3);
        }
    }

    protected synchronized void updatePastErrorDisclaimerModel(int n) {
        this.getLogChannel().log(1000000, "updatePastErrorDisclaimerModel: errorReason=%1", (long)n);
        if (n == 16 || n == 0) {
            this.getChoiceModel(2100488).setValue(0);
            return;
        }
        this.getChoiceModel(2100488).setValue(1);
    }

    public void resetPastError() {
        this.getChoiceModel(2100488).setValue(0);
        this.getLogChannel().log(1000000, "[AbstractAuxheaterComponent#resetPastError] screen with past error entered, resetting the error until next bus cycle");
        this.getDSI().setBatteryControlPastErrorReason(0);
    }

    public void onTimeChange(ClockTime clockTime) {
        if (this.clockTime.getMinutes() != clockTime.getMinutes() || this.clockTime.getHours() != clockTime.getHours()) {
            this.storeRemainingTimeTillTimerActivation(clockTime);
            this.getLogChannel().log(10000000, "onTimeChange: time = %1", (Object)clockTime);
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
        this.getMetricsModel(2100548).setMetric(dateMetric);
        this.getMetricsModel(2100548).formatChanged();
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

    public void onDateChange(ClockDate clockDate) {
        if (this.clockDate.getDay() != clockDate.getDay() || this.clockDate.getMonth() != clockDate.getMonth() || this.clockDate.getYear() != clockDate.getYear()) {
            this.getLogChannel().log(10000000, "onDateChange: date = %1", (Object)clockDate);
            this.clockDate = clockDate;
            this.dsiCalendar.set(1, clockDate.getYear() + 2000);
            this.dsiCalendar.set(2, clockDate.getMonth() - 1);
            this.dsiCalendar.set(5, clockDate.getDay());
            this.onDateTimeChange();
        } else {
            this.clockDate = clockDate;
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

    private class BCListHandlingTrackerListener
    implements CarServiceTrackerListener {
        private AbstractChargeComponent component;

        public BCListHandlingTrackerListener(AbstractChargeComponent abstractChargeComponent2) {
            this.component = abstractChargeComponent2;
        }

        public void serviceAvailable(Object object) {
            AbstractChargeComponent.this.bcListHandlingService = (IBatteryControlListHandlingService)object;
            AbstractChargeComponent.this.bcListHandlingService.registerCalledBackComponent(this.component);
        }

        public void serviceRemoved() {
            AbstractChargeComponent.this.bcListHandlingService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractChargeComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
        }

        public IBatteryControlListHandlingService getGoodbyeService() {
            return AbstractChargeComponent.this.bcListHandlingService;
        }
    }

    private class BCCommunicationTrackerListener
    implements CarServiceTrackerListener {
        private AbstractChargeComponent component;

        public BCCommunicationTrackerListener(AbstractChargeComponent abstractChargeComponent2) {
            this.component = abstractChargeComponent2;
        }

        public void serviceAvailable(Object object) {
            AbstractChargeComponent.this.bcCommunicationService = (IBattCtrlCommunicationService)object;
        }

        public void serviceRemoved() {
            AbstractChargeComponent.this.bcCommunicationService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$IBattCtrlCommunicationService == null ? (class$de$audi$atip$interapp$IBattCtrlCommunicationService = AbstractChargeComponent.class$("de.audi.atip.interapp.IBattCtrlCommunicationService")) : class$de$audi$atip$interapp$IBattCtrlCommunicationService).getName()};
        }
    }
}

