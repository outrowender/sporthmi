/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.amfm;

import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.amfm.AbstractAMFMCmd$Builder;
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

    protected AbstractAMFMCmd(AbstractAMFMCmd$Builder abstractAMFMCmd$Builder) {
        super(AbstractAMFMCmd$Builder.access$000(abstractAMFMCmd$Builder), AbstractAMFMCmd$Builder.access$100(abstractAMFMCmd$Builder), 1);
        this.defaultListener = AbstractAMFMCmd$Builder.access$200(abstractAMFMCmd$Builder);
        this.tuner = AbstractAMFMCmd$Builder.access$300(abstractAMFMCmd$Builder);
    }

    @Override
    public void updateLinkingUsageStatus(int n) {
        this.defaultListener.updateLinkingUsageStatus(n);
    }

    @Override
    public void selectStationStatus(int n) {
        this.defaultListener.selectStationStatus(n);
    }

    @Override
    public final void updateSelectedStation(Station station) {
        this.defaultListener.updateSelectedStation(station);
    }

    @Override
    public final void updateStationList(Station[] stationArray) {
        this.defaultListener.updateStationList(stationArray);
    }

    @Override
    public final void updateStationListMW(Station[] stationArray) {
        this.defaultListener.updateStationListMW(stationArray);
    }

    @Override
    public final void updateStationListLW(Station[] stationArray) {
        this.defaultListener.updateStationListLW(stationArray);
    }

    @Override
    public final void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.defaultListener.updateWavebandInfoList(wavebandInfoArray);
    }

    @Override
    public final void updateRadioText(AMFMRadioText aMFMRadioText) {
        this.defaultListener.updateRadioText(aMFMRadioText);
    }

    @Override
    public final void updateAFSwitchStatus(boolean bl) {
        this.defaultListener.updateAFSwitchStatus(bl);
    }

    @Override
    public final void updateREGSwitchStatus(int n) {
        this.defaultListener.updateREGSwitchStatus(n);
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.defaultListener.updateDetectedDevice(n);
    }

    @Override
    public final void tuneFrequencyStepsStatus(int n) {
        this.defaultListener.tuneFrequencyStepsStatus(n);
    }

    @Override
    public void seekStationStatus(int n) {
        this.defaultListener.seekStationStatus(n);
    }

    @Override
    public final void updateRadioTextPlus(int[] nArray, String[] stringArray) {
        this.defaultListener.updateRadioTextPlus(nArray, stringArray);
    }

    @Override
    public final void prepareTuningStatus(int n) {
        this.defaultListener.prepareTuningStatus(n);
    }

    @Override
    public final void selectFrequencyStatus(int n) {
        this.defaultListener.selectFrequencyStatus(n);
    }

    @Override
    public final void setAMBandRangeStatus(int n) {
        this.defaultListener.setAMBandRangeStatus(n);
    }

    @Override
    public final void forceFMUpdateStatus(int n) {
        this.defaultListener.forceFMUpdateStatus(n);
    }

    @Override
    public final void updatePiIgnoreSwitchStatus(boolean bl) {
        this.defaultListener.updatePiIgnoreSwitchStatus(bl);
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        this.defaultListener.forceAMUpdateStatus(n);
    }

    @Override
    public final void updateRDSIgnoreSwitchStatus(boolean bl) {
        this.defaultListener.updateRDSIgnoreSwitchStatus(bl);
    }

    @Override
    public final void updateMESwitchStatus(boolean bl) {
        this.defaultListener.updateMESwitchStatus(bl);
    }

    @Override
    public final void updateHdStatus(int n) {
        this.defaultListener.updateHdStatus(n);
    }

    @Override
    public final void updateHdMode(int n) {
        this.defaultListener.updateHdMode(n);
    }

    @Override
    public final void updateHdStationInfo(HdStationInfo hdStationInfo) {
        this.defaultListener.updateHdStationInfo(hdStationInfo);
    }

    @Override
    public void updateAvailability(int n) {
        this.defaultListener.updateAvailability(n);
    }

    @Override
    public final void updateElectronicSerialCode(String string) {
        this.defaultListener.updateElectronicSerialCode(string);
    }

    @Override
    public void updateSelectedStationHD(Station station, int n) {
        this.defaultListener.updateSelectedStationHD(station, n);
    }
}

