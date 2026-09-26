/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.util.addressformatting.audi.tooltip;

import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.util.Util;
import de.audi.tghu.navi.app.util.addressformatting.AbstractTooltipFormatter$TooltipStringBuilder;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter$TooltipFormatterEnvironment;
import de.audi.tghu.navi.app.util.addressformatting.audi.tooltip.TooltipFormatterAsia;
import java.util.Date;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class TooltipFormatterJP
extends TooltipFormatterAsia {
    public TooltipFormatterJP(ITooltipFormatter$TooltipFormatterEnvironment iTooltipFormatter$TooltipFormatterEnvironment) {
        super(iTooltipFormatter$TooltipFormatterEnvironment);
    }

    protected String formatVICSGen2(TmcMessage tmcMessage) {
        String string;
        Object object;
        String string2 = tmcMessage.eventText != null && tmcMessage.eventText.length >= 1 ? tmcMessage.eventText[0] : null;
        if (tmcMessage.startTime > 0L && tmcMessage.endTime > 0L) {
            object = new DateMetric(new Date(tmcMessage.endTime - tmcMessage.startTime), 3);
            string = ((DateMetric)object).format();
        } else {
            string = null;
        }
        object = new AbstractTooltipFormatter$TooltipStringBuilder(this);
        ((AbstractTooltipFormatter$TooltipStringBuilder)object).addString(string2);
        if (!Util.isEmpty(string)) {
            ((AbstractTooltipFormatter$TooltipStringBuilder)object).addString("(");
            ((AbstractTooltipFormatter$TooltipStringBuilder)object).addStringWithoutSeparator(string);
            ((AbstractTooltipFormatter$TooltipStringBuilder)object).addString(")");
        }
        return ((AbstractTooltipFormatter$TooltipStringBuilder)object).toString();
    }

    @Override
    public String formatTMC(TmcMessage tmcMessage) {
        if (tmcMessage.eventType == 1 || tmcMessage.eventType == 255) {
            return this.formatVICSGen2(tmcMessage);
        }
        return super.formatTMC(tmcMessage);
    }
}

