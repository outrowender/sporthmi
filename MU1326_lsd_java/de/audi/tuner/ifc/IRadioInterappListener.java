/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.ifc.IRadioInterappListener$RadioStation;
import org.dsi.ifc.radio.WavebandInfo;

public interface IRadioInterappListener {
    public static final int AUDIOSTATUS_ANALOG;
    public static final int AUDIOSTATUS_DIGITAL;
    public static final int AUDIOSTATUS_MUTE;
    public static final int AUDIOSTATUS_BALLGAME;

    default public void updateBandList(int[] nArray) {
    }

    default public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
    }

    default public void updateActiveBand(int n) {
    }

    default public void updateRadioStationList(IRadioInterappListener$RadioStation[] iRadioInterappListener$RadioStationArray) {
    }

    default public void updateActiveStation(IRadioInterappListener$RadioStation iRadioInterappListener$RadioStation) {
    }

    default public void enforceRadio() {
    }
}

