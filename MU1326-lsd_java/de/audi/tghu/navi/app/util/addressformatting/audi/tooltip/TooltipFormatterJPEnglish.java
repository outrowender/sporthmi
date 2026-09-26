/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter$TooltipStringBuilder;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterJP;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class TooltipFormatterJPEnglish
extends TooltipFormatterJP {
    public TooltipFormatterJPEnglish(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    protected String format(String string, String string2, String string3) {
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        abstractTooltipFormatter$TooltipStringBuilder.addString(string);
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(string2);
        abstractTooltipFormatter$TooltipStringBuilder.addString(string3);
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }

    @Override
    public String formatPOI(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(LocationFormatter.formatPOIName(navLocation), iMyLocationAccessor.getWard(), LocationFormatter.getCity(iMyLocationAccessor));
    }

    @Override
    public String formatPOIStack(NavLocation navLocation, int n) {
        return this.formatPOI(navLocation);
    }

    @Override
    public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
        if (poiOnlineSearchValuelistElement == null) {
            return null;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(poiOnlineSearchValuelistElement.getName(), iMyLocationAccessor.getWard(), LocationFormatter.getCity(iMyLocationAccessor));
    }

    @Override
    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        NavLocation navLocation = this.env.getNavLocation(iFavorite.getFavoriteLocation());
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(iFavorite.getFavoriteName(), iMyLocationAccessor.getWard(), LocationFormatter.getCity(iMyLocationAccessor));
    }

    @Override
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

