/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common.search.organizer.commands;

import de.audi.app.addressbook.core.common.ADBApplication;
import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.commands.AbstractADBCommand;
import de.audi.app.addressbook.core.common.search.organizer.ADBOrganizerSearch;

public class StopSpellerCommand
extends AbstractADBCommand {
    private ADBOrganizerSearch adbSearch;

    protected StopSpellerCommand(ADBApplication aDBApplication, ADBOrganizerSearch aDBOrganizerSearch) {
        super(aDBApplication);
        this.adbSearch = aDBOrganizerSearch;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "StopSpellerCommand#execute()");
        int n = this.adbSearch.getCurrentSpellerHandle();
        if (n != -1) {
            this.logger.log(1078071040, "StopSpellerCommand#execute(): stopping speller with spellerHandle %1.", (long)n);
            boolean bl = this.adbDSIAccess.stopSpeller(n);
            if (!bl) {
                this.logger.log(10000, "StopSpellerCommand#execute(): dsi call was not successful, finishing command.");
                this.commandList.commandFinished();
            }
        } else {
            this.logger.log(1078071040, "StopSpellerCommand#execute(): nothing to do, no speller active currently.");
            this.commandList.commandFinished();
        }
    }

    @Override
    public void stopSpellerResult(int n, int n2) {
        this.logger.log(1078071040, "StopSpellerCommand#stopSpellerResult(): success: %1, spellerHandle: %2", (Object)ADBDbgUtils.dbgSuccessFlag(n), (long)n2);
        this.commandList.commandFinished();
    }
}

