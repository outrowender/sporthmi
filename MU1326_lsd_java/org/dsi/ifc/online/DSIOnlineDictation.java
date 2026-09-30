/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;

public interface DSIOnlineDictation
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int STATUS_OK_INIT = 10;
    public static final int STATUS_OK_DICTATION_COMPLETE = 11;
    public static final int STATUS_OK_DICTATION_CANCELED = 12;
    public static final int STATUS_ERROR_CAR_HARDWARE = 21;
    public static final int STATUS_ERROR_CAR_DSI = 22;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_SETUP = 23;
    public static final int STATUS_ERROR_CAR_CONNECTIVITY_ERROR = 24;
    public static final int STATUS_ERROR_DICTATION_SSL_HANDSHAKE_FAILED = 31;
    public static final int STATUS_ERROR_DICTATION_TIMEOUT = 41;
    public static final int STATUS_ERROR_DICTATION_CONNECTION_CLOSED = 42;
    public static final int STATUS_ERROR_DICTATION_CONNECTION_REJECTED = 43;
    public static final int STATUS_ERROR_DICTATION_PARSE = 44;
    public static final int STATUS_ERROR_DICTATION_HOST_UNRESOLVABLE = 45;
    public static final int STATUS_ERROR_DICTATION_UNKNOWN_ERROR = 46;
    public static final int STATUS_ERROR_DICTATION_INVALID_INPUT = 47;
    public static final int STATUS_ERROR_DICTATION_URL_INVALID = 48;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_TIMEOUT = 51;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_CONNECTION_CLOSED = 52;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_CONNECTION_REJECTED = 53;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_PARSE = 54;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_HOST_UNRESOLVABLE = 55;
    public static final int STATUS_ERROR_DICTATION_PROVIDER_UNKNOWN_ERROR = 56;
    public static final int STATUS_ERROR_LANGUAGE_NOT_SUPPORTED = 61;
    public static final int STATUS_ERROR_VOICE_RECOGNITION_FAILED = 62;
    public static final int STATUS_ERROR_PROFANITY_DETECTED = 63;
    public static final int STATUS_ERROR_DICTATION_DISABLED = 64;
    public static final int STATUS_ERROR_DICTATION_UPLOAD_FAILED = 71;
    public static final int STATUS_ERROR_DICTATION_CHECKSUM_FAILED = 72;
    public static final int STATUS_ERROR_DICTATION_FORCED_UPLOAD = 73;
    public static final int RT_STOPDICTATION = 1000;
    public static final int RT_SETFALLBACKLANGUAGE = 1001;
    public static final int RT_SETLANGUAGE = 1002;
    public static final int RT_ACTIVATEDICTATION = 1003;
    public static final int RT_STARTDICTATION = 1004;
    public static final int RT_FINISHDICTATION = 1005;
    public static final int RT_RAWVOICEDATAAVAILABLE = 1008;
    public static final int RP_DICTATIONRESULT = 2000;
    public static final int RP_FINISHDICTATIONRESPONSE = 2001;
    public static final int RP_DICTATIONVALUELIST = 2002;

    public void stopDictation();

    public void setFallbackLanguage(String var1);

    public void setLanguage(String var1);

    public void activateDictation();

    public void startDictation(String var1, String var2, String var3, String var4);

    public void finishDictation();

    public void rawVoiceDataAvailable(String var1, int var2);
}

