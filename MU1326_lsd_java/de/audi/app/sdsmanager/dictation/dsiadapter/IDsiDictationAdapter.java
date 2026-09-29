/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.dictation.dsiadapter;

import de.audi.app.sdsmanager.dictation.dsiadapter.IDsiDictationAdapterListener;

public interface IDsiDictationAdapter {
    public static final int ACTIVATION_STATE_INACTIVE;
    public static final int ACTIVATION_STATE_ACTIVATED;
    public static final int ACTIVATION_STATE_STARTED;
    public static final int ACTIVATION_STATE_PROCESSING;
    public static final int RESULT_OK;
    public static final int RESULT_ERROR_GENERAL;
    public static final int RESULT_ERROR_ILLEGAL_ARGUMENT;
    public static final int RESULT_ERROR_ILLEGAL_STATE;
    public static final int RESULT_ERROR_CAR_HARDWARE;
    public static final int RESULT_ERROR_CAR_DSI;
    public static final int RESULT_ERROR_CAR_CONNECTIVITY_SETUP;
    public static final int RESULT_ERROR_CAR_CONNECTIVITY_ERROR;
    public static final int RESULT_ERROR_DICTATION_SSL_HANDSHAKE_FAILED;
    public static final int RESULT_ERROR_DICTATION_TIMEOUT;
    public static final int RESULT_ERROR_DICTATION_CONNECTION_CLOSED;
    public static final int RESULT_ERROR_DICTATION_CONNECTION_REJECTED;
    public static final int RESULT_ERROR_DICTATION_PARSE;
    public static final int RESULT_ERROR_DICTATION_HOST_UNRESOLVABLE;
    public static final int RESULT_ERROR_DICTATION_UNKNOWN_ERROR;
    public static final int RESULT_ERROR_DICTATION_INVALID_INPUT;
    public static final int RESULT_ERROR_DICTATION_URL_INVALID;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_TIMEOUT;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_CONNECTION_CLOSED;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_CONNECTION_REJECTED;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_PARSE;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_HOST_UNRESOLVABLE;
    public static final int RESULT_ERROR_DICTATION_PROVIDER_UNKNOWN_ERROR;
    public static final int RESULT_ERROR_LANGUAGE_NOT_SUPPORTED;
    public static final int RESULT_ERROR_VOICE_RECOGNITION_FAILED;
    public static final int RESULT_ERROR_PROFANITY_DETECTED;
    public static final int RESULT_ERROR_DICTATION_DISABLED;
    public static final int RESULT_ERROR_DICTATION_UPLOAD_FAILED;
    public static final int RESULT_ERROR_DICTATION_CHECKSUM_FAILED;
    public static final int RESULT_ERROR_DICTATION_FORCED_UPLOAD;
    public static final int RESULT_DICTATION_LICENCE_ACTIVE;
    public static final int RESULT_DICTATION_LICENCE_INACTIVE;
    public static final int RESULT_DICTATION_LICENCE_EXPIRED;
    public static final int RESULT_DICTATION_LICENCE_ACTIVE_WARNING;

    default public void addListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
    }

    default public void removeListener(IDsiDictationAdapterListener iDsiDictationAdapterListener) {
    }

    default public void requestSetLanguage(String string) {
    }

    default public void requestSetFallbackLanguage(String string) {
    }

    default public void requestSetUserId(String string) {
    }

    default public void requestActivateDictation() {
    }

    default public void requestStartDictation(String string) {
    }

    default public void requestProcessVoiceData() {
    }

    default public void requestStopDictation() {
    }
}

