/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.progress.NaviProgressMap;
import de.audi.atip.start.IStartupManager;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.command.Monitor;
import de.audi.tghu.navi.app.AbstractNavigationActivator;
import de.audi.tghu.navi.app.IOperationManagerSDCardPopupHandler;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManagerModelAccess;
import de.audi.tghu.navi.app.call.CommandListCallManager;
import de.audi.tghu.navi.app.call.RGStopGuidanceCall;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.command.EnableRgLaneGuidanceCommand;
import de.audi.tghu.navi.app.command.EnableRgPoiInfoCommand;
import de.audi.tghu.navi.app.command.HandleRenderingInfoProviderCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LoadPersistencyCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.NotifyRestCommand;
import de.audi.tghu.navi.app.command.ResetSMCommand;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerObserver;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.PosPosition;

public class OperationManager
implements TimerListener {
    public static final int NAV_STATE_INITIAL = 0;
    public static final int NAV_STATE_UPDATING = 1;
    public static final int NAV_STATE_AVAILABLE = 2;
    public static final int NAV_STATE_NOTCALIBRATED = 3;
    public static final int NAV_STATE_ERROR = 4;
    public static final String IGNORE_CALIBRATION = "IGNORE_CALIBRATION";
    public static final long DEBOUNCING_TIME = 3000L;
    public static final long NAV_INITIALIZED_TIME = 80000L;
    private volatile int currentNavState;
    private volatile int tmpNavState;
    private volatile int currentErrorState;
    private volatile int tmpErrorState;
    private final NavigationEnv env;
    private DSINavigationManager dsiNavigationManager;
    private CommandListCallManager commandListCallManager;
    private AbstractNavigationActivator activator;
    private final LogChannel logChannel;
    private final IStartupManager startup;
    private final Timer debouncer;
    private final Timer initializationChecker;
    private volatile boolean naviMainInitialized = false;
    private volatile boolean naviRemoteInitialized = false;
    private volatile boolean mapInitialized = false;
    private volatile boolean mapReady = false;
    private volatile boolean ignoreCalibration = false;
    private volatile boolean calibrationAcknowledge = false;
    private volatile boolean navigationStarted = false;
    private volatile boolean restartGuidanceOnFullyOp = false;
    private volatile boolean diskIssueDetected = false;
    private volatile boolean calibrationScreenShown = false;
    private Monitor recoveryMonitor = null;
    private NaviServiceListener naviServiceListener;
    private final OperationManagerModelAccess modelAccess;
    private IOperationManagerSDCardPopupHandler popupHandler;
    private ICommandListFactory commandListFactory;
    private NaviServiceListenerObserver naviServiceListenerObserver;
    private Navigation navigation;
    private ClusterService clusterService;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public OperationManager(NavigationEnv navigationEnv, DSINavigationManager dSINavigationManager, CommandListCallManager commandListCallManager, AbstractNavigationActivator abstractNavigationActivator, NaviServiceListener naviServiceListener, ICommandListFactory iCommandListFactory, Navigation navigation) {
        this.env = navigationEnv;
        this.dsiNavigationManager = dSINavigationManager;
        this.commandListCallManager = commandListCallManager;
        this.activator = abstractNavigationActivator;
        this.naviServiceListener = naviServiceListener;
        this.commandListFactory = iCommandListFactory;
        this.navigation = navigation;
        this.logChannel = navigationEnv.getLogChannel();
        this.modelAccess = new OperationManagerModelAccess(navigationEnv, this.logChannel);
        this.popupHandler = new NullPopupManager();
        this.currentNavState = 0;
        this.startup = navigationEnv.getFramework().getStartupMgr();
        this.recoveryMonitor = new Monitor(this.logChannel);
        this.debouncer = new Timer("OPStateDebouncer", 3000L, false, this);
        this.initializationChecker = new Timer("NavInitializationChecker", 80000L, true, this);
        OperationManager operationManager = this;
        synchronized (operationManager) {
            this.modelAccess.onStart();
        }
        this.handleHMIOperationFailure();
        boolean bl = navigationEnv.getFramework().isPorscheHigh() || navigationEnv.getFramework().isBentley() ? true : Boolean.getBoolean(IGNORE_CALIBRATION);
        this.setIgnoreCalibration(bl);
    }

    public void init(ClusterService clusterService) {
        this.clusterService = clusterService;
    }

    public void deinit() {
        this.clusterService = null;
        this.navigation = null;
        this.commandListCallManager = null;
        this.commandListFactory = null;
        this.activator = null;
        this.dsiNavigationManager = null;
        this.naviServiceListener = null;
        this.naviServiceListenerObserver = null;
        this.popupHandler.cleanup();
        this.setSDCardPartialPopuphandler(null);
    }

    public synchronized void cleanup() {
        this.handleHMIOperationFailure();
        this.debouncer.cancel();
        this.initializationChecker.cancel();
        this.deinit();
    }

    public void setNavigationMainInitialized(boolean bl) {
        this.logChannel.log(1000000, "OperationManager#setNavigationMainInitialized( %1 )", bl);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#setNavigationMainInitialized( ").append(bl).append(" )"));
        this.naviMainInitialized = bl;
        this.updateOperationState();
    }

    public void setNavigationRemoteInitialized(boolean bl) {
        this.logChannel.log(1000000, "OperationManager#setNavigationRemoteInitialized( %1 )", bl);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#setNavigationRemoteInitialized( ").append(bl).append(" )"));
        this.naviRemoteInitialized = bl;
        this.updateOperationState();
    }

    public void setIgnoreCalibration(boolean bl) {
        this.logChannel.log(1000000, "OperationManager#setIgnoreCalibration( %1 ) ", bl);
        this.ignoreCalibration = bl;
        this.updateOperationState();
    }

    public void setMapInitialized(boolean bl) {
        this.logChannel.log(1000000, "OperationManager#setMapInitialized( %1 ) ", bl);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#setMapInitialized( ").append(bl).append(" )"));
        this.mapInitialized = bl;
        this.updateOperationState();
    }

    public boolean isMapInitialized() {
        return this.mapInitialized;
    }

    public void setMapReady(boolean bl) {
        this.logChannel.log(1000000, "OperationManager#setMapReady( %1 )", bl);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#setMapReady( ").append(bl).append(" )"));
        this.mapReady = bl;
        this.updateOperationState();
    }

    public boolean isMapReady() {
        return this.mapReady;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void updateOperationState() {
        int n = this.env.getContainer().getNavstateOfOperation();
        this.logChannel.log(1000000, "OperationManager#updateOperationState() - current navstateOfOperation: %1", (long)n);
        this.popupHandler.updateOperationState(n);
        if (n == 12) {
            this.handleReady4NavState(true);
        } else if (n == 0) {
            this.handleHMIOperationFailure();
        } else {
            this.handleReady4NavState(false);
            if (n != 5) {
                this.handleNavstateOperationFailure(n);
            } else {
                OperationManager operationManager = this;
                synchronized (operationManager) {
                    if (this.diskIssueDetected) {
                        this.handleHMIRecoveryState();
                    } else if (!this.naviMainInitialized || !this.mapInitialized || !this.naviRemoteInitialized && !this.env.getFramework().isFrontMU()) {
                        this.handleHMIOperationFailure();
                    } else if (!this.mapReady) {
                        this.handleMapNotReadyFailure();
                    } else if (!(this.ignoreCalibration || this.isNaviCalibrated() || this.calibrationAcknowledge)) {
                        this.handleNotCalibratedFailure();
                    } else {
                        this.handleFullyOperableState();
                    }
                }
            }
        }
        if (this.clusterService != null) {
            this.clusterService.updateOperationState(n);
        } else {
            this.logChannel.log(10000000, "OperationManager#updateOperationState() - cluster service not ready");
        }
    }

    public void updateNavstateOfOperation(int n) {
        this.updateOperationState();
    }

    private boolean isNaviCalibrated() {
        PosPosition posPosition = this.env.getContainer().getSoPosPosition();
        boolean bl = false;
        if (posPosition != null) {
            bl = posPosition.isCalibrated();
        }
        return bl;
    }

    public void flushOperationState() {
        this.refreshNavState();
    }

    public boolean isFullyOperable() {
        return this.currentNavState == 2;
    }

    private void handleNavstateOperationFailure(int n) {
        this.logChannel.log(1000000, "OperationManager#handleNavstateOperationFailure( %1 ) ", (long)n);
        if (n == 4 || n == 3) {
            this.logChannel.log(100000, "OperationManager#handleNavstateOperationFailure() - DISKREQUEST state %1 detected!", (long)n);
            this.diskIssueDetected = true;
            if (n == 4) {
                this.restartGuidanceOnFullyOp = false;
            }
            this.dsiNavigationManager.abortExecution("DISKREQUEST", 0);
        }
        this.setOperationState(4, n);
        boolean bl = false;
        if (n == 6 || n == 9 || n == 11) {
            bl = true;
        }
        if (bl) {
            this.logChannel.log(10000000, "OperationManager#handleNavstateOperationFailure() - unblock startup manager");
            Util.logStartupEvent(this.env.getFramework(), "OperationManager#handleNavstateOperationFailure() - unblock startup manager");
            this.startup.triggerMapAvailable();
        }
    }

    private void handleHMIOperationFailure() {
        this.logChannel.log(1000000, "OperationManager#handleHMIOperationFailure() ");
        this.setOperationState(1, 0);
    }

    private void handleMapNotReadyFailure() {
        this.logChannel.log(1000000, "OperationManager#handleMapNotReadyFailure()");
        this.setOperationState(4, 0);
    }

    private void handleNotCalibratedFailure() {
        this.logChannel.log(1000000, "OperationManager#handleNotCalibratedFailure() ");
        this.setOperationState(3, 0);
        if (!this.calibrationScreenShown) {
            this.calibrationScreenShown = true;
            this.logChannel.log(10000000, "OperationManager#handleNotCalibratedFailure() - unblock startup manager");
            Util.logStartupEvent(this.env.getFramework(), "OperationManager#handleNotCalibratedFailure() - unblock startup manager");
            this.startup.triggerMapAvailable();
        }
    }

    private void handleFullyOperableState() {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "OperationManager#handleFullyOperableState() ");
        }
        this.setOperationState(2, 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void handleHMIRecoveryState() {
        this.logChannel.log(1000000, "OperationManager#handleHMIRecoveryState() - naviMainInitialized: %1, naviRemoteInitialized: %2, mapInitialized: %3", this.naviMainInitialized, this.naviRemoteInitialized, this.mapInitialized);
        this.setOperationState(4, 0);
        OperationManager operationManager = this;
        synchronized (operationManager) {
            if (!this.recoveryMonitor.isActive()) {
                this.logChannel.log(1000000, "OperationManager#handleHMIRecoveryState() - start recovery!");
                Util.logStartupEvent(this.env.getFramework(), "OperationManager#handleHMIRecoveryState() - start recovery!");
                this.dsiNavigationManager.abortExecution("RECOVERY", 0);
                CommandList commandList = this.commandListFactory.createCommandList();
                commandList.addMonitor(this.recoveryMonitor);
                commandList.add(new HandleRenderingInfoProviderCommand());
                commandList.add(new NotifyRestCommand());
                commandList.add(new LISPCancelSpellerCommand());
                commandList.add(new ResetSMCommand());
                commandList.add(new LoadPersistencyCommand());
                commandList.add(new EnableRgPoiInfoCommand(true));
                commandList.add(new EnableRgLaneGuidanceCommand(true));
                commandList.add(new NavCommand("SignalRecovered"){

                    public void execute() {
                        OperationManager.this.logChannel.log(10000000, "SignalRecovered#execute() - recovery finished!");
                        Util.logStartupEvent(this.env.getFramework(), "SignalRecovered#execute() - recovery finished!");
                        OperationManager.this.diskIssueDetected = false;
                        OperationManager.this.setNavigationMainInitialized(true);
                        this.getCommandList().commandFinished();
                    }
                });
                commandList.execute("OperationManager#handleHMIRecoveryState");
            } else {
                this.logChannel.log(1000000, "OperationManager#handleHMIRecoveryState() - recovery already running!");
                Util.logStartupEvent(this.env.getFramework(), "OperationManager#handleHMIRecoveryState() - recovery already running!");
            }
        }
    }

    private void handleReady4NavState(boolean bl) {
        this.logChannel.log(10000000, "OperationManager#handleReady4NavState(%1)", bl);
        boolean bl2 = !bl;
        boolean bl3 = this.startup.isNavEnabled();
        if (bl2 != bl3) {
            Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#handleReady4NavState( ").append(bl).append(" )"));
            this.startup.setNavEnabled(bl2);
            if (!bl2) {
                this.logChannel.log(10000000, "OperationManager#handleReady4NavState() - Ready4Nav enabled, unblock startup manager");
                Util.logStartupEvent(this.env.getFramework(), "OperationManager#handleReady4NavState() - Ready4Nav enabled, unblock startup manager");
                this.startup.triggerMapAvailable();
            }
        }
    }

    public void checkInitialization(boolean bl) {
        boolean bl2 = this.initializationChecker.isRunning();
        this.logChannel.log(10000000, "OperationManager#checkInitialization( %1 ) - running: %2", bl, bl2);
        if (bl && !bl2) {
            this.initializationChecker.restart();
        } else if (!bl && bl2) {
            this.initializationChecker.cancel();
        }
    }

    public void updateSatellites(PosPosition posPosition) {
        if (posPosition != null) {
            String string = String.valueOf(posPosition.getUsedSatellites());
            this.env.getLabelModel(400347).setText(string);
        } else {
            this.logChannel.log(10000, "OperationManager#updateSatellites() - soPosPosition is null! ");
        }
    }

    public String toString() {
        int n = this.env.getContainer().getNavstateOfOperation();
        NavDataBase navDataBase = this.env.getContainer().getNavDataBase();
        String string = navDataBase != null ? navDataBase.getName() : "<none>";
        int n2 = -1;
        if (this.env.getChoiceModel(400507) != null) {
            n2 = this.env.getChoiceModel(400507).getValue();
        }
        String string2 = this.env.getContainer().getLanguage();
        String string3 = "Labelmodel is null";
        if (this.env.getLabelModel(341) != null) {
            string3 = this.env.getLabelModel(341).getText();
        }
        String string4 = this.env.getFramework().getNavProgressMonitor().toString();
        Buffer buffer = new Buffer(1200);
        buffer.append("NavstateOfOperation: ").append(n).append(Formatter.LINE_SEPARATOR);
        buffer.append("NaviMainInitialized: ").append(this.naviMainInitialized).append(Formatter.LINE_SEPARATOR);
        buffer.append("NaviRemoteInitialized: ").append(this.naviRemoteInitialized).append(Formatter.LINE_SEPARATOR);
        buffer.append("MapInitialized: ").append(this.mapInitialized).append(Formatter.LINE_SEPARATOR);
        buffer.append("MapReady: ").append(this.mapReady).append(Formatter.LINE_SEPARATOR);
        buffer.append("Calibrated: ").append(this.isNaviCalibrated()).append(Formatter.LINE_SEPARATOR);
        buffer.append("IgnoreCalibration: ").append(this.ignoreCalibration).append(Formatter.LINE_SEPARATOR);
        buffer.append("CalibrationAcknowledge: ").append(this.calibrationAcknowledge).append(Formatter.LINE_SEPARATOR);
        PosPosition posPosition = this.env.getContainer().getSoPosPosition();
        if (posPosition != null) {
            buffer.append("Reliability: ").append(posPosition.getReliability()).append(Formatter.LINE_SEPARATOR);
            buffer.append("Used satellites: ").append(posPosition.getUsedSatellites()).append(Formatter.LINE_SEPARATOR);
        }
        buffer.append("NavDataBase: ").append(string).append(" MEDIUM_ID: ").append(n2).append(Formatter.LINE_SEPARATOR);
        buffer.append("EtcVersionInfo: ").append(string3).append(Formatter.LINE_SEPARATOR);
        buffer.append("NavMedia: ");
        Util.appendObjectArray(buffer, this.env.getContainer().getNavMedia());
        buffer.append(Formatter.LINE_SEPARATOR);
        buffer.append("Language: ").append(string2).append(Formatter.LINE_SEPARATOR);
        buffer.append("AvailableLanguages: ");
        Util.appendObjectArray(buffer, this.env.getContainer().getAvailableLanguages());
        buffer.append(Formatter.LINE_SEPARATOR);
        buffer.append("ProgressMonitor: ").append(string4).append(Formatter.LINE_SEPARATOR);
        buffer.append(this.navigation.getMapInterface() == null ? "getMapInterface is null!" : this.navigation.getMapInterface().getStartupState());
        return buffer.toString();
    }

    private synchronized void setOperationState(int n, int n2) {
        this.logChannel.log(10000000, "OperationManager#setOperationState( %1 ) ", (long)n);
        this.tmpNavState = n;
        this.tmpErrorState = n2;
        if (!this.debouncer.isRunning()) {
            this.refreshNavState();
        } else {
            this.logChannel.log(10000000, "OperationManager#setOperationState() - Debouncing timer running. Value set ignored! ");
        }
    }

    private synchronized void refreshNavState() {
        this.logChannel.log(10000000, "OperationManager#refreshNavState: tmpNavState = %1, currentNavState = %2", (long)this.tmpNavState, (long)this.currentNavState);
        this.logChannel.log(10000000, "OperationManager#refreshNavState: tmpErrorState = %1, currentErrorState = %2", (long)this.tmpErrorState, (long)this.currentErrorState);
        if (this.tmpNavState != this.currentNavState || this.tmpErrorState != this.currentErrorState) {
            boolean bl = this.currentNavState == 2;
            boolean bl2 = this.tmpNavState == 2;
            this.currentNavState = this.tmpNavState;
            this.currentErrorState = this.tmpErrorState;
            this.modelAccess.onNavStateUpdated(this.currentNavState, this.currentErrorState);
            this.checkFullyOperableState(bl, bl2);
            this.modelAccess.onPropagateStateToOtherApps(bl2);
            if (this.clusterService != null) {
                this.clusterService.updateNavState(this.modelAccess.getInitializationChoice().getStatus(), this.modelAccess.getInitializationChoice().getValue());
            }
            this.debouncer.restart();
            this.logChannel.log(10000000, "OperationManager#refreshNavState() - Values did change -> debouncing timer restarted! ");
        } else {
            this.debouncer.cancel();
            this.logChannel.log(10000000, "OperationManager#refreshNavState() - Values did not change -> debouncing timer canceled! ");
        }
    }

    private void checkFullyOperableState(boolean bl, boolean bl2) {
        if (bl == bl2) {
            return;
        }
        this.logChannel.log(10000000, "OperationManager#checkFullyOperableState( %1, %2 ) - restartGuidanceOnFullyOp: %3", bl, bl2, this.restartGuidanceOnFullyOp);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#checkFullyOperableState() - priorFullyOperable: ").append(bl).append(", currentFullyOperable: ").append(bl2).append(", restartGuidanceOnFullyOp: ").append(this.restartGuidanceOnFullyOp));
        this.updateNaviOperableState(this.naviServiceListener);
        if (this.naviServiceListener != null && this.naviServiceListenerObserver != null) {
            this.logChannel.log(10000000, "OperationManager#checkFullyOperableState() HAVE naviServiceListenerObserver and naviServiceListener");
            this.naviServiceListenerObserver.listenerAdded(this.naviServiceListener);
        } else {
            this.logChannel.log(10000000, "OperationManager#checkFullyOperableState() DO NOT HAVE naviServiceListenerObserver and naviServiceListener");
        }
        this.navigation.getTmcGateway().updateNaviFullyOperable(bl2);
        if (bl2) {
            Util.logStartupEvent(this.env.getFramework(), "OperationManager#checkFullyOperableState - navigation is operable");
            this.navigation.updateNaviLanguage();
            if (!this.navigationStarted) {
                this.navigationStarted = true;
                boolean bl3 = this.navigation.getRouteManager().resumeRouteGuidance();
                if (!bl3) {
                    this.logChannel.log(1000000, "OperationManager#checkFullyOperableState() - route guidance not restarted!");
                    this.navigation.getNavigationStartup().triggerNavAvailable("Startup finished - RG not restarted");
                    this.navigation.getSimpleDetourHandler().setDeleteBlockingsAtStartup();
                }
                this.startDelayedDSIServices();
            } else if (this.env.getFramework().isFrontMU() && this.restartGuidanceOnFullyOp) {
                this.restartGuidance();
                this.restartGuidanceOnFullyOp = false;
            }
            this.navigation.getPoiService().onFullyOperable();
            if (!this.env.getFramework().isPorsche()) {
                this.navigation.getPoiCategoryManager().preloadCategories();
            }
            if (this.navigation.getPoiService().getPoiWarningManager() != null && !Util.isHURegionAsia()) {
                this.navigation.getPoiService().getPoiWarningManager().init();
            } else {
                this.logChannel.log(10000000, "OperationManager#checkFullyOperableState navigation.getPoiService().getPoiWarningManager().init(); - Was not initialised");
            }
            this.navigation.deserializeAddresses();
        } else {
            Util.logStartupEvent(this.env.getFramework(), "OperationManager#checkOperationState - navigation is no longer operable");
            if (this.env.getFramework().isFrontMU() && this.env.getContainer().isRgActive()) {
                this.stopGuidance();
                this.restartGuidanceOnFullyOp = true;
            }
            this.navigation.getMapInterface().signalNaviNotOperable();
        }
    }

    private void restartGuidance() {
        this.checkTTS();
        this.navigation.getRouteManager().resumeRouteGuidance();
    }

    private void stopGuidance() {
        if (this.dsiNavigationManager != null && this.dsiNavigationManager.getDSINavigation(0) != null) {
            RGStopGuidanceCall rGStopGuidanceCall = new RGStopGuidanceCall(this.env, this.dsiNavigationManager);
            rGStopGuidanceCall.execute("OperationManager#stopGuidance");
        } else {
            this.logChannel.log(10000000, "OperationManager#stopGuidance() - DSI not set!");
        }
    }

    public void checkTTS() {
        this.logChannel.log(10000000, "OperationManager#checkTTS()");
        Util.logStartupEvent(this.env.getFramework(), "OperationManager#checkTTS()");
        boolean bl = this.startup.waitForTTSAvailable();
        if (!bl) {
            this.logChannel.log(100000, "OperationManager#checkTTS() - TTS synchronization timed out or was interrupted!");
            Util.logStartupEvent(this.env.getFramework(), "OperationManager#checkTTS() - TTS synchronization timed out or was interrupted!");
        }
    }

    public void taskCompleted(int n) {
        String string = NaviProgressMap.taskName(n);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#taskCompleted( ").append(string).append(" )"));
        this.env.getFramework().getNavProgressMonitor().taskCompleted(n, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void proceedWithoutCalibration() {
        this.calibrationAcknowledge = true;
        OperationManager operationManager = this;
        synchronized (operationManager) {
            this.debouncer.cancel();
        }
        this.updateOperationState();
    }

    public synchronized void fireTimer(Timer timer) {
        this.logChannel.log(10000000, "OperationManager#fireTimer( %1 )", (Object)timer);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#fireTimer( ").append(timer).append(" )"));
        if (timer == this.debouncer) {
            this.refreshNavState();
        } else if (timer == this.initializationChecker) {
            this.updateOperationState();
            if (!this.isFullyOperable()) {
                Buffer buffer = new Buffer(1500);
                String string = this.toString();
                String string2 = this.commandListCallManager.getQueue().printStatus();
                buffer.append("Navigation not initialized ").append(80000L).append("ms after bundle AppNavi start!");
                buffer.append(Formatter.LINE_SEPARATOR);
                buffer.append("Operation status:").append(Formatter.LINE_SEPARATOR);
                buffer.append(string).append(Formatter.LINE_SEPARATOR);
                buffer.append("Queue status:").append(Formatter.LINE_SEPARATOR);
                buffer.append(string2).append(Formatter.LINE_SEPARATOR);
                Formatter.standardTargetSysout(buffer.toString());
                Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#fireTimer() - Navigation not initialized ").append(80000L).append("ms after bundle AppNavi start!"));
                Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#fireTimer() - Operation status: ").append(string));
                Util.logStartupEvent(this.env.getFramework(), new Buffer().append("OperationManager#fireTimer() - Queue status: %1").append(string2));
            }
        }
    }

    public void cancelTimer(Timer timer) {
    }

    private void startDelayedDSIServices() {
        if (this.activator == null) {
            return;
        }
        this.activator.startDelayedDSIServices(this.env.getLogChannel(), this.env.getFramework());
    }

    public void updateNaviOperableState(NaviServiceListener naviServiceListener) {
        this.logChannel.log(10000000, "OperationManager#updateNaviOperableState()");
        boolean bl = this.isFullyOperable();
        if (naviServiceListener != null) {
            naviServiceListener.updateFullyOperableStateChanged(bl);
        } else {
            this.logChannel.log(10000, "OperationManager#updateNaviOperableState() - navi service listener not available!");
        }
    }

    public void setNaviServiceListenerObserver(NaviServiceListenerObserver naviServiceListenerObserver) {
        this.naviServiceListenerObserver = naviServiceListenerObserver;
    }

    public void setSDCardPartialPopuphandler(IOperationManagerSDCardPopupHandler iOperationManagerSDCardPopupHandler) {
        this.popupHandler = iOperationManagerSDCardPopupHandler != null ? iOperationManagerSDCardPopupHandler : new NullPopupManager();
    }

    private class NullPopupManager
    implements IOperationManagerSDCardPopupHandler {
        private NullPopupManager() {
        }

        public void updateOperationState(int n) {
            if (OperationManager.this.logChannel.isDebug2()) {
                OperationManager.this.logChannel.log(100000000, "Nothing to do - OperationManager.NullPopupManager#updateOperationState( %1 ) ", (long)n);
            }
        }

        public void cleanup() {
        }
    }
}

