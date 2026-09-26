/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessaging;
import de.audi.app.messaging.core.dsi.messaging.DiagDsiMessagingData;
import org.dsi.ifc.messaging.ListEntry;

class DiagDsiMessaging$3
implements Runnable {
    private final /* synthetic */ int val$requestId;
    private final /* synthetic */ ListEntry[] val$listEntries;
    private final /* synthetic */ int val$accountId;
    private final /* synthetic */ int val$offset;
    private final /* synthetic */ DiagDsiMessaging this$0;

    DiagDsiMessaging$3(DiagDsiMessaging diagDsiMessaging, int n, ListEntry[] listEntryArray, int n2, int n3) {
        this.this$0 = diagDsiMessaging;
        this.val$requestId = n;
        this.val$listEntries = listEntryArray;
        this.val$accountId = n2;
        this.val$offset = n3;
    }

    @Override
    public void run() {
        DiagDsiMessaging.access$000(this.this$0).listEntriesResponse(this.val$requestId, 0, this.val$listEntries, this.val$accountId, DiagDsiMessagingData.ROOT_FOLDER.getFolderID(), this.val$offset);
    }
}

