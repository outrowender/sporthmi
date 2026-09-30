/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateRouteSelenaAbstract;
import org.dsi.ifc.global.NavSegmentID;

public class PreviewMapStateRouteSelenaOverview
extends PreviewMapStateRouteSelenaAbstract {
    NavSegmentID[] routeIds;

    public PreviewMapStateRouteSelenaOverview(PreviewMapHandlerAbstract previewMapHandlerAbstract, NavSegmentID[] navSegmentIDArray, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        this.routeIds = navSegmentIDArray;
    }

    public void applyToScreenDetail() {
        this.getMapForPreview().getNaviInterface().focusSelenaRoutes(true);
        this.applyToScreenDetailRouteSegments();
    }

    protected void applyToScreenDetailRouteSegments() {
        if (this.routeIds == null || this.routeIds.length == 0) {
            this.previewPredictiveNavigationRoutesWithNoRoutes();
        } else {
            this.previewPredictiveNavigationRoutes(this.routeIds);
        }
    }

    protected void previewPredictiveNavigationRoutes(NavSegmentID[] navSegmentIDArray) {
        this.getPreviewMapHandler().resetEventVisibilities(false, false);
        this.getPreviewMapHandler().getMapForPreview().getMVRequest().setMode(16);
        this.getPreviewMapHandler().getMapForPreview().getMVRequest().setVisibleRoutes(navSegmentIDArray);
        this.getPreviewMapHandler().getMapForPreview().getGuiInterface().showPreviewMap(true);
    }

    protected void previewPredictiveNavigationRoutesWithNoRoutes() {
        this.getPreviewMapHandler().resetEventVisibilities(false, false);
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(2);
        this.getPreviewMapHandler().getMapForPreview().getZoomHandler().setZoomLevel(IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
        this.getPreviewMapHandler().getMapForPreview().getMVRequest().setLocationByLocation(this.getPreviewMapHandler().getMapForPreview().getMapManager().getMapMain().getNaviInterface().getVehicle().getVehicleLocation());
        this.getPreviewMapHandler().getMapForPreview().getGuiInterface().showPreviewMap(true);
    }

    public void applyToScreenFullMap() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilitiesPredictiveNav();
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(16);
        if (this.routeIds != null) {
            this.getMapForPreview().getMVRequest().setVisibleRoutes(this.routeIds);
        }
    }

    public String toString() {
        return "PreviewMapStateRouteSelenaOverview()";
    }
}

