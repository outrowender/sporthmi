/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMessagingLicenseService {
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT;
    public static final int RESULT_ERROR_ILLEGAL_STATE;
    public static final int RESULT_DICTATION_LICENSE_ACTIVE;
    public static final int RESULT_DICTATION_LICENSE_INACTIVE;
    public static final int RESULT_DICTATION_LICENSE_EXPIRED;
    public static final int RESULT_DICTATION_LICENSE_ACTIVE_WARNING;

    default public void requestOnlineDictationLicenseInfo() {
    }

    default public void setExpirationWarning(boolean bl) {
    }
}

