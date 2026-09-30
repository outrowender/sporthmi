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

    public void asyncException(int n, String string, int n2) {
        this.log();
    }

    public void updateStationList(Station[] stationArray, int n) {
        this.log();
    }

    public void updateStationListMW(Station[] stationArray, int n) {
        this.log();
    }

    public void updateStationListLW(Station[] stationArray, int n) {
        this.log();
    }

    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray, int n) {
        this.log();
    }

    public void updateRadioText(AMFMRadioText aMFMRadioText, int n) {
        this.log();
    }

    public void updateAFSwitchStatus(boolean bl, int n) {
        this.log();
    }

    public void updateREGSwitchStatus(int n, int n2) {
        this.log();
    }

    public void updateLinkingUsageStatus(int n, int n2) {
        this.log();
    }

    public void updateDetectedDevice(int n, int n2) {
        this.log();
    }

    public void tuneFrequencyStepsStatus(int n) {
        this.log();
    }

    public void selectStationStatus(int n) {
        this.log();
    }

    public void seekStationStatus(int n) {
        this.log();
    }

    public void updateRadioTextPlus(int[] nArray, String[] stringArray, int n) {
        this.log();
    }

    public void updateSelectedStation(Station station, int n) {
        this.log();
    }

    public void prepareTuningStatus(int n) {
        this.log();
    }

    public void selectFrequencyStatus(int n) {
        this.log();
    }

    public void setAMBandRangeStatus(int n) {
        this.log();
    }

    public void forceFMUpdateStatus(int n) {
        this.log();
    }

    public void updatePiIgnoreSwitchStatus(boolean bl, int n) {
        this.log();
    }

    public void forceAMUpdateStatus(int n) {
        this.log();
    }

    public void updateRDSIgnoreSwitchStatus(boolean bl, int n) {
        this.log();
    }

    public void updateMESwitchStatus(boolean bl, int n) {
        this.log();
    }

    public void updateHdStatus(int n, int n2) {
        this.log();
    }

    public void updateHdMode(int n, int n2) {
        this.log();
    }

    public void updateHdStationInfo(HdStationInfo hdStationInfo, int n) {
        this.log();
    }

    public void updateAvailability(int n, int n2) {
        this.log();
    }

    public void updateElectronicSerialCode(String string, int n) {
        this.log();
    }

    public void updateSelectedStationHD(Station station, int n, int n2) {
        this.log();
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.log();
    }

    public void profileChanged(int n, int n2) {
        this.log();
    }

    public void profileCopied(int n, int n2, int n3) {
        this.log();
    }

    public void profileReset(int n, int n2) {
        this.log();
    }

    public void profileResetAll(int n) {
        this.log();
    }
}

