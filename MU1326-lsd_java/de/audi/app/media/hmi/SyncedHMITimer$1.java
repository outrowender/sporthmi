/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.hmi;

import de.audi.app.media.hmi.SyncedHMITimer;
import de.audi.atip.hmi.event.ATIPNotifyEvent;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class SyncedHMITimer$1
implements TimerListener {
    private final /* synthetic */ SyncedHMITimer this$0;

    SyncedHMITimer$1(SyncedHMITimer syncedHMITimer) {
        this.this$0 = syncedHMITimer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = SyncedHMITimer.access$000(this.this$0);
        synchronized (object) {
            if (SyncedHMITimer.access$100(this.this$0) != 1) {
                SyncedHMITimer.access$200(this.this$0).log(1078071040, "[%1.fireTimer] [%2]", (Object)"SyncedHMITimer", (Object)this.this$0.getName());
                return;
            }
            SyncedHMITimer.access$200(this.this$0).log(1078071040, "[%1.fireTimer] [%2] Post event", (Object)"SyncedHMITimer", (Object)this.this$0.getName());
            SyncedHMITimer.access$400(this.this$0).postEvent(new ATIPNotifyEvent(SyncedHMITimer.access$300(this.this$0), 10601));
            SyncedHMITimer.access$102(this.this$0, 2);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

