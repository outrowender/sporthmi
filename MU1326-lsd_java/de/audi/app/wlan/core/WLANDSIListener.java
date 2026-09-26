/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.wlan.core.WLANDSIListener$1;
import de.audi.app.wlan.core.WLANDSIListener$10;
import de.audi.app.wlan.core.WLANDSIListener$11;
import de.audi.app.wlan.core.WLANDSIListener$12;
import de.audi.app.wlan.core.WLANDSIListener$13;
import de.audi.app.wlan.core.WLANDSIListener$14;
import de.audi.app.wlan.core.WLANDSIListener$15;
import de.audi.app.wlan.core.WLANDSIListener$16;
import de.audi.app.wlan.core.WLANDSIListener$17;
import de.audi.app.wlan.core.WLANDSIListener$18;
import de.audi.app.wlan.core.WLANDSIListener$19;
import de.audi.app.wlan.core.WLANDSIListener$2;
import de.audi.app.wlan.core.WLANDSIListener$20;
import de.audi.app.wlan.core.WLANDSIListener$3;
import de.audi.app.wlan.core.WLANDSIListener$4;
import de.audi.app.wlan.core.WLANDSIListener$5;
import de.audi.app.wlan.core.WLANDSIListener$6;
import de.audi.app.wlan.core.WLANDSIListener$7;
import de.audi.app.wlan.core.WLANDSIListener$8;
import de.audi.app.wlan.core.WLANDSIListener$9;
import de.audi.app.wlan.core.WLANDefaultListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.command.ICommandResponseSupplier;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

class WLANDSIListener
implements DSIWLANListener,
ICommandResponseSupplier {
    private final CommandListManager cmdListManager;
    private final WLANDefaultListener wlanDefaultListener;
    private final LogChannel log;

    WLANDSIListener(CommandListManager commandListManager, LogChannel logChannel) {
        this.cmdListManager = commandListManager;
        this.wlanDefaultListener = new WLANDefaultListener(logChannel);
        this.log = logChannel;
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log.log(10000, "WLANDSIListener#asyncException():  called, error code: %2, error msg: %1, request type: %3 ", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void responseAbortSearch(int n) {
        CommandResponse.execute(this, new WLANDSIListener$1(this, n));
    }

    @Override
    public void responseConnectNetwork(String string, String string2, int n) {
        CommandResponse.execute(this, new WLANDSIListener$2(this, string, string2, n));
    }

    @Override
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
        CommandResponse.execute(this, new WLANDSIListener$3(this, string, string2, n));
    }

    @Override
    public void responseDisconnectNetwork(String string, String string2, int n) {
        CommandResponse.execute(this, new WLANDSIListener$4(this, string, string2, n));
    }

    @Override
    public void responseFactoryReset(int n) {
        CommandResponse.execute(this, new WLANDSIListener$5(this, n));
    }

    @Override
    public void responseNetworkSearch(int n, int n2) {
        CommandResponse.execute(this, new WLANDSIListener$6(this, n, n2));
    }

    @Override
    public void responseSetProfile(int n) {
        CommandResponse.execute(this, new WLANDSIListener$7(this, n));
    }

    @Override
    public void responseSetRFActive(int n) {
        CommandResponse.execute(this, new WLANDSIListener$8(this, n));
    }

    @Override
    public void responseSetRole(int n) {
        CommandResponse.execute(this, new WLANDSIListener$9(this, n));
    }

    @Override
    public void responseActivateWps(int n) {
        CommandResponse.execute(this, new WLANDSIListener$10(this));
    }

    @Override
    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
        CommandResponse.execute(this, new WLANDSIListener$11(this, string, string2, n, n2));
    }

    @Override
    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
        CommandResponse.execute(this, new WLANDSIListener$12(this, discoveredNetwork, n));
    }

    @Override
    public void updateNodeList(Node[] nodeArray, int n) {
        CommandResponse.execute(this, new WLANDSIListener$13(this, nodeArray, n));
    }

    @Override
    public void updateProfile(Profile profile, int n) {
        CommandResponse.execute(this, new WLANDSIListener$14(this, profile, n));
    }

    @Override
    public void updateRFActive(int n, int n2) {
        CommandResponse.execute(this, new WLANDSIListener$15(this, n, n2));
    }

    @Override
    public void updateRole(int n, int n2) {
        CommandResponse.execute(this, new WLANDSIListener$16(this, n, n2));
    }

    @Override
    public void updateStartupState(int n, int n2) {
        CommandResponse.execute(this, new WLANDSIListener$17(this, n, n2));
    }

    @Override
    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
        CommandResponse.execute(this, new WLANDSIListener$18(this, stringArray, stringArray2, nArray, n));
    }

    @Override
    public void updateWlanEnabled(boolean bl, int n) {
        CommandResponse.execute(this, new WLANDSIListener$19(this, bl, n));
    }

    @Override
    public void updateWPSRunning(int n, int n2) {
        CommandResponse.execute(this, new WLANDSIListener$20(this));
    }

    @Override
    public CommandList getActiveCommandList() {
        return this.cmdListManager.getActiveCommandList();
    }

    @Override
    public DSIListener getDSIDefaultHandler() {
        return this.wlanDefaultListener;
    }

    @Override
    public String getHandlerName() {
        return super.getClass().getName();
    }

    @Override
    public LogChannel getLogChannel() {
        return this.log;
    }

    @Override
    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
    }

    static /* synthetic */ LogChannel access$000(WLANDSIListener wLANDSIListener) {
        return wLANDSIListener.log;
    }
}

