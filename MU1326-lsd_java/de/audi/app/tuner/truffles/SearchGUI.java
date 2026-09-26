/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.IRadioSearch;
import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.app.tuner.truffles.SearchGUI$ActionPproxy;
import de.audi.app.tuner.truffles.SearchGUI$FrequencyListListener;
import de.audi.app.tuner.truffles.SearchGUI$HmiAppListenerExt;
import de.audi.app.tuner.truffles.SearchGUI$ListComparator;
import de.audi.app.tuner.truffles.SearchGUI$PerformQueryCmd;
import de.audi.app.tuner.truffles.SearchGUI$RadioUpdates;
import de.audi.app.tuner.truffles.SearchGUI$SearchResultListener;
import de.audi.app.tuner.truffles.SearchResultFormatter;
import de.audi.app.tuner.truffles.SearchUtil;
import de.audi.app.tuner.truffles.TrufflesCommandHandler;
import de.audi.app.tuner.truffles.frequency.FrequencySearchHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.search.AbstractGuiSearchHandler;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tuner.app.HmiAppListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.RadioObjectIds;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.listener.IUpdateListener;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.search.SearchResult;

public class SearchGUI
extends AbstractGuiSearchHandler
implements ISearchGUI {
    public final TunerActionProxyListener actionProxy = new SearchGUI$ActionPproxy(this, null);
    public final HmiAppListener hmiAppListener = new SearchGUI$HmiAppListenerExt(this, null);
    private final Logger logger;
    private final TunerModels models;
    private final MemoryListHandler memory;
    private final IUpdateListener updateListener = new SearchGUI$RadioUpdates(this, null);
    private final IRadioSearch appSearch;
    private final FrequencySearchHandler frequencySearch;
    private static final int SEARCH_PROGRESS_SPELLER_EMPTY;
    private static final int SEARCH_PROGRESS_STARTED;
    private static final int SEARCH_PROGRESS_NO_RESULTS;
    private static final int SEARCH_PROGRESS_RESULTS_FOUND;
    private boolean frequencySearchEnded = false;
    private boolean truffleSearchEnded = false;
    private int truffleListSize = 0;
    private int frequencyListSize = 0;
    private final Object twoSearchListMutex = new Object();
    private volatile int searchCounter = -1;
    private final TrufflesCommandHandler cmdHandler;
    private boolean searchIsActive = false;
    private volatile boolean clearSearchWaiting = false;
    private Object searchRunningMutex = new Object();

    public SearchGUI(TunerBasics tunerBasics, IRadioSearch iRadioSearch, FrequencySearchHandler frequencySearchHandler, TrufflesCommandHandler trufflesCommandHandler, MemoryListHandler memoryListHandler) {
        super(new int[]{17}, tunerBasics.getModels().getInternalBaseListModel(-2138570496), tunerBasics.getModels().getSpellerModel(1518862592), tunerBasics.getModels().getChoiceModel(-1433992960), tunerBasics.getLogger().truffles, (AbstractSearch)((Object)iRadioSearch));
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.appSearch = iRadioSearch;
        this.frequencySearch = frequencySearchHandler;
        this.memory = memoryListHandler;
        this.frequencySearch.registerSearchGui(this);
        this.cmdHandler = trufflesCommandHandler;
        SearchResultFormatter searchResultFormatter = new SearchResultFormatter(this.logger.truffles);
        this.registryFormatter.put(new Integer(17), searchResultFormatter);
        this.registryFormatter.put(new Integer(23), searchResultFormatter);
        this.registryFormatter.put(new Integer(24), searchResultFormatter);
        this.registryFormatter.put(new Integer(25), searchResultFormatter);
        this.registryFormatter.put(new Integer(26), searchResultFormatter);
        this.registryFormatter.put(new Integer(20017), searchResultFormatter);
        this.registryFormatter.put(new Integer(10017), searchResultFormatter);
        this.models.getBaseListModel(-1064828672).setListener(new SearchGUI$FrequencyListListener(this, null));
        this.models.getBaseListModel(-2138570496).setListener(new SearchGUI$SearchResultListener(this, null));
        tunerBasics.getModels().getSpellerModel(1518862592).setStatus(0);
        this.configureSuggestions(false, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void textChanged(int n, String string, char c2, int n2) {
        Object object = this.twoSearchListMutex;
        synchronized (object) {
            this.truffleSearchEnded = false;
            this.frequencySearchEnded = false;
            this.frequencyListSize = 0;
            this.truffleListSize = 0;
            this.models.getSpellerModel(n).setText(string);
            if (string.length() == 0) {
                this.models.getSpellerModel(n).setStatus(0);
                this.logger.truffles.log(-2137614336, "[SearchGUI.textChanged] speller status: empty");
            } else {
                this.models.getSpellerModel(n).setStatus(1);
                this.logger.truffles.log(-2137614336, "[SearchGUI.textChanged] speller status: search started");
            }
            this.models.getBaseListModel(-2138570496).removeAll();
            this.models.getBaseListModel(-1064828672).removeAll();
        }
        super.textChanged(n, string, c2, n2);
        this.frequencySearch.textChanged(string);
    }

    @Override
    protected synchronized void performQuery(String string) {
        this.logger.truffles.log(-2137614336, "[SearchGUI.performQuery] ->%1<-", (Object)string);
        if (string.length() != 0) {
            this.cmdHandler.add(new SearchGUI$PerformQueryCmd(this, string));
            this.runCommands();
        } else {
            this.logger.truffles.log(-2137614336, "[SearchGUI.performQuery] no query");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void runCommands() {
        Object object = this.searchRunningMutex;
        synchronized (object) {
            if (this.searchIsActive) {
                return;
            }
            this.searchIsActive = true;
        }
        this.logger.truffles.log(-2137614336, "[SearchGUI.runCommands] running commands");
        boolean bl = this.cmdHandler.runCommands();
        this.logger.truffles.log(-2137614336, "[SearchGUI.runCommands] running commands finished, performing search: %1", bl);
        Object object2 = this.searchRunningMutex;
        synchronized (object2) {
            this.searchIsActive = bl;
        }
    }

    private void clearSearch() {
        this.logger.truffles.log(-2137614336, "[SearchGUI.clearSearch]");
        this.appSearch.cancelQuerry();
        this.models.getSpellerModel(1518862592).clear();
        this.models.getSpellerModel(1518862592).setStatus(0);
        this.models.getBaseListModel(-2138570496).removeAll();
        this.frequencySearch.clearSearchResults();
    }

    @Override
    public void cancelQueryResult() {
        if (this.searchCounter > 0) {
            --this.searchCounter;
        }
        super.cancelQueryResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void searchEnded() {
        Object object;
        super.searchEnded();
        BaseListModelApp baseListModelApp = this.models.getBaseListModel(-2138570496);
        BaseListModelApp baseListModelApp2 = this.models.getInternalBaseListModel(-2138570496);
        if (this.searchCounter > 0) {
            this.logger.truffles.log(-2137614336, "[SearchGUI.searchEnded] search cancel action not finished!");
        } else {
            object = this.twoSearchListMutex;
            synchronized (object) {
                this.truffleSearchEnded = true;
                this.truffleListSize = baseListModelApp2.getLength();
                this.logger.truffles.log(-2137614336, "[SearchGUI.searchEnded] item count: %1", (long)this.truffleListSize);
                baseListModelApp.update(baseListModelApp2);
                this.updateSpellerStatus();
            }
        }
        object = this.searchRunningMutex;
        synchronized (object) {
            this.searchIsActive = false;
        }
        this.runCommands();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void frequencySearchEnded(int n) {
        Object object = this.twoSearchListMutex;
        synchronized (object) {
            this.logger.truffles.log(-2137614336, "[SearchGUI.frequencySearchEnded] item count: %1", (long)n);
            this.frequencySearchEnded = true;
            this.frequencyListSize = n;
            this.updateSpellerStatus();
        }
    }

    private void updateSpellerStatus() {
        if (this.frequencySearchEnded && this.truffleSearchEnded) {
            this.logger.truffles.log(-2137614336, "[SearchGUI.updateSpellerStatus]");
            int n = 0;
            if (this.models.getSpellerModel(1518862592).getText().length() != 0) {
                if (this.truffleListSize + this.frequencyListSize == 0) {
                    n = 2;
                    this.logger.truffles.log(-2137614336, "[SearchGUI.updateSpellerStatus] speller status: no results");
                } else {
                    n = 3;
                    this.logger.truffles.log(-2137614336, "[SearchGUI.updateSpellerStatus] speller status: results found");
                }
            }
            this.models.getSpellerModel(1518862592).setStatus(n);
        }
    }

    @Override
    public int[] getSources() {
        List list = this.models.getAvailableLists();
        Collections.sort(list, new SearchGUI$ListComparator(this.models.getActiveList()));
        int[] nArray = new int[list.size()];
        int n = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer n2 = (Integer)iterator.next();
            nArray[n++] = SearchUtil.getSourceByBand(n2);
        }
        return nArray;
    }

    @Override
    public final int getMaxColumns() {
        return 7;
    }

    @Override
    public void focusedCharacter(int n, char c2, int n2) {
    }

    @Override
    public IUpdateListener getUpdateListener() {
        return this.updateListener;
    }

    @Override
    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        TunerObjectContainer tunerObjectContainer;
        int n3;
        SearchResult searchResult = searchResultListRow.getSearchResult();
        this.logger.truffles.log(-2137614336, "[SearchGUI.searchResultSelected] result: %1", (Object)searchResult);
        RadioObjectIds radioObjectIds = new RadioObjectIds(searchResult.dataId, this.logger.truffles);
        if (RadioObjectIds.isFavorite(searchResult.dataId)) {
            n3 = (int)(searchResult.dataId >> 8 & 0xFFFFFFFFFFFFFFFFL);
            tunerObjectContainer = this.memory.getPreset(n3);
        } else {
            tunerObjectContainer = radioObjectIds.toc;
        }
        this.clearSearchWaiting = true;
        if (tunerObjectContainer != null) {
            n3 = RadioObjectIds.isFavorite(searchResult.dataId) ? 12 : tunerObjectContainer.getBand();
            if (this.models.getActiveList() == n3) {
                this.models.getBaseListModel(n2).fireEvent(n);
            } else {
                this.models.setActiveList(n3);
            }
            TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n);
        } else {
            this.logger.truffles.log(10000, "[SearchGUI.searchResultSelected] result nor found %1", (Object)searchResult);
        }
    }

    @Override
    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    @Override
    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    static /* synthetic */ boolean access$500(SearchGUI searchGUI) {
        return searchGUI.clearSearchWaiting;
    }

    static /* synthetic */ void access$600(SearchGUI searchGUI) {
        searchGUI.clearSearch();
    }

    static /* synthetic */ Logger access$700(SearchGUI searchGUI) {
        return searchGUI.logger;
    }

    static /* synthetic */ boolean access$502(SearchGUI searchGUI, boolean bl) {
        searchGUI.clearSearchWaiting = bl;
        return searchGUI.clearSearchWaiting;
    }

    static /* synthetic */ TunerModels access$800(SearchGUI searchGUI) {
        return searchGUI.models;
    }

    static /* synthetic */ int access$908(SearchGUI searchGUI) {
        return searchGUI.searchCounter++;
    }

    static /* synthetic */ IRadioSearch access$1000(SearchGUI searchGUI) {
        return searchGUI.appSearch;
    }

    static /* synthetic */ void access$1101(SearchGUI searchGUI, String string) {
        super.performQuery(string);
    }
}

