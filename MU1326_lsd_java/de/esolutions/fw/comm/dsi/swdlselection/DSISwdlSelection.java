/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlselection;

public interface DSISwdlSelection {
    public static final String IPL_COMM_UUID = "642703f2-5649-59cc-95fe-3b8d2ad2e820";
    public static final String IPL_COMM_INTERFACE_KEY = "c6768a13-1a4f-5901-8238-db0905b4ccff";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.12";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.12";

    public static interface Consts {
        public static final String VERSION = "2.11.12";
        public static final int RELEASERESULT_NOT_INITIALIZED = 0;
        public static final int RELEASERESULT_OK = 1;
        public static final int RELEASERESULT_ERROR_OPEN = 2;
        public static final int RELEASERESULT_ERROR_READ = 3;
        public static final int RELEASERESULT_ERROR_PARSE = 4;
        public static final int RELEASERESULT_ERROR_SIGNATURE = 5;
        public static final int RELEASERESULT_ERROR_CRC = 6;
        public static final int RELEASERESULT_ERROR_NO_RELEASES = 7;
        public static final int RELEASERESULT_ERROR_MEDIUM_UNAVAILABLE = 8;
        public static final int RELEASERESULT_ERROR_VARIANT = 9;
        public static final int RELEASERESULT_ERROR_REGION = 10;
        public static final int RELEASERESULT_ERROR_MEMORY = 11;
        public static final int RELEASERESULT_ERROR_DOWNLOAD_ACTIVE = 12;
        public static final int RELEASERESULT_ERROR_NO_RSE_SWDL = 13;
        public static final int RELEASERESULT_ERROR_MOUNT_ERROR_CIFS_DOMAIN_USER = 14;
        public static final int RELEASERESULT_ERROR_PARSING_MU_FILE = 15;
        public static final int RELEASERESULT_ERROR_AUTORUN_ACTIVE = 16;
        public static final int RELEASERESULT_ERROR_TEST_ACTIVE = 17;
        public static final int RELEASERESULT_ERROR_BLOCKED_TRAIN = 18;
        public static final int METAINFORESULT_NOT_INITIALIZED = 0;
        public static final int METAINFORESULT_OK = 1;
        public static final int METAINFORESULT_ERROR_OPEN_METAINFO = 2;
        public static final int METAINFORESULT_ERROR_READ = 3;
        public static final int METAINFORESULT_ERROR_PARSE = 4;
        public static final int METAINFORESULT_ERROR_SIGNATURE = 5;
        public static final int METAINFORESULT_ERROR_CRC = 6;
        public static final int METAINFORESULT_ERROR_REGION = 7;
        public static final int METAINFORESULT_ERROR_MEDIUM_UNAVAILABLE = 8;
        public static final int METAINFORESULT_ERROR_VARIANT = 9;
        public static final int METAINFORESULT_ERROR_CRC_CHANGED = 10;
        public static final int METAINFORESULT_ERROR_DOWNLOAD_ACTIVE = 11;
        public static final int METAINFORESULT_ERROR_WAIT_FOR_RSU_VERSIONS_EXPIRED = 12;
        public static final int METAINFORESULT_ERRORR_WRONG_MU_RING_TYPE = 13;
        public static final int METAINFORESULT_ERROR_BLOCKED_TRAIN = 14;
        public static final int MEDIUM_NOT_INITIALIZED = 0;
        public static final int MEDIUM_NFS = 1;
        public static final int MEDIUM_INTERNAL_DRIVE = 2;
        public static final int MEDIUM_USB_FS = 3;
        public static final int MEDIUM_SD_1 = 4;
        public static final int MEDIUM_SD_2 = 5;
        public static final int MEDIUM_CIFS = 6;
        public static final int MEDIUM_OTA = 7;
        public static final int MEDIUM_FS = 8;
        public static final int CONSISTENCY_NOT_INITIALIZED = 0;
        public static final int CONSISTENCY_OK = 1;
        public static final int CONSISTENCY_IMAGE_LAYOUT = 2;
        public static final int CONSISTENCY_APP_DEAD = 4;
        public static final int CONSISTENCY_EMERGENCY_DEAD = 8;
        public static final int CONSISTENCY_IOC_BOLO = 16;
        public static final int CONSISTENCY_USER_SWDL_RUNNING = 32;
        public static final int CONSISTENCY_WINZIP_CORRUPTED = 64;
        public static final int CONSISTENCY_NOT_AUTHENTICATED = 128;
        public static final int CONSISTENCY_INSUFFICIENT_SPACE = 256;
        public static final int CONSISTENCY_RSU_UPDATE_RUNNING = 512;
        public static final int CONSISTENCY_RSU_IMAGE_LAYOUT = 1024;
        public static final int CONSISTENCY_RSU_APP_DEAD = 2048;
        public static final int CONSISTENCY_RSU_EMERGENCY_DEAD = 4096;
        public static final int CONSISTENCY_METAINFO = 8192;
        public static final int FINALIZETARGETRESULT_TARGET_INITIALIZED = 0;
        public static final int FINALIZETARGETRESULT_TARGET_OK = 1;
        public static final int FINALIZETARGETRESULT_TARGET_ERROR_SIZE = 2;
        public static final int FINALIZETARGETRESULT_TARGET_ERROR_MOUNT_PATH = 4;
        public static final int FINALIZETARGETRESULT_TARGET_ERROR_GENERAL = 3;
        public static final int UNITTYPES_NOT_INITIALIZED = 0;
        public static final int UNITTYPES_MAINUNIT = 1;
        public static final int UNITTYPES_REARSEATUNIT = 2;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

