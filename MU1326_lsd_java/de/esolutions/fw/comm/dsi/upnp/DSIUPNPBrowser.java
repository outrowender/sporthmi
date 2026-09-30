/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

public interface DSIUPNPBrowser {
    public static final String IPL_COMM_UUID = "8d35f5b4-3fbf-5229-98d1-b7f48f398272";
    public static final String IPL_COMM_INTERFACE_KEY = "4689e104-88c5-580b-8c75-45b23c93e421";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public static interface Consts {
        public static final String VERSION = "2.11.2";
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
        public static final int CONTENTTYPE_SHARED_AUDIO_QUEUE = 21;
        public static final int CONTENTTYPE_DEVICE = 22;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

