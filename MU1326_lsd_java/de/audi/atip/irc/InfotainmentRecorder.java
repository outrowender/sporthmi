/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.irc;

public interface InfotainmentRecorder {
    public static final int SYSTEM_STATE_UNDEFINED = 0;
    public static final int SYSTEM_STATE_SYSTEM_OVERTEMP = 1;
    public static final int SYSTEM_STATE_DVD_DRIVE_OVERTEMP = 2;
    public static final int SYSTEM_STATE_CD_DRIVE_TEMP_TO_HIGH = 3;
    public static final int SYSTEM_STATE_DVD_DRIVE_UNDER_TEMP = 4;
    public static final int SYSTEM_STATE_CD_DRIVE_TEMP_TO_LOW = 5;
    public static final int SYSTEM_STATE_DVD_DRIVE_DAMAGED = 6;
    public static final int SYSTEM_STATE_CD_DRIVE_DAMAGED = 7;
    public static final int SYSTEM_STATE_DVD_NOT_READABLE = 8;
    public static final int SYSTEM_STATE_HDD_NOT_READABLE = 9;
    public static final int SYSTEM_STATE_HDD_NO_OPERATION = 10;
    public static final int SYSTEM_STATE_SYSTEM_OVERTEMP_DEACT = 11;
    public static final int SYSTEM_STATE_ERROR_OCCURED = 12;
    public static final int SYSTEM_STATE_PHONE_NOT_OPERABLE = 13;
    public static final int SYSTEM_STATE_PHONE_OVERTEMP_AND_DEACTIVATED = 14;
    public static final int SYSTEM_STATE_PHONE_UNUSABLE = 15;

    public void logSystemState(int var1);

    public void logScreenChange(int var1);

    public void logInit();

    public void logRemoteHMI(String var1);

    public void backupTrigger();
}

