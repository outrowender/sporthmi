/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionActionShow;
import org.dsi.ifc.tmc.TmcMessage;

public class MapItemSelectionActionShowTrafficInfo
extends MapItemSelectionActionShow {
    public TmcMessage tmcMessage;

    public MapItemSelectionActionShowTrafficInfo(TmcMessage tmcMessage) {
        this.tmcMessage = tmcMessage;
    }

    @Override
    public void setPreviewMap(int n, AbstractMap abstractMap, IPreviewMap iPreviewMap, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        abstractMap.getGuiInterface().newPoiPreviewMapSelectionMade(true);
        iPreviewMap.setPreviewMapPositionRefreshAllowed(false);
        iPreviewMap.setPreviewTrafficInfoTmcEvent(this.tmcMessage, n, false);
        iPreviewMap.setPreviewMapPositionRefreshAllowed(true);
    }
}

