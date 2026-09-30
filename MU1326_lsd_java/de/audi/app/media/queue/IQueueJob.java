/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.queue;

import de.audi.app.media.queue.IQueueExecutionContext;

public interface IQueueJob {
    public int getType();

    public String getName();

    public void start(IQueueExecutionContext var1);

    public void abort(boolean var1);
}

