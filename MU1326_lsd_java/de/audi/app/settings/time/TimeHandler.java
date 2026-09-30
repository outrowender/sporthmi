/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.time;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.time.AutomaticModeHandler;
import de.audi.app.settings.time.TimeZoneHandler;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.model.MetricsModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.power.PowerEventListener;
import edu.emory.mathcs.backport.java.util.concurrent.atomic.AtomicInteger;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;
import org.dsi.ifc.global.CarViewOption;

public final class TimeHandler
implements ChoiceListener,
MetricsListener,
PowerEventListener {
    private volatile int summerTimeOffset = 0;
    private Calendar calendar = Calendar.getInstance();
    private Calendar timeCalendar = Calendar.getInstance();
    private Calendar dateCalendar = Calendar.getInstance();
    private volatile ClockViewOptions currentClockViewOptions;
    private volatile UnitmasterViewOptions currentUnitViewOptions;
    private final AutomaticModeHandler automaticModeHandler;
    private volatile AtomicInteger ignoreTimeUpdateCounter;
    private final SettingsEnv env;
    private final LogChannel lc;
    private final TimeZoneHandler timeZoneHandler;
    private static final int MIN_IGNORE_UPDATE_TIME_COUNTER = 3;
    private ChoiceModelApp timeVisibilityModel;
    private ChoiceModelApp timeDisclaimer;
    private volatile boolean clamp15 = true;

    public TimeHandler(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.lc = this.env.getFw().getLogChannel("App.Settings.Clock");
        this.automaticModeHandler = new AutomaticModeHandler(this.env, this);
        this.timeZoneHandler = new TimeZoneHandler(this.env, this);
        this.ignoreTimeUpdateCounter = new AtomicInteger(0);
        this.init();
    }

    private DSICarTimeUnitsLanguage getDSI() {
        return this.env.getDSIManager().getDSI();
    }

    public AutomaticModeHandler getAutomaticModeHandler() {
        return this.automaticModeHandler;
    }

    public TimeZoneHandler getTimeZoneHandler() {
        return this.timeZoneHandler;
    }

    private void init() {
        this.env.getChoiceModel(1100230).setChoiceListener(this);
        this.env.getChoiceModel(1100176).setChoiceListener(this);
        this.env.getChoiceModel(1100180).setChoiceListener(this);
        this.env.getChoiceModel(1100179).setChoiceListener(this);
        this.env.getChoiceModel(1100211).setChoiceListener(this);
        this.env.getMetricsModel(1100125).setMetricsListener(this);
        this.env.getChoiceModel(1100138).setValue(1);
        this.env.getMetricsModel(1100134).setMetricsListener(this);
        this.env.getChoiceModel(1100142).setValue(1);
        this.env.getChoiceModel(1100139).setChoiceListener(this);
        this.env.getChoiceModel(1100196).setChoiceListener(this);
        this.env.getChoiceModel(1100238).setValue(1);
        this.timeVisibilityModel = this.env.getChoiceModel(1100136);
        this.timeDisclaimer = this.env.getChoiceModel(1100296);
        MetricsModelApp metricsModelApp = this.env.getFw().getSysApp().getClock();
        DateMetric.timeFormat = this.readTimeFormat(this.env.getFw(), 10);
        DateMetric.dateFormat = this.readDateFormat(this.env.getFw(), 20);
        try {
            if (metricsModelApp != null) {
                Date date = ((DateMetric)metricsModelApp.getMetric()).getDate();
                DateMetric dateMetric = new DateMetric(date, 1);
                this.env.getMetricsModel(1100134).setMetric(dateMetric);
                DateMetric dateMetric2 = new DateMetric(date, 0);
                this.env.getMetricsModel(1100125).setMetric(dateMetric2);
            } else {
                this.lc.log(100000, "could not get clock from HMI framework");
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "Exception: ", (Throwable)exception);
        }
        this.applyClockVisibility();
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void metricsUpdated(int n, int n2) {
        this.lc.log(1000000, "metricsUpdated: %1", (long)n);
        switch (n) {
            case 1100134: {
                this.ignoreTimeUpdateCounter.set(0);
                this.setTime(this.env.getDateMetric(1100134).getDate());
                this.env.getFw().getMsgDistrib().sendMessage(12);
                break;
            }
            case 1100125: {
                this.setDate(this.env.getDateMetric(1100125).getDate());
                this.env.getFw().getMsgDistrib().sendMessage(12);
                break;
            }
            default: {
                this.lc.log(100000, "metricsUpdated: Illegal modelID: %1 ", (long)n);
            }
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        boolean bl = n2 != 0;
        switch (n) {
            case 1100196: {
                this.setClockDaylightSavingState(bl);
                break;
            }
            case 1100139: {
                this.automaticModeHandler.itemSelected(true, false);
                this.setTimeZoneAutomaticCheckBox(bl);
                break;
            }
            case 1100211: {
                this.setDateFormat(n2);
                break;
            }
            case 1100179: {
                this.setClockFormat(n2);
                break;
            }
            case 1100230: {
                this.setManualSummerTime(bl);
                break;
            }
            case 1100180: {
                this.setTimeZoneAutomaticCheckBox(bl);
                break;
            }
            case 1100176: {
                this.setSummerTimeAutomatic(bl);
                break;
            }
        }
    }

    public void setTimeZoneAutomaticCheckBox(boolean bl) {
        this.timeZoneHandler.setTimeZoneAutomaticCheckBox(bl);
    }

    public void setManualSummerTime(boolean bl) {
        this.lc.log(10000000, "TimeHandler.setManualSummerTime(%1)", bl);
        this.getDSI().setClockDayLightSaving(bl);
    }

    public void setSummerTimeAutomatic(boolean bl) {
        this.lc.log(10000000, "TimeHandler.setSummerTimeAutomatic(%1)", bl);
        this.getDSI().setClockDayLightSaving(bl);
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    public void setClockDaylightSavingState(boolean bl) {
        this.lc.log(1000000, "setClockDaylightSavingState: setClockDaylightSavingState onSelected=%1", bl);
        this.getDSI().setClockDayLightSaving(bl);
    }

    private void setTime(Date date) {
        this.lc.log(1000000, "setTime: dsi.setClockTime %1", (Object)date);
        this.calendar.setTime(date);
        this.getDSI().setClockTime((byte)this.calendar.get(11), (byte)this.calendar.get(12), (byte)0);
    }

    private void setDate(Date date) {
        this.calendar.setTime(date);
        ClockDate clockDate = new ClockDate((short)(this.calendar.get(1) - 2000 < 0 ? 0 : this.calendar.get(1) - 2000), (byte)(this.calendar.get(2) + 1), (byte)this.calendar.get(5));
        this.lc.log(1000000, "setDate: dsi.setClockDate %1", (Object)clockDate);
        this.getDSI().setClockDate(clockDate);
    }

    private void setDateFormat(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
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
            default: {
                this.lc.log(100000, "setDateFormat: using default");
            }
        }
        this.lc.log(1000000, "setDateFormat: dsi.setDateFormat(%1)", (long)n2);
        this.getDSI().setDateFormat(n2);
        this.updateDateFormat(n2);
    }

    private void setClockFormat(int n) {
        int n2 = 0;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            default: {
                this.lc.log(100000, "setClockFormat using default");
            }
        }
        this.lc.log(1000000, "setClockFormat: dsi.setClockFormat(%1)", (long)n2);
        this.persistAndSetDSIClockFormat(n2);
        this.updateClockFormat(n2);
    }

    private void persistAndSetDSIClockFormat(int n) {
        this.getDSI().setClockFormat(n);
        this.env.getStorageMgr().setInt(256, 250, n);
    }

    public void setClockSource(int n) {
        this.lc.log(1000000, "setClockSource: dsi.setClockSource(%1)", (Object)this.getReadableDSIClock(n));
        this.getDSI().setClockSource(n);
    }

    public void updateClockDate(ClockDate clockDate) {
        this.dateCalendar.set(clockDate.getYear() + 2000, clockDate.getMonth() == 0 ? 0 : clockDate.getMonth() - 1, clockDate.getDay());
        this.env.getDateMetric(1100125).setDate(this.dateCalendar.getTime());
        this.env.getMetricsModel(1100125).setMetric(this.env.getDateMetric(1100125));
    }

    public void updateClockTime(ClockTime clockTime) {
        if (this.ignoreTimeUpdateCounter.getAndIncrement() < 3) {
            return;
        }
        this.timeCalendar.set(this.timeCalendar.get(1), this.timeCalendar.get(2), this.timeCalendar.get(5), clockTime.getHours(), clockTime.getMinutes(), clockTime.getSeconds());
        this.env.getDateMetric(1100134).setDate(this.timeCalendar.getTime());
        this.env.getMetricsModel(1100134).setMetric(this.env.getDateMetric(1100134));
        this.summerTimeOffset = clockTime.isSummerTime() ? 1 : 0;
        this.lc.log(1000000, "updateClockTime: Summertime='%1', summerTimeOffset='%2'", clockTime.isSummerTime(), (long)this.summerTimeOffset);
    }

    public void updateClockFormat(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                DateMetric.timeFormat = 10;
                this.persistTimeFormat(this.env.getFw(), DateMetric.timeFormat);
                this.env.getMetricsModel(1100134).formatChanged();
                this.env.getFw().getSysApp().getClock().formatChanged();
                this.env.getMetricsModel(55).setMetric(this.env.getDateMetric(55));
                break;
            }
            case 1: {
                n2 = 1;
                DateMetric.timeFormat = 11;
                this.persistTimeFormat(this.env.getFw(), DateMetric.timeFormat);
                this.env.getMetricsModel(1100134).formatChanged();
                this.env.getFw().getSysApp().getClock().formatChanged();
                this.env.getMetricsModel(55).setMetric(this.env.getDateMetric(55));
                break;
            }
        }
        if (n2 != -1) {
            this.env.getFw().getMsgDistrib().sendMessage(11);
            this.env.getChoiceModel(1100179).setValue(n2);
        }
    }

    public void updateDateFormat(int n) {
        int n2 = -1;
        switch (n) {
            case 0: {
                n2 = 0;
                DateMetric.dateFormat = 20;
                this.persistDateFormat(this.env.getFw(), DateMetric.dateFormat);
                this.env.getMetricsModel(1100125).formatChanged();
                ((MetricsModel)this.env.getFw().getSysApp().getClock()).formatChanged();
                this.env.getMetricsModel(1100134).formatChanged();
                break;
            }
            case 1: {
                n2 = 1;
                DateMetric.dateFormat = 23;
                this.persistDateFormat(this.env.getFw(), DateMetric.dateFormat);
                this.env.getMetricsModel(1100125).formatChanged();
                ((MetricsModel)this.env.getFw().getSysApp().getClock()).formatChanged();
                this.env.getMetricsModel(1100134).formatChanged();
                break;
            }
            case 2: {
                n2 = 2;
                DateMetric.dateFormat = 26;
                this.persistDateFormat(this.env.getFw(), DateMetric.dateFormat);
                this.env.getMetricsModel(1100125).formatChanged();
                ((MetricsModel)this.env.getFw().getSysApp().getClock()).formatChanged();
                this.env.getMetricsModel(1100134).formatChanged();
                break;
            }
        }
        if (n2 != -1) {
            this.env.getFw().getMsgDistrib().sendMessage(11);
            this.env.getChoiceModel(1100211).setValue(n2);
        }
    }

    public void updateClockViewOptions(ClockViewOptions clockViewOptions) {
        this.lc.log(10000000, "Timehandler.updateClockViewOptions(%1)", (Object)clockViewOptions);
        this.currentClockViewOptions = clockViewOptions;
        if (!this.env.getFw().getSysConstManager().getCarFuncAdaptation().isMenuDisplayActivated((short)20)) {
            this.lc.log(10000000, "Timehandler.updateClockViewOptions DIAG_CODE_MENUEOPERATION = 0 for clock");
            return;
        }
        this.setVisibilityProxy(clockViewOptions.getTime(), 1100142);
        this.setVisibilityProxy(clockViewOptions.getDate(), 1100138);
        this.applyClockVisibility();
        this.automaticModeHandler.checkAndSetAutomaticModeAvailibility(clockViewOptions);
        this.timeZoneHandler.setVisibility(clockViewOptions);
        this.setSummerTimeAutomaticVisibility();
    }

    private void setSummerTimeAutomaticVisibility() {
        if (this.getAutomaticModeHandler().isAutomaticModeAvailible() || this.currentClockViewOptions.getClockConfig() == null) {
            this.env.getChoiceModel(1100238).setValue(1);
            this.env.getChoiceModel(1100239).setValue(1);
            return;
        }
        if (this.currentClockViewOptions.getClockConfig().getDayLightSavingMode() == 1) {
            this.setVisibilityProxy(this.currentClockViewOptions.getDayLightSaving(), 1100238);
        }
        if (this.currentClockViewOptions.getClockConfig().getDayLightSavingMode() == 2 || this.currentClockViewOptions.getClockConfig().getDayLightSavingMode() == 3) {
            int n = 1100239;
            if (this.currentClockViewOptions.getDayLightSaving() != null) {
                if (this.currentClockViewOptions.getDayLightSaving().state != 0) {
                    if (this.currentClockViewOptions.getDayLightSaving().state == 2 && this.timeZoneHandler.isSummerTimeAutomaticAvailable(this.timeZoneHandler.getCurrenttimeZone())) {
                        this.env.getChoiceModel(n).setValue(0);
                    } else {
                        this.env.getChoiceModel(n).setValue(2);
                    }
                } else {
                    this.env.getChoiceModel(n).setValue(1);
                }
            } else {
                this.env.getChoiceModel(n).setValue(1);
            }
        }
    }

    private void applyClockVisibility() {
        try {
            if (this.env.getFw().getSysConstManager().getCarFuncAdaptation().isMenuDisplayActivated((short)20) || this.env.getFw().getSysConstManager().getCarFuncAdaptation().isMenuDisplayActivated((short)23)) {
                if (this.currentClockViewOptions == null && this.currentUnitViewOptions == null) {
                    this.timeVisibilityModel.setValue(0);
                    return;
                }
                if (this.currentUnitViewOptions == null ^ this.currentClockViewOptions == null) {
                    if (this.currentClockViewOptions != null) {
                        if (this.currentClockViewOptions.getTime().getState() != 2 && this.currentClockViewOptions.getDate().getState() != 2) {
                            this.timeVisibilityModel.setValue(2);
                        }
                        return;
                    }
                    if (this.currentUnitViewOptions != null) {
                        if (this.currentUnitViewOptions.getClockFormat().getState() != 2 && this.currentUnitViewOptions.getDateFormat().getState() != 2) {
                            this.timeVisibilityModel.setValue(2);
                        }
                        return;
                    }
                }
                if (this.currentClockViewOptions.getTime().getState() != 2 && this.currentClockViewOptions.getDate().getState() != 2 && this.currentUnitViewOptions.getClockFormat().getState() != 2 && this.currentUnitViewOptions.getDateFormat().getState() != 2) {
                    if (this.timeVisibilityModel.getValue() == 0) {
                        this.timeVisibilityModel.setValue(2);
                    }
                } else if (this.timeVisibilityModel.getValue() == 2 && this.clamp15) {
                    this.timeVisibilityModel.setValue(0);
                }
            } else {
                this.timeVisibilityModel.setValue(1);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "applyClockVisibility() Exception: ", (Throwable)exception);
            this.timeVisibilityModel.setValue(1);
        }
    }

    private void setVisibilityProxy(CarViewOption carViewOption, int n) {
        if (carViewOption != null) {
            if (carViewOption.state != 0) {
                if (carViewOption.state == 2) {
                    this.env.getChoiceModel(n).setValue(0);
                } else {
                    this.env.getChoiceModel(n).setValue(2);
                }
            } else {
                this.env.getChoiceModel(n).setValue(1);
            }
        } else {
            this.env.getChoiceModel(n).setValue(1);
        }
    }

    public void activateTimeMenuEntry() {
        this.lc.log(10000000, "Timehandler.activateTimeMenuEntry()");
        boolean bl = true;
        boolean bl2 = true;
        if (this.currentClockViewOptions != null) {
            if (this.currentClockViewOptions.getTime() != null) {
                boolean bl3 = bl = this.currentClockViewOptions.getTime().getState() == 2;
            }
            if (this.currentClockViewOptions.getDate() != null) {
                boolean bl4 = bl2 = this.currentClockViewOptions.getDate().getState() == 2;
            }
        }
        if (this.env.getChoiceModel(1100142).getValue() == 2 && bl) {
            this.env.getChoiceModel(1100142).setValue(0);
        }
        if (this.env.getChoiceModel(1100138).getValue() == 2 && bl2) {
            this.env.getChoiceModel(1100138).setValue(0);
        }
    }

    public void deactivateTimeMenuEntry() {
        this.lc.log(10000000, "Timehandler.deactivateTimeMenuEntry()");
        if (this.env.getChoiceModel(1100142).getValue() == 0) {
            this.env.getChoiceModel(1100142).setValue(2);
        }
        if (this.env.getChoiceModel(1100138).getValue() == 0) {
            this.env.getChoiceModel(1100138).setValue(2);
        }
    }

    public void updateClockDayLightSaving(boolean bl) {
        this.lc.log(10000000, "Timehandler.updateClockDayLightSaving(%1)", bl);
        this.env.getChoiceModel(1100230).setValue(bl ? 1 : 0);
        this.env.getChoiceModel(1100176).setValue(bl ? 1 : 0);
    }

    private String getReadableDSIClock(int n) {
        switch (n) {
            case 0: {
                return "invalid";
            }
            case 1: {
                return "Quartz";
            }
            case 2: {
                return "DCF77";
            }
            case 3: {
                return "GPS";
            }
        }
        return "unknown";
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        this.clamp15 = bl2;
        if (this.timeVisibilityModel.getValue() != 1) {
            if (bl2) {
                this.timeVisibilityModel.setValue(0);
                this.timeDisclaimer.setValue(0);
            } else {
                this.timeVisibilityModel.setValue(2);
                this.timeDisclaimer.setValue(3);
            }
        }
    }

    public void setUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions) {
        this.currentUnitViewOptions = unitmasterViewOptions;
        this.applyClockVisibility();
    }

    public int readDateFormat(IFrameworkAccess iFrameworkAccess, int n) {
        return iFrameworkAccess.getStorageMgr().getInt(1011, 102, n);
    }

    public int readTimeFormat(IFrameworkAccess iFrameworkAccess, int n) {
        return iFrameworkAccess.getStorageMgr().getInt(1011, 101, n);
    }

    public void persistDateFormat(IFrameworkAccess iFrameworkAccess, int n) {
        iFrameworkAccess.getStorageMgr().setInt(1011, 102, n);
    }

    public void persistTimeFormat(IFrameworkAccess iFrameworkAccess, int n) {
        iFrameworkAccess.getStorageMgr().setInt(1011, 101, n);
    }
}

