/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.request.RequestQueue;
import de.audi.tghu.tts.request.SpeakRequest;
import de.esolutions.fw.util.commons.Buffer;

public class DetailedSpeakRequest
extends SpeakRequest {
    private char[] charsToSpeak;
    private int charCounter = 0;

    public DetailedSpeakRequest(LogChannel logChannel, TTSListener tTSListener, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, String string, short s) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, string, s);
        this.logCh.log(10000000, "[DetailedSpeakRequest#ctor] Called.");
        this.text = string;
        this.type = 1;
        this.charsToSpeak = this.text.toCharArray();
    }

    protected void initialize() {
        super.initialize();
        ++this.charCounter;
    }

    protected int checkRequestFinished() {
        this.logCh.log(10000000, "[DetailedSpeakRequest#checkRequestFinished] Called.");
        if (this.requestCounter == 0 && this.isAborted()) {
            this.finish();
            this.logCh.log(10000000, "[DetailedSpeakRequest#checkRequestFinished] Finish speak request with ABORTED.");
            return 4;
        }
        if (this.requestCounter == 0 && this.audioInfo == 0) {
            if (this.charCounter < this.charsToSpeak.length - 1) {
                this.logCh.log(10000000, "[DetailedSpeakRequest#checkRequestFinished] Speak next character.");
                this.initialize();
                this.execute();
                return 1;
            }
            this.finish();
            this.logCh.log(10000000, "[DetailedSpeakRequest#checkRequestFinished] Finish speak request with FINISHED.");
            return 2;
        }
        return 1;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("DetailedSpeakRequest{");
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
        this.logCh.log(10000000, "[DetailedSpeakRequest#execute] Called.");
        this.dsiCaller.dsiSpeak(this.sourceId, String.valueOf(this.charsToSpeak[this.charCounter]));
        this.incrementRequestCounter();
    }
}

