/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;

class DsiMessagingPrimaryListener$7
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ int val$deleted;
    private final /* synthetic */ int val$num;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$7(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int n, int n2, int n3) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$result = n;
        this.val$deleted = n2;
        this.val$num = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$700(this.this$0), classCastException, "[DsiMessagingPrimaryListener#deleteMessageResponse]");
        }
        dSIMessagingListener.deleteMessageResponse(this.val$result, this.val$deleted, this.val$num);
    }
}

