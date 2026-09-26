/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarHybridAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.service.CarServiceTracker;
import de.audi.app.car.common.util.TimerHelper;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$1;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$BatteryControlListHandlingServiceListener;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$HybridTimerModelHandler;
import de.audi.app.earlyfunc.core.hybrid.HybridTimerConfig;
import de.audi.app.earlyfunc.core.hybrid.IDateTimeChangeListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
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
    public static final short CODING_ID_CHARGE;
    public static final short CODING_ID_CLIMATE;
    public static final short[] CODING_IDS;
    public static final String LOGCHANNEL_NAME;
    public static final String DSI_LOGCHANNEL_NAME;
    protected static final int INVALID;
    private static final int INVALID_TIMER_VALUE_;
    public static final int HMI_TIMER_ID_IMMEDIATE;
    public static final int HMI_TIMER_ID_1;
    public static final int HMI_TIMER_ID_2;
    public static final int HMI_TIMER_ID_3;
    public static final int HMI_TIMER_ID_4;
    private static final int PROFILE_ID_TIMER_IMMEDIATE;
    private static final int PROFILE_ID_TIMER_1;
    private static final int PROFILE_ID_TIMER_2;
    private static final int PROFILE_ID_TIMER_3;
    private static final int PROFILE_ID_TIMER_4;
    protected static final int DISABLED;
    protected static final int ENABLED;
    protected static final int IMMEDIATE_CONTROL_STOP;
    protected static final int IMMEDIATE_CONTROL_START;
    protected static final int TIMER_TYPE_INDIVIDUAL;
    protected static final int TIMER_TYPE_CYCLIC;
    protected static final int TIMER_FUNCTION_UNKNOWN;
    protected static final int TIMER_FUNCTION_CHARGE;
    protected static final int TIMER_FUNCTION_CLIMATE;
    protected static final int TIMER_FUNCTION_CHARGExCLIMATE;
    protected static final int TIMER_ERROR_REASON_NONE;
    protected static final int TIMER_ERROR_REASON_GENERALDEVICEERROR;
    protected static final int TIMER_ERROR_REASON_BATTERY_LOW;
    protected static final int TIMER_ERROR_REASON_FUEL_LOW;
    private final TimerHelper helper = new TimerHelper(this.getApplication(), this.getLogChannel());
    private CarServiceTracker bcListHandlingServiceTracker;
    private final AbstractHybridTimerControlComponent$BatteryControlListHandlingServiceListener bcListHandlingServiceTrackerListener = new AbstractHybridTimerControlComponent$BatteryControlListHandlingServiceListener(this, null);
    private final LogChannel dsiLogChannel;
    private final Calendar dsiCalendar = Calendar.getInstance();
    private ClockTime dsiClockTime = new ClockTime();
    private ClockDate dsiClockDate = new ClockDate();
    protected AbstractHybridTimerControlComponent$HybridTimerModelHandler timer1ModelHandler;
    protected AbstractHybridTimerControlComponent$HybridTimerModelHandler timer2ModelHandler;
    protected AbstractHybridTimerControlComponent$HybridTimerModelHandler timer3ModelHandler;
    protected AbstractHybridTimerControlComponent$HybridTimerModelHandler timer4ModelHandler;
    protected volatile BatteryControlViewOptions currentViewOptions;
    private BatteryControlTimerState currentBatteryControlTimerState;
    private BatteryControlChargeState currentBatteryControlChargeState;
    private BatteryControlClimateState currentBatteryControlClimateState;
    private final DefaultChoiceListener choiceListener = new AbstractHybridTimerControlComponent$1(this);
    static /* synthetic */ Class class$de$audi$atip$interapp$IBatteryControlListHandlingService;

    public AbstractHybridTimerControlComponent(ICarApplication iCarApplication) {
        super(iCarApplication, "App.EarlyFunc.Hybrid.Timer");
        this.dsiLogChannel = iCarApplication.getFrameworkAccess().getLogChannel("App.EarlyFunc.Hybrid.DSI");
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
            this.getLogChannel().log(-1601830656, "[AbstractHybridTimerControlComponent#isOperationMode] currentViewOptions='null'. Presume operation mode to be 'false'.");
            bl = false;
        }
        return bl;
    }

    protected void dsiSetBatteryControlTimerImmediateState(int n) {
        this.getLogChannelDSI().log(1078071040, "[HMI|--->>|DSI] DSI.setBatteryControlImmediately(%1, %2)", (long)0, (long)n);
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
                this.getLogChannelDSI().log(1078071040, "[HMI|--->>|DSI] Service.setBatteryControlProfileOperation(profileIndex='%1', charge='%2', climate='%3', climateWithoutExternalSupply='%4')", (Object)Integer.toString(n4), (Object)Boolean.toString(bl3), (Object)Boolean.toString(bl2), (Object)Boolean.toString(bl));
                this.bcListHandlingServiceTrackerListener.getService().setBatteryControlProfileOperation(n4, bl3, bl2, bl);
            }
        } else {
            this.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimerFunction] Invalid timer function: '%1'", (long)n2);
        }
    }

    protected void dsiSetBatteryControlTimerType(int n, int n2) {
        this.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimerType] hmiTimerID='%1', timerType='%2'", (long)n, (long)n2);
        if (0 == n2 || 1 == n2) {
            boolean bl = 1 == n2;
            AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler = this.getTimerModelHandler(n);
            if (null != abstractHybridTimerControlComponent$HybridTimerModelHandler) {
                Date date = abstractHybridTimerControlComponent$HybridTimerModelHandler.getDateForTypeChange(bl);
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
            this.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimer] hmiTimerID='%1', calendar='%2', cyclicTimer='%3'", (Object)Integer.toString(n), (Object)(null != calendar ? calendar.getTime().toString() : "null"), (Object)Boolean.toString(bl));
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
            this.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent#dsiSetBatteryControlTimer] hmiTimerID='%1', calendar='%2', weekdays='%3'", (Object)Integer.toString(n), (Object)(null != calendar ? calendar.getTime().toString() : "null"), (Object)(null != batteryControlWeekdays ? batteryControlWeekdays.toString() : "null"));
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
        this.getLogChannelDSI().log(1078071040, "[HMI|--->>|DSI] DSI.setBatteryControlTimer(%1)", (Object)buffer.toString());
        this.getDSI().setBatteryControlTimer(n2, n3, n4, n5, n6, n7, batteryControlWeekdays2, n8);
    }

    protected AbstractHybridTimerControlComponent$HybridTimerModelHandler getTimerModelHandler(int n) {
        AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler;
        switch (n) {
            case 1: {
                abstractHybridTimerControlComponent$HybridTimerModelHandler = this.timer1ModelHandler;
                break;
            }
            case 2: {
                abstractHybridTimerControlComponent$HybridTimerModelHandler = this.timer2ModelHandler;
                break;
            }
            case 3: {
                abstractHybridTimerControlComponent$HybridTimerModelHandler = this.timer3ModelHandler;
                break;
            }
            case 4: {
                abstractHybridTimerControlComponent$HybridTimerModelHandler = this.timer4ModelHandler;
                break;
            }
            default: {
                abstractHybridTimerControlComponent$HybridTimerModelHandler = null;
            }
        }
        return abstractHybridTimerControlComponent$HybridTimerModelHandler;
    }

    protected int getNextActiveTimer(List list) {
        AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler = null;
        if (null != list) {
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler2 = (AbstractHybridTimerControlComponent$HybridTimerModelHandler)iterator.next();
                if (null == abstractHybridTimerControlComponent$HybridTimerModelHandler2 || !abstractHybridTimerControlComponent$HybridTimerModelHandler2.isTimerActive()) continue;
                if (null == abstractHybridTimerControlComponent$HybridTimerModelHandler) {
                    abstractHybridTimerControlComponent$HybridTimerModelHandler = abstractHybridTimerControlComponent$HybridTimerModelHandler2;
                    continue;
                }
                if (abstractHybridTimerControlComponent$HybridTimerModelHandler.getDateFromMetric().equals(abstractHybridTimerControlComponent$HybridTimerModelHandler2.getDateFromMetric())) continue;
                abstractHybridTimerControlComponent$HybridTimerModelHandler = abstractHybridTimerControlComponent$HybridTimerModelHandler.getDateFromMetric().before(abstractHybridTimerControlComponent$HybridTimerModelHandler2.getDateFromMetric()) ? abstractHybridTimerControlComponent$HybridTimerModelHandler : abstractHybridTimerControlComponent$HybridTimerModelHandler2;
            }
        }
        return null != abstractHybridTimerControlComponent$HybridTimerModelHandler ? abstractHybridTimerControlComponent$HybridTimerModelHandler.getHmiTimerID() : -1;
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
        this.getChoiceModel(-1207099392).setValue(n2);
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
        this.getChoiceModel(-1190322176).setValue(n2);
    }

    protected abstract HybridTimerConfig getConfig() {
    }

    protected abstract boolean isChargeTimerSupported() {
    }

    protected abstract boolean isClimateTimerSupported() {
    }

    protected abstract void notifyStateChanged(BatteryControlTimerState batteryControlTimerState, BatteryControlChargeState batteryControlChargeState, BatteryControlClimateState batteryControlClimateState) {
    }

    protected abstract void onTimerFunctionItemSelected(int n, int n2) {
    }

    protected abstract void updateMenuEntryVisibility(BatteryControlViewOptions batteryControlViewOptions) {
    }

    @Override
    public String getName() {
        return "Hybrid Timer Control";
    }

    @Override
    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{6}, new int[]{10, 11, 12, 13, 14, 8, 9, 22})};
    }

    @Override
    public String getCurrentViewOptions() {
        Buffer buffer = new Buffer();
        buffer.append(null == this.currentViewOptions ? "No view options received yet" : this.currentViewOptions.toString());
        return buffer.toString();
    }

    @Override
    protected void dsiAvailable(boolean bl) {
        super.dsiAvailable(bl);
        this.bcListHandlingServiceTracker = new CarServiceTracker(this.bcListHandlingServiceTrackerListener, this.getApplication().getBundleContext(), this.getLogChannel());
        this.bcListHandlingServiceTracker.startTracking();
    }

    @Override
    public void init() {
        super.init();
    }

    @Override
    public void deinit() {
        this.bcListHandlingServiceTracker.stopTracking();
        super.deinit();
    }

    @Override
    protected void initModels() {
        this.getChoiceModel(-1391648768).setChoiceListener(this.choiceListener);
        this.timer1ModelHandler = new AbstractHybridTimerControlComponent$HybridTimerModelHandler(this, 1, -385015808, -1408425984, -854777856, -2146623488, 2047680512, -1257431040, -1341317120, -1962074112, -787668992, 1879908352, -955441152, -972218368, -603119616, 1561141248, 1628250112, -1760747520, -418570240, -1559420928, -351461376, -1072881664, -1660084224, -485679104);
        this.timer1ModelHandler.init();
        this.timer2ModelHandler = new AbstractHybridTimerControlComponent$HybridTimerModelHandler(this, 2, -838000640, -1425203200, -2045960192, -636674048, 1695358976, -1324539904, -1290985472, -2029182976, -435347456, -988995584, -905109504, 1678581760, 1544364032, 1980571648, 1812799488, -1878188032, -1777524736, -452124672, -1022550016, -871555072, -1626529792, -653451264);
        this.timer2ModelHandler.init();
        this.timer3ModelHandler = new AbstractHybridTimerControlComponent$HybridTimerModelHandler(this, 3, -552787968, -1005772800, -2062737408, -619896832, -401793024, -1223876608, -1274208256, -1995628544, -720560128, 1762467840, 2064457728, -737337344, 2030903296, 1527586816, 1712136192, -821223424, -1609752576, -1827856384, -502456320, -1089658880, -1039327232, -1710415872);
        this.timer3ModelHandler.init();
        this.timer4ModelHandler = new AbstractHybridTimerControlComponent$HybridTimerModelHandler(this, 4, -703782912, -1458757632, -938663936, 2131566592, -770891776, -1240653824, -1307762688, -2012405760, 1997348864, -921886720, 2014126080, -368238592, 1913462784, 1779245056, -569565184, -1676861440, -754114560, -888332288, -536010752, -1056104448, -586342400, -1945296896);
        this.timer4ModelHandler.init();
    }

    @Override
    protected void deinitModels() {
        this.getChoiceModel(-1391648768).resetListener();
        this.timer1ModelHandler.deinit();
        this.timer1ModelHandler = null;
        this.timer1ModelHandler.deinit();
        this.timer2ModelHandler = null;
        this.timer1ModelHandler.deinit();
        this.timer3ModelHandler = null;
        this.timer1ModelHandler.deinit();
        this.timer4ModelHandler = null;
    }

    @Override
    public void updateClimateSystemType(int n, int n2) {
    }

    @Override
    public void updateChargeTimerClimateChoice(int n, int n2) {
    }

    @Override
    public void onBatteryControlProfileOperationChanged(int n, BatteryControlProfileOperation batteryControlProfileOperation) {
        AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler;
        int n2 = this.convertTimerDSI2HMI(n);
        if (-1 != n2 && null != (abstractHybridTimerControlComponent$HybridTimerModelHandler = this.getTimerModelHandler(n2))) {
            abstractHybridTimerControlComponent$HybridTimerModelHandler.updateBatteryControlProfileOperation(batteryControlProfileOperation);
        }
    }

    @Override
    public void onTimeChange(ClockTime clockTime) {
        if (null != clockTime) {
            if (this.dsiClockTime.getMinutes() != clockTime.getMinutes() || this.dsiClockTime.getHours() != clockTime.getHours()) {
                this.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent#onTimeChange] time='%1'", (Object)clockTime);
                this.dsiCalendar.set(11, clockTime.getHours());
                this.dsiCalendar.set(12, clockTime.getMinutes());
                this.dsiCalendar.set(13, clockTime.getSeconds());
                this.onDateTimeChange(false, true);
            }
            this.dsiClockTime = clockTime;
        }
    }

    @Override
    public void onDateChange(ClockDate clockDate) {
        if (null != clockDate) {
            if (this.dsiClockDate.getDay() != clockDate.getDay() || this.dsiClockDate.getMonth() != clockDate.getMonth() || this.dsiClockDate.getYear() != clockDate.getYear()) {
                this.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent#onDateChange] date='%1'", (Object)clockDate);
                this.dsiCalendar.set(1, clockDate.getYear() + 2000);
                this.dsiCalendar.set(2, clockDate.getMonth() - 1);
                this.dsiCalendar.set(5, clockDate.getDay());
                this.onDateTimeChange(true, false);
            }
            this.dsiClockDate = clockDate;
        }
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlViewOptions] viewOptions='%1', valid='%2'", (Object)(null != batteryControlViewOptions ? this.formatViewOptionsLog(batteryControlViewOptions.toString()) : "null"), (long)n);
        }
        if (1 == n && null != batteryControlViewOptions) {
            this.currentViewOptions = batteryControlViewOptions;
            this.updateMenuEntryVisibility(this.currentViewOptions);
            this.primaryAttributeFirstSetReceived();
        }
    }

    @Override
    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] success='%1', control='%2'", bl, (long)n);
        switch (n) {
            case 0: {
                this.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] 'STOP' %1.", (Object)(bl ? "successful" : "unsuccessful"));
                if (!bl) break;
                this.getChoiceModel(-1391648768).setValue(0);
                break;
            }
            case 1: {
                this.getLogChannel().log(-2137614336, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] 'START' %1.", (Object)(bl ? "successful" : "unsuccessful"));
                if (!bl) break;
                this.getChoiceModel(-1391648768).setValue(1);
                break;
            }
            default: {
                this.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#acknowledgeBatteryControlImmediately] control='%1' invalid.", (long)n);
            }
        }
    }

    @Override
    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlTimerState] timerState='%1', validFlag='%2'", (Object)(null == batteryControlTimerState ? "null" : batteryControlTimerState.toString()), (long)n);
        if (1 == n) {
            this.currentBatteryControlTimerState = batteryControlTimerState;
            this.timer1ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.timer2ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.timer3ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.timer4ModelHandler.updateBatteryControlTimerState(batteryControlTimerState);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    @Override
    public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer1] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer1ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    @Override
    public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer2] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer2ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    @Override
    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer3] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer3ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    @Override
    public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlTimer4] timer='%1', validFlag='%2'", (Object)(null == batteryControlTimer ? "null" : batteryControlTimer.toString()), (long)n);
        if (1 == n) {
            this.timer4ModelHandler.updateBatteryControlTimer(batteryControlTimer);
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlChargeState] chargeState='%1', validFlag='%2'", (Object)(null == batteryControlChargeState ? "null" : batteryControlChargeState.toString()), (long)n);
        if (1 == n) {
            this.currentBatteryControlChargeState = batteryControlChargeState;
            int n2 = batteryControlChargeState.getRemainingChargeTime();
            if (-65536 == n2 || 0 > n2 || 1500 < n2 || 2 != batteryControlChargeState.getChargeState()) {
                DateMetric dateMetric = new DateMetric(new Date(0L), 5);
                dateMetric.setMetricValid(false);
                this.getMetricsModel(-804446208).setMetric(dateMetric);
            } else {
                DateMetric dateMetric = new DateMetric(new Date(n2 * 60 * 1000), 11);
                dateMetric.setUseInstanceUnit(true);
                dateMetric.setMetricValid(true);
                this.getMetricsModel(-804446208).setMetric(dateMetric);
            }
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    @Override
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlClimateState] climateState='%1', validFlag='%2'", (Object)(null == batteryControlClimateState ? "null" : batteryControlClimateState.toString()), (long)n);
        if (1 == n) {
            this.currentBatteryControlClimateState = batteryControlClimateState;
            int n2 = batteryControlClimateState.getClimatingTime();
            if (0xFF0000 == n2 || 0 > n2 || 1500 < n2 || 12 != batteryControlClimateState.getClimateState()) {
                DateMetric dateMetric = new DateMetric(new Date(0L), 5);
                dateMetric.setMetricValid(false);
                this.getMetricsModel(-1475534848).setMetric(dateMetric);
            } else {
                DateMetric dateMetric = new DateMetric(new Date(n2 * 60 * 1000), 11);
                dateMetric.setUseInstanceUnit(true);
                dateMetric.setMetricValid(true);
                this.getMetricsModel(-1475534848).setMetric(dateMetric);
            }
            this.notifyStateChanged(this.currentBatteryControlTimerState, this.currentBatteryControlChargeState, this.currentBatteryControlClimateState);
        }
    }

    @Override
    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        if (this.getLogChannelDSI().isInfo()) {
            this.getLogChannelDSI().log(1078071040, "[AbstractHybridTimerControlComponent#updateBatteryControlPastErrorReason] %1, validFlag=%2", (Object)new Buffer().append("reset='").append(n).append("' climateStateLastError='").append(n2).append("' chargeStateLastError='").append(n3).append("'").toString(), (long)n4);
        }
        if (1 == n4) {
            this.onBatteryControlClimatePastErrorReasonUpdate(n2);
            this.onBatteryControlChargePastErrorReasonUpdate(n3);
        }
    }

    @Override
    public void responseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
    }

    @Override
    public void responseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
    }

    @Override
    public void responseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
    }

    @Override
    public void responseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
    }

    @Override
    public void responseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
    }

    @Override
    public void responseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
    }

    @Override
    public void responseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
    }

    @Override
    public void responseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
    }

    @Override
    public void responseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
    }

    @Override
    public void responsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
    }

    @Override
    public void responsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
    }

    @Override
    public void responsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
    }

    @Override
    public void responsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
    }

    @Override
    public void responsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
    }

    static /* synthetic */ ChoiceModelApp access$2000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$2200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$2400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$2600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$2800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$3900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$4000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$4100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$4200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ DateMetric access$4300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getDateMetric(n);
    }

    static /* synthetic */ MetricsModelApp access$4500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getMetricsModel(n);
    }

    static /* synthetic */ ButtonModelApp access$4600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getButtonModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$4700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$4800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$4900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ButtonModelApp access$5000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$5100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getButtonModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$5900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ MetricsModelApp access$6700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getMetricsModel(n);
    }

    static /* synthetic */ ButtonModelApp access$6800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getButtonModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$6900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ButtonModelApp access$7200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getButtonModel(n);
    }

    static /* synthetic */ ButtonModelApp access$7300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getButtonModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$7900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$8900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ DateMetric access$9000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getDateMetric(n);
    }

    static /* synthetic */ DateMetric access$9100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getDateMetric(n);
    }

    static /* synthetic */ TimerHelper access$9200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent) {
        return abstractHybridTimerControlComponent.helper;
    }

    static /* synthetic */ MetricsModelApp access$9300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getMetricsModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$9400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$9500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$9600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$9700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$9800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$9900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$10900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ BatteryControlTimerState access$11500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent) {
        return abstractHybridTimerControlComponent.currentBatteryControlTimerState;
    }

    static /* synthetic */ ChoiceModelApp access$11600(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$11900(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$12000(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$12100(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$12200(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ ChoiceModelApp access$12300(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getChoiceModel(n);
    }

    static /* synthetic */ Calendar access$12400(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent) {
        return abstractHybridTimerControlComponent.dsiCalendar;
    }

    static /* synthetic */ DateMetric access$12500(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getDateMetric(n);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ AbstractHybridTimerControlComponent$BatteryControlListHandlingServiceListener access$12700(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent) {
        return abstractHybridTimerControlComponent.bcListHandlingServiceTrackerListener;
    }

    static /* synthetic */ int access$12800(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n) {
        return abstractHybridTimerControlComponent.getProfileIDForHMITimerID(n);
    }

    static {
        CODING_IDS = new short[]{41, 46};
    }
}

