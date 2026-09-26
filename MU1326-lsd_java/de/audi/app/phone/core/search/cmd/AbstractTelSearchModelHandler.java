/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler$ResultListListener;
import de.audi.app.phone.core.search.cmd.AbstractTelSearchModelHandler$SearchSpellerListener;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.search.util.SearchResultListRow;
import de.esolutions.fw.util.commons.Converter;
import java.util.StringTokenizer;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public abstract class AbstractTelSearchModelHandler
extends AbstractPhoneComponent
implements ITelSearchQueryListener {
    private static final int SEARCH_NOT_ACTIVE;
    protected static final int SEARCH_ACTIVE;
    private final ITelDSISearchAccess dsiSearchAccess;
    private volatile Suggestion suggestion;
    private volatile SearchResultListRow currentOpenRow;

    private static String extractSuggestionFromQueryField(String string, int n) {
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = "";
        char c2 = '\u0002';
        String string3 = String.valueOf(c2);
        String string4 = " ";
        StringTokenizer stringTokenizer = new StringTokenizer(string, string3);
        if (stringTokenizer.hasMoreTokens()) {
            stringBuffer.append(stringTokenizer.nextToken());
            string2 = stringBuffer.toString();
        }
        if (stringTokenizer.hasMoreTokens()) {
            string2 = stringTokenizer.nextToken();
            stringBuffer.append(string4);
            stringBuffer.append(string2);
        }
        if (n == 0) {
            return stringBuffer.toString();
        }
        return string2;
    }

    private static void closeRowInList(BaseListModelApp baseListModelApp, SearchResultListRow searchResultListRow) {
        baseListModelApp.removeAndClose(searchResultListRow.getUniqueID(), searchResultListRow.getChildrenCount());
        searchResultListRow.setOpen(false);
        int n = baseListModelApp.getIndexForUniqueID(searchResultListRow.getUniqueID());
        baseListModelApp.setRow(n, searchResultListRow);
    }

    public AbstractTelSearchModelHandler(ITelApplication iTelApplication, ITelDSISearchAccess iTelDSISearchAccess, String string) {
        super(iTelApplication, "App.Phone.Search");
        this.dsiSearchAccess = iTelDSISearchAccess;
    }

    @Override
    public void init() {
        this.addSubPhoneComponent(new AbstractTelSearchModelHandler$SearchSpellerListener(this, this.getApplication()));
        this.addSubPhoneComponent(new AbstractTelSearchModelHandler$ResultListListener(this, this.getApplication()));
        super.init();
    }

    protected ITelDSISearchAccess getDsiSearchAccess() {
        return this.dsiSearchAccess;
    }

    protected abstract SpellerModelApp getSearchSpellerModel() {
    }

    protected abstract BaseListModelApp getSearchResultListModel() {
    }

    protected abstract ChoiceModelApp getSearchIsActiveChoiceModel() {
    }

    protected abstract SearchResultListRow getSearchResultListRow(SearchResult searchResult) {
    }

    protected abstract int[] getSources() {
    }

    private void scheduleQuery(String string) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler#scheduleQuery] text=%1", (Object)string);
        this.dsiSearchAccess.scheduleQuery(string, this.getSources(), this);
    }

    protected void searchSpellerTextChanged(String string, char c2) {
        if (string != null && string.length() > 0) {
            this.updateSearchInProgressChoice(true);
        } else {
            this.updateSearchInProgressChoice(false);
        }
        this.scheduleQuery(string);
    }

    @Override
    public void updateSuggestion(Suggestion[] suggestionArray) {
        if (suggestionArray == null || suggestionArray.length == 0) {
            this.log.log(1078071040, "[IntellicallSearchModelHandler#updateSuggestion] no suggestions --> NOP!");
            return;
        }
        this.updateSuggestion(suggestionArray[0]);
    }

    private void updateSuggestion(Suggestion suggestion) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler#updateSuggestion] suggestion=%1", (Object)suggestion);
        if (suggestion == null) {
            this.log.log(10000, "[AbstractTelSearchModelHandler#updateSuggestion] suggestion is null");
            return;
        }
        this.getSearchSpellerModel().setSuggestions(new StringBuffer().append(this.getSearchSpellerModel().getText()).append(suggestion.getSuggestion()).toString(), AbstractTelSearchModelHandler.extractSuggestionFromQueryField(suggestion.getQuery(), 0));
        this.getSearchSpellerModel().setCompletionText(AbstractTelSearchModelHandler.extractSuggestionFromQueryField(suggestion.getQuery(), 0));
    }

    private void resetSuggestion() {
        this.getSearchSpellerModel().setSuggestions(null, null);
        this.getSearchSpellerModel().setCompletionText(null);
    }

    @Override
    public void searchStarted(int n) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler#searchStarted] queryID=%1", (long)n);
        this.getSearchResultListModel().removeAll();
        this.currentOpenRow = null;
        this.updateSearchInProgressChoice(true);
        this.resetSuggestion();
    }

    private void updateSearchInProgressChoice(boolean bl) {
        this.getSearchIsActiveChoiceModel().setValue(bl ? 1 : 0);
    }

    @Override
    public void searchEnded(int n) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler#searchEnded] queryID=%1", (long)n);
        this.updateSearchInProgressChoice(false);
    }

    @Override
    public void searchCanceled(int n) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler#searchCanceled] queryID=%1", (long)n);
        this.getSearchResultListModel().removeAll();
        this.resetSuggestion();
    }

    @Override
    public void updateSearchResult(int n, SearchResult searchResult) {
        if (searchResult != null) {
            this.getSearchResultListModel().append(this.getSearchResultListRow(searchResult));
            if (searchResult.getListPosition() == 0) {
                this.updateSuggestion(searchResult.getSuggestion());
            }
        } else {
            this.log.log(-1601830656, "[AbstractTelSearchModelHandler#updateSearchResult] searchResult is null --> NOP!");
        }
    }

    @Override
    public void dataInvalidated(int n, int[] nArray) {
        this.log.log(1078071040, "[AbstractTelSearchModelHandler#dataInvalidated] queryID=%2, sources=%1", (Object)Converter.intArrayToString(nArray), (long)n);
    }

    public abstract void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
    }

    public abstract void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public abstract void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    public abstract void spellerSelected(String string, int n) {
    }

    protected void parentNodeSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(-2137614336, "AbstractTelSearchModelHandler#parentNodeSelected, currentOpenRow - %1", (Object)this.currentOpenRow);
        if (!searchResultListRow.equals(this.currentOpenRow)) {
            this.requestChildrenNodes(searchResultListRow, n2);
        } else {
            BaseListModelApp baseListModelApp = this.getSearchResultListModel().getCopy();
            AbstractTelSearchModelHandler.closeRowInList(baseListModelApp, this.currentOpenRow);
            this.getSearchResultListModel().update(baseListModelApp);
            this.currentOpenRow = null;
        }
    }

    public void setChildrenNodes(EvoListRow[] evoListRowArray, SearchResultListRow searchResultListRow) {
        this.log.log(-2137614336, "AbstractTelSearchModelHandler#setChildrenNodes children.length=%1", (long)evoListRowArray.length);
        if (this.getSearchResultListModel().getIndexForUniqueID(searchResultListRow.getUniqueID()) == -1) {
            this.log.log(10000, "AbstractTelSearchModelHandler#setChildrenNodes parent already gone from list, parent=%1", (Object)searchResultListRow);
            return;
        }
        if (evoListRowArray != null && evoListRowArray.length > 0) {
            BaseListModelApp baseListModelApp = this.getSearchResultListModel().getCopy();
            if (this.currentOpenRow != null) {
                AbstractTelSearchModelHandler.closeRowInList(baseListModelApp, this.currentOpenRow);
            }
            this.currentOpenRow = searchResultListRow;
            baseListModelApp.insertAfterAndOpen(searchResultListRow.getUniqueID(), evoListRowArray);
            searchResultListRow.setOpen(true);
            searchResultListRow.setChildrenCount(evoListRowArray.length);
            baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(searchResultListRow.getUniqueID()), searchResultListRow);
            this.getSearchResultListModel().update(baseListModelApp);
        } else {
            this.log.log(-2137614336, "AbstractTelSearchModelHandler#parentNodeSelected - no children available");
        }
    }

    protected void clearSearchSpeller() {
        this.getSearchSpellerModel().clear();
    }
}

