/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import org.dsi.ifc.messaging.MessageDetails;

class DiagDsiMessaging$8
implements Runnable {
    private final /* synthetic */ MessageDetails val$messageDetails;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$8(DiagDsiMessaging diagDsiMessaging, MessageDetails messageDetails) {
        this.this$0 = diagDsiMessaging;
        this.val$messageDetails = messageDetails;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).getMessageContentsResponse(0, this.val$messageDetails);
    }
}

