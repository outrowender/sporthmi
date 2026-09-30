/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner.truffles;

import de.audi.app.tuner.truffles.IRadioSearch;
import de.audi.app.tuner.truffles.ISearchGUI;
import de.audi.app.tuner.truffles.RadioSearchListRow;
import de.audi.app.tuner.truffles.SearchResultFormatter;
import de.audi.app.tuner.truffles.SearchUtil;
import de.audi.app.tuner.truffles.TrufflesCommandHandler;
import de.audi.app.tuner.truffles.frequency.FrequencySearchHandler;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
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
import de.audi.tuner.sds.DefaultUpdateListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.search.SearchResult;

public class SearchGUI
extends AbstractGuiSearchHandler
implements ISearchGUI {
    public final TunerActionProxyListener actionProxy = new ActionPproxy();
    public final HmiAppListener hmiAppListener = new HmiAppListenerExt();
    private final Logger logger;
    private final TunerModels models;
    private final MemoryListHandler memory;
    private final IUpdateListener updateListener = new RadioUpdates();
    private final IRadioSearch appSearch;
    private final FrequencySearchHandler frequencySearch;
    private static final int SEARCH_PROGRESS_SPELLER_EMPTY = 0;
    private static final int SEARCH_PROGRESS_STARTED = 1;
    private static final int SEARCH_PROGRESS_NO_RESULTS = 2;
    private static final int SEARCH_PROGRESS_RESULTS_FOUND = 3;
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
        super(new int[]{17}, tunerBasics.getModels().getInternalBaseListModel(100480), tunerBasics.getModels().getSpellerModel(100442), tunerBasics.getModels().getChoiceModel(100266), tunerBasics.getLogger().truffles, (AbstractSearch)((Object)iRadioSearch));
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
        this.models.getBaseListModel(100544).setListener(new FrequencyListListener());
        this.models.getBaseListModel(100480).setListener(new SearchResultListener());
        tunerBasics.getModels().getSpellerModel(100442).setStatus(0);
        this.configureSuggestions(false, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
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
                this.logger.truffles.log(10000000, "[SearchGUI.textChanged] speller status: empty");
            } else {
                this.models.getSpellerModel(n).setStatus(1);
                this.logger.truffles.log(10000000, "[SearchGUI.textChanged] speller status: search started");
            }
            this.models.getBaseListModel(100480).removeAll();
            this.models.getBaseListModel(100544).removeAll();
        }
        super.textChanged(n, string, c2, n2);
        this.frequencySearch.textChanged(string);
    }

    protected synchronized void performQuery(String string) {
        this.logger.truffles.log(10000000, "[SearchGUI.performQuery] ->%1<-", (Object)string);
        if (string.length() != 0) {
            this.cmdHandler.add(new PerformQueryCmd(string));
            this.runCommands();
        } else {
            this.logger.truffles.log(10000000, "[SearchGUI.performQuery] no query");
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
        this.logger.truffles.log(10000000, "[SearchGUI.runCommands] running commands");
        boolean bl = this.cmdHandler.runCommands();
        this.logger.truffles.log(10000000, "[SearchGUI.runCommands] running commands finished, performing search: %1", bl);
        Object object2 = this.searchRunningMutex;
        synchronized (object2) {
            this.searchIsActive = bl;
        }
    }

    private void clearSearch() {
        this.logger.truffles.log(10000000, "[SearchGUI.clearSearch]");
        this.appSearch.cancelQuerry();
        this.models.getSpellerModel(100442).clear();
        this.models.getSpellerModel(100442).setStatus(0);
        this.models.getBaseListModel(100480).removeAll();
        this.frequencySearch.clearSearchResults();
    }

    public void cancelQueryResult() {
        if (this.searchCounter > 0) {
            --this.searchCounter;
        }
        super.cancelQueryResult();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void searchEnded() {
        Object object;
        super.searchEnded();
        BaseListModelApp baseListModelApp = this.models.getBaseListModel(100480);
        BaseListModelApp baseListModelApp2 = this.models.getInternalBaseListModel(100480);
        if (this.searchCounter > 0) {
            this.logger.truffles.log(10000000, "[SearchGUI.searchEnded] search cancel action not finished!");
        } else {
            object = this.twoSearchListMutex;
            synchronized (object) {
                this.truffleSearchEnded = true;
                this.truffleListSize = baseListModelApp2.getLength();
                this.logger.truffles.log(10000000, "[SearchGUI.searchEnded] item count: %1", (long)this.truffleListSize);
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
    public void frequencySearchEnded(int n) {
        Object object = this.twoSearchListMutex;
        synchronized (object) {
            this.logger.truffles.log(10000000, "[SearchGUI.frequencySearchEnded] item count: %1", (long)n);
            this.frequencySearchEnded = true;
            this.frequencyListSize = n;
            this.updateSpellerStatus();
        }
    }

    private void updateSpellerStatus() {
        if (this.frequencySearchEnded && this.truffleSearchEnded) {
            this.logger.truffles.log(10000000, "[SearchGUI.updateSpellerStatus]");
            int n = 0;
            if (this.models.getSpellerModel(100442).getText().length() != 0) {
                if (this.truffleListSize + this.frequencyListSize == 0) {
                    n = 2;
                    this.logger.truffles.log(10000000, "[SearchGUI.updateSpellerStatus] speller status: no results");
                } else {
                    n = 3;
                    this.logger.truffles.log(10000000, "[SearchGUI.updateSpellerStatus] speller status: results found");
                }
            }
            this.models.getSpellerModel(100442).setStatus(n);
        }
    }

    public int[] getSources() {
        List list = this.models.getAvailableLists();
        Collections.sort(list, new ListComparator(this.models.getActiveList()));
        int[] nArray = new int[list.size()];
        int n = 0;
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer n2 = (Integer)iterator.next();
            nArray[n++] = SearchUtil.getSourceByBand(n2);
        }
        return nArray;
    }

    public final int getMaxColumns() {
        return 7;
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    public IUpdateListener getUpdateListener() {
        return this.updateListener;
    }

    public void searchResultSelected(SearchResultListRow searchResultListRow, int n, int n2) {
        TunerObjectContainer tunerObjectContainer;
        int n3;
        SearchResult searchResult = searchResultListRow.getSearchResult();
        this.logger.truffles.log(10000000, "[SearchGUI.searchResultSelected] result: %1", (Object)searchResult);
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

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
    }

    private class ActionPproxy
    extends TunerActionProxyListener {
        private ActionPproxy() {
        }

        public void hmiDeactivatedTuner() {
            SearchGUI.this.clearSearch();
        }
    }

    private class RadioUpdates
    extends DefaultUpdateListener
    implements IUpdateListener {
        private int band;
        private int list;

        private RadioUpdates() {
        }

        public void updatedWaveband(int n) {
            this.doUpdate(n, this.list);
        }

        public void updatedActiveList(int n) {
            this.doUpdate(this.band, n);
        }

        private void doUpdate(int n, int n2) {
            if (n != this.band || n2 != this.list) {
                if (!SearchGUI.this.clearSearchWaiting) {
                    SearchGUI.this.clearSearch();
                }
                this.band = n;
                this.list = n2;
            }
        }
    }

    private static class ListComparator
    implements Comparator {
        private static final int[] order = new int[]{12, 13, 11, 5, 7, 1, 4};
        private int activeList;

        public ListComparator(int n) {
            this.activeList = n;
        }

        public int compare(Object object, Object object2) {
            int n = this.getIndex(object);
            int n2 = this.getIndex(object2);
            return n - n2;
        }

        private int getIndex(Object object) {
            int n = (Integer)object;
            if (n == this.activeList) {
                return -10;
            }
            for (int i2 = 0; i2 < order.length; ++i2) {
                if (order[i2] != n) continue;
                return i2;
            }
            return -1;
        }
    }

    class PerformQueryCmd
    implements TrufflesCommandHandler.ITrufflesCommand {
        private final String text;

        public PerformQueryCmd(String string) {
            this.text = string;
        }

        public void execute() {
            SearchGUI.this.searchCounter++;
            SearchGUI.this.appSearch.setIgnoreSearchIsActive(true);
            SearchGUI.super.performQuery(this.text);
        }

        public int getPriority() {
            return 1;
        }
    }

    private class HmiAppListenerExt
    extends HmiAppListener {
        private HmiAppListenerExt() {
        }

        public void screenFadedOut(int n, int n2) {
            ((SearchGUI)SearchGUI.this).logger.truffles.log(10000000, "[SearchGUI.HMIAppListenerExt.screenFadedOut] id %1", (long)n);
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

    private class FrequencyListListener
    extends DefaultBaseListModelListener {
        private FrequencyListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            long l;
            RadioSearchListRow radioSearchListRow = (RadioSearchListRow)evoListRow;
            SearchResult searchResult = radioSearchListRow.getSearchResult();
            ((SearchGUI)SearchGUI.this).logger.truffles.log(10000000, "[FrequencySearchHandler.itemSelected] row: %1, dataId: %2", (Object)evoListRow, searchResult.dataId);
            switch (radioSearchListRow.getBand()) {
                case 4: {
                    l = RadioObjectIds.getAmFmId(3, radioSearchListRow.getSearchResult().getDataId(), -1, 0, false);
                    break;
                }
                case 1: {
                    l = RadioObjectIds.getAmFmId(1, radioSearchListRow.getSearchResult().getDataId(), -1, 0, false);
                    break;
                }
                default: {
                    return;
                }
            }
            SearchGUI.this.clearSearchWaiting = true;
            TunerObjectContainer tunerObjectContainer = new RadioObjectIds((long)l, (LogChannel)((SearchGUI)SearchGUI.this).logger.truffles).toc;
            if (tunerObjectContainer != null) {
                if (SearchGUI.this.models.getActiveList() == tunerObjectContainer.getBand()) {
                    SearchGUI.this.models.getBaseListModel(n).fireEvent(n4);
                } else {
                    SearchGUI.this.models.setActiveList(tunerObjectContainer.getBand());
                }
                TunerProxyManager.getInstance().prepareAndTune(tunerObjectContainer, n4);
            } else {
                ((SearchGUI)SearchGUI.this).logger.truffles.log(10000, "[FrequencySearchHandler.itemSelected] item not found %1", (Object)evoListRow);
            }
        }
    }
}

