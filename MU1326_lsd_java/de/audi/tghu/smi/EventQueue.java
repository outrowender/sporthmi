/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.smi;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.smi.SMI;

class EventQueue {
    private SMI smi;
    private LogChannel logChan;
    private int size = 0;
    private int[] eventBuffer;
    private int nextEventIdx = 0;
    private int lastEventIdx;

    public EventQueue(SMI sMI, LogChannel logChannel, int n) {
        this.smi = sMI;
        this.logChan = logChannel;
        this.eventBuffer = new int[n];
        this.lastEventIdx = this.eventBuffer.length - 1;
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public synchronized void enqueueEvent(int n) {
        if (n <= -1) {
            return;
        }
        if (this.size == this.eventBuffer.length) {
            this.logChan.log(1000, "[EventQueue#enqueueEvent] event queue overflow (capacity = %1), cannot add event (EVENTID#%2)", (long)this.eventBuffer.length, (long)n);
            this.smi.criticalError("event queue overflow");
            return;
        }
        this.lastEventIdx = (this.lastEventIdx + 1) % this.eventBuffer.length;
        this.eventBuffer[this.lastEventIdx] = n;
        ++this.size;
    }

    public synchronized int getNextEvent() {
        if (this.isEmpty()) {
            return -1;
        }
        int n = this.eventBuffer[this.nextEventIdx];
        this.nextEventIdx = (this.nextEventIdx + 1) % this.eventBuffer.length;
        --this.size;
        return n;
    }
}

