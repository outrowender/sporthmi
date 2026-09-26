/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.tghu.fwhmi.HMIEventQueue;
import de.audi.tghu.fwhmi.HMIEventQueue$1;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.util.List;
import java.util.ListIterator;

class HMIEventQueue$LockFilter
extends BaseJobFilter {
    private final /* synthetic */ HMIEventQueue this$0;

    private HMIEventQueue$LockFilter(HMIEventQueue hMIEventQueue) {
        this.this$0 = hMIEventQueue;
    }

    @Override
    public void enqueue(Job job, int n) {
        Object object = job.getPayload();
        if (this.this$0.isUserInteraction(object)) {
            HMIEventQueue.access$700(this.this$0).log(-2137614336, "HMIEventQueue.postEvent(): discarded user interaction, event =  %1", object);
        } else {
            super.enqueue(job, n);
        }
    }

    void removeEvents(List list) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object object = ((Job)listIterator.next()).getPayload();
            if (!this.this$0.isUserInteraction(object)) continue;
            HMIEventQueue.access$700(this.this$0).log(-2137614336, "HMIEventQueue.lockUsage(): discarded user interaction, event =  %1", object);
            listIterator.remove();
        }
    }

    /* synthetic */ HMIEventQueue$LockFilter(HMIEventQueue hMIEventQueue, HMIEventQueue$1 hMIEventQueue$1) {
        this(hMIEventQueue);
    }
}

