/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.gui;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import org.dsi.ifc.global.NavLocation;

public class GuiModelAccessForPreviewMapDetailScreenDefault
implements GuiModelAccessForPreviewMapDetailScreen {
    @Override
    public void onUpdateLocation(NavLocation navLocation) {
    }

    @Override
    public void onUpdateLocationsForTour(NavLocation[] navLocationArray, String string) {
    }

    @Override
    public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation navLocation, String string) {
        return null;
    }
}

