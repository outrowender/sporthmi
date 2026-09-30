/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.counter;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandResetPacketCounter
extends AbstractDataCommand {
    static /* synthetic */ Class class$de$audi$app$data$core$counter$CommandResetPacketCounter;

    static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration) {
        CommandResetPacketCounter commandResetPacketCounter = new CommandResetPacketCounter(iDataApplication.getLogChannel(), dSIDataConfiguration);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandResetPacketCounter);
    }

    private CommandResetPacketCounter(LogChannel logChannel, DSIDataConfiguration dSIDataConfiguration) {
        super(logChannel, dSIDataConfiguration, (class$de$audi$app$data$core$counter$CommandResetPacketCounter == null ? (class$de$audi$app$data$core$counter$CommandResetPacketCounter = CommandResetPacketCounter.class$("de.audi.app.data.core.counter.CommandResetPacketCounter")) : class$de$audi$app$data$core$counter$CommandResetPacketCounter).getName());
    }

    public void execute() {
        if (this.dsi != null) {
            this.dsi.resetPacketCounter();
        } else {
            this.logger.log(100000, "CommandResetPacketCounter#execute(): dsi is NULL");
            this.commandList.commandFinished();
        }
    }

    public void resetPacketCounterResponse(int n) {
        this.logger.log(10000000, "CommandResetPacketCounter#resetPacketCounterResponse(): result=%1", (long)n);
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

