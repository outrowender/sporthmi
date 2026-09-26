/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

import de.audi.app.messaging.core.addressbook.GetEntryCommand$ResultHandler;
import de.audi.app.messaging.core.compose.RecipientSearch;
import org.dsi.ifc.organizer.AdbEntry;

class RecipientSearch$1
implements GetEntryCommand$ResultHandler {
    private final /* synthetic */ RecipientSearch this$0;

    RecipientSearch$1(RecipientSearch recipientSearch) {
        this.this$0 = recipientSearch;
    }

    @Override
    public void handleResult(int n, AdbEntry adbEntry) {
        RecipientSearch.access$000(this.this$0, n, adbEntry);
    }
}

