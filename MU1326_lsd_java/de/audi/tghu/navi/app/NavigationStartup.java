/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.call.ClearNotificationCall;
import de.audi.tghu.navi.app.command.ETCSetMetricSystemCommand;
import de.audi.tghu.navi.app.command.EnableRgLaneGuidanceCommand;
import de.audi.tghu.navi.app.command.EnableRgPoiInfoCommand;
import de.audi.tghu.navi.app.command.HandleRenderingInfoProviderCommand;
import de.audi.tghu.navi.app.command.LISPCancelSpellerCommand;
import de.audi.tghu.navi.app.command.LoadPersistencyCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.NotifyNavStateOfOperationCommand;
import de.audi.tghu.navi.app.command.NotifyRemoteCommand;
import de.audi.tghu.navi.app.command.NotifyRestCommand;
import de.audi.tghu.navi.app.command.RGEnableEnhancedSignPostInfoCommand;
import de.audi.tghu.navi.app.command.RgConfigurePoiInfoCommand;
import de.audi.tghu.navi.app.command.RgSetTurnListModeCommand;
import de.audi.tghu.navi.app.command.SetNotificationCommand;
import de.audi.tghu.navi.app.dsi.DSINavigationManager;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.DSIBlocking;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.dsi.ifc.navigation.DSINavigation;

public final class NavigationStartup {
    private final NavigationEnv env;
    private final ICommandListFactory commandListFactory;
    private final DSINavigationManager dsiNavigationManager;
    private final OperationManager operationManager;
    private LogChannel logChannel;
    private boolean navAvailableTriggered = false;
    private boolean notificationSet = false;
    private boolean persistencyLoaded = false;
    private boolean[] allDSIsAvailable;
    private DSINavigation[] dsiNavigation;
    private DSIBlocking[] dsiBlocking;
    private DSICombinedRouteList[] dsiCombinedRouteList;
    private final Navigation navigation;

    public NavigationStartup(NavigationEnv navigationEnv, ICommandListFactory iCommandListFactory, DSINavigationManager dSINavigationManager, OperationManager operationManager, Navigation navigation) {
        this.env = navigationEnv;
        this.commandListFactory = iCommandListFactory;
        this.dsiNavigationManager = dSINavigationManager;
        this.operationManager = operationManager;
        this.navigation = navigation;
        this.logChannel = navigationEnv.getLogChannel();
        this.allDSIsAvailable = new boolean[2];
        this.dsiNavigation = new DSINavigation[2];
        this.dsiBlocking = new DSIBlocking[2];
        this.dsiCombinedRouteList = new DSICombinedRouteList[2];
    }

    public void triggerNavAvailable(String string) {
        this.logChannel.log(1000000, "NavigationStartup#triggerNavAvailable( %2 ) - navAvailableTriggered: %1", this.navAvailableTriggered, (Object)string);
        if (!this.navAvailableTriggered) {
            this.env.getFramework().getStartupMgr().triggerNavAvailable();
            this.navAvailableTriggered = true;
        }
    }

    public boolean isNotificationSet() {
        return this.notificationSet;
    }

    public void setNotificationSet(boolean bl) {
        this.notificationSet = bl;
    }

    public boolean isPersistencyLoaded() {
        return this.persistencyLoaded;
    }

    public void setPersistencyLoaded(boolean bl) {
        this.persistencyLoaded = bl;
    }

    public void setDSINavigation(DSINavigation dSINavigation, int n) {
        this.dsiNavigation[n] = dSINavigation;
        this.checkStartup(n);
    }

    public void setDSIBlocking(DSIBlocking dSIBlocking, int n) {
        this.dsiBlocking[n] = dSIBlocking;
        this.checkStartup(n);
    }

    public void setDSICombinedRouteList(DSICombinedRouteList dSICombinedRouteList, int n) {
        this.dsiCombinedRouteList[n] = dSICombinedRouteList;
        this.checkStartup(n);
    }

    private void checkStartup(int n) {
        boolean bl;
        boolean bl2 = bl = this.dsiNavigation[n] != null && this.dsiBlocking[n] != null && this.dsiCombinedRouteList[n] != null;
        if (bl != this.allDSIsAvailable[n]) {
            this.allDSIsAvailable[n] = bl;
            if (this.env.getFramework().isFrontMU()) {
                this.setStartupFront(n, this.allDSIsAvailable[n]);
            } else {
                this.setStartupRear(n, this.allDSIsAvailable[n]);
            }
        } else {
            this.updateAllDSIs(n);
        }
    }

    private void updateAllDSIs(int n) {
        this.dsiNavigationManager.setDSINavigation(this.dsiNavigation[n], n);
        this.dsiNavigationManager.setDSIBlocking(this.dsiBlocking[n], n);
        this.dsiNavigationManager.setDSICombinedRouteList(this.dsiCombinedRouteList[n], n);
    }

    private void setStartupFront(int n, boolean bl) {
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("[Startup] NavigationStartup#setStartupFront( ").append(n).append(", ").append(bl).append(" )"));
        this.logChannel.log(10000000, "NavigationStartup#setStartupFront( %2, %1 )", bl, (long)n);
        if (n != 0) {
            this.logChannel.log(100000, "NavigationStartup#setStartupFront() - invalid dsiType: %1", (long)n);
            return;
        }
        this.operationManager.taskCompleted(1);
        this.dsiNavigationManager.abortExecution("NEW MAIN DSI", n);
        this.clearNotifications(n);
        this.updateAllDSIs(n);
        if (bl) {
            CommandList commandList = this.commandListFactory.createCommandList(0);
            commandList.add(new SetNotificationCommand(new int[]{78, 53, 28, 55, 56}));
            commandList.add(new NotifyNavStateOfOperationCommand(true));
            commandList.add(new HandleRenderingInfoProviderCommand());
            commandList.add(new NotifyRestCommand());
            commandList.add(new ETCSetMetricSystemCommand(Util.getCurrentMetricsSystem(false)));
            commandList.add(new LISPCancelSpellerCommand());
            commandList.add(new LoadPersistencyCommand());
            commandList.add(new NavCommand("CheckRestartGuidance"){

                public void execute() {
                    NavigationStartup.this.operationManager.taskCompleted(4);
                    CommandList commandList = this.navigation.getRouteManager().evaluateGuidanceStatus();
                    this.getCommandList().commandFinishedWithPostSequence(commandList);
                }
            });
            commandList.add(new EnableRgPoiInfoCommand(true));
            commandList.add(new EnableRgLaneGuidanceCommand(true));
            commandList.add(new RGEnableEnhancedSignPostInfoCommand(true));
            commandList.add(new RgSetTurnListModeCommand());
            commandList.add(new RgConfigurePoiInfoCommand());
            commandList.add(new NavCommand("setNavigationInitialized"){

                public void execute() {
                    this.navigation.getOperationManager().taskCompleted(8);
                    this.navigation.getOperationManager().setNavigationMainInitialized(true);
                    this.getCommandList().commandFinished();
                }
            });
            commandList.execute("NavigationStartup#setStartupFront");
        } else {
            this.operationManager.setNavigationMainInitialized(false);
        }
    }

    private void setStartupRear(int n, boolean bl) {
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("[Startup] NavigationStartup#setStartupRear( ").append(n).append(", ").append(bl).append(" )"));
        this.logChannel.log(10000000, "NavigationStartup#setStartupRear( %2, %1 )", bl, (long)n);
        if (n == 0) {
            this.operationManager.taskCompleted(1);
            this.dsiNavigationManager.abortExecution("NEW MAIN DSI", n);
            this.clearNotifications(n);
            this.updateAllDSIs(n);
            if (bl) {
                CommandList commandList = this.commandListFactory.createCommandList(0);
                DSINavigationManager.setDSIType(commandList, n);
                commandList.add(new SetNotificationCommand(new int[]{78, 53, 28, 55, 56}));
                commandList.add(new NotifyNavStateOfOperationCommand(true));
                commandList.add(new HandleRenderingInfoProviderCommand());
                commandList.add(new NotifyRestCommand());
                commandList.add(new ETCSetMetricSystemCommand(Util.getCurrentMetricsSystem(false)));
                commandList.add(new LISPCancelSpellerCommand());
                commandList.add(new LoadPersistencyCommand());
                commandList.add(new NavCommand("setNavigationInitialized"){

                    public void execute() {
                        this.navigation.getOperationManager().taskCompleted(8);
                        this.navigation.getOperationManager().setNavigationMainInitialized(true);
                        this.getCommandList().commandFinished();
                    }
                });
                commandList.execute("NavigationStartup#setStartupRear[DSI_MAIN]");
            } else {
                this.operationManager.setNavigationMainInitialized(false);
            }
        } else if (n == 1) {
            this.dsiNavigationManager.abortExecution("NEW REMOTE DSI", n);
            this.clearNotifications(n);
            this.updateAllDSIs(n);
            if (bl) {
                CommandList commandList = this.commandListFactory.createCommandList(0);
                DSINavigationManager.setDSIType(commandList, n);
                commandList.add(new NotifyRemoteCommand());
                commandList.add(new NavCommand("setRemoteDSINavigationReady"){

                    public void execute() {
                        NavigationStartup.this.operationManager.taskCompleted(4);
                        NavigationStartup.this.operationManager.setNavigationRemoteInitialized(true);
                        this.getCommandList().commandFinished();
                    }
                });
                commandList.execute("NavigationStartup#setStartupRear[DSI_REMOTE]");
            } else {
                this.operationManager.setNavigationRemoteInitialized(false);
            }
        } else {
            this.logChannel.log(100000, "NavigationStartup#setStartupRear() - invalid dsiType: %1", (long)n);
        }
    }

    private void clearNotifications(int n) {
        this.dsiNavigationManager.getDispatcher(n).updateNavstateOfOperation(0, 2);
    }

    public void clearNotificationsAll(int n) {
        ClearNotificationCall clearNotificationCall;
        if (this.dsiNavigationManager.getDSINavigation(n) != null) {
            clearNotificationCall = new ClearNotificationCall(this.env, this.dsiNavigationManager, this.navigation, n, 0);
            clearNotificationCall.execute("NavigationStartup#clearNotifications(NAVIGATION)");
        }
        if (this.dsiNavigationManager.getDSIBlocking(n) != null) {
            clearNotificationCall = new ClearNotificationCall(this.env, this.dsiNavigationManager, this.navigation, n, 1);
            clearNotificationCall.execute("NavigationStartup#clearNotifications(BLOCKING)");
        }
        if (this.dsiNavigationManager.getDSICombinedRouteList(n) != null) {
            clearNotificationCall = new ClearNotificationCall(this.env, this.dsiNavigationManager, this.navigation, n, 2);
            clearNotificationCall.execute("NavigationStartup#clearNotifications(COMBINEDROUTELIST)");
        }
        this.dsiNavigationManager.getDispatcher(n).updateNavstateOfOperation(0, 2);
    }

    public void rgNotPossible(int n) {
        this.triggerNavAvailable("setCalculationError");
    }

    public void updateRgActive(boolean bl) {
        this.triggerNavAvailable("routeGuidanceStarted");
    }
}

