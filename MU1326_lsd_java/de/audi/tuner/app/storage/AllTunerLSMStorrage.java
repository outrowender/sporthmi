/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.storage;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.storage.AbstractStorageDataContainer;
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
import de.audi.tuner.app.storage.SerializingHelpers;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.esolutions.fw.util.commons.SimpleIntIntMap;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radio.UnifiedStation;
import org.dsi.ifc.sdars.StationInfo;

public class AllTunerLSMStorrage {
    private static final int VERSION = 10;
    public static final int INDEX_FM = 0;
    public static final int INDEX_AM = 1;
    public static final int INDEX_TI = 2;
    public static final int AMFMVIEW_SHOW_STATIONNAME = 0;
    public static final int AMFMVIEW_SHOW_FREQUENCY = 1;
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
            StorageDataContainer storageDataContainer = new StorageDataContainer();
            storageDataContainer.readAndDeserialize();
        }
        this.logger.startup.log(10000000, "[AllTunerLSMStorrage.AllTunerLSMStorrage] read persistence %1 ms", System.currentTimeMillis() - l);
        if (this.logger.startup.isDebug2()) {
            this.dump();
        }
    }

    private void dump() {
        this.logger.startup.log(100000000, "list: %1 Band: %2", (long)this.lsmList, (long)this.lsmBand);
        this.logger.startup.log(100000000, "FM %1", (Object)this.stations[0]);
        this.logger.startup.log(100000000, "AM %1", (Object)this.stations[1]);
        this.logger.startup.log(100000000, "TI %1", (Object)this.stations[2]);
        this.logger.startup.log(100000000, "AmFm Setup %1", (Object)this.amFmSetup);
        this.logger.startup.log(100000000, "DAB Ensemble %1", (Object)this.dabLsm.ensemble);
        this.logger.startup.log(100000000, "DAB Service %1", (Object)this.dabLsm.service);
        this.logger.startup.log(100000000, "DAB Component %1", (Object)this.dabLsm.component);
        this.logger.startup.log(100000000, "DAB Setup", (Object)this.dabSetup);
        this.logger.startup.log(100000000, "DAB List Keys %1", (Object)this.ensState.getKeys());
        this.logger.startup.log(100000000, "DAB List Vals %1", (Object)this.ensState.getValues());
        this.logger.startup.log(100000000, "Uni %1", (Object)this.uniLsm);
        this.logger.startup.log(100000000, "SDARS %1", (Object)this.sdarsLsm);
        this.logger.startup.log(100000000, "SDARS Setup %1", (Object)this.sdarsSetup);
        this.logger.startup.log(100000000, "TA %1", (Object)this.taSetup);
        this.logger.startup.log(100000000, "Preferred Img type %1", (long)this.prefImgType);
        this.logger.startup.log(100000000, "Gracenote Online Lookup %1", this.gracenoteLookup);
        this.logger.startup.log(100000000, "HdTuner %1", this.isAmFmHd);
        this.logger.startup.log(100000000, "LogoDB Country %1", (long)this.databaseCountry);
        this.logger.startup.log(100000000, "slideshowEnabled %1", this.slideshowEnabled);
        this.logger.startup.log(100000000, "suppressTAPopup %1", this.suppressTAPopup);
        this.logger.startup.log(100000000, "listOrCoverflowViewSetting %1", (Object)this.listOrCoverflowViewSetting);
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
        this.logger.main.log(10000000, "[AllTunerLSMStorrage.storeAmFmLsm]");
        this.logger.main.log(100000000, "[AllTunerLSMStorrage.storeAmFmLsm] Saving %1", (Object)aMFMStation);
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
        this.logger.main.log(100000000, "[AllTunerLSMStorrage.storeAmFmLsm] Serialization necessary? %1", (Object)(bl ? "true" : "false"));
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
        this.logger.dabDSI.log(10000000, "[AllTunerLSMStorrage.storeDabLsm] store DAB station %1", (Object)dabStation);
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
            this.logger.main.log(10000000, "[AllTunerLSMStorrage.storeUniLsm]");
            this.logger.main.log(100000000, "[AllTunerLSMStorrage.storeUniLsm] Saving %1", (Object)unifiedStationExt);
        }
        this.uniLsm = unifiedStationExt;
        this.write();
    }

    public UnifiedStationExt getUniLsm() {
        return this.uniLsm;
    }

    synchronized void storeSdarsLsm(StationInfoExt stationInfoExt) {
        this.logger.sdarsDSI.log(10000000, "[AllTunerLSMStorrage.storeSdarsLsm] store sdars station %1", (Object)stationInfoExt);
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
        StorageDataContainer storageDataContainer = new StorageDataContainer();
        storageDataContainer.serializeAndWrite();
    }

    private UnifiedStationExt deserialzieUniLsmOld(DataInputStream dataInputStream) throws IOException {
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
            return new UnifiedStationExt(new UnifiedStation("", "", 88300L, 0, 0, 0, 0, 1, false, 0, 1, new byte[]{0}, false, false, false, false, new ResourceLocator(), false));
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
        this.stations[0].frequency = 88300L;
        this.stations[0].waveband = 1;
        this.stations[1] = new AMFMStation();
        this.stations[1].frequency = 540L;
        this.stations[1].waveband = 3;
        this.stations[2] = new AMFMStation();
        this.stations[2].frequency = 1620L;
        this.stations[2].waveband = 3;
        this.amFmSetup = AMFMSetupHandler.getDefaultSetup();
        EnsembleInfo ensembleInfo = new EnsembleInfo(0, 0, "Ens 0", "Ensemble 0", "", 0, false, false);
        ServiceInfo serviceInfo = new ServiceInfo(0, 0, 1L, "NoSer", "No Service", new byte[]{0}, false, false);
        ComponentInfo componentInfo = new ComponentInfo(0, 0, 1L, 0, "", "", true, false);
        this.dabLsm = new DabStation(ensembleInfo, serviceInfo, componentInfo);
        this.dabSetup = DABSetupHandler.getDefaultSetup();
        this.ensState = new SimpleIntIntMap(10);
        this.uniLsm = new UnifiedStationExt(new UnifiedStation("", "", 88300L, 0, 0, 0, 0, 1, false, 0, 1, new byte[]{0}, false, false, false, false, new ResourceLocator(), false));
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

    static /* synthetic */ int[] access$2402(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.listOrCoverflowViewSetting = nArray;
        return nArray;
    }

    static /* synthetic */ AMFMStation[] access$402(AllTunerLSMStorrage allTunerLSMStorrage, AMFMStation[] aMFMStationArray) {
        allTunerLSMStorrage.stations = aMFMStationArray;
        return aMFMStationArray;
    }

    static /* synthetic */ int[] access$502(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.amFmSetup = nArray;
        return nArray;
    }

    static /* synthetic */ int[] access$702(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.dabSetup = nArray;
        return nArray;
    }

    static /* synthetic */ int[] access$1102(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.sdarsSetup = nArray;
        return nArray;
    }

    static /* synthetic */ int[] access$1302(AllTunerLSMStorrage allTunerLSMStorrage, int[] nArray) {
        allTunerLSMStorrage.taSetup = nArray;
        return nArray;
    }

    private class StorageDataContainer
    extends AbstractStorageDataContainer {
        public StorageDataContainer() {
            super(AllTunerLSMStorrage.this.storageAccess, 10, 1001, Utilities.isPGen1OrBentley() ? 30 : 29);
        }

        protected void handleCRC32Error() {
            ((AllTunerLSMStorrage)AllTunerLSMStorrage.this).logger.main.log(10000, "[AllTunerLSMStorrage.handleCRC32Error]");
            AllTunerLSMStorrage.this.defaultValues();
        }

        protected void handleStorageReadError(Exception exception) {
            ((AllTunerLSMStorrage)AllTunerLSMStorrage.this).logger.main.log(10000, "[AllTunerLSMStorrage.handleStorageReadError]: %1", (Object)exception.toString());
            AllTunerLSMStorrage.this.defaultValues();
        }

        protected void convertContainer(int n, int n2, DataInputStream dataInputStream) throws IOException {
            ((AllTunerLSMStorrage)AllTunerLSMStorrage.this).logger.main.log(10000, "[AllTunerLSMStorrage.convertContainer] persisted:%1 container:%2", (long)n, (long)n2);
            AllTunerLSMStorrage.this.defaultValues();
            switch (n) {
                case 9: {
                    this.deserializeV9(dataInputStream);
                    break;
                }
                case 8: {
                    this.deserializeV8(dataInputStream);
                    break;
                }
                case 7: {
                    this.deserializeV7(dataInputStream);
                    break;
                }
                case 6: {
                    this.deserializeV6(dataInputStream);
                    break;
                }
                case 5: {
                    this.deserializeV5(dataInputStream);
                    break;
                }
                case 4: {
                    this.deserializeV4(dataInputStream);
                    break;
                }
                case 3: {
                    this.deserializeV3(dataInputStream);
                    break;
                }
                case 2: {
                    this.deserializeV2(dataInputStream);
                    break;
                }
            }
        }

        protected void serialize(DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(AllTunerLSMStorrage.this.lsmList);
            dataOutputStream.writeInt(AllTunerLSMStorrage.this.lsmBand);
            dataOutputStream.writeInt(8);
            SerializingHelpers.serializeAmFm(dataOutputStream, AllTunerLSMStorrage.this.stations[0]);
            SerializingHelpers.serializeAmFm(dataOutputStream, AllTunerLSMStorrage.this.stations[1]);
            SerializingHelpers.serializeAmFm(dataOutputStream, AllTunerLSMStorrage.this.stations[2]);
            this.serializeIntArray(AllTunerLSMStorrage.this.amFmSetup, dataOutputStream);
            SerializingHelpers.serializeDab(dataOutputStream, AllTunerLSMStorrage.this.dabLsm);
            this.serializeIntArray(AllTunerLSMStorrage.this.dabSetup, dataOutputStream);
            int[] nArray = AllTunerLSMStorrage.this.ensState.getKeys();
            int[] nArray2 = AllTunerLSMStorrage.this.ensState.getValues();
            this.serializeIntArray(nArray, dataOutputStream);
            this.serializeIntArray(nArray2, dataOutputStream);
            SerializingHelpers.serializeUni(dataOutputStream, AllTunerLSMStorrage.this.uniLsm);
            SerializingHelpers.serializeSdars(dataOutputStream, AllTunerLSMStorrage.this.sdarsLsm);
            this.serializeIntArray(AllTunerLSMStorrage.this.sdarsSetup, dataOutputStream);
            nArray = AllTunerLSMStorrage.this.sdarsCatFilter.getKeys();
            nArray2 = AllTunerLSMStorrage.this.sdarsCatFilter.getValues();
            this.serializeIntArray(nArray, dataOutputStream);
            this.serializeIntArray(nArray2, dataOutputStream);
            this.serializeIntArray(AllTunerLSMStorrage.this.taSetup, dataOutputStream);
            dataOutputStream.writeInt(AllTunerLSMStorrage.this.prefImgType);
            dataOutputStream.writeBoolean(AllTunerLSMStorrage.this.gracenoteLookup);
            dataOutputStream.writeBoolean(AllTunerLSMStorrage.this.isAmFmHd);
            dataOutputStream.writeBoolean(AllTunerLSMStorrage.this.showRadioText);
            dataOutputStream.writeInt(AllTunerLSMStorrage.this.presetBank);
            dataOutputStream.writeInt(AllTunerLSMStorrage.this.amfmView);
            dataOutputStream.writeInt(AllTunerLSMStorrage.this.databaseCountry);
            dataOutputStream.writeInt(AllTunerLSMStorrage.this.databaseActivated);
            dataOutputStream.writeBoolean(AllTunerLSMStorrage.this.slideshowEnabled);
            dataOutputStream.writeBoolean(AllTunerLSMStorrage.this.suppressTAPopup);
            this.serializeIntArray(AllTunerLSMStorrage.this.listOrCoverflowViewSetting, dataOutputStream);
        }

        protected void deserialize(DataInputStream dataInputStream) throws IOException {
            this.deserializeV10(dataInputStream);
        }

        private void deserializeV10(DataInputStream dataInputStream) throws IOException {
            this.deserializeV9(dataInputStream);
            AllTunerLSMStorrage.access$2402(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
        }

        private void deserializeV9(DataInputStream dataInputStream) throws IOException {
            this.deserializeV8(dataInputStream);
            AllTunerLSMStorrage.this.suppressTAPopup = dataInputStream.readBoolean();
        }

        private void deserializeV8(DataInputStream dataInputStream) throws IOException {
            this.deserializeV7(dataInputStream);
            AllTunerLSMStorrage.this.slideshowEnabled = dataInputStream.readBoolean();
        }

        private void deserializeV7(DataInputStream dataInputStream) throws IOException {
            this.deserializeV6(dataInputStream);
            AllTunerLSMStorrage.this.databaseActivated = dataInputStream.readInt();
        }

        private void deserializeV6(DataInputStream dataInputStream) throws IOException {
            this.deserializeV5(dataInputStream);
            AllTunerLSMStorrage.this.databaseCountry = dataInputStream.readInt();
        }

        private void deserializeV5(DataInputStream dataInputStream) throws IOException {
            int n;
            AllTunerLSMStorrage.this.lsmList = dataInputStream.readInt();
            AllTunerLSMStorrage.this.lsmBand = dataInputStream.readInt();
            int n2 = dataInputStream.readInt();
            AllTunerLSMStorrage.access$402(AllTunerLSMStorrage.this, new AMFMStation[3]);
            ((AllTunerLSMStorrage)AllTunerLSMStorrage.this).stations[0] = SerializingHelpers.deserializeAMFM(dataInputStream, n2);
            ((AllTunerLSMStorrage)AllTunerLSMStorrage.this).stations[1] = SerializingHelpers.deserializeAMFM(dataInputStream, n2);
            ((AllTunerLSMStorrage)AllTunerLSMStorrage.this).stations[2] = SerializingHelpers.deserializeAMFM(dataInputStream, n2);
            AllTunerLSMStorrage.access$502(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            AllTunerLSMStorrage.this.dabLsm = SerializingHelpers.deserializeDAB(dataInputStream, n2);
            AllTunerLSMStorrage.access$702(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            int[] nArray = this.deserializeIntArray(dataInputStream);
            int[] nArray2 = this.deserializeIntArray(dataInputStream);
            AllTunerLSMStorrage.this.ensState = new SimpleIntIntMap(nArray.length + 10);
            for (n = 0; n < nArray.length; ++n) {
                AllTunerLSMStorrage.this.ensState.add(nArray[n], nArray2[n]);
            }
            AllTunerLSMStorrage.this.uniLsm = SerializingHelpers.deserializeUni(dataInputStream, n2);
            AllTunerLSMStorrage.this.sdarsLsm = SerializingHelpers.deserializeSDARS(dataInputStream);
            AllTunerLSMStorrage.access$1102(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            nArray = this.deserializeIntArray(dataInputStream);
            nArray2 = this.deserializeIntArray(dataInputStream);
            AllTunerLSMStorrage.this.sdarsCatFilter = new SimpleIntIntMap(nArray.length + 10);
            for (n = 0; n < nArray.length; ++n) {
                AllTunerLSMStorrage.this.sdarsCatFilter.add(nArray[n], nArray2[n]);
            }
            AllTunerLSMStorrage.access$1302(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            AllTunerLSMStorrage.this.prefImgType = dataInputStream.readInt();
            AllTunerLSMStorrage.this.gracenoteLookup = dataInputStream.readBoolean();
            AllTunerLSMStorrage.this.isAmFmHd = dataInputStream.readBoolean();
            AllTunerLSMStorrage.this.showRadioText = dataInputStream.readBoolean();
            AllTunerLSMStorrage.this.presetBank = dataInputStream.readInt();
            AllTunerLSMStorrage.this.amfmView = dataInputStream.readInt();
        }

        private void deserializeV2(DataInputStream dataInputStream) throws IOException {
            int n;
            AllTunerLSMStorrage.this.lsmList = dataInputStream.readInt();
            AllTunerLSMStorrage.this.lsmBand = dataInputStream.readInt();
            AllTunerLSMStorrage.access$402(AllTunerLSMStorrage.this, this.deserialzieAmFmLsmOld(dataInputStream));
            AllTunerLSMStorrage.access$502(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            this.deserializeDabLsmOld(dataInputStream);
            AllTunerLSMStorrage.access$702(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            int[] nArray = this.deserializeIntArray(dataInputStream);
            int[] nArray2 = this.deserializeIntArray(dataInputStream);
            AllTunerLSMStorrage.this.ensState = new SimpleIntIntMap(nArray.length + 10);
            for (n = 0; n < nArray.length; ++n) {
                AllTunerLSMStorrage.this.ensState.add(nArray[n], nArray2[n]);
            }
            AllTunerLSMStorrage.this.uniLsm = AllTunerLSMStorrage.this.deserialzieUniLsmOld(dataInputStream);
            AllTunerLSMStorrage.this.sdarsLsm = this.deserializeSdarsLsmOld(dataInputStream);
            AllTunerLSMStorrage.access$1102(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            nArray = this.deserializeIntArray(dataInputStream);
            nArray2 = this.deserializeIntArray(dataInputStream);
            AllTunerLSMStorrage.this.sdarsCatFilter = new SimpleIntIntMap(nArray.length + 10);
            for (n = 0; n < nArray.length; ++n) {
                AllTunerLSMStorrage.this.sdarsCatFilter.add(nArray[n], nArray2[n]);
            }
            AllTunerLSMStorrage.access$1302(AllTunerLSMStorrage.this, this.deserializeIntArray(dataInputStream));
            AllTunerLSMStorrage.this.prefImgType = dataInputStream.readInt();
            AllTunerLSMStorrage.this.gracenoteLookup = dataInputStream.readBoolean();
        }

        private void deserializeV3(DataInputStream dataInputStream) throws IOException {
            this.deserializeV2(dataInputStream);
            AllTunerLSMStorrage.this.isAmFmHd = dataInputStream.readBoolean();
        }

        private void deserializeV4(DataInputStream dataInputStream) throws IOException {
            this.deserializeV3(dataInputStream);
            AllTunerLSMStorrage.this.showRadioText = dataInputStream.readBoolean();
            AllTunerLSMStorrage.this.presetBank = dataInputStream.readInt();
            AllTunerLSMStorrage.this.amfmView = dataInputStream.readInt();
        }

        private StationInfoExt deserializeSdarsLsmOld(DataInputStream dataInputStream) throws IOException {
            StationInfoExt stationInfoExt = new StationInfoExt();
            stationInfoExt.sID = dataInputStream.readInt();
            stationInfoExt.stationNumber = (short)dataInputStream.readInt();
            stationInfoExt.categoryNumber = (short)dataInputStream.readInt();
            stationInfoExt.fullLabel = dataInputStream.readUTF();
            stationInfoExt.shortLabel = dataInputStream.readUTF();
            String string = dataInputStream.readUTF();
            int n = dataInputStream.readInt();
            stationInfoExt.setStationArt(new HMIResourceLocator(n, string));
            stationInfoExt.subscription = 2;
            return stationInfoExt;
        }

        private AMFMStation[] deserialzieAmFmLsmOld(DataInputStream dataInputStream) throws IOException {
            AMFMStation[] aMFMStationArray = new AMFMStation[3];
            aMFMStationArray[0] = new AMFMStation();
            aMFMStationArray[0].waveband = 1;
            aMFMStationArray[0].frequency = dataInputStream.readInt();
            aMFMStationArray[0].pi = dataInputStream.readInt();
            aMFMStationArray[0].rds = dataInputStream.readBoolean();
            aMFMStationArray[0].serviceId = dataInputStream.readInt();
            aMFMStationArray[0].name = dataInputStream.readUTF();
            aMFMStationArray[0].shortNameHD = dataInputStream.readUTF();
            aMFMStationArray[0].longNameHD = dataInputStream.readUTF();
            aMFMStationArray[0].hd = dataInputStream.readBoolean();
            aMFMStationArray[0].setHdStructure(1 | aMFMStationArray[0].serviceId);
            aMFMStationArray[1] = new AMFMStation();
            aMFMStationArray[1].waveband = 3;
            aMFMStationArray[1].frequency = dataInputStream.readInt();
            aMFMStationArray[1].pi = -1;
            aMFMStationArray[1].name = dataInputStream.readUTF();
            aMFMStationArray[1].shortNameHD = dataInputStream.readUTF();
            aMFMStationArray[1].longNameHD = dataInputStream.readUTF();
            aMFMStationArray[2] = new AMFMStation();
            aMFMStationArray[2].waveband = 3;
            aMFMStationArray[2].frequency = dataInputStream.readInt();
            aMFMStationArray[2].pi = -1;
            return aMFMStationArray;
        }

        private void deserializeDabLsmOld(DataInputStream dataInputStream) throws IOException {
            EnsembleInfo ensembleInfo = new EnsembleInfo();
            ensembleInfo.ensID = dataInputStream.readInt();
            ensembleInfo.ensECC = dataInputStream.readInt();
            ensembleInfo.frequencyValue = dataInputStream.readInt();
            ensembleInfo.fullName = dataInputStream.readUTF();
            ensembleInfo.shortName = dataInputStream.readUTF();
            ServiceInfo serviceInfo = new ServiceInfo();
            serviceInfo.ensID = ensembleInfo.ensID;
            serviceInfo.ensECC = ensembleInfo.ensECC;
            serviceInfo.sID = dataInputStream.readInt();
            serviceInfo.fullName = dataInputStream.readUTF();
            serviceInfo.shortName = dataInputStream.readUTF();
            serviceInfo.ptyCodes = new byte[]{0};
            ComponentInfo componentInfo = new ComponentInfo();
            componentInfo.ensID = ensembleInfo.ensID;
            componentInfo.ensECC = ensembleInfo.ensECC;
            componentInfo.sID = serviceInfo.sID;
            componentInfo.sCIDI = dataInputStream.readInt();
            componentInfo.primaryService = dataInputStream.readBoolean();
            componentInfo.fullName = dataInputStream.readUTF();
            componentInfo.shortName = dataInputStream.readUTF();
            AllTunerLSMStorrage.this.dabLsm = new DabStation(ensembleInfo, serviceInfo, componentInfo);
        }
    }
}

