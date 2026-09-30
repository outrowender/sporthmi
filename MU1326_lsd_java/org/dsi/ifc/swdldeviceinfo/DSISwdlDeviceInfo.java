/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdldeviceinfo;

import org.dsi.ifc.base.DSIBase;

public interface DSISwdlDeviceInfo
extends DSIBase {
    public static final String VERSION = "2.11.6";
    public static final int ATTR_SUMMARYCHANGED = 1;
    public static final int UPDATEAMOUT_NOT_INITIALIZED = 0;
    public static final int UPDATEAMOUT_YES = 1;
    public static final int UPDATEAMOUT_NO = 2;
    public static final int UPDATEAMOUT_NOT_EXISTING = 3;
    public static final int UPDATEAMOUT_NOT_AVAILABLE = 4;
    public static final int UPDATEAMOUT_PARTIAL = 5;
    public static final int UPDATEAMOUT_INCOMPATIBLE = 6;
    public static final int UPDATEAMOUT_ERROR = 7;
    public static final int UPDATEAMOUT_CORRUPTED = 8;
    public static final int UPDATEAMOUT_NOT_ACTIVATED = 9;
    public static final int UPDATEAMOUT_CHECK_TIMEOUT = 10;
    public static final int UPDATEAMOUT_COMPONENT_NOT_REGISTERED = 11;
    public static final int UPDATEAMOUT_PACKET_ERROR = 12;
    public static final int UPDATEAMOUT_RESULT_ERROR = 13;
    public static final int UPDATEAMOUT_DOWNGRADE = 14;
    public static final int UPDATEAMOUT_GROUP_ERROR = 15;
    public static final int SUMMARYRESULT_NOT_INITIALIZED = 0;
    public static final int SUMMARYRESULT_NO_UPDATE = 1;
    public static final int SUMMARYRESULT_SUCCESS = 2;
    public static final int SUMMARYRESULT_FAILED = 3;
    public static final int SUMMARYRESULT_NEW_MODULE = 4;
    public static final int SUMMARYRESULT_REMOVED_MODULE = 5;
    public static final int DEVICEINFOACCESSTYPE_NOT_INITIALIZED = 0;
    public static final int DEVICEINFOACCESSTYPE_SELECTION = 1;
    public static final int DEVICEINFOACCESSTYPE_SUMMARY = 2;
    public static final int DEVICEINFOACCESSTYPE_PRECONDITION = 3;
    public static final int DEVICEINFOACCESSTYPE_POSTCONDITION = 4;
    public static final int DETAILEDSUMMARYTYPES_NOT_INITIALIZED = 0;
    public static final int DETAILEDSUMMARYTYPES_REMOVED_MODULE = 1;
    public static final int DETAILEDSUMMARYTYPES_INTERNAL_ERROR_EXPECTED_VERSION_IS_SET = 2;
    public static final int DETAILEDSUMMARYTYPES_NEW_MODULE_VERSION = 3;
    public static final int DETAILEDSUMMARYTYPES_NO_UPDATE = 4;
    public static final int DETAILEDSUMMARYTYPES_CDVERSION_0_UNEXPECTED_UPDATE = 5;
    public static final int DETAILEDSUMMARYTYPES_CDVERSION_0 = 6;
    public static final int DETAILEDSUMMARYTYPES_NO_UPDATE_VERSION_UNCHANGED = 7;
    public static final int DETAILEDSUMMARYTYPES_NO_UPDATE_VERSION_CHANGED = 8;
    public static final int DETAILEDSUMMARYTYPES_NEW_MODULE_UPDATE_OK = 9;
    public static final int DETAILEDSUMMARYTYPES_UPDATE_OK = 10;
    public static final int DETAILEDSUMMARYTYPES_NEW_MODULE_UPDATE_FROM_0_OK = 11;
    public static final int DETAILEDSUMMARYTYPES_UPDATE_FROM_0_OK = 12;
    public static final int DETAILEDSUMMARYTYPES_MISSING = 13;
    public static final int DETAILEDSUMMARYTYPES_UNEXPECTED_UPDATE = 14;
    public static final int DETAILEDSUMMARYTYPES_INTERNAL_ERROR = 15;
    public static final int DETAILEDSUMMARYTYPES_NONE = 16;
    public static final int ERROR_NOT_INITIALIZED = 0;
    public static final int ERROR_USER_ABORTED_THIS_DEVICE = 256;
    public static final int ERROR_USER_ABORTED_COMPLETLY = 257;
    public static final int ERROR_USER_ABORTED_AFTER_DEVICEERROR = 258;
    public static final int ERROR_USER_RETRIED_AFTER_DEVICEERROR = 259;
    public static final int ERROR_USER_ABORTED_AFTER_SWITCH_MEDIUM = 260;
    public static final int ERROR_USER_RETRIED_AFTER_SWITCH_MEDIUM = 261;
    public static final int ERROR_USERABORTED_AFTER_EXPORT_DATA = 262;
    public static final int ERROR_USER_RETRIED_AFTER_EXPORT_DATA = 263;
    public static final int ERROR_USER_ABORTED_AFTER_IMPORT_DATA = 264;
    public static final int ERROR_USER_RETRIED_AFTER_IMPORT_DATA = 265;
    public static final int ERROR_USER_ABORTED_AFTER_READ_METAINFO = 266;
    public static final int ERROR_USER_RETRIED_AFTER_READ_METAINFO = 267;
    public static final int ERROR_BEM_HIGHLY_CRITICAL = 272;
    public static final int ERROR_BEM_MEDIUM_CRITICAL = 273;
    public static final int ERROR_BEM_BACK_TO_UNCRITICAL = 274;
    public static final int ERROR_DEVICE_NOT_IN_DLMODE = 288;
    public static final int ERROR_DEVICE_DEAD = 289;
    public static final int ERROR_DEVICE_NOTFIES_TOO_LATE = 290;
    public static final int ERROR_DEVICE_IS_ALIVE = 291;
    public static final int ERROR_DEVICE_ABORT_MAX_TIME = 294;
    public static final int ERROR_CD_ERROR_RETRY = 304;
    public static final int ERROR_CD_ERROR_CRC_MISSING_RETRY = 305;
    public static final int ERROR_CD_ERROR_INTERNAL_RETRY = 306;
    public static final int ERROR_CD_ERROR_CRC_FAILED_RETRY = 307;
    public static final int ERROR_CD_ERROR_FS_NO_DATA_CD_RETRY = 308;
    public static final int ERROR_CD_ERROR_FS_NO_CD_RETRY = 309;
    public static final int ERROR_CD_ERROR_FS_UNLOAD_RETRY = 310;
    public static final int ERROR_CD_ERROR_FS_DRIVE_ERROR_RETRY = 311;
    public static final int ERROR_CD_ERROR_FS_NOT_READABLE_RETRY = 312;
    public static final int ERROR_CD_ERROR_FS_NO_INFO_RETRY = 313;
    public static final int ERROR_CD_ERROR_FS_INTERNAL_RETRY = 314;
    public static final int ERROR_CD_ERROR_FS_FILE_NOT_FOUND_RETRY = 315;
    public static final int ERROR_CD_ERROR_FS_DIR_NOT_FOUND_RETRY = 316;
    public static final int ERROR_CD_ERROR_FS_UNKNOWN_RETRY = 317;
    public static final int ERROR_CD_ERROR_ABORT = 318;
    public static final int ERROR_CD_ERROR_CRC_MISSING_ABORT = 319;
    public static final int ERROR_CD_ERROR_INTERNAL_ABORT = 320;
    public static final int ERROR_CD_ERROR_CRC_FAILED_ABORT = 321;
    public static final int ERROR_CD_ERROR_FS_NO_DATA_CD_ABORT = 322;
    public static final int ERROR_CD_ERROR_FS_NO_CD_ABORT = 323;
    public static final int ERROR_CD_ERROR_FS_UNLOAD_ABORT = 324;
    public static final int ERROR_CD_ERROR_FS_DRIVE_ERROR_ABORT = 325;
    public static final int ERROR_CD_ERROR_FS_NOT_READABLE_ABORT = 326;
    public static final int ERROR_CD_ERROR_FS_NO_INFO_ABORT = 327;
    public static final int ERROR_CD_ERROR_FS_INTERNAL_ABORT = 328;
    public static final int ERROR_CD_ERROR_FS_FILE_NOT_FOUND_ABORT = 329;
    public static final int ERROR_CD_ERROR_FS_DIR_NOT_FOUND_ABORT = 330;
    public static final int ERROR_CD_ERROR_FS_UNKNOWN_ABORT = 331;
    public static final int ERROR_CD_ERROR_FS_NO_CD_AUTO_RETRY = 332;
    public static final int ERROR_CD_ERROR_FS_FILE_NOT_FOUND_AUTORETRY = 333;
    public static final int ERROR_ERROR_INIT_INFLATE_RETRY = 334;
    public static final int ERROR_ERROR_INIT_INFLATE_ABORT = 335;
    public static final int ERROR_ERROR_CD_TIMEOUT_READING_RETRY = 336;
    public static final int ERROR_ERROR_CD_TIMEOUT_OPENIN_GRETRY = 337;
    public static final int ERROR_ERROR_CD_TIMEOUT_READING_ABORT = 338;
    public static final int ERROR_ERROR_CD_TIMEOUT_OPENING_ABORT = 339;
    public static final int ERROR_CD_ERROR_FS_FILE_NOTOPENRETRY = 340;
    public static final int ERROR_CD_ERROR_FS_FILE_NOTOPENABORT = 341;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_NOINFORETRY = 342;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_NOINFOABORT = 343;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_GENERALRETRY = 344;
    public static final int ERROR_CD_ERROR_FS_NOTFOUND_GENERALABORT = 345;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_RETRY = 346;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_ABORT = 347;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNRETRY = 348;
    public static final int ERROR_CD_ERROR_FS_INVALIDHANDLE_UNKNOWNABORT = 349;
    public static final int ERROR_CD_ERROR_FS_SEEK_RETRY = 350;
    public static final int ERROR_CD_ERROR_FS_SEEK_ABORT = 351;
    public static final int ERROR_SERVER_NOTAVAILABLERETRY = 384;
    public static final int ERROR_SERVER_NOTAVAILABLEABORT = 385;
    public static final int ERROR_ERROR_EXPORT_DATA = 389;
    public static final int ERROR_ERROR_IMPORT_DATA = 390;
    public static final int ERROR_ERROR_READ_METAINFO = 391;
    public static final int ERROR_SWITCH_MEDIUM = 400;
    public static final int ERROR_ERROR_FINISH_VERSION_UPDATE = 405;
    public static final int ERROR_VERSION_UPDATE_ABORTED = 406;
    public static final int ERROR_DEVICEERROR = 512;
    public static final int ERROR_UNKNOWN = 65535;
    public static final int DEVICESELECTION_NONE = 0;
    public static final int DEVICESELECTION_ALL = 1;
    public static final int DEVICESELECTION_DEFAULT = 2;
    public static final int RT_SETACCESSTYPE = 1000;
    public static final int RT_GETDEVICES = 1001;
    public static final int RT_GETMODULES = 1003;
    public static final int RT_GETLANGUAGES = 1004;
    public static final int RT_GETERRORS = 1005;
    public static final int RT_ISDATAMODULE = 1007;
    public static final int RT_ISNOEXCLUSIVEBOLOUPDATE = 1008;
    public static final int RT_GETVERSIONS = 1009;
    public static final int RT_GETTARGETVERSIONS = 1010;
    public static final int RT_GETADDITIONALINFO = 1011;
    public static final int RT_TOGGLESELECTION = 1012;
    public static final int RT_GETFILENAMES = 1013;
    public static final int RT_GETFILEDETAILS = 1014;
    public static final int RT_GETINFOFILEPATH = 1015;
    public static final int RT_SETDEVICESELECTION = 1016;
    public static final int RT_GETNUMBEROFPOPUPS = 1017;
    public static final int RT_GETPOPUP = 1018;
    public static final int RP_GETDEVICES = 2000;
    public static final int RP_GETMODULES = 2001;
    public static final int RP_GETLANGUAGES = 2002;
    public static final int RP_GETERRORS = 2003;
    public static final int RP_ISDATAMODULE = 2004;
    public static final int RP_ISNOEXCLUSIVEBOLOUPDATE = 2005;
    public static final int RP_GETVERSIONS = 2006;
    public static final int RP_GETTARGETVERSIONS = 2007;
    public static final int RP_GETADDITIONALINFO = 2008;
    public static final int RP_GETFILENAMES = 2009;
    public static final int RP_GETFILEDETAILS = 2010;
    public static final int RP_GETINFOFILEPATH = 2011;
    public static final int RP_GETNUMBEROFPOPUPS = 2012;
    public static final int RP_GETPOPUP = 2013;

    public void setAccessType(int var1);

    public void getDevices();

    public void getModules(int var1);

    public void getLanguages(int var1);

    public void getErrors(int var1);

    public void isDataModule(int var1, int var2);

    public void isNoExclusiveBoloUpdate(int var1, int var2);

    public void getVersions(int var1, int var2);

    public void getTargetVersions(int var1, int var2);

    public void getAdditionalInfo(int var1, int var2);

    public void toggleSelection(int var1, int var2, short var3);

    public void getFileNames(int var1, int var2);

    public void getFileDetails(int var1, int var2, short var3);

    public void getInfoFilePath(int var1);

    public void setDeviceSelection(int var1, int var2);

    public void getNumberOfPopups();

    public void getPopup(int var1);
}

