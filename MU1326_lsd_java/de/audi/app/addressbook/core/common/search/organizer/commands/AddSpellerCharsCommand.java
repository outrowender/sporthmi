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

public class AddSpellerCharsCommand
extends AbstractADBCommand {
    private ADBOrganizerSearch adbSearch;
    private int currentSpellerHandle;
    private String characters;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerCharsCommand;

    public AddSpellerCharsCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, String string) {
        super(aDBApplication);
        aDBOrganizerSearch.getSpellerModel().setStatus(0);
        this.adbSearch = aDBOrganizerSearch;
        this.currentSpellerHandle = n;
        this.characters = string;
    }

    public void execute() {
        this.logger.log(10000000, "AddSpellerCharsCommand#execute()");
        boolean bl = this.adbDSIAccess.addSpellerChars(this.currentSpellerHandle, this.characters);
        if (!bl) {
            this.logger.log(10000, "AddSpellerCharsCommand#execute(): dsi call was not successful, finishing command.");
            this.adbSearch.getSpellerModel().setStatus(2);
            this.commandList.commandFinished();
        }
    }

    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.logger.log(10000000, "AddSpellerCharsCommand#spellerResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.adbSearch.spellerResult(n2, dataSetArray, n3, string, string2);
            this.adbSearch.getSpellerModel().setStatus(1);
        } else {
            this.adbSearch.getSpellerModel().setStatus(2);
        }
        this.commandList.commandFinished();
    }

    public static void createAddSpellerCharsCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, String string) {
        AddSpellerCharsCommand addSpellerCharsCommand = new AddSpellerCharsCommand(aDBApplication, aDBOrganizerSearch, n, string);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(addSpellerCharsCommand);
        commandList.execute((class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerCharsCommand == null ? (class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerCharsCommand = AddSpellerCharsCommand.class$("de.audi.app.addressbook.core.common.search.organizer.commands.AddSpellerCharsCommand")) : class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerCharsCommand).getName());
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

