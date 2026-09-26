/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.phone;

public interface ITelServiceListener {
    public static final int RESULT_OK;
    public static final int RESULT_ABORTED;
    public static final int RESULT_ERROR_NOSUP_PHONE;
    public static final int RESULT_ERROR_NOSUP_NW;
    public static final int RESULT_ERROR_UNSPECIFIED;
    public static final int RESULT_ERROR_CODE_WRONG;
    public static final int RESULT_ERROR_SERV_BUSY;
    public static final int RESULT_ERROR_NOT_ALLOWED;
    public static final int RESULT_ERROR_SIM_FAILURE;
    public static final int RESULT_ERROR_CODE_INVALID_FORMAT;
    public static final int RESULT_ERROR_STRING_TOO_LONG;
    public static final int RESULT_ERROR_NO_NW_REPLY;
    public static final int RESULT_ERROR_NO_NW_ACCESS;
    public static final int RESULT_ERROR_INVALID_CALL_ID;
    public static final int RESULT_ERROR_NW_REGISTRATION_NOT_ALLOWED;
    public static final int RESULT_ERROR_PIN_IDENTICAL_PROFILE_NOT_CHANGED;
    public static final int NOT_POSSIBLE_OPERATOR_CALL_ACTIVE;

    default public void dialNumberResponse(int n) {
    }
}

