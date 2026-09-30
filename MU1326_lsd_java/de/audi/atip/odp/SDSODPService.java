/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.Logger;
import de.audi.atip.odp.SpeechGrammar;

public interface SDSODPService {
    public static final byte RESULT_OK = 0;
    public static final byte RESULT_ERROR = 1;
    public static final byte RESULT_TIMEOUT = 2;
    public static final byte RESULT_NONE = 3;
    public static final byte RESULT_ABORTED = 4;
    public static final byte RESULT_INVALID = 5;
    public static final byte RESULT_AMBIGUOUS = 6;
    public static final int GRAMMARTYPE_SRGS_GRAMMAR_STRING = 1;
    public static final byte GRAMMAR_TYPE_PRECOMPILED_ID = 4;
    public static final byte GRAMMARTYPE_LAST_NBESTLIST = 6;
    public static final byte GRAMMARTYPE_COMBINED_WORD_ID_LIST = 8;
    public static final int SCREEN_ID_PHONE_MAIN = 1;
    public static final int POPUP_ID_NAVI_POI_PICKLIST = 1;
    public static final int POPUP_ID_NAVI_POI_RESULTLIST = 2;
    public static final int POPUP_ID_TEL_CONTACT = 50;
    public static final int MODEL_ID_GUIDANCE_STATUS = 1;
    public static final int MODEL_ID_MEDIA_SOURCE = 2;
    public static final int EVENT_PTT = 0;
    public static final int EVENT_LOW_FUEL = 1;
    public static final int EVENT_INCOMING_CALL = 2;

    public void loadGrammar(SpeechGrammar[] var1);

    public void unloadGrammar(SpeechGrammar[] var1);

    public void startRecognition();

    public void playPrompt(String var1);

    public void endDialogSession();

    public void startDialogSession();

    public void responseLanguageChanged(byte var1);

    public int getModelIntegerValue(int var1);

    public String getModelStringValue(int var1);

    public void showScreen(int var1);

    public void showPopup(int var1);

    public void removePopup(int var1);

    public Logger createLogger(String var1);
}

