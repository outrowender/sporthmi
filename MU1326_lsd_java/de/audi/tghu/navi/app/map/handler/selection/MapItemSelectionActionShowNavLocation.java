/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionActionShow;
import org.dsi.ifc.global.NavLocation;

public class MapItemSelectionActionShowNavLocation
extends MapItemSelectionActionShow {
    public NavLocation navLocation;
    private boolean isOnlineGoogleEarthMapPoi = false;
    private String urlOnlineGoogleEarthMapPoi;

    public MapItemSelectionActionShowNavLocation(NavLocation navLocation) {
        this.navLocation = navLocation;
    }

    public MapItemSelectionActionShowNavLocation(NavLocation navLocation, boolean bl, String string) {
        this.navLocation = navLocation;
        this.isOnlineGoogleEarthMapPoi = bl;
        this.urlOnlineGoogleEarthMapPoi = string;
    }

    public void setPreviewMap(int n, AbstractMap abstractMap, IPreviewMap iPreviewMap, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        abstractMap.getGuiInterface().newPoiPreviewMapSelectionMade(true);
        iPreviewMap.setPreviewMapPositionRefreshAllowed(false);
        if (this.navLocation != null) {
            iPreviewMap.setPreviewLocation(this.navLocation, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer, this.isOnlineGoogleEarthMapPoi, this.urlOnlineGoogleEarthMapPoi);
        } else {
            iPreviewMap.setPreviewMapNone(n);
        }
        iPreviewMap.setPreviewMapPositionRefreshAllowed(true);
    }
}

