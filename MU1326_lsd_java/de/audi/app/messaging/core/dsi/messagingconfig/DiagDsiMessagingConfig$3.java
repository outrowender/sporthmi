/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig;

class DiagDsiMessagingConfig$3
implements Runnable {
    private final /* synthetic */ DiagDsiMessagingConfig this$0;

    DiagDsiMessagingConfig$3(DiagDsiMessagingConfig diagDsiMessagingConfig) {
        this.this$0 = diagDsiMessagingConfig;
    }

    @Override
    public void run() {
        DiagDsiMessagingConfig.access$000(this.this$0).responseSetSmsIndications(0);
    }
}

