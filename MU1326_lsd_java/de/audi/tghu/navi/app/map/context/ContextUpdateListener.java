/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.tmc.TmcMessage;

public interface ContextUpdateListener {
    default public void updateAvailableLanguages(String[] stringArray) {
    }

    default public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
    }

    default public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
    }

    default public void updateCarPosition(Point point) {
    }

    default public void updateCurrentLanguage(String string) {
    }

    default public void updateCurrentViewType(int n) {
    }

    default public void updateDayNightView(boolean bl) {
    }

    default public void updateDestDistance(int n) {
    }

    default public void updateDistanceToNextManeuver(int n) {
    }

    default public void updateGoogleDataStatus(int n) {
    }

    default public void updateLoadKml(boolean[] blArray) {
    }

    default public void updateManoeuvreViewActive(int n) {
    }

    default public void updateManoeuvreViewsAvailable(short[] sArray) {
    }

    default public void updateMapMode(int n) {
    }

    default public void updateMapOrientation(int n) {
    }

    default public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void updateMapRotation(short s) {
    }

    default public void updateOnlineResultFlagDetails(int n) {
    }

    default public void updatePicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
    }

    default public void updateReady(boolean bl, int n) {
    }

    default public void updateRecommendedZoom(float f2) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void updateRgRouteCalculationState(int n) {
    }

    default public void updateRouteCalcModeEnabled(boolean bl) {
    }

    default public void updateSoftJumpEnabled(boolean bl) {
    }

    default public void updateSoftRotationEnabled(boolean bl) {
    }

    default public void updateSoftTiltEnabled(boolean bl) {
    }

    default public void updateSoftTiltRunning(boolean bl) {
    }

    default public void updateTmcMessage(TmcMessage tmcMessage) {
    }

    default public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
    }

    default public void updateTmcVisible(boolean bl) {
    }

    default public void updateViewFreeze(boolean bl) {
    }

    default public void updateViewPort(ViewPort viewPort) {
    }

    default public void updateViewScreenViewPort(Rect rect) {
    }

    default public void updateViewVisible(boolean bl) {
    }

    default public void updateVisibleLayers(int[] nArray) {
    }

    default public void updateXTRepresentation(NavLocation navLocation, String string) {
    }

    default public void updateZoomEngineState(int n) {
    }

    default public void updateZoomList(float[] fArray, int n, float[] fArray2) {
    }

    default public void updateZoomListIndex(int n) {
    }

    default public void updateSatelliteDataVisible(boolean bl) {
    }

    default public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84) {
    }

    default public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
    }

    default public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    default public void updateBapManeuverState(int n) {
    }

    default public void updateMobilityHorizonStatus(int n) {
    }
}

