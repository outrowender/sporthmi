/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.reactive.operations.DebounceOperation$1;

class DebounceOperation$1$1
implements Runnable {
    private final /* synthetic */ Object val$data;
    private final /* synthetic */ DebounceOperation$1 this$1;

    DebounceOperation$1$1(DebounceOperation$1 debounceOperation$1, Object object) {
        this.this$1 = debounceOperation$1;
        this.val$data = object;
    }

    @Override
    public void run() {
        DebounceOperation$1.access$000(this.this$1).accept(this.val$data);
    }
}

