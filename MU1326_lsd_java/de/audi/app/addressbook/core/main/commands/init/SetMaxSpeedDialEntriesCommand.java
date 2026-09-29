/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetMaxSpeedDialEntriesCommand
extends AbstractADBCommand {
    private int maxSpeedDialEntries;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$SetMaxSpeedDialEntriesCommand;

    public SetMaxSpeedDialEntriesCommand(ADBApplication aDBApplication, int n) {
        super(aDBApplication);
        this.maxSpeedDialEntries = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "SetMaxSpeedDialEntriesCommand#execute()");
        boolean bl = this.adbDSIAccess.setMaxSpeedDialEntries(this.maxSpeedDialEntries);
        if (!bl) {
            this.logger.log(10000, "SetMaxSpeedDialEntriesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setMaxSpeedDialEntriesResult(int n) {
        this.logger.log(1078071040, "SetMaxSpeedDialEntriesCommand#setMaxSpeedDialEntriesResult(): %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetMaxSpeedDialEntriesCommand(ADBApplication aDBApplication, int n) {
        SetMaxSpeedDialEntriesCommand setMaxSpeedDialEntriesCommand = new SetMaxSpeedDialEntriesCommand(aDBApplication, n);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setMaxSpeedDialEntriesCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$SetMaxSpeedDialEntriesCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$SetMaxSpeedDialEntriesCommand = SetMaxSpeedDialEntriesCommand.class$("de.audi.app.addressbook.core.main.commands.init.SetMaxSpeedDialEntriesCommand")) : class$de$audi$app$addressbook$core$main$commands$init$SetMaxSpeedDialEntriesCommand).getName());
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

