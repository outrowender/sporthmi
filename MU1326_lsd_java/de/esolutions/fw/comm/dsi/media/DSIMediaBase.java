/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

public interface DSIMediaBase {
    public static final String IPL_COMM_UUID = "2d578e68-b367-54c4-8775-ff89f7374613";
    public static final String IPL_COMM_INTERFACE_KEY = "7f8e1e0e-11f2-5c08-902f-c7079a3ec8e8";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public static interface Consts {
        public static final String VERSION = "2.11.52";
        public static final int DEVICETYPE_JUKEBOX = 0;
        public static final int DEVICETYPE_SD = 1;
        public static final int DEVICETYPE_USB = 2;
        public static final int DEVICETYPE_DVDINT = 3;
        public static final int DEVICETYPE_CDINT = 4;
        public static final int DEVICETYPE_CDC = 5;
        public static final int DEVICETYPE_DVDC = 6;
        public static final int DEVICETYPE_AUX = 8;
        public static final int DEVICETYPE_WLAN = 9;
        public static final int DEVICETYPE_BT = 10;
        public static final int DEVICETYPE_FILEPLAYER = 12;
        public static final int DEVICETYPE_BDINT = 13;
        public static final int DEVICEFLAGS_COOPERATIVE = 1;
        public static final int DEVICEFLAGS_EXCLUSIVE = 2;
        public static final int DEVICEFLAGS_ERROR = 4;
        public static final int DEVICEFLAGS_UNAVAILABLE = 8;
        public static final int DEVICEFLAGS_OVERTEMP = 16;
        public static final int DEVICEFLAGS_UNDERTEMP = 32;
        public static final int DEVICEFLAGS_OVERCURRENT = 64;
        public static final int DEVICEFLAGS_LIMITED_FUNCTIONALITY = 128;
        public static final int MEDIAFLAG_NOPLAYABLEFILES = 1;
        public static final int MEDIAFLAG_PASS_ALL_COMPLETED = 8;
        public static final int MEDIAFLAG_IMPORT_RUNNING = 16;
        public static final int MEDIAFLAG_INVALID_REGIONCODE = 32;
        public static final int MEDIAFLAG_PML_BLOCKED = 64;
        public static final int MEDIAFLAG_PML_RESTRICTED = 128;
        public static final int MEDIAFLAG_PLAYBACK = 512;
        public static final int MEDIAFLAG_NO_CONTENT = 1024;
        public static final int MEDIAFLAG_COPY_PROTECTED = 4096;
        public static final int MEDIAFLAG_READ_ONLY = 8192;
        public static final int MEDIAFLAG_READY_FOR_RECORDER = 16384;
        public static final int MEDIAFLAG_FIRMWARE_NOT_SUPPORTED = 32768;
        public static final int MEDIAFLAG_PASS_FILESYSTEM_COMPLETED = 65536;
        public static final int MEDIAFLAG_PASS_METADATA_COMPLETED = 131072;
        public static final int MEDIAFLAG_PASS_COVERART_COMPLETED = 262144;
        public static final int MEDIAFLAG_PASS_EXTERNAL_METADATA_COMPLETED = 524288;
        public static final int MEDIAFLAG_DELETION_RUNNING = 0x100000;
        public static final int MEDIAFLAG_LAST_PLAYSELECTION_VALID = 0x400000;
        public static final int MEDIAFLAG_INTERNATIONALIZABLE = 0x800000;
        public static final int MEDIAFLAG_CORRUPTED_PARTITION = 0x1000000;
        public static final int MEDIAFLAG_CHARGING = 0x2000000;
        public static final int MEDIAFLAG_DATABASE_FULL = 0x4000000;
        public static final int MEDIAFLAG_READY_FOR_ALBUMBROWSER = Integer.MIN_VALUE;
        public static final int MEDIATYPE_UNKNOWN = 0;
        public static final int MEDIATYPE_CDAUDIO = 1;
        public static final int MEDIATYPE_DVDAUDIO = 2;
        public static final int MEDIATYPE_DVDVIDEO = 3;
        public static final int MEDIATYPE_CDROM = 5;
        public static final int MEDIATYPE_DVDROM = 6;
        public static final int MEDIATYPE_FILESYSTEM = 7;
        public static final int MEDIATYPE_RAW = 8;
        public static final int MEDIATYPE_RCP = 9;
        public static final int MEDIATYPE_EMPTY = 10;
        public static final int MEDIATYPE_UNREADABLE = 11;
        public static final int MEDIATYPE_LOADING = 12;
        public static final int MEDIATYPE_AUTOMATIC_RELOAD = 13;
        public static final int MEDIATYPE_UNSUPPORTED = 15;
        public static final int MEDIATYPE_UPDATE = 17;
        public static final int MEDIATYPE_FILEPLAYER = 18;
        public static final int MEDIATYPE_NAVIGATIONDATABASE = 19;
        public static final int MEDIATYPE_IPOD = 20;
        public static final int MEDIATYPE_BLURAY = 21;
        public static final int MEDIATYPE_BOARDBOOK = 22;
        public static final int RESETMODE_FACTORYSETTINGS = 1;
        public static final int RESETMODE_DATABASE = 2;
        public static final int RESETMODE_JUKEBOX = 4;
        public static final int RESETMODE_CUSTOMERUPDATE = 8;
        public static final int CUSTOMERUPDATE_UNKNOWN = 0;
        public static final int CUSTOMERUPDATE_NOT_AVAILABLE = 1;
        public static final int CUSTOMERUPDATE_AVAILABLE = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

