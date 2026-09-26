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
    protected abstract AbstractMap getMap() {
    }

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

    @Override
    public void updateAvailableLanguages(String[] stringArray) {
    }

    @Override
    public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
    }

    @Override
    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray) {
    }

    @Override
    public void updateCarPosition(Point point) {
    }

    @Override
    public void updateCurrentLanguage(String string) {
    }

    @Override
    public void updateCurrentViewType(int n) {
    }

    @Override
    public void updateDayNightView(boolean bl) {
    }

    @Override
    public void updateDestDistance(int n) {
    }

    @Override
    public void updateDistanceToNextManeuver(int n) {
    }

    @Override
    public void updateGoogleDataStatus(int n) {
    }

    @Override
    public void updateLoadKml(boolean[] blArray) {
    }

    @Override
    public void updateManoeuvreViewActive(int n) {
    }

    @Override
    public void updateManoeuvreViewsAvailable(short[] sArray) {
    }

    @Override
    public void updateMapMode(int n) {
    }

    @Override
    public void updateMapOrientation(int n) {
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    @Override
    public void updateMapRotation(short s) {
    }

    @Override
    public void updateOnlineResultFlagDetails(int n) {
    }

    @Override
    public void updatePicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
    }

    @Override
    public void updateReady(boolean bl, int n) {
    }

    @Override
    public void updateRecommendedZoom(float f2) {
    }

    @Override
    public void updateRgActive(boolean bl) {
    }

    @Override
    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
    }

    @Override
    public void updateRouteCalcModeEnabled(boolean bl) {
    }

    @Override
    public void updateSoftJumpEnabled(boolean bl) {
    }

    @Override
    public void updateSoftRotationEnabled(boolean bl) {
    }

    @Override
    public void updateSoftTiltEnabled(boolean bl) {
    }

    @Override
    public void updateSoftTiltRunning(boolean bl) {
    }

    @Override
    public void updateTmcMessage(TmcMessage tmcMessage) {
    }

    @Override
    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
    }

    @Override
    public void updateTmcVisible(boolean bl) {
    }

    @Override
    public void updateViewFreeze(boolean bl) {
    }

    @Override
    public void updateViewPort(ViewPort viewPort) {
    }

    @Override
    public void updateViewScreenViewPort(Rect rect) {
    }

    @Override
    public void updateViewVisible(boolean bl) {
    }

    @Override
    public void updateVisibleLayers(int[] nArray) {
    }

    @Override
    public void updateBapManeuverState(int n) {
    }

    @Override
    public void updateXTRepresentation(NavLocation navLocation, String string) {
    }

    @Override
    public void updateZoomEngineState(int n) {
    }

    @Override
    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
    }

    @Override
    public void updateZoomListIndex(int n) {
    }

    @Override
    public void updateSatelliteDataVisible(boolean bl) {
    }

    @Override
    public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84) {
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
    }

    @Override
    public void initViewPort() {
    }

    @Override
    public void updateMobilityHorizonStatus(int n) {
    }

    @Override
    public void updateZoomLevel(float f2) {
    }

    @Override
    public void belowLowerThreshold(int n) {
    }

    @Override
    public void exceedsUpperThreshold(int n) {
    }

    @Override
    public void updateLockingState(boolean bl) {
    }

    @Override
    public void vehicleMoved() {
    }

    @Override
    public void hideTENM() {
    }
}

