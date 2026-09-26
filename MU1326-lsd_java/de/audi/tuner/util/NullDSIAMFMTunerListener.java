/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public class NullDSIAMFMTunerListener
extends NullService
implements DSIAMFMTunerListener {
    public NullDSIAMFMTunerListener(LogChannel logChannel) {
        super(logChannel, "DSIAMFMTunerListener");
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log();
    }

    @Override
    public void updateStationList(Station[] stationArray, int n) {
        this.log();
    }

    @Override
    public void updateStationListMW(Station[] stationArray, int n) {
        this.log();
    }

    @Override
    public void updateStationListLW(Station[] stationArray, int n) {
        this.log();
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
        this.log();
    }

    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
        this.log();
    }

    @Override
    public void updateAFSwitchStatus(boolean bl, int n) {
        this.log();
    }

    @Override
    public void updateREGSwitchStatus(int n, int n2) {
        this.log();
    }

    @Override
    public void updateLinkingUsageStatus(int n, int n2) {
        this.log();
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
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
    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        this.log();
    }

    @Override
    public void updateSelectedStation(Station station, int n) {
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
    public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
        this.log();
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        this.log();
    }

    @Override
    public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
        this.log();
    }

    @Override
    public void updateMESwitchStatus(boolean bl, int n) {
        this.log();
    }

    @Override
    public void updateHdStatus(int n, int n2) {
        this.log();
    }

    @Override
    public void updateHdMode(int n, int n2) {
        this.log();
    }

    @Override
    public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        this.log();
    }

    @Override
    public void updateAvailability(int n, int n2) {
        this.log();
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
        this.log();
    }

    @Override
    public void updateSelectedStationHD(Station station, int n, int n2) {
        this.log();
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void profileChanged(int n, int n2) {
        this.log();
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void profileReset(int n, int n2) {
        this.log();
    }

    @Override
    public void profileResetAll(int n) {
        this.log();
    }
}

