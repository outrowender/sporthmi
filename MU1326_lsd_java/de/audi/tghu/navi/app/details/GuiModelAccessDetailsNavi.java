/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.details;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.OperatorCallResult;

public interface GuiModelAccessDetailsNavi
extends GuiModelAccessForPreviewMapDetailScreen {
    public void onUpdateLocation(NavLocation var1);

    public void onUpdateLocation(OperatorCallResult var1);

    public void onUpdateLocationsForTour(NavLocation[] var1, String var2);

    public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation var1, String var2);
}

