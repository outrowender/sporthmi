/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.wordprediction;

import de.audi.atip.hmi.event.ATIPEventListener;

public interface IWordPrediction {
    public static final String WORDDATABASE_POIS_FOR_PROVINCE = "<pois-for-province>";
    public static final String[] ADDITIONAL_WORDDATABASES = new String[]{"<pois-for-province>", "contactdb", "mediadb"};

    public void spellerConnected(ATIPEventListener var1, int var2, int var3, String[] var4);

    public void spellerDisconnected(ATIPEventListener var1, int var2);

    public void convertedAllCharactersInternally(ATIPEventListener var1, int var2);

    public void unconvertedTextChanged(ATIPEventListener var1, int var2, String var3, String var4, int var5);

    public void startContextBasedPrediction(ATIPEventListener var1, int var2, String var3, String var4, int var5);

    public void selectedCandidate(ATIPEventListener var1, int var2, String var3, int var4, String var5, int var6);

    public void getCandidates(ATIPEventListener var1, int var2, int var3);

    public void addToUserPreference(ATIPEventListener var1, int var2, String var3, String var4);

    public void getConversionAndSpellingImmediately(ATIPEventListener var1, int var2, String var3, int var4);
}

