/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.TMCCalculationHelper;
import de.audi.tghu.info.app.tmc.TMCHelper;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessageImpl;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tmc.TmcPhoneme;

public class TMCReadOutStringHelper {
    private static final char SPACE;
    private static final String NULL_EVENT;
    private final InfoEnv env;

    public TMCReadOutStringHelper(InfoEnv infoEnv) {
        this.env = infoEnv;
    }

    void createStringForOnRouteMsgFirstAttentionPoint(TMCReadOutMessageImpl tMCReadOutMessageImpl, long l) {
        if (tMCReadOutMessageImpl == null) {
            return;
        }
        TmcPhoneme tmcPhoneme = tMCReadOutMessageImpl.getPhoneme();
        String string = null;
        if (tmcPhoneme != null && !TMCHelper.isEmpty(tmcPhoneme.getRoadName())) {
            string = TTSStringUtil.buildPhonemeString(tmcPhoneme.getRoadName(), tmcPhoneme.getPhonemeAlphabet(), tMCReadOutMessageImpl.getRoadName());
        }
        if (string == null) {
            string = tMCReadOutMessageImpl.getRoadName();
        }
        Buffer buffer = new Buffer(100);
        buffer.append(this.env.getTranslatedText(15));
        buffer.append(' ');
        buffer.append(TMCCalculationHelper.calculateDistance(l - tMCReadOutMessageImpl.getDistanceToTarget()));
        buffer.append(' ');
        if (tMCReadOutMessageImpl.getEventText().length < 1) {
            buffer.append("null event");
        } else {
            buffer.append(tMCReadOutMessageImpl.getEventText()[0]);
        }
        buffer.append(' ');
        buffer.append(this.env.getTranslatedText(17));
        buffer.append(' ');
        buffer.append(string);
        buffer.append(".");
        tMCReadOutMessageImpl.setReadOutString(buffer.toString().toLowerCase());
    }

    void createStringForOnRouteMsgSecondAttentionPoint(TMCReadOutMessageImpl tMCReadOutMessageImpl, long l) {
        if (tMCReadOutMessageImpl == null) {
            return;
        }
        Buffer buffer = new Buffer(100);
        buffer.append(this.env.getTranslatedText(18));
        buffer.append(' ');
        if (tMCReadOutMessageImpl.getEventText().length < 1) {
            buffer.append("null event");
        } else {
            buffer.append(tMCReadOutMessageImpl.getEventText()[0]);
        }
        buffer.append(' ');
        buffer.append(this.env.getTranslatedText(20));
        buffer.append(".");
        tMCReadOutMessageImpl.setReadOutString(buffer.toString().toLowerCase());
    }

    void createStringForOnRoadMsg(TMCReadOutMessageImpl tMCReadOutMessageImpl) {
        if (tMCReadOutMessageImpl == null) {
            return;
        }
        TmcPhoneme tmcPhoneme = tMCReadOutMessageImpl.getPhoneme();
        String string = tmcPhoneme.getPhonemeAlphabet();
        String string2 = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        String string6 = null;
        if (tmcPhoneme != null) {
            if (!TMCHelper.isEmpty(tmcPhoneme.getRoadName())) {
                string2 = TTSStringUtil.buildPhonemeString(tmcPhoneme.getRoadName(), string, tMCReadOutMessageImpl.getRoadName());
            }
            if (!TMCHelper.isEmpty(tmcPhoneme.getDirectionOfRoad1())) {
                string3 = TTSStringUtil.buildPhonemeString(tmcPhoneme.getDirectionOfRoad1(), string, tMCReadOutMessageImpl.getDirectionOfRoad1());
            }
            if (!TMCHelper.isEmpty(tmcPhoneme.getDirectionOfRoad2())) {
                string4 = TTSStringUtil.buildPhonemeString(tmcPhoneme.getDirectionOfRoad2(), string, tMCReadOutMessageImpl.getDirectionOfRoad2());
            }
            if (!TMCHelper.isEmpty(tmcPhoneme.getStartLocation())) {
                string5 = TTSStringUtil.buildPhonemeString(tmcPhoneme.getStartLocation(), string, tMCReadOutMessageImpl.getStartLocation());
            }
            if (!TMCHelper.isEmpty(tmcPhoneme.getEndLocation())) {
                string6 = TTSStringUtil.buildPhonemeString(tmcPhoneme.getEndLocation(), string, tMCReadOutMessageImpl.getEndLocation());
            }
        }
        if (string2 == null) {
            string2 = tMCReadOutMessageImpl.getRoadName();
        }
        if (string3 == null) {
            string3 = tMCReadOutMessageImpl.getDirectionOfRoad1();
        }
        if (string4 == null) {
            string4 = tMCReadOutMessageImpl.getDirectionOfRoad2();
        }
        if (string5 == null) {
            string5 = tMCReadOutMessageImpl.getStartLocation();
        }
        if (string6 == null) {
            string6 = tMCReadOutMessageImpl.getEndLocation();
        }
        Buffer buffer = new Buffer(150);
        if (!TMCHelper.isEmpty(string2)) {
            buffer.append(string2);
            buffer.append(", ");
        }
        if (tMCReadOutMessageImpl.isArea() && !TMCHelper.isEmpty(string5)) {
            buffer.append(this.env.getTranslatedText(14));
            buffer.append(' ');
            buffer.append(string5);
            buffer.append(' ');
        } else {
            if (tMCReadOutMessageImpl.isUrban()) {
                buffer.append(this.env.getTranslatedText(22));
                buffer.append(' ');
            }
            buffer.append(string3);
            buffer.append(' ');
            if (!TMCHelper.isEmpty(string4)) {
                buffer.append(this.env.getTranslatedText(13));
                buffer.append(' ');
                buffer.append(string4);
                buffer.append(' ');
            }
            if (!TMCHelper.isEmpty(string5) && !TMCHelper.isEmpty(string6)) {
                buffer.append(this.env.getTranslatedText(11));
                buffer.append(' ');
                buffer.append(string5);
                buffer.append(' ');
                buffer.append(this.env.getTranslatedText(10));
                buffer.append(' ');
                buffer.append(string6);
                buffer.append(' ');
            } else if (!TMCHelper.isEmpty(string5)) {
                buffer.append(string5);
                buffer.append(' ');
            } else if (!TMCHelper.isEmpty(string6)) {
                buffer.append(string6);
                buffer.append(' ');
            }
            if (tMCReadOutMessageImpl.isBidirectional()) {
                buffer.append(this.env.getTranslatedText(12));
                buffer.append(' ');
            }
        }
        String[] stringArray = tMCReadOutMessageImpl.getEventText();
        if (stringArray.length > 1) {
            buffer.append(": ");
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                buffer.append(stringArray[i2]);
                if (i2 >= stringArray.length - 1) continue;
                buffer.append(", ");
            }
        }
        buffer.append('.');
        tMCReadOutMessageImpl.setReadOutString(buffer.toString().toLowerCase());
    }
}

