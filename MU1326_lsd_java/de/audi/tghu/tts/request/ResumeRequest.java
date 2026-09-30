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

public class ResumeRequest
extends AbstractRequest {
    public ResumeRequest(LogChannel logChannel, TTSListener tTSListener, DSITTSCaller dSITTSCaller, RequestQueue requestQueue, short s) {
        super(logChannel, tTSListener, dSITTSCaller, requestQueue, s, 0);
        this.logCh.log(10000000, "[ResumeRequest#ctor] Called.");
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ResumeRequest{");
        buffer.append("sourceID=");
        buffer.append(this.sourceId);
        buffer.append("}");
        return buffer.toString();
    }

    public void process() {
        AbstractRequest abstractRequest = this.requestProcessor.getRunningRequest();
        if (abstractRequest == null) {
            this.logCh.log(10000000, "[ResumeRequest#process] No running request, nothing to resume.");
        } else if (abstractRequest.getType() == 0) {
            this.logCh.log(10000000, "[ResumeRequest#process] Speak request is running: %1", (Object)abstractRequest);
            if (abstractRequest.getSourceId() == this.sourceId) {
                this.logCh.log(10000000, "[ResumeRequest#process] Resume speaking of source ID '%1'", (long)abstractRequest.getSourceId());
                ((SpeakRequest)abstractRequest).resume();
            } else {
                this.logCh.log(10000000, "[ResumeRequest#process] Running speak request is not of the same source, do nothing.");
            }
        } else {
            this.logCh.log(10000000, "[ResumeRequest#process] No running speak request, nothing to resume.");
        }
    }

    public void execute() {
        this.logCh.log(10000000, "[ResumeRequest#process] Nothing to do.");
    }
}

