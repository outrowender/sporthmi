/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor$AbstractTextBuilder;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor$TextBuilderAsia_English;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor$TextBuilder_Japanese;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor$TextBuilder_Korean;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese;
import de.audi.tghu.navi.app.map.context.TrafficEventMsgExtractor$TextBuilder_Traditional_Chinese;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.tmc.TmcMessage;

public class TrafficEventMsgExtractor {
    private static final int PAG_MAX_COUNT_ASIA;
    private static final int PAG_MAX_COUNT_ENGLISH;
    private static final int AUDI_MAX_COUNT_ASIA;
    private static final int AUDI_MAX_COUNT_ENGLISH;
    private NavigationEnv env = null;
    private int languageIndex = -1;
    private TrafficEventMsgExtractor$AbstractTextBuilder textBuilder = null;

    public TrafficEventMsgExtractor(NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.languageIndex = navigationEnv.getFramework().getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_HMI").getLanguageIndex();
        navigationEnv.getLogChannel().log(14808325, "TrafficEventMsgFormatter#constructor, language index is: (%1)", (long)this.languageIndex);
        switch (this.languageIndex) {
            case 1: 
            case 9: 
            case 13: 
            case 15: 
            case 17: 
            case 25: {
                this.textBuilder = new TrafficEventMsgExtractor$TextBuilderAsia_English(this, Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 14: {
                this.textBuilder = new TrafficEventMsgExtractor$TextBuilder_Simplified_Chinese(this, Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 23: 
            case 24: {
                this.textBuilder = new TrafficEventMsgExtractor$TextBuilder_Traditional_Chinese(this, Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 12: {
                this.textBuilder = new TrafficEventMsgExtractor$TextBuilder_Japanese(this, Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
                break;
            }
            case 16: {
                this.textBuilder = new TrafficEventMsgExtractor$TextBuilder_Korean(this, Util.isPorsche(navigationEnv.getFramework()) ? 50 : 30, Util.isPorsche(navigationEnv.getFramework()) ? 30 : 15);
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
            this.env.getLogChannel().log(1078071040, "TrafficEventMsgExtractor#extractTrafficEventMsg(), validateTmcMessage result is invalid!");
            return "";
        }
        String string = this.textBuilder.buildText(tmcMessage);
        return string;
    }

    static /* synthetic */ NavigationEnv access$000(TrafficEventMsgExtractor trafficEventMsgExtractor) {
        return trafficEventMsgExtractor.env;
    }
}

