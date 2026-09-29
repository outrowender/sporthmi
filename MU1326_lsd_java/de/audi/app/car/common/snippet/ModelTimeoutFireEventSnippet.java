/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.snippet;

import de.audi.app.car.common.snippet.ModelTimeoutFireEventSnippet$1;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class ModelTimeoutFireEventSnippet {
    private static final long DEFAULT_TIMEOUT;
    private static final int DEFAULT_TERMINAL;
    private final Object mutex = new Object();
    private final HMIModelApp model;
    private final int terminal;
    private final Timer fireEventTimer;
    private final TimerListener fireEventTimerListener = new ModelTimeoutFireEventSnippet$1(this);

    public ModelTimeoutFireEventSnippet(HMIModelApp hMIModelApp) {
        this(hMIModelApp, 0, 0);
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

    static /* synthetic */ Timer access$000(ModelTimeoutFireEventSnippet modelTimeoutFireEventSnippet) {
        return modelTimeoutFireEventSnippet.fireEventTimer;
    }

    static /* synthetic */ Object access$100(ModelTimeoutFireEventSnippet modelTimeoutFireEventSnippet) {
        return modelTimeoutFireEventSnippet.mutex;
    }

    static /* synthetic */ int access$200(ModelTimeoutFireEventSnippet modelTimeoutFireEventSnippet) {
        return modelTimeoutFireEventSnippet.terminal;
    }

    static /* synthetic */ HMIModelApp access$300(ModelTimeoutFireEventSnippet modelTimeoutFireEventSnippet) {
        return modelTimeoutFireEventSnippet.model;
    }
}

