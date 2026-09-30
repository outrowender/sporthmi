/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.request.RequestQueue;
import de.audi.tghu.tts.request.TTSResult;

public abstract class AbstractRequest
implements TimerListener {
    public static final String SYSTEM_PROPERTY_TTS_REQ = "ttsRequestTimer";
    private static final long TIMER_VALUE = 60000L;
    protected static final int RT_SPEAK = 0;
    protected static final int RT_SPEAK_SEPARATELY = 1;
    protected static final int RT_ABORT = 2;
    protected static final int RT_INIT = 3;
    protected static final int RT_SET_LANGUAGE = 4;
    protected static final int RT_PLAY_BEEP = 5;
    protected short sourceId;
    protected int type;
    protected RequestQueue requestProcessor;
    protected LogChannel logCh;
    protected DSITTSCaller dsiCaller;
    protected TTSListener ttsListener;
    protected Timer timer;

    public AbstractRequest(LogChannel logChannel, TTSListener tTSListener, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, short s, int n) {
        this.logCh = logChannel;
        this.requestProcessor = requestQueue;
        this.sourceId = s;
        this.type = n;
        this.dsiCaller = dSITTSCaller;
        this.ttsListener = tTSListener;
        this.timer = new Timer("TTSRequestTimer", Long.getLong(SYSTEM_PROPERTY_TTS_REQ, 60000L), true, this);
    }

    public void process() {
        AbstractRequest abstractRequest = this.requestProcessor.getRunningRequest();
        if (abstractRequest == null) {
            this.logCh.log(10000000, "[AbstractRequest#process] No running request.");
            if (this.requestProcessor.isEmpty()) {
                this.logCh.log(10000000, "[AbstractRequest#process] Empty request queue, set requst to running.");
                this.execute();
                this.requestProcessor.setRunningRequest(this);
            } else {
                this.logCh.log(10000000, "[AbstractRequest#process] Should not happen, do nothing.");
            }
        } else {
            this.logCh.log(10000000, "[AbstractRequest#process] Adding request to queue.");
            this.requestProcessor.addRequest(this);
        }
    }

    protected abstract void execute();

    protected void finish() {
        this.logCh.log(10000000, "[AbstractRequest#finish] Called.");
        this.timer.cancel();
        this.requestProcessor.finishRequest();
    }

    public short getSourceId() {
        return this.sourceId;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return this.getClass().getName();
    }

    public TTSResult responseSpeakText(int n) {
        this.logCh.log(10000000, "[AbstractRequest#responseSpeakText] Called, result: %1", (long)n);
        return new TTSResult(null, 1);
    }

    public TTSResult responseSpeakPrompt(int n) {
        this.logCh.log(10000000, "[AbstractRequest#responseSpeakPrompt] Called, result: %1", (long)n);
        return new TTSResult(null, 1);
    }

    public TTSResult responseAudioTrigger(short s, int n) {
        this.logCh.log(10000000, "[AbstractRequest#responseAudioTrigger] Called, sourceID: %1, result: %2", (long)s, (long)n);
        return new TTSResult(null, 1);
    }

    public TTSResult responsePlayTone(int n) {
        this.logCh.log(10000000, "[AbstractRequest#responsePlayTone] Called, result: %1", (long)n);
        return new TTSResult(null, 1);
    }

    public TTSResult updateAudioRequest(int n, int n2) {
        this.logCh.log(10000000, "[AbstractRequest#updateAudioRequest] Called, audioInfo: %1", (long)n);
        return new TTSResult(null, 1);
    }

    public TTSResult responseInit(int n) {
        this.logCh.log(10000000, "[AbstractRequest#responseInit] Called, result: %1", (long)n);
        return new TTSResult(null, 1);
    }

    public TTSResult responseSetLanguage(int n) {
        this.logCh.log(10000000, "[AbstractRequest#responseSetLanguage] Called, result: %1", (long)n);
        return new TTSResult(null, 1);
    }

    public void fireTimer(Timer timer) {
        this.logCh.log(10000000, "[AbstractRequest#fireTimer] Called, stop request object.");
        this.finish();
    }

    public void cancelTimer(Timer timer) {
        this.logCh.log(10000000, "[AbstractRequest#cancelTimer] Called.");
    }

    public static boolean isAbortableByLanguageChange(int n) {
        return n != 3 && n != 4;
    }

    public void abort() {
    }

    public TTSResult abortQueued() {
        return new TTSResult(this.ttsListener, 1);
    }
}

