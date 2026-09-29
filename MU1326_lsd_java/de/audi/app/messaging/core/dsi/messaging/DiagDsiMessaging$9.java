/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;

class DiagDsiMessaging$9
implements Runnable {
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$9(DiagDsiMessaging diagDsiMessaging) {
        this.this$0 = diagDsiMessaging;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).setMessageReadStatusResponse(0);
    }
}

