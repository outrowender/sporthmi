/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.search.cmd.AbstractTelSearchCmd;
import de.audi.app.phone.core.search.cmd.ITelSearchRequestSuggestionListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Converter;
import org.dsi.ifc.search.DSISearch;
import org.dsi.ifc.search.SearchQuery;
import org.dsi.ifc.search.Suggestion;

public class TelSearchRequestSuggestionCommand
extends AbstractTelSearchCmd {
    private final ITelSearchRequestSuggestionListener listener;
    private final SearchQuery query;

    public TelSearchRequestSuggestionCommand(LogChannel logChannel, DSISearch dSISearch, SearchQuery searchQuery, ITelSearchRequestSuggestionListener iTelSearchRequestSuggestionListener) {
        super(logChannel, "TelSearchRequestSuggestionCommand", dSISearch);
        this.listener = iTelSearchRequestSuggestionListener;
        this.query = searchQuery;
    }

    public void execute() {
        if (this.dsiSearch != null) {
            this.logger.log(1000000, "[TelSearchRequestSuggestionCommand#execute] query=%1", (Object)this.query);
            this.dsiSearch.requestSuggestion(this.query);
        } else {
            this.logger.log(100000, "[TelSearchRequestSuggestionCommand#execute] DSISearch is null --> NOP!");
            this.getCommandList().commandFinished();
        }
    }

    public void requestSuggestionResult(int n, Suggestion[] suggestionArray) {
        this.logger.log(1000000, "[TelSearchRequestSuggestionCommand#requestSuggestionResult] success=%2, suggestions=%1", (Object)Converter.array2String(suggestionArray), (long)n);
        this.listener.updateSuggestion(suggestionArray);
        this.getCommandList().commandFinished();
    }
}

