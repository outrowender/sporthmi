/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.navigation.previewmap.gui;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import org.dsi.ifc.global.NavLocation;

public interface GuiModelAccessForPreviewMapDetailScreen {
    public void onUpdateLocation(NavLocation var1);

    public void onUpdateLocationsForTour(NavLocation[] var1, String var2);

    public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation var1, String var2);
}

