/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.reactive.operations.BufferOverTimeOperation$1;
import de.audi.atip.utils.reactive.operations.BufferOverTimeOperation$1$1;

class BufferOverTimeOperation$1$1$1
implements Runnable {
    private final /* synthetic */ BufferOverTimeOperation$1$1 this$2;

    BufferOverTimeOperation$1$1$1(BufferOverTimeOperation$1$1 bufferOverTimeOperation$1$1) {
        this.this$2 = bufferOverTimeOperation$1$1;
    }

    @Override
    public void run() {
        BufferOverTimeOperation$1.access$300(BufferOverTimeOperation$1$1.access$200(this.this$2)).accept(BufferOverTimeOperation$1.access$000(BufferOverTimeOperation$1$1.access$200(this.this$2)));
        BufferOverTimeOperation$1.access$002(BufferOverTimeOperation$1$1.access$200(this.this$2), null);
    }
}

