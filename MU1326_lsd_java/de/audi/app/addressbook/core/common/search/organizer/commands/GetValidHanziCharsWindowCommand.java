/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.tghu.command.CommandList;

public class GetValidHanziCharsWindowCommand
extends AbstractADBCommand {
    private ADBOrganizerSearch adbSearch;
    private int currentSpellerHandle;
    private int offset;
    private int windowSize;
    static /* synthetic */ Class class$de$audi$app$addressbook$core$common$search$organizer$commands$GetValidHanziCharsWindowCommand;

    public GetValidHanziCharsWindowCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, int n2, int n3) {
        super(aDBApplication);
        aDBOrganizerSearch.getSpellerModel().setStatus(0);
        this.adbSearch = aDBOrganizerSearch;
        this.currentSpellerHandle = n;
        this.offset = n2;
        this.windowSize = n3;
    }

    public void execute() {
        this.logger.log(10000000, "GetValidHanziCharsWindowCommand#execute()");
        boolean bl = this.adbDSIAccess.getValidHanziCharsWindow(this.currentSpellerHandle, this.offset, this.windowSize);
        if (!bl) {
            this.logger.log(10000, "GetValidHanziCharsWindowCommand#execute(): dsi call was not successful, finishing command.");
            this.adbSearch.getSpellerModel().setStatus(2);
            this.commandList.commandFinished();
        }
    }

    public void getValidHanziCharsWindowResult(int n, int n2, int n3, String string, int n4) {
        this.logger.log(10000000, "GetValidHanziCharsWindowCommand#getValidHanziCharsWindowResult(): success: %1", (Object)ADBDbgUtils.dbgSuccessFlag(n));
        if (n == 0) {
            this.adbSearch.setValidHanziChars(string, n4);
            this.adbSearch.getSpellerModel().setStatus(1);
        } else {
            this.adbSearch.getSpellerModel().setStatus(2);
        }
        this.commandList.commandFinished();
    }

    public static void createGetValidHanziCharsWindowCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, int n2, int n3) {
        GetValidHanziCharsWindowCommand getValidHanziCharsWindowCommand = new GetValidHanziCharsWindowCommand(aDBApplication, aDBOrganizerSearch, n, n2, n3);
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        commandList.add(getValidHanziCharsWindowCommand);
        commandList.execute((class$de$audi$app$addressbook$core$common$search$organizer$commands$GetValidHanziCharsWindowCommand == null ? (class$de$audi$app$addressbook$core$common$search$organizer$commands$GetValidHanziCharsWindowCommand = GetValidHanziCharsWindowCommand.class$("de.audi.app.addressbook.core.common.search.organizer.commands.GetValidHanziCharsWindowCommand")) : class$de$audi$app$addressbook$core$common$search$organizer$commands$GetValidHanziCharsWindowCommand).getName());
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

