/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sysapp;

import de.audi.atip.interapp.cartrip.ITripDataProvider;
import de.audi.atip.interapp.cartrip.TripModelHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.sysapp.SysApp;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

class SysApp$CarTimeUnitsLanguageListenerImpl
implements DSICarTimeUnitsLanguageListener,
ITripDataProvider {
    private SysApp sysApp;
    private LogChannel lc;
    private TripModelHandler tripModelHandler;
    private ClockDate sClockDate = new ClockDate();
    private ClockTime sClockTime = new ClockTime();

    public SysApp$CarTimeUnitsLanguageListenerImpl(SysApp sysApp, LogChannel logChannel) {
        this.sysApp = sysApp;
        this.lc = logChannel;
        this.tripModelHandler = new TripModelHandler(this);
    }

    @Override
    public void updateWeightUnit(int n, int n2) {
    }

    @Override
    public void updateClockDate(ClockDate clockDate, int n) {
        this.lc.log(1078071040, "DSICarKombiListener.updateClockDate %1 %2", (Object)clockDate, (long)n);
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

    @Override
    public void updateClockTime(ClockTime clockTime, int n) {
        this.lc.log(1078071040, "DSICarKombiListener.updateClockTime %1 %2", (Object)clockTime, (long)n);
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

    @Override
    public void updateClockFormat(int n, int n2) {
        this.lc.log(1078071040, "DSICarKombiListener.updateClockFormat %1 %2", (long)n, (long)n2);
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

    @Override
    public void updateClockDayLightSaving(boolean bl, int n) {
    }

    @Override
    public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
    }

    @Override
    public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
    }

    @Override
    public void updateClockSource(int n, int n2) {
    }

    @Override
    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
    }

    @Override
    public void updateUTCOffset(UTCOffset uTCOffset, int n) {
        this.lc.log(1078071040, "DSICarKombiListener.updateUTCOffset %1 %2", (Object)uTCOffset, (long)n);
        if (n != 1) {
            return;
        }
        if (SysApp.access$200(this.sysApp) != null) {
            switch (uTCOffset.getState()) {
                case 2: {
                    long l = uTCOffset.isAlgebraicSign() ? (long)(uTCOffset.getOffset() * -1) : (long)uTCOffset.getOffset();
                    SysApp.access$200(this.sysApp).utcOffsetChanged(l * 0);
                    break;
                }
                default: {
                    SysApp.access$200(this.sysApp).utcOffsetChanged(SysApp.access$200(this.sysApp).getCurrentTimezoneOffsetMilliseconds());
                }
            }
        }
    }

    @Override
    public void updateClockTimeZoneOffset(float f2, int n) {
        this.lc.log(1078071040, "DSICarKombiListener.updateClockTimeZoneOffset timezone:%1 valid:%2", (Object)String.valueOf(f2), (long)n);
        if (n != 1) {
            return;
        }
        if (SysApp.access$200(this.sysApp) != null) {
            SysApp.access$200(this.sysApp).timezoneOffsetChanged(f2);
        }
    }

    @Override
    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
    }

    @Override
    public void updateConsumptionGasUnit(int n, int n2) {
    }

    @Override
    public void updateConsumptionPetrolUnit(int n, int n2) {
    }

    @Override
    public void updateDateFormat(int n, int n2) {
        this.lc.log(1078071040, "DSICarKombiListener.updateDateFormat %1 %2", (long)n, (long)n2);
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

    @Override
    public void updateDistanceUnit(int n, int n2) {
    }

    @Override
    public void updateMenuLanguage(int n, int n2) {
    }

    @Override
    public void updatePressureUnit(int n, int n2) {
    }

    @Override
    public void updateSpeedUnit(int n, int n2) {
    }

    @Override
    public void updateTemperatureUnit(int n, int n2) {
    }

    @Override
    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
    }

    @Override
    public void updateVolumeUnit(int n, int n2) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void acknowledgeUmSetFactoryDefault(boolean bl) {
    }

    @Override
    public void updateConsumptionElectricUnit(int n, int n2) {
    }

    @Override
    public void updateSkin(int n, int n2) {
    }

    @Override
    public TripModelHandler getTripModelHandler() {
        return this.tripModelHandler;
    }

    @Override
    public int[] getProvidedTripDataTypes() {
        return new int[]{19, 20};
    }

    @Override
    public AbstractMetrics getTripDataValue(int n) {
        switch (n) {
            case 19: {
                return SysApp.access$300(this.sysApp).getMetricsModel(4241).getMetric();
            }
            case 20: {
                return SysApp.access$300(this.sysApp).getMetricsModel(55).getMetric();
            }
        }
        this.lc.log(10000, "[SysApp#getTripDataValue] unsupported data type: %1", (long)n);
        return null;
    }
}

