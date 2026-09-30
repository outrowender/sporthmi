/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetMaxLocalEntriesCommand
extends AbstractADBCommand {
    private final int limit;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$SetMaxLocalEntriesCommand;

    public SetMaxLocalEntriesCommand(ADBApplication aDBApplication, int n) {
        super(aDBApplication);
        this.limit = n;
    }

    public void execute() {
        this.logger.log(10000000, "SetMaxLocalEntriesCommand#execute()");
        boolean bl = this.adbDSIAccess.setMaxLocalEntries(this.limit);
        if (!bl) {
            this.logger.log(10000, "SetMaxLocalEntriesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void setMaxLocalEntriesResult(int n) {
        this.logger.log(10000000, "SetMaxLocalEntriesCommand#setMaxLocalEntriesResult(): %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetMaxLocalEntriesCommand(ADBApplication aDBApplication, int n) {
        SetMaxLocalEntriesCommand setMaxLocalEntriesCommand = new SetMaxLocalEntriesCommand(aDBApplication, n);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setMaxLocalEntriesCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$SetMaxLocalEntriesCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$SetMaxLocalEntriesCommand = SetMaxLocalEntriesCommand.class$("de.audi.app.addressbook.core.main.commands.init.SetMaxLocalEntriesCommand")) : class$de$audi$app$addressbook$core$main$commands$init$SetMaxLocalEntriesCommand).getName());
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

