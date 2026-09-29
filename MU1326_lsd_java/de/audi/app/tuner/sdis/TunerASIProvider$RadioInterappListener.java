/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.sdis;

import de.audi.app.tuner.sdis.TunerASIProvider;
import de.audi.app.tuner.sdis.TunerASIProvider$1;
import de.audi.tuner.ifc.IRadioInterappListener;
import de.audi.tuner.ifc.IRadioInterappListener$RadioStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import java.util.ArrayList;

class TunerASIProvider$RadioInterappListener
implements IRadioInterappListener {
    private final /* synthetic */ TunerASIProvider this$0;

    private TunerASIProvider$RadioInterappListener(TunerASIProvider tunerASIProvider) {
        this.this$0 = tunerASIProvider;
    }

    @Override
    public void updateBandList(int[] nArray) {
        this.this$0.updateBandList(nArray);
    }

    @Override
    public void updateActiveBand(int n) {
        this.this$0.updateActiveBand(n);
    }

    @Override
    public void updateWavebandInfoList(org.dsi.ifc.radio.WavebandInfo[] wavebandInfoArray) {
        ArrayList arrayList = new ArrayList(wavebandInfoArray.length);
        for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
            org.dsi.ifc.radio.WavebandInfo wavebandInfo = wavebandInfoArray[i2];
            if (wavebandInfo.waveband != 1 && wavebandInfo.waveband != 3) continue;
            int n = wavebandInfo.waveband == 3 ? 4 : wavebandInfo.waveband;
            arrayList.add(new WavebandInfo(n, (int)wavebandInfo.lowerLimit, (int)wavebandInfo.upperLimit, (int)wavebandInfo.stepWidth));
        }
        this.this$0.updateWavebands((WavebandInfo[])arrayList.toArray(new WavebandInfo[arrayList.size()]));
    }

    @Override
    public void updateRadioStationList(IRadioInterappListener$RadioStation[] iRadioInterappListener$RadioStationArray) {
        StationInfo[] stationInfoArray = new StationInfo[iRadioInterappListener$RadioStationArray.length];
        for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
            IRadioInterappListener$RadioStation iRadioInterappListener$RadioStation = iRadioInterappListener$RadioStationArray[i2];
            stationInfoArray[i2] = new StationInfo(iRadioInterappListener$RadioStation.id, iRadioInterappListener$RadioStation.name, iRadioInterappListener$RadioStation.fullName, iRadioInterappListener$RadioStationArray[i2].audioStatus, iRadioInterappListener$RadioStation.layer, iRadioInterappListener$RadioStation.stationLogoUri, iRadioInterappListener$RadioStation.frequency, "");
            if (!this.this$0.log.isDebug()) continue;
            this.this$0.log.log(1078071040, "[TunerASIProvider.RadioInterappListener.updateRadioStationList] [%2] %1", (Object)stationInfoArray[i2], (long)i2);
        }
        this.this$0.updateRadioStationList(stationInfoArray);
        if (!TunerASIProvider.access$200(this.this$0).isEmpty()) {
            this.this$0.updateStationDetails(iRadioInterappListener$RadioStationArray);
        }
    }

    @Override
    public void updateActiveStation(IRadioInterappListener$RadioStation iRadioInterappListener$RadioStation) {
        this.this$0.updateActiveStation(iRadioInterappListener$RadioStation);
    }

    @Override
    public void enforceRadio() {
        this.this$0.parentalEnforcement.enforceRadio();
    }

    /* synthetic */ TunerASIProvider$RadioInterappListener(TunerASIProvider tunerASIProvider, TunerASIProvider$1 tunerASIProvider$1) {
        this(tunerASIProvider);
    }
}

