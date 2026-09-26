/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.wordprediction;

import de.audi.atip.hmi.event.ATIPEventListener;

public interface IWordPrediction {
    public static final String WORDDATABASE_POIS_FOR_PROVINCE;
    public static final String[] ADDITIONAL_WORDDATABASES;

    default public void spellerConnected(ATIPEventListener aTIPEventListener, int n, int n2, String[] stringArray) {
    }

    default public void spellerDisconnected(ATIPEventListener aTIPEventListener, int n) {
    }

    default public void convertedAllCharactersInternally(ATIPEventListener aTIPEventListener, int n) {
    }

    default public void unconvertedTextChanged(ATIPEventListener aTIPEventListener, int n, String string, String string2, int n2) {
    }

    default public void startContextBasedPrediction(ATIPEventListener aTIPEventListener, int n, String string, String string2, int n2) {
    }

    default public void selectedCandidate(ATIPEventListener aTIPEventListener, int n, String string, int n2, String string2, int n3) {
    }

    default public void getCandidates(ATIPEventListener aTIPEventListener, int n, int n2) {
    }

    default public void addToUserPreference(ATIPEventListener aTIPEventListener, int n, String string, String string2) {
    }

    default public void getConversionAndSpellingImmediately(ATIPEventListener aTIPEventListener, int n, String string, int n2) {
    }

    static {
        ADDITIONAL_WORDDATABASES = new String[]{"<pois-for-province>", "contactdb", "mediadb"};
    }
}

