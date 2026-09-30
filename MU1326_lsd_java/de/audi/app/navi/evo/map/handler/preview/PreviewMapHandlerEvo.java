/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.map.handler.preview;

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
    private PreviewMapParameters previewMapParameters = new PreviewMapParameters();

    public PreviewMapHandlerEvo(NavigationEnv navigationEnv, AbstractMap abstractMap, IScreenManager iScreenManager, IPopupManager iPopupManager) {
        super(navigationEnv, abstractMap);
        this.screenManager = iScreenManager;
        this.popupManager = iPopupManager;
    }

    public void setPreviewLocationDistant(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewLocationDistant() - location: %1", (Object)navLocation);
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewTour(NavLocation[] navLocationArray, String string, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewTour()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(Util.navLocationsToWgs84(navLocationArray), false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewLocationsForOperatorCall(NavLocationWgs84[] navLocationWgs84Array, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#previewLocationsForOperatorCall()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(navLocationWgs84Array, false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewAddressBookEntry(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewAddressBookEntry() - location %1", (Object)navLocation);
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    public void setPreviewLocationAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewLocationAroundReferencePoint() - location %1, referencePoint: %2", (Object)navLocation, (Object)navLocationWgs84);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, true, navLocationWgs84, 111, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewLocationAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewLocationAroundDestination() - location %1, destination: %2", (Object)navLocation, (Object)navLocationWgs84);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewLocationAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewLocationAroundCCP() - location %1", (Object)navLocation);
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewState(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewState() - location: %1", (Object)navLocation);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, false, null, 29, 15000.0f);
    }

    public void setPreviewLocationCity(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewLocationCity() - location %1", (Object)navLocation);
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    public void setPreviewDestination(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewDestination() - destination %1", (Object)navLocation);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(null, false, false, true, Util.navLocationToWgs84(navLocation), 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewFavoriteHome(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewFavoriteHome() - location %1", (Object)navLocation);
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    public void setPreviewPOIsOnboard(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewPOIsOnboard()");
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewPOIsOnboardAroundCCP(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#previewPOIsOnboardAroundCCP()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewPOIsOnboardAroundReferencePoint(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#previewPOIsOnboardAroundReferencePoint() - referencePoint: %1", (Object)navLocationWgs84);
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, true, navLocationWgs84, 111, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewPOIsOnboardAroundDestination(NavLocation[] navLocationArray, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#previewPOIsOnboardAroundDestination() - destination: %1", (Object)navLocationWgs84);
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewPOIsOnboardDistant(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewPOIsOnboardDistant()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, false, false, false, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewSDSPicklistEvents(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(100000000, "PreviewMapHandler#previewSDSPicklistEvents() - number of positions: %1", navLocationArray == null ? 0L : (long)navLocationArray.length);
        this.focusOnPOIsAndCreateNewPreviewMapState(navLocationArray, true, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewLocation() - location: %1", (Object)navLocation);
        this.focusOnLocationAndCreateNewPreviewMapStateAsCurrent(Util.navLocationToWgs84(navLocation), false, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewLocations(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewLocations()");
        this.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(Util.navLocationsToWgs84(navLocationArray), false, false, false, null, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewPoiOnlineAroundCCP(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewPoiOnlineAroundCCP()");
        NavLocationWgs84 navLocationWgs84 = Util.navLocationToWgs84(this.mapForPreview.getNaviInterface().getVehicle().getVehicleLocation());
        this.focusOnPOIsAndCreateNewPreviewMapState(new NavLocation[]{navLocation}, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewPoiOnlineAroundReferencePoint(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#setPreviewPoiOnlineAroundReferencePoint()");
        this.focusOnPOIsAndCreateNewPreviewMapState(new NavLocation[]{navLocation}, false, false, true, navLocationWgs84, 111, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewPoiOnlineAroundDestination(NavLocation navLocation, NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#previewOnlinePOIAroundDestination()");
        this.focusOnPOIsAndCreateNewPreviewMapState(new NavLocation[]{navLocation}, false, false, true, navLocationWgs84, 29, IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
    }

    public void setPreviewFavorite(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(10000000, "PreviewMapHandlerEvo#previewFavorite()");
        this.setPreviewLocationDistant(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        if (!this.mapForPreview.getSetup().isFavoriteVisible(0)) {
            MapPin mapPin = new MapPin(navLocation.getLongitude(), navLocation.getLatitude(), MapUtils.getStyleIndexForFavorite(), 0);
            this.mapForPreview.getMapFlagHandler().addTemporaryPins(new MapPin[]{mapPin});
        }
    }

    boolean isMapScreen(int n) {
        return n == 400362 || n == 400002 || n == 400216 || n == 400089;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void previewMapScreenEntering(int n, int n2, int n3, int n4, boolean bl) {
        Object object = this.screenFadeOutMutex;
        synchronized (object) {
            int n5 = this.screenManager.getCurrentScreenId();
            int n6 = this.popupManager.getCurrentPopupID();
            this.logger.log(10000000, "PreviewMapHandlerEvo#previewMapScreenEntering(): currentScreenID: %1, currentPopupID: %2", (long)n5, (long)n6);
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
    public void previewMapScreenExited() {
        Object object = this.screenFadeOutMutex;
        synchronized (object) {
            this.logger.log(10000000, "PreviewMapHandlerEvo#exitPreviewMapScreen(), waitForScreenFadedOut:( %1 ) ", (Object)Boolean.toString(this.waitForScreenFadedOut));
            this.waitForScreenFadedOut = false;
            super.previewMapScreenExited();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void onScreenFadedOut(int n) {
        Object object = this.screenFadeOutMutex;
        synchronized (object) {
            this.logger.log(10000000, "PreviewMapHandlerEvo#onScreenFadedOut( %1 ): waitForScreenFadedOut: %2", (Object)Integer.toString(n), (Object)Boolean.toString(this.waitForScreenFadedOut));
            if (this.waitForScreenFadedOut) {
                this.waitForScreenFadedOut = false;
                if (this.isMapScreen(n)) {
                    this.previewMapScreenEnteringExecute(this.previewMapParameters.width, this.previewMapParameters.height, this.previewMapParameters.offsetX, this.previewMapParameters.offsetY, this.previewMapParameters.ignoreForBackupState);
                }
            }
        }
    }

    public void setPreviewLocationSds(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.setPreviewLocation(navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    public void previewMapScreenEntering(int n, int n2) {
    }

    public void previewMapScreenTypeRegister(int n, int n2, int n3, int n4, int n5) {
    }

    public void previewMapScreenApplyItemBeforeShown(int n, int n2) {
    }

    public void previewMapFullScreenShowItemSelectedWithToolTip(int n) {
    }

    public void setPreviewLocationConcierge(NavLocationWgs84 navLocationWgs84, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationTpeg(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewPOIsOnboardFromTourListOrRouteList(NavLocation[] navLocationArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void setPreviewLocationFromTourList(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }

    public void previewMapFullScreenShowItemSelectedWithToolTipLast() {
    }

    public void previewMapFullScreenShowItemInMapWithToolTip() {
    }

    public GuiModelAccessForPreviewMapDetailScreenDefault getGuiModelAccessForPreviewMapDetailScreenDefault() {
        return null;
    }

    public FactoryPreviewMapStateAbstract getFactoryPreviewMapState() {
        return null;
    }

    public void setPreviewMapNone(int n) {
    }

    public void setPreviewMapWaitSyncChoiceModelId(int n) {
    }

    public void setPreviewTrafficInfoTmcEvent(TmcMessage tmcMessage, int n, boolean bl) {
    }

    public void previewMapFullScreenShowItemInMapWithToolTipWithoutCenteringMapPosition() {
    }

    public void setPreviewLocation(NavLocation navLocation, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, boolean bl, String string) {
    }

    class PreviewMapParameters {
        public int width;
        public int height;
        public int offsetX;
        public int offsetY;
        public boolean ignoreForBackupState;

        PreviewMapParameters() {
        }

        void setValues(int n, int n2, int n3, int n4, boolean bl) {
            this.width = n;
            this.height = n2;
            this.offsetX = n3;
            this.offsetY = n4;
            this.ignoreForBackupState = bl;
        }
    }
}

