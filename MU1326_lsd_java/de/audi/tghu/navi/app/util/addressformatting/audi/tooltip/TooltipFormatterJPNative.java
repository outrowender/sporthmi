/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterJP;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class TooltipFormatterJPNative
extends TooltipFormatterJP {
    public TooltipFormatterJPNative(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        super(tooltipFormatterEnvironment);
    }

    protected String format(String string, String string2, String string3) {
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        tooltipStringBuilder.addString(string);
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addStringWithoutComma(string3);
        tooltipStringBuilder.addStringWithoutComma(string2);
        return tooltipStringBuilder.toString();
    }

    public String formatPOI(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(LocationFormatter.formatPOIName(navLocation), iMyLocationAccessor.getWard(), LocationFormatter.getCity(iMyLocationAccessor));
    }

    public String formatPOIStack(NavLocation navLocation, int n) {
        return this.formatPOI(navLocation);
    }

    public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
        if (poiOnlineSearchValuelistElement == null) {
            return null;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(poiOnlineSearchValuelistElement.getName(), iMyLocationAccessor.getWard(), LocationFormatter.getCity(iMyLocationAccessor));
    }

    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        NavLocation navLocation = this.env.getNavLocation(iFavorite.getFavoriteLocation());
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(iFavorite.getFavoriteName(), iMyLocationAccessor.getWard(), LocationFormatter.getCity(iMyLocationAccessor));
    }

    public String formatLocation(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        String string = this.getStreet(iMyLocationAccessor);
        String string2 = iMyLocationAccessor.getWard();
        String string3 = LocationFormatter.getCity(iMyLocationAccessor);
        return this.format(string, string2, string3);
    }

    protected String getStreet(IMyLocationAccessor iMyLocationAccessor) {
        String string = iMyLocationAccessor.getStreet();
        if (Util.isEmpty(string)) {
            return iMyLocationAccessor.getChome();
        }
        return string;
    }
}

