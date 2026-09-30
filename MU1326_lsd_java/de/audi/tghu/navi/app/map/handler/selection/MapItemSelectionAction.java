/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.selection;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;

public abstract class MapItemSelectionAction {
    public abstract void setPreviewMap(int var1, AbstractMap var2, IPreviewMap var3, GuiModelAccessForPreviewMapDetailScreen var4, GuiTooltipInformationContainer var5);

    public boolean isShow() {
        return false;
    }
}

