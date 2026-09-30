/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.poi.online;

import de.audi.app.navi.evo.poi.online.OnlineSearchHistoryEvo;
import de.audi.app.navi.evo.poi.online.PoiOnlineListRow;
import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListListener;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.phone.ITelServiceListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.INavigationInputModeManager;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationBrowser;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.addressinput.poi.rrd.IRRDListener;
import de.audi.tghu.navi.app.command.poi.online.OnlineSearchProviderHandler;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.phone.ITelServiceController;
import de.audi.tghu.navi.app.poi.PhoneUtil;
import de.audi.tghu.navi.app.poi.online.IOnlineSearchForm;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.poi.online.OnlineSearchContext;
import de.audi.tghu.navi.app.poi.online.OnlineSearchHistory;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import de.audi.tghu.navi.app.poi.online.PoiOnlineSearchArea;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class OnlineSearchForm
implements IOnlineSearchForm,
SpellerListener,
ListListener,
ButtonListener {
    private static final int ACTIVE_APPLICATION_ONLINE = 22;
    private static final int ACTIVE_APPLICATION_NAVI = 5;
    private static final int ACTIVE_APPLICATION_ADB = 4;
    private static final int NAV_ONLINE_MODE_NAVI_ONLINE = 0;
    private static final int NAV_ONLINE_MODE_ADB = 1;
    private static final int CELL_FOR_DATA_EXPANSION = 12;
    private static final int CHOICE_ENABLED = 0;
    private static final int CHOICE_DISABLED = 1;
    private final NavigationEnv env;
    private final LogChannel logChannel;
    private final OnlineSearchSequence onlineSearchSequence;
    private final OnlineSearchHistory searchHistory;
    private NavLocation poiLocation;
    private final OnlineSearchProviderHandler providerHandler;
    private final IconHandler iconHandler;
    private final IVehicle vehicle;
    private final IStartGuidanceToDestinationSequence startGuidanceToDestinationSequence;
    private final ISDSController sdsController;
    private final ITelServiceController telServiceController;
    private int currentList = 0;
    private final IPreviewMap previewMapProxy;
    private NavigationBrowser navigationBrowser;
    private NaviADBHandler naviAdbHandler;
    private INavigationInputModeManager inputManager;
    private IAddressInputForm inputForm;
    private IRRDListener rrdListener;
    private boolean isRRDRunning = false;
    private final IRouteManager routeManager;
    private String previousSearchTerm;
    private boolean previousRequestSuggestion;
    private final HomeAddressHandler homeAddressHandler;
    private boolean onlineSearchEnteredForTheFirstTime = true;

    public OnlineSearchForm(NavigationEnv navigationEnv, OnlineSearchSequence onlineSearchSequence, IconHandler iconHandler, IVehicle iVehicle, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ISDSController iSDSController, ITelServiceController iTelServiceController, IPreviewMap iPreviewMap, NavigationBrowser navigationBrowser, NaviADBHandler naviADBHandler, IAddressInputForm iAddressInputForm, IRRDListener iRRDListener, IRouteManager iRouteManager, HomeAddressHandler homeAddressHandler) {
        this.env = navigationEnv;
        this.iconHandler = iconHandler;
        this.sdsController = iSDSController;
        this.vehicle = iVehicle;
        this.startGuidanceToDestinationSequence = iStartGuidanceToDestinationSequence;
        this.telServiceController = iTelServiceController;
        this.previewMapProxy = iPreviewMap;
        this.navigationBrowser = navigationBrowser;
        this.naviAdbHandler = naviADBHandler;
        this.inputManager = navigationEnv.getInputModeManager();
        this.inputForm = iAddressInputForm;
        this.homeAddressHandler = homeAddressHandler;
        this.logChannel = navigationEnv.getOnlineLogChannel();
        this.rrdListener = iRRDListener;
        this.routeManager = iRouteManager;
        this.onlineSearchSequence = onlineSearchSequence;
        this.setListeners();
        this.providerHandler = new OnlineSearchProviderHandler(this.logChannel, navigationEnv, null);
        navigationEnv.getLabelModel(400626).setStatus(0);
        this.searchHistory = new OnlineSearchHistoryEvo(navigationEnv, navigationEnv.getListModel(400615), navigationEnv.getListModel(400616), navigationEnv.getSpellerModel(400624));
        this.doLoadState();
        this.poiLocation = null;
        this.logChannel.log(1000000, "OnlineSearchForm#OnlineSearchForm()");
    }

    private void setListeners() {
        this.logChannel.log(1000000, "OnlineSearchForm#setListeners() Setting HMI Listeners for poi online");
        this.env.getSpellerModel(400624).setSpellerListener(this);
        this.env.getSpellerModel(400624).setMinLength(1);
        this.env.getSpellerModel(400624).setMaxLength(128);
        this.env.getListModel(400615).setListListener(this);
        this.env.getListModel(400615).setMaxColumns(2);
        this.env.getListModel(400615).setMaxRows(OnlineSearchHistory.MAX_HISTORY_LENGTH);
        this.env.getListModel(400616).setMaxColumns(2);
        this.env.getListModel(400616).setMaxRows(4);
        this.env.getListModel(400618).setListListener(this);
        this.env.getListModel(400618).setMaxColumns(PoiOnlineListRow.getMaxColumns());
        this.env.getListModel(400618).setMaxRows(10);
        this.env.getButtonModel(400629).setButtonListener(this);
        this.env.getLabelModel(400630).setText("");
        this.env.getButtonModel(400195).setButtonListener(this);
        this.env.getButtonModel(400191).setButtonListener(this);
        this.env.getButtonModel(400970).setButtonListener(this);
        this.env.getButtonModel(400186).setButtonListener(this);
        this.env.getButtonModel(400631).setButtonListener(this);
        this.env.getButtonModel(400623).setButtonListener(this);
        this.env.getButtonModel(400622).setButtonListener(this);
        this.env.getButtonModel(400581).setButtonListener(this);
        this.env.getButtonModel(400585).setButtonListener(this);
        this.env.getButtonModel(400634).setButtonListener(this);
        this.env.getButtonModel(400582).setButtonListener(this);
        this.env.getButtonModel(401185).setButtonListener(this);
        this.env.getButtonModel(401015).setButtonListener(this);
        this.env.getButtonModel(401016).setButtonListener(this);
        this.env.getButtonModel(401317).setButtonListener(this);
        this.env.getButtonModel(401325).setButtonListener(this);
        this.env.getButtonModel(401465).setButtonListener(this);
        this.env.getButtonModel(401561).setButtonListener(this);
        this.env.getButtonModel(401472).setButtonListener(this);
        this.env.getButtonModel(401474).setButtonListener(this);
        this.env.getButtonModel(401471).setButtonListener(this);
        this.env.getButtonModel(401498).setButtonListener(this);
        this.env.getButtonModel(401550).setButtonListener(this);
        this.env.getButtonModel(401560).setButtonListener(this);
    }

    private final void doLoadState() {
        this.logChannel.log(1000000, "OnlineSearchForm#loadState() Loading search history state.");
        this.searchHistory.loadState();
    }

    public void loadState() {
        this.doLoadState();
    }

    public void resetMemory() {
        this.logChannel.log(1000000, "OnlineSearchForm#resetMemory() Reseting search history memory.");
        this.searchHistory.resetHistory();
    }

    public void refreshSearchHistory() {
        this.logChannel.log(1000000, "OnlineSearchForm#refreshSearchHistory() Refreshing search history.");
        this.searchHistory.refreshSearchHistory();
        this.configurePreviewMapOnSearchArea();
    }

    public void startSearchWithSpellingSuggestion() {
        String string = this.env.getLabelModel(400630).getText();
        this.logChannel.log(10000000, "OnlineSearchForm#startSearchWithSpellingSuggestion: Using text %1", (Object)string);
        this.startSearch(string, false);
    }

    public void enterOnlineSearchForm() {
        this.logChannel.log(10000000, "OnlineSearchForm#enterOnlineSearchForm");
        this.setNavOnlineMode();
        this.performFirstTimeEnterActions();
        this.setSearchAreaOptions();
        this.resetHistoryList();
        this.showList(0);
    }

    private void setNavOnlineMode() {
        int n = this.env.getChoiceModel(8).getValue();
        switch (n) {
            case 5: 
            case 22: {
                this.env.getChoiceModel(402784).setValue(0);
                break;
            }
            case 4: {
                this.env.getChoiceModel(402784).setValue(1);
                break;
            }
        }
    }

    private void performFirstTimeEnterActions() {
        if (this.onlineSearchEnteredForTheFirstTime) {
            this.onlineSearchEnteredForTheFirstTime = false;
            NavLocation navLocation = Util.isHURegionAsia() ? this.vehicle.getVehicleLocationDescription() : this.vehicle.getVehicleLocation();
            this.logChannel.log(10000000, "OnlineSearchForm#performFirstTimeEnterActions - location=%1", (Object)LocationFormatter.formatLocationShort(navLocation));
            this.onlineSearchSequence.setInitialNavLocationForSearchArea(navLocation);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logChannel.log(10000000, "OnlineSearchForm#keyTyped( %1 %2)", (long)n, (long)n2);
        switch (n) {
            case 400624: {
                this.logChannel.log(10000000, "OnlineSearchForm#keyTyped - NAV_P_O_I_GOOGLE_SEARCH_SPELLER");
                String string = this.env.getSpellerModel(400624).getText();
                this.startSearch(string, true);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400629: {
                this.logChannel.log(10000000, "OnlineSearchForm#keyTyped - NAV_P_O_I_GOOGLE_SPELLING_SUGGESTION_BUTTON");
                this.startSearchWithSpellingSuggestion();
                break;
            }
            case 400195: {
                this.logChannel.log(10000000, "OnlineSearchForm#keyTyped - NAV_DEST_P_O_I_AREA_GOOGLE_BUTTON");
                this.onlineSearchSequence.setSearchArea(0);
                if (this.currentList == 1) {
                    this.startSearch(this.previousSearchTerm, this.previousRequestSuggestion);
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400191: {
                this.logChannel.log(10000000, "OnlineSearchForm#keyTyped - NAV_DEST_P_O_I_AREA_DESTINATION_ONLINE_BUTTON");
                this.onlineSearchSequence.setSearchArea(1);
                if (this.currentList == 1) {
                    this.startSearch(this.previousSearchTerm, this.previousRequestSuggestion);
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400970: {
                this.logChannel.log(10000000, "OnlineSearchForm#keyTyped - NAV_DEST_P_O_I_AREA_STOPOVER_ONLINE_BUTTON");
                this.onlineSearchSequence.setSearchArea(2);
                if (this.currentList == 1) {
                    this.startSearch(this.previousSearchTerm, this.previousRequestSuggestion);
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400631: {
                this.logChannel.log(10000000, "OnlineSearchForm#keyTyped - NAV_P_O_I_GOOGLE_WAIT_ABORT_BUTTON");
                this.onlineSearchSequence.abortSearch();
                this.sdsController.abortSDSSession(false);
                this.resetAfterAbort();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400623: {
                this.onlineSearchSequence.requestValueList(0);
                break;
            }
            case 400622: {
                this.onlineSearchSequence.requestValueList(1);
                break;
            }
            case 400634: {
                this.setSearchAreaOptions();
                this.resetHistoryList();
                this.showList(0);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 400585: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped - save in address book");
                this.naviAdbHandler.startStoringAddress(this.poiLocation);
                this.env.fireModelEvent(n, n3);
                this.onlineSearchSequence.markCurrentResultUsedFor(12);
                break;
            }
            case 400582: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped - store as favorite");
                this.env.fireModelEvent(n, n3);
                this.onlineSearchSequence.markCurrentResultUsedFor(0);
                break;
            }
            case 401325: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped - DEST_OPT_ONLINE_SEARCH_AREA_MAIN_BUTTON");
                if (this.inputManager == null) {
                    return;
                }
                this.inputManager.setInputMode(6, this.env);
                this.inputForm.startForOnline();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401185: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped: hk_return virtual button in browser pressed");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401015: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped: delete search history cancel");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401016: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped: delete search history");
                this.resetMemory();
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401561: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped: new search");
                this.env.getSpellerModel(400624).setText("");
                this.searchHistory.refreshSearchHistory();
                this.showList(0);
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401317: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped: spelling suggestion from error screen");
                this.startSearchWithSpellingSuggestion();
                break;
            }
            case 401465: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped: try again selected");
                if (this.previousSearchTerm != null) {
                    this.startSearch(this.previousSearchTerm, true);
                } else {
                    this.logChannel.log(100000, "OnlineSearchForm#keyTyped: no previousSearchTerm found");
                }
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401550: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401560: {
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401472: {
                String string = LocationFormatter.getURLAddress(this.poiLocation);
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped(DEST_OPT_SHOW_DETAILS_ONLINE_POI_ADDITIONAL_INFO_BUTTON) - loading URL: '%1' ", (Object)string);
                boolean bl = this.navigationBrowser.loadURL(2, string, true);
                if (bl) {
                    this.env.fireModelEvent(n, n3);
                    this.onlineSearchSequence.markCurrentResultUsedFor(0);
                    break;
                }
                this.logChannel.log(10000, "OnlineSearchForm#keyTyped(DEST_OPT_SHOW_DETAILS_ONLINE_POI_ADDITIONAL_INFO_BUTTON) - failed to load url: '%1' ", (Object)string);
                break;
            }
            case 401474: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped(DEST_OPT_SHOW_DETAILS_ONLINE_POI_CALL_BUTTON) - calling number");
                String string = LocationFormatter.formatPhonenumber(this.poiLocation);
                String string2 = LocationFormatter.formatPOIName(this.poiLocation);
                if (!this.dialNumber(string2, string)) break;
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped(DEST_OPT_SHOW_DETAILS_ONLINE_POI_CALL_BUTTON) - firing model event");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401471: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped(DEST_OPT_SHOW_DETAILS_ONLINE_POI_RG_START_BUTTON) - starting route guidance");
                CommandList commandList = this.onlineSearchSequence.startRouteGuidance(this.startGuidanceToDestinationSequence);
                commandList.execute("OnlineSearchForm#NAV_P_O_I_ONLINE_ROUTE_GUIDENCE");
                this.env.fireModelEvent(n, n3);
                break;
            }
            case 401498: {
                this.logChannel.log(1000000, "OnlineSearchForm#keyTyped(NAV_P_O_I_GOOGLE_DELETE_SEARCH_HISTORY_POPUP_ORDER_BUTTON) - Setting the position of cursor to 0");
                MenuModelApp menuModelApp = this.env.getMenuModel(401497);
                menuModelApp.setFocusedItem(0, FocusAdvice.KEEP_POSITION, -1L);
                this.env.fireModelEvent(n, n3);
                break;
            }
        }
    }

    public void resetAfterAbort() {
        this.env.getListModel(400618).setStatus(1);
        this.env.getSpellerModel(400624).setText("");
        this.resetHistoryList();
        this.refreshSearchHistory();
        this.showList(0);
    }

    private void setSearchAreaOptions() {
        boolean bl = this.env.getContainer().isRgActive();
        int n = RouteUtil.getNumberOfDestinations(this.routeManager.getRoute(), 1);
        this.logChannel.log(1000000, new StringBuffer().append("OnlineSearchForm#setSearchAreaOptions: configurating searchArea: RouteGuidance Active").append(bl).toString());
        this.updateRGActiveModels(bl, n);
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
        if (this.env.getChoiceModel(335).getValue() == 2 || this.env.getChoiceModel(335).getValue() == 8) {
            this.logChannel.log(10000000, "OnlineSearchForm#textChanged: SDS running, discarding textChanged event");
            return;
        }
        this.logChannel.log(10000000, "OnlineSearchForm#textChanged( %1) ", (Object)string);
        if (n == 400624) {
            this.env.getLabelModel(400630).setText("");
            this.refreshSearchHistory();
            this.showList(0);
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.logChannel.log(1000000, "OnlineSearchForm#itemSelected( %1) ", (long)n);
        if (n == 400615) {
            TextListCell textListCell = (TextListCell)this.env.getListModel(400615).getCell(n2, 0);
            String string = textListCell.getText();
            this.startSearch(string, true);
            this.env.fireModelEvent(n, n4);
        } else if (n == 400618) {
            int n5 = this.env.getChoiceModel(401246).getValue();
            OnlinePOIResultList onlinePOIResultList = this.onlineSearchSequence.getSearchContext().getResultList();
            PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = onlinePOIResultList == null ? null : onlinePOIResultList.getPOIElementAt(n2);
            ADBInterAppService aDBInterAppService = this.naviAdbHandler.getADBInterAppService();
            if (n5 == 1) {
                String string;
                String string2 = string = poiOnlineSearchValuelistElement == null ? "" : poiOnlineSearchValuelistElement.name;
                if (string.length() == 0) {
                    this.logChannel.log(100000, "OnlineSearchForm#itemSelected: onlinePOIName is empty for poiLocation '%1'", (Object)this.poiLocation);
                }
                byte[] byArray = aDBInterAppService.resolveGeoCoords(this.poiLocation.longitude, this.poiLocation.latitude, string);
                NaviADBService.LocationInputHandler locationInputHandler = aDBInterAppService.getCurrentLocationInputHandler();
                if (locationInputHandler != null) {
                    locationInputHandler.updateLocation(byArray);
                    aDBInterAppService.removeHandler();
                }
                this.env.fireModelEvent(n, n4);
            } else if (n5 == 2) {
                byte[] byArray = aDBInterAppService.resolveGeoCoords(poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude, poiOnlineSearchValuelistElement.name);
                NavLocation navLocation = aDBInterAppService.streamToLocation(byArray);
                this.logChannel.log(10000000, "OnlineSearchForm#itemSelected: save NavLocation '%1' as home address", (Object)navLocation);
                this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
                this.env.fireModelEvent(n, n4);
            } else {
                this.logChannel.log(10000000, "OnlineSearchForm#itemSelected( %1) - Starting route guidance", (long)n);
                CommandList commandList = this.onlineSearchSequence.startRouteGuidance(this.startGuidanceToDestinationSequence);
                commandList.execute("OnlineSearchForm#NAV_P_O_I_ONLINE_ROUTE_GUIDENCE");
                this.env.fireModelEvent(n, n4);
            }
        } else {
            this.logChannel.log(10000000, "OnlineSearchForm#itemSelected() - modelID %1 not supported! ", (long)n);
        }
    }

    public void startSearch(String string, boolean bl) {
        this.logChannel.log(1000000, "OnlineSearchForm#startSearch( %1 ) ", (Object)string);
        this.previousSearchTerm = string;
        this.previousRequestSuggestion = bl;
        this.stopRRDCalculation();
        this.onlineSearchSequence.startSearch(string, bl);
        this.showList(1);
        this.env.getSpellerModel(400624).setText(string);
        this.searchHistory.handleSearchText(string);
    }

    public void showList(int n) {
        this.logChannel.log(1000000, "OnlineSearchForm#showList: List shown is '%1' ", (Object)(n == 1 ? "LIST_RESULTS" : "LIST_HISTORY"));
        this.env.getChoiceModel(400628).setValue(n);
        this.currentList = n;
        this.providerHandler.updateVisibility(n);
        if (n != 1) {
            this.configurePreviewMapOnSearchArea();
        }
    }

    private void configurePreviewMapOnSearchArea() {
        if (this.onlineSearchSequence.isSpellerOpen()) {
            this.logChannel.log(1000000, "OnlineSearchForm#configurePreviewMapOnSearchArea: speller is open so not configuring map");
            return;
        }
        this.onlineSearchSequence.previewSearchArea();
        this.logChannel.log(1000000, "OnlineSearchForm#configurePreviewMapOnSearchArea: preview location updated");
    }

    public void itemFocused(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "OnlineSearchForm#itemFocused() Model Id is '%1' and row is '%2' ", (long)n, (long)n2);
        if (n == 400618) {
            this.logChannel.log(1000000, "OnlineSearchForm#itemFocused() - %1", (long)n2);
            this.env.getListModel(400618).setSelected(n2);
            if (n2 != -1) {
                CommandList commandList = this.onlineSearchSequence.refreshDetailsFor(n2);
                commandList.execute("OnlineSearchForm#NAV_P_O_I_ONLINE_RESULTS_LIST");
                OnlinePOIResultList onlinePOIResultList = this.onlineSearchSequence.getSearchContext().getResultList();
                PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = onlinePOIResultList.getPOIElementAt(n2);
                LabelModelApp labelModelApp = this.env.getLabelModel(401477);
                labelModelApp.setText(poiOnlineSearchValuelistElement.name);
                LabelModelApp labelModelApp2 = this.env.getLabelModel(401473);
                labelModelApp2.setText(PoiOnlineListRow.getCustomAddress(poiOnlineSearchValuelistElement));
                if (!this.env.getFramework().isTarget()) {
                    NavLocation navLocation = Util.getLocationFromGeoPos(poiOnlineSearchValuelistElement.longitude, poiOnlineSearchValuelistElement.latitude);
                    this.updateSelectedOnlineDetails(onlinePOIResultList, poiOnlineSearchValuelistElement, navLocation, n2);
                }
            } else if (!this.onlineSearchSequence.isSpellerOpen()) {
                this.logChannel.log(10000000, "OnlineSearchForm#itemFocused() - %1 speller is closed", (long)n2);
                OnlineSearchContext onlineSearchContext = this.onlineSearchSequence.getSearchContext();
                if (onlineSearchContext == null) {
                    this.logChannel.log(100000, "OnlineSearchForm#itemFocused() - OnlineSearchContext is null");
                    return;
                }
                PoiOnlineSearchArea poiOnlineSearchArea = onlineSearchContext.getSearchArea();
                if (poiOnlineSearchArea == null) {
                    this.logChannel.log(100000, "OnlineSearchForm#itemFocused() - PoiOnlineSearchArea is null");
                    return;
                }
                NavLocation navLocation = poiOnlineSearchArea.getNavLocation();
                if (navLocation == null) {
                    this.logChannel.log(100000, "OnlineSearchForm#itemFocused() - NavLocation is null for PoiOnlineSearchArea");
                    return;
                }
                this.previewMapProxy.setPreviewLocation(navLocation, 1, null, null);
            } else {
                this.logChannel.log(10000000, "OnlineSearchForm#itemFocused() - %1 speller is open", (long)n2);
                this.onlineSearchSequence.hidePreviewMap(this.previewMapProxy);
            }
        }
    }

    public void itemReleased(int n, int n2, int n3, int n4) {
        this.logChannel.log(10000000, "OnlineSearchForm#itemReleased( %1) ", (long)n);
        if (n == 400618) {
            this.env.getListModel(400618).setCell(n2, 12, IntegerListCell.create(0));
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "OnlineSearchForm#keyPressed( %1 %2)", (long)n, (long)n2);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logChannel.log(10000000, "OnlineSearchForm#commandPressed( %1 %2)", (long)n, (long)n2);
    }

    public void commandPressed(int n, int n2, int n3) {
        this.logChannel.log(10000000, "OnlineSearchForm#commandPressed( %1 %2)", (long)n, (long)n2);
        if (n2 == 4711) {
            this.onlineSearchSequence.setSpellerOpen(true);
            this.onlineSearchSequence.hidePreviewMap(this.previewMapProxy);
        } else if (n2 == 4712) {
            this.onlineSearchSequence.setSpellerOpen(false);
            this.configurePreviewMapOnSearchArea();
        }
    }

    public void focusedCharacter(int n, char c2, int n2) {
    }

    boolean dialNumber(String string, String string2) {
        this.logChannel.log(1000000, "OnlineSearchForm#keyTyped(): dialNumber( %1, %2 ) ", (Object)string, (Object)string2);
        string2 = PhoneUtil.makePhonenumberDialable(this.env, string2);
        if (Util.isEmpty(string2)) {
            this.logChannel.log(100000, "OnlineSearchForm#keyTyped(): number is empty");
            return false;
        }
        ITelService iTelService = this.telServiceController.getTelService();
        if (iTelService == null) {
            this.logChannel.log(10000, "OnlineSearchForm#keyTyped(): no tel service");
            return false;
        }
        iTelService.dialNumber(string2, new ITelServiceListener(){

            public void dialNumberResponse(int n) {
                OnlineSearchForm.this.logChannel.log(10000000, "OnlineSearchForm#dialNumberResponse( %1 ): %2", (Object)Integer.toString(n), (Object)(n == 0 ? "OK" : "Error"));
            }
        }, true);
        this.onlineSearchSequence.markCurrentResultUsedFor(11);
        return true;
    }

    public OnlineSearchSequence getOnlineSearchSequence() {
        return this.onlineSearchSequence;
    }

    public void resetSpellingSuggestion() {
        this.logChannel.log(1000000, "OnlineSearchForm#resetSpellingSuggestion() Resetting spelling suggestion.");
        this.env.getLabelModel(400630).setText("");
    }

    public void updateProvider(int n, String string, String string2, String string3, String string4, String string5, String string6, String string7) {
        this.logChannel.log(1000000, "OnlineSearchForm#updatePOIOnlineProvider(): source %1, provider %2, ", (Object)Integer.toString(n), (Object)string);
        try {
            this.providerHandler.updateProviderName(string);
            this.providerHandler.updateLogos(n, string2, string3, string4, string5, string6, string7);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "Could not perform logo update, message is %1.", (Throwable)exception);
        }
    }

    public void updateSelectedOnlineDetails(OnlinePOIResultList onlinePOIResultList, PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation, int n) {
        Object object;
        this.logChannel.log(10000000, "OnlineSearchForm#updateSelectedOnlineDetails() - %1, %2", (Object)poiOnlineSearchValuelistElement, (Object)LocationFormatter.formatLocationShort(navLocation));
        LabelModelApp labelModelApp = this.env.getLabelModel(401475);
        LabelModelApp labelModelApp2 = this.env.getLabelModel(401896);
        if (poiOnlineSearchValuelistElement.getPhone() != null && poiOnlineSearchValuelistElement.getPhone().length() > 0) {
            Util.setPhoneNumberOnLocation(navLocation, poiOnlineSearchValuelistElement.getPhone());
            object = LocationFormatter.formatPhonenumber(navLocation);
            labelModelApp.setText((String)object);
            labelModelApp.setStatus(1);
            labelModelApp2.setText((String)object);
            labelModelApp2.setStatus(1);
        } else {
            labelModelApp.setText("");
            labelModelApp.setStatus(0);
            labelModelApp2.setText("");
            labelModelApp2.setStatus(0);
        }
        object = this.env.getListModel(400618).getRow(n);
        this.handleIfPoiIsCallable(navLocation, (BaseListRow)object);
        this.poiLocation = navLocation;
        Util.setOnlinePOINameOnLocation(this.poiLocation, poiOnlineSearchValuelistElement.name);
        String string = LocationFormatter.getURLAddress(this.poiLocation);
        ButtonModelApp buttonModelApp = this.env.getButtonModel(401472);
        if (string == null || string.length() == 0) {
            buttonModelApp.setStatus(0);
        } else {
            buttonModelApp.setStatus(1);
        }
        int n2 = onlinePOIResultList.getStyleTypeAt(n);
        int n3 = this.iconHandler.resolveTargetIcon(n2);
        ResourceLocatorModelApp resourceLocatorModelApp = this.env.getResourceLocatorModel(401476);
        if (resourceLocatorModelApp != null) {
            this.logChannel.log(10000000, "OnlineSearchForm#updateSelectedOnlineDetails() - updating pin %1 (ID %2)", (Object)Integer.toString(n), (Object)Integer.toString(n3));
            resourceLocatorModelApp.setResourceLocator(n3, ResourceLocatorModelApp.UNDEFINED_URI);
        } else {
            this.logChannel.log(10000000, "OnlineSearchForm#updateSelectedOnlineDetails() - PIN model not found");
        }
        Util.setURLOnLocation(navLocation, poiOnlineSearchValuelistElement.url);
    }

    public void indicateError(int n, String string) {
        this.logChannel.log(1000000, "OnlineSearchForm#indicateError() Error in getting result list.");
        this.env.getChoiceModel(400614).setValue(n);
        this.env.getLabelModel(400613).setText(string);
        this.env.getListModel(400618).clear();
        this.env.getListModel(400618).setStatus(2);
    }

    public void setSearchTextLabel(String string) {
        this.logChannel.log(1000000, "OnlineSearchForm#setSearchTextLabel() Setting search text label.");
        this.env.getLabelModel(400625).setText(string);
    }

    public void clearResultList() {
        this.logChannel.log(1000000, "OnlineSearchForm#clearResultList() Clearing result list before populating results.");
        this.isRRDRunning = false;
        this.env.getListModel(400618).clear();
        this.env.getListModel(400618).setStatus(0);
        this.env.getButtonModel(400623).setStatus(0);
        this.env.getButtonModel(400622).setStatus(0);
    }

    public void resetHistoryList() {
        this.setPrevNextVisibility(false, false);
        this.resetSpellingSuggestion();
        this.searchHistory.refreshSearchHistory();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int updateResults(int n, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n2, int n3, boolean bl, OnlinePOIResultList onlinePOIResultList) {
        int n4;
        this.logChannel.log(10000000, "OnlineSearchForm#updateResults( %1 ) - #%2", (long)n2, (long)n3);
        int n5 = 0;
        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = poiOnlineSearchValuelist.getList();
        int n6 = poiOnlineSearchValuelistElementArray.length;
        this.onlineSearchSequence.setCurrentPOIOnlineList(poiOnlineSearchValuelist);
        PoiOnlineSearchArea poiOnlineSearchArea = this.getOnlineSearchSequence().getSearchContext().getSearchArea();
        onlinePOIResultList.updateResultList(poiOnlineSearchValuelistElementArray, bl ? poiOnlineSearchArea.getNavLocation() : null);
        ListModelApp listModelApp = this.env.getListModel(400618);
        try {
            listModelApp.beginTransaction();
            listModelApp.clear();
            for (n4 = 0; n4 < n6; ++n4) {
                PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = onlinePOIResultList.getPOIElementAt(n4);
                if (poiOnlineSearchValuelistElement == null) continue;
                int n7 = onlinePOIResultList.getStyleTypeAt(n4);
                boolean bl2 = this.env.getFramework().getSysConst(442) == 1;
                PoiOnlineListRow poiOnlineListRow = new PoiOnlineListRow(this.logChannel, poiOnlineSearchArea, this.vehicle, poiOnlineSearchValuelistElement, n7, this.iconHandler, poiOnlineSearchArea.getNavLocation(), bl2);
                listModelApp.addRow(poiOnlineListRow);
                ++n5;
            }
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "Exception while updating POI online list. %1", (Throwable)exception);
        }
        finally {
            listModelApp.endTransaction();
        }
        if (this.onlineSearchSequence.getSearchContext().getSearchArea().useRRD() && n5 > 0 && this.rrdListener != null) {
            this.rrdListener.enterRRD(5);
            this.logChannel.log(10000000, "OnlineSearchForm#updateResults: entering RRD calculation");
            this.isRRDRunning = true;
        }
        n4 = n2 + 1;
        int n8 = n2 + n6;
        Buffer buffer = new Buffer();
        buffer.append(n4);
        buffer.append('-');
        buffer.append(n8);
        this.env.getLabelModel(400620).setText(buffer.toString());
        this.env.getLabelModel(400619).setText(Integer.toString(n3));
        this.setPrevNextVisibility(n2 > 0, n8 < n3);
        this.env.getSpellerModel(400624).setExitButtonText(-1);
        return n5;
    }

    public void setResultsComplete() {
        this.logChannel.log(1000000, "OnlineSearchForm#setResultsComplete: Setting result list as complete.");
        this.env.getListModel(400618).setStatus(1);
        this.showList(1);
    }

    public void setPrevNextVisibility(boolean bl, boolean bl2) {
        int n = bl ? 1 : 0;
        Util.setModelStatus(this.env.getButtonModel(400623), n);
        int n2 = bl2 ? 1 : 0;
        Util.setModelStatus(this.env.getButtonModel(400622), n2);
    }

    public int getStopOverType() {
        this.logChannel.log(1000000, "OnlineSearchForm#getStopOverType() Getting stop over type.");
        return this.env.getChoiceModel(400192).getValue();
    }

    public void setSpellingsuggestion(String string) {
        this.logChannel.log(1000000, "OnlineSearchForm#setSpellingsuggestion() Setting spelling suggestion %1", (Object)string);
        this.env.getLabelModel(400630).setText(string);
        this.env.getSpellerModel(400624).setExitButtonText(-1);
    }

    public void setSpellerText(String string) {
        this.env.getSpellerModel(400624).setText(string);
    }

    public void setSearchLocation(int n, NavLocation navLocation) {
        this.logChannel.log(1000000, "OnlineSearchForm#setSearchLocation: %1", (long)n);
        LabelModelApp labelModelApp = this.env.getLabelModel(400626);
        labelModelApp.setStatus(n);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(401482);
        choiceModelApp.setValue(n);
        if (n == 3 && navLocation != null) {
            String string = LocationFormatter.formatCityTitleWithoutCityCenter(navLocation);
            labelModelApp.setText(string);
        }
        if (n == 3 && this.currentList == 1) {
            this.startSearch(this.previousSearchTerm, this.previousRequestSuggestion);
        }
        this.refreshSearchHistory();
    }

    private void stopRRDCalculation() {
        if (this.rrdListener != null && this.isRRDRunning) {
            this.rrdListener.exitRRD(5);
            this.isRRDRunning = false;
            this.logChannel.log(10000000, "OnlineSearchForm#stopRRDCalculation: exiting RRD calculation");
        }
    }

    public void onlineSearchExit() {
        this.logChannel.log(1000000, "OnlineSearchForm#onlineSearchExit: called");
        this.stopRRDCalculation();
        if (this.currentList == 1) {
            this.providerHandler.updateVisibility(0);
        }
    }

    public void updateRGActiveModels(boolean bl, int n) {
        this.setChoiceRouteActive(bl);
        this.setChoiceStopOverActive(bl, n);
        this.setChoiceDestinationActive(bl, n);
    }

    private void setChoiceRouteActive(boolean bl) {
        int n = bl ? 0 : 1;
        this.env.getChoiceModel(401301).setValue(n);
    }

    private void setChoiceStopOverActive(boolean bl, int n) {
        int n2 = bl && n > 1 ? 0 : 1;
        this.env.getChoiceModel(401303).setValue(n2);
    }

    private void setChoiceDestinationActive(boolean bl, int n) {
        int n2 = bl && n > 0 ? 0 : 1;
        this.env.getChoiceModel(401302).setValue(n2);
    }

    public void startNewSearch() {
        this.env.getSpellerModel(400624).setText("");
        this.enterOnlineSearchForm();
    }

    public void onlinePOIMainEnter() {
        this.logChannel.log(10000000, "OnlineSearchForm#onlinePOIMainEnter");
        int n = this.env.getListModel(400618).getSelected();
        if (n != -1) {
            CommandList commandList = this.onlineSearchSequence.refreshDetailsFor(n);
            commandList.execute("OnlineSearchForm#NAV_P_O_I_ONLINE_RESULTS_LIST");
        }
    }

    public void onlinePOIMainExit() {
        this.logChannel.log(10000000, "OnlineSearchForm#onlinePOIMainExit: Called");
    }

    public NavLocation getCurrentlySelectedLocation() {
        return this.poiLocation;
    }

    public void setRequestSpellingSuggestion(boolean bl) {
        this.logChannel.log(10000000, "OnlineSearchForm#setRequestSpellingSuggestion: Called");
    }

    public void addToSearchHistorySDS(String string) {
        this.logChannel.log(10000000, "OnlineSearchForm#addToSearchHistorySDS: Called with recognizedTerm %1", (Object)string);
        this.searchHistory.handleSearchTextSDS(string);
    }

    private void handleIfPoiIsCallable(NavLocation navLocation, BaseListRow baseListRow) {
        this.logChannel.log(10000000, "OnlineSearchForm#handleIfPoiIsCallable: Called for row %1", (Object)baseListRow);
        if (PoiUtil.checkIfPoiIsCallable(navLocation, this.env)) {
            this.env.getChoiceModel(401640).setValue(1);
            PropertyListCell propertyListCell = (PropertyListCell)baseListRow.getCell(13);
            int[] nArray = propertyListCell.getProperties();
            int[] nArray2 = new int[nArray.length + 1];
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                nArray2[i2] = nArray[i2];
            }
            nArray2[nArray2.length - 1] = -1996031499;
            PropertyListCell propertyListCell2 = new PropertyListCell(propertyListCell.getCategory(), nArray2);
            baseListRow.setCell(13, propertyListCell2);
        } else {
            this.env.getChoiceModel(401640).setValue(2);
        }
    }

    public OnlineSearchProviderHandler getProviderHandler() {
        return this.providerHandler;
    }

    public OnlineSearchHistory getOnlineSearchHistory() {
        return this.searchHistory;
    }

    public void setResultLengthValue(int n, int n2, int n3) {
        this.logChannel.log(10000000, "OnlineSearchForm#setResultLengthValue: setting length value of result list to %1", (long)n2);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(n);
        choiceModelApp.setValue(n2);
        choiceModelApp.setStatus(n3);
    }
}

