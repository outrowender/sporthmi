/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.snippet;

import de.audi.app.car.common.snippet.TimeoutFireSMEventSnippet$1;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class TimeoutFireSMEventSnippet {
    private static final long DEFAULT_TIMEOUT;
    private static final int DEFAULT_TERMINAL;
    private final Object mutex = new Object();
    private final HMIService hmiService;
    private final int smEventID;
    private final int terminal;
    private final Timer fireEventTimer;
    private final TimerListener fireEventTimerListener = new TimeoutFireSMEventSnippet$1(this);

    public TimeoutFireSMEventSnippet(HMIService hMIService, int n) {
        this(hMIService, n, 0, 0);
    }

    public TimeoutFireSMEventSnippet(HMIService hMIService, int n, long l, int n2) {
        this.fireEventTimer = new Timer(new StringBuffer().append("TimeoutFireSMEventSnippet(eventID='").append(n).append("')").toString(), l, true, this.fireEventTimerListener);
        this.hmiService = hMIService;
        this.smEventID = n;
        this.terminal = n2;
    }

    public void triggerTimeout() {
        this.fireEventTimer.restart();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void cancelTimeout() {
        Object object = this.mutex;
        synchronized (object) {
            this.fireEventTimer.cancel();
        }
    }

    static /* synthetic */ Timer access$000(TimeoutFireSMEventSnippet timeoutFireSMEventSnippet) {
        return timeoutFireSMEventSnippet.fireEventTimer;
    }

    static /* synthetic */ Object access$100(TimeoutFireSMEventSnippet timeoutFireSMEventSnippet) {
        return timeoutFireSMEventSnippet.mutex;
    }

    static /* synthetic */ int access$200(TimeoutFireSMEventSnippet timeoutFireSMEventSnippet) {
        return timeoutFireSMEventSnippet.terminal;
    }

    static /* synthetic */ int access$300(TimeoutFireSMEventSnippet timeoutFireSMEventSnippet) {
        return timeoutFireSMEventSnippet.smEventID;
    }

    static /* synthetic */ HMIService access$400(TimeoutFireSMEventSnippet timeoutFireSMEventSnippet) {
        return timeoutFireSMEventSnippet.hmiService;
    }
}

