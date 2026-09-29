/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.atip.interapp.locationaccessor.IMyLocationAccessor;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter$TooltipStringBuilder;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterKREnglish;
import org.dsi.ifc.global.NavLocation;

public class TooltipFormatterKRNative
extends TooltipFormatterKREnglish {
    public TooltipFormatterKRNative(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    @Override
    protected String format(String string, String string2, String string3, boolean bl) {
        AbstractTooltipFormatter$TooltipStringBuilder abstractTooltipFormatter$TooltipStringBuilder = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        if (bl) {
            abstractTooltipFormatter$TooltipStringBuilder.addString(string);
            bl = abstractTooltipFormatter$TooltipStringBuilder.addLineBreak();
            abstractTooltipFormatter$TooltipStringBuilder.addString(string3);
        } else {
            abstractTooltipFormatter$TooltipStringBuilder.addString(string);
            abstractTooltipFormatter$TooltipStringBuilder.addString(string3);
        }
        return abstractTooltipFormatter$TooltipStringBuilder.toString();
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
}

