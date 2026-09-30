/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.AbstractWlanCommand;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.networking.DSIWLANListener;

final class CommandDisconnectNetwork
extends AbstractWlanCommand {
    private final String networkName;
    private final String bssidAddress;
    private final ChoiceModelApp commandMonitor;
    private DSIWLANListener responseListener;
    static /* synthetic */ Class class$de$audi$app$wlan$core$client$CommandDisconnectNetwork;

    static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN, String string, String string2, ChoiceModelApp choiceModelApp, DSIWLANListener dSIWLANListener) {
        CommandDisconnectNetwork commandDisconnectNetwork = new CommandDisconnectNetwork(iWlanApplication.getLogChannel(), dSIWLAN, string, string2, choiceModelApp, dSIWLANListener);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandDisconnectNetwork);
    }

    private CommandDisconnectNetwork(LogChannel logChannel, DSIWLAN dSIWLAN, String string, String string2, ChoiceModelApp choiceModelApp, DSIWLANListener dSIWLANListener) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$client$CommandDisconnectNetwork == null ? (class$de$audi$app$wlan$core$client$CommandDisconnectNetwork = CommandDisconnectNetwork.class$("de.audi.app.wlan.core.client.CommandDisconnectNetwork")) : class$de$audi$app$wlan$core$client$CommandDisconnectNetwork).getName());
        this.networkName = string;
        this.bssidAddress = string2;
        this.commandMonitor = choiceModelApp;
        this.responseListener = dSIWLANListener;
        choiceModelApp.setStatus(0);
        choiceModelApp.setValue(-1);
    }

    public void execute() {
        this.dsiWlan.requestDisconnectNetwork(this.networkName, this.bssidAddress);
    }

    public void responseDisconnectNetwork(String string, String string2, int n) {
        this.logger.log(10000000, "CommandDisconnectNetwork#responseDisconnectNetwork(): %1 %2, result=%3", (Object)string, (Object)string2, (long)n);
        this.commandMonitor.setValue(n);
        if (n == 0) {
            this.commandMonitor.setStatus(1);
        } else {
            this.commandMonitor.setStatus(2);
        }
        this.commandList.commandFinished();
        if (this.responseListener != null) {
            this.responseListener.responseDisconnectNetwork(string, string2, n);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

