/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.queue;

import de.audi.app.media.queue.IQueueExecutionContext;
import de.audi.app.media.queue.Queue;

class Queue$QueueExecutionContextImpl
implements IQueueExecutionContext {
    private final Queue queue;
    private final /* synthetic */ Queue this$0;

    public Queue$QueueExecutionContextImpl(Queue queue, Queue queue2) {
        this.this$0 = queue;
        this.queue = queue2;
    }

    @Override
    public void jobFinished() {
        Queue.access$000(this.queue);
    }
}

