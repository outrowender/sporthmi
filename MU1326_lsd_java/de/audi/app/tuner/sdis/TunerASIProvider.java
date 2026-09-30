/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.sdis;

import de.audi.app.tuner.sdis.ParentalEnforcement;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.interapp.sdis.ISDISBlockingListener;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.IRadioInterappListener;
import de.audi.tuner.ifc.IRadioInterappService;
import de.audi.tuner.ifc.NullRadioInterappService;
import de.esolutions.fw.comm.asi.hmisync.radio.ASIHMISyncRadioReply;
import de.esolutions.fw.comm.asi.hmisync.radio.CurrentStation;
import de.esolutions.fw.comm.asi.hmisync.radio.StationInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.WavebandInfo;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioAbstractBaseService;
import de.esolutions.fw.comm.asi.hmisync.radio.impl.ASIHMISyncRadioService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.method.MethodException;
import java.util.ArrayList;
import java.util.List;

public class TunerASIProvider
extends ASIHMISyncRadioAbstractBaseService
implements IASIProvider {
    public final RadioInterappListener radioInterappListener = new RadioInterappListener();
    public final BlockingListener blockingListener = new BlockingListener();
    public final ParentalEnforcement parentalEnforcement = new ParentalEnforcement();
    private IRadioInterappService radioInterappService;
    private final ASIHMISyncRadioService radioService;
    public final LogChannel log;
    private boolean sdisBlocked = false;
    private List stationDetailListeners = new ArrayList(2);

    public TunerASIProvider(LogChannel logChannel, int n) {
        this.radioService = new ASIHMISyncRadioService(n, this);
        this.log = logChannel;
        this.radioInterappService = new NullRadioInterappService(logChannel);
        try {
            this.updateReplyIDs(new short[]{21, 11, 12, 18, 17, 14, 22, 20});
            this.updateRequestIDs(new short[]{0, 1, 2, 7, 8, 9, 5, 6, 3});
            this.updateASIVersion("3.3.11");
        }
        catch (MethodException methodException) {
            logChannel.log(10000, "TunerASIProvider - could not register ASI version!");
        }
    }

    public void setRadioInterappService(IRadioInterappService iRadioInterappService) {
        this.radioInterappService = iRadioInterappService;
    }

    public IService getService() {
        return this.radioService;
    }

    public void attachStub(IStub iStub) {
        this.log.log(1000000, "'%1'", (Object)iStub);
    }

    public void detachStub(IStub iStub) {
        this.log.log(1000000, "'%1'", (Object)iStub);
    }

    public void selectBand(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) throws MethodException {
        this.log.log(1000000, "[TunerASIProvider.selectBand(%1)]", (long)n);
        if (!this.sdisBlocked) {
            this.radioInterappService.selectBand(n);
        } else {
            this.log.log(1000000, "[TunerASIProvider.selectBand()] blocked -> no action");
        }
    }

    public void selectStation(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) throws MethodException {
        this.log.log(1000000, "[TunerASIProvider.selectStation(%1)]", l);
        if (!this.sdisBlocked) {
            this.radioInterappService.tuneStation(l);
        } else {
            this.log.log(1000000, "[TunerASIProvider.selectStation()] blocked -> no action");
        }
    }

    public void seekStation(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) throws MethodException {
        this.log.log(1000000, "[TunerASIProvider.seekStation] not supported");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void enableStationDetails(boolean bl, ASIHMISyncRadioReply aSIHMISyncRadioReply) throws MethodException {
        List list = this.stationDetailListeners;
        synchronized (list) {
            if (bl) {
                this.stationDetailListeners.add(aSIHMISyncRadioReply);
            } else {
                this.stationDetailListeners.remove(aSIHMISyncRadioReply);
            }
        }
    }

    public void updateActiveBand(int n) {
        try {
            this.log.log(10000000, "[TunerASIProvider.updateActiveBand] %1", (long)n);
            super.updateActiveBand(n);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateWavebands(WavebandInfo[] wavebandInfoArray) {
        try {
            this.log.log(10000000, "[TunerASIProvider.updateWavebands] %1", (Object)wavebandInfoArray);
            super.updateWavebands(wavebandInfoArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateActiveStation(IRadioInterappListener.RadioStation radioStation) {
        try {
            CurrentStation currentStation = this.changeStationType(radioStation);
            if (this.log.isDebug()) {
                this.log.log(10000000, "[TunerASIProvider.updateActiveStation] %1", (Object)currentStation.toString());
            }
            super.updateActiveStation(currentStation);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateBandList(int[] nArray) {
        this.log.log(10000000, "[TunerASIProvider.updateBandList] %1", (Object)nArray);
        try {
            super.updateBandList(nArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateRadioStationList(StationInfo[] stationInfoArray) {
        try {
            super.updateRadioStationList(stationInfoArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateStationDetails(IRadioInterappListener.RadioStation[] radioStationArray) {
        int n;
        CurrentStation[] currentStationArray = new CurrentStation[radioStationArray.length];
        for (n = 0; n < radioStationArray.length; ++n) {
            currentStationArray[n] = this.changeStationType(radioStationArray[n]);
        }
        for (n = 0; n < this.stationDetailListeners.size(); ++n) {
            try {
                ((ASIHMISyncRadioReply)this.stationDetailListeners.get(n)).stationDetailsUpdated(currentStationArray);
                continue;
            }
            catch (MethodException methodException) {
                this.log.log(10000, "%1", (Throwable)methodException);
            }
        }
    }

    private CurrentStation changeStationType(IRadioInterappListener.RadioStation radioStation) {
        return new CurrentStation(radioStation.id, radioStation.name, radioStation.fullName, radioStation.artist, radioStation.artistType, radioStation.title, radioStation.titleType, radioStation.image, radioStation.audioStatus, radioStation.layer, radioStation.album, radioStation.radioText, "");
    }

    private class BlockingListener
    implements ISDISBlockingListener {
        private BlockingListener() {
        }

        public void updateLockState(int n) {
        }

        public void updateBlockState(int n) {
            TunerASIProvider.this.log.log(1000000, "[TunerASIProvider.BlockingListener.updateBlockState] %1", (long)n);
            if ((n & 1) == 1) {
                TunerASIProvider.this.sdisBlocked = true;
            } else {
                TunerASIProvider.this.sdisBlocked = false;
            }
        }
    }

    private class RadioInterappListener
    implements IRadioInterappListener {
        private RadioInterappListener() {
        }

        public void updateBandList(int[] nArray) {
            TunerASIProvider.this.updateBandList(nArray);
        }

        public void updateActiveBand(int n) {
            TunerASIProvider.this.updateActiveBand(n);
        }

        public void updateWavebandInfoList(org.dsi.ifc.radio.WavebandInfo[] wavebandInfoArray) {
            ArrayList arrayList = new ArrayList(wavebandInfoArray.length);
            for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
                org.dsi.ifc.radio.WavebandInfo wavebandInfo = wavebandInfoArray[i2];
                if (wavebandInfo.waveband != 1 && wavebandInfo.waveband != 3) continue;
                int n = wavebandInfo.waveband == 3 ? 4 : wavebandInfo.waveband;
                arrayList.add(new WavebandInfo(n, (int)wavebandInfo.lowerLimit, (int)wavebandInfo.upperLimit, (int)wavebandInfo.stepWidth));
            }
            TunerASIProvider.this.updateWavebands((WavebandInfo[])arrayList.toArray(new WavebandInfo[arrayList.size()]));
        }

        public void updateRadioStationList(IRadioInterappListener.RadioStation[] radioStationArray) {
            StationInfo[] stationInfoArray = new StationInfo[radioStationArray.length];
            for (int i2 = 0; i2 < stationInfoArray.length; ++i2) {
                IRadioInterappListener.RadioStation radioStation = radioStationArray[i2];
                stationInfoArray[i2] = new StationInfo(radioStation.id, radioStation.name, radioStation.fullName, radioStationArray[i2].audioStatus, radioStation.layer, radioStation.stationLogoUri, radioStation.frequency, "");
                if (!TunerASIProvider.this.log.isDebug()) continue;
                TunerASIProvider.this.log.log(1000000, "[TunerASIProvider.RadioInterappListener.updateRadioStationList] [%2] %1", (Object)stationInfoArray[i2], (long)i2);
            }
            TunerASIProvider.this.updateRadioStationList(stationInfoArray);
            if (!TunerASIProvider.this.stationDetailListeners.isEmpty()) {
                TunerASIProvider.this.updateStationDetails(radioStationArray);
            }
        }

        public void updateActiveStation(IRadioInterappListener.RadioStation radioStation) {
            TunerASIProvider.this.updateActiveStation(radioStation);
        }

        public void enforceRadio() {
            TunerASIProvider.this.parentalEnforcement.enforceRadio();
        }
    }
}

