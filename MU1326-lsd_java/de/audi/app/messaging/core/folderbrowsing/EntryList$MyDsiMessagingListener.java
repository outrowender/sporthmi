/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.folderbrowsing;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.core.folderbrowsing.EntryList;
import de.audi.app.messaging.core.folderbrowsing.EntryList$1;
import de.audi.app.messaging.core.util.Logs;
import org.dsi.ifc.messaging.ListChangedInformation;

class EntryList$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ EntryList this$0;

    private EntryList$MyDsiMessagingListener(EntryList entryList) {
        this.this$0 = entryList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void indicateListChanged(ListChangedInformation listChangedInformation) {
        Object object = EntryList.access$3700(this.this$0).getMessagingHmiLock();
        synchronized (object) {
            try {
                EntryList.access$3800(this.this$0).log(-2137614336, "[EntryList#indicateListChanged]");
                if (!EntryList.access$3900(this.this$0)) {
                    EntryList.access$2400(this.this$0, 0);
                    EntryList.access$4000(this.this$0, true, listChangedInformation);
                } else {
                    EntryList.access$4100(this.this$0).log(-1601830656, "[EntryList#indicateListChanged] Context information on current folder is invalid. Ignoring call.");
                }
            }
            catch (Exception exception) {
                Logs.logException(EntryList.access$4200(this.this$0), exception, "[EntryList#indicateListChanged]");
                EntryList.access$2400(this.this$0, 3);
            }
        }
    }

    /* synthetic */ EntryList$MyDsiMessagingListener(EntryList entryList, EntryList$1 entryList$1) {
        this(entryList);
    }
}

