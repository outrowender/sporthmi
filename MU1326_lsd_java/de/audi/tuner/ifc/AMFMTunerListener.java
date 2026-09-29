/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.ifc.CmdDefaultListener;
import org.dsi.ifc.radio.AMFMRadioText;
import org.dsi.ifc.radio.HdStationInfo;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radio.WavebandInfo;

public interface AMFMTunerListener
extends CmdDefaultListener {
    default public void updateStationList(Station[] stationArray) {
    }

    default public void updateStationListMW(Station[] stationArray) {
    }

    default public void updateStationListLW(Station[] stationArray) {
    }

    default public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
    }

    default public void updateRadioText(AMFMRadioText aMFMRadioText) {
    }

    default public void updateAFSwitchStatus(boolean bl) {
    }

    default public void updateREGSwitchStatus(int n) {
    }

    default public void updateLinkingUsageStatus(int n) {
    }

    default public void updateDetectedDevice(int n) {
    }

    default public void tuneFrequencyStepsStatus(int n) {
    }

    default public void selectStationStatus(int n) {
    }

    default public void seekStationStatus(int n) {
    }

    default public void updateRadioTextPlus(int[] nArray, String[] stringArray) {
    }

    default public void updateSelectedStation(Station station) {
    }

    default public void updateSelectedStationHD(Station station, int n) {
    }

    default public void prepareTuningStatus(int n) {
    }

    default public void selectFrequencyStatus(int n) {
    }

    default public void setAMBandRangeStatus(int n) {
    }

    default public void forceFMUpdateStatus(int n) {
    }

    default public void updatePiIgnoreSwitchStatus(boolean bl) {
    }

    default public void forceAMUpdateStatus(int n) {
    }

    default public void updateRDSIgnoreSwitchStatus(boolean bl) {
    }

    default public void updateMESwitchStatus(boolean bl) {
    }

    default public void updateHdStatus(int n) {
    }

    default public void updateHdMode(int n) {
    }

    default public void updateHdStationInfo(HdStationInfo hdStationInfo) {
    }

    default public void updateAvailability(int n) {
    }

    default public void updateElectronicSerialCode(String string) {
    }
}

