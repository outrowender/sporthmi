/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.AbstractWlanCommand;
import de.audi.app.wlan.core.IWlanApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIWLAN;

final class CommandNetworkSearch
extends AbstractWlanCommand {
    private static final int INQUIRY_LENGTH;
    private static final int NUM_RESPONSES;
    private final ChoiceModelApp inquiryState;
    static /* synthetic */ Class class$de$audi$app$wlan$core$client$CommandNetworkSearch;

    static void schedule(IWlanApplication iWlanApplication, DSIWLAN dSIWLAN, ChoiceModelApp choiceModelApp) {
        CommandNetworkSearch commandNetworkSearch = new CommandNetworkSearch(iWlanApplication.getLogChannel(), dSIWLAN, choiceModelApp);
        AbstractWlanCommand.schedule(iWlanApplication.getCommandListManager(), commandNetworkSearch);
    }

    private CommandNetworkSearch(LogChannel logChannel, DSIWLAN dSIWLAN, ChoiceModelApp choiceModelApp) {
        super(logChannel, dSIWLAN, (class$de$audi$app$wlan$core$client$CommandNetworkSearch == null ? (class$de$audi$app$wlan$core$client$CommandNetworkSearch = CommandNetworkSearch.class$("de.audi.app.wlan.core.client.CommandNetworkSearch")) : class$de$audi$app$wlan$core$client$CommandNetworkSearch).getName());
        this.inquiryState = choiceModelApp;
    }

    @Override
    public void execute() {
        this.dsiWlan.requestNetworkSearch(5, 50);
        this.logger.log(-2137614336, "CommandNetworkSearch#requestNetworkSearch(): INQUIRY_LENGTH=%1, NUM_RESPONSES=%2", (long)0, (long)0);
    }

    @Override
    public void responseNetworkSearch(int n, int n2) {
        this.logger.log(-2137614336, "CommandNetworkSearch#responseNetworkSearch(): Found %1 networks, result=%2", (long)n, (long)n2);
        this.inquiryState.setValue(0);
        this.commandList.commandFinished();
    }

    void abortSearch() {
        this.logger.log(-2137614336, "CommandNetworkSearch#abortSearch()");
        this.dsiWlan.requestAbortSearch();
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

