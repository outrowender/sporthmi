/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.Template;

class DsiMessagingPrimaryListener$16
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ Template[] val$templates;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$16(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int n, Template[] templateArray) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$result = n;
        this.val$templates = templateArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$1600(this.this$0), classCastException, "[DsiMessagingPrimaryListener#getTemplatesResponse]");
        }
        dSIMessagingListener.getTemplatesResponse(this.val$result, this.val$templates);
    }
}

