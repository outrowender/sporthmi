/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIBase;

public interface DSIMobileSpeechRecognition
extends DSIBase {
    public static final String VERSION = "2.11.27";
    public static final int RT_REQUESTSTARTSPEECHRECOGNITION = 1000;
    public static final int RT_REQUESTSTOPSPEECHRECOGNITION = 1001;
    public static final int ATTR_SPEECHRECOGNITIONAVAILABLE = 1;
    public static final int ATTR_SPEECHRECOGNITIONACTIVE = 2;
    public static final int ATTR_SPEECHRECOGNITIONTYPE = 3;
    public static final int RP_RESPONSESTARTSPEECHRECOGNITION = 2000;
    public static final int RP_RESPONSESTOPSPEECHRECOGNITION = 2001;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ABORTED = 1;
    public static final int RESULT_ERROR_UNSPECIFIED = 2;
    public static final int RESULT_ERROR_SPEECHRECOGNITION_NOT_STARTED = 3;
    public static final int RESULT_ERROR_SPEECH_RECOGNITION_NOT_AVAILABLE = 4;
    public static final int RESULT_ERROR_SPEECH_RECOGNITION_ALREADY_ACTIVE = 5;
    public static final int MOBILESPEECHRECOGNITIONSTATUS_NOT_ACTIVE = 0;
    public static final int MOBILESPEECHRECOGNITIONSTATUS_ACTIVE = 1;
    public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_NOT_AVAILABLE = 0;
    public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_AVAILABLE = 1;
    public static final int MOBILESPEECHRECOGNITIONAVAILABILITY_UNKNOWN = 2;
    public static final int MOBILESPEECHRECOGNITIONTYPE_UNKNOWN = 0;
    public static final int MOBILESPEECHRECOGNITIONTYPE_GENERIC = 1;
    public static final int MOBILESPEECHRECOGNITIONTYPE_SIRI = 2;
    public static final int MOBILESPEECHRECOGNITIONTYPE_GOOGLE_NOW = 3;

    public void requestStartSpeechRecognition();

    public void requestStopSpeechRecognition();
}

