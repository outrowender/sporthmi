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

    public void setCoordinates(NavLocation navLocation, int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "GuiModelAccessInputGeoCoordinateImpl#setCoordinates(NavLocation vehicleposition)");
        }
        this.setCoordinates(this.createGeoMetric(navLocation), n);
    }

    protected GeoMetric createGeoMetric(NavLocation navLocation) {
        return new GeoMetric(navLocation.getLatitude(), navLocation.getLongitude());
    }

    public void setCoordinates(GeoMetric geoMetric, int n) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "GuiModelAccessInputGeoCoordinateImpl#setCoordinates(GeoMetric coordinate)");
        }
        this.env.getMetricsModel(400160).setMetric(geoMetric);
        this.showPreviewMap();
        this.env.getMenuModel(401414).setFocusedItem(n, FocusAdvice.KEEP_POSITION, -1L);
    }

    private void showPreviewMap() {
        if (this.env.getChoiceModel(401057).getValue() == 0) {
            this.env.getChoiceModel(401057).setValue(1);
        }
    }

    public void onUpdateLocation(NavLocation navLocation) {
        if (this.logChannel.isDebug2()) {
            this.logChannel.log(100000000, "GuiModelAccessInputGeoCoordinateImpl#setDetailedCoordinateInformation()");
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
            this.env.getChoiceModel(401367).setValue(0);
        } else {
            this.env.getLabelModel(401357).setText(stringBuffer.toString());
            this.env.getChoiceModel(401367).setValue(1);
        }
    }

    public GuiTooltipInformationContainer createMapTooltipInformationContainer(NavLocation navLocation, String string) {
        GuiTooltipInformationContainer guiTooltipInformationContainer = new GuiTooltipInformationContainer();
        PreviewMapUtils.fillToolTipInformationContainerByNavLocation(this.env, navLocation, string, guiTooltipInformationContainer);
        return guiTooltipInformationContainer;
    }

    public void onUpdateLocationsForTour(NavLocation[] navLocationArray, String string) {
    }
}

