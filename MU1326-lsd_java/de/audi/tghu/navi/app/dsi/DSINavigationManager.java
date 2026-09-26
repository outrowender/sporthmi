/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.dsi.AbstractDSINavigationHandler;
import de.audi.tghu.navi.app.dsi.DSINavigationDispatcher;
import de.audi.tghu.navi.app.dsi.DefaultDSINavigationMainHandler;
import de.audi.tghu.navi.app.dsi.DefaultDSINavigationRemoteHandler;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.navigation.DSIBlocking;
import org.dsi.ifc.navigation.DSICombinedRouteList;
import org.dsi.ifc.navigation.DSINavigation;

public class DSINavigationManager {
    public static final int DSI_MAIN;
    public static final int DSI_REMOTE;
    public static final int DSI_MAX;
    public static final String DSI_REMOTE_KEY;
    private final CommandListManager commandListManager;
    private final LogChannel logChannel;
    private final DSINavigation[] navigationDSIs = new DSINavigation[2];
    private final DSIBlocking[] blockingDSIs = new DSIBlocking[2];
    private final DSICombinedRouteList[] combinedRouteListDSIs = new DSICombinedRouteList[2];
    private final DSINavigationDispatcher[] navigationDispatchers = new DSINavigationDispatcher[2];

    public DSINavigationManager(NavigationEnv navigationEnv, Navigation navigation, CommandListManager commandListManager, ICommandListFactory iCommandListFactory, DispatcherBase dispatcherBase) {
        this.commandListManager = commandListManager;
        this.logChannel = navigationEnv.getLogChannel();
        DefaultDSINavigationMainHandler defaultDSINavigationMainHandler = new DefaultDSINavigationMainHandler(navigationEnv, navigation, iCommandListFactory);
        DefaultDSINavigationRemoteHandler defaultDSINavigationRemoteHandler = new DefaultDSINavigationRemoteHandler(navigationEnv, navigation);
        this.navigationDispatchers[0] = new DSINavigationDispatcher(navigationEnv, commandListManager, defaultDSINavigationMainHandler, 0, dispatcherBase);
        this.navigationDispatchers[1] = new DSINavigationDispatcher(navigationEnv, commandListManager, defaultDSINavigationRemoteHandler, 1, dispatcherBase);
    }

    public DSINavigationDispatcher getDispatcher(int n) {
        if (0 <= n && n < 2) {
            return this.navigationDispatchers[n];
        }
        this.logChannel.log(-1601830656, "DSINavigationManager#getDispatcher() - invalid dsiType: %1", (long)n);
        return null;
    }

    public void setDSINavigation(DSINavigation dSINavigation, int n) {
        this.logChannel.log(-2137614336, "DSINavigationManager#setDSINavigation( %1, %2 )", (Object)dSINavigation, (long)n);
        if (0 <= n && n < 2) {
            this.navigationDSIs[n] = dSINavigation;
        } else {
            this.logChannel.log(-1601830656, "DSINavigationManager#setDSINavigation() - invalid dsiType: %1", (long)n);
        }
    }

    public void setDSIBlocking(DSIBlocking dSIBlocking, int n) {
        this.logChannel.log(-2137614336, "DSINavigationManager#setDSIBlocking( %1, %2 )", (Object)dSIBlocking, (long)n);
        if (0 <= n && n < 2) {
            this.blockingDSIs[n] = dSIBlocking;
        } else {
            this.logChannel.log(-1601830656, "DSINavigationManager#setDSIBlocking() - invalid dsiType: %1", (long)n);
        }
    }

    public void setDSICombinedRouteList(DSICombinedRouteList dSICombinedRouteList, int n) {
        this.logChannel.log(-2137614336, "DSINavigationManager#setDSICombinedRouteList( %1, %2 )", (Object)dSICombinedRouteList, (long)n);
        if (0 <= n && n < 2) {
            this.combinedRouteListDSIs[n] = dSICombinedRouteList;
        } else {
            this.logChannel.log(-1601830656, "DSINavigationManager#setDSICombinedRouteList() - invalid dsiType: %1", (long)n);
        }
    }

    public DSINavigation getDSINavigation(int n) {
        if (0 <= n && n < 2) {
            return this.navigationDSIs[n];
        }
        this.logChannel.log(-1601830656, "DSINavigationManager#getDSINavigation() - invalid dsiType: %1", (long)n);
        return null;
    }

    public DSIBlocking getDSIBlocking(int n) {
        if (0 <= n && n < 2) {
            return this.blockingDSIs[n];
        }
        this.logChannel.log(-1601830656, "DSINavigationManager#getDSIBlocking() - invalid dsiType: %1", (long)n);
        return null;
    }

    public DSICombinedRouteList getDSICombinedRouteList(int n) {
        if (0 <= n && n < 2) {
            return this.combinedRouteListDSIs[n];
        }
        this.logChannel.log(-1601830656, "DSINavigationManager#getDSICombinedRouteList() - invalid dsiType: %1", (long)n);
        return null;
    }

    public static String dsiTypeToString(int n) {
        String string;
        switch (n) {
            case 0: {
                string = "DSI_MAIN";
                break;
            }
            case 1: {
                string = "DSI_REMOTE";
                break;
            }
            default: {
                string = "DSI_UNKNOWN";
            }
        }
        return string;
    }

    public static int getDSIType(ICommandList iCommandList) {
        return iCommandList.get("DSI_NAVI_REMOTE") != null ? 1 : 0;
    }

    public static void setDSIType(CommandList commandList, int n) {
        if (n == 1) {
            commandList.put("DSI_NAVI_REMOTE", "true");
        } else {
            commandList.remove("DSI_NAVI_REMOTE");
        }
    }

    public void setNavigationMode(int n) {
        this.logChannel.log(-2137614336, "DSINavigationManager#setNavigationMode( %1 )", (long)n);
        int n2 = n == 0 ? 0 : 1;
        this.navigationDispatchers[n2].propagateDSIData();
    }

    public AbstractDSINavigationHandler getDefaultHandler(int n) {
        return this.navigationDispatchers[n].getDSINavigationDefaultHandler();
    }

    public void abortExecution(String string, int n) {
        switch (n) {
            case 0: {
                this.commandListManager.abortExecution(string, "DSI_NAVI_REMOTE", true);
                break;
            }
            case 1: {
                this.commandListManager.abortExecution(string, "DSI_NAVI_REMOTE", false);
                break;
            }
            default: {
                this.logChannel.log(10000, "DSINavigationManager#abortExecution() - invalid DSI type %1 !", (long)n);
            }
        }
    }

    public void cleanUp() {
        for (int i2 = 0; i2 < this.navigationDispatchers.length; ++i2) {
            this.navigationDispatchers[i2].cleanUp();
            this.navigationDispatchers[i2] = null;
        }
    }
}

