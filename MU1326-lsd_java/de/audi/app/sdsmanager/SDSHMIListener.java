/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.ISDSDispatcher;
import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.IJoystickBlock;
import de.audi.app.sdsmanager.apps.ISDSApplication;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.terminalmode.ITerminalModeSDSHandler;
import de.audi.app.sdsmanager.commands.CommandChangeLanguage;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.MobileSpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.app.sdsmanager.dsi.SpeechTTSHandler;
import de.audi.app.sdsmanager.grammar.IDynamicLists;
import de.audi.app.sdsmanager.grammar.ISDSGrammarState;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.drawerfocus.DrawerFocusUtil;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.model.DefaultListListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.i18n.I18NTarget;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSService$ScreenConnectedSDSData;
import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceSDS;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;

public class SDSHMIListener
extends DefaultListListener
implements HMIApplication,
ChoiceListener,
SpeedThresholdListener,
TimerListener,
I18NTarget,
IViewSizeListener {
    private static boolean firstPTTProcessed = false;
    private final LogChannel lc = Logger.getHMILog();
    private final SDSModelAccess modelAccess;
    private final AppSDSManager sdsManager;
    private final ISDSDispatcher dispatcher;
    protected final SpeechRecognitionHandler srHandler;
    private final MobileSpeechRecognitionHandler mobileSRHandler;
    private final SpeechTTSHandler ttsHandler;
    private CommandListManager cmdListManager;
    protected final IFrameworkAccess framework;
    private final IDynamicLists dynamicHMIList;
    private final ISDSPopupHelper sdsPopupHelper;
    private final ISDSGrammarState grammarState;
    private final SDSAudioHandler audioHandler;
    private ITerminalModeSDSHandler terminalModeSDSHandler;
    private final Timer statusBarTimer = new Timer("SDSHMIListenerStatusBarTimer", 5, this.lc, this, 0, true);
    private final Timer tempCombiTimer = new Timer("SDSHMIListenerTempCombiTimer", 5, this.lc, this, 0, true);
    protected SDSAdapter sdsAdapter;
    private CombiBAPServiceSDS combiService;
    protected SDSAppFactory factory;
    private int tempCombiState = 2;
    private int combiState = 1;
    private boolean pttLongpushActive = false;
    private boolean pttIgnoreActive;
    private NaviService naviService;
    private int currentSDSScreenId = -1;
    private static final int LOGICAL_SDS_POPUP_SCREEN_ID = SDSManagerBaseActivator.getMapping().getScreenID(1);
    private static final int KOMBI_ACTIVE_POPUP_SCREEN_ID = SDSManagerBaseActivator.getMapping().getScreenID(55);
    private static final int SMALL_STAGE_TYPE_SCREENSHOT;

    protected SDSHMIListener(IFrameworkAccess iFrameworkAccess, AppSDSManager appSDSManager, SpeechRecognitionHandler speechRecognitionHandler, SpeechTTSHandler speechTTSHandler, IDynamicLists iDynamicLists, ISDSGrammarState iSDSGrammarState, ISDSPopupHelper iSDSPopupHelper, SDSAudioHandler sDSAudioHandler, MobileSpeechRecognitionHandler mobileSpeechRecognitionHandler, ISDSDispatcher iSDSDispatcher) {
        this.framework = iFrameworkAccess;
        this.modelAccess = new SDSModelAccess(iFrameworkAccess, this);
        this.sdsManager = appSDSManager;
        this.dispatcher = iSDSDispatcher;
        this.srHandler = speechRecognitionHandler;
        this.ttsHandler = speechTTSHandler;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.audioHandler = sDSAudioHandler;
        this.modelAccess.registerModelListeners();
        this.dynamicHMIList = iDynamicLists;
        this.grammarState = iSDSGrammarState;
        this.mobileSRHandler = mobileSpeechRecognitionHandler;
        this.lc.log(-2137614336, "SDSHMIListener initialized.");
    }

    void stop() {
        this.lc.log(-2137614336, "SDSHMIListener#stop: Resetting status!");
        this.updateSDSStatusInactive(false, true);
    }

    void registerSysAppListeners(IFrameworkAccess iFrameworkAccess) {
        this.lc.log(-2137614336, "SDSHMIListener#registerSysAppListeners: Registering speed threshold listener.");
        iFrameworkAccess.getSysApp().registerSpeedThresholdListener(this, 1);
    }

    @Override
    public int getId() {
        return 14;
    }

    @Override
    public ButtonModelApp getVirtualButton(int n) {
        this.lc.log(-2137614336, "SDSHMIListener#getVirtualButton: keycode=%1", (long)n);
        switch (n) {
            case 34: {
                return (ButtonModelApp)((Object)this.modelAccess.getModel(-1050929920));
            }
            case 36: {
                return (ButtonModelApp)((Object)this.modelAccess.getModel(-1017375488));
            }
            case 35: {
                return (ButtonModelApp)((Object)this.modelAccess.getModel(-1034152704));
            }
        }
        return null;
    }

    @Override
    public void popupVisible(int n, int n2) {
        this.lc.log(-2137614336, "SDSHMIListener#popupVisible: id=%1", (long)n);
    }

    @Override
    public void popupHidden(int n, int n2) {
        this.lc.log(-2137614336, "SDSHMIListener#popupHidden: id=%1!", (long)n);
    }

    @Override
    public void popupRemoved(int n, int n2) {
        this.lc.log(-2137614336, "SDSHMIListener#popupRemoved: id=%1", (long)n);
    }

    @Override
    public void screenVisible(int n, int n2) {
        this.lc.log(-2137614336, "SDSHMIListener#screenVisible: screen with ID %1 visible", (long)n);
    }

    @Override
    public void screenHidden(int n, int n2) {
        this.lc.log(-2137614336, "SDSHMIListener#screenHidden: screen with ID %1 hidden", (long)n);
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        int n3 = this.sdsPopupHelper.getCurrentHMIPopup();
        this.lc.log(-2137614336, "SDSHMIListener#screenFadedOut: Popup %1 triggered and screen %2 fading out!", (long)n3, (long)n);
        if (this.currentSDSScreenId == n) {
            this.currentSDSScreenId = -1;
            this.srHandler.setExpectedLongRecognitionTimeoutMode(false);
        } else if (SDSManagerBaseActivator.getMapping().getScreenMapping(n) != 1) {
            this.lc.log(-1601830656, "SDSHMIListener#screenFadedOut: Connected screenId %1 is not the fading out screenId %2!", (long)this.currentSDSScreenId, (long)n);
        }
        this.factory.getSDSHandlerSystem().systemScreenFadedOut(n);
        if (!this.checkIgnoreFadingOut(n, n3)) {
            this.checkAbortSDSAfterHighPrioPopupConnect(n);
        }
    }

    private boolean checkIgnoreFadingOut(int n, int n2) {
        if (this.sdsPopupHelper.isSDSPopup(n2)) {
            this.lc.log(-2137614336, "SDSHMIListener#checkIgnoreFadingOut: Screen fading out was triggered by SDS-request of popup => NOP!");
            return true;
        }
        if (n2 == -1 && n != LOGICAL_SDS_POPUP_SCREEN_ID) {
            this.lc.log(-2137614336, "SDSHMIListener#checkIgnoreFadingOut: Screen fading out was triggered by SDS-request of GUI-screen => NOP!");
            return true;
        }
        if (n == LOGICAL_SDS_POPUP_SCREEN_ID && this.sdsPopupHelper.isLogicalPopupRemovedBySDS() || n == LOGICAL_SDS_POPUP_SCREEN_ID && !this.sdsPopupHelper.isLogicalPopupRemovedBySDS() && this.sdsPopupHelper.isLogicalPopupCalledToBeRemovedBySDS()) {
            this.lc.log(-2137614336, "SDSHMIListener#checkIgnoreFadingOut: Logical popup screen fading out was triggered by SDS => NOP!");
            this.sdsPopupHelper.setLogicalPopupCalledToBeRemovedBySDS(false);
            return true;
        }
        if (this.sdsManager.isSDSAborting()) {
            this.lc.log(-2137614336, "SDSHMIListener#checkIgnoreFadingOut: Screen fading out was triggered by high prio popup but SDS already aborting => NOP!");
            return true;
        }
        this.lc.log(-2137614336, "SDSHMIListener#checkIgnoreFadingOut: No ignore case => Check if SDS must be aborted!");
        return false;
    }

    private void checkAbortSDSAfterHighPrioPopupConnect(int n) {
        if (this.sdsManager.isSDSActive() || this.sdsManager.isExternalSDSActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#checkAbortSDSAfterHighPrioPopupConnect: High-prio popup triggered => Abort SDS-session!");
            SDSModelAccess.setSDSAborterType(11);
            this.sdsManager.abortSDSSession(this.sdsManager.isSDSWaitStateActive());
            return;
        }
        if (this.sdsManager.isSDSSpeechPopupActive() && (n == LOGICAL_SDS_POPUP_SCREEN_ID || n == KOMBI_ACTIVE_POPUP_SCREEN_ID)) {
            this.lc.log(-2137614336, "SDSHMIListener#checkAbortSDSAfterHighPrioPopupConnect: High-prio popup already active => Abort starting of SDS-session!");
            SDSModelAccess.setSDSAborterType(11);
            this.sdsManager.forceAbortSDSSession(true);
            return;
        }
    }

    @Override
    public void screenConnected(int n, int n2) {
        this.lc.log(-2137614336, "SDSHMIListener#screenConnected: screenID=%1", (long)n);
        if (n == LOGICAL_SDS_POPUP_SCREEN_ID) {
            return;
        }
        if (n == KOMBI_ACTIVE_POPUP_SCREEN_ID && !this.sdsManager.isSDSAborting()) {
            this.lc.log(-2137614336, "SDSHMIListener#screenConnected: Kombi active popup screen connected => Abort SDS-session (startup)!");
            this.checkAbortSDSAfterHighPrioPopupConnect(n);
            return;
        }
        this.currentSDSScreenId = n;
        boolean bl = this.sdsManager.isConnectedScreenScollable(n);
        this.lc.log(-2137614336, "SDSHMIListener#screenConnected: Connected screen isScrollable=%1!", bl);
        if (bl) {
            this.srHandler.setExpectedLongRecognitionTimeoutMode(true);
        }
        if (!this.sdsManager.isSDSActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#screenConnected: SDS not active => no further operations!");
            return;
        }
        if (this.sdsAdapter.isCommandScreen() && this.sdsPopupHelper.isBigCommandDisplay(n) && !this.sdsManager.isSDSAborting()) {
            SDSUtils.updateSDSNumbers(true);
            this.sdsPopupHelper.updateBigCommandDisplayConnected();
        }
        this.factory.getSDSHandlerSystem().systemScreenConnected(n);
    }

    public int getCurrentSDSScreenId() {
        return this.currentSDSScreenId;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
        if (abstractSystemCallCommand != null && abstractSystemCallCommand.handleKeyTyped(n, n2, n3)) {
            return;
        }
        SDSAdapter sDSAdapter = this.sdsAdapter;
        switch (n) {
            case 3984: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: Aborting posttraining!");
                sDSAdapter.handleLeavingWaitingState();
                sDSAdapter.sendEvent(1004);
                if (this.sdsManager.isSDSActive()) break;
                SDSModelAccess.fireSettingsEvent(n, n3);
                break;
            }
            case 3983: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: Starting posttraining!");
                sDSAdapter.handleLeavingWaitingState();
                this.keyTypedSDSPostTrainingButton();
                break;
            }
            case 3985: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: Resetting posttraining data!");
                this.srHandler.deleteProfile(this.factory.getSDSHandlerADB().getProfileID());
                SDSModelAccess.fireSettingsEvent(n, n3);
                break;
            }
            case 245: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: Help button typed, starting special dialog!");
                sDSAdapter.handleLeavingWaitingState();
                this.startSpecialDialog((byte)3);
                break;
            }
            case 3993: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: External SDS abort button typed, triggering stopping mobile speech recognition!");
                sDSAdapter.handleLeavingWaitingState();
                this.mobileSRHandler.requestStopSpeechRecognition();
                break;
            }
            case 3994: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: External SDS continue button typed, starting mobile speech recognition!");
                sDSAdapter.handleLeavingWaitingState();
                this.mobileSRHandler.requestStartSpeechRecognition();
                break;
            }
            case 4139: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: Starting SMS dictation!");
                sDSAdapter.handleLeavingWaitingState();
                this.keyTypedSDSStartingButton(4, 1017);
                break;
            }
            case 4299: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: Starting mail dictation!");
                sDSAdapter.handleLeavingWaitingState();
                this.keyTypedSDSStartingButton(5, 1018);
                break;
            }
            case 4300: {
                this.lc.log(-2137614336, "SDSHMIListener#keyTyped: Starting POI online search!");
                sDSAdapter.handleLeavingWaitingState();
                this.keyTypedSDSStartingButton(6, 1019);
                break;
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
        this.lc.log(-2137614336, "SDSHMIListener#keyLongTyped: modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
    }

    private void keyTypedSDSPostTrainingButton() {
        int n = this.checkPTTConditions();
        if (n != 0) {
            this.handleIgnoreDialogStartTrigger(n, false);
            return;
        }
        if (SDSModelAccess.getPosttrainingSpeedValue() == 1) {
            this.lc.log(-2137614336, "keyTypedSDSPostTrainingButton: Car is moving, displaying SETTINGS_SDS_TRAINING_RUN_ERROR-V!");
            SDSModelAccess.fireSettingsEvent(3983, 0);
            return;
        }
        this.lc.log(-2137614336, "SDSHMIListener#keyTypedSDSPostTrainingButton: Setting model and triggering posttraining!");
        SDSModelAccess.setDialogJumpingModel(1);
        this.sdsAdapter.sendEvent(3);
    }

    private void keyTypedSDSStartingButton(int n, int n2) {
        if (!this.sdsAdapter.isSDSActive()) {
            int n3 = this.checkPTTConditions();
            if (n3 != 0) {
                this.handleIgnoreDialogStartTrigger(n3, false);
                return;
            }
            SDSModelAccess.setDialogJumpingModel(n);
            this.sdsAdapter.sendEvent(5);
        } else if (!this.sdsAdapter.isSDSAborting()) {
            this.sdsAdapter.sendEvent(n2);
        }
    }

    private void checkCombiState() {
        if (this.tempCombiTimer.isRunning()) {
            this.lc.log(-1601830656, "SDSHMIListener#checkCombiState: Temporary combi timer already running!");
            return;
        }
        this.lc.log(-2137614336, "SDSHMIListener#checkCombiState: Updating combi state and restarting temporary combi state timer!");
        int n = this.combiState;
        this.setCombiState(this.tempCombiState);
        this.setTempCombiState(n);
        this.tempCombiTimer.restart();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
        byte by = this.audioHandler.getDownlinkStatus();
        boolean bl = this.sdsManager.isSDSAborting();
        boolean bl2 = this.sdsAdapter.isSDSEnding();
        if (bl || bl2 || by == 1 || by == 4) {
            this.lc.log(-1601830656, "SDSHMIListener#keyPressed: Dialog aborting or audio requested/released, ignoring PTT and NOT checking combi state! aborting=%1, ending=%2, downlinkStatus=%3", bl, (Object)bl2, (Object)new Byte(by));
            this.pttIgnoreActive = true;
            return;
        }
        int n4 = this.checkPTTConditions();
        if (n4 != 0) {
            this.handleIgnoreDialogStartTrigger(n4, true);
            switch (n) {
                case 0x155CC1: {
                    this.checkAndNotifyExternalSDSKeyListenersForPTT();
                    break;
                }
                case 1400002: {
                    this.handlePTTLong();
                    break;
                }
                default: {
                    this.lc.log(-2137614336, "SDSHMIListener#keyPressed: not meeting PTT conditions, button %1 -> NOP!", (long)n);
                }
            }
            return;
        }
        switch (n) {
            case 0x155CC1: {
                this.lc.log(-2137614336, "SDSHMIListener#keyPressed: PTT pressed, waiting for keyReleased!");
                this.checkAndNotifyExternalSDSKeyListenersForPTT();
                break;
            }
            case 1400002: {
                this.lc.log(-2137614336, "SDSHMIListener#keyPressed: PTT_LONG pressed!");
                this.handlePTTLong();
                break;
            }
            case 1400003: {
                this.lc.log(-2137614336, "SDSHMIListener#keyPressed: PTT_DOUBLE pressed, aborting session!");
                this.pttIgnoreActive = true;
                SDSModelAccess.setSDSAborterType(12);
                this.sdsManager.abortSDSSession();
                break;
            }
            case 1400004: {
                this.lc.log(-2137614336, "SDSHMIListener#keyPressed: PTT_OFF pressed, aborting session!");
                this.sdsManager.abortSDSSession();
                break;
            }
            default: {
                this.lc.log(-2137614336, "SDSHMIListener#keyPressed: button %1 -> NOP!", (long)n);
            }
        }
    }

    private boolean isExternalSDSBlocked() {
        byte by = this.sdsManager.getPTTBlocked();
        boolean bl = by == 5;
        this.lc.log(-2137614336, "SDSHMIListener#isExternalSDSBlocked: value %1, blocking reason %2", bl, (long)by);
        return bl;
    }

    private void checkAndNotifyExternalSDSKeyListenersForPTT() {
        if (this.terminalModeSDSHandler.isTerminalModeDeviceActive() && !this.isExternalSDSBlocked()) {
            this.sdsManager.notifyExternalSDSKeyListeners(0);
        }
    }

    private void checkAndNotifyExternalSDSKeyListenersForPTTLong() {
        this.lc.log(-2137614336, "SDSHMIListener#checkAndNotifyExternalSDSKeyListenersForPTTLong: Terminal-Mode device is active => setting flag and notifying AppTerminalMode!");
        this.setLongPushActive(true);
        this.sdsManager.notifyExternalSDSKeyListeners(2);
    }

    private void handleIgnoreDialogStartTrigger(int n, boolean bl) {
        this.lc.log(-1601830656, "SDSHMIListener#keyPressed: PTT conditions not OK, ignoring PTT and checking combi state!");
        if (n == 5) {
            this.lc.log(-2137614336, "SDSHMIListener#keyPressed: incoming call or SDS deactivated because of SWaP -> do not update the combi state!");
        } else {
            this.checkCombiState();
        }
        this.pttIgnoreActive = bl;
        this.framework.getStartupMgr().logStartupEvent(new StringBuffer().append("[Startup SDS] Phase 6a: First PTT declined with status ").append(n).append("!").toString());
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
        this.lc.log(-2137614336, "SDSHMIListener#keyReleased: id=%1", (long)n);
        if (this.pttIgnoreActive) {
            this.lc.log(-2137614336, "SDSHMIListener#keyReleased: Ignoring PTT!");
            if (n == -1050929920) {
                if (!this.pttLongpushActive && !this.terminalModeSDSHandler.isTerminalModeSpeechActive()) {
                    if (SDSModelAccess.isSDSDisabledForLanguage()) {
                        this.indicateSDSStatus(7, "SDS/TTS not available for language");
                    } else if (!this.sdsAdapter.isSDSAndTTSReady()) {
                        this.indicateSDSStatus(1, "SDS or TTS not ready");
                    }
                }
                if (this.terminalModeSDSHandler.isTerminalModeSpeechActive()) {
                    this.lc.log(-2137614336, "SDSHMIListener#keyReleased: TerminalMode Speech active, sending event to TerminalMode to abort!");
                    this.sdsManager.notifyExternalSDSKeyListeners(this.pttLongpushActive ? 3 : 1);
                }
                this.setLongPushActive(false);
            }
            this.pttIgnoreActive = false;
            return;
        }
        switch (n) {
            case 0x155CC1: {
                this.lc.log(-2137614336, "SDSHMIListener#keyReleased: PTT released!");
                if (this.pttLongpushActive) {
                    this.lc.log(-2137614336, "SDSHMIListener#keyReleased: PTT longpush active, ignoring PTT release!");
                    this.setLongPushActive(false);
                    if (this.isExternalSDSBlocked()) break;
                    this.sdsManager.notifyExternalSDSKeyListeners(3);
                    break;
                }
                this.lc.log(-2137614336, "SDSHMIListener#keyReleased: PTT longpush inactive, handling PTT!");
                this.handlePTTShort();
                break;
            }
            case 1400002: {
                this.lc.log(-2137614336, "SDSHMIListener#keyReleased: PTT long released!");
                break;
            }
            default: {
                this.lc.log(-2137614336, "SDSHMIListener#keyReleased: Unhandled button %1!", (long)n);
            }
        }
    }

    public void movedDDSJoystick(JoystickEvent joystickEvent) {
        if (joystickEvent == null) {
            this.lc.log(10000, "SDSHMIListener#movedDDSJoystick: Joystick event is null!");
            return;
        }
        this.lc.log(-2137614336, "SDSHMIListener#movedDDSJoystick: joystickEvent: %1!", (Object)joystickEvent);
        int n = joystickEvent.getDirection();
        if (this.ignoreJoystick(n)) {
            joystickEvent.setConsumed(false);
            return;
        }
        if (this.blockFurtherCommandsJoystick(n)) {
            joystickEvent.setConsumed(true);
            return;
        }
        if (n == 6) {
            this.sdsPopupHelper.toggleFurtherCommandDisplay();
            joystickEvent.setConsumed(true);
            return;
        }
        if (this.sdsPopupHelper.isFurtherCommandDisplayActive()) {
            this.sdsPopupHelper.removeFurtherCommandDisplay();
            joystickEvent.setConsumed(true);
            return;
        }
        joystickEvent.setConsumed(false);
    }

    private boolean ignoreJoystick(int n) {
        if (!this.sdsAdapter.isSDSActive() && !this.sdsManager.isExternalSDSActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#ignoreJoystick: No SDS active => Ignore joystick!");
            return true;
        }
        if (this.sdsAdapter.isSDSPaused()) {
            this.lc.log(-2137614336, "SDSHMIListener#ignoreJoystick: SDS paused => Ignore joystick and let phone handle!");
            return true;
        }
        if (n == 2 && (this.currentSDSScreenId == SDSManagerBaseActivator.getMapping().getScreenID(42) || this.currentSDSScreenId == SDSManagerBaseActivator.getMapping().getScreenID(43))) {
            this.lc.log(-2137614336, "SDSHMIListener#ignoreJoystick: MessageEdit-Screen active => Ignore joystick!");
            return true;
        }
        if (n != 6) {
            return false;
        }
        ISDSApplication[] iSDSApplicationArray = this.dispatcher.getRegisteredApplications();
        if (iSDSApplicationArray == null) {
            this.lc.log(-2137614336, "SDSHMIListener#ignoreJoystick: applicationHandler is null => Do not ignore joystick!");
            return false;
        }
        int n2 = iSDSApplicationArray.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            try {
                this.lc.log(-2137614336, "SDSHMIListener#ignoreJoystick: Check application handler number %2 - %1!", (Object)super.getClass().getName(), (long)i2);
                if (!iSDSApplicationArray[i2].ignoreJoystick()) continue;
                this.lc.log(-2137614336, "SDSHMIListener#ignoreJoystick: Application handler number %2 - %1 active => Ignore joystick!", (Object)iSDSApplicationArray[i2], (long)i2);
                return true;
            }
            catch (Exception exception) {
                this.lc.log(-2137614336, "SDSHMIListener#ignoreJoystick: Exception in %1!", (Object)iSDSApplicationArray[i2], (Throwable)exception);
            }
        }
        return false;
    }

    private boolean blockFurtherCommandsJoystick(int n) {
        if (SDSModelAccess.getCommandType() == 3) {
            this.lc.log(-2137614336, "SDSHMIListener#blockFurtherCommandsJoystick: SDS help active => No further commands!");
            return true;
        }
        if (SDSModelAccess.getPosttrainingActiveValue() == 1) {
            this.lc.log(-2137614336, "SDSHMIListener#blockFurtherCommandsJoystick: SDS posttraining active => No further commands!");
            return true;
        }
        if (this.sdsManager.isExternalSDSActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#blockFurtherCommandsJoystick: External SDS active => No further commands!");
            return true;
        }
        if (n == 0) {
            this.lc.log(-2137614336, "SDSHMIListener#blockFurtherCommandsJoystick: Idle joystick event => No reaction!");
            return true;
        }
        if (this.sdsAdapter.isSDSAborting()) {
            this.lc.log(-2137614336, "SDSHMIListener#blockFurtherCommandsJoystick: SDS already aborting => No further commands!");
            return true;
        }
        if (SDSUtils.getActiveSystemCall() instanceof IJoystickBlock) {
            this.lc.log(-2137614336, "SDSHMIListener#blockFurtherCommandsJoystick: Systemcall is running which requires access to screen behind => No further commands!");
            return true;
        }
        return false;
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.lc.log(-2137614336, "SDSHMIListener#itemSelected: called with id=%1, row=%2!", (long)n, (long)n2);
        switch (n) {
            case 3987: {
                boolean bl = n2 != 0;
                this.sdsAdapter.changeQuickMode(bl);
                SDSModelAccess.setRepeatCommand(n2);
                this.lc.log(-2137614336, "SDSHMIListener#itemSelected: quickMode=%1!", bl);
                break;
            }
            case 3986: {
                boolean bl = n2 != 0;
                this.sdsAdapter.changeBeepOn(bl);
                SDSModelAccess.setPrompt(n2);
                this.lc.log(-2137614336, "SDSHMIListener#itemSelected: beepOn=%1!", bl);
                break;
            }
            case 3982: {
                boolean bl = n2 != 0;
                this.sdsAdapter.changeExpertMode(bl);
                SDSModelAccess.setExpertMode(n2);
                this.lc.log(-2137614336, "SDSHMIListener#itemSelected: expertMode=%1!", bl);
                break;
            }
            case 3981: {
                boolean bl = n2 != 0;
                this.sdsAdapter.changeCommandScreen(bl);
                SDSModelAccess.setCommandScreen(n2);
                this.lc.log(-2137614336, "SDSHMIListener#itemSelected: commandScreen=%1!", bl);
                break;
            }
            case 337: {
                boolean bl = n2 != 0;
                this.sdsAdapter.changeVoiceBargeIn(bl);
                SDSModelAccess.setVoiceBargeIn(n2);
                this.lc.log(-2137614336, "SDSHMIListener#itemSelected: voiceBargeIn=%1!", bl);
                break;
            }
            case 535: {
                this.itemSelectedDrawerStateChoice(n2);
                break;
            }
            default: {
                this.lc.log(10000, "SDSHMIListener#itemSelected: Unhandled model ID %1!", (long)n);
            }
        }
    }

    private void itemSelectedDrawerStateChoice(int n) {
        boolean bl = DrawerFocusUtil.isOptionMenuOpened(n);
        boolean bl2 = DrawerFocusUtil.isSelectionMenuOpened(n);
        boolean bl3 = DrawerFocusUtil.isMainArea(n);
        boolean bl4 = DrawerFocusUtil.isEntertainmentMenuOpened(n);
        if (bl3) {
            this.lc.log(-2137614336, "SDSHMIListener#itemSelectedDrawerStateChoice: main area visible!");
            this.sdsPopupHelper.updateFurtherCommandsRemoved();
        } else if (bl4) {
            this.lc.log(-2137614336, "SDSHMIListener#itemSelectedDrawerStateChoice: entertainment menu opened => NOP!");
            this.sdsPopupHelper.updateFurtherCommandsShown();
        } else if (!this.sdsManager.isSDSActive() || this.sdsManager.isSDSAborting() || this.sdsManager.getWaitStateStatus() == 1 || this.sdsManager.getWaitStateStatus() == 2 || this.sdsAdapter.isSDSEnding()) {
            this.lc.log(-2137614336, "SDSHMIListener#itemSelectedDrawerStateChoice: Drawer state %1 changed, but SDS inactive, waiting, ending or aborting => NOP!", (long)n);
        } else if (bl || bl2) {
            this.lc.log(-2137614336, "SDSHMIListener#itemSelectedDrawerStateChoice: %1 drawer opened!", (Object)(bl ? "Right" : "Left"));
            this.sdsManager.checkAbortingAndTriggerWaitState();
        } else {
            this.lc.log(-2137614336, "SDSHMIListener#itemSelectedDrawerStateChoice: Unhandled row %1 => NOP!", (long)n);
        }
    }

    @Override
    public void exceedsUpperThreshold(int n) {
        this.lc.log(-2137614336, "SDSHMIListener#exceedsUpperThreshold: id=%1", (long)n);
        SDSModelAccess.setPosttrainingSpeed(1);
    }

    @Override
    public void belowLowerThreshold(int n) {
        this.lc.log(-2137614336, "SDSHMIListener#belowLowerThreshold: id=%1", (long)n);
        SDSModelAccess.setPosttrainingSpeed(0);
    }

    private void handlePTTShort() {
        if (!firstPTTProcessed) {
            firstPTTProcessed = true;
            this.framework.getStartupMgr().logStartupEvent("[Startup SDS] Phase 6: First PTT processed.");
        }
        if (this.sdsAdapter.isPttRunning()) {
            this.lc.log(-1601830656, "SDSHMIListener#handlePTTShort: PTT already running!");
            return;
        }
        if (Boolean.getBoolean("externalSDS") && this.mobileSRHandler.isMobileSpeechRecognitionActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTShort: Mobile speech recognition active, restarting it (delayed)!");
            this.mobileSRHandler.requestDelayedStartSpeechRecognition();
            return;
        }
        if (this.ttsHandler.isTTSAborting() || this.sdsManager.isSDSAborting() || this.sdsAdapter.isSDSEnding()) {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTShort: Dialog aborting => NOP!");
            return;
        }
        if (this.sdsManager.getWaitStateStatus() == 1) {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTShort: Waiting state has been triggered => NOP!");
            return;
        }
        if (this.sdsManager.getWaitStateStatus() == 2) {
            this.handlePTTShortDuringWaitState();
            return;
        }
        SDSAdapter sDSAdapter = this.sdsAdapter;
        if (this.sdsManager.isSDSActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTShort: SDS active, just sending PTT to restart recognition!");
            sDSAdapter.sendPTTEvent();
            return;
        }
        if (sDSAdapter.isSDSPaused()) {
            this.lc.log(-1601830656, "SDSHMIListener#handlePTTShort: SDS paused -> PTT should have been disabled -> NOP");
            return;
        }
        if (this.terminalModeSDSHandler.isTerminalModeSpeechActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTShort: TerminalMode Speech active, sending event to TerminalMode to abort!");
            this.sdsManager.notifyExternalSDSKeyListeners(1);
            return;
        }
        this.lc.log(-2137614336, "SDSHMIListener#handlePTTShort: Starting session normally!");
        this.sdsManager.changeTracingStatus(true);
        this.activateSDSPrologue();
        sDSAdapter.sendPTTEvent();
    }

    protected void activateSDSPrologue() {
    }

    private void handlePTTShortDuringWaitState() {
        SDSService$ScreenConnectedSDSData sDSService$ScreenConnectedSDSData = this.sdsManager.getScreenConnectedSDSData(this.getCurrentSDSScreenId());
        if (this.sdsPopupHelper.isSmallStageActive() && sDSService$ScreenConnectedSDSData != null && sDSService$ScreenConnectedSDSData.getSmallStageType() == 3) {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTShortDuringWaitState: waiting in small stage and screen not operable => stay in wait state!");
            return;
        }
        this.lc.log(-2137614336, "SDSHMIListener#handlePTTShortDuringWaitState: waiting in big stage or small stage screen which is SDS operable => sending WAIT_RELEASE to resume!");
        this.sdsAdapter.sendEvent(1013);
    }

    private void handlePTTLong() {
        if (this.sdsManager.isSDSActive() || this.sdsManager.isExternalSDSActive()) {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTLong: Dialog or external SDS active, aborting session!");
            SDSModelAccess.setSDSAborterType(13);
            this.setLongPushActive(true);
            this.sdsManager.abortSDSSession();
            return;
        }
        if (this.sdsAdapter.isPttRunning()) {
            this.lc.log(-1601830656, "SDSHMIListener#handlePTTLong: PTT already running!");
            return;
        }
        if (this.isExternalSDSBlocked()) {
            return;
        }
        if (this.terminalModeSDSHandler.isTerminalModeDeviceActive()) {
            this.checkAndNotifyExternalSDSKeyListenersForPTTLong();
        } else if (this.isExternalSmartphoneSupported()) {
            if (!Boolean.getBoolean("externalSDS")) {
                this.lc.log(-2137614336, "SDSHMIListener#handlePTTLong: VM-option for external SDS not set => handle as PTT short!");
                return;
            }
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTLong: Dialog inactive => setting flag and starting special dialog!");
            this.sdsManager.changeTracingStatus(true);
            this.setLongPushActive(true);
            this.startSpecialDialog((byte)2);
        } else {
            this.lc.log(-2137614336, "SDSHMIListener#handlePTTLong: Siri activation conditions not met!");
            this.handleNoExternalSds();
        }
    }

    protected boolean isExternalSmartphoneSupported() {
        return true;
    }

    protected void handleNoExternalSds() {
    }

    private void startSpecialDialog(byte by) {
        this.lc.log(-2137614336, "SDSHMIListener#startSpecialDialog: jumpPoint=%1", (long)by);
        SDSModelAccess.setDialogJumpingModel(by);
        this.lc.log(-2137614336, "SDSHMIListener#startSpecialDialog: Starting special session!");
        this.sdsAdapter.sendPTTEvent();
    }

    private int checkPTTConditions() {
        boolean bl = SDSModelAccess.isSDSDisabled();
        if (bl) {
            this.indicateSDSStatus(5, "SDS is currently disabled (SWAP)");
            return 5;
        }
        byte by = this.sdsManager.getPTTBlocked();
        if (by == 2 || by == 9) {
            this.indicateSDSStatus(6, "APS/OPS active");
            return 6;
        }
        if (by == 8) {
            this.indicateSDSStatus(10, "Audi drive select active");
            return 10;
        }
        if (SDSModelAccess.isSDSDisabledForLanguage()) {
            return 7;
        }
        if (!this.sdsAdapter.isSDSAndTTSReady()) {
            return 10;
        }
        if (this.sdsAdapter.isSDSWaitingForLanguage()) {
            this.indicateSDSStatus(1, "Waiting for language");
            return 11;
        }
        if (this.sdsManager.isPTTBlocked()) {
            this.lc.log(-2137614336, "SDSHMIListener#checkPTTConditions: PTT button blocked!");
            return 12;
        }
        this.lc.log(-2137614336, "SDSHMIListener#checkPTTConditions: PTT handling OK!");
        return 0;
    }

    protected void indicateSDSStatus(int n, String string) {
        SDSModelAccess.setSDSStatus(n);
        this.lc.log(-2137614336, "SDSHMIListener#indicateSDSStatus: %1, sdsStatusChoice.value=%2!", (Object)string, (long)n);
        if (!this.statusBarTimer.isRunning()) {
            this.statusBarTimer.start();
        }
    }

    public void updateSDSRecogStatus(boolean bl, boolean bl2) {
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSRecogStatus: recognizerActive=%1, waitingStateActive=%2", bl, bl2);
        this.updateSDSRecogSymbol(true, bl);
        this.updateSDSCombiStateAndSymbol(true, bl);
        if (!this.sdsAdapter.isCommandScreen()) {
            this.updateSDSStatusBar(true, bl2, false);
        }
    }

    public void updateSDSStatusInactive(boolean bl, boolean bl2) {
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusInactive: pauseActive=%1, dialogEnding=%2", bl, bl2);
        boolean bl3 = this.sdsAdapter.isCommandScreen();
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusInactive: commandScreenActive=%1!", bl3);
        if (!bl && !this.sdsManager.isExternalSDSActive()) {
            this.updateSDSRecogSymbol(false, false);
        }
        SDSUtils.updateSDSNumbers(!bl2);
        if (this.sdsManager.isExternalSDSActive()) {
            return;
        }
        this.updateSDSCombiStateAndSymbol(false, bl);
        this.updateSDSStatusBar(false, bl, bl3);
    }

    void updateSDSStatusActive() {
        boolean bl = this.sdsAdapter.isCommandScreen();
        boolean bl2 = this.sdsAdapter.isSDSVolumeSettingActive();
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusActive: commandScreenActive=%1, volumeSettingActive=%2", bl, bl2);
        if (!bl2) {
            this.updateSDSStatusBar(true, false, bl);
        }
    }

    public void updateSDSStatusCommands() {
        boolean bl = this.sdsManager.isSDSActive();
        boolean bl2 = this.sdsManager.isSDSAborting();
        boolean bl3 = this.sdsAdapter.isCommandScreen();
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusCommands: sdsActive=%1, sdsAborting=%2, commandScreenActive=%3", bl, bl2, bl3);
        if (!bl) {
            SDSUtils.updateSDSNumbers(false);
        }
        if (!bl2) {
            this.updateSDSStatusBar(bl, false, bl3);
        }
    }

    public void updateSDSStatusPause(boolean bl) {
        boolean bl2 = this.sdsManager.isSDSActive() && !this.sdsManager.isSDSAborting();
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusPause: pauseActive=%1, sdsActiveAndNotAborting=%2", bl, bl2);
        if (!bl && !bl2) {
            this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusPause: Neither pause nor SDS active, removing SDS head!");
            this.updateSDSRecogSymbol(false, false);
        }
        if (bl) {
            this.sdsAdapter.removeSDSProgressIcon();
        }
        this.updateSDSCombiStateAndSymbol(!bl, bl);
        boolean bl3 = this.sdsAdapter.isCommandScreen();
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusPause: sdsActive=%1, commandScreenActive=%2!", bl2, bl3);
        this.updateSDSStatusBar(bl2, bl, bl3);
    }

    private void updateSDSStatusBar(boolean bl, boolean bl2, boolean bl3) {
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusBar: sdsActive=%1, sdsPaused=%2, commandScreenActive=%3", bl, bl2, bl3);
        int n = bl2 ? 3 : (bl ? (bl3 ? 2 : 8) : 0);
        SDSModelAccess.setSDSStatus(n);
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSStatusBar: sdsStatusChoice.value=%1, SDS status bar set!", (long)n);
    }

    private void updateSDSCombiStateAndSymbol(boolean bl, boolean bl2) {
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSCombiStateAndSymbol: dialogActive=%1, recognizerOrPauseActive=%2", bl, bl2);
        int n = bl ? (bl2 ? 3 : 4) : (bl2 ? 7 : 6);
        this.setCombiState(n);
        int n2 = bl ? (bl2 ? 39 : 40) : (bl2 ? 40 : 0);
        SDSModelAccess.setCombiSDSSign(n2);
    }

    public void updateSDSCombiState(boolean bl, byte by) {
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSCombiState: enable=%1, disabler=%2", bl, (long)by);
        if (bl) {
            this.resetTempCombiState(true);
            return;
        }
        switch (by) {
            case 1: {
                this.lc.log(-1601830656, "SDSHMIListener#updateSDSCombiState: SDS not available due to NOT READY!");
                this.setCombiState(1);
                this.setTempCombiState(2);
                break;
            }
            case 6: {
                this.lc.log(-2137614336, "SDSHMIListener#updateSDSCombiState: SDS temporarily not available due to language loading!");
                this.setCombiState(6);
                this.setTempCombiState(10);
                break;
            }
            case 7: {
                this.lc.log(-2137614336, "SDSHMIListener#updateSDSCombiState: SDS temporarily not available due to language not available!");
                this.setCombiState(6);
                this.setTempCombiState(9);
                break;
            }
            case 2: 
            case 9: {
                this.lc.log(-2137614336, "SDSHMIListener#updateSDSCombiState: SDS temporarily not available due to APS/OPS/RVC!");
                this.setTempCombiState(12);
                break;
            }
            case 3: 
            case 4: 
            case 5: 
            case 8: 
            case 10: {
                this.lc.log(-2137614336, "SDSHMIListener#updateSDSCombiState: SDS temporarily not available due to disabler %1!", (long)by);
                this.setTempCombiState(13);
                break;
            }
            default: {
                this.lc.log(-2137614336, "SDSHMIListener#updateSDSCombiState: Unhandled disabler %1 => NOP!", (long)by);
            }
        }
    }

    private void setCombiState(int n) {
        if (this.combiService == null) {
            this.lc.log(-1601830656, "SDSHMIListener#setCombiState: combiService not available, storing state %1!", (long)n);
            this.setTempCombiState(n);
            return;
        }
        this.lc.log(-2137614336, "SDSHMIListener#setCombiState: state=%1!", (long)n);
        this.combiState = n;
        this.combiService.updateSDSState(n);
    }

    private void updateSDSRecogSymbol(boolean bl, boolean bl2) {
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSRecogSymbol: dialogActive=%1, recognizerActive=%2 ", bl, bl2);
        int n = bl ? (bl2 ? 2 : 1) : 0;
        SDSModelAccess.setRecognizer(n);
        this.lc.log(-2137614336, "SDSHMIListener#updateSDSRecogSymbol: sdsRecognizerChoice.value=%1!", (long)n);
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer == this.statusBarTimer) {
            int n = SDSModelAccess.getSDSStatusValue();
            SDSModelAccess.setSDSStatus(0);
            this.lc.log(-2137614336, "SDSHMIListener#fireTimer: SDS status bar timeout expired, sdsStatusChoice.value was %1, sdsStatusChoice.value=%2!", (long)n, 0L);
        } else if (timer == this.tempCombiTimer) {
            this.lc.log(-2137614336, "SDSHMIListener#fireTimer: Temporary combi timout expired, resetting combi state!");
            this.resetTempCombiState(false);
        } else {
            this.lc.log(10000, "SDSHMIListener#fireTimer: Unhandled timer %1!", (Object)timer);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.lc.log(-2137614336, "SDSHMIListener#cancelTimer: Timer %1 cancelled!", (Object)timer);
    }

    @Override
    public void setLanguage(Language language) {
        String string = language.getLanguageCode();
        this.lc.log(-2137614336, "SDSHMIListener.setLanguage: languageCode='%1'", (Object)string);
        CommandList commandList = new CommandList(this.cmdListManager);
        commandList.add(new CommandChangeLanguage(Logger.getCommandLog(), string, this.srHandler, this.sdsAdapter, this.framework, this.dynamicHMIList, this.grammarState, this.naviService));
        commandList.execute("CHANGE_LANGUAGE");
    }

    @Override
    public void viewSizeChanged(int n) {
        this.lc.log(-2137614336, "SDSHMIListener#viewSizeChanged: newViewSize=%1", (long)n);
        SDSService$ScreenConnectedSDSData sDSService$ScreenConnectedSDSData = this.sdsManager.getScreenConnectedSDSData(this.getCurrentSDSScreenId());
        if (this.sdsManager.isSDSActive() && !this.sdsManager.isSDSAborting() && !this.sdsAdapter.isSDSEnding() && n == 1 && sDSService$ScreenConnectedSDSData != null && sDSService$ScreenConnectedSDSData.getSmallStageType() == 3) {
            this.lc.log(-2137614336, "SDSHMIListener#viewSizeChanged: user changed to small stage in screen which is not SDS operable => trigger wait state!");
            this.sdsManager.checkAbortingAndTriggerWaitState();
        }
    }

    public SDSModelAccess getModelAccess() {
        return this.modelAccess;
    }

    public void setCombiBAPServiceSDS(CombiBAPServiceSDS combiBAPServiceSDS) {
        this.lc.log(-2137614336, "SDSHMIListener#setCombiBAPServiceSDS: service=%1", (Object)combiBAPServiceSDS);
        this.combiService = combiBAPServiceSDS;
        if (this.sdsAdapter.isSDSAndTTSReady()) {
            this.lc.log(-2137614336, "SDSHMIListener#setCombiBAPServiceSDS: SDS and TTS ready => NOP!");
            return;
        }
        this.lc.log(-2137614336, "SDSHMIListener#setCombiBAPServiceSDS: SDS or TTS not ready, initializing combi state!");
        this.setCombiState(this.combiState);
    }

    protected void setSDSAdapter(SDSAdapter sDSAdapter) {
        this.sdsAdapter = sDSAdapter;
    }

    public void setFactory(SDSAppFactory sDSAppFactory) {
        this.factory = sDSAppFactory;
        if (sDSAppFactory == null) {
            return;
        }
        this.terminalModeSDSHandler = sDSAppFactory.getTerminalModeSDSHandler();
    }

    private void resetTempCombiState(boolean bl) {
        this.lc.log(-2137614336, "SDSHMIListener#resetTempCombiState: enable=%1, tempCombiState=%2, combiState=%3", (Object)bl, (long)this.tempCombiState, (long)this.combiState);
        if (this.tempCombiTimer.isRunning()) {
            this.lc.log(-2137614336, "SDSHMIListener#resetTempCombiState: Canceling timer!");
            this.tempCombiTimer.cancel();
        }
        int n = this.tempCombiState;
        this.setTempCombiState(this.combiState);
        this.setCombiState(bl ? 6 : n);
    }

    public void setTempCombiState(int n) {
        this.lc.log(-2137614336, "SDSHMIListener#setTempCombiState: value=%1", (long)n);
        this.tempCombiState = n;
    }

    public void setCommandListManager(CommandListManager commandListManager) {
        this.cmdListManager = commandListManager;
    }

    protected void setLongPushActive(boolean bl) {
        this.lc.log(-2137614336, "SDSHMIListener#setLong: value=%1", bl);
        this.pttLongpushActive = bl;
    }

    public void setNaviService(NaviService naviService) {
        this.lc.log(-2137614336, "SDSHMIListener#setNaviService: called");
        this.naviService = naviService;
    }

    void unsetNaviService() {
        this.lc.log(-2137614336, "SDSHMIListener#unsetNaviService: called");
        this.naviService = null;
    }

    public void updateStatusExternalSDS(boolean bl) {
        if (bl) {
            this.audioHandler.switchToSDSAudioDrawerContextMain();
            SDSModelAccess.setSDSStatus(9);
            SDSModelAccess.setRecognizer(1);
            SDSModelAccess.setCombiSDSSign(40);
            this.setCombiState(14);
        } else {
            this.audioHandler.disableCurrentSDSAudioDrawerContext();
            SDSModelAccess.setSDSStatus(0);
            SDSModelAccess.setRecognizer(0);
            SDSModelAccess.setCombiSDSSign(0);
            this.setCombiState(6);
        }
    }
}

