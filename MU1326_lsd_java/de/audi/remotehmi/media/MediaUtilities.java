/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.media;

public class MediaUtilities {
    public static String concatenateArtistAndAlbum(String string, String string2) {
        string = string == null ? "" : string.trim();
        String string3 = string2 = string2 == null ? "" : string2.trim();
        if (string.length() == 0) {
            return string2;
        }
        if (string2.length() == 0) {
            return string;
        }
        return string + " - " + string2;
    }

    public static int calculateIdFromAlbum(String string, int n) {
        if (string == null) {
            return n;
        }
        return string.hashCode() % 5 + 1;
    }
}

