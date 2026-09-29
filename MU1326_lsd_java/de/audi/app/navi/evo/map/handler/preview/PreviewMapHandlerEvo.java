/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.handler.preview;

import de.audi.app.navi.evo.map.handler.preview.PreviewMapHandlerEvo$PreviewMapParameters;
import de.audi.atip.hmi.view.IPopupManager;
import de.audi.atip.hmi.view.IScreenManager;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstractMapStateSingle;
import de.audi.tghu.navi.app.map.handler.preview.gui.GuiModelAccessForPreviewMapDetailScreenDefault;
import de.audi.tghu.navi.app.map.handler.preview.states.FactoryPreviewMapStateAbstract;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.tmc.TmcMessage;

public class PreviewMapHandlerEvo
extends PreviewMapHandlerAbstractMapStateSingle {
    IScreenManager screenManager;
    IPopupManager popupManager;
    private boolean waitForScreenFadedOut = false;
    private final Object screenFadeOutMutex = new Object();
    private PreviewMapHandlerEvo$PreviewMapParameters previewMapParameters = new PreviewMapHandlerEvo$PreviewMapParameters(this);

    public PreviewMapHandlerEvo(NavigationEnv navigationEnv, AbstractMap abstractMap, IScreenManager iScreenManager, IPopupManager iPopupManager) {
        super(navigationEnv, abstractMap);
        this.screenManager = iScreenManager;
        this.popupManager = iPopupManager;
    }

    @Override
    public void setPreviewLocationDistant(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewLocationDistant() - location: %1", (Object)navLocation);
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewTour(NavLocation[] navLocationArray, String string, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewTour()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(Util.navLocationsToWgs84(navLocationArray), false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewLocationsForOperatorCall(NavLocationWgs84[] navLocationWgs84Array, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#previewLocationsForOperatorCall()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(navLocationWgs84Array, false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewAddressBookEntry(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewAddressBookEntry() - location %1", (Object)navLocation);
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void setPreviewLocationAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewLocationAroundReferencePoint() - location %1, referencePoint: %2", (Object)navLocation, (Object)navLocationWgs84);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, true, navLocationWgs84, 111, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewLocationAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewLocationAroundDestination() - location %1, destination: %2", (Object)navLocation, (Object)navLocationWgs84);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewLocationAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewLocationAroundCCP() - location %1", (Object)navLocation);
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewState(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewState() - location: %1", (Object)navLocation);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, false, null, 29, 6318662);
    }

    @Override
    public void setPreviewLocationCity(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewLocationCity() - location %1", (Object)navLocation);
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void setPreviewDestination(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewDestination() - destination %1", (Object)navLocation);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(null, false, false, true, Util.navLocationToWgs84(navLocation), 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewFavoriteHome(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewFavoriteHome() - location %1", (Object)navLocation);
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void setPreviewPOIsOnboard(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewPOIsOnboard()");
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewPOIsOnboardAroundCCP(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#previewPOIsOnboardAroundCCP()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewPOIsOnboardAroundReferencePoint(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#previewPOIsOnboardAroundReferencePoint() - referencePoint: %1", (Object)navLocationWgs84);
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, true, navLocationWgs84, 111, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewPOIsOnboardAroundDestination(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#previewPOIsOnboardAroundDestination() - destination: %1", (Object)navLocationWgs84);
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewPOIsOnboardDistant(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewPOIsOnboardDistant()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewSDSPicklistEvents(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(14808325, "PreviewMapHandler#previewSDSPicklistEvents() - number of positions: %1", navLocationArray == null ? 0L : (long)navLocationArray.length);
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, true, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewLocation() - location: %1", (Object)navLocation);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewLocations(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewLocations()");
        this.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(Util.navLocationsToWgs84(navLocationArray), false, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewPoiOnlineAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewPoiOnlineAroundCCP()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnPOIsAndCreateNewPreviewMapState(new NavLocation[]{navLocation}, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewPoiOnlineAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#setPreviewPoiOnlineAroundReferencePoint()");
        this.focusOnPOIsAndCreateNewPreviewMapState(new NavLocation[]{navLocation}, false, false, true, navLocationWgs84, 111, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewPoiOnlineAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#previewOnlinePOIAroundDestination()");
        this.focusOnPOIsAndCreateNewPreviewMapState(new NavLocation[]{navLocation}, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    @Override
    public void setPreviewFavorite(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(-2137614336, "PreviewMapHandlerEvo#previewFavorite()");
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        if (!this.mapForPreview.getSetup().isFavoriteVisible(0)) {
            MapPin mapPin = new MapPin(navLocation.getLongitude(), navLocation.getLatitude(), MapUtils.getStyleIndexForFavorite(), 0);
            this.mapForPreview.getMapFlagHandler().addTemporaryPins(new MapPin[]{mapPin});
        }
    }

    boolean isMapScreen(int n) {
        return n == -367327744 || n == -2112223744 || n == 1478166016 || n == -652605952;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void previewMapScreenEntering(int n, int n2, int n3, int n4, boolean bl) {
        Object object = this.screenFadeOutMutex;
        synchronized (object) {
            int n5 = this.screenManager.getCurrentScreenId();
            int n6 = this.popupManager.getCurrentPopupID();
            this.logger.log(-2137614336, "PreviewMapHandlerEvo#previewMapScreenEntering(): currentScreenID: %1, currentPopupID: %2", (long)n5, (long)n6);
            if (this.isMapScreen(n5) && n6 == -1) {
                this.waitForScreenFadedOut = true;
                this.previewMapParameters.setValues(n, n2, n3, n4, bl);
            } else {
                this.waitForScreenFadedOut = false;
                this.previewMapScreenEnteringExecute(n, n2, n3, n4, bl);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void previewMapScreenExited() {
        Object object = this.screenFadeOutMutex;
        synchronized (object) {
            this.logger.log(-2137614336, "PreviewMapHandlerEvo#exitPreviewMapScreen(), waitForScreenFadedOut:( %1 ) ", (Object)Boolean.toString(this.waitForScreenFadedOut));
            this.waitForScreenFadedOut = false;
            super.previewMapScreenExited();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onScreenFadedOut(int n) {
        Object object = this.screenFadeOutMutex;
        synchronized (object) {
            this.logger.log(-2137614336, "PreviewMapHandlerEvo#onScreenFadedOut( %1 ): waitForScreenFadedOut: %2", (Object)Integer.toString(n), (Object)Boolean.toString(this.waitForScreenFadedOut));
            if (this.waitForScreenFadedOut) {
                this.waitForScreenFadedOut = false;
                if (this.isMapScreen(n)) {
                    this.previewMapScreenEnteringExecute(this.previewMapParameters.width, this.previewMapParameters.height, this.previewMapParameters.offsetX, this.previewMapParameters.offsetY, this.previewMapParameters.ignoreForBackupState);
                }
            }
        }
    }

    @Override
    public void setPreviewLocationSds(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.setPreviewLocation(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void previewMapScreenEntering(int n, int n2) {
    }

    public void previewMapScreenTypeRegister(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void previewMapScreenApplyItemBeforeShown(int n, int n2) {
    }

    @Override
    public void previewMapFullScreenShowItemSelectedWithToolTip(int n) {
    }

    @Override
    public void setPreviewLocationConcierge(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    @Override
    public void setPreviewLocationTpeg(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    @Override
    public void setPreviewPOIsOnboardFromTourListOrRouteList(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    @Override
    public void setPreviewLocationFromTourList(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    @Override
    public void previewMapFullScreenShowItemSelectedWithToolTipLast() {
    }

    @Override
    public void previewMapFullScreenShowItemInMapWithToolTip() {
    }

    @Override
    public GuiModelAccessForPreviewMapDetailScreenDefault getGuiModelAccessForPreviewMapDetailScreenDefault() {
        return null;
    }

    @Override
    public FactoryPreviewMapStateAbstract getFactoryPreviewMapState() {
        return null;
    }

    @Override
    public void setPreviewMapNone(int n) {
    }

    @Override
    public void setPreviewMapWaitSyncChoiceModelId(int n) {
    }

    @Override
    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n, boolean bl) {
    }

    @Override
    public void previewMapFullScreenShowItemInMapWithToolTipWithoutCenteringMapPosition() {
    }

    @Override
    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl, String string) {
    }
}

