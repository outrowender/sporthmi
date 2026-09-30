/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.i18n.Language;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.TTSOperable;
import de.audi.tghu.tts.request.AbstractRequest;
import de.audi.tghu.tts.request.RequestQueue;
import de.audi.tghu.tts.request.TTSResult;
import de.esolutions.fw.util.commons.Buffer;

public class SetLanguageRequest
extends AbstractRequest {
    TTSOperable ttsOperable;
    private Language language;

    public SetLanguageRequest(LogChannel logChannel, TTSListener tTSListener, TTSOperable tTSOperable, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, Language language) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, (short)-1, 4);
        this.logCh.log(10000000, "[SetLanguageRequest#ctor] Called.");
        this.language = language;
        this.ttsOperable = tTSOperable;
    }

    public void execute() {
        this.logCh.log(10000000, "[SetLanguageRequest#execute] Called, language: %1", (Object)this.language);
        this.dsiCaller.dsiSetLanguage(this.sourceId, this.language);
    }

    public void process() {
        this.logCh.log(10000000, "[SetLanguageRequest#process] Called.");
        AbstractRequest abstractRequest = this.requestProcessor.getRunningRequest();
        if (abstractRequest == null) {
            this.logCh.log(10000000, "[SetLanguageRequest#process] No running request.");
            if (this.requestProcessor.isEmpty()) {
                this.logCh.log(10000000, "[SetLanguageRequest#process] Empty request queue, set request to running.");
                this.execute();
                this.requestProcessor.setRunningRequest(this);
            }
        } else {
            int n = abstractRequest.getType();
            if (AbstractRequest.isAbortableByLanguageChange(n)) {
                abstractRequest.abort();
            }
            this.requestProcessor.cleanRequestQueueForLanguageChange();
            this.requestProcessor.addRequest(this);
        }
    }

    public TTSResult responseSetLanguage(int n) {
        this.logCh.log(10000000, "[SetLanguageRequest#responseSetLanguage] Called, result: %1", (long)n);
        if (n == 0) {
            this.ttsOperable.responseSetLanguageComplete();
        } else {
            this.logCh.log(10000, "[SetLanguageRequest#responseSetLanguage] DSI answered with error code: %1 - no TTS service will be started.", (long)n);
        }
        this.finish();
        return new TTSResult(null, 1);
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("SetLanguageRequest{");
        buffer.append("sourceID=");
        buffer.append(this.sourceId);
        buffer.append(", language=");
        buffer.append(this.language);
        buffer.append("}");
        return buffer.toString();
    }
}

