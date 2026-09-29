/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;

class DsiMessagingPrimaryListener$14
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ int val$templateID;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$14(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int n, int n2) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$result = n;
        this.val$templateID = n2;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$1400(this.this$0), classCastException, "[DsiMessagingPrimaryListener#changeTemplateResponse]");
        }
        dSIMessagingListener.changeTemplateResponse(this.val$result, this.val$templateID);
    }
}

