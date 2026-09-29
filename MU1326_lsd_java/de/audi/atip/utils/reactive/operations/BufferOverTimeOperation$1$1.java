/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.atip.utils.reactive.operations;

import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.operations.BufferOverTimeOperation;
import de.audi.atip.utils.reactive.operations.BufferOverTimeOperation$1;
import de.audi.atip.utils.reactive.operations.BufferOverTimeOperation$1$1$1;

class BufferOverTimeOperation$1$1
implements Runnable {
    private final /* synthetic */ Object val$data;
    private final /* synthetic */ BufferOverTimeOperation$1 this$1;

    BufferOverTimeOperation$1$1(BufferOverTimeOperation$1 bufferOverTimeOperation$1, Object object) {
        this.this$1 = bufferOverTimeOperation$1;
        this.val$data = object;
    }

    @Override
    public void run() {
        if (BufferOverTimeOperation$1.access$000(this.this$1) == null) {
            BufferOverTimeOperation$1.access$002(this.this$1, Generics.newArrayList());
            BufferOverTimeOperation$1.access$102(this.this$1, BufferOverTimeOperation.access$600(BufferOverTimeOperation$1.access$400(this.this$1)).execute(new BufferOverTimeOperation$1$1$1(this), BufferOverTimeOperation.access$500(BufferOverTimeOperation$1.access$400(this.this$1))));
        }
        BufferOverTimeOperation$1.access$000(this.this$1).add(this.val$data);
    }

    static /* synthetic */ BufferOverTimeOperation$1 access$200(BufferOverTimeOperation$1$1 bufferOverTimeOperation$1$1) {
        return bufferOverTimeOperation$1$1.this$1;
    }
}

