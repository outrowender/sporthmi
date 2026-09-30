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
    private static final int ENTRYPOINT_LEFTDRAWER_DESTINATION = 2;
    private static final int ENTRYPOINT_REMOTEHMI = 3;
    private static final int SEARCH_AREA_ACTIVE = 1;
    private static final int SEARCH_AREA_INACTIVE = 0;
    private static final int MAP_POI_STACK_SCREEN_INACTIVE = 0;
    private static final int MAP_POI_STACK_SCREEN_ACTIVE = 1;
    public static final int SPELLER_SCREEN_INACTIVE = 0;
    public static final int SPELLER_SCREEN_ACTIVE = 1;
    public static final int POI_NEW_AREA_SEARCH_ACTIVE = 1;
    public static final int POI_NEW_AREA_SEARCH_INACTIVE = 0;
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

    public void enterNavDestForm(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterNavDestFormScreen()");
        this.navigation.getInterAppService().getSDSHandler().enterNavDestForm();
        this.env.getChoiceModel(400326).setValue(0);
        this.env.getChoiceModel(402014).setValue(1);
    }

    public void activateMap(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#activateMap()");
        this.env.getChoiceModel(400904).setValue(0);
    }

    public void activateDestination(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#activateDestination()");
        this.env.getChoiceModel(400904).setValue(1);
    }

    public void exitTrufflesRangeSelect(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitTrufflesRangeSelect()");
        this.intelliDestAccess.exitTrufflesRangeSelect();
    }

    public void exitNavDestForm(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitNavDestForm");
        this.navigation.getAddressInputForm().persistBackupLocation(this.navigation.getAddressInputForm().getBackupLocation());
        this.env.getChoiceModel(402014).setValue(0);
    }

    public void destPOIHKReturn(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#destPOIHKReturn, removeHandler: %1", (long)n2);
        this.poiService.destPOIHKReturn(n, n2);
    }

    public void destExitStartGuidancePopup(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#destExitStartGuidancePopup()");
        this.destinationHandler.setTransfereToNdf(false);
    }

    public void exitParkingAtDestinationScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitParkingAtDestinationScreen()");
        this.poiService.destPOIHKReturn(n, 0);
    }

    public void exitPoiInput(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitPoiInput()");
        if (this.poiService != null) {
            this.poiService.resetSearchContext();
        }
    }

    public void exitRouteCriteria(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitRouteCriteria()");
        this.routeCriteriaHMIListener.routeCriteriaScreenExited();
    }

    public void exitNaviGeneralSettings(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitNaviGeneralSettings()");
        this.routeCriteriaHMIListener.routeCriteriaScreenExited();
    }

    public void enterDestIntellidest(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestIntellidest()");
        this.intelliDestAccess.enterDestinationContext(0);
    }

    public void exitDestIntellidest(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitDestIntellidest()");
        this.intelliDestAccess.exitDestinationContext(0);
        this.logChannelPerformance.log(10000000, this.CLASS_NAME + "#exitDestIntellidest()");
    }

    public void enterDestOptContacts(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestOptContacts()");
        this.intelliDestAccess.enterDestinationContext(4);
    }

    public void exitDestOptContacts(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitDestOptContacts()");
        this.intelliDestAccess.exitDestinationContext(4);
    }

    public void enterDestOptFavorites(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestOptFavorites()");
        this.intelliDestAccess.enterDestinationContext(7);
    }

    public void exitDestOptFavorites(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitDestOptFavorites()");
        this.intelliDestAccess.exitDestinationContext(7);
    }

    public void enterAddAddressDestOpt(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterAddAddressDestOpt()");
        this.intelliDestAccess.enterDestinationContext(6);
    }

    public void exitAddAddressDestOpt(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitAddAddressDestOpt()");
        this.intelliDestAccess.exitDestinationContext(6);
    }

    public void enterDestLastDest(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestLastDest()");
        this.intelliDestAccess.enterDestinationContext(5);
    }

    public void exitDestLastDest(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitDestLastDest()");
        this.intelliDestAccess.exitDestinationContext(5);
    }

    public void enterDemoModeStartPosIntellidest(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDemoModeStartPosIntellidest()");
        this.intelliDestAccess.enterDestinationContext(1);
        this.env.getInputModeManager().setInputMode(9, this.env);
    }

    public void exitDemoModeStartPosIntellidest(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitDemoModeStartPosIntellidest()");
        this.intelliDestAccess.exitDestinationContext(1);
    }

    public void destAddressInputHKReturn(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#destAddressInputHKReturn");
        this.addressInputService.destAddressInputHKReturn(n, -1, null, null);
    }

    public void navFuelFeatureActive(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#navFuelFeatureActive()");
        this.poiService.navFuelFeatureActive(n, n2);
    }

    public void rmlExit(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#rmlExit()");
        this.rmlListener.stop();
    }

    public void rmlEnter(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#rmlEnter()");
        this.rmlListener.start();
    }

    public void onlineSearchExit(int n) {
        this.logChannel.log(1000000, this.CLASS_NAME + "#onlineSearchExit: called");
        if (this.navigation.getOnlineSearchController() != null) {
            this.navigation.getOnlineSearchController().onlineSearchExit();
        } else {
            this.logChannel.log(100000, this.CLASS_NAME + "#onlineSearchExit: online search controller is null");
        }
    }

    public void enterRRD(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterRRD(%1)", (long)n2);
        int n3 = this.env.getChoiceModel(402577).getValue();
        if (n3 != 2 && n3 != 4 && n3 != 3) {
            this.navigation.getRrdListener().enterRRD(n2);
        } else {
            this.logChannel.log(1000000, this.CLASS_NAME + "#enterRRD: will not call enterRRD because no RRD is needed for searchContext vicinity");
        }
    }

    public void exitRRD(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitRRD(%1)", (long)n2);
        this.navigation.getRrdListener().exitRRD(n2);
    }

    public void enterTpegPOIRRD(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterTpegPOIRRD()");
        this.navigation.getRrdListener().enterRRD(8);
    }

    public void exitTpegPOIRRD(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitTpegPOIRRD()");
        this.navigation.getRrdListener().exitRRD(8);
    }

    public void enterTpegPOI(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterTpegPOI()");
    }

    public void exitTpegPOI(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitTpegPOI()");
    }

    public void destTpegPOIHKReturn(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#destTpegPOIHKReturn, removeHandler: %1", (long)n2);
        this.tpegPOIService.destTpegPOIHKReturn(n, n2);
    }

    public void setDestActiveContext(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setDestActiveContext(terminalID=%1, value=%2)", (long)n, (long)n2);
        this.env.getChoiceModel(401416).setValue(n2);
    }

    public void setMapActiveContext(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setMapActiveContext(terminalID=%1, value=%2)", (long)n, (long)n2);
        this.env.getChoiceModel(401415).setValue(n2);
    }

    public void enterPoiMainScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterPoiMainScreen()");
        this.env.getChoiceModel(401420).setValue(1);
        super.enterPoiMainScreen(n);
    }

    public void exitPoiMainScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitPoiMainScreen()");
        this.env.getChoiceModel(401420).setValue(0);
    }

    public void enterNavFavorites(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterNavFavorites()");
        this.intelliDestAccess.enterDestinationContext(2);
    }

    public void exitNavFavorites(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitNavFavorites()");
        this.naviFavoriteHandler.updateNaviPersistence();
        this.intelliDestAccess.exitDestinationContext(2);
    }

    public void setNavigationInputMode(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setNavigationInputMode - mode=%1", (long)n2);
        this.env.getInputModeManager().setInputMode(n2, this.env);
    }

    public void enterDestOptMethods(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestOptMethods()");
        this.intelliDestAccess.enterDestinationContext(3);
    }

    public void exitDestOptMethods(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#exitDestOptMethods()");
        this.intelliDestAccess.exitDestinationContext(3);
    }

    public void onlinePOIMainEnter(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onlinePOIMainEnter: Called ");
        this.navigation.getOnlineSearchController().onlinePOIMainEnter();
    }

    public void onlinePOIMainExit(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onlinePOIMainExit: Called ");
        this.navigation.getOnlineSearchController().onlinePOIMainExit();
    }

    public void onlineSearchEnter(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#onlineSearchEnter: Called with entry point '%1'", (Object)new Integer(n2));
        if (n2 == 2 || n2 == 3) {
            OnlineSearchForm onlineSearchForm = ((OnlineSearchControllerEvo)this.navigation.getOnlineSearchController()).getOnlineSearchForm();
            onlineSearchForm.startNewSearch();
        }
    }

    public void confirmRouteCalcFail(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#confirmRouteCalcFail: Called ");
        this.env.getChoiceModel(401582).setValue(0);
    }

    public void enterDestIntellidestDownTransition(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestIntellidestDownTransition");
        this.intelliDestAccess.enterDestinationContextDownTransition(0);
    }

    public void enterNavFavoritesDownTransition(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterNavFavoritesDownTransition");
        this.intelliDestAccess.enterDestinationContextDownTransition(2);
    }

    public void enterDestSelectionContext(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestSelectionContext('%1')", (Object)new Integer(n2));
        this.contextHmiListener.handleDestContextChange(n2);
    }

    public void setDestOptSelectionBreadcrumb(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setDestOptSelectionBreadcrumb('%1')", (Object)new Integer(n2));
        this.env.getChoiceModel(401650).setValue(n2);
    }

    public void returnFromConnectivity(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#returnFromConnectivity: connectivity is succesfully established and triggering download");
        this.navigation.getRemoteHMIAppsBaseListener().triggerAppListDownload();
    }

    public void returnFromConnectivityError(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#returnFromConnectivity: connectivity has problems and going to back to previous state.");
        this.navigation.getRemoteHMIAppsBaseListener().configureModelsMiniApps(3, 48);
    }

    public void setNavDestPOIContext(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setNavDestPOIContext setting to contextId=%1", (long)n2);
        this.env.getChoiceModel(401690).setValue(n2);
    }

    public void setNavAddressFormContext(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setNavAddressFormContext setting to contextId=%1", (long)n2);
        this.env.getChoiceModel(401701).setValue(n2);
    }

    public void setMapShowDetailsContext(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setMapShowDetailsContext to contextId=%1", (long)n2);
        this.env.getChoiceModel(401704).setValue(n2);
    }

    public void setMapPoiStackScreenActive(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setMapPoiStackScreenActive");
        this.env.getChoiceModel(401783).setValue(1);
    }

    public void setMapPoiStackScreenInactive(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setMapPoiStackScreenInactive");
        this.env.getChoiceModel(401783).setValue(0);
    }

    public void setSpellerScreenActive(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setSpellerScreenActive");
        this.env.getChoiceModel(401794).setValue(1);
    }

    public void setSpellerScreenInactive(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setSpellerScreenInactive");
        this.env.getChoiceModel(401794).setValue(0);
    }

    public void enterPOINewAreaSearchScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterPOINewAreaSearchScreen()");
        this.env.getChoiceModel(401824).setValue(1);
    }

    public void leavePOINewAreaSearchScreen(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#leavePOINewAreaSearchScreen()");
        this.env.getChoiceModel(401824).setValue(0);
    }

    public void reenterPOIOnline(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#reenterPOIOnline()");
        OnlineSearchForm onlineSearchForm = ((OnlineSearchControllerEvo)this.navigation.getOnlineSearchController()).getOnlineSearchForm();
        onlineSearchForm.getProviderHandler().updateVisibility(1);
    }

    public void setPoiActiveContext(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setPoiActiveContext - contextId=%1", (long)n2);
        this.env.getChoiceModel(401894).setValue(n2);
    }

    public void enterGeoCoordInput(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterGeoCoordInput - terminalID=%1", (long)n);
        this.navigation.getGeoCoordInputHmiListener().enterGeoCoordInput(n);
    }

    public void enterDestOptSaveAsFavorite(int n) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#enterDestOptSaveAsFavorite - terminalID=%1", (long)n);
        this.navigation.getNaviFavoriteHmiListener().enterDestOptSaveAsFavorite();
    }

    public void setMapLicenceWeatherMapCheckResChoice(int n, int n2) {
        this.logChannel.log(10000000, this.CLASS_NAME + "#setMapLicenceWeatherMapCheckResChoiceModel() - value: %1 ", (long)n2);
        this.env.getChoiceModel(402043).setValue(n2);
    }

    public void navDestEnterMapcode(int n) {
        this.logChannel.log(100000000, this.CLASS_NAME + "#navDestEnterMapcode() ");
    }

    public void navDestLeaveMapcode(int n) {
        this.logChannel.log(100000000, this.CLASS_NAME + "#navDestLeaveMapcode() ");
    }

    public void navDestEnterTelephone(int n) {
        this.logChannel.log(100000000, this.CLASS_NAME + "#navDestEnterTelephone() ");
    }

    public void navDestLeaveTelephone(int n) {
        this.logChannel.log(100000000, this.CLASS_NAME + "#navDestLeaveTelephone() ");
    }

    public void resetAudiConnectOptionState(int n) {
        this.logChannel.log(100000000, this.CLASS_NAME + "#resetAudiConnectOptionState() ");
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

