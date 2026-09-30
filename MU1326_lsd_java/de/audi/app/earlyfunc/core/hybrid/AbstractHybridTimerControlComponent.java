/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.service.CarServiceTrackerListener;
import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.earlyfunc.core.hybrid.HybridTimerConfig;
import de.audi.app.earlyfunc.core.hybrid.IDateTimeChangeListener;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public abstract class AbstractHybridTimerControlComponent
extends AbstractDSICarHybridAdapter
implements IBatteryControlListHandlingCallback,
IDateTimeChangeListener {
    public static final short CODING_ID_CHARGE = 41;
    public static final short CODING_ID_CLIMATE = 46;
    public static final short[] CODING_IDS = new short[]{41, 46};
    public static final String LOGCHANNEL_NAME = "App.EarlyFunc.Hybrid.Timer";
    public static final String DSI_LOGCHANNEL_NAME = "App.EarlyFunc.Hybrid.DSI";
    protected static final int INVALID = -1;
    private static final int INVALID_TIMER_VALUE_ = 255;
    public static final int HMI_TIMER_ID_IMMEDIATE = 0;
    public static final int HMI_TIMER_ID_1 = 1;
    public static final int HMI_TIMER_ID_2 = 2;
    public static final int HMI_TIMER_ID_3 = 3;
    public static final int HMI_TIMER_ID_4 = 4;
    private static final int PROFILE_ID_TIMER_IMMEDIATE = 6;
    private static final int PROFILE_ID_TIMER_1 = 1;
    private static final int PROFILE_ID_TIMER_2 = 2;
    private static final int PROFILE_ID_TIMER_3 = 3;
    private static final int PROFILE_ID_TIMER_4 = 4;
    protected static final int DISABLED = 0;
    protected static final int ENABLED = 1;
    protected static final int IMMEDIATE_CONTROL_STOP = 0;
    protected static final int IMMEDIATE_CONTROL_START = 1;
    protected static final int TIMER_TYPE_INDIVIDUAL = 0;
    protected static final int TIMER_TYPE_CYCLIC = 1;
    protected static final int TIMER_FUNCTION_UNKNOWN = 0;
    protected static final int TIMER_FUNCTION_CHARGE = 1;
    protected static final int TIMER_FUNCTION_CLIMATE = 2;
    protected static final int TIMER_FUNCTION_CHARGExCLIMATE = 3;
    protected static final int TIMER_ERROR_REASON_NONE = 0;
    protected static final int TIMER_ERROR_REASON_GENERALDEVICEERROR = 1;
    protected static final int TIMER_ERROR_REASON_BATTERY_LOW = 2;
    protected static final int TIMER_ERROR_REASON_FUEL_LOW = 3;
    private final TimerHelper helper = new TimerHelper(this.getApplication(), this.getLogChannel());
    private CarServiceTracker bcListHandlingServiceTracker;
    private final BatteryControlListHandlingServiceListener bcListHandlingServiceTrackerListener = new BatteryControlListHandlingServiceListener();
    private final LogChannel dsiLogChannel;
    private final Calendar dsiCalendar = Calendar.getInstance();
    private ClockTime dsiClockTime = new ClockTime();
    private ClockDate dsiClockDate = new ClockDate();
    protected HybridTimerModelHandler timer1ModelHandler;
    protected HybridTimerModelHandler timer2ModelHandler;
    protected HybridTimerModelHandler timer3ModelHandler;
    protected HybridTimerModelHandler timer4ModelHandler;
    protected volatile BatteryControlViewOptions currentViewOptions;
    private BatteryControlTimerState currentBatteryControlTimerState;
    private BatteryControlChargeState currentBatteryControlChargeState;
    private BatteryControlClimateState currentBatteryControlClimateState;
    private final DefaultChoiceListener choiceListener = new DefaultChoiceListener(){

        public void itemSelected(int n, int n2, int n3, int n4) {
            AbstractHybridTimerControlComponent.this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent.DefaultChoiceListener#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
            boolean bl = 1 == n2;
            switch (n) {
                case 2100653: {
                    BatteryControlProfileOperation batteryControlProfileOperation;
                    if (bl && AbstractHybridTimerControlComponent.this.bcListHandlingServiceTrackerListener.isServiceAvailable() && ((batteryControlProfileOperation = AbstractHybridTimerControlComponent.this.bcListHandlingServiceTrackerListener.getService().getBatteryControlProfileOperation(AbstractHybridTimerControlComponent.this.getProfileIDForHMITimerID(0))).isCharge() || !batteryControlProfileOperation.isClimate() || !batteryControlProfileOperation.isClimateWithoutExternalSupply())) {
                        AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimerFunction(0, 2);
                    }
                    AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimerImmediateState(bl ? 1 : 0);
                    break;
                }
                default: {
                    AbstractHybridTimerControlComponent.this.getLogChannel().log(100000, "[AbstractHybridTimerControlComponent.DefaultChoiceListener#itemSelected] ModelID='%1' not supported.", (long)n);
                }
            }
        }
    };
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;

    public AbstractHybridTimerControlComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.dsiLogChannel = iCarApplication.getFrameworkAccess().getLogChannel(DSI_LOGCHANNEL_NAME);
    }

    public LogChannel getLogChannelDSI() {
        return this.dsiLogChannel;
    }

    public int convertTimerHMI2DSI(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    public int convertTimerDSI2HMI(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    protected Date getCorrectedDate(Date date) {
        return this.helper.getTomorrowCurrentTime(date);
    }

    protected boolean dsiNeedsCorrectionOnTimerActivation() {
        return false;
    }

    protected boolean modelNeedsCorrectionAfterChange() {
        return false;
    }

    protected boolean isDirectTransmission() {
        return false;
    }

    protected boolean isOperationMode(int n) {
        boolean bl;
        if (this.currentViewOptions != null && this.currentViewOptions.getConfiguration() != null && this.currentViewOptions.getConfiguration().getClimateOperationModeInstallation() != null) {
            switch (n) {
                case 0: {
                    bl = this.currentViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeImmediatly();
                    break;
                }
                case 1: {
                    bl = this.currentViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeTimer1();
                    break;
                }
                case 2: {
                    bl = this.currentViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeTimer2();
                    break;
                }
                case 3: {
                    bl = this.currentViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeTimer3();
                    break;
                }
                case 4: {
                    bl = this.currentViewOptions.getConfiguration().getClimateOperationModeInstallation().isOperationModeTimer4();
                    break;
                }
                default: {
                    this.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#isOperationMode] Invalid timer identifier: %1", (long)n);
                    bl = false;
                    break;
                }
            }
        } else {
            this.getLogChannel().log(100000, "[AbstractHybridTimerControlComponent#isOperationMode] currentViewOptions='null'. Presume operation mode to be 'false'.");
            bl = false;
        }
        return bl;
    }

    protected void dsiSetBatteryControlTimerImmediateState(int n) {
        this.getLogChannelDSI().log(1000000, "[HMI|--->>|DSI] DSI.setBatteryControlImmediately(%1, %2)", 6L, (long)n);
        this.getDSI().setBatteryControlImmediately(6, n);
    }

    protected void dsiSetBatteryControlTimerFunction(int n, int n2) {
        if (1 == n2 || 2 == n2 || 3 == n2) {
            if (this.bcListHandlingServiceTrackerListener.isServiceAvailable()) {
                boolean bl;
                boolean bl2;
                boolean bl3;
                int n3 = this.convertTimerHMI2DSI(n);
                int n4 = 0 == n ? 6 : this.getProfileIDForDSITimerID(n3);
                switch (n2) {
                    case 1: {
                        bl3 = true;
                        bl2 = false;
                        bl = false;
                        break;
                    }
                    case 2: {
                        bl3 = false;
                        bl2 = true;
                        bl = true;
                        break;
                    }
                    case 3: {
                        bl3 = true;
                        bl2 = true;
                        bl = false;
                        break;
                    }
                    default: {
                        return;
                    }
                }
                this.getLogChannelDSI().log(1000000, "[HMI|--->>|DSI] Service.setBatteryControlProfileOperation(profileIndex='%1', charge='%2', climate='%3', climateWithoutExternalSupply='%4')", (Object)Integer.toString(n4), (Object)Boolean.toString(bl3), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl));
                this.bcListHandlingServiceTrackerListener.getService().setBatteryControlProfileOperation(n4, bl3, bl2, bl);
            }
        } else {
            this.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimerFunction] Invalid timer function: '%1'", (long)n2);
        }
    }

    protected void dsiSetBatteryControlTimerType(int n, int n2) {
        this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimerType] hmiTimerID='%1', timerType='%2'", (long)n, (long)n2);
        if (0 == n2 || 1 == n2) {
            boolean bl = 1 == n2;
            HybridTimerModelHandler hybridTimerModelHandler = this.getTimerModelHandler(n);
            if (null != hybridTimerModelHandler) {
                Date date = hybridTimerModelHandler.getDateForTypeChange(bl);
                Calendar calendar = TimerHelper.getCorrectCalendarFromDate(date);
                this.dsiSetBatteryControlTimer(n, calendar, bl);
            }
        } else {
            this.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimerType] Invalid timer type: '%1'", (long)n2);
        }
    }

    protected void dsiSetBatteryControlTimer(int n, Calendar calendar, boolean bl) {
        BatteryControlWeekdays batteryControlWeekdays;
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimer] hmiTimerID='%1', calendar='%2', cyclicTimer='%3'", (Object)Integer.toString(n), (Object)(null != calendar ? calendar.getTime().toString() : "null"), (Object)Boolean.toString(bl));
        }
        if (bl) {
            batteryControlWeekdays = this.getCyclicControlWeekdays(n);
            batteryControlWeekdays.cyclic = bl;
        } else {
            batteryControlWeekdays = new BatteryControlWeekdays();
        }
        this.dsiSetBatteryControlTimer(n, calendar, batteryControlWeekdays);
    }

    protected void dsiSetBatteryControlTimer(int n, Calendar calendar, BatteryControlWeekdays batteryControlWeekdays) {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimer] hmiTimerID='%1', calendar='%2', weekdays='%3'", (Object)Integer.toString(n), (Object)(null != calendar ? calendar.getTime().toString() : "null"), (Object)(null != batteryControlWeekdays ? batteryControlWeekdays.toString() : "null"));
        }
        calendar = TimerHelper.getCorrectCalendarFromDate(calendar.getTime());
        if (this.helper.getNowInOneYear().getTime().before(calendar.getTime())) {
            calendar = TimerHelper.getCorrectCalendarFromDate(this.helper.getNowInOneYear().getTime());
        }
        int n2 = this.convertTimerHMI2DSI(n);
        int n3 = batteryControlWeekdays.isCyclic() ? 255 : calendar.get(1);
        int n4 = batteryControlWeekdays.isCyclic() ? 255 : calendar.get(2) + 1;
        int n5 = batteryControlWeekdays.isCyclic() ? 255 : calendar.get(5);
        int n6 = calendar.get(11);
        int n7 = calendar.get(12);
        BatteryControlWeekdays batteryControlWeekdays2 = batteryControlWeekdays;
        int n8 = this.getProfileIDForDSITimerID(n2);
        Buffer buffer = new Buffer();
        buffer.append("timer='").append(n2).append("', ");
        buffer.append("year='").append(n3).append("', ");
        buffer.append("month='").append(n4).append("', ");
        buffer.append("day='").append(n5).append("', ");
        buffer.append("hour='").append(n6).append("', ");
        buffer.append("minute='").append(n7).append("', ");
        buffer.append("cyclic='").append(batteryControlWeekdays2).append("', ");
        buffer.append("refProfileID='").append(n8).append("'");
        this.getLogChannelDSI().log(1000000, "[HMI|--->>|DSI] DSI.setBatteryControlTimer(%1)", (Object)buffer.toString());
        this.getDSI().setBatteryControlTimer(n2, n3, n4, n5, n6, n7, batteryControlWeekdays2, n8);
    }

    protected HybridTimerModelHandler getTimerModelHandler(int n) {
        HybridTimerModelHandler hybridTimerModelHandler;
        switch (n) {
            case 1: {
                hybridTimerModelHandler = this.timer1ModelHandler;
                break;
            }
            case 2: {
                hybridTimerModelHandler = this.timer2ModelHandler;
                break;
            }
            case 3: {
                hybridTimerModelHandler = this.timer3ModelHandler;
                break;
            }
            case 4: {
                hybridTimerModelHandler = this.timer4ModelHandler;
                break;
            }
            default: {
                hybridTimerModelHandler = null;
            }
        }
        return hybridTimerModelHandler;
    }

    protected int getNextActiveTimer(List list) {
        HybridTimerModelHandler hybridTimerModelHandler = null;
        if (null != list) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                HybridTimerModelHandler hybridTimerModelHandler2 = (HybridTimerModelHandler)iterator.next();
                if (null == hybridTimerModelHandler2 || !hybridTimerModelHandler2.isTimerActive()) continue;
                if (null == hybridTimerModelHandler) {
                    hybridTimerModelHandler = hybridTimerModelHandler2;
                    continue;
                }
                if (hybridTimerModelHandler.getDateFromMetric().equals(hybridTimerModelHandler2.getDateFromMetric())) continue;
                hybridTimerModelHandler = hybridTimerModelHandler.getDateFromMetric().before(hybridTimerModelHandler2.getDateFromMetric()) ? hybridTimerModelHandler : hybridTimerModelHandler2;
            }
        }
        return null != hybridTimerModelHandler ? hybridTimerModelHandler.getHmiTimerID() : -1;
    }

    private int getProfileIDForHMITimerID(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 6;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    private int getProfileIDForDSITimerID(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 1;
                break;
            }
            case 2: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    private BatteryControlWeekdays getCyclicControlWeekdays(int n) {
        BatteryControlWeekdays batteryControlWeekdays;
        switch (n) {
            case 1: {
                batteryControlWeekdays = null != this.timer1ModelHandler ? this.timer1ModelHandler.getCurrentBatteryControlWeekdays() : new BatteryControlWeekdays();
                break;
            }
            case 2: {
                batteryControlWeekdays = null != this.timer2ModelHandler ? this.timer2ModelHandler.getCurrentBatteryControlWeekdays() : new BatteryControlWeekdays();
                break;
            }
            case 3: {
                batteryControlWeekdays = null != this.timer3ModelHandler ? this.timer3ModelHandler.getCurrentBatteryControlWeekdays() : new BatteryControlWeekdays();
                break;
            }
            case 4: {
                batteryControlWeekdays = null != this.timer4ModelHandler ? this.timer4ModelHandler.getCurrentBatteryControlWeekdays() : new BatteryControlWeekdays();
                break;
            }
            default: {
                batteryControlWeekdays = new BatteryControlWeekdays();
            }
        }
        return batteryControlWeekdays;
    }

    private void onDateTimeChange(boolean bl, boolean bl2) {
    }

    private void onBatteryControlClimatePastErrorReasonUpdate(int n) {
        int n2;
        switch (n) {
            case 0: 
            case 18: {
                n2 = 0;
                break;
            }
            case 10: {
                n2 = 2;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        this.getChoiceModel(2100664).setValue(n2);
    }

    private void onBatteryControlChargePastErrorReasonUpdate(int n) {
        int n2;
        switch (n) {
            case 0: 
            case 16: {
                n2 = 0;
                break;
            }
            default: {
                n2 = 1;
            }
        }
        this.getChoiceModel(2100665).setValue(n2);
    }

    protected abstract HybridTimerConfig getConfig();

    protected abstract boolean isChargeTimerSupported();

    protected abstract boolean isClimateTimerSupported();

    protected abstract void notifyStateChanged(BatteryControlTimerState var1, BatteryControlChargeState var2, BatteryControlClimateState var3);

    protected abstract void onTimerFunctionItemSelected(int var1, int var2);

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions var1);

    public String getName() {
        return "Hybrid Timer Control";
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{10, 11, 12, 13, 14, 8, 9, 22})};
    }

    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        this.bcListHandlingServiceTracker = new CarServiceTracker(this.bcListHandlingServiceTrackerListener, this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcListHandlingServiceTracker.startTracking();
    }

    public void init() {
        super.init();
    }

    public void deinit() {
        this.bcListHandlingServiceTracker.stopTracking();
        super.deinit();
    }

    protected void initModels() {
        this.getChoiceModel(2100653).setChoiceListener(this.choiceListener);
        this.timer1ModelHandler = new HybridTimerModelHandler(1, 2100713, 2100652, 2100685, 2100608, 2100602, 2100661, 2100656, 2100619, 2100689, 2100592, 2100679, 2100678, 2100700, 2100573, 2100577, 2100631, 2100711, 2100643, 2100715, 2100672, 2100637, 2100707);
        this.timer1ModelHandler.init();
        this.timer2ModelHandler = new HybridTimerModelHandler(2, 2100686, 2100651, 2100614, 2100698, 2100581, 2100657, 2100659, 2100615, 2100710, 2100677, 2100682, 2100580, 2100572, 2100598, 2100588, 2100624, 2100630, 2100709, 2100675, 2100684, 2100639, 2100697);
        this.timer2ModelHandler.init();
        this.timer3ModelHandler = new HybridTimerModelHandler(3, 2100703, 2100676, 2100613, 2100699, 2100712, 2100663, 2100660, 2100617, 2100693, 2100585, 2100603, 2100692, 2100601, 2100571, 2100582, 2100687, 2100640, 2100627, 2100706, 2100671, 2100674, 2100634);
        this.timer3ModelHandler.init();
        this.timer4ModelHandler = new HybridTimerModelHandler(4, 2100694, 2100649, 2100680, 2100607, 0x200DD2, 2100662, 2100658, 2100616, 2100599, 2100681, 2100600, 2100714, 2100594, 2100586, 2100702, 2100636, 2100691, 2100683, 2100704, 2100673, 0x200DDD, 2100620);
        this.timer4ModelHandler.init();
    }

    protected void deinitModels() {
        this.getChoiceModel(2100653).resetListener();
        this.timer1ModelHandler.deinit();
        this.timer1ModelHandler = null;
        this.timer1ModelHandler.deinit();
        this.timer2ModelHandler = null;
        this.timer1ModelHandler.deinit();
        this.timer3ModelHandler = null;
        this.timer1ModelHandler.deinit();
        this.timer4ModelHandler = null;
    }

    public void updateClimateSystemType(int n, int n2) {
    }

    public void updateChargeTimerClimateChoice(int n, int n2) {
    }

    public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
        HybridTimerModelHandler hybridTimerModelHandler;
        int n2 = this.convertTimerDSI2HMI(n);
        if (-1 != n2 && null != (hybridTimerModelHandler = this.getTimerModelHandler(n2))) {
            hybridTimerModelHandler.updateBatteryControlProfileOperation(batteryControlProfileOperation);
        }
    }

    public void onTimeChange(ClockTime clockTime) {
        if (null != clockTime) {
            if (this.dsiClockTime.getMinutes() != clockTime.getMinutes() || this.dsiClockTime.getHours() != clockTime.getHours()) {
                this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent#onTimeChange] time='%1'", (Object)clockTime);
                this.dsiCalendar.set(11, clockTime.getHours());
                this.dsiCalendar.set(12, clockTime.getMinutes());
                this.dsiCalendar.set(13, clockTime.getSeconds());
                this.onDateTimeChange(false, true);
            }
            this.dsiClockTime = clockTime;
        }
    }

    public void onDateChange(ClockDate clockDate) {
        if (null != clockDate) {
            if (this.dsiClockDate.getDay() != clockDate.getDay() || this.dsiClockDate.getMonth() != clockDate.getMonth() || this.dsiClockDate.getYear() != clockDate.getYear()) {
                this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent#onDateChange] date='%1'", (Object)clockDate);
                this.dsiCalendar.set(1, clockDate.getYear() + 2000);
                this.dsiCalendar.set(2, clockDate.getMonth() - 1);
                this.dsiCalendar.set(5, clockDate.getDay());
                this.onDateTimeChange(true, false);
            }
            this.dsiClockDate = clockDate;
        }
    }

    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlViewOptions] viewOptions='%1', valid='%2'", (Object)(null != batteryControlViewOptions ? this.formatViewOptionsLog(batteryControlViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != batteryControlViewOptions) {
            this.currentViewOptions = batteryControlViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] success='%1', control='%2'", bl, (long)n);
        switch (n) {
            case 0: {
                this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] 'STOP' %1.", (Object)(bl ? "successful" : "unsuccessful"));
                if (!bl) break;
                this.getChoiceModel(2100653).setValue(0);
                break;
            }
            case 1: {
                this.getLogChannel().log(10000000, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] 'START' %1.", (Object)(bl ? "successful" : "unsuccessful"));
                if (!bl) break;
                this.getChoiceModel(2100653).setValue(1);
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] control='%1' invalid.", (long)n);
            }
        }
    }

    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlTimerState] timerState='%1', validFlag='%2'", (Object)(null == batteryControlTimerState ? "null" : batteryControlTimerState.toString()), (long)n);
        if (1 == n) {
            this.currentBatteryControlTimerState = batteryControlTimerState;
            this.timer1ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.timer2ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.timer3ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.timer4ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer1] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer1ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer2] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer2ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer3] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer3ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer4] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer4ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlChargeState] chargeState='%1', validFlag='%2'", (Object)(null == batteryControlChargeState ? "null" : batteryControlChargeState.toString()), (long)n);
        if (1 == n) {
            this.currentBatteryControlChargeState = batteryControlChargeState;
            int n2 = batteryControlChargeState.getRemainingChargeTime();
            if (65535 == n2 || 0 > n2 || 1500 < n2 || 2 != batteryControlChargeState.getChargeState()) {
                DateMetric dateMetric = new DateMetric(new Date(0L), 5);
                dateMetric.setMetricValid(false);
                this.getMetricsModel(0x200DD0).setMetric(dateMetric);
            } else {
                DateMetric dateMetric = new DateMetric(new Date(n2 * 60 * 1000), 11);
                dateMetric.setUseInstanceUnit(true);
                dateMetric.setMetricValid(true);
                this.getMetricsModel(0x200DD0).setMetric(dateMetric);
            }
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlClimateState] climateState='%1', validFlag='%2'", (Object)(null == batteryControlClimateState ? "null" : batteryControlClimateState.toString()), (long)n);
        if (1 == n) {
            this.currentBatteryControlClimateState = batteryControlClimateState;
            int n2 = batteryControlClimateState.getClimatingTime();
            if (65280 == n2 || 0 > n2 || 1500 < n2 || 12 != batteryControlClimateState.getClimateState()) {
                DateMetric dateMetric = new DateMetric(new Date(0L), 5);
                dateMetric.setMetricValid(false);
                this.getMetricsModel(2100648).setMetric(dateMetric);
            } else {
                DateMetric dateMetric = new DateMetric(new Date(n2 * 60 * 1000), 11);
                dateMetric.setUseInstanceUnit(true);
                dateMetric.setMetricValid(true);
                this.getMetricsModel(2100648).setMetric(dateMetric);
            }
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        if (this.getLogChannelDSI().isInfo()) {
            this.getLogChannelDSI().log(1000000, "[AbstractHybridTimerControlComponent#updateBatteryControlPastErrorReason] %1, validFlag=%2", (Object)new Buffer().append("reset='").append(n).append("' climateStateLastError='").append(n2).append("' chargeStateLastError='").append(n3).append("'").toString(), (long)n4);
        }
        if (1 == n4) {
            this.onBatteryControlClimatePastErrorReasonUpdate(n2);
            this.onBatteryControlChargePastErrorReasonUpdate(n3);
        }
    }

    public void responseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
    }

    public void responseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
    }

    public void responseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
    }

    public void responseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
    }

    public void responseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
    }

    public void responseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
    }

    public void responseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
    }

    public void responseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
    }

    public void responseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
    }

    public void responsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
    }

    public void responsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
    }

    public void responsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
    }

    public void responsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
    }

    public void responsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    protected class HybridTimerModelHandler {
        private final Object mutex = new Object();
        private final int hmiTimerID;
        private final int metricsModelID;
        private final int timerApplyModelID;
        private final int timerStateModelID;
        private final int timerFunctionModelID;
        private final int timerTypeModelID;
        private final int timerTypeSetIndividualModelID;
        private final int timerTypeSetCyclicModelID;
        private final int weekdaySelectAllModelID;
        private final int weekdayMondayModelID;
        private final int weekdayTuesdayModelID;
        private final int weekdayWednesdayModelID;
        private final int weekdayThursdayModelID;
        private final int weekdayFridayModelID;
        private final int weekdaySaturdayModelID;
        private final int weekdaySundayModelID;
        private final int weekdayMondayPreviewModelID;
        private final int weekdayTuesdayPreviewModelID;
        private final int weekdayWednesdayPreviewModelID;
        private final int weekdayThursdayPreviewModelID;
        private final int weekdayFridayPreviewModelID;
        private final int weekdaySaturdayPreviewModelID;
        private final int weekdaySundayPreviewModelID;
        private final boolean directTransmission;
        private final boolean isCyclicSupported;
        private volatile BatteryControlTimer currentDsiBatteryControlTimer = new BatteryControlTimer();
        private volatile BatteryControlProfileOperation currentDsiBatteryControlProfileOperation = new BatteryControlProfileOperation();
        private final DefaultButtonListener buttonListener = new DefaultButtonListener(){

            public void keyReleased(int n, int n2, int n3) {
                AbstractHybridTimerControlComponent.this.getLogChannel().log(10000000, "[HybridTimerModelHandler.DefaultButtonListener#keyReleased] modelID='%1', keyID='%2'", (long)n, (long)n2);
                if (n == HybridTimerModelHandler.this.timerApplyModelID) {
                    boolean bl = HybridTimerModelHandler.this.isCurrentTimerCyclic();
                    AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimer(HybridTimerModelHandler.this.hmiTimerID, HybridTimerModelHandler.this.getCalendarForTimer(bl), bl);
                } else if (n == HybridTimerModelHandler.this.timerTypeSetIndividualModelID) {
                    boolean bl;
                    boolean bl2 = bl = HybridTimerModelHandler.this.isCurrentTimerCyclic();
                    if (bl) {
                        AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimerType(HybridTimerModelHandler.this.hmiTimerID, 0);
                    }
                } else if (n == HybridTimerModelHandler.this.timerTypeSetCyclicModelID) {
                    boolean bl;
                    boolean bl3 = bl = HybridTimerModelHandler.this.isCurrentTimerCyclic();
                    if (!bl) {
                        AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimerType(HybridTimerModelHandler.this.hmiTimerID, 1);
                    }
                } else {
                    AbstractHybridTimerControlComponent.this.getLogChannel().log(100000, "[HybridTimerModelHandler.DefaultButtonListener#keyReleased] ModelID='%1' not supported.", (long)n);
                }
            }
        };
        private final DefaultChoiceListener choiceListener = new DefaultChoiceListener(){

            public void itemSelected(int n, int n2, int n3, int n4) {
                boolean bl;
                AbstractHybridTimerControlComponent.this.getLogChannel().log(10000000, "[HybridTimerModelHandler.DefaultChoiceListener#itemSelected] modelID='%1', itemID='%2'", (long)n, (long)n2);
                boolean bl2 = bl = 1 == n2;
                if (n == HybridTimerModelHandler.this.timerStateModelID) {
                    HybridTimerModelHandler.this.dsiSetBatteryControlTimerState(bl);
                } else if (n == HybridTimerModelHandler.this.timerFunctionModelID) {
                    int n5 = n2;
                    if (0 == n5) {
                        AbstractHybridTimerControlComponent.this.onTimerFunctionItemSelected(HybridTimerModelHandler.this.hmiTimerID, n5);
                    } else {
                        AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimerFunction(HybridTimerModelHandler.this.hmiTimerID, n5);
                    }
                } else if (n == HybridTimerModelHandler.this.timerTypeModelID) {
                    int n6;
                    int n7 = n2;
                    int n8 = n6 = HybridTimerModelHandler.this.isCurrentTimerCyclic() ? 1 : 0;
                    if (n6 != n7) {
                        AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimerType(HybridTimerModelHandler.this.hmiTimerID, n7);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayMondayModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(2, bl);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayTuesdayModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(3, bl);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayWednesdayModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(4, bl);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayThursdayModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(5, bl);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayFridayModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(6, bl);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdaySaturdayModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(7, bl);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdaySundayModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(1, bl);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayMondayPreviewModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(2, bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayMondayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayTuesdayPreviewModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(3, bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayTuesdayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayWednesdayPreviewModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(4, bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayWednesdayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayThursdayPreviewModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(5, bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayThursdayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdayFridayPreviewModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(6, bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayFridayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdaySaturdayPreviewModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(7, bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdaySaturdayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdaySundayPreviewModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setWeekdayForCyclicTimer(1, bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdaySundayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else if (n == HybridTimerModelHandler.this.weekdaySelectAllModelID) {
                    if (HybridTimerModelHandler.this.directTransmission) {
                        HybridTimerModelHandler.this.setAllWeekdayForCyclicTimer(bl);
                    } else {
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdaySelectAllModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayMondayPreviewModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayTuesdayPreviewModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayWednesdayPreviewModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayThursdayPreviewModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdayFridayPreviewModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdaySaturdayPreviewModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(HybridTimerModelHandler.this.weekdaySundayPreviewModelID).setValue(bl ? 1 : 0);
                    }
                } else {
                    AbstractHybridTimerControlComponent.this.getLogChannel().log(100000, "[HybridTimerModelHandler.DefaultChoiceListener#itemSelected] ModelID='%1' not supported.", (long)n);
                }
            }
        };
        private final MetricsListener metricsListener = new MetricsListener(){

            public void metricsUpdated(int n, int n2) {
                AbstractHybridTimerControlComponent.this.getLogChannel().log(10000000, "[HybridTimerModelHandler.MetricsListener#metricsUpdated] modelID='%1', date='%2'", (Object)String.valueOf(n), (Object)AbstractHybridTimerControlComponent.this.getDateMetric(n).getDate());
                if (n == HybridTimerModelHandler.this.metricsModelID) {
                    boolean bl = HybridTimerModelHandler.this.isCurrentTimerCyclic();
                    AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimer(HybridTimerModelHandler.this.hmiTimerID, HybridTimerModelHandler.this.getCalendarForTimer(bl), bl);
                } else {
                    AbstractHybridTimerControlComponent.this.getLogChannel().log(100000, "[HybridTimerModelHandler.DefaultChoiceListener#itemSelected] id='%1' not supported.", (long)n);
                }
            }
        };

        public HybridTimerModelHandler(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20, int n21, int n22, int n23) {
            this.hmiTimerID = n;
            this.directTransmission = AbstractHybridTimerControlComponent.this.isDirectTransmission();
            this.isCyclicSupported = 0 < n6;
            this.metricsModelID = n2;
            this.timerApplyModelID = n3;
            this.timerStateModelID = n4;
            this.timerTypeModelID = n6;
            this.timerFunctionModelID = n5;
            this.timerTypeSetIndividualModelID = n7;
            this.timerTypeSetCyclicModelID = n8;
            this.weekdaySelectAllModelID = n9;
            this.weekdayMondayModelID = n10;
            this.weekdayTuesdayModelID = n11;
            this.weekdayWednesdayModelID = n12;
            this.weekdayThursdayModelID = n13;
            this.weekdayFridayModelID = n14;
            this.weekdaySaturdayModelID = n15;
            this.weekdaySundayModelID = n16;
            this.weekdayMondayPreviewModelID = n17;
            this.weekdayTuesdayPreviewModelID = n18;
            this.weekdayWednesdayPreviewModelID = n19;
            this.weekdayThursdayPreviewModelID = n20;
            this.weekdayFridayPreviewModelID = n21;
            this.weekdaySaturdayPreviewModelID = n22;
            this.weekdaySundayPreviewModelID = n23;
        }

        public HybridTimerModelHandler(int n, int n2, int n3, int n4, int n5) {
            this(n, n2, n3, n4, n5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        }

        public void init() {
            AbstractHybridTimerControlComponent.this.getMetricsModel(this.metricsModelID).setMetricsListener(this.metricsListener);
            AbstractHybridTimerControlComponent.this.getButtonModel(this.timerApplyModelID).setButtonListener(this.buttonListener);
            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerStateModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerFunctionModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerTypeModelID).setChoiceListener(this.choiceListener);
            if (this.isCyclicSupported) {
                AbstractHybridTimerControlComponent.this.getButtonModel(this.timerTypeSetIndividualModelID).setButtonListener(this.buttonListener);
                AbstractHybridTimerControlComponent.this.getButtonModel(this.timerTypeSetCyclicModelID).setButtonListener(this.buttonListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySelectAllModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayMondayModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayTuesdayModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayWednesdayModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayThursdayModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayFridayModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySaturdayModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySundayModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayMondayPreviewModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayTuesdayPreviewModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayWednesdayPreviewModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayThursdayPreviewModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayFridayPreviewModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySaturdayPreviewModelID).setChoiceListener(this.choiceListener);
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySundayPreviewModelID).setChoiceListener(this.choiceListener);
            }
        }

        public void deinit() {
            AbstractHybridTimerControlComponent.this.getMetricsModel(this.metricsModelID).resetListener();
            AbstractHybridTimerControlComponent.this.getButtonModel(this.timerApplyModelID).resetListener();
            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerStateModelID).resetListener();
            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerFunctionModelID).resetListener();
            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerTypeModelID).resetListener();
            if (this.isCyclicSupported) {
                AbstractHybridTimerControlComponent.this.getButtonModel(this.timerTypeSetIndividualModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getButtonModel(this.timerTypeSetCyclicModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySelectAllModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayMondayModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayTuesdayModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayWednesdayModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayThursdayModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayFridayModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySaturdayModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySundayModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayMondayPreviewModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayTuesdayPreviewModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayWednesdayPreviewModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayThursdayPreviewModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayFridayPreviewModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySaturdayPreviewModelID).resetListener();
                AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySundayPreviewModelID).resetListener();
            }
        }

        public int getHmiTimerID() {
            return this.hmiTimerID;
        }

        public boolean isTimerActive() {
            return 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerStateModelID).getValue();
        }

        public Date getDateFromMetric() {
            return AbstractHybridTimerControlComponent.this.getDateMetric(this.metricsModelID).getDate();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void setMetricTimeToNextTimeOccurrence() {
            Object object = this.mutex;
            synchronized (object) {
                DateMetric dateMetric = AbstractHybridTimerControlComponent.this.getDateMetric(this.metricsModelID);
                if (dateMetric != null && AbstractHybridTimerControlComponent.this.helper.isDateInThePast(this.getDateFromMetric(), "setMetricTimeToCorrectedDate")) {
                    dateMetric.setDate(AbstractHybridTimerControlComponent.this.helper.getNextTimeOccurrenceFromNow(this.getDateFromMetric(), "setMetricTimeToCorrectedDate"));
                }
            }
        }

        public Date getDateForTypeChange(boolean bl) {
            Date date = this.getDateFromMetric();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            if (bl) {
                if (AbstractHybridTimerControlComponent.this.helper.isDateInThePast(date, "getDateForTypeChange")) {
                    calendar.add(5, 1);
                }
            } else {
                calendar.setTime(AbstractHybridTimerControlComponent.this.getCorrectedDate(date));
            }
            return calendar.getTime();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public int getCurrentTimerFunction() {
            Object object = this.mutex;
            synchronized (object) {
                int n = null != this.currentDsiBatteryControlProfileOperation ? (this.currentDsiBatteryControlProfileOperation.isCharge() && this.currentDsiBatteryControlProfileOperation.isClimate() ? 3 : (this.currentDsiBatteryControlProfileOperation.isCharge() && !this.currentDsiBatteryControlProfileOperation.isClimate() ? 1 : (!this.currentDsiBatteryControlProfileOperation.isCharge() && this.currentDsiBatteryControlProfileOperation.isClimate() ? 2 : 0))) : 0;
                return n;
            }
        }

        public BatteryControlWeekdays getCurrentBatteryControlWeekdays() {
            return this.getCurrentBatteryControlWeekdays(!this.directTransmission);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateBatteryControlTimer(BatteryControlTimer batteryControlTimer) {
            Object object = this.mutex;
            synchronized (object) {
                if (null != batteryControlTimer) {
                    Object object2;
                    BatteryControlTimer batteryControlTimer2 = this.currentDsiBatteryControlTimer = batteryControlTimer;
                    if (this.currentDsiBatteryControlTimer.getWeekdays().isCyclic()) {
                        object2 = this.getCalendarForWeekdayOfNextTimer(batteryControlTimer);
                        batteryControlTimer2.year = ((Calendar)object2).get(1);
                        batteryControlTimer2.month = ((Calendar)object2).get(2) + 1;
                        batteryControlTimer2.day = ((Calendar)object2).get(5);
                    }
                    AbstractHybridTimerControlComponent.this.helper.setTimerMetric(AbstractHybridTimerControlComponent.this.helper.castTimerToGeneralObject(batteryControlTimer2), AbstractHybridTimerControlComponent.this.getMetricsModel(this.metricsModelID), "updateBatteryControlTimer");
                    if (this.isCyclicSupported) {
                        object2 = batteryControlTimer.getWeekdays();
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerTypeModelID).setValue(((BatteryControlWeekdays)object2).isCyclic() ? 1 : 0);
                        boolean bl = ((BatteryControlWeekdays)object2).isMonday() ? true : this.shouldBeCheckedForNonCyclicTimer(2, ((BatteryControlWeekdays)object2).isMonday(), batteryControlTimer);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayMondayModelID).setValue(bl ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayMondayPreviewModelID).setValue(bl ? 1 : 0);
                        this.currentDsiBatteryControlTimer.getWeekdays().monday = bl;
                        boolean bl2 = ((BatteryControlWeekdays)object2).isTuesday() ? true : this.shouldBeCheckedForNonCyclicTimer(3, ((BatteryControlWeekdays)object2).isTuesday(), batteryControlTimer);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayTuesdayModelID).setValue(bl2 ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayTuesdayPreviewModelID).setValue(bl2 ? 1 : 0);
                        this.currentDsiBatteryControlTimer.getWeekdays().tuesday = bl2;
                        boolean bl3 = ((BatteryControlWeekdays)object2).isWednesday() ? true : this.shouldBeCheckedForNonCyclicTimer(4, ((BatteryControlWeekdays)object2).isWednesday(), batteryControlTimer);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayWednesdayModelID).setValue(bl3 ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayWednesdayPreviewModelID).setValue(bl3 ? 1 : 0);
                        this.currentDsiBatteryControlTimer.getWeekdays().wednesday = bl3;
                        boolean bl4 = ((BatteryControlWeekdays)object2).isThursday() ? true : this.shouldBeCheckedForNonCyclicTimer(5, ((BatteryControlWeekdays)object2).isThursday(), batteryControlTimer);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayThursdayModelID).setValue(bl4 ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayThursdayPreviewModelID).setValue(bl4 ? 1 : 0);
                        this.currentDsiBatteryControlTimer.getWeekdays().thursday = bl4;
                        boolean bl5 = ((BatteryControlWeekdays)object2).isFriday() ? true : this.shouldBeCheckedForNonCyclicTimer(6, ((BatteryControlWeekdays)object2).isFriday(), batteryControlTimer);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayFridayModelID).setValue(bl5 ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayFridayPreviewModelID).setValue(bl5 ? 1 : 0);
                        this.currentDsiBatteryControlTimer.getWeekdays().friday = bl5;
                        boolean bl6 = ((BatteryControlWeekdays)object2).isSaturday() ? true : this.shouldBeCheckedForNonCyclicTimer(7, ((BatteryControlWeekdays)object2).isSaturday(), batteryControlTimer);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySaturdayModelID).setValue(bl6 ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySaturdayPreviewModelID).setValue(bl6 ? 1 : 0);
                        this.currentDsiBatteryControlTimer.getWeekdays().saturday = bl6;
                        boolean bl7 = ((BatteryControlWeekdays)object2).isSunday() ? true : this.shouldBeCheckedForNonCyclicTimer(1, ((BatteryControlWeekdays)object2).isSunday(), batteryControlTimer);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySundayModelID).setValue(bl7 ? 1 : 0);
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySundayPreviewModelID).setValue(bl7 ? 1 : 0);
                        this.currentDsiBatteryControlTimer.getWeekdays().sunday = bl7;
                        AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySelectAllModelID).setValue(this.isSelectionAllWeekdays(this.currentDsiBatteryControlTimer.getWeekdays()) ? 1 : 0);
                    }
                    if (AbstractHybridTimerControlComponent.this.modelNeedsCorrectionAfterChange() && !this.isTimerActive() && !this.isCurrentTimerCyclic()) {
                        this.setMetricTimeToNextTimeOccurrence();
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState) {
            Object object = this.mutex;
            synchronized (object) {
                if (null != batteryControlTimerState) {
                    switch (this.hmiTimerID) {
                        case 1: {
                            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer1() ? 1 : 0);
                            break;
                        }
                        case 2: {
                            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer2() ? 1 : 0);
                            break;
                        }
                        case 3: {
                            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer3() ? 1 : 0);
                            break;
                        }
                        case 4: {
                            AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer4() ? 1 : 0);
                            break;
                        }
                        default: {
                            AbstractHybridTimerControlComponent.this.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#isOperationMode] Invalid configuration. hmiTimerID='%1'", (long)this.hmiTimerID);
                        }
                    }
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void updateBatteryControlProfileOperation(BatteryControlProfileOperation batteryControlProfileOperation) {
            Object object = this.mutex;
            synchronized (object) {
                if (null != batteryControlProfileOperation) {
                    this.currentDsiBatteryControlProfileOperation = batteryControlProfileOperation;
                    int n = this.getCurrentTimerFunction();
                    AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerFunctionModelID).setValue(n);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void dsiSetBatteryControlTimerState(boolean bl) {
            int n = AbstractHybridTimerControlComponent.this.convertTimerHMI2DSI(this.hmiTimerID);
            if (null != AbstractHybridTimerControlComponent.this.currentBatteryControlTimerState) {
                boolean bl2 = 1 == n ? bl : AbstractHybridTimerControlComponent.this.currentBatteryControlTimerState.getProgrammedTimer().isTimer1();
                boolean bl3 = 2 == n ? bl : AbstractHybridTimerControlComponent.this.currentBatteryControlTimerState.getProgrammedTimer().isTimer2();
                boolean bl4 = 3 == n ? bl : AbstractHybridTimerControlComponent.this.currentBatteryControlTimerState.getProgrammedTimer().isTimer3();
                boolean bl5 = 4 == n ? bl : AbstractHybridTimerControlComponent.this.currentBatteryControlTimerState.getProgrammedTimer().isTimer4();
                BatteryControlProgrammedTimer batteryControlProgrammedTimer = new BatteryControlProgrammedTimer(bl2, bl3, bl4, bl5);
                AbstractHybridTimerControlComponent.this.getLogChannelDSI().log(1000000, "[HMI|--->>|DSI] DSI.setBatteryControlTimerState(%1)", (Object)batteryControlProgrammedTimer.toString());
                AbstractHybridTimerControlComponent.this.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
                if (AbstractHybridTimerControlComponent.this.dsiNeedsCorrectionOnTimerActivation() && bl && !this.isCurrentTimerCyclic()) {
                    Calendar calendar = Calendar.getInstance();
                    Object object = this.mutex;
                    synchronized (object) {
                        calendar.setTime(this.getDateFromMetric());
                    }
                    AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimer(this.hmiTimerID, calendar, false);
                }
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private BatteryControlWeekdays getCurrentBatteryControlWeekdays(boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                BatteryControlWeekdays batteryControlWeekdays = this.currentDsiBatteryControlTimer.getWeekdays();
                if (!this.directTransmission && this.isCurrentTimerCyclic()) {
                    batteryControlWeekdays.monday = 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayMondayPreviewModelID).getValue();
                    batteryControlWeekdays.tuesday = 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayTuesdayPreviewModelID).getValue();
                    batteryControlWeekdays.wednesday = 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayWednesdayPreviewModelID).getValue();
                    batteryControlWeekdays.thursday = 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayThursdayPreviewModelID).getValue();
                    batteryControlWeekdays.friday = 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdayFridayPreviewModelID).getValue();
                    batteryControlWeekdays.saturday = 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySaturdayPreviewModelID).getValue();
                    batteryControlWeekdays.sunday = 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.weekdaySundayPreviewModelID).getValue();
                }
                return batteryControlWeekdays;
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private boolean isCurrentTimerCyclic() {
            Object object = this.mutex;
            synchronized (object) {
                if (this.directTransmission) {
                    return this.currentDsiBatteryControlTimer.getWeekdays().isCyclic();
                }
                return 1 == AbstractHybridTimerControlComponent.this.getChoiceModel(this.timerTypeModelID).getValue();
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void setWeekdayForCyclicTimer(int n, boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                Calendar calendar = AbstractHybridTimerControlComponent.this.helper.getCalendarFromTimer(this.currentDsiBatteryControlTimer);
                BatteryControlWeekdays batteryControlWeekdays = this.currentDsiBatteryControlTimer.getWeekdays();
                batteryControlWeekdays.monday = 2 == n ? bl : batteryControlWeekdays.isMonday();
                batteryControlWeekdays.tuesday = 3 == n ? bl : batteryControlWeekdays.isTuesday();
                batteryControlWeekdays.wednesday = 4 == n ? bl : batteryControlWeekdays.isWednesday();
                batteryControlWeekdays.thursday = 5 == n ? bl : batteryControlWeekdays.isThursday();
                batteryControlWeekdays.friday = 6 == n ? bl : batteryControlWeekdays.isFriday();
                batteryControlWeekdays.saturday = 7 == n ? bl : batteryControlWeekdays.isSaturday();
                batteryControlWeekdays.sunday = 1 == n ? bl : batteryControlWeekdays.isSunday();
                batteryControlWeekdays.cyclic = true;
                AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimer(this.hmiTimerID, calendar, batteryControlWeekdays);
            }
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private void setAllWeekdayForCyclicTimer(boolean bl) {
            Object object = this.mutex;
            synchronized (object) {
                Calendar calendar = AbstractHybridTimerControlComponent.this.helper.getCalendarFromTimer(this.currentDsiBatteryControlTimer);
                BatteryControlWeekdays batteryControlWeekdays = this.currentDsiBatteryControlTimer.getWeekdays();
                batteryControlWeekdays.monday = bl;
                batteryControlWeekdays.tuesday = bl;
                batteryControlWeekdays.wednesday = bl;
                batteryControlWeekdays.thursday = bl;
                batteryControlWeekdays.friday = bl;
                batteryControlWeekdays.saturday = bl;
                batteryControlWeekdays.sunday = bl;
                batteryControlWeekdays.cyclic = true;
                AbstractHybridTimerControlComponent.this.dsiSetBatteryControlTimer(this.hmiTimerID, calendar, batteryControlWeekdays);
            }
        }

        private Calendar getCalendarForWeekdayOfNextTimer(BatteryControlTimer batteryControlTimer) {
            int n;
            BatteryControlTimer batteryControlTimer2 = batteryControlTimer;
            BatteryControlWeekdays batteryControlWeekdays = batteryControlTimer.getWeekdays();
            Date date = AbstractHybridTimerControlComponent.this.dsiCalendar.getTime();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            batteryControlTimer2.year = calendar.get(1);
            batteryControlTimer2.month = calendar.get(2) + 1;
            batteryControlTimer2.day = calendar.get(5);
            int[] nArray = new int[]{7, 1, 2, 3, 4, 5, 6};
            int n2 = nArray[calendar.get(7) - 1];
            boolean[] blArray = new boolean[]{false, batteryControlWeekdays.isMonday(), batteryControlWeekdays.isTuesday(), batteryControlWeekdays.isWednesday(), batteryControlWeekdays.isThursday(), batteryControlWeekdays.isFriday(), batteryControlWeekdays.isSaturday(), batteryControlWeekdays.isSunday()};
            int n3 = 0;
            int n4 = 0;
            for (n = 1; n < blArray.length; ++n) {
                if (!AbstractHybridTimerControlComponent.this.helper.getCalendarFromTimer(batteryControlTimer2).getTime().before(date) && n2 == n || n2 < n) {
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

        private boolean isSelectionAllWeekdays(BatteryControlWeekdays batteryControlWeekdays) {
            return batteryControlWeekdays.isMonday() && batteryControlWeekdays.isTuesday() && batteryControlWeekdays.isWednesday() && batteryControlWeekdays.isThursday() && batteryControlWeekdays.isFriday() && batteryControlWeekdays.isSaturday() && batteryControlWeekdays.isSunday();
        }

        private boolean shouldBeCheckedForNonCyclicTimer(int n, boolean bl, BatteryControlTimer batteryControlTimer) {
            if (!batteryControlTimer.getWeekdays().isCyclic()) {
                Calendar calendar = AbstractHybridTimerControlComponent.this.helper.getCalendarFromTimer(batteryControlTimer);
                return n == calendar.get(7);
            }
            return bl;
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        private Calendar getCalendarForTimer(boolean bl) {
            Date date = null;
            Object object = this.mutex;
            synchronized (object) {
                date = AbstractHybridTimerControlComponent.this.getDateMetric(this.metricsModelID).getDate();
            }
            if (date != null) {
                object = Calendar.getInstance();
                ((Calendar)object).setTime(date);
                if (bl) {
                    if (AbstractHybridTimerControlComponent.this.helper.isDateInThePast(date, "getCalendarForTimer")) {
                        ((Calendar)object).add(5, 1);
                    }
                } else if (AbstractHybridTimerControlComponent.this.helper.isDateInThePast(date, "getCalendarForTimer")) {
                    ((Calendar)object).setTime(AbstractHybridTimerControlComponent.this.getCorrectedDate(date));
                }
                return object;
            }
            AbstractHybridTimerControlComponent.this.getLogChannel().log(10000, "[HybridTimerModelHandler#getCalendarForTimer] dateFromMetrics was null, returning Incorrect date.");
            return Calendar.getInstance();
        }
    }

    private class BatteryControlListHandlingServiceListener
    implements CarServiceTrackerListener {
        private IBatteryControlListHandlingService bcListHandlingService = null;

        private BatteryControlListHandlingServiceListener() {
        }

        public IBatteryControlListHandlingService getService() {
            return this.bcListHandlingService;
        }

        public boolean isServiceAvailable() {
            return null != this.bcListHandlingService;
        }

        public void serviceAvailable(Object object) {
            this.bcListHandlingService = (IBatteryControlListHandlingService)object;
            this.bcListHandlingService.registerCalledBackComponent(AbstractHybridTimerControlComponent.this);
        }

        public void serviceRemoved() {
            this.bcListHandlingService = null;
        }

        public String[] getTrackedServiceClazzName() {
            return new String[]{(class$de$audi$atip$interapp$IBatteryControlListHandlingService == null ? (class$de$audi$atip$interapp$IBatteryControlListHandlingService = AbstractHybridTimerControlComponent.class$("de.audi.atip.interapp.IBatteryControlListHandlingService")) : class$de$audi$atip$interapp$IBatteryControlListHandlingService).getName()};
        }
    }
}

