/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface NaviActionProxy
extends ActionProxy {
    public void enterPOINewAreaSearchScreen(int var1);

    public void leavePOINewAreaSearchScreen(int var1);

    public void onlineSearchEnter(int var1, int var2);

    public void reenterPOIOnline(int var1);

    public void exitTrufflesRangeSelect(int var1);

    public void enterShowDetailsOnlinePoiBrowserMain(int var1);

    public void destPOIHKReturn(int var1, int var2);

    public void exitPoiInput(int var1);

    public void enterDestIntellidest(int var1);

    public void enterDestLastDest(int var1);

    public void destAddressInputHKReturn(int var1);

    public void enterDemoModeStartPosIntellidest(int var1);

    public void exitRouteCriteria(int var1);

    public void exitNavDestForm(int var1);

    public void navFuelFeatureActive(int var1, int var2);

    public void exitPreviewMapScreen(int var1);

    public void exitDestIntellidest(int var1);

    public void onlineSearchExit(int var1);

    public void setDestActiveContext(int var1, int var2);

    public void onlinePOIMainExit(int var1);

    public void onlinePOIMainEnter(int var1);

    public void returnFromConnectivity(int var1);

    public void enterGeoCoordInput(int var1);

    public void enterDestOptSaveAsFavorite(int var1);

    public void enterNavDestForm(int var1);

    public void enterTpegPOIRRD(int var1);

    public void exitTpegPOIRRD(int var1);

    public void enterTpegPOI(int var1);

    public void exitTpegPOI(int var1);

    public void destTpegPOIHKReturn(int var1, int var2);

    public void exitPoiWarning(int var1);

    public void exitNaviGeneralSettings(int var1);

    public void setMapActiveContext(int var1, int var2);

    public void resetAudiConnectOptionState(int var1);

    public void navigationLeft(int var1);

    public void navigationEntered(int var1);

    public void cancelInput(int var1);

    public void enterMapScreen(int var1, int var2);

    public void exitMapScreen(int var1);

    public void enterNavCalcRoute(int var1);

    public void exitNavCalcRoute(int var1);

    public void activateMap(int var1);

    public void activateDestination(int var1);

    public void rmlExit(int var1);

    public void rmlEnter(int var1);

    public void enterRRD(int var1, int var2);

    public void exitRRD(int var1, int var2);

    public void enterPoiMainScreen(int var1);

    public void exitPoiMainScreen(int var1);

    public void setNavigationInputMode(int var1, int var2);

    public void enterNavFavorites(int var1);

    public void exitNavFavorites(int var1);

    public void enterPreviewMapScreen(int var1, int var2, int var3);

    public void enterDestOptMethods(int var1);

    public void exitDestOptMethods(int var1);

    public void enterDestOptContacts(int var1);

    public void exitDestOptContacts(int var1);

    public void exitParkingAtDestinationScreen(int var1);

    public void enterAddAddressDestOpt(int var1);

    public void setOnlineMapDataConnectionStatus(int var1, boolean var2);

    public void onlineMapEntered(int var1);

    public void enterMapMainScreen(int var1);

    public void exitMapMainScreen(int var1);

    public void enterMapBriefingScreen(int var1);

    public void exitMapBriefingScreen(int var1);

    public void confirmRouteCalcFail(int var1);

    public void onlineTrafficLicenceActive(int var1);

    public void enterDestIntellidestDownTransition(int var1);

    public void enterNavFavoritesDownTransition(int var1);

    public void enterDestSelectionContext(int var1, int var2);

    public void setDestOptSelectionBreadcrumb(int var1, int var2);

    public void setOnlineMapDataConnectionLicenseStatus(int var1, boolean var2, boolean var3);

    public void returnFromConnectivityError(int var1);

    public void setNavDestPOIContext(int var1, int var2);

    public void setNavAddressFormContext(int var1, int var2);

    public void enterTrafficDetails(int var1, int var2);

    public void exitTrafficDetails(int var1);

    public void setMapShowDetailsContext(int var1, int var2);

    public void setMapPoiStackScreenInactive(int var1);

    public void setMapPoiStackScreenActive(int var1);

    public void setSpellerScreenActive(int var1);

    public void setSpellerScreenInactive(int var1);

    public void enterMapScreenFromLeftDrawer(int var1);

    public void enterDestOptFavorites(int var1);

    public void setPoiActiveContext(int var1, int var2);

    public void weatherMapLicenceActive(int var1);

    public void weatherMapLicenceActiveKombi(int var1);

    public void exitAddAddressDestOpt(int var1);

    public void exitDemoModeStartPosIntellidest(int var1);

    public void exitDestLastDest(int var1);

    public void exitDestOptFavorites(int var1);

    public void destExitStartGuidancePopup(int var1);

    public void enterMapOptionsDrawer(int var1);

    public void exitMapOptionsDrawer(int var1);

    public void setMapLicenceWeatherMapCheckResChoice(int var1, int var2);

    public void enterGoogleSplashScreen(int var1);

    public void exitGoogleSplashScreen(int var1);

    public void enterOperatorCallMapScreen(int var1);

    public void exitOperatorCallMapScreen(int var1);

    public void prepareVICS2ShowInMap(int var1);

    public void closeSelectionDrawer(int var1);
}

