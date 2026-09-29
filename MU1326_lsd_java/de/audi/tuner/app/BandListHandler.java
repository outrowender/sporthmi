/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tuner.app.BandListHandler$BandListComparator;
import de.audi.tuner.app.BandListHandler$UpdateListener;
import de.audi.tuner.app.BandListRow;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.sds.UpdateListenerHandler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.dsi.ifc.radio.WavebandInfo;

public class BandListHandler
extends UpdateListenerHandler {
    public final IUpdateListener updateListener = new BandListHandler$UpdateListener(this, null);
    private WavebandInfo[] wavebandInfos = new WavebandInfo[0];
    private List bandArrayList = new ArrayList(10);
    private final Logger logger;
    private final TunerStatus status;
    private final TunerStorage storage;
    private final MemoryListHandler memory;
    private final TunerAudioMgmt audio;
    private final AnnouncementHandler announce;
    private final BaseListModelApp bandList;
    private final TunerModels models;

    BandListHandler(TunerBasics tunerBasics, TunerStorage tunerStorage, MemoryListHandler memoryListHandler, TunerAudioMgmt tunerAudioMgmt, AnnouncementHandler announcementHandler) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.storage = tunerStorage;
        this.memory = memoryListHandler;
        this.audio = tunerAudioMgmt;
        this.announce = announcementHandler;
        this.bandList = this.models.getBaseListModel(-2004352768);
        if (Utilities.isJapan()) {
            this.models.getChoiceModel(1720123648).setValue(1);
        }
    }

    public void setAvailableWaveBands(WavebandInfo[] wavebandInfoArray) {
        this.logger.main.log(-2137614336, " [BandListHandler.setAvailableWaveBands] Updating available wavebands");
        this.wavebandInfos = wavebandInfoArray;
        this.removeFromBandList(4);
        this.removeFromBandList(10);
        this.removeFromBandList(1);
        boolean bl = false;
        block4: for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
            switch (wavebandInfoArray[i2].waveband) {
                case 3: {
                    if (bl || wavebandInfoArray[i2].lowerLimit == 0L || wavebandInfoArray[i2].upperLimit == 0L) continue block4;
                    this.addToBandList(4);
                    if (Utilities.isJapan() && !Utilities.isPGen1OrBentley()) {
                        this.addToBandList(10);
                    }
                    bl = true;
                    continue block4;
                }
                case 1: {
                    if (wavebandInfoArray[i2].lowerLimit == 0L || wavebandInfoArray[i2].upperLimit == 0L) continue block4;
                    this.addToBandList(1);
                    continue block4;
                }
            }
        }
        this.propagateUpdatedBandList(this.getWavebands());
    }

    public int getBandByFrequency(int n) {
        if (this.wavebandInfos.length != 0) {
            for (int i2 = 0; i2 < this.wavebandInfos.length; ++i2) {
                boolean bl;
                this.logger.dd.log(14808325, "[BandListHandler.getBandByFrequency] waveband: %2, freq: %1", (Object)this.wavebandInfos[i2], (long)n);
                boolean bl2 = bl = (long)n >= this.wavebandInfos[i2].lowerLimit && (long)n <= this.wavebandInfos[i2].upperLimit && this.wavebandInfos[i2].stepWidth != 0L && ((long)n - this.wavebandInfos[i2].lowerLimit) % this.wavebandInfos[i2].stepWidth == 0L;
                if (!bl) continue;
                switch (this.wavebandInfos[i2].waveband) {
                    case 1: {
                        return 1;
                    }
                    case 3: 
                    case 4: {
                        return 4;
                    }
                }
            }
            return -1;
        }
        if (n > 1625948160) {
            return 1;
        }
        return 4;
    }

    public int getWavebandByFrequency(long l) {
        for (int i2 = 0; i2 < this.wavebandInfos.length; ++i2) {
            this.logger.dd.log(14808325, "[BandListHandler.getWavebandByFrequency] waveband: %2, freq: %1", (Object)this.wavebandInfos[i2], l);
            if (l < this.wavebandInfos[i2].lowerLimit || l > this.wavebandInfos[i2].upperLimit) continue;
            return this.wavebandInfos[i2].waveband;
        }
        return -1;
    }

    public synchronized void switchBand(int n) {
        ChoiceModelApp choiceModelApp = this.models.getChoiceModel(-595132160);
        choiceModelApp.setValue(n);
        switch (n) {
            case 8: 
            case 12: 
            case 13: {
                choiceModelApp.fireEvent(0);
                this.audio.demute();
                break;
            }
            default: {
                this.switchBand(n, null, 0);
            }
        }
        this.propagateUpdatedActiveList(n);
        this.storage.storeLastMode(n, this.models.getActiveTuner());
    }

    synchronized void switchBand(int n, TunerObjectContainer tunerObjectContainer, int n2) {
        boolean bl = false;
        TunerProxyManager tunerProxyManager = TunerProxyManager.getInstance();
        this.memory.cancelActions();
        int n3 = this.models.getActiveTuner();
        int n4 = this.models.getActiveList();
        this.logger.main.log(-2137614336, "[BandListHandler.switchBand] switchBand called! target: %1, source: %2 ", (long)n, (long)n3);
        tunerProxyManager.stopActiveActions();
        if (n != n3) {
            this.announce.abortAnnouncement();
            this.announce.resetVolumeAdjustment();
            this.models.setActiveTuner(n);
            if (n4 == n3) {
                this.models.getChoiceModel(-595132160).setValue(n);
                bl = true;
            }
            this.models.getChoiceModel(422).setValue(n);
            switch (n) {
                case 5: {
                    DabStation dabStation = null;
                    if (tunerObjectContainer != null && tunerObjectContainer.getType() == 6) {
                        dabStation = tunerObjectContainer.getDABStation();
                    }
                    tunerProxyManager.getDABTuner().dabSelected(dabStation, n2);
                    break;
                }
                case 11: {
                    UnifiedStationExt unifiedStationExt = null;
                    if (tunerObjectContainer != null && tunerObjectContainer.getType() == 7) {
                        unifiedStationExt = tunerObjectContainer.getUniStation();
                    }
                    tunerProxyManager.getUnifiedTuner().uniSelected(unifiedStationExt, n2);
                    break;
                }
                case 7: {
                    tunerProxyManager.getAmFmTuner().setComponentUsage(false);
                    tunerProxyManager.getSDARSTuner().setComponentUsage(true);
                    StationInfoExt stationInfoExt = null;
                    if (tunerObjectContainer != null && tunerObjectContainer.getType() == 5) {
                        stationInfoExt = tunerObjectContainer.getSDARSService();
                    }
                    tunerProxyManager.getSDARSTuner().sdarsSelected(stationInfoExt, n2);
                    break;
                }
                case 1: {
                    tunerProxyManager.getAmFmTuner().changeWaveband(1, tunerObjectContainer, n2);
                    break;
                }
                case 4: {
                    tunerProxyManager.getAmFmTuner().changeWaveband(4, tunerObjectContainer, n2);
                    break;
                }
                case 10: {
                    tunerProxyManager.getAmFmTuner().changeWaveband(10, tunerObjectContainer, n2);
                    break;
                }
            }
            this.storage.storeLastMode(this.models.getActiveList(), n);
            this.propagateUpdatedWaveband(n);
        } else {
            this.audio.demute();
        }
        if (this.status.isTaVolumeAdjustmentActive()) {
            this.announce.resetVolumeAdjustment();
        }
        if (bl) {
            this.models.getChoiceModel(-595132160).fireEvent(0);
        }
    }

    public void addToBandList(int n) {
        this.logger.hmi.log(-2137614336, "[BandListHandler.addToBandList] adding band %1 to list", (long)n);
        switch (n) {
            case 1: {
                this.models.getChoiceModel(596115712).setValue(1);
                break;
            }
            case 4: {
                this.models.getChoiceModel(-544800512).setValue(1);
                break;
            }
            case 10: {
                this.models.getChoiceModel(1720123648).setValue(1);
                break;
            }
        }
        this.buildNewBandList(n, true);
        this.propagateUpdatedBandList(this.getWavebands());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void buildNewBandList(int n, boolean bl) {
        Integer n2 = new Integer(n);
        boolean bl2 = false;
        List list = this.bandArrayList;
        synchronized (list) {
            if (bl) {
                if (!this.bandArrayList.contains(n2)) {
                    this.bandArrayList.add(n2);
                    Collections.sort(this.bandArrayList, new BandListHandler$BandListComparator(null));
                    bl2 = true;
                }
            } else {
                bl2 = this.bandArrayList.remove(n2);
            }
            if (bl2) {
                this.bandList.removeAll();
                for (int i2 = 0; i2 < this.bandArrayList.size(); ++i2) {
                    int n3 = (Integer)this.bandArrayList.get(i2);
                    this.bandList.append(new BandListRow(n3));
                }
            }
        }
    }

    public void removeFromBandList(int n) {
        switch (n) {
            case 4: {
                this.models.getChoiceModel(-544800512).setValue(0);
                break;
            }
            case 1: {
                this.models.getChoiceModel(596115712).setValue(0);
                break;
            }
            case 10: {
                this.models.getChoiceModel(1720123648).setValue(0);
                break;
            }
        }
        this.buildNewBandList(n, false);
        this.propagateUpdatedBandList(this.getWavebands());
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public synchronized int[] getWavebands() {
        List list = this.bandArrayList;
        synchronized (list) {
            int[] nArray = new int[this.bandArrayList.size()];
            for (int i2 = 0; i2 < this.bandArrayList.size(); ++i2) {
                nArray[i2] = (Integer)this.bandArrayList.get(i2);
            }
            return nArray;
        }
    }

    static /* synthetic */ TunerModels access$200(BandListHandler bandListHandler) {
        return bandListHandler.models;
    }
}

