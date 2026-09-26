/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.viewmessage;

import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver$EmptyImplementation;
import de.audi.app.messaging.core.util.ListEntries;
import de.audi.app.messaging.core.viewmessage.MessageOptionsManager;
import de.audi.app.messaging.core.viewmessage.MessageOptionsManager$1;
import org.dsi.ifc.messaging.ListEntry;

final class MessageOptionsManager$EntryListObserver
extends IEntryListObserver$EmptyImplementation {
    private final /* synthetic */ MessageOptionsManager this$0;

    private MessageOptionsManager$EntryListObserver(MessageOptionsManager messageOptionsManager) {
        this.this$0 = messageOptionsManager;
    }

    @Override
    public void indicateItemFocused(EntryListRow entryListRow) {
        ListEntry listEntry = entryListRow.getListEntry();
        MessageOptionsManager.access$200(this.this$0).log(1078071040, "[MessageOptionsManager#indicateItemFocused] entryListRow.getListEntry() = %1", (Object)listEntry);
        if (ListEntries.isMessage(listEntry)) {
            this.this$0.setFocusedMessageListEntry(listEntry.getMessageListEntry());
        }
    }

    /* synthetic */ MessageOptionsManager$EntryListObserver(MessageOptionsManager messageOptionsManager, MessageOptionsManager$1 messageOptionsManager$1) {
        this(messageOptionsManager);
    }
}

