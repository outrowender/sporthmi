/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingServiceConfigurationListener;

class DsiMessagingConfigPrimaryListener$6
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DsiMessagingConfigPrimaryListener this$0;

    DsiMessagingConfigPrimaryListener$6(DsiMessagingConfigPrimaryListener dsiMessagingConfigPrimaryListener, int n) {
        this.this$0 = dsiMessagingConfigPrimaryListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingServiceConfigurationListener dSIMessagingServiceConfigurationListener = DsiMessagingConfigPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingServiceConfigurationListener = (DSIMessagingServiceConfigurationListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingConfigPrimaryListener.access$600(this.this$0), classCastException, "[DsiMessagingConfigPrimaryListener#responseSetEmailIndications]");
        }
        dSIMessagingServiceConfigurationListener.responseSetEmailIndications(this.val$result);
    }
}

