/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.esolutions.fw.util.commons.job.Job;

public interface EventDispatcher {
    public Job postEvent(ATIPEvent var1);

    public Job postEvent(ATIPEvent var1, long var2);

    public ATIPEvent peekEvent();

    public boolean isDispatchThread();

    public void setAdaptiveSleepingEnabled(boolean var1);

    public void doCheckedSleeping();

    public boolean doCheckedSleepingInternal();
}

