/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IAppSystem;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.interapp.cartrip.ITripDataProvider;
import de.audi.atip.interapp.cartrip.TripModelHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
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
import de.audi.atip.sysapp.carcoding.Adaptation;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.atip.sysapp.carcoding.ISysConstManager;
import de.audi.atip.sysapp.carcoding.LoadSpeedThreshold;
import de.esolutions.fw.util.commons.error.DumpInfoProvider;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public final class SysApp
implements ISysApp {
    private static final int TIME_FORMAT_READ_ERROR = -1;
    private static final int MODULE_ID = 0;
    private final IFrameworkAccess fw;
    private IAppSystem variantAppSystem = null;
    private final LogChannel lc;
    private CarTimeUnitsLanguageListenerImpl carTimeUnitsLanguageListenerImpl;
    private GeneralVehicleStateHandler generalVehicleStateHandler;
    private ClockHandler clockHandler;
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
        this.fw.getErrorMgr().registerDumpInfoProvider(new SysConstInfoProvider());
        this.carTimeUnitsLanguageListenerImpl = new CarTimeUnitsLanguageListenerImpl(this, this.lc);
    }

    final IFrameworkAccess getFramework() {
        return this.fw;
    }

    private final HMIService getHMIService() {
        return this.getFramework().getHMIService();
    }

    public void registerAppSystem(IAppSystem iAppSystem) {
        this.variantAppSystem = iAppSystem;
    }

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

    public void registerSpeedThresholdListener(SpeedThresholdListener speedThresholdListener, int n) {
        this.getGeneralVehicleStateHandler().registerThreshold(speedThresholdListener, n);
    }

    public void unregisterSpeedThresholdListener(SpeedThresholdListener speedThresholdListener) {
        this.getGeneralVehicleStateHandler().unregisterThreshold(speedThresholdListener);
    }

    public void registerStandStillListener(IStandStillListener iStandStillListener) {
        this.getGeneralVehicleStateHandler().registerStandStillListener(iStandStillListener);
    }

    public void unregisterStandStillListener(IStandStillListener iStandStillListener) {
        this.getGeneralVehicleStateHandler().unregisterStandStillListener(iStandStillListener);
    }

    public MetricsModelApp getClock() {
        return this.getHMIService().getMetricsModel(55);
    }

    public MetricsModelApp getDate() {
        return this.getHMIService().getMetricsModel(4241);
    }

    void initClock() {
        if (this.clockHandler == null) {
            this.clockHandler = new ClockHandler(this.getClock(), this.getDate());
        }
        this.carTimeUnitsLanguageListenerImpl.doUpdateClockFormat(this.readClockFormat());
    }

    public void setPowerState(int n) {
        this.powerState = n;
        if (this.powerState == 2 || this.powerState == 3) {
            this.clockHandler.setInvisible();
        }
    }

    public void adjustClock(Date date) {
        if (this.clockHandler != null && date != null) {
            this.clockHandler.adjustClock(date);
        }
    }

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

    public boolean isCustomerDownloadActive() {
        return 0 != this.getHMIService().getChoiceModel(392).getValue();
    }

    public void setCustomerDownloadActive(boolean bl) {
        this.getHMIService().getChoiceModel(392).setValue(bl ? 1 : 0);
    }

    public void setEngineeringDownloadActive(boolean bl) {
        this.engineeringDLActive = bl;
    }

    public boolean isEngineeringDownloadActive() {
        return this.engineeringDLActive;
    }

    public void setSwdlActive() {
        this.getHMIService().getChoiceModel(389).setValue(1);
    }

    public boolean isRebootToSwdl() {
        return this.getHMIService().getChoiceModel(389).getValue() == 1;
    }

    public void storeSysConstsForSWDLReboot() {
    }

    public int getId() {
        return 0;
    }

    public HMIModel getModel(int n) {
        return this.getHMIService().getModel(n);
    }

    public CarTimeUnitsLanguageListenerImpl getDSICarTimeUnitsLanguageListener() {
        return this.carTimeUnitsLanguageListenerImpl;
    }

    void updateClockDate(ClockDate clockDate, int n) {
        this.lc.log(1000000, "updateClockDate %1 %2 ", (Object)clockDate, (long)n);
        if (n != 1) {
            return;
        }
        if (clockDate.getYear() == 1 && clockDate.getMonth() == 1 && clockDate.getDay() == 1) {
            return;
        }
        this.dateCalendar.setTime(((DateMetric)this.getClock().getMetric()).getDate());
        this.dateCalendar.set(clockDate.getYear() + 2000, clockDate.getMonth() == 0 ? 0 : clockDate.getMonth() - 1, clockDate.getDay());
        Date date = this.dateCalendar.getTime();
        this.lc.log(10000000, "updateClockDate: date = %1 ", (Object)date);
        this.adjustClock(date);
        this.combiDateSet = true;
        this.checkClockAdjusted();
    }

    void updateClockTime(ClockTime clockTime) {
        if (clockTime.getHours() == 1 && clockTime.getMinutes() == 1 && clockTime.getSeconds() == 1 && clockTime.getTimeZone() == 1.0f) {
            return;
        }
        this.lc.log(10000000, "updateClockTime: from = %1 ", (Object)((DateMetric)this.getClock().getMetric()).getDate());
        this.timeCalendar.setTime(((DateMetric)this.getClock().getMetric()).getDate());
        this.timeCalendar.set(this.timeCalendar.get(1), this.timeCalendar.get(2), this.timeCalendar.get(5), clockTime.getHours(), clockTime.getMinutes(), clockTime.getSeconds());
        Date date = this.timeCalendar.getTime();
        this.lc.log(10000000, "updateClockTime: to = %1 ", (Object)date);
        this.adjustClock(date);
        this.combiTimeSet = true;
        this.checkClockAdjusted();
    }

    public CarFuncAdap getCarFuncAdaptation() {
        return this.getSysConstManager().getCarFuncAdaptation();
    }

    public Coding getDiagnosisCOD() {
        return this.getSysConstManager().getCarCoding();
    }

    public Adaptation getAdaptationANP() {
        return this.getSysConstManager().getAdaptationANP();
    }

    public LoadSpeedThreshold getSpeedThresholdUPDL() {
        return this.getSysConstManager().getSpeedThresholdUPDL();
    }

    public boolean isStandstill() {
        return this.standstillActive;
    }

    public void setStandstill(boolean bl) {
        this.standstillActive = bl;
    }

    private final class ClockHandler {
        static final int SECONDS_TO_MILLISECONDS = 1000;
        static final int HOUR_TO_MILLISECONDS = 3600000;
        long adjust = 0L;
        volatile long timeZoneOffsetMilliseconds = 0L;
        volatile long utcOffsetMilliseconds = 0L;
        final MetricsModelApp clockModel;
        final MetricsModelApp dateModel;
        Date date;
        DateMetric timeMetric;
        DateMetric dateMetric;

        ClockHandler(MetricsModelApp metricsModelApp, MetricsModelApp metricsModelApp2) {
            this.clockModel = metricsModelApp;
            this.dateModel = metricsModelApp2;
            this.date = new Date(this.getCurrentTime());
            this.timeMetric = new DateMetric(this.date, 1);
            this.dateMetric = new DateMetric(this.date, 0);
            DateMetric.timeFormat = 10;
            DateMetric.dateFormat = 20;
            metricsModelApp.setMetric(this.timeMetric);
            metricsModelApp.setStatus(3);
            metricsModelApp2.setMetric(this.dateMetric);
            metricsModelApp2.setStatus(3);
        }

        public synchronized void setInvisible() {
            this.clockModel.setStatus(3);
            this.dateModel.setStatus(3);
        }

        public long getCurrentTime() {
            return SysApp.this.getFramework().getMonotonicTime() + this.adjust;
        }

        public long getCurrentUTCTime() {
            return this.getCurrentTime() - this.utcOffsetMilliseconds;
        }

        public long convertUTCTimeToLocalTime(long l) {
            return l + this.utcOffsetMilliseconds;
        }

        public long convertLocalTimeToUTCTime(long l) {
            return l - this.utcOffsetMilliseconds;
        }

        public long getCurrentTimezoneOffsetMilliseconds() {
            return this.timeZoneOffsetMilliseconds;
        }

        public long getCurrentUTCOffsetMilliseconds() {
            return this.utcOffsetMilliseconds;
        }

        public void adjustClock(Date date) {
            this.adjust = date.getTime() - SysApp.this.getFramework().getMonotonicTime();
            String string = this.timeMetric.format();
            date.setTime(SysApp.this.getFramework().getMonotonicTime() + this.adjust);
            this.timeMetric.setDate(date);
            this.dateMetric.setDate(date);
            if (this.clockModel.getStatus() != 1) {
                if (SysApp.this.powerState != 2 && SysApp.this.powerState != 3) {
                    this.clockModel.setMetric(this.timeMetric);
                    this.clockModel.setStatus(1);
                    this.dateModel.setMetric(this.dateMetric);
                    this.dateModel.setStatus(1);
                }
            } else if (!string.equals(this.timeMetric.format())) {
                this.clockModel.setMetric(this.timeMetric);
                this.dateModel.setMetric(this.dateMetric);
            }
        }

        public void timezoneOffsetChanged(float f2) {
            this.timeZoneOffsetMilliseconds = (long)(f2 * 3600000.0f);
        }

        public void utcOffsetChanged(long l) {
            this.utcOffsetMilliseconds = l;
        }
    }

    private class SysConstInfoProvider
    implements DumpInfoProvider {
        private SysConstInfoProvider() {
        }

        public String getName() {
            return "SysConst";
        }

        public void dump(PrintStream printStream, String string) {
            try {
                ISysConstManager iSysConstManager = SysApp.this.getSysConstManager();
                printStream.println(iSysConstManager.dumpCarData());
                printStream.println("\n");
            }
            catch (FrameworkException frameworkException) {
                printStream.println("SysConstManager not available!\n");
            }
        }
    }

    private static class CarTimeUnitsLanguageListenerImpl
    implements DSICarTimeUnitsLanguageListener,
    ITripDataProvider {
        private SysApp sysApp;
        private LogChannel lc;
        private TripModelHandler tripModelHandler;
        private ClockDate sClockDate = new ClockDate();
        private ClockTime sClockTime = new ClockTime();

        public CarTimeUnitsLanguageListenerImpl(SysApp sysApp, LogChannel logChannel) {
            this.sysApp = sysApp;
            this.lc = logChannel;
            this.tripModelHandler = new TripModelHandler(this);
        }

        public void updateWeightUnit(int n, int n2) {
        }

        public void updateClockDate(ClockDate clockDate, int n) {
            this.lc.log(1000000, "DSICarKombiListener.updateClockDate %1 %2", (Object)clockDate, (long)n);
            if (n != 1) {
                return;
            }
            if (clockDate != null) {
                this.sClockDate.year = clockDate.getYear();
                this.sClockDate.month = clockDate.getMonth();
                this.sClockDate.day = clockDate.getDay();
                this.sysApp.updateClockDate(this.sClockDate, n);
                this.tripModelHandler.updateMetricsModel(19);
                this.tripModelHandler.updateMetricsModel(20);
            }
        }

        public void updateClockTime(ClockTime clockTime, int n) {
            this.lc.log(1000000, "DSICarKombiListener.updateClockTime %1 %2", (Object)clockTime, (long)n);
            if (n != 1) {
                return;
            }
            if (clockTime != null) {
                this.sClockTime.hours = clockTime.getHours();
                this.sClockTime.minutes = clockTime.getMinutes();
                this.sClockTime.seconds = clockTime.getSeconds();
                this.sClockTime.timeZone = clockTime.getTimeZone();
                this.sysApp.updateClockTime(this.sClockTime);
                this.tripModelHandler.updateMetricsModel(19);
                this.tripModelHandler.updateMetricsModel(20);
            }
        }

        public void updateClockFormat(int n, int n2) {
            this.lc.log(1000000, "DSICarKombiListener.updateClockFormat %1 %2", (long)n, (long)n2);
            if (n2 == 1) {
                this.doUpdateClockFormat(n);
            }
        }

        public void doUpdateClockFormat(int n) {
            switch (n) {
                case 0: {
                    DateMetric.timeFormat = 10;
                    break;
                }
                case 1: {
                    DateMetric.timeFormat = 11;
                    break;
                }
                default: {
                    return;
                }
            }
            this.sysApp.getClock().formatChanged();
            this.tripModelHandler.updateMetricsModel(20);
            this.sysApp.getFramework().getMsgDistrib().sendMessage(11);
        }

        public void updateClockDayLightSaving(boolean bl, int n) {
        }

        public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
        }

        public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
        }

        public void updateClockSource(int n, int n2) {
        }

        public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
        }

        public void updateUTCOffset(UTCOffset uTCOffset, int n) {
            this.lc.log(1000000, "DSICarKombiListener.updateUTCOffset %1 %2", (Object)uTCOffset, (long)n);
            if (n != 1) {
                return;
            }
            if (this.sysApp.clockHandler != null) {
                switch (uTCOffset.getState()) {
                    case 2: {
                        long l = uTCOffset.isAlgebraicSign() ? (long)(uTCOffset.getOffset() * -1) : (long)uTCOffset.getOffset();
                        this.sysApp.clockHandler.utcOffsetChanged(l * 1000L);
                        break;
                    }
                    default: {
                        this.sysApp.clockHandler.utcOffsetChanged(this.sysApp.clockHandler.getCurrentTimezoneOffsetMilliseconds());
                    }
                }
            }
        }

        public void updateClockTimeZoneOffset(float f2, int n) {
            this.lc.log(1000000, "DSICarKombiListener.updateClockTimeZoneOffset timezone:%1 valid:%2", (Object)String.valueOf(f2), (long)n);
            if (n != 1) {
                return;
            }
            if (this.sysApp.clockHandler != null) {
                this.sysApp.clockHandler.timezoneOffsetChanged(f2);
            }
        }

        public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        }

        public void updateConsumptionGasUnit(int n, int n2) {
        }

        public void updateConsumptionPetrolUnit(int n, int n2) {
        }

        public void updateDateFormat(int n, int n2) {
            this.lc.log(1000000, "DSICarKombiListener.updateDateFormat %1 %2", (long)n, (long)n2);
            if (n2 != 1) {
                return;
            }
            switch (n) {
                case 0: {
                    DateMetric.dateFormat = 20;
                    break;
                }
                case 1: {
                    DateMetric.dateFormat = 23;
                    break;
                }
                case 2: {
                    DateMetric.dateFormat = 26;
                    break;
                }
                default: {
                    return;
                }
            }
            this.sysApp.getClock().formatChanged();
            this.tripModelHandler.updateMetricsModel(19);
            this.sysApp.getFramework().getMsgDistrib().sendMessage(11);
        }

        public void updateDistanceUnit(int n, int n2) {
        }

        public void updateMenuLanguage(int n, int n2) {
        }

        public void updatePressureUnit(int n, int n2) {
        }

        public void updateSpeedUnit(int n, int n2) {
        }

        public void updateTemperatureUnit(int n, int n2) {
        }

        public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        }

        public void updateVolumeUnit(int n, int n2) {
        }

        public void asyncException(int n, String string, int n2) {
        }

        public void acknowledgeUmSetFactoryDefault(boolean bl) {
        }

        public void updateConsumptionElectricUnit(int n, int n2) {
        }

        public void updateSkin(int n, int n2) {
        }

        public TripModelHandler getTripModelHandler() {
            return this.tripModelHandler;
        }

        public int[] getProvidedTripDataTypes() {
            return new int[]{19, 20};
        }

        public AbstractMetrics getTripDataValue(int n) {
            switch (n) {
                case 19: {
                    return this.sysApp.getHMIService().getMetricsModel(4241).getMetric();
                }
                case 20: {
                    return this.sysApp.getHMIService().getMetricsModel(55).getMetric();
                }
            }
            this.lc.log(10000, "[SysApp#getTripDataValue] unsupported data type: %1", (long)n);
            return null;
        }
    }
}

