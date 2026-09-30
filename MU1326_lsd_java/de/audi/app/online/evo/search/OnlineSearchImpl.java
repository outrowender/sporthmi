/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.search;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.remotehmi.ui.mib2.grid.IGridList;
import de.audi.tghu.online.app.remotehmi.search.ISearchListener;
import de.audi.tghu.online.app.remotehmi.search.ITruffleSearchHandler;
import org.dsi.ifc.search.ConflictMatch;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;
import org.osgi.framework.BundleContext;

public class OnlineSearchImpl
extends AbstractSearch
implements ITruffleSearchHandler {
    private static String LOGCLASS = (class$de$audi$app$online$evo$search$OnlineSearchImpl == null ? (class$de$audi$app$online$evo$search$OnlineSearchImpl = OnlineSearchImpl.class$("de.audi.app.online.evo.search.OnlineSearchImpl")) : class$de$audi$app$online$evo$search$OnlineSearchImpl).getName();
    protected ISearchListener searchListener;
    private Suggestion currentSuggestion;
    static /* synthetic */ Class class$de$audi$app$online$evo$search$OnlineSearchImpl;

    public OnlineSearchImpl(BundleContext bundleContext, IFrameworkAccess iFrameworkAccess, LogChannel logChannel, int n) {
        super(bundleContext, iFrameworkAccess, logChannel, n);
    }

    public void init() {
        this.logChannel.log(1000000, "OnlineSearchImpl#init: Called");
        this.startDSI();
    }

    public void deinit() {
        this.logChannel.log(1000000, "OnlineSearchImpl#deinit: Called", (Object)LOGCLASS);
        this.stopDSI();
    }

    public void setSearchListener(ISearchListener iSearchListener) {
        this.searchListener = iSearchListener;
    }

    public void performQuery(String string, IGridList iGridList, ISearchListener iSearchListener) {
        this.searchListener = iSearchListener;
        this.currentSuggestion = null;
        iGridList.deleteGridHighlight();
        if (string.length() > 0) {
            iGridList.setGridsVisible(false);
            super.performQuery(string);
        } else {
            iGridList.restoreInitialGridVisibility();
        }
        iGridList.correctCurrentCursor();
        this.logChannel.log(10000000, "OnlineSearchImpl#performQuery %1", (Object)string);
    }

    public void requestSuggestionResult(int n, Suggestion[] suggestionArray) {
        this.logChannel.log(1000000, "OnlineSearchImpl#requestSuggestionResult # result=%1 suggestion length = %2", (long)n, (long)suggestionArray.length);
        for (int i2 = 0; i2 < suggestionArray.length; ++i2) {
            Suggestion suggestion = suggestionArray[i2];
            this.logChannel.log(1000000, "OnlineSearchImpl#requestSuggestionResult:%1 query: %2 sugg: %3 full: %4", (Object)new Integer(i2), (Object)suggestion.getQuery(), (Object)suggestion.getSuggestion(), (Object)suggestion.getFullSuggestion());
        }
    }

    public void searchResult(int n, SearchResult searchResult) {
        if (searchResult.entryType == 17) {
            Suggestion suggestion;
            this.logChannel.log(1000000, "OnlineSearchImpl#searchResult() count: %1 queryID: %2", (long)searchResult.tokens.length, (long)searchResult.queryId);
            super.searchResult(n, searchResult);
            if (this.searchListener == null || searchResult.getQueryId() != this.getLastQueryID()) {
                this.logChannel.log(1000000, "OnlineSearchImpl#searchResult() no search Listener or same query id (last QueryID: %1 ", (long)this.getLastQueryID());
                return;
            }
            if (this.currentSuggestion == null && (suggestion = searchResult.suggestion) != null) {
                String string = searchResult.suggestion.fullSuggestion;
                this.logChannel.log(1000000, "OnlineSearchImpl#searchResult() suggestion query: %1, suggestion: %2 extractedSuggestion: %3", (Object)suggestion.query, (Object)suggestion.suggestion, (Object)string);
                this.searchListener.handleSuggestion(suggestion, string);
                this.currentSuggestion = suggestion;
            }
            this.searchListener.triggerApplySearchFilter((int)searchResult.dataId, searchResult.getTokens());
        }
    }

    public void removeAllFromHistoryResult(int n) {
        this.logChannel.log(1000000, "OnlineSearchImpl#removeAllFromHistoryResult(%1): called", (long)n);
    }

    public void updatePotentialConflict(boolean bl, ConflictMatch conflictMatch, int n) {
        this.logChannel.log(1000000, "OnlineSearchGuiImpl#updatePotentialConflict(%1, Conflict*, %2): called", bl, (long)n);
    }

    public void createBackupFileResult(int n, String string) {
        this.logChannel.log(1000000, "OnlineSearchGuiImpl#createBackupFileResult(%1, %2): called", (Object)new Integer(n), (Object)string);
    }

    public void importBackupFileResult(int n, String string) {
        this.logChannel.log(1000000, "OnlineSearchGuiImpl#importBackupFileResult(%1, %2): called", (Object)new Integer(n), (Object)string);
    }

    public void setEnvironmentResult(int n) {
        this.logChannel.log(1000000, "OnlineSearchGuiImpl#setEnvironmentResult(%1): called", (long)n);
    }

    public void requestSuggestionResult2(int n, int n2, Suggestion[] suggestionArray) {
    }

    public void removeAllFromHistoryBySourceResult(int n) {
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

