/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.request.AbstractRequest;
import de.audi.tghu.tts.request.RequestQueue;
import de.audi.tghu.tts.request.TTSResult;
import de.esolutions.fw.util.commons.Buffer;

public class SpeakRequest
extends AbstractRequest {
    protected String text;
    protected int promptType = 1;
    protected boolean aborted = false;
    protected volatile boolean pauseTriggered = false;
    protected volatile boolean paused = false;
    protected boolean speakingFailed = false;
    protected int requestCounter = 0;
    protected int audioInfo = -1;
    private boolean audioInfoPromptFailed = false;
    private boolean audioInfoPromptAborted = false;
    private boolean audioInfoPromptPaused = false;
    private boolean responseSpeakPromptFailed;

    public SpeakRequest(LogChannel logChannel, TTSListener tTSListener, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, String string, short s) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, s, 0);
        this.logCh.log(10000000, "[SpeakRequest#ctor] Called.");
        this.text = string;
        this.aborted = false;
        this.audioInfo = -1;
        this.requestCounter = 0;
        this.speakingFailed = false;
        this.responseSpeakPromptFailed = false;
    }

    public SpeakRequest(LogChannel logChannel, TTSListener tTSListener, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, String string, int n, short s) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, s, 0);
        this.logCh.log(10000000, "[SpeakRequest#ctor] Called.");
        this.text = string;
        this.promptType = n;
        this.aborted = false;
        this.audioInfo = -1;
        this.requestCounter = 0;
        this.speakingFailed = false;
        this.responseSpeakPromptFailed = false;
    }

    protected void initialize() {
        this.aborted = false;
        this.paused = false;
        this.audioInfo = -1;
        this.requestCounter = 0;
        this.speakingFailed = false;
        this.responseSpeakPromptFailed = false;
    }

    public String getText() {
        return this.text;
    }

    public void abort() {
        this.logCh.log(10000000, "[SpeakRequest#abort] Called.");
        if (!this.aborted) {
            this.logCh.log(10000000, "[SpeakRequest#abort] Abort speaking.");
            this.aborted = true;
            this.dsiCaller.dsiAbort(this.sourceId);
            this.incrementRequestCounter();
        } else {
            this.logCh.log(10000000, "[SpeakRequest#abort] Speaking already aborted, do nothing.");
        }
    }

    public void pause() {
        if (this.aborted) {
            this.logCh.log(10000000, "[SpeakRequest#pause] Speaking already aborted, do nothing.");
            return;
        }
        if (this.paused) {
            this.logCh.log(10000000, "[SpeakRequest#pause] Speaking already paused, do nothing.");
            return;
        }
        if (this.audioInfo != 1) {
            this.logCh.log(10000000, "[SpeakRequest#pause] Speaking not yet started, remember pause trigger for later.");
            this.pauseTriggered = true;
            return;
        }
        this.logCh.log(10000000, "[SpeakRequest#pause] Pause speaking.");
        this.paused = true;
        this.incrementRequestCounter();
        this.dsiCaller.dsiPause(this.sourceId);
    }

    public void resume() {
        if (!this.paused) {
            this.logCh.log(10000000, "[SpeakRequest#resume] Speaking is not paused, do nothing.");
            return;
        }
        if (this.aborted) {
            this.logCh.log(10000000, "[SpeakRequest#resume] Speaking has already been aborted, do nothing.");
            return;
        }
        this.incrementRequestCounter();
        this.dsiCaller.dsiResume(this.sourceId);
    }

    protected void incrementRequestCounter() {
        ++this.requestCounter;
        this.logCh.log(10000000, "[SpeakRequest#incrementRequestCounter]  -> counter = %1", (long)this.requestCounter);
    }

    protected void decrementRequestCounter() {
        --this.requestCounter;
        this.logCh.log(10000000, "[SpeakRequest#decrementRequestCounter]  -> counter = %1", (long)this.requestCounter);
    }

    protected int checkRequestFinished() {
        this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] Called, current requestCounter=%1", (long)this.requestCounter);
        if (this.responseSpeakPromptFailed && this.requestCounter == 0) {
            this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] speak request FAILED due to #responseSpeakPrompt(ERROR).");
            this.finish();
            return 3;
        }
        if (this.audioInfo == 7) {
            this.audioInfoPromptFailed = true;
            this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] speak request FAILED due to #updateAudioRequest(AUDIOINFO_PROMPT_FAILED).");
            return 1;
        }
        if (this.audioInfo == 3) {
            if (!this.isAborted()) {
                this.logCh.log(10000, "[SpeakRequest#checkRequestFinished] should never happen: received ABORT from TTS without trigger from HMI");
            }
            this.audioInfoPromptAborted = true;
            this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] speak request ABORTED due to #updateAudioRequest(AUDIOINFO_PROMPT_ABORTED).");
            return 1;
        }
        if (this.requestCounter == 0 && this.audioInfo == 0) {
            return this.getResultForAudioInfoIdle();
        }
        if (this.isAborted()) {
            this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] speak request was aborted, ignore start/processing/finish-updates.");
            return 1;
        }
        this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] Status of SpeakRequest: %1.", (Object)DSITTSCaller.audioInfoToString(this.audioInfo));
        if (this.audioInfo == 1) {
            if (this.paused) {
                this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] Set paused to false");
                this.paused = false;
                this.audioInfoPromptPaused = false;
            } else if (this.pauseTriggered) {
                this.pauseTriggered = false;
                this.pause();
                return 1;
            }
            return 5;
        }
        if (this.audioInfo == 8) {
            this.audioInfoPromptPaused = true;
            return 1;
        }
        return 1;
    }

    private int getResultForAudioInfoIdle() {
        int n = 2;
        boolean bl = true;
        if (this.audioInfoPromptAborted) {
            n = 4;
        } else if (this.isAborted()) {
            n = 4;
        } else if (this.isFailed()) {
            n = 3;
        } else if (this.isPaused()) {
            n = 8;
            bl = false;
        }
        this.logCh.log(10000000, "[SpeakRequest#checkRequestFinished] %1 speak request, status %2.", (Object)(bl ? "Finish" : "Don't finish"), (Object)TTSResult.resultToString(n));
        if (bl) {
            this.finish();
        }
        return n;
    }

    public boolean isAborted() {
        return this.aborted;
    }

    public boolean isFailed() {
        return this.audioInfoPromptFailed || this.speakingFailed;
    }

    public boolean isPaused() {
        return this.paused || this.audioInfoPromptPaused;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("SpeakRequest{");
        buffer.append("sourceID=");
        buffer.append(this.sourceId);
        buffer.append(", aborted=");
        buffer.append(this.aborted);
        buffer.append(", text=");
        buffer.append(this.text);
        buffer.append("}");
        return buffer.toString();
    }

    public void execute() {
        this.logCh.log(10000000, "[SpeakRequest#execute] Called.");
        if (this.promptType == 1) {
            this.dsiCaller.dsiSpeak(this.sourceId, this.text);
        } else {
            this.dsiCaller.dsiSpeak(this.sourceId, this.text, this.promptType);
        }
        this.incrementRequestCounter();
    }

    public void process() {
        this.logCh.log(10000000, "[SpeakRequest#process] Called.");
        AbstractRequest abstractRequest = this.requestProcessor.getRunningRequest();
        if (abstractRequest == null) {
            this.logCh.log(10000000, "[SpeakRequest#process] No running request.");
            if (this.requestProcessor.isEmpty()) {
                this.logCh.log(10000000, "[SpeakRequest#process] Empty request queue, set request to running.");
                this.execute();
                this.requestProcessor.setRunningRequest(this);
            } else {
                this.logCh.log(10000000, "[SpeakRequest#process] Should not happen, do nothing.");
            }
        } else {
            this.logCh.log(10000000, "[SpeakRequest#process] Another Request is already running: %1", (Object)abstractRequest);
            if (abstractRequest.getType() == 4) {
                this.logCh.log(10000000, "[SpeakRequest#process] Language change is running -> speaking failed: %1", (Object)abstractRequest);
                new TTSResult(this.ttsListener, 3).execute();
                return;
            }
            if (abstractRequest.getType() == 0) {
                this.logCh.log(10000000, "[SpeakRequest#process] Running request is of type SPEAK");
                short s = abstractRequest.getSourceId();
                if (s == this.sourceId && s != 33 && s != 34 && s != 37) {
                    this.logCh.log(10000000, "[SpeakRequest#process] Queue request, because source IDs are equal.");
                    this.requestProcessor.addRequest(this);
                } else {
                    this.logCh.log(10000000, "[SpeakRequest#process] Abort current request (because source IDs are NOT equal).");
                    ((SpeakRequest)abstractRequest).abort();
                    this.requestProcessor.removeSpeakRequestsFromQueue(abstractRequest.getSourceId());
                    this.requestProcessor.addRequest(this);
                }
            } else if (abstractRequest.getType() == 1) {
                this.logCh.log(10000000, "[SpeakRequest#process] Running request is of type SPEAK_SEPARATELY, abort!");
                ((SpeakRequest)abstractRequest).abort();
                this.requestProcessor.removeSpeakRequestsFromQueue(abstractRequest.getSourceId());
                this.requestProcessor.addRequest(this);
            } else {
                this.logCh.log(10000000, "[SpeakRequest#process] Add request to queue.");
                this.requestProcessor.addRequest(this);
            }
        }
    }

    public TTSResult responseSpeakPrompt(int n) {
        this.logCh.log(10000000, "[SpeakRequest#responseSpeakPrompt] Called, result: %1", (long)n);
        this.decrementRequestCounter();
        if (DSITTSCaller.isError(n)) {
            this.logCh.log(10000000, "[SpeakRequest#responseSpeakPrompt] Error occured.");
            this.responseSpeakPromptFailed = true;
            return new TTSResult(this.ttsListener, this.checkRequestFinished());
        }
        if (!this.isAborted()) {
            this.logCh.log(10000000, "[SpeakRequest#responseSpeakPrompt] Request audio trigger.");
            this.dsiCaller.dsiRequestAudioTrigger(this.sourceId);
            this.incrementRequestCounter();
            return new TTSResult(this.ttsListener, 1);
        }
        this.logCh.log(10000000, "[SpeakRequest#responseSpeakPrompt] Check if request is finished.");
        return new TTSResult(this.ttsListener, this.checkRequestFinished());
    }

    public TTSResult responseAudioTrigger(short s, int n) {
        this.logCh.log(10000000, "[SpeakRequest#responseAudioTrigger] Called, sourceID: %1, result: %2", (long)s, (long)n);
        this.decrementRequestCounter();
        if (DSITTSCaller.isError(n)) {
            this.logCh.log(10000000, "[SpeakRequest#responseAudioTrigger] Error occured.");
            this.speakingFailed = true;
        }
        return new TTSResult(this.ttsListener, this.checkRequestFinished());
    }

    public TTSResult updateAudioRequest(int n, int n2) {
        this.logCh.log(10000000, "[SpeakRequest#updateAudioRequest] Called, audioInfo: %1", (Object)DSITTSCaller.audioInfoToString(n));
        this.audioInfo = n;
        return new TTSResult(this.ttsListener, this.checkRequestFinished());
    }

    public TTSResult abortQueued() {
        return new TTSResult(this.ttsListener, 4);
    }
}

