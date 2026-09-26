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

public class TooltipFormatterKREnglish
extends TooltipFormatterAsia {
    public TooltipFormatterKREnglish(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    protected String format(String string, String string2, String string3, boolean bl) {
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        if (bl) {
            abstractTooltipFormatter$TooltipStringBuilder.addString(string);
            abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
            abstractTooltipFormatter$TooltipStringBuilder.addString(string3);
        } else {
            abstractTooltipFormatter$TooltipStringBuilder.addString(string);
            abstractTooltipFormatter$TooltipStringBuilder.addString(string3);
        }
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }

    protected String getCityWardCounty(IMyLocationAccessor iMyLocationAccessor) {
        String string = LocationFormatter.getCity(iMyLocationAccessor);
        if (Util.isEmpty(string)) {
            string = iMyLocationAccessor.getWard();
        }
        if (Util.isEmpty(string)) {
            string = iMyLocationAccessor.getTownRefinement();
        }
        return string;
    }

    @Override
    public String formatPOI(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(LocationFormatter.formatPOIName(navLocation), iMyLocationAccessor.getState(), this.getCityWardCounty(iMyLocationAccessor), true);
    }

    @Override
    public String formatPOIStack(NavLocation navLocation, int n) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        abstractTooltipFormatter$TooltipStringBuilder.addString(LocationFormatter.formatPOIName(navLocation));
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(this.getCityWardCounty(iMyLocationAccessor));
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }

    @Override
    public String formatOnlinePOI(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, NavLocation navLocation) {
        if (poiOnlineSearchValuelistElement == null) {
            return null;
        }
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(poiOnlineSearchValuelistElement.getName(), iMyLocationAccessor.getState(), this.getCityWardCounty(iMyLocationAccessor), true);
    }

    @Override
    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        NavLocation navLocation = this.env.getNavLocation(iFavorite.getFavoriteLocation());
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(iFavorite.getFavoriteName(), iMyLocationAccessor.getState(), this.getCityWardCounty(iMyLocationAccessor), true);
    }

    @Override
    public String formatLocation(NavLocation navLocation) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        return this.format(iMyLocationAccessor.getStreet(), iMyLocationAccessor.getState(), this.getCityWardCounty(iMyLocationAccessor), true);
    }
}

