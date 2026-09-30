/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.PreviewMapCallback;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.tmc.TmcMessage;

public class NullPreviewMapHandler
implements IPreviewMap {
    public void setPreviewMapCallbackHandler(PreviewMapCallback previewMapCallback) {
    }

    public void hidePreviewMap() {
    }

    public void previewMapScreenEntering(int n, int n2, int n3, int n4) {
    }

    public void previewMapScreenExited() {
    }

    public void setPreviewAreaAroundCCP() {
    }

    public void setPreviewLocation(NavLocationWgs84 navLocationWgs84, int n) {
    }

    public void setPreviewDistantLocation(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewLocationAroundReferencePoint(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    public void setPreviewLocationAroundCCP(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewLocationAroundDestination(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842) {
    }

    public void setPreviewDestination(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewAddressBookEntry(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewFavoriteHome(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewState(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewLocationCity(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewLocations(NavLocationWgs84[] navLocationWgs84Array) {
    }

    public void setPreviewTour(NavLocationWgs84[] navLocationWgs84Array) {
    }

    public void setPreviewLocationsForOperatorCall(NavLocationWgs84[] navLocationWgs84Array) {
    }

    public void setPreviewPOIsOnboard(NavLocation[] navLocationArray) {
    }

    public void setPreviewPOIsOnboardDistant(NavLocation[] navLocationArray) {
    }

    public void setPreviewPOIsOnboardAroundCCP(NavLocation[] navLocationArray) {
    }

    public void setPreviewPOIsOnboardAroundReferencePoint(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewPOIsOnboardAroundDestination(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewRoadSegment(int n, int n2, int n3, int n4, long l, long l2) {
    }

    public void setPreviewTMCEvents(long[] lArray, NavRectangle navRectangle) {
    }

    public void setPreviewRoute(boolean bl) {
    }

    public void setPreviewRouteEvent(NavLocationWgs84 navLocationWgs84, int n) {
    }

    public void setPreviewSDSPicklistEvents(NavLocation[] navLocationArray) {
    }

    public void setPreviewTMCEvent(long l) {
    }

    public void setPreviewTMCEventsForRouteList(NavRectangle navRectangle) {
    }

    public void setStoreFocusForEnter(boolean bl) {
    }

    public void cleanUp() {
    }

    public void setStoreFocusForEnterOnce(boolean bl) {
    }

    public void refreshLastRequestedState(int n) {
    }

    public void previewMapScreenEntering(int n, int n2, int n3, int n4, boolean bl) {
    }

    public void resetEventVisibilities() {
    }

    public void resetEventVisibilities(boolean bl, boolean bl2) {
    }

    public void onScreenFadedOut(int n) {
    }

    public void setPreviewRoute(boolean bl, boolean bl2) {
    }

    public void setPreviewLocationConcierge(NavLocationWgs84 navLocationWgs84, String string, String string2) {
    }

    public void setPreviewLocationTpeg(NavLocation navLocation) {
    }

    public void setPreviewLocationSds(NavLocationWgs84 navLocationWgs84) {
    }

    public void callbackByMapContextOnEnteringMapPreview() {
    }

    public void callbackByMapContextOnEnteringMapFullscreen() {
    }

    public void setPreviewPOIsOnboardFromTourListOrRouteList(NavLocation[] navLocationArray) {
    }

    public void setPreviewLocationFromTourList(NavLocationWgs84 navLocationWgs84) {
    }

    public void previewMapScreenEntering(int n, int n2) {
    }

    public void previewMapScreenLayoutRegister(int n, int n2, int n3, int n4, int n5) {
    }

    public void previewMapScreenApplyItemBeforeShown(int n, int n2) {
    }

    public void previewMapFullScreenShowItemSelectedWithToolTip(int n) {
    }

    public void setPreviewAreaAroundCCP(int n) {
    }

    public void setPreviewLocation(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationSds(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewDistantLocation(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationAroundReferencePoint(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationAroundCCP(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationAroundDestination(NavLocationWgs84 navLocationWgs84, NavLocationWgs84 navLocationWgs842, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewDestination(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewAddressBookEntry(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewFavoriteHome(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewState(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationCity(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void previewLocationCity(NavLocationWgs84 navLocationWgs84) {
    }

    public void setPreviewLocations(NavLocationWgs84[] navLocationWgs84Array, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewTour(NavLocationWgs84[] navLocationWgs84Array, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationsForOperatorCall(NavLocationWgs84[] navLocationWgs84Array, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPOIsOnboard(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPOIsOnboardDistant(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPOIsOnboardAroundCCP(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPOIsOnboardAroundReferencePoint(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPOIsOnboardAroundDestination(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewRoadSegment(int n, int n2, int n3, int n4, long l, long l2, int n5, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewTrafficInfoTmcEvents(long[] lArray, NavRectangle navRectangle, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewRoute(boolean bl, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewRoute(boolean bl, boolean bl2, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewRouteEvent(NavLocationWgs84 navLocationWgs84, int n, int n2, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewSDSPicklistEvents(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewTrafficInfoTmcEvent(long l, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewTrafficInfoTmcEventsForRouteList(NavRectangle navRectangle, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void previewMapFullScreenShowItemSelectedWithToolTipLast() {
    }

    public void previewMapFullScreenShowItemInMapWithToolTip() {
    }

    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationSds(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationDistant(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewDestination(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewAddressBookEntry(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewFavoriteHome(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewState(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationCity(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocations(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewTour(NavLocation[] navLocationArray, String string, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationsForOperatorCall(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewRouteEvent(NavLocation navLocation, int n, int n2, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPredictiveNavigationRoute(NavSegmentID navSegmentID, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPredictiveNavigationRoutes(NavSegmentID[] navSegmentIDArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewRouteOffroad(NavSegmentID navSegmentID, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPoiOnlineAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPoiOnlineAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPoiOnlineAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewFavorite(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationTpeg(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPOIsOnboardFromTourListOrRouteList(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationFromTourList(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void previewMapFullScreenHidden() {
    }

    public void setPreviewLocationConcierge(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public Rect getGuiPreviewMapLayoutVisibleAreaCurrent() {
        return null;
    }

    public void setPreviewMapNone(int n) {
    }

    public void setPreviewMapPositionRefreshAllowed(boolean bl) {
    }

    public int getPreviewMapClientIdLast() {
        return -1;
    }

    public void previewMapScreenErrorUpdateByClientWithDelay() {
    }

    public void setPreviewMapWaitSyncChoiceModelId(int n) {
    }

    public int getMapContextCorrected(int n) {
        return n;
    }

    public int getPreviewMapModelHkBackBehavior() {
        return 0;
    }

    public void setPreviewMapModelHkBackBehavior(int n) {
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n, boolean bl) {
    }

    public void previewMapFullScreenShowItemInMapWithToolTipWithoutCenteringMapPosition() {
    }

    public int getPreviewMapMode() {
        return 0;
    }

    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl, String string) {
    }

    public ChoiceModelApp getPreviewMapModelDetailView() {
        return null;
    }

    public boolean isFullscreenPreviewMapVisible() {
        return false;
    }

    public boolean isPreviewMapItemArea() {
        return false;
    }
}

