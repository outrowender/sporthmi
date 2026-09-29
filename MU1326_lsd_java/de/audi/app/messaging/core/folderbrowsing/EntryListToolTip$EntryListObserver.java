/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryListRow;
import de.audi.app.messaging.core.folderbrowsing.EntryListToolTip;
import de.audi.app.messaging.core.folderbrowsing.EntryListToolTip$1;
import de.audi.app.messaging.core.folderbrowsing.IEntryListObserver$EmptyImplementation;

class EntryListToolTip$EntryListObserver
extends IEntryListObserver$EmptyImplementation {
    private final /* synthetic */ EntryListToolTip this$0;

    private EntryListToolTip$EntryListObserver(EntryListToolTip entryListToolTip) {
        this.this$0 = entryListToolTip;
    }

    @Override
    public void indicateItemFocused(EntryListRow entryListRow) {
        EntryListToolTip.access$100(this.this$0).log(-2137614336, "[EntryListToolTip#indicateItemFocused]");
        EntryListToolTip.access$200(this.this$0, entryListRow);
    }

    /* synthetic */ EntryListToolTip$EntryListObserver(EntryListToolTip entryListToolTip, EntryListToolTip$1 entryListToolTip$1) {
        this(entryListToolTip);
    }
}

