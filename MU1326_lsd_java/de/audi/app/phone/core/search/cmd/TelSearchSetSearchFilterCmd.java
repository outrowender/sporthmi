/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelSearchCmd;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.SearchFilter;

public class TelSearchSetSearchFilterCmd
extends AbstractTelSearchCmd {
    private final SearchFilter searchFilter;
    private final int source;

    public TelSearchSetSearchFilterCmd(LogChannel logChannel, DSISearch dSISearch, int n, SearchFilter searchFilter) {
        super(logChannel, "TelSearchSetSearchFilterCmd", dSISearch);
        this.searchFilter = searchFilter;
        this.source = n;
    }

    public void execute() {
        if (this.dsiSearch != null) {
            this.logger.log(1000000, "[TelSearchSetSearchFilterCmd#execute] searchFilter=%1, source=%2", (Object)this.searchFilter, (long)this.source);
            this.dsiSearch.setSearchFilter(this.source, this.searchFilter);
        } else {
            this.logger.log(100000, "[TelSearchSetSearchFilterCmd#execute] dsiSearch is null --> NOP!");
        }
    }

    public void setSearchFilterResult(int n, int n2) {
        this.logger.log(1000000, "[TelSearchSetSearchFilterCmd#setSearchFilterResult] success=%1, source=%2", (long)n, (long)n2);
        this.getCommandList().commandFinished();
    }
}

