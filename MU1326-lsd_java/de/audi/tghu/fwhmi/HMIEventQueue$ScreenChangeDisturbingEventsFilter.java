/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.KeyEvent;
import de.audi.tghu.fwhmi.HMIEventQueue;
import de.audi.tghu.fwhmi.HMIEventQueue$1;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.util.List;
import java.util.ListIterator;

class HMIEventQueue$ScreenChangeDisturbingEventsFilter
extends BaseJobFilter {
    private final /* synthetic */ HMIEventQueue this$0;

    private HMIEventQueue$ScreenChangeDisturbingEventsFilter(HMIEventQueue hMIEventQueue) {
        this.this$0 = hMIEventQueue;
    }

    @Override
    public void enqueue(Job job, int n) {
        Object object = job.getPayload();
        if (HMIEventQueue.access$800(this.this$0, object)) {
            HMIEventQueue.access$700(this.this$0).log(-2137614336, "HMIEventQueue.postEvent(): discarded screen change disturbing key event =  %1", object);
        } else {
            super.enqueue(job, n);
        }
    }

    void removeEvents(List list) {
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            if (!(object instanceof KeyEvent) || !HMIEventQueue.access$800(this.this$0, object)) continue;
            HMIEventQueue.access$700(this.this$0).log(-2137614336, "HMIEventQueue.blockScreenChangeDisturbingKeys(): discarded screen change disturbing key, event = %1", object);
            listIterator.remove();
        }
    }

    /* synthetic */ HMIEventQueue$ScreenChangeDisturbingEventsFilter(HMIEventQueue hMIEventQueue, HMIEventQueue$1 hMIEventQueue$1) {
        this(hMIEventQueue);
    }
}

