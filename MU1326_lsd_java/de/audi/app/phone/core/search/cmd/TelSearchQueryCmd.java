/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelSearchCmd;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;
import de.audi.app.phone.core.search.cmd.TelSearchCancelQueryCmd;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import de.audi.tghu.command.CommandList;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.SearchResult;

public class TelSearchQueryCmd
extends AbstractTelSearchCmd {
    private static final int MAX_RESULTS = 100;
    private static int queryID;
    private volatile boolean active;
    private final ITelSearchQueryListener queryListener;
    private final SearchQuery query;
    private volatile boolean canceled;

    static SearchQuery getNextSearchQuery(int[] nArray, String string, int n) {
        SearchQuery searchQuery = new SearchQuery();
        searchQuery.queryId = ++queryID;
        searchQuery.sources = nArray;
        searchQuery.needle = string;
        searchQuery.offset = 0;
        searchQuery.count = 100;
        searchQuery.conflictMode = false;
        searchQuery.matchingMode = n;
        return searchQuery;
    }

    public TelSearchQueryCmd(LogChannel logChannel, DSISearch dSISearch, SearchQuery searchQuery, ITelSearchQueryListener iTelSearchQueryListener) {
        super(logChannel, "TelSearchQueryCmd", dSISearch);
        this.queryListener = iTelSearchQueryListener;
        this.query = searchQuery;
    }

    public TelSearchQueryCmd(LogChannel logChannel, DSISearch dSISearch, TelSearchQueryCmd telSearchQueryCmd) {
        super(logChannel, "TelSearchQueryCmd", dSISearch);
        this.queryListener = telSearchQueryCmd.queryListener;
        this.query = TelSearchQueryCmd.getNextSearchQuery(telSearchQueryCmd.query.getSources(), telSearchQueryCmd.query.getNeedle(), telSearchQueryCmd.query.getMatchingMode());
    }

    public void execute() {
        if (this.dsiSearch != null) {
            this.logger.log(1000000, "[TelSearchQueryCmd#execute] query=%1", (Object)this.query);
            this.dsiSearch.search(this.query);
        } else {
            this.logger.log(100000, "[TelSearchQueryCmd#execute] DSISearch is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    public void updateSearchIsActive(int n, boolean bl, int n2) {
        if (bl) {
            this.logger.log(1000000, "[TelSearchQueryCmd#updateSearchIsActive] queryID=%1, search is started", (long)queryID);
            this.active = true;
            this.queryListener.searchStarted(queryID);
        } else if (this.active) {
            this.logger.log(1000000, "[TelSearchQueryCmd#updateSearchIsActive] queryID=%1, search is finished", (long)queryID);
            this.active = false;
            this.queryListener.searchEnded(queryID);
            this.getCommandList().commandFinished();
        }
    }

    public void searchResult(int n, SearchResult searchResult) {
        if (!this.canceled) {
            this.logger.log(1000000, "[TelSearchQueryCmd#searchResult] success=%2, searchResult=%1", (Object)searchResult, (long)n);
            this.queryListener.updateSearchResult(queryID, searchResult);
        }
    }

    public void invalidateData(int[] nArray) {
        boolean bl = false;
        if (nArray != null) {
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                int[] nArray2 = this.query.getSources();
                for (int i3 = 0; i3 < nArray2.length; ++i3) {
                    if (nArray[i2] != nArray2[i3]) continue;
                    bl = true;
                }
            }
        }
        if (bl) {
            this.logger.log(1000000, "[TelSearchQueryCmd#invalidateData] queryID=%2, sources=%1", (Object)Converter.intArrayToString(nArray), (long)queryID);
            this.queryListener.dataInvalidated(queryID, nArray);
            CommandList commandList = new CommandList(this.getCommandList().getManager());
            commandList.add(new TelSearchCancelQueryCmd(this.logger, this.dsiSearch, queryID, this.queryListener));
            commandList.add(new TelSearchQueryCmd(this.logger, this.dsiSearch, this));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }

    public void setCancel() {
        this.logger.log(1000000, "[TelSearchQueryCmd#setCancel]");
        this.canceled = true;
    }

    protected Command canceled() {
        if (this.canceled) {
            return new TelSearchCancelQueryCmd(this.logger, this.dsiSearch, queryID, this.queryListener);
        }
        return null;
    }
}

