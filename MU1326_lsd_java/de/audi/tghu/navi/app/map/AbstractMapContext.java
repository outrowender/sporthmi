/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.gui.ViewFactory;
import de.audi.tghu.navi.app.map.handler.IMapFlagHandler;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class AbstractMapContext
implements IContext {
    protected abstract AbstractMap getMap();

    protected final GUIInterface getGUI() {
        return this.getMap().getGuiInterface();
    }

    protected final ViewFactory getViews() {
        return this.getMap().getViews();
    }

    protected final ISetupHandler getSetup() {
        return this.getMap().getSetup();
    }

    protected final IZoomHandler getZoomHandler() {
        return this.getMap().getZoomHandler();
    }

    protected final IRouteCalculator getRouteCalcHandler() {
        return this.getMap().getRouteCalculationHandler();
    }

    protected final MapConfig getMapConfig() {
        return this.getMap().getMapConfig();
    }

    protected MapDataContainer getData() {
        return this.getMap().getMapDataContainer();
    }

    protected IMapFlagHandler getMapFlagHandler() {
        return this.getMap().getMapFlagHandler();
    }

    protected MapSelectionHandler getMapSelectionHandler() {
        return this.getMap().getMapSelectionHandler();
    }

    protected int getMapRepresentation() {
        return this.getSetup().getMapRepresentation();
    }

    protected int getSavedZoomListIndex() {
        return this.getSetup().getSavedZoomListIndex();
    }

    protected boolean getSetupTMCSymbols() {
        return this.getSetup().getTMCSymbols(0);
    }

    protected boolean getSetup3DLandmarks() {
        return this.getSetup().get3DLandmarks(0);
    }

    protected int getSetup3DBuildings() {
        return this.getSetup().get3DBuildings(this.getMap().getCurrentMapStyle());
    }

    protected int determineSetup3DCityModelMode() {
        if (this.getMap().getSatellitemapsManager().isSatelliteMapActive()) {
            return this.getSetup().getGoogle3DCityModel();
        }
        return this.getSetup().get3DBuildings(0);
    }

    protected int getSetupBrandedPOIs() {
        return this.getSetup().getBrandedPOIs(0);
    }

    protected boolean getSetupSpeedAndFlowFreeflow() {
        return this.getSetup().getSpeedAndFlowFreeflow(0);
    }

    protected boolean getSetupSpeedAndFlowCongestions() {
        return this.getSetup().getSpeedAndFlowCongestions(0);
    }

    protected boolean getSetupPicNavIcons() {
        return this.getSetup().getPicNavIcons(0);
    }

    protected int getSetupAutoZoom() {
        return this.getSetup().getAutoZoom(true);
    }

    protected int getSetupMapType() {
        return this.getSetup().getMapType(true);
    }

    protected int getSetupOrientation() {
        return this.getSetup().getOrientation();
    }

    protected int getSetupAdditionalInfos() {
        return this.getSetup().getAdditionalInfos();
    }

    protected int getSetupCrossingView() {
        return this.getSetup().getCrossingView();
    }

    protected int retrieveZoomListIndex(float f2) {
        return this.getZoomHandler().getZoomListIndex(f2);
    }

    protected int getMapMode() {
        return this.getMap().getMVResponseControl().getMapMode();
    }

    protected ViewPort getViewPort() {
        return this.getMap().getMVResponseControl().getViewPort();
    }

    protected short getMapRotation() {
        return this.getMap().getMVResponseControl().getMapRotation();
    }

    protected int getMapOrientation() {
        return this.getMap().getMVResponseControl().getMapOrientation();
    }

    protected Point getCarPosition() {
        return this.getMap().getMVResponseControl().getCarPosition();
    }

    protected NavLocationWgs84 getMapPosition() {
        return this.getMap().getMapPosition();
    }

    protected AvailableRoute[] getAvailableRoutes() {
        return this.getMap().getMVResponseControl().getAvailableRoutes();
    }

    protected boolean getMapReady() {
        return this.getMap().getMVResponseControl().getMapReady();
    }

    protected long[] getConfiguredFlags() {
        return this.getMap().getMVResponseControl().getConfiguredFlags();
    }

    protected boolean getRouteCalcModeEnabled() {
        return this.getMap().getMVResponseControl().getRouteCalcModeEnabled();
    }

    protected boolean getSatelliteDataVisible() {
        return this.getMap().getMVResponseControl().getSatelliteDataVisible();
    }

    protected boolean getSoftJumpEnabled() {
        return this.getMap().getMVResponseControl().getSoftJumpEnabled();
    }

    protected boolean getSoftRotationEnabled() {
        return this.getMap().getMVResponseControl().getSoftRotationEnabled();
    }

    protected boolean getSoftTiltEnabled() {
        return this.getMap().getMVResponseControl().getSoftTiltEnabled();
    }

    protected boolean getSoftZoomEnabled() {
        return this.getMap().getMVResponseControl().getSoftZoomEnabled();
    }

    protected boolean getTmcVisible() {
        return this.getMap().getMVResponseControl().getTmcVisible();
    }

    protected Rect getViewScreenViewPort() {
        return this.getMap().getMVResponseControl().getViewScreenViewPort();
    }

    protected boolean getViewFreeze() {
        return this.getMap().getMVResponseControl().getViewFreeze();
    }

    protected boolean getViewVisible() {
        return this.getMap().getMVResponseControl().getViewVisible();
    }

    protected int getZoomEngineState() {
        return this.getMap().getZoomEngineState();
    }

    protected short[] getManoeuvreViewsAvailable() {
        return this.getMap().getMVResponseManeuverView().getManoeuvreViewsAvailable();
    }

    public void updateAvailableLanguages(String[] stringArray) {
    }

    public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
    }

    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
    }

    public void updateCarPosition(Point point) {
    }

    public void updateCurrentLanguage(String string) {
    }

    public void updateCurrentViewType(int n) {
    }

    public void updateDayNightView(boolean bl) {
    }

    public void updateDestDistance(int n) {
    }

    public void updateDistanceToNextManeuver(int n) {
    }

    public void updateGoogleDataStatus(int n) {
    }

    public void updateLoadKml(boolean[] blArray) {
    }

    public void updateManoeuvreViewActive(int n) {
    }

    public void updateManoeuvreViewsAvailable(short[] sArray) {
    }

    public void updateMapMode(int n) {
    }

    public void updateMapOrientation(int n) {
    }

    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    public void updateMapRotation(short s) {
    }

    public void updateOnlineResultFlagDetails(int n) {
    }

    public void updatePicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
    }

    public void updateReady(boolean bl, int n) {
    }

    public void updateRecommendedZoom(float f2) {
    }

    public void updateRgActive(boolean bl) {
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    public void updateRgRouteCalculationState(int n) {
    }

    public void updateRouteCalcModeEnabled(boolean bl) {
    }

    public void updateSoftJumpEnabled(boolean bl) {
    }

    public void updateSoftRotationEnabled(boolean bl) {
    }

    public void updateSoftTiltEnabled(boolean bl) {
    }

    public void updateSoftTiltRunning(boolean bl) {
    }

    public void updateTmcMessage(TmcMessage tmcMessage) {
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
    }

    public void updateTmcVisible(boolean bl) {
    }

    public void updateViewFreeze(boolean bl) {
    }

    public void updateViewPort(ViewPort viewPort) {
    }

    public void updateViewScreenViewPort(Rect rect) {
    }

    public void updateViewVisible(boolean bl) {
    }

    public void updateVisibleLayers(int[] nArray) {
    }

    public void updateBapManeuverState(int n) {
    }

    public void updateXTRepresentation(NavLocation navLocation, String string) {
    }

    public void updateZoomEngineState(int n) {
    }

    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
    }

    public void updateZoomListIndex(int n) {
    }

    public void updateSatelliteDataVisible(boolean bl) {
    }

    public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84) {
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    public void initViewPort() {
    }

    public void updateMobilityHorizonStatus(int n) {
    }

    public void updateZoomLevel(float f2) {
    }

    public void belowLowerThreshold(int n) {
    }

    public void exceedsUpperThreshold(int n) {
    }

    public void updateLockingState(boolean bl) {
    }

    public void vehicleMoved() {
    }

    public void hideTENM() {
    }
}

