/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import org.dsi.ifc.global.NavLocation;

public class PreviewMapStateRoute
extends PreviewMapStateAbstract {
    protected boolean completeRoute = true;
    protected boolean rgActive = false;

    public PreviewMapStateRoute(PreviewMapHandlerAbstract previewMapHandlerAbstract, boolean bl, boolean bl2) {
        super(previewMapHandlerAbstract, null, null);
        this.completeRoute = bl;
        this.rgActive = bl2;
    }

    public PreviewMapStateRoute(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    public void applyToScreenDetail() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        if (this.rgActive) {
            if (this.completeRoute) {
                this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(10);
            } else {
                this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(0);
            }
        } else {
            this.applyToScreenDetailPreviewAreaAroundCCP();
        }
        this.getMapForPreview().getGuiInterface().showPreviewMap(true);
    }

    public void applyToScreenDetailModels() {
    }

    private void applyToScreenDetailPreviewAreaAroundCCP() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(1);
        this.getMapForPreview().getZoomHandler().setZoomLevel(IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
        this.getMapForPreview().getGuiInterface().showPreviewMap(true);
    }

    public void applyToScreenFullMap() {
    }

    public NavLocation getNavLocationForEnterInMap() {
        return null;
    }

    public String toString() {
        return "PreviewMapStateRoute()";
    }

    public boolean isPreviewMapItemArea() {
        return true;
    }
}

