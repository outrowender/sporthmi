/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingPrimaryListener;
import de.audi.app.messaging.core.util.Logs;
import de.audi.tghu.command.CommandResponse;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.messaging.DSIMessagingListener;
import org.dsi.ifc.messaging.ListEntry;

class DsiMessagingPrimaryListener$4
extends CommandResponse {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ int val$result;
    private final /* synthetic */ ListEntry[] val$mappedListEntries;
    private final /* synthetic */ int val$accountId;
    private final /* synthetic */ int val$folderId;
    private final /* synthetic */ int val$offset;
    private final /* synthetic */ DsiMessagingPrimaryListener this$0;

    DsiMessagingPrimaryListener$4(DsiMessagingPrimaryListener dsiMessagingPrimaryListener, int n, int n2, ListEntry[] listEntryArray, int n3, int n4, int n5) {
        this.this$0 = dsiMessagingPrimaryListener;
        this.val$requestId = n;
        this.val$result = n2;
        this.val$mappedListEntries = listEntryArray;
        this.val$accountId = n3;
        this.val$folderId = n4;
        this.val$offset = n5;
    }

    @Override
    public void call(DSIListener dSIListener) {
        DSIMessagingListener dSIMessagingListener = DsiMessagingPrimaryListener.access$100(this.this$0);
        try {
            dSIMessagingListener = (DSIMessagingListener)dSIListener;
        }
        catch (ClassCastException classCastException) {
            Logs.logException(DsiMessagingPrimaryListener.access$400(this.this$0), classCastException, "[DsiMessagingPrimaryListener#listEntriesResponse]");
        }
        dSIMessagingListener.listEntriesResponse(this.val$requestId, this.val$result, this.val$mappedListEntries, this.val$accountId, this.val$folderId, this.val$offset);
    }
}

