/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rsdb;

import de.audi.atip.hmi.model.HMIResourceLocator;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.rsdb.CountryRegionMngr;
import de.audi.tuner.app.rsdb.IRSDBResult;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.rsdb.OutstandingRequest;
import de.audi.tuner.app.rsdb.RadioDBEntry;
import de.audi.tuner.app.rsdb.RadioDataDsi;
import de.audi.tuner.app.rsdb.RadioDataListenerImpl;
import de.audi.tuner.app.rsdb.RequestData;
import de.audi.tuner.app.rsdb.StrategyFive;
import de.audi.tuner.app.rsdb.StrategyOne;
import de.audi.tuner.app.rsdb.StrategyTwo;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.NullLogoDatabase;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.SimpleIntObjectMap;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class LogoDatabase
implements ILogoDatabase {
    public final LanguageManager.ILanguageChangeListener languageChangeListener = new LanguageChangeListener();
    private static final int MAX_ITEM_COUNT = 10;
    public static final int REQ_TYPE_COUNTRY_DETECT = 1;
    public static final int REQ_TYPE_STATION_DETECT = 2;
    public static final int REQ_TYPE_LOGO_REQUEST = 3;
    public static final int ACTIVATION_STATE_DEACTIVATED = 0;
    public static final int ACTIVATION_STATE_ACTIVATED = 1;
    private static final RadioStationData EMPTY_RADIO_DATA = LogoDatabase.nullCheck(new RadioStationData());
    private RadioDataDsi dsi;
    private final RadioDataListenerImpl radioDataListenerImpl;
    private int requestCount = 10;
    private final LogChannel lg;
    private final TunerStorage tunerStorage;
    private final ChoiceModelApp dbActivatedChoice;
    private final HashMap intDB = new HashMap(500);
    private final HashMap oldDB = new HashMap(500);
    private SimpleIntObjectMap outstandingRequests = new SimpleIntObjectMap(20);
    private boolean initialisationOk = false;
    private int settingsRegion = 1;
    private CountryRegionMngr countryRegionMngr;
    private String language;
    private Object mutex = new Object();
    private final StrategyTwo strategyTwo;
    private final StrategyOne strategyOne;
    private final StrategyFive strategyFive;
    private int lastDetectedCountry = 1;
    private IRadioDatabaseListener[] listeners = new IRadioDatabaseListener[0];
    private boolean[] runningReq = new boolean[16];
    private boolean[] skippedReq = new boolean[16];

    public LogoDatabase(TunerBasics tunerBasics, TunerStorage tunerStorage, LanguageManager languageManager) {
        this.dsi = new RadioDataDsi(tunerBasics);
        this.radioDataListenerImpl = new RadioDataListenerImpl(tunerBasics, this);
        this.lg = tunerBasics.getLogger().rsdb;
        this.settingsRegion = tunerStorage.loadDatabaseCountry();
        this.tunerStorage = tunerStorage;
        this.dbActivatedChoice = tunerBasics.getModels().getChoiceModel(100808);
        this.dbActivatedChoice.setValue(this.tunerStorage.loadDatabaseActivated());
        this.dbActivatedChoice.setChoiceListener(new ChoiceListener());
        this.countryRegionMngr = new CountryRegionMngr(this, tunerBasics, tunerStorage, languageManager);
        this.strategyOne = new StrategyOne(this.countryRegionMngr, this.lg);
        this.strategyTwo = new StrategyTwo(this.countryRegionMngr, this.lg);
        this.strategyFive = new StrategyFive(this.countryRegionMngr, this.lg);
    }

    public boolean isRealDatabase() {
        return true;
    }

    public void setDeviceService(DSIRadioData dSIRadioData) {
        this.dsi.setDeviceService(dSIRadioData);
    }

    public void init() {
        this.dsi.setNotification(new int[]{1}, this.radioDataListenerImpl);
    }

    public void addListener(IRadioDatabaseListener iRadioDatabaseListener) {
        IRadioDatabaseListener[] iRadioDatabaseListenerArray = new IRadioDatabaseListener[this.listeners.length + 1];
        System.arraycopy((Object)this.listeners, 0, (Object)iRadioDatabaseListenerArray, 0, this.listeners.length);
        iRadioDatabaseListenerArray[this.listeners.length] = iRadioDatabaseListener;
        this.listeners = iRadioDatabaseListenerArray;
    }

    public void setInitStatus(boolean bl) {
        if (this.initialisationOk != bl) {
            this.initialisationOk = bl;
            if (bl) {
                this.informDbReadyChanged();
            }
        }
    }

    private void informDbReadyChanged() {
        IRadioDatabaseListener[] iRadioDatabaseListenerArray = this.listeners;
        boolean bl = this.dbActivatedChoice.getValue() == 1;
        ILogoDatabase iLogoDatabase = bl ? this : NullLogoDatabase.INSTANCE;
        for (int i2 = 0; i2 < iRadioDatabaseListenerArray.length; ++i2) {
            iRadioDatabaseListenerArray[i2].databaseReady(iLogoDatabase);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setStatus(int n) {
        if (n == 2) {
            String string;
            this.dsi.requestCountryRegionData(424242);
            this.dsi.requestCountryListUpdate(434343);
            Object object = this.mutex;
            synchronized (object) {
                string = this.language;
            }
            if (!Utilities.isEmpty(string)) {
                this.dsi.requestCountryRegionTranslationData(-1, string, 444444);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void setSystemLanguage(String string) {
        Object object = this.mutex;
        synchronized (object) {
            this.language = string;
        }
        this.dsi.requestCountryRegionTranslationData(-1, string, 444444);
        this.countryRegionMngr.setSystemLanguage(string);
    }

    private void setActivated(int n) {
        this.dbActivatedChoice.setValue(n);
        this.tunerStorage.storeDatabaseActivated(n);
        this.informDbReadyChanged();
    }

    public RadioDataDsi getRadioDataDsi() {
        return this.dsi;
    }

    public RadioDataListenerImpl getRadioDataListener() {
        return this.radioDataListenerImpl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void requestDataById(TunerObjectContainer[] tunerObjectContainerArray, IRSDBResult iRSDBResult) {
        Serializable serializable;
        int n;
        int n2 = 0;
        OutstandingRequest outstandingRequest = new OutstandingRequest(3, tunerObjectContainerArray.length, iRSDBResult, 12);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            Object object;
            n = tunerObjectContainerArray[i2].getDbStationId();
            if (n == 0) continue;
            ++n2;
            serializable = new Long(tunerObjectContainerArray[i2].getRadioId());
            Object object2 = this.intDB;
            synchronized (object2) {
                object = this.intDB.get(serializable);
            }
            if (object == null) {
                object2 = new RadioStationDataRequest();
                ((RadioStationDataRequest)object2).maxItemCount = 1;
                ((RadioStationDataRequest)object2).stationId = n;
                ((RadioStationDataRequest)object2).useStationId = true;
                outstandingRequest.request.add(new RequestData((RadioStationDataRequest)object2, (Long)serializable, tunerObjectContainerArray[i2]));
                continue;
            }
            object2 = (RadioDBEntry)object;
            tunerObjectContainerArray[i2].setLogoFromDb(((RadioDBEntry)object2).stationLogo);
        }
        RadioStationLogoRequest[] radioStationLogoRequestArray = outstandingRequest.getDsiLogoReq();
        if (radioStationLogoRequestArray.length > 0) {
            this.lg.log(10000000, "[LD.requestDataById] send request size:%1 type:%2", (long)radioStationLogoRequestArray.length, (long)outstandingRequest.requestType);
            serializable = this.intDB;
            synchronized (serializable) {
                n = this.requestCount;
                this.requestCount += 10;
                this.outstandingRequests.add(n, outstandingRequest);
            }
            this.dsi.requestRadioStationLogos(radioStationLogoRequestArray, n);
        } else if (n2 > 0) {
            iRSDBResult.resultAvailable();
        } else {
            this.lg.log(10000000, "[LogoDatabase.requestAmFmData] request is empty");
        }
    }

    public void requestAmFmData(AMFMStation[] aMFMStationArray, IRSDBResult iRSDBResult) {
        if (!this.initialisationOk) {
            return;
        }
        OutstandingRequest outstandingRequest = this.createDatabaseRequest(aMFMStationArray, iRSDBResult);
        if (this.settingsRegion != 1 || aMFMStationArray.length < 2) {
            int n = this.settingsRegion != 1 ? this.settingsRegion : this.lastDetectedCountry;
            outstandingRequest = this.addStationDetectStrategy(n, outstandingRequest);
        }
        this.startRequest(outstandingRequest);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startRequest(OutstandingRequest outstandingRequest) {
        RadioStationDataRequest[] radioStationDataRequestArray = outstandingRequest.getDsiDataReq();
        if (radioStationDataRequestArray.length > 0) {
            this.lg.log(10000000, "[LogoDatabase.startRequest] send request size:%1 type:%2", (long)radioStationDataRequestArray.length, (long)outstandingRequest.requestType);
            int n = 0;
            HashMap hashMap = this.intDB;
            synchronized (hashMap) {
                if (this.isReqestAllowed(outstandingRequest)) {
                    n = this.requestCount;
                    this.requestCount += 10;
                    this.outstandingRequests.add(n, outstandingRequest);
                    this.runningReq[outstandingRequest.band] = true;
                } else {
                    this.lg.log(10000000, "[LogoDatabase.startRequest] skip request for list %1", (long)outstandingRequest.band);
                    this.skippedReq[outstandingRequest.band] = true;
                }
            }
            if (n != 0) {
                this.dsi.requestRadioStationData(radioStationDataRequestArray, n);
            }
        } else {
            this.lg.log(10000000, "[LogoDatabase.startRequest] request is empty");
        }
    }

    private boolean isReqestAllowed(OutstandingRequest outstandingRequest) {
        if (outstandingRequest.request.size() == 1) {
            return true;
        }
        return !this.runningReq[outstandingRequest.band];
    }

    public void requestUniData(UnifiedStationExt[] unifiedStationExtArray, IRSDBResult iRSDBResult) {
        if (!this.initialisationOk) {
            return;
        }
        OutstandingRequest outstandingRequest = this.createDatabaseRequest(unifiedStationExtArray, iRSDBResult);
        if (this.settingsRegion != 1 || unifiedStationExtArray.length < 2) {
            outstandingRequest = this.addStationDetectStrategy(this.settingsRegion, outstandingRequest);
        }
        this.startRequest(outstandingRequest);
    }

    public void requestDabData(DabStation[] dabStationArray, IRSDBResult iRSDBResult) {
        if (!this.initialisationOk) {
            return;
        }
        OutstandingRequest outstandingRequest = this.createStationDetectRequest(dabStationArray, iRSDBResult);
        this.startRequest(outstandingRequest);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private OutstandingRequest createDatabaseRequest(AMFMStation[] aMFMStationArray, IRSDBResult iRSDBResult) {
        OutstandingRequest outstandingRequest = new OutstandingRequest(1, aMFMStationArray.length, iRSDBResult, 1);
        for (int i2 = 0; i2 < aMFMStationArray.length; ++i2) {
            RadioDBEntry radioDBEntry;
            AMFMStation aMFMStation = aMFMStationArray[i2];
            Long l = new Long(aMFMStation.getUniqueId());
            RadioDBEntry radioDBEntry2 = null;
            Object object = this.intDB;
            synchronized (object) {
                radioDBEntry = (RadioDBEntry)this.intDB.get(l);
                if (radioDBEntry == null) {
                    radioDBEntry2 = (RadioDBEntry)this.oldDB.get(l);
                }
            }
            if (radioDBEntry == null && radioDBEntry2 == null) {
                object = new RadioStationDataRequest();
                ((RadioStationDataRequest)object).maxItemCount = 10;
                ((RadioStationDataRequest)object).frequency = aMFMStation.frequency;
                ((RadioStationDataRequest)object).piSid = aMFMStation.pi;
                ((RadioStationDataRequest)object).usePiSid = true;
                ((RadioStationDataRequest)object).useFrequency = !aMFMStation.isRds();
                ((RadioStationDataRequest)object).stationType = "FM";
                ((RadioStationDataRequest)object).useStationType = true;
                ((RadioStationDataRequest)object).shortName = aMFMStation.name;
                ((RadioStationDataRequest)object).useShortName = false;
                outstandingRequest.request.add(new RequestData((RadioStationDataRequest)object, l, new TunerObjectContainer(aMFMStation)));
                continue;
            }
            if (radioDBEntry2 != null) {
                object = new RadioStationDataRequest();
                ((RadioStationDataRequest)object).maxItemCount = 1;
                ((RadioStationDataRequest)object).stationId = radioDBEntry2.stationData.stationId;
                ((RadioStationDataRequest)object).useStationId = true;
                ((RadioStationDataRequest)object).shortName = aMFMStation.name;
                ((RadioStationDataRequest)object).useShortName = false;
                ((RadioStationDataRequest)object).frequency = aMFMStation.frequency;
                outstandingRequest.request.add(new RequestData((RadioStationDataRequest)object, l, new TunerObjectContainer(aMFMStation)));
                continue;
            }
            if (radioDBEntry == null || radioDBEntry.stationData == EMPTY_RADIO_DATA) continue;
            aMFMStation.setLogoFromDb(radioDBEntry.stationLogo);
            aMFMStation.setDatabaseId(radioDBEntry.stationData.stationId);
            if ((aMFMStation.isScrollingPS() || !aMFMStation.isRds()) && ((String)(object = this.getFmName(radioDBEntry))).length() > 0) {
                aMFMStation.name = object;
                aMFMStation.scrollingPS = false;
            }
            if (!radioDBEntry.isUnique) continue;
            outstandingRequest.countryFinder.add(radioDBEntry.stationData.country);
        }
        return outstandingRequest;
    }

    private String getFmName(RadioDBEntry radioDBEntry) {
        String string;
        boolean bl = this.countryRegionMngr.isLongNamePrefered(radioDBEntry.stationData.country);
        if (bl) {
            string = Utilities.isEmpty(radioDBEntry.stationData.longName) ? radioDBEntry.stationData.shortName : radioDBEntry.stationData.longName;
        } else {
            String string2 = string = Utilities.isEmpty(radioDBEntry.stationData.shortName) ? radioDBEntry.stationData.longName : radioDBEntry.stationData.shortName;
        }
        if ("-1".equals(string)) {
            this.lg.log(10000, "[LogoDatabase.getFmName] invalid name '-1' found for entry  %1", (Object)radioDBEntry.stationData);
        }
        return Utilities.isEmpty(string) ? "" : string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private OutstandingRequest createDatabaseRequest(UnifiedStationExt[] unifiedStationExtArray, IRSDBResult iRSDBResult) {
        OutstandingRequest outstandingRequest = new OutstandingRequest(1, unifiedStationExtArray.length, iRSDBResult, 11);
        for (int i2 = 0; i2 < unifiedStationExtArray.length; ++i2) {
            String string;
            Object object;
            UnifiedStationExt unifiedStationExt = unifiedStationExtArray[i2];
            if (unifiedStationExt.piSId == -1) continue;
            Long l = new Long(unifiedStationExt.getUniqueId());
            Object object2 = this.intDB;
            synchronized (object2) {
                object = this.intDB.get(l);
            }
            if (object == null) {
                object2 = new RadioStationDataRequest();
                ((RadioStationDataRequest)object2).maxItemCount = 10;
                ((RadioStationDataRequest)object2).piSid = unifiedStationExt.piSId;
                ((RadioStationDataRequest)object2).usePiSid = true;
                ((RadioStationDataRequest)object2).shortName = unifiedStationExt.shortName;
                ((RadioStationDataRequest)object2).useShortName = false;
                if (unifiedStationExt.ensId == 0) {
                    ((RadioStationDataRequest)object2).stationType = "FM";
                    ((RadioStationDataRequest)object2).useStationType = true;
                } else {
                    ((RadioStationDataRequest)object2).extendedCountryCode = unifiedStationExt.ecc;
                    ((RadioStationDataRequest)object2).useExtendedCountryCode = true;
                    ((RadioStationDataRequest)object2).ensembleId = unifiedStationExt.ensId;
                    if (unifiedStationExt.isComponent()) {
                        ((RadioStationDataRequest)object2).scidi = unifiedStationExt.sCIDI;
                        ((RadioStationDataRequest)object2).useScidi = true;
                    }
                    ((RadioStationDataRequest)object2).stationType = "DAB";
                    ((RadioStationDataRequest)object2).useStationType = true;
                }
                outstandingRequest.request.add(new RequestData((RadioStationDataRequest)object2, l, new TunerObjectContainer(unifiedStationExt)));
                continue;
            }
            object2 = (RadioDBEntry)object;
            unifiedStationExt.setLogoFromDb(((RadioDBEntry)object2).stationLogo);
            unifiedStationExt.setDatabaseId(((RadioDBEntry)object2).stationData.stationId);
            if ((unifiedStationExt.scrollingPS == 2 || unifiedStationExt.isAnalog() && !unifiedStationExt.rds) && (string = this.getFmName((RadioDBEntry)object2)).length() > 0) {
                unifiedStationExt.shortName = ((RadioDBEntry)object2).stationData.shortName;
                unifiedStationExt.scrollingPS = 1;
            }
            if (!((RadioDBEntry)object2).isUnique) continue;
            outstandingRequest.countryFinder.add(((RadioDBEntry)object2).stationData.country);
        }
        return outstandingRequest;
    }

    private OutstandingRequest addStationDetectStrategy(int n, OutstandingRequest outstandingRequest) {
        int n2 = this.countryRegionMngr.getStrategy(n);
        this.lg.log(100000000, "[LogoDatabase.addStationDetectStrategy] country %1, strategy %2", (long)n, (long)n2);
        switch (n2) {
            case 1: {
                return this.strategyOne.createStationDetectRequest(n, outstandingRequest);
            }
            case 2: {
                return this.strategyTwo.createStationDetectRequest(n, outstandingRequest);
            }
            case 5: {
                return this.strategyFive.createStationDetectRequest(n, outstandingRequest);
            }
        }
        this.lg.log(10000, "[LogoDatabase.addStationDetectStrategy] unsupported strategy %1", (long)this.countryRegionMngr.getStrategy(n));
        return new OutstandingRequest(2, 0, null, 8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private OutstandingRequest createStationDetectRequest(DabStation[] dabStationArray, IRSDBResult iRSDBResult) {
        OutstandingRequest outstandingRequest = new OutstandingRequest(2, dabStationArray.length, iRSDBResult, 5);
        for (int i2 = 0; i2 < dabStationArray.length; ++i2) {
            Object object;
            DabStation dabStation = dabStationArray[i2];
            Long l = new Long(dabStation.getUniqueId());
            Object object2 = this.intDB;
            synchronized (object2) {
                object = this.intDB.get(l);
            }
            if (object == null) {
                object2 = new RadioStationDataRequest();
                ((RadioStationDataRequest)object2).maxItemCount = 10;
                ((RadioStationDataRequest)object2).extendedCountryCode = dabStation.ensemble.ensECC;
                ((RadioStationDataRequest)object2).useExtendedCountryCode = true;
                ((RadioStationDataRequest)object2).piSid = (int)dabStation.service.sID;
                ((RadioStationDataRequest)object2).usePiSid = true;
                ((RadioStationDataRequest)object2).ensembleId = dabStation.ensemble.ensID;
                ((RadioStationDataRequest)object2).shortName = dabStation.getShortName();
                if (dabStation.isComponent()) {
                    ((RadioStationDataRequest)object2).scidi = dabStation.component.sCIDI;
                    ((RadioStationDataRequest)object2).useScidi = true;
                }
                ((RadioStationDataRequest)object2).stationType = "DAB";
                ((RadioStationDataRequest)object2).useStationType = true;
                outstandingRequest.request.add(new RequestData((RadioStationDataRequest)object2, l, new TunerObjectContainer(dabStation)));
                continue;
            }
            object2 = (RadioDBEntry)object;
            dabStation.setLogoFromDb(((RadioDBEntry)object2).stationLogo);
            dabStation.setDatabaseId(((RadioDBEntry)object2).stationData.stationId);
        }
        return outstandingRequest;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private OutstandingRequest createLogoRequest(RadioStationDataResponse[] radioStationDataResponseArray, OutstandingRequest outstandingRequest) {
        OutstandingRequest outstandingRequest2 = new OutstandingRequest(3, outstandingRequest.request.size(), outstandingRequest.rsdbListener, outstandingRequest.band);
        int n = 0;
        for (int i2 = 0; i2 < outstandingRequest.request.size(); ++i2) {
            Object object;
            RequestData requestData = (RequestData)outstandingRequest.request.get(i2);
            int n2 = requestData.dsiReq.length;
            RadioStationData radioStationData = null;
            for (int i3 = 0; i3 < n2; ++i3) {
                object = radioStationDataResponseArray[n++];
                if (((RadioStationDataResponse)object).totalItemCount == 1) {
                    radioStationData = ((RadioStationDataResponse)object).radioStationData[0];
                } else if (((RadioStationDataResponse)object).totalItemCount > 1) {
                    String string = requestData.toc.getStationName(false);
                    long l = requestData.toc.getFrequency();
                    int n3 = 0;
                    int n4 = 0;
                    int n5 = 0;
                    int n6 = 0;
                    for (int i4 = 0; i4 < ((RadioStationDataResponse)object).radioStationData.length; ++i4) {
                        if (string.equalsIgnoreCase(((RadioStationDataResponse)object).radioStationData[i4].shortName)) {
                            ++n3;
                            n5 = i4;
                        }
                        if (l != ((RadioStationDataResponse)object).radioStationData[i4].frequency) continue;
                        ++n4;
                        n6 = i4;
                    }
                    if (n3 == 1) {
                        radioStationData = ((RadioStationDataResponse)object).radioStationData[n5];
                    } else if (n4 == 1) {
                        radioStationData = ((RadioStationDataResponse)object).radioStationData[n6];
                    }
                }
                if (radioStationData == null) continue;
                n += n2 - (i3 + 1);
                break;
            }
            if (radioStationData != null) {
                if (radioStationData.logoId != -1) {
                    RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
                    radioStationDataRequest.maxItemCount = 1;
                    radioStationDataRequest.stationId = radioStationData.stationId;
                    radioStationDataRequest.useStationId = true;
                    radioStationDataRequest.logoId = radioStationData.logoId;
                    radioStationDataRequest.useLogoId = true;
                    outstandingRequest2.request.add(new RequestData(radioStationDataRequest, requestData.radioId, requestData.toc));
                    continue;
                }
                RadioDBEntry radioDBEntry = new RadioDBEntry(ISimpleTuner.EMPTY_RL, LogoDatabase.nullCheck(radioStationData), requestData.unique);
                object = this.intDB;
                synchronized (object) {
                    this.intDB.put(requestData.radioId, radioDBEntry);
                    continue;
                }
            }
            if (requestData.dsiReq.length <= 0 || !requestData.dsiReq[0].useCountry) continue;
            RadioDBEntry radioDBEntry = new RadioDBEntry(ISimpleTuner.EMPTY_RL, EMPTY_RADIO_DATA, false);
            object = this.intDB;
            synchronized (object) {
                this.intDB.put(requestData.radioId, radioDBEntry);
                continue;
            }
        }
        return outstandingRequest2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void respStationData(RadioStationDataResponse[] radioStationDataResponseArray, int n) {
        block25: {
            OutstandingRequest outstandingRequest;
            Object object;
            block26: {
                this.lg.log(100000000, "[LogoDatabase.responseRadioStationData] in %1", (long)n);
                object = this.intDB;
                // MONITORENTER : object
                outstandingRequest = (OutstandingRequest)this.outstandingRequests.get(n);
                this.outstandingRequests.remove(n);
                // MONITOREXIT : object
                if (outstandingRequest == null || outstandingRequest.getDsiReqSize() != radioStationDataResponseArray.length) {
                    this.lg.log(10000, "[LogoDatabase.responseRadioStationData] wrong response size!");
                    return;
                }
                if (outstandingRequest.requestType != 1) break block26;
                this.lg.log(100000000, "handle coutry detection");
                this.calculateCountry(outstandingRequest, radioStationDataResponseArray);
                this.lg.log(100000000, "Country detection statistic %1", (Object)outstandingRequest.countryFinder);
                int n2 = outstandingRequest.countryFinder.getCountry();
                if (n2 == 1) {
                    n2 = this.lastDetectedCountry;
                } else {
                    this.lastDetectedCountry = n2;
                }
                OutstandingRequest outstandingRequest2 = this.addStationDetectStrategy(n2, outstandingRequest);
                RadioStationDataRequest[] radioStationDataRequestArray = outstandingRequest2.getDsiDataReq();
                if (radioStationDataRequestArray.length > 0) {
                    this.lg.log(10000000, "[LogoDatabase.responseRadioStationData] send stationDetectionRequest size:%1", (long)radioStationDataRequestArray.length);
                    int n3 = n + 1;
                    HashMap hashMap = this.intDB;
                    // MONITORENTER : hashMap
                    this.outstandingRequests.add(n3, outstandingRequest2);
                    // MONITOREXIT : hashMap
                    this.dsi.requestRadioStationData(radioStationDataRequestArray, n3);
                    break block25;
                } else {
                    this.lg.log(10000000, "[LogoDatabase.responseRadioStationData] send no stationDetectionRequest");
                    IRSDBResult iRSDBResult = null;
                    HashMap hashMap = this.intDB;
                    // MONITORENTER : hashMap
                    if (this.skippedReq[outstandingRequest2.band] && outstandingRequest2.rsdbListener != null) {
                        this.skippedReq[outstandingRequest2.band] = false;
                        iRSDBResult = outstandingRequest2.rsdbListener;
                    }
                    this.runningReq[outstandingRequest2.band] = false;
                    // MONITOREXIT : hashMap
                    if (iRSDBResult != null) {
                        iRSDBResult.resultAvailable();
                    }
                }
                break block25;
            }
            if (outstandingRequest.requestType == 2) {
                this.lg.log(100000000, "handle station detection");
                object = this.createLogoRequest(radioStationDataResponseArray, outstandingRequest);
                RadioStationLogoRequest[] radioStationLogoRequestArray = ((OutstandingRequest)object).getDsiLogoReq();
                if (radioStationLogoRequestArray.length > 0) {
                    this.lg.log(10000000, "[LogoDatabase.responseRadioStationData] send Logo Request size:%1", (long)radioStationLogoRequestArray.length);
                    int n4 = n + 1;
                    HashMap hashMap = this.intDB;
                    // MONITORENTER : hashMap
                    this.outstandingRequests.add(n4, object);
                    // MONITOREXIT : hashMap
                    this.dsi.requestRadioStationLogos(radioStationLogoRequestArray, n4);
                } else {
                    this.lg.log(10000000, "[LogoDatabase.responseRadioStationData] send no Logo Request");
                    boolean bl = false;
                    HashMap hashMap = this.intDB;
                    // MONITORENTER : hashMap
                    if (this.skippedReq[((OutstandingRequest)object).band] && ((OutstandingRequest)object).rsdbListener != null) {
                        this.skippedReq[((OutstandingRequest)object).band] = false;
                        bl = true;
                    }
                    // MONITOREXIT : hashMap
                    if (bl) {
                        ((OutstandingRequest)object).rsdbListener.resultAvailable();
                    }
                    hashMap = this.intDB;
                    // MONITORENTER : hashMap
                    this.runningReq[((OutstandingRequest)object).band] = false;
                    // MONITOREXIT : hashMap
                }
            } else {
                this.lg.log(10000000, "[LogoDatabase.responseRadioStationData] wasRequest.requestType %1 unknown", (long)outstandingRequest.requestType);
            }
        }
        this.lg.log(100000000, "[LogoDatabase.responseRadioStationData] out %1", (long)n);
    }

    private void calculateCountry(OutstandingRequest outstandingRequest, RadioStationDataResponse[] radioStationDataResponseArray) {
        for (int i2 = 0; i2 < radioStationDataResponseArray.length; ++i2) {
            if (radioStationDataResponseArray[i2].totalItemCount != 1) continue;
            outstandingRequest.countryFinder.add(radioStationDataResponseArray[i2].radioStationData[0].country);
            ((RequestData)outstandingRequest.request.get((int)i2)).unique = true;
        }
    }

    private static RadioStationData nullCheck(RadioStationData radioStationData) {
        radioStationData.longName = radioStationData.longName == null ? "" : radioStationData.longName.trim();
        radioStationData.shortName = radioStationData.shortName == null ? "" : radioStationData.shortName.trim();
        radioStationData.stationType = radioStationData.stationType == null ? "" : radioStationData.stationType.trim();
        radioStationData.scidi = radioStationData.scidi == -1 ? 0 : radioStationData.scidi;
        return radioStationData;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void respStationLogos(RadioStationLogoResponse[] radioStationLogoResponseArray, int n) {
        Object object;
        int n2;
        OutstandingRequest outstandingRequest;
        HashMap hashMap = this.intDB;
        synchronized (hashMap) {
            outstandingRequest = (OutstandingRequest)this.outstandingRequests.get(n);
            this.outstandingRequests.remove(n);
        }
        if (outstandingRequest == null || outstandingRequest.getDsiReqSize() != radioStationLogoResponseArray.length) {
            this.lg.log(10000, "[LogoDatabase.respStationLogos] wrong response size!");
            return;
        }
        boolean bl = false;
        for (n2 = 0; n2 < radioStationLogoResponseArray.length; ++n2) {
            if (radioStationLogoResponseArray[n2].totalItemCount == 1) {
                object = (RequestData)outstandingRequest.request.get(n2);
                RadioStationData radioStationData = radioStationLogoResponseArray[n2].radioStationData[0];
                ResourceLocator resourceLocator = radioStationLogoResponseArray[n2].resourceLocators[0];
                RadioDBEntry radioDBEntry = new RadioDBEntry(new HMIResourceLocator(resourceLocator.id, resourceLocator.url), LogoDatabase.nullCheck(radioStationData), ((RequestData)object).unique);
                HashMap hashMap2 = this.intDB;
                synchronized (hashMap2) {
                    this.intDB.put(((RequestData)object).radioId, radioDBEntry);
                    bl = true;
                    continue;
                }
            }
            if (radioStationLogoResponseArray[n2].totalItemCount != -999) continue;
            this.lg.log(10000000, "[LogoDatabase.respStationLogos] reorganizing DB!");
            object = this.intDB;
            synchronized (object) {
                this.oldDB.putAll(this.intDB);
                this.intDB.clear();
            }
            this.informDbReadyChanged();
        }
        n2 = 0;
        object = this.intDB;
        synchronized (object) {
            this.runningReq[outstandingRequest.band] = false;
            n2 = this.skippedReq[outstandingRequest.band];
            this.skippedReq[outstandingRequest.band] = false;
        }
        if (outstandingRequest.rsdbListener != null) {
            if (bl || n2 != 0) {
                outstandingRequest.rsdbListener.resultAvailable();
            } else {
                this.lg.log(1000000, "[LogoDatabase.respStationLogos] no new infos");
            }
        }
    }

    public Object dump() {
        Buffer buffer = new Buffer(10000);
        this.dsi.requestDatabaseVersionInfo(424344);
        Set set = this.intDB.keySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Long l = (Long)iterator.next();
            RadioDBEntry radioDBEntry = (RadioDBEntry)this.intDB.get(l);
            buffer.append(l).append(" -> ").append(radioDBEntry.stationData).append(':').append(radioDBEntry.stationLogo.getResourceURI()).append('\n');
        }
        return buffer;
    }

    public void setCountyRegionData(CountryRegionData[] countryRegionDataArray) {
        this.countryRegionMngr.setCountyRegionData(countryRegionDataArray);
    }

    public void setCountryRegionTranslationData(CountryRegionTranslationData[] countryRegionTranslationDataArray) {
        this.countryRegionMngr.setCountryRegionTranslationData(countryRegionTranslationDataArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setRegion(int n) {
        this.lg.log(1000000, "[LogoDatabase.setRegion] to %1 ", (long)n);
        HashMap hashMap = this.intDB;
        synchronized (hashMap) {
            this.settingsRegion = n;
            this.intDB.clear();
            this.oldDB.clear();
            this.outstandingRequests.clear();
        }
        this.init();
        this.informDbReadyChanged();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public HMIResourceLocator getLogo(long l) {
        Object object;
        Object object2 = this.intDB;
        synchronized (object2) {
            object = this.intDB.get(new Long(l));
        }
        if (object != null) {
            object2 = (RadioDBEntry)object;
            return ((RadioDBEntry)object2).stationLogo;
        }
        return ISimpleTuner.EMPTY_RL;
    }

    public void resetToDefaultSettings() {
        this.countryRegionMngr.resetToDefaultSettings();
        this.setActivated(1);
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            int n5 = LogoDatabase.this.dbActivatedChoice.getValue() == 1 ? 0 : 1;
            LogoDatabase.this.setActivated(n5);
        }
    }

    private class LanguageChangeListener
    implements LanguageManager.ILanguageChangeListener {
        private LanguageChangeListener() {
        }

        public void languageChanged(Language language) {
            LogoDatabase.this.setSystemLanguage(language.getLanguageCode());
            if (LogoDatabase.this.initialisationOk) {
                LogoDatabase.this.informDbReadyChanged();
            }
        }
    }
}

