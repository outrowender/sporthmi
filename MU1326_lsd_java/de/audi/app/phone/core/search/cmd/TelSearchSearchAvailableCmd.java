/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelSearchCmd;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.DSISearch;

public class TelSearchSearchAvailableCmd
extends AbstractTelSearchCmd {
    private final ChoiceModelApp searchAvailableChoice;

    public TelSearchSearchAvailableCmd(LogChannel logChannel, DSISearch dSISearch, ChoiceModelApp choiceModelApp) {
        super(logChannel, "TelSearchSearchAvailableCmd", dSISearch);
        this.searchAvailableChoice = choiceModelApp;
    }

    public void execute() {
        int n = this.dsiSearch != null ? 1 : 0;
        this.logger.log(1000000, "[TelSearchSearchAvailableCmd#execute] available=%1", n == 1);
        if (this.searchAvailableChoice != null) {
            this.searchAvailableChoice.setValue(n);
        } else {
            this.logger.log(100000, "[TelSearchSearchAvailableCmd#execute] searchAvailableChoice is null --> NOP!");
        }
        this.getCommandList().commandFinished();
    }
}

