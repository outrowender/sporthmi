/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.search.cmd;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultBaseListListener;
import de.audi.app.phone.core.model.TelDefaultSpellerListener;
import de.audi.app.phone.core.search.cmd.ITelDSISearchAccess;
import de.audi.app.phone.core.search.cmd.ITelSearchQueryListener;
import de.audi.app.phone.core.util.TelLoggingUtils;
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
    private static final int SEARCH_NOT_ACTIVE = 0;
    protected static final int SEARCH_ACTIVE = 1;
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

    public void init() {
        this.addSubPhoneComponent(new SearchSpellerListener(this.getApplication()));
        this.addSubPhoneComponent(new ResultListListener(this.getApplication()));
        super.init();
    }

    protected ITelDSISearchAccess getDsiSearchAccess() {
        return this.dsiSearchAccess;
    }

    protected abstract SpellerModelApp getSearchSpellerModel();

    protected abstract BaseListModelApp getSearchResultListModel();

    protected abstract ChoiceModelApp getSearchIsActiveChoiceModel();

    protected abstract SearchResultListRow getSearchResultListRow(SearchResult var1);

    protected abstract int[] getSources();

    private void scheduleQuery(String string) {
        this.log.log(1000000, "[AbstractTelSearchModelHandler#scheduleQuery] text=%1", (Object)string);
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

    public void updateSuggestion(Suggestion[] suggestionArray) {
        if (suggestionArray == null || suggestionArray.length == 0) {
            this.log.log(1000000, "[IntellicallSearchModelHandler#updateSuggestion] no suggestions --> NOP!");
            return;
        }
        this.updateSuggestion(suggestionArray[0]);
    }

    private void updateSuggestion(Suggestion suggestion) {
        this.log.log(1000000, "[AbstractTelSearchModelHandler#updateSuggestion] suggestion=%1", (Object)suggestion);
        if (suggestion == null) {
            this.log.log(10000, "[AbstractTelSearchModelHandler#updateSuggestion] suggestion is null");
            return;
        }
        this.getSearchSpellerModel().setSuggestions(this.getSearchSpellerModel().getText() + suggestion.getSuggestion(), AbstractTelSearchModelHandler.extractSuggestionFromQueryField(suggestion.getQuery(), 0));
        this.getSearchSpellerModel().setCompletionText(AbstractTelSearchModelHandler.extractSuggestionFromQueryField(suggestion.getQuery(), 0));
    }

    private void resetSuggestion() {
        this.getSearchSpellerModel().setSuggestions(null, null);
        this.getSearchSpellerModel().setCompletionText(null);
    }

    public void searchStarted(int n) {
        this.log.log(1000000, "[AbstractTelSearchModelHandler#searchStarted] queryID=%1", (long)n);
        this.getSearchResultListModel().removeAll();
        this.currentOpenRow = null;
        this.updateSearchInProgressChoice(true);
        this.resetSuggestion();
    }

    private void updateSearchInProgressChoice(boolean bl) {
        this.getSearchIsActiveChoiceModel().setValue(bl ? 1 : 0);
    }

    public void searchEnded(int n) {
        this.log.log(1000000, "[AbstractTelSearchModelHandler#searchEnded] queryID=%1", (long)n);
        this.updateSearchInProgressChoice(false);
    }

    public void searchCanceled(int n) {
        this.log.log(1000000, "[AbstractTelSearchModelHandler#searchCanceled] queryID=%1", (long)n);
        this.getSearchResultListModel().removeAll();
        this.resetSuggestion();
    }

    public void updateSearchResult(int n, SearchResult searchResult) {
        if (searchResult != null) {
            this.getSearchResultListModel().append(this.getSearchResultListRow(searchResult));
            if (searchResult.getListPosition() == 0) {
                this.updateSuggestion(searchResult.getSuggestion());
            }
        } else {
            this.log.log(100000, "[AbstractTelSearchModelHandler#updateSearchResult] searchResult is null --> NOP!");
        }
    }

    public void dataInvalidated(int n, int[] nArray) {
        this.log.log(1000000, "[AbstractTelSearchModelHandler#dataInvalidated] queryID=%2, sources=%1", (Object)Converter.intArrayToString(nArray), (long)n);
    }

    public abstract void searchResultSelected(SearchResultListRow var1, int var2, int var3);

    public abstract void childNodeSelected(EvoListRow var1, int var2, int var3);

    public abstract void requestChildrenNodes(SearchResultListRow var1, int var2);

    public abstract void spellerSelected(String var1, int var2);

    protected void parentNodeSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        this.log.log(10000000, "AbstractTelSearchModelHandler#parentNodeSelected, currentOpenRow - %1", (Object)this.currentOpenRow);
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
        this.log.log(10000000, "AbstractTelSearchModelHandler#setChildrenNodes children.length=%1", (long)evoListRowArray.length);
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
            this.log.log(10000000, "AbstractTelSearchModelHandler#parentNodeSelected - no children available");
        }
    }

    protected void clearSearchSpeller() {
        this.getSearchSpellerModel().clear();
    }

    private class ResultListListener
    extends TelDefaultBaseListListener {
        public ResultListListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Search", AbstractTelSearchModelHandler.this.getSearchResultListModel().getID());
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            if (evoListRow instanceof SearchResultListRow && ((SearchResultListRow)evoListRow).getNodeType() == 1) {
                AbstractTelSearchModelHandler.this.parentNodeSelected((SearchResultListRow)evoListRow, n, n4);
            } else if (evoListRow instanceof SearchResultListRow && ((SearchResultListRow)evoListRow).getNodeType() == 0) {
                AbstractTelSearchModelHandler.this.searchResultSelected((SearchResultListRow)evoListRow, n4, n);
            } else {
                AbstractTelSearchModelHandler.this.childNodeSelected(evoListRow, n4, n);
            }
        }
    }

    private class SearchSpellerListener
    extends TelDefaultSpellerListener {
        public SearchSpellerListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Search", AbstractTelSearchModelHandler.this.getSearchSpellerModel().getID());
        }

        public void textChanged(int n, String string, char c2, int n2) {
            this.log.log(1000000, "[AbstractTelSearchModelHandler.SearchSpellerListener#textChanged] %1", (Object)TelLoggingUtils.textChanged(n, string, c2, n2));
            AbstractTelSearchModelHandler.this.searchSpellerTextChanged(string, c2);
        }

        public void focusedCharacter(int n, char c2, int n2) {
            this.log.log(1000000, "[AbstractTelSearchModelHandler.SearchSpellerListener#focusedCharacter] %1", (Object)TelLoggingUtils.focusedCharacter(n, c2, n2));
        }

        public void keyTyped(int n, int n2, int n3) {
            this.log.log(1000000, "[AbstractTelSearchModelHandler.SearchSpellerListener#keyTyped] %1", (Object)TelLoggingUtils.keyTyped(n, n2, n3));
            AbstractTelSearchModelHandler.this.spellerSelected(AbstractTelSearchModelHandler.this.getSearchSpellerModel().getText(), n3);
        }
    }
}

