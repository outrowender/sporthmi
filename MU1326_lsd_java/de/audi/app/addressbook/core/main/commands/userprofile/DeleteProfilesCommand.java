/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.userprofile;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.tghu.command.CommandList;

public class DeleteProfilesCommand
extends AbstractADBCommand {
    private int[] profileNums;
    private HMIModelApp syncModel;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$userprofile$DeleteProfilesCommand;

    public DeleteProfilesCommand(ADBApplication aDBApplication, int[] nArray, HMIModelApp hMIModelApp) {
        super(aDBApplication);
        this.profileNums = nArray;
        this.syncModel = hMIModelApp;
    }

    public void execute() {
        this.logger.log(1000000, "DeleteProfilesCommand#execute(): profileNums: %1", (Object)ADBDbgUtils.dbg(this.profileNums));
        boolean bl = this.adbDSIAccess.deleteProfiles(this.profileNums);
        if (!bl) {
            this.logger.log(10000, "DeleteProfilesCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void deleteProfilesResult(int n) {
        this.logger.log(1000000, "DeleteProfilesCommand#deleteProfilesResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.syncModel.setStatus(1);
        this.commandList.commandFinished();
    }

    public static void createDeleteProfilesCommand(ADBApplication aDBApplication, int[] nArray, HMIModelApp hMIModelApp) {
        hMIModelApp.setStatus(0);
        DeleteProfilesCommand deleteProfilesCommand = new DeleteProfilesCommand(aDBApplication, nArray, hMIModelApp);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(deleteProfilesCommand);
        commandList.execute((class$de$audi$app$addressbook$core$main$commands$userprofile$DeleteProfilesCommand == null ? (class$de$audi$app$addressbook$core$main$commands$userprofile$DeleteProfilesCommand = DeleteProfilesCommand.class$("de.audi.app.addressbook.core.main.commands.userprofile.DeleteProfilesCommand")) : class$de$audi$app$addressbook$core$main$commands$userprofile$DeleteProfilesCommand).getName());
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

