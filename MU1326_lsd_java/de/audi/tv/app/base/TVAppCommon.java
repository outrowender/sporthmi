/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import de.audi.atip.log.LogChannel;
import de.audi.tv.app.EWS;
import de.audi.tv.app.FullscreenHandler;
import de.audi.tv.app.HardKeyListener;
import de.audi.tv.app.SourceManager;
import de.audi.tv.app.StartUpMUConfig;
import de.audi.tv.app.TVHMIApplication;
import de.audi.tv.app.TVInfobar;
import de.audi.tv.app.TVSpeedDisclaimer;
import de.audi.tv.app.audio.AudioFocusClient;
import de.audi.tv.app.audio.EWSBeepHandler;
import de.audi.tv.app.audio.MuteHandler;
import de.audi.tv.app.audio.TVAudioSDISConnectionRetryTimer;
import de.audi.tv.app.audio.TVAudioService;
import de.audi.tv.app.audio.TunerAnnouncementHandler;
import de.audi.tv.app.base.MessageHandler;
import de.audi.tv.app.base.NotificationHandler;
import de.audi.tv.app.base.TVAppCommon$ComponentCallListener;
import de.audi.tv.app.base.TVAppCommon$ResetListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDispatcher;
import de.audi.tv.app.base.TvTunerStateTracker;
import de.audi.tv.app.cas.CasDisclaimer;
import de.audi.tv.app.cas.CasInfo;
import de.audi.tv.app.cmd.TVCmdManager;
import de.audi.tv.app.combi.CombiBAPServiceHandler;
import de.audi.tv.app.combi.CombiBAPServiceTVListenerImpl;
import de.audi.tv.app.dsi.DSICallListener;
import de.audi.tv.app.dsi.DSIHandler;
import de.audi.tv.app.dsi.DSITVTunerListenerImpl;
import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.dsi.DisplayManagerListenerImpl;
import de.audi.tv.app.dsi.DsiProperties;
import de.audi.tv.app.dsi.TuningMonitor;
import de.audi.tv.app.interapp.SourceActivatorAdapter;
import de.audi.tv.app.interapp.TVStateNotifier;
import de.audi.tv.app.interapp.TvSdisManager;
import de.audi.tv.app.joker.JokerKeyHandler;
import de.audi.tv.app.lists.FocusHandler;
import de.audi.tv.app.lists.LogoList;
import de.audi.tv.app.lists.NormAreaSublist;
import de.audi.tv.app.lists.ServiceListsResource;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.TVMenuModelListener;
import de.audi.tv.app.lists.TVStationList;
import de.audi.tv.app.sds.TVServiceHandler;
import de.audi.tv.app.sds.TVServiceImpl;
import de.audi.tv.app.seek.SeekHandler;
import de.audi.tv.app.settings.TVSettings;
import de.audi.tv.app.settings.parental.ChildlockProperties;
import de.audi.tv.app.storage.TVLastmode;
import de.audi.tv.app.storage.TVStorage;
import de.audi.tv.app.tm.KeyPanelHandler;
import de.audi.tv.app.tm.TVEngineering;
import de.audi.tv.app.tm.TouchpadListener;
import de.audi.tv.app.tm.handling.DisplayContextHandler;
import de.audi.tv.app.tm.handling.DisplayManagerHandler;
import de.audi.tv.app.tm.handling.DisplayModeHandler;
import de.audi.tv.app.tm.handling.TerminalAndScreenModeHandler;
import de.audi.tv.app.tm.handling.TerminalModeMisc;
import de.audi.tv.app.util.Handler$Builder;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.dsi.ifc.tvtuner.DSITVTuner;

public class TVAppCommon {
    public final DSIHandler dsiHandler;
    public final TVAppCommon$ComponentCallListener componentCallListener;
    public final DSITVTunerListenerImpl dsiListener;
    final DisplayManagerListenerImpl dsiDisplayListener;
    public final TVEventDispatcher tvEventDispatcher;
    private final TVCmdManager cmdManager;
    protected final TvTunerStateTracker stateTracker;
    final TVHMIApplication hmiApplication;
    final TvSdisManager interappManager;
    protected final TVAudioService audioListener;
    protected final AudioFocusClient audioFocus;
    final CombiBAPServiceHandler combiBAPHandler;
    final CombiBAPServiceTVListenerImpl combiBAPListener;
    protected final ServiceListsResource serviceResource;
    protected final StationMapper mapper;
    protected final TVStationList stationList;
    protected final FocusHandler focusHandler;
    protected final TVStorage storage;
    protected final TVSettings settings;
    private final TVEnv env;
    private final SourceManager sourceManager;
    protected final SeekHandler seekHandler;
    protected final NormAreaSublist normAreaSublist;
    protected final MessageHandler msgHandler;
    protected final NotificationHandler notificationHandler;
    protected final LogoList logoList;
    protected final TVInfobar osd;
    protected final HardKeyListener hardKeyListener;
    protected final KeyPanelHandler keyPanelHandler;
    protected final TouchpadListener touchpadListener;
    protected final EWS ews;
    protected final SourceActivatorAdapter sourceActivatorAdapter;
    private final TVEngineering tvEngineering;
    protected final TVMenuModelListener menuModelListener;
    final TunerAnnouncementHandler taHandler;
    final EWSBeepHandler ewsBeep;
    final TVServiceHandler sdsServiceHandler;
    final TVServiceImpl sdsServiceListener;

    TVAppCommon(TVEnv tVEnv) {
        this.env = tVEnv;
        LogChannel logChannel = tVEnv.lcMain;
        logChannel.log(-2137614336, "[TVApp.new]");
        this.cmdManager = new TVCmdManager(tVEnv.lcCmd, tVEnv.framework);
        this.mapper = new StationMapper();
        this.tvEventDispatcher = new TVEventDispatcher(tVEnv, tVEnv.lcMain, 20);
        this.dsiHandler = new DSIHandler(tVEnv.lcDSI, this.tvEventDispatcher);
        this.componentCallListener = new TVAppCommon$ComponentCallListener(this);
        this.dsiListener = new DSITVTunerListenerImpl(tVEnv.lcDSI);
        this.dsiDisplayListener = new DisplayManagerListenerImpl(tVEnv.lcDSI);
        TVStateNotifier tVStateNotifier = new TVStateNotifier(tVEnv);
        TuningMonitor tuningMonitor = new TuningMonitor(tVEnv.lcMain, this.tvEventDispatcher);
        this.notificationHandler = new NotificationHandler(tVEnv.lcDSI, this.dsiHandler, this.dsiListener);
        this.hmiApplication = new TVHMIApplication(tVEnv);
        this.storage = new TVStorage(tVEnv);
        this.ewsBeep = new EWSBeepHandler(tVEnv.lcMain, new Handler$Builder().setDispatcher(tVEnv.dispatchBase));
        this.audioListener = new TVAudioService(tVEnv.lcAudio, this.ewsBeep.playerListener);
        this.audioListener.addChildAudioServiceListener(new TVAudioSDISConnectionRetryTimer(this.audioListener, tVEnv.lcAudio));
        this.sourceManager = new SourceManager(tVEnv, this.dsiHandler, this.storage, this.notificationHandler);
        new DisplayManagerHandler(tVEnv, this.dsiHandler, tVEnv.dispatch);
        TerminalAndScreenModeHandler terminalAndScreenModeHandler = new TerminalAndScreenModeHandler(tVEnv, this.dsiHandler, tVEnv.dispatch);
        new DisplayModeHandler(tVEnv);
        new DisplayContextHandler(tVEnv);
        ChildlockProperties childlockProperties = new ChildlockProperties(tVEnv);
        TerminalModeMisc.connectMiscModelsAndProperties(tVEnv);
        this.sourceActivatorAdapter = new SourceActivatorAdapter(tVEnv.lcInterapp);
        this.stateTracker = new TvTunerStateTracker(this.tvEventDispatcher, logChannel, tVEnv.dispatchBase, this.audioListener.smAudioService, this.sourceManager, this.sourceActivatorAdapter, this.dsiHandler.createDownCallLock("energy saving mode"), this.storage);
        this.audioFocus = new AudioFocusClient(tVEnv, tVEnv.lcAudio, this.stateTracker.audioFocusListener);
        this.logoList = new LogoList(tVEnv.framework.getStorageMgr(), tVEnv.lcMain);
        this.serviceResource = new ServiceListsResource(tVEnv, this.cmdManager, this.mapper, this.logoList);
        this.stationList = new TVStationList(tVEnv, this.storage, this.dsiHandler, this.mapper);
        this.serviceResource.registerStationList(this.stationList);
        this.settings = new TVSettings(tVEnv, this.dsiHandler, this.stateTracker.childLockListener);
        this.focusHandler = new FocusHandler(tVEnv, this.tvEventDispatcher.listFocusListener);
        this.hardKeyListener = new HardKeyListener(tVEnv, tVEnv.lcHMI, this.focusHandler, tuningMonitor);
        new JokerKeyHandler(tVEnv, this.hardKeyListener, this.audioFocus);
        FullscreenHandler fullscreenHandler = new FullscreenHandler(tVEnv);
        this.combiBAPHandler = new CombiBAPServiceHandler(tVEnv, this.storage);
        this.combiBAPListener = new CombiBAPServiceTVListenerImpl(tVEnv, this.dsiHandler, this.combiBAPHandler, this.hardKeyListener, this.sourceActivatorAdapter, this.audioFocus, this.focusHandler, this.stateTracker);
        new TVSpeedDisclaimer(tVEnv);
        this.tvEngineering = new TVEngineering(tVEnv);
        this.ews = new EWS(tVEnv, this.ewsBeep, this.tvEventDispatcher.ewsListener);
        this.osd = new TVInfobar(tVEnv);
        this.touchpadListener = new TouchpadListener(tVEnv, this.dsiHandler);
        TVLastmode tVLastmode = new TVLastmode(this.storage, this.dsiHandler, tVEnv, this.settings);
        CasInfo casInfo = new CasInfo(tVEnv);
        this.keyPanelHandler = new KeyPanelHandler(this.dsiHandler, tVEnv);
        CasDisclaimer casDisclaimer = new CasDisclaimer(tVEnv, this.keyPanelHandler);
        StartUpMUConfig startUpMUConfig = new StartUpMUConfig(tVEnv);
        MuteHandler muteHandler = new MuteHandler(tVEnv.lcAudio, this.audioListener, this.tvEventDispatcher.audioListener);
        this.seekHandler = new SeekHandler(tVEnv, this.dsiHandler, tVEnv.lcMain);
        this.normAreaSublist = new NormAreaSublist(tVEnv, this.dsiHandler);
        this.interappManager = new TvSdisManager(tVEnv, this.dsiHandler, this.mapper, this.keyPanelHandler, this.stateTracker.interappConnectionListener, this.sourceActivatorAdapter);
        this.msgHandler = new MessageHandler(tVEnv.lcMain);
        this.menuModelListener = new TVMenuModelListener(tVEnv, new int[]{-492034304, -1666439424});
        this.taHandler = new TunerAnnouncementHandler(tVEnv);
        this.sdsServiceHandler = new TVServiceHandler(tVEnv.lcSDS, tVEnv, this.storage);
        this.sdsServiceListener = new TVServiceImpl(tVEnv.lcSDS, this.focusHandler, this.dsiHandler, this.notificationHandler, this.sourceActivatorAdapter);
        DsiProperties dsiProperties = new DsiProperties(tVEnv);
        DefaultTVListener[] defaultTVListenerArray = new DefaultTVListener[]{dsiProperties.dsiUpListener, this.stateTracker.tvListener, this.notificationHandler.tvListener, this.serviceResource.tvListener, this.stationList.tvListener, muteHandler.tvListener, this.sourceManager.tvListener, this.osd.sourceListener, this.interappManager.tvListener, this.ews.tvListener, this.settings.tvListener, tVLastmode.tvListener, casInfo, this.keyPanelHandler.tvListener, terminalAndScreenModeHandler.tvListener, startUpMUConfig, this.hardKeyListener.listener, tuningMonitor.tvListener, this.combiBAPHandler.tvListener, this.sdsServiceHandler.tvListener, casDisclaimer.tvListener};
        this.dsiListener.addListeners(defaultTVListenerArray);
        DSICallListener[] dSICallListenerArray = new DSICallListener[]{dsiProperties.dsiDownListener, casDisclaimer.callListener, muteHandler.dsiCallListener, tVLastmode.dsiCallListener, tuningMonitor.dsiCallListener, this.settings.dsiCallListener, this.osd.callListener, this.serviceResource.selectServiceListener, this.combiBAPHandler.callListener, this.taHandler.callListener, this.componentCallListener};
        this.dsiHandler.addListeners(dSICallListenerArray);
        this.tvEventDispatcher.addListener(this.stateTracker.tvEventListener);
        this.tvEventDispatcher.addListener(this.audioListener.eventListener);
        this.tvEventDispatcher.addListener(this.settings.eventListener);
        this.tvEventDispatcher.addListener(this.serviceResource.selectionListener);
        this.tvEventDispatcher.addListener(fullscreenHandler.eventListener);
        this.tvEventDispatcher.addListener(this.osd.tvListener);
        this.tvEventDispatcher.addListener(this.dsiHandler.tuneUpdateListener);
        this.tvEventDispatcher.addListener(tVLastmode.dsiHandlerLockedListener);
        this.tvEventDispatcher.addListener(this.tvEngineering.activationListener);
        this.tvEventDispatcher.addListener(tVStateNotifier);
        this.tvEventDispatcher.addListener(this.hardKeyListener.activationListener);
        this.tvEventDispatcher.addListener(this.combiBAPHandler.activationListener);
        this.tvEventDispatcher.addListener(this.interappManager.eventListener);
        this.tvEventDispatcher.addListener(this.normAreaSublist.tvStatusListener);
        this.tvEventDispatcher.addListener(this.sdsServiceHandler.eventListener);
        this.tvEventDispatcher.addListener(this.touchpadListener.eventListener);
        this.tvEventDispatcher.addListener(casDisclaimer.eventListener);
        this.tvEventDispatcher.addListener(childlockProperties.childLockListener);
        this.settings.addListener(this.ews.settingListener);
        this.settings.addListener(this.serviceResource.settingListener);
        this.settings.addListener(this.stationList.settingListener);
        this.combiBAPHandler.registerStationList(this.stationList);
        this.combiBAPListener.registerStationList(this.stationList);
        this.sdsServiceHandler.registerStationList(this.stationList);
        this.sdsServiceListener.setStationList(this.stationList);
        this.stationList.registerListener(this.interappManager.listsListener);
        this.stationList.registerListener(this.combiBAPHandler.listsListener);
        this.stationList.registerListener(this.sdsServiceHandler.listsListener);
        this.msgHandler.addMessageListener(new TVAppCommon$ResetListener(this, null));
        this.msgHandler.addMessageListener(this.tvEventDispatcher.messageListener);
        this.tvEngineering.startTimer();
        tVEnv.lcMain.log(-2137614336, "[TVApp.new] done");
    }

    public void resetSettings(boolean bl, boolean bl2) {
        this.env.lcMain.log(1078071040, "[TVApp.resetSettings] sys %1, pers %2", bl, bl2);
        this.tvEventDispatcher.makeFactoryReset();
        this.stationList.resetToDefault();
        this.settings.resetToDefault(bl, bl2);
        this.focusHandler.resetToDefault();
        this.logoList.resetToDefault();
        this.env.properties.terminalMode.desiredTerminalMode.accept(new Integer(0));
    }

    public void setDSI(DSITVTuner dSITVTuner) {
        this.dsiHandler.register(dSITVTuner);
        this.notificationHandler.setNotifications(dSITVTuner);
    }

    public void setDSI(DSIDisplayManagement dSIDisplayManagement) {
        this.dsiHandler.register(dSIDisplayManagement);
    }

    public void setDSI(IDisplayManagerService iDisplayManagerService) {
        this.dsiHandler.register(iDisplayManagerService);
    }

    void deinit() {
        this.cmdManager.deinit();
        this.stateTracker.deinit();
        this.tvEngineering.deinit();
        this.osd.deinit();
        this.settings.deinit();
        this.dsiListener.removeListeners();
    }
}

