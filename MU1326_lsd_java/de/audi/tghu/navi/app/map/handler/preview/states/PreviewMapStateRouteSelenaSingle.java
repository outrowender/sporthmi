/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateRouteSelenaOverview;
import org.dsi.ifc.global.NavSegmentID;

public class PreviewMapStateRouteSelenaSingle
extends PreviewMapStateRouteSelenaOverview {
    public PreviewMapStateRouteSelenaSingle(PreviewMapHandlerAbstract previewMapHandlerAbstract, NavSegmentID navSegmentID, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        super(previewMapHandlerAbstract, new NavSegmentID[]{navSegmentID}, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    public void applyToScreenDetail() {
        this.getMapForPreview().getNaviInterface().focusSelenaRoutes(false);
        this.applyToScreenDetailRouteSegments();
    }

    public String toString() {
        return "PreviewMapStateRouteSelenaSingle()";
    }
}

