/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdlprogress;

import org.dsi.ifc.base.DSIBase;

public interface DSISwdlProgress
extends DSIBase {
    public static final String VERSION = "2.11.6";
    public static final int ATTR_GENERALPROGRESS = 1;
    public static final int ATTR_DEVICESOVERVIEWPROGRESS = 2;
    public static final int ATTR_TRIGGERPANEL = 3;
    public static final int ATTR_LOSTDEVICES = 4;
    public static final int ATTR_OVERVIEWSTATUS = 5;
    public static final int ATTR_ACTIVEDEVICES = 6;
    public static final int PROGRESSSTATUS_NOT_INITIALIZED = 0;
    public static final int PROGRESSSTATUS_NONE = 1;
    public static final int PROGRESSSTATUS_READ_BLOCK = 2;
    public static final int PROGRESSSTATUS_ERASE_FLASH = 3;
    public static final int PROGRESSSTATUS_PROGRAM_FLASH = 4;
    public static final int PROGRESSSTATUS_CALCULATE_CHECKSUM = 5;
    public static final int PROGRESSSTATUS_OPEN_FILE = 6;
    public static final int PROGRESSSTATUS_CLOSE_FILE = 7;
    public static final int PROGRESSSTATUS_USERINFO_TEXT = 8;
    public static final int PROGRESSSTATUS_COPY_FILES = 9;
    public static final int PROGRESSSTATUS_WAIT_FOR_DEVICES_AFTER_UNLOCK = 10;
    public static final int PROGRESSSTATUS_WAIT_FOR_DEVICES_AFTER_UNLOCK_DURING_FLASHTIMEOUT = 11;
    public static final int PROGRESSSTATUS_REPORT_UNLOCK = 12;
    public static final int PROGRESSSTATUS_OPEN_FILE_ANIMATED_DOTS = 13;
    public static final int PROGRESSSTATUS_SWITCH_TO_DOWNLOAD_MODE = 14;
    public static final int PROGRESSSTATUS_DEVICE_REBOOTS = 15;
    public static final int PROGRESSSTATUS_CONTACTING_DEVICE = 16;
    public static final int PROGRESSSTATUS_DELAY_CONTACTING_DEVICE = 17;
    public static final int PROGRESSSTATUS_START_APPLICATIONS = 18;
    public static final int PROGRESSSTATUS_SET_UPDATE_DEVICE = 19;
    public static final int PROGRESSSTATUS_WAIT_FOR_LATE_RECONNECTING = 20;
    public static final int PROGRESSSTATUS_WAIT_FOR_RECONNECTING = 21;
    public static final int PROGRESSSTATUS_FLASHTIMEOUT = 22;
    public static final int FILEACCESSERROR_NOT_INITIALIZED = 0;
    public static final int FILEACCESSERROR_OPEN = 1;
    public static final int FILEACCESSERROR_READ = 2;
    public static final int FILEACCESSERROR_CRC = 3;
    public static final int FILEACCESSERROR_INVALID_HANDLE = 4;
    public static final int FILEACCESSERROR_DECOMPRESS = 5;
    public static final int FILEACCESSERROR_SEEK = 6;
    public static final int FILEACCESSERROR_ACCESS = 7;
    public static final int FILEACCESSERROR_BAD_FILESYSTEM = 8;
    public static final int FILEACCESSERROR_NAME_TOO_LONG = 9;
    public static final int FILEACCESSERROR_NO_ENTRY = 10;
    public static final int FILEACCESSERROR_NO_MEMORY = 11;
    public static final int FILEACCESSERROR_NO_SYSTEM = 12;
    public static final int FILEACCESSERROR_NO_DIRECTORY = 13;
    public static final int FILEACCESSERROR_EJECT = 14;
    public static final int FILEACCESSERROR_OTHER = 15;
    public static final int FILEACCESSERROR_TIMEOUT_OPEN = 16;
    public static final int FILEACCESSERROR_TIMEOUT_READ = 17;
    public static final int USERSELECTION_SELECTED_NOT_INITIALIZED = 0;
    public static final int USERSELECTION_SELECTED_ABORT_DEVICE = 1;
    public static final int USERSELECTION_SELECTED_ABORT_COMPLETLY = 2;
    public static final int USERSELECTION_SELECTED_RETRY = 3;
    public static final int USERSELECTION_SELECTED_CANCEL = 4;
    public static final int USERSELECTION_SELECTED_CONTINUE = 5;
    public static final int USERSELECTION_SELECTED_OK = 6;
    public static final int TRIGGER_TRIGGER_NOT_INITIALIZED = 0;
    public static final int TRIGGER_TRIGGER_REBOOT = 1;
    public static final int TRIGGER_TRIGGER_SUMMARY = 2;
    public static final int TRIGGER_TRIGGER_READING_METAINFO = 3;
    public static final int PROGRESSTYPE_UNKNOWN = 0;
    public static final int PROGRESSTYPE_PROGRESS = 1;
    public static final int PROGRESSTYPE_TIMEOUT = 2;
    public static final int RT_GETPROGRESSDETAILS = 1000;
    public static final int RT_HANDLEUSERSELECTION = 1001;
    public static final int RT_HANDLEMEDIUMSELECTION = 1002;
    public static final int RP_GETSTATICPROGRESSDETAILS = 2000;
    public static final int RP_GETDYNAMICPROGRESSDETAILS = 2001;
    public static final int IN_INDICATEPOPUP = 3000;
    public static final int IN_INDICATEDISMISSPOPUP = 3001;

    public void getProgressDetails(String var1);

    public void handleUserSelection(int var1, String var2, int var3);

    public void handleMediumSelection(int var1, String var2, byte var3, int var4);
}

