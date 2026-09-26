/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.geocoordinput;

import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.GeoMetric;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.geocoordinput.GuiModelAccessInputGeoCoordinate;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

public class GuiModelAccessInputGeoCoordinateImpl
implements GuiModelAccessInputGeoCoordinate {
    protected final NavigationEnv env;
    private final LogChannel logChannel;

    public GuiModelAccessInputGeoCoordinateImpl(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.logChannel = navigationEnv.getGeoCoordInputLogChannel();
    }

    @Override
    public void setCoordinates(NavLocation navLocation, int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GuiModelAccessInputGeoCoordinateImpl#setCoordinates(NavLocation vehicleposition)");
        }
        this.setCoordinates(this.createGeoMetric(navLocation), n);
    }

    protected GeoMetric createGeoMetric(NavLocation navLocation) {
        return new GeoMetric(navLocation.getLatitude(), navLocation.getLongitude());
    }

    @Override
    public void setCoordinates(GeoMetric geoMetric, int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GuiModelAccessInputGeoCoordinateImpl#setCoordinates(GeoMetric coordinate)");
        }
        this.env.getMetricsModel(538641920).setMetric(geoMetric);
        this.showPreviewMap();
        this.env.getMenuModel(0x6200600).setFocusedItem(n, FocusAdvice.KEEP_POSITION, -1L);
    }

    private void showPreviewMap() {
        if (this.env.getChoiceModel(-1591867904).getValue() == 0) {
            this.env.getChoiceModel(-1591867904).setValue(1);
        }
    }

    @Override
    public void onUpdateLocation(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(14808325, "GuiModelAccessInputGeoCoordinateImpl#setDetailedCoordinateInformation()");
        }
        String string = LocationFormatter.formatStreetHousenumber(navLocation);
        String string2 = LocationFormatter.formatCityZipTextfield(navLocation);
        String string3 = LocationFormatter.formatCountry(navLocation);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append("\n");
        stringBuffer.append(string2);
        stringBuffer.append("\n");
        stringBuffer.append(string3);
        if (Util.isEmpty(string) && Util.isEmpty(string2) && Util.isEmpty(string3)) {
            this.env.getChoiceModel(-685832704).setValue(0);
        } else {
            this.env.getLabelModel(-853604864).setText(stringBuffer.toString());
            this.env.getChoiceModel(-685832704).setValue(1);
        }
    }

    @Override
    public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation navLocation, String string) {
        GuiTooltipInformationContainer guiTooltipInformationContainer = new GuiTooltipInformationContainer();
        PreviewMapUtils.fillToolTipInformationContainerByNavLocation(this.env, navLocation, string, guiTooltipInformationContainer);
        return guiTooltipInformationContainer;
    }

    @Override
    public void onUpdateLocationsForTour(NavLocation[] navLocationArray, String string) {
    }
}

