/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig;

class DiagDsiMessagingConfig$6
implements Runnable {
    private final /* synthetic */ boolean val$pushSms;
    private final /* synthetic */ DiagDsiMessagingConfig this$0;

    DiagDsiMessagingConfig$6(DiagDsiMessagingConfig diagDsiMessagingConfig, boolean bl) {
        this.this$0 = diagDsiMessagingConfig;
        this.val$pushSms = bl;
    }

    @Override
    public void run() {
        DiagDsiMessagingConfig.access$000(this.this$0).updatePushSms(this.val$pushSms, 1);
    }
}

