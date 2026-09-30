/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.DSITTSCaller;
import de.audi.tghu.tts.TTSOperable;
import de.audi.tghu.tts.request.AbstractRequest;
import de.audi.tghu.tts.request.RequestQueue;
import de.audi.tghu.tts.request.TTSResult;
import de.esolutions.fw.util.commons.Buffer;

public class InitRequest
extends AbstractRequest {
    TTSOperable ttsOperable;

    public InitRequest(LogChannel logChannel, TTSListener tTSListener, TTSOperable tTSOperable, DSITTSCaller dSITTSCaller, RequestQueue requestQueue) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, (short)-1, 3);
        this.logCh.log(10000000, "[InitRequest#ctor] Called.");
        this.ttsOperable = tTSOperable;
    }

    public void execute() {
        this.logCh.log(10000000, "[InitRequest#execute] Called.");
        this.dsiCaller.dsiInitTTSEngine(this.sourceId);
    }

    public void process() {
        this.logCh.log(10000000, "[InitRequest#process] Called.");
        super.process();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("InitRequest{");
        buffer.append("sourceID=");
        buffer.append(this.sourceId);
        buffer.append("}");
        return buffer.toString();
    }

    public TTSResult responseInit(int n) {
        this.logCh.log(10000000, "[InitRequest#responseInit] Called, result: %1", (long)n);
        this.finish();
        this.ttsOperable.fullyOperable();
        return new TTSResult(null, 1);
    }
}

