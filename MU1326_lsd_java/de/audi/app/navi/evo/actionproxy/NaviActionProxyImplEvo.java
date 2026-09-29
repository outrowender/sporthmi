/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.actionproxy;

import de.audi.app.navi.evo.NavigationContextHmiListener;
import de.audi.app.navi.evo.NavigationEvo;
import de.audi.app.navi.evo.poi.online.OnlineSearchControllerEvo;
import de.audi.app.navi.evo.poi.online.OnlineSearchForm;
import de.audi.app.navi.evo.rml.RMLListener;
import de.audi.app.navi.evo.setup.RouteCriteriaHMIListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.statemachine.ap.NaviActionProxy;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.IAddressInputForm;
import de.audi.tghu.navi.app.addressinput.poi.IPoiService;
import de.audi.tghu.navi.app.addressinput.tpegpoi.ITpegPOIService;
import de.audi.tghu.navi.app.appcore.NaviActionProxyImplCore;
import de.audi.tghu.navi.app.details.IDestinationHandler;
import de.audi.tghu.navi.app.favorite.NaviFavoriteHandler;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.search.IntelliDestAccess;

public class NaviActionProxyImplEvo
extends NaviActionProxyImplCore
implements NaviActionProxy {
    private static final int ENTRYPOINT_LEFTDRAWER_DESTINATION;
    private static final int ENTRYPOINT_REMOTEHMI;
    private static final int SEARCH_AREA_ACTIVE;
    private static final int SEARCH_AREA_INACTIVE;
    private static final int MAP_POI_STACK_SCREEN_INACTIVE;
    private static final int MAP_POI_STACK_SCREEN_ACTIVE;
    public static final int SPELLER_SCREEN_INACTIVE;
    public static final int SPELLER_SCREEN_ACTIVE;
    public static final int POI_NEW_AREA_SEARCH_ACTIVE;
    public static final int POI_NEW_AREA_SEARCH_INACTIVE;
    protected NavigationEvo navigation;
    protected IntelliDestAccess intelliDestAccess;
    protected RouteCriteriaHMIListener routeCriteriaHMIListener;
    private RMLListener rmlListener;
    private NaviFavoriteHandler naviFavoriteHandler;
    private NavigationContextHmiListener contextHmiListener;
    private IAddressInputForm addressInputService;
    private ITpegPOIService tpegPOIService;
    private IDestinationHandler destinationHandler;
    private final LogChannel logChannelPerformance;

    public NaviActionProxyImplEvo(NavigationEnv navigationEnv, NavigationEvo navigationEvo, IPoiService iPoiService, RouteCriteriaHMIListener routeCriteriaHMIListener, RMLListener rMLListener, MapInterface mapInterface, NaviFavoriteHandler naviFavoriteHandler, IntelliDestAccess intelliDestAccess, NavigationContextHmiListener navigationContextHmiListener, IAddressInputForm iAddressInputForm, ITpegPOIService iTpegPOIService, IDestinationHandler iDestinationHandler) {
        super(navigationEnv, mapInterface, navigationEvo.getOnlineTrafficHandler(), iPoiService);
        this.rmlListener = rMLListener;
        this.navigation = navigationEvo;
        this.naviFavoriteHandler = naviFavoriteHandler;
        this.intelliDestAccess = intelliDestAccess;
        this.routeCriteriaHMIListener = routeCriteriaHMIListener;
        this.contextHmiListener = navigationContextHmiListener;
        this.addressInputService = iAddressInputForm;
        this.tpegPOIService = iTpegPOIService;
        this.destinationHandler = iDestinationHandler;
        this.logChannelPerformance = navigationEnv.getLogChannel("App.Navi.Search.Performance");
    }

    @Override
    public void enterNavDestForm(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterNavDestFormScreen()").toString());
        this.navigation.getInterAppService().getSDSHandler().enterNavDestForm();
        this.env.getChoiceModel(-971307520).setValue(0);
        this.env.getChoiceModel(1579288064).setValue(1);
    }

    @Override
    public void activateMap(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#activateMap()").toString());
        this.env.getChoiceModel(136185344).setValue(0);
    }

    @Override
    public void activateDestination(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#activateDestination()").toString());
        this.env.getChoiceModel(136185344).setValue(1);
    }

    @Override
    public void exitTrufflesRangeSelect(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitTrufflesRangeSelect()").toString());
        this.intelliDestAccess.exitTrufflesRangeSelect();
    }

    @Override
    public void exitNavDestForm(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitNavDestForm").toString());
        this.navigation.getAddressInputForm().persistBackupLocation(this.navigation.getAddressInputForm().getBackupLocation());
        this.env.getChoiceModel(1579288064).setValue(0);
    }

    @Override
    public void destPOIHKReturn(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#destPOIHKReturn, removeHandler: %1").toString(), (long)n2);
        this.poiService.destPOIHKReturn(n, n2);
    }

    @Override
    public void destExitStartGuidancePopup(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#destExitStartGuidancePopup()").toString());
        this.destinationHandler.setTransfereToNdf(false);
    }

    @Override
    public void exitParkingAtDestinationScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitParkingAtDestinationScreen()").toString());
        this.poiService.destPOIHKReturn(n, 0);
    }

    @Override
    public void exitPoiInput(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitPoiInput()").toString());
        if (this.poiService != null) {
            this.poiService.resetSearchContext();
        }
    }

    @Override
    public void exitRouteCriteria(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitRouteCriteria()").toString());
        this.routeCriteriaHMIListener.routeCriteriaScreenExited();
    }

    @Override
    public void exitNaviGeneralSettings(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitNaviGeneralSettings()").toString());
        this.routeCriteriaHMIListener.routeCriteriaScreenExited();
    }

    @Override
    public void enterDestIntellidest(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestIntellidest()").toString());
        this.intelliDestAccess.enterDestinationContext(0);
    }

    @Override
    public void exitDestIntellidest(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitDestIntellidest()").toString());
        this.intelliDestAccess.exitDestinationContext(0);
        this.logChannelPerformance.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitDestIntellidest()").toString());
    }

    @Override
    public void enterDestOptContacts(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestOptContacts()").toString());
        this.intelliDestAccess.enterDestinationContext(4);
    }

    @Override
    public void exitDestOptContacts(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitDestOptContacts()").toString());
        this.intelliDestAccess.exitDestinationContext(4);
    }

    @Override
    public void enterDestOptFavorites(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestOptFavorites()").toString());
        this.intelliDestAccess.enterDestinationContext(7);
    }

    @Override
    public void exitDestOptFavorites(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitDestOptFavorites()").toString());
        this.intelliDestAccess.exitDestinationContext(7);
    }

    @Override
    public void enterAddAddressDestOpt(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterAddAddressDestOpt()").toString());
        this.intelliDestAccess.enterDestinationContext(6);
    }

    @Override
    public void exitAddAddressDestOpt(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitAddAddressDestOpt()").toString());
        this.intelliDestAccess.exitDestinationContext(6);
    }

    @Override
    public void enterDestLastDest(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestLastDest()").toString());
        this.intelliDestAccess.enterDestinationContext(5);
    }

    @Override
    public void exitDestLastDest(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitDestLastDest()").toString());
        this.intelliDestAccess.exitDestinationContext(5);
    }

    @Override
    public void enterDemoModeStartPosIntellidest(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDemoModeStartPosIntellidest()").toString());
        this.intelliDestAccess.enterDestinationContext(1);
        this.env.getInputModeManager().setInputMode(9, this.env);
    }

    @Override
    public void exitDemoModeStartPosIntellidest(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitDemoModeStartPosIntellidest()").toString());
        this.intelliDestAccess.exitDestinationContext(1);
    }

    @Override
    public void destAddressInputHKReturn(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#destAddressInputHKReturn").toString());
        this.addressInputService.destAddressInputHKReturn(n, -1, null, null);
    }

    @Override
    public void navFuelFeatureActive(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#navFuelFeatureActive()").toString());
        this.poiService.navFuelFeatureActive(n, n2);
    }

    @Override
    public void rmlExit(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#rmlExit()").toString());
        this.rmlListener.stop();
    }

    @Override
    public void rmlEnter(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#rmlEnter()").toString());
        this.rmlListener.start();
    }

    @Override
    public void onlineSearchExit(int n) {
        this.logChannel.log(1078071040, new StringBuffer().append(this.CLASS_NAME).append("#onlineSearchExit: called").toString());
        if (this.navigation.getOnlineSearchController() != null) {
            this.navigation.getOnlineSearchController().onlineSearchExit();
        } else {
            this.logChannel.log(-1601830656, new StringBuffer().append(this.CLASS_NAME).append("#onlineSearchExit: online search controller is null").toString());
        }
    }

    @Override
    public void enterRRD(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterRRD(%1)").toString(), (long)n2);
        int n3 = this.env.getChoiceModel(-1859910144).getValue();
        if (n3 != 2 && n3 != 4 && n3 != 3) {
            this.navigation.getRrdListener().enterRRD(n2);
        } else {
            this.logChannel.log(1078071040, new StringBuffer().append(this.CLASS_NAME).append("#enterRRD: will not call enterRRD because no RRD is needed for searchContext vicinity").toString());
        }
    }

    @Override
    public void exitRRD(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitRRD(%1)").toString(), (long)n2);
        this.navigation.getRrdListener().exitRRD(n2);
    }

    @Override
    public void enterTpegPOIRRD(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterTpegPOIRRD()").toString());
        this.navigation.getRrdListener().enterRRD(8);
    }

    @Override
    public void exitTpegPOIRRD(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitTpegPOIRRD()").toString());
        this.navigation.getRrdListener().exitRRD(8);
    }

    @Override
    public void enterTpegPOI(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterTpegPOI()").toString());
    }

    @Override
    public void exitTpegPOI(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitTpegPOI()").toString());
    }

    @Override
    public void destTpegPOIHKReturn(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#destTpegPOIHKReturn, removeHandler: %1").toString(), (long)n2);
        this.tpegPOIService.destTpegPOIHKReturn(n, n2);
    }

    @Override
    public void setDestActiveContext(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setDestActiveContext(terminalID=%1, value=%2)").toString(), (long)n, (long)n2);
        this.env.getChoiceModel(136316416).setValue(n2);
    }

    @Override
    public void setMapActiveContext(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setMapActiveContext(terminalID=%1, value=%2)").toString(), (long)n, (long)n2);
        this.env.getChoiceModel(119539200).setValue(n2);
    }

    @Override
    public void enterPoiMainScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterPoiMainScreen()").toString());
        this.env.getChoiceModel(203425280).setValue(1);
        super.enterPoiMainScreen(n);
    }

    @Override
    public void exitPoiMainScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitPoiMainScreen()").toString());
        this.env.getChoiceModel(203425280).setValue(0);
    }

    @Override
    public void enterNavFavorites(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterNavFavorites()").toString());
        this.intelliDestAccess.enterDestinationContext(2);
    }

    @Override
    public void exitNavFavorites(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitNavFavorites()").toString());
        this.naviFavoriteHandler.updateNaviPersistence();
        this.intelliDestAccess.exitDestinationContext(2);
    }

    @Override
    public void setNavigationInputMode(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setNavigationInputMode - mode=%1").toString(), (long)n2);
        this.env.getInputModeManager().setInputMode(n2, this.env);
    }

    @Override
    public void enterDestOptMethods(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestOptMethods()").toString());
        this.intelliDestAccess.enterDestinationContext(3);
    }

    @Override
    public void exitDestOptMethods(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#exitDestOptMethods()").toString());
        this.intelliDestAccess.exitDestinationContext(3);
    }

    @Override
    public void onlinePOIMainEnter(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onlinePOIMainEnter: Called ").toString());
        this.navigation.getOnlineSearchController().onlinePOIMainEnter();
    }

    @Override
    public void onlinePOIMainExit(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onlinePOIMainExit: Called ").toString());
        this.navigation.getOnlineSearchController().onlinePOIMainExit();
    }

    @Override
    public void onlineSearchEnter(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#onlineSearchEnter: Called with entry point '%1'").toString(), (Object)new Integer(n2));
        if (n2 == 2 || n2 == 3) {
            OnlineSearchForm onlineSearchForm = ((OnlineSearchControllerEvo)this.navigation.getOnlineSearchController()).getOnlineSearchForm();
            onlineSearchForm.startNewSearch();
        }
    }

    @Override
    public void confirmRouteCalcFail(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#confirmRouteCalcFail: Called ").toString());
        this.env.getChoiceModel(-1373633024).setValue(0);
    }

    @Override
    public void enterDestIntellidestDownTransition(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestIntellidestDownTransition").toString());
        this.intelliDestAccess.enterDestinationContextDownTransition(0);
    }

    @Override
    public void enterNavFavoritesDownTransition(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterNavFavoritesDownTransition").toString());
        this.intelliDestAccess.enterDestinationContextDownTransition(2);
    }

    @Override
    public void enterDestSelectionContext(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestSelectionContext('%1')").toString(), (Object)new Integer(n2));
        this.contextHmiListener.handleDestContextChange(n2);
    }

    @Override
    public void setDestOptSelectionBreadcrumb(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setDestOptSelectionBreadcrumb('%1')").toString(), (Object)new Integer(n2));
        this.env.getChoiceModel(-232782336).setValue(n2);
    }

    @Override
    public void returnFromConnectivity(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#returnFromConnectivity: connectivity is succesfully established and triggering download").toString());
        this.navigation.getRemoteHMIAppsBaseListener().triggerAppListDownload();
    }

    @Override
    public void returnFromConnectivityError(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#returnFromConnectivity: connectivity has problems and going to back to previous state.").toString());
        this.navigation.getRemoteHMIAppsBaseListener().configureModelsMiniApps(3, 48);
    }

    @Override
    public void setNavDestPOIContext(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setNavDestPOIContext setting to contextId=%1").toString(), (long)n2);
        this.env.getChoiceModel(438371840).setValue(n2);
    }

    @Override
    public void setNavAddressFormContext(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setNavAddressFormContext setting to contextId=%1").toString(), (long)n2);
        this.env.getChoiceModel(622921216).setValue(n2);
    }

    @Override
    public void setMapShowDetailsContext(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setMapShowDetailsContext to contextId=%1").toString(), (long)n2);
        this.env.getChoiceModel(673252864).setValue(n2);
    }

    @Override
    public void setMapPoiStackScreenActive(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setMapPoiStackScreenActive").toString());
        this.env.getChoiceModel(1998652928).setValue(1);
    }

    @Override
    public void setMapPoiStackScreenInactive(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setMapPoiStackScreenInactive").toString());
        this.env.getChoiceModel(1998652928).setValue(0);
    }

    @Override
    public void setSpellerScreenActive(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setSpellerScreenActive").toString());
        this.env.getChoiceModel(-2111764992).setValue(1);
    }

    @Override
    public void setSpellerScreenInactive(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setSpellerScreenInactive").toString());
        this.env.getChoiceModel(-2111764992).setValue(0);
    }

    @Override
    public void enterPOINewAreaSearchScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterPOINewAreaSearchScreen()").toString());
        this.env.getChoiceModel(-1608448512).setValue(1);
    }

    @Override
    public void leavePOINewAreaSearchScreen(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#leavePOINewAreaSearchScreen()").toString());
        this.env.getChoiceModel(-1608448512).setValue(0);
    }

    @Override
    public void reenterPOIOnline(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#reenterPOIOnline()").toString());
        OnlineSearchForm onlineSearchForm = ((OnlineSearchControllerEvo)this.navigation.getOnlineSearchController()).getOnlineSearchForm();
        onlineSearchForm.getProviderHandler().updateVisibility(1);
    }

    @Override
    public void setPoiActiveContext(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setPoiActiveContext - contextId=%1").toString(), (long)n2);
        this.env.getChoiceModel(-434043392).setValue(n2);
    }

    @Override
    public void enterGeoCoordInput(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterGeoCoordInput - terminalID=%1").toString(), (long)n);
        this.navigation.getGeoCoordInputHmiListener().enterGeoCoordInput(n);
    }

    @Override
    public void enterDestOptSaveAsFavorite(int n) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#enterDestOptSaveAsFavorite - terminalID=%1").toString(), (long)n);
        this.navigation.getNaviFavoriteHmiListener().enterDestOptSaveAsFavorite();
    }

    @Override
    public void setMapLicenceWeatherMapCheckResChoice(int n, int n2) {
        this.logChannel.log(-2137614336, new StringBuffer().append(this.CLASS_NAME).append("#setMapLicenceWeatherMapCheckResChoiceModel() - value: %1 ").toString(), (long)n2);
        this.env.getChoiceModel(2065827328).setValue(n2);
    }

    public void navDestEnterMapcode(int n) {
        this.logChannel.log(14808325, new StringBuffer().append(this.CLASS_NAME).append("#navDestEnterMapcode() ").toString());
    }

    public void navDestLeaveMapcode(int n) {
        this.logChannel.log(14808325, new StringBuffer().append(this.CLASS_NAME).append("#navDestLeaveMapcode() ").toString());
    }

    public void navDestEnterTelephone(int n) {
        this.logChannel.log(14808325, new StringBuffer().append(this.CLASS_NAME).append("#navDestEnterTelephone() ").toString());
    }

    public void navDestLeaveTelephone(int n) {
        this.logChannel.log(14808325, new StringBuffer().append(this.CLASS_NAME).append("#navDestLeaveTelephone() ").toString());
    }

    @Override
    public void resetAudiConnectOptionState(int n) {
        this.logChannel.log(14808325, new StringBuffer().append(this.CLASS_NAME).append("#resetAudiConnectOptionState() ").toString());
        this.navigation.getRemoteHMIAppsBaseListener().resetAudiConnectOptionState();
    }

    public void cleaunUp() {
        this.navigation = null;
        this.intelliDestAccess = null;
        this.routeCriteriaHMIListener = null;
        this.rmlListener = null;
        this.naviFavoriteHandler = null;
        this.contextHmiListener = null;
        this.addressInputService = null;
        this.tpegPOIService = null;
    }
}

