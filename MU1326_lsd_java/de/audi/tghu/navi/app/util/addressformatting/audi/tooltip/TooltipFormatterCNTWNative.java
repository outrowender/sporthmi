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
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterCNTWEnglish;
import org.dsi.ifc.global.NavLocation;

public class TooltipFormatterCNTWNative
extends TooltipFormatterCNTWEnglish {
    public TooltipFormatterCNTWNative(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        super(tooltipFormatterEnvironment);
    }

    protected String format(String string, String string2, String string3, boolean bl) {
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        tooltipStringBuilder.addString(string);
        if (bl) {
            tooltipStringBuilder.addLineBreak();
        }
        tooltipStringBuilder.addString(string3);
        tooltipStringBuilder.addStringWithoutComma(string2);
        return tooltipStringBuilder.toString();
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
        tooltipStringBuilder.addStringWithoutComma(LocationFormatter.getCity(iMyLocationAccessor));
        tooltipStringBuilder.addStringWithoutComma(LocationFormatter.getDistrict(iMyLocationAccessor));
        return tooltipStringBuilder.toString();
    }
}

