/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DiagDsiMessagingConfig;
import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;

final class DsiMessagingConfigAccess$DiagPlugIn
implements IDiagPlugIn {
    private final /* synthetic */ DsiMessagingConfigAccess this$0;

    DsiMessagingConfigAccess$DiagPlugIn(DsiMessagingConfigAccess dsiMessagingConfigAccess) {
        this.this$0 = dsiMessagingConfigAccess;
    }

    public void cmdUseDiagDsiMessagingConfig(boolean bl, int n) {
        DiagDsiMessagingConfig diagDsiMessagingConfig = new DiagDsiMessagingConfig(DsiMessagingConfigAccess.access$500(this.this$0).getDsiMessagingConfigPrimaryListener(), DsiMessagingConfigAccess.access$600(this.this$0), DsiMessagingConfigAccess.access$700(this.this$0).getExecutorManager().getInternalTaskDispatcher());
        diagDsiMessagingConfig.setResponsesEnabled(bl);
        diagDsiMessagingConfig.setResponseDelayOffset(n);
        DsiMessagingConfigAccess.access$400(this.this$0, diagDsiMessagingConfig);
    }

    public void cmdRequestSetSmsIndications(boolean bl) {
        this.this$0.requestSetSmsIndications(bl);
    }

    public void cmdRequestSetEmailIndications(boolean bl) {
        this.this$0.requestSetEmailIndications(bl);
    }
}

