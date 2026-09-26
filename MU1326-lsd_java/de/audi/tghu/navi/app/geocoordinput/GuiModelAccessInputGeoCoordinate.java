/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.geocoordinput;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.metrics.GeoMetric;
import org.dsi.ifc.global.NavLocation;

public interface GuiModelAccessInputGeoCoordinate
extends GuiModelAccessForPreviewMapDetailScreen {
    default public void setCoordinates(NavLocation navLocation, int n) {
    }

    default public void setCoordinates(GeoMetric geoMetric, int n) {
    }

    @Override
    default public void onUpdateLocation(NavLocation navLocation) {
    }
}

