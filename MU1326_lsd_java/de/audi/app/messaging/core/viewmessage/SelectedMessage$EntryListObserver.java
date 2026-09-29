/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver$EmptyImplementation;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.viewmessage.SelectedMessage;
import de.audi.app.messaging.core.viewmessage.SelectedMessage$1;
import org.dsi.ifc.messaging.ListEntry;

class SelectedMessage$EntryListObserver
extends IEntryListObserver$EmptyImplementation {
    private final /* synthetic */ SelectedMessage this$0;

    private SelectedMessage$EntryListObserver(SelectedMessage selectedMessage) {
        this.this$0 = selectedMessage;
    }

    @Override
    public void indicateItemSelected(ListEntry listEntry, long l) {
        SelectedMessage.access$600(this.this$0).log(-2137614336, "[SelectedMessage#indicateItemSelected]");
        if (ListEntries.isMessage(listEntry)) {
            this.this$0.requestSetMessage(listEntry.getMessageListEntry(), 0, null);
        }
    }

    /* synthetic */ SelectedMessage$EntryListObserver(SelectedMessage selectedMessage, SelectedMessage$1 selectedMessage$1) {
        this(selectedMessage);
    }
}

