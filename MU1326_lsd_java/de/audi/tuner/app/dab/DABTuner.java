/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

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
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.ann.AnnouncementHandler;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.app.cmd.IRadioCmdManager;
import de.audi.tuner.app.cmd.NullRadioCmdManager;
import de.audi.tuner.app.cmd.RadioCommandList;
import de.audi.tuner.app.dab.DABDSIDownManager;
import de.audi.tuner.app.dab.DABDSIUpManager;
import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABSetupHandler;
import de.audi.tuner.app.dab.DABTuner$DsiDownListener;
import de.audi.tuner.app.dab.DABTuner$DsiUpListener;
import de.audi.tuner.app.dab.DABTuner$RsdbStatusListener;
import de.audi.tuner.app.dab.DABTuner$TunerActionProxyListenerExt;
import de.audi.tuner.app.dab.DABVolumeLockHandler;
import de.audi.tuner.app.dab.DabRadioTextHistory;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.GUIHandlerDAB;
import de.audi.tuner.app.dab.stationlist.DabDummyNames;
import de.audi.tuner.app.gracenote.IGracenoteRequest;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.app.rthyperlinking.RadiotextHyperlinkProcessor;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.CmdDefaultListener;
import de.audi.tuner.ifc.IDABTuner;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IScanHandler;
import de.audi.tuner.ifc.ITunerGUIHandler;
import de.audi.tuner.ifc.ITunerVariantExt;
import de.audi.tuner.ifc.listener.IUpdateListener;
import de.audi.tuner.itunes.ITaggingManager;
import de.audi.tuner.sds.UpdateListenerHandler;
import de.audi.tuner.util.NullDSIDABTunerListener;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.ComponentInfo;
import org.dsi.ifc.radio.DSIDABTuner;
import org.dsi.ifc.radio.DSIDABTunerListener;
import org.dsi.ifc.radio.EnsembleInfo;
import org.dsi.ifc.radio.ServiceInfo;

public class DABTuner
extends UpdateListenerHandler
implements IDABTuner {
    private final DABDsiUpInfo dsiUpListener = new DABTuner$DsiUpListener(this, null);
    private DabStation activeStation = new DabStation(new EnsembleInfo());
    private final GUIHandlerDAB guiHandler;
    private final DABDSIUpManager dsiUpManager;
    private final DABDSIDownManager dsiDownManager;
    private boolean dabDetected = false;
    private DabReceptionStatus reception = new DabReceptionStatus(4, 1);
    private volatile boolean showDebugInfos = false;
    private final GeneralStatusHandler deviceUsage;
    private volatile boolean initDone;
    private final Object mutexInit = new Object();
    private boolean initAlreadyTriggered;
    final int[] attributes = new int[]{5, 6, 7, 9, 15, 14, 10, 33, 11, 18, 22, 12, 19, 8, 32, 24, 29, 30, 34};
    private final Logger logger;
    private final TunerModels models;
    private final TunerStatus status;
    private final BandListHandler bandList;
    private final MemoryListHandler memory;
    private final TunerAudioMgmt audio;
    private final AnnouncementHandler announce;
    private final TunerStorage storage;
    private int forceUpdateStatus = 0;
    private DSIDABTunerListener dsiDabTunerListener;
    private IRadioCmdManager cmdManager;
    private final DabRadioTextHistory radioTextHistory;
    private final ITunerVariantExt variantExt;
    private final DABVolumeLockHandler volumeLockHandler;
    private volatile boolean seekRunning;

    public DABTuner(TunerBasics tunerBasics, TunerStorage tunerStorage, BandListHandler bandListHandler, MemoryListHandler memoryListHandler, TunerAudioMgmt tunerAudioMgmt, AnnouncementHandler announcementHandler, ITunerVariantExt iTunerVariantExt, LanguageManager languageManager, IScanHandler iScanHandler, DabDummyNames dabDummyNames, RadiotextHyperlinkProcessor radiotextHyperlinkProcessor) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.status = tunerBasics.getStatus();
        this.variantExt = iTunerVariantExt;
        this.bandList = bandListHandler;
        this.memory = memoryListHandler;
        this.audio = tunerAudioMgmt;
        this.announce = announcementHandler;
        this.storage = tunerStorage;
        this.logger.initDABLogChannels();
        this.dsiDabTunerListener = new NullDSIDABTunerListener(this.logger.dabDSI);
        this.cmdManager = new NullRadioCmdManager(tunerBasics);
        this.guiHandler = new GUIHandlerDAB(this, tunerBasics, tunerStorage, iTunerVariantExt, languageManager, memoryListHandler, iScanHandler);
        this.volumeLockHandler = new DABVolumeLockHandler(this.models, tunerAudioMgmt);
        this.dsiUpManager = new DABDSIUpManager(tunerBasics, languageManager, this, dabDummyNames);
        this.dsiUpManager.init();
        this.dsiDownManager = new DABDSIDownManager(tunerBasics);
        this.deviceUsage = new GeneralStatusHandler(0);
        this.activeStation = tunerStorage.loadLastDABService();
        DABDsiUpInfo[] dABDsiUpInfoArray = this.guiHandler.getDsiUpListeners();
        for (int i2 = 0; i2 < dABDsiUpInfoArray.length; ++i2) {
            this.dsiUpManager.register(dABDsiUpInfoArray[i2]);
        }
        this.dsiUpManager.register(this.dsiUpListener);
        this.dsiUpManager.register(this.volumeLockHandler.dsiUpListener);
        DABDsiDownInfo[] dABDsiDownInfoArray = this.guiHandler.getDsiDownListeners();
        for (int i3 = 0; i3 < dABDsiDownInfoArray.length; ++i3) {
            this.dsiDownManager.register(dABDsiDownInfoArray[i3]);
        }
        this.dsiDownManager.register(new DABTuner$DsiDownListener(this, null));
        this.dsiDownManager.register(this.dsiUpManager.dsiDownListener);
        this.dsiUpManager.register(memoryListHandler.highlightListener);
        this.dsiDownManager.register(memoryListHandler.highlightListener);
        this.radioTextHistory = new DabRadioTextHistory(tunerBasics, radiotextHyperlinkProcessor);
        this.radioTextHistory.init();
        this.dsiUpManager.register(this.radioTextHistory.dsiUpListener);
        this.dsiDownManager.register(this.radioTextHistory.dsiDownListener);
    }

    @Override
    public void setDeviceService(DSIBase dSIBase) {
        this.logger.startup.log(-2137614336, "[DABTuner#setDeviceService]");
        this.dsiDownManager.setDeviceService((DSIDABTuner)dSIBase);
        if (this.isDsiFound()) {
            this.cmdManager.getActiveAllBandCmd(this).dsiRegistered(dSIBase);
        }
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
    public void register(DSIListener dSIListener) {
        this.dsiDabTunerListener = (DSIDABTunerListener)dSIListener;
    }

    @Override
    public void register(ITaggingManager iTaggingManager) {
        throw new IllegalArgumentException();
    }

    @Override
    public void registerDsiUpDownListener(RadioInfo radioInfo) {
        if (radioInfo instanceof DABDsiUpInfo) {
            this.dsiUpManager.register(radioInfo);
        } else if (radioInfo instanceof DABDsiDownInfo) {
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
    public IUpdateListener getUpdateListener(IMemoryList iMemoryList) {
        return this.dsiUpManager.getUpdateListener(iMemoryList);
    }

    @Override
    public IRadioDatabaseListener getDatabaseListener() {
        return new DABTuner$RsdbStatusListener(this, null);
    }

    public MemoryListHandler getMemoryList() {
        return this.memory;
    }

    @Override
    public void audioManagementJustBecameAvailable() {
        this.volumeLockHandler.audioManagementJustBecameAvailable();
    }

    @Override
    public void setSoftlinking(int n) {
        this.models.getChoiceModel(-1333264128).setValue(n);
        if (this.models.getChoiceModel(378011904).getValue() == 1) {
            this.switchLinking(n == 1 ? 7 : 3);
        }
        this.guiHandler.setupValueUpdated(n, 3);
    }

    @Override
    public void reRequestCoverArt() {
        this.dsiDownManager.reNotification(33);
    }

    @Override
    public ITunerGUIHandler getGUIHandler() {
        return this.guiHandler;
    }

    @Override
    public void dabSelected(DabStation dabStation, int n) {
        String string = this.activeStation.getFullName();
        String string2 = this.activeStation.getShortName();
        if (string == null) {
            string = "";
        }
        if (string2 == null) {
            string2 = "";
        }
        this.logger.dabDSI.log(1078071040, "[DABTuner.dabSelected] full:%1 short:%2", (Object)string, (Object)string2);
        this.guiHandler.labels.updateServiceFullName(string);
        RadioCommandList radioCommandList = this.cmdManager.clSwitchToDAB(n);
        if (dabStation == null) {
            dabStation = this.activeStation;
        }
        int n2 = dabStation.ensemble.frequencyValue;
        if (dabStation.component.sCIDI > 0) {
            radioCommandList.addBeforeFadeTo(this.cmdManager.cmdSelectDABServiceBlock(3, dabStation, n));
        } else if (n2 > 0) {
            radioCommandList.addBeforeFadeTo(this.cmdManager.cmdSelectDABServiceBlock(6, dabStation, n));
        } else {
            radioCommandList.addBeforeFadeTo(this.cmdManager.cmdSelectDABServiceBlock(2, dabStation, n));
        }
        this.cmdManager.enqueue(radioCommandList);
    }

    private void reTuneActiveServOrComp() {
        ServiceInfo serviceInfo = this.getActiveService();
        this.logger.main.log(1078071040, "[DABTuner.reTuneActiveServOrComp] %1", (Object)serviceInfo);
        RadioCommandList radioCommandList = new RadioCommandList(this.cmdManager, "DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdSelectDABServiceDontBlock(2, this.activeStation, 0));
        this.cmdManager.enqueue(radioCommandList);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void deinit() {
        this.logger.hmi.log(-2137614336, "[DABTuner#deinit]");
        this.dsiDownManager.clearNotification(this.attributes, this.dsiDabTunerListener);
        Object object = this.mutexInit;
        synchronized (object) {
            this.initAlreadyTriggered = false;
            this.initDone = false;
        }
    }

    @Override
    public void setInitDone() {
        this.logger.main.log(-2137614336, "[DABTuner.setInitDone]");
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
        this.logger.main.log(1078071040, "[DABTuner.init]");
        Object object = this.mutexInit;
        synchronized (object) {
            if (this.initAlreadyTriggered) {
                this.logger.main.log(1078071040, "[DABTuner.init] Already triggered!");
                return 0;
            }
            if (!this.isDsiFound()) {
                this.logger.startup.log(1078071040, "[DABTuner.init] abort: No dsi available!");
                return 2;
            }
            this.updateCurrentService(this.activeStation);
            this.executeInitialCommands();
            RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdInitDabDone());
            this.cmdManager.enqueue(radioCommandList);
            this.initAlreadyTriggered = true;
        }
        return 1;
    }

    @Override
    public void initSetup() {
        this.guiHandler.initSetup();
        this.dsiDownManager.setNotification(this.attributes, this.dsiDabTunerListener);
        if (Utilities.isRadioTextPlusActivated()) {
            int[] nArray = new int[]{4, 8, 7, 1, 33, 36};
            this.dsiDownManager.enableRadioTextPlus(Utilities.combineArrays(nArray, RadiotextHyperlinkProcessor.HYPERLINK_TAGS));
        } else {
            this.logger.dabDSI.log(-2137614336, "DABTuner#init: RT+ is disabled by coding");
        }
        this.switchSlideShowMode(1);
        this.dsiDownManager.setEpgMode(4);
    }

    @Override
    public void executeInitialCommands() {
        RadioCommandList radioCommandList;
        RadioCommandList radioCommandList2;
        boolean bl;
        this.logger.main.log(1078071040, "[DABTuner.executeInitialCommands]");
        boolean bl2 = this.models.getActiveTuner() == 5;
        boolean bl3 = bl = this.status.hasAudioFocus(0) && bl2;
        if (bl) {
            radioCommandList2 = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList2.add(this.cmdManager.cmdWaitAMAvilable(2000));
            radioCommandList2.add(this.cmdManager.cmdRequestConnection(5, 0));
            this.cmdManager.enqueue(radioCommandList2);
        }
        radioCommandList2 = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList2.add(this.cmdManager.cmdWaitDSIRegistered(this));
        radioCommandList2.add(this.cmdManager.cmdWaitDABTunerReady());
        radioCommandList2.add(this.cmdManager.cmdSwitchDABUsage(bl));
        radioCommandList2.add(this.cmdManager.cmdInitSetup(this));
        radioCommandList2.add(this.cmdManager.cmdWaitAMAvilable());
        this.cmdManager.enqueue(radioCommandList2);
        if (bl) {
            radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdRequestConnection(5, 0));
            radioCommandList.add(this.cmdManager.cmdSwitchAMFMUsage(false));
            radioCommandList.add(this.cmdManager.cmdSwitchUniUsage(false));
            radioCommandList.add(this.cmdManager.cmdSwitchDABUsage(true));
            radioCommandList.add(this.cmdManager.cmdSelectDABServiceBlock(this.activeStation.isComponent() ? 3 : 2, this.activeStation, 0));
            radioCommandList.add(this.cmdManager.cmdFadeToConnection(5, 0));
            this.cmdManager.enqueue(radioCommandList);
        } else {
            radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdSwitchDABUsage(false));
            radioCommandList.add(this.cmdManager.cmdSelectDABServiceDontBlock(2, this.activeStation, 0));
            this.cmdManager.enqueue(radioCommandList);
        }
        radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
        radioCommandList.add(this.cmdManager.cmdSetNotificationDAB(new int[]{1, 2, 3, 4}));
        this.cmdManager.enqueue(radioCommandList);
    }

    public void switchSlideShowMode(int n) {
        this.dsiDownManager.setSlideShowMode(n);
    }

    @Override
    public void seekStation(int n, int n2) {
        this.logger.dabDSI.log(1078071040, "[DABTuner.seekStation] mode:%1", (long)n);
        this.dsiDownManager.seekService(n);
        if (n2 != -2) {
            this.audio.demute(n2);
        }
    }

    @Override
    public void selectStation(DabStation dabStation, int n, int n2) {
        this.logger.dabDSI.log(-2137614336, "[DABT.tune] Container %1", (Object)dabStation);
        DabReceptionStatus dabReceptionStatus = this.prepareReceptionStatus(dabStation);
        this.dsiDownManager.selectStation(dabStation, n, dabReceptionStatus, n2);
    }

    private void preTuneAction(DabStation dabStation) {
        boolean bl = true;
        boolean bl2 = true;
        if (dabStation.isService()) {
            bl = dabStation.service.ensID != this.activeStation.ensemble.ensID;
            boolean bl3 = bl2 = dabStation.service.sID != this.activeStation.service.sID || dabStation.service.ensID != this.activeStation.ensemble.ensID;
            if (dabStation.service.sID != this.activeStation.service.sID || dabStation.service.ensID != this.activeStation.ensemble.ensID || !this.activeStation.isService()) {
                bl2 = true;
            }
        } else if (dabStation.isComponent()) {
            ComponentInfo componentInfo = dabStation.component;
            if (componentInfo.sID == this.activeStation.service.sID && componentInfo.ensID == this.activeStation.ensemble.ensID && componentInfo.sCIDI == this.activeStation.component.sCIDI) {
                bl2 = false;
            }
            boolean bl4 = bl = componentInfo.ensID != this.activeStation.ensemble.ensID;
        }
        if (this.guiHandler.isSortModeAlphabetically() && bl2) {
            bl = true;
        }
        this.prepareReceptionStati(bl, bl2);
        if (!bl2 && !bl) {
            this.logger.dabDSI.log(-2137614336, "[DABTuner.preTuneAction] Service to Tune allready Tuned. Dont discard Bufferd Service");
            this.dsiUpManager.setServiceChangedAtTune(false);
        } else {
            this.logger.dabDSI.log(-2137614336, "[DABTuner.preTuneAction] New Service to Tune. Discard Bufferd Service while Tune-running ");
            this.dsiUpManager.setServiceChangedAtTune(true);
        }
        this.activeStation = dabStation;
    }

    @Override
    public DabReceptionStatus prepareReceptionStatus(DabStation dabStation) {
        boolean bl;
        boolean bl2 = dabStation.ensemble.ensID != this.activeStation.ensemble.ensID;
        boolean bl3 = bl = dabStation.service.sID != this.activeStation.service.sID || bl2;
        if (this.guiHandler.isSortModeAlphabetically() && bl) {
            bl2 = true;
        }
        return this.prepareReceptionStati(bl2, bl);
    }

    private DabReceptionStatus prepareReceptionStati(boolean bl, boolean bl2) {
        int n = this.reception.syncStatus;
        int n2 = this.reception.linkStatus;
        if (bl) {
            n2 = 1;
            n = 4;
        } else if (bl2) {
            if (this.reception.syncStatus == 3) {
                n = 4;
            }
            n2 = 1;
        }
        DabReceptionStatus dabReceptionStatus = new DabReceptionStatus(n, n2);
        if (!this.reception.equals(dabReceptionStatus)) {
            this.handleLinkingAndSyncState(dabReceptionStatus);
        }
        return dabReceptionStatus;
    }

    private void handleLinkingAndSyncState(DabReceptionStatus dabReceptionStatus) {
        this.logger.main.log(-2137614336, "[DABTuner.handleLinkingAndSyncState] linkingState:%1 syncState:%2", (long)dabReceptionStatus.linkStatus, (long)dabReceptionStatus.syncStatus);
        boolean bl = !this.reception.equals(dabReceptionStatus);
        this.reception = dabReceptionStatus;
        this.propagateUpdatedMuteStatus(5, dabReceptionStatus.syncStatus != 4);
        if (bl) {
            this.guiHandler.setSyncLinkState(dabReceptionStatus);
            this.propagateUpdatedActiveStation(5);
            this.propagateUpdatedStationList(5);
        }
    }

    public void updateLinkingSwitchStatus(int n) {
        int n2 = 0;
        int n3 = this.models.getChoiceModel(-1333264128).getValue();
        switch (n) {
            case 7: {
                n2 = 1;
                n3 = 1;
                break;
            }
            case 3: {
                n2 = 1;
                n3 = 0;
                break;
            }
        }
        this.models.getChoiceModel(378011904).setValue(n2);
        this.models.getChoiceModel(-1333264128).setValue(n3);
        this.guiHandler.setupValueUpdated(n2, 1);
        this.guiHandler.setupValueUpdated(n3, 3);
    }

    public void updateCurrentService(DabStation dabStation) {
        this.activeStation = dabStation;
        this.storage.storeLastDABService(dabStation);
    }

    @Override
    public void switchLinking(int n) {
        this.dsiDownManager.switchLinking(n);
    }

    @Override
    public void setNotification(int[] nArray) {
        this.dsiDownManager.setNotification(nArray, this.dsiDabTunerListener);
    }

    @Override
    public void reNotification(int n) {
        this.dsiDownManager.reNotification(n);
    }

    @Override
    public void clearNotification(int[] nArray) {
        this.dsiDownManager.clearNotification(nArray, this.dsiDabTunerListener);
    }

    public void updateFrequencyTableSwitchStatus(int n) {
        this.logger.dabDSI.log(1078071040, "active frequency table is %1 ", (long)n);
        int n2 = n == 8 ? 0 : 1;
        this.models.getChoiceModel(-2037972736).setValue(n2);
        this.guiHandler.setupValueUpdated(n2, 0);
    }

    @Override
    public boolean isDsiFound() {
        return this.dsiDownManager.isDsiFound();
    }

    public int getType() {
        return 2;
    }

    @Override
    public void switchFrequencyTable(int n) {
        this.dsiDownManager.switchFrequencyTable(n);
    }

    @Override
    public void resetToDefaultSettings() {
        int[] nArray = DABSetupHandler.getDefaultSetup();
        this.guiHandler.processSetup(nArray);
        this.dsiDownManager.reset(1);
        this.dsiDownManager.reset(2);
    }

    public void updateDetectedDevice(int n) {
        switch (n) {
            case 3: {
                if (this.dabDetected) break;
                this.models.getChoiceModel(42467584).setValue(1);
                this.models.getChoiceModel(42467584).setStatus(1);
                this.bandList.addToBandList(5);
                this.dabDetected = true;
                break;
            }
            default: {
                this.models.getChoiceModel(42467584).setStatus(0);
                this.models.getChoiceModel(42467584).setValue(0);
                this.bandList.removeFromBandList(5);
                this.dabDetected = false;
            }
        }
    }

    @Override
    public int getCurSyncState() {
        return this.reception.syncStatus;
    }

    public String getNameOfCurrentService() {
        if (this.getActiveService() != null) {
            return this.getActiveService().fullName;
        }
        return "Unknown service";
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
        this.logger.dabDSI.log(-2137614336, "[DABTuner.setComponentUsage] used: %1 ", bl);
        if (this.isDsiFound()) {
            int n = bl ? 2 : 1;
            boolean bl2 = false;
            GeneralStatusHandler generalStatusHandler = this.deviceUsage;
            synchronized (generalStatusHandler) {
                if (n != this.deviceUsage.getStatus()) {
                    if (!bl && this.isForcedStationListUpdateRunning()) {
                        this.logger.dabDSI.log(1078071040, "[DABTuner.setComponentUsage] faking south side answer for abort LMUpdateStatus : %1", this.isForcedStationListUpdateRunning());
                        RadioCommandList radioCommandList = this.cmdManager.createCmdList("DAB");
                        radioCommandList.add(this.cmdManager.cmdAbortDABForcedUpdateListAndSwitchLinkingDeviceUsage(this.dsiDownManager));
                        this.cmdManager.enqueue(radioCommandList);
                    } else {
                        this.dsiDownManager.switchLinkingDeviceUsage(n);
                    }
                    this.deviceUsage.setStatus(n);
                    bl2 = true;
                }
            }
            if (bl2) {
                this.logger.dabDSI.log(1078071040, "[DABTuner.setComponentUsage] switchLinkingDeviceUsage to state: %1", (long)n);
            }
        } else {
            this.logger.dabDSI.log(1078071040, "[DABTuner.setComponentUsage] no DSI available", bl);
        }
    }

    @Override
    public void setComponentUnused() {
        this.logger.dabDSI.log(1078071040, "[DABTuner.setComponentUnused]");
        if (this.isForcedStationListUpdateRunning()) {
            this.dsiDownManager.forceLMUpdate(2);
        }
        this.setComponentUsage(false);
    }

    @Override
    public int getCurLinkState() {
        return this.reception.linkStatus;
    }

    @Override
    public ServiceInfo getActiveService() {
        return this.activeStation.service;
    }

    public final void setActiveStation(DabStation dabStation) {
        this.logger.dabDeepDebug.log(-2137614336, "[DABT.setActiveStation]: %1", (Object)dabStation);
        if (!dabStation.isEnsemble()) {
            this.activeStation = dabStation;
        }
    }

    @Override
    public DabStation getActiveStation() {
        return this.activeStation;
    }

    @Override
    public EnsembleInfo getActiveEnsemble() {
        return this.activeStation.ensemble;
    }

    @Override
    public ComponentInfo getActiveComponent() {
        return this.activeStation.component;
    }

    @Override
    public boolean forceStationListUpdate(boolean bl) {
        boolean bl2 = this.isForcedStationListUpdateRunning();
        this.logger.dabDSI.log(1078071040, "[DABTuner.forceStationListUpdate] start:%1 already running:%2", bl, bl2);
        boolean bl3 = false;
        if (bl && !bl2) {
            this.dsiDownManager.forceLMUpdate(1);
            bl3 = true;
        } else if (!bl && bl2) {
            RadioCommandList radioCommandList = this.cmdManager.createCmdList("DONT_ABORT");
            radioCommandList.add(this.cmdManager.cmdAbortDABForcedStationListUpdate(this.dsiDownManager));
            this.cmdManager.enqueue(radioCommandList);
            this.models.getChoiceModel(-1970798336).setValue(0);
            this.variantExt.hidePartialPopup(5);
            bl3 = true;
        }
        this.audio.demute();
        return bl3;
    }

    public void forceLMUpdateStatus(int n) {
        if (this.forceUpdateStatus == n) {
            return;
        }
        this.forceUpdateStatus = n;
        if (n == 1) {
            this.models.getChoiceModel(-1970798336).setValue(1);
            this.variantExt.showPartialPopup(5);
        } else {
            this.models.getChoiceModel(-1970798336).setValue(0);
            this.variantExt.hidePartialPopup(5);
        }
        this.propagateUpdatedForceStationListUpdateStatus(5, n);
    }

    @Override
    public void getEPGDetailData(DabStation dabStation) {
        this.dsiDownManager.getEPGDetailData(dabStation);
    }

    @Override
    public void switchDebugInfos(boolean bl) {
        this.showDebugInfos = bl;
        if (bl) {
            ((DABTuner$DsiUpListener)this.dsiUpListener).updateDebugInfos();
        } else {
            this.models.getLabelModel(416).setText("");
        }
    }

    @Override
    public void abortSeek() {
        if (!this.seekRunning) {
            this.logger.dabDSI.log(-2137614336, "[DABTuner.abortSeek] Seek is not active, ignoring");
            return;
        }
        this.logger.dabDSI.log(1078071040, "[DABTuner.abortSeek] send STOP");
        this.seekStation(4, -2);
        this.reTuneActiveServOrComp();
    }

    public void abortForceLMUpdate() {
        if (this.forceUpdateStatus != 2) {
            this.logger.dabDSI.log(-2137614336, "[DABTuner.abortForceLMUpdate] ForceLMUpdate is not active, ignoring");
            return;
        }
        this.logger.dabDSI.log(1078071040, "[DABTuner.abortForceLMUpdate] send STOP");
        this.forceLMUpdateStatus(2);
        this.reTuneActiveServOrComp();
    }

    @Override
    public TunerActionProxyListener getActionProxyListener() {
        return new DABTuner$TunerActionProxyListenerExt(this, null);
    }

    @Override
    public CmdDefaultListener getDSIUpManager() {
        return this.dsiUpManager;
    }

    @Override
    public IPrevNext getPrevNextHandler() {
        return this.guiHandler.prevNextHandler;
    }

    public void addUpdateListeners(IUpdateListener[] iUpdateListenerArray) {
        this.guiHandler.addUpdateListeners(iUpdateListenerArray);
        for (int i2 = 0; i2 < iUpdateListenerArray.length; ++i2) {
            this.addUpdateListener(iUpdateListenerArray[i2]);
        }
    }

    @Override
    public TunerObjectContainer[] startScan() {
        int n;
        TunerObjectContainer[] tunerObjectContainerArray;
        this.dsiDownManager.clearNotification(new int[]{5, 6, 7}, this.dsiDabTunerListener);
        TunerObjectContainer[] tunerObjectContainerArray2 = tunerObjectContainerArray = this.guiHandler.getStationList();
        long l = this.activeStation.getUniqueId();
        for (n = 0; n < tunerObjectContainerArray.length && tunerObjectContainerArray[n].getListID() != l; ++n) {
        }
        if (n == tunerObjectContainerArray.length - 1) {
            tunerObjectContainerArray2 = tunerObjectContainerArray;
        } else {
            tunerObjectContainerArray2 = new TunerObjectContainer[tunerObjectContainerArray.length];
            int n2 = n + 1;
            int n3 = tunerObjectContainerArray.length - n2;
            System.arraycopy((Object)tunerObjectContainerArray, n2, (Object)tunerObjectContainerArray2, 0, n3);
            System.arraycopy((Object)tunerObjectContainerArray, 0, (Object)tunerObjectContainerArray2, n3, n2);
        }
        return tunerObjectContainerArray2;
    }

    @Override
    public void stopScan() {
        this.dsiDownManager.setNotification(new int[]{5, 6, 7}, this.dsiDabTunerListener);
    }

    @Override
    public void performLanguageChange() {
        this.dsiUpManager.forceNextListUpdate();
        this.dsiDownManager.reNotification(5);
        this.dsiDownManager.reNotification(6);
        this.dsiDownManager.reNotification(7);
    }

    public TunerAudioMgmt getAudioManager() {
        return this.audio;
    }

    public boolean isSeekActive() {
        return this.seekRunning;
    }

    private boolean isForcedStationListUpdateRunning() {
        return this.forceUpdateStatus == 1;
    }

    static /* synthetic */ void access$400(DABTuner dABTuner, DabStation dabStation) {
        dABTuner.preTuneAction(dabStation);
    }

    static /* synthetic */ AnnouncementHandler access$500(DABTuner dABTuner) {
        return dABTuner.announce;
    }

    static /* synthetic */ void access$600(DABTuner dABTuner, DabReceptionStatus dabReceptionStatus) {
        dABTuner.handleLinkingAndSyncState(dabReceptionStatus);
    }

    static /* synthetic */ GeneralStatusHandler access$700(DABTuner dABTuner) {
        return dABTuner.deviceUsage;
    }

    static /* synthetic */ boolean access$800(DABTuner dABTuner) {
        return dABTuner.initDone;
    }

    static /* synthetic */ TunerStatus access$900(DABTuner dABTuner) {
        return dABTuner.status;
    }

    static /* synthetic */ TunerModels access$1000(DABTuner dABTuner) {
        return dABTuner.models;
    }

    static /* synthetic */ boolean access$1102(DABTuner dABTuner, boolean bl) {
        dABTuner.seekRunning = bl;
        return dABTuner.seekRunning;
    }

    static /* synthetic */ boolean access$1200(DABTuner dABTuner) {
        return dABTuner.showDebugInfos;
    }

    static /* synthetic */ Logger access$1300(DABTuner dABTuner) {
        return dABTuner.logger;
    }

    static /* synthetic */ boolean access$1100(DABTuner dABTuner) {
        return dABTuner.seekRunning;
    }

    static /* synthetic */ boolean access$1400(DABTuner dABTuner) {
        return dABTuner.isForcedStationListUpdateRunning();
    }

    static /* synthetic */ DABDSIUpManager access$1500(DABTuner dABTuner) {
        return dABTuner.dsiUpManager;
    }
}

