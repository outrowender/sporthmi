/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;

class DiagDsiMessaging$10
implements Runnable {
    private final /* synthetic */ String val$draftId;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$10(DiagDsiMessaging diagDsiMessaging, String string) {
        this.this$0 = diagDsiMessaging;
        this.val$draftId = string;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).saveAsDraftResponse(0, this.val$draftId);
    }
}

