/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.atip.phone.ITelService;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerStatus;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.audiodrawer.AudioDrawerStateTracker;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.NullRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.epg.ClockTimeZoneOffsetHandler;
import de.audi.tuner.app.epg.sdars.SDARSEPGHandler;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.sdars.ArtistTitleList;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.GUIHandlerSDARS;
import de.audi.tuner.app.sdars.PdtInfoHandler;
import de.audi.tuner.app.sdars.SDARSAdvisoryHandler;
import de.audi.tuner.app.sdars.SDARSLabels;
import de.audi.tuner.app.sdars.SDARSManTune;
import de.audi.tuner.app.sdars.SDARSStationDescriptions;
import de.audi.tuner.app.sdars.SDARSStationListHandler;
import de.audi.tuner.app.sdars.SDARSStatusManager;
import de.audi.tuner.app.sdars.SDARSVolumeLockHandler;
import de.audi.tuner.app.sdars.SDARSWatch;
import de.audi.tuner.app.sdars.SdarsRadioTextHistory;
import de.audi.tuner.app.sdars.SdarsSpellerHandler;
import de.audi.tuner.app.sdars.SdarsSubscriptionMngr;
import de.audi.tuner.app.sdars.StationInfoExt;
import de.audi.tuner.app.sdars.dsi.ISdarsDsiDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDSIDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDSISeekDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDSIUpManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiDownInfo;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.seek.AbstractSeekListSizeRistrictionHandler;
import de.audi.tuner.app.sdars.seek.AlertHandler;
import de.audi.tuner.app.sdars.seek.AlertsToEntertainmentDrawerDelivery;
import de.audi.tuner.app.sdars.seek.DSISDARSSeekListenerImpl;
import de.audi.tuner.app.sdars.seek.GameHandler;
import de.audi.tuner.app.sdars.seek.MusicHandler;
import de.audi.tuner.app.sdars.seek.SeekActiveContentHandler;
import de.audi.tuner.app.sdars.seek.WeatherHandler;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISDARSTuner;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.audi.tuner.util.NullDSISDARSTunerListener;
import java.util.ArrayList;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSSeek;
import org.dsi.ifc.sdars.DSISDARSSeekListener;
import org.dsi.ifc.sdars.DSISDARSTuner;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;

public class SDARSTuner
extends UpdateListenerHandler
implements ISDARSTuner {
    public static final int SXM_DEFAULT_CHANNEL_SID = 1;
    public static final short SXM_DEFAULT_CHANNEL_NUMBER = 1;
    private DSISDARSTunerListener dsiSDARSTunerListener;
    private IRadioCmdManager cmdManager;
    private final GUIHandlerSDARS guiHandler;
    private final SDARSDSISeekDownManager dsiSeekDownManager;
    private final SeekActiveContentHandler seekHandler;
    private final GameHandler gameAlertHandler;
    private final MusicHandler musicAlertHandler;
    private final AlertHandler alertHandler;
    private final AbstractSeekListSizeRistrictionHandler seekListSizeRistrictionHandler;
    private final PdtInfoHandler pdtHandler;
    private final SDARSAdvisoryHandler advisoryHandler;
    private SdarsSpellerHandler spellerHandler;
    private final SDARSStatusManager statusManager;
    private final SDARSDSIUpManager dsiUpManager;
    private final ISdarsDsiDownManager dsiDownManager;
    private volatile boolean initDone;
    final int[] attributes = new int[]{6, 10, 27, 2, 7, 13, 28};
    StationInfoExt[] currentStationList = new StationInfoExt[0];
    private StationInfoExt[] receivedStationList = new StationInfoExt[0];
    private StationInfoExt activeStation = new StationInfoExt();
    private final Object mutexInit = new Object();
    private volatile boolean initAlreadyTriggered;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final TunerStorage storage;
    private final BandListHandler bandList;
    private final MemoryListHandler memory;
    private final TunerAudioMgmt audio;
    private final SDARSWatch watch;
    private final SDARSLabels sdarsLabels;
    private final SDARSStationDescriptions sdarsStationDescriptions;
    private final AudioDrawerStateTracker audioDrawerStateTracker;
    private boolean firstStationListSDARSReceived = false;
    private final SDARSEPGHandler epgHandler;
    private final SDARSManTune manTune;
    private final DSISDARSSeekListener seekListener;
    private final WeatherHandler weatherHandler;
    private final SDARSVolumeLockHandler volumeLockHandler;
    private int availability = 0;
    private StationInfoExt defaultChannel;

    public SDARSTuner(TunerBasics tunerBasics, TunerStorage tunerStorage, BandListHandler bandListHandler, MemoryListHandler memoryListHandler, TunerAudioMgmt tunerAudioMgmt, ITaggingManager iTaggingManager, LanguageManager languageManager, ITunerVariantExt iTunerVariantExt, IScanHandler iScanHandler, ClockTimeZoneOffsetHandler clockTimeZoneOffsetHandler, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor, SDARSStationDescriptions sDARSStationDescriptions, AudioDrawerStateTracker audioDrawerStateTracker) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.storage = tunerStorage;
        this.bandList = bandListHandler;
        this.memory = memoryListHandler;
        this.audio = tunerAudioMgmt;
        this.audioDrawerStateTracker = audioDrawerStateTracker;
        this.logger.initSDARSLogChannels();
        Object object = new Object();
        this.dsiDownManager = new SDARSDSIDownManager(tunerBasics, object);
        this.dsiUpManager = new SDARSDSIUpManager(tunerBasics, this.dsiDownManager, object);
        this.seekListener = new DSISDARSSeekListenerImpl(this.logger.sdarsSeekDSI, this.dsiUpManager);
        this.dsiSeekDownManager = new SDARSDSISeekDownManager(tunerBasics, this.seekListener);
        this.dsiUpManager.setSeekDownManager(this.dsiSeekDownManager);
        this.seekListSizeRistrictionHandler = iTunerVariantExt.getSeekListRestriction(tunerBasics, this.dsiSeekDownManager);
        this.seekHandler = new SeekActiveContentHandler(tunerBasics, this.dsiSeekDownManager, iTunerVariantExt, this.seekListSizeRistrictionHandler);
        this.gameAlertHandler = new GameHandler(tunerBasics, languageManager, this.dsiSeekDownManager, iTunerVariantExt, this.seekListSizeRistrictionHandler);
        this.musicAlertHandler = new MusicHandler(tunerBasics, this.dsiSeekDownManager, iTunerVariantExt);
        this.volumeLockHandler = new SDARSVolumeLockHandler(tunerAudioMgmt);
        this.weatherHandler = new WeatherHandler(tunerBasics, this.dsiSeekDownManager, iTunerVariantExt, this.seekListSizeRistrictionHandler);
        this.watch = new SDARSWatch(this);
        this.dsiSDARSTunerListener = new NullDSISDARSTunerListener(this.logger.sdarsDSI);
        this.cmdManager = new NullRadioCmdManager(tunerBasics);
        this.pdtHandler = new PdtInfoHandler(tunerBasics, iTaggingManager);
        this.alertHandler = new AlertHandler(tunerBasics, this.pdtHandler, iTunerVariantExt, iScanHandler);
        AlertsToEntertainmentDrawerDelivery alertsToEntertainmentDrawerDelivery = new AlertsToEntertainmentDrawerDelivery(tunerBasics);
        this.alertHandler.addEnrichedSeekAlertListener(alertsToEntertainmentDrawerDelivery);
        this.advisoryHandler = new SDARSAdvisoryHandler(tunerBasics, this);
        this.epgHandler = new SDARSEPGHandler(this.dsiDownManager, tunerBasics, clockTimeZoneOffsetHandler, iTunerVariantExt, languageManager, iScanHandler);
        SDARSStationListHandler sDARSStationListHandler = iTunerVariantExt.getSDARSStationListHandler(this, tunerBasics, memoryListHandler.storeHandler, languageManager, iTunerVariantExt.getListRowFactory(), iScanHandler, tunerStorage);
        this.guiHandler = new GUIHandlerSDARS(this, tunerBasics, tunerStorage, sDARSStationListHandler, this.epgHandler);
        this.sdarsLabels = new SDARSLabels(tunerBasics, this.pdtHandler, this.watch, sDARSStationDescriptions);
        this.sdarsStationDescriptions = sDARSStationDescriptions;
        this.statusManager = new SDARSStatusManager(tunerBasics, this.advisoryHandler, this.guiHandler);
        this.guiHandler.getSdarsListHandler().getCategoryListHandler().addListener(this.epgHandler.catFilterListener);
        SdarsRadioTextHistory sdarsRadioTextHistory = new SdarsRadioTextHistory(tunerBasics, this.pdtHandler, radiotextHyperlinkProcessor);
        sdarsRadioTextHistory.init();
        this.activeStation = tunerStorage.loadLastSDARSStation();
        this.dsiUpManager.register(new DsiUpListener());
        this.dsiUpManager.register(this.sdarsLabels.dsiUpInfo);
        this.dsiUpManager.register(this.guiHandler.getSdarsListHandler().dsiUpInfo);
        this.dsiUpManager.register(this.pdtHandler.dsiUpListener);
        this.dsiUpManager.register(this.watch.dsiUpListener);
        this.dsiUpManager.register(this.dsiDownManager.getDsiUpListener());
        this.dsiUpManager.register(this.volumeLockHandler.dsiUpListener);
        this.dsiUpManager.register(memoryListHandler.sdarsDsiUpListener);
        this.dsiUpManager.register(this.epgHandler.dsiUpInfo);
        this.dsiUpManager.register(new SdarsSubscriptionMngr((TunerBasics)tunerBasics).dsiUpListener);
        this.dsiUpManager.register(this.seekListSizeRistrictionHandler.dsiUpListener);
        this.dsiUpManager.register(this.seekHandler.dsiUpListener);
        this.dsiUpManager.register(this.gameAlertHandler.dsiUpListener);
        this.dsiUpManager.register(this.musicAlertHandler.dsiUpListener);
        this.dsiUpManager.register(this.weatherHandler.dsiUpListener);
        this.dsiUpManager.register(this.alertHandler.dsiUpListener);
        this.dsiUpManager.register(sdarsRadioTextHistory.dsiUpInfo);
        this.dsiUpManager.register(memoryListHandler.highlightListener);
        this.dsiDownManager.register(new DsiDownListener());
        this.dsiDownManager.register(memoryListHandler.highlightListener);
        this.dsiDownManager.register(sdarsRadioTextHistory.dsiDownInfo);
        this.dsiDownManager.register(this.seekHandler.dsiDownListener);
        if (Utilities.isPGen1OrBentley()) {
            this.spellerHandler = new SdarsSpellerHandler(tunerBasics, this.guiHandler, this, iScanHandler);
            this.dsiUpManager.register(this.spellerHandler.dsiUpInfo);
        }
        this.manTune = new SDARSManTune(tunerBasics, this, iScanHandler, tunerStorage);
        this.dsiUpManager.register(this.manTune.dsiUpInfo);
        ArtistTitleList artistTitleList = new ArtistTitleList(tunerBasics, languageManager, iTunerVariantExt.getListRowFactory());
        this.guiHandler.getSdarsListHandler().getCategoryListHandler().addListener(artistTitleList.catFilterListener);
        this.dsiUpManager.register(artistTitleList.dsiUpListener);
        this.dsiDownManager.register(this.dsiUpManager.dsiDownListener);
        this.dsiDownManager.register(this.guiHandler.getSdarsListHandler().dsiDownInfo);
        this.dsiDownManager.register(this.sdarsLabels.dsiDownInfo);
        this.defaultChannel = new StationInfoExt();
        this.defaultChannel.stationNumber = 1;
        this.defaultChannel.sID = 1;
    }

    public TunerActionProxyListener[] getActionProxyListeners() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.gameAlertHandler.actionProxy);
        arrayList.add(this.seekHandler.actionProxyListener);
        if (this.manTune != null) {
            arrayList.add(this.manTune.actionProxy);
        }
        if (this.spellerHandler != null) {
            arrayList.add(this.spellerHandler.proxyListener);
        }
        return (TunerActionProxyListener[])arrayList.toArray(new TunerActionProxyListener[arrayList.size()]);
    }

    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return this.dsiUpManager.getUpdateListener(iMemoryList);
    }

    public SDARSEPGHandler getSdarsEpgHandler() {
        return this.epgHandler;
    }

    public AlertHandler getAlertHandler() {
        return this.alertHandler;
    }

    public SDARSDSISeekDownManager getDsiSeekDownManager() {
        return this.dsiSeekDownManager;
    }

    public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        this.cmdManager = iRadioCmdManager;
    }

    public IRadioCmdManager getCmdManager() {
        return this.cmdManager;
    }

    public DSISDARSSeekListener getSeekListener() {
        return this.seekListener;
    }

    public void audioManagementJustBecameAvailable() {
        this.volumeLockHandler.audioManagementJustBecameAvailable();
    }

    public void sdarsSelected(StationInfoExt stationInfoExt, int n) {
        this.statusManager.sdarsSelected();
        RadioCommandList radioCommandList = this.cmdManager.clSwitchToSDARS(n);
        radioCommandList.addBeforeFadeTo(this.cmdManager.cmdSelectSDARSServiceBlock(stationInfoExt != null ? stationInfoExt : this.activeStation));
        this.cmdManager.enqueue(radioCommandList);
    }

    public void register(DSIListener dSIListener) {
        this.dsiSDARSTunerListener = (DSISDARSTunerListener)dSIListener;
    }

    public void registerDsiUpDownListener(RadioInfo radioInfo) {
        if (radioInfo instanceof SDARSDsiUpInfo) {
            this.dsiUpManager.register(radioInfo);
        } else if (radioInfo instanceof SDARSDsiDownInfo) {
            this.dsiDownManager.register(radioInfo);
            this.dsiSeekDownManager.register((SDARSDsiDownInfo)radioInfo);
        } else {
            this.dsiUpManager.register(radioInfo);
            this.dsiDownManager.register(radioInfo);
        }
    }

    public void register(IGracenoteRequest iGracenoteRequest) {
        this.pdtHandler.register(iGracenoteRequest);
    }

    public void register(ITaggingManager iTaggingManager) {
        this.sdarsLabels.register(iTaggingManager);
    }

    public void setNotification(int[] nArray) {
        this.dsiDownManager.setNotification(nArray, this.dsiSDARSTunerListener);
    }

    public void setHmiReady() {
        this.dsiDownManager.setHmiReady();
    }

    public void clearNotification(int[] nArray) {
        this.dsiDownManager.clearNotification(nArray, this.dsiSDARSTunerListener);
    }

    public void setInitDone() {
        this.logger.main.log(10000000, "[SDARSTuner.setInitDone]");
        this.initDone = true;
    }

    public boolean isInitDone() {
        return this.initDone;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int init() {
        this.logger.main.log(1000000, "[SDARSTuner.init]");
        Object object = this.mutexInit;
        synchronized (object) {
            if (this.initAlreadyTriggered) {
                this.logger.main.log(1000000, "[SDARSTuner.init] Already triggered!");
                return 0;
            }
            if (!this.isDsiFound()) {
                this.logger.startup.log(1000000, "[SDARSTuner.init] abort: No dsi available!");
                return 2;
            }
            if (this.getActiveStation() != null) {
                this.currentStationList = new StationInfoExt[]{this.getActiveStation()};
                this.receivedStationList = null;
            }
            this.executeInitialCommands();
            RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdInitSdarsDone());
            this.cmdManager.enqueue(radioCommandList);
            this.initAlreadyTriggered = true;
        }
        return 1;
    }

    public void reRequestCoverArt() {
        this.sdarsLabels.reRequestCoverArt();
    }

    public void initSeek() {
        this.logger.sdarsSeekDSI.log(1000000, "[SDARSTuner.initSeek]");
        this.dsiSeekDownManager.initNotifications();
        this.models.getChoiceModel(100420).setStatus(0);
        this.models.getChoiceModel(100653).setStatus(1);
    }

    public void initSetup() {
        this.guiHandler.initSetup();
        this.setNotification(this.attributes);
        this.watch.init();
    }

    public IDoTagging getTagging() {
        return this.sdarsLabels.getTagging();
    }

    public void executeInitialCommands() {
        this.logger.sdarsDSI.log(1000000, "[SDARSTuner.executeInitialCommands]");
        boolean bl = this.models.getActiveTuner() == 7;
        boolean bl2 = this.status.hasAudioFocus(0) && bl;
        RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdWaitDSIRegistered(this));
        radioCommandList.add(this.cmdManager.cmdWaitSDARSTunerReady());
        radioCommandList.add(this.cmdManager.cmdInitSetup(this));
        radioCommandList.add(this.cmdManager.cmdWaitAMAvilable());
        this.cmdManager.enqueue(radioCommandList);
        if (bl2) {
            int n = 0;
            RadioCommandList radioCommandList2 = this.cmdManager.createCmdList("SDARS");
            radioCommandList2.add(this.cmdManager.cmdRequestConnection(7, n));
            radioCommandList2.add(this.cmdManager.cmdSwitchAMFMUsage(false));
            radioCommandList2.add(this.cmdManager.cmdSelectSDARSServiceBlock(this.activeStation));
            radioCommandList2.add(this.cmdManager.cmdFadeToConnection(7, n));
            this.cmdManager.enqueue(radioCommandList2);
        } else {
            RadioCommandList radioCommandList3 = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList3.add(this.cmdManager.cmdSelectSDARSServiceDontBlock(this.activeStation));
            this.cmdManager.enqueue(radioCommandList3);
        }
        RadioCommandList radioCommandList4 = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList4.add(this.cmdManager.cmdSetNotificationSDARS(new int[]{8}));
        radioCommandList4.add(this.cmdManager.cmdHmiReadySDARS());
        this.cmdManager.enqueue(radioCommandList4);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logger.hmi.log(10000000, "[SDARSTuner#deinit]");
        this.dsiDownManager.clearNotification(this.attributes, this.dsiSDARSTunerListener);
        Object object = this.mutexInit;
        synchronized (object) {
            this.initAlreadyTriggered = false;
            this.initDone = false;
        }
    }

    public boolean isDsiFound() {
        return this.dsiDownManager.isDsiFound();
    }

    public boolean isDsiSeekFound() {
        return this.dsiSeekDownManager.isDsiSeekFound();
    }

    public boolean isEntertainmentDrawerOpened() {
        return this.audioDrawerStateTracker.isEntertainmentDrawerOpened();
    }

    public ITunerGUIHandler getGUIHandler() {
        return this.guiHandler;
    }

    public void setDeviceService(DSIBase dSIBase) {
        this.logger.startup.log(10000000, "[SDARSTuner#setDeviceService]");
        if (dSIBase instanceof DSISDARSTuner) {
            this.dsiDownManager.setDeviceService((DSISDARSTuner)dSIBase);
        } else if (dSIBase instanceof DSISDARSSeek) {
            this.dsiSeekDownManager.setDeviceService((DSISDARSSeek)dSIBase);
        }
        if (this.isDsiFound()) {
            this.cmdManager.getActiveAllBandCmd(this).dsiRegistered(dSIBase);
        }
    }

    public void seekStation(int n, int n2) {
        throw new IllegalStateException("[SDARSTuner.seekStation] NotImplemented");
    }

    public void resetToDefaultSettings() {
        this.logger.main.log(1000000, "SDARS Tuner, reset to default settings called");
        this.dsiDownManager.reset(1);
        this.dsiDownManager.reset(2);
        this.selectStation(new StationInfoExt(new StationInfo(1, 1, "", "", 2, 0, false, null)), 0);
        this.pdtHandler.clearPDTBuffer();
        this.guiHandler.resetToDefaultSettings();
        this.seekHandler.resetToDefaultSettings();
    }

    private boolean isGivenStationContainedInList(StationInfoExt stationInfoExt) {
        boolean bl = false;
        if (this.receivedStationList != null) {
            for (int i2 = 0; i2 < this.receivedStationList.length; ++i2) {
                if (this.receivedStationList[i2].sID != stationInfoExt.sID) continue;
                bl = true;
                break;
            }
        } else {
            bl = true;
        }
        return bl;
    }

    public void updateSelectedStation(StationInfoExt stationInfoExt) {
        if (stationInfoExt.subscription == 1 || !this.isGivenStationContainedInList(stationInfoExt)) {
            if (stationInfoExt.getSID() != 1) {
                this.logger.sdarsDSI.log(1000000, "SelectedStation is not subscribed, tuning default channel");
                this.selectStation(new StationInfoExt(new StationInfo(1, 1, "", "", 2, 0, false, null)), 0);
            } else {
                this.logger.sdarsDSI.log(10000, "SelectedStation is not subscribed, NO tuning because default channel unsubscribed!");
            }
            return;
        }
        this.setActiveStation(stationInfoExt);
        this.storage.storeLastSDARSService(stationInfoExt);
    }

    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
        int n;
        if (!this.firstStationListSDARSReceived) {
            Utilities.getFramework().getStartupMgr().logStartupEvent("Sender list: SDARS received");
        }
        if (this.logger.sdarsDSI.isDebug2()) {
            for (n = 0; n < stationInfoExtArray.length; ++n) {
                this.logger.sdarsDSI.log(100000000, "%1", (Object)stationInfoExtArray[n]);
            }
        }
        this.checkActiveStationSubscription(stationInfoExtArray);
        this.guiHandler.setChannelNumberNameMapping(stationInfoExtArray);
        this.currentStationList = stationInfoExtArray;
        this.receivedStationList = stationInfoExtArray;
        this.memory.setCurrentStation(this.getActiveStation(), 0);
        if (!this.firstStationListSDARSReceived) {
            Utilities.getFramework().getStartupMgr().logStartupEvent("Sender list: SDARS ready");
            this.firstStationListSDARSReceived = true;
        }
        for (n = 0; n < stationInfoExtArray.length; ++n) {
            if (stationInfoExtArray[n].sID <= 0 || stationInfoExtArray[n].subscription != 2) continue;
            this.models.getChoiceModel(100154).setValue(1);
            this.propagateUpdatedActiveInfoState(7);
            break;
        }
    }

    private void checkActiveStationSubscription(StationInfoExt[] stationInfoExtArray) {
        for (int i2 = 0; i2 < stationInfoExtArray.length; ++i2) {
            if (stationInfoExtArray[i2].getSID() == this.getActiveStation().getSID() && stationInfoExtArray[i2].subscription == 2) {
                return;
            }
            if (stationInfoExtArray[i2].sID != 1) continue;
            this.defaultChannel = stationInfoExtArray[i2];
        }
        if (this.defaultChannel != null) {
            this.logger.sdarsDSI.log(100000000, "[SDARSTCheckActiveStationSubscription] select default channel");
            this.selectStation(this.defaultChannel, 0);
        }
    }

    public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
        if (this.logger.sdarsDSI.isDebug2()) {
            for (int i2 = 0; i2 < categoryInfoExtArray.length; ++i2) {
                this.logger.sdarsDSI.log(100000000, "%1", (Object)categoryInfoExtArray[i2]);
            }
        }
    }

    public void selectStationStatus(int n) {
        if (n == 5) {
            this.logger.sdarsDSI.log(100000, "received selectStationStatus NOT_SUBSCRIBED");
            this.advisoryHandler.requestAdvisory(3);
            this.dsiDownManager.selectStation(this.defaultChannel, 0);
        }
    }

    public void selectStation(StationInfoExt stationInfoExt, int n) {
        this.dsiDownManager.selectStation(stationInfoExt, n);
    }

    public void updateDetectedDevice(int n) {
        if (n == 3) {
            if (!this.status.isSdarsPresent()) {
                this.models.getChoiceModel(220).setValue(1);
                this.models.getChoiceModel(220).setStatus(1);
                this.bandList.addToBandList(7);
                this.status.setSdarsPresent(true);
            }
        } else {
            this.status.setSdarsPresent(false);
        }
    }

    public boolean isDeviceInUse() {
        return true;
    }

    public void setComponentUsage(boolean bl) {
    }

    public void setComponentUnused() {
    }

    public void reRequestAdvisory(int n) {
        this.advisoryHandler.requestAdvisory(n);
        this.advisoryHandler.flushAdvisoryGroup();
    }

    public SDARSAdvisoryHandler getAdvisoryHandler() {
        return this.advisoryHandler;
    }

    public SDARSStatusManager getStatusManager() {
        return this.statusManager;
    }

    public boolean forceStationListUpdate(boolean bl) {
        return false;
    }

    public void updateAvailability(int n) {
        if (this.availability != n) {
            if (this.availability == 2 && n == 1) {
                this.models.getChoiceModel(100154).setValue(0);
            } else if (n == 2 && this.firstStationListSDARSReceived) {
                this.models.getChoiceModel(100154).setValue(1);
            }
            this.availability = n;
        }
    }

    public PdtInfoHandler getPdtHandler() {
        return this.pdtHandler;
    }

    public void setActiveStation(StationInfoExt stationInfoExt) {
        this.activeStation = stationInfoExt;
    }

    public StationInfoExt getActiveStation() {
        return this.activeStation;
    }

    public SDARSLabels getLabels() {
        return this.sdarsLabels;
    }

    public final SDARSStationDescriptions getSdarsStationDescriptions() {
        return this.sdarsStationDescriptions;
    }

    public StationInfoExt getStationBySid(int n) {
        for (int i2 = 0; i2 < this.currentStationList.length; ++i2) {
            if (this.currentStationList[i2].sID != n) continue;
            return this.currentStationList[i2];
        }
        return null;
    }

    public void setPhoneService(ITelService iTelService) {
        this.advisoryHandler.setPhoneService(iTelService);
    }

    void askModuleTime() {
        this.dsiDownManager.getTime();
    }

    public CmdDefaultListener getDSIUpManager() {
        return this.dsiUpManager;
    }

    public SDARSManTune getManualTuneHandler() {
        return this.manTune;
    }

    public IPrevNext getPrevNextHandler() {
        return this.guiHandler.getSdarsListHandler().prevNextHandler;
    }

    public void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        this.guiHandler.addUpdateListeners(iUpdateListenerArray);
        this.sdarsLabels.addUpdateListeners(iUpdateListenerArray);
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    public TunerObjectContainer getNextChannelByGenre(short s) {
        TunerObjectContainer[] tunerObjectContainerArray = this.startScan();
        for (int i2 = 0; i2 < tunerObjectContainerArray.length; ++i2) {
            if (tunerObjectContainerArray[i2].getSDARSService().categoryNumber != s) continue;
            return tunerObjectContainerArray[i2];
        }
        return null;
    }

    public TunerObjectContainer[] startScan() {
        int n;
        int n2;
        TunerObjectContainer[] tunerObjectContainerArray = this.guiHandler.getStationList();
        ArrayList arrayList = new ArrayList(tunerObjectContainerArray.length);
        long l = this.activeStation.getUniqueId();
        for (n2 = 0; n2 < tunerObjectContainerArray.length && tunerObjectContainerArray[n2].getListID() != l; ++n2) {
        }
        for (n2 = n = n2 + 1; n2 < tunerObjectContainerArray.length; ++n2) {
            if (tunerObjectContainerArray[n2].getSDARSService().subscription != 2) continue;
            arrayList.add(tunerObjectContainerArray[n2]);
        }
        for (n2 = 0; n2 < n; ++n2) {
            if (tunerObjectContainerArray[n2].getSDARSService().subscription != 2) continue;
            arrayList.add(tunerObjectContainerArray[n2]);
        }
        return (TunerObjectContainer[])arrayList.toArray(new TunerObjectContainer[arrayList.size()]);
    }

    public void stopScan() {
    }

    public void performLanguageChange() {
    }

    public IRadioDatabaseListener getDatabaseListener() {
        throw new IllegalArgumentException();
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateSelectedStation(StationInfoExt stationInfoExt) {
            SDARSTuner.this.updateSelectedStation(stationInfoExt);
        }

        public void updateStationList(StationInfoExt[] stationInfoExtArray) {
            SDARSTuner.this.updateStationList(stationInfoExtArray);
        }

        public void updateElectronicSerialCode(String string) {
            SDARSTuner.this.models.getLabelModel(222).setText(string);
            SDARSTuner.this.models.getLabelModel(125).setText(string);
        }

        public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
            SDARSTuner.this.statusManager.updateServiceStatus(serviceStatus3);
        }

        public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
            SDARSTuner.this.updateCategoryList(categoryInfoExtArray);
        }

        public void updateDetectedDevice(int n) {
            SDARSTuner.this.updateDetectedDevice(n);
        }

        public void updateAvailability(int n) {
            SDARSTuner.this.updateAvailability(n);
        }

        public void selectStationStatus(int n) {
            SDARSTuner.this.selectStationStatus(n);
        }

        public void updateStationDescription(StationDescription[] stationDescriptionArray) {
            SDARSTuner.this.sdarsStationDescriptions.updateStationDescriptions(stationDescriptionArray);
        }
    }

    private class DsiDownListener
    extends SDARSDsiDownInfo {
        private DsiDownListener() {
        }

        public void postTuneAction(StationInfoExt stationInfoExt, int n, int n2) {
            if (n != 0 && SDARSTuner.this.models.getActiveTuner() == 7) {
                SDARSTuner.this.audio.demute(n2);
            }
        }
    }
}

