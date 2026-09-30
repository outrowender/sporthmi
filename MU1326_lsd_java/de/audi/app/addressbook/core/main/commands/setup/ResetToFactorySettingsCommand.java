/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.setup;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class ResetToFactorySettingsCommand
extends AbstractADBCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$setup$ResetToFactorySettingsCommand;

    public ResetToFactorySettingsCommand(ADBApplication aDBApplication) {
        super(aDBApplication);
    }

    public void execute() {
        this.logger.log(10000000, "ResetToFactorySettingsCommand#execute()");
        boolean bl = this.adbDSIAccess.resetToFactorySettings();
        if (!bl) {
            this.logger.log(10000, "ResetToFactorySettingsCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void resetToFactorySettingsResult(int n) {
        this.logger.log(10000000, "ResetToFactorySettingsCommand#resetToFactorySettingsResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createResetToFactorySettingsCommand(ADBApplication aDBApplication) {
        ResetToFactorySettingsCommand resetToFactorySettingsCommand = new ResetToFactorySettingsCommand(aDBApplication);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(resetToFactorySettingsCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$setup$ResetToFactorySettingsCommand == null ? (class$de$audi$app$addressbook$core$main$commands$setup$ResetToFactorySettingsCommand = ResetToFactorySettingsCommand.class$("de.audi.app.addressbook.core.main.commands.setup.ResetToFactorySettingsCommand")) : class$de$audi$app$addressbook$core$main$commands$setup$ResetToFactorySettingsCommand).getName());
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

