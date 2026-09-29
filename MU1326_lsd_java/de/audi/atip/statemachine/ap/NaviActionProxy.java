/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface NaviActionProxy
extends ActionProxy {
    default public void enterPOINewAreaSearchScreen(int n) {
    }

    default public void leavePOINewAreaSearchScreen(int n) {
    }

    default public void onlineSearchEnter(int n, int n2) {
    }

    default public void reenterPOIOnline(int n) {
    }

    default public void exitTrufflesRangeSelect(int n) {
    }

    default public void enterShowDetailsOnlinePoiBrowserMain(int n) {
    }

    default public void destPOIHKReturn(int n, int n2) {
    }

    default public void exitPoiInput(int n) {
    }

    default public void enterDestIntellidest(int n) {
    }

    default public void enterDestLastDest(int n) {
    }

    default public void destAddressInputHKReturn(int n) {
    }

    default public void enterDemoModeStartPosIntellidest(int n) {
    }

    default public void exitRouteCriteria(int n) {
    }

    default public void exitNavDestForm(int n) {
    }

    default public void navFuelFeatureActive(int n, int n2) {
    }

    default public void exitPreviewMapScreen(int n) {
    }

    default public void exitDestIntellidest(int n) {
    }

    default public void onlineSearchExit(int n) {
    }

    default public void setDestActiveContext(int n, int n2) {
    }

    default public void onlinePOIMainExit(int n) {
    }

    default public void onlinePOIMainEnter(int n) {
    }

    default public void returnFromConnectivity(int n) {
    }

    default public void enterGeoCoordInput(int n) {
    }

    default public void enterDestOptSaveAsFavorite(int n) {
    }

    default public void enterNavDestForm(int n) {
    }

    default public void enterTpegPOIRRD(int n) {
    }

    default public void exitTpegPOIRRD(int n) {
    }

    default public void enterTpegPOI(int n) {
    }

    default public void exitTpegPOI(int n) {
    }

    default public void destTpegPOIHKReturn(int n, int n2) {
    }

    default public void exitPoiWarning(int n) {
    }

    default public void exitNaviGeneralSettings(int n) {
    }

    default public void setMapActiveContext(int n, int n2) {
    }

    default public void resetAudiConnectOptionState(int n) {
    }

    default public void navigationLeft(int n) {
    }

    default public void navigationEntered(int n) {
    }

    default public void cancelInput(int n) {
    }

    default public void enterMapScreen(int n, int n2) {
    }

    default public void exitMapScreen(int n) {
    }

    default public void enterNavCalcRoute(int n) {
    }

    default public void exitNavCalcRoute(int n) {
    }

    default public void activateMap(int n) {
    }

    default public void activateDestination(int n) {
    }

    default public void rmlExit(int n) {
    }

    default public void rmlEnter(int n) {
    }

    default public void enterRRD(int n, int n2) {
    }

    default public void exitRRD(int n, int n2) {
    }

    default public void enterPoiMainScreen(int n) {
    }

    default public void exitPoiMainScreen(int n) {
    }

    default public void setNavigationInputMode(int n, int n2) {
    }

    default public void enterNavFavorites(int n) {
    }

    default public void exitNavFavorites(int n) {
    }

    default public void enterPreviewMapScreen(int n, int n2, int n3) {
    }

    default public void enterDestOptMethods(int n) {
    }

    default public void exitDestOptMethods(int n) {
    }

    default public void enterDestOptContacts(int n) {
    }

    default public void exitDestOptContacts(int n) {
    }

    default public void exitParkingAtDestinationScreen(int n) {
    }

    default public void enterAddAddressDestOpt(int n) {
    }

    default public void setOnlineMapDataConnectionStatus(int n, boolean bl) {
    }

    default public void onlineMapEntered(int n) {
    }

    default public void enterMapMainScreen(int n) {
    }

    default public void exitMapMainScreen(int n) {
    }

    default public void enterMapBriefingScreen(int n) {
    }

    default public void exitMapBriefingScreen(int n) {
    }

    default public void confirmRouteCalcFail(int n) {
    }

    default public void onlineTrafficLicenceActive(int n) {
    }

    default public void enterDestIntellidestDownTransition(int n) {
    }

    default public void enterNavFavoritesDownTransition(int n) {
    }

    default public void enterDestSelectionContext(int n, int n2) {
    }

    default public void setDestOptSelectionBreadcrumb(int n, int n2) {
    }

    default public void setOnlineMapDataConnectionLicenseStatus(int n, boolean bl, boolean bl2) {
    }

    default public void returnFromConnectivityError(int n) {
    }

    default public void setNavDestPOIContext(int n, int n2) {
    }

    default public void setNavAddressFormContext(int n, int n2) {
    }

    default public void enterTrafficDetails(int n, int n2) {
    }

    default public void exitTrafficDetails(int n) {
    }

    default public void setMapShowDetailsContext(int n, int n2) {
    }

    default public void setMapPoiStackScreenInactive(int n) {
    }

    default public void setMapPoiStackScreenActive(int n) {
    }

    default public void setSpellerScreenActive(int n) {
    }

    default public void setSpellerScreenInactive(int n) {
    }

    default public void enterMapScreenFromLeftDrawer(int n) {
    }

    default public void enterDestOptFavorites(int n) {
    }

    default public void setPoiActiveContext(int n, int n2) {
    }

    default public void weatherMapLicenceActive(int n) {
    }

    default public void weatherMapLicenceActiveKombi(int n) {
    }

    default public void exitAddAddressDestOpt(int n) {
    }

    default public void exitDemoModeStartPosIntellidest(int n) {
    }

    default public void exitDestLastDest(int n) {
    }

    default public void exitDestOptFavorites(int n) {
    }

    default public void destExitStartGuidancePopup(int n) {
    }

    default public void enterMapOptionsDrawer(int n) {
    }

    default public void exitMapOptionsDrawer(int n) {
    }

    default public void setMapLicenceWeatherMapCheckResChoice(int n, int n2) {
    }

    default public void enterGoogleSplashScreen(int n) {
    }

    default public void exitGoogleSplashScreen(int n) {
    }

    default public void enterOperatorCallMapScreen(int n) {
    }

    default public void exitOperatorCallMapScreen(int n) {
    }

    default public void prepareVICS2ShowInMap(int n) {
    }

    default public void closeSelectionDrawer(int n) {
    }
}

