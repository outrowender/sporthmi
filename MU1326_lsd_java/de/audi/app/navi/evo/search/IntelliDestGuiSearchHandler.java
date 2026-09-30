/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.addressbook.core.common.ADBAddressUtils;
import de.audi.app.navi.evo.adb.AddChildrenToEntryEvoNaviCommand;
import de.audi.app.navi.evo.addressinput.disambiguation.AddressDisambiguatorEvo;
import de.audi.app.navi.evo.search.IIntelliDestSearchTimer;
import de.audi.app.navi.evo.search.IntelliDestSearch;
import de.audi.app.navi.evo.search.NaviAdbEntryListRow;
import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.app.navi.evo.search.SearchResultFormatterADB;
import de.audi.app.navi.evo.search.SearchResultFormatterNavDb;
import de.audi.app.navi.evo.search.SearchResultFormatterNavDbWithIcons;
import de.audi.app.navi.evo.search.SearchResultFormatterPoiCall;
import de.audi.app.navi.evo.search.SearchResultFormatterPressRoutes;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.interapp.NaviADBService;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.search.AbstractSearch;
import de.audi.atip.search.util.AbstractSearchResultFormatter;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.adb.NaviADBHandler;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.car.kombi.ICarKombiService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.storage.RmRouteGet;
import de.audi.tghu.navi.app.command.translate.TranslateTourCommand;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.favorite.INaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.navlocationextractor.LiValueListAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.NavLocationCallback;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultAsyncNavLocationExtractor;
import de.audi.tghu.navi.app.navlocationextractor.SearchResultNavLocationExtractor;
import de.audi.tghu.navi.app.search.AbstractNaviGuiSearchHandler;
import de.audi.tghu.navi.app.search.TrufflesDistanceCalculator;
import de.audi.tghu.navi.app.search.TrufflesTaskManager;
import de.audi.tghu.navi.app.util.MMIInternalData;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.search.SearchResult;
import org.dsi.ifc.search.Token;

public class IntelliDestGuiSearchHandler
extends AbstractNaviGuiSearchHandler {
    private static final int PICKING_OFF = 0;
    private static final int PICKING_ON = 1;
    private static final int OMIT_DISAMBIG_CHOICE_DEST = -1;
    private static final int MAX_VISIBLE_ROWS = 3;
    private static final int ROWS_RESOLVED_AUTOMATICALLY = 3;
    protected static final int SPELLER_OPENED = 4711;
    protected static final int SPELLER_CLOSED = 4712;
    private static final String LOGCLASS = "IntelliDestGuiSearchHandler";
    private final MapInterface mapInterface;
    private final INaviFavoriteHandler naviFavoriteHandler;
    protected final HomeAddressHandler homeAddressHandler;
    private final IPoiService poiService;
    protected final NaviADBHandler naviADBHandler;
    private final IAddressInputForm addressInputForm;
    protected final NavigationEnv env;
    protected final ICommandListFactory commandListFactory;
    protected final ADBInterAppService adbInterAppService;
    protected final SearchResultNavLocationExtractor searchResultNavLocationExtractor;
    private final IIntelliDestSearchTimer intelliDestSearchTimer;
    private final IDestinationHandler destinationHandler;
    protected SearchResultListRow cachedSelectedRow;
    private final MenuModelApp menuModel;
    protected final DispatcherBase dispatcher;
    private TrufflesDistanceCalculator distanceCalculator;
    protected AddressDisambiguatorEvo addressDisambiguator;
    private ADBHMIAppService adbHMIAppService;
    private final TrufflesTaskManager taskManager;
    protected final SearchResultAsyncNavLocationExtractor asyncLocationExtractor;
    private boolean invalidateDataMissed;
    private final int[] allSources;
    private final int[] initialSearchSources = new int[]{14, 4};
    private int activeTrufflesContext;
    private final NaviServiceListener naviServiceListener;
    private int sdsQueryID;

    public IntelliDestGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, HomeAddressHandler homeAddressHandler, IAddressInputForm iAddressInputForm, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, MapInterface mapInterface, DispatcherBase dispatcherBase, NaviServiceListener naviServiceListener, IIntelliDestSearchTimer iIntelliDestSearchTimer, IDestinationHandler iDestinationHandler) {
        this(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch, navigationEnv, iPreviewMap, naviADBHandler, aDBInterAppService, interAppService, iconHandler, iCommandListFactory, iNaviFavoriteHandler, iPoiService, homeAddressHandler, iAddressInputForm, searchResultAsyncNavLocationExtractor, mapInterface, dispatcherBase, naviServiceListener, iIntelliDestSearchTimer, null, iDestinationHandler);
    }

    public IntelliDestGuiSearchHandler(int[] nArray, BaseListModelApp baseListModelApp, SpellerModelApp spellerModelApp, ChoiceModelApp choiceModelApp, LogChannel logChannel, AbstractSearch abstractSearch, NavigationEnv navigationEnv, IPreviewMap iPreviewMap, NaviADBHandler naviADBHandler, ADBInterAppService aDBInterAppService, InterAppService interAppService, IconHandler iconHandler, ICommandListFactory iCommandListFactory, INaviFavoriteHandler iNaviFavoriteHandler, IPoiService iPoiService, HomeAddressHandler homeAddressHandler, IAddressInputForm iAddressInputForm, SearchResultAsyncNavLocationExtractor searchResultAsyncNavLocationExtractor, MapInterface mapInterface, DispatcherBase dispatcherBase, NaviServiceListener naviServiceListener, IIntelliDestSearchTimer iIntelliDestSearchTimer, ICarKombiService iCarKombiService, IDestinationHandler iDestinationHandler) {
        super(nArray, baseListModelApp, spellerModelApp, choiceModelApp, logChannel, abstractSearch, iPreviewMap);
        this.env = navigationEnv;
        this.destinationHandler = iDestinationHandler;
        this.allSources = nArray;
        this.mapInterface = mapInterface;
        this.naviADBHandler = naviADBHandler;
        this.adbInterAppService = aDBInterAppService;
        this.commandListFactory = iCommandListFactory;
        this.naviFavoriteHandler = iNaviFavoriteHandler;
        this.poiService = iPoiService;
        this.homeAddressHandler = homeAddressHandler;
        this.addressInputForm = iAddressInputForm;
        this.dispatcher = dispatcherBase;
        this.asyncLocationExtractor = searchResultAsyncNavLocationExtractor;
        this.naviServiceListener = naviServiceListener;
        this.intelliDestSearchTimer = iIntelliDestSearchTimer;
        this.searchResultNavLocationExtractor = new SearchResultNavLocationExtractor(this.asyncLocationExtractor);
        this.taskManager = new TrufflesTaskManager(baseListModelApp, ((IntelliDestSearch)abstractSearch).getLock(), ((IntelliDestSearch)abstractSearch).getVehicle(), this.searchResultNavLocationExtractor, dispatcherBase, logChannel, this);
        this.addressDisambiguator = new AddressDisambiguatorEvo(navigationEnv, iCommandListFactory, logChannel, new LiValueListAsyncNavLocationExtractor(iCommandListFactory), this.homeAddressHandler, this.adbInterAppService, iAddressInputForm, iPreviewMap);
        this.registryFormatter.put(new Integer(14), new SearchResultFormatterPressRoutes(logChannel, navigationEnv));
        this.registryFormatter.put(new Integer(4), new SearchResultFormatterNavDb(interAppService, iconHandler, logChannel, this.naviFavoriteHandler, navigationEnv));
        this.registryFormatter.put(new Integer(16), new SearchResultFormatterNavDbWithIcons(interAppService, iconHandler, logChannel, this.naviFavoriteHandler, navigationEnv, iCarKombiService));
        this.registryFormatter.put(new Integer(5), new SearchResultFormatterNavDb(interAppService, iconHandler, logChannel, this.naviFavoriteHandler, navigationEnv));
        this.registryFormatter.put(new Integer(3), new SearchResultFormatterADB(aDBInterAppService, navigationEnv));
        if (this.isPoiOrConciergeCallEnabled()) {
            this.registryFormatter.put(new Integer(15), new SearchResultFormatterPoiCall(logChannel, navigationEnv));
        }
        navigationEnv.getChoiceModel(401008).setValue(1);
        this.menuModel = navigationEnv.getMenuModel(401249);
    }

    public void activate() {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#activate() [%2]", (Object)LOGCLASS, (Object)this.getClass().getName());
        }
        ((IntelliDestSearch)this.appSearch).setSearchFilterForSource(3);
        this.registerListeners();
    }

    public void enterScreen() {
    }

    public void loadInitialScreen() {
        this.mdlSpellerSearchText.clear();
        this.env.getChoiceModel(401008).setValue(1);
        this.performQuery("");
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(400991);
        if (baseListModelApp.getLength() > 0) {
            this.menuModel.setFocusedItem(baseListModelApp.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, baseListModelApp.getRow(0).getUniqueID());
        }
    }

    public void deactivate() {
        this.lc.log(1000000, "%1#deactivate() [%2]", (Object)LOGCLASS, (Object)this.getClass().getName());
        this.cancelTimers();
        this.stopIntelliDestTimer();
    }

    protected void performQuery(String string, String[] stringArray) {
        this.lc.log(10000000, "%1#performQuery # text=%2, alternativeTexts=%3", (Object)LOGCLASS, (Object)string, (Object)stringArray);
        ((IntelliDestSearch)this.appSearch).refreshCarPosition();
        this.invalidateDataMissed = false;
        this.setSearchSources();
        if (!Util.isEmpty(string)) {
            this.restartIntelliDestTimer();
        } else {
            this.stopIntelliDestTimer();
        }
        super.performQuery(string, stringArray);
    }

    public void refreshQuery() {
        if (this.appSearch.getLastQueryID() == this.sdsQueryID) {
            this.lc.log(100000, "%1#refreshQuery won't refresh query in SDS usecase", (Object)LOGCLASS);
        } else {
            super.refreshQuery();
        }
    }

    public void searchEnded() {
        this.stopIntelliDestTimer();
        super.searchEnded();
        this.sendSearchResponseToSDS(true, this.appSearch.getLastQueryID());
    }

    private void sendSearchResponseToSDS(boolean bl, int n) {
        if (this.sdsQueryID != n) {
            return;
        }
        try {
            this.naviServiceListener.updateResponseStartTrufflesSearch((byte)0, this.mdlListSearchResults.getLength(), bl, n);
        }
        catch (Exception exception) {
            this.lc.log(10000, "%1#sendSearchResponseToSDS() %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    private void setSearchSources() {
        if (this.activeTrufflesContext != 0) {
            return;
        }
        this.activeSources = this.mdlSpellerSearchText.getText() != null && this.mdlSpellerSearchText.getText().length() == 0 ? this.initialSearchSources : this.allSources;
    }

    protected void setCurrentTrufflesContext(int n) {
        this.activeTrufflesContext = n;
    }

    public void textChanged(int n, String string, char c2, int n2) {
        this.lc.log(10000000, "%1#textChanged = %2", (Object)LOGCLASS, (Object)string);
        this.menuModel.setFocusedItem(this.mdlSpellerSearchText.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, -1L);
        if (this.distanceCalculator != null) {
            this.distanceCalculator.userInputChanged();
        }
        this.performQuery(string, new String[0]);
        this.taskManager.cancelAllJobs();
        if (string.length() == 0) {
            this.env.getChoiceModel(402354).setValue(0);
            this.env.getChoiceModel(401008).setValue(1);
            this.clearModels();
            this.mdlSpellerSearchText.setText("");
        } else {
            this.env.getChoiceModel(401008).setValue(0);
        }
    }

    private boolean isPickable(EvoListRow evoListRow) {
        if (!(evoListRow instanceof SearchResultListRow)) {
            return false;
        }
        return this.isPickable((SearchResultListRow)evoListRow);
    }

    private boolean isPickable(SearchResultListRow searchResultListRow) {
        if (0 != searchResultListRow.getNodeType()) {
            return false;
        }
        if (16 != searchResultListRow.getSearchResult().getSource()) {
            return false;
        }
        switch (searchResultListRow.getSearchResult().entryType) {
            case 4: 
            case 16: 
            case 64: {
                break;
            }
            default: {
                return false;
            }
        }
        String string = "";
        Token token = AbstractSearchResultFormatter.getTokenForType(searchResultListRow.getSearchResult().getTokens(), 7);
        if (null != token) {
            string = token.getToken();
        }
        return null == string || 0 == string.length();
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.env.getChoiceModel(401470).setValue(0);
        if (Util.isIntellidestPickHelpAvailable(this.env.getFramework()) && 1 == this.env.getChoiceModel(401483).getValue()) {
            this.env.getChoiceModel(401517).setValue(this.isPickable(evoListRow) ? 1 : 0);
        }
        super.itemSelected(evoListRow, n, n2, n3, n4);
    }

    private String getPickHelpLabelString(Token[] tokenArray) {
        StringBuffer stringBuffer = new StringBuffer();
        Token token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 1);
        if (!AbstractSearchResultFormatter.isEmpty(token)) {
            stringBuffer.append(token.getToken());
        }
        if (!AbstractSearchResultFormatter.isEmpty(token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 2))) {
            stringBuffer.append(" ");
            stringBuffer.append(token.getToken());
        }
        if (!AbstractSearchResultFormatter.isEmpty(token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 3))) {
            stringBuffer.append(" ");
            stringBuffer.append(token.getToken());
        }
        if (!AbstractSearchResultFormatter.isEmpty(token = AbstractSearchResultFormatter.getTokenForType(tokenArray, 7))) {
            stringBuffer.append(" ");
            stringBuffer.append(token.getToken());
        }
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    public void searchResultSelected(final SearchResultListRow searchResultListRow, final int n, int n2) {
        if (searchResultListRow == null) {
            this.lc.log(100000, "%1#searchResultSelected - listRow is null", (Object)LOGCLASS);
            return;
        }
        int n3 = this.env.getChoiceModel(401246).getValue();
        if (n3 == 1) {
            this.asyncLocationExtractor.executeCallbackWithNavLocation(searchResultListRow, 0, new NavLocationCallback(){

                public void callBack(NavLocation navLocation, ICommandList iCommandList) {
                    IntelliDestGuiSearchHandler.this.storeAddressToAdb(searchResultListRow, navLocation, iCommandList, n);
                }
            });
        } else if (n3 == 2) {
            this.asyncLocationExtractor.executeCallbackWithNavLocation(searchResultListRow, 0, new NavLocationCallback(){

                public void callBack(final NavLocation navLocation, ICommandList iCommandList) {
                    if (IntelliDestGuiSearchHandler.this.isDisambiguationNeeded(searchResultListRow)) {
                        if (null != IntelliDestGuiSearchHandler.this.addressDisambiguator) {
                            iCommandList.commandFinishedWithPostSequence(IntelliDestGuiSearchHandler.this.addressDisambiguator.prepareCandidatesList(searchResultListRow, n));
                        } else {
                            IntelliDestGuiSearchHandler.this.env.getLogChannel().log(100000, "%1#searchResultSelected() - addressDisambiguator is null", (Object)IntelliDestGuiSearchHandler.LOGCLASS);
                        }
                    } else {
                        IntelliDestGuiSearchHandler.this.dispatcher.execute(new Runnable(){

                            public void run() {
                                if (IntelliDestGuiSearchHandler.this.lc.isDebug2()) {
                                    IntelliDestGuiSearchHandler.this.lc.log(100000000, "%1#searchResultSelected - Store Address as HomeAddress", (Object)IntelliDestGuiSearchHandler.LOGCLASS);
                                }
                                (this).IntelliDestGuiSearchHandler.this.homeAddressHandler.onCreateEditHomeAddress(navLocation);
                            }
                        });
                    }
                }
            });
        } else if (1 == this.env.getChoiceModel(401483).getValue() && 1 == this.env.getChoiceModel(401517).getValue()) {
            this.lc.log(10000000, "%1#searchResultSelected - pick help activated", (Object)LOGCLASS);
            this.env.getLabelModel(401479).setText(this.getPickHelpLabelString(searchResultListRow.getSearchResult().getTokens()));
            this.cachedSelectedRow = searchResultListRow;
        } else {
            this.startRG(searchResultListRow, n);
        }
        this.env.getBaseListModel(n2).fireEvent(n);
    }

    protected void storeAddressToAdb(SearchResultListRow searchResultListRow, final NavLocation navLocation, ICommandList iCommandList, int n) {
        if (this.isDisambiguationNeeded(searchResultListRow)) {
            if (null != this.addressDisambiguator) {
                iCommandList.commandFinishedWithPostSequence(this.addressDisambiguator.prepareCandidatesList(searchResultListRow, n));
            } else {
                this.env.getLogChannel().log(100000, "%1#searchResultSelected() - addressDisambiguator is null", (Object)LOGCLASS);
            }
        } else {
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    IntelliDestGuiSearchHandler.this.selectResultModeADB(navLocation);
                }
            });
        }
    }

    private void selectResultModeADB(NavLocation navLocation) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "%1#searchResultSelected - Store Address to ADB", (Object)LOGCLASS);
        }
        byte[] byArray = this.adbInterAppService.locationToStream(navLocation);
        NaviADBService.LocationInputHandler locationInputHandler = this.adbInterAppService.getCurrentLocationInputHandler();
        if (locationInputHandler != null) {
            locationInputHandler.updateLocation(byArray);
            this.adbInterAppService.removeHandler();
        } else {
            this.env.getLogChannel().log(100000, "%1#searchResultSelected() - LocationInputhandler is null", (Object)LOGCLASS);
        }
    }

    protected void startRG(final SearchResultListRow searchResultListRow, final int n) {
        if (searchResultListRow.getSearchResult().source == 14) {
            this.createStartRgWithPressRouteCL(searchResultListRow).execute("IntelliDestGuiSearchHandler#startRG() with PRESSROUTE");
            return;
        }
        this.asyncLocationExtractor.executeCallbackWithNavLocation(searchResultListRow, 0, new NavLocationCallback(){

            public void callBack(final NavLocation navLocation, ICommandList iCommandList) {
                if (IntelliDestGuiSearchHandler.this.destinationHandler != null) {
                    IntelliDestGuiSearchHandler.this.destinationHandler.setTransfereToNdf(true);
                }
                if (IntelliDestGuiSearchHandler.this.isDisambiguationNeeded(searchResultListRow)) {
                    IntelliDestGuiSearchHandler.this.cancelJobs();
                    if (null != IntelliDestGuiSearchHandler.this.addressDisambiguator) {
                        iCommandList.commandFinishedWithPostSequence(IntelliDestGuiSearchHandler.this.addressDisambiguator.prepareCandidatesList(searchResultListRow, n));
                    } else {
                        IntelliDestGuiSearchHandler.this.env.getLogChannel().log(100000, "IntelliDestGuiSearchHandler#searchResultSelected() - addressDisambiguator is null");
                    }
                } else {
                    IntelliDestGuiSearchHandler.this.checkNavLocation(navLocation, searchResultListRow);
                    IntelliDestGuiSearchHandler.this.cachedSelectedRow = null;
                    NavCommand navCommand = new NavCommand("IntelliDestGuiSearchHandler#StartRouteGuidance"){

                        public void execute() {
                            this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(null, navLocation, true, false));
                        }
                    };
                    iCommandList.commandFinishedWithPostCommand(navCommand);
                }
            }
        });
    }

    private CommandList createStartRgWithPressRouteCL(SearchResultListRow searchResultListRow) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.put("TOUR_INDEX", new Integer(0));
        commandList.add(new RmRouteGet(2, searchResultListRow.getSearchResult().dataId));
        commandList.add(new TranslateTourCommand());
        commandList.add(new NavCommand("start the StartGuidanceDependantSequence"){

            public void execute() {
                this.navigation.getStartGuidanceDependantSequence().start((Route)this.getCommandList().get("TRANSLATED_ROUTE"));
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    private void checkNavLocation(NavLocation navLocation, SearchResultListRow searchResultListRow) {
        if (null == navLocation || !navLocation.isPositionValid()) {
            this.lc.log(100000, "%1#searchResultSelected # location is null or position is invalid - %2", (Object)LOGCLASS, (Object)navLocation);
        }
        if (null == navLocation && searchResultListRow.getSearchResult().getSource() == 4) {
            this.showPopUpRgNotPossible();
            this.appSearch.removeFromHistory(searchResultListRow.getSearchResult().getDataId());
            this.mdlListSearchResults.remove(searchResultListRow);
        }
    }

    private void showPopUpRgNotPossible() {
        if (this.env.getLogChannel().isDebug2()) {
            this.env.getLogChannel().log(100000000, "%1#showPopUpRgNotPossible show PartialPopup sor CALC_FAIL_SINGLE", (Object)LOGCLASS);
        }
        this.env.getChoiceModel(401582).setValue(1);
    }

    protected boolean isDisambiguationNeeded(SearchResultListRow searchResultListRow) {
        boolean bl = 16 == searchResultListRow.getSearchResult().getSource() && AddressDisambiguatorEvo.isHNrUnclear(this.env.getContainer().getTryMatchLocationResultData(), this.lc);
        this.lc.log(10000000, "%2#isDisambiguationNeeded result=%1", bl, (Object)LOGCLASS);
        return bl;
    }

    public void cancelJobs() {
        this.taskManager.cancelAllJobs();
    }

    protected void optionShowContactDetailsForAdbResult(int n) {
        SearchResultListRow searchResultListRow;
        EvoListRow evoListRow = this.mdlListSearchResults.getRow(n);
        if (evoListRow instanceof SearchResultListRow && (searchResultListRow = (SearchResultListRow)evoListRow).getNodeType() == 1) {
            this.adbHMIAppService.showEntryDetails(searchResultListRow.getSearchResult().dataId, 1);
        }
    }

    public void requestChildrenNodes(SearchResultListRow searchResultListRow, int n) {
        this.lc.log(10000000, "%1#getChildrenNodes", (Object)LOGCLASS);
        SearchResultFormatterADB searchResultFormatterADB = (SearchResultFormatterADB)this.registryFormatter.get(new Integer(searchResultListRow.getSearchResult().getSource()));
        AddChildrenToEntryEvoNaviCommand.createAndExecuteAddChildrenToEntryNaviCommand(this.naviADBHandler, searchResultListRow.getSearchResult().dataId, this.mdlChoiceSearchIsActive, this, searchResultListRow, searchResultFormatterADB);
    }

    private void openAddressInputForm(NavLocation navLocation, int n, String string) {
        this.env.getChoiceModel(401580).setValue(0);
        if (-1 != n) {
            this.env.getChoiceModel(401470).setValue(n);
        }
        if (null != navLocation && navLocation.isPositionValid()) {
            MMIInternalData mMIInternalData = new MMIInternalData();
            mMIInternalData.init(navLocation);
            mMIInternalData.setValue("Title", string);
            mMIInternalData.setInLocation(navLocation);
            this.env.getChoiceModel(170).setValue(0);
            this.addressInputForm.startWithoutStrip(navLocation);
        } else {
            if (this.lc.isDebug2()) {
                this.lc.log(100000000, "IntelliDestGuiSearchHandler#openAddressInputForm Invalid navLoc = >>%1<<", (Object)navLocation);
            }
            this.env.getChoiceModel(401580).setValue(1);
        }
    }

    protected void openAddressInputForm() {
        int n = 0;
        int n2 = this.env.getChoiceModel(8).getValue();
        if (n2 == 4 || n2 == 3) {
            n = 2;
        }
        this.env.getChoiceModel(170).setValue(n);
        this.addressInputForm.start(((IntelliDestSearch)this.appSearch).vehicle.getVehicleCountryLocation());
    }

    protected void openAddressInputForm(NavLocation navLocation) {
        this.openAddressInputForm(navLocation, -1, "");
    }

    private void openAddressInputForm(NaviAdbEntryListRow naviAdbEntryListRow) {
        this.openAddressInputForm(this.extractNavLocationFromRow(naviAdbEntryListRow), 1, naviAdbEntryListRow.getAdbEntry().combinedName);
    }

    public void childNodeSelected(EvoListRow evoListRow, int n, int n2) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "IntelliDestGuiSearchHandler#childNodeSelected, row: [%1], terminal: [%2], modelID: [%3]", (Object)evoListRow, (long)n, (long)n2);
        }
        NaviAdbEntryListRow naviAdbEntryListRow = (NaviAdbEntryListRow)evoListRow;
        switch (naviAdbEntryListRow.getAdbType()) {
            case 0: {
                this.openAddressInputForm(naviAdbEntryListRow);
                break;
            }
            case 1: {
                this.openAddressInputForm(naviAdbEntryListRow);
                break;
            }
            case 2: {
                this.adbInterAppService.setDestination(naviAdbEntryListRow.getAdbEntry().addressData[0].navLocation, naviAdbEntryListRow.getAdbEntry().combinedName);
                break;
            }
            case 3: {
                this.adbInterAppService.setDestination(naviAdbEntryListRow.getAdbEntry().addressData[1].navLocation, naviAdbEntryListRow.getAdbEntry().combinedName);
                break;
            }
            case 4: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(naviAdbEntryListRow.getAdbEntry().addressData[0].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    // empty if block
                }
                this.adbInterAppService.setDestination(stringArray[1], stringArray[0], naviAdbEntryListRow.getAdbEntry().combinedName);
                break;
            }
            case 5: {
                String[] stringArray = ADBAddressUtils.vCardGeoPosToDegrees(naviAdbEntryListRow.getAdbEntry().addressData[1].geoPosition);
                if (stringArray == null || stringArray.length != 2) {
                    // empty if block
                }
                this.adbInterAppService.setDestination(stringArray[1], stringArray[0], naviAdbEntryListRow.getAdbEntry().combinedName);
                break;
            }
        }
        this.env.getBaseListModel(n2).fireEvent(n);
    }

    protected void saveAsFavorite(final EvoListRow evoListRow, final NavLocation navLocation, int n) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new NavCommand("AddToFavoritesCommand"){

            public void execute() {
                if (evoListRow != null && evoListRow instanceof NaviAdbEntryListRow) {
                    IntelliDestGuiSearchHandler.this.lc.log(1000000, "%1#saveAsFavorite - NaviAdbEntryListRow", (Object)IntelliDestGuiSearchHandler.LOGCLASS);
                    NaviAdbEntryListRow naviAdbEntryListRow = (NaviAdbEntryListRow)evoListRow;
                    AdbEntry adbEntry = naviAdbEntryListRow.getAdbEntry();
                    String string = adbEntry.getCombinedName();
                    if (!Util.isEmpty(string)) {
                        IntelliDestGuiSearchHandler.this.naviFavoriteHandler.addToFavorites(navLocation, string);
                    }
                } else {
                    IntelliDestGuiSearchHandler.this.lc.log(1000000, "%1#saveAsFavorite - no NaviAdbEntryListRow", (Object)IntelliDestGuiSearchHandler.LOGCLASS);
                    IntelliDestGuiSearchHandler.this.naviFavoriteHandler.addToFavorites(navLocation);
                }
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("AddToFavoritesCommandCommandList");
    }

    protected void parkingNearDestination(NavLocation navLocation) {
        if (navLocation == null) {
            this.lc.log(1000000, "%1#parkingNearDestination location is null", (Object)LOGCLASS);
            return;
        }
        this.poiService.getParkingNearDestinationSequenceWithDistanceFromCCP(navLocation).execute("IntelliDestGuiSearchHandler#parkingNearDestination");
    }

    protected void poiNearDestination(NavLocation navLocation) {
        if (navLocation == null) {
            this.lc.log(1000000, "%1#poiNearDestination location is null", (Object)LOGCLASS);
            return;
        }
        this.poiService.startPoiWithSearchContext(4, navLocation, true, true);
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.mdlListSearchResults.getLength() == 1) {
            NaviSearchResultListRow naviSearchResultListRow = (NaviSearchResultListRow)this.env.getBaseListModel(401316).getRow(0);
            if (naviSearchResultListRow != null) {
                this.menuModel.setFocusedItem(401316, FocusAdvice.VIEWPORT_SECOND_POSITION, naviSearchResultListRow.getUniqueID());
            }
            if (naviSearchResultListRow.getNodeType() == 1) {
                this.parentNodeSelected(naviSearchResultListRow, n, n3);
            } else {
                this.searchResultSelected((SearchResultListRow)this.mdlListSearchResults.getRow(0), 0, 401316);
            }
        }
    }

    public NavLocation extractNavLocationFromRow(EvoListRow evoListRow) {
        if (evoListRow instanceof NaviSearchResultListRow) {
            return this.searchResultNavLocationExtractor.extractNavLocationFromRow(evoListRow);
        }
        if (evoListRow instanceof NaviAdbEntryListRow) {
            return this.searchResultNavLocationExtractor.extractNavLocationFromRow(evoListRow);
        }
        throw new IllegalArgumentException(new StringBuffer().append("this NavLocationExtractor works only with NaviSearchResultListRow or NaviAdbEntryListRow objects, not ").append(evoListRow != null ? evoListRow.getClass().getName() : "[null]").toString());
    }

    public void focusPreviewMapOnSearchResult(final long l, int n) {
        this.lc.log(10000000, "%1#focusPreviewMapOnSearchResult # uniqueListRowID=%2, menuItemID=%3", (Object)LOGCLASS, l, (long)n);
        this.env.getChoiceModel(401640).setValue(2);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(n);
        EvoListRow evoListRow = baseListModelApp.getRowByUniqueID(l);
        int n2 = baseListModelApp.getIndexForUniqueID(l);
        if (n == 401316) {
            if (evoListRow instanceof SearchResultListRow && ((SearchResultListRow)evoListRow).getSearchResult().source == 14) {
                CommandList commandList = this.commandListFactory.createCommandList();
                commandList.put("TOUR_INDEX", new Integer(n2));
                commandList.add(new RmRouteGet(2, ((SearchResultListRow)evoListRow).getSearchResult().dataId));
                commandList.add(new TranslateTourCommand());
                commandList.execute("IntelliDestGuiSearchHandler#itemFocused() with SOURCE_PRESSROUTE");
            } else {
                this.taskManager.focusPreviewMap(evoListRow);
            }
            this.taskManager.cancelCursorFocusJobs();
            this.taskManager.resolveCoordinates(this.getVisibleRows(n2), 1);
        } else if (n == 401334) {
            this.lc.log(1000000, "IntelliDestGuiSearchHandler#itemFocused operationMode=%1", (long)this.naviFavoriteHandler.getOperationMode());
            if (this.naviFavoriteHandler.getOperationMode() == 0) {
                this.taskManager.cancelFocusPreviewMapJob();
                this.dispatcher.execute(new Runnable(){

                    public void run() {
                        IntelliDestGuiSearchHandler.this.lc.log(10000000, "%1#focusPreviewMapOnSearchResult NAV_DEST_FAVORITES_BASE_LIST", (Object)IntelliDestGuiSearchHandler.LOGCLASS);
                        NavLocation navLocation = IntelliDestGuiSearchHandler.this.naviFavoriteHandler.getFavoriteNavLocationByUniqueId(l);
                        IntelliDestGuiSearchHandler.this.focusPreviewMapOnNavLocation(navLocation, true);
                    }
                });
            }
        } else {
            this.taskManager.focusPreviewMap(evoListRow);
        }
    }

    public void handleIfPoiIsCallable(NavLocation navLocation, EvoListRow evoListRow) {
        if (PoiUtil.checkIfPoiIsCallable(navLocation, this.env)) {
            PropertyListCell propertyListCell;
            this.env.getChoiceModel(401640).setValue(1);
            PropertyListCell propertyListCell2 = (PropertyListCell)evoListRow.getCell(4);
            if (propertyListCell2 != null) {
                int[] nArray = propertyListCell2.getProperties();
                int[] nArray2 = new int[nArray.length + 1];
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    nArray2[i2] = nArray[i2];
                }
                nArray2[nArray2.length - 1] = -1996031499;
                propertyListCell = new PropertyListCell(propertyListCell2.getCategory(), nArray2);
            } else {
                propertyListCell = new PropertyListCell(1055316784, new int[]{-1996031499});
            }
            evoListRow.setPropertyCell(4, propertyListCell);
        }
    }

    private List getVisibleRows(int n) {
        int n2 = n - 3 < 0 ? 0 : n - 3;
        int n3 = n + 3 > this.mdlListSearchResults.getLength() - 1 ? this.mdlListSearchResults.getLength() - 1 : n + 3;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.mdlListSearchResults.getRow(n));
        int n4 = 1;
        while (true) {
            int n5 = n - n4;
            int n6 = n + n4;
            EvoListRow evoListRow = this.mdlListSearchResults.getRow(n5);
            EvoListRow evoListRow2 = this.mdlListSearchResults.getRow(n6);
            if (evoListRow2 != null) {
                arrayList.add(evoListRow2);
            }
            if (evoListRow != null) {
                arrayList.add(evoListRow);
            }
            if (n5 <= n2 && n6 >= n3) break;
            ++n4;
        }
        return arrayList;
    }

    public void destOptShowInMap(NavLocation navLocation, long l) {
        if (navLocation == null) {
            this.lc.log(1000000, "%1#destOptShowInMap location is NULL", (Object)LOGCLASS);
            return;
        }
        IFavorite iFavorite = null;
        if (l != -1L) {
            iFavorite = (IFavorite)((Object)this.naviFavoriteHandler.getFavoriteRow(l));
        }
        this.mapInterface.destOptShowInMap(navLocation, false, iFavorite, false);
    }

    public void startAddLocationToContact(NavLocation navLocation) {
        this.naviADBHandler.startStoringAddress(navLocation);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void flushSearchResultBuffer() {
        ArrayList arrayList;
        Object object = ((IntelliDestSearch)this.appSearch).getLock();
        synchronized (object) {
            if (this.mdlListSearchResults.getLength() > 3) {
                super.flushSearchResultBuffer();
                this.sendSearchResponseToSDS(false, this.appSearch.getLastQueryID());
                return;
            }
            arrayList = this.getBufferCopy();
            super.flushSearchResultBuffer();
            this.sendSearchResponseToSDS(false, this.appSearch.getLastQueryID());
        }
        object = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            SearchResult searchResult = ((SearchResultListRow)iterator.next()).getSearchResult();
            if (searchResult.listPosition >= 3) break;
            object.add(this.mdlListSearchResults.getRow(searchResult.listPosition));
        }
        if (object.size() > 0) {
            this.taskManager.resolveCoordinates((List)object, 0);
        }
    }

    public void setDistanceCalculator(TrufflesDistanceCalculator trufflesDistanceCalculator) {
        this.distanceCalculator = trufflesDistanceCalculator;
    }

    public void setADBHMIAppService(ADBHMIAppService aDBHMIAppService) {
        this.adbHMIAppService = aDBHMIAppService;
    }

    protected void setInvalidateDataMissed(boolean bl) {
        this.lc.log(10000000, "%2#setInvalidateDataMissed: %1", bl, (Object)LOGCLASS);
        this.invalidateDataMissed = bl;
    }

    protected boolean hasMissedInvalidateData() {
        this.lc.log(10000000, "%2#hasMissedInvalidateData: %1", this.invalidateDataMissed, (Object)LOGCLASS);
        return this.invalidateDataMissed;
    }

    public void cacheQueryIDForSDSSearch() {
        this.sdsQueryID = this.appSearch.getLastQueryID();
    }

    public void clearSpellerModel() {
        this.mdlSpellerSearchText.clear();
    }

    private boolean isPoiOrConciergeCallEnabled() {
        return this.env.getFramework().getSysConst(4154) == 1 || this.env.getFramework().getSysConst(4153) == 1;
    }

    protected void restartIntelliDestTimer() {
        this.lc.log(10000000, "%1#restartIntelliDestTimer()", (Object)LOGCLASS);
        this.intelliDestSearchTimer.restart();
    }

    protected void stopIntelliDestTimer() {
        this.lc.log(10000000, "%1#stopIntelliDestTimer() + hide 'Search with Google' Button", (Object)LOGCLASS);
        this.intelliDestSearchTimer.stop();
    }

    public void release() {
        super.release();
        this.stopIntelliDestTimer();
        this.registryFormatter.clear();
    }
}

