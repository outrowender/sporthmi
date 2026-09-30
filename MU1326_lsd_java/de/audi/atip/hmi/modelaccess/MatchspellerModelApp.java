/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.MatchspellerListenerAsia;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;

public interface MatchspellerModelApp
extends SpellerModelApp {
    public static final int INPUT_MODE_SPELLER = 0;
    public static final int INPUT_MODE_HANDWRITTEN = 1;

    public int getMatchCount();

    public void setValidChars(String var1);

    public void setValidChars(String var1, int var2);

    public void setValidChars(String var1, int var2, int var3);

    public String getValidChars();

    public void setZIPFlag(boolean var1);

    public boolean isZIP();

    public void setUniqueMatch(boolean var1);

    public void setMatchCount(int var1);

    public void setMatchCount(int var1, int var2);

    public void setFullMatch(boolean var1);

    public void setLanguage(int var1);

    public void setPhonemeText(String var1, String var2);

    public void setValidNonAlphaNumTPCharacters(String var1);

    public void setInitialInputMode(int var1);

    public void setAllowNonAlphaNumInput(boolean var1);

    public void setSpellerListenerAsia(MatchspellerListenerAsia var1);

    public void setValidHanziChars(String var1, int var2);
}

