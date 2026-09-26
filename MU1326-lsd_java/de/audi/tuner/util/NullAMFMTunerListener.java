/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.AMFMTunerListener;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public class NullAMFMTunerListener
extends NullService
implements AMFMTunerListener {
    public NullAMFMTunerListener(LogChannel logChannel) {
        super(logChannel, "AMFMTunerListener");
    }

    protected NullAMFMTunerListener(LogChannel logChannel, String string) {
        super(logChannel, string);
    }

    public void asyncException(int n, String string, int n2) {
        this.log();
    }

    @Override
    public void updateStationList(Station[] stationArray) {
        this.log();
    }

    @Override
    public void updateStationListMW(Station[] stationArray) {
        this.log();
    }

    @Override
    public void updateStationListLW(Station[] stationArray) {
        this.log();
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.log();
    }

    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText) {
        this.log();
    }

    @Override
    public void updateAFSwitchStatus(boolean bl) {
        this.log();
    }

    @Override
    public void updateREGSwitchStatus(int n) {
        this.log();
    }

    @Override
    public void updateLinkingUsageStatus(int n) {
        this.log();
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.log();
    }

    @Override
    public void tuneFrequencyStepsStatus(int n) {
        this.log();
    }

    @Override
    public void selectStationStatus(int n) {
        this.log();
    }

    @Override
    public void seekStationStatus(int n) {
        this.log();
    }

    @Override
    public void updateRadioTextPlus(int[] nArray, String[] stringArray) {
        this.log();
    }

    @Override
    public void updateSelectedStation(Station station) {
        this.log();
    }

    @Override
    public void prepareTuningStatus(int n) {
        this.log();
    }

    @Override
    public void selectFrequencyStatus(int n) {
        this.log();
    }

    @Override
    public void setAMBandRangeStatus(int n) {
        this.log();
    }

    @Override
    public void forceFMUpdateStatus(int n) {
        this.log();
    }

    @Override
    public void updatePiIgnoreSwitchStatus(boolean bl) {
        this.log();
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        this.log();
    }

    @Override
    public void updateRDSIgnoreSwitchStatus(boolean bl) {
        this.log();
    }

    @Override
    public void updateMESwitchStatus(boolean bl) {
        this.log();
    }

    @Override
    public void updateHdStatus(int n) {
        this.log();
    }

    @Override
    public void updateHdMode(int n) {
        this.log();
    }

    @Override
    public void updateHdStationInfo(HdStationInfo hdStationInfo) {
        this.log();
    }

    @Override
    public void updateAvailability(int n) {
        this.log();
    }

    @Override
    public void updateElectronicSerialCode(String string) {
        this.log();
    }

    @Override
    public void updateSelectedStationHD(Station station, int n) {
        this.log();
    }
}

