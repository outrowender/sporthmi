/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.data.search;

public class MediaSearchUtils {
    public static final int ENTRYTYPE_COMPOSER;
    public static final int ENTRYTYPE_PODCAST;

    public static int getContentType(int n) {
        switch (n) {
            case 6: {
                return 14;
            }
            case 5: {
                return 13;
            }
            case 9: {
                return 16;
            }
            case 10: {
                return 6;
            }
            case 7: {
                return 1;
            }
            case 11: {
                return 2;
            }
            case 12: {
                return 4;
            }
            case 14: {
                return 11;
            }
            case 13: {
                return 17;
            }
        }
        return 1;
    }
}

