/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.tv.app.base.IConfiguration;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.settings.DisplaySettings$RangeListener;
import de.audi.tv.app.settings.SettingsStorage;

public class DisplaySettings {
    private volatile int currentSource = -1;
    private int cid = 26;
    private int brightness;
    private int color;
    private int contrast;
    private int tint;
    private final RangeModelApp brightnessModel;
    private final RangeModelApp colorModel;
    private final RangeModelApp contrastModel;
    static final int DEFAULT;
    private final int minSetting;
    private final int maxSetting;
    private final int stepWidth;
    private volatile boolean isInTerminalMode = false;
    private final TVEnv env;
    private final DSITV dsi;
    private final SettingsStorage storage;

    DisplaySettings(TVEnv tVEnv, DSITV dSITV, SettingsStorage settingsStorage) {
        this.env = tVEnv;
        this.dsi = dSITV;
        this.storage = settingsStorage;
        this.brightnessModel = tVEnv.getRangeModel(-1632884992);
        this.colorModel = tVEnv.getRangeModel(-1616107776);
        this.contrastModel = tVEnv.getRangeModel(-1599330560);
        IConfiguration iConfiguration = tVEnv.getConfiguration();
        this.minSetting = iConfiguration.getDisplaySettingMinValue();
        this.maxSetting = iConfiguration.getDisplaySettingMaxValue();
        this.stepWidth = iConfiguration.getDisplaySettingStepWidth();
        this.brightnessModel.setLimits(this.minSetting, this.maxSetting, this.stepWidth, 0);
        this.colorModel.setLimits(this.minSetting, this.maxSetting, this.stepWidth, 0);
        this.contrastModel.setLimits(this.minSetting, this.maxSetting, this.stepWidth, 0);
        DisplaySettings$RangeListener displaySettings$RangeListener = new DisplaySettings$RangeListener(this, null);
        this.brightnessModel.setRangeListener(displaySettings$RangeListener);
        this.colorModel.setRangeListener(displaySettings$RangeListener);
        this.contrastModel.setRangeListener(displaySettings$RangeListener);
    }

    private void saveSettings() {
        this.env.lcMain.log(-2137614336, "[DisplaySettings.saveSettings]");
        switch (this.currentSource) {
            case 0: {
                this.storage.saveTVBrightness(this.correctValueToStepWidth(this.brightness));
                this.storage.saveTVColor(this.correctValueToStepWidth(this.color));
                this.storage.saveTVContrast(this.correctValueToStepWidth(this.contrast));
                this.storage.saveTVTint(this.correctValueToStepWidth(this.tint));
                break;
            }
            case 1: {
                this.storage.saveAVBrightness(this.correctValueToStepWidth(this.brightness));
                this.storage.saveAVColor(this.correctValueToStepWidth(this.color));
                this.storage.saveAVContrast(this.correctValueToStepWidth(this.contrast));
                this.storage.saveAVTint(this.correctValueToStepWidth(this.tint));
                break;
            }
            default: {
                this.env.lcMain.log(-1601830656, "[DisplaySettings.saveSettings] source unknown: %1", (long)this.currentSource);
            }
        }
    }

    synchronized void resetSettings(int n) {
        this.env.lcMain.log(-2137614336, "[DisplaySettings.resetSettings] source %1", (long)this.currentSource);
        this.currentSource = n;
        this.brightness = 0;
        this.color = 0;
        this.contrast = 0;
        this.tint = 0;
        this.setBrightness(this.brightness);
        this.setColor(this.color);
        this.setContrast(this.contrast);
        this.saveSettings();
    }

    private void restoreSettings() {
        this.env.lcMain.log(-2137614336, "[DisplaySettings.restoreSettings] source %1", (long)this.currentSource);
        switch (this.currentSource) {
            case 0: {
                this.brightness = this.correctValueToStepWidth(this.storage.loadTVBrightness());
                this.color = this.correctValueToStepWidth(this.storage.loadTVColor());
                this.contrast = this.correctValueToStepWidth(this.storage.loadTVContrast());
                this.tint = this.correctValueToStepWidth(this.storage.loadTVTint());
                break;
            }
            case 1: {
                this.brightness = this.correctValueToStepWidth(this.storage.loadAVBrightness());
                this.color = this.correctValueToStepWidth(this.storage.loadAVColor());
                this.contrast = this.correctValueToStepWidth(this.storage.loadAVContrast());
                this.tint = this.correctValueToStepWidth(this.storage.loadAVTint());
                break;
            }
            default: {
                this.env.lcMain.log(-1601830656, "[DisplaySettings.restoreSettings] source unknown: %1", (long)this.currentSource);
            }
        }
        this.setBrightness(this.brightness);
        this.setColor(this.color);
        this.setContrast(this.contrast);
        this.brightnessModel.setValue(this.brightness);
        this.colorModel.setValue(this.color);
        this.contrastModel.setValue(this.contrast);
    }

    private int correctValueToStepWidth(int n) {
        return n / this.stepWidth * this.stepWidth;
    }

    private void setBrightness(int n) {
        int n2 = (n + this.maxSetting) * 100 / (2 * this.maxSetting);
        this.env.getChoiceModel(-743692544).setValue(n2);
        this.dsi.setBrightness(this.cid, n);
    }

    private void setColor(int n) {
        int n2 = (n + this.maxSetting) * 100 / (2 * this.maxSetting);
        this.env.getChoiceModel(-726915328).setValue(n2);
        this.dsi.setColor(this.cid, n);
    }

    private void setContrast(int n) {
        int n2 = (n + this.maxSetting) * 100 / (2 * this.maxSetting);
        this.env.getChoiceModel(-710138112).setValue(n2);
        this.dsi.setContrast(this.cid, n);
    }

    public synchronized void enterTerminalMode() {
        this.saveSettings();
        this.cid = 31;
        this.setBrightness(0);
        this.setColor(0);
        this.setContrast(0);
        this.isInTerminalMode = true;
    }

    public synchronized void enterSelectedTvAvMode() {
        this.isInTerminalMode = false;
        this.cid = 26;
        this.restoreSettings();
    }

    void setSelectedSource(int n) {
        if (this.currentSource != -1) {
            this.saveSettings();
        }
        this.currentSource = n;
        this.restoreSettings();
    }

    void onPowerStateStandby() {
        if (this.isInTerminalMode) {
            this.enterSelectedTvAvMode();
        }
    }

    static /* synthetic */ RangeModelApp access$100(DisplaySettings displaySettings) {
        return displaySettings.brightnessModel;
    }

    static /* synthetic */ RangeModelApp access$200(DisplaySettings displaySettings) {
        return displaySettings.colorModel;
    }

    static /* synthetic */ RangeModelApp access$300(DisplaySettings displaySettings) {
        return displaySettings.contrastModel;
    }

    static /* synthetic */ int access$400(DisplaySettings displaySettings) {
        return displaySettings.brightness;
    }

    static /* synthetic */ int access$500(DisplaySettings displaySettings, int n) {
        return displaySettings.correctValueToStepWidth(n);
    }

    static /* synthetic */ int access$600(DisplaySettings displaySettings) {
        return displaySettings.minSetting;
    }

    static /* synthetic */ int access$402(DisplaySettings displaySettings, int n) {
        displaySettings.brightness = n;
        return displaySettings.brightness;
    }

    static /* synthetic */ void access$700(DisplaySettings displaySettings, int n) {
        displaySettings.setBrightness(n);
    }

    static /* synthetic */ int access$800(DisplaySettings displaySettings) {
        return displaySettings.color;
    }

    static /* synthetic */ int access$802(DisplaySettings displaySettings, int n) {
        displaySettings.color = n;
        return displaySettings.color;
    }

    static /* synthetic */ void access$900(DisplaySettings displaySettings, int n) {
        displaySettings.setColor(n);
    }

    static /* synthetic */ int access$1000(DisplaySettings displaySettings) {
        return displaySettings.contrast;
    }

    static /* synthetic */ int access$1002(DisplaySettings displaySettings, int n) {
        displaySettings.contrast = n;
        return displaySettings.contrast;
    }

    static /* synthetic */ void access$1100(DisplaySettings displaySettings, int n) {
        displaySettings.setContrast(n);
    }

    static /* synthetic */ void access$1200(DisplaySettings displaySettings) {
        displaySettings.saveSettings();
    }
}

