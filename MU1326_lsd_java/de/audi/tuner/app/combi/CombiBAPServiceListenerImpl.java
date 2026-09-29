/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTunerListener;
import de.audi.tuner.app.AudioFocusClient;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.combi.CombiBAPIdMapper;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.app.combi.CombiBAPUtilities;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.keys.DefaultButtonHandler;

public class CombiBAPServiceListenerImpl
implements CombiBAPServiceTunerListener {
    private final Logger logger;
    private final TunerModels models;
    private final CombiBAPServiceHandler combiHandler;
    private IMemoryList memory;
    private final AnnouncementHandler announce;
    private final AudioFocusClient audioFocusClient;
    private final CombiBAPIdMapper idMapper;
    private final DefaultButtonHandler defaultButtonHandler;
    private final IScanHandler scan;
    private final TunerStorage storage;

    public CombiBAPServiceListenerImpl(TunerBasics tunerBasics, CombiBAPServiceHandler combiBAPServiceHandler, MemoryListHandler memoryListHandler, AnnouncementHandler announcementHandler, AudioFocusClient audioFocusClient, CombiBAPIdMapper combiBAPIdMapper, DefaultButtonHandler defaultButtonHandler, IScanHandler iScanHandler, TunerStorage tunerStorage) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.combiHandler = combiBAPServiceHandler;
        this.memory = memoryListHandler;
        this.announce = announcementHandler;
        this.audioFocusClient = audioFocusClient;
        this.idMapper = combiBAPIdMapper;
        this.defaultButtonHandler = defaultButtonHandler;
        this.scan = iScanHandler;
        this.storage = tunerStorage;
    }

    public synchronized void setFavortieListHandler(IMemoryList iMemoryList) {
        this.memory = iMemoryList;
    }

    @Override
    public void startStationListUpdate() {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#startStationListUpdate]");
        if (!TunerProxyManager.getInstance().getActiveTuner().forceStationListUpdate(true)) {
            this.combiHandler.startStationListUpdateResult(false);
        } else {
            this.combiHandler.startStationListUpdateResult(true);
        }
    }

    @Override
    public void cancelStationListUpdate() {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#cancelStationListUpdate]");
        if (!TunerProxyManager.getInstance().getActiveTuner().forceStationListUpdate(false)) {
            this.combiHandler.cancelStationListUpdateResult(false);
        } else {
            this.combiHandler.cancelStationListUpdateResult(true);
        }
    }

    @Override
    public void startSeek(int n) {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#startSeek] direction:%1", (long)n);
        int n2 = CombiBAPUtilities.getTunerSeekMode(n);
        TunerProxyManager.getInstance().getAmFmTuner().seekStation(n2, 0);
    }

    @Override
    public void cancelSeek() {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#cancelSeek]");
        TunerProxyManager.getInstance().getAmFmTuner().abortSeek();
    }

    @Override
    public void setPreferredList(int n) {
        this.scan.abortScan();
        if (Utilities.isPGen1OrBentley()) {
            this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#setPreferredList] ignored for PAG or BY");
            return;
        }
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#setPreferredList]");
        int n2 = this.models.getActiveList();
        int n3 = this.models.getActiveTuner();
        if (n == 2) {
            this.models.setActiveList(12);
            n2 = 12;
        } else if (n == 1) {
            this.models.setActiveList(n3);
            n2 = n3;
        }
        this.combiHandler.updatedActiveList(this.models.getActiveList());
        this.storage.storeLastMode(n2, n3);
    }

    @Override
    public void selectListEntry(int n) {
        this.scan.abortScan();
        long l = this.idMapper.getRadioId(n);
        if (l == 0L) {
            this.combiHandler.selectListEntryResult(false);
            return;
        }
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#selectListEntry], posID: %1 RadioId: %2", (long)n, l);
        ITunerGUIHandler iTunerGUIHandler = TunerProxyManager.getInstance().getActiveTunerGuiHandler();
        if (iTunerGUIHandler != null) {
            boolean bl = iTunerGUIHandler.tuneById(l, 1);
            this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#selectListEntry], result %1", bl);
            this.combiHandler.selectListEntryResult(bl);
        } else {
            this.logger.combi.log(10000, "[CombiBAPServiceTunerListenerImpl#selectListEntry], guiHandler == null!");
        }
    }

    @Override
    public void selectListEntryPresetList(int n) {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#selectListEntryPresetList], posID: %1", (long)n);
        this.scan.abortScan();
        boolean bl = this.memory.tuneByCombiID(n, 1);
        this.combiHandler.selectListEntryResult(bl);
    }

    @Override
    public void setActiveSourceState(int n, int n2) {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#setActiveSourceState], playMode: %1, playScope: %2", (long)n, (long)n2);
    }

    @Override
    public void skip(int n) {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl.skip] skipCount: %1", (long)n);
        this.scan.abortScan();
        int n2 = n > 0 ? 1283981568 : 1300758784;
        try {
            for (int i2 = 0; i2 < Math.abs(n); ++i2) {
                this.defaultButtonHandler.keyTyped(n2, 0, 0);
            }
            this.combiHandler.updatedSkipResult(true);
        }
        catch (Exception exception) {
            this.logger.combi.log(10000, "[CombiBAPServiceTunerListenerImpl.skip]", (Throwable)exception);
            this.combiHandler.updatedSkipResult(false);
        }
    }

    @Override
    public void switchSource(int n, int n2, int n3) {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#switchSource], type: %1, slotNumber: %2, partitionNumber: %3", (long)n, (long)n2, (long)n3);
        int n4 = CombiBAPUtilities.getTunerSourceType(n);
        this.scan.abortScan();
        this.audioFocusClient.switchSource(0, n4, null);
        this.combiHandler.updatedSwitchSourceResult(true);
    }

    @Override
    public void cancelAnnouncement() {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#cancelAnnouncement]");
        boolean bl = this.announce.abortAnnouncement();
        this.combiHandler.updatedAbortAnnoucementStatus(bl);
    }

    @Override
    public void setProgramStringLength(boolean bl, boolean bl2) {
        this.combiHandler.setLongNames(bl, bl2);
    }

    @Override
    public void getNextListPos(int n, int n2) {
    }

    @Override
    public void activateSource(int n) {
        this.logger.combi.log(-2137614336, "[CombiBAPServiceTunerListenerImpl#activateSource]%1", (long)n);
        if (n == 0) {
            int n2 = this.models.getActiveTuner();
            this.audioFocusClient.switchSource(0, n2, null);
            this.combiHandler.activateSourceResult(0);
        } else {
            this.combiHandler.activateSourceResult(1);
        }
    }

    @Override
    public void resendAllInfoForActiveBand() {
        this.combiHandler.tunerActivated();
    }
}

