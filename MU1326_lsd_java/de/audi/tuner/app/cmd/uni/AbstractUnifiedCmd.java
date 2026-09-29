/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.uni.AbstractUnifiedCmd$Builder;
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

    public AbstractUnifiedCmd(AbstractUnifiedCmd$Builder abstractUnifiedCmd$Builder) {
        super(AbstractUnifiedCmd$Builder.access$000(abstractUnifiedCmd$Builder), AbstractUnifiedCmd$Builder.access$100(abstractUnifiedCmd$Builder), 8);
        this.defaultUnifiedListener = AbstractUnifiedCmd$Builder.access$200(abstractUnifiedCmd$Builder);
        this.unifiedTuner = AbstractUnifiedCmd$Builder.access$300(abstractUnifiedCmd$Builder);
    }

    @Override
    public void selectStationStatus(int n) {
        this.defaultUnifiedListener.selectStationStatus(n);
    }

    @Override
    public void updateAudioStatus(int n) {
        this.defaultUnifiedListener.updateAudioStatus(n);
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.defaultUnifiedListener.updateDetectedDevice(n);
    }

    @Override
    public void updateSelectedStation(UnifiedStation unifiedStation) {
        this.defaultUnifiedListener.updateSelectedStation(unifiedStation);
    }

    @Override
    public void updateStationList(UnifiedStation[] unifiedStationArray) {
        this.defaultUnifiedListener.updateStationList(unifiedStationArray);
    }

    @Override
    public void updateRadioText(UnifiedRadioText unifiedRadioText) {
        this.defaultUnifiedListener.updateEnhancedRadioText(unifiedRadioText);
    }

    @Override
    public void updateEnhancedRadioText(UnifiedRadioText unifiedRadioText) {
        this.defaultUnifiedListener.updateEnhancedRadioText(unifiedRadioText);
    }

    @Override
    public void updateRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.defaultUnifiedListener.updateRadioTextPlus(unifiedRadioTextPlus);
    }

    @Override
    public void updateEnhancedRadioTextPlus(UnifiedRadioTextPlus unifiedRadioTextPlus) {
        this.defaultUnifiedListener.updateEnhancedRadioTextPlus(unifiedRadioTextPlus);
    }

    @Override
    public void updateSlideShowInfo(DABSlideShowInfo dABSlideShowInfo) {
        this.defaultUnifiedListener.updateSlideShowInfo(dABSlideShowInfo);
    }

    @Override
    public void listMode(int n) {
        this.defaultUnifiedListener.listMode(n);
    }

    @Override
    public void stationFollowingMode(int n) {
        this.defaultUnifiedListener.stationFollowingMode(n);
    }

    @Override
    public void updateSoftLinkSwitchStatus(int n) {
        this.defaultUnifiedListener.updateSoftLinkSwitchStatus(n);
    }

    @Override
    public void updateDeviceUsageStatus(int n) {
        this.defaultUnifiedListener.updateDeviceUsageStatus(n);
    }

    @Override
    public void updateRegModeStatus(int n) {
        this.defaultUnifiedListener.updateRegModeStatus(n);
    }
}

