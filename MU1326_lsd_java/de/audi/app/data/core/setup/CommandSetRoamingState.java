/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.setup;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandSetRoamingState
extends AbstractDataCommand {
    private final int roamingState;
    static /* synthetic */ Class class$de$audi$app$data$core$setup$CommandSetRoamingState;

    static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration, int n) {
        CommandSetRoamingState commandSetRoamingState = new CommandSetRoamingState(iDataApplication.getLogChannel(), dSIDataConfiguration, n);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandSetRoamingState);
    }

    private CommandSetRoamingState(LogChannel logChannel, DSIDataConfiguration dSIDataConfiguration, int n) {
        super(logChannel, dSIDataConfiguration, (class$de$audi$app$data$core$setup$CommandSetRoamingState == null ? (class$de$audi$app$data$core$setup$CommandSetRoamingState = CommandSetRoamingState.class$("de.audi.app.data.core.setup.CommandSetRoamingState")) : class$de$audi$app$data$core$setup$CommandSetRoamingState).getName());
        this.roamingState = n;
    }

    @Override
    public void execute() {
        if (this.dsi != null) {
            this.dsi.setRoamingState(this.roamingState);
        } else {
            this.logger.log(-1601830656, "CommandSetRoamingState#execute(): dsi is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setRoamingStateResponse(int n) {
        this.logger.log(1078071040, "CommandSetRoamingState#setRoamingStateResponse(): result=%1", (long)n);
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

