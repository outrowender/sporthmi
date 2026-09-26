/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.truffles;

import de.audi.atip.hmi.model.ChoiceModel;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tv.app.IScreenActionListener;
import de.audi.tv.app.base.ITVEventListener;
import de.audi.tv.app.base.TVEnv;
import de.audi.tv.app.dsi.DSITV;
import de.audi.tv.app.interapp.ITVRowFactory;
import de.audi.tv.app.lists.FocusHandler;
import de.audi.tv.app.lists.IStationList;
import de.audi.tv.app.lists.ITVListsListener;
import de.audi.tv.app.lists.StationMapper;
import de.audi.tv.app.lists.TVMenuModelListener;
import de.audi.tv.app.lists.favorites.IFavoritesList;
import de.audi.tv.app.truffles.ISearchGUI;
import de.audi.tv.app.truffles.SearchGUI;
import de.audi.tv.app.truffles.TVSearch;
import de.audi.tv.app.truffles.TVSearchDataProvider;
import de.audi.tv.app.truffles.TrufflesCommandHandler;
import org.osgi.framework.BundleContext;

public class SearchHandler {
    private final TVSearch tvSearch;
    final TVSearchDataProvider searchDataProvider;
    private final ISearchGUI searchGui;

    public SearchHandler(BundleContext bundleContext, TVEnv tVEnv, DSITV dSITV, TVMenuModelListener tVMenuModelListener, IStationList iStationList, IFavoritesList iFavoritesList, FocusHandler focusHandler, StationMapper stationMapper, int n, int n2, int n3, ITVRowFactory iTVRowFactory, int[] nArray) {
        this(bundleContext, tVEnv, dSITV, tVMenuModelListener, iStationList, iFavoritesList, focusHandler, stationMapper, n, n2, n3, new ChoiceModel(42), iTVRowFactory, nArray);
    }

    public SearchHandler(BundleContext bundleContext, TVEnv tVEnv, DSITV dSITV, TVMenuModelListener tVMenuModelListener, IStationList iStationList, IFavoritesList iFavoritesList, FocusHandler focusHandler, StationMapper stationMapper, int n, int n2, int n3, int n4, ITVRowFactory iTVRowFactory, int[] nArray) {
        this(bundleContext, tVEnv, dSITV, tVMenuModelListener, iStationList, iFavoritesList, focusHandler, stationMapper, n, n2, n3, tVEnv.getChoiceModel(n4), iTVRowFactory, nArray);
    }

    private SearchHandler(BundleContext bundleContext, TVEnv tVEnv, DSITV dSITV, TVMenuModelListener tVMenuModelListener, IStationList iStationList, IFavoritesList iFavoritesList, FocusHandler focusHandler, StationMapper stationMapper, int n, int n2, int n3, ChoiceModelApp choiceModelApp, ITVRowFactory iTVRowFactory, int[] nArray) {
        TrufflesCommandHandler trufflesCommandHandler = new TrufflesCommandHandler();
        this.tvSearch = new TVSearch(bundleContext, tVEnv.framework, tVEnv.lcTruffles, tVEnv);
        this.searchGui = new SearchGUI(tVEnv, tVEnv.lcTruffles, this.tvSearch, iFavoritesList, iStationList, dSITV, trufflesCommandHandler, focusHandler, n, n2, n3, choiceModelApp, iTVRowFactory, nArray);
        this.searchDataProvider = new TVSearchDataProvider(tVEnv.lcTruffles, iStationList, iFavoritesList, stationMapper, trufflesCommandHandler, this.searchGui);
        this.tvSearch.setActiveGuiSearchHandler(this.searchGui);
        tVMenuModelListener.register(this.searchDataProvider.searchListener, n);
    }

    public void deinit() {
        this.tvSearch.deinit();
    }

    public IScreenActionListener getScreenActionListener() {
        return ((SearchGUI)this.searchGui).screenActionListener;
    }

    public ITVEventListener getEventListener() {
        return ((SearchGUI)this.searchGui).eventListener;
    }

    public ITVListsListener getListsListener() {
        return this.searchDataProvider.listsListener;
    }

    public TVSearchDataProvider getSearchDataProvider() {
        return this.searchDataProvider;
    }

    public void clearSearch() {
        ((SearchGUI)this.searchGui).clearSearch();
    }

    public int getSearchId() {
        return this.tvSearch.getSearchId();
    }
}

