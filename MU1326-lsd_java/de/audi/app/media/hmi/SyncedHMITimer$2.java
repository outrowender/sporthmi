/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.hmi;

import de.audi.app.media.hmi.SyncedHMITimer;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

class SyncedHMITimer$2
implements ATIPEventListener {
    private final /* synthetic */ SyncedHMITimer this$0;

    SyncedHMITimer$2(SyncedHMITimer syncedHMITimer) {
        this.this$0 = syncedHMITimer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        Object object = SyncedHMITimer.access$000(this.this$0);
        synchronized (object) {
            switch (aTIPEvent.getID()) {
                case 10601: {
                    if (SyncedHMITimer.access$100(this.this$0) != 2) {
                        SyncedHMITimer.access$200(this.this$0).log(1078071040, "[%1.processEvent] [%2] TIMER_FIRED", (Object)"SyncedHMITimer", (Object)this.this$0.getName());
                        return;
                    }
                    SyncedHMITimer.access$200(this.this$0).log(1078071040, "[%1.processEvent] [%2] TIMER_FIRED, notify", (Object)"SyncedHMITimer", (Object)this.this$0.getName());
                    SyncedHMITimer.access$500(this.this$0).fireTimer(this.this$0);
                    SyncedHMITimer.access$102(this.this$0, 0);
                    break;
                }
                case 10602: {
                    if (SyncedHMITimer.access$100(this.this$0) != 3) {
                        SyncedHMITimer.access$200(this.this$0).log(1078071040, "[%1.processEvent] [%2] TIMER_CANCELED", (Object)"SyncedHMITimer", (Object)this.this$0.getName());
                        return;
                    }
                    SyncedHMITimer.access$200(this.this$0).log(1078071040, "[%1.processEvent] [%2] TIMER_CANCELED, Notify", (Object)"SyncedHMITimer", (Object)this.this$0.getName());
                    SyncedHMITimer.access$500(this.this$0).cancelTimer(this.this$0);
                    SyncedHMITimer.access$102(this.this$0, 0);
                    break;
                }
            }
        }
    }
}

