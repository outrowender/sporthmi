/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.geocoordinput;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.metrics.GeoMetric;
import org.dsi.ifc.global.NavLocation;

public interface GuiModelAccessInputGeoCoordinate
extends GuiModelAccessForPreviewMapDetailScreen {
    public void setCoordinates(NavLocation var1, int var2);

    public void setCoordinates(GeoMetric var1, int var2);

    public void onUpdateLocation(NavLocation var1);
}

