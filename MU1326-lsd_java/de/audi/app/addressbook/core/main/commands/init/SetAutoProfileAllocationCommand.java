/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetAutoProfileAllocationCommand
extends AbstractADBCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$SetAutoProfileAllocationCommand;

    public SetAutoProfileAllocationCommand(ADBApplication aDBApplication) {
        super(aDBApplication);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SetAutoProfileAllocationCommand#execute()");
        boolean bl = this.adbDSIAccess.setAutoProfileAllocation(true);
        if (!bl) {
            this.logger.log(10000, "SetAutoProfileAllocationCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setAutoProfileAllocationResult(int n) {
        this.logger.log(-2137614336, "SetAutoProfileAllocationCommand#setAutoProfileAllocationResult(): %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetAutoProfileAllocationCommand(ADBApplication aDBApplication) {
        SetAutoProfileAllocationCommand setAutoProfileAllocationCommand = new SetAutoProfileAllocationCommand(aDBApplication);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setAutoProfileAllocationCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$SetAutoProfileAllocationCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$SetAutoProfileAllocationCommand = SetAutoProfileAllocationCommand.class$("de.audi.app.addressbook.core.main.commands.init.SetAutoProfileAllocationCommand")) : class$de$audi$app$addressbook$core$main$commands$init$SetAutoProfileAllocationCommand).getName());
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

