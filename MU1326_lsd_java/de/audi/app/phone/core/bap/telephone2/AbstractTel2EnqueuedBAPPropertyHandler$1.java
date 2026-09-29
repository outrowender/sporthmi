/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone2;

import de.audi.app.phone.core.bap.telephone2.AbstractTel2EnqueuedBAPPropertyHandler;

class AbstractTel2EnqueuedBAPPropertyHandler$1
implements Runnable {
    private final /* synthetic */ AbstractTel2EnqueuedBAPPropertyHandler this$0;

    AbstractTel2EnqueuedBAPPropertyHandler$1(AbstractTel2EnqueuedBAPPropertyHandler abstractTel2EnqueuedBAPPropertyHandler) {
        this.this$0 = abstractTel2EnqueuedBAPPropertyHandler;
    }

    @Override
    public void run() {
        this.this$0.updateAsync();
    }
}

