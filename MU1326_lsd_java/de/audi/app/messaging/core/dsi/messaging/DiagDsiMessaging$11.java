/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessagingData;

class DiagDsiMessaging$11
implements Runnable {
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$11(DiagDsiMessaging diagDsiMessaging) {
        this.this$0 = diagDsiMessaging;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).extractInformationResponse(0, DiagDsiMessagingData.EXTRACTED_ITEMS);
    }
}

