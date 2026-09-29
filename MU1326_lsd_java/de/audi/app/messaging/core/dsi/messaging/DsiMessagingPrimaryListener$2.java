/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.StatusInformation;

class DsiMessagingPrimaryListener$2
extends CommandResponse {
    private final /* synthetic */ StatusInformation val$statusInformation;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$2(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, StatusInformation statusInformation) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$statusInformation = statusInformation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$200(this.this$0), classCastException, "[DsiMessagingPrimaryListener#indicateMessageStatus]");
        }
        dSIMessagingListener.indicateMessageStatus(this.val$statusInformation);
    }
}

