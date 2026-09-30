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
import de.esolutions.fw.util.commons.Buffer;

public class AbortRequest
extends AbstractRequest {
    public AbortRequest(LogChannel logChannel, TTSListener tTSListener, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, short s) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, s, 0);
        this.logCh.log(10000000, "[AbortRequest#ctor] Called.");
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("AbortRequest{");
        buffer.append("sourceID=");
        buffer.append(this.sourceId);
        buffer.append("}");
        return buffer.toString();
    }

    public void process() {
        AbstractRequest abstractRequest = this.requestProcessor.getRunningRequest();
        if (abstractRequest == null) {
            this.logCh.log(10000000, "[AbortRequest#process] No running request, nothing to abort.");
        } else if (abstractRequest.getType() == 0 || abstractRequest.getType() == 1) {
            this.logCh.log(10000000, "[AbortRequest#process] Speak request is running: %1", (Object)abstractRequest);
            if (abstractRequest.getSourceId() == this.sourceId) {
                this.logCh.log(10000000, "[AbortRequest#process] Abort speaking of source ID '%1'", (long)abstractRequest.getSourceId());
                ((SpeakRequest)abstractRequest).abort();
            } else {
                this.logCh.log(10000000, "[AbortRequest#process] Running speak request is not of the same source, do nothing.");
            }
            this.requestProcessor.removeSpeakRequestsFromQueue(this.sourceId);
        } else {
            this.logCh.log(10000000, "[AbortRequest#process] No running speak request, nothing to abort.");
        }
    }

    public void execute() {
        this.logCh.log(10000000, "[AbortRequest#process] Nothing to do.");
    }
}

