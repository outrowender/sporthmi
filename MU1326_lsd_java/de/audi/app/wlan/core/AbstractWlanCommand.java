/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.networking.DSIWLANListener;
import org.dsi.ifc.networking.DiscoveredNetwork;
import org.dsi.ifc.networking.Node;
import org.dsi.ifc.networking.Profile;

public abstract class AbstractWlanCommand
extends Command
implements DSIWLANListener {
    protected final DSIWLAN dsiWlan;

    protected static void schedule(CommandListManager commandListManager, Command command) {
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(command);
        commandList.execute(command.getName());
    }

    protected static void schedule(CommandListManager commandListManager, Command command, Command command2) {
        CommandList commandList = new CommandList(commandListManager);
        commandList.add(command);
        commandList.setErrorCommand(command2);
        commandList.execute(command.getName());
    }

    protected AbstractWlanCommand(LogChannel logChannel, DSIWLAN dSIWLAN, String string) {
        super(logChannel, string);
        this.dsiWlan = dSIWLAN;
    }

    public void responseAbortSearch(int n) {
    }

    public void responseConnectNetwork(String string, String string2, int n) {
    }

    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
    }

    public void responseDisconnectNetwork(String string, String string2, int n) {
    }

    public void responseFactoryReset(int n) {
    }

    public void responseNetworkSearch(int n, int n2) {
    }

    public void responseSetProfile(int n) {
    }

    public void responseSetRFActive(int n) {
    }

    public void responseSetRole(int n) {
    }

    public void responseActivateWps(int n) {
    }

    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
    }

    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
    }

    public void updateNodeList(Node[] nodeArray, int n) {
    }

    public void updateProfile(Profile profile, int n) {
    }

    public void updateRFActive(int n, int n2) {
    }

    public void updateRole(int n, int n2) {
    }

    public void updateStartupState(int n, int n2) {
    }

    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
    }

    public void updateWlanEnabled(boolean bl, int n) {
    }

    public void updateWPSRunning(int n, int n2) {
    }

    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
    }
}

