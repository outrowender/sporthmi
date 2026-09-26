/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;

class DiagDsiMessaging$12
implements Runnable {
    private final /* synthetic */ int val$templateID;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$12(DiagDsiMessaging diagDsiMessaging, int n) {
        this.this$0 = diagDsiMessaging;
        this.val$templateID = n;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).changeTemplateResponse(0, this.val$templateID);
    }
}

