/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.ExtractedItem;

class DsiMessagingPrimaryListener$13
extends CommandResponse {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ ExtractedItem[] val$items;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$13(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int n, ExtractedItem[] extractedItemArray) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$result = n;
        this.val$items = extractedItemArray;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$1300(this.this$0), classCastException, "[DsiMessagingPrimaryListener#extractInformationResponse]");
        }
        dSIMessagingListener.extractInformationResponse(this.val$result, this.val$items);
    }
}

