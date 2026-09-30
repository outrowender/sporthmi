/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetDefaultSortOrderCommand
extends AbstractADBCommand {
    private int defaultSortOrder;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$SetDefaultSortOrderCommand;

    public SetDefaultSortOrderCommand(ADBApplication aDBApplication, int n) {
        super(aDBApplication);
        this.defaultSortOrder = n;
    }

    public void execute() {
        this.logger.log(10000000, "SetDefaultSortOrderCommand#execute(): defaultSortOrder: %1", (Object)ADBDbgUtils.dbgSortOrder(this.defaultSortOrder));
        boolean bl = this.adbDSIAccess.setDefaultSortOrder(this.defaultSortOrder);
        if (!bl) {
            this.logger.log(10000, "SetDefaultSortOrderCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void setDefaultSortOrderResult(int n) {
        this.logger.log(10000000, "SetDefaultSortOrderCommand#setDefaultSortOrderResult(): %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetDefaultSortOrderCommand(ADBApplication aDBApplication, int n) {
        SetDefaultSortOrderCommand setDefaultSortOrderCommand = new SetDefaultSortOrderCommand(aDBApplication, n);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setDefaultSortOrderCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$SetDefaultSortOrderCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$SetDefaultSortOrderCommand = SetDefaultSortOrderCommand.class$("de.audi.app.addressbook.core.main.commands.init.SetDefaultSortOrderCommand")) : class$de$audi$app$addressbook$core$main$commands$init$SetDefaultSortOrderCommand).getName());
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

