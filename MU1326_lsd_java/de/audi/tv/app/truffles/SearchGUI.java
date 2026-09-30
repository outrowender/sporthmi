/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tv.app.NullScreenActionListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.base.TVEventDefaultListener;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.interapp.ITVRowFactory;
import de.audi.tv.app.lists.FocusHandler;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.truffles.ISearchGUI;
import de.audi.tv.app.truffles.ITVSearch;
import de.audi.tv.app.truffles.SearchResultFormatter;
import de.audi.tv.app.truffles.TVSearchListRow;
import de.audi.tv.app.truffles.TrufflesCommandHandler;
import de.audi.tv.app.util.SynchronizedInteger;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.tvtuner.ServiceInfo;

public class SearchGUI
extends AbstractGuiSearchHandler
implements ISearchGUI {
    private final TVEnv env;
    private final DSITV dsi;
    public final ScreenActionListener screenActionListener = new ScreenActionListener();
    public final TVEventDefaultListener eventListener = new EventListener();
    private final ITVSearch appSearch;
    private final FocusHandler focusHandler;
    private static final int SEARCH_PROGRESS_SPELLER_EMPTY = 0;
    private static final int SEARCH_PROGRESS_STARTED = 1;
    private static final int SEARCH_PROGRESS_NO_RESULTS = 2;
    private static final int SEARCH_PROGRESS_RESULTS_FOUND = 3;
    private final TrufflesCommandHandler cmdHandler;
    private final int listModelID;
    private final int spellerModelID;
    private final ChoiceModelApp searchStateChoice;
    private final SynchronizedInteger searchCounter = new SynchronizedInteger(-1);
    private volatile boolean clearSearchWaiting = false;
    private boolean searchIsActive = false;
    private Object searchRunningMutex = new Object();
    private Object searchListMutex = new Object();

    public SearchGUI(TVEnv tVEnv, LogChannel logChannel, ITVSearch iTVSearch, IFavoritesList iFavoritesList, IStationList iStationList, DSITV dSITV, TrufflesCommandHandler trufflesCommandHandler, FocusHandler focusHandler, int n, int n2, int n3, ChoiceModelApp choiceModelApp, ITVRowFactory iTVRowFactory, int[] nArray) {
        super(nArray, tVEnv.getInternalBaseListModel(n), tVEnv.getSpellerModel(n2), tVEnv.getChoiceModel(n3), logChannel, (AbstractSearch)((Object)iTVSearch));
        this.env = tVEnv;
        this.dsi = dSITV;
        this.appSearch = iTVSearch;
        this.cmdHandler = trufflesCommandHandler;
        this.focusHandler = focusHandler;
        this.listModelID = n;
        this.spellerModelID = n2;
        this.searchStateChoice = choiceModelApp;
        SearchResultFormatter searchResultFormatter = new SearchResultFormatter(logChannel, iFavoritesList, iStationList, iTVRowFactory);
        this.registryFormatter.put(new Integer(20027), searchResultFormatter);
        this.registryFormatter.put(new Integer(27), searchResultFormatter);
        this.registryFormatter.put(new Integer(10027), searchResultFormatter);
        tVEnv.getBaseListModel(n).setListener(new SearchResultListener());
        tVEnv.getSpellerModel(n2).setStatus(0);
        this.configureSuggestions(false, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void textChanged(int n, String string, char c2, int n2) {
        Object object = this.searchListMutex;
        synchronized (object) {
            this.env.getSpellerModel(n).setText(string);
            if (string.length() == 0) {
                this.env.getSpellerModel(n).setStatus(0);
                this.searchStateChoice.setValue(0);
                this.mdlSpellerSearchText.setSuggestions(null, null);
                this.mdlSpellerSearchText.setCompletionText(null);
                this.lc.log(10000000, "[SearchGUI.textChanged] speller status: empty");
            } else {
                this.env.getSpellerModel(n).setStatus(1);
                this.searchStateChoice.setValue(1);
                this.lc.log(10000000, "[SearchGUI.textChanged] speller status: search started");
            }
            this.env.getBaseListModel(this.listModelID).removeAll();
        }
        super.textChanged(n, string, c2, n2);
    }

    protected synchronized void performQuery(String string) {
        this.lc.log(10000000, "[SearchGUI.performQuery] ->%1<-", (Object)string);
        if (string.length() != 0) {
            this.cmdHandler.add(new PerformQueryCmd(string));
            this.runCommands();
        } else {
            this.lc.log(10000000, "[SearchGUI.performQuery] no query");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void runCommands() {
        Object object = this.searchRunningMutex;
        synchronized (object) {
            if (this.searchIsActive) {
                return;
            }
            this.searchIsActive = true;
        }
        this.lc.log(10000000, "[SearchGUI.runCommands] running commands");
        boolean bl = this.cmdHandler.runCommands();
        this.lc.log(10000000, "[SearchGUI.runCommands] running commands finished, performing search: %1", bl);
        Object object2 = this.searchRunningMutex;
        synchronized (object2) {
            this.searchIsActive = bl;
        }
    }

    void clearSearch() {
        this.lc.log(10000000, "[SearchGUI.clearSearch]");
        this.appSearch.cancelQuerry();
        this.env.getSpellerModel(this.spellerModelID).clear();
        this.env.getSpellerModel(this.spellerModelID).setStatus(0);
        this.searchStateChoice.setValue(0);
        this.env.getBaseListModel(this.listModelID).removeAll();
    }

    public void cancelQueryResult() {
        this.searchCounter.decrementIfGreaterThan(0);
        super.cancelQueryResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void searchEnded() {
        Object object;
        super.searchEnded();
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(this.listModelID);
        BaseListModelApp baseListModelApp2 = this.env.getInternalBaseListModel(this.listModelID);
        if (this.searchCounter.isGreaterThan(0)) {
            this.lc.log(10000000, "[SearchGUI.searchEnded] search cancel action not finished!");
        } else {
            object = this.searchListMutex;
            synchronized (object) {
                int n = baseListModelApp2.getLength();
                this.lc.log(10000000, "[SearchGUI.searchEnded] item count: %1", (long)n);
                baseListModelApp.update(baseListModelApp2);
                this.updateSpellerStatus(n);
            }
        }
        object = this.searchRunningMutex;
        synchronized (object) {
            this.searchIsActive = false;
        }
        this.runCommands();
    }

    public void keyTyped(int n, int n2, int n3) {
        String string;
        if (n2 == 7 && (string = this.mdlSpellerSearchText.getCompletionText()) != null && string.length() > 0) {
            this.mdlSpellerSearchText.setText(string);
            this.performQuery(string);
        }
    }

    private void updateSpellerStatus(int n) {
        this.lc.log(10000000, "[SearchGUI.updateSpellerStatus]");
        int n2 = 0;
        if (this.env.getSpellerModel(this.spellerModelID).getText().length() != 0) {
            if (n == 0) {
                n2 = 2;
                this.lc.log(10000000, "[SearchGUI.updateSpellerStatus] speller status: no results");
            } else {
                n2 = 3;
                this.lc.log(10000000, "[SearchGUI.updateSpellerStatus] speller status: results found");
            }
        }
        this.env.getSpellerModel(this.spellerModelID).setStatus(n2);
        this.searchStateChoice.setValue(n2);
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        ServiceInfo serviceInfo = ((TVSearchListRow)searchResultListRow).service;
        SearchResult searchResult = searchResultListRow.getSearchResult();
        this.lc.log(10000000, "[SearchGUI.searchResultSelected] tune service: %1", (Object)serviceInfo);
        this.clearSearchWaiting = true;
        if (serviceInfo != null) {
            int n3 = StationMapper.isFavorite(searchResult.dataId) ? 1 : 0;
            if (this.focusHandler.getFocusedListId() == n3) {
                this.env.getBaseListModel(n2).fireEvent(n);
            } else {
                this.focusHandler.changeFocus(n3);
            }
            this.dsi.selectService(serviceInfo, true);
        } else {
            this.lc.log(10000, "[SearchGUI.searchResultSelected] result nor found %1", (Object)searchResult);
        }
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    private class EventListener
    extends TVEventDefaultListener {
        private int list = 0;

        private EventListener() {
        }

        public void onAppDeactivated(int n) {
            SearchGUI.this.clearSearch();
        }

        public void onFocusedListChanged(int n) {
            if (n != this.list) {
                if (!SearchGUI.this.clearSearchWaiting) {
                    SearchGUI.this.clearSearch();
                }
                this.list = n;
            }
        }
    }

    class PerformQueryCmd
    implements TrufflesCommandHandler.ITrufflesCommand {
        private final String text;

        public PerformQueryCmd(String string) {
            this.text = string;
        }

        public void execute() {
            SearchGUI.this.searchCounter.increment();
            SearchGUI.this.appSearch.setIgnoreSearchIsActive(true);
            SearchGUI.super.performQuery(this.text);
        }

        public int getPriority() {
            return 1;
        }
    }

    private class ScreenActionListener
    extends NullScreenActionListener {
        private ScreenActionListener() {
        }

        public void screenFadedOut(int n, int n2) {
            if (SearchGUI.this.clearSearchWaiting) {
                SearchGUI.this.clearSearch();
                SearchGUI.this.clearSearchWaiting = false;
            }
        }
    }

    private class SearchResultListener
    extends DefaultBaseListModelListener {
        private SearchResultListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            SearchGUI.this.itemSelected(evoListRow, n, n2, n3, n4);
        }
    }
}

