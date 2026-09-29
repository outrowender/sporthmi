/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.interapp.AMFMStationInfo;
import de.audi.atip.interapp.AMFMTunerService;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.GeneralStatusHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMLabels;
import de.audi.tuner.app.amfm.AMFMSetupHandler;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMTuner$DsiDownListener;
import de.audi.tuner.app.amfm.AMFMTuner$DsiUpListener;
import de.audi.tuner.app.amfm.AMFMTuner$MemoryListener;
import de.audi.tuner.app.amfm.AMFMTuner$RsdbStatusListener;
import de.audi.tuner.app.amfm.AMFMTuner$TunerActionProxyListenerExt;
import de.audi.tuner.app.amfm.AMFMVolumeLockHandler;
import de.audi.tuner.app.amfm.FmRadioTextHistory;
import de.audi.tuner.app.amfm.GUIHandlerAMFM;
import de.audi.tuner.app.amfm.HdTagging;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.amfm.StationNameHistory;
import de.audi.tuner.app.amfm.dsi.AMFMDSIDownManager;
import de.audi.tuner.app.amfm.dsi.AMFMDSIUpManager;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.amfm.stationlist.SortAlgoFrequency;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.NullRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IAMFMTuner;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.itunes.TaggingManager;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.audi.tuner.util.NullDSIAMFMTunerListener;
import java.util.ArrayList;
import java.util.Arrays;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;
import org.dsi.ifc.radio.DSIAMFMTunerListener;
import org.dsi.ifc.radio.WavebandInfo;

public class AMFMTuner
extends UpdateListenerHandler
implements IAMFMTuner {
    private AMFMStation activeStation = new AMFMStation();
    private AMFMStation activeStationFM = new AMFMStation();
    private AMFMStation activeStationAM = new AMFMStation();
    private AMFMStation activeStationTI = new AMFMStation();
    private GUIHandlerAMFM guiHandler;
    private volatile boolean initDone;
    private final int[] attr = new int[]{2, 3, 5, 7, 8, 6, 9, 14, 13, 12, 14, 11, 16, 15, 17};
    private long seekUpdateTime = 0L;
    private int amUpdateStatus = 0;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final TunerStorage storage;
    private final BandListHandler bandList;
    private final MemoryListHandler memory;
    protected final TunerAudioMgmt audio;
    private final GeneralStatusHandler deviceUsage;
    private boolean abortSeekRunning;
    private final AnnouncementHandler annHandler;
    private DSIAMFMTunerListener dsiAmFmTunerListener;
    private IRadioCmdManager cmdManager;
    private volatile boolean seekRunning;
    private boolean firstStationListFMReceived = false;
    private boolean firstStationListAMReceived = false;
    private final ITunerVariantExt variantExt;
    private final Object mutexInit = new Object();
    private boolean initAlreadyTriggered;
    private final AMFMDSIUpManager dsiUpManager;
    private final IAmFmDsiDownManager dsiDownManager;
    private final IPSFreezeDB psFreezeDB;
    private final FmRadioTextHistory radioTextHistory;
    private final HdTagging tagging;
    private final AMFMVolumeLockHandler volumeLockHandler;
    private WavebandInfo[] wavebandInfoList = new WavebandInfo[0];

    public AMFMTuner(TunerBasics tunerBasics, TunerStorage tunerStorage, BandListHandler bandListHandler, MemoryListHandler memoryListHandler, TunerAudioMgmt tunerAudioMgmt, AnnouncementHandler announcementHandler, TaggingManager taggingManager, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, IScanHandler iScanHandler, IPSFreezeDB iPSFreezeDB, ITaggingManager iTaggingManager, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        Object[] objectArray;
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.variantExt = iTunerVariantExt;
        this.storage = tunerStorage;
        this.bandList = bandListHandler;
        this.memory = memoryListHandler;
        this.audio = tunerAudioMgmt;
        this.annHandler = announcementHandler;
        this.psFreezeDB = iPSFreezeDB;
        Object object = new Object();
        this.dsiDownManager = new AMFMDSIDownManager(tunerBasics, object);
        this.dsiUpManager = new AMFMDSIUpManager(tunerBasics, iPSFreezeDB, this.dsiDownManager, object, iTaggingManager, tunerAudioMgmt);
        AMFMLabels aMFMLabels = new AMFMLabels(tunerBasics);
        AMFMStation[] aMFMStationArray = tunerStorage.loadLastAMFMStations();
        this.activeStationFM = aMFMStationArray[0];
        this.activeStationAM = aMFMStationArray[1];
        this.activeStationTI = aMFMStationArray[2];
        if (Utilities.isJapan()) {
            objectArray = new AMFMStationInfo[]{new AMFMStationInfo(this.activeStationFM.name, (int)this.activeStationFM.frequency), new AMFMStationInfo(this.activeStationAM.name, (int)this.activeStationAM.frequency), new AMFMStationInfo(this.activeStationTI.name, (int)this.activeStationTI.frequency)};
            this.dsiUpManager.jpNameListener.updateReceivableStations((AMFMStationInfo[])objectArray);
        }
        this.dsiAmFmTunerListener = new NullDSIAMFMTunerListener(this.logger.amfmDSI);
        this.cmdManager = new NullRadioCmdManager(tunerBasics);
        this.guiHandler = new GUIHandlerAMFM(this, tunerBasics, memoryListHandler, tunerStorage, taggingManager, iTunerVariantExt, languageManager, iScanHandler);
        this.deviceUsage = new GeneralStatusHandler(0);
        this.models.getChoiceModel(1200095488).setValue(0);
        this.models.getChoiceModel(-2037907200).setValue(Utilities.getAmBandsetting());
        this.models.getChoiceModel(-2021129984).setValue(Utilities.getFmBandsetting());
        this.volumeLockHandler = new AMFMVolumeLockHandler(tunerAudioMgmt, this.logger.amfmDSI);
        this.radioTextHistory = new FmRadioTextHistory(tunerBasics, radiotextHyperlinkProcessor);
        this.radioTextHistory.init();
        memoryListHandler.setDeviceServiceAMFM(this.dsiDownManager);
        this.dsiUpManager.register(this.dsiDownManager.getDsiUpListener());
        this.dsiUpManager.register(new AMFMTuner$DsiUpListener(this, null));
        this.dsiUpManager.register(aMFMLabels.amfmDsiUpListener);
        this.dsiUpManager.register(this.volumeLockHandler.dsiUpListener);
        objectArray = this.guiHandler.getDsiUpListeners();
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            this.dsiUpManager.register((RadioInfo)objectArray[i2]);
        }
        this.dsiUpManager.register(this.radioTextHistory.dsiUpListener);
        this.dsiDownManager.register(this.dsiUpManager.dsiDownListener);
        this.dsiDownManager.register(new AMFMTuner$DsiDownListener(this, null));
        this.dsiDownManager.register(aMFMLabels.dsiDownListener);
        this.dsiDownManager.register(this.guiHandler.getFMStationList().getDsiDownListener());
        this.dsiDownManager.register(this.guiHandler.getAMStationList().getDsiDownListener());
        this.dsiDownManager.register(this.guiHandler.getTIStationList().getDsiDownListener());
        this.dsiDownManager.register(this.guiHandler.getManWheelDownListener(4));
        this.dsiDownManager.register(this.guiHandler.getManWheelDownListener(1));
        this.dsiDownManager.register(this.radioTextHistory.dsiDownListener);
        this.dsiDownManager.register(this.guiHandler.dsiDownInfo);
        this.dsiDownManager.register(this.volumeLockHandler.dsiDownListener);
        this.dsiUpManager.register(memoryListHandler.highlightListener);
        this.dsiDownManager.register(memoryListHandler.highlightListener);
        if (Utilities.isNARBuild()) {
            this.tagging = new HdTagging(tunerBasics);
            this.dsiUpManager.register(this.tagging.amfmDsiUpListener);
            this.dsiDownManager.register(this.tagging.dsiDownListener);
        } else {
            this.tagging = null;
        }
    }

    public TunerStatus getStatus() {
        return this.status;
    }

    @Override
    public final void register(DSIListener dSIListener) {
        this.dsiAmFmTunerListener = (DSIAMFMTunerListener)dSIListener;
    }

    @Override
    public void registerDsiUpDownListener(RadioInfo radioInfo) {
        if (radioInfo instanceof AMFMDsiUpInfo) {
            this.dsiUpManager.register(radioInfo);
        } else if (radioInfo instanceof AMFMDsiDownInfo) {
            this.dsiDownManager.register(radioInfo);
        } else {
            this.dsiUpManager.register(radioInfo);
            this.dsiDownManager.register(radioInfo);
        }
    }

    @Override
    public void register(IGracenoteRequest iGracenoteRequest) {
        this.dsiUpManager.register(iGracenoteRequest);
    }

    @Override
    public void register(ITaggingManager iTaggingManager) {
        if (this.tagging != null) {
            this.tagging.register(iTaggingManager);
        }
    }

    @Override
    public IUpdateListener[] getUpdateListeners(IMemoryList iMemoryList) {
        return new IUpdateListener[]{this.dsiUpManager.getUpdateListener(iMemoryList), new AMFMTuner$MemoryListener(this, iMemoryList)};
    }

    @Override
    public IRadioDatabaseListener getDatabaseListener() {
        return new AMFMTuner$RsdbStatusListener(this, null);
    }

    @Override
    public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        this.cmdManager = iRadioCmdManager;
    }

    @Override
    public IRadioCmdManager getCmdManager() {
        return this.cmdManager;
    }

    @Override
    public void audioManagementJustBecameAvailable() {
        this.volumeLockHandler.audioManagementJustBecameAvailable();
    }

    @Override
    public void reRequestCoverArt() {
        this.dsiDownManager.reNotification(11);
        this.dsiDownManager.reNotification(17);
    }

    @Override
    public void abortSeek() {
        if (!this.isSeekActive() || this.abortSeekRunning) {
            this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.abortSeek] Ignore as seek not active, or aborSeekRunning");
            return;
        }
        RadioCommandList radioCommandList = new RadioCommandList(this.cmdManager, "DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdSeekAbort());
        this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.abortSeek] Send ABORT");
        this.cmdManager.enqueue(radioCommandList);
        this.abortSeekRunning = true;
    }

    @Override
    public boolean forceStationListUpdate(boolean bl) {
        boolean bl2 = this.isForcedStationListUpdateRunning();
        this.logger.hmi.log(1078071040, "[AMFMTuner.forceStationListUpdate], start: %1 already running:%2", bl, bl2);
        boolean bl3 = false;
        if (bl && !bl2) {
            this.dsiDownManager.forceAMUpdate(1);
            bl3 = true;
        } else if (!bl && bl2) {
            RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdAbortAMForcedStationListUpdate(this.dsiDownManager));
            this.cmdManager.enqueue(radioCommandList);
            this.models.getChoiceModel(-1987575552).setValue(0);
            this.variantExt.hidePartialPopup(5);
            bl3 = true;
        }
        this.audio.demute();
        return bl3;
    }

    @Override
    public void changeWaveband(int n, TunerObjectContainer tunerObjectContainer, int n2) {
        RadioCommandList radioCommandList;
        this.logger.amfmDSI.log(1078071040, "[AMFMTuner.changeWaveband] band:%2 toc:%1", (Object)tunerObjectContainer, (long)n);
        switch (n) {
            case 1: {
                radioCommandList = this.cmdManager.clSwitchToAMFM(n, n2);
                AMFMStation aMFMStation = this.getActiveStationFM();
                if (tunerObjectContainer != null && tunerObjectContainer.containsAMFMService()) {
                    aMFMStation = tunerObjectContainer.getAMFMService();
                }
                if (aMFMStation != null) {
                    radioCommandList.addBeforeFadeTo(this.cmdManager.cmdTuneAMFMStationBlock(aMFMStation, false, n2));
                    radioCommandList.addAtFirstPos(this.cmdManager.cmdHighlightAMFMStation(aMFMStation, false, n2));
                }
                this.activeStationAM.setAudioStatus(1);
                break;
            }
            case 4: 
            case 10: {
                radioCommandList = this.cmdManager.clSwitchToAMFM(n, n2);
                AMFMStation aMFMStation = null;
                aMFMStation = n == 4 ? this.getActiveStationAM() : this.getActiveStationTI();
                if (tunerObjectContainer != null && tunerObjectContainer.containsAMFMService()) {
                    aMFMStation = tunerObjectContainer.getAMFMService();
                }
                if (aMFMStation != null) {
                    radioCommandList.addBeforeFadeTo(this.cmdManager.cmdTuneAMFMStationBlock(aMFMStation, false, n2));
                    radioCommandList.addAtFirstPos(this.cmdManager.cmdHighlightAMFMStation(aMFMStation, false, n2));
                }
                this.activeStationFM.setAudioStatus(1);
                break;
            }
            default: {
                return;
            }
        }
        this.cmdManager.enqueue(radioCommandList);
    }

    @Override
    public AMFMStation getActiveStation(int n) {
        AMFMStation aMFMStation;
        switch (n) {
            case 4: {
                aMFMStation = this.activeStationAM;
                break;
            }
            case 1: {
                aMFMStation = this.activeStationFM;
                break;
            }
            case 10: {
                aMFMStation = this.activeStationTI;
                break;
            }
            default: {
                aMFMStation = this.activeStation;
            }
        }
        return aMFMStation;
    }

    @Override
    public IAmFmDsiDownManager getDsiDownManager() {
        return this.dsiDownManager;
    }

    @Override
    public IDoTagging getTagging() {
        return this.tagging;
    }

    @Override
    public void switchAF(boolean bl) {
        this.dsiDownManager.switchAF(bl);
    }

    @Override
    public void switchReg(boolean bl) {
        this.logger.hmi.log(-2137614336, "[AMFMTuner.switchReg], box checked: %1", bl);
        int n = bl ? 3 : 1;
        this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.switchReg]doSwitchReg to: %1", (long)n);
        this.dsiDownManager.switchREG(n);
    }

    @Override
    public void tuneStation(AMFMStation aMFMStation, boolean bl, boolean bl2, int n) {
        this.dsiDownManager.tuneStation(aMFMStation, bl, bl2, n);
    }

    void nextSubChannel(int n) {
        if (this.activeStation.waveband == 1 && this.activeStation.isHd()) {
            AMFMStation aMFMStation = Utilities.getNextSubChannel(this.activeStation);
            this.dsiDownManager.tuneStation(aMFMStation, false, false, n);
        }
    }

    private void preTuneActions(AMFMStation aMFMStation) {
        if (this.isSeekActive()) {
            this.abortSeek();
        }
        this.memory.cancelActions();
        this.annHandler.abortAnnouncement();
        this.setActiveStation(aMFMStation);
        if (aMFMStation.waveband == 1) {
            this.setActiveStationFM(aMFMStation);
        } else if (aMFMStation.waveband == 3) {
            if (this.models.getActiveTuner() == 4) {
                this.setActiveStationAM(aMFMStation);
            } else if (this.models.getActiveTuner() == 10) {
                this.setActiveStationTI(aMFMStation);
            }
        } else {
            this.logger.amfmDSI.log(10000, "[AMFMTuner.preTuneAction] wrong station %1", (Object)aMFMStation);
        }
    }

    @Override
    public AMFMStation getActiveStation() {
        return this.activeStation;
    }

    @Override
    public AMFMStation getStationWanted() {
        int[] nArray = this.storage.loadLastMode();
        switch (nArray[1]) {
            case 1: 
            case 4: 
            case 10: {
                return this.storage.getAMFMLSM(nArray[1]);
            }
        }
        this.logger.hmi.log(10000, "[AMFMTuner.getStationWanted]", (Throwable)new IllegalStateException(new StringBuffer().append("Invalid band ").append(nArray[1]).toString()));
        return this.storage.getAMFMLSM(1);
    }

    @Override
    public void clearNotification(int[] nArray) {
        this.logger.amfmDSI.log(1078071040, "[AMFMTuner.clearNotification] %1", (Object)nArray);
        this.dsiDownManager.clearNotification(nArray, this.dsiAmFmTunerListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logger.hmi.log(-2137614336, "[AMFMTuner.deinit]");
        this.dsiDownManager.clearNotification(this.attr, this.dsiAmFmTunerListener);
        Object object = this.mutexInit;
        synchronized (object) {
            this.initAlreadyTriggered = false;
            this.initDone = false;
        }
    }

    @Override
    public ITunerGUIHandler getGUIHandler() {
        return this.guiHandler;
    }

    public int getType() {
        return 1;
    }

    @Override
    public void setInitDone() {
        this.logger.main.log(-2137614336, "[AMFMTuner.setInitDone]");
        this.initDone = true;
    }

    public boolean isInitDone() {
        return this.initDone;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int init() {
        this.logger.main.log(1078071040, "[AMFMTuner.init]");
        Object object = this.mutexInit;
        synchronized (object) {
            if (this.initAlreadyTriggered) {
                this.logger.main.log(1078071040, "[AMFMTuner.init] Already triggered!");
                return 0;
            }
            if (!this.isDsiFound()) {
                this.logger.startup.log(1078071040, "[AMFMTuner.init] abort: No dsi available!");
                return 2;
            }
            switch (this.models.getActiveTuner()) {
                case 4: {
                    this.setActiveStation(this.getActiveStationAM());
                    break;
                }
                case 10: {
                    this.setActiveStation(this.getActiveStationTI());
                    break;
                }
                default: {
                    this.setActiveStation(this.getActiveStationFM());
                }
            }
            this.guiHandler.setSelectedStation(this.getActiveStation());
            this.executeInitialCommands();
            RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdInitAmFmDone());
            this.cmdManager.enqueue(radioCommandList);
            this.initAlreadyTriggered = true;
        }
        return 1;
    }

    @Override
    public void initSetup() {
        this.guiHandler.initSetup();
        this.logger.amfmDSI.log(1078071040, "[AMFMTuner.initSetup]: Setting notification on tuner attributes");
        this.dsiDownManager.setNotification(this.attr, this.dsiAmFmTunerListener);
        if (Utilities.isRadioTextPlusActivated()) {
            int[] nArray = new int[]{32, 31, 4, 8, 7, 1, 33, 36};
            if (Utilities.isStd()) {
                this.dsiDownManager.enableRadiotextPlus(Utilities.combineArrays(nArray, RadiotextHyperlinkProcessor.HYPERLINK_TAGS_MIB2_STD));
            } else {
                this.dsiDownManager.enableRadiotextPlus(Utilities.combineArrays(nArray, RadiotextHyperlinkProcessor.HYPERLINK_TAGS));
            }
            this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.initSetup]: Calling enableRadioTextPlus");
        } else {
            this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.init]: RT+ is disabled by coding");
        }
        this.dsiDownManager.switchRDSIgnore(Utilities.isJapan());
        this.dsiDownManager.setERTPrefered(true);
        this.dsiDownManager.setERTDisplayable(true);
    }

    @Override
    public void executeInitialCommands() {
        this.logger.startup.log(1078071040, "[AMFMTuner.executeInitialCommands]");
        boolean bl = this.storage.isAmFmHdTuner();
        int n = this.models.getActiveTuner();
        boolean bl2 = n == 4 || n == 1 || n == 10;
        boolean bl3 = this.status.hasAudioFocus(0) && bl2;
        RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdWaitDSIRegistered(this));
        radioCommandList.add(this.cmdManager.cmdWaitAMFMTunerReady(bl));
        radioCommandList.add(this.cmdManager.cmdSwitchAMFMUsage(bl3));
        radioCommandList.add(this.cmdManager.cmdInitSetup(this));
        radioCommandList.add(this.cmdManager.cmdWaitAMAvilable());
        this.cmdManager.enqueue(radioCommandList);
        if (bl3) {
            int n2 = 0;
            RadioCommandList radioCommandList2 = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList2.add(this.cmdManager.cmdRequestConnection(n, n2));
            radioCommandList2.add(this.cmdManager.cmdSwitchUniUsage(false));
            radioCommandList2.add(this.cmdManager.cmdSwitchDABUsage(false));
            radioCommandList2.add(this.cmdManager.cmdSwitchAMFMUsage(true));
            radioCommandList2.add(this.cmdManager.cmdTuneAMFMStationBlock(this.getActiveStation(), false, 0));
            radioCommandList2.add(this.cmdManager.cmdFadeToConnection(n, n2));
            this.cmdManager.enqueue(radioCommandList2);
        }
    }

    @Override
    public boolean isDsiFound() {
        return this.dsiDownManager.isDsiFound();
    }

    @Override
    public void resetToDefaultSettings() {
        boolean bl;
        boolean bl2;
        this.logger.hmi.log(-2137614336, "[AMFMTuner.resetToDefaultSettings]");
        int[] nArray = AMFMSetupHandler.getDefaultSetup();
        this.guiHandler.processSetup(nArray);
        boolean bl3 = bl2 = nArray[9] == 0;
        if (bl2) {
            this.status.setAmHdModeOn(false);
            this.activeStationAM = new AMFMStation(this.activeStationAM, 0);
            this.activeStationAM.hd = false;
        }
        boolean bl4 = bl = nArray[8] == 0;
        if (bl) {
            this.status.setFmHdModeOn(false);
            this.activeStationFM = new AMFMStation(this.activeStationFM, 0);
            this.activeStationFM.hd = false;
            this.activeStationFM.serviceId = 1;
        }
        this.psFreezeDB.removeAll();
        this.dsiDownManager.reset(1);
        this.dsiDownManager.reset(2);
        this.storage.storeHdTuner(false);
    }

    @Override
    public void seekStation(int n, int n2) {
        this.logger.main.log(-2137614336, "[AMFMTuner.seekStation] mode:%1 HT:%2", (long)n, (long)n2);
        this.annHandler.abortAnnouncement();
        this.logger.amfmDSI.log(1078071040, "[AMFMTuner.seekStation] mode:%1", (long)n);
        this.dsiDownManager.seekStation(n);
        if (n2 != -2) {
            this.audio.demute(n2);
        }
    }

    @Override
    public boolean isDeviceInUse() {
        return this.deviceUsage.getStatus() == 2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setComponentUsage(boolean bl) {
        this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.setComponentUsage], used: %1", bl);
        if (!bl) {
            this.activeStation.setAudioStatus(1);
            this.activeStationAM.setAudioStatus(1);
            this.activeStationFM.setAudioStatus(1);
        }
        if (this.isDsiFound()) {
            int n = bl ? 2 : 1;
            boolean bl2 = false;
            GeneralStatusHandler generalStatusHandler = this.deviceUsage;
            synchronized (generalStatusHandler) {
                if (n != this.deviceUsage.getStatus()) {
                    this.dsiDownManager.switchLinkingDeviceUsage(n);
                    this.deviceUsage.setStatus(n);
                    bl2 = true;
                }
            }
            if (bl2) {
                this.logger.amfmDSI.log(1078071040, "[AMFMTuner.switchLinkingDeviceUsage] to state: %1", (long)n);
            }
        } else {
            this.logger.amfmDSI.log(1078071040, "[AMFMTuner.switchLinkingDeviceUsage] no DSI available", bl);
        }
    }

    @Override
    public void setComponentUnused() {
        RadioCommandList radioCommandList = new RadioCommandList(this.cmdManager, "DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdSeekAbort());
        radioCommandList.add(this.cmdManager.cmdSwitchAMFMUsage(false));
        this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.setComponentUnused]");
        this.cmdManager.enqueue(radioCommandList);
    }

    @Override
    public void setDeviceService(DSIBase dSIBase) {
        this.logger.startup.log(-2137614336, "[AMFMTuner.setDeviceService]");
        this.dsiDownManager.setDeviceService((DSIAMFMTuner)dSIBase);
        if (this.isDsiFound()) {
            this.cmdManager.getActiveAllBandCmd(this).dsiRegistered(dSIBase);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        this.dsiDownManager.setNotification(nArray, this.dsiAmFmTunerListener);
    }

    @Override
    public void reNotification(int n) {
        this.dsiDownManager.reNotification(n);
    }

    public void forceAMUpdateStatus(int n) {
        if (this.amUpdateStatus == n) {
            return;
        }
        this.amUpdateStatus = n;
        if (n == 1) {
            this.models.getChoiceModel(-1987575552).setValue(1);
            this.variantExt.showPartialPopup(5);
        } else {
            this.models.getChoiceModel(-1987575552).setValue(0);
            this.variantExt.hidePartialPopup(5);
        }
        this.propagateUpdatedForceStationListUpdateStatus(this.models.getActiveTuner(), n);
    }

    public void seekStationStatus(boolean bl) {
        this.seekRunning = bl;
        if (this.seekRunning) {
            this.seekUpdateTime = 0L;
            this.propagateupdatedSeekStatus(true);
        } else {
            this.models.getButtonModel(528941312).setPressed(false);
            this.models.getButtonModel(830931200).setPressed(false);
            this.abortSeekRunning = false;
            this.propagateupdatedSeekStatus(false);
        }
    }

    @Override
    public boolean isSeekActive() {
        return this.seekRunning;
    }

    public boolean isForcedStationListUpdateRunning() {
        return this.amUpdateStatus == 1;
    }

    public void updateAFSwitchStatus(boolean bl) {
        int n = bl ? 1 : 0;
        this.models.getChoiceModel(780665088).setValue(n);
        this.guiHandler.setupValueUpdated(n, 1);
    }

    public void updateDetectedDevice(int n) {
        if (n == 3 || n == 4) {
            if (n == 4) {
                this.models.getChoiceModel(1200095488).setValue(1);
                this.status.setIbocPresent(true);
                this.storage.storeHdTuner(true);
            } else {
                this.models.getChoiceModel(1200095488).setValue(0);
                this.status.setIbocPresent(false);
            }
        }
    }

    public void updateREGSwitchStatus(int n) {
        int n2 = n == 1 ? 0 : 1;
        this.models.getChoiceModel(797442304).setValue(n2);
        this.guiHandler.setupValueUpdated(n2, 2);
    }

    public void updateSelectedStation(AMFMStation aMFMStation) {
        if (this.isSeekActive()) {
            long l = Utilities.getFramework().getMonotonicTime();
            if (l - this.seekUpdateTime < 0 || this.abortSeekRunning) {
                return;
            }
            this.seekUpdateTime = l;
        }
        this.doUpdateSelectedStation(aMFMStation);
    }

    private void doUpdateSelectedStation(AMFMStation aMFMStation) {
        this.storeLSM(aMFMStation);
        this.guiHandler.setSelectedStation(aMFMStation);
        this.setActiveStation(aMFMStation);
    }

    private void storeLSM(AMFMStation aMFMStation) {
        if (this.isSeekActive()) {
            return;
        }
        this.storeLastStation(aMFMStation, this.models.getActiveTuner());
    }

    private void updateStationListFM() {
        if (!this.firstStationListFMReceived) {
            Utilities.getFramework().getStartupMgr().logStartupEvent("Sender list: FM received");
            this.firstStationListFMReceived = true;
        }
    }

    private void updateStationListAM() {
        if (!this.firstStationListAMReceived) {
            Utilities.getFramework().getStartupMgr().logStartupEvent("Sender list: AM received");
            this.firstStationListAMReceived = true;
        }
    }

    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.wavebandInfoList = wavebandInfoArray;
        this.bandList.setAvailableWaveBands(wavebandInfoArray);
        this.limitActiveStationFrequencies(wavebandInfoArray);
        this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.updateWavebandInfoList] updateWavebandInfo called ");
        for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
            this.logger.amfmDSI.log(14808325, "[AMFMTuner.updateWavebandInfoList] band:%1 ", (Object)wavebandInfoArray[i2]);
        }
    }

    private void limitActiveStationFrequencies(WavebandInfo[] wavebandInfoArray) {
        WavebandInfo[] wavebandInfoArray2 = null;
        ArrayList arrayList = new ArrayList(2);
        block4: for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
            switch (wavebandInfoArray[i2].waveband) {
                case 1: {
                    wavebandInfoArray2 = new WavebandInfo[]{wavebandInfoArray[i2]};
                    continue block4;
                }
                case 3: {
                    arrayList.add(wavebandInfoArray[i2]);
                    continue block4;
                }
            }
        }
        if (wavebandInfoArray2 != null) {
            this.activeStationFM.frequency = this.limitFrequencyToWavebandInfo(this.activeStationFM.frequency, wavebandInfoArray2);
        }
        if (!arrayList.isEmpty()) {
            this.activeStationAM.frequency = this.limitFrequencyToWavebandInfo(this.activeStationAM.frequency, (WavebandInfo[])arrayList.toArray(new WavebandInfo[arrayList.size()]));
        }
        this.setActiveStationFrequency();
    }

    private long limitFrequencyToWavebandInfo(long l, WavebandInfo[] wavebandInfoArray) {
        for (int i2 = 0; i2 < wavebandInfoArray.length; ++i2) {
            boolean bl = true;
            if (l < wavebandInfoArray[i2].lowerLimit) {
                bl = false;
            } else if (l > wavebandInfoArray[i2].upperLimit) {
                bl = false;
            }
            long l2 = l - wavebandInfoArray[i2].lowerLimit;
            if (wavebandInfoArray[i2].stepWidth != 0L && l2 % wavebandInfoArray[i2].stepWidth != 0L) {
                bl = false;
            }
            if (!bl) continue;
            return l;
        }
        this.logger.amfmDSI.log(10000, "[AMFMTuner.limitFrequencyToWavebandInfo] %1", (Object)wavebandInfoArray[0]);
        if (wavebandInfoArray[0].waveband == 1) {
            return 0;
        }
        return 0;
    }

    private void setActiveStationFrequency() {
        switch (this.models.getActiveTuner()) {
            case 4: {
                this.activeStation.frequency = this.activeStationAM.frequency;
                break;
            }
            case 1: {
                this.activeStation.frequency = this.activeStationFM.frequency;
                break;
            }
        }
    }

    @Override
    public void switchHD(boolean bl, boolean bl2) {
        this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.switchHD] AM:%1 FM %2", bl, bl2);
        int n = 2;
        if (bl && bl2) {
            n = 1;
        } else if (bl) {
            n = 6;
        } else if (bl2) {
            n = 5;
        }
        this.dsiDownManager.setModeHD(n);
        this.status.setFmHdModeOn(bl2);
        this.status.setAmHdModeOn(bl);
    }

    public void setActiveStation(AMFMStation aMFMStation) {
        this.logger.dd.log(14808325, "[AMFMTuner.setActiveStation] %1", (Object)aMFMStation);
        this.activeStation = aMFMStation;
    }

    public void setActiveStationFM(AMFMStation aMFMStation) {
        this.activeStationFM = aMFMStation;
    }

    public AMFMStation getActiveStationFM() {
        return this.activeStationFM;
    }

    public void setActiveStationAM(AMFMStation aMFMStation) {
        this.activeStationAM = aMFMStation;
    }

    public void setActiveStationTI(AMFMStation aMFMStation) {
        this.activeStationTI = aMFMStation;
    }

    public AMFMStation getActiveStationAM() {
        return this.activeStationAM;
    }

    public AMFMStation getActiveStationTI() {
        if (this.activeStationTI.frequency != 0 && this.activeStationTI.frequency != 0) {
            this.logger.amfmDSI.log(10000, "[AMFMTuner.getActiveStationTI] wrong TI Station %1", (Object)this.activeStationTI);
            this.activeStationTI = new AMFMStation("", 0, -1, 0, 0, 3, false, false, false, false, false, false, "", false, "", "", false, 0);
        }
        return this.activeStationTI;
    }

    public void updateHdMode(int n) {
        int n2;
        int n3;
        switch (n) {
            case 1: {
                n3 = 1;
                n2 = 1;
                break;
            }
            case 6: {
                n3 = 1;
                n2 = 0;
                break;
            }
            case 5: {
                n3 = 0;
                n2 = 1;
                break;
            }
            default: {
                n3 = 0;
                n2 = 0;
            }
        }
        this.models.getChoiceModel(-561512192).setValue(n3);
        this.guiHandler.setupValueUpdated(n3, 9);
        this.models.getChoiceModel(-544734976).setValue(n2);
        this.guiHandler.setupValueUpdated(n2, 8);
        this.status.setFmHdModeOn(n2 == 1);
        this.status.setAmHdModeOn(n3 == 1);
    }

    public void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        this.guiHandler.addUpdateListeners(iUpdateListenerArray);
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    public StationNameHistory getStationNameHistory() {
        return this.dsiUpManager.getStationNameHistory();
    }

    @Override
    public TunerActionProxyListener[] getActionProxyListeners() {
        int n = 1;
        AMFMTuner$TunerActionProxyListenerExt aMFMTuner$TunerActionProxyListenerExt = new AMFMTuner$TunerActionProxyListenerExt(this, null);
        TunerActionProxyListener[] tunerActionProxyListenerArray = this.guiHandler.getActionProxyListeners();
        TunerActionProxyListener[] tunerActionProxyListenerArray2 = new TunerActionProxyListener[n + tunerActionProxyListenerArray.length];
        tunerActionProxyListenerArray2[0] = aMFMTuner$TunerActionProxyListenerExt;
        System.arraycopy((Object)tunerActionProxyListenerArray, 0, (Object)tunerActionProxyListenerArray2, n, tunerActionProxyListenerArray.length);
        return tunerActionProxyListenerArray2;
    }

    @Override
    public CmdDefaultListener getDSIUpManager() {
        return this.dsiUpManager;
    }

    public AMFMTunerService getJpTunerListener() {
        return this.dsiUpManager.jpNameListener;
    }

    @Override
    public void performLanguageChange() {
        this.dsiDownManager.reNotification(2);
    }

    private void storeLastStation(AMFMStation aMFMStation, int n) {
        int n2 = Utilities.getWavebandByBand(n);
        if (n2 != aMFMStation.waveband) {
            this.logger.amfmDSI.log(10000, "[AMFMTuner.storeLastStation] wb mismatch: %2 vs. %1", (Object)aMFMStation, (long)n);
            return;
        }
        for (int i2 = 0; i2 < this.wavebandInfoList.length; ++i2) {
            WavebandInfo wavebandInfo = this.wavebandInfoList[i2];
            if (wavebandInfo == null || wavebandInfo.waveband != n2) continue;
            if (aMFMStation.frequency >= wavebandInfo.lowerLimit && aMFMStation.frequency <= wavebandInfo.upperLimit && (wavebandInfo.upperLimit - aMFMStation.frequency) % wavebandInfo.stepWidth == 0L) {
                this.storage.storeLastStation(aMFMStation, this.models.getActiveTuner());
                return;
            }
            this.logger.amfmDSI.log(10000, "[AMFMTuner.storeLastStation] frequency mismatch: %2 vs. %1", (Object)aMFMStation, (Object)wavebandInfo);
            return;
        }
        this.logger.amfmDSI.log(10000, "[AMFMTuner.storeLastStation] waveband not found: %1", (Object)aMFMStation);
    }

    @Override
    public TunerObjectContainer[] startScan() {
        int n;
        this.dsiDownManager.clearNotification(new int[]{2, 3}, this.dsiAmFmTunerListener);
        Object[] objectArray = this.guiHandler.getStationList();
        if (Utilities.isPGen1OrBentley()) {
            Arrays.sort(objectArray, new SortAlgoFrequency());
        }
        Object[] objectArray2 = objectArray;
        long l = this.activeStation.getUniqueId();
        for (n = 0; n < objectArray.length && ((TunerObjectContainer)objectArray[n]).getListID() != l; ++n) {
        }
        if (n == objectArray.length && this.activeStation.waveband == 3) {
            long l2 = this.activeStation.frequency;
            for (n = 0; n < objectArray.length; ++n) {
                AMFMStation aMFMStation = ((TunerObjectContainer)objectArray[n]).getAMFMService();
                if (aMFMStation.frequency != l2) continue;
                this.logger.amfmDSI.log(-2137614336, "[AMFMTuner.startScan] not found by ID: sought: %1, by freq found: %2", (Object)this.activeStation, (Object)aMFMStation);
                break;
            }
        }
        if (n == objectArray.length) {
            this.logger.amfmDSI.log(-1601830656, "[AMFMTuner.startScan] active station not found %1", (Object)this.activeStation);
            objectArray2 = new TunerObjectContainer[objectArray.length + 1];
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, 0, objectArray.length);
            objectArray2[n] = new TunerObjectContainer(this.activeStation);
        } else if (n == objectArray.length - 1) {
            objectArray2 = objectArray;
        } else {
            objectArray2 = new TunerObjectContainer[objectArray.length];
            int n2 = n + 1;
            int n3 = objectArray.length - n2;
            System.arraycopy((Object)objectArray, n2, (Object)objectArray2, 0, n3);
            System.arraycopy((Object)objectArray, 0, (Object)objectArray2, n3, n2);
        }
        return objectArray2;
    }

    @Override
    public void stopScan() {
        this.dsiDownManager.setNotification(new int[]{2, 3}, this.dsiAmFmTunerListener);
    }

    static /* synthetic */ void access$400(AMFMTuner aMFMTuner, AMFMStation aMFMStation) {
        aMFMTuner.preTuneActions(aMFMStation);
    }

    static /* synthetic */ TunerModels access$500(AMFMTuner aMFMTuner) {
        return aMFMTuner.models;
    }

    static /* synthetic */ void access$600(AMFMTuner aMFMTuner, AMFMStation aMFMStation, int n) {
        aMFMTuner.storeLastStation(aMFMStation, n);
    }

    static /* synthetic */ void access$700(AMFMTuner aMFMTuner) {
        aMFMTuner.updateStationListFM();
    }

    static /* synthetic */ void access$800(AMFMTuner aMFMTuner) {
        aMFMTuner.updateStationListAM();
    }

    static /* synthetic */ boolean access$900(AMFMTuner aMFMTuner) {
        return aMFMTuner.seekRunning;
    }

    static /* synthetic */ AMFMStation access$1000(AMFMTuner aMFMTuner) {
        return aMFMTuner.activeStation;
    }

    static /* synthetic */ AMFMStation access$1100(AMFMTuner aMFMTuner) {
        return aMFMTuner.activeStationAM;
    }

    static /* synthetic */ AMFMStation access$1200(AMFMTuner aMFMTuner) {
        return aMFMTuner.activeStationFM;
    }

    static /* synthetic */ AMFMDSIUpManager access$1300(AMFMTuner aMFMTuner) {
        return aMFMTuner.dsiUpManager;
    }
}

