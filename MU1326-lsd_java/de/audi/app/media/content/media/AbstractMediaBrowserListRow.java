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
    public static final int SYMBOL_FILE_AUDIO;
    public static final int SYMBOL_FILE_AUDIO_PROTECTED;
    public static final int SYMBOL_FILE_AUDIO_CORRUPT;
    public static final int SYMBOL_FILE_AUDIO_DEADLINK;
    public static final int SYMBOL_FILE_VIDEO;
    public static final int SYMBOL_FILE_VIDEO_PROTECTED;
    public static final int SYMBOL_FILE_VIDEO_CORRUPT;
    public static final int SYMBOL_FILE_VIDEO_DEADLINK;
    public static final int SYMBOL_FILE_PLAYLIST;
    public static final int SYMBOL_FILE_DEFAULT;
    public static final int SYMBOL_FOLDER;
    public static final int SYMBOL_FOLDER_EMPTY;
    public static final int SYMBOL_FOLDER_PLAYLISTS;
    public static final int SYMBOL_FOLDER_ARTIST;
    public static final int SYMBOL_FOLDER_ARTISTS;
    public static final int SYMBOL_FOLDER_ALBUM;
    public static final int SYMBOL_FOLDER_ALBUMS;
    public static final int SYMBOL_FOLDER_SONGS;
    public static final int SYMBOL_FOLDER_GENRE;
    public static final int SYMBOL_FOLDER_GENRES;
    public static final int SYMBOL_FOLDER_COMPOSER;
    public static final int SYMBOL_FOLDER_COMPOSERS;
    public static final int SYMBOL_FOLDER_AUDIO;
    public static final int SYMBOL_FOLDER_VIDEO;
    public static final int SYMBOL_FOLDER_VOICEMEMOS;
    public static final int SYMBOL_FOLDER_AUDIOBOOK;
    public static final int SYMBOL_FOLDER_AUDIOBOOKS;
    public static final int SYMBOL_FOLDER_PODCAST;
    public static final int SYMBOL_FOLDER_PODCASTS;
    public static final int SYMBOL_FOLDER_ALL;
    public static final int SYMBOL_FOLDER_PLAYLIST;
    public static final int SYMBOL_VOICEMEMO;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS0;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS1;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS2;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS3;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS4;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_STARS5;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_MOST_PLAYED;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_LAST_PLAYED_FOLDER;
    public static final int SYMBOL_FOLDER_DYN_PLAYLIST_ON_THE_GO;
    public static final int SYMBOL_FOLDER_DYN_PLAYLISTS;
    public static final int SYMBOL_FOLDER_VARIOUS_ARTISTS;
    public static final int SYMBOL_FOLDER_MUSIC_VIDEOS;
    public static final int SYMBOL_FOLDER_MOVIES;
    public static final int SYMBOL_FOLDER_RENTED_MOVIES;
    public static final int SYMBOL_FOLDER_TV_SHOWS;
    public static final int SYMBOL_FOLDER_VIDEO_PLAYLISTS;
    public static final int SYMBOL_FOLDER_VIDEO_PODCASTS;
    public static final int SYMBOL_FOLDER_NOT_PLAYABLE;
    public static final int SYMBOL_PLAYLIST_NO_ICON;
    public static final int SYMBOL_ITUNES_RADIO;
    public static final int DISABLE_STATE_NONE;
    public static final int DISABLE_STATE_PROTECTED;
    public static final int DISABLE_STATE_CORRUPT;
    public static final int DISABLE_STATE_DEADLINK;
    public static final int DISABLE_STATE_NO_ENTRIES;
    public static final int DISABLE_STATE_ONLINE_ENTRY_NO_CONNECTION;
    public static final int ONLINE_STATE_NONE;
    public static final int ONLINE_STATE_CLOUD;
    private static final IntMap SYMBOLI18NMAP;
    private final int entryContentType;

    public AbstractMediaBrowserListRow(long l, int n, int n2, int n3) {
        super(n, l, n3);
        this.entryContentType = n2;
    }

    public AbstractMediaBrowserListRow(AbstractMediaBrowserListRow abstractMediaBrowserListRow) {
        super(abstractMediaBrowserListRow);
        this.entryContentType = abstractMediaBrowserListRow.getEntryContentType();
    }

    public abstract int getSymbol() {
    }

    public abstract boolean isFolder() {
    }

    public abstract MediaListEntry getFolderMediaEntry() {
    }

    public abstract boolean isFile() {
    }

    public abstract I18NString getTitle() {
    }

    public final int getEntryContentType() {
        return this.entryContentType;
    }

    @Override
    public boolean equals(Object object) {
        try {
            AbstractMediaBrowserListRow abstractMediaBrowserListRow = (AbstractMediaBrowserListRow)object;
            return this.getEntryID() == abstractMediaBrowserListRow.getEntryID() && this.getEntryContentType() == abstractMediaBrowserListRow.getEntryContentType();
        }
        catch (Exception exception) {
            return false;
        }
    }

    @Override
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
        SYMBOLI18NMAP = new IntMap(40);
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

