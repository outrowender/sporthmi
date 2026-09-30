/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.main.commands.userprofile;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.main.AbstractAddressBookApplication;
import de.audi.tghu.command.CommandList;

public class RestartDownloadCommand
extends AbstractADBCommand {
    static /* synthetic */ Class class$de$audi$app$addressbook$core$main$commands$userprofile$RestartDownloadCommand;

    public RestartDownloadCommand(ADBApplication aDBApplication) {
        super(aDBApplication);
    }

    public void execute() {
        this.logger.log(1000000, "RestartDownloadCommand#execute()");
        boolean bl = this.adbDSIAccess.restartDownload();
        if (!bl) {
            this.logger.log(10000, "RestartDownloadCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void restartDownloadResult(int n) {
        this.logger.log(1000000, "RestartDownloadCommand#restartDownloadResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        this.commandList.commandFinished();
    }

    public static void createRestartDownloadCommand(AbstractAddressBookApplication abstractAddressBookApplication) {
        if (abstractAddressBookApplication.getHMIService().getChoiceModel(700444).getValue() == 1 && abstractAddressBookApplication.getHMIService().getChoiceModel(14).getStatus() == 1) {
            abstractAddressBookApplication.getUserProfileUpdater().resetDownloadProgress();
            RestartDownloadCommand restartDownloadCommand = new RestartDownloadCommand(abstractAddressBookApplication);
            CommandList commandList = new CommandList(abstractAddressBookApplication.getCommandListManager());
            commandList.add(restartDownloadCommand);
            commandList.execute((class$de$audi$app$addressbook$core$main$commands$userprofile$RestartDownloadCommand == null ? (class$de$audi$app$addressbook$core$main$commands$userprofile$RestartDownloadCommand = RestartDownloadCommand.class$("de.audi.app.addressbook.core.main.commands.userprofile.RestartDownloadCommand")) : class$de$audi$app$addressbook$core$main$commands$userprofile$RestartDownloadCommand).getName());
        } else {
            abstractAddressBookApplication.getLog().log(1000000, "RestartDownloadCommand#createRestartDownloadCommand(): no device connected or download already active, not restarting download.");
        }
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

