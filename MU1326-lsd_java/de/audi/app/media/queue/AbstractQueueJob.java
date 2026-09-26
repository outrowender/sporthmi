/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.queue;

import de.audi.app.media.queue.IQueueExecutionContext;
import de.audi.app.media.queue.IQueueJob;

public abstract class AbstractQueueJob
implements IQueueJob {
    private volatile IQueueExecutionContext exContext;

    public abstract void start() {
    }

    @Override
    public final void start(IQueueExecutionContext iQueueExecutionContext) {
        this.setExecutionContext(iQueueExecutionContext);
        this.start();
    }

    private final void setExecutionContext(IQueueExecutionContext iQueueExecutionContext) {
        this.exContext = iQueueExecutionContext;
    }

    protected final IQueueExecutionContext getExecutionContext() {
        return this.exContext;
    }
}

