/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.EntryList$1;
import de.audi.atip.msg.MsgListener;

class EntryList$MyMsgListener
implements MsgListener {
    private final /* synthetic */ EntryList this$0;

    private EntryList$MyMsgListener(EntryList entryList) {
        this.this$0 = entryList;
    }

    @Override
    public void processMsg(int n) {
        if (n == 11) {
            EntryList.access$4300(this.this$0).log(1078071040, "[EntryList#processMsg] message = %1 (UNITS_CHANGED)", (long)n);
            EntryList.access$4400(this.this$0);
        }
    }

    /* synthetic */ EntryList$MyMsgListener(EntryList entryList, EntryList$1 entryList$1) {
        this(entryList);
    }
}

