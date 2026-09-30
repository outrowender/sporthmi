/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.atip.hmi.model.HMIModel;
import de.audi.tghu.command.CommandList;

public class ValidateSpellerCharsCommand
extends AbstractADBCommand {
    private ADBOrganizerSearch adbSearch;
    private int spellerHandle;
    private String characters;
    private HMIModel syncModel;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$common$search$organizer$commands$ValidateSpellerCharsCommand;

    public ValidateSpellerCharsCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, String string, HMIModel hMIModel) {
        super(aDBApplication);
        this.adbSearch = aDBOrganizerSearch;
        this.spellerHandle = n;
        this.characters = string;
        this.syncModel = hMIModel;
    }

    public void execute() {
        this.logger.log(10000000, "ValidateSpellerCharsCommand#execute()");
        boolean bl = this.adbDSIAccess.validateSpellerChars(this.spellerHandle, this.characters);
        if (!bl) {
            this.logger.log(10000, "ValidateSpellerCharsCommand#execute(): dsi call was not successful, finishing command.");
            this.commandList.commandFinished();
        }
    }

    public void validateSpellerCharsResult(int n, int n2, String string, String string2) {
        this.logger.log(10000000, "ValidateSpellerCharsCommand#validateSpellerCharsResult(): validChars: %1, success: %2", (Object)string2, (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.adbSearch.validateSpellerCharsResult(string2);
        }
        this.syncModel.setStatus(1);
        this.commandList.commandFinished();
    }

    public static void createValidateSpellerCharsCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, String string, HMIModel hMIModel) {
        hMIModel.setStatus(0);
        ValidateSpellerCharsCommand validateSpellerCharsCommand = new ValidateSpellerCharsCommand(aDBApplication, aDBOrganizerSearch, n, string, hMIModel);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(validateSpellerCharsCommand);
        commandList.execute((class$de$audi$app$addressbook$core$common$search$organizer$commands$ValidateSpellerCharsCommand == null ? (class$de$audi$app$addressbook$core$common$search$organizer$commands$ValidateSpellerCharsCommand = ValidateSpellerCharsCommand.class$("de.audi.app.addressbook.core.common.search.organizer.commands.ValidateSpellerCharsCommand")) : class$de$audi$app$addressbook$core$common$search$organizer$commands$ValidateSpellerCharsCommand).getName());
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

