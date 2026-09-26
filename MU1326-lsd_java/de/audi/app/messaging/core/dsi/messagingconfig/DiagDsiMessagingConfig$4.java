/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig;

class DiagDsiMessagingConfig$4
implements Runnable {
    private final /* synthetic */ boolean val$emailIndications;
    private final /* synthetic */ DiagDsiMessagingConfig this$0;

    DiagDsiMessagingConfig$4(DiagDsiMessagingConfig diagDsiMessagingConfig, boolean bl) {
        this.this$0 = diagDsiMessagingConfig;
        this.val$emailIndications = bl;
    }

    @Override
    public void run() {
        DiagDsiMessagingConfig.access$000(this.this$0).updateEmailIndications(this.val$emailIndications, 1);
    }
}

