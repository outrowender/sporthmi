/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.dispatching;

import de.audi.atip.utils.dispatching.IDispatcher;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;

public class DispatcherBaseAdapter
implements IDispatcher {
    private final DispatcherBase dispatcherBase;

    public DispatcherBaseAdapter(DispatcherBase dispatcherBase) {
        this.dispatcherBase = dispatcherBase;
    }

    public void execute(Runnable runnable) {
        this.dispatcherBase.execute(runnable);
    }

    public IDispatcher.ICancelable execute(Runnable runnable, long l) {
        final Job job = this.dispatcherBase.execute(runnable, l);
        return new IDispatcher.ICancelable(){

            public void cancel() {
                job.cancel();
            }
        };
    }

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

