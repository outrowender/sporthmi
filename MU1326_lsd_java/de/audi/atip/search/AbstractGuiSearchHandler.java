/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.search;

import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Suggestion;

public abstract class AbstractGuiSearchHandler
implements SpellerListener,
BaseListModelListener {
    private static final int FLUSH_BUFFER_BLOCKSIZE = 20;
    private static final int FLUSH_BUFFER_1ST_PAGE = 3;
    private static final int FLUSH_BUFFER_TIMERDELAY = 300;
    protected BaseListModelApp mdlListSearchResults;
    protected SpellerModelApp mdlSpellerSearchText;
    protected ChoiceModelApp mdlChoiceSearchIsActive;
    protected AbstractSearch appSearch;
    protected final LogChannel lc;
    protected LogChannel lcFrequent;
    protected int[] activeSources;
    protected Map registryFormatter = new HashMap();
    private Timer timerFlushBuffer;
    private SearchResultListRow currentOpenRow;
    protected ArrayList searchResultBuffer = new ArrayList();
    protected final Object lock;
    private boolean lockSearchIsActiveChoice = false;
    private boolean showFastGuess = true;
    private boolean showSlowGuess = true;
    private int lastSuggestionQueryID = Integer.MAX_VALUE;
    private Suggestion currentSuggestion;
    static /* synthetic */ Class class$de$audi$atip$search$AbstractGuiSearchHandler;

    public AbstractGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch) {
        this.lock = abstractSearch.getLock();
        this.lc = logChannel;
        this.appSearch = abstractSearch;
        this.activeSources = nArray;
        if (abstractSearch != null) {
            abstractSearch.prepareSources(this.activeSources);
        }
        this.mdlListSearchResults = baseListModelApp;
        this.mdlSpellerSearchText = spellerModelApp;
        this.mdlChoiceSearchIsActive = choiceModelApp;
        this.registerListeners();
        this.initModels();
        TimerListener timerListener = new TimerListener(){

            public void fireTimer(Timer timer) {
                if (AbstractGuiSearchHandler.this.lcFrequent != null) {
                    AbstractGuiSearchHandler.this.lcFrequent.log(10000000, "%1#fireTimer flushSearchResultBuffer", (Object)(class$de$audi$atip$search$AbstractGuiSearchHandler == null ? (class$de$audi$atip$search$AbstractGuiSearchHandler = AbstractGuiSearchHandler.class$("de.audi.atip.search.AbstractGuiSearchHandler")) : class$de$audi$atip$search$AbstractGuiSearchHandler).getName());
                }
                AbstractGuiSearchHandler.this.flushSearchResultBuffer();
            }

            public void cancelTimer(Timer timer) {
            }
        };
        this.timerFlushBuffer = new Timer("SearchFlushTimer", 5, this.lcFrequent, timerListener, 300L, false);
    }

    protected final void registerListeners() {
        if (this.mdlListSearchResults != null) {
            this.mdlListSearchResults.setListener(this);
        } else {
            this.lc.log(100000, "AbstractGuiSearchHandler#registerListeners ListModel missing");
        }
        if (this.mdlSpellerSearchText != null) {
            this.mdlSpellerSearchText.setSpellerListener(this);
        } else {
            this.lc.log(100000, "AbstractGuiSearchHandler#registerListeners SpellerModel missing");
        }
    }

    protected final void initModels() {
        if (this.mdlListSearchResults != null) {
            this.mdlListSearchResults.removeAll();
        }
        if (this.mdlSpellerSearchText != null) {
            this.mdlSpellerSearchText.clear();
        }
        if (this.mdlChoiceSearchIsActive != null) {
            this.mdlChoiceSearchIsActive.setValue(0);
        }
    }

    protected void unregisterListeners() {
        if (this.mdlListSearchResults != null) {
            this.mdlListSearchResults.resetListener();
        }
        if (this.mdlSpellerSearchText != null) {
            this.mdlSpellerSearchText.resetListener();
        }
    }

    public int[] getSources() {
        return this.activeSources;
    }

    public void configureSuggestions(boolean bl, boolean bl2) {
        this.showFastGuess = bl;
        this.showSlowGuess = bl2;
    }

    protected SearchResultListRow getFormattedRow(SearchResult searchResult) {
        this.lc.log(100000000, "AbstractGuiSearchHandler#getFormattedRow");
        AbstractSearchResultFormatter abstractSearchResultFormatter = null;
        if (!this.registryFormatter.containsKey(new Integer(searchResult.getSource()))) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#getFormattedRow - no Formatter for source %1", (long)searchResult.getSource());
            return null;
        }
        abstractSearchResultFormatter = (AbstractSearchResultFormatter)this.registryFormatter.get(new Integer(searchResult.getSource()));
        return abstractSearchResultFormatter.formatResult(searchResult);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean setListRow(int n, SearchResult searchResult) {
        Object object = this.lock;
        synchronized (object) {
            this.lc.log(100000000, "AbstractGuiSearchHandler#setListRow # row=%1", (long)n);
            this.setSlowGuess(searchResult.getSuggestion());
            SearchResultListRow searchResultListRow = this.getFormattedRow(searchResult);
            if (searchResultListRow != null) {
                this.searchResultBuffer.add(searchResultListRow);
            }
            if (n == 3 || this.searchResultBuffer.size() >= 20) {
                this.flushSearchResultBuffer();
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void flushSearchResultBuffer() {
        Object object = this.lock;
        synchronized (object) {
            EvoListRow[] evoListRowArray;
            if (this.lcFrequent != null) {
                this.lcFrequent.log(10000000, "%1#flushSearchResultBuffer", (Object)this.getClass().getName());
                this.lcFrequent.log(10000000, "flushSearchResultBuffer # size = %1", (long)this.searchResultBuffer.size());
            }
            Iterator iterator = this.searchResultBuffer.iterator();
            while (iterator.hasNext()) {
                evoListRowArray = (EvoListRow[])iterator.next();
                if (evoListRowArray.getSearchResult().getQueryId() == this.appSearch.getLastQueryID()) continue;
                this.lc.log(100000, "AbstractGuiSearchHandler#flushSearchResultBuffer - row %1 should not have been added to the buffer", (Object)evoListRowArray);
                iterator.remove();
            }
            if (!this.searchResultBuffer.isEmpty()) {
                evoListRowArray = new SearchResultListRow[this.searchResultBuffer.size()];
                for (int i2 = 0; i2 < this.searchResultBuffer.size(); ++i2) {
                    SearchResultListRow searchResultListRow;
                    evoListRowArray[i2] = searchResultListRow = (SearchResultListRow)this.searchResultBuffer.get(i2);
                }
                BaseListModelApp baseListModelApp = this.mdlListSearchResults.getCopy();
                int n = baseListModelApp.getLength();
                baseListModelApp.setLength(n + evoListRowArray.length);
                baseListModelApp.setRows(-1, n, evoListRowArray);
                this.mdlListSearchResults.update(baseListModelApp);
                this.searchResultBuffer.clear();
                if (n <= 0) {
                    this.firstResultsAdded();
                }
            }
        }
    }

    protected void firstResultsAdded() {
    }

    protected ArrayList getBufferCopy() {
        return (ArrayList)this.searchResultBuffer.clone();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void searchStarted() {
        Object object = this.lock;
        synchronized (object) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#searchStarted");
            if (this.lockSearchIsActiveChoice) {
                this.lc.log(10000000, "AbstractGuiSearchHandler#searchStarted lockSearchIsActiveChoice=true, return");
                return;
            }
            if (this.mdlChoiceSearchIsActive != null) {
                this.mdlChoiceSearchIsActive.setValue(1);
            }
            this.timerFlushBuffer.restart();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void searchEnded() {
        Object object = this.lock;
        synchronized (object) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#searchEnded");
            if (this.lockSearchIsActiveChoice) {
                this.lc.log(10000000, "AbstractGuiSearchHandler#searchEnded lockSearchIsActiveChoice=true, return");
                return;
            }
            this.flushSearchResultBuffer();
            this.timerFlushBuffer.cancel();
            if (this.mdlChoiceSearchIsActive != null) {
                this.mdlChoiceSearchIsActive.setValue(0);
            }
        }
    }

    protected void setFastGuess(Suggestion[] suggestionArray, int n) {
        this.currentSuggestion = null;
        if (!this.showFastGuess) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#setFastGuess fast guess is turned off, showSlowGuess=%1", this.showSlowGuess);
            return;
        }
        this.mdlSpellerSearchText.setCompletionText(null);
        if (this.lastSuggestionQueryID != n) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#setFastGuess fast guess is old queryID=%1", (long)n);
            return;
        }
        if (suggestionArray == null || suggestionArray.length == 0 || suggestionArray[0] == null) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#setFastGuess invalid result from the south side, showSlowGuess=%1", this.showSlowGuess);
            return;
        }
        this.lc.log(10000000, "AbstractGuiSearchHandler#setFastGuess suggestions[0]=%1", (Object)suggestionArray[0]);
        this.mdlSpellerSearchText.setSuggestions(new StringBuffer().append(this.mdlSpellerSearchText.getText()).append(suggestionArray[0].getSuggestion()).toString(), suggestionArray[0].getQuery());
        this.currentSuggestion = suggestionArray[0];
        this.mdlSpellerSearchText.setCompletionText(suggestionArray[0].getFullSuggestion());
    }

    protected void setSlowGuess(Suggestion suggestion) {
        if (!this.showSlowGuess || this.currentSuggestion != null) {
            return;
        }
        if (suggestion == null) {
            return;
        }
        this.lc.log(10000000, "AbstractGuiSearchHandler#setSlowGuess suggestion=%1", (Object)suggestion);
        String string = new StringBuffer().append(this.mdlSpellerSearchText.getText()).append(suggestion.getSuggestion()).toString();
        this.mdlSpellerSearchText.setSuggestions(string, suggestion.getQuery());
        this.mdlSpellerSearchText.setCompletionText(string);
        this.currentSuggestion = suggestion;
    }

    public abstract void searchResultSelected(SearchResultListRow var1, int var2, int var3);

    public abstract void childNodeSelected(EvoListRow var1, int var2, int var3);

    public abstract void requestChildrenNodes(SearchResultListRow var1, int var2);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void parentNodeSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        Object object = this.lock;
        synchronized (object) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#parentNodeSelected, currentOpenRow - %1", (Object)this.currentOpenRow);
            if (!searchResultListRow.equals(this.currentOpenRow)) {
                this.requestChildrenNodes(searchResultListRow, n2);
            } else {
                BaseListModelApp baseListModelApp = this.mdlListSearchResults.getCopy();
                this.closeRowInList(baseListModelApp, this.currentOpenRow);
                this.mdlListSearchResults.update(baseListModelApp);
                this.currentOpenRow = null;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setChildrenNodes(EvoListRow[] evoListRowArray, SearchResultListRow searchResultListRow) {
        Object object = this.lock;
        synchronized (object) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#setChildrenNodes children.length=%1", (long)evoListRowArray.length);
            if (this.mdlListSearchResults.getIndexForUniqueID(searchResultListRow.getUniqueID()) == -1) {
                this.lc.log(10000, "AbstractGuiSearchHandler#setChildrenNodes parent already gone from list, parent=%1", (Object)searchResultListRow);
                return;
            }
            if (evoListRowArray != null && evoListRowArray.length > 0) {
                BaseListModelApp baseListModelApp = this.mdlListSearchResults.getCopy();
                if (this.currentOpenRow != null) {
                    this.closeRowInList(baseListModelApp, this.currentOpenRow);
                }
                this.currentOpenRow = searchResultListRow;
                baseListModelApp.insertAfterAndOpen(searchResultListRow.getUniqueID(), evoListRowArray);
                searchResultListRow.setOpen(true);
                searchResultListRow.setChildrenCount(evoListRowArray.length);
                baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(searchResultListRow.getUniqueID()), searchResultListRow);
                this.mdlListSearchResults.update(baseListModelApp);
            } else {
                this.lc.log(10000000, "AbstractGuiSearchHandler#parentNodeSelected - no children available");
            }
        }
    }

    private void closeRowInList(BaseListModelApp baseListModelApp, SearchResultListRow searchResultListRow) {
        baseListModelApp.removeAndClose(searchResultListRow.getUniqueID(), searchResultListRow.getChildrenCount());
        searchResultListRow.setOpen(false);
        int n = baseListModelApp.getIndexForUniqueID(searchResultListRow.getUniqueID());
        baseListModelApp.setRow(n, searchResultListRow);
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#itemReleased # index=%1", (long)n2);
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#itemSelected # model=%1 index=%2", (long)n, (long)n2);
        if (evoListRow instanceof SearchResultListRow && ((SearchResultListRow)evoListRow).getNodeType() == 1) {
            this.parentNodeSelected((SearchResultListRow)evoListRow, n, n4);
        } else if (evoListRow instanceof SearchResultListRow && ((SearchResultListRow)evoListRow).getNodeType() == 0) {
            this.searchResultSelected((SearchResultListRow)evoListRow, n4, n);
        } else {
            this.childNodeSelected(evoListRow, n4, n);
        }
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#itemFocused # index=%1", (long)n2);
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#itemLongSelected # index=%1", (long)n2);
    }

    public void keyPressed(int n, int n2, int n3) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#keyPressed # model=%1, key=%2", (long)n, (long)n2);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#keyReleased # model=%1, key=%2", (long)n, (long)n2);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#keyTyped # model=%1, key=%2", (long)n, (long)n2);
    }

    public void commandPressed(int n, int n2, int n3) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#commandPressed # model=%1, index=%2", (long)n, (long)n2);
    }

    public void focusedCharacter(int n, char c2, int n2) {
        this.lc.log(10000000, "AbstractGuiSearchHandler#focusedCharacter()");
        this.mdlSpellerSearchText.setCompletionText(null);
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.performQuery(string);
    }

    public void refreshQuery() {
        if (this.mdlSpellerSearchText != null) {
            this.lc.log(10000000, "%1#refreshQuery()", (Object)this.getClass().getName());
            this.performQuery(this.mdlSpellerSearchText.getText());
        }
    }

    protected void performQuery(String string) {
        this.performQuery(string, new String[0]);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void performQuery(String string, String[] stringArray) {
        Object object = this.lock;
        synchronized (object) {
            this.lc.log(10000000, "AbstractGuiSearchHandler#performQuery # text=%1, alternativeTexts=%2", (Object)string, (Object)stringArray);
            this.searchResultBuffer.clear();
            this.searchStarted();
            this.lockSearchIsActiveChoice = this.appSearch.cancelQuery();
            this.clearModels();
            this.appSearch.performQuery(string, stringArray);
            this.lastSuggestionQueryID = this.appSearch.getLastQueryID();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelQueryResult() {
        Object object = this.lock;
        synchronized (object) {
            this.lockSearchIsActiveChoice = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void clearModels() {
        this.mdlListSearchResults.removeAll();
        this.mdlSpellerSearchText.setSuggestions(null, null);
        this.mdlSpellerSearchText.setCompletionText(null);
        Object object = this.lock;
        synchronized (object) {
            this.currentOpenRow = null;
        }
    }

    public void release() {
        this.unregisterListeners();
        this.cancelTimers();
    }

    public void cancelTimers() {
        this.timerFlushBuffer.cancel();
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

