/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;

class DiagDsiMessaging$4
implements Runnable {
    private final /* synthetic */ int val$numMessageDeleted;
    private final /* synthetic */ int val$requestedDeleteCount;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$4(DiagDsiMessaging diagDsiMessaging, int n, int n2) {
        this.this$0 = diagDsiMessaging;
        this.val$numMessageDeleted = n;
        this.val$requestedDeleteCount = n2;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).deleteMessageResponse(0, this.val$numMessageDeleted, this.val$requestedDeleteCount);
    }
}

