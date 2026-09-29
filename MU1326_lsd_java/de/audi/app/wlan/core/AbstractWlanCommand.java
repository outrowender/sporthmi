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

    @Override
    public void responseAbortSearch(int n) {
    }

    @Override
    public void responseConnectNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseDisconnectNetwork(String string, String string2, int n) {
    }

    @Override
    public void responseFactoryReset(int n) {
    }

    @Override
    public void responseNetworkSearch(int n, int n2) {
    }

    @Override
    public void responseSetProfile(int n) {
    }

    @Override
    public void responseSetRFActive(int n) {
    }

    @Override
    public void responseSetRole(int n) {
    }

    @Override
    public void responseActivateWps(int n) {
    }

    @Override
    public void updateConnectedNetwork(String string, String string2, int n, int n2) {
    }

    @Override
    public void updateDiscoveredNetwork(DiscoveredNetwork discoveredNetwork, int n) {
    }

    @Override
    public void updateNodeList(Node[] nodeArray, int n) {
    }

    @Override
    public void updateProfile(Profile profile, int n) {
    }

    @Override
    public void updateRFActive(int n, int n2) {
    }

    @Override
    public void updateRole(int n, int n2) {
    }

    @Override
    public void updateStartupState(int n, int n2) {
    }

    @Override
    public void updateTrustedNetworks(String[] stringArray, String[] stringArray2, int[] nArray, int n) {
    }

    @Override
    public void updateWlanEnabled(boolean bl, int n) {
    }

    @Override
    public void updateWPSRunning(int n, int n2) {
    }

    @Override
    public void updateWPSStoppedAndConnecting(String string, String string2, int n) {
    }
}

