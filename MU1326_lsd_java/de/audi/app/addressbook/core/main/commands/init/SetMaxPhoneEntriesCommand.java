/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetMaxPhoneEntriesCommand
extends AbstractADBCommand {
    private final int limit;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$SetMaxPhoneEntriesCommand;

    public SetMaxPhoneEntriesCommand(ADBApplication aDBApplication, int n) {
        super(aDBApplication);
        this.limit = n;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SetMaxPhoneEntriesCommand#execute()");
        boolean bl = this.adbDSIAccess.setMaxPhoneEntries(this.limit);
        if (!bl) {
            this.logger.log(10000, "SetMaxPhoneEntriesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setMaxPhoneEntriesResult(int n) {
        this.logger.log(-2137614336, "SetMaxPhoneEntriesCommand#setMaxPhoneEntriesResult(): %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetMaxPhoneEntriesCommand(ADBApplication aDBApplication, int n) {
        SetMaxPhoneEntriesCommand setMaxPhoneEntriesCommand = new SetMaxPhoneEntriesCommand(aDBApplication, n);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setMaxPhoneEntriesCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$SetMaxPhoneEntriesCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$SetMaxPhoneEntriesCommand = SetMaxPhoneEntriesCommand.class$("de.audi.app.addressbook.core.main.commands.init.SetMaxPhoneEntriesCommand")) : class$de$audi$app$addressbook$core$main$commands$init$SetMaxPhoneEntriesCommand).getName());
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

