/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess;
import org.dsi.ifc.messaging.DSIMessaging;

class DsiMessagingAccess$1
implements Runnable {
    private final /* synthetic */ DSIMessaging val$dsiMessaging;
    private final /* synthetic */ DsiMessagingAccess this$0;

    DsiMessagingAccess$1(DsiMessagingAccess dsiMessagingAccess, DSIMessaging dSIMessaging) {
        this.this$0 = dsiMessagingAccess;
        this.val$dsiMessaging = dSIMessaging;
    }

    @Override
    public void run() {
        boolean bl;
        DsiMessagingAccess.access$000(this.this$0).log(-2137614336, "[DsiMessagingAccess#setDsiMessaging] dsiMessaging = %1", (Object)this.val$dsiMessaging);
        DsiMessagingAccess.access$102(this.this$0, this.val$dsiMessaging);
        boolean bl2 = bl = this.val$dsiMessaging != null;
        if (bl) {
            this.val$dsiMessaging.setNotification(DsiMessagingAccess.access$200(this.this$0).getDsiMessagingPrimaryListener());
        }
        DsiMessagingAccess.access$300(this.this$0, bl);
    }
}

