/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.time;

import de.audi.app.settings.SettingsEnv;
import de.audi.app.settings.time.TimeHandler;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;

public class AutomaticModeHandler {
    private final SettingsEnv env;
    private final TimeHandler timeHandler;
    private boolean automaticModeActive;
    private boolean automaticModeAvailible;
    private LogChannel lc;

    public AutomaticModeHandler(SettingsEnv settingsEnv, TimeHandler timeHandler) {
        this.env = settingsEnv;
        this.lc = settingsEnv.getFw().getLogChannel("App.Settings.Clock");
        this.timeHandler = timeHandler;
        settingsEnv.getChoiceModel(1100189).setValue(1);
    }

    public void checkAndSetAutomaticModeAvailibility(ClockViewOptions clockViewOptions) {
        this.lc.log(10000000, "AutomaticModeHandler.checkAndSetAutomaticModeAvailibility %1", (Object)clockViewOptions);
        if (this.env.getFw().isEvoStd()) {
            return;
        }
        if (clockViewOptions.clockSource == null || clockViewOptions.clockConfig == null || clockViewOptions.clockConfig.timeSourcesInstallation == null) {
            return;
        }
        if (clockViewOptions.clockConfig.dayLightSavingMode != 4) {
            return;
        }
        if (clockViewOptions.clockSource.getState() == 2 && clockViewOptions.clockConfig.timeSourcesInstallation.isGps() && clockViewOptions.clockConfig.timeSourcesInstallation.isQuartz()) {
            this.automaticModeAvailible = true;
            this.getChoiceModel(1100189).setValue(0);
            this.checkAndSetAutomaticModeStatus();
        } else if (clockViewOptions.clockSource.getState() == 1 && clockViewOptions.clockConfig.timeSourcesInstallation.isGps() && clockViewOptions.clockConfig.timeSourcesInstallation.isQuartz()) {
            this.automaticModeAvailible = true;
            if (clockViewOptions.clockSource.getReason() == 12) {
                this.getChoiceModel(1100189).setValue(3);
            } else {
                this.getChoiceModel(1100189).setValue(2);
            }
        } else if (clockViewOptions.clockSource.getState() == 0) {
            this.env.getChoiceModel(1100189).setValue(1);
        }
    }

    private void checkAndSetAutomaticModeStatus() {
        this.automaticModeActive = this.env.getFw().getStorageMgr().getBoolean(1011, 30, true);
        this.lc.log(10000000, "AutomaticModeHandler.checkAndSetAutomaticModeStatus() automaticModeActive=%1", this.automaticModeActive);
        if (this.automaticModeActive) {
            this.getChoiceModel(1100139).setValue(1);
            if (this.env.getNavigationListener() != null) {
                this.env.getNavigationListener().setClockSummerTimeData();
            }
            this.timeHandler.deactivateTimeMenuEntry();
        } else {
            this.getChoiceModel(1100139).setValue(0);
            this.timeHandler.activateTimeMenuEntry();
        }
    }

    public void itemSelected(boolean bl, boolean bl2) {
        this.toggleAutomaticModeAndPersist(bl, bl2);
    }

    private void toggleAutomaticModeAndPersist(boolean bl, boolean bl2) {
        this.lc.log(10000000, "AutomaticModeHandler.toggleAutomaticModeAndPersist()");
        if (this.automaticModeActive) {
            this.deactivateAutomaticMode(bl, bl2);
            this.automaticModeActive = false;
        } else {
            this.acivateAutomaticMode(bl, bl2);
            this.automaticModeActive = true;
        }
        this.env.getFw().getStorageMgr().setBoolean(1011, 30, this.automaticModeActive);
    }

    private void deactivateAutomaticMode(boolean bl, boolean bl2) {
        this.lc.log(10000000, "AutomaticModeHandler.deactivateAutomaticMode()");
        this.getChoiceModel(1100139).setValue(0);
        if (bl2) {
            this.lc.log(10000000, "AutomaticModeHandler.deactivateAutomaticMode() [IC Update]");
            this.timeHandler.setTimeZoneAutomaticCheckBox(false);
        }
        this.timeHandler.activateTimeMenuEntry();
        if (bl) {
            this.timeHandler.setClockSource(1);
        }
        this.timeHandler.setClockDaylightSavingState(false);
    }

    private void acivateAutomaticMode(boolean bl, boolean bl2) {
        this.lc.log(10000000, "AutomaticModeHandler.activateAutomaticMode()");
        this.getChoiceModel(1100139).setValue(1);
        if (bl2) {
            this.lc.log(10000000, "AutomaticModeHandler.activateAutomaticMode() [IC Update]");
            this.timeHandler.setTimeZoneAutomaticCheckBox(true);
        }
        this.timeHandler.deactivateTimeMenuEntry();
        if (bl) {
            this.timeHandler.setClockSource(3);
        }
        this.timeHandler.setClockDaylightSavingState(true);
        this.env.getNavigationListener().setClockSummerTimeData();
    }

    private ChoiceModelApp getChoiceModel(int n) {
        return this.env.getChoiceModel(n);
    }

    public boolean isAutomaticModeAvailible() {
        return this.automaticModeAvailible;
    }

    public boolean isAutomaticModeActive() {
        return this.automaticModeActive;
    }
}

