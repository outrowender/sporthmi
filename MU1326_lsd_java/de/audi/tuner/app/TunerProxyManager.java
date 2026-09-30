/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.phone.ITelService;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.IDrawerFocusManager;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner;
import de.audi.tuner.app.amfm.GUIHandlerAMFM;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.audiodrawer.AudioDrawerStateTracker;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabDummyNames;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.history.HistoryTuner;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;
import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.SDARSStatusManager;
import de.audi.tuner.app.sdars.SDARSTuner;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.app.uni.UnifiedTuner;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IAMFMTuner;
import de.audi.tuner.ifc.IDABTuner;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ISearchBreak;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.ITunerAMFMGUIHandler;
import de.audi.tuner.ifc.ITunerDABGUIHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.NullLogoDatabase;
import de.audi.tuner.ifc.NullRSDBResult;
import de.audi.tuner.ifc.NullSimpleTuner;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.ifc.listener.MessageListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.itunes.TaggingManager;
import de.audi.tuner.keys.KeyHandlerManager;
import de.audi.tuner.util.jobqueue.TunerJobQueue;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.sdars.DSISDARSSeekListener;

public class TunerProxyManager {
    public final RsdbStatusListener rsdbStatusListener = new RsdbStatusListener();
    private static final TunerProxyManager INSTANCE = new TunerProxyManager();
    private IAMFMTuner amFmTuner;
    private IDABTuner dabTuner;
    private ISDARSTuner sdarsTuner;
    private IUnifiedTuner uniTuner;
    private TunerBasics basics;
    private TunerModels models;
    private TunerStorage storage;
    private BandListHandler bandList;
    private MemoryListHandler memory;
    private TunerAudioMgmt audio;
    private AnnouncementHandler announce;
    private TunerJobQueue jobQueue;
    private IUpdateListener[] updateListeners;
    private TaggingManager taggingMgr;
    private ITunerVariantExt variantExt;
    private LanguageManager langMngr;
    private IScanHandler scanHandler;
    private IPSFreezeDB psFreezeDB;
    private final DabDummyNames dummyNames = new DabDummyNames();
    private ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler;
    private RadiotextHyperlinkProcessor hyperlinkProcessor;
    private SDARSStationDescriptions sdarsStationDescriptions;
    private AudioDrawerStateTracker audioDrawerStateTracker;
    private HistoryTuner historyTuner = null;
    private ILogoDatabase logoDatabase;

    private TunerProxyManager() {
    }

    public static TunerProxyManager getInstance() {
        return INSTANCE;
    }

    void init(TunerBasics tunerBasics, TunerStorage tunerStorage, BandListHandler bandListHandler, KeyHandlerManager keyHandlerManager, MemoryListHandler memoryListHandler, TunerAudioMgmt tunerAudioMgmt, AnnouncementHandler announcementHandler, TunerJobQueue tunerJobQueue, IUpdateListener[] iUpdateListenerArray, TaggingManager taggingManager, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, IScanHandler iScanHandler, IPSFreezeDB iPSFreezeDB, ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, SDARSStationDescriptions sDARSStationDescriptions, AudioDrawerStateTracker audioDrawerStateTracker) {
        this.basics = tunerBasics;
        this.models = tunerBasics.getModels();
        this.storage = tunerStorage;
        this.bandList = bandListHandler;
        this.memory = memoryListHandler;
        this.audio = tunerAudioMgmt;
        this.announce = announcementHandler;
        this.jobQueue = tunerJobQueue;
        this.updateListeners = iUpdateListenerArray;
        this.taggingMgr = taggingManager;
        this.variantExt = iTunerVariantExt;
        this.langMngr = languageManager;
        this.scanHandler = iScanHandler;
        this.psFreezeDB = iPSFreezeDB;
        this.clockTimeZoneOffsetHandler = clockTimeZoneOffsetHandler;
        this.hyperlinkProcessor = radiotextHyperlinkProcessor;
        this.sdarsStationDescriptions = sDARSStationDescriptions;
        this.audioDrawerStateTracker = audioDrawerStateTracker;
        this.logoDatabase = new NullLogoDatabase();
        this.amFmTuner = null;
        this.dabTuner = null;
        this.sdarsTuner = null;
    }

    void shutdown() {
        this.amFmTuner = null;
        this.dabTuner = null;
        this.sdarsTuner = null;
        this.basics = null;
        this.storage = null;
        this.bandList = null;
        this.memory = null;
        this.audio = null;
        this.announce = null;
        this.jobQueue = null;
        this.updateListeners = null;
        this.taggingMgr = null;
        this.variantExt = null;
        this.langMngr = null;
        this.psFreezeDB = null;
        this.clockTimeZoneOffsetHandler = null;
        this.hyperlinkProcessor = null;
        this.logoDatabase = new NullLogoDatabase();
    }

    public IAMFMTuner getAmFmTuner() {
        if (!this.isInitialized()) {
            throw new IllegalArgumentException("Uninitialized TunerProxyManager during AMFM intstantiation!");
        }
        if (this.amFmTuner == null) {
            AMFMTuner aMFMTuner = new AMFMTuner(this.basics, this.storage, this.bandList, this.memory, this.audio, this.announce, this.taggingMgr, this.variantExt, this.langMngr, this.scanHandler, this.psFreezeDB, this.taggingMgr, this.hyperlinkProcessor);
            aMFMTuner.addUpdateListeners(this.updateListeners);
            this.amFmTuner = aMFMTuner;
        }
        return this.amFmTuner;
    }

    public IDABTuner getDABTuner() {
        if (this.dabTuner == null) {
            if (Utilities.isDABPresent()) {
                if (!this.isInitialized()) {
                    throw new IllegalArgumentException("Uninitialized TunerProxyManager during DAB instantiation!");
                }
                DABTuner dABTuner = new DABTuner(this.basics, this.storage, this.bandList, this.memory, this.audio, this.announce, this.variantExt, this.langMngr, this.scanHandler, this.dummyNames, this.hyperlinkProcessor);
                dABTuner.addUpdateListeners(this.updateListeners);
                this.dabTuner = dABTuner;
            } else {
                this.dabTuner = new DummyDABTuner();
            }
        }
        return this.dabTuner;
    }

    public ISDARSTuner getSDARSTuner() {
        if (this.sdarsTuner == null) {
            if (Utilities.isSDARSPresent()) {
                if (!this.isInitialized()) {
                    throw new IllegalArgumentException("Uninitialized TunerProxyManager during SDARS instantiation!");
                }
                SDARSTuner sDARSTuner = new SDARSTuner(this.basics, this.storage, this.bandList, this.memory, this.audio, this.taggingMgr, this.langMngr, this.variantExt, this.scanHandler, this.clockTimeZoneOffsetHandler, this.hyperlinkProcessor, this.sdarsStationDescriptions, this.audioDrawerStateTracker);
                sDARSTuner.addUpdateListeners(this.updateListeners);
                this.sdarsTuner = sDARSTuner;
            } else {
                this.sdarsTuner = new DummySDARSTuner();
            }
        }
        return this.sdarsTuner;
    }

    public IUnifiedTuner getUnifiedTuner() {
        if (this.uniTuner == null) {
            if (Utilities.isDABPresent() && Utilities.isEvoHigh()) {
                if (!this.isInitialized()) {
                    throw new IllegalArgumentException("Uninitialized TunerProxyManager during Unified tuner instantiation!");
                }
                UnifiedTuner unifiedTuner = new UnifiedTuner(this.basics, this.storage, this.audio, this.variantExt, this.langMngr, this.memory, this.bandList, this.psFreezeDB, this.dummyNames, this.announce, this.hyperlinkProcessor);
                unifiedTuner.addUpdateListeners(this.updateListeners);
                this.uniTuner = unifiedTuner;
            } else {
                this.uniTuner = new DummyUnifiedTuner();
            }
        }
        return this.uniTuner;
    }

    public IStationListHandler getUniStationListHandler() {
        return this.getUnifiedTuner().getStationListHandler();
    }

    public ITunerAMFMGUIHandler getAmFmGUIHandler() {
        return (ITunerAMFMGUIHandler)this.getAmFmTuner().getGUIHandler();
    }

    public ITunerDABGUIHandler getDabGUIHandler() {
        return (ITunerDABGUIHandler)this.getDABTuner().getGUIHandler();
    }

    public ITunerGUIHandler getUniGUIHandler() {
        return this.getUnifiedTuner().getGUIHandler();
    }

    public ITunerGUIHandler getSdarsGUIHandler() {
        return this.getSDARSTuner().getGUIHandler();
    }

    public IStationListHandler getDabStationListHandler() {
        return this.getDABTuner().getGUIHandler().getStationListHandler();
    }

    public IStationListHandler getSdarsStationListHandler() {
        return this.getSDARSTuner().getGUIHandler().getStationListHandler();
    }

    public SDARSEPGHandler getSdarsEpgHandler() {
        return this.getSDARSTuner().getSdarsEpgHandler();
    }

    public IStationListHandler getStationListHandler(int n) {
        switch (n) {
            case 1: {
                return (IStationListHandler)((Object)((GUIHandlerAMFM)this.getAmFmGUIHandler()).getFMStationList());
            }
            case 4: {
                return (IStationListHandler)((Object)((GUIHandlerAMFM)this.getAmFmGUIHandler()).getAMStationList());
            }
            case 10: {
                return (IStationListHandler)((Object)((GUIHandlerAMFM)this.getAmFmGUIHandler()).getTIStationList());
            }
            case 11: {
                return this.getUniStationListHandler();
            }
            case 5: {
                return this.getDabStationListHandler();
            }
            case 7: {
                return this.getSdarsStationListHandler();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("unsupported band ").append(n).toString());
    }

    public ITunerGUIHandler getActiveTunerGuiHandler() {
        int n = this.basics.getModels().getActiveTuner();
        switch (n) {
            case 1: 
            case 4: 
            case 10: {
                return this.getAmFmGUIHandler();
            }
            case 5: {
                return this.getDabGUIHandler();
            }
            case 7: {
                return this.getSdarsGUIHandler();
            }
            case 11: {
                return this.getUniGUIHandler();
            }
        }
        throw new IllegalStateException(new StringBuffer().append("Illegal band ").append(n).toString());
    }

    public ISimpleTuner getActiveTuner() {
        return this.getTuner(this.basics.getModels().getActiveTuner());
    }

    ISimpleTuner getTuner(int n) {
        switch (n) {
            case 1: 
            case 4: {
                return this.getAmFmTuner();
            }
            case 5: {
                return this.getDABTuner();
            }
            case 7: {
                return this.getSDARSTuner();
            }
            case 11: {
                return this.getUnifiedTuner();
            }
        }
        return new NullSimpleTuner(this.basics);
    }

    public int prepareAndTune(TunerObjectContainer tunerObjectContainer, int n) {
        this.basics.getLogger().main.log(10000000, "[TunerProxyManager.prepareAndTune] %1", (Object)tunerObjectContainer);
        TunerObjectContainer tunerObjectContainer2 = this.fillMissingName(tunerObjectContainer);
        this.basics.getLogger().main.log(10000000, "[TunerProxyManager.prepareAndTune] %1", (Object)tunerObjectContainer2);
        if (tunerObjectContainer2 == null) {
            return this.basics.getModels().getActiveTuner();
        }
        switch (tunerObjectContainer2.getType()) {
            case 3: {
                return this.tuneAMFM(tunerObjectContainer2, n);
            }
            case 6: {
                return this.tuneDAB(tunerObjectContainer2, n);
            }
            case 7: {
                return this.tuneUni(tunerObjectContainer2, n);
            }
            case 5: {
                return this.tuneSDARS(tunerObjectContainer2, 0);
            }
        }
        throw new IllegalArgumentException();
    }

    private int tuneDAB(TunerObjectContainer tunerObjectContainer, int n) {
        this.logoDatabase.requestDabData(new DabStation[]{tunerObjectContainer.getDABStation()}, NullRSDBResult.INSTANCE);
        if (this.basics.getModels().getActiveTuner() != 5) {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneDAB] switch band - %1", (Object)tunerObjectContainer);
            this.bandList.switchBand(5, tunerObjectContainer, n);
        } else {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneDAB] DAB already active - %1", (Object)tunerObjectContainer);
            IRadioCmdManager iRadioCmdManager = this.getAmFmTuner().getCmdManager();
            RadioCommandList radioCommandList = tunerObjectContainer.getDABStation().isService() ? iRadioCmdManager.clSwitchToDAB(2, tunerObjectContainer.getDABStation(), n) : iRadioCmdManager.clSwitchToDAB(3, tunerObjectContainer.getDABStation(), n);
            iRadioCmdManager.enqueue(radioCommandList);
        }
        return 5;
    }

    private int tuneUni(TunerObjectContainer tunerObjectContainer, int n) {
        this.logoDatabase.requestUniData(new UnifiedStationExt[]{tunerObjectContainer.getUniStation()}, NullRSDBResult.INSTANCE);
        if (this.basics.getModels().getActiveTuner() != 11) {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneUni] switch band - %1", (Object)tunerObjectContainer);
            this.bandList.switchBand(11, tunerObjectContainer, n);
        } else {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneUni] UniTuner already active - %1", (Object)tunerObjectContainer);
            IRadioCmdManager iRadioCmdManager = this.getUnifiedTuner().getCmdManager();
            RadioCommandList radioCommandList = iRadioCmdManager.clSwitchToUni(tunerObjectContainer.getUniStation(), n);
            iRadioCmdManager.enqueue(radioCommandList);
        }
        return 11;
    }

    private int tuneAMFM(TunerObjectContainer tunerObjectContainer, int n) {
        AMFMStation aMFMStation = tunerObjectContainer.getAMFMService();
        this.logoDatabase.requestAmFmData(new AMFMStation[]{aMFMStation}, NullRSDBResult.INSTANCE);
        int n2 = Utilities.getBandIdByWaveband(aMFMStation.waveband);
        if (n2 != this.models.getActiveTuner()) {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneAMFM] switch band - %1", (Object)tunerObjectContainer);
            this.bandList.switchBand(n2, tunerObjectContainer, n);
        } else {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneAMFM] AM/FM already active - %1", (Object)tunerObjectContainer);
            IRadioCmdManager iRadioCmdManager = this.getAmFmTuner().getCmdManager();
            RadioCommandList radioCommandList = iRadioCmdManager.clSwitchToAMFM(n, aMFMStation, false);
            iRadioCmdManager.enqueue(radioCommandList);
        }
        return n2;
    }

    private int tuneSDARS(TunerObjectContainer tunerObjectContainer, int n) {
        if (this.basics.getModels().getActiveTuner() != 7) {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneSDARS] switch band - %1", (Object)tunerObjectContainer);
            this.bandList.switchBand(7, tunerObjectContainer, n);
        } else {
            this.basics.getLogger().main.log(100000000, "[TunerProxyManager.tuneSDARS] SDARSTuner already active - %1", (Object)tunerObjectContainer);
            IRadioCmdManager iRadioCmdManager = this.getSDARSTuner().getCmdManager();
            RadioCommandList radioCommandList = iRadioCmdManager.clSwitchToSDARS(tunerObjectContainer.getSDARSService(), n);
            iRadioCmdManager.enqueue(radioCommandList);
        }
        return 7;
    }

    TunerObjectContainer fillMissingName(TunerObjectContainer tunerObjectContainer) {
        switch (tunerObjectContainer.getType()) {
            case 3: {
                AMFMStation aMFMStation = this.fillMissingName(tunerObjectContainer.getAMFMService());
                return new TunerObjectContainer(aMFMStation);
            }
            case 6: {
                return this.fillMissingNameDAB(tunerObjectContainer);
            }
            case 7: {
                return this.fillMissingNameUni(tunerObjectContainer);
            }
            case 5: {
                StationInfoExt stationInfoExt = this.fillMissingName(tunerObjectContainer.getSDARSService());
                return new TunerObjectContainer(stationInfoExt, tunerObjectContainer.isEnabled());
            }
        }
        return tunerObjectContainer;
    }

    private AMFMStation fillMissingName(AMFMStation aMFMStation) {
        if (!Utilities.isEmpty(aMFMStation.getName())) {
            return aMFMStation;
        }
        if (Utilities.isJapan()) {
            return this.fillMissingNameJapan(aMFMStation);
        }
        int n = Utilities.getBandIdByWaveband(aMFMStation.getWaveband());
        if (Utilities.isNARBuild() && !aMFMStation.rds && !aMFMStation.hd) {
            return aMFMStation;
        }
        TunerObjectContainer[] tunerObjectContainerArray = this.getAmFmGUIHandler().getStationList(n);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            AMFMStation aMFMStation2 = tunerObjectContainerArray[i2].getAMFMService();
            if (!RadioComparators.equals(aMFMStation, aMFMStation2)) continue;
            aMFMStation2.setPresetPos(aMFMStation.getPresetPos());
            return aMFMStation2;
        }
        AbstractMemoryRow[] abstractMemoryRowArray = this.memory.getRows(n);
        for (int i3 = 0; i3 < abstractMemoryRowArray.length; ++i3) {
            AMFMStation aMFMStation3 = abstractMemoryRowArray[i3].getTOContainer().getAMFMService();
            if (!RadioComparators.equals(aMFMStation, aMFMStation3)) continue;
            aMFMStation3.setPresetPos(aMFMStation.getPresetPos());
            return aMFMStation3;
        }
        this.basics.getLogger().main.log(100000, "[TunerProxyManager.fillMissingName] No matching FM station found for %1", (Object)aMFMStation);
        return aMFMStation;
    }

    private AMFMStation fillMissingNameJapan(AMFMStation aMFMStation) {
        int n = Utilities.getBandIdByWaveband(aMFMStation.getWaveband());
        TunerObjectContainer[] tunerObjectContainerArray = this.getAmFmGUIHandler().getStationList(n);
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            if (aMFMStation.getFrequency() != tunerObjectContainerArray[i2].getAMFMService().getFrequency()) continue;
            return tunerObjectContainerArray[i2].getAMFMService();
        }
        AbstractMemoryRow[] abstractMemoryRowArray = this.memory.getRows(n);
        for (int i3 = 0; i3 < abstractMemoryRowArray.length; ++i3) {
            AMFMStation aMFMStation2 = abstractMemoryRowArray[i3].getTOContainer().getAMFMService();
            if (aMFMStation.getFrequency() != aMFMStation2.getFrequency()) continue;
            return aMFMStation2;
        }
        return aMFMStation;
    }

    private TunerObjectContainer fillMissingNameDAB(TunerObjectContainer tunerObjectContainer) {
        DabStation dabStation = tunerObjectContainer.getDABStation();
        TunerObjectContainer[] tunerObjectContainerArray = this.getDabGUIHandler().getStationList();
        AbstractMemoryRow[] abstractMemoryRowArray = this.memory.getRows(5);
        switch (dabStation.getType()) {
            case 3: {
                this.fillComponentName(dabStation.component, tunerObjectContainerArray, abstractMemoryRowArray);
                this.fillServiceName(dabStation.service, tunerObjectContainerArray, abstractMemoryRowArray);
                this.fillEnsembleName(dabStation.ensemble, tunerObjectContainerArray, abstractMemoryRowArray);
                break;
            }
            case 2: {
                this.fillServiceName(dabStation.service, tunerObjectContainerArray, abstractMemoryRowArray);
                this.fillEnsembleName(dabStation.ensemble, tunerObjectContainerArray, abstractMemoryRowArray);
                break;
            }
            case 1: {
                this.fillEnsembleName(dabStation.ensemble, tunerObjectContainerArray, abstractMemoryRowArray);
                break;
            }
        }
        return tunerObjectContainer;
    }

    private TunerObjectContainer fillMissingNameUni(TunerObjectContainer tunerObjectContainer) {
        UnifiedStationExt unifiedStationExt = tunerObjectContainer.getUniStation();
        if (Utilities.isEmpty(unifiedStationExt.shortName)) {
            TunerObjectContainer[] tunerObjectContainerArray = this.getUniGUIHandler().getStationList();
            for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
                if (!RadioComparators.equals(unifiedStationExt, tunerObjectContainerArray[i2].getUniStation())) continue;
                UnifiedStationExt unifiedStationExt2 = tunerObjectContainerArray[i2].getUniStation();
                unifiedStationExt.longName = unifiedStationExt2.longName;
                unifiedStationExt.shortName = unifiedStationExt2.shortName;
                unifiedStationExt.ptyCodes = unifiedStationExt2.ptyCodes;
                unifiedStationExt.setAudioStatus(unifiedStationExt2.getAudioStatus());
                return tunerObjectContainer;
            }
            AbstractMemoryRow[] abstractMemoryRowArray = this.memory.getRows(11);
            for (int i3 = 0; i3 < abstractMemoryRowArray.length; ++i3) {
                if (!RadioComparators.equals(unifiedStationExt, abstractMemoryRowArray[i3].getTOContainer().getUniStation())) continue;
                UnifiedStationExt unifiedStationExt3 = abstractMemoryRowArray[i3].getTOContainer().getUniStation();
                unifiedStationExt.longName = unifiedStationExt3.longName;
                unifiedStationExt.shortName = unifiedStationExt3.shortName;
                unifiedStationExt.ptyCodes = unifiedStationExt3.ptyCodes;
                unifiedStationExt.setAudioStatus(unifiedStationExt3.getAudioStatus());
                return tunerObjectContainer;
            }
        }
        if (tunerObjectContainer.getUniStation().getAudioStatus() == 0) {
            tunerObjectContainer.getUniStation().setAudioStatus(tunerObjectContainer.getUniStation().ensId == 0 ? 1 : 2);
        }
        return tunerObjectContainer;
    }

    private void fillEnsembleName(EnsembleInfo ensembleInfo, TunerObjectContainer[] tunerObjectContainerArray, AbstractMemoryRow[] abstractMemoryRowArray) {
        Object object;
        int n;
        if (Utilities.isEmpty(ensembleInfo.getFullName()) || Utilities.isEmpty(ensembleInfo.getShortName())) {
            for (n = 0; n < tunerObjectContainerArray.length; ++n) {
                object = tunerObjectContainerArray[n].getDABStation();
                if (!((DabStation)object).isEnsemble() || ensembleInfo.ensID != ((DabStation)object).ensemble.ensID) continue;
                ensembleInfo.fullName = ((DabStation)object).ensemble.fullName;
                ensembleInfo.shortName = ((DabStation)object).ensemble.shortName;
                break;
            }
        }
        if (Utilities.isEmpty(ensembleInfo.getFullName()) || Utilities.isEmpty(ensembleInfo.getShortName())) {
            for (n = 0; n < abstractMemoryRowArray.length; ++n) {
                object = abstractMemoryRowArray[n].getTOContainer().getDABStation().ensemble;
                if (ensembleInfo.ensID != ((EnsembleInfo)object).ensID) continue;
                ensembleInfo.fullName = ((EnsembleInfo)object).fullName;
                ensembleInfo.shortName = ((EnsembleInfo)object).shortName;
                break;
            }
        }
    }

    private void fillServiceName(ServiceInfo serviceInfo, TunerObjectContainer[] tunerObjectContainerArray, AbstractMemoryRow[] abstractMemoryRowArray) {
        Object object;
        int n;
        if (Utilities.isEmpty(serviceInfo.fullName) || Utilities.isEmpty(serviceInfo.shortName)) {
            for (n = 0; n < tunerObjectContainerArray.length; ++n) {
                ServiceInfo serviceInfo2;
                object = tunerObjectContainerArray[n].getDABStation();
                if (!((DabStation)object).isService() || !RadioComparators.equals(serviceInfo, serviceInfo2 = ((DabStation)object).service)) continue;
                serviceInfo.fullName = serviceInfo2.fullName;
                serviceInfo.shortName = serviceInfo2.shortName;
                serviceInfo.ptyCodes = serviceInfo2.ptyCodes;
                break;
            }
        }
        if (Utilities.isEmpty(serviceInfo.fullName) || Utilities.isEmpty(serviceInfo.shortName)) {
            for (n = 0; n < abstractMemoryRowArray.length; ++n) {
                if (!abstractMemoryRowArray[n].getTOContainer().getDABStation().isService() || !RadioComparators.equals(serviceInfo, (ServiceInfo)(object = abstractMemoryRowArray[n].getTOContainer().getDABStation().service))) continue;
                serviceInfo.fullName = ((ServiceInfo)object).fullName;
                serviceInfo.shortName = ((ServiceInfo)object).shortName;
                break;
            }
        }
    }

    private void fillComponentName(ComponentInfo componentInfo, TunerObjectContainer[] tunerObjectContainerArray, AbstractMemoryRow[] abstractMemoryRowArray) {
        Object object;
        int n;
        if (Utilities.isEmpty(componentInfo.getFullName()) || Utilities.isEmpty(componentInfo.getShortName())) {
            for (n = 0; n < tunerObjectContainerArray.length; ++n) {
                object = tunerObjectContainerArray[n].getDABStation();
                if (!((DabStation)object).isComponent() || !RadioComparators.equals(componentInfo, ((DabStation)object).component)) continue;
                componentInfo.fullName = ((DabStation)object).component.fullName;
                componentInfo.shortName = ((DabStation)object).component.shortName;
                break;
            }
        }
        if (Utilities.isEmpty(componentInfo.getFullName()) || Utilities.isEmpty(componentInfo.getShortName())) {
            for (n = 0; n < abstractMemoryRowArray.length; ++n) {
                if (!abstractMemoryRowArray[n].getTOContainer().getDABStation().isComponent() || !RadioComparators.equals(componentInfo, (ComponentInfo)(object = abstractMemoryRowArray[n].getTOContainer().getDABStation().component))) continue;
                componentInfo.fullName = ((ComponentInfo)object).fullName;
                componentInfo.shortName = ((ComponentInfo)object).shortName;
                break;
            }
        }
    }

    private StationInfoExt fillMissingName(StationInfoExt stationInfoExt) {
        if (!Utilities.isEmpty(stationInfoExt.getFullLabel()) && !Utilities.isEmpty(stationInfoExt.getShortLabel())) {
            return stationInfoExt;
        }
        TunerObjectContainer[] tunerObjectContainerArray = this.getSdarsGUIHandler().getStationList();
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            StationInfoExt stationInfoExt2 = tunerObjectContainerArray[i2].getSDARSService();
            if (!RadioComparators.equals(stationInfoExt, stationInfoExt2)) continue;
            return stationInfoExt2;
        }
        AbstractMemoryRow[] abstractMemoryRowArray = this.memory.getRows(7);
        for (int i3 = 0; i3 < abstractMemoryRowArray.length; ++i3) {
            StationInfoExt stationInfoExt3 = abstractMemoryRowArray[i3].getTOContainer().getSDARSService();
            if (!RadioComparators.equals(stationInfoExt, stationInfoExt3)) continue;
            return stationInfoExt3;
        }
        this.basics.getLogger().main.log(100000, "[TunerProxyManager.fillMissingName] No matching SDARS station found for %1", (Object)stationInfoExt);
        return stationInfoExt;
    }

    void stopActiveActions() {
        switch (this.models.getActiveTuner()) {
            case 5: {
                this.dabTuner.abortSeek();
                this.dabTuner.forceStationListUpdate(false);
                break;
            }
            case 4: {
                this.amFmTuner.abortSeek();
                this.amFmTuner.forceStationListUpdate(false);
                break;
            }
            case 1: {
                this.amFmTuner.abortSeek();
                break;
            }
        }
    }

    private boolean isInitialized() {
        return this.basics != null && this.storage != null && this.bandList != null && this.memory != null && this.audio != null && this.updateListeners != null && this.announce != null && this.taggingMgr != null && this.variantExt != null && this.langMngr != null && this.psFreezeDB != null && this.clockTimeZoneOffsetHandler != null && this.hyperlinkProcessor != null && this.audioDrawerStateTracker != null;
    }

    public void setHistoryTuner(HistoryTuner historyTuner) {
        this.historyTuner = historyTuner;
    }

    public HistoryTuner getHistoryTuner() {
        return this.historyTuner;
    }

    public boolean isTuneForbidden(int n, TunerObjectContainer tunerObjectContainer) {
        int n2 = 0;
        if (n == 0) {
            this.models.getChoiceModel(100446).setValue(n2);
            int n3 = this.models.getChoiceModel(100618).getValue();
            if (n3 == 3 || n3 == 12) {
                this.models.getChoiceModel(100618).setValue(n2);
            }
            return false;
        }
        String string = "";
        switch (n) {
            case 11: {
                n2 = 3;
                string = tunerObjectContainer.getStationName(true);
                break;
            }
            case 12: {
                n2 = 8;
                string = tunerObjectContainer.getStationName(true);
                break;
            }
            case 2: {
                n2 = 6;
                break;
            }
        }
        this.models.getLabelModel(100632).setText(string);
        this.models.getChoiceModel(100618).setValue(n2);
        if (this.models.getActiveTuner() != 7) {
            this.models.getChoiceModel(100446).setValue(n2);
        }
        return true;
    }

    private static class DummyDABTuner
    extends DefaultChoiceListener
    implements IDABTuner,
    ITunerDABGUIHandler,
    IStationListHandler {
        private DummyDABTuner() {
        }

        public void register(ISearchBreak iSearchBreak, int n) {
        }

        public void register(ITaggingManager iTaggingManager) {
        }

        public void register(IDrawerFocusManager iDrawerFocusManager) {
        }

        public void clearNotification(int[] nArray) {
        }

        public void reNotification(int n) {
        }

        public void dabSelected(DabStation dabStation, int n) {
        }

        public void registerDsiUpDownListener(RadioInfo radioInfo) {
        }

        public void deinit() {
        }

        public int getCurSyncState() {
            return 4;
        }

        public boolean isDsiFound() {
            return false;
        }

        public ITunerGUIHandler getGUIHandler() {
            return this;
        }

        public IStationListHandler getStationListHandler() {
            return this;
        }

        public int init() {
            return 0;
        }

        public void resetToDefaultSettings() {
        }

        public void seekStation(int n, int n2) {
        }

        public void setComponentUsage(boolean bl) {
        }

        public void setDeviceService(DSIBase dSIBase) {
        }

        public void setNotification(int[] nArray) {
        }

        public void switchFrequencyTable(int n) {
        }

        public void switchLinking(int n) {
        }

        public int getCurLinkState() {
            return 1;
        }

        public ServiceInfo getActiveService() {
            return null;
        }

        public EnsembleInfo getActiveEnsemble() {
            return new EnsembleInfo();
        }

        public boolean tuneById(long l, int n) {
            return false;
        }

        public void audioManagementJustBecameAvailable() {
        }

        public TunerObjectContainer[] getStationList() {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer[] getStationListHierarchical() {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer getCurrentStation() {
            return TunerObjectContainer.EMPTY_CONTAINER;
        }

        public boolean forceStationListUpdate(boolean bl) {
            return false;
        }

        public TunerObjectContainer[] getStationList(int n) {
            return new TunerObjectContainer[0];
        }

        public void addUpdateListener(IUpdateListener iUpdateListener) {
        }

        public boolean isDeviceInUse() {
            return false;
        }

        public void register(DSIListener dSIListener) {
        }

        public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        }

        public IRadioCmdManager getCmdManager() {
            return null;
        }

        public void setComponentUnused() {
        }

        public void setInitDone() {
        }

        public void executeInitialCommands() {
        }

        public ComponentInfo getActiveComponent() {
            return new ComponentInfo();
        }

        public void selectStation(DabStation dabStation, int n, int n2) {
        }

        public void switchDebugInfos(boolean bl) {
        }

        public void abortSeek() {
        }

        public void initSetup() {
        }

        public CmdDefaultListener getDSIUpManager() {
            return null;
        }

        public DabReceptionStatus prepareReceptionStatus(DabStation dabStation) {
            return new DabReceptionStatus(0, 0);
        }

        public DabStation getActiveStation() {
            return new DabStation();
        }

        public IPrevNext getPrevNextHandler() {
            return null;
        }

        public TunerObjectContainer[] startScan() {
            return new TunerObjectContainer[0];
        }

        public void stopScan() {
        }

        public void register(IStoreStationHandler iStoreStationHandler) {
        }

        public void register(IGracenoteRequest iGracenoteRequest) {
        }

        public void getEPGDetailData(DabStation dabStation) {
        }

        public void setPrefImgType(int n) {
        }

        public void setSyncLinkState(DabReceptionStatus dabReceptionStatus) {
        }

        public boolean isEnsemble(int n) {
            return false;
        }

        public TunerActionProxyListener getActionProxyListener() {
            return new TunerActionProxyListener();
        }

        public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
            return null;
        }

        public void performLanguageChange() {
        }

        public IPowerEvent getPoPowerStateListener() {
            return new IPowerEvent(){

                public void notifyPowerEvent(int n, int n2) {
                }
            };
        }

        public MessageListener getMessageListener() {
            return new MessageListener();
        }

        public void reRequestCoverArt() {
        }

        public void setSoftlinking(int n) {
        }

        public IRadioDatabaseListener getDatabaseListener() {
            return new IRadioDatabaseListener(){

                public void databaseReady(ILogoDatabase iLogoDatabase) {
                }
            };
        }
    }

    private static class DummySDARSTuner
    extends DefaultChoiceListener
    implements ISDARSTuner,
    ITunerGUIHandler,
    IStationListHandler {
        private DummySDARSTuner() {
        }

        public void register(ISearchBreak iSearchBreak, int n) {
        }

        public void register(IDrawerFocusManager iDrawerFocusManager) {
        }

        public void clearNotification(int[] nArray) {
        }

        public void deinit() {
        }

        public boolean isDsiFound() {
            return false;
        }

        public ITunerGUIHandler getGUIHandler() {
            return this;
        }

        public IStationListHandler getStationListHandler() {
            return this;
        }

        public void registerDsiUpDownListener(RadioInfo radioInfo) {
        }

        public int init() {
            return 0;
        }

        public void initSeek() {
        }

        public void resetToDefaultSettings() {
        }

        public void sdarsSelected(StationInfoExt stationInfoExt, int n) {
        }

        public void seekStation(int n, int n2) {
        }

        public void selectStation(StationInfoExt stationInfoExt, int n) {
        }

        public void setComponentUsage(boolean bl) {
        }

        public void setDeviceService(DSIBase dSIBase) {
        }

        public void setNotification(int[] nArray) {
        }

        public void audioManagementJustBecameAvailable() {
        }

        public SDARSAdvisoryHandler getAdvisoryHandler() {
            return null;
        }

        public SDARSStatusManager getStatusManager() {
            return null;
        }

        public AlertHandler getAlertHandler() {
            return null;
        }

        public boolean tuneById(long l, int n) {
            return false;
        }

        public TunerObjectContainer[] getStationList() {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer getCurrentStation() {
            return TunerObjectContainer.EMPTY_CONTAINER;
        }

        public boolean forceStationListUpdate(boolean bl) {
            return false;
        }

        public TunerObjectContainer[] getStationList(int n) {
            return new TunerObjectContainer[0];
        }

        public void addUpdateListener(IUpdateListener iUpdateListener) {
        }

        public PdtInfoHandler getPdtHandler() {
            return null;
        }

        public boolean isDeviceInUse() {
            return false;
        }

        public void register(DSIListener dSIListener) {
        }

        public void register(ITaggingManager iTaggingManager) {
        }

        public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        }

        public IRadioCmdManager getCmdManager() {
            return null;
        }

        public void setComponentUnused() {
        }

        public void setInitDone() {
        }

        public void executeInitialCommands() {
        }

        public void initSetup() {
        }

        public DSISDARSSeekListener getSeekListener() {
            return null;
        }

        public StationInfoExt getActiveStation() {
            return new StationInfoExt();
        }

        public void setPhoneService(ITelService iTelService) {
        }

        public CmdDefaultListener getDSIUpManager() {
            return null;
        }

        public IPrevNext getPrevNextHandler() {
            return null;
        }

        public SDARSDSISeekDownManager getDsiSeekDownManager() {
            return null;
        }

        public TunerObjectContainer[] startScan() {
            return new TunerObjectContainer[0];
        }

        public void stopScan() {
        }

        public void register(IStoreStationHandler iStoreStationHandler) {
        }

        public void register(IGracenoteRequest iGracenoteRequest) {
        }

        public void setPrefImgType(int n) {
        }

        public void setHmiReady() {
        }

        public boolean isEnsemble(int n) {
            return false;
        }

        public SDARSEPGHandler getSdarsEpgHandler() {
            return null;
        }

        public void performLanguageChange() {
        }

        public IPowerEvent getPoPowerStateListener() {
            return new IPowerEvent(){

                public void notifyPowerEvent(int n, int n2) {
                }
            };
        }

        public TunerActionProxyListener[] getActionProxyListeners() {
            return new TunerActionProxyListener[0];
        }

        public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
            return null;
        }

        public IDoTagging getTagging() {
            return new IDoTagging(){

                public void doTagging(int n, int n2) {
                }
            };
        }

        public TunerObjectContainer getNextChannelByGenre(short s) {
            return null;
        }

        public void reRequestCoverArt() {
        }

        public SDARSManTune getManualTuneHandler() {
            return null;
        }

        public SDARSStationDescriptions getSdarsStationDescriptions() {
            return null;
        }

        public IRadioDatabaseListener getDatabaseListener() {
            return new IRadioDatabaseListener(){

                public void databaseReady(ILogoDatabase iLogoDatabase) {
                }
            };
        }
    }

    private static class DummyUnifiedTuner
    implements IUnifiedTuner,
    IStationListHandler,
    ITunerGUIHandler {
        private DummyUnifiedTuner() {
        }

        public void register(ISearchBreak iSearchBreak, int n) {
        }

        public void register(ITaggingManager iTaggingManager) {
        }

        public void register(IDrawerFocusManager iDrawerFocusManager) {
        }

        public void setNotification(int[] nArray) {
        }

        public void clearNotification(int[] nArray) {
        }

        public int init() {
            return 0;
        }

        public void initSetup() {
        }

        public void setInitDone() {
        }

        public void deinit() {
        }

        public void executeInitialCommands() {
        }

        public boolean isDsiFound() {
            return false;
        }

        public ITunerGUIHandler getGUIHandler() {
            return this;
        }

        public void setDeviceService(DSIBase dSIBase) {
        }

        public void seekStation(int n, int n2) {
        }

        public void resetToDefaultSettings() {
        }

        public boolean isDeviceInUse() {
            return false;
        }

        public void setComponentUsage(boolean bl) {
        }

        public void setComponentUnused() {
        }

        public boolean forceStationListUpdate(boolean bl) {
            return false;
        }

        public void audioManagementJustBecameAvailable() {
        }

        public void register(DSIListener dSIListener) {
        }

        public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        }

        public IRadioCmdManager getCmdManager() {
            return null;
        }

        public void registerDsiUpDownListener(RadioInfo radioInfo) {
        }

        public CmdDefaultListener getDSIUpManager() {
            return null;
        }

        public void selectStation(UnifiedStationExt unifiedStationExt, int n) {
        }

        public UnifiedStationExt getActiveStation() {
            return null;
        }

        public void uniSelected(UnifiedStationExt unifiedStationExt, int n) {
        }

        public IStationListHandler getStationListHandler() {
            return this;
        }

        public IPrevNext getPrevNextHandler() {
            return null;
        }

        public boolean tuneById(long l, int n) {
            return false;
        }

        public void addUpdateListener(IUpdateListener iUpdateListener) {
        }

        public TunerObjectContainer[] startScan() {
            return new TunerObjectContainer[0];
        }

        public void stopScan() {
        }

        public void register(IGracenoteRequest iGracenoteRequest) {
        }

        public void setPrefImgType(int n) {
        }

        public void reNotification(int n) {
        }

        public boolean isEnsemble(int n) {
            return false;
        }

        public void performLanguageChange() {
        }

        public IPowerEvent getPoPowerStateListener() {
            return null;
        }

        public TunerObjectContainer[] getStationList() {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer[] getStationList(int n) {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer getCurrentStation() {
            return TunerObjectContainer.EMPTY_CONTAINER;
        }

        public void register(IStoreStationHandler iStoreStationHandler) {
        }

        public void setSoftlinking(int n) {
        }

        public void reRequestCoverArt() {
        }

        public IRadioDatabaseListener getDatabaseListener() {
            return new IRadioDatabaseListener(){

                public void databaseReady(ILogoDatabase iLogoDatabase) {
                }
            };
        }
    }

    private class RsdbStatusListener
    implements IRadioDatabaseListener {
        private RsdbStatusListener() {
        }

        public void databaseReady(ILogoDatabase iLogoDatabase) {
            TunerProxyManager.this.logoDatabase = iLogoDatabase;
        }
    }
}

