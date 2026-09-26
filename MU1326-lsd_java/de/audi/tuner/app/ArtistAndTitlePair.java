/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

public class ArtistAndTitlePair {
    public static final ArtistAndTitlePair EMPTY_PAIR = new ArtistAndTitlePair("", "");
    public final String artistString;
    public final String titleString;

    public ArtistAndTitlePair(String string, String string2) {
        this.artistString = string;
        this.titleString = string2;
    }
}

