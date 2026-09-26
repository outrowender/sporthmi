/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.AMFMTuner$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import org.dsi.ifc.radio.WavebandInfo;

class AMFMTuner$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ AMFMTuner this$0;

    private AMFMTuner$DsiUpListener(AMFMTuner aMFMTuner) {
        this.this$0 = aMFMTuner;
    }

    @Override
    public void updateStationListFM(AMFMStation[] aMFMStationArray) {
        AMFMTuner.access$700(this.this$0);
    }

    @Override
    public void updateStationListAM(AMFMStation[] aMFMStationArray) {
        AMFMTuner.access$800(this.this$0);
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.this$0.updateWavebandInfoList(wavebandInfoArray);
    }

    @Override
    public void updateAFSwitchStatus(boolean bl) {
        this.this$0.updateAFSwitchStatus(bl);
    }

    @Override
    public void updateREGSwitchStatus(int n) {
        this.this$0.updateREGSwitchStatus(n);
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.this$0.updateDetectedDevice(n);
    }

    @Override
    public void seekStationStatus(boolean bl) {
        this.this$0.seekStationStatus(bl);
    }

    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        this.this$0.updateSelectedStation(aMFMStation);
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        this.this$0.forceAMUpdateStatus(n);
    }

    @Override
    public void updateHdMode(int n) {
        this.this$0.updateHdMode(n);
    }

    /* synthetic */ AMFMTuner$DsiUpListener(AMFMTuner aMFMTuner, AMFMTuner$1 aMFMTuner$1) {
        this(aMFMTuner);
    }
}

