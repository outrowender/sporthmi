/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.snippet;

import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class ModelTimeoutFireEventSnippet {
    private static final long DEFAULT_TIMEOUT = 1000L;
    private static final int DEFAULT_TERMINAL = 0;
    private final Object mutex = new Object();
    private final HMIModelApp model;
    private final int terminal;
    private final Timer fireEventTimer;
    private final TimerListener fireEventTimerListener = new TimerListener(){

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            if (timer.equals(ModelTimeoutFireEventSnippet.this.fireEventTimer)) {
                Object object = ModelTimeoutFireEventSnippet.this.mutex;
                synchronized (object) {
                    ModelTimeoutFireEventSnippet.this.model.fireEvent(ModelTimeoutFireEventSnippet.this.terminal);
                }
            }
        }

        public void cancelTimer(Timer timer) {
        }
    };

    public ModelTimeoutFireEventSnippet(HMIModelApp hMIModelApp) {
        this(hMIModelApp, 1000L, 0);
    }

    public ModelTimeoutFireEventSnippet(HMIModelApp hMIModelApp, long l, int n) {
        this.fireEventTimer = new Timer(new StringBuffer().append("ModelTimeoutFireEventTimer(").append(hMIModelApp.getName()).append(")").toString(), l, true, this.fireEventTimerListener);
        this.model = hMIModelApp;
        this.terminal = n;
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

