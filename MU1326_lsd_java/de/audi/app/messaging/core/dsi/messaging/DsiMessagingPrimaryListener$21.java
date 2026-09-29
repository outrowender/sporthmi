/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;

class DsiMessagingPrimaryListener$21
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$21(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int n) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$result = n;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$2100(this.this$0), classCastException, "[DsiMessagingPrimaryListener#deleteSimCardMessagesResponse]");
        }
        dSIMessagingListener.deleteSimCardMessagesResponse(this.val$result);
    }
}

