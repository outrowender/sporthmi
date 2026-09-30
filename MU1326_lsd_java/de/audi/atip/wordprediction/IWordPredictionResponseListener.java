/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.wordprediction;

public interface IWordPredictionResponseListener {
    public void updateCandidates(String[] var1);

    public void updateSpelling(String var1);

    public void updateAutoConvertedCharacters(String var1);

    public void handleError(String var1);
}

