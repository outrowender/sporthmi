/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateRoute;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;
import org.dsi.ifc.global.NavSegmentID;

public class PreviewMapStateRouteOffroad
extends PreviewMapStateRoute {
    NavSegmentID routeId;

    public PreviewMapStateRouteOffroad(PreviewMapHandlerAbstract previewMapHandlerAbstract, NavSegmentID navSegmentID, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        this.routeId = navSegmentID;
    }

    public void applyToScreenDetail() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(10);
        this.getMapForPreview().getMVRequest().setVisibleRoutes(new NavSegmentID[]{this.routeId});
    }

    public void applyToScreenFullMap() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(10);
        this.getMapForPreview().getMVRequest().setVisibleRoutes(new NavSegmentID[]{this.routeId});
        AbstractMap abstractMap = this.getMapForFullScreen();
        MapItemSelectionAction mapItemSelectionAction = abstractMap.getGuiInterface().checkToShowToolTipForOffroadTour(this.guiTooltipInformationContainer);
        if (mapItemSelectionAction == null) {
            this.logger.log(10000, "PreviewMapStateNavLocations#applyToScreenFullMapNavLocationSingle no tooltip shown");
        }
    }

    public void releaseApplyToScreenDetail() {
        this.getPreviewMapHandler().getMapForPreview().getMVRequest().setVisibleRoutes(new NavSegmentID[0]);
    }

    public void releaseApplyToScreenFullMap() {
        this.getPreviewMapHandler().getMapForFullScreen().getMVRequest().setVisibleRoutes(new NavSegmentID[0]);
    }

    public String toString() {
        return "PreviewMapStateRouteOffroad()";
    }
}

