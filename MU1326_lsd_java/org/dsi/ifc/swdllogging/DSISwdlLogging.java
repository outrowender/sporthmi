/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdllogging;

import org.dsi.ifc.base.DSIBase;

public interface DSISwdlLogging
extends DSIBase {
    public static final String VERSION = "2.11.2";
    public static final int UNUSUALEVENT_NOT_INITIALIZED = 0;
    public static final int UNUSUALEVENT_USER_ABORTED_THIS_DEVICE = 256;
    public static final int UNUSUALEVENT_USER_ABORTED_COMPLETLY = 257;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_DEVICEERROR = 258;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_DEVICEERROR = 259;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_SWITCH_MEDIUM = 260;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_SWITCH_MEDIUM = 261;
    public static final int UNUSUALEVENT_USERABORTED_AFTER_EXPORT_DATA = 262;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_EXPORT_DATA = 263;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_IMPORT_DATA = 264;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_IMPORT_DATA = 265;
    public static final int UNUSUALEVENT_USER_ABORTED_AFTER_READ_METAINFO = 266;
    public static final int UNUSUALEVENT_USER_RETRIED_AFTER_READ_METAINFO = 267;
    public static final int UNUSUALEVENT_BEM_HIGHLY_CRITICAL = 272;
    public static final int UNUSUALEVENT_BEM_MEDIUM_CRITICAL = 273;
    public static final int UNUSUALEVENT_BEM_BACK_TO_UNCRITICAL = 274;
    public static final int UNUSUALEVENT_DEVICE_NOT_IN_DLMODE = 288;
    public static final int UNUSUALEVENT_DEVICE_DEAD = 289;
    public static final int UNUSUALEVENT_DEVICE_NOTFIES_TOO_LATE = 290;
    public static final int UNUSUALEVENT_DEVICE_IS_ALIVE = 291;
    public static final int UNUSUALEVENT_DEVICE_ABORT_MAX_TIME = 294;
    public static final int UNUSUALEVENT_CD_ERROR_RETRY = 304;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_MISSING_RETRY = 305;
    public static final int UNUSUALEVENT_CD_ERROR_INTERNAL_RETRY = 306;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_FAILED_RETRY = 307;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_DATA_CD_RETRY = 308;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_CD_RETRY = 309;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNLOAD_RETRY = 310;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DRIVE_ERROR_RETRY = 311;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOT_READABLE_RETRY = 312;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_INFO_RETRY = 313;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INTERNAL_RETRY = 314;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOT_FOUND_RETRY = 315;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DIR_NOT_FOUND_RETRY = 316;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNKNOWN_RETRY = 317;
    public static final int UNUSUALEVENT_CD_ERROR_ABORT = 318;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_MISSING_ABORT = 319;
    public static final int UNUSUALEVENT_CD_ERROR_INTERNAL_ABORT = 320;
    public static final int UNUSUALEVENT_CD_ERROR_CRC_FAILED_ABORT = 321;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_DATA_CD_ABORT = 322;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_CD_ABORT = 323;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNLOAD_ABORT = 324;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DRIVE_ERROR_ABORT = 325;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOT_READABLE_ABORT = 326;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_INFO_ABORT = 327;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INTERNAL_ABORT = 328;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOT_FOUND_ABORT = 329;
    public static final int UNUSUALEVENT_CD_ERROR_FS_DIR_NOT_FOUND_ABORT = 330;
    public static final int UNUSUALEVENT_CD_ERROR_FS_UNKNOWN_ABORT = 331;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NO_CD_AUTO_RETRY = 332;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOT_FOUND_AUTORETRY = 333;
    public static final int UNUSUALEVENT_ERROR_INIT_INFLATE_RETRY = 334;
    public static final int UNUSUALEVENT_ERROR_INIT_INFLATE_ABORT = 335;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_READING_RETRY = 336;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_OPENIN_GRETRY = 337;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_READING_ABORT = 338;
    public static final int UNUSUALEVENT_ERROR_CD_TIMEOUT_OPENING_ABORT = 339;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOTOPENRETRY = 340;
    public static final int UNUSUALEVENT_CD_ERROR_FS_FILE_NOTOPENABORT = 341;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_NOINFORETRY = 342;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_NOINFOABORT = 343;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_GENERALRETRY = 344;
    public static final int UNUSUALEVENT_CD_ERROR_FS_NOTFOUND_GENERALABORT = 345;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_RETRY = 346;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_ABORT = 347;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNRETRY = 348;
    public static final int UNUSUALEVENT_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNABORT = 349;
    public static final int UNUSUALEVENT_CD_ERROR_FS_SEEK_RETRY = 350;
    public static final int UNUSUALEVENT_CD_ERROR_FS_SEEK_ABORT = 351;
    public static final int UNUSUALEVENT_SERVER_NOTAVAILABLERETRY = 384;
    public static final int UNUSUALEVENT_SERVER_NOTAVAILABLEABORT = 385;
    public static final int UNUSUALEVENT_ERROR_EXPORT_DATA = 389;
    public static final int UNUSUALEVENT_ERROR_IMPORT_DATA = 390;
    public static final int UNUSUALEVENT_ERROR_READ_METAINFO = 391;
    public static final int UNUSUALEVENT_SWITCH_MEDIUM = 400;
    public static final int UNUSUALEVENT_ERROR_FINISH_VERSION_UPDATE = 405;
    public static final int UNUSUALEVENT_VERSION_UPDATE_ABORTED = 406;
    public static final int UNUSUALEVENT_DEVICEERROR = 512;
    public static final int UNUSUALEVENT_UNKNOWN = 65535;
    public static final int RT_GETHISTORY = 1000;
    public static final int RT_SETUPDATE = 1001;
    public static final int RT_SELECTSUBUPDATE = 1002;
    public static final int RT_GETGENERALINFORMATION = 1003;
    public static final int RT_GETUNUSUALEVENTS = 1004;
    public static final int RT_GETUNUSUALEVENT = 1005;
    public static final int RP_GETHISTORY = 2000;
    public static final int RP_SETUPDATE = 2001;
    public static final int RP_GETGENERALINFORMATION = 2002;
    public static final int RP_GETUNUSUALEVENTS = 2003;
    public static final int RP_GETUNUSUALEVENT = 2004;

    public void getHistory();

    public void setUpdate(String var1);

    public void selectSubUpdate(int var1);

    public void getGeneralInformation();

    public void getUnusualEvents();

    public void getUnusualEvent(int var1);
}

