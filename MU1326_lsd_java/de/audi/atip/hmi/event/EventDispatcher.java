/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.esolutions.fw.util.commons.job.Job;

public interface EventDispatcher {
    default public Job postEvent(ATIPEvent aTIPEvent) {
    }

    default public Job postEvent(ATIPEvent aTIPEvent, long l) {
    }

    default public ATIPEvent peekEvent() {
    }

    default public boolean isDispatchThread() {
    }

    default public void setAdaptiveSleepingEnabled(boolean bl) {
    }

    default public void doCheckedSleeping() {
    }

    default public boolean doCheckedSleepingInternal() {
    }
}

