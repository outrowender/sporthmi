/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.sdis;

import de.audi.app.tuner.sdis.ParentalEnforcement;
import de.audi.app.tuner.sdis.TunerASIProvider$BlockingListener;
import de.audi.app.tuner.sdis.TunerASIProvider$RadioInterappListener;
import de.audi.atip.agent.IASIProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.IRadioInterappListener$RadioStation;
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
    public final TunerASIProvider$RadioInterappListener radioInterappListener = new TunerASIProvider$RadioInterappListener(this, null);
    public final TunerASIProvider$BlockingListener blockingListener = new TunerASIProvider$BlockingListener(this, null);
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

    @Override
    public IService getService() {
        return this.radioService;
    }

    @Override
    public void attachStub(IStub iStub) {
        this.log.log(1078071040, "'%1'", (Object)iStub);
    }

    @Override
    public void detachStub(IStub iStub) {
        this.log.log(1078071040, "'%1'", (Object)iStub);
    }

    @Override
    public void selectBand(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.log.log(1078071040, "[TunerASIProvider.selectBand(%1)]", (long)n);
        if (!this.sdisBlocked) {
            this.radioInterappService.selectBand(n);
        } else {
            this.log.log(1078071040, "[TunerASIProvider.selectBand()] blocked -> no action");
        }
    }

    @Override
    public void selectStation(long l, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.log.log(1078071040, "[TunerASIProvider.selectStation(%1)]", l);
        if (!this.sdisBlocked) {
            this.radioInterappService.tuneStation(l);
        } else {
            this.log.log(1078071040, "[TunerASIProvider.selectStation()] blocked -> no action");
        }
    }

    @Override
    public void seekStation(int n, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        this.log.log(1078071040, "[TunerASIProvider.seekStation] not supported");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void enableStationDetails(boolean bl, ASIHMISyncRadioReply aSIHMISyncRadioReply) {
        List list = this.stationDetailListeners;
        synchronized (list) {
            if (bl) {
                this.stationDetailListeners.add(aSIHMISyncRadioReply);
            } else {
                this.stationDetailListeners.remove(aSIHMISyncRadioReply);
            }
        }
    }

    @Override
    public void updateActiveBand(int n) {
        try {
            this.log.log(-2137614336, "[TunerASIProvider.updateActiveBand] %1", (long)n);
            super.updateActiveBand(n);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateWavebands(WavebandInfo[] wavebandInfoArray) {
        try {
            this.log.log(-2137614336, "[TunerASIProvider.updateWavebands] %1", (Object)wavebandInfoArray);
            super.updateWavebands(wavebandInfoArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateActiveStation(IRadioInterappListener$RadioStation radioStation) {
        try {
            CurrentStation currentStation = this.changeStationType(radioStation);
            if (this.log.isDebug()) {
                this.log.log(-2137614336, "[TunerASIProvider.updateActiveStation] %1", (Object)currentStation.toString());
            }
            super.updateActiveStation(currentStation);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateBandList(int[] nArray) {
        this.log.log(-2137614336, "[TunerASIProvider.updateBandList] %1", (Object)nArray);
        try {
            super.updateBandList(nArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    @Override
    public void updateRadioStationList(StationInfo[] stationInfoArray) {
        try {
            super.updateRadioStationList(stationInfoArray);
        }
        catch (MethodException methodException) {
            this.log.log(10000, "%1", (Throwable)methodException);
        }
    }

    public void updateStationDetails(IRadioInterappListener$RadioStation[] radioStationArray) {
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

    private CurrentStation changeStationType(IRadioInterappListener$RadioStation iRadioInterappListener$RadioStation) {
        return new CurrentStation(iRadioInterappListener$RadioStation.id, iRadioInterappListener$RadioStation.name, iRadioInterappListener$RadioStation.fullName, iRadioInterappListener$RadioStation.artist, iRadioInterappListener$RadioStation.artistType, iRadioInterappListener$RadioStation.title, iRadioInterappListener$RadioStation.titleType, iRadioInterappListener$RadioStation.image, iRadioInterappListener$RadioStation.audioStatus, iRadioInterappListener$RadioStation.layer, iRadioInterappListener$RadioStation.album, iRadioInterappListener$RadioStation.radioText, "");
    }

    static /* synthetic */ List access$200(TunerASIProvider tunerASIProvider) {
        return tunerASIProvider.stationDetailListeners;
    }

    static /* synthetic */ boolean access$302(TunerASIProvider tunerASIProvider, boolean bl) {
        tunerASIProvider.sdisBlocked = bl;
        return tunerASIProvider.sdisBlocked;
    }
}

