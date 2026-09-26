/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter$TooltipStringBuilder;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;
import org.dsi.ifc.global.NavLocation;

public abstract class TooltipFormatterAsia
extends AbstractTooltipFormatter {
    public TooltipFormatterAsia(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    @Override
    public String formatFallback(NavLocation navLocation) {
        return null;
    }

    @Override
    protected String formatTMC(String string, int n, int n2, String string2, String string3, boolean bl, String[] stringArray, String string4, boolean bl2, long l) {
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        abstractTooltipFormatter$TooltipStringBuilder.addString(this.formatTMCRoadNameAndMessageCount(string, n, n2));
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addString(this.formatTMCDirectionOrArea(string2, string3, bl, string4, bl2));
        abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
        abstractTooltipFormatter$TooltipStringBuilder.addStringWithoutComma(this.formatTMCText(stringArray));
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
    }

    @Override
    public String formatBuilding(NavLocation navLocation) {
        return this.formatPOIStack(navLocation, 1);
    }
}

