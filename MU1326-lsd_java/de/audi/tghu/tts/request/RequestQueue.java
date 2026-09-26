/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tts.request;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.tts.request.AbstractRequest;
import de.audi.tghu.tts.request.SpeakRequest;
import de.audi.tghu.tts.request.TTSResult;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class RequestQueue {
    private static final int CACHE_SIZE;
    private List queue;
    private LogChannel logCh;
    private AbstractRequest runningRequest;
    private int speakRequestCounter = 0;

    public RequestQueue(LogChannel logChannel) {
        this.logCh = logChannel;
        this.logCh.log(-2137614336, "[RequestQueue#ctor] Called.");
        this.queue = new Vector(8);
    }

    private void increaseSpeakRequestCounter() {
        ++this.speakRequestCounter;
        this.logCh.log(-2137614336, "[RequestQueue#increaseSpeakRequestCounter] Called, counter: %1", (long)this.speakRequestCounter);
    }

    private void decreaseSpeakRequestCounter() {
        --this.speakRequestCounter;
        this.logCh.log(-2137614336, "[RequestQueue#decreaseSpeakRequestCounter] Called, counter: %1", (long)this.speakRequestCounter);
    }

    public synchronized AbstractRequest getRunningRequest() {
        return this.runningRequest;
    }

    synchronized void setRunningRequest(AbstractRequest abstractRequest) {
        this.logCh.log(-2137614336, "[RequestQueue#setRunningRequest] Called, request: %1", (Object)abstractRequest);
        this.runningRequest = abstractRequest;
    }

    public synchronized boolean isEmpty() {
        return this.queue.isEmpty();
    }

    synchronized void addRequest(AbstractRequest abstractRequest) {
        this.logCh.log(-2137614336, "[RequestQueue#addRequest] Called, request: %1", (Object)abstractRequest);
        if (abstractRequest.getType() == 0) {
            if (this.speakRequestCounter == 8) {
                this.logCh.log(-2137614336, "[RequestQueue#addRequest] Request is of type 'SpeakRequest' and cache size is reached, ignore request.");
            } else {
                this.increaseSpeakRequestCounter();
                this.queue.add(abstractRequest);
            }
        } else {
            this.queue.add(abstractRequest);
        }
    }

    public synchronized void processRequest(AbstractRequest abstractRequest) {
        this.logCh.log(-2137614336, "[RequestQueue#processRequest] Called, request: %1", (Object)abstractRequest);
        abstractRequest.process();
    }

    synchronized void finishRequest() {
        this.setRunningRequest(null);
        if (!this.queue.isEmpty()) {
            AbstractRequest abstractRequest = (AbstractRequest)this.queue.remove(0);
            if (abstractRequest.getType() == 0) {
                this.decreaseSpeakRequestCounter();
            }
            this.setRunningRequest(abstractRequest);
            this.logCh.log(-2137614336, "[RequestQueue#finishRequest] Execute next request object: '%1'", (Object)this.runningRequest);
            abstractRequest.execute();
        } else {
            this.logCh.log(-2137614336, "[RequestQueue#finishRequest] No further request objects available.");
        }
    }

    synchronized void removeSpeakRequestsFromQueue(short s) {
        this.logCh.log(-2137614336, "[RequestQueue#removeSpeakRequestsFromQueue] Called: %1", (long)s);
        Iterator iterator = this.queue.iterator();
        while (iterator.hasNext()) {
            this.logCh.log(-2137614336, "[RequestQueue#removeSpeakRequestsFromQueue] Iterate over queue and remove SPEAK request with same source ID.");
            AbstractRequest abstractRequest = (AbstractRequest)iterator.next();
            if (abstractRequest.getType() != 0 || abstractRequest.getSourceId() != s) continue;
            this.logCh.log(-2137614336, "[RequestQueue#removeSpeakRequestsFromQueue] Request removed: %1", (Object)abstractRequest);
            iterator.remove();
            this.decreaseSpeakRequestCounter();
            if (!(abstractRequest instanceof SpeakRequest)) continue;
            ((SpeakRequest)abstractRequest).abortQueued().execute();
        }
        this.logCh.log(-2137614336, "[RequestQueue#removeSpeakRequestsFromQueue] Left.");
    }

    synchronized void cleanRequestQueueForLanguageChange() {
        this.logCh.log(-2137614336, "[RequestQueue#cleanRequestQueueForLanguageChange] Called!");
        Iterator iterator = this.queue.iterator();
        while (iterator.hasNext()) {
            this.logCh.log(-2137614336, "[RequestQueue#cleanRequestQueueForLanguageChange] Iterate over queue and remove request");
            AbstractRequest abstractRequest = (AbstractRequest)iterator.next();
            int n = abstractRequest.getType();
            if (!AbstractRequest.isAbortableByLanguageChange(n)) {
                this.logCh.log(-2137614336, "[RequestQueue#cleanRequestQueueForLanguageChange] Keep request of type %1", (long)n);
                continue;
            }
            this.logCh.log(-2137614336, "[RequestQueue#cleanRequestQueueForLanguageChange] Remove request of type %1 -> including abort", (long)n);
            if (n == 0) {
                this.decreaseSpeakRequestCounter();
            }
            iterator.remove();
            abstractRequest.abortQueued().execute();
        }
        this.logCh.log(-2137614336, "[RequestQueue#cleanRequestQueueForLanguageChange] Left.");
    }

    public synchronized TTSResult responseAudioTrigger(short s, int n) {
        if (this.runningRequest != null) {
            return this.runningRequest.responseAudioTrigger(s, n);
        }
        return new TTSResult(null, 1);
    }

    public synchronized TTSResult responseSpeakPrompt(int n) {
        if (this.runningRequest != null) {
            return this.runningRequest.responseSpeakPrompt(n);
        }
        return new TTSResult(null, 1);
    }

    public synchronized TTSResult responsePlayTone(int n) {
        if (this.runningRequest != null) {
            return this.runningRequest.responsePlayTone(n);
        }
        return new TTSResult(null, 1);
    }

    public synchronized TTSResult updateAudioRequest(int n, int n2) {
        if (this.runningRequest != null) {
            return this.runningRequest.updateAudioRequest(n, n2);
        }
        this.logCh.log(-2137614336, "[RequestQueue#updateAudioRequest] no running request -> TTSResult_NONE.");
        return new TTSResult(null, 1);
    }

    public synchronized TTSResult responseInit(int n) {
        if (this.runningRequest != null) {
            return this.runningRequest.responseInit(n);
        }
        return new TTSResult(null, 1);
    }

    public synchronized TTSResult responseSetLanguage(int n) {
        if (this.runningRequest != null) {
            return this.runningRequest.responseSetLanguage(n);
        }
        return new TTSResult(null, 1);
    }
}

