/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.watchdog;

import de.audi.atip.watchdog.HMIWatchDog;
import org.dsi.ifc.system.DSIHMIWatchDog;

public class HMIWatchDog$HeartBeat
implements Runnable {
    final int sequenceNumber;
    private final /* synthetic */ HMIWatchDog this$0;

    HMIWatchDog$HeartBeat(HMIWatchDog hMIWatchDog, int n) {
        this.this$0 = hMIWatchDog;
        this.sequenceNumber = n;
    }

    @Override
    public void run() {
        DSIHMIWatchDog dSIHMIWatchDog = HMIWatchDog.access$000(this.this$0);
        if (dSIHMIWatchDog != null) {
            HMIWatchDog.access$100(this.this$0).log(-2137614336, "-> HMIWatchDog.heartbeat(%1)", (long)this.sequenceNumber);
            dSIHMIWatchDog.heartbeat(this.sequenceNumber);
        }
    }

    public String toString() {
        return new StringBuffer().append("Heartbeat-").append(this.sequenceNumber).toString();
    }
}

