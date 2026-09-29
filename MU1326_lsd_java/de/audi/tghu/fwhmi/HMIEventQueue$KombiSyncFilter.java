/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.tghu.fwhmi.HMIEventQueue;
import de.audi.tghu.fwhmi.HMIEventQueue$1;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.util.List;
import java.util.ListIterator;

class HMIEventQueue$KombiSyncFilter
extends BaseJobFilter {
    private final /* synthetic */ HMIEventQueue this$0;

    private HMIEventQueue$KombiSyncFilter(HMIEventQueue hMIEventQueue) {
        this.this$0 = hMIEventQueue;
    }

    boolean isKombiSyncKey(Object object) {
        if (object instanceof JoystickEvent) {
            return true;
        }
        if (object instanceof TouchEvent) {
            return true;
        }
        return HMIEventQueue.access$900(this.this$0, object);
    }

    @Override
    public void enqueue(Job job, int n) {
        Object object = job.getPayload();
        if ((object instanceof KeyEvent || object instanceof TouchEvent) && this.isKombiSyncKey(object)) {
            HMIEventQueue.access$700(this.this$0).log(-2137614336, "HMIEventQueue.postEvent(): KombiSync: KOMBI has currently focus for discarded event =  %1", object);
        } else {
            super.enqueue(job, n);
        }
    }

    void removeEvents(List list) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object object = ((Job)listIterator.next()).getPayload();
            if (!this.isKombiSyncKey(object)) continue;
            HMIEventQueue.access$700(this.this$0).log(-2137614336, "HMIEventQueue.blockHardKeys(): discarded Hardkey, event =  %1", object);
            listIterator.remove();
        }
    }

    /* synthetic */ HMIEventQueue$KombiSyncFilter(HMIEventQueue hMIEventQueue, HMIEventQueue$1 hMIEventQueue$1) {
        this(hMIEventQueue);
    }
}

