/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navigation.previewmap.gui;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import org.dsi.ifc.global.NavLocation;

public interface GuiModelAccessForPreviewMapDetailScreen {
    default public void onUpdateLocation(NavLocation navLocation) {
    }

    default public void onUpdateLocationsForTour(NavLocation[] navLocationArray, String string) {
    }

    default public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation navLocation, String string) {
    }
}

