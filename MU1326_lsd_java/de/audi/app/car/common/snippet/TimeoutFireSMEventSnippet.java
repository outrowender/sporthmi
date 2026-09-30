/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.snippet;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class TimeoutFireSMEventSnippet {
    private static final long DEFAULT_TIMEOUT = 1000L;
    private static final int DEFAULT_TERMINAL = 0;
    private final Object mutex = new Object();
    private final HMIService hmiService;
    private final int smEventID;
    private final int terminal;
    private final Timer fireEventTimer;
    private final TimerListener fireEventTimerListener = new TimerListener(){

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            if (timer.equals(TimeoutFireSMEventSnippet.this.fireEventTimer)) {
                Object object = TimeoutFireSMEventSnippet.this.mutex;
                synchronized (object) {
                    TimeoutFireSMEventSnippet.this.hmiService.fireSMEvent(TimeoutFireSMEventSnippet.this.terminal, TimeoutFireSMEventSnippet.this.smEventID);
                }
            }
        }

        public void cancelTimer(Timer timer) {
        }
    };

    public TimeoutFireSMEventSnippet(HMIService hMIService, int n) {
        this(hMIService, n, 1000L, 0);
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
}

