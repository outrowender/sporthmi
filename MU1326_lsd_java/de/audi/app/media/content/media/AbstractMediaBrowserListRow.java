/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaListRow;
import de.audi.app.media.content.media.utils.IntMap;
import de.audi.app.media.content.media.utils.NoMapElementException;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.i18n.I18NString;

public abstract class AbstractMediaBrowserListRow
extends AbstractMediaListRow {
    public static final int SYMBOL_FILE_AUDIO = 0;
    public static final int SYMBOL_FILE_AUDIO_PROTECTED = 1;
    public static final int SYMBOL_FILE_AUDIO_CORRUPT = 2;
    public static final int SYMBOL_FILE_AUDIO_DEADLINK = 3;
    public static final int SYMBOL_FILE_VIDEO = 4;
    public static final int SYMBOL_FILE_VIDEO_PROTECTED = 5;
    public static final int SYMBOL_FILE_VIDEO_CORRUPT = 6;
    public static final int SYMBOL_FILE_VIDEO_DEADLINK = 7;
    public static final int SYMBOL_FILE_PLAYLIST = 8;
    public static final int SYMBOL_FILE_DEFAULT = 9;
    public static final int SYMBOL_FOLDER = 10;
    public static final int SYMBOL_FOLDER_EMPTY = 11;
    public static final int SYMBOL_FOLDER_PLAYLISTS = 12;
    public static final int SYMBOL_FOLDER_ARTIST = 13;
    public static final int SYMBOL_FOLDER_ARTISTS = 14;
    public static final int SYMBOL_FOLDER_ALBUM = 15;
    public static final int SYMBOL_FOLDER_ALBUMS = 16;
    public static final int SYMBOL_FOLDER_SONGS = 17;
    public static final int SYMBOL_FOLDER_GENRE = 18;
    public static final int SYMBOL_FOLDER_GENRES = 19;
    public static final int SYMBOL_FOLDER_COMPOSER = 20;
    public static final int SYMBOL_FOLDER_COMPOSERS = 21;
    public static final int SYMBOL_FOLDER_AUDIO = 22;
    public static final int SYMBOL_FOLDER_VIDEO = 23;
    public static final int SYMBOL_FOLDER_VOICEMEMOS = 24;
    public static final int SYMBOL_FOLDER_AUDIOBOOK = 25;
    public static final int SYMBOL_FOLDER_AUDIOBOOKS = 26;
    public static final int SYMBOL_FOLDER_PODCAST = 27;
    public static final int SYMBOL_FOLDER_PODCASTS = 28;
    public static final int SYMBOL_FOLDER_ALL = 29;
    public static final int SYMBOL_FOLDER_PLAYLIST = 30;
    public static final int SYMBOL_VOICEMEMO = 31;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS0 = 32;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS1 = 33;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS2 = 34;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS3 = 35;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS4 = 36;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS5 = 37;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_MOST_PLAYED = 38;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_LAST_PLAYED_FOLDER = 39;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_ON_THE_GO = 40;
    public static final int SYMBOL_FOLDER_DYN_PLAYLISTS = 41;
    public static final int SYMBOL_FOLDER_VARIOUS_ARTISTS = 42;
    public static final int SYMBOL_FOLDER_MUSIC_VIDEOS = 43;
    public static final int SYMBOL_FOLDER_MOVIES = 44;
    public static final int SYMBOL_FOLDER_RENTED_MOVIES = 45;
    public static final int SYMBOL_FOLDER_TV_SHOWS = 46;
    public static final int SYMBOL_FOLDER_VIDEO_PLAYLISTS = 47;
    public static final int SYMBOL_FOLDER_VIDEO_PODCASTS = 48;
    public static final int SYMBOL_FOLDER_NOT_PLAYABLE = 49;
    public static final int SYMBOL_PLAYLIST_NO_ICON = 50;
    public static final int SYMBOL_ITUNES_RADIO = 51;
    public static final int DISABLE_STATE_NONE = 0;
    public static final int DISABLE_STATE_PROTECTED = 1;
    public static final int DISABLE_STATE_CORRUPT = 2;
    public static final int DISABLE_STATE_DEADLINK = 3;
    public static final int DISABLE_STATE_NO_ENTRIES = 4;
    public static final int DISABLE_STATE_ONLINE_ENTRY_NO_CONNECTION = 5;
    public static final int ONLINE_STATE_NONE = 0;
    public static final int ONLINE_STATE_CLOUD = 1;
    private static final IntMap SYMBOLI18NMAP = new IntMap(40);
    private final int entryContentType;

    public AbstractMediaBrowserListRow(long l, int n, int n2, int n3) {
        super(n, l, n3);
        this.entryContentType = n2;
    }

    public AbstractMediaBrowserListRow(AbstractMediaBrowserListRow abstractMediaBrowserListRow) {
        super(abstractMediaBrowserListRow);
        this.entryContentType = abstractMediaBrowserListRow.getEntryContentType();
    }

    public abstract int getSymbol();

    public abstract boolean isFolder();

    public abstract MediaListEntry getFolderMediaEntry();

    public abstract boolean isFile();

    public abstract I18NString getTitle();

    public final int getEntryContentType() {
        return this.entryContentType;
    }

    public boolean equals(Object object) {
        try {
            AbstractMediaBrowserListRow abstractMediaBrowserListRow = (AbstractMediaBrowserListRow)object;
            return this.getEntryID() == abstractMediaBrowserListRow.getEntryID() && this.getEntryContentType() == abstractMediaBrowserListRow.getEntryContentType();
        }
        catch (Exception exception) {
            return false;
        }
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isListEntry(MediaListEntry mediaListEntry) {
        if (mediaListEntry == null) {
            return false;
        }
        return this.getEntryID() == mediaListEntry.getEntryID() && this.getEntryContentType() == mediaListEntry.getContentType();
    }

    public boolean isPlayListContent() {
        return false;
    }

    public static int getSymbolOfI18NKey(int n) {
        try {
            return SYMBOLI18NMAP.get(n);
        }
        catch (NoMapElementException noMapElementException) {
            return 10;
        }
    }

    static {
        SYMBOLI18NMAP.put(5, 16);
        SYMBOLI18NMAP.put(2, 14);
        SYMBOLI18NMAP.put(18, 29);
        SYMBOLI18NMAP.put(16, 26);
        SYMBOLI18NMAP.put(11, 21);
        SYMBOLI18NMAP.put(26, 39);
        SYMBOLI18NMAP.put(25, 38);
        SYMBOLI18NMAP.put(27, 40);
        SYMBOLI18NMAP.put(19, 32);
        SYMBOLI18NMAP.put(20, 33);
        SYMBOLI18NMAP.put(21, 34);
        SYMBOLI18NMAP.put(22, 35);
        SYMBOLI18NMAP.put(23, 36);
        SYMBOLI18NMAP.put(24, 37);
        SYMBOLI18NMAP.put(28, 41);
        SYMBOLI18NMAP.put(8, 19);
        SYMBOLI18NMAP.put(12, 22);
        SYMBOLI18NMAP.put(1, 12);
        SYMBOLI18NMAP.put(33, 17);
        SYMBOLI18NMAP.put(6, 15);
        SYMBOLI18NMAP.put(7, 16);
        SYMBOLI18NMAP.put(3, 13);
        SYMBOLI18NMAP.put(4, 14);
        SYMBOLI18NMAP.put(9, 18);
        SYMBOLI18NMAP.put(10, 19);
        SYMBOLI18NMAP.put(50, 20);
        SYMBOLI18NMAP.put(51, 21);
        SYMBOLI18NMAP.put(30, 42);
        SYMBOLI18NMAP.put(13, 23);
        SYMBOLI18NMAP.put(37, 23);
        SYMBOLI18NMAP.put(32, 23);
        SYMBOLI18NMAP.put(31, 23);
        SYMBOLI18NMAP.put(34, 23);
        SYMBOLI18NMAP.put(15, 23);
        SYMBOLI18NMAP.put(36, 28);
        SYMBOLI18NMAP.put(17, 28);
        SYMBOLI18NMAP.put(35, 12);
        SYMBOLI18NMAP.put(38, 49);
    }
}

