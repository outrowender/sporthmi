/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.settings;

import de.audi.atip.hmi.model.DefaultRangeListener;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.tv.app.base.IConfiguration;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
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
    static final int DEFAULT = 0;
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
        this.brightnessModel = tVEnv.getRangeModel(2600094);
        this.colorModel = tVEnv.getRangeModel(2600095);
        this.contrastModel = tVEnv.getRangeModel(2600096);
        IConfiguration iConfiguration = tVEnv.getConfiguration();
        this.minSetting = iConfiguration.getDisplaySettingMinValue();
        this.maxSetting = iConfiguration.getDisplaySettingMaxValue();
        this.stepWidth = iConfiguration.getDisplaySettingStepWidth();
        this.brightnessModel.setLimits(this.minSetting, this.maxSetting, this.stepWidth, 0);
        this.colorModel.setLimits(this.minSetting, this.maxSetting, this.stepWidth, 0);
        this.contrastModel.setLimits(this.minSetting, this.maxSetting, this.stepWidth, 0);
        RangeListener rangeListener2 = new RangeListener();
        this.brightnessModel.setRangeListener(rangeListener2);
        this.colorModel.setRangeListener(rangeListener2);
        this.contrastModel.setRangeListener(rangeListener2);
    }

    private void saveSettings() {
        this.env.lcMain.log(10000000, "[DisplaySettings.saveSettings]");
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
                this.env.lcMain.log(100000, "[DisplaySettings.saveSettings] source unknown: %1", (long)this.currentSource);
            }
        }
    }

    synchronized void resetSettings(int n) {
        this.env.lcMain.log(10000000, "[DisplaySettings.resetSettings] source %1", (long)this.currentSource);
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
        this.env.lcMain.log(10000000, "[DisplaySettings.restoreSettings] source %1", (long)this.currentSource);
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
                this.env.lcMain.log(100000, "[DisplaySettings.restoreSettings] source unknown: %1", (long)this.currentSource);
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
        this.env.getChoiceModel(2600147).setValue(n2);
        this.dsi.setBrightness(this.cid, n);
    }

    private void setColor(int n) {
        int n2 = (n + this.maxSetting) * 100 / (2 * this.maxSetting);
        this.env.getChoiceModel(2600148).setValue(n2);
        this.dsi.setColor(this.cid, n);
    }

    private void setContrast(int n) {
        int n2 = (n + this.maxSetting) * 100 / (2 * this.maxSetting);
        this.env.getChoiceModel(2600149).setValue(n2);
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

    private class RangeListener
    extends DefaultRangeListener {
        private RangeListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            switch (n) {
                case 2600094: {
                    DisplaySettings.this.brightnessModel.fireEvent(n3);
                    break;
                }
                case 2600095: {
                    DisplaySettings.this.colorModel.fireEvent(n3);
                    break;
                }
                case 2600096: {
                    DisplaySettings.this.contrastModel.fireEvent(n3);
                    break;
                }
            }
        }

        public void decrement(int n, int n2, int n3) {
            switch (n) {
                case 2600094: {
                    int n4 = DisplaySettings.this.correctValueToStepWidth(DisplaySettings.this.brightness - n2);
                    if (n4 < DisplaySettings.this.minSetting) break;
                    DisplaySettings.this.brightness = n4;
                    DisplaySettings.this.setBrightness(DisplaySettings.this.brightness);
                    DisplaySettings.this.brightnessModel.setValue(DisplaySettings.this.brightness);
                    break;
                }
                case 2600095: {
                    int n5 = DisplaySettings.this.correctValueToStepWidth(DisplaySettings.this.color - n2);
                    if (n5 < DisplaySettings.this.minSetting) break;
                    DisplaySettings.this.color = n5;
                    DisplaySettings.this.setColor(DisplaySettings.this.color);
                    DisplaySettings.this.colorModel.setValue(DisplaySettings.this.color);
                    break;
                }
                case 2600096: {
                    int n6 = DisplaySettings.this.correctValueToStepWidth(DisplaySettings.this.contrast - n2);
                    if (n6 < DisplaySettings.this.minSetting) break;
                    DisplaySettings.this.contrast = n6;
                    DisplaySettings.this.setContrast(DisplaySettings.this.contrast);
                    DisplaySettings.this.contrastModel.setValue(DisplaySettings.this.contrast);
                    break;
                }
            }
            DisplaySettings.this.saveSettings();
        }

        public void increment(int n, int n2, int n3) {
            switch (n) {
                case 2600094: {
                    DisplaySettings.this.brightness = DisplaySettings.this.correctValueToStepWidth(DisplaySettings.this.brightness + n2);
                    DisplaySettings.this.setBrightness(DisplaySettings.this.brightness);
                    DisplaySettings.this.brightnessModel.setValue(DisplaySettings.this.brightness);
                    break;
                }
                case 2600095: {
                    DisplaySettings.this.color = DisplaySettings.this.correctValueToStepWidth(DisplaySettings.this.color + n2);
                    DisplaySettings.this.setColor(DisplaySettings.this.color);
                    DisplaySettings.this.colorModel.setValue(DisplaySettings.this.color);
                    break;
                }
                case 2600096: {
                    DisplaySettings.this.contrast = DisplaySettings.this.correctValueToStepWidth(DisplaySettings.this.contrast + n2);
                    DisplaySettings.this.setContrast(DisplaySettings.this.contrast);
                    DisplaySettings.this.contrastModel.setValue(DisplaySettings.this.contrast);
                    break;
                }
            }
            DisplaySettings.this.saveSettings();
        }
    }
}

