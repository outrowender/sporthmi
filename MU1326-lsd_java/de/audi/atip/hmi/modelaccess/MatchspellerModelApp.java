/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public interface MatchspellerModelApp
extends SpellerModelApp {
    public static final int INPUT_MODE_SPELLER;
    public static final int INPUT_MODE_HANDWRITTEN;

    default public int getMatchCount() {
    }

    default public void setValidChars(String string) {
    }

    default public void setValidChars(String string, int n) {
    }

    default public void setValidChars(String string, int n, int n2) {
    }

    default public String getValidChars() {
    }

    default public void setZIPFlag(boolean bl) {
    }

    default public boolean isZIP() {
    }

    default public void setUniqueMatch(boolean bl) {
    }

    default public void setMatchCount(int n) {
    }

    default public void setMatchCount(int n, int n2) {
    }

    default public void setFullMatch(boolean bl) {
    }

    default public void setLanguage(int n) {
    }

    default public void setPhonemeText(String string, String string2) {
    }

    default public void setValidNonAlphaNumTPCharacters(String string) {
    }

    default public void setInitialInputMode(int n) {
    }

    default public void setAllowNonAlphaNumInput(boolean bl) {
    }

    default public void setSpellerListenerAsia(MatchspellerListenerAsia matchspellerListenerAsia) {
    }

    default public void setValidHanziChars(String string, int n) {
    }
}

