/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang.dsi;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.timeunitslang.LanguageHandler;
import de.audi.app.settings.timeunitslang.dsi.NullDSICarTimeUnitsLanguage;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguageListener;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public final class DSICarTimeUnitsLanguageManager
implements DSICarTimeUnitsLanguageListener {
    private DSICarTimeUnitsLanguage dsi;
    private final SettingsEnv env;
    private final LogChannel lc;
    private final LanguageHandler languageHandler;

    public DSICarTimeUnitsLanguageManager(SettingsEnv settingsEnv) {
        this.env = settingsEnv;
        this.lc = settingsEnv.getFw().getLogChannel("App.Settings.DSI");
        this.dsi = new NullDSICarTimeUnitsLanguage(this.lc);
        this.languageHandler = new LanguageHandler(settingsEnv);
    }

    public LanguageHandler getLanguageHandler() {
        return this.languageHandler;
    }

    public void setDSI(DSICarTimeUnitsLanguage dSICarTimeUnitsLanguage) {
        this.lc.log(10000000, "DSICarTimeUnitsLanguage(%1)", (Object)dSICarTimeUnitsLanguage);
        if (null != dSICarTimeUnitsLanguage) {
            this.dsi = dSICarTimeUnitsLanguage;
            dSICarTimeUnitsLanguage.setNotification(this);
        } else {
            this.dsi = new NullDSICarTimeUnitsLanguage(this.lc);
        }
    }

    public DSICarTimeUnitsLanguage getDSI() {
        return this.dsi;
    }

    public void asyncException(int n, String string, int n2) {
        this.lc.log(10000000, "<- asyncException(%2, %1, %3)", (Object)string, (long)n, (long)n2);
    }

    public void updateUnitmasterViewOptions(UnitmasterViewOptions unitmasterViewOptions, int n) {
        this.lc.log(10000000, "<- updateUnitmasterViewOptions(%1, %2)", (Object)unitmasterViewOptions, (long)n);
        if (n == 1 && unitmasterViewOptions != null) {
            this.env.getUnitHandler().updateUnitmasterViewOptions(unitmasterViewOptions);
        }
    }

    public void updateMenuLanguage(int n, int n2) {
        this.lc.log(10000000, "<- updateMenuLanguage(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.languageHandler.updateMenuLanguage(n);
        }
    }

    public void updateTemperatureUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateTemperatureUnit(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getUnitHandler().updateTemperatureUnit(n);
        }
    }

    public void updateDistanceUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateDistanceUnit(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getUnitHandler().updateDistanceUnit(n);
        }
    }

    public void updateSpeedUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateSpeedUnit(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getUnitHandler().updateSpeedUnit(n);
        }
    }

    public void updatePressureUnit(int n, int n2) {
        this.lc.log(10000000, "<- updatePressureUnit(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getUnitHandler().updatePressureUnit(n);
        }
    }

    public void updateVolumeUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateVolumeUnit(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getUnitHandler().updateVolumeUnit(n);
        }
    }

    public void updateConsumptionPetrolUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateConsumptionPetrolUnit(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getUnitHandler().updateConsumptionPetrolUnit(n);
        }
    }

    public void updateConsumptionGasUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateConsumptionGasUnit(%1, %2)", (long)n, (long)n2);
    }

    public void updateConsumptionElectricUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateConsumptionElectricUnit(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getUnitHandler().updateConsumptionElectricUnit(n);
        }
    }

    public void updateClockFormat(int n, int n2) {
        this.lc.log(10000000, "<- updateClockFormat(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getTimeHandler().updateClockFormat(n);
        }
    }

    public void updateDateFormat(int n, int n2) {
        this.lc.log(10000000, "<- updateDateFormat(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            this.env.getTimeHandler().updateDateFormat(n);
        }
    }

    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        this.lc.log(10000000, "<- updateClockViewOptions(%1, %2)", (Object)clockViewOptions, (long)n);
        if (n == 1 && clockViewOptions != null) {
            this.env.getTimeHandler().updateClockViewOptions(clockViewOptions);
        }
    }

    public void updateClockDate(ClockDate clockDate, int n) {
        this.lc.log(10000000, "<- updateClockDate(%1, %2)", (Object)clockDate, (long)n);
        if (n == 1 && clockDate != null) {
            this.env.getTimeHandler().updateClockDate(clockDate);
        }
    }

    public void updateClockTime(ClockTime clockTime, int n) {
        this.lc.log(10000000, "<- updateClockTime(%1, %2)", (Object)clockTime, (long)n);
        if (n == 1 && clockTime != null) {
            this.env.getTimeHandler().updateClockTime(clockTime);
        }
    }

    public void updateClockSource(int n, int n2) {
        this.lc.log(10000000, "<- updateClockSource(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            if (n == 3) {
                if (this.env.getChoiceModel(1100139).getValue() != 1) {
                    if (!this.env.getFw().isPorscheHigh()) {
                        this.env.getTimeHandler().getAutomaticModeHandler().itemSelected(false, false);
                    } else {
                        this.env.getTimeHandler().getAutomaticModeHandler().itemSelected(true, true);
                    }
                }
            } else if (n == 1 && this.env.getChoiceModel(1100139).getValue() != 0) {
                if (!this.env.getFw().isPorscheHigh()) {
                    this.env.getTimeHandler().getAutomaticModeHandler().itemSelected(false, false);
                } else {
                    this.env.getTimeHandler().getAutomaticModeHandler().itemSelected(true, true);
                }
            }
        }
    }

    public void updateClockDayLightSaving(boolean bl, int n) {
        this.lc.log(10000000, "<- updateClockDayLightSaving(%1, %2)", bl, (long)n);
        if (n == 1) {
            this.env.getTimeHandler().updateClockDayLightSaving(bl);
        }
    }

    public void updateClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData, int n) {
        this.lc.log(10000000, "<- updateClockDayLightSavingData(%1, %2)", (Object)clockDayLightSavingData, (long)n);
    }

    public void updateClockTimeZoneOffset(float f2, int n) {
        if (this.lc.isDebug()) {
            this.lc.log(10000000, "<- updateClockTimeZoneOffset(%1, %2)", (Object)Float.toString(f2), (long)n);
        }
        if (n == 1) {
            this.env.getTimeHandler().getTimeZoneHandler().updateClockTimeZoneOffset(f2);
        }
    }

    public void updateClockTimeSourcesAvailable(ClockSources clockSources, int n) {
        this.lc.log(10000000, "<- updateClockTimeSourcesAvailable(%1, %2)", (Object)clockSources, (long)n);
    }

    public void updateClockGPSSyncData(ClockGPSSyncData clockGPSSyncData, int n) {
        this.lc.log(10000000, "<- updateClockGPSSyncData(%1, %2)", (Object)clockGPSSyncData, (long)n);
    }

    public void acknowledgeUmSetFactoryDefault(boolean bl) {
        this.lc.log(10000000, "<- acknowledgeUmSetFactoryDefault(%1)", bl);
    }

    public void updateUTCOffset(UTCOffset uTCOffset, int n) {
        this.lc.log(10000000, "<- updateUTCOffset(%1, %2)", (Object)uTCOffset, (long)n);
    }

    public void updateSkin(int n, int n2) {
        this.lc.log(10000000, "<- updateSkin(%1, %2)", (long)n, (long)n2);
        if (n2 == 1) {
            System.out.println("DSICarTimeUnitsLanguageManager#updateSkin received update for new skin: " + n);
            this.env.getChoiceModel(3937).forceUpdate(true);
            this.env.getFw().getLastmodeHandler().getLastmodeStorage().setSkin(n);
            this.env.getChoiceModel(3937).setValue(n);
        }
    }

    public void updateWeightUnit(int n, int n2) {
        this.lc.log(10000000, "<- updateWeightUnit(%1, %2)", (long)n, (long)n2);
    }
}

