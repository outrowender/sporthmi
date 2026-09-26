/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.SpellerModelGUI;

public interface MatchspellerModelGUI
extends SpellerModelGUI {
    public static final int INPUT_MODE_SPELLER;
    public static final int INPUT_MODE_HANDWRITTEN;

    default public String getValidChars() {
    }

    default public int getMatchCountVisibility() {
    }

    default public boolean isUniqueMatch() {
    }

    default public boolean isFullMatch() {
    }

    default public void setFullMatch(boolean bl) {
    }

    default public int getMatchCount() {
    }

    default public int getLanguage() {
    }

    default public String getPhonemeText() {
    }

    default public String getPhonemeAlphabet() {
    }

    default public String getValidNonAlphaNumTPCharacters(int n) {
    }

    default public void nonAlphaNumTPCharsChanged(String string, int n) {
    }

    default public void inputModeTPChanged(int n, int n2) {
    }

    default public int getInitialInputMode(int n) {
    }

    default public boolean getAllowNonAlphaNumInput(int n) {
    }

    default public void strokesChanged(int n, String string, char c2) {
    }

    default public void requestValidHanziCharsWindow(int n, int n2, int n3) {
    }

    default public String getValidHanziCharsWindowResult() {
    }

    default public int getTotalAmountOfHanziCharacters() {
    }
}

