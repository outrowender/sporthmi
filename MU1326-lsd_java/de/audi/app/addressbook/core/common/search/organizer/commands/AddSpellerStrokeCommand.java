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

public class AddSpellerStrokeCommand
extends AbstractADBCommand {
    private ADBOrganizerSearch adbSearch;
    private int currentSpellerHandle;
    private String stroke;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerStrokeCommand;

    public AddSpellerStrokeCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, String string) {
        super(aDBApplication);
        aDBOrganizerSearch.getSpellerModel().setStatus(0);
        this.adbSearch = aDBOrganizerSearch;
        this.currentSpellerHandle = n;
        this.stroke = string;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "AddSpellerStrokeCommand#execute()");
        boolean bl = this.adbDSIAccess.addSpellerStroke(this.currentSpellerHandle, this.stroke);
        if (!bl) {
            this.logger.log(10000, "AddSpellerStrokeCommand#execute(): dsi call was not successful, finishing command.");
            this.adbSearch.getSpellerModel().setStatus(2);
            this.commandList.commandFinished();
        }
    }

    @Override
    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.logger.log(-2137614336, "AddSpellerStrokeCommand#spellerResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.adbSearch.spellerResult(n2, dataSetArray, n3, string, string2);
            this.adbSearch.getSpellerModel().setStatus(1);
        } else {
            this.adbSearch.getSpellerModel().setStatus(2);
        }
        this.commandList.commandFinished();
    }

    public static void createAddSpellerStrokeCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, String string) {
        AddSpellerStrokeCommand addSpellerStrokeCommand = new AddSpellerStrokeCommand(aDBApplication, aDBOrganizerSearch, n, string);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(addSpellerStrokeCommand);
        commandList.execute((class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerStrokeCommand == null ? (class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerStrokeCommand = AddSpellerStrokeCommand.class$("de.audi.app.addressbook.core.common.search.organizer.commands.AddSpellerStrokeCommand")) : class$de$audi$app$addressbook$core$common$search$organizer$commands$AddSpellerStrokeCommand).getName());
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

