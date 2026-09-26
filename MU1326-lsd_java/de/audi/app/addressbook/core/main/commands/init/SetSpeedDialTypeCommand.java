/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.init;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.tghu.command.CommandList;

public class SetSpeedDialTypeCommand
extends AbstractADBCommand {
    private int speedDialType;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$init$SetSpeedDialTypeCommand;

    public SetSpeedDialTypeCommand(ADBApplication aDBApplication, int n) {
        super(aDBApplication);
        this.speedDialType = n;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "SetSpeedDialTypeCommand#execute()");
        boolean bl = this.adbDSIAccess.setSpeedDialType(this.speedDialType);
        if (!bl) {
            this.logger.log(10000, "SetSpeedDialTypeCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void setSpeedDialTypeResult(int n) {
        this.logger.log(1078071040, "SetSpeedDialTypeCommand#setSpeedDialTypeResult(): %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createSetSpeedDialTypeCommand(ADBApplication aDBApplication, int n) {
        SetSpeedDialTypeCommand setSpeedDialTypeCommand = new SetSpeedDialTypeCommand(aDBApplication, n);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(setSpeedDialTypeCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$init$SetSpeedDialTypeCommand == null ? (class$de$audi$app$addressbook$core$main$commands$init$SetSpeedDialTypeCommand = SetSpeedDialTypeCommand.class$("de.audi.app.addressbook.core.main.commands.init.SetSpeedDialTypeCommand")) : class$de$audi$app$addressbook$core$main$commands$init$SetSpeedDialTypeCommand).getName());
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

