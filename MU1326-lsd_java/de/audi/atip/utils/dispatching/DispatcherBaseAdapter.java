/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.dispatching.DispatcherBaseAdapter$1;
import de.audi.atip.utils.dispatching.IDispatcher;
import de.audi.atip.utils.dispatching.IDispatcher$ICancelable;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;

public class DispatcherBaseAdapter
implements IDispatcher {
    private final DispatcherBase dispatcherBase;

    public DispatcherBaseAdapter(DispatcherBase dispatcherBase) {
        this.dispatcherBase = dispatcherBase;
    }

    @Override
    public void execute(Runnable runnable) {
        this.dispatcherBase.execute(runnable);
    }

    @Override
    public IDispatcher$ICancelable execute(Runnable runnable, long l) {
        Job job = this.dispatcherBase.execute(runnable, l);
        return new DispatcherBaseAdapter$1(this, job);
    }

    @Override
    public boolean isDispatchThread() {
        return this.dispatcherBase.isDispatchThread();
    }

    public void start() {
        this.dispatcherBase.start();
    }

    public void stop() {
        this.dispatcherBase.stop();
    }

    public String getDispatcherName() {
        return this.dispatcherBase.getDispatcherName();
    }
}

