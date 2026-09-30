/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;

public interface IDsiDictationAdapter {
    public static final int ACTIVATION_STATE_INACTIVE = 0;
    public static final int ACTIVATION_STATE_ACTIVATED = 1;
    public static final int ACTIVATION_STATE_STARTED = 2;
    public static final int ACTIVATION_STATE_PROCESSING = 3;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ERROR_GENERAL = 1;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT = 2;
    public static final int RESULT_ERROR_ILLEGAL_STATE = 3;
    public static final int RESULT_ERROR_CAR_HARDWARE = 21;
    public static final int RESULT_ERROR_CAR_DSI = 22;
    public static final int RESULT_ERROR_CAR_CONNECTIVITY_SETUP = 23;
    public static final int RESULT_ERROR_CAR_CONNECTIVITY_ERROR = 24;
    public static final int RESULT_ERROR_DICTATION_SSL_HANDSHAKE_FAILED = 31;
    public static final int RESULT_ERROR_DICTATION_TIMEOUT = 41;
    public static final int RESULT_ERROR_DICTATION_CONNECTION_CLOSED = 42;
    public static final int RESULT_ERROR_DICTATION_CONNECTION_REJECTED = 43;
    public static final int RESULT_ERROR_DICTATION_PARSE = 44;
    public static final int RESULT_ERROR_DICTATION_HOST_UNRESOLVABLE = 45;
    public static final int RESULT_ERROR_DICTATION_UNKNOWN_ERROR = 46;
    public static final int RESULT_ERROR_DICTATION_INVALID_INPUT = 47;
    public static final int RESULT_ERROR_DICTATION_URL_INVALID = 48;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_TIMEOUT = 51;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_CONNECTION_CLOSED = 52;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_CONNECTION_REJECTED = 53;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_PARSE = 54;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_HOST_UNRESOLVABLE = 55;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_UNKNOWN_ERROR = 56;
    public static final int RESULT_ERROR_LANGUAGE_NOT_SUPPORTED = 61;
    public static final int RESULT_ERROR_VOICE_RECOGNITION_FAILED = 62;
    public static final int RESULT_ERROR_PROFANITY_DETECTED = 63;
    public static final int RESULT_ERROR_DICTATION_DISABLED = 64;
    public static final int RESULT_ERROR_DICTATION_UPLOAD_FAILED = 71;
    public static final int RESULT_ERROR_DICTATION_CHECKSUM_FAILED = 72;
    public static final int RESULT_ERROR_DICTATION_FORCED_UPLOAD = 73;
    public static final int RESULT_DICTATION_LICENCE_ACTIVE = 74;
    public static final int RESULT_DICTATION_LICENCE_INACTIVE = 75;
    public static final int RESULT_DICTATION_LICENCE_EXPIRED = 76;
    public static final int RESULT_DICTATION_LICENCE_ACTIVE_WARNING = 77;

    public void addListener(IDsiDictationAdapterListener var1);

    public void removeListener(IDsiDictationAdapterListener var1);

    public void requestSetLanguage(String var1);

    public void requestSetFallbackLanguage(String var1);

    public void requestSetUserId(String var1);

    public void requestActivateDictation();

    public void requestStartDictation(String var1);

    public void requestProcessVoiceData();

    public void requestStopDictation();
}

