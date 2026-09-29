/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.storage.IStorageAccess;
import de.audi.tuner.app.GlobalOptionsMngr;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMSetupHandler;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DABSetupHandler;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.sdars.SDARSSetupHandler;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.storage.AllTunerLSMStorrage$StorageDataContainer;
import de.audi.tuner.app.storage.SerializingHelpers;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.io.DataInputStream;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.UnifiedStation;
import org.dsi.ifc.sdars.StationInfo;

public class AllTunerLSMStorrage {
    private static final int VERSION;
    public static final int INDEX_FM;
    public static final int INDEX_AM;
    public static final int INDEX_TI;
    public static final int AMFMVIEW_SHOW_STATIONNAME;
    public static final int AMFMVIEW_SHOW_FREQUENCY;
    private final IStorageAccess storageAccess;
    private final Logger logger;
    private volatile int lsmBand;
    private volatile int lsmList;
    private volatile AMFMStation[] stations = new AMFMStation[3];
    private volatile int[] amFmSetup;
    private volatile DabStation dabLsm;
    private volatile int[] dabSetup;
    private volatile SimpleIntIntMap sdarsCatFilter = new SimpleIntIntMap();
    private volatile UnifiedStationExt uniLsm;
    private volatile SimpleIntIntMap ensState = new SimpleIntIntMap();
    private volatile StationInfoExt sdarsLsm;
    private volatile int[] sdarsSetup;
    private volatile int[] taSetup;
    private volatile int prefImgType;
    private volatile boolean gracenoteLookup;
    private volatile boolean isAmFmHd;
    private volatile boolean showRadioText;
    private volatile int presetBank;
    private volatile int amfmView;
    private volatile int databaseCountry = 1;
    private volatile int databaseActivated = 1;
    private volatile boolean slideshowEnabled = true;
    private volatile boolean suppressTAPopup = false;
    private volatile int[] listOrCoverflowViewSetting = new int[0];

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    AllTunerLSMStorrage(IStorageAccess iStorageAccess, TunerBasics tunerBasics) {
        this.storageAccess = iStorageAccess;
        this.logger = tunerBasics.getLogger();
        long l = System.currentTimeMillis();
        AllTunerLSMStorrage allTunerLSMStorrage = this;
        synchronized (allTunerLSMStorrage) {
            AllTunerLSMStorrage$StorageDataContainer allTunerLSMStorrage$StorageDataContainer = new AllTunerLSMStorrage$StorageDataContainer(this);
            allTunerLSMStorrage$StorageDataContainer.readAndDeserialize();
        }
        this.logger.startup.log(-2137614336, "[AllTunerLSMStorrage.AllTunerLSMStorrage] read persistence %1 ms", System.currentTimeMillis() - l);
        if (this.logger.startup.isDebug2()) {
            this.dump();
        }
    }

    private void dump() {
        this.logger.startup.log(14808325, "list: %1 Band: %2", (long)this.lsmList, (long)this.lsmBand);
        this.logger.startup.log(14808325, "FM %1", (Object)this.stations[0]);
        this.logger.startup.log(14808325, "AM %1", (Object)this.stations[1]);
        this.logger.startup.log(14808325, "TI %1", (Object)this.stations[2]);
        this.logger.startup.log(14808325, "AmFm Setup %1", (Object)this.amFmSetup);
        this.logger.startup.log(14808325, "DAB Ensemble %1", (Object)this.dabLsm.ensemble);
        this.logger.startup.log(14808325, "DAB Service %1", (Object)this.dabLsm.service);
        this.logger.startup.log(14808325, "DAB Component %1", (Object)this.dabLsm.component);
        this.logger.startup.log(14808325, "DAB Setup", (Object)this.dabSetup);
        this.logger.startup.log(14808325, "DAB List Keys %1", (Object)this.ensState.getKeys());
        this.logger.startup.log(14808325, "DAB List Vals %1", (Object)this.ensState.getValues());
        this.logger.startup.log(14808325, "Uni %1", (Object)this.uniLsm);
        this.logger.startup.log(14808325, "SDARS %1", (Object)this.sdarsLsm);
        this.logger.startup.log(14808325, "SDARS Setup %1", (Object)this.sdarsSetup);
        this.logger.startup.log(14808325, "TA %1", (Object)this.taSetup);
        this.logger.startup.log(14808325, "Preferred Img type %1", (long)this.prefImgType);
        this.logger.startup.log(14808325, "Gracenote Online Lookup %1", this.gracenoteLookup);
        this.logger.startup.log(14808325, "HdTuner %1", this.isAmFmHd);
        this.logger.startup.log(14808325, "LogoDB Country %1", (long)this.databaseCountry);
        this.logger.startup.log(14808325, "slideshowEnabled %1", this.slideshowEnabled);
        this.logger.startup.log(14808325, "suppressTAPopup %1", this.suppressTAPopup);
        this.logger.startup.log(14808325, "listOrCoverflowViewSetting %1", (Object)this.listOrCoverflowViewSetting);
    }

    synchronized void storeLastMode(int n, int n2) {
        this.lsmBand = n2;
        this.lsmList = n;
        this.write();
    }

    public int[] getLastMode() {
        return new int[]{this.lsmList, this.lsmBand};
    }

    synchronized void storeAmFmLsm(AMFMStation aMFMStation, int n) {
        this.logger.main.log(-2137614336, "[AllTunerLSMStorrage.storeAmFmLsm]");
        this.logger.main.log(14808325, "[AllTunerLSMStorrage.storeAmFmLsm] Saving %1", (Object)aMFMStation);
        boolean bl = false;
        AMFMStation aMFMStation2 = null;
        switch (n) {
            case 1: {
                aMFMStation2 = this.stations[0];
                this.stations[0] = aMFMStation;
                bl = aMFMStation2.frequency != aMFMStation.frequency || aMFMStation2.pi != aMFMStation.pi || aMFMStation2.serviceId != aMFMStation.serviceId || !aMFMStation2.name.equals(aMFMStation.name) || aMFMStation2.hd != aMFMStation.hd;
                break;
            }
            case 4: {
                aMFMStation2 = this.stations[1];
                this.stations[1] = aMFMStation;
                bl = aMFMStation2.frequency != aMFMStation.frequency || aMFMStation2.hd != aMFMStation.hd;
                break;
            }
            case 10: {
                aMFMStation2 = this.stations[2];
                this.stations[2] = aMFMStation;
                bl = aMFMStation2.frequency != aMFMStation.frequency;
                break;
            }
        }
        this.logger.main.log(14808325, "[AllTunerLSMStorrage.storeAmFmLsm] Serialization necessary? %1", (Object)(bl ? "true" : "false"));
        if (bl) {
            this.write();
        }
    }

    public AMFMStation[] getAmFmLsm() {
        return this.stations;
    }

    synchronized void storeAmFmSetup(int[] nArray) {
        this.amFmSetup = nArray;
        this.write();
    }

    public int[] getAmFmSetup() {
        return this.amFmSetup;
    }

    public boolean isAmFmHdTuner() {
        return this.isAmFmHd;
    }

    synchronized void storeHdTuner(boolean bl) {
        this.isAmFmHd = bl;
        this.write();
    }

    synchronized void storeDabLsm(DabStation dabStation) {
        this.dabLsm = dabStation;
        this.logger.dabDSI.log(-2137614336, "[AllTunerLSMStorrage.storeDabLsm] store DAB station %1", (Object)dabStation);
        this.write();
    }

    public DabStation getDABLsm() {
        return this.dabLsm;
    }

    synchronized void storeDabSetup(int[] nArray) {
        this.dabSetup = nArray;
        this.write();
    }

    public int[] getDABSetup() {
        return this.dabSetup;
    }

    synchronized void storeDabListLsm(SimpleIntIntMap simpleIntIntMap) {
        this.ensState = simpleIntIntMap;
        this.write();
    }

    public SimpleIntIntMap getDABListLsm() {
        return this.ensState;
    }

    synchronized void storeUniLsm(UnifiedStationExt unifiedStationExt) {
        if (unifiedStationExt.frequency == 0L) {
            this.logger.uniDSI.log(10000, "[AllTunerLSMStorrage.storeUniLsm] defect station %1", (Object)unifiedStationExt);
        } else {
            this.logger.main.log(-2137614336, "[AllTunerLSMStorrage.storeUniLsm]");
            this.logger.main.log(14808325, "[AllTunerLSMStorrage.storeUniLsm] Saving %1", (Object)unifiedStationExt);
        }
        this.uniLsm = unifiedStationExt;
        this.write();
    }

    public UnifiedStationExt getUniLsm() {
        return this.uniLsm;
    }

    synchronized void storeSdarsLsm(StationInfoExt stationInfoExt) {
        this.logger.sdarsDSI.log(-2137614336, "[AllTunerLSMStorrage.storeSdarsLsm] store sdars station %1", (Object)stationInfoExt);
        this.sdarsLsm = stationInfoExt;
        this.write();
    }

    public StationInfoExt getSdarsLsm() {
        return this.sdarsLsm;
    }

    synchronized void storeTASetup(int[] nArray) {
        this.taSetup = nArray;
        this.write();
    }

    public int[] getTaSetup() {
        return this.taSetup;
    }

    synchronized void storeSdarsSetup(int[] nArray) {
        this.sdarsSetup = nArray;
        this.write();
    }

    public int[] getSdarsSetup() {
        return this.sdarsSetup;
    }

    public void storeSdarsCatFilter(SimpleIntIntMap simpleIntIntMap) {
        this.sdarsCatFilter = simpleIntIntMap;
        this.write();
    }

    public SimpleIntIntMap getSdarsCatFilter() {
        return this.sdarsCatFilter;
    }

    public synchronized void storePreferredImageType(int n) {
        this.prefImgType = n;
        this.write();
    }

    public int getPreferredImageType() {
        return this.prefImgType;
    }

    public synchronized void storeGracenoteOnlineLookup(boolean bl) {
        this.gracenoteLookup = bl;
        this.write();
    }

    public boolean getGracenoteOnlineLookup() {
        return this.gracenoteLookup;
    }

    public synchronized void storeShowRadioText(boolean bl) {
        this.showRadioText = bl;
        this.write();
    }

    public boolean isShowRadioText() {
        return this.showRadioText;
    }

    public synchronized void storePresetBank(int n) {
        this.presetBank = n;
        this.write();
    }

    public int getPresetBank() {
        return this.presetBank;
    }

    public synchronized void storeAmfmView(int n) {
        this.amfmView = n;
        this.write();
    }

    public int getAmfmView() {
        return this.amfmView;
    }

    public int getDatabaseCountry() {
        return this.databaseCountry;
    }

    public void storeDatabaseCountry(int n) {
        this.databaseCountry = n;
        this.write();
    }

    public void setDatabaseActivated(int n) {
        this.databaseActivated = n;
        this.write();
    }

    public int getDatabaseActivated() {
        return this.databaseActivated;
    }

    public void setSlideshowEnabled(boolean bl) {
        this.slideshowEnabled = bl;
        this.write();
    }

    public boolean isSlideshowEnabled() {
        return this.slideshowEnabled;
    }

    public void setSuppressTAPopup(boolean bl) {
        this.suppressTAPopup = bl;
        this.write();
    }

    public boolean isSuppressTAPopup() {
        return this.suppressTAPopup;
    }

    public int[] getListOrCoverflowViewSetting() {
        return this.listOrCoverflowViewSetting;
    }

    public void setListOrCoverflowViewSetting(int[] nArray) {
        this.listOrCoverflowViewSetting = nArray;
        this.write();
    }

    private synchronized void write() {
        AllTunerLSMStorrage$StorageDataContainer allTunerLSMStorrage$StorageDataContainer = new AllTunerLSMStorrage$StorageDataContainer(this);
        allTunerLSMStorrage$StorageDataContainer.serializeAndWrite();
    }

    private UnifiedStationExt deserialzieUniLsmOld(DataInputStream dataInputStream) {
        UnifiedStationExt unifiedStationExt = new UnifiedStationExt();
        unifiedStationExt.shortName = dataInputStream.readUTF();
        unifiedStationExt.longName = dataInputStream.readUTF();
        unifiedStationExt.frequency = dataInputStream.readLong();
        unifiedStationExt.piSId = dataInputStream.readInt();
        unifiedStationExt.ensId = dataInputStream.readInt();
        unifiedStationExt.ecc = dataInputStream.readInt();
        unifiedStationExt.sCIDI = dataInputStream.readInt();
        unifiedStationExt.scrollingPS = dataInputStream.readInt();
        unifiedStationExt.rds = dataInputStream.readBoolean();
        unifiedStationExt.audioQuality = dataInputStream.readInt();
        unifiedStationExt.tpAvailability = dataInputStream.readInt();
        unifiedStationExt.ptyCodes = SerializingHelpers.deserializeByteArray(dataInputStream);
        unifiedStationExt.stationLogo = new ResourceLocator();
        if (unifiedStationExt.frequency == 0L) {
            this.logger.startup.log(10000, "[AllTunerLSMStorrage.deserialzieUniLsm] defect station read %1", (Object)unifiedStationExt);
            return new UnifiedStationExt(new UnifiedStation("", "", 0, 0, 0, 0, 0, 1, false, 0, 1, new byte[]{0}, false, false, false, false, new ResourceLocator(), false));
        }
        if (unifiedStationExt.ensId == 0) {
            unifiedStationExt.setAudioStatus(1);
        } else {
            unifiedStationExt.setAudioStatus(2);
        }
        return unifiedStationExt;
    }

    public void defaultValues() {
        this.lsmList = 1;
        this.lsmBand = 1;
        this.stations = new AMFMStation[3];
        this.stations[0] = new AMFMStation();
        this.stations[0].frequency = 0;
        this.stations[0].waveband = 1;
        this.stations[1] = new AMFMStation();
        this.stations[1].frequency = 0;
        this.stations[1].waveband = 3;
        this.stations[2] = new AMFMStation();
        this.stations[2].frequency = 0;
        this.stations[2].waveband = 3;
        this.amFmSetup = AMFMSetupHandler.getDefaultSetup();
        EnsembleInfo ensembleInfo = new EnsembleInfo(0, 0, "Ens 0", "Ensemble 0", "", 0, false, false);
        ServiceInfo serviceInfo = new ServiceInfo(0, 0, 1L, "NoSer", "No Service", new byte[]{0}, false, false);
        ComponentInfo componentInfo = new ComponentInfo(0, 0, 1L, 0, "", "", true, false);
        this.dabLsm = new DabStation(ensembleInfo, serviceInfo, componentInfo);
        this.dabSetup = DABSetupHandler.getDefaultSetup();
        this.ensState = new SimpleIntIntMap(10);
        this.uniLsm = new UnifiedStationExt(new UnifiedStation("", "", 0, 0, 0, 0, 0, 1, false, 0, 1, new byte[]{0}, false, false, false, false, new ResourceLocator(), false));
        StationInfo stationInfo = new StationInfo(1, 1, "fixme", "FIXME", 2, 0, false, new ResourceLocator());
        this.sdarsLsm = new StationInfoExt(stationInfo);
        this.sdarsSetup = SDARSSetupHandler.getDefaultSetup();
        this.sdarsCatFilter = new SimpleIntIntMap(60);
        this.taSetup = new int[]{0, 0, 0};
        this.prefImgType = GlobalOptionsMngr.getDefaultPreferedImgType();
        this.gracenoteLookup = true;
        this.isAmFmHd = false;
        byte by = Utilities.getFmBandsetting();
        this.showRadioText = !Utilities.isPGen1OrBentley() || by != 5 && by != 3 && by != 8 && by != 4;
        this.presetBank = 0;
        this.amfmView = Utilities.isSinglePiMode() ? 0 : 1;
        this.databaseCountry = 1;
        this.databaseActivated = Utilities.isPiIgnore() ? 0 : 1;
        this.slideshowEnabled = true;
        this.suppressTAPopup = false;
        this.listOrCoverflowViewSetting = new int[0];
    }

    static /* synthetic */ IStorageAccess access$000(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.storageAccess;
    }

    static /* synthetic */ Logger access$100(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.logger;
    }

    static /* synthetic */ int access$200(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.lsmList;
    }

    static /* synthetic */ int access$300(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.lsmBand;
    }

    static /* synthetic */ AMFMStation[] access$400(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.stations;
    }

    static /* synthetic */ int[] access$500(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.amFmSetup;
    }

    static /* synthetic */ DabStation access$600(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.dabLsm;
    }

    static /* synthetic */ int[] access$700(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.dabSetup;
    }

    static /* synthetic */ SimpleIntIntMap access$800(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.ensState;
    }

    static /* synthetic */ UnifiedStationExt access$900(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.uniLsm;
    }

    static /* synthetic */ StationInfoExt access$1000(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.sdarsLsm;
    }

    static /* synthetic */ int[] access$1100(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.sdarsSetup;
    }

    static /* synthetic */ SimpleIntIntMap access$1200(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.sdarsCatFilter;
    }

    static /* synthetic */ int[] access$1300(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.taSetup;
    }

    static /* synthetic */ int access$1400(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.prefImgType;
    }

    static /* synthetic */ boolean access$1500(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.gracenoteLookup;
    }

    static /* synthetic */ boolean access$1600(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.isAmFmHd;
    }

    static /* synthetic */ boolean access$1700(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.showRadioText;
    }

    static /* synthetic */ int access$1800(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.presetBank;
    }

    static /* synthetic */ int access$1900(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.amfmView;
    }

    static /* synthetic */ int access$2000(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.databaseCountry;
    }

    static /* synthetic */ int access$2100(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.databaseActivated;
    }

    static /* synthetic */ boolean access$2200(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.slideshowEnabled;
    }

    static /* synthetic */ boolean access$2300(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.suppressTAPopup;
    }

    static /* synthetic */ int[] access$2400(AllTunerLSMStorrage allTunerLSMStorrage) {
        return allTunerLSMStorrage.listOrCoverflowViewSetting;
    }

    static /* synthetic */ int[] access$2402(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.listOrCoverflowViewSetting = nArray;
        return nArray;
    }

    static /* synthetic */ boolean access$2302(AllTunerLSMStorrage allTunerLSMStorrage, boolean bl) {
        allTunerLSMStorrage.suppressTAPopup = bl;
        return allTunerLSMStorrage.suppressTAPopup;
    }

    static /* synthetic */ boolean access$2202(AllTunerLSMStorrage allTunerLSMStorrage, boolean bl) {
        allTunerLSMStorrage.slideshowEnabled = bl;
        return allTunerLSMStorrage.slideshowEnabled;
    }

    static /* synthetic */ int access$2102(AllTunerLSMStorrage allTunerLSMStorrage, int n) {
        allTunerLSMStorrage.databaseActivated = n;
        return allTunerLSMStorrage.databaseActivated;
    }

    static /* synthetic */ int access$2002(AllTunerLSMStorrage allTunerLSMStorrage, int n) {
        allTunerLSMStorrage.databaseCountry = n;
        return allTunerLSMStorrage.databaseCountry;
    }

    static /* synthetic */ int access$202(AllTunerLSMStorrage allTunerLSMStorrage, int n) {
        allTunerLSMStorrage.lsmList = n;
        return allTunerLSMStorrage.lsmList;
    }

    static /* synthetic */ int access$302(AllTunerLSMStorrage allTunerLSMStorrage, int n) {
        allTunerLSMStorrage.lsmBand = n;
        return allTunerLSMStorrage.lsmBand;
    }

    static /* synthetic */ AMFMStation[] access$402(AllTunerLSMStorrage allTunerLSMStorrage, AMFMStation[] aMFMStationArray) {
        allTunerLSMStorrage.stations = aMFMStationArray;
        return aMFMStationArray;
    }

    static /* synthetic */ int[] access$502(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.amFmSetup = nArray;
        return nArray;
    }

    static /* synthetic */ DabStation access$602(AllTunerLSMStorrage allTunerLSMStorrage, DabStation dabStation) {
        allTunerLSMStorrage.dabLsm = dabStation;
        return allTunerLSMStorrage.dabLsm;
    }

    static /* synthetic */ int[] access$702(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.dabSetup = nArray;
        return nArray;
    }

    static /* synthetic */ SimpleIntIntMap access$802(AllTunerLSMStorrage allTunerLSMStorrage, SimpleIntIntMap simpleIntIntMap) {
        allTunerLSMStorrage.ensState = simpleIntIntMap;
        return allTunerLSMStorrage.ensState;
    }

    static /* synthetic */ UnifiedStationExt access$902(AllTunerLSMStorrage allTunerLSMStorrage, UnifiedStationExt unifiedStationExt) {
        allTunerLSMStorrage.uniLsm = unifiedStationExt;
        return allTunerLSMStorrage.uniLsm;
    }

    static /* synthetic */ StationInfoExt access$1002(AllTunerLSMStorrage allTunerLSMStorrage, StationInfoExt stationInfoExt) {
        allTunerLSMStorrage.sdarsLsm = stationInfoExt;
        return allTunerLSMStorrage.sdarsLsm;
    }

    static /* synthetic */ int[] access$1102(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.sdarsSetup = nArray;
        return nArray;
    }

    static /* synthetic */ SimpleIntIntMap access$1202(AllTunerLSMStorrage allTunerLSMStorrage, SimpleIntIntMap simpleIntIntMap) {
        allTunerLSMStorrage.sdarsCatFilter = simpleIntIntMap;
        return allTunerLSMStorrage.sdarsCatFilter;
    }

    static /* synthetic */ int[] access$1302(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.taSetup = nArray;
        return nArray;
    }

    static /* synthetic */ int access$1402(AllTunerLSMStorrage allTunerLSMStorrage, int n) {
        allTunerLSMStorrage.prefImgType = n;
        return allTunerLSMStorrage.prefImgType;
    }

    static /* synthetic */ boolean access$1502(AllTunerLSMStorrage allTunerLSMStorrage, boolean bl) {
        allTunerLSMStorrage.gracenoteLookup = bl;
        return allTunerLSMStorrage.gracenoteLookup;
    }

    static /* synthetic */ boolean access$1602(AllTunerLSMStorrage allTunerLSMStorrage, boolean bl) {
        allTunerLSMStorrage.isAmFmHd = bl;
        return allTunerLSMStorrage.isAmFmHd;
    }

    static /* synthetic */ boolean access$1702(AllTunerLSMStorrage allTunerLSMStorrage, boolean bl) {
        allTunerLSMStorrage.showRadioText = bl;
        return allTunerLSMStorrage.showRadioText;
    }

    static /* synthetic */ int access$1802(AllTunerLSMStorrage allTunerLSMStorrage, int n) {
        allTunerLSMStorrage.presetBank = n;
        return allTunerLSMStorrage.presetBank;
    }

    static /* synthetic */ int access$1902(AllTunerLSMStorrage allTunerLSMStorrage, int n) {
        allTunerLSMStorrage.amfmView = n;
        return allTunerLSMStorrage.amfmView;
    }

    static /* synthetic */ UnifiedStationExt access$2500(AllTunerLSMStorrage allTunerLSMStorrage, DataInputStream dataInputStream) {
        return allTunerLSMStorrage.deserialzieUniLsmOld(dataInputStream);
    }
}

