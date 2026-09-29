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
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterCNTWEnglish;
import org.dsi.ifc.global.NavLocation;

public class TooltipFormatterCNTWNative
extends TooltipFormatterCNTWEnglish {
    public TooltipFormatterCNTWNative(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    @Override
    protected String format(String string, String string2, String string3, boolean bl) {
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        abstractTooltipFormatter$TooltipStringBuilder.addString(string);
        if (bl) {
            abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        }
        abstractTooltipFormatter$TooltipStringBuilder.addString(string3);
        abstractTooltipFormatter$TooltipStringBuilder.addStringWithoutComma(string2);
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
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
        abstractTooltipFormatter$TooltipStringBuilder.addStringWithoutComma(LocationFormatter.getCity(iMyLocationAccessor));
        abstractTooltipFormatter$TooltipStringBuilder.addStringWithoutComma(LocationFormatter.getDistrict(iMyLocationAccessor));
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }
}

