/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.esolutions.hmi.widgets.audi.base.NullWordPredictionAccess;

public interface IWordPredictionAccess {
    public static final IWordPredictionAccess NULL = new NullWordPredictionAccess();

    public void spellerConnected(int var1, String[] var2);

    public void convertedAllCharactersInternally();

    public void spellerDisconnected();

    public void unconvertedTextChanged(String var1, String var2, int var3);

    public void startContextBasedPrediction(String var1, String var2, int var3);

    public void selectedCandidate(String var1, int var2, String var3, int var4);

    public void getCandidates(int var1);

    public void addToUserPreference(String var1, String var2);

    public void getConversionAndSpellingImmediately(String var1, int var2);
}

