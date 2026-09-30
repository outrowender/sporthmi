/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMessagingLicenseService {
    public static final int RESULT_ERROR_GENERAL = 0;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT = 1;
    public static final int RESULT_ERROR_ILLEGAL_STATE = 2;
    public static final int RESULT_DICTATION_LICENSE_ACTIVE = 3;
    public static final int RESULT_DICTATION_LICENSE_INACTIVE = 4;
    public static final int RESULT_DICTATION_LICENSE_EXPIRED = 5;
    public static final int RESULT_DICTATION_LICENSE_ACTIVE_WARNING = 6;

    public void requestOnlineDictationLicenseInfo();

    public void setExpirationWarning(boolean var1);
}

