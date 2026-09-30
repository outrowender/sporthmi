/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandAcceptDataRequest
extends AbstractDataCommand {
    private int dataApplicationIdOnlineServices;
    private boolean dataAccept;
    static /* synthetic */ Class class$de$audi$app$data$core$online$CommandAcceptDataRequest;

    public static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration, int n, boolean bl) {
        CommandAcceptDataRequest commandAcceptDataRequest = new CommandAcceptDataRequest(iDataApplication.getLogChannel(), dSIDataConfiguration, n, bl);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandAcceptDataRequest);
    }

    private CommandAcceptDataRequest(LogChannel logChannel, DSIDataConfiguration dSIDataConfiguration, int n, boolean bl) {
        super(logChannel, dSIDataConfiguration, (class$de$audi$app$data$core$online$CommandAcceptDataRequest == null ? (class$de$audi$app$data$core$online$CommandAcceptDataRequest = CommandAcceptDataRequest.class$("de.audi.app.data.core.online.CommandAcceptDataRequest")) : class$de$audi$app$data$core$online$CommandAcceptDataRequest).getName());
        this.dataApplicationIdOnlineServices = n;
        this.dataAccept = bl;
    }

    public void execute() {
        this.logger.log(1000000, "CommandAcceptDataRequest#execute(): dataApplicationIdOnlineServices %1, dataAccept %2", (Object)String.valueOf(this.dataApplicationIdOnlineServices), (Object)String.valueOf(this.dataAccept));
        if (this.dsi != null) {
            this.dsi.acceptDataRequest(this.dataApplicationIdOnlineServices, this.dataAccept);
        } else {
            this.logger.log(100000, "CommandAcceptDataRequest#execute(): dsi is NULL");
            this.commandList.commandFinished();
        }
    }

    public void acceptDataRequestResponse(int n) {
        this.logger.log(1000000, "CommandAcceptDataRequest#acceptDataRequestResponse(): result=%1", (long)n);
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

