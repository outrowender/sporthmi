/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

final class DsiMessagingAccess$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ DsiMessagingAccess this$0;

    DsiMessagingAccess$DiagPlugIn(DsiMessagingAccess dsiMessagingAccess) {
        this.this$0 = dsiMessagingAccess;
    }

    public void cmdUseDiagDsiMessaging(boolean bl, int n) {
        DiagDsiMessaging diagDsiMessaging = new DiagDsiMessaging(DsiMessagingAccess.access$500(this.this$0).getDsiMessagingPrimaryListener(), DsiMessagingAccess.access$600(this.this$0), DsiMessagingAccess.access$700(this.this$0).getExecutorManager().getInternalTaskDispatcher());
        diagDsiMessaging.setResponsesEnabled(bl);
        diagDsiMessaging.setResponseDelayOffset(n);
        DsiMessagingAccess.access$400(this.this$0, diagDsiMessaging);
    }
}

