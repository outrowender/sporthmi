/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.setup;

import de.audi.app.addressbook.core.combi.bap.commands.GetCombiViewSizeCommand;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.tghu.command.CommandList;

public class SetSortOrderCommand
extends AbstractADBCommand {
    private final int dsiSortOrder;
    private final AbstractAddressBookApplication appAdr;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$setup$SetSortOrderCommand;

    public SetSortOrderCommand(AbstractAddressBookApplication abstractAddressBookApplication, int n) {
        super(abstractAddressBookApplication);
        this.appAdr = abstractAddressBookApplication;
        this.dsiSortOrder = n;
    }

    public void execute() {
        this.logger.log(10000000, "SetSortOrderCommand#execute()");
        boolean bl = this.adbDSIAccess.setSortOrder(this.dsiSortOrder);
        if (!bl) {
            this.logger.log(10000, "SetSortOrderCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void setSortOrderResult(int n) {
        this.logger.log(10000000, "SetSortOrderCommand#setSortOrderResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        GetCombiViewSizeCommand.createGetCombiViewSizeCommand(this.appAdr.getCombiAdbHandler(), true, true);
        this.commandList.commandFinished();
    }

    public static void createSetSortOrderCommand(AbstractAddressBookApplication abstractAddressBookApplication, int n) {
        SetSortOrderCommand setSortOrderCommand = new SetSortOrderCommand(abstractAddressBookApplication, n);
        CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
        commandList.add(setSortOrderCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$setup$SetSortOrderCommand == null ? (class$de$audi$app$addressbook$core$main$commands$setup$SetSortOrderCommand = SetSortOrderCommand.class$("de.audi.app.addressbook.core.main.commands.setup.SetSortOrderCommand")) : class$de$audi$app$addressbook$core$main$commands$setup$SetSortOrderCommand).getName());
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

