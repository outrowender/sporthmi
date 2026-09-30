/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionAction;

public class MapItemSelectionActionHide
extends MapItemSelectionAction {
    public void setPreviewMap(int n, AbstractMap abstractMap, IPreviewMap iPreviewMap, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        iPreviewMap.setPreviewMapNone(n);
    }
}

