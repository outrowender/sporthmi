/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class FinalizeConfigurationCommand
extends AbstractADBCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$FinalizeConfigurationCommand;

    public FinalizeConfigurationCommand(ADBApplication aDBApplication) {
        super(aDBApplication);
    }

    public void execute() {
        this.logger.log(10000000, "FinalizeConfigurationCommand#execute()");
        boolean bl = this.adbDSIAccess.finalizeConfiguration();
        if (!bl) {
            this.logger.log(10000, "FinalizeConfigurationCommand#execute(): dsi call was not successful, finishing command.");
        }
        this.commandList.commandFinished();
    }

    public static void createFinalizeConfigurationCommand(ADBApplication aDBApplication) {
        FinalizeConfigurationCommand finalizeConfigurationCommand = new FinalizeConfigurationCommand(aDBApplication);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(finalizeConfigurationCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$FinalizeConfigurationCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$FinalizeConfigurationCommand = FinalizeConfigurationCommand.class$("de.audi.app.addressbook.core.main.commands.init.FinalizeConfigurationCommand")) : class$de$audi$app$addressbook$core$main$commands$init$FinalizeConfigurationCommand).getName());
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

