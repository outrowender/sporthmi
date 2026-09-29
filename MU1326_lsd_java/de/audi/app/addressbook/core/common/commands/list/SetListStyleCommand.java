/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.commands.list;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetListStyleCommand
extends AbstractADBCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$common$commands$list$SetListStyleCommand;

    public SetListStyleCommand(ADBApplication aDBApplication) {
        super(aDBApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SetListStyleCommand#execute()");
        boolean bl = this.adbDSIAccess.setListStyle(0, 1, 0);
        if (!bl) {
            this.logger.log(10000, "SetListStyleCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setListStyleResult(int n) {
        this.logger.log(-2137614336, "SetListStyleCommand#setListStyleResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetListStyleCommand(ADBApplication aDBApplication) {
        SetListStyleCommand setListStyleCommand = new SetListStyleCommand(aDBApplication);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setListStyleCommand);
        commandList.execute((class$de$audi$app$addressbook$core$common$commands$list$SetListStyleCommand == null ? (class$de$audi$app$addressbook$core$common$commands$list$SetListStyleCommand = SetListStyleCommand.class$("de.audi.app.addressbook.core.common.commands.list.SetListStyleCommand")) : class$de$audi$app$addressbook$core$common$commands$list$SetListStyleCommand).getName());
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

