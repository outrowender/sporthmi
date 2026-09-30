/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.DataSet;

public class RemoveSpellerCharCommand
extends AbstractADBCommand {
    private ADBOrganizerSearch adbSearch;
    private int currentSpellerHandle;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$common$search$organizer$commands$RemoveSpellerCharCommand;

    public RemoveSpellerCharCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n) {
        super(aDBApplication);
        aDBOrganizerSearch.getSpellerModel().setStatus(0);
        this.adbSearch = aDBOrganizerSearch;
        this.currentSpellerHandle = n;
    }

    public void execute() {
        this.logger.log(10000000, "RemoveSpellerCharCommand#execute()");
        boolean bl = this.adbDSIAccess.removeSpellerChar(this.currentSpellerHandle);
        if (!bl) {
            this.logger.log(10000, "RemoveSpellerCharCommand#execute(): dsi call was not successful, finishing command.");
            this.adbSearch.getSpellerModel().setStatus(2);
            this.commandList.commandFinished();
        }
    }

    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.logger.log(10000000, "RemoveSpellerCharCommand#spellerResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.adbSearch.spellerResult(n2, dataSetArray, n3, string, string2);
            this.adbSearch.getSpellerModel().setStatus(1);
        } else {
            this.adbSearch.getSpellerModel().setStatus(2);
        }
        this.commandList.commandFinished();
    }

    public static void createRemoveSpellerCharCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n) {
        RemoveSpellerCharCommand removeSpellerCharCommand = new RemoveSpellerCharCommand(aDBApplication, aDBOrganizerSearch, n);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(removeSpellerCharCommand);
        commandList.execute((class$de$audi$app$addressbook$core$common$search$organizer$commands$RemoveSpellerCharCommand == null ? (class$de$audi$app$addressbook$core$common$search$organizer$commands$RemoveSpellerCharCommand = RemoveSpellerCharCommand.class$("de.audi.app.addressbook.core.common.search.organizer.commands.RemoveSpellerCharCommand")) : class$de$audi$app$addressbook$core$common$search$organizer$commands$RemoveSpellerCharCommand).getName());
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

