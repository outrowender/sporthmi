/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.setup;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetLanguageCommand
extends AbstractADBCommand {
    private String language;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$setup$SetLanguageCommand;

    public SetLanguageCommand(ADBApplication aDBApplication, String string) {
        super(aDBApplication);
        this.language = string;
    }

    public void execute() {
        this.logger.log(1000000, "SetLanguageCommand#execute(): language: %1", (Object)this.language);
        boolean bl = this.adbDSIAccess.setLanguage(this.language);
        if (!bl) {
            this.logger.log(10000, "SetLanguageCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void setLanguageResult(int n) {
        this.logger.log(1000000, "SetLanguageCommand#setLanguageResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetLanguageCommand(ADBApplication aDBApplication, String string) {
        SetLanguageCommand setLanguageCommand = new SetLanguageCommand(aDBApplication, string);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setLanguageCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$setup$SetLanguageCommand == null ? (class$de$audi$app$addressbook$core$main$commands$setup$SetLanguageCommand = SetLanguageCommand.class$("de.audi.app.addressbook.core.main.commands.setup.SetLanguageCommand")) : class$de$audi$app$addressbook$core$main$commands$setup$SetLanguageCommand).getName());
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

