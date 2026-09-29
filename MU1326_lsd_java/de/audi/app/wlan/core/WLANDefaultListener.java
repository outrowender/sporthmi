/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

class WLANDefaultListener
implements DSIWLANListener {
    private LogChannel log;

    WLANDefaultListener(LogChannel logChannel) {
        this.log = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "WLANDefaultListener#asyncException(): called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void responseAbortSearch(int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseAbortSearch(): Expected to be handled by a Command!");
    }

    @Override
    public void responseConnectNetwork(String string, String string2, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseConnectNetwork(): Expected to be handled by a Command!");
    }

    @Override
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseDeleteTrustedNetwork(): Expected to be handled by a Command!");
    }

    @Override
    public void responseDisconnectNetwork(String string, String string2, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseDisconnectNetwork(): Expected to be handled by a Command!");
    }

    @Override
    public void responseFactoryReset(int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseFactoryReset(): Expected to be handled by a Command!");
    }

    @Override
    public void responseNetworkSearch(int n, int n2) {
        this.log.log(-1601830656, "WLANDefaultListener#responseNetworkSearch(): Expected to be handled by a Command!");
    }

    @Override
    public void responseSetProfile(int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseSetProfile(): Expected to be handled by a Command!");
    }

    @Override
    public void responseSetRFActive(int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseSetRFActive(): Expected to be handled by a Command!");
    }

    @Override
    public void responseSetRole(int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseSetRole(): Expected to be handled by a Command!");
    }

    @Override
    public void responseActivateWps(int n) {
        this.log.log(-1601830656, "WLANDefaultListener#responseActivateWps(): Unexpected call (no notification)");
    }

    @Override
    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
        this.log.log(-1601830656, "WLANDefaultListener#updateConnectedNetwork(): Unexpected call (no notification)");
    }

    @Override
    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#updateDiscoveredNetwork(): Unexpected call (no notification)");
    }

    @Override
    public void updateNodeList(Node[] nodeArray, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#updateNodeList(): Unexpected call (no notification)");
    }

    @Override
    public void updateProfile(Profile profile, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#updateProfile(): Unexpected call (no notification)");
    }

    @Override
    public void updateRFActive(int n, int n2) {
        this.log.log(-1601830656, "WLANDefaultListener#updateRFActive(): Unexpected call (no notification)");
    }

    @Override
    public void updateRole(int n, int n2) {
        this.log.log(-1601830656, "WLANDefaultListener#updateRole(): Unexpected call (no notification)");
    }

    @Override
    public void updateStartupState(int n, int n2) {
        this.log.log(-1601830656, "WLANDefaultListener#updateStartupState(): Unexpected call (no notification)");
    }

    @Override
    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#updateTrustedNetworks(): Unexpected call (no notification)");
    }

    @Override
    public void updateWlanEnabled(boolean bl, int n) {
        this.log.log(-1601830656, "WLANDefaultListener#updateWlanEnabled(): Unexpected call (no notification)");
    }

    @Override
    public void updateWPSRunning(int n, int n2) {
        this.log.log(-1601830656, "WLANDefaultListener#updateWPSRunning(): Unexpected call (no notification)");
    }

    @Override
    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
    }
}

