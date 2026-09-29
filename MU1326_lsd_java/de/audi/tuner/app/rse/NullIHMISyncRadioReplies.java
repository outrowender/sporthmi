/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.IRadioInterappListener;
import de.audi.tuner.ifc.IRadioInterappListener$RadioStation;
import org.dsi.ifc.radio.WavebandInfo;

class NullIHMISyncRadioReplies
extends NullService
implements IRadioInterappListener {
    protected NullIHMISyncRadioReplies(LogChannel logChannel) {
        super(logChannel, "NullIHMISyncRadioReplies");
    }

    @Override
    public void updateBandList(int[] nArray) {
        this.log();
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.log();
    }

    @Override
    public void updateActiveBand(int n) {
        this.log();
    }

    @Override
    public void updateActiveStation(IRadioInterappListener$RadioStation iRadioInterappListener$RadioStation) {
        this.log();
    }

    @Override
    public void updateRadioStationList(IRadioInterappListener$RadioStation[] iRadioInterappListener$RadioStationArray) {
        this.log();
    }

    public void updateActiveStationInfo(String[] stringArray) {
        this.log();
    }

    public void updateSlideshowInfo(String string) {
        this.log();
    }

    @Override
    public void enforceRadio() {
        this.log();
    }
}

