/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.reactive.operations.AsyncOperation$1;

class AsyncOperation$1$1
implements Runnable {
    private final /* synthetic */ Object val$data;
    private final /* synthetic */ AsyncOperation$1 this$1;

    AsyncOperation$1$1(AsyncOperation$1 asyncOperation$1, Object object) {
        this.this$1 = asyncOperation$1;
        this.val$data = object;
    }

    @Override
    public void run() {
        AsyncOperation$1.access$000(this.this$1).accept(this.val$data);
    }
}

