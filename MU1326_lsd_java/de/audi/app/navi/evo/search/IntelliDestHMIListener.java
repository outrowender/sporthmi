/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.poi.online.OnlineSearchControllerEvo;
import de.audi.app.navi.evo.search.ActiveDestinationsManager;
import de.audi.app.navi.evo.search.IntelliDestController;
import de.audi.app.navi.evo.search.IntelliDestGuiSearchHandler;
import de.audi.app.navi.evo.search.NaviSearchResultListRow;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.phone.ITelService;
import de.audi.atip.search.util.SearchResultListRow;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.HomeAddressHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.poi.PoiUtil;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.search.ICountrySelection;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.search.SearchResult;

public class IntelliDestHMIListener
implements MenuModelListener {
    private final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());
    private final NavigationEnv env;
    private final LogChannel lc;
    private final IntelliDestGuiSearchHandler guiSearchHandler;
    private final OnlineSearchControllerEvo onlineController;
    private final ActiveDestinationsManager activeDestinationsManager;
    private final IntelliDestController searchController;
    private MenuModelApp menuModel;
    private final SpellerModelApp searchSpeller;
    private final BaseListModelApp intelliDestResultList;
    private final DispatcherBase dispatcher;
    private final ITelService telService;
    private final ICommandListFactory commandListFactory;
    private final HomeAddressHandler homeAddressHandler;
    private final ICountrySelection countrySelection;
    private IPoiService poiService;
    protected static final int SPELLER_OPENED = 4711;
    protected static final int SPELLER_CLOSED = 4712;

    public IntelliDestHMIListener(NavigationEnv navigationEnv, IntelliDestGuiSearchHandler intelliDestGuiSearchHandler, OnlineSearchControllerEvo onlineSearchControllerEvo, ActiveDestinationsManager activeDestinationsManager, IntelliDestController intelliDestController, DispatcherBase dispatcherBase, ITelService iTelService, ICommandListFactory iCommandListFactory, HomeAddressHandler homeAddressHandler, ICountrySelection iCountrySelection, IPoiService iPoiService) {
        this.env = navigationEnv;
        this.guiSearchHandler = intelliDestGuiSearchHandler;
        this.onlineController = onlineSearchControllerEvo;
        this.activeDestinationsManager = activeDestinationsManager;
        this.searchController = intelliDestController;
        this.dispatcher = dispatcherBase;
        this.homeAddressHandler = homeAddressHandler;
        this.countrySelection = iCountrySelection;
        this.poiService = iPoiService;
        this.lc = navigationEnv.getLogChannel("App.Navi.Search");
        this.searchSpeller = Util.isHURegionKR() ? navigationEnv.getSpellerModel(402379) : navigationEnv.getSpellerModel(402563);
        this.intelliDestResultList = navigationEnv.getBaseListModel(401316);
        this.telService = iTelService;
        this.commandListFactory = iCommandListFactory;
        this.initListener();
    }

    private final void initListener() {
        MyOptionModelListener myOptionModelListener = new MyOptionModelListener();
        this.env.getHMIService().getOptionModel(401012).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401012).setListener(myOptionModelListener, 400991);
        this.env.getHMIService().getOptionModel(401012).setListener(myOptionModelListener, 401408);
        this.env.getHMIService().getOptionModel(401380).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401380).setListener(myOptionModelListener, 400991);
        this.env.getHMIService().getOptionModel(401990).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401990).setListener(myOptionModelListener, 400991);
        this.env.getHMIService().getOptionModel(401478).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401478).setListener(myOptionModelListener, 400991);
        this.env.getHMIService().getOptionModel(401013).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401013).setListener(myOptionModelListener, 400991);
        this.env.getHMIService().getOptionModel(401043).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401043).setListener(myOptionModelListener, 400991);
        this.env.getHMIService().getOptionModel(401485).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401485).setListener(myOptionModelListener, 400991);
        this.env.getHMIService().getOptionModel(401029).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401622).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        this.env.getHMIService().getOptionModel(401005).setListener(myOptionModelListener, this.intelliDestResultList.getID());
        MyButtonListener myButtonListener = new MyButtonListener();
        this.env.getButtonModel(401480).setButtonListener(myButtonListener);
        this.env.getButtonModel(401481).setButtonListener(myButtonListener);
        this.env.getButtonModel(401030).setButtonListener(myButtonListener);
        this.env.getButtonModel(400993).setButtonListener(myButtonListener);
        this.env.getButtonModel(401579).setButtonListener(myButtonListener);
        this.env.getButtonModel(401755).setButtonListener(myButtonListener);
        this.menuModel = this.env.getMenuModel(401249);
        this.menuModel.setListener(this);
        this.env.getMenuModel(401675).setListener(this);
        this.env.getMenuModel(401676).setListener(this);
        this.env.getMenuModel(401376).setListener(this);
        this.env.getMenuModel(401966).setListener(this);
        this.env.getMenuModel(401677).setListener(this);
        this.env.getMenuModel(401963).setListener(this);
    }

    public void deinit() {
        this.env.getHMIService().getOptionModel(401012).resetListener();
        this.env.getHMIService().getOptionModel(401380).resetListener();
        this.env.getHMIService().getOptionModel(401990).resetListener();
        this.env.getHMIService().getOptionModel(401478).resetListener();
        this.env.getHMIService().getOptionModel(401013).resetListener();
        this.env.getHMIService().getOptionModel(401485).resetListener();
        this.env.getHMIService().getOptionModel(401029).resetListener();
        this.env.getHMIService().getOptionModel(401622).resetListener();
        this.env.getHMIService().getOptionModel(401005).resetListener();
        this.env.getButtonModel(401480).resetListener();
        this.env.getButtonModel(401481).resetListener();
        this.env.getButtonModel(401030).resetListener();
        this.env.getButtonModel(400993).resetListener();
        this.env.getButtonModel(401579).resetListener();
        this.env.getButtonModel(401755).resetListener();
        this.env.getMenuModel(401249).resetListener();
        this.env.getMenuModel(401675).resetListener();
        this.env.getMenuModel(401676).resetListener();
        this.env.getMenuModel(401376).resetListener();
        this.env.getMenuModel(401966).resetListener();
        this.env.getMenuModel(401677).resetListener();
        this.env.getMenuModel(401963).resetListener();
    }

    public void itemFocused(final int n, int n2, final long l, int n3) {
        this.lc.log(10000000, new StringBuffer().append(this.CLASS_NAME).append("#itemFocused menuItemID: %1 model: %2 terminal: %3").toString(), (long)n, (long)n2, (long)n3);
        this.dispatcher.execute(new Runnable(){

            public void run() {
                if (IntelliDestHMIListener.this.homeAddressHandler.isHomeAddressMenuItem(n)) {
                    IntelliDestHMIListener.this.homeAddressHandler.handleHomeAddressFocus();
                } else if (n == 400991) {
                    if (IntelliDestHMIListener.this.env.getFramework().isEvoHigh() && !IntelliDestHMIListener.this.env.getFramework().isEvoHighMMIKombi()) {
                        IntelliDestHMIListener.this.guiSearchHandler.hidePreviewMap();
                        return;
                    }
                    NavLocation navLocation = IntelliDestHMIListener.this.activeDestinationsManager.getNavLocation(l);
                    IntelliDestHMIListener.this.guiSearchHandler.focusPreviewMapOnDestination(navLocation);
                } else if (n == 401316 || n == 401408 || n == 401377 || n == 401421 || n == 401864 || n == 401612 || n == 401486 || n == 401334) {
                    IntelliDestHMIListener.this.guiSearchHandler.focusPreviewMapOnSearchResult(l, n);
                } else if (n == 401335 || n == 401378 || n == 401866) {
                    if (IntelliDestHMIListener.this.env.getFramework().isAsia()) {
                        CommandList commandList = IntelliDestHMIListener.this.commandListFactory.createCommandList();
                        commandList.add(new NavCommand("IntelliDestHMIListener itemFocused"){

                            public void execute() {
                                IntelliDestHMIListener.this.guiSearchHandler.focusPreviewAreaAroundCCP();
                                this.getCommandList().commandFinished();
                            }
                        });
                        commandList.execute("IntelliDestHMIListener itemFocused");
                    } else {
                        IntelliDestHMIListener.this.guiSearchHandler.hidePreviewMap();
                    }
                } else if (n != 402078) {
                    IntelliDestHMIListener.this.guiSearchHandler.hidePreviewMap();
                }
            }
        });
    }

    private class MyButtonListener
    extends DefaultButtonListener {
        private MyButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            IntelliDestHMIListener.this.lc.log(1000000, "%1#ButtonListener.keyPressed model = %2 key = %3", (Object)IntelliDestHMIListener.this.CLASS_NAME, (long)n, (long)n2);
            switch (n) {
                case 400993: {
                    IntelliDestHMIListener.this.onlineController.configureSearchFromTruffles(IntelliDestHMIListener.this.searchSpeller.getText());
                    break;
                }
                case 401480: {
                    IntelliDestHMIListener.this.guiSearchHandler.startRG(((IntelliDestHMIListener)IntelliDestHMIListener.this).guiSearchHandler.cachedSelectedRow, n3);
                    break;
                }
                case 401481: {
                    String string = IntelliDestHMIListener.this.env.getLabelModel(401479).getText();
                    IntelliDestHMIListener.this.searchSpeller.setText(string);
                    IntelliDestHMIListener.this.guiSearchHandler.performQuery(string, new String[0]);
                    IntelliDestHMIListener.this.menuModel.setFocusedItem(IntelliDestHMIListener.this.searchSpeller.getID(), FocusAdvice.VIEWPORT_FIRST_POSITION, -1L);
                    break;
                }
                case 401030: {
                    IntelliDestHMIListener.this.searchController.getMainSearch().removeAllFromHistory();
                    break;
                }
                case 401579: {
                    IntelliDestHMIListener.this.guiSearchHandler.openAddressInputForm();
                    break;
                }
                case 401755: {
                    IntelliDestHMIListener.this.countrySelection.loadCountriesFromNavigation();
                    break;
                }
            }
            IntelliDestHMIListener.this.env.getButtonModel(n).fireEvent(n3);
        }
    }

    private class MyOptionModelListener
    extends DefaultOptionListener {
        private MyOptionModelListener() {
        }

        public void keyPressed(int n, int n2, int n3, int n4, int n5) {
            Object object;
            IntelliDestHMIListener.this.lc.log(1000000, new StringBuffer().append(IntelliDestHMIListener.this.CLASS_NAME).append("#OptionModelListener.keyPressed modelID = %1, targetModelID=%2, targetRow = %3").toString(), (long)n, (long)n2, (long)n3);
            EvoListRow evoListRow = IntelliDestHMIListener.this.intelliDestResultList.getRow(n3);
            NavLocation navLocation = null;
            if (n2 == IntelliDestHMIListener.this.intelliDestResultList.getID()) {
                navLocation = IntelliDestHMIListener.this.guiSearchHandler.extractNavLocationFromRow(evoListRow);
            } else if (n2 == 400991) {
                navLocation = IntelliDestHMIListener.this.activeDestinationsManager.getNavLocation(n3);
            } else if (n2 == 401334) {
                evoListRow = IntelliDestHMIListener.this.env.getBaseListModel(401421).getRow(n3);
                navLocation = IntelliDestHMIListener.this.guiSearchHandler.extractNavLocationFromRow(evoListRow);
            }
            long l = -1L;
            if (evoListRow instanceof SearchResultListRow && ((SearchResult)(object = ((SearchResultListRow)evoListRow).getSearchResult())).getSource() == 5) {
                l = ((SearchResult)object).getDataId();
            }
            switch (n) {
                case 401380: {
                    IntelliDestHMIListener.this.guiSearchHandler.parkingNearDestination(navLocation);
                    break;
                }
                case 401990: {
                    IntelliDestHMIListener.this.guiSearchHandler.poiNearDestination(navLocation);
                    break;
                }
                case 401013: {
                    IntelliDestHMIListener.this.guiSearchHandler.saveAsFavorite(evoListRow, navLocation, n2);
                    break;
                }
                case 401043: {
                    IntelliDestHMIListener.this.poiService.showPoiDetailScreen(navLocation);
                    break;
                }
                case 401478: {
                    IntelliDestHMIListener.this.guiSearchHandler.openAddressInputForm(navLocation);
                    break;
                }
                case 401012: {
                    IntelliDestHMIListener.this.guiSearchHandler.destOptShowInMap(navLocation, l);
                    break;
                }
                case 401485: {
                    IntelliDestHMIListener.this.guiSearchHandler.startAddLocationToContact(navLocation);
                    break;
                }
                case 401029: {
                    object = (NaviSearchResultListRow)IntelliDestHMIListener.this.intelliDestResultList.getRow(n3);
                    IntelliDestHMIListener.this.searchController.getMainSearch().removeFromHistory(((SearchResultListRow)object).getSearchResult().getDataId());
                    IntelliDestHMIListener.this.intelliDestResultList.remove((EvoListRow)object);
                    break;
                }
                case 401622: {
                    IntelliDestHMIListener.this.guiSearchHandler.optionShowContactDetailsForAdbResult(n3);
                    break;
                }
                case 401005: {
                    PoiUtil.callPoi(navLocation, IntelliDestHMIListener.this.env, IntelliDestHMIListener.this.commandListFactory, IntelliDestHMIListener.this.telService);
                    break;
                }
            }
            IntelliDestHMIListener.this.env.getHMIService().getOptionModel(n).fireEvent(n5);
        }
    }
}

