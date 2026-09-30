/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateNavLocations;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class PreviewMapStateNavLocationsTour
extends PreviewMapStateNavLocations {
    String tourName;

    public PreviewMapStateNavLocationsTour(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavLocation[] navLocationArray, String string) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer, navLocationArray);
        this.forTourShowNumberedMapPins = true;
        this.tourName = string;
    }

    public void applyToScreenDetail() {
        this.logger.log(10000000, "PreviewMapStateNavLocationsTour#applyToScreenDetail()");
        NavLocation navLocation = this.getMapForPreview().getNaviInterface().getVehicle().getVehicleLocation();
        this.navLocationPivot = Util.navLocationToWgs84(navLocation);
        this.centerOnPivot = true;
        super.applyToScreenDetail();
    }

    public void applyToScreenDetailModels() {
        if (this.navLocations == null || this.navLocations.length == 0) {
            this.logger.log(10000, "PreviewMapStateNavLocationsTour#applyToScreenDetailModels() no nav location given");
            return;
        }
        if (this.guiModelAccess != null && this.navLocations.length >= 0) {
            this.guiModelAccess.onUpdateLocationsForTour(this.navLocations, this.tourName);
        }
    }

    public void applyToScreenFullMap() {
        this.logger.log(10000000, "PreviewMapStateNavLocationsTour#applyToScreenFullMap()");
        NavLocation navLocation = this.getMapForPreview().getNaviInterface().getVehicle().getVehicleLocation();
        this.navLocationPivot = Util.navLocationToWgs84(navLocation);
        this.centerOnPivot = true;
        super.applyToScreenFullMap();
    }

    protected String getTourName() {
        return this.tourName;
    }

    public boolean isPreviewMapItemArea() {
        return this.navLocations != null && this.navLocations.length != 0;
    }
}

