/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.poi.online.OnlineSearchControllerEvo;
import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.app.navi.evo.search.AdbContactsGuiSearchHandler;
import de.audi.app.navi.evo.search.AdbContactsWithAddressGuiSearchHandler;
import de.audi.app.navi.evo.search.DemoModeSearchGuiHandler;
import de.audi.app.navi.evo.search.FavoriteGuiSearchHandler;
import de.audi.app.navi.evo.search.FavoriteSearchFormatter;
import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntellDestSearchTimerDummy;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.IntelliDestHMIListener;
import de.audi.app.navi.evo.search.IntelliDestOptSelection;
import de.audi.app.navi.evo.search.IntelliDestPressRoutesDataProvider;
import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.app.navi.evo.search.IntelliDestSearchAsia;
import de.audi.app.navi.evo.search.IntelliDestSearchTimerAsia;
import de.audi.app.navi.evo.search.LastDestGuiSearchHandler;
import de.audi.app.navi.evo.search.NoPropertyFormatterFavorites;
import de.audi.app.navi.evo.search.PickHelpManager;
import de.audi.app.navi.evo.search.PickHelpPersistanceHelper;
import de.audi.app.navi.evo.search.SearchResultFormatterNavDb;
import de.audi.app.navi.evo.search.countryselection.CountrySelection;
import de.audi.app.navi.evo.search.countryselection.CountrySelectionNAR;
import de.audi.app.navi.favorite.NaviFavoriteHandlerEvo;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.cluster.CombiBAPListener;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultNavLocationExtractor;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceListener;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import de.audi.tghu.navi.app.search.ICountrySelection;
import de.audi.tghu.navi.app.search.ILastDestHandler;
import de.audi.tghu.navi.app.search.IntelliDestAccess;
import de.audi.tghu.navi.app.search.LastDestCacheSearchHandler;
import de.audi.tghu.navi.app.search.LastDestProducer;
import de.audi.tghu.navi.app.search.LastDestSearch;
import de.audi.tghu.navi.app.search.TrufflesDistanceCalculator;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.search.Country;
import org.osgi.framework.BundleContext;

public class IntelliDestController
implements IRouteGuidanceListener,
IntelliDestAccess {
    private final IntelliDestSearch destSearch;
    private final LastDestSearch lastDestSearch;
    private final IntelliDestGuiSearchHandler intelliDestGuiHandler;
    private final IntelliDestGuiSearchHandler demoModeGuiHandler;
    private final IntelliDestGuiSearchHandler favoritesGuiHandler;
    private final IntelliDestGuiSearchHandler destOptFavoritesGuiHandler;
    private final IntelliDestGuiSearchHandler destOptSelectionGuiHandler;
    private final IntelliDestGuiSearchHandler lastDestGuiHandler;
    private final LastDestCacheSearchHandler lastDestCache;
    private final IntelliDestGuiSearchHandler destOptContactsWithAddressGuiHandler;
    private final IntelliDestGuiSearchHandler destOptAddAddressToContactGuiSearchHandler;
    private final IntelliDestGuiSearchHandler intelliDestGuiExternalHandler;
    private final IIntelliDestSearchTimer intelliDestSearchTimer;
    private final PickHelpManager pickHelpManager;
    private final PickHelpPersistanceHelper pickHelpPersistanceHelper;
    private IntelliDestHMIListener intelliDestHMIListener;
    private final TrufflesDistanceCalculator distanceCalculator;
    private IntelliDestGuiSearchHandler currentGuiHandler;
    private final ICountrySelection countrySelection;
    private final ActiveDestinationsManager activeDestionationsManager;
    private final LastDestProducer lastDestProducer;
    private final IntelliDestPressRoutesDataProvider pressRoutesDataProvider;
    private final LogChannel logger;
    private final NavigationEnv env;
    private static final String LOGCLASS;
    private boolean downTransitionCalled;
    public static final int INTELLI_DEST_HANDLER;
    public static final int DEMO_MODE_HANDLER;
    public static final int FAVORITES_HANDLER;
    public static final int DEST_OPT_SELECTION_HANDLER;
    public static final int DEST_OPT_CONTACTS_HANDLER;
    public static final int LAST_DEST_HANDLER;
    public static final int DEST_OPT_CONTACTS_ADD_ADDRESS_HANDLER;
    public static final int DEST_OPT_FAVORITES_HANDLER;
    public static final int INTELLI_DEST_EXTERNAL_HANDLER;
    public static final int HIDE;

    public IntelliDestController(BundleContext bundleContext, NavigationEnv navigationEnv, IVehicle iVehicle, OnlineSearchControllerEvo onlineSearchControllerEvo, HomeAddressHandler homeAddressHandler, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, IStartGuidanceManager iStartGuidanceManager, CombiBAPListener combiBAPListener, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, NaviFavoriteHandlerEvo naviFavoriteHandlerEvo, IPoiService iPoiService, NaviServiceListener naviServiceListener, IAddressInputForm iAddressInputForm, MapInterface mapInterface, DispatcherBase dispatcherBase, ITelService iTelService, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, ICarKombiService iCarKombiService, IDestinationHandler iDestinationHandler) {
        this.env = navigationEnv;
        this.logger = navigationEnv.getLogChannel("App.Navi.Search");
        this.countrySelection = Util.isHURegionNAR() ? new CountrySelectionNAR(navigationEnv, iCommandListFactory, iconHandler) : new CountrySelection(navigationEnv, iCommandListFactory, iconHandler);
        this.intelliDestSearchTimer = Util.isHURegionAsia() ? new IntelliDestSearchTimerAsia(navigationEnv, this.logger) : new IntellDestSearchTimerDummy();
        this.activeDestionationsManager = new ActiveDestinationsManager(navigationEnv, iStartGuidanceManager);
        this.lastDestProducer = new LastDestProducer(this.logger, iCommandListFactory, navigationEnv);
        this.lastDestSearch = new LastDestSearch(bundleContext, navigationEnv, 7, this.logger, combiBAPListener, naviServiceListener, new SearchResultNavLocationExtractor(searchResultAsyncNavLocationExtractor));
        this.destSearch = Util.isHURegionAsia() ? new IntelliDestSearchAsia(this, bundleContext, navigationEnv.getFramework(), 0, iVehicle, this.logger, navigationEnv, this.lastDestSearch) : new IntelliDestSearch(this, bundleContext, navigationEnv.getFramework(), 0, iVehicle, this.logger, navigationEnv, this.lastDestSearch);
        this.distanceCalculator = new TrufflesDistanceCalculator(iVehicle, this.logger, navigationEnv.getBaseListModel(-1541470720), this.destSearch.getLock(), iCommandListFactory);
        this.intelliDestGuiHandler = new IntelliDestGuiSearchHandler(new int[]{14, 4, 5, 15, 3, 16}, navigationEnv.getBaseListModel(-1541470720), navigationEnv.getSpellerModel(Util.isHURegionKR() ? -886897152 : -2094791168), navigationEnv.getChoiceModel(-65206784), this.logger, this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, this.intelliDestSearchTimer, iCarKombiService, iDestinationHandler);
        this.intelliDestGuiHandler.setDistanceCalculator(this.distanceCalculator);
        this.pickHelpPersistanceHelper = new PickHelpPersistanceHelper(navigationEnv, 975);
        this.pickHelpManager = new PickHelpManager(navigationEnv, this.pickHelpPersistanceHelper);
        this.intelliDestHMIListener = new IntelliDestHMIListener(navigationEnv, this.intelliDestGuiHandler, onlineSearchControllerEvo, this.activeDestionationsManager, this, dispatcherBase, iTelService, iCommandListFactory, homeAddressHandler, this.countrySelection, iPoiService);
        this.demoModeGuiHandler = new DemoModeSearchGuiHandler(new int[]{4, 5, 16}, navigationEnv.getBaseListModel(0x200600), navigationEnv.getSpellerModel(18875904), navigationEnv.getChoiceModel(0x2200600), this.logger, this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, new IntellDestSearchTimerDummy());
        SearchResultFormatterNavDb searchResultFormatterNavDb = new SearchResultFormatterNavDb(interAppService, iconHandler, this.logger, naviFavoriteHandlerEvo, navigationEnv);
        this.lastDestCache = new LastDestCacheSearchHandler(new int[]{4}, navigationEnv.getBaseListModel(2065958400), navigationEnv.getSpellerModel(-501283328), navigationEnv.getChoiceModel(-484506112), this.logger, this.lastDestSearch, dispatcherBase, searchResultFormatterNavDb);
        this.lastDestGuiHandler = new LastDestGuiSearchHandler(new int[]{4}, navigationEnv.getBaseListModel(-518060544), navigationEnv.getSpellerModel(-501283328), navigationEnv.getChoiceModel(-484506112), this.logger, this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, new IntellDestSearchTimerDummy());
        this.favoritesGuiHandler = new FavoriteGuiSearchHandler(new int[]{5}, navigationEnv.getBaseListModel(220202496), navigationEnv.getSpellerModel(-1222703616), navigationEnv.getChoiceModel(169870848), this.logger, (AbstractSearch)this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, (INaviFavoriteHandler)naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, new FavoriteSearchFormatter(interAppService, iconHandler, this.logger, naviFavoriteHandlerEvo, navigationEnv), naviServiceListener, new IntellDestSearchTimerDummy());
        this.destOptFavoritesGuiHandler = new FavoriteGuiSearchHandler(new int[]{5}, navigationEnv.getBaseListModel(-937359872), navigationEnv.getSpellerModel(-903805440), navigationEnv.getChoiceModel(-920582656), this.logger, (AbstractSearch)this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, (INaviFavoriteHandler)naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, new NoPropertyFormatterFavorites(interAppService, iconHandler, this.logger, naviFavoriteHandlerEvo, navigationEnv), naviServiceListener, new IntellDestSearchTimerDummy());
        this.destOptSelectionGuiHandler = new IntelliDestOptSelection(new int[]{16}, navigationEnv.getBaseListModel(-870316544), navigationEnv.getSpellerModel(-853539328), navigationEnv.getChoiceModel(-836762112), this.logger, this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, new IntellDestSearchTimerDummy());
        this.destOptContactsWithAddressGuiHandler = new AdbContactsWithAddressGuiSearchHandler(new int[]{3}, navigationEnv.getBaseListModel(1310721536), navigationEnv.getSpellerModel(1327498752), navigationEnv.getChoiceModel(-887093760), this.logger, this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, new IntellDestSearchTimerDummy());
        this.destOptAddAddressToContactGuiSearchHandler = new AdbContactsGuiSearchHandler(new int[]{3}, navigationEnv.getBaseListModel(1310721536), navigationEnv.getSpellerModel(1327498752), navigationEnv.getChoiceModel(-887093760), this.logger, this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, new IntellDestSearchTimerDummy());
        this.intelliDestGuiExternalHandler = new IntelliDestGuiSearchHandler(new int[]{14, 4, 5, 15, 16}, navigationEnv.getBaseListModel(-1541470720), navigationEnv.getSpellerModel(Util.isHURegionKR() ? -886897152 : -2094791168), navigationEnv.getChoiceModel(-65206784), this.logger, this.destSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, naviFavoriteHandlerEvo, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, this.intelliDestSearchTimer, iCarKombiService, iDestinationHandler);
        this.intelliDestGuiHandler.setDistanceCalculator(this.distanceCalculator);
        this.destSearch.setActiveGuiSearchHandler(this.intelliDestGuiHandler);
        this.destSearch.startDSI();
        this.currentGuiHandler = this.intelliDestGuiHandler;
        this.intelliDestGuiHandler.activate();
        this.intelliDestGuiHandler.loadInitialScreen();
        this.lastDestSearch.setActiveGuiSearchHandler(this.lastDestCache);
        this.lastDestSearch.startDSI();
        this.lastDestCache.activate();
        this.pressRoutesDataProvider = new IntelliDestPressRoutesDataProvider(this.logger, navigationEnv, bundleContext, 14);
        this.pressRoutesDataProvider.start();
    }

    @Override
    public void enterDestinationContext(int n) {
        this.logger.log(-2137614336, "%1#enterDestinationContext - %2", (Object)"IntelliDestController", (long)n);
        IntelliDestGuiSearchHandler intelliDestGuiSearchHandler = null;
        switch (n) {
            case 0: {
                intelliDestGuiSearchHandler = this.intelliDestGuiHandler;
                break;
            }
            case 1: {
                intelliDestGuiSearchHandler = this.demoModeGuiHandler;
                break;
            }
            case 2: {
                intelliDestGuiSearchHandler = this.favoritesGuiHandler;
                break;
            }
            case 3: {
                intelliDestGuiSearchHandler = this.destOptSelectionGuiHandler;
                break;
            }
            case 4: {
                intelliDestGuiSearchHandler = this.destOptContactsWithAddressGuiHandler;
                break;
            }
            case 5: {
                intelliDestGuiSearchHandler = this.lastDestGuiHandler;
                break;
            }
            case 6: {
                intelliDestGuiSearchHandler = this.destOptAddAddressToContactGuiSearchHandler;
                break;
            }
            case 7: {
                intelliDestGuiSearchHandler = this.destOptFavoritesGuiHandler;
                break;
            }
            case 8: {
                intelliDestGuiSearchHandler = this.intelliDestGuiExternalHandler;
                break;
            }
            default: {
                intelliDestGuiSearchHandler = this.intelliDestGuiHandler;
            }
        }
        intelliDestGuiSearchHandler.setCurrentTrufflesContext(n);
        if (intelliDestGuiSearchHandler.equals(this.currentGuiHandler)) {
            this.logger.log(-2137614336, "[%1#enterDestinationContext()] Search handler is already active.", (Object)"IntelliDestController");
        } else {
            if (null != this.currentGuiHandler) {
                this.currentGuiHandler.deactivate();
            }
            this.currentGuiHandler = intelliDestGuiSearchHandler;
            this.destSearch.setActiveGuiSearchHandler(this.currentGuiHandler);
            this.currentGuiHandler.activate();
        }
        this.currentGuiHandler.setIsActive(true);
        if (n == 0) {
            this.startDistanceCalculator();
            this.destSearch.turnMaxResultRestrictionOn();
        } else {
            this.destSearch.turnMaxResultRestrictionOff();
        }
        if (n == 5 || n == 7) {
            this.currentGuiHandler.loadInitialScreen();
        }
        if (n == 6) {
            this.currentGuiHandler.enterScreen();
        }
        if (this.downTransitionCalled) {
            if (n == 2) {
                this.favoritesGuiHandler.loadInitialScreen();
            } else if (n == 0) {
                this.intelliDestGuiHandler.loadInitialScreen();
                this.activeDestionationsManager.loadInitialScreen();
            }
            this.downTransitionCalled = false;
        } else if (this.currentGuiHandler.hasMissedInvalidateData()) {
            this.currentGuiHandler.refreshQuery();
        } else {
            this.getMainSearch().resumeQuery();
        }
    }

    @Override
    public void enterDestinationContextDownTransition(int n) {
        this.logger.log(-2137614336, "%1#enterDestinationContextDownTransition - %2", (Object)"IntelliDestController", (long)n);
        this.downTransitionCalled = true;
    }

    @Override
    public void exitDestinationContext(int n) {
        this.logger.log(-2137614336, "%1#exitDestinationContext - %2", (Object)"IntelliDestController", (long)n);
        this.currentGuiHandler.setIsActive(false);
        this.getMainSearch().cancelQuery();
        this.env.getChoiceModel(-1306327552).setValue(0);
        if (n == 0) {
            this.stopDistanceCalculator();
        }
    }

    public void startDistanceCalculator() {
        this.logger.log(-2137614336, "%1#startDistanceCalculator()", (Object)"IntelliDestController");
        if (this.distanceCalculator != null) {
            this.distanceCalculator.startCalculation();
        }
    }

    public void stopDistanceCalculator() {
        this.logger.log(-2137614336, "%1#stopDistanceCalculator()", (Object)"IntelliDestController");
        if (this.distanceCalculator != null) {
            this.distanceCalculator.stopCalculation();
        }
    }

    @Override
    public AbstractSearch getMainSearch() {
        return this.destSearch;
    }

    @Override
    public ILastDestHandler getLastDestHandler() {
        return this.lastDestSearch;
    }

    public void updateCountries(Country[] countryArray) {
        this.countrySelection.updateCountriesList(countryArray);
    }

    public String[] getSelection() {
        this.logger.log(-2137614336, "%1#getSelection()", (Object)"IntelliDestController");
        return this.countrySelection.getActiveCountries();
    }

    @Override
    public void exitTrufflesRangeSelect() {
        this.logger.log(-2137614336, "%1#exitTrufflesRangeSelect()", (Object)"IntelliDestController");
        this.countrySelection.savePersistentState();
        this.destSearch.setActiveSearchCountries(this.countrySelection.getActiveCountries());
    }

    @Override
    public void updateRouteInfo(Route route, TripHandler$TripData tripHandler$TripData) {
        this.activeDestionationsManager.updateRouteInfo(route, tripHandler$TripData);
    }

    @Override
    public void updateRgActive(boolean bl) {
        this.activeDestionationsManager.updateRgActive(bl);
    }

    public void deinit(BundleContext bundleContext) {
        this.intelliDestGuiHandler.release();
        this.intelliDestGuiExternalHandler.release();
        this.demoModeGuiHandler.release();
        this.lastDestCache.release();
        this.favoritesGuiHandler.release();
        this.destOptFavoritesGuiHandler.release();
        this.destOptSelectionGuiHandler.release();
        this.lastDestGuiHandler.release();
        this.destOptContactsWithAddressGuiHandler.release();
        this.destOptAddAddressToContactGuiSearchHandler.release();
        this.destSearch.stopDSI(bundleContext);
        this.lastDestSearch.stopDSI(bundleContext);
        this.pressRoutesDataProvider.stop();
        this.distanceCalculator.stopCalculation();
        this.intelliDestHMIListener.deinit();
        this.intelliDestHMIListener = null;
    }

    @Override
    public void routeGuidanceRequested(Route route, NavLocation navLocation) {
        this.activeDestionationsManager.routeGuidanceToDestinationRequested();
        this.getMainSearch().cancelQuery();
        this.stopDistanceCalculator();
        this.intelliDestGuiHandler.cancelJobs();
        this.lastDestProducer.createAndSaveLastDestination(navLocation, this.getMainSearch());
    }

    @Override
    public void cancelStartRouteCalculation() {
        this.activeDestionationsManager.cancelStartRouteCalculation();
    }

    @Override
    public NavLocation getNavLocationByIndex(int n) {
        EvoListRow evoListRow = this.env.getBaseListModel(-1541470720).getRow(n);
        return this.intelliDestGuiHandler.extractNavLocationFromRow(evoListRow);
    }

    @Override
    public int startTrufflesSearch(String string, String[] stringArray) {
        this.enterDestinationContext(8);
        if (Util.isHURegionKR()) {
            this.env.getSpellerModel(-886897152).setText(string);
        } else {
            this.env.getSpellerModel(-2094791168).setText(string);
        }
        this.currentGuiHandler.performQuery(string, stringArray);
        this.currentGuiHandler.cacheQueryIDForSDSSearch();
        return this.destSearch.getLastQueryID();
    }

    @Override
    public void cancelSDSTrufflesSearch(boolean bl) {
        this.getMainSearch().cancelQuery();
        if (bl) {
            this.currentGuiHandler.clearSpellerModel();
        }
    }

    @Override
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.distanceCalculator.updateRrdCalculationInfo(rrdCalculationInfoArray);
    }

    @Override
    public void resetSettings() {
        if (this.pickHelpManager != null) {
            this.pickHelpManager.resetSettings();
        }
        this.countrySelection.resetSettings();
        this.destSearch.setActiveSearchCountries(this.countrySelection.getActiveCountries());
    }

    @Override
    public void setADBHMIAppService(ADBHMIAppService aDBHMIAppService) {
        this.intelliDestGuiHandler.setADBHMIAppService(aDBHMIAppService);
    }

    public ActiveDestinationsManager getActiveDestinationsManager() {
        return this.activeDestionationsManager;
    }

    @Override
    public void updateRmRoutesPress() {
        this.pressRoutesDataProvider.updateRmRoutesPress();
    }

    @Override
    public boolean isTrufflesConflictmodeAvailable() {
        return this.currentGuiHandler.equals(this.intelliDestGuiExternalHandler) && this.env.getChoiceModel(-803142144).getValue() != 0;
    }

    @Override
    public int triggerTrufflesConflictmode(String string, String[] stringArray) {
        if (!this.isTrufflesConflictmodeAvailable()) {
            this.logger.log(-1601830656, "%1#triggerTrufflesConflictmode was called but conflict mode was currently not available", (Object)"IntelliDestController");
        }
        this.destSearch.setConflictMode(true);
        this.env.getChoiceModel(-803142144).setValue(0);
        return this.startTrufflesSearch(string, stringArray);
    }
}

