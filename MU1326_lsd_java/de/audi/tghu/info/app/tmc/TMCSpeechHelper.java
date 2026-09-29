/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.tts.TTSStringUtil;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.tmc.TmcPhoneme;

public class TMCSpeechHelper {
    private String tempRoadName = "";
    private String tempDirectionOfRoad1 = "";
    private String tempDirectionOfRoad2 = "";
    private String tempStartLocation = "";
    private String tempEndLocation = "";
    private LogChannel logger;
    private final InfoEnv env;

    public TMCSpeechHelper(InfoEnv infoEnv, LogChannel logChannel) {
        this.env = infoEnv;
        this.logger = logChannel;
    }

    String getStringForTTS(TmcMessage tmcMessage) {
        String[] stringArray;
        if (tmcMessage == null) {
            this.logger.log(-2137614336, "[TMCSpeechHelper#getStringForTTS] No current detail message available, build default text! ");
            return this.env.getTranslatedText(8).toLowerCase();
        }
        this.logger.log(-2137614336, "[TMCSpeechHelper#getStringForTTS] before getting phonemes: %1 ", (Object)Thread.currentThread().getName());
        this.replaceWithPhonemes(tmcMessage);
        Buffer buffer = new Buffer();
        if (tmcMessage.isUrbanFlag()) {
            buffer.append(this.env.getTranslatedText(22).toLowerCase());
            buffer.append(" ");
            if (tmcMessage.getRoadName() != null && !tmcMessage.getRoadName().equals("")) {
                buffer.append(this.tempRoadName);
                buffer.append(", ");
            }
        } else {
            if (tmcMessage.getRoadName() != null && !tmcMessage.getRoadName().equals("")) {
                buffer.append(this.tempRoadName);
                buffer.append(", ");
            }
            if (tmcMessage.isIsArea()) {
                buffer.append(this.env.getTranslatedText(14).toLowerCase());
                buffer.append(" ");
                buffer.append(this.tempStartLocation);
                buffer.append(" ");
            } else {
                buffer.append(this.tempDirectionOfRoad1);
                buffer.append(" ");
                if (tmcMessage.getDirectionOfRoad2() != null && !tmcMessage.getDirectionOfRoad2().equals("")) {
                    buffer.append(this.env.getTranslatedText(3).toLowerCase());
                    buffer.append(" ");
                    buffer.append(this.tempDirectionOfRoad2);
                    buffer.append(" ");
                }
            }
        }
        if (!tmcMessage.isIsArea()) {
            if (tmcMessage.getStartLocation() != null && !tmcMessage.getStartLocation().equals("") && tmcMessage.getEndLocation() != null && !tmcMessage.getEndLocation().equals("")) {
                buffer.append(this.env.getTranslatedText(1).toLowerCase());
                buffer.append(" ");
                buffer.append(this.tempStartLocation);
                buffer.append(" ");
                buffer.append(this.env.getTranslatedText(0).toLowerCase());
                buffer.append(" ");
                buffer.append(this.tempEndLocation);
                buffer.append(" ");
            } else if (tmcMessage.getStartLocation() != null && !tmcMessage.getStartLocation().equals("")) {
                buffer.append(this.tempStartLocation);
                buffer.append(" ");
            } else if (tmcMessage.getEndLocation() != null && !tmcMessage.getEndLocation().equals("")) {
                buffer.append(this.tempEndLocation);
                buffer.append(" ");
            }
            if (tmcMessage.isBidirectional) {
                buffer.append(this.env.getTranslatedText(2).toLowerCase());
                buffer.append(" ");
            }
        }
        if ((stringArray = tmcMessage.getEventText()).length > 1) {
            buffer.append(": ");
            for (int i2 = 1; i2 < stringArray.length; ++i2) {
                buffer.append(stringArray[i2].toLowerCase());
                if (i2 >= stringArray.length - 1) continue;
                buffer.append(", ");
            }
        }
        buffer.append(".");
        String string = buffer.toString();
        this.logger.log(-2137614336, "[TMCSpeechHelper#getStringForTTS] Built message: '%1' ", (Object)string);
        return string;
    }

    private void replaceWithPhonemes(TmcMessage tmcMessage) {
        this.logger.log(-2137614336, "[TMCSpeechHelper#replaceWithPhonemes] Called, msg: %1", (Object)tmcMessage);
        TmcPhoneme tmcPhoneme = tmcMessage.getPhoneme();
        this.tempRoadName = tmcMessage.getRoadName();
        if (this.tempRoadName != null) {
            this.tempRoadName = this.tempRoadName.toLowerCase();
        }
        this.tempDirectionOfRoad1 = tmcMessage.getDirectionOfRoad1();
        if (this.tempDirectionOfRoad1 != null) {
            this.tempDirectionOfRoad1 = this.tempDirectionOfRoad1.toLowerCase();
        }
        this.tempDirectionOfRoad2 = tmcMessage.getDirectionOfRoad2();
        if (this.tempDirectionOfRoad2 != null) {
            this.tempDirectionOfRoad2 = this.tempDirectionOfRoad2.toLowerCase();
        }
        this.tempStartLocation = tmcMessage.getStartLocation();
        if (this.tempStartLocation != null) {
            this.tempStartLocation = this.tempStartLocation.toLowerCase();
        }
        this.tempEndLocation = tmcMessage.getEndLocation();
        if (this.tempEndLocation != null) {
            this.tempEndLocation = this.tempEndLocation.toLowerCase();
        }
        if (tmcPhoneme == null) {
            this.logger.log(-2137614336, "[TMCSpeechHelper#replaceWithPhonemes] No phonemes available!");
            return;
        }
        if (tmcPhoneme.getRoadName() != null && !tmcPhoneme.getRoadName().equals("")) {
            this.tempRoadName = TTSStringUtil.buildPhonemeString(tmcPhoneme.getRoadName(), tmcPhoneme.getPhonemeAlphabet(), tmcMessage.getRoadName());
            this.logger.log(-2137614336, "[TMCSpeechHelper#replaceWithPhonemes] Phoneme for road name: %1", (Object)this.tempRoadName);
        }
        if (tmcPhoneme.getDirectionOfRoad1() != null && !tmcPhoneme.getDirectionOfRoad1().equals("")) {
            this.tempDirectionOfRoad1 = TTSStringUtil.buildPhonemeString(tmcPhoneme.getDirectionOfRoad1(), tmcPhoneme.getPhonemeAlphabet(), tmcMessage.getDirectionOfRoad1());
            this.logger.log(-2137614336, "[TMCSpeechHelper#replaceWithPhonemes] Phoneme for directionOfRoad1: %1", (Object)this.tempDirectionOfRoad1);
        }
        if (tmcPhoneme.getDirectionOfRoad2() != null && !tmcPhoneme.getDirectionOfRoad2().equals("")) {
            this.tempDirectionOfRoad2 = TTSStringUtil.buildPhonemeString(tmcPhoneme.getDirectionOfRoad2(), tmcPhoneme.getPhonemeAlphabet(), tmcMessage.getDirectionOfRoad2());
            this.logger.log(-2137614336, "[TMCSpeechHelper#replaceWithPhonemes] Phoneme for directionOfRoad2: %1", (Object)this.tempDirectionOfRoad2);
        }
        if (tmcPhoneme.getStartLocation() != null && !tmcPhoneme.getStartLocation().equals("")) {
            this.tempStartLocation = TTSStringUtil.buildPhonemeString(tmcPhoneme.getStartLocation(), tmcPhoneme.getPhonemeAlphabet(), tmcMessage.getStartLocation());
            this.logger.log(-2137614336, "[TMCSpeechHelper#replaceWithPhonemes] Phoneme for startLocation: %1", (Object)this.tempStartLocation);
        }
        if (tmcPhoneme.getEndLocation() != null && !tmcPhoneme.getEndLocation().equals("")) {
            this.tempEndLocation = TTSStringUtil.buildPhonemeString(tmcPhoneme.getEndLocation(), tmcPhoneme.getPhonemeAlphabet(), tmcMessage.getEndLocation());
            this.logger.log(-2137614336, "[TMCSpeechHelper#replaceWithPhonemes] Phoneme for endLocation: %1", (Object)this.tempEndLocation);
        }
    }

    String getSeveralMessagesOnRouteString() {
        String string = this.env.getTranslatedText(5);
        this.logger.log(-2137614336, "[TMCSpeechHelper#getSeveralMessagesOnRouteString] String: '%1' ", (Object)string);
        return string;
    }

    String getAvailableMessagesString() {
        String string = this.env.getTranslatedText(4).toLowerCase();
        this.logger.log(-2137614336, "[TMCSpeechHelper#getAvailableMessagesString] String: '%1'", (Object)string);
        return string;
    }

    String getOneMessageOnRouteString() {
        String string = this.env.getTranslatedText(21).toLowerCase();
        this.logger.log(-2137614336, "[TMCSpeechHelper#getOneMessageOnRouteString] String: '%1' ", (Object)string);
        return string;
    }

    String getNoMessagesOnRouteString() {
        String string = this.env.getTranslatedText(9).toLowerCase();
        this.logger.log(-2137614336, "[TMCSpeechHelper#getNoMessagesOnRouteString] String: '%1' ", (Object)string);
        return string;
    }
}

