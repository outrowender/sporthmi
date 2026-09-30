/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.tts;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.tts.TTSPrompt;

public interface DSITTS
extends DSIBase {
    public static final String VERSION = "2.11.13";
    public static final int ATTR_LANGUAGE = 2;
    public static final int ATTR_AVAILABLELANGUAGES = 7;
    public static final int ATTR_AUDIOREQUEST = 9;
    public static final int ATTR_MARKERPASSED = 10;
    public static final int AUDIOINFO_IDLE = 0;
    public static final int AUDIOINFO_PROMPT_STARTED = 1;
    public static final int AUDIOINFO_PROMPT_FINISHED = 2;
    public static final int AUDIOINFO_PROMPT_ABORTED = 3;
    public static final int AUDIOINFO_TONE_STARTED = 4;
    public static final int AUDIOINFO_TONE_FINISHED = 5;
    public static final int AUDIOINFO_PROCESSING = 6;
    public static final int AUDIOINFO_PROMPT_FAILED = 7;
    public static final int AUDIOINFO_PAUSED = 8;
    public static final int RESULT_OK = 0;
    public static final int RESULT_ABORTED = 1;
    public static final int RESULT_PAUSED = 2;
    public static final int RESULT_ERROR_GENERAL = 3;
    public static final int RESULT_ERROR_TTSALREADYRUNNING = 6;
    public static final int RESULT_ERROR_LANGUAGENOTSUPPORTED = 8;
    public static final int RESULT_ERROR_UNKNOWNVOICE = 9;
    public static final int RESULT_WARNING_INIT_ALREADY_DONE = 10;
    public static final int RESULT_ERROR_NOT_INIT = 11;
    public static final int RESULT_ERROR_VALUEOUTOFRANGE = 12;
    public static final int RESULT_ERROR_NOT_POSSIBLE = 13;
    public static final int RESULT_ERROR_REGISTRATION_MISSING = 14;
    public static final int RESULT_ERROR_INTERNAL = 15;
    public static final int RESULT_ERROR_ILLEGAL_SKIN_ID = 16;
    public static final int RESULT_ERROR_ILLEGAL_PROMPT_TYPE = 17;
    public static final int SKINID_1 = 1;
    public static final int SKINID_2 = 2;
    public static final int SKINID_3 = 3;
    public static final int AUDIOMODE_START = 0;
    public static final int AUDIOMODE_REPEAT = 1;
    public static final int AUDIOMODE_ABORT = 2;
    public static final int AUDIOMODE_PAUSE = 3;
    public static final int PROMPTMODE_NONE = 0;
    public static final int PROMPTMODE_SHORT = 1;
    public static final int PROMPTMODE_LONG = 2;
    public static final int VOICEID_FEMALE = 0;
    public static final int VOICEID_MALE = 1;
    public static final int VOICEID_OTHER_1 = 2;
    public static final int VOICEID_OTHER_2 = 3;
    public static final int VOICEID_OTHER_3 = 4;
    public static final int TONEID_STARTTONE = 0;
    public static final int TONEID_ENDTONE = 1;
    public static final int TONEID_RECOGNIZER_READY_TONE = 2;
    public static final int TONEID_WAITING_TONE = 3;
    public static final int TONEID_ERROR_TONE = 4;
    public static final int PLAYBACKTYPE_TEXT = 0;
    public static final int PLAYBACKTYPE_STARTTONE = 1;
    public static final int PLAYBACKTYPE_ENDTONE = 2;
    public static final int PLAYBACKTYPE_RECOGNIZER_READY_TONE = 3;
    public static final int PROMPTTYPE_INVALID = 0;
    public static final int PROMPTTYPE_SSML_TEXT = 1;
    public static final int PROMPTTYPE_SSML_TEXT_ID = 2;
    public static final int PROMPTTYPE_SSML_REMOTE_TEXT = 3;
    public static final int SKIPDIRECTION_FORWARD = 0;
    public static final int SKIPDIRECTION_BACKWARD = 1;
    public static final int RT_SETLANGUAGE = 1001;
    public static final int RT_INIT = 1003;
    public static final int RT_REQUESTAUDIOTRIGGER = 1008;
    public static final int RT_REQUESTPLAYTONE = 1009;
    public static final int RT_SPEAKPROMPT = 1010;
    public static final int RT_REQUESTSKIPSPEAKING = 1011;
    public static final int RP_RESPONSESETLANGUAGE = 2000;
    public static final int RP_RESPONSEINIT = 2002;
    public static final int RP_RESPONSEAUDIOTRIGGER = 2008;
    public static final int RP_RESPONSEPLAYTONE = 2009;
    public static final int RP_RESPONSESPEAKPROMPT = 2010;
    public static final int RP_RESPONSESKIPSPEAKING = 2011;

    public void speakPrompt(short var1, TTSPrompt var2);

    public void setLanguage(short var1, String var2, int var3, int var4, int var5);

    public void init(short var1);

    public void requestAudioTrigger(short var1, int var2);

    public void requestPlayTone(short var1, int var2);

    public void requestSkipSpeaking(short var1, int var2, int var3);
}

