/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.i18n;

import de.audi.app.media.content.media.utils.Integers;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;

public class I18NString {
    public static final int KEY_NOT_INTERNATIONALIZED;
    public static final int KEY_PLAYLISTS;
    public static final int KEY_ARTISTS;
    public static final int KEY_UNKNOWN_ARTIST;
    public static final int KEY_UNKNOWN_ARTISTS;
    public static final int KEY_ALBUMS;
    public static final int KEY_UNKNOWN_ALBUM;
    public static final int KEY_UNKNOWN_ALBUMS;
    public static final int KEY_GENRES;
    public static final int KEY_UNKNOWN_GENRE;
    public static final int KEY_UNKNOWN_GENRES;
    public static final int KEY_COMPOSERS;
    public static final int KEY_MUSIC;
    public static final int KEY_VIDEOS;
    public static final int KEY_VOICEMEMOS;
    public static final int KEY_AUDIOBOOKS;
    public static final int KEY_PODCASTS;
    public static final int KEY_ALL;
    public static final int KEY_DYN_PLAYLIST_STARS0;
    public static final int KEY_DYN_PLAYLIST_STARS1;
    public static final int KEY_DYN_PLAYLIST_STARS2;
    public static final int KEY_DYN_PLAYLIST_STARS3;
    public static final int KEY_DYN_PLAYLIST_STARS4;
    public static final int KEY_DYN_PLAYLIST_STARS5;
    public static final int KEY_DYN_PLAYLIST_MOST_PLAYED;
    public static final int KEY_DYN_PLAYLIST_LAST_PLAYED;
    public static final int KEY_DYN_PLAYLIST_ON_THE_GO;
    public static final int KEY_DYN_PLAYLISTS;
    public static final int KEY_DYN_PLAYLIST_FAVORITEN;
    public static final int KEY_VARIOUS_ARTISTS;
    public static final int KEY_MUSIC_VIDEOS;
    public static final int KEY_RENTED_MOVIES;
    public static final int KEY_SONGS;
    public static final int KEY_TV_SHOWS;
    public static final int KEY_VIDEO_PLAYLISTS;
    public static final int KEY_VIDEO_PODCASTS;
    public static final int KEY_MOVIES;
    public static final int KEY_NOT_PLAYABLE;
    public static final int KEY_PLAYLISTS_AND_COVERS;
    public static final int KEY_CDDA_TRACK;
    public static final int KEY_DVDV_CHAPTER;
    public static final int KEY_DVDA_AUDIO_TRACK;
    public static final int KEY_DVDV_TITLE;
    public static final int KEY_NOW_PLAYING;
    public static final int KEY_UNKNOWN_TITLE;
    public static final int KEY_ITUNES_UNIVERSITY;
    public static final int KEY_GENIUS_PLAYLISTS;
    public static final int KEY_DYN_PLAYLIST_LAST_COPIED;
    public static final int KEY_RADIOS;
    public static final int KEY_UNKNOWN_COMPOSER;
    public static final int KEY_UNKNOWN_COMPOSERS;
    private static final int KEY_MAX_VALUES;
    public static final I18NString EMPTY_I18N_STRING;
    private static final Map KEYMAP;
    private final String i18nString;
    private final int i18nKey;
    private final String originalString;

    public I18NString(String string, boolean bl) {
        if (!bl || string == null) {
            this.i18nKey = 0;
            if (string == null) {
                this.i18nString = "";
                this.originalString = "";
            } else {
                this.i18nString = string;
                this.originalString = string;
            }
            return;
        }
        this.originalString = string;
        int n = string.indexOf(32);
        if (n == -1) {
            Integer n2 = (Integer)KEYMAP.get(string);
            if (n2 == null) {
                this.i18nKey = 0;
                this.i18nString = string;
            } else {
                this.i18nKey = n2;
                this.i18nString = "";
            }
            return;
        }
        String string2 = string.substring(0, n);
        Integer n3 = (Integer)KEYMAP.get(string2);
        if (n3 == null) {
            this.i18nKey = 0;
            this.i18nString = string;
            return;
        }
        this.i18nKey = n3;
        this.i18nString = string.substring(n + 1, string.length());
    }

    public static String getOriginalString(String string, int n) {
        if (0 != n) {
            Iterator iterator = KEYMAP.entrySet().iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                if ((Integer)map$Entry.getValue() != n) continue;
                return (String)map$Entry.getKey();
            }
        }
        return string;
    }

    public int getI18NKey() {
        return this.i18nKey;
    }

    public boolean isInternationalized() {
        return this.i18nKey != 0;
    }

    public String getI18NString() {
        return this.i18nString;
    }

    public String getOriginalString() {
        return this.originalString;
    }

    public boolean isEmpty() {
        return !this.isInternationalized() && this.getI18NString().length() == 0;
    }

    public String toString() {
        Buffer buffer = new Buffer(60);
        buffer.append("[");
        if (this.isInternationalized()) {
            buffer.append("'");
            buffer.append(this.i18nKey);
            buffer.append("','");
            buffer.append(this.getI18NString());
            buffer.append("'");
        } else {
            buffer.append("'");
            buffer.append(this.getI18NString());
        }
        buffer.append("']");
        return buffer.toString();
    }

    static {
        EMPTY_I18N_STRING = new I18NString("", false);
        KEYMAP = new HashMap(52);
        KEYMAP.put("cdda.track", Integers.valueOf(40));
        KEYMAP.put("dvdv.chapter", Integers.valueOf(41));
        KEYMAP.put("dvdv.title", Integers.valueOf(43));
        KEYMAP.put("dvda.track", Integers.valueOf(42));
        KEYMAP.put("filterCriteria.albums", Integers.valueOf(5));
        KEYMAP.put("filterCriteria.all", Integers.valueOf(18));
        KEYMAP.put("filterCriteria.artists", Integers.valueOf(2));
        KEYMAP.put("filterCriteria.audiobooks", Integers.valueOf(16));
        KEYMAP.put("filterCriteria.composers", Integers.valueOf(11));
        KEYMAP.put("filterCriteria.dynPlaylists", Integers.valueOf(28));
        KEYMAP.put("filterCriteria.dynPlaylistLastPlayed", Integers.valueOf(26));
        KEYMAP.put("filterCriteria.dynPlaylistMostPlayed", Integers.valueOf(25));
        KEYMAP.put("filterCriteria.dynPlaylistOnTheGo", Integers.valueOf(27));
        KEYMAP.put("filterCriteria.dynPlaylistStars0", Integers.valueOf(19));
        KEYMAP.put("filterCriteria.dynPlaylistStars1", Integers.valueOf(20));
        KEYMAP.put("filterCriteria.dynPlaylistStars2", Integers.valueOf(21));
        KEYMAP.put("filterCriteria.dynPlaylistStars3", Integers.valueOf(22));
        KEYMAP.put("filterCriteria.dynPlaylistStars4", Integers.valueOf(23));
        KEYMAP.put("filterCriteria.dynPlaylistStars5", Integers.valueOf(24));
        KEYMAP.put("filterCriteria.dynPlaylistFavorites", Integers.valueOf(29));
        KEYMAP.put("filterCriteria.variousArtists", Integers.valueOf(30));
        KEYMAP.put("filterCriteria.genres", Integers.valueOf(8));
        KEYMAP.put("filterCriteria.music", Integers.valueOf(12));
        KEYMAP.put("filterCriteria.musicVideos", Integers.valueOf(31));
        KEYMAP.put("filterCriteria.playlists", Integers.valueOf(1));
        KEYMAP.put("filterCriteria.podcasts", Integers.valueOf(17));
        KEYMAP.put("filterCriteria.rentedMovies", Integers.valueOf(32));
        KEYMAP.put("filterCriteria.songs", Integers.valueOf(33));
        KEYMAP.put("filterCriteria.tvShows", Integers.valueOf(34));
        KEYMAP.put("filterCriteria.unknownAlbum", Integers.valueOf(6));
        KEYMAP.put("filterCriteria.unknownAlbums", Integers.valueOf(7));
        KEYMAP.put("filterCriteria.unknownArtist", Integers.valueOf(3));
        KEYMAP.put("filterCriteria.unknownArtists", Integers.valueOf(4));
        KEYMAP.put("filterCriteria.unknownGenre", Integers.valueOf(9));
        KEYMAP.put("filterCriteria.unknownGenres", Integers.valueOf(10));
        KEYMAP.put("filterCriteria.videos", Integers.valueOf(13));
        KEYMAP.put("filterCriteria.videoPlaylists", Integers.valueOf(35));
        KEYMAP.put("filterCriteria.videoPodcasts", Integers.valueOf(36));
        KEYMAP.put("filterCriteria.voicememos", Integers.valueOf(15));
        KEYMAP.put("filterCriteria.movies", Integers.valueOf(37));
        KEYMAP.put("filterCriteria.notPlayable", Integers.valueOf(38));
        KEYMAP.put("copyRunningMain.progressPlaylistsCovers", Integers.valueOf(39));
        KEYMAP.put("filterCriteria.nowPlaying", Integers.valueOf(44));
        KEYMAP.put("filterCriteria.unknownTitle", Integers.valueOf(45));
        KEYMAP.put("filterCriteria.itunesU", Integers.valueOf(46));
        KEYMAP.put("filterCriteria.geniusPlaylists", Integers.valueOf(47));
        KEYMAP.put("filterCriteria.dynPlaylistLastCopied", Integers.valueOf(48));
        KEYMAP.put("filterCriteria.itunesRadio", Integers.valueOf(49));
        KEYMAP.put("filterCriteria.unknownComposer", Integers.valueOf(50));
        KEYMAP.put("filterCriteria.unknownComposers", Integers.valueOf(51));
    }
}

