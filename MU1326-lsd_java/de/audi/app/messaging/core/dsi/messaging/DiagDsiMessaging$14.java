/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessagingData;

class DiagDsiMessaging$14
implements Runnable {
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$14(DiagDsiMessaging diagDsiMessaging) {
        this.this$0 = diagDsiMessaging;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).getTemplatesResponse(0, DiagDsiMessagingData.templates);
    }
}

