/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor;
import de.esolutions.fw.util.commons.Buffer;
import java.text.BreakIterator;
import java.util.Locale;
import org.dsi.ifc.tmc.TmcMessage;

abstract class TrafficEventMsgExtractor$AbstractTextBuilder {
    protected int mMaxCntAsia;
    protected int mMaxCntEnglish;
    private final /* synthetic */ TrafficEventMsgExtractor this$0;

    public TrafficEventMsgExtractor$AbstractTextBuilder(TrafficEventMsgExtractor trafficEventMsgExtractor, int n, int n2) {
        this.this$0 = trafficEventMsgExtractor;
        this.mMaxCntAsia = n2;
        this.mMaxCntEnglish = n;
    }

    public boolean validateTmcMessage(TmcMessage tmcMessage) {
        if (tmcMessage.eventText == null) {
            TrafficEventMsgExtractor.access$000(this.this$0).getLogChannel().log(10000, "AbstractTextBuilder#validateTmcMessage(), TmcMessage.eventText is null!");
            return false;
        }
        return true;
    }

    public String wordWrap(String string, int n, Locale locale) {
        if (string == null) {
            return "";
        }
        if (n < 5) {
            return string;
        }
        if (n >= string.length()) {
            return string;
        }
        Buffer buffer = new Buffer(string);
        boolean bl = false;
        int n2 = 0;
        for (int i2 = 0; i2 < buffer.length(); ++i2) {
            if (buffer.charAt(i2) == '\n') {
                n2 = i2 + 1;
                bl = true;
            }
            if (i2 <= n2 + n - 1) continue;
            if (!bl) {
                int n3 = i2 - n2 - 1;
                BreakIterator breakIterator = BreakIterator.getLineInstance(locale);
                breakIterator.setText(buffer.substring(n2, i2));
                int n4 = breakIterator.last();
                if (n4 == n3 + 1 && !Character.isWhitespace(buffer.charAt(n2 + n4))) {
                    n4 = breakIterator.preceding(n4 - 1);
                }
                if (n4 != -1 && n4 == n3 + 1) {
                    buffer.insert(n2 + n4, "\n");
                    n2 += n4;
                    continue;
                }
                if (n4 != -1 && n4 != 0) {
                    buffer.insert(n2 + n4, '\n');
                    n2 = n2 + n4 + 1;
                    continue;
                }
                buffer.insert(i2, '\n');
                n2 = i2 + 1;
                continue;
            }
            buffer.insert(i2, '\n');
            n2 = i2 + 1;
            bl = false;
        }
        return buffer.toString();
    }

    public abstract String buildText(TmcMessage tmcMessage) {
    }
}

