/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.ifc.UnifiedTunerListener;
import org.dsi.ifc.radio.DABSlideShowInfo;
import org.dsi.ifc.radio.UnifiedRadioText;
import org.dsi.ifc.radio.UnifiedRadioTextPlus;
import org.dsi.ifc.radio.UnifiedStation;

public abstract class AbstractUnifiedCmd
extends AbstractRadioCmd
implements UnifiedTunerListener {
    private final UnifiedTunerListener defaultUnifiedListener;
    protected final IUnifiedTuner unifiedTuner;

    public AbstractUnifiedCmd(Builder builder) {
        super(builder.framework, builder.lc, 8);
        this.defaultUnifiedListener = builder.defaultUnifiedListener;
        this.unifiedTuner = builder.unifiedTuner;
    }

    public void selectStationStatus(int n) {
        this.defaultUnifiedListener.selectStationStatus(n);
    }

    public void updateAudioStatus(int n) {
        this.defaultUnifiedListener.updateAudioStatus(n);
    }

    public void updateDetectedDevice(int n) {
        this.defaultUnifiedListener.updateDetectedDevice(n);
    }

    public void updateSelectedStation(UnifiedStation unifiedStation) {
        this.defaultUnifiedListener.updateSelectedStation(unifiedStation);
    }

    public void updateStationList(UnifiedStation[] unifiedStationArray) {
        this.defaultUnifiedListener.updateStationList(unifiedStationArray);
    }

    public void updateRadioText(UnifiedRadioText unifiedRadioText) {
        this.defaultUnifiedListener.updateEnhancedRadioText(unifiedRadioText);
    }

    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText) {
        this.defaultUnifiedListener.updateEnhancedRadioText(unifiedRadioText);
    }

    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.defaultUnifiedListener.updateRadioTextPlus(unifiedRadioTextPlus);
    }

    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.defaultUnifiedListener.updateEnhancedRadioTextPlus(unifiedRadioTextPlus);
    }

    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.defaultUnifiedListener.updateSlideShowInfo(dABSlideShowInfo);
    }

    public void listMode(int n) {
        this.defaultUnifiedListener.listMode(n);
    }

    public void stationFollowingMode(int n) {
        this.defaultUnifiedListener.stationFollowingMode(n);
    }

    public void updateSoftLinkSwitchStatus(int n) {
        this.defaultUnifiedListener.updateSoftLinkSwitchStatus(n);
    }

    public void updateDeviceUsageStatus(int n) {
        this.defaultUnifiedListener.updateDeviceUsageStatus(n);
    }

    public void updateRegModeStatus(int n) {
        this.defaultUnifiedListener.updateRegModeStatus(n);
    }

    public static class Builder {
        private final LogChannel lc;
        private final IUnifiedTuner unifiedTuner;
        private final UnifiedTunerListener defaultUnifiedListener;
        private final IFrameworkAccess framework;

        public Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IUnifiedTuner iUnifiedTuner, UnifiedTunerListener unifiedTunerListener) {
            this.framework = iFrameworkAccess;
            this.lc = logChannel;
            this.unifiedTuner = iUnifiedTuner;
            this.defaultUnifiedListener = unifiedTunerListener;
        }
    }
}

