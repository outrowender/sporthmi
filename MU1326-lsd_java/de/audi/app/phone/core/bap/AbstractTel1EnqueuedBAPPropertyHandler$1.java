/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.audi.app.phone.core.bap.AbstractTel1EnqueuedBAPPropertyHandler;

class AbstractTel1EnqueuedBAPPropertyHandler$1
implements Runnable {
    private final /* synthetic */ AbstractTel1EnqueuedBAPPropertyHandler this$0;

    AbstractTel1EnqueuedBAPPropertyHandler$1(AbstractTel1EnqueuedBAPPropertyHandler abstractTel1EnqueuedBAPPropertyHandler) {
        this.this$0 = abstractTel1EnqueuedBAPPropertyHandler;
    }

    @Override
    public void run() {
        this.this$0.updateAsync();
    }
}

