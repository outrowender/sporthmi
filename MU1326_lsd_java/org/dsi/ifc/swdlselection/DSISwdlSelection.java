/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlselection;

import org.dsi.ifc.base.DSIBase;

public interface DSISwdlSelection
extends DSIBase {
    public static final String VERSION = "2.11.12";
    public static final int ATTR_LAMECLIENTS = 1;
    public static final int ATTR_ENGINEERING = 2;
    public static final int ATTR_USERSWDL = 3;
    public static final int ATTR_RINGNOTOK = 4;
    public static final int ATTR_ENDDOWNLOAD = 5;
    public static final int ATTR_AVAILABLEMEDIA = 6;
    public static final int ATTR_UNITTYPE = 7;
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
    public static final int RT_SETUSERSWDL = 1000;
    public static final int RT_SETGOTFOCUS = 1001;
    public static final int RT_GETMEDIA = 1002;
    public static final int RT_STORENFSIPADDRESS = 1003;
    public static final int RT_STORENFSPATH = 1004;
    public static final int RT_SETMEDIUM = 1005;
    public static final int RT_SETRELEASE = 1006;
    public static final int RT_GETUSERDEFINEDALLOWED = 1007;
    public static final int RT_SETINSTALLATIONTYPE = 1008;
    public static final int RT_SETTARGETLANGUAGE = 1009;
    public static final int RT_GETINCOMPATIBLEDEVICES = 1010;
    public static final int RT_STARTDOWNLOAD = 1012;
    public static final int RT_CREATECRITICALUNLOCK = 1013;
    public static final int RT_ABORTVERSIONUPLOAD = 1014;
    public static final int RT_ENDVERSIONUPLOAD = 1015;
    public static final int RT_STORECIFSSERVER = 1016;
    public static final int RT_STORECIFSPATH = 1017;
    public static final int RT_STORECIFSUSER = 1018;
    public static final int RT_STORECIFSPASSWORD = 1019;
    public static final int RT_STOREFSPATH = 1021;
    public static final int RT_CHECKCONSISTENCY = 1026;
    public static final int RT_ABORTSETMEDIUM = 1028;
    public static final int RT_ABORTSETRELEASE = 1029;
    public static final int RT_GETFINALIZETARGETS = 1030;
    public static final int RT_SETFINALIZETARGET = 1031;
    public static final int RT_STARTVERSIONUPLOAD = 1032;
    public static final int RT_ENTERCOMPONENTUPDATECONFIRMATION = 1033;
    public static final int RP_GETMEDIA = 2000;
    public static final int RP_STORENFSIPADDRESS = 2001;
    public static final int RP_SETMEDIUM = 2002;
    public static final int RP_SETRELEASE = 2003;
    public static final int RP_GETUSERDEFINEDALLOWED = 2004;
    public static final int RP_SETTARGETLANGUAGE = 2005;
    public static final int RP_GETINCOMPATIBLEDEVICES = 2006;
    public static final int RP_STARTVERSIONUPLOAD = 2008;
    public static final int RP_CHECKCONSISTENCY = 2014;
    public static final int RP_ABORTSETMEDIUM = 2015;
    public static final int RP_ABORTSETRELEASE = 2016;
    public static final int RP_GETFINALIZETARGETS = 2017;
    public static final int RP_SETFINALIZETARGET = 2018;
    public static final int RP_STOREFSPATH = 2019;
    public static final int RP_STORENFSPATH = 2020;
    public static final int RP_ENTERCOMPONENTUPDATECONFIRMATION = 2021;

    public void setUserSwdl(boolean var1);

    public void setGotFocus(boolean var1);

    public void getMedia();

    public void storeNfsIpAddress(String var1);

    public void storeNfsPath(String var1);

    public void setMedium(int var1);

    public void setRelease(long var1);

    public void getUserDefinedAllowed();

    public void setInstallationType(boolean var1);

    public void setTargetLanguage(short var1);

    public void getIncompatibleDevices();

    public void startDownload();

    public void createCriticalUnlock();

    public void startVersionUpload();

    public void abortVersionUpload();

    public void endVersionUpload();

    public void storeCifsServer(String var1);

    public void storeCifsPath(String var1);

    public void storeCifsUser(String var1);

    public void storeCifsPassword(String var1);

    public void storeFsPath(String var1);

    public void checkConsistency();

    public void abortSetMedium();

    public void abortSetRelease();

    public void getFinalizeTargets();

    public void setFinalizeTarget(int var1);

    public void enterComponentUpdateConfirmation(boolean var1);
}

