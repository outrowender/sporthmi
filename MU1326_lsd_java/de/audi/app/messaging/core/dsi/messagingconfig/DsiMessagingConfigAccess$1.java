/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;

class DsiMessagingConfigAccess$1
implements Runnable {
    private final /* synthetic */ DSIMessagingServiceConfiguration val$dsiMessagingConfig;
    private final /* synthetic */ DsiMessagingConfigAccess this$0;

    DsiMessagingConfigAccess$1(DsiMessagingConfigAccess dsiMessagingConfigAccess, DSIMessagingServiceConfiguration dSIMessagingServiceConfiguration) {
        this.this$0 = dsiMessagingConfigAccess;
        this.val$dsiMessagingConfig = dSIMessagingServiceConfiguration;
    }

    @Override
    public void run() {
        boolean bl;
        DsiMessagingConfigAccess.access$000(this.this$0).log(-2137614336, "[DsiMessagingConfigAccess#setDsiMessagingConfig] dsiMessagingConfig = %1", (Object)this.val$dsiMessagingConfig);
        DsiMessagingConfigAccess.access$102(this.this$0, this.val$dsiMessagingConfig);
        boolean bl2 = bl = this.val$dsiMessagingConfig != null;
        if (bl) {
            this.val$dsiMessagingConfig.setNotification(DsiMessagingConfigAccess.access$200(this.this$0).getDsiMessagingConfigPrimaryListener());
        }
        DsiMessagingConfigAccess.access$300(this.this$0, bl);
    }
}

