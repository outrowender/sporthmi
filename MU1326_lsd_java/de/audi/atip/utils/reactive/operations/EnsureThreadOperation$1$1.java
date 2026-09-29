/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.reactive.operations.EnsureThreadOperation$1;

class EnsureThreadOperation$1$1
implements Runnable {
    private final /* synthetic */ Object val$data;
    private final /* synthetic */ EnsureThreadOperation$1 this$1;

    EnsureThreadOperation$1$1(EnsureThreadOperation$1 ensureThreadOperation$1, Object object) {
        this.this$1 = ensureThreadOperation$1;
        this.val$data = object;
    }

    @Override
    public void run() {
        EnsureThreadOperation$1.access$100(this.this$1).accept(this.val$data);
    }
}

