/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.TTSOperable;
import de.audi.tghu.tts.request.AbortRequest;
import de.audi.tghu.tts.request.DetailedSpeakRequest;
import de.audi.tghu.tts.request.InitRequest;
import de.audi.tghu.tts.request.PauseRequest;
import de.audi.tghu.tts.request.RequestQueue;
import de.audi.tghu.tts.request.ResumeRequest;
import de.audi.tghu.tts.request.SetLanguageRequest;
import de.audi.tghu.tts.request.SpeakRequest;
import de.audi.tghu.tts.request.ToneRequest;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.DSITTSListener;
import org.dsi.ifc.tts.DynamicTTSPromptPart;
import org.dsi.ifc.tts.LanguageVoiceInfo;
import org.dsi.ifc.tts.TTSPrompt;

public class DSITTSCaller
implements DSITTSListener {
    public static final short SDS_SOURCE = 1;
    public static final short TMC_DETAIL_VIEW_SOURCE = 21;
    public static final short TMC_OVERVIEW_LIST_SOURCE = 22;
    public static final short TOUCHPAD_SOURCE = 23;
    public static final short TOUCHPAD_VOLUME_SOURCE = 24;
    public static final short ADB_SOURCE = 25;
    public static final short REMOTE_HMI_SOURCE = 26;
    public static final short MESSAGING_SOURCE = 27;
    public static final short WIRELESS_CHARGING_VOLUME_SOURCE = 28;
    public static final short WIRELESS_CHARGING_SOURCE = 29;
    public static final short TMC_URGENT_ROUTE_ROAD_SOURCE = 31;
    public static final short TMC_URGENT_ROUTE_ROAD_SOURCE_NO_TEL = 32;
    public static final short DSRC_WARNING = 33;
    public static final short DSRC_INFO = 34;
    public static final short ETC_INFO = 35;
    public static final short ETC_WARNING = 36;
    public static final short DSRC_MESSAGE = 37;
    public static final short ETC_VOLUME_MENU = 38;
    private DSITTS dsiTTS;
    protected LogChannel logCh;
    protected IFrameworkAccess frameworkAccess;
    private TTSOperable ttsStateObserver;
    private RequestQueue requestProcessor;
    private int instance = -1;

    public DSITTSCaller(IFrameworkAccess iFrameworkAccess, TTSOperable tTSOperable) {
        this.frameworkAccess = iFrameworkAccess;
        this.logCh = this.frameworkAccess.getLogChannel("Fw.TTS");
        this.logCh.log(10000000, "[DSITTSCaller#ctor] Called.");
        this.requestProcessor = new RequestQueue(this.logCh);
        this.ttsStateObserver = tTSOperable;
    }

    RequestQueue getRequestQueue() {
        return this.requestProcessor;
    }

    public void setTTSDSI(DSITTS dSITTS) {
        this.dsiTTS = dSITTS;
        this.dsiTTS.setNotification(new int[]{9, 7, 2}, (DSIListener)this);
    }

    public void dsiInitTTSEngine(short s) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiInitTTSEngine] No TTS-DSI available! ");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiInitTTSEngine] for sourceID=%1 Called.", (long)s);
        this.dsiTTS.init(s);
    }

    public void dsiRequestAudioTrigger(short s) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiRequestAudioTrigger] No TTS-DSI available! ");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiRequestAudioTrigger] for sourceID=%1 Called.", (long)s);
        this.dsiTTS.requestAudioTrigger(s, 0);
    }

    public void setLanguage(Language language, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#setLanguage] Called, text: %1", (Object)language);
        SetLanguageRequest setLanguageRequest = new SetLanguageRequest(this.logCh, tTSListener, this.ttsStateObserver, this, this.requestProcessor, language);
        this.requestProcessor.processRequest(setLanguageRequest);
    }

    public void speak(String string, int n, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#speak] Called, text: %1, sourceId: %2", (Object)string, (long)n);
        SpeakRequest speakRequest = new SpeakRequest(this.logCh, tTSListener, this, this.requestProcessor, string, (short)n);
        this.requestProcessor.processRequest(speakRequest);
    }

    public void speak(String string, int n, int n2, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#speak] Called, text: %1, sourceId: %2, promptType: %3", (Object)string, (long)n2, (long)n);
        SpeakRequest speakRequest = new SpeakRequest(this.logCh, tTSListener, this, this.requestProcessor, string, n, (short)n2);
        this.requestProcessor.processRequest(speakRequest);
    }

    public void pause(int n, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#pause] Called, sourceId: %1", (long)n);
        PauseRequest pauseRequest = new PauseRequest(this.logCh, tTSListener, this, this.requestProcessor, (short)n);
        this.requestProcessor.processRequest(pauseRequest);
    }

    public void resume(int n, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#resume] Called, sourceId: %1", (long)n);
        ResumeRequest resumeRequest = new ResumeRequest(this.logCh, tTSListener, this, this.requestProcessor, (short)n);
        this.requestProcessor.processRequest(resumeRequest);
    }

    public void speakCharacters(String string, int n, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#speak] Called, text: %1, sourceId: %2", (Object)string, (long)n);
        DetailedSpeakRequest detailedSpeakRequest = new DetailedSpeakRequest(this.logCh, tTSListener, this, this.requestProcessor, string, (short)n);
        this.requestProcessor.processRequest(detailedSpeakRequest);
    }

    public void playTone(int n, int n2, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#playTone] Called, sourceId: %1, toneValue=%2", (long)n2, (long)n);
        ToneRequest toneRequest = new ToneRequest(n, this.logCh, tTSListener, this, this.requestProcessor, (short)n2);
        this.requestProcessor.processRequest(toneRequest);
    }

    public void dsiPlayTone(int n, short s) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiPlayTone] No TTS-DSI available! ");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiPlayTone] for sourceID=%1 and toneValue=%2 Called.", (long)s, (long)n);
        this.dsiTTS.requestPlayTone(s, n);
    }

    public void initTTSEngine(TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#initTTSEngine] Called.");
        InitRequest initRequest = new InitRequest(this.logCh, tTSListener, this.ttsStateObserver, this, this.requestProcessor);
        this.requestProcessor.processRequest(initRequest);
    }

    public void dsiSpeak(short s, String string) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiSpeak] DSITTS not available!");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiSpeak] Speak prompt, text: %1, source ID: %2", (Object)string, (long)s);
        this.dsiTTS.speakPrompt(s, new TTSPrompt(DSITTSCaller.resolveTTSPromptTypeBySourceId(s), new String[]{string}, new int[0], new DynamicTTSPromptPart[0]));
    }

    public void dsiSpeak(short s, String string, int n) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiSpeak] DSITTS not available!");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiSpeak] Speak prompt, text: %1, source ID: %2, promptType: %3", (Object)string, (long)s, (long)n);
        this.dsiTTS.speakPrompt(s, new TTSPrompt(n, new String[]{string}, new int[0], new DynamicTTSPromptPart[0]));
    }

    public void dsiSetLanguage(short s, Language language) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiSetLanguage] No TTS-DSI available!");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiSetLanguage] Set language: %1, sourceID=%2", (Object)language, (long)s);
        this.dsiTTS.setLanguage(s, language.getLanguageCode(), 0, language.getVoiceId(), 0);
    }

    public void abortSpeaking(short s, TTSListener tTSListener) {
        this.logCh.log(10000000, "[DSITTSCaller#abortSpeaking] Called, sourceID: %1", (long)s);
        AbortRequest abortRequest = new AbortRequest(this.logCh, tTSListener, this, this.requestProcessor, s);
        this.requestProcessor.processRequest(abortRequest);
    }

    public void dsiAbort(short s) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiAbort] No TTS-DSI available!");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiAbort] Called, sourceID: %1", (long)s);
        this.dsiTTS.requestAudioTrigger(s, 2);
    }

    public void dsiPause(short s) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiPause] No TTS-DSI available!");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiPause] Called, sourceID: %1", (long)s);
        this.dsiTTS.requestAudioTrigger(s, 3);
    }

    public void dsiResume(short s) {
        if (this.dsiTTS == null) {
            this.logCh.log(10000, "[DSITTSCaller#dsiResume] No TTS-DSI available!");
            return;
        }
        this.logCh.log(10000000, "[DSITTSCaller#dsiResume] Called, sourceID: %1", (long)s);
        this.dsiTTS.requestAudioTrigger(s, 0);
    }

    public DSITTSListener getTTSListener() {
        return this;
    }

    public void updateAvailableLanguages(LanguageVoiceInfo[] languageVoiceInfoArray, int n) {
        this.logCh.log(10000000, "[DSITTSCaller#updateAvailableLanguages] availableLanguages=%1, valid: %2", (Object)languageVoiceInfoArray, (long)n);
        if (n == 1) {
            if (languageVoiceInfoArray == null) {
                this.logCh.log(10000, "[DSITTSCaller#updateAvailableLanguages] availableLanguages == null!");
                return;
            }
            String[] stringArray = new String[languageVoiceInfoArray.length];
            for (int i2 = 0; i2 < languageVoiceInfoArray.length; ++i2) {
                stringArray[i2] = languageVoiceInfoArray[i2].getLanguage();
            }
            this.frameworkAccess.getLanguageMgr().updateAvailableLanguages("LANG_COMPONENT_TTS", stringArray);
        }
    }

    public void responseSetLanguage(short s, int n) {
        this.logCh.log(10000000, "[DSITTSCaller#responseSetLanguage] Called, sourceId: %1, result: %2", (long)s, (long)n);
        this.requestProcessor.responseSetLanguage(n);
        if (n == 0) {
            this.frameworkAccess.getLanguageMgr().responseSetLanguage("LANG_COMPONENT_TTS", true);
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.logCh.log(10000000, "[DSITTSCaller#asyncException] Called, error code: %1", (long)n);
    }

    public void updateLanguage(String string, int n, int n2, int n3) {
        if (n3 == 2) {
            this.logCh.log(10000000, "[DSITTSCaller#updateLanguage] Called, invalid update.");
        } else if (n3 == 1) {
            this.logCh.log(10000000, "[DSITTSCaller#updateLanguage] supported language: '%1'", (Object)string);
        } else {
            this.logCh.log(10000000, "[DSITTSCaller#updateLanguageList] Called, unknown valid flag.");
        }
    }

    public void responseAudioTrigger(short s, int n) {
        this.logCh.log(10000000, "[DSITTSCaller#responseAudioTrigger] called, source: %1, result: %2", (long)s, (long)n);
        this.requestProcessor.responseAudioTrigger(s, n).execute();
    }

    public void updateAudioRequest(int n, int n2) {
        if (n2 == 2) {
            this.logCh.log(10000000, "[DSITTSCaller#updateAudioRequest] Called, invalid update.");
        } else if (n2 == 1) {
            this.logCh.log(10000000, "[DSITTSCaller#updateAudioRequest] param: %1, instance: %2", (Object)DSITTSCaller.audioInfoToString(n), (long)this.instance);
            this.requestProcessor.updateAudioRequest(n, n2).execute();
        } else {
            this.logCh.log(10000000, "[DSITTSCaller#updateAudioRequest] Called, unknown valid flag.");
        }
    }

    public void responseInit(short s, int n) {
        this.logCh.log(10000000, "[DSITTSCaller#responseInit] Called, sourceID: %1, result: %2", (long)s, (long)n);
        this.requestProcessor.responseInit(n).execute();
        this.setLanguage(this.frameworkAccess.getLanguageMgr().getCurrentLanguage("LANG_COMPONENT_TTS"), null);
    }

    public void responsePlayTone(short s, int n) {
        this.logCh.log(10000000, "[DSITTSCaller#responsePlayTone] Called, sourceID: %1, result: %2", (long)s, (long)n);
        this.requestProcessor.responsePlayTone(n).execute();
    }

    public void responseSpeakPrompt(short s, int n) {
        this.logCh.log(10000000, "[DSITTSCaller#responseSpeakPrompt] Called, sourceID: %1, result: %2", (long)s, (long)n);
        this.requestProcessor.responseSpeakPrompt(n).execute();
    }

    public boolean isRequestQueueIdle() {
        return this.requestProcessor.getRunningRequest() == null;
    }

    public static boolean isError(int n) {
        switch (n) {
            case 3: 
            case 6: 
            case 8: 
            case 9: 
            case 11: 
            case 12: 
            case 13: 
            case 14: 
            case 15: 
            case 16: 
            case 17: {
                return true;
            }
        }
        return false;
    }

    public static String audioInfoToString(int n) {
        switch (n) {
            case 0: {
                return "idle";
            }
            case 6: {
                return "processing";
            }
            case 3: {
                return "prompt aborted";
            }
            case 2: {
                return "prompt finished";
            }
            case 1: {
                return "prompt started";
            }
            case 7: {
                return "prompt failed";
            }
            case 5: {
                return "tone finished";
            }
            case 4: {
                return "tone started";
            }
            case 8: {
                return "prompt paused";
            }
        }
        return "unknown (" + n + ")";
    }

    public static int resolveTTSPromptTypeBySourceId(int n) {
        int n2 = 1;
        switch (n) {
            case 26: 
            case 27: {
                n2 = 3;
                break;
            }
        }
        return n2;
    }

    public void setInstance(int n) {
        this.instance = n;
    }

    public void updateMarkerPassed(int n, int n2) {
    }

    public void responseSkipSpeaking(short s, int n) {
    }
}

