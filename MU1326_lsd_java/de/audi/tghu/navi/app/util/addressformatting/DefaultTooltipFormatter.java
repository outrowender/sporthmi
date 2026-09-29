/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter$TooltipStringBuilder;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class DefaultTooltipFormatter
extends AbstractTooltipFormatter {
    protected static final float ADD_COUNTRY_ZOOM;
    protected static final float REMOVE_CITY_ZOOM;

    public DefaultTooltipFormatter(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    @Override
    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        String string = iFavorite.getFavoriteName() != null ? iFavorite.getFavoriteName() : "";
        String string2 = iFavorite.getStreet();
        String string3 = iFavorite.getHouseNumber();
        String string4 = iFavorite.getCity();
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        if (!Util.isEmpty(string2)) {
            abstractTooltipFormatter$TooltipStringBuilder.addString(string2);
            abstractTooltipFormatter$TooltipStringBuilder.addStringWithoutComma(string3);
        }
        if (!Util.isEmpty(string4)) {
            abstractTooltipFormatter$TooltipStringBuilder.addString(string4);
        }
        if (abstractTooltipFormatter$TooltipStringBuilder.isEmpty() || !abstractTooltipFormatter$TooltipStringBuilder.toString().trim().equals(string.trim())) {
            AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder2 = new AbstractTooltipFormatter$TooltipStringBuilder(this);
            abstractTooltipFormatter$TooltipStringBuilder2.addString(string);
            abstractTooltipFormatter$TooltipStringBuilder2.addLineBreak();
            abstractTooltipFormatter$TooltipStringBuilder2.addString(abstractTooltipFormatter$TooltipStringBuilder.toString());
            return abstractTooltipFormatter$TooltipStringBuilder2.toString();
        }
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }

    @Override
    public String formatLocation(NavLocation navLocation) {
        String string;
        float f2 = this.env.getZoomLevel();
        if (navLocation == null) {
            this.env.getLogChannel().log(10000, "DefaultTooltipFormatter#formatLocation(): location = null");
            return null;
        }
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        if (f2 > 5260103) {
            string = LocationFormatter.formatCountry(navLocation);
            abstractTooltipFormatter$TooltipStringBuilder.addString(string);
        }
        if (f2 < 2389065) {
            string = LocationFormatter.formatCity(navLocation);
            String string2 = LocationFormatter.formatStreet(navLocation);
            this.addCityAndStreet(abstractTooltipFormatter$TooltipStringBuilder, string, string2);
        }
        if (!abstractTooltipFormatter$TooltipStringBuilder.isEmpty()) {
            return abstractTooltipFormatter$TooltipStringBuilder.toString();
        }
        this.env.getLogChannel().log(-2137614336, "DefaultTooltipFormatter#formatLocation(): failed to format location: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        return null;
    }

    @Override
    public String formatPOIStack(NavLocation navLocation, int n) {
        if (n > 1) {
            String string = LocationFormatter.formatPOICategory(navLocation);
            int n2 = string.indexOf(9);
            if (n2 >= 0) {
                string = string.substring(0, n2);
            }
            return new StringBuffer().append(n).append(" ").append(string).toString();
        }
        return this.formatPOI(navLocation);
    }

    @Override
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
        this.env.getLogChannel().log(-2137614336, "DefaultTooltipFormatter#formatPOI(): failed to format POI: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        return null;
    }

    @Override
    public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
        this.env.getLogChannel().log(-2137614336, "DefaultTooltipFormatter#formatOnlinePOI() - location: %1, poi: %2", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)poiOnlineSearchValuelistElement);
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
        this.env.getLogChannel().log(-2137614336, "DefaultTooltipFormatter#formatOnlinePOI(): failed to format POI: %1", (Object)LocationFormatter.formatLocationShort(navLocation));
        return null;
    }

    @Override
    protected String formatTMC(String string, int n, int n2, String string2, String string3, boolean bl, String[] stringArray, String string4, boolean bl2, long l) {
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        abstractTooltipFormatter$TooltipStringBuilder.addString(this.formatTMCRoadNameAndMessageCount(string, n, n2));
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(this.formatTMCDirectionOrArea(string2, string3, bl, string4, bl2));
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(this.formatTMCText(stringArray));
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }
}

