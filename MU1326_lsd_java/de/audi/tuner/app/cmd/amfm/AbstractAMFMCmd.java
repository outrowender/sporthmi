/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.ifc.AMFMTunerListener;
import de.audi.tuner.ifc.IAMFMTuner;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public abstract class AbstractAMFMCmd
extends AbstractRadioCmd
implements AMFMTunerListener {
    private final AMFMTunerListener defaultListener;
    protected final IAMFMTuner tuner;

    protected AbstractAMFMCmd(Builder builder) {
        super(builder.framework, builder.lc, 1);
        this.defaultListener = builder.defaultListener;
        this.tuner = builder.tuner;
    }

    public void updateLinkingUsageStatus(int n) {
        this.defaultListener.updateLinkingUsageStatus(n);
    }

    public void selectStationStatus(int n) {
        this.defaultListener.selectStationStatus(n);
    }

    public final void updateSelectedStation(Station station) {
        this.defaultListener.updateSelectedStation(station);
    }

    public final void updateStationList(Station[] stationArray) {
        this.defaultListener.updateStationList(stationArray);
    }

    public final void updateStationListMW(Station[] stationArray) {
        this.defaultListener.updateStationListMW(stationArray);
    }

    public final void updateStationListLW(Station[] stationArray) {
        this.defaultListener.updateStationListLW(stationArray);
    }

    public final void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.defaultListener.updateWavebandInfoList(wavebandInfoArray);
    }

    public final void updateRadioText(AMFMRadioText aMFMRadioText) {
        this.defaultListener.updateRadioText(aMFMRadioText);
    }

    public final void updateAFSwitchStatus(boolean bl) {
        this.defaultListener.updateAFSwitchStatus(bl);
    }

    public final void updateREGSwitchStatus(int n) {
        this.defaultListener.updateREGSwitchStatus(n);
    }

    public void updateDetectedDevice(int n) {
        this.defaultListener.updateDetectedDevice(n);
    }

    public final void tuneFrequencyStepsStatus(int n) {
        this.defaultListener.tuneFrequencyStepsStatus(n);
    }

    public void seekStationStatus(int n) {
        this.defaultListener.seekStationStatus(n);
    }

    public final void updateRadioTextPlus(int[] nArray, String[] stringArray) {
        this.defaultListener.updateRadioTextPlus(nArray, stringArray);
    }

    public final void prepareTuningStatus(int n) {
        this.defaultListener.prepareTuningStatus(n);
    }

    public final void selectFrequencyStatus(int n) {
        this.defaultListener.selectFrequencyStatus(n);
    }

    public final void setAMBandRangeStatus(int n) {
        this.defaultListener.setAMBandRangeStatus(n);
    }

    public final void forceFMUpdateStatus(int n) {
        this.defaultListener.forceFMUpdateStatus(n);
    }

    public final void updatePiIgnoreSwitchStatus(boolean bl) {
        this.defaultListener.updatePiIgnoreSwitchStatus(bl);
    }

    public void forceAMUpdateStatus(int n) {
        this.defaultListener.forceAMUpdateStatus(n);
    }

    public final void updateRDSIgnoreSwitchStatus(boolean bl) {
        this.defaultListener.updateRDSIgnoreSwitchStatus(bl);
    }

    public final void updateMESwitchStatus(boolean bl) {
        this.defaultListener.updateMESwitchStatus(bl);
    }

    public final void updateHdStatus(int n) {
        this.defaultListener.updateHdStatus(n);
    }

    public final void updateHdMode(int n) {
        this.defaultListener.updateHdMode(n);
    }

    public final void updateHdStationInfo(HdStationInfo hdStationInfo) {
        this.defaultListener.updateHdStationInfo(hdStationInfo);
    }

    public void updateAvailability(int n) {
        this.defaultListener.updateAvailability(n);
    }

    public final void updateElectronicSerialCode(String string) {
        this.defaultListener.updateElectronicSerialCode(string);
    }

    public void updateSelectedStationHD(Station station, int n) {
        this.defaultListener.updateSelectedStationHD(station, n);
    }

    public static class Builder {
        private final LogChannel lc;
        private final IAMFMTuner tuner;
        private final AMFMTunerListener defaultListener;
        private final IFrameworkAccess framework;

        public Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, IAMFMTuner iAMFMTuner, AMFMTunerListener aMFMTunerListener) {
            this.framework = iFrameworkAccess;
            this.lc = logChannel;
            this.tuner = iAMFMTuner;
            this.defaultListener = aMFMTunerListener;
        }
    }
}

