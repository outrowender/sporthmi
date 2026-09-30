/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class DefaultTooltipFormatter
extends AbstractTooltipFormatter {
    protected static final float ADD_COUNTRY_ZOOM = 50000.0f;
    protected static final float REMOVE_CITY_ZOOM = 1000000.0f;

    public DefaultTooltipFormatter(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        super(tooltipFormatterEnvironment);
    }

    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        String string = iFavorite.getFavoriteName() != null ? iFavorite.getFavoriteName() : "";
        String string2 = iFavorite.getStreet();
        String string3 = iFavorite.getHouseNumber();
        String string4 = iFavorite.getCity();
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder(this);
        if (!Util.isEmpty(string2)) {
            tooltipStringBuilder.addString(string2);
            tooltipStringBuilder.addStringWithoutComma(string3);
        }
        if (!Util.isEmpty(string4)) {
            tooltipStringBuilder.addString(string4);
        }
        if (tooltipStringBuilder.isEmpty() || !tooltipStringBuilder.toString().trim().equals(string.trim())) {
            AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder2 = new AbstractTooltipFormatter.TooltipStringBuilder(this);
            tooltipStringBuilder2.addString(string);
            tooltipStringBuilder2.addLineBreak();
            tooltipStringBuilder2.addString(tooltipStringBuilder.toString());
            return tooltipStringBuilder2.toString();
        }
        return tooltipStringBuilder.toString();
    }

    public String formatLocation(NavLocation navLocation) {
        String string;
        float f2 = this.env.getZoomLevel();
        if (navLocation == null) {
            this.env.getLogChannel().log(10000, "DefaultTooltipFormatter#formatLocation(): location = null");
            return null;
        }
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder(this);
        if (f2 > 50000.0f) {
            string = LocationFormatter.formatCountry(navLocation);
            tooltipStringBuilder.addString(string);
        }
        if (f2 < 1000000.0f) {
            string = LocationFormatter.formatCity(navLocation);
            String string2 = LocationFormatter.formatStreet(navLocation);
            this.addCityAndStreet(tooltipStringBuilder, string, string2);
        }
        if (!tooltipStringBuilder.isEmpty()) {
            return tooltipStringBuilder.toString();
        }
        this.env.getLogChannel().log(10000000, "DefaultTooltipFormatter#formatLocation(): failed to format location: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        return null;
    }

    public String formatPOIStack(NavLocation navLocation, int n) {
        if (n > 1) {
            String string = LocationFormatter.formatPOICategory(navLocation);
            int n2 = string.indexOf(9);
            if (n2 >= 0) {
                string = string.substring(0, n2);
            }
            return n + " " + string;
        }
        return this.formatPOI(navLocation);
    }

    public String formatPOI(NavLocation navLocation) {
        String string = LocationFormatter.formatPOIName(navLocation);
        String string2 = LocationFormatter.formatStreetHousenumber(navLocation);
        Buffer buffer = new Buffer();
        if (!Util.isEmpty(string)) {
            buffer.append(string);
        } else {
            String string3 = LocationFormatter.formatPOICategory(navLocation);
            buffer.append(string3);
        }
        if (!(Util.isEmpty(string2) || !Util.isEmpty(string) && string.equals(string2))) {
            buffer.append('\n').append(string2);
        }
        if (buffer.length() > 0) {
            return buffer.toString();
        }
        this.env.getLogChannel().log(10000000, "DefaultTooltipFormatter#formatPOI(): failed to format POI: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        return null;
    }

    public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
        this.env.getLogChannel().log(10000000, "DefaultTooltipFormatter#formatOnlinePOI() - location: %1, poi: %2", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)poiOnlineSearchValuelistElement);
        String string = poiOnlineSearchValuelistElement.name;
        String string2 = LocationFormatter.formatStreetHousenumber(navLocation);
        String string3 = LocationFormatter.formatPhonenumber(navLocation);
        Buffer buffer = new Buffer();
        if (!Util.isEmpty(string)) {
            buffer.append(string);
        }
        if (!(Util.isEmpty(string2) || !Util.isEmpty(string) && string.equals(string2))) {
            buffer.append('\n').append(string2);
        }
        if (!Util.isEmpty(string3)) {
            buffer.append('\n').append(string3);
        }
        if (buffer.length() > 0) {
            return buffer.toString();
        }
        this.env.getLogChannel().log(10000000, "DefaultTooltipFormatter#formatOnlinePOI(): failed to format POI: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        return null;
    }

    protected String formatTMC(String string, int n, int n2, String string2, String string3, boolean bl, String[] stringArray, String string4, boolean bl2, long l) {
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder(this);
        tooltipStringBuilder.addString(this.formatTMCRoadNameAndMessageCount(string, n, n2));
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(this.formatTMCDirectionOrArea(string2, string3, bl, string4, bl2));
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(this.formatTMCText(stringArray));
        return tooltipStringBuilder.toString();
    }
}

