/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

public interface ITelServiceListener {
    public static final int RESULT_OK = 0;
    public static final int RESULT_ABORTED = 1;
    public static final int RESULT_ERROR_NOSUP_PHONE = 2;
    public static final int RESULT_ERROR_NOSUP_NW = 3;
    public static final int RESULT_ERROR_UNSPECIFIED = 4;
    public static final int RESULT_ERROR_CODE_WRONG = 5;
    public static final int RESULT_ERROR_SERV_BUSY = 6;
    public static final int RESULT_ERROR_NOT_ALLOWED = 7;
    public static final int RESULT_ERROR_SIM_FAILURE = 8;
    public static final int RESULT_ERROR_CODE_INVALID_FORMAT = 9;
    public static final int RESULT_ERROR_STRING_TOO_LONG = 11;
    public static final int RESULT_ERROR_NO_NW_REPLY = 12;
    public static final int RESULT_ERROR_NO_NW_ACCESS = 13;
    public static final int RESULT_ERROR_INVALID_CALL_ID = 14;
    public static final int RESULT_ERROR_NW_REGISTRATION_NOT_ALLOWED = 15;
    public static final int RESULT_ERROR_PIN_IDENTICAL_PROFILE_NOT_CHANGED = 16;
    public static final int NOT_POSSIBLE_OPERATOR_CALL_ACTIVE = 16;

    public void dialNumberResponse(int var1);
}

