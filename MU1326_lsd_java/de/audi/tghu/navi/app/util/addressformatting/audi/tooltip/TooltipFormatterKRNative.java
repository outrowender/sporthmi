/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterKREnglish;
import org.dsi.ifc.global.NavLocation;

public class TooltipFormatterKRNative
extends TooltipFormatterKREnglish {
    public TooltipFormatterKRNative(ITooltipFormatter.TooltipFormatterEnvironment tooltipFormatterEnvironment) {
        super(tooltipFormatterEnvironment);
    }

    protected String format(String string, String string2, String string3, boolean bl) {
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        if (bl) {
            tooltipStringBuilder.addString(string);
            bl = tooltipStringBuilder.addLineBreak();
            tooltipStringBuilder.addString(string3);
        } else {
            tooltipStringBuilder.addString(string);
            tooltipStringBuilder.addString(string3);
        }
        return tooltipStringBuilder.toString();
    }

    public String formatPOIStack(NavLocation navLocation, int n) {
        IMyLocationAccessor iMyLocationAccessor = Util.getLocationAccessor(navLocation);
        AbstractTooltipFormatter.TooltipStringBuilder tooltipStringBuilder = new AbstractTooltipFormatter.TooltipStringBuilder();
        tooltipStringBuilder.addString(LocationFormatter.formatPOIName(navLocation));
        tooltipStringBuilder.addLineBreak();
        tooltipStringBuilder.addString(this.getCityWardCounty(iMyLocationAccessor));
        return tooltipStringBuilder.toString();
    }
}

