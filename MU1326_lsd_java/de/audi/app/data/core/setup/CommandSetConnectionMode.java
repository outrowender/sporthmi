/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.setup;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandSetConnectionMode
extends AbstractDataCommand {
    private final int connectionMode;
    static /* synthetic */ Class class$de$audi$app$data$core$setup$CommandSetConnectionMode;

    static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration, int n) {
        CommandSetConnectionMode commandSetConnectionMode = new CommandSetConnectionMode(iDataApplication.getLogChannel(), dSIDataConfiguration, n);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandSetConnectionMode);
    }

    private CommandSetConnectionMode(LogChannel logChannel, DSIDataConfiguration dSIDataConfiguration, int n) {
        super(logChannel, dSIDataConfiguration, (class$de$audi$app$data$core$setup$CommandSetConnectionMode == null ? (class$de$audi$app$data$core$setup$CommandSetConnectionMode = CommandSetConnectionMode.class$("de.audi.app.data.core.setup.CommandSetConnectionMode")) : class$de$audi$app$data$core$setup$CommandSetConnectionMode).getName());
        this.connectionMode = n;
    }

    @Override
    public void execute() {
        if (this.dsi != null) {
            this.dsi.setConnectionMode(this.connectionMode);
        } else {
            this.logger.log(-1601830656, "CommandSetConnectionMode#execute(): dsi is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setConnectionModeResponse(int n) {
        this.logger.log(1078071040, "CommandSetConnectionMode#setConnectionModeResponse(): result=%1", (long)n);
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

