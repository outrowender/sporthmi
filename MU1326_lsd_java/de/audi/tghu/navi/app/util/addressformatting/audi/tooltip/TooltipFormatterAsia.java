/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import org.dsi.ifc.global.NavLocation;

public abstract class TooltipFormatterAsia
extends AbstractTooltipFormatter {
    public TooltipFormatterAsia(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        super(tooltipFormatterEnvironment);
    }

    public String formatFallback(NavLocation navLocation) {
        return null;
    }

    protected String formatTMC(String string, int n, int n2, String string2, String string3, boolean bl, String[] stringArray, String string4, boolean bl2, long l) {
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        tooltipStringBuilder.addString(this.formatTMCRoadNameAndMessageCount(string, n, n2));
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(this.formatTMCDirectionOrArea(string2, string3, bl, string4, bl2));
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addStringWithoutComma(this.formatTMCText(stringArray));
        return tooltipStringBuilder.toString();
    }

    public String formatBuilding(NavLocation navLocation) {
        return this.formatPOIStack(navLocation, 1);
    }
}

