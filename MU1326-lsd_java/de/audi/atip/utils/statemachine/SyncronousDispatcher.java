/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.audi.atip.utils.statemachine.Handler;

public class SyncronousDispatcher
implements IDispatcher {
    @Override
    public void execute(Runnable runnable) {
        runnable.run();
    }

    @Override
    public IDispatcher$ICancelable execute(Runnable runnable, long l) {
        return Handler.startTimerForDelayedRunnable(runnable, l, this);
    }

    @Override
    public boolean isDispatchThread() {
        return true;
    }

    public void start() {
        throw new UnsupportedOperationException();
    }

    public void stop() {
        throw new UnsupportedOperationException();
    }

    public String getDispatcherName() {
        return "SyncronousDispatcher";
    }
}

