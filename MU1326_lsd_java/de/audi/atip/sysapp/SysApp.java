/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Consumption;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.Pressure;
import de.audi.atip.metrics.Speed;
import de.audi.atip.metrics.Temperature;
import de.audi.atip.metrics.Volume;
import de.audi.atip.sysapp.GeneralVehicleStateHandler;
import de.audi.atip.sysapp.IStandStillListener;
import de.audi.atip.sysapp.ISysApp;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.sysapp.SysApp$CarTimeUnitsLanguageListenerImpl;
import de.audi.atip.sysapp.SysApp$ClockHandler;
import de.audi.atip.sysapp.SysApp$SysConstInfoProvider;
import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public final class SysApp
implements ISysApp {
    private static final int TIME_FORMAT_READ_ERROR;
    private static final int MODULE_ID;
    private final IFrameworkAccess fw;
    private IAppSystem variantAppSystem = null;
    private final LogChannel lc;
    private SysApp$CarTimeUnitsLanguageListenerImpl carTimeUnitsLanguageListenerImpl;
    private GeneralVehicleStateHandler generalVehicleStateHandler;
    private SysApp$ClockHandler clockHandler;
    private boolean combiDateSet;
    private boolean clockAdjusted;
    private boolean combiTimeSet;
    private boolean engineeringDLActive;
    private volatile int powerState;
    private volatile boolean standstillActive = true;
    private Calendar dateCalendar = Calendar.getInstance();
    private Calendar timeCalendar = Calendar.getInstance();

    SysApp(IFrameworkAccess iFrameworkAccess) {
        this.fw = iFrameworkAccess;
        this.lc = this.fw.getLogChannel("Fw.SysApp");
        this.fw.getErrorMgr().registerDumpInfoProvider(new SysApp$SysConstInfoProvider(this, null));
        this.carTimeUnitsLanguageListenerImpl = new SysApp$CarTimeUnitsLanguageListenerImpl(this, this.lc);
    }

    final IFrameworkAccess getFramework() {
        return this.fw;
    }

    private final HMIService getHMIService() {
        return this.getFramework().getHMIService();
    }

    @Override
    public void registerAppSystem(IAppSystem iAppSystem) {
        this.variantAppSystem = iAppSystem;
    }

    @Override
    public IAppSystem getVariantAppSystem() {
        return this.variantAppSystem;
    }

    public void initModels() {
        this.initClock();
        this.initUnits();
        this.getHMIService().getChoiceModel(345).setValue(0);
        this.getHMIService().getChoiceModel(349).setValue(0);
        this.getHMIService().getChoiceModel(389).setValue(0);
        this.getHMIService().getChoiceModel(9).setValue(0);
        this.getHMIService().getChoiceModel(12).setValue(0);
        this.getHMIService().getChoiceModel(201).setValue(0);
        this.getHMIService().getChoiceModel(392).setValue(-1);
        this.generalVehicleStateHandler = new GeneralVehicleStateHandler(this);
        if (this.getFramework().getScreenRes() != 4) {
            this.getHMIService().getChoiceModel(455).setValue(1);
        } else {
            this.getHMIService().getChoiceModel(455).setValue(0);
        }
        if (this.getFramework().getSysConstManager().getSysConst(466) == 7 && this.getFramework().getSysConstManager().getSysConst(469) == 2 && this.getFramework().getSysConstManager().getSysConst(467) == 4) {
            this.getHMIService().getChoiceModel(4271).setValue(1);
        }
    }

    private int readClockFormat() {
        return this.getFramework().getStorageMgr().getInt(256, 250, -1);
    }

    void initUnits() {
        if (this.getFramework().getLastmodeHandler().getLastmodeStorage().getDistance() == 1) {
            this.getHMIService().getChoiceModel(4016).setValue(0);
            Distance.setSystemUnit(1);
        } else {
            this.getHMIService().getChoiceModel(4016).setValue(1);
            Distance.setSystemUnit(2);
        }
        if (this.getFramework().getLastmodeHandler().getLastmodeStorage().getPressure() == 1) {
            this.getHMIService().getChoiceModel(4017).setValue(0);
            Pressure.setSystemUnit(1);
        } else {
            this.getHMIService().getChoiceModel(4017).setValue(1);
            Pressure.setSystemUnit(2);
        }
        if (this.getFramework().getLastmodeHandler().getLastmodeStorage().getSpeed() == 1) {
            this.getHMIService().getChoiceModel(4018).setValue(0);
            Speed.setSystemUnit(1);
        } else {
            this.getHMIService().getChoiceModel(4018).setValue(1);
            Speed.setSystemUnit(2);
        }
        if (this.getFramework().getLastmodeHandler().getLastmodeStorage().getTemperature() == 1) {
            this.getHMIService().getChoiceModel(4019).setValue(0);
            Temperature.setSystemUnit(1);
        } else {
            this.getHMIService().getChoiceModel(4019).setValue(1);
            Temperature.setSystemUnit(2);
        }
        int n = this.getFramework().getLastmodeHandler().getLastmodeStorage().getConsumption();
        switch (n) {
            case 2: {
                this.getHMIService().getChoiceModel(4014).setValue(0);
                Consumption.setSystemUnit(2);
                break;
            }
            case 3: {
                this.getHMIService().getChoiceModel(4014).setValue(1);
                Consumption.setSystemUnit(3);
                break;
            }
            case 1: {
                this.getHMIService().getChoiceModel(4014).setValue(2);
                Consumption.setSystemUnit(1);
                break;
            }
            case 4: {
                this.getHMIService().getChoiceModel(4014).setValue(3);
                Consumption.setSystemUnit(4);
                break;
            }
        }
        int n2 = this.getFramework().getLastmodeHandler().getLastmodeStorage().getConsumptionElectro();
        switch (n2) {
            case 5: {
                this.getHMIService().getChoiceModel(4015).setValue(0);
                Consumption.setSystemUnitElektro(5);
                break;
            }
            case 6: {
                this.getHMIService().getChoiceModel(4015).setValue(1);
                Consumption.setSystemUnitElektro(6);
                break;
            }
            case 7: {
                this.getHMIService().getChoiceModel(4015).setValue(2);
                Consumption.setSystemUnitElektro(7);
                break;
            }
            case 8: {
                this.getHMIService().getChoiceModel(4015).setValue(3);
                Consumption.setSystemUnitElektro(8);
                break;
            }
        }
        int n3 = this.getFramework().getLastmodeHandler().getLastmodeStorage().getVolume();
        switch (n3) {
            case 1: {
                this.getHMIService().getChoiceModel(4020).setValue(0);
                Volume.setSystemUnit(1);
                break;
            }
            case 2: {
                this.getHMIService().getChoiceModel(4020).setValue(1);
                Volume.setSystemUnit(2);
                break;
            }
            case 3: {
                this.getHMIService().getChoiceModel(4020).setValue(2);
                Volume.setSystemUnit(3);
                break;
            }
        }
    }

    public GeneralVehicleStateHandler getGeneralVehicleStateHandler() {
        return this.generalVehicleStateHandler;
    }

    public void init(boolean bl) {
    }

    public ISysConstManager getSysConstManager() {
        return this.fw.getSysConstManager();
    }

    @Override
    public void registerSpeedThresholdListener(SpeedThresholdListener speedThresholdListener, int n) {
        this.getGeneralVehicleStateHandler().registerThreshold(speedThresholdListener, n);
    }

    @Override
    public void unregisterSpeedThresholdListener(SpeedThresholdListener speedThresholdListener) {
        this.getGeneralVehicleStateHandler().unregisterThreshold(speedThresholdListener);
    }

    @Override
    public void registerStandStillListener(IStandStillListener iStandStillListener) {
        this.getGeneralVehicleStateHandler().registerStandStillListener(iStandStillListener);
    }

    @Override
    public void unregisterStandStillListener(IStandStillListener iStandStillListener) {
        this.getGeneralVehicleStateHandler().unregisterStandStillListener(iStandStillListener);
    }

    @Override
    public MetricsModelApp getClock() {
        return this.getHMIService().getMetricsModel(55);
    }

    public MetricsModelApp getDate() {
        return this.getHMIService().getMetricsModel(4241);
    }

    void initClock() {
        if (this.clockHandler == null) {
            this.clockHandler = new SysApp$ClockHandler(this, this.getClock(), this.getDate());
        }
        this.carTimeUnitsLanguageListenerImpl.doUpdateClockFormat(this.readClockFormat());
    }

    public void setPowerState(int n) {
        this.powerState = n;
        if (this.powerState == 2 || this.powerState == 3) {
            this.clockHandler.setInvisible();
        }
    }

    @Override
    public void adjustClock(Date date) {
        if (this.clockHandler != null && date != null) {
            this.clockHandler.adjustClock(date);
        }
    }

    @Override
    public boolean isClockAdjusted() {
        return this.clockAdjusted;
    }

    private void checkClockAdjusted() {
        if (!this.clockAdjusted && this.combiDateSet && this.combiTimeSet) {
            this.clockAdjusted = true;
            this.fw.getMsgDistrib().sendMessage(42);
            this.fw.getStartupMgr().logStartupEvent(new StringBuffer().append("[CLOCK] Combi Time Available: ").append(new Date(this.fw.getKombiTime())).toString());
        }
    }

    @Override
    public long getAdjustedTime() {
        if (this.clockHandler == null) {
            return System.currentTimeMillis();
        }
        return this.clockHandler.getCurrentTime();
    }

    public long getUTCTime() {
        if (this.clockHandler == null) {
            return System.currentTimeMillis();
        }
        return this.clockHandler.getCurrentUTCTime();
    }

    public long convertUTCTimeToLocalTime(long l) {
        if (this.clockHandler == null) {
            return l;
        }
        return this.clockHandler.convertUTCTimeToLocalTime(l);
    }

    public long convertLocalTimeToUTCTime(long l) {
        if (this.clockHandler == null) {
            return l;
        }
        return this.clockHandler.convertLocalTimeToUTCTime(l);
    }

    public long getCurrentTimezoneOffsetMilliseconds() {
        if (this.clockHandler == null) {
            return 0L;
        }
        return this.clockHandler.getCurrentTimezoneOffsetMilliseconds();
    }

    public long getCurrentUTCOffsetMilliseconds() {
        if (this.clockHandler == null) {
            return 0L;
        }
        return this.clockHandler.getCurrentUTCOffsetMilliseconds();
    }

    @Override
    public boolean isCustomerDownloadActive() {
        return 0 != this.getHMIService().getChoiceModel(392).getValue();
    }

    @Override
    public void setCustomerDownloadActive(boolean bl) {
        this.getHMIService().getChoiceModel(392).setValue(bl ? 1 : 0);
    }

    @Override
    public void setEngineeringDownloadActive(boolean bl) {
        this.engineeringDLActive = bl;
    }

    @Override
    public boolean isEngineeringDownloadActive() {
        return this.engineeringDLActive;
    }

    public void setSwdlActive() {
        this.getHMIService().getChoiceModel(389).setValue(1);
    }

    @Override
    public boolean isRebootToSwdl() {
        return this.getHMIService().getChoiceModel(389).getValue() == 1;
    }

    @Override
    public void storeSysConstsForSWDLReboot() {
    }

    public int getId() {
        return 0;
    }

    public HMIModel getModel(int n) {
        return this.getHMIService().getModel(n);
    }

    public SysApp$CarTimeUnitsLanguageListenerImpl getDSICarTimeUnitsLanguageListener() {
        return this.carTimeUnitsLanguageListenerImpl;
    }

    void updateClockDate(ClockDate clockDate, int n) {
        this.lc.log(1078071040, "updateClockDate %1 %2 ", (Object)clockDate, (long)n);
        if (n != 1) {
            return;
        }
        if (clockDate.getYear() == 1 && clockDate.getMonth() == 1 && clockDate.getDay() == 1) {
            return;
        }
        this.dateCalendar.setTime(((DateMetric)this.getClock().getMetric()).getDate());
        this.dateCalendar.set(clockDate.getYear() + 2000, clockDate.getMonth() == 0 ? 0 : clockDate.getMonth() - 1, clockDate.getDay());
        Date date = this.dateCalendar.getTime();
        this.lc.log(-2137614336, "updateClockDate: date = %1 ", (Object)date);
        this.adjustClock(date);
        this.combiDateSet = true;
        this.checkClockAdjusted();
    }

    void updateClockTime(ClockTime clockTime) {
        if (clockTime.getHours() == 1 && clockTime.getMinutes() == 1 && clockTime.getSeconds() == 1 && clockTime.getTimeZone() == 1.0f) {
            return;
        }
        this.lc.log(-2137614336, "updateClockTime: from = %1 ", (Object)((DateMetric)this.getClock().getMetric()).getDate());
        this.timeCalendar.setTime(((DateMetric)this.getClock().getMetric()).getDate());
        this.timeCalendar.set(this.timeCalendar.get(1), this.timeCalendar.get(2), this.timeCalendar.get(5), clockTime.getHours(), clockTime.getMinutes(), clockTime.getSeconds());
        Date date = this.timeCalendar.getTime();
        this.lc.log(-2137614336, "updateClockTime: to = %1 ", (Object)date);
        this.adjustClock(date);
        this.combiTimeSet = true;
        this.checkClockAdjusted();
    }

    @Override
    public CarFuncAdap getCarFuncAdaptation() {
        return this.getSysConstManager().getCarFuncAdaptation();
    }

    @Override
    public Coding getDiagnosisCOD() {
        return this.getSysConstManager().getCarCoding();
    }

    @Override
    public Adaptation getAdaptationANP() {
        return this.getSysConstManager().getAdaptationANP();
    }

    @Override
    public LoadSpeedThreshold getSpeedThresholdUPDL() {
        return this.getSysConstManager().getSpeedThresholdUPDL();
    }

    @Override
    public boolean isStandstill() {
        return this.standstillActive;
    }

    public void setStandstill(boolean bl) {
        this.standstillActive = bl;
    }

    static /* synthetic */ int access$100(SysApp sysApp) {
        return sysApp.powerState;
    }

    static /* synthetic */ SysApp$ClockHandler access$200(SysApp sysApp) {
        return sysApp.clockHandler;
    }

    static /* synthetic */ HMIService access$300(SysApp sysApp) {
        return sysApp.getHMIService();
    }
}

