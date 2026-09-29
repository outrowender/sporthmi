/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;

class DiagDsiMessaging$6
implements Runnable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$6(DiagDsiMessaging diagDsiMessaging, int n) {
        this.this$0 = diagDsiMessaging;
        this.val$requestId = n;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).sendMessageResponse(0, this.val$requestId);
    }
}

