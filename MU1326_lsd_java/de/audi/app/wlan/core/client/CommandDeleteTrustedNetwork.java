/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.AbstractWlanCommand;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLAN;

final class CommandDeleteTrustedNetwork
extends AbstractWlanCommand {
    private final String networkName;
    private final String bssidAddress;
    private final ChoiceModelApp commandMonitor;
    static /* synthetic */ Class class$de$audi$app$wlan$core$client$CommandDeleteTrustedNetwork;

    static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN, String string, String string2, ChoiceModelApp choiceModelApp) {
        CommandDeleteTrustedNetwork commandDeleteTrustedNetwork = new CommandDeleteTrustedNetwork(iWlanApplication.getLogChannel(), dSIWLAN, string, string2, choiceModelApp);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandDeleteTrustedNetwork);
    }

    private CommandDeleteTrustedNetwork(LogChannel logChannel, DSIWLAN dSIWLAN, String string, String string2, ChoiceModelApp choiceModelApp) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$client$CommandDeleteTrustedNetwork == null ? (class$de$audi$app$wlan$core$client$CommandDeleteTrustedNetwork = CommandDeleteTrustedNetwork.class$("de.audi.app.wlan.core.client.CommandDeleteTrustedNetwork")) : class$de$audi$app$wlan$core$client$CommandDeleteTrustedNetwork).getName());
        this.networkName = string;
        this.bssidAddress = string2;
        this.commandMonitor = choiceModelApp;
        choiceModelApp.setStatus(0);
        choiceModelApp.setValue(-1);
    }

    @Override
    public void execute() {
        this.dsiWlan.requestDeleteTrustedNetwork(this.networkName, this.bssidAddress);
    }

    @Override
    public void responseDeleteTrustedNetwork(String string, String string2, int n) {
        this.logger.log(-2137614336, "CommandDeleteTrustedNetwork#responseDeleteTrustedNetwork(): %1 %2, result=%3", (Object)string, (Object)string2, (long)n);
        this.commandMonitor.setValue(n);
        if (n == 0) {
            this.commandMonitor.setStatus(1);
        } else {
            this.commandMonitor.setStatus(2);
        }
        this.commandList.commandFinished();
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

