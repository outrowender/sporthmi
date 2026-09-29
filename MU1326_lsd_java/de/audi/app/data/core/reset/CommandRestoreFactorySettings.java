/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.reset;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandRestoreFactorySettings
extends AbstractDataCommand {
    static /* synthetic */ Class class$de$audi$app$data$core$reset$CommandRestoreFactorySettings;

    static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration) {
        CommandRestoreFactorySettings commandRestoreFactorySettings = new CommandRestoreFactorySettings(iDataApplication.getLogChannel(), dSIDataConfiguration);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandRestoreFactorySettings);
    }

    private CommandRestoreFactorySettings(LogChannel logChannel, DSIDataConfiguration dSIDataConfiguration) {
        super(logChannel, dSIDataConfiguration, (class$de$audi$app$data$core$reset$CommandRestoreFactorySettings == null ? (class$de$audi$app$data$core$reset$CommandRestoreFactorySettings = CommandRestoreFactorySettings.class$("de.audi.app.data.core.reset.CommandRestoreFactorySettings")) : class$de$audi$app$data$core$reset$CommandRestoreFactorySettings).getName());
    }

    @Override
    public void execute() {
        if (this.dsi != null) {
            this.dsi.restoreFactorySettings();
        } else {
            this.logger.log(-1601830656, "CommandRestoreFactorySettings#execute(): dsi is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void restoreFactorySettingsResponse(int n) {
        this.logger.log(-2137614336, "CommandRestoreFactorySettings#restoreFactorySettingsResponse(): result=%1", (long)n);
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

