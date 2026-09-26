/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;
import de.audi.tghu.navi.app.util.addressformatting.TooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.TooltipFormatter$1;
import org.dsi.ifc.global.NavLocation;

class TooltipFormatter$TooltipFormatterEnvironmentImpl
implements ITooltipFormatter$TooltipFormatterEnvironment {
    private final /* synthetic */ TooltipFormatter this$0;

    private TooltipFormatter$TooltipFormatterEnvironmentImpl(TooltipFormatter tooltipFormatter) {
        this.this$0 = tooltipFormatter;
    }

    @Override
    public LogChannel getLogChannel() {
        return TooltipFormatter.access$000(this.this$0).getMapMainLogChannel();
    }

    @Override
    public NavLocation getNavLocation(byte[] byArray) {
        return TooltipFormatter.access$100((TooltipFormatter)this.this$0).locationSerializer.streamToLocation(byArray);
    }

    @Override
    public boolean hasIcon(NavLocation navLocation) {
        return LocationFormatter.getIconResourceID(TooltipFormatter.access$100(this.this$0).getIconHandler(), navLocation) != -1;
    }

    @Override
    public float getZoomLevel() {
        return TooltipFormatter.access$100(this.this$0).getZoomHandler().getZoom();
    }

    /* synthetic */ TooltipFormatter$TooltipFormatterEnvironmentImpl(TooltipFormatter tooltipFormatter, TooltipFormatter$1 tooltipFormatter$1) {
        this(tooltipFormatter);
    }
}

