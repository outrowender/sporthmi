/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.enumeration;

import de.audi.tghu.exlap.Enum;

public class MediaEntryTypeEnumeration
extends Enum {
    public static final MediaEntryTypeEnumeration UNKNOWN = new MediaEntryTypeEnumeration("UNKNOWN", 0);
    public static final MediaEntryTypeEnumeration AUDIO = new MediaEntryTypeEnumeration("AUDIO", 1);
    public static final MediaEntryTypeEnumeration VIDEO = new MediaEntryTypeEnumeration("VIDEO", 2);
    public static final MediaEntryTypeEnumeration IMAGE = new MediaEntryTypeEnumeration("IMAGE", 3);
    public static final MediaEntryTypeEnumeration FOLDER = new MediaEntryTypeEnumeration("FOLDER", 4);
    public static final MediaEntryTypeEnumeration PLAYLIST = new MediaEntryTypeEnumeration("PLAYLIST", 5);
    public static final MediaEntryTypeEnumeration PLAYLIST_FOLDER = new MediaEntryTypeEnumeration("PLAYLIST_FOLDER", 6);
    public static final MediaEntryTypeEnumeration AUDIO_FOLDER = new MediaEntryTypeEnumeration("AUDIO_FOLDER", 7);
    public static final MediaEntryTypeEnumeration VIDEO_FOLDER = new MediaEntryTypeEnumeration("VIDEO_FOLDER", 8);
    public static final MediaEntryTypeEnumeration IMAGE_FOLDER = new MediaEntryTypeEnumeration("IMAGE_FOLDER", 9);
    public static final MediaEntryTypeEnumeration DYNAMIC_PLAYLIST = new MediaEntryTypeEnumeration("DYNAMIC_PLAYLIST", 10);
    public static final MediaEntryTypeEnumeration PODCAST_FOLDER = new MediaEntryTypeEnumeration("PODCAST_FOLDER", 11);
    public static final MediaEntryTypeEnumeration ARTIST_FOLDER = new MediaEntryTypeEnumeration("ARTIST_FOLDER", 13);
    public static final MediaEntryTypeEnumeration ALBUM_FOLDER = new MediaEntryTypeEnumeration("ALBUM_FOLDER", 14);
    public static final MediaEntryTypeEnumeration TITLE_FOLDER = new MediaEntryTypeEnumeration("TITLE_FOLDER", 15);
    public static final MediaEntryTypeEnumeration GENRE_FOLDER = new MediaEntryTypeEnumeration("GENRE_FOLDER", 16);
    public static final MediaEntryTypeEnumeration FAVORITE_FOLDER = new MediaEntryTypeEnumeration("FAVORITE_FOLDER", 20);
    public static final MediaEntryTypeEnumeration RAW_BROWSING_ROOT = new MediaEntryTypeEnumeration("RAW_BROWSING_ROOT", 257);
    public static final MediaEntryTypeEnumeration DATABASE_BROWSING_ROOT = new MediaEntryTypeEnumeration("DATABASE_BROWSING_ROOT", 258);

    protected MediaEntryTypeEnumeration(String string, int n) {
        super(string, n);
    }

    public static MediaEntryTypeEnumeration valueOf(int n) {
        switch (n) {
            case 0: {
                return UNKNOWN;
            }
            case 1: {
                return AUDIO;
            }
            case 2: {
                return VIDEO;
            }
            case 3: {
                return IMAGE;
            }
            case 4: {
                return FOLDER;
            }
            case 5: {
                return PLAYLIST;
            }
            case 6: {
                return PLAYLIST_FOLDER;
            }
            case 7: {
                return AUDIO_FOLDER;
            }
            case 8: {
                return VIDEO_FOLDER;
            }
            case 9: {
                return IMAGE_FOLDER;
            }
            case 10: {
                return DYNAMIC_PLAYLIST;
            }
            case 11: {
                return PODCAST_FOLDER;
            }
            case 13: {
                return ARTIST_FOLDER;
            }
            case 14: {
                return ALBUM_FOLDER;
            }
            case 15: {
                return TITLE_FOLDER;
            }
            case 16: {
                return GENRE_FOLDER;
            }
            case 20: {
                return FAVORITE_FOLDER;
            }
            case 257: {
                return RAW_BROWSING_ROOT;
            }
            case 258: {
                return DATABASE_BROWSING_ROOT;
            }
        }
        return null;
    }
}

