/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.irc;

public interface InfotainmentRecorder {
    public static final int SYSTEM_STATE_UNDEFINED;
    public static final int SYSTEM_STATE_SYSTEM_OVERTEMP;
    public static final int SYSTEM_STATE_DVD_DRIVE_OVERTEMP;
    public static final int SYSTEM_STATE_CD_DRIVE_TEMP_TO_HIGH;
    public static final int SYSTEM_STATE_DVD_DRIVE_UNDER_TEMP;
    public static final int SYSTEM_STATE_CD_DRIVE_TEMP_TO_LOW;
    public static final int SYSTEM_STATE_DVD_DRIVE_DAMAGED;
    public static final int SYSTEM_STATE_CD_DRIVE_DAMAGED;
    public static final int SYSTEM_STATE_DVD_NOT_READABLE;
    public static final int SYSTEM_STATE_HDD_NOT_READABLE;
    public static final int SYSTEM_STATE_HDD_NO_OPERATION;
    public static final int SYSTEM_STATE_SYSTEM_OVERTEMP_DEACT;
    public static final int SYSTEM_STATE_ERROR_OCCURED;
    public static final int SYSTEM_STATE_PHONE_NOT_OPERABLE;
    public static final int SYSTEM_STATE_PHONE_OVERTEMP_AND_DEACTIVATED;
    public static final int SYSTEM_STATE_PHONE_UNUSABLE;

    default public void logSystemState(int n) {
    }

    default public void logScreenChange(int n) {
    }

    default public void logInit() {
    }

    default public void logRemoteHMI(String string) {
    }

    default public void backupTrigger() {
    }
}

