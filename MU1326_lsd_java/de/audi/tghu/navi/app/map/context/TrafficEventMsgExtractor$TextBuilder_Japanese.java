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

class TrafficEventMsgExtractor$TextBuilder_Japanese
extends TrafficEventMsgExtractor$AbstractTextBuilder {
    private final /* synthetic */ TrafficEventMsgExtractor this$0;

    public TrafficEventMsgExtractor$TextBuilder_Japanese(TrafficEventMsgExtractor trafficEventMsgExtractor, int n, int n2) {
        this.this$0 = trafficEventMsgExtractor;
        super(trafficEventMsgExtractor, n, n2);
    }

    @Override
    public String buildText(TmcMessage tmcMessage) {
        TrafficEventMsgExtractor.access$000(this.this$0).getLogChannel().log(-2137614336, "TextBuilder_Japanese#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
        String string = "";
        if (tmcMessage.affectedRoadLength == 0L) {
            if (tmcMessage.eventText != null) {
                if (tmcMessage.eventText.length == 1) {
                    string = StringUtilities.formatMessage("%1%2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5148", tmcMessage.eventText[0]});
                } else if (tmcMessage.eventText.length == 2) {
                    string = !Util.isEmpty(tmcMessage.eventText[0]) ? StringUtilities.formatMessage("%1%2 %3 %4 %5", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5148", tmcMessage.eventText[1], "\u306e\u70ba", tmcMessage.eventText[0]}) : StringUtilities.formatMessage("%1%2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5148", tmcMessage.eventText[1]});
                }
            }
        } else if (tmcMessage.affectedRoadLength > 0L && tmcMessage.eventText != null) {
            string = tmcMessage.eventText.length == 0 ? StringUtilities.formatMessage("%1%2 %3 %4%5", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5148", "\u6e0b\u6ede", "\u9577\u3055", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5)}) : StringUtilities.formatMessage("%1%2 %3 %4%5", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5148", tmcMessage.eventText[0], "\u9577\u3055", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5)});
        }
        string = this.wordWrap(string, this.mMaxCntAsia, Locale.JAPAN);
        return string;
    }
}

