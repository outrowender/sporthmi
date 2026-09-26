/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.AllTunerLSMStorrage;
import de.audi.tuner.app.storage.IMemListStorage;
import de.audi.tuner.app.storage.TunerStorage$UniUpListener;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.esolutions.fw.util.commons.SimpleIntIntMap;

public class TunerStorage {
    public final UniDsiUpInfo dsiUpListener = new TunerStorage$UniUpListener(this, null);
    private final Logger logger;
    private final IMemListStorage memoryListStorage;
    private final AllTunerLSMStorrage allLsmStorrage;
    private final TunerAudioMgmt audio;

    public TunerStorage(TunerBasics tunerBasics, ITunerVariantExt iTunerVariantExt, TunerAudioMgmt tunerAudioMgmt) {
        this.logger = tunerBasics.getLogger();
        this.memoryListStorage = iTunerVariantExt.getMemListStorage(tunerBasics.getFramework().getStorageMgr(), tunerBasics.getLogger().main, iTunerVariantExt.getListRowFactory());
        this.allLsmStorrage = new AllTunerLSMStorrage(tunerBasics.getFramework().getStorageMgr(), tunerBasics);
        this.audio = tunerAudioMgmt;
    }

    public void init() {
        this.memoryListStorage.setPreferredImgType(this.loadPreferredImageType());
        this.loadAMFMSetup();
        this.loadTASetup();
        this.loadDABSetup();
    }

    public void storeLastMode(int n, int n2) {
        this.logger.main.log(-2137614336, "[TunerStorage#storeLastMode] list:%1 band:%2", (long)n, (long)n2);
        if (this.audio.isAMAvailable()) {
            this.allLsmStorrage.storeLastMode(n, n2);
        } else {
            this.logger.main.log(-1601830656, "[TunerStorage#storeLastMode] AMAvailable=false: -> not storing the last mode (list:%1 band:%2)", (long)n, (long)n2);
        }
    }

    public int[] loadLastMode() {
        return this.allLsmStorrage.getLastMode();
    }

    public AMFMStation[] loadLastAMFMStations() {
        return this.allLsmStorrage.getAmFmLsm();
    }

    public AMFMStation getAMFMLSM(int n) {
        switch (n) {
            case 1: {
                return this.loadLastAMFMStations()[0];
            }
            case 4: {
                return this.loadLastAMFMStations()[1];
            }
            case 10: {
                return this.loadLastAMFMStations()[2];
            }
        }
        this.logger.main.log(10000, "[TunerStorage.getAMFMLSM]", (Throwable)new IllegalArgumentException(new StringBuffer().append("Invalid band ").append(n).toString()));
        return new AMFMStation();
    }

    public void storeLastStation(AMFMStation aMFMStation, int n) {
        if (this.audio.isAMAvailable()) {
            this.allLsmStorrage.storeAmFmLsm(aMFMStation, n);
        } else {
            this.logger.main.log(-1601830656, "[TunerStorage#storeLastStation] AMAvailable=false: -> not storing the last mode (station:%1 band:%2) ", aMFMStation.frequency, (long)n);
        }
    }

    public DabStation loadLastDABService() {
        return this.allLsmStorrage.getDABLsm();
    }

    public UnifiedStationExt loadLastUnifiedStation() {
        return this.allLsmStorrage.getUniLsm();
    }

    public void storeLastDABService(DabStation dabStation) {
        if (this.audio.isAMAvailable()) {
            this.logger.main.log(1078071040, "[TunerStorage#storeLastDABService], Ensemble: %1", (Object)dabStation.ensemble);
            this.logger.main.log(1078071040, "[TunerStorage#storeLastDABService], Service: %1", (Object)dabStation.service);
            this.logger.main.log(1078071040, "[TunerStorage#storeLastDABService], Component: %1", (Object)dabStation.component);
            if (dabStation.ensemble.ensID == 0) {
                this.logger.dabDSI.log(-2137614336, "[TunerStorage..storeLastDABService] ignore to save ensId=0");
                return;
            }
            this.allLsmStorrage.storeDabLsm(dabStation);
        } else {
            this.logger.main.log(-1601830656, "[TunerStorage#storeLastDABService] AMAvailable=false: -> not storing the last mode (station:%1 band:DAB)", (Object)dabStation.service.fullName);
        }
    }

    public void storeLastUniStation(UnifiedStationExt unifiedStationExt) {
        if (this.audio.isAMAvailable()) {
            this.allLsmStorrage.storeUniLsm(unifiedStationExt);
        } else {
            this.logger.main.log(-1601830656, "[TunerStorage#storeLastUniStation] AMAvailable=false: -> not storing the last mode (station:%1 band:FM/DAB)", (Object)unifiedStationExt.shortName);
        }
    }

    public StationInfoExt loadLastSDARSStation() {
        return this.allLsmStorrage.getSdarsLsm();
    }

    public void storeLastSDARSService(StationInfoExt stationInfoExt) {
        if (this.audio.isAMAvailable()) {
            this.allLsmStorrage.storeSdarsLsm(stationInfoExt);
        } else {
            this.logger.main.log(-1601830656, "[TunerStorage#storeLastSDARSService] AMAvailable=false: -> not storing the last mode (station:%1 band:SDARS)", (Object)stationInfoExt.shortLabel);
        }
    }

    public AbstractMemoryRow[] loadMemoryList(int n, ILogoDatabase iLogoDatabase) {
        return this.memoryListStorage.readList(n, iLogoDatabase);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void storeMemoryList(int n, AbstractMemoryRow[] abstractMemoryRowArray) {
        this.logger.main.log(-2137614336, "[TunerStorage.storeMemoryList]");
        TunerStorage tunerStorage = this;
        synchronized (tunerStorage) {
            this.memoryListStorage.writeList(n, abstractMemoryRowArray);
        }
    }

    public int[] loadAMFMSetup() {
        return this.allLsmStorrage.getAmFmSetup();
    }

    public void storeAMFMSetup(int[] nArray, boolean bl) {
        this.allLsmStorrage.storeAmFmSetup(nArray);
    }

    public boolean isAmFmHdTuner() {
        return this.allLsmStorrage.isAmFmHdTuner();
    }

    public void storeHdTuner(boolean bl) {
        this.allLsmStorrage.storeHdTuner(bl);
    }

    public int[] loadTASetup() {
        return this.allLsmStorrage.getTaSetup();
    }

    public void storeTASetup(int n, int n2, boolean bl) {
        this.allLsmStorrage.storeTASetup(new int[]{n, n2, bl ? 1 : 0});
    }

    public int[] loadSDARSSetup() {
        return this.allLsmStorrage.getSdarsSetup();
    }

    public void storeSDARSSetup(int[] nArray) {
        this.allLsmStorrage.storeSdarsSetup(nArray);
    }

    public SimpleIntIntMap loadSDARSFilterStates() {
        return this.allLsmStorrage.getSdarsCatFilter();
    }

    public void storeSDARSFilterStates(SimpleIntIntMap simpleIntIntMap) {
        this.allLsmStorrage.storeSdarsCatFilter(simpleIntIntMap);
    }

    public SimpleIntIntMap loadDABListLM() {
        return this.allLsmStorrage.getDABListLsm();
    }

    public void storeDABListLM(SimpleIntIntMap simpleIntIntMap) {
        this.allLsmStorrage.storeDabListLsm(simpleIntIntMap);
    }

    public int[] loadDABSetup() {
        return this.allLsmStorrage.getDABSetup();
    }

    public void storeDABSetup(int[] nArray, boolean bl) {
        this.allLsmStorrage.storeDabSetup(nArray);
    }

    public int loadPreferredImageType() {
        if (Utilities.isPGen1OrBentley()) {
            return 0;
        }
        if (!Utilities.isEvoHigh() && !Utilities.isNARBuild()) {
            return 2;
        }
        return this.allLsmStorrage.getPreferredImageType();
    }

    public void storePreferredImageType(int n) {
        this.allLsmStorrage.storePreferredImageType(n);
    }

    public boolean loadGracenoteOnlineLookup() {
        return this.allLsmStorrage.getGracenoteOnlineLookup();
    }

    public void storeGracenoteOnlineLookup(boolean bl) {
        this.allLsmStorrage.storeGracenoteOnlineLookup(bl);
    }

    public void storeShowRadioText(boolean bl) {
        this.allLsmStorrage.storeShowRadioText(bl);
    }

    public boolean isShowRadioText() {
        return this.allLsmStorrage.isShowRadioText();
    }

    public void storeAmfmView(int n) {
        this.allLsmStorrage.storeAmfmView(n);
    }

    public int getAmfmView() {
        return this.allLsmStorrage.getAmfmView();
    }

    public void storePresetBank(int n) {
        this.allLsmStorrage.storePresetBank(n);
    }

    public int getPresetBank() {
        return this.allLsmStorrage.getPresetBank();
    }

    public int loadDatabaseCountry() {
        return this.allLsmStorrage.getDatabaseCountry();
    }

    public void storeDatabaseCountry(int n) {
        this.allLsmStorrage.storeDatabaseCountry(n);
    }

    public int loadDatabaseActivated() {
        return this.allLsmStorrage.getDatabaseActivated();
    }

    public void storeDatabaseActivated(int n) {
        this.allLsmStorrage.setDatabaseActivated(n);
    }

    public boolean loadSlideshowEnabled() {
        return this.allLsmStorrage.isSlideshowEnabled();
    }

    public void storeSlideshowEnabled(boolean bl) {
        this.allLsmStorrage.setSlideshowEnabled(bl);
    }

    public boolean loadSuppressTAPopup() {
        return this.allLsmStorrage.isSuppressTAPopup();
    }

    public void storeSupressTAPopup(boolean bl) {
        this.allLsmStorrage.setSuppressTAPopup(bl);
    }

    public int[] loadListOrCoverflowViewSetting() {
        return this.allLsmStorrage.getListOrCoverflowViewSetting();
    }

    public void storeListOrCoverflowViewSetting(int[] nArray) {
        this.allLsmStorrage.setListOrCoverflowViewSetting(nArray);
    }

    public void storePsFreezeDB(byte[] byArray) {
        Utilities.getStorageManager().setByteArray(1001, 310, byArray);
        this.logger.main.log(-2137614336, "[TunerStorage.storePsFreezeDB length %1", (long)byArray.length);
    }

    public byte[] loadPsFreezeDB() {
        byte[] byArray = Utilities.getStorageManager().getByteArray(1001, 310, new byte[0]);
        this.logger.main.log(-2137614336, "[TunerStorage#loadPsFreeze] length %1", (long)byArray.length);
        return byArray;
    }

    public void storeHistoryList(AbstractMemoryRow[] abstractMemoryRowArray) {
        this.logger.main.log(-2137614336, "[TunerStorage.storeHistoryList]");
        this.memoryListStorage.writeList(13, abstractMemoryRowArray);
    }

    public AbstractMemoryRow[] loadHistoryList(ILogoDatabase iLogoDatabase) {
        return this.memoryListStorage.readList(13, iLogoDatabase);
    }
}

