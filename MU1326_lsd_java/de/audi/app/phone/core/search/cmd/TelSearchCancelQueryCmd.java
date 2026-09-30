/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelSearchCmd;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.DSISearch;

public class TelSearchCancelQueryCmd
extends AbstractTelSearchCmd {
    private final int queryID;
    private final ITelSearchQueryListener listener;

    public TelSearchCancelQueryCmd(LogChannel logChannel, DSISearch dSISearch, int n, ITelSearchQueryListener iTelSearchQueryListener) {
        super(logChannel, "TelSearchCancelQueryCmd", dSISearch);
        this.queryID = n;
        this.listener = iTelSearchQueryListener;
    }

    public void execute() {
        if (this.dsiSearch != null) {
            this.logger.log(1000000, "[TelSearchCancelQueryCmd#execute] canceling query %1", (long)this.queryID);
            this.dsiSearch.cancelQuery(this.queryID);
        } else {
            this.logger.log(100000, "[TelSearchCancelQueryCmd#execute] DSISearch is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    public void updateSearchIsActive(int n, boolean bl, int n2) {
        this.logger.log(100000, "[TelSearchQueryCmd#updateSearchIsActive] queryID=%2, isActive=%1", (Object)String.valueOf(bl), (long)this.queryID);
    }

    public void cancelQueryResult(int n, int n2) {
        this.logger.log(1000000, "[TelSearchQueryCmd.TelSearchCancelQueryCmd#cancelQueryResult] queryID=%1, success=%2", (long)this.queryID, (long)n2);
        this.listener.searchCanceled(this.queryID);
        this.getCommandList().commandFinished();
    }
}

