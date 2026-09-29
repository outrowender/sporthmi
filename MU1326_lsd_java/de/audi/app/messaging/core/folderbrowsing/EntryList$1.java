/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.ListDataResponse;
import de.audi.app.messaging.core.folderbrowsing.ListEntriesCommand$ResultHandler;

class EntryList$1
implements ListEntriesCommand$ResultHandler {
    private final /* synthetic */ EntryList this$0;

    EntryList$1(EntryList entryList) {
        this.this$0 = entryList;
    }

    @Override
    public void handleResult(ListDataResponse listDataResponse) {
        EntryList.access$000(this.this$0, listDataResponse);
    }
}

