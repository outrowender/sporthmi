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
import org.dsi.ifc.networking.DiscoveredNetwork;

final class CommandConnectNetwork
extends AbstractWlanCommand {
    private static final int RESULT_OK = 0;
    private static final int RESULT_ERROR = 1;
    private static final int RESULT_ERROR_PASSWORD = 2;
    private final ChoiceModelApp bondingState;
    private final ChoiceModelApp bondingResult;
    private final String networkName;
    private final String networkAddress;
    private final String password;
    private final int encryptionType;
    private final DSIWLANListener responseListener;
    static /* synthetic */ Class class$de$audi$app$wlan$core$client$CommandConnectNetwork;

    static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, DiscoveredNetwork discoveredNetwork, String string, DSIWLANListener dSIWLANListener) {
        CommandConnectNetwork commandConnectNetwork = new CommandConnectNetwork(iWlanApplication.getLogChannel(), dSIWLAN, choiceModelApp, choiceModelApp2, discoveredNetwork, string, dSIWLANListener);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandConnectNetwork);
    }

    private CommandConnectNetwork(LogChannel logChannel, DSIWLAN dSIWLAN, ChoiceModelApp choiceModelApp, ChoiceModelApp choiceModelApp2, DiscoveredNetwork discoveredNetwork, String string, DSIWLANListener dSIWLANListener) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$client$CommandConnectNetwork == null ? (class$de$audi$app$wlan$core$client$CommandConnectNetwork = CommandConnectNetwork.class$("de.audi.app.wlan.core.client.CommandConnectNetwork")) : class$de$audi$app$wlan$core$client$CommandConnectNetwork).getName());
        this.bondingState = choiceModelApp;
        this.bondingResult = choiceModelApp2;
        this.networkName = discoveredNetwork.getNetworkName();
        this.networkAddress = discoveredNetwork.getBssidAddress();
        this.password = string;
        this.encryptionType = discoveredNetwork.getEncryptionType();
        this.responseListener = dSIWLANListener;
    }

    public void execute() {
        this.dsiWlan.requestConnectNetwork(this.networkName, this.networkAddress, this.password, this.encryptionType);
    }

    public void abort() {
        this.logger.log(100000, "CommandConnectNetwork#abort()");
        this.finishCommand(1);
        if (this.responseListener != null) {
            this.responseListener.responseConnectNetwork(this.networkName, this.networkAddress, 5);
        }
    }

    public void responseConnectNetwork(String string, String string2, int n) {
        int n2;
        switch (n) {
            case 0: {
                this.logger.log(1000000, "CommandConnectNetwork#responseConnectNetwork(): %1 %2, result=%3", (Object)string, (Object)string2, (long)n);
                n2 = 0;
                break;
            }
            case 4: {
                this.logger.log(10000, "CommandConnectNetwork#responseConnectNetwork(): %1 %2, result=%3 (invalid password)", (Object)string, (Object)string2, (long)n);
                n2 = 2;
                break;
            }
            default: {
                this.logger.log(10000, "CommandConnectNetwork#responseConnectNetwork(): %1 %2, result=%3", (Object)string, (Object)string2, (long)n);
                n2 = 1;
            }
        }
        this.finishCommand(n2);
        if (this.responseListener != null) {
            this.responseListener.responseConnectNetwork(string, string2, n);
        }
    }

    private void finishCommand(int n) {
        this.bondingResult.setValue(n);
        this.bondingState.setStatus(1);
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

