/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.odp;

import de.audi.atip.odp.Logger;
import de.audi.atip.odp.SpeechGrammar;

public interface SDSODPService {
    public static final byte RESULT_OK;
    public static final byte RESULT_ERROR;
    public static final byte RESULT_TIMEOUT;
    public static final byte RESULT_NONE;
    public static final byte RESULT_ABORTED;
    public static final byte RESULT_INVALID;
    public static final byte RESULT_AMBIGUOUS;
    public static final int GRAMMARTYPE_SRGS_GRAMMAR_STRING;
    public static final byte GRAMMAR_TYPE_PRECOMPILED_ID;
    public static final byte GRAMMARTYPE_LAST_NBESTLIST;
    public static final byte GRAMMARTYPE_COMBINED_WORD_ID_LIST;
    public static final int SCREEN_ID_PHONE_MAIN;
    public static final int POPUP_ID_NAVI_POI_PICKLIST;
    public static final int POPUP_ID_NAVI_POI_RESULTLIST;
    public static final int POPUP_ID_TEL_CONTACT;
    public static final int MODEL_ID_GUIDANCE_STATUS;
    public static final int MODEL_ID_MEDIA_SOURCE;
    public static final int EVENT_PTT;
    public static final int EVENT_LOW_FUEL;
    public static final int EVENT_INCOMING_CALL;

    default public void loadGrammar(SpeechGrammar[] speechGrammarArray) {
    }

    default public void unloadGrammar(SpeechGrammar[] speechGrammarArray) {
    }

    default public void startRecognition() {
    }

    default public void playPrompt(String string) {
    }

    default public void endDialogSession() {
    }

    default public void startDialogSession() {
    }

    default public void responseLanguageChanged(byte by) {
    }

    default public int getModelIntegerValue(int n) {
    }

    default public String getModelStringValue(int n) {
    }

    default public void showScreen(int n) {
    }

    default public void showPopup(int n) {
    }

    default public void removePopup(int n) {
    }

    default public Logger createLogger(String string) {
    }
}

