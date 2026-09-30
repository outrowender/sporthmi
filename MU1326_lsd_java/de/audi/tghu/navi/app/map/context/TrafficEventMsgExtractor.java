/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.util.StringUtilities;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import java.text.BreakIterator;
import java.util.Locale;
import org.dsi.ifc.tmc.TmcMessage;

public class TrafficEventMsgExtractor {
    private static final int PAG_MAX_COUNT_ASIA = 30;
    private static final int PAG_MAX_COUNT_ENGLISH = 50;
    private static final int AUDI_MAX_COUNT_ASIA = 15;
    private static final int AUDI_MAX_COUNT_ENGLISH = 30;
    private NavigationEnv env = null;
    private int languageIndex = -1;
    private AbstractTextBuilder textBuilder = null;

    public TrafficEventMsgExtractor(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.languageIndex = navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        navigationEnv.getLogChannel().log(100000000, "TrafficEventMsgFormatter#constructor, language index is: (%1)", (long)this.languageIndex);
        switch (this.languageIndex) {
            case 1: 
            case 9: 
            case 13: 
            case 15: 
            case 17: 
            case 25: {
                this.textBuilder = new TextBuilderAsia_English(Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 14: {
                this.textBuilder = new TextBuilder_Simplified_Chinese(Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 23: 
            case 24: {
                this.textBuilder = new TextBuilder_Traditional_Chinese(Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 12: {
                this.textBuilder = new TextBuilder_Japanese(Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 16: {
                this.textBuilder = new TextBuilder_Korean(Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            default: {
                navigationEnv.getLogChannel().log(10000, "TrafficEventMsgFormatter#constructor, language index (%1) is not supported in the country!", (long)this.languageIndex);
            }
        }
    }

    public String extractTrafficEventMsg(TmcMessage tmcMessage) {
        if (this.textBuilder == null) {
            this.env.getLogChannel().log(10000, "TrafficEventMsgExtractor#extractTrafficEventMsg(), ITextBuilder is null, cannot build traffic message!");
            return "";
        }
        boolean bl = this.textBuilder.validateTmcMessage(tmcMessage);
        if (!bl) {
            this.env.getLogChannel().log(1000000, "TrafficEventMsgExtractor#extractTrafficEventMsg(), validateTmcMessage result is invalid!");
            return "";
        }
        String string = this.textBuilder.buildText(tmcMessage);
        return string;
    }

    private class TextBuilder_Korean
    extends AbstractTextBuilder {
        public TextBuilder_Korean(int n, int n2) {
            super(n, n2);
        }

        public String buildText(TmcMessage tmcMessage) {
            TrafficEventMsgExtractor.this.env.getLogChannel().log(10000000, "TextBuilder_Korean#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
            String string = "";
            if (tmcMessage.affectedRoadLength == 0L) {
                if (tmcMessage.eventText != null) {
                    if (tmcMessage.eventText.length == 1) {
                        string = StringUtilities.formatMessage("%1 %2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\uc804\ubc29", tmcMessage.eventText[0]});
                    } else if (tmcMessage.eventText.length == 2) {
                        string = !Util.isEmpty(tmcMessage.eventText[0]) ? StringUtilities.formatMessage("%1%2 %3(%4)%5 %6 %7", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\uc804\ubc29", tmcMessage.eventText[1], "\uc73c", "\ub85c", "\uc778\ud55c", tmcMessage.eventText[0]}) : StringUtilities.formatMessage("%1%2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\uc804\ubc29", tmcMessage.eventText[1]});
                    }
                }
            } else if (tmcMessage.affectedRoadLength > 0L && tmcMessage.eventText != null) {
                string = tmcMessage.eventText.length == 0 ? StringUtilities.formatMessage("%1 %2 %3%4 %5", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\uc804\ubc29", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5), "\ub3d9\uc548", "\uc815\uccb4"}) : StringUtilities.formatMessage("%1 %2 %3%4 %5(%6) %7 %8 %9", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\uc804\ubc29", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5), "\ub3d9\uc548", tmcMessage.eventText[0], "\uc73c", "\ub85c", "\uc778\ud55c", "\uc815\uccb4"});
            }
            string = this.wordWrap(string, this.mMaxCntAsia, Locale.KOREA);
            return string;
        }
    }

    private abstract class AbstractTextBuilder {
        protected int mMaxCntAsia;
        protected int mMaxCntEnglish;

        public AbstractTextBuilder(int n, int n2) {
            this.mMaxCntAsia = n2;
            this.mMaxCntEnglish = n;
        }

        public boolean validateTmcMessage(TmcMessage tmcMessage) {
            if (tmcMessage.eventText == null) {
                TrafficEventMsgExtractor.this.env.getLogChannel().log(10000, "AbstractTextBuilder#validateTmcMessage(), TmcMessage.eventText is null!");
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

        public abstract String buildText(TmcMessage var1);
    }

    private class TextBuilder_Japanese
    extends AbstractTextBuilder {
        public TextBuilder_Japanese(int n, int n2) {
            super(n, n2);
        }

        public String buildText(TmcMessage tmcMessage) {
            TrafficEventMsgExtractor.this.env.getLogChannel().log(10000000, "TextBuilder_Japanese#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
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

    private class TextBuilderAsia_English
    extends AbstractTextBuilder {
        public TextBuilderAsia_English(int n, int n2) {
            super(n, n2);
        }

        public String buildText(TmcMessage tmcMessage) {
            TrafficEventMsgExtractor.this.env.getLogChannel().log(10000000, "TextBuilderAsia_English#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
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

    private class TextBuilder_Simplified_Chinese
    extends AbstractTextBuilder {
        public TextBuilder_Simplified_Chinese(int n, int n2) {
            super(n, n2);
        }

        public String buildText(TmcMessage tmcMessage) {
            TrafficEventMsgExtractor.this.env.getLogChannel().log(10000000, "TextBuilder_Simplified_Chinese#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
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

    private class TextBuilder_Traditional_Chinese
    extends AbstractTextBuilder {
        public TextBuilder_Traditional_Chinese(int n, int n2) {
            super(n, n2);
        }

        public String buildText(TmcMessage tmcMessage) {
            TrafficEventMsgExtractor.this.env.getLogChannel().log(10000000, "TextBuilder_Chinese#buildText(), TmcMessage: (%1)", (Object)tmcMessage);
            String string = "";
            if (tmcMessage.affectedRoadLength == 0L) {
                if (tmcMessage.eventText != null) {
                    if (tmcMessage.eventText.length == 1) {
                        string = StringUtilities.formatMessage("%1%2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5f8c", tmcMessage.eventText[0]});
                    } else if (tmcMessage.eventText.length == 2) {
                        string = !Util.isEmpty(tmcMessage.eventText[0]) ? StringUtilities.formatMessage("%1%2 %3 %4%5", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5f8c", tmcMessage.eventText[1], "\u5f15\u8d77", tmcMessage.eventText[0]}) : StringUtilities.formatMessage("%1%2 %3", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5f8c", tmcMessage.eventText[1]});
                    }
                }
            } else if (tmcMessage.affectedRoadLength > 0L && tmcMessage.eventText != null) {
                string = tmcMessage.eventText.length == 0 ? StringUtilities.formatMessage("%1%2 %3%4", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5f8c", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5), "\u8eca\u8f1b\u64c1\u5835"}) : StringUtilities.formatMessage("%1%2 %3%4", new String[]{Util.formatDistance((int)tmcMessage.distanceToEvent, 5), "\u5f8c", Util.formatDistance((int)tmcMessage.affectedRoadLength, 5), tmcMessage.eventText[0]});
            }
            string = this.wordWrap(string, this.mMaxCntAsia, Locale.CHINA);
            return string;
        }
    }
}

