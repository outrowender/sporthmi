/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.TiledListModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navtmc.TMCService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.msg.MsgDistributor;
import de.audi.atip.msg.MsgListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.ResponseContainer;
import de.audi.tghu.info.app.tmc.InfoStorageManager;
import de.audi.tghu.info.app.tmc.TMCAbstractListManager;
import de.audi.tghu.info.app.tmc.TMCAbstractListRowBuilder;
import de.audi.tghu.info.app.tmc.TMCConst;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.audi.tghu.info.app.tmc.TMCListener;
import de.audi.tghu.info.app.tmc.TMCSpeechHelper;
import de.audi.tghu.info.app.tmc.TMCTitleLineManager;
import de.audi.tghu.info.app.tmc.commands.TMCCommand;
import de.audi.tghu.info.app.tmc.readout.AppTMCReadOut;
import java.util.Calendar;
import java.util.Date;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class AppTMC
implements TMCService,
MsgListener {
    protected static final int INVALID_LIST_POSITION = -1;
    protected static final String X_URGENT_STRING = "X-URGENT";
    private static final int UPDATING_ICON_SHOW = 0;
    private static final int UPDATING_ICON_HIDE = 1;
    private IPreviewMap previewMap;
    public TMCAbstractListManager listManager;
    private TMCHelper tmcHelper;
    protected boolean rgActive = false;
    private AppTMCReadOut tmcReadOutApp;
    private TMCListener tmcHandler;
    protected IFrameworkAccess framework;
    protected InfoEnv env;
    protected final LogChannel logMain;
    private MapTmcService mapService;
    private NaviService naviService;
    private TMCSpeechHelper speechHelper;
    private InfoStorageManager storageManager;
    protected CommandListManager cmdListManager;
    private long timestampDistanceUpdate = System.currentTimeMillis();
    private Calendar calendar;
    private DateMetric dm;
    private TTSSessionBasedService ttsServiceOverviewList;
    private DateMetric vwDateMetric;
    private boolean isNavigationOperable = false;
    protected TMCAbstractListRowBuilder rowBuilder;
    protected ResponseContainer responseContainer;
    protected long eventsOnRoute;
    protected int trafficRerouting;
    protected boolean hasBetterRoute;
    protected int savingTime;
    protected long trafficDelayOnCurrentRoute;
    private int[] segmentDistance = new int[]{0};
    private int indexOfCurrentDestination;
    private int distanceToFinalDestination;

    public AppTMC(InfoEnv infoEnv, AppTMCReadOut appTMCReadOut) {
        this.env = infoEnv;
        this.framework = infoEnv.getFramework();
        this.tmcHelper = new TMCHelper(infoEnv);
        this.logMain = infoEnv.getLogChannel("App.TMC.Main");
        this.calendar = Calendar.getInstance();
        this.dm = new DateMetric(this.calendar.getTime(), 1);
        this.vwDateMetric = new DateMetric(this.calendar.getTime(), 0);
        this.tmcReadOutApp = appTMCReadOut;
        this.cmdListManager = new CommandListManager("TMC CmdListMgr OL", this.framework, this.logMain, null, infoEnv.getChoiceModel(500166));
        this.cmdListManager.start();
        this.tmcHandler = new TMCListener(this.cmdListManager, infoEnv, this, this.framework);
        this.speechHelper = new TMCSpeechHelper(infoEnv, this.logMain);
        this.responseContainer = new ResponseContainer();
    }

    public void setTTSService(TTSService tTSService, Integer n) {
        this.logMain.log(1000000, "[AppTMC#setTTSService] Called: service %1, id %2", (Object)tTSService, (Object)n);
        switch (n) {
            case 2: {
                TTSSessionBasedService tTSSessionBasedService;
                this.logMain.log(10000000, "[AppTMC#setTTSService] Set TTSService instance for TMC list");
                this.ttsServiceOverviewList = tTSSessionBasedService = (TTSSessionBasedService)tTSService;
                break;
            }
            case 4: {
                if (this.tmcReadOutApp != null) {
                    this.logMain.log(10000000, "[AppTMC#setTTSService] Set TTSService instance for urgent messages");
                    TTSSingleSpeakService tTSSingleSpeakService = (TTSSingleSpeakService)tTSService;
                    this.tmcReadOutApp.setTTSService(tTSSingleSpeakService);
                    break;
                }
                this.logMain.log(10000, "[AppTMC#setTTSService] tmcReadOutApp is null");
                break;
            }
            case 9: {
                if (this.tmcReadOutApp != null) {
                    this.logMain.log(10000000, "[AppTMC#setTTSService] Set TTSService instance for urgent messages no tel");
                    TTSSingleSpeakService tTSSingleSpeakService = (TTSSingleSpeakService)tTSService;
                    this.tmcReadOutApp.setTTSServiceNoTel(tTSSingleSpeakService);
                    break;
                }
                this.logMain.log(10000, "[AppTMC#setTTSService] tmcReadOutApp is null");
                break;
            }
            default: {
                this.logMain.log(10000000, "[AppTMC#setTTSService] unwanted TTSService client id : %1", (Object)n);
            }
        }
    }

    public void requestInitialTMCWindow() {
        this.logMain.log(10000000, "[AppTMC#requestInitialTMCWindow] Requesting the first TMC window");
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(this.listManager.getRequestWindowCommand(TMCConst.INITIAL_WINDOW, -1L, -1, TMCConst.WINDOW_REQUEST_SIZE));
        commandList.add(new TMCCommand(this, this.logMain, "AppTMC#requestInitialTMCWindow1"){

            public void execute() {
                TiledListModelApp tiledListModelApp = AppTMC.this.listManager.getListModel();
                EvoListRow evoListRow = tiledListModelApp.getRow(0);
                if (AppTMC.this.listManager.getMenuModel() != null && evoListRow != null) {
                    AppTMC.this.listManager.getMenuModel().setFocusedItem(tiledListModelApp.getID(), FocusAdvice.VIEWPORT_SECOND_POSITION, evoListRow.getUniqueID());
                    AppTMC.this.listManager.setFocusedRowIndex(0);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new TMCCommand(this, this.logMain, "AppTMC#requestInitialTMCWindow2"){

            public void execute() {
                AppTMC.this.listManager.onUpdateEventsTotal();
                this.getCommandList().commandFinished();
            }
        });
        this.cmdListManager.execute(commandList);
    }

    void requestNewOverviewListWindow(EvoListRow evoListRow, int n) {
        boolean bl;
        this.logMain.log(10000000, "[AppTMC#requestNewOverviewListWindow] called, terminalID: %1", (long)n);
        if (evoListRow != null && (bl = false) < true) {
            this.logMain.log(10000, "[AppTMC#requestNewOverviewListWindow] Abort request - position in complete list invalid");
            return;
        }
    }

    public void stop() {
        this.tmcHandler.stop();
    }

    public void releaseTmcService() {
        this.logMain.log(1000000, "[AppTMC#releaseTmcOnRoute] DSITmc is removed from AppTMC application. ");
        this.tmcHandler.releaseTmcService();
    }

    public void setMapService(MapTmcService mapTmcService) {
        this.logMain.log(10000000, "[AppTMC#setMapService] Called");
        this.mapService = mapTmcService;
        if (this.mapService != null) {
            int n = this.env.getChoiceModel(500161).getValue();
            try {
                if (n == 0) {
                    this.logMain.log(10000000, "[AppTMC#setMapService] Automatic redirection is on");
                    this.mapService.enableAutomaticRouteDiversion(true);
                } else {
                    this.logMain.log(10000000, "[AppTMC#setMapService] Automatic redirection is off");
                    this.mapService.enableAutomaticRouteDiversion(false);
                }
            }
            catch (Exception exception) {
                this.logMain.log(10000, "[AppTMC#setMapService] ERROR = %1", (Throwable)exception);
            }
        }
    }

    public void abortSpeakingSelectedTmcMessage() {
        this.logMain.log(10000000, "[AppTMC#abortSpeakingSelectedTmcMessage] Abort speaking");
    }

    public void setLanguage(Language language) {
        this.logMain.log(10000000, "[AppTMC#setLanguage] Called, language: %1", (Object)language.getLanguageCode());
        String string = language.getLanguageCode();
        this.logMain.log(10000000, "[AppTMC#setLanguage] Following language code is set to TTS instances: %1", (Object)string);
        this.logMain.log(10000000, "[AppTMC#setLanguage] Updating TMC lists");
        this.logMain.log(10000000, "[UpdateDistance#AppTMC#setLanguage] NAR version! Update all TMC lists");
        this.listManager.updateDistanceAndDirection(this.distanceToFinalDestination);
    }

    public void updateRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.logMain.log(10000000, "AppTMC#updateRgDestinationInfo rgDestinationInfo.length: %1", (long)navRouteListDataArray.length);
        this.segmentDistance = new int[navRouteListDataArray.length];
        for (int i2 = 0; i2 < navRouteListDataArray.length; ++i2) {
            this.segmentDistance[i2] = navRouteListDataArray[i2].startDistance - navRouteListDataArray[i2].endDistance;
        }
    }

    public void updateDistanceToFinalDestination(int n) {
        this.distanceToFinalDestination = n;
        long l = System.currentTimeMillis();
        long l2 = l - this.timestampDistanceUpdate;
        if (l2 > 10000L) {
            this.logMain.log(10000000, "AppTMC#updateDistanceToFinalDestination timespan is reached, update the TMC list, diff (%1)", l2);
            this.listManager.updateDistanceAndDirection(n);
            this.timestampDistanceUpdate = l;
        } else if (this.logMain.isDebug2()) {
            this.logMain.log(100000000, "AppTMC#updateDistanceToFinalDestination timespan is NOT reached, do NOT update TMC lists, diff (%1)", l2);
        }
    }

    public void updateIndexOfCurrentDestination(int n) {
        this.indexOfCurrentDestination = n;
    }

    public int repeatOrAbortTmcMessageReadOutSince(long l) {
        if (this.framework.isFrontMU()) {
            this.logMain.log(10000000, "[AppTMC#repeatOrAbortTmcMessageReadOutSince] Called, timestamp: %1", l);
            return this.tmcReadOutApp.repeatOrAbortTmcMessageReadOutSince(l);
        }
        return 0;
    }

    public void updateTimeToNextAnnouncement(long l) {
        if (this.framework.isFrontMU()) {
            this.logMain.log(10000000, "[AppTMC#updateTimeToNextAnnouncement] Called, time: %1", l);
            this.tmcReadOutApp.setTimeForAnnouncement(l);
        }
    }

    public void updateSemidynamicRouteGuidance(long l, boolean bl, boolean bl2, int n) {
        this.logMain.log(10000000, "[AppTMC#updateSemidynamicRouteGuidance] Called");
        this.hasBetterRoute = bl2;
        this.savingTime = n;
        this.trafficDelayOnCurrentRoute = bl ? l : -1L;
    }

    public void updateRgActive(boolean bl) {
        this.logMain.log(10000000, "[AppTMC#updateRgActive] Called, old state: %1, new state: %2", this.rgActive, bl);
        if (this.rgActive != bl) {
            this.logMain.log(10000000, "[AppTMC#updateRgActive] Route guidance activity changed");
            this.rgActive = bl;
            this.listManager.tmcWindowChanged();
            if (!this.rgActive) {
                this.hasBetterRoute = false;
                this.savingTime = 0;
                this.trafficDelayOnCurrentRoute = 0L;
            }
        } else {
            this.logMain.log(10000000, "[AppTMC#updateRgActive] Route guidance activity did NOT change, do nothing");
        }
    }

    public void updateNaviFullyOperable(boolean bl) {
        this.logMain.log(1000000, "[AppTMC#updateNaviFullyOperable] Called, old state: %1, new state: %2", this.isNavigationOperable, bl);
        boolean bl2 = this.isNavigationOperable;
        this.isNavigationOperable = bl;
        if (!bl2) {
            this.checkWindowRequest();
        }
    }

    public void updateDynamicRgActive(boolean bl) {
        this.logMain.log(10000000, "[AppTMC#updateDynamicRgActive] Called, active: %1", bl);
    }

    public void updateTrafficRerouting(int n) {
        this.trafficRerouting = n;
    }

    public void addMsgDistributor(MsgDistributor msgDistributor) {
        this.logMain.log(10000000, "[AppTMC#addMessageDistributor] Called");
    }

    public void processMsg(int n) {
        this.logMain.log(10000000, "[AppTMC#processMessage] message: %1", (long)n);
        switch (n) {
            case 11: {
                this.logMain.log(10000000, "[UpdateDistance#AppTMC#processMessage] Check whether to change units in TMC lists", (long)n);
                this.logMain.log(10000000, "[UpdateDistance#AppTMC#processMessage] NAR version! Update complete list");
                this.listManager.updateDistanceAndDirection(this.distanceToFinalDestination);
                break;
            }
        }
    }

    void demute() {
        this.logMain.log(10000000, "[AppTMC#demute] Called");
    }

    protected int getElementPositionInCompleteList(TmcListElement tmcListElement) {
        int n = -1;
        if (tmcListElement == null) {
            this.logMain.log(100000, "[AppTMC#getElementPositionInCompleteList] element is null, return");
        } else {
            n = tmcListElement.getPositionInCompleteList();
            if (n < 1) {
                this.logMain.log(10000, "[AppTMC#requestNewOverviewListWindow] Position in complete list of focused element must be >0 but is: %1", (long)n);
                n = -1;
            }
        }
        return n;
    }

    public static boolean isMessageOnRoute(TmcMessage tmcMessage) {
        int n;
        boolean bl = false;
        if (tmcMessage != null && (n = tmcMessage.getRouteRelevance()) == 0) {
            bl = true;
        }
        return bl;
    }

    public static boolean isMessageXUrgent(TmcMessage tmcMessage) {
        boolean bl = false;
        if (tmcMessage != null) {
            bl = X_URGENT_STRING.equals(tmcMessage.getUrgent());
        }
        return bl;
    }

    public static boolean isMessageBypassed(TmcMessage tmcMessage) {
        int n;
        boolean bl = false;
        if (tmcMessage != null && ((n = tmcMessage.getRouteRelevance()) == 2 || n == 3)) {
            bl = true;
        }
        return bl;
    }

    public void updateTMCMapActive(boolean bl) {
        if (bl) {
            this.logMain.log(10000000, "[AppTMC#updateTMCMapActive] Called, set sync mediator to OK");
            this.env.getModelAccess().setShowInMapSyncModelOK();
        }
    }

    public void checkWindowRequest() {
        if (this.isDSITmcReady() && this.isNavigationOperable()) {
            this.env.getChoiceModel(500149).setValue(1);
            this.logMain.log(10000000, "[AppTMC#checkWindowRequest] Requesting the initial TMC window...");
            this.requestInitialTMCWindow();
        }
    }

    public void removeMsg(int n) {
        this.tmcHandler.removeMsg(n, -1);
    }

    public void removeMsg(int n, int n2) {
        this.tmcHandler.removeMsg(n, n2);
    }

    private String getTimeStampAsString(Date date) {
        this.calendar.setTime(date);
        this.dm.setDate(this.calendar.getTime());
        return this.dm.format();
    }

    private String getDateAsString(Date date) {
        this.calendar.setTime(date);
        this.vwDateMetric.setDate(this.calendar.getTime());
        return this.vwDateMetric.format();
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public TMCHelper getTMCHelper() {
        return this.tmcHelper;
    }

    public CommandListManager getCmdListManager() {
        return this.cmdListManager;
    }

    public InfoStorageManager getStorageManager() {
        return this.storageManager;
    }

    TTSSessionBasedService getTTSManagerOverviewList() {
        return this.ttsServiceOverviewList;
    }

    public AppTMCReadOut getReadOutApp() {
        return this.tmcReadOutApp;
    }

    public TMCSpeechHelper getSpeechHelper() {
        return this.speechHelper;
    }

    public TMCTitleLineManager getTitleLineManager() {
        return this.tmcHandler.getTitleLineManager();
    }

    public TMCListener getTMCHandler() {
        return this.tmcHandler;
    }

    public NaviService getNaviService() {
        return this.naviService;
    }

    public MapTmcService getMapService() {
        return this.mapService;
    }

    boolean isRgActive() {
        return this.rgActive;
    }

    public boolean isDSITmcReady() {
        return this.tmcHandler.isDSITmcReady();
    }

    public boolean isNavigationOperable() {
        return this.isNavigationOperable;
    }

    public ResponseContainer getResponseContainer() {
        return this.responseContainer;
    }

    public void setTmcService(DSIBase dSIBase) {
        this.tmcHandler.setTmcService(dSIBase);
    }

    public void setStorageManager(InfoStorageManager infoStorageManager) {
        this.storageManager = infoStorageManager;
    }

    public void setRgActive(boolean bl) {
        this.rgActive = bl;
        this.getReadOutApp().updateRgActive(bl);
    }

    public void setNaviService(NaviService naviService) {
        this.naviService = naviService;
    }

    public void setPreviewMap(IPreviewMap iPreviewMap) {
        this.previewMap = iPreviewMap;
    }

    public IPreviewMap getPreviewMap() {
        return this.previewMap;
    }

    public TMCAbstractListRowBuilder getRowBuilder() {
        return this.rowBuilder;
    }

    public void showHideTMCPopup() {
    }

    public void popupRemoved(int n, int n2) {
    }

    public void popupVisible(int n, int n2) {
    }

    public void tmcScreenVisible() {
        this.logMain.log(1000000, "[AppTMC#tmcScreenVisible]");
        this.listManager.setTmcScreenShown(true);
    }

    public void tmcScreenHidden() {
        this.logMain.log(1000000, "[AppTMC#tmcScreenHidden]");
        this.listManager.setTmcScreenShown(false);
    }

    public void fillDetailScreen(TmcMessage tmcMessage) {
        this.listManager.fillDetailScreen(tmcMessage);
    }

    public void fillDetailScreen(TmcMessage tmcMessage, int n) {
        this.listManager.fillDetailScreen(tmcMessage, n);
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage) {
        this.listManager.setPreviewTrafficInfoTmcEvent(tmcMessage);
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n) {
        this.setPreviewTrafficInfoTmcEvent(tmcMessage, n, true);
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n, boolean bl) {
        this.listManager.setPreviewTrafficInfoTmcEvent(tmcMessage, n, bl);
    }

    public void updateEventsOnRoute(long l) {
        this.eventsOnRoute = l;
    }

    public int getIndexOfCurrentDestination() {
        return this.indexOfCurrentDestination;
    }

    public int[] getSegmentDistances() {
        return this.segmentDistance;
    }

    public int getDistanceToFinalDestination() {
        return this.distanceToFinalDestination;
    }

    public void detailsScreenEntered() {
        this.listManager.detailsScreenEntered();
    }

    public void leaveMapSemidynamicRouteScreen() {
    }

    public void showTMCWarningPopup() {
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        this.listManager.updateTmcMessagesAhead(tmcMessageArray);
    }
}

