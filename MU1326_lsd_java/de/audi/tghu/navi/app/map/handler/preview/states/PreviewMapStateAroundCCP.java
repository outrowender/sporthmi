/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import org.dsi.ifc.global.NavLocation;

public class PreviewMapStateAroundCCP
extends PreviewMapStateAbstract {
    public PreviewMapStateAroundCCP(PreviewMapHandlerAbstract previewMapHandlerAbstract) {
        super(previewMapHandlerAbstract, null, null);
    }

    public void applyToScreenDetail() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(1);
        this.getMapForPreview().getZoomHandler().setZoomLevel(IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
        this.getMapForPreview().getGuiInterface().showPreviewMap(true);
    }

    public void applyToScreenDetailModels() {
    }

    public void applyToScreenFullMap() {
        AbstractMap abstractMap = this.getMapForFullScreen();
        NavLocation navLocation = abstractMap.getNaviInterface().getVehicle().getVehicleLocation();
        abstractMap.getMVRequest().setLocationByLocation(navLocation);
        abstractMap.getGuiInterface().checkToShowToolTipForNaviWithoutPin(navLocation, null, this.guiTooltipInformationContainer, false);
    }

    public NavLocation getNavLocationForEnterInMap() {
        return this.getMapForFullScreen().getNaviInterface().getVehicle().getVehicleLocation();
    }

    public String toString() {
        return "PreviewMapStateAroundCCP()";
    }
}

