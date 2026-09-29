/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService$EntryListObserver;

class MultipleMessageReadoutService$EntryListObserver$1
implements Runnable {
    private final /* synthetic */ MultipleMessageReadoutService$EntryListObserver this$1;

    MultipleMessageReadoutService$EntryListObserver$1(MultipleMessageReadoutService$EntryListObserver multipleMessageReadoutService$EntryListObserver) {
        this.this$1 = multipleMessageReadoutService$EntryListObserver;
    }

    @Override
    public void run() {
        if (MultipleMessageReadoutService.access$800(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)) == 1) {
            if (MultipleMessageReadoutService.access$3700(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)).getFolderNavigator().getCurrentFolder().isValid() && MultipleMessageReadoutService.access$3800(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)).getFolderNavigator().getCurrentFolder().getHmiFolderType() == 4) {
                if (!MultipleMessageReadoutService.access$1100(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1))) {
                    MultipleMessageReadoutService.access$3902(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1), MultipleMessageReadoutService.access$4000(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)));
                    MultipleMessageReadoutService.access$4100(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)).log(-2137614336, "[MultipleMessageReadoutService$EntryListObserver#indicateListDataResponseOnFolderChange] copied %1 messages", (long)MultipleMessageReadoutService.access$3900(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)).size());
                }
                MultipleMessageReadoutService.access$2000(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1), 0);
            } else {
                MultipleMessageReadoutService.access$4200(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)).log(-1601830656, "[MultipleMessageReadoutService$EntryListObserver#indicateListDataResponseOnFolderChange] folder change failed", (long)MultipleMessageReadoutService.access$3900(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)).size());
                MultipleMessageReadoutService.access$2000(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1), 1);
            }
        }
        MultipleMessageReadoutService.access$4300(MultipleMessageReadoutService$EntryListObserver.access$3600(this.this$1)).getEntryList().signalListReady(true);
    }
}

