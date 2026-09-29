/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.utils.dispatching.IDispatcher;

final class Handler$1
extends DefaultTimerListener {
    private final /* synthetic */ IDispatcher val$dispatcher;
    private final /* synthetic */ Runnable val$runnable;

    Handler$1(IDispatcher iDispatcher, Runnable runnable) {
        this.val$dispatcher = iDispatcher;
        this.val$runnable = runnable;
    }

    @Override
    public void fireTimer(Timer timer) {
        this.val$dispatcher.execute(this.val$runnable);
    }
}

