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

class TrafficEventMsgExtractor$TextBuilderAsia_English
extends TrafficEventMsgExtractor$AbstractTextBuilder {
    private final /* synthetic */ TrafficEventMsgExtractor this$0;

    public TrafficEventMsgExtractor$TextBuilderAsia_English(TrafficEventMsgExtractor trafficEventMsgExtractor, int n, int n2) {
        this.this$0 = trafficEventMsgExtractor;
        super(trafficEventMsgExtractor, n, n2);
    }

    @Override
    public String buildText(TmcMessage tmcMessage) {
        TrafficEventMsgExtractor.access$000(this.this$0).getLogChannel().log(-2137614336, "TextBuilderAsia_English#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
        String string = "";
        if (tmcMessage.affectedRoadLength == 0L) {
            if (tmcMessage.eventText != null) {
                if (tmcMessage.eventText.length == 1) {
                    string = StringUtilities.formatMessage("In %1 %2", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), tmcMessage.eventText[0]});
                } else if (tmcMessage.eventText.length == 2) {
                    string = StringUtilities.formatMessage("In %1 %2 due to %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), tmcMessage.eventText[0], tmcMessage.eventText[1]});
                }
            }
        } else if (tmcMessage.affectedRoadLength > 0L && tmcMessage.eventText != null) {
            string = tmcMessage.eventText.length == 0 ? StringUtilities.formatMessage("In %1 traffic jam %2 long", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), Util.formatDistance((int)tmcMessage.affectedRoadLength, 5)}) : StringUtilities.formatMessage("In %1 %2 %3 long", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), tmcMessage.eventText[0], Util.formatDistance((int)tmcMessage.affectedRoadLength, 5)});
        }
        string = this.wordWrap(string, this.mMaxCntEnglish, Locale.UK);
        return string;
    }
}

