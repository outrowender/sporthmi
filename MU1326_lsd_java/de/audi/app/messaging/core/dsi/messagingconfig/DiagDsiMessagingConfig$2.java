/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig;

class DiagDsiMessagingConfig$2
implements Runnable {
    private final /* synthetic */ boolean val$smsIndications;
    private final /* synthetic */ DiagDsiMessagingConfig this$0;

    DiagDsiMessagingConfig$2(DiagDsiMessagingConfig diagDsiMessagingConfig, boolean bl) {
        this.this$0 = diagDsiMessagingConfig;
        this.val$smsIndications = bl;
    }

    @Override
    public void run() {
        DiagDsiMessagingConfig.access$000(this.this$0).updateSmsIndications(this.val$smsIndications, 1);
    }
}

