/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;

class DsiMessagingPrimaryListener$11
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ String val$adbEntry;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$11(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int n, String string) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$result = n;
        this.val$adbEntry = string;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$1100(this.this$0), classCastException, "[DsiMessagingPrimaryListener#parseVCardResponse]");
        }
        dSIMessagingListener.parseVCardResponse(this.val$result, this.val$adbEntry);
    }
}

