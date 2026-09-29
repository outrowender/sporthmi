/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateNavLocations;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;

public class PreviewMapStateNavLocationsConcierge
extends PreviewMapStateNavLocations {
    NavLocationWgs84[] navLocationsWgs84;

    public PreviewMapStateNavLocationsConcierge(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavLocationWgs84[] navLocationWgs84Array) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer, Util.wgs84sToNavLocations(navLocationWgs84Array));
    }

    @Override
    public void applyToScreenFullMap() {
        AbstractMap abstractMap = this.getMapForFullScreen();
        this.logger.log(-2137614336, "PreviewMapHandlerPCore#showInFullScreenMapLastLocationConcierge() - NavLocation: %1", (Object)this.navLocationsWgs84);
        NavRectangle navRectangle = PreviewMapUtils.calculateMapSection(this.logger, this.navLocationsWgs84, this.navLocationsWgs84[0], true);
        this.getMapForFullScreen().getMVRequest().setMapViewPortByWGS84Rectangle(navRectangle, 5);
    }

    @Override
    public String toString() {
        return new StringBuffer().append("PreviewMapStateNavLocationsConcierge() ").append(PreviewMapUtils.toStringNavLocations(this.navLocations)).toString();
    }
}

