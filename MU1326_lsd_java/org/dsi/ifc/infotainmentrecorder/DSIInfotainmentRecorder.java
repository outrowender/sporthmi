/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.infotainmentrecorder;

import org.dsi.ifc.base.DSIBase;

public interface DSIInfotainmentRecorder
extends DSIBase {
    public static final String VERSION = "2.11.0";
    public static final int RT_LOGPANELNAME = 1000;
    public static final int RT_LOGKEYEVENT = 1002;
    public static final int RT_BACKUPTRIGGER = 1003;
    public static final int RT_ENABLETRIGGER = 1004;
    public static final int RT_LOGINIT = 1005;
    public static final int ATTR_ENABLEDTRIGGERS = 1;
    public static final int TTRIGGERTYPES_IRC_EXCEPTION_TRIGGER = 61;
    public static final int TTRIGGERTYPES_IRC_HOTKEY_TRIGGER = 63;
    public static final int TTRIGGERTYPES_IRC_RESET_TRIGGER = 62;
    public static final int TTRIGGERTYPES_SYSTEM_DRIVE_ERROR = 12;
    public static final int TTRIGGERTYPES_SYSTEM_DRIVE_READERROR = 8;
    public static final int TTRIGGERTYPES_SYSTEM_HDD_DEFECT = 9;
    public static final int TTRIGGERTYPES_SYSTEM_HDD_PRESURE = 10;
    public static final int TTRIGGERTYPES_SYSTEM_OVER_HEAT = 11;
    public static final int TTRIGGERTYPES_TEL_PHONE_NOT_FUNCTIONAL = 13;
    public static final int TTRIGGERTYPES_TEL_PHONE_TEMPERATURE_OFF = 14;
    public static final int TTRIGGERTYPES_TEL_SECCO_BLOCKED = 15;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_DAMAGED = 7;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_TEMPHIGH = 3;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_CD_DRIVE_TEMPLOW = 5;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_DAMAGED = 6;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_TEMPHIGH = 2;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_DVD_DRIVE_TEMPLOW = 4;
    public static final int TTRIGGERTYPES_TEMP_SYSTEM_TEMP = 1;
    public static final int TTRIGGERTYPES_UNUSED = 0;

    public void logPanelName(String var1);

    public void logKeyEvent(int var1, int var2, int var3);

    public void backupTrigger(int var1);

    public void enableTrigger(boolean var1, int var2);

    public void logInit();
}

