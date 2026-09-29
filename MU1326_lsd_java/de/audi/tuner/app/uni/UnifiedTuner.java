/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

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
import de.audi.tuner.app.amfm.IPSFreezeDB;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.cmd.uni.IUnifiedTuner;
import de.audi.tuner.app.dab.stationlist.DabDummyNames;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.app.uni.UniDsiDownInfo;
import de.audi.tuner.app.uni.UniDsiDownManager;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniDsiUpManager;
import de.audi.tuner.app.uni.UniLabels;
import de.audi.tuner.app.uni.UniRadioTextHistory;
import de.audi.tuner.app.uni.UniStationList;
import de.audi.tuner.app.uni.UniVolumeLockHandler;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.app.uni.UnifiedTuner$ChoiceListener;
import de.audi.tuner.app.uni.UnifiedTuner$GUIHandlerUnified;
import de.audi.tuner.app.uni.UnifiedTuner$RsdbStatusListener;
import de.audi.tuner.app.uni.UnifiedTuner$UniDownListener;
import de.audi.tuner.app.uni.UnifiedTuner$UniUpListener;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIUnifiedTuner;
import org.dsi.ifc.radio.DSIUnifiedTunerListener;

public class UnifiedTuner
implements IUnifiedTuner {
    private final UnifiedTuner$GUIHandlerUnified gui = new UnifiedTuner$GUIHandlerUnified(this, null);
    private DSIUnifiedTunerListener dsiUniTunerListener;
    private IRadioCmdManager cmdManager;
    private final UniDsiUpManager dsiUpManager;
    private final UniDsiDownManager dsiDownManager;
    private final UniStationList stationList;
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final TunerAudioMgmt audio;
    private final BandListHandler bandList;
    private final AnnouncementHandler announce;
    private final TunerStorage storage;
    private final UnifiedTuner$ChoiceListener choiceListener = new UnifiedTuner$ChoiceListener(this, null);
    private UnifiedStationExt activeStation = new UnifiedStationExt();
    private boolean initAlreadyTriggered;
    final int[] attributes = new int[]{4, 2, 5, 7, 6, 10, 11, 9};
    private final Object mutexInit = new Object();
    private volatile boolean initDone;
    private final UniRadioTextHistory radioTextHistory;
    private final UniVolumeLockHandler volumeLockManager;

    public UnifiedTuner(TunerBasics tunerBasics, TunerStorage tunerStorage, TunerAudioMgmt tunerAudioMgmt, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, MemoryListHandler memoryListHandler, BandListHandler bandListHandler, IPSFreezeDB iPSFreezeDB, DabDummyNames dabDummyNames, AnnouncementHandler announcementHandler, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.logger = tunerBasics.getLogger();
        this.audio = tunerAudioMgmt;
        this.bandList = bandListHandler;
        this.announce = announcementHandler;
        this.storage = tunerStorage;
        this.logger.initUniLogChannels();
        this.activeStation = tunerStorage.loadLastUnifiedStation();
        this.stationList = new UniStationList(tunerBasics, this, iTunerVariantExt.getListRowFactory(), languageManager, tunerStorage);
        this.stationList.init();
        this.volumeLockManager = new UniVolumeLockHandler(this.models, tunerAudioMgmt);
        Object object = new Object();
        this.dsiUpManager = new UniDsiUpManager(tunerBasics, iPSFreezeDB, this, dabDummyNames, object);
        this.dsiUpManager.init();
        this.dsiDownManager = new UniDsiDownManager(tunerBasics, object);
        this.dsiUpManager.register(new UnifiedTuner$UniUpListener(this, null));
        this.dsiUpManager.register(this.stationList.dsiUpListener);
        this.dsiUpManager.register(tunerStorage.dsiUpListener);
        this.dsiUpManager.register(this.volumeLockManager.dsiUpListener);
        this.dsiDownManager.register(new UnifiedTuner$UniDownListener(this, null));
        this.dsiDownManager.register(this.stationList.dsiDownListener);
        this.dsiDownManager.register(this.dsiUpManager.dsiDownListener);
        this.dsiUpManager.register(memoryListHandler.highlightListener);
        this.dsiDownManager.register(memoryListHandler.highlightListener);
        this.radioTextHistory = new UniRadioTextHistory(tunerBasics, radiotextHyperlinkProcessor);
        this.radioTextHistory.init();
        this.dsiUpManager.register(this.radioTextHistory.dsiUpListener);
        this.dsiDownManager.register(this.radioTextHistory.dsiDownListener);
        UniLabels uniLabels = new UniLabels(this.models);
        this.dsiUpManager.register(uniLabels.dsiUpListener);
        this.dsiDownManager.register(uniLabels.dsiDownListener);
        this.models.getChoiceModel(-1316486912).setChoiceListener(this.choiceListener);
    }

    @Override
    public IStationListHandler getStationListHandler() {
        return this.stationList;
    }

    @Override
    public IPrevNext getPrevNextHandler() {
        return this.stationList.prevNextHandler;
    }

    @Override
    public void reNotification(int n) {
        this.dsiDownManager.reNotification(n);
    }

    @Override
    public IRadioDatabaseListener getDatabaseListener() {
        return new UnifiedTuner$RsdbStatusListener(this, null);
    }

    @Override
    public void selectStation(UnifiedStationExt unifiedStationExt, int n) {
        this.dsiDownManager.selectStation(unifiedStationExt, n);
    }

    @Override
    public void audioManagementJustBecameAvailable() {
        this.volumeLockManager.audioManagementJustBecameAvailable();
    }

    @Override
    public void uniSelected(UnifiedStationExt unifiedStationExt, int n) {
        this.logger.uniDSI.log(1078071040, "[UnifiedTuner.uniSelected]");
        RadioCommandList radioCommandList = this.cmdManager.clSwitchToUni(n);
        if (unifiedStationExt != null) {
            radioCommandList.addBeforeFadeTo(this.cmdManager.cmdTuneUniStationBlock(unifiedStationExt, n));
        } else {
            radioCommandList.addBeforeFadeTo(this.cmdManager.cmdTuneUniStationBlock(this.activeStation, n));
        }
        this.cmdManager.enqueue(radioCommandList);
    }

    @Override
    public UnifiedStationExt getActiveStation() {
        return this.activeStation;
    }

    @Override
    public void setDeviceService(DSIBase dSIBase) {
        this.dsiDownManager.setDeviceService((DSIUnifiedTuner)dSIBase);
        if (this.isDsiFound()) {
            this.cmdManager.getActiveAllBandCmd(this).dsiRegistered(dSIBase);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public int init() {
        this.logger.main.log(1078071040, "[UnifiedTuner.init]");
        Object object = this.mutexInit;
        synchronized (object) {
            if (this.initAlreadyTriggered) {
                this.logger.main.log(1078071040, "[UnifiedTuner.init] Already triggered!");
                return 0;
            }
            if (!this.isDsiFound()) {
                this.logger.startup.log(1078071040, "[UnifiedTuner.init] abort: No dsi available!");
                return 2;
            }
            this.executeInitialCommands();
            RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdInitUniDone());
            this.cmdManager.enqueue(radioCommandList);
            this.initAlreadyTriggered = true;
        }
        return 1;
    }

    @Override
    public void setNotification(int[] nArray) {
        this.dsiDownManager.setNotification(nArray, this.dsiUniTunerListener);
    }

    @Override
    public void clearNotification(int[] nArray) {
        this.dsiDownManager.clearNotification(nArray, this.dsiUniTunerListener);
    }

    @Override
    public void initSetup() {
        int[] nArray = this.storage.loadDABSetup();
        this.choiceListener.itemSelected(-1316486912, nArray[3], 0, 0);
        this.dsiDownManager.setListMode(1);
        this.dsiDownManager.setStationFollowingMode(1);
        this.dsiDownManager.setRegMode(2);
        if (Utilities.isRadioTextPlusActivated()) {
            int[] nArray2 = new int[]{4, 8, 7, 1, 33, 36, 2};
            this.dsiDownManager.enableRadioTextPlus(Utilities.combineArrays(nArray2, RadiotextHyperlinkProcessor.HYPERLINK_TAGS));
        }
        this.setNotification(this.attributes);
    }

    @Override
    public void setInitDone() {
        this.logger.main.log(-2137614336, "[UnifiedTuner.setInitDone]");
        this.initDone = true;
    }

    public boolean isInitDone() {
        return this.initDone;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logger.hmi.log(-2137614336, "[UnifiedTuner#deinit]");
        this.dsiDownManager.clearNotification(this.attributes, this.dsiUniTunerListener);
        Object object = this.mutexInit;
        synchronized (object) {
            this.initAlreadyTriggered = false;
            this.initDone = false;
        }
    }

    @Override
    public void executeInitialCommands() {
        this.logger.startup.log(1078071040, "[UnifiedTuner#executeInitialCommands]");
        int n = this.models.getActiveTuner();
        boolean bl = n == 11;
        boolean bl2 = this.status.hasAudioFocus(0) && bl;
        RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdWaitDSIRegistered(this));
        radioCommandList.add(this.cmdManager.cmdWaitUniTunerReady());
        radioCommandList.add(this.cmdManager.cmdInitSetup(this));
        radioCommandList.add(this.cmdManager.cmdWaitAMAvilable());
        this.cmdManager.enqueue(radioCommandList);
        if (bl2) {
            int n2 = 0;
            RadioCommandList radioCommandList2 = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList2.add(this.cmdManager.cmdRequestConnection(11, n2));
            radioCommandList2.add(this.cmdManager.cmdSwitchAMFMUsage(false));
            radioCommandList2.add(this.cmdManager.cmdSwitchDABUsage(false));
            radioCommandList2.add(this.cmdManager.cmdSwitchUniUsage(true));
            radioCommandList2.add(this.cmdManager.cmdTuneUniStationBlock(this.activeStation, 0));
            radioCommandList2.add(this.cmdManager.cmdFadeToConnection(11, n2));
            this.cmdManager.enqueue(radioCommandList2);
        } else {
            RadioCommandList radioCommandList3 = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList3.add(this.cmdManager.cmdSwitchUniUsage(false));
            radioCommandList3.add(this.cmdManager.cmdTuneUniStationDontBlock(this.activeStation, 0));
            this.cmdManager.enqueue(radioCommandList3);
        }
        RadioCommandList radioCommandList4 = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList4.add(this.cmdManager.cmdSetNotificationUni(new int[]{3}));
        this.cmdManager.enqueue(radioCommandList4);
    }

    @Override
    public boolean isDsiFound() {
        return this.dsiDownManager.isDsiFound();
    }

    @Override
    public ITunerGUIHandler getGUIHandler() {
        return this.gui;
    }

    @Override
    public void setSoftlinking(int n) {
        this.dsiDownManager.setSoftLinkSwitch(n == 1);
    }

    @Override
    public void seekStation(int n, int n2) {
    }

    @Override
    public void resetToDefaultSettings() {
    }

    @Override
    public void reRequestCoverArt() {
        this.dsiDownManager.reNotification(7);
    }

    @Override
    public boolean isDeviceInUse() {
        return false;
    }

    @Override
    public void setComponentUsage(boolean bl) {
        this.dsiDownManager.switchDeviceUsage(bl);
    }

    @Override
    public void setComponentUnused() {
        this.setComponentUsage(false);
    }

    @Override
    public boolean forceStationListUpdate(boolean bl) {
        return false;
    }

    public void addUpdateListener(IUpdateListener iUpdateListener) {
    }

    @Override
    public void register(DSIListener dSIListener) {
        this.dsiUniTunerListener = (DSIUnifiedTunerListener)dSIListener;
    }

    @Override
    public void register(ITaggingManager iTaggingManager) {
        throw new IllegalArgumentException();
    }

    @Override
    public void register(IGracenoteRequest iGracenoteRequest) {
        this.dsiUpManager.register(iGracenoteRequest);
    }

    @Override
    public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        this.cmdManager = iRadioCmdManager;
    }

    @Override
    public IRadioCmdManager getCmdManager() {
        return this.cmdManager;
    }

    public TunerActionProxyListener getActionProxyListener() {
        return null;
    }

    @Override
    public void registerDsiUpDownListener(RadioInfo radioInfo) {
        if (radioInfo instanceof UniDsiUpInfo) {
            this.dsiUpManager.register(radioInfo);
        } else if (radioInfo instanceof UniDsiDownInfo) {
            this.dsiDownManager.register(radioInfo);
        } else {
            this.dsiUpManager.register(radioInfo);
            this.dsiDownManager.register(radioInfo);
        }
    }

    @Override
    public CmdDefaultListener getDSIUpManager() {
        return this.dsiUpManager;
    }

    private synchronized void doUpdateSelectedStation(UnifiedStationExt unifiedStationExt) {
        this.activeStation = unifiedStationExt;
    }

    public void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.stationList.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    @Override
    public TunerObjectContainer[] startScan() {
        return new TunerObjectContainer[0];
    }

    @Override
    public void stopScan() {
    }

    @Override
    public void performLanguageChange() {
        this.dsiDownManager.reNotification(4);
    }

    static /* synthetic */ void access$500(UnifiedTuner unifiedTuner, UnifiedStationExt unifiedStationExt) {
        unifiedTuner.doUpdateSelectedStation(unifiedStationExt);
    }

    static /* synthetic */ AnnouncementHandler access$600(UnifiedTuner unifiedTuner) {
        return unifiedTuner.announce;
    }

    static /* synthetic */ TunerModels access$700(UnifiedTuner unifiedTuner) {
        return unifiedTuner.models;
    }

    static /* synthetic */ TunerAudioMgmt access$800(UnifiedTuner unifiedTuner) {
        return unifiedTuner.audio;
    }

    static /* synthetic */ BandListHandler access$900(UnifiedTuner unifiedTuner) {
        return unifiedTuner.bandList;
    }

    static /* synthetic */ UniStationList access$1000(UnifiedTuner unifiedTuner) {
        return unifiedTuner.stationList;
    }

    static /* synthetic */ UniDsiDownManager access$1100(UnifiedTuner unifiedTuner) {
        return unifiedTuner.dsiDownManager;
    }

    static /* synthetic */ UniDsiUpManager access$1200(UnifiedTuner unifiedTuner) {
        return unifiedTuner.dsiUpManager;
    }
}

