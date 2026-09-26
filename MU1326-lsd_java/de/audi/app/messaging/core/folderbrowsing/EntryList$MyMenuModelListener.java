/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.EntryList$1;
import de.audi.atip.hmi.model.menu.MenuModelListener;

final class EntryList$MyMenuModelListener
implements MenuModelListener {
    private final /* synthetic */ EntryList this$0;

    private EntryList$MyMenuModelListener(EntryList entryList) {
        this.this$0 = entryList;
    }

    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        EntryList.access$3000(this.this$0).log(1078071040, "[EntryList#MyMenuModelListener#itemFocused] model = %1", (long)n2);
        if (n2 != EntryList.access$2900(this.this$0).getID()) {
            EntryList.access$2100(this.this$0, null);
        }
    }

    /* synthetic */ EntryList$MyMenuModelListener(EntryList entryList, EntryList$1 entryList$1) {
        this(entryList);
    }
}

