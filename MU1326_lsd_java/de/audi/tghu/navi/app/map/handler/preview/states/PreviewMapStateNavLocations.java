/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.PosPosition;

public class PreviewMapStateNavLocations
extends PreviewMapStateAbstract {
    private static final int BUTTON_DETAILS_HIDE = 0;
    private static final int BUTTON_DETAILS_SHOW = 1;
    protected NavLocation[] navLocations;
    protected boolean forSdsShowNumberedMapPins;
    protected boolean forTourShowNumberedMapPins;
    protected int pivotStyle = 29;
    protected NavLocationWgs84 navLocationPivot = null;
    protected boolean centerOnPivot = false;
    protected float defaultZoomLevel = IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL;
    private boolean isOnlineGoogleEarthMapPoi = false;
    private String urlOnlineGoogleEarthMapPoi = "";

    public PreviewMapStateNavLocations(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavLocation[] navLocationArray) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        this.navLocations = navLocationArray;
    }

    public PreviewMapStateNavLocations(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavLocation[] navLocationArray, boolean bl, boolean bl2) {
        this(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer, navLocationArray);
        this.forSdsShowNumberedMapPins = bl;
        this.forTourShowNumberedMapPins = bl2;
    }

    public PreviewMapStateNavLocations(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavLocation[] navLocationArray, boolean bl, boolean bl2, boolean bl3, NavLocationWgs84 navLocationWgs84) {
        this(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer, navLocationArray, bl, bl2);
        this.centerOnPivot = bl3;
        this.navLocationPivot = navLocationWgs84;
    }

    public PreviewMapStateNavLocations(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavLocation[] navLocationArray, boolean bl, String string) {
        this(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer, navLocationArray);
        this.isOnlineGoogleEarthMapPoi = bl;
        this.urlOnlineGoogleEarthMapPoi = string;
    }

    public void applyToScreenDetail() {
        this.logger.log(10000000, "PreviewMapStateNavLocations#applyToScreenDetail()");
        if (this.navLocations == null || this.navLocations.length == 0) {
            this.logger.log(10000, "PreviewMapStateNavLocations#applyToScreenDetail() no nav location given");
            return;
        }
        this.applyToScreenDetailModels();
        this.applyToScreenDetailNavLocations();
    }

    public void applyToScreenDetailModels() {
        if (this.navLocations == null || this.navLocations.length == 0) {
            this.logger.log(10000, "PreviewMapStateNavLocations#applyToScreenDetailModels() no nav location given");
            return;
        }
        if (this.guiModelAccess != null && this.navLocations.length == 1) {
            this.guiModelAccess.onUpdateLocation(this.navLocations[0]);
        }
        if (this.isOnlineGoogleEarthMapPoi) {
            this.getPreviewMapHandler().getPreviewMapModelDetailView().setValue(1);
        } else {
            this.getPreviewMapHandler().getPreviewMapModelDetailView().setValue(0);
        }
        this.setDetailsButtonVisibilityAndAvailability();
    }

    private void setDetailsButtonVisibilityAndAvailability() {
        ButtonModelApp buttonModelApp = this.getPreviewMapHandler().getPreviewMapModelDetailButton();
        if (StringUtilities.isNullOrEmpty(this.urlOnlineGoogleEarthMapPoi)) {
            buttonModelApp.setStatus(3);
        } else {
            buttonModelApp.setStatus(1);
        }
    }

    protected void applyToScreenDetailNavLocations() {
        int n;
        Object[] objectArray;
        int n2;
        AbstractMap abstractMap = this.getMapForPreview();
        NavLocationWgs84[] navLocationWgs84Array = Util.navLocationsToWgs84(this.navLocations);
        if (this.navLocationPivot != null) {
            n2 = this.pivotStyle == 29 ? this.navLocations.length : this.navLocations.length + 1;
            objectArray = new NavLocationWgs84[this.navLocations.length + 1];
            System.arraycopy((Object)navLocationWgs84Array, 0, (Object)objectArray, 0, navLocationWgs84Array.length);
            objectArray[navLocationWgs84Array.length] = (int)this.navLocationPivot;
            navLocationWgs84Array = (NavLocationWgs84[])objectArray;
        } else {
            n2 = this.navLocations.length;
        }
        objectArray = new int[navLocationWgs84Array.length];
        for (n = 0; n < this.navLocations.length; ++n) {
            objectArray[n] = PreviewMapUtils.getMapStyleType(this.navLocations.length, n, this.forSdsShowNumberedMapPins, this.forTourShowNumberedMapPins);
        }
        if (this.navLocationPivot != null) {
            objectArray[this.navLocations.length] = this.pivotStyle;
        }
        if (navLocationWgs84Array.length == 0) {
            this.logger.log(10000, "PreviewMapStateNavLocations#focus() - no locations available => hide preview map instead");
            this.getPreviewMapHandler().hidePreviewMap();
            return;
        }
        n = -1;
        if (navLocationWgs84Array.length == 1) {
            n = this.getMapForPreview().getZoomHandler().getZoomListIndex(this.defaultZoomLevel);
        }
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        NavRectangle navRectangle = PreviewMapUtils.calculateMapSection(this.logger, navLocationWgs84Array, this.navLocationPivot, this.centerOnPivot);
        if (navRectangle == null || !Util.isNavRectangleValid(navRectangle)) {
            this.logger.log(10000, "PreviewMapStateNavLocations#focus() - could not calculate a rectangle or all locations were invalid => hide preview map instead");
            this.getPreviewMapHandler().hidePreviewMap();
            return;
        }
        if (Util.isHURegionAsia()) {
            Rect rect;
            this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(10);
            if (abstractMap.getActiveContext() instanceof IVisibleContext && (rect = ((IVisibleContext)abstractMap.getActiveContext()).getVisibleArea()) != null) {
                abstractMap.getMVRequest().setZoomArea(rect);
            }
        }
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(2);
        this.getPreviewMapHandler().setFlagsInMap(navLocationWgs84Array, (int[])objectArray, n2);
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().ensurePOIVisibility(this.navLocations, false);
        abstractMap.getMVRequest().setMapViewPortByWGS84Rectangle(navRectangle, n);
        abstractMap.getGuiInterface().showPreviewMap(true);
    }

    public void applyToScreenFullMap() {
        this.logger.log(10000000, "PreviewMapStateNavLocations#applyToScreenFullMap()");
        if (this.navLocations == null || this.navLocations.length == 0) {
            this.logger.log(10000, "PreviewMapStateNavLocations#applyToScreenFullMap() no navLocations given");
            return;
        }
        if (this.navLocations.length == 1) {
            this.applyToScreenFullMapNavLocationSingle();
        } else {
            this.applyToScreenFullMapNavLocationsMultiple();
        }
    }

    private void applyToScreenFullMapNavLocationSingle() {
        MapItemSelectionAction mapItemSelectionAction;
        this.logger.log(10000000, "PreviewMapStateNavLocations#applyToScreenFullMapNavLocationSingle()");
        AbstractMap abstractMap = this.getMapForFullScreen();
        if (this.getPreviewMapHandler().isPreviewMapPositionRefreshAllowed()) {
            abstractMap.getMVRequest().setLocationByLocation(this.navLocations[0]);
        }
        if ((mapItemSelectionAction = this.isOnlineGoogleEarthMapPoi ? abstractMap.getGuiInterface().checkToShowToolTipForPoiOnline(this.navLocations[0], true, false, this.isOnlineGoogleEarthMapPoi, this.urlOnlineGoogleEarthMapPoi) : abstractMap.getGuiInterface().checkToShowToolTipForNavi(this.navLocations[0], this.guiTooltipInformationContainer)) == null || !mapItemSelectionAction.isShow()) {
            this.logger.log(10000, "PreviewMapStateNavLocations#applyToScreenFullMapNavLocationSingle no tooltip shown");
        }
    }

    private void applyToScreenFullMapNavLocationsMultiple() {
        this.logger.log(10000000, "PreviewMapStateNavLocations#applyToScreenFullMapNavLocationsMultiple()");
        AbstractMap abstractMap = this.getMapForFullScreen();
        PosPosition posPosition = abstractMap.getNaviInterface().getVehicle().getPosition();
        int n = posPosition.getLatitude();
        int n2 = posPosition.getLatitude();
        int n3 = posPosition.getLongitude();
        int n4 = posPosition.getLongitude();
        for (int i2 = 0; i2 < this.navLocations.length; ++i2) {
            this.logger.log(10000000, "PreviewMapStateNavLocations#showLastLocations() - [%1] lat=%2, long=%3", (long)i2, (long)this.navLocations[i2].getLatitude(), (long)this.navLocations[i2].getLongitude());
            n = Math.min(n, this.navLocations[i2].getLatitude());
            n2 = Math.max(n2, this.navLocations[i2].getLatitude());
            n3 = Math.min(n3, this.navLocations[i2].getLongitude());
            n4 = Math.max(n4, this.navLocations[i2].getLongitude());
        }
        NavLocation navLocation = Util.getLocationFromGeoPos(n3, n);
        NavLocation navLocation2 = Util.getLocationFromGeoPos(n4, n2);
        int n5 = this.getMapForFullScreen().getZoomHandler().getZoomListIndex(100.0f);
        MapPin[] mapPinArray = new MapPin[this.navLocations.length];
        for (int i3 = 0; i3 < mapPinArray.length; ++i3) {
            int n6 = PreviewMapUtils.getMapStyleType(this.navLocations.length, i3, this.forSdsShowNumberedMapPins, this.forTourShowNumberedMapPins);
            mapPinArray[i3] = new MapPin(this.navLocations[i3].getLongitude(), this.navLocations[i3].getLatitude(), n6, 4);
        }
        abstractMap.getMapFlagHandler().setPins(mapPinArray);
        abstractMap.getMVRequest().setMapViewportByLD(navLocation2, navLocation, n5);
        NavLocation navLocation3 = this.navLocations[this.navLocations.length - 1];
        abstractMap.getGuiInterface().checkToShowToolTipForNaviWithoutPin(navLocation3, this.getTourName(), this.guiTooltipInformationContainer, this.forTourShowNumberedMapPins);
    }

    protected String getTourName() {
        return null;
    }

    public NavLocation getNavLocationForEnterInMap() {
        if (this.navLocations != null && this.navLocations.length == 1) {
            return this.navLocations[0];
        }
        return null;
    }

    public String toString() {
        return "PreviewMapStateNavLocations() " + PreviewMapUtils.toStringNavLocations(this.navLocations);
    }

    public void releaseApplyToScreenDetail() {
        super.releaseApplyToScreenDetail();
        this.getPreviewMapHandler().getPreviewMapModelDetailView().setValue(0);
    }

    public void releaseApplyToScreenFullMap() {
        super.releaseApplyToScreenFullMap();
        this.getPreviewMapHandler().getPreviewMapModelDetailView().setValue(0);
    }
}

