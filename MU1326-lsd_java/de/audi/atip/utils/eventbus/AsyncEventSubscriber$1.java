/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.eventbus.AsyncEventSubscriber;

class AsyncEventSubscriber$1
implements Runnable {
    private final /* synthetic */ Object val$event;
    private final /* synthetic */ AsyncEventSubscriber this$0;

    AsyncEventSubscriber$1(AsyncEventSubscriber asyncEventSubscriber, Object object) {
        this.this$0 = asyncEventSubscriber;
        this.val$event = object;
    }

    @Override
    public void run() {
        AsyncEventSubscriber.access$001(this.this$0, this.val$event);
    }
}

