/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.LanguageManager;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
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
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.ILogoDatabase;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;
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
    private final GUIHandlerUnified gui = new GUIHandlerUnified();
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
    private final ChoiceListener choiceListener = new ChoiceListener();
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
        this.dsiUpManager.register(new UniUpListener());
        this.dsiUpManager.register(this.stationList.dsiUpListener);
        this.dsiUpManager.register(tunerStorage.dsiUpListener);
        this.dsiUpManager.register(this.volumeLockManager.dsiUpListener);
        this.dsiDownManager.register(new UniDownListener());
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
        this.models.getChoiceModel(100529).setChoiceListener(this.choiceListener);
    }

    public IStationListHandler getStationListHandler() {
        return this.stationList;
    }

    public IPrevNext getPrevNextHandler() {
        return this.stationList.prevNextHandler;
    }

    public void reNotification(int n) {
        this.dsiDownManager.reNotification(n);
    }

    public IRadioDatabaseListener getDatabaseListener() {
        return new RsdbStatusListener();
    }

    public void selectStation(UnifiedStationExt unifiedStationExt, int n) {
        this.dsiDownManager.selectStation(unifiedStationExt, n);
    }

    public void audioManagementJustBecameAvailable() {
        this.volumeLockManager.audioManagementJustBecameAvailable();
    }

    public void uniSelected(UnifiedStationExt unifiedStationExt, int n) {
        this.logger.uniDSI.log(1000000, "[UnifiedTuner.uniSelected]");
        RadioCommandList radioCommandList = this.cmdManager.clSwitchToUni(n);
        if (unifiedStationExt != null) {
            radioCommandList.addBeforeFadeTo(this.cmdManager.cmdTuneUniStationBlock(unifiedStationExt, n));
        } else {
            radioCommandList.addBeforeFadeTo(this.cmdManager.cmdTuneUniStationBlock(this.activeStation, n));
        }
        this.cmdManager.enqueue(radioCommandList);
    }

    public UnifiedStationExt getActiveStation() {
        return this.activeStation;
    }

    public void setDeviceService(DSIBase dSIBase) {
        this.dsiDownManager.setDeviceService((DSIUnifiedTuner)dSIBase);
        if (this.isDsiFound()) {
            this.cmdManager.getActiveAllBandCmd(this).dsiRegistered(dSIBase);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int init() {
        this.logger.main.log(1000000, "[UnifiedTuner.init]");
        Object object = this.mutexInit;
        synchronized (object) {
            if (this.initAlreadyTriggered) {
                this.logger.main.log(1000000, "[UnifiedTuner.init] Already triggered!");
                return 0;
            }
            if (!this.isDsiFound()) {
                this.logger.startup.log(1000000, "[UnifiedTuner.init] abort: No dsi available!");
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

    public void setNotification(int[] nArray) {
        this.dsiDownManager.setNotification(nArray, this.dsiUniTunerListener);
    }

    public void clearNotification(int[] nArray) {
        this.dsiDownManager.clearNotification(nArray, this.dsiUniTunerListener);
    }

    public void initSetup() {
        int[] nArray = this.storage.loadDABSetup();
        this.choiceListener.itemSelected(100529, nArray[3], 0, 0);
        this.dsiDownManager.setListMode(1);
        this.dsiDownManager.setStationFollowingMode(1);
        this.dsiDownManager.setRegMode(2);
        if (Utilities.isRadioTextPlusActivated()) {
            int[] nArray2 = new int[]{4, 8, 7, 1, 33, 36, 2};
            this.dsiDownManager.enableRadioTextPlus(Utilities.combineArrays(nArray2, RadiotextHyperlinkProcessor.HYPERLINK_TAGS));
        }
        this.setNotification(this.attributes);
    }

    public void setInitDone() {
        this.logger.main.log(10000000, "[UnifiedTuner.setInitDone]");
        this.initDone = true;
    }

    public boolean isInitDone() {
        return this.initDone;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void deinit() {
        this.logger.hmi.log(10000000, "[UnifiedTuner#deinit]");
        this.dsiDownManager.clearNotification(this.attributes, this.dsiUniTunerListener);
        Object object = this.mutexInit;
        synchronized (object) {
            this.initAlreadyTriggered = false;
            this.initDone = false;
        }
    }

    public void executeInitialCommands() {
        this.logger.startup.log(1000000, "[UnifiedTuner#executeInitialCommands]");
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

    public boolean isDsiFound() {
        return this.dsiDownManager.isDsiFound();
    }

    public ITunerGUIHandler getGUIHandler() {
        return this.gui;
    }

    public void setSoftlinking(int n) {
        this.dsiDownManager.setSoftLinkSwitch(n == 1);
    }

    public void seekStation(int n, int n2) {
    }

    public void resetToDefaultSettings() {
    }

    public void reRequestCoverArt() {
        this.dsiDownManager.reNotification(7);
    }

    public boolean isDeviceInUse() {
        return false;
    }

    public void setComponentUsage(boolean bl) {
        this.dsiDownManager.switchDeviceUsage(bl);
    }

    public void setComponentUnused() {
        this.setComponentUsage(false);
    }

    public boolean forceStationListUpdate(boolean bl) {
        return false;
    }

    public void addUpdateListener(IUpdateListener iUpdateListener) {
    }

    public void register(DSIListener dSIListener) {
        this.dsiUniTunerListener = (DSIUnifiedTunerListener)dSIListener;
    }

    public void register(ITaggingManager iTaggingManager) {
        throw new IllegalArgumentException();
    }

    public void register(IGracenoteRequest iGracenoteRequest) {
        this.dsiUpManager.register(iGracenoteRequest);
    }

    public void setCmdManager(IRadioCmdManager iRadioCmdManager) {
        this.cmdManager = iRadioCmdManager;
    }

    public IRadioCmdManager getCmdManager() {
        return this.cmdManager;
    }

    public TunerActionProxyListener getActionProxyListener() {
        return null;
    }

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

    public TunerObjectContainer[] startScan() {
        return new TunerObjectContainer[0];
    }

    public void stopScan() {
    }

    public void performLanguageChange() {
        this.dsiDownManager.reNotification(4);
    }

    private class UniUpListener
    extends UniDsiUpInfo {
        private UniUpListener() {
        }

        public void reNotification(int n) {
            UnifiedTuner.this.reNotification(n);
        }

        public void updateDetectedDevice(int n) {
            if (n == 3) {
                UnifiedTuner.this.models.getChoiceModel(100305).setValue(1);
                UnifiedTuner.this.bandList.addToBandList(11);
            } else {
                UnifiedTuner.this.models.getChoiceModel(100305).setValue(0);
            }
        }

        public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
            UnifiedTuner.this.doUpdateSelectedStation(unifiedStationExt);
        }

        public void updateSoftLinkSwitchStatus(int n) {
            boolean bl = n == 1;
            UnifiedTuner.this.models.getChoiceModel(100529).setValue(bl ? 1 : 0);
        }
    }

    private class ChoiceListener
    extends DefaultChoiceListener {
        private ChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            UnifiedTuner.this.dsiDownManager.setSoftLinkSwitch(n2 == 1);
            TunerProxyManager.getInstance().getDABTuner().setSoftlinking(n2);
        }
    }

    private class UniDownListener
    extends UniDsiDownInfo {
        private UniDownListener() {
        }

        public void preTuneCommand(UnifiedStationExt unifiedStationExt) {
            UnifiedTuner.this.doUpdateSelectedStation(unifiedStationExt);
            UnifiedTuner.this.announce.abortAnnouncement();
        }

        public void postTuneCommand(UnifiedStationExt unifiedStationExt, int n) {
            if (n != 0 && UnifiedTuner.this.models.getActiveTuner() == 11) {
                UnifiedTuner.this.audio.demute();
            }
        }
    }

    private class GUIHandlerUnified
    implements ITunerGUIHandler {
        private GUIHandlerUnified() {
        }

        public void register(IStoreStationHandler iStoreStationHandler) {
        }

        public IStationListHandler getStationListHandler() {
            return UnifiedTuner.this.stationList;
        }

        public boolean tuneById(long l, int n) {
            return UnifiedTuner.this.stationList.tuneById(l, n);
        }

        public TunerObjectContainer[] getStationList() {
            return UnifiedTuner.this.stationList.getStationList();
        }

        public TunerObjectContainer[] getStationList(int n) {
            return new TunerObjectContainer[0];
        }

        public TunerObjectContainer getCurrentStation() {
            return new TunerObjectContainer(UnifiedTuner.this.stationList.getActiveStation());
        }

        public IPowerEvent getPoPowerStateListener() {
            return new IPowerEvent(){

                public void notifyPowerEvent(int n, int n2) {
                }
            };
        }
    }

    private class RsdbStatusListener
    implements IRadioDatabaseListener {
        private RsdbStatusListener() {
        }

        public void databaseReady(ILogoDatabase iLogoDatabase) {
            UnifiedTuner.this.dsiUpManager.setDatabase(iLogoDatabase);
            UnifiedTuner.this.reNotification(4);
            UnifiedTuner.this.reNotification(3);
        }
    }
}

