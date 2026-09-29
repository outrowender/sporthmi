/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import org.dsi.ifc.radio.DABRadioText;
import org.dsi.ifc.radio.EPGFullInfo;
import org.dsi.ifc.radio.FrequencyInfo;

public class DABDsiUpInfo
extends RadioInfo {
    public void listUpdate(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
    }

    public void setEPGList(EPGShortInfoExt[] ePGShortInfoExtArray) {
    }

    public void setEPGDetailData(EPGFullInfo ePGFullInfo) {
    }

    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
    }

    public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
    }

    public void updateRadioText(DABRadioText dABRadioText) {
    }

    public void updateRadioTextPlusInfo(RadioTextPlusStorage radioTextPlusStorage) {
    }

    public void updateQuality(short s) {
    }

    public void updateLinkingSwitchStatus(int n) {
    }

    public void updateFrequencyTableSwitchStatus(int n) {
    }

    public void updateDetectedDevice(int n) {
    }

    public void selectServiceStatus(int n) {
    }

    public void seekServiceStatus(boolean bl) {
    }

    public void forceLMUpdateStatus(int n) {
    }

    public void updateAvailability(int n) {
    }

    public void ensembleSeekIsRunning(String string) {
    }

    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
    }

    public void updateReceptionStatus(DabReceptionStatus dabReceptionStatus) {
    }
}

