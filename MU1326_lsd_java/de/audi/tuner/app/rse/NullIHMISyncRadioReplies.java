/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.IRadioInterappListener;
import org.dsi.ifc.radio.WavebandInfo;

class NullIHMISyncRadioReplies
extends NullService
implements IRadioInterappListener {
    protected NullIHMISyncRadioReplies(LogChannel logChannel) {
        super(logChannel, "NullIHMISyncRadioReplies");
    }

    public void updateBandList(int[] nArray) {
        this.log();
    }

    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.log();
    }

    public void updateActiveBand(int n) {
        this.log();
    }

    public void updateActiveStation(IRadioInterappListener.RadioStation radioStation) {
        this.log();
    }

    public void updateRadioStationList(IRadioInterappListener.RadioStation[] radioStationArray) {
        this.log();
    }

    public void updateActiveStationInfo(String[] stringArray) {
        this.log();
    }

    public void updateSlideshowInfo(String string) {
        this.log();
    }

    public void enforceRadio() {
        this.log();
    }
}

