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
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterAsia;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

public class TooltipFormatterCNTWEnglish
extends TooltipFormatterAsia {
    public TooltipFormatterCNTWEnglish(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    protected String format(String string, String string2, String string3, boolean bl) {
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        abstractTooltipFormatter$TooltipStringBuilder.addString(string);
        if (bl) {
            abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        }
        abstractTooltipFormatter$TooltipStringBuilder.addString(string2);
        abstractTooltipFormatter$TooltipStringBuilder.addString(string3);
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }

    @Override
    public String formatPOI(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(LocationFormatter.formatPOIName(navLocation), LocationFormatter.getDistrict(iMyLocationAccessor), LocationFormatter.getCity(iMyLocationAccessor), true);
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
        return this.format(poiOnlineSearchValuelistElement.getName(), LocationFormatter.getDistrict(iMyLocationAccessor), LocationFormatter.getCity(iMyLocationAccessor), true);
    }

    @Override
    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        abstractTooltipFormatter$TooltipStringBuilder.addString(iFavorite.getFavoriteName());
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        NavLocation navLocation = this.env.getNavLocation(iFavorite.getFavoriteLocation());
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        abstractTooltipFormatter$TooltipStringBuilder.addString(LocationFormatter.getDistrict(iMyLocationAccessor));
        abstractTooltipFormatter$TooltipStringBuilder.addString(LocationFormatter.getCity(iMyLocationAccessor));
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }

    @Override
    public String formatLocation(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(iMyLocationAccessor.getStreet(), LocationFormatter.getDistrict(iMyLocationAccessor), LocationFormatter.getCity(iMyLocationAccessor), true);
    }
}

