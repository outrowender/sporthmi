/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter$TooltipStringBuilder;
import de.audi.tghu.navi.app.util.addressformatting.DefaultTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;

public class TooltipFormatterNAR
extends DefaultTooltipFormatter {
    public TooltipFormatterNAR(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    @Override
    protected String formatTMC(String string, int n, int n2, String string2, String string3, boolean bl, String[] stringArray, String string4, boolean bl2, long l) {
        return super.formatTMC(string, n, n2, string3, null, bl, stringArray, string4, bl2, l);
    }

    @Override
    protected void addCityAndStreet(AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder, String string, String string2) {
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(string2);
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(string);
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
            abstractTooltipFormatter$TooltipStringBuilder.addStringWithoutComma(string3);
            abstractTooltipFormatter$TooltipStringBuilder.addString(string2);
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
}

