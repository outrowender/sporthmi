/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.DefaultTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;

public class TooltipFormatterNAR
extends DefaultTooltipFormatter {
    public TooltipFormatterNAR(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        super(tooltipFormatterEnvironment);
    }

    protected String formatTMC(String string, int n, int n2, String string2, String string3, boolean bl, String[] stringArray, String string4, boolean bl2, long l) {
        return super.formatTMC(string, n, n2, string3, null, bl, stringArray, string4, bl2, l);
    }

    protected void addCityAndStreet(AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder, String string, String string2) {
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(string2);
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(string);
    }

    public String formatFavorite(IFavorite iFavorite) {
        if (iFavorite == null) {
            return null;
        }
        String string = iFavorite.getFavoriteName() != null ? iFavorite.getFavoriteName() : "";
        String string2 = iFavorite.getStreet();
        String string3 = iFavorite.getHouseNumber();
        String string4 = iFavorite.getCity();
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        if (!Util.isEmpty(string2)) {
            tooltipStringBuilder.addStringWithoutComma(string3);
            tooltipStringBuilder.addString(string2);
        }
        if (!Util.isEmpty(string4)) {
            tooltipStringBuilder.addString(string4);
        }
        if (tooltipStringBuilder.isEmpty() || !tooltipStringBuilder.toString().trim().equals(string.trim())) {
            AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder2 = new AbstractTooltipFormatter.TooltipStringBuilder();
            tooltipStringBuilder2.addString(string);
            tooltipStringBuilder2.addLineBreak();
            tooltipStringBuilder2.addString(tooltipStringBuilder.toString());
            return tooltipStringBuilder2.toString();
        }
        return tooltipStringBuilder.toString();
    }
}

