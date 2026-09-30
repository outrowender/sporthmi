/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.reset;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.app.data.core.profile.IDataProfile;
import org.dsi.ifc.networking.CDataProfile;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandAutomaticProfile
extends AbstractDataCommand {
    private final IDataProfile profileHandler;
    static /* synthetic */ Class class$de$audi$app$data$core$reset$CommandAutomaticProfile;

    static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration) {
        CommandAutomaticProfile commandAutomaticProfile = new CommandAutomaticProfile(iDataApplication, dSIDataConfiguration);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandAutomaticProfile);
    }

    private CommandAutomaticProfile(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration) {
        super(iDataApplication.getLogChannel(), dSIDataConfiguration, (class$de$audi$app$data$core$reset$CommandAutomaticProfile == null ? (class$de$audi$app$data$core$reset$CommandAutomaticProfile = CommandAutomaticProfile.class$("de.audi.app.data.core.reset.CommandAutomaticProfile")) : class$de$audi$app$data$core$reset$CommandAutomaticProfile).getName());
        this.profileHandler = iDataApplication.getDataProfile();
    }

    public void execute() {
        if (this.dsi != null) {
            this.dsi.automaticProfile(-1);
        } else {
            this.logger.log(100000, "CommandAutomaticProfile#execute(): dsi is NULL");
            this.commandList.commandFinished();
        }
    }

    public void automaticProfileResponse(int n, CDataProfile cDataProfile, int n2) {
        this.logger.log(1000000, "CommandAutomaticProfile#automaticProfileResponse(): %1; result=%2", (Object)cDataProfile, (long)n2);
        if (this.profileHandler != null) {
            this.profileHandler.automaticProfileResponse(cDataProfile);
        } else {
            this.logger.log(100000, "CommandAutomaticProfile#automaticProfileResponse(): profileHandler is null");
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

