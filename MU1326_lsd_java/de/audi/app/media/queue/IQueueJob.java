/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.queue;

import de.audi.app.media.queue.IQueueExecutionContext;

public interface IQueueJob {
    default public int getType() {
    }

    default public String getName() {
    }

    default public void start(IQueueExecutionContext iQueueExecutionContext) {
    }

    default public void abort(boolean bl) {
    }
}

