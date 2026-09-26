/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;
import de.audi.app.addressbook.core.common.search.organizer.commands.StopSpellerCommand;
import de.audi.tghu.command.CommandList;
import org.dsi.ifc.organizer.DataSet;

public class StartSpellerCommand
extends AbstractADBCommand {
    private static final String START_SPELLER_COMMAND_LIST_NAME;
    private ADBOrganizerSearch adbSearch;
    private int viewType;
    private int listSize;
    private int searchMode;

    public StartSpellerCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, int n2, int n3) {
        super(aDBApplication);
        aDBOrganizerSearch.getSpellerModel().setStatus(0);
        aDBOrganizerSearch.getListSyncModel().setStatus(0);
        this.adbSearch = aDBOrganizerSearch;
        this.viewType = n;
        this.listSize = n2;
        this.searchMode = n3;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "StartSpellerCommand#execute()");
        boolean bl = this.adbDSIAccess.startSpeller(this.viewType, this.listSize, this.searchMode);
        if (!bl) {
            this.logger.log(10000, "StartSpellerCommand#execute(): dsi call was not successful, finishing command.");
            this.adbSearch.getSpellerModel().setStatus(2);
            this.adbSearch.getListSyncModel().setStatus(2);
            this.commandList.commandFinished();
        }
    }

    @Override
    public void spellerResult(int n, int n2, DataSet[] dataSetArray, int n3, String string, String string2) {
        this.logger.log(1078071040, "StartSpellerCommand#spellerResult(): success: %1, spellerHandle: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (long)n2);
        if (n == 0) {
            this.adbSearch.spellerResult(n2, dataSetArray, n3, string, string2);
            this.adbSearch.getSpellerModel().setStatus(1);
        } else {
            this.adbSearch.getSpellerModel().setStatus(2);
            this.adbSearch.getListSyncModel().setStatus(2);
        }
        this.commandList.commandFinished();
    }

    public static void createStartSpellerCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch, int n, int n2, int n3) {
        CommandList commandList = new CommandList(aDBApplication.getCommandListManager());
        StopSpellerCommand stopSpellerCommand = new StopSpellerCommand(aDBApplication, aDBOrganizerSearch);
        commandList.add(stopSpellerCommand);
        StartSpellerCommand startSpellerCommand = new StartSpellerCommand(aDBApplication, aDBOrganizerSearch, n, n2, n3);
        commandList.add(startSpellerCommand);
        commandList.execute("StartSpellerCommandList");
    }
}

