/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.setup;

import de.audi.app.data.core.AbstractDataCommand;
import de.audi.app.data.core.IDataApplication;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.networking.DSIDataConfiguration;

final class CommandSetRequestSetting
extends AbstractDataCommand {
    private int dataApplicationID;
    private int statusRequest;
    static /* synthetic */ Class class$de$audi$app$data$core$setup$CommandSetRequestSetting;

    static void schedule(IDataApplication iDataApplication, DSIDataConfiguration dSIDataConfiguration, int n, int n2) {
        CommandSetRequestSetting commandSetRequestSetting = new CommandSetRequestSetting(iDataApplication.getLogChannel(), dSIDataConfiguration, n, n2);
        AbstractDataCommand.schedule(iDataApplication.getCommandListManager(), commandSetRequestSetting);
    }

    private CommandSetRequestSetting(LogChannel logChannel, DSIDataConfiguration dSIDataConfiguration, int n, int n2) {
        super(logChannel, dSIDataConfiguration, (class$de$audi$app$data$core$setup$CommandSetRequestSetting == null ? (class$de$audi$app$data$core$setup$CommandSetRequestSetting = CommandSetRequestSetting.class$("de.audi.app.data.core.setup.CommandSetRequestSetting")) : class$de$audi$app$data$core$setup$CommandSetRequestSetting).getName());
        this.dataApplicationID = n;
        this.statusRequest = n2;
    }

    @Override
    public void execute() {
        if (this.dsi != null) {
            this.dsi.setRequestSetting(this.dataApplicationID, this.statusRequest);
        } else {
            this.logger.log(-1601830656, "CommandSetRequestSetting#execute(): dsi is NULL");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setRequestSettingResponse(int n) {
        this.logger.log(1078071040, "CommandSetRequestSetting#setRequestSettingResponse(): result=%1", (long)n);
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

