/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class RunnableEvent
extends ATIPEvent {
    private static final int EVENT_ID = 10501;
    private final boolean processBeforeFirstScreen;
    private final Runnable doRun;

    public RunnableEvent(Runnable runnable) {
        this(false, runnable);
    }

    public RunnableEvent(boolean bl, Runnable runnable) {
        super((ATIPEventListener)null, 10501);
        this.processBeforeFirstScreen = bl;
        this.doRun = runnable;
    }

    public final Runnable getRunnable() {
        return this.doRun;
    }

    public final void dispatch() {
        this.doRun.run();
    }

    public final boolean isProcessBeforeFirstScreen() {
        return this.processBeforeFirstScreen;
    }

    public final String toString() {
        return "RunnableEvent(" + this.doRun + ')';
    }
}

