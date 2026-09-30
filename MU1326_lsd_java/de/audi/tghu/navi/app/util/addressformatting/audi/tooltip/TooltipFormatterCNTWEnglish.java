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
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterAsia;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class TooltipFormatterCNTWEnglish
extends TooltipFormatterAsia {
    public TooltipFormatterCNTWEnglish(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        super(tooltipFormatterEnvironment);
    }

    protected String format(String string, String string2, String string3, boolean bl) {
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        tooltipStringBuilder.addString(string);
        if (bl) {
            tooltipStringBuilder.addLineBreak();
        }
        tooltipStringBuilder.addString(string2);
        tooltipStringBuilder.addString(string3);
        return tooltipStringBuilder.toString();
    }

    public String formatPOI(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(LocationFormatter.formatPOIName(navLocation), LocationFormatter.getDistrict(iMyLocationAccessor), LocationFormatter.getCity(iMyLocationAccessor), true);
    }

    public String formatPOIStack(NavLocation navLocation, int n) {
        return this.formatPOI(navLocation);
    }

    public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
        if (poiOnlineSearchValuelistElement == null) {
            return null;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(poiOnlineSearchValuelistElement.getName(), LocationFormatter.getDistrict(iMyLocationAccessor), LocationFormatter.getCity(iMyLocationAccessor), true);
    }

    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        tooltipStringBuilder.addString(iFavorite.getFavoriteName());
        tooltipStringBuilder.addLineBreak();
        NavLocation navLocation = this.env.getNavLocation(iFavorite.getFavoriteLocation());
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        tooltipStringBuilder.addString(LocationFormatter.getDistrict(iMyLocationAccessor));
        tooltipStringBuilder.addString(LocationFormatter.getCity(iMyLocationAccessor));
        return tooltipStringBuilder.toString();
    }

    public String formatLocation(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(iMyLocationAccessor.getStreet(), LocationFormatter.getDistrict(iMyLocationAccessor), LocationFormatter.getCity(iMyLocationAccessor), true);
    }
}

