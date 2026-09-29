/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.setup;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetContextSpecificVisibilityCommand
extends AbstractADBCommand {
    private boolean showOnlyUsableContacts;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$setup$SetContextSpecificVisibilityCommand;

    public SetContextSpecificVisibilityCommand(ADBApplication aDBApplication, boolean bl) {
        super(aDBApplication);
        this.showOnlyUsableContacts = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SetContextSpecificVisibilityCommand#execute()");
        boolean bl = this.adbDSIAccess.setContextSpecificVisibility(this.showOnlyUsableContacts);
        if (!bl) {
            this.logger.log(10000, "SetContextSpecificVisibilityCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setContextSpecificVisibilityResult(int n) {
        this.logger.log(-2137614336, "SetContextSpecificVisibilityCommand#setContextSpecificVisibilityResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetContextSpecificVisibilityCommand(ADBApplication aDBApplication, boolean bl) {
        SetContextSpecificVisibilityCommand setContextSpecificVisibilityCommand = new SetContextSpecificVisibilityCommand(aDBApplication, bl);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setContextSpecificVisibilityCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$setup$SetContextSpecificVisibilityCommand == null ? (class$de$audi$app$addressbook$core$main$commands$setup$SetContextSpecificVisibilityCommand = SetContextSpecificVisibilityCommand.class$("de.audi.app.addressbook.core.main.commands.setup.SetContextSpecificVisibilityCommand")) : class$de$audi$app$addressbook$core$main$commands$setup$SetContextSpecificVisibilityCommand).getName());
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

