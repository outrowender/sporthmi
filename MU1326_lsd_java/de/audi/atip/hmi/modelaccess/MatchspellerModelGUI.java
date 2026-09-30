/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.modelaccess.SpellerModelGUI;

public interface MatchspellerModelGUI
extends SpellerModelGUI {
    public static final int INPUT_MODE_SPELLER = 0;
    public static final int INPUT_MODE_HANDWRITTEN = 1;

    public String getValidChars();

    public int getMatchCountVisibility();

    public boolean isUniqueMatch();

    public boolean isFullMatch();

    public void setFullMatch(boolean var1);

    public int getMatchCount();

    public int getLanguage();

    public String getPhonemeText();

    public String getPhonemeAlphabet();

    public String getValidNonAlphaNumTPCharacters(int var1);

    public void nonAlphaNumTPCharsChanged(String var1, int var2);

    public void inputModeTPChanged(int var1, int var2);

    public int getInitialInputMode(int var1);

    public boolean getAllowNonAlphaNumInput(int var1);

    public void strokesChanged(int var1, String var2, char var3);

    public void requestValidHanziCharsWindow(int var1, int var2, int var3);

    public String getValidHanziCharsWindowResult();

    public int getTotalAmountOfHanziCharacters();
}

