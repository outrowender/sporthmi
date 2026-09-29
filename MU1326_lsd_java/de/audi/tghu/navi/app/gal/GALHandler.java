/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.gal;

import de.audi.atip.interapp.terminalmode.DefaultTerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.ITerminalModeUpdateListener;
import de.audi.atip.interapp.terminalmode.TerminalModeAppState;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterService;

public class GALHandler
extends DefaultTerminalModeUpdateListener
implements ITerminalModeUpdateListener {
    protected final NavigationEnv navigationEnv;
    protected boolean naviIsRunningOnSmartphone = false;
    protected final ClusterService clusterService;

    public GALHandler(NavigationEnv navigationEnv, ClusterService clusterService) {
        this.navigationEnv = navigationEnv;
        this.clusterService = clusterService;
    }

    @Override
    public void updateAppStates(TerminalModeAppState[] terminalModeAppStateArray) {
        this.navigationEnv.getLogChannel().log(-2137614336, "GALHandler#updateAppStates");
        if (terminalModeAppStateArray == null) {
            return;
        }
        for (int i2 = 0; i2 < terminalModeAppStateArray.length; ++i2) {
            TerminalModeAppState terminalModeAppState = terminalModeAppStateArray[i2];
            if (terminalModeAppState == null || terminalModeAppState.getAppId() != 1) continue;
            this.updateNaviAppState(terminalModeAppState.isRunningOnDevice());
            return;
        }
    }

    protected void updateNaviAppState(boolean bl) {
        this.navigationEnv.getLogChannel().log(1078071040, "GALHandler#updateNaviAppState - naviIsRunningOnSmartphone: %1", bl);
        this.naviIsRunningOnSmartphone = bl;
        this.clusterService.updateGALState(bl);
    }

    public boolean isNaviRunningOnSmartphone() {
        return this.naviIsRunningOnSmartphone;
    }
}

