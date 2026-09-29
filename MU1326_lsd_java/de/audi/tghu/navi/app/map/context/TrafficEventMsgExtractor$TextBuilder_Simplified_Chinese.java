/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor$AbstractTextBuilder;
import de.audi.tghu.navi.app.util.Util;
import java.util.Locale;
import org.dsi.ifc.tmc.TmcMessage;

class TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese
extends TrafficEventMsgExtractor$AbstractTextBuilder {
    private final /* synthetic */ TrafficEventMsgExtractor this$0;

    public TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese(TrafficEventMsgExtractor trafficEventMsgExtractor, int n, int n2) {
        this.this$0 = trafficEventMsgExtractor;
        super(trafficEventMsgExtractor, n, n2);
    }

    @Override
    public String buildText(TmcMessage tmcMessage) {
        TrafficEventMsgExtractor.access$000(this.this$0).getLogChannel().log(-2137614336, "TextBuilder_Simplified_Chinese#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
        String string = "";
        if (tmcMessage.affectedRoadLength == 0L) {
            if (tmcMessage.eventText != null) {
                if (tmcMessage.eventText.length == 1) {
                    string = StringUtilities.formatMessage("%1%2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u540e", tmcMessage.eventText[0]});
                } else if (tmcMessage.eventText.length == 2) {
                    string = !Util.isEmpty(tmcMessage.eventText[0]) ? StringUtilities.formatMessage("%1%2 %3 %4%5", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u540e", tmcMessage.eventText[1], "\u5f15\u8d77", tmcMessage.eventText[0]}) : StringUtilities.formatMessage("%1%2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u540e", tmcMessage.eventText[1]});
                }
            }
        } else if (tmcMessage.affectedRoadLength > 0L && tmcMessage.eventText != null) {
            string = tmcMessage.eventText.length == 0 ? StringUtilities.formatMessage("%1%2 %3%4", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u540e", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5), "\u4ea4\u901a\u62e5\u5835"}) : StringUtilities.formatMessage("%1%2 %3%4", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u540e", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5), tmcMessage.eventText[0]});
        }
        string = this.wordWrap(string, this.mMaxCntAsia, Locale.CHINA);
        return string;
    }
}

