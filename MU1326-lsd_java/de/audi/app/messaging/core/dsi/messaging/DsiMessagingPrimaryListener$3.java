/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.ListChangedInformation;

class DsiMessagingPrimaryListener$3
extends CommandResponse {
    private final /* synthetic */ ListChangedInformation val$information;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$3(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, ListChangedInformation listChangedInformation) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$information = listChangedInformation;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$300(this.this$0), classCastException, "[DsiMessagingPrimaryListener#indicateListChanged]");
        }
        dSIMessagingListener.indicateListChanged(this.val$information);
    }
}

