/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$HybridTimerModelHandler$1;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$HybridTimerModelHandler$2;
import de.audi.app.earlyfunc.core.hybrid.AbstractHybridTimerControlComponent$HybridTimerModelHandler$3;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.metrics.DateMetric;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public class AbstractHybridTimerControlComponent$HybridTimerModelHandler {
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
    private final DefaultButtonListener buttonListener = new AbstractHybridTimerControlComponent$HybridTimerModelHandler$1(this);
    private final DefaultChoiceListener choiceListener = new AbstractHybridTimerControlComponent$HybridTimerModelHandler$2(this);
    private final MetricsListener metricsListener = new AbstractHybridTimerControlComponent$HybridTimerModelHandler$3(this);
    private final /* synthetic */ AbstractHybridTimerControlComponent this$0;

    public AbstractHybridTimerControlComponent$HybridTimerModelHandler(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19, int n20, int n21, int n22, int n23) {
        this.this$0 = abstractHybridTimerControlComponent;
        this.hmiTimerID = n;
        this.directTransmission = abstractHybridTimerControlComponent.isDirectTransmission();
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

    public AbstractHybridTimerControlComponent$HybridTimerModelHandler(AbstractHybridTimerControlComponent abstractHybridTimerControlComponent, int n, int n2, int n3, int n4, int n5) {
        this(abstractHybridTimerControlComponent, n, n2, n3, n4, n5, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
    }

    public void init() {
        AbstractHybridTimerControlComponent.access$4500(this.this$0, this.metricsModelID).setMetricsListener(this.metricsListener);
        AbstractHybridTimerControlComponent.access$4600(this.this$0, this.timerApplyModelID).setButtonListener(this.buttonListener);
        AbstractHybridTimerControlComponent.access$4700(this.this$0, this.timerStateModelID).setChoiceListener(this.choiceListener);
        AbstractHybridTimerControlComponent.access$4800(this.this$0, this.timerFunctionModelID).setChoiceListener(this.choiceListener);
        AbstractHybridTimerControlComponent.access$4900(this.this$0, this.timerTypeModelID).setChoiceListener(this.choiceListener);
        if (this.isCyclicSupported) {
            AbstractHybridTimerControlComponent.access$5000(this.this$0, this.timerTypeSetIndividualModelID).setButtonListener(this.buttonListener);
            AbstractHybridTimerControlComponent.access$5100(this.this$0, this.timerTypeSetCyclicModelID).setButtonListener(this.buttonListener);
            AbstractHybridTimerControlComponent.access$5200(this.this$0, this.weekdaySelectAllModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$5300(this.this$0, this.weekdayMondayModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$5400(this.this$0, this.weekdayTuesdayModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$5500(this.this$0, this.weekdayWednesdayModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$5600(this.this$0, this.weekdayThursdayModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$5700(this.this$0, this.weekdayFridayModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$5800(this.this$0, this.weekdaySaturdayModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$5900(this.this$0, this.weekdaySundayModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$6000(this.this$0, this.weekdayMondayPreviewModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$6100(this.this$0, this.weekdayTuesdayPreviewModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$6200(this.this$0, this.weekdayWednesdayPreviewModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$6300(this.this$0, this.weekdayThursdayPreviewModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$6400(this.this$0, this.weekdayFridayPreviewModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$6500(this.this$0, this.weekdaySaturdayPreviewModelID).setChoiceListener(this.choiceListener);
            AbstractHybridTimerControlComponent.access$6600(this.this$0, this.weekdaySundayPreviewModelID).setChoiceListener(this.choiceListener);
        }
    }

    public void deinit() {
        AbstractHybridTimerControlComponent.access$6700(this.this$0, this.metricsModelID).resetListener();
        AbstractHybridTimerControlComponent.access$6800(this.this$0, this.timerApplyModelID).resetListener();
        AbstractHybridTimerControlComponent.access$6900(this.this$0, this.timerStateModelID).resetListener();
        AbstractHybridTimerControlComponent.access$7000(this.this$0, this.timerFunctionModelID).resetListener();
        AbstractHybridTimerControlComponent.access$7100(this.this$0, this.timerTypeModelID).resetListener();
        if (this.isCyclicSupported) {
            AbstractHybridTimerControlComponent.access$7200(this.this$0, this.timerTypeSetIndividualModelID).resetListener();
            AbstractHybridTimerControlComponent.access$7300(this.this$0, this.timerTypeSetCyclicModelID).resetListener();
            AbstractHybridTimerControlComponent.access$7400(this.this$0, this.weekdaySelectAllModelID).resetListener();
            AbstractHybridTimerControlComponent.access$7500(this.this$0, this.weekdayMondayModelID).resetListener();
            AbstractHybridTimerControlComponent.access$7600(this.this$0, this.weekdayTuesdayModelID).resetListener();
            AbstractHybridTimerControlComponent.access$7700(this.this$0, this.weekdayWednesdayModelID).resetListener();
            AbstractHybridTimerControlComponent.access$7800(this.this$0, this.weekdayThursdayModelID).resetListener();
            AbstractHybridTimerControlComponent.access$7900(this.this$0, this.weekdayFridayModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8000(this.this$0, this.weekdaySaturdayModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8100(this.this$0, this.weekdaySundayModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8200(this.this$0, this.weekdayMondayPreviewModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8300(this.this$0, this.weekdayTuesdayPreviewModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8400(this.this$0, this.weekdayWednesdayPreviewModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8500(this.this$0, this.weekdayThursdayPreviewModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8600(this.this$0, this.weekdayFridayPreviewModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8700(this.this$0, this.weekdaySaturdayPreviewModelID).resetListener();
            AbstractHybridTimerControlComponent.access$8800(this.this$0, this.weekdaySundayPreviewModelID).resetListener();
        }
    }

    public int getHmiTimerID() {
        return this.hmiTimerID;
    }

    public boolean isTimerActive() {
        return 1 == AbstractHybridTimerControlComponent.access$8900(this.this$0, this.timerStateModelID).getValue();
    }

    public Date getDateFromMetric() {
        return AbstractHybridTimerControlComponent.access$9000(this.this$0, this.metricsModelID).getDate();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setMetricTimeToNextTimeOccurrence() {
        Object object = this.mutex;
        synchronized (object) {
            DateMetric dateMetric = AbstractHybridTimerControlComponent.access$9100(this.this$0, this.metricsModelID);
            if (dateMetric != null && AbstractHybridTimerControlComponent.access$9200(this.this$0).isDateInThePast(this.getDateFromMetric(), "setMetricTimeToCorrectedDate")) {
                dateMetric.setDate(AbstractHybridTimerControlComponent.access$9200(this.this$0).getNextTimeOccurrenceFromNow(this.getDateFromMetric(), "setMetricTimeToCorrectedDate"));
            }
        }
    }

    public Date getDateForTypeChange(boolean bl) {
        Date date = this.getDateFromMetric();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        if (bl) {
            if (AbstractHybridTimerControlComponent.access$9200(this.this$0).isDateInThePast(date, "getDateForTypeChange")) {
                calendar.add(5, 1);
            }
        } else {
            calendar.setTime(this.this$0.getCorrectedDate(date));
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
                AbstractHybridTimerControlComponent.access$9200(this.this$0).setTimerMetric(AbstractHybridTimerControlComponent.access$9200(this.this$0).castTimerToGeneralObject(batteryControlTimer2), AbstractHybridTimerControlComponent.access$9300(this.this$0, this.metricsModelID), "updateBatteryControlTimer");
                if (this.isCyclicSupported) {
                    object2 = batteryControlTimer.getWeekdays();
                    AbstractHybridTimerControlComponent.access$9400(this.this$0, this.timerTypeModelID).setValue(((BatteryControlWeekdays)object2).isCyclic() ? 1 : 0);
                    boolean bl = ((BatteryControlWeekdays)object2).isMonday() ? true : this.shouldBeCheckedForNonCyclicTimer(2, ((BatteryControlWeekdays)object2).isMonday(), batteryControlTimer);
                    AbstractHybridTimerControlComponent.access$9500(this.this$0, this.weekdayMondayModelID).setValue(bl ? 1 : 0);
                    AbstractHybridTimerControlComponent.access$9600(this.this$0, this.weekdayMondayPreviewModelID).setValue(bl ? 1 : 0);
                    this.currentDsiBatteryControlTimer.getWeekdays().monday = bl;
                    boolean bl2 = ((BatteryControlWeekdays)object2).isTuesday() ? true : this.shouldBeCheckedForNonCyclicTimer(3, ((BatteryControlWeekdays)object2).isTuesday(), batteryControlTimer);
                    AbstractHybridTimerControlComponent.access$9700(this.this$0, this.weekdayTuesdayModelID).setValue(bl2 ? 1 : 0);
                    AbstractHybridTimerControlComponent.access$9800(this.this$0, this.weekdayTuesdayPreviewModelID).setValue(bl2 ? 1 : 0);
                    this.currentDsiBatteryControlTimer.getWeekdays().tuesday = bl2;
                    boolean bl3 = ((BatteryControlWeekdays)object2).isWednesday() ? true : this.shouldBeCheckedForNonCyclicTimer(4, ((BatteryControlWeekdays)object2).isWednesday(), batteryControlTimer);
                    AbstractHybridTimerControlComponent.access$9900(this.this$0, this.weekdayWednesdayModelID).setValue(bl3 ? 1 : 0);
                    AbstractHybridTimerControlComponent.access$10000(this.this$0, this.weekdayWednesdayPreviewModelID).setValue(bl3 ? 1 : 0);
                    this.currentDsiBatteryControlTimer.getWeekdays().wednesday = bl3;
                    boolean bl4 = ((BatteryControlWeekdays)object2).isThursday() ? true : this.shouldBeCheckedForNonCyclicTimer(5, ((BatteryControlWeekdays)object2).isThursday(), batteryControlTimer);
                    AbstractHybridTimerControlComponent.access$10100(this.this$0, this.weekdayThursdayModelID).setValue(bl4 ? 1 : 0);
                    AbstractHybridTimerControlComponent.access$10200(this.this$0, this.weekdayThursdayPreviewModelID).setValue(bl4 ? 1 : 0);
                    this.currentDsiBatteryControlTimer.getWeekdays().thursday = bl4;
                    boolean bl5 = ((BatteryControlWeekdays)object2).isFriday() ? true : this.shouldBeCheckedForNonCyclicTimer(6, ((BatteryControlWeekdays)object2).isFriday(), batteryControlTimer);
                    AbstractHybridTimerControlComponent.access$10300(this.this$0, this.weekdayFridayModelID).setValue(bl5 ? 1 : 0);
                    AbstractHybridTimerControlComponent.access$10400(this.this$0, this.weekdayFridayPreviewModelID).setValue(bl5 ? 1 : 0);
                    this.currentDsiBatteryControlTimer.getWeekdays().friday = bl5;
                    boolean bl6 = ((BatteryControlWeekdays)object2).isSaturday() ? true : this.shouldBeCheckedForNonCyclicTimer(7, ((BatteryControlWeekdays)object2).isSaturday(), batteryControlTimer);
                    AbstractHybridTimerControlComponent.access$10500(this.this$0, this.weekdaySaturdayModelID).setValue(bl6 ? 1 : 0);
                    AbstractHybridTimerControlComponent.access$10600(this.this$0, this.weekdaySaturdayPreviewModelID).setValue(bl6 ? 1 : 0);
                    this.currentDsiBatteryControlTimer.getWeekdays().saturday = bl6;
                    boolean bl7 = ((BatteryControlWeekdays)object2).isSunday() ? true : this.shouldBeCheckedForNonCyclicTimer(1, ((BatteryControlWeekdays)object2).isSunday(), batteryControlTimer);
                    AbstractHybridTimerControlComponent.access$10700(this.this$0, this.weekdaySundayModelID).setValue(bl7 ? 1 : 0);
                    AbstractHybridTimerControlComponent.access$10800(this.this$0, this.weekdaySundayPreviewModelID).setValue(bl7 ? 1 : 0);
                    this.currentDsiBatteryControlTimer.getWeekdays().sunday = bl7;
                    AbstractHybridTimerControlComponent.access$10900(this.this$0, this.weekdaySelectAllModelID).setValue(this.isSelectionAllWeekdays(this.currentDsiBatteryControlTimer.getWeekdays()) ? 1 : 0);
                }
                if (this.this$0.modelNeedsCorrectionAfterChange() && !this.isTimerActive() && !this.isCurrentTimerCyclic()) {
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
                        AbstractHybridTimerControlComponent.access$11000(this.this$0, this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer1() ? 1 : 0);
                        break;
                    }
                    case 2: {
                        AbstractHybridTimerControlComponent.access$11100(this.this$0, this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer2() ? 1 : 0);
                        break;
                    }
                    case 3: {
                        AbstractHybridTimerControlComponent.access$11200(this.this$0, this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer3() ? 1 : 0);
                        break;
                    }
                    case 4: {
                        AbstractHybridTimerControlComponent.access$11300(this.this$0, this.timerStateModelID).setValue(batteryControlTimerState.getProgrammedTimer().isTimer4() ? 1 : 0);
                        break;
                    }
                    default: {
                        this.this$0.getLogChannel().log(10000, "[AbstractHybridTimerControlComponent#isOperationMode] Invalid configuration. hmiTimerID='%1'", (long)this.hmiTimerID);
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
                AbstractHybridTimerControlComponent.access$11400(this.this$0, this.timerFunctionModelID).setValue(n);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void dsiSetBatteryControlTimerState(boolean bl) {
        int n = this.this$0.convertTimerHMI2DSI(this.hmiTimerID);
        if (null != AbstractHybridTimerControlComponent.access$11500(this.this$0)) {
            boolean bl2 = 1 == n ? bl : AbstractHybridTimerControlComponent.access$11500(this.this$0).getProgrammedTimer().isTimer1();
            boolean bl3 = 2 == n ? bl : AbstractHybridTimerControlComponent.access$11500(this.this$0).getProgrammedTimer().isTimer2();
            boolean bl4 = 3 == n ? bl : AbstractHybridTimerControlComponent.access$11500(this.this$0).getProgrammedTimer().isTimer3();
            boolean bl5 = 4 == n ? bl : AbstractHybridTimerControlComponent.access$11500(this.this$0).getProgrammedTimer().isTimer4();
            BatteryControlProgrammedTimer batteryControlProgrammedTimer = new BatteryControlProgrammedTimer(bl2, bl3, bl4, bl5);
            this.this$0.getLogChannelDSI().log(1078071040, "[HMI|--->>|DSI] DSI.setBatteryControlTimerState(%1)", (Object)batteryControlProgrammedTimer.toString());
            this.this$0.getDSI().setBatteryControlTimerState(batteryControlProgrammedTimer);
            if (this.this$0.dsiNeedsCorrectionOnTimerActivation() && bl && !this.isCurrentTimerCyclic()) {
                Calendar calendar = Calendar.getInstance();
                Object object = this.mutex;
                synchronized (object) {
                    calendar.setTime(this.getDateFromMetric());
                }
                this.this$0.dsiSetBatteryControlTimer(this.hmiTimerID, calendar, false);
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
                batteryControlWeekdays.monday = 1 == AbstractHybridTimerControlComponent.access$11600(this.this$0, this.weekdayMondayPreviewModelID).getValue();
                batteryControlWeekdays.tuesday = 1 == AbstractHybridTimerControlComponent.access$11700(this.this$0, this.weekdayTuesdayPreviewModelID).getValue();
                batteryControlWeekdays.wednesday = 1 == AbstractHybridTimerControlComponent.access$11800(this.this$0, this.weekdayWednesdayPreviewModelID).getValue();
                batteryControlWeekdays.thursday = 1 == AbstractHybridTimerControlComponent.access$11900(this.this$0, this.weekdayThursdayPreviewModelID).getValue();
                batteryControlWeekdays.friday = 1 == AbstractHybridTimerControlComponent.access$12000(this.this$0, this.weekdayFridayPreviewModelID).getValue();
                batteryControlWeekdays.saturday = 1 == AbstractHybridTimerControlComponent.access$12100(this.this$0, this.weekdaySaturdayPreviewModelID).getValue();
                batteryControlWeekdays.sunday = 1 == AbstractHybridTimerControlComponent.access$12200(this.this$0, this.weekdaySundayPreviewModelID).getValue();
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
            return 1 == AbstractHybridTimerControlComponent.access$12300(this.this$0, this.timerTypeModelID).getValue();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setWeekdayForCyclicTimer(int n, boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            Calendar calendar = AbstractHybridTimerControlComponent.access$9200(this.this$0).getCalendarFromTimer(this.currentDsiBatteryControlTimer);
            BatteryControlWeekdays batteryControlWeekdays = this.currentDsiBatteryControlTimer.getWeekdays();
            batteryControlWeekdays.monday = 2 == n ? bl : batteryControlWeekdays.isMonday();
            batteryControlWeekdays.tuesday = 3 == n ? bl : batteryControlWeekdays.isTuesday();
            batteryControlWeekdays.wednesday = 4 == n ? bl : batteryControlWeekdays.isWednesday();
            batteryControlWeekdays.thursday = 5 == n ? bl : batteryControlWeekdays.isThursday();
            batteryControlWeekdays.friday = 6 == n ? bl : batteryControlWeekdays.isFriday();
            batteryControlWeekdays.saturday = 7 == n ? bl : batteryControlWeekdays.isSaturday();
            batteryControlWeekdays.sunday = 1 == n ? bl : batteryControlWeekdays.isSunday();
            batteryControlWeekdays.cyclic = true;
            this.this$0.dsiSetBatteryControlTimer(this.hmiTimerID, calendar, batteryControlWeekdays);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setAllWeekdayForCyclicTimer(boolean bl) {
        Object object = this.mutex;
        synchronized (object) {
            Calendar calendar = AbstractHybridTimerControlComponent.access$9200(this.this$0).getCalendarFromTimer(this.currentDsiBatteryControlTimer);
            BatteryControlWeekdays batteryControlWeekdays = this.currentDsiBatteryControlTimer.getWeekdays();
            batteryControlWeekdays.monday = bl;
            batteryControlWeekdays.tuesday = bl;
            batteryControlWeekdays.wednesday = bl;
            batteryControlWeekdays.thursday = bl;
            batteryControlWeekdays.friday = bl;
            batteryControlWeekdays.saturday = bl;
            batteryControlWeekdays.sunday = bl;
            batteryControlWeekdays.cyclic = true;
            this.this$0.dsiSetBatteryControlTimer(this.hmiTimerID, calendar, batteryControlWeekdays);
        }
    }

    private Calendar getCalendarForWeekdayOfNextTimer(BatteryControlTimer batteryControlTimer) {
        int n;
        BatteryControlTimer batteryControlTimer2 = batteryControlTimer;
        BatteryControlWeekdays batteryControlWeekdays = batteryControlTimer.getWeekdays();
        Date date = AbstractHybridTimerControlComponent.access$12400(this.this$0).getTime();
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
            if (!AbstractHybridTimerControlComponent.access$9200(this.this$0).getCalendarFromTimer(batteryControlTimer2).getTime().before(date) && n2 == n || n2 < n) {
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
            Calendar calendar = AbstractHybridTimerControlComponent.access$9200(this.this$0).getCalendarFromTimer(batteryControlTimer);
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
            date = AbstractHybridTimerControlComponent.access$12500(this.this$0, this.metricsModelID).getDate();
        }
        if (date != null) {
            object = Calendar.getInstance();
            ((Calendar)object).setTime(date);
            if (bl) {
                if (AbstractHybridTimerControlComponent.access$9200(this.this$0).isDateInThePast(date, "getCalendarForTimer")) {
                    ((Calendar)object).add(5, 1);
                }
            } else if (AbstractHybridTimerControlComponent.access$9200(this.this$0).isDateInThePast(date, "getCalendarForTimer")) {
                ((Calendar)object).setTime(this.this$0.getCorrectedDate(date));
            }
            return object;
        }
        this.this$0.getLogChannel().log(10000, "[HybridTimerModelHandler#getCalendarForTimer] dateFromMetrics was null, returning Incorrect date.");
        return Calendar.getInstance();
    }

    static /* synthetic */ AbstractHybridTimerControlComponent access$000(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.this$0;
    }

    static /* synthetic */ int access$100(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.timerApplyModelID;
    }

    static /* synthetic */ boolean access$200(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.isCurrentTimerCyclic();
    }

    static /* synthetic */ int access$300(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.hmiTimerID;
    }

    static /* synthetic */ Calendar access$400(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler, boolean bl) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.getCalendarForTimer(bl);
    }

    static /* synthetic */ int access$500(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.timerTypeSetIndividualModelID;
    }

    static /* synthetic */ int access$600(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.timerTypeSetCyclicModelID;
    }

    static /* synthetic */ int access$700(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.timerStateModelID;
    }

    static /* synthetic */ int access$800(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.timerFunctionModelID;
    }

    static /* synthetic */ int access$900(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.timerTypeModelID;
    }

    static /* synthetic */ int access$1000(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayMondayModelID;
    }

    static /* synthetic */ boolean access$1100(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.directTransmission;
    }

    static /* synthetic */ void access$1200(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler, int n, boolean bl) {
        abstractHybridTimerControlComponent$HybridTimerModelHandler.setWeekdayForCyclicTimer(n, bl);
    }

    static /* synthetic */ int access$1300(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayTuesdayModelID;
    }

    static /* synthetic */ int access$1400(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayWednesdayModelID;
    }

    static /* synthetic */ int access$1500(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayThursdayModelID;
    }

    static /* synthetic */ int access$1600(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayFridayModelID;
    }

    static /* synthetic */ int access$1700(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdaySaturdayModelID;
    }

    static /* synthetic */ int access$1800(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdaySundayModelID;
    }

    static /* synthetic */ int access$1900(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayMondayPreviewModelID;
    }

    static /* synthetic */ int access$2100(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayTuesdayPreviewModelID;
    }

    static /* synthetic */ int access$2300(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayWednesdayPreviewModelID;
    }

    static /* synthetic */ int access$2500(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayThursdayPreviewModelID;
    }

    static /* synthetic */ int access$2700(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdayFridayPreviewModelID;
    }

    static /* synthetic */ int access$2900(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdaySaturdayPreviewModelID;
    }

    static /* synthetic */ int access$3100(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdaySundayPreviewModelID;
    }

    static /* synthetic */ int access$3300(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.weekdaySelectAllModelID;
    }

    static /* synthetic */ void access$3400(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler, boolean bl) {
        abstractHybridTimerControlComponent$HybridTimerModelHandler.setAllWeekdayForCyclicTimer(bl);
    }

    static /* synthetic */ int access$4400(AbstractHybridTimerControlComponent$HybridTimerModelHandler abstractHybridTimerControlComponent$HybridTimerModelHandler) {
        return abstractHybridTimerControlComponent$HybridTimerModelHandler.metricsModelID;
    }
}

