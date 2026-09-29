/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.request.AbstractRequest;
import de.audi.tghu.tts.request.RequestQueue;
import de.audi.tghu.tts.request.SpeakRequest;
import de.audi.tghu.tts.request.TTSResult;
import de.esolutions.fw.util.commons.Buffer;

public class ToneRequest
extends AbstractRequest {
    private int beepValue;
    private int requestCounter = 0;
    private int audioInfo = -1;

    public ToneRequest(int n, LogChannel logChannel, TTSListener tTSListener, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, short s) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, s, 5);
        this.beepValue = n;
        this.logCh.log(-2137614336, "[ToneRequest#ctor] Called, beepValue=%1", (long)n);
    }

    private void increaseRequestCounter() {
        ++this.requestCounter;
    }

    private void decreaseRequestCounter() {
        --this.requestCounter;
    }

    @Override
    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ToneRequest{");
        buffer.append("sourceID=");
        buffer.append(this.sourceId);
        buffer.append(", beepValue=");
        buffer.append(this.beepValue);
        buffer.append("}");
        return buffer.toString();
    }

    @Override
    public void execute() {
        this.dsiCaller.dsiPlayTone(this.beepValue, this.sourceId);
        this.increaseRequestCounter();
    }

    @Override
    public void process() {
        AbstractRequest abstractRequest = this.requestProcessor.getRunningRequest();
        if (abstractRequest == null) {
            if (this.requestProcessor.isEmpty()) {
                this.logCh.log(-2137614336, "[ToneRequest#process] Empty request queue, set request to running.");
                this.execute();
                this.requestProcessor.setRunningRequest(this);
            } else {
                this.logCh.log(-2137614336, "[ToneRequest#process] Should not happen, do nothing.");
            }
        } else {
            this.logCh.log(-2137614336, "[ToneRequest#process] Another Request is already running: %1", (Object)abstractRequest);
            if (abstractRequest.getType() == 0) {
                this.logCh.log(-2137614336, "[ToneRequest#process] Running request is of type SPEAK");
                if (abstractRequest.getSourceId() == this.sourceId) {
                    this.logCh.log(-2137614336, "[ToneRequest#process] Queue request, because source IDs are equal.");
                    this.requestProcessor.addRequest(this);
                } else {
                    this.logCh.log(-2137614336, "[ToneRequest#process] Abort current request (because source IDs are NOT equal).");
                    ((SpeakRequest)abstractRequest).abort();
                    this.requestProcessor.removeSpeakRequestsFromQueue(abstractRequest.getSourceId());
                    this.requestProcessor.addRequest(this);
                }
            } else {
                this.logCh.log(-2137614336, "[ToneRequest#process] Add request to queue.");
                this.requestProcessor.addRequest(this);
            }
        }
    }

    @Override
    public TTSResult responsePlayTone(int n) {
        this.logCh.log(-2137614336, "[ToneRequest#responsePlayTone] Called, result: %1", (long)n);
        this.decreaseRequestCounter();
        if (DSITTSCaller.isError(n)) {
            this.logCh.log(-2137614336, "[ToneRequest#responsePlayTone] Error occured.");
            this.finish();
            return new TTSResult(this.ttsListener, 7);
        }
        return new TTSResult(this.ttsListener, this.checkRequestFinished());
    }

    @Override
    public TTSResult updateAudioRequest(int n, int n2) {
        this.audioInfo = n;
        return new TTSResult(this.ttsListener, this.checkRequestFinished());
    }

    private int checkRequestFinished() {
        if (this.audioInfo == 4) {
            this.logCh.log(-2137614336, "[ToneRequest#checkRequestFinished] Called -> request not yet finished: audioInfo=%1, requestCounter=%2", (Object)DSITTSCaller.audioInfoToString(this.audioInfo), (long)this.requestCounter);
            return 6;
        }
        if (this.audioInfo == 0 && this.requestCounter == 0) {
            this.logCh.log(-2137614336, "[ToneRequest#checkRequestFinished] Called -> request finished: audioInfo=%1, requestCounter=%2", (Object)DSITTSCaller.audioInfoToString(this.audioInfo), (long)this.requestCounter);
            this.finish();
            return 7;
        }
        this.logCh.log(-2137614336, "[ToneRequest#checkRequestFinished] Called -> request not yet finished: audioInfo=%1, requestCounter=%2", (Object)DSITTSCaller.audioInfoToString(this.audioInfo), (long)this.requestCounter);
        return 1;
    }

    @Override
    public TTSResult abortQueued() {
        return new TTSResult(this.ttsListener, 4);
    }
}

