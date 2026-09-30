/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

public interface DSIMediaBrowser {
    public static final String IPL_COMM_UUID = "1bd5924e-e807-5b32-b705-039ed68a859a";
    public static final String IPL_COMM_INTERFACE_KEY = "511a36ee-5c16-5d07-8f8b-2c59d03e04c4";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public static interface Consts {
        public static final String VERSION = "2.11.52";
        public static final int BROWSERID_1 = 0;
        public static final int BROWSERID_2 = 1;
        public static final int BROWSERID_3 = 2;
        public static final int BROWSERID_4 = 3;
        public static final int BROWSERID_5 = 4;
        public static final int BROWSERID_6 = 5;
        public static final int BROWSERID_7 = 6;
        public static final int BROWSERID_RECORDER = 7;
        public static final int MEDIATAGTYPE_ALBUM = 1;
        public static final int MEDIATAGTYPE_GENRE = 2;
        public static final int MEDIATAGTYPE_ARTIST = 3;
        public static final int MEDIATAGTYPE_TITLE = 4;
        public static final int MEDIATAGTYPE_VIDEO = 5;
        public static final int MEDIATAGTYPE_FILENAME = 6;
        public static final int MEDIATAGTYPE_FOLDER = 7;
        public static final int LISTSIZEFLAG_NONE = 0;
        public static final int ENTRYFLAG_NOENTRIES = 1;
        public static final int ENTRYFLAG_DRM = 2;
        public static final int ENTRYFLAG_CORRUPT = 4;
        public static final int ENTRYFLAG_DEADLINK = 8;
        public static final int ENTRYFLAG_INTERNATIONALIZABLE = 16;
        public static final int ENTRYFLAG_SELECTED = 32;
        public static final int ENTRYFLAG_PARTLY_SELECTED = 64;
        public static final int ENTRYFLAG_IMPORT_RUNNING = 128;
        public static final int ENTRYFLAG_IMPORT_PENDING = 256;
        public static final int ENTRYFLAG_IMPORT_NOT_PLAYABLE = 512;
        public static final int ENTRYFLAG_ALREADY_IMPORTED = 1024;
        public static final int ENTRYFLAG_PARTLY_IMPORTED = 2048;
        public static final int ENTRYFLAG_FAVORITE = 4096;
        public static final int ENTRYFLAG_ONLINE = 8192;
        public static final int BROWSEMODE_RAW = 0;
        public static final int BROWSEMODE_CONTENT = 1;
        public static final int CONTENTTYPE_UNKNOWN = 0;
        public static final int CONTENTTYPE_AUDIO = 1;
        public static final int CONTENTTYPE_VIDEO = 2;
        public static final int CONTENTTYPE_IMAGE = 3;
        public static final int CONTENTTYPE_FOLDER = 4;
        public static final int CONTENTTYPE_PLAYLIST = 5;
        public static final int CONTENTTYPE_PLAYLIST_FOLDER = 6;
        public static final int CONTENTTYPE_AUDIO_FOLDER = 7;
        public static final int CONTENTTYPE_VIDEO_FOLDER = 8;
        public static final int CONTENTTYPE_IMAGE_FOLDER = 9;
        public static final int CONTENTTYPE_DYNAMIC_PLAYLIST = 10;
        public static final int CONTENTTYPE_PODCAST_FOLDER = 11;
        public static final int CONTENTTYPE_SELECTCONTROL = 12;
        public static final int CONTENTTYPE_ARTIST_FOLDER = 13;
        public static final int CONTENTTYPE_ALBUM_FOLDER = 14;
        public static final int CONTENTTYPE_TITLE_FOLDER = 15;
        public static final int CONTENTTYPE_GENRE_FOLDER = 16;
        public static final int CONTENTTYPE_COMPOSER_FOLDER = 17;
        public static final int CONTENTTYPE_AUDIOBOOK_FOLDER = 18;
        public static final int CONTENTTYPE_NOTPLAYABLE_FOLDER = 19;
        public static final int CONTENTTYPE_FAVORITE_FOLDER = 20;
        public static final int SELECTIONSTATE_NONE = 0;
        public static final int SELECTIONSTATE_ALL = 1;
        public static final int SELECTIONSTATE_PARTIAL = 2;
        public static final int SELECTIONRANGE_INDEX = 0;
        public static final int SELECTIONRANGE_ALL = 1;
        public static final int SELECTIONRESULT_OK = 0;
        public static final int SELECTIONRESULT_JUKEBOX_FULL = 1;
        public static final int SELECTIONRESULT_LIBRARY_DB_FULL = 2;
        public static final int SELECTIONRESULT_NOK = 3;
        public static final int SEARCHSPELLERCRITERIA_ALBUM = 1;
        public static final int SEARCHSPELLERCRITERIA_ARTIST = 2;
        public static final int SEARCHSPELLERCRITERIA_TITLE = 4;
        public static final int SEARCHSPELLERCRITERIA_FILENAME = 8;
        public static final int SEARCHSPELLERCRITERIA_FOLDER = 16;
        public static final int SEARCHSPELLERSTATE_UNKNOWN = 0;
        public static final int SEARCHSPELLERSTATE_SEARCHING = 1;
        public static final int SEARCHSPELLERSTATE_WAITING = 2;
        public static final int SEARCHSPELLERSTATE_SEARCHNOTPOSSIBLE = 3;
        public static final int CONTENTFILTER_AUDIO = 1;
        public static final int CONTENTFILTER_VIDEO = 2;
        public static final int CONTENTFILTER_PLAYLIST = 4;
        public static final int CONTENTFILTER_PICTURE = 8;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

