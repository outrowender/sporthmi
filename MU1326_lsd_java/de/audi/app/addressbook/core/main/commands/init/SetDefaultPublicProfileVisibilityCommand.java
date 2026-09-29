/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetDefaultPublicProfileVisibilityCommand
extends AbstractADBCommand {
    private boolean defaultPublicProfileVisibility;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$SetDefaultPublicProfileVisibilityCommand;

    public SetDefaultPublicProfileVisibilityCommand(ADBApplication aDBApplication, boolean bl) {
        super(aDBApplication);
        this.defaultPublicProfileVisibility = bl;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "SetDefaultPublicProfileVisibilityCommand#execute()");
        boolean bl = this.adbDSIAccess.setDefaultPublicProfileVisibility(this.defaultPublicProfileVisibility);
        if (!bl) {
            this.logger.log(10000, "SetDefaultPublicProfileVisibilityCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setDefaultPublicProfileVisibilityResult(int n) {
        this.logger.log(-2137614336, "SetDefaultPublicProfileVisibilityCommand#setDefaultPublicProfileVisibilityResult(): %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetDefaultPublicProfileVisibilityCommand(ADBApplication aDBApplication, boolean bl) {
        SetDefaultPublicProfileVisibilityCommand setDefaultPublicProfileVisibilityCommand = new SetDefaultPublicProfileVisibilityCommand(aDBApplication, bl);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setDefaultPublicProfileVisibilityCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$SetDefaultPublicProfileVisibilityCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$SetDefaultPublicProfileVisibilityCommand = SetDefaultPublicProfileVisibilityCommand.class$("de.audi.app.addressbook.core.main.commands.init.SetDefaultPublicProfileVisibilityCommand")) : class$de$audi$app$addressbook$core$main$commands$init$SetDefaultPublicProfileVisibilityCommand).getName());
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

