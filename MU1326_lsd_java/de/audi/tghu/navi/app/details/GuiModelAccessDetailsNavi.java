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
    @Override
    default public void onUpdateLocation(NavLocation navLocation) {
    }

    default public void onUpdateLocation(OperatorCallResult operatorCallResult) {
    }

    @Override
    default public void onUpdateLocationsForTour(NavLocation[] navLocationArray, String string) {
    }

    @Override
    default public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation navLocation, String string) {
    }
}

