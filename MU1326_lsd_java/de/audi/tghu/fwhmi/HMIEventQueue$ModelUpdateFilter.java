/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.tghu.fwhmi.HMIEventQueue;
import de.audi.tghu.fwhmi.HMIEventQueue$1;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.util.ListIterator;

class HMIEventQueue$ModelUpdateFilter
extends BaseJobFilter {
    private int filteredEvents = 0;
    private final /* synthetic */ HMIEventQueue this$0;

    private HMIEventQueue$ModelUpdateFilter(HMIEventQueue hMIEventQueue) {
        this.this$0 = hMIEventQueue;
    }

    private int getFilteredEvents() {
        return this.filteredEvents;
    }

    private boolean isEventNeededInQueue(ModelUpdateEvent modelUpdateEvent) {
        if (HMIEventQueue.access$1000(this.this$0).size() > 0) {
            ListIterator listIterator = HMIEventQueue.access$1200(this.this$0).listIterator(HMIEventQueue.access$1100(this.this$0).size());
            while (listIterator.hasPrevious()) {
                ATIPEvent aTIPEvent = (ATIPEvent)((Job)listIterator.previous()).getPayload();
                if (!(aTIPEvent instanceof ModelUpdateEvent)) continue;
                ModelUpdateEvent modelUpdateEvent2 = (ModelUpdateEvent)aTIPEvent;
                int n = modelUpdateEvent.getModelType();
                int n2 = modelUpdateEvent2.getModelType();
                if (modelUpdateEvent2.getModelId() != modelUpdateEvent.getModelId() && (n != 100 || n2 != 100)) continue;
                return !modelUpdateEvent.isRedundantToAlreadyQueuedEvent(modelUpdateEvent2);
            }
        }
        return true;
    }

    private boolean discardEvent(ModelUpdateEvent modelUpdateEvent) {
        return !modelUpdateEvent.alwaysPlaceInQueue() && !this.isEventNeededInQueue(modelUpdateEvent);
    }

    @Override
    public void enqueue(Job job, int n) {
        Object object = job.getPayload();
        if (object instanceof ModelUpdateEvent && this.discardEvent((ModelUpdateEvent)object)) {
            HMIEventQueue.access$700(this.this$0).log(-2137614336, "HMIEventQueue do not post modelupdateevent (modelID: %1, is modeltype: %2), information not needed ", (long)((ModelUpdateEvent)object).getModelId(), (long)((ModelUpdateEvent)object).getModelType());
            ++this.filteredEvents;
        } else {
            super.enqueue(job, n);
        }
    }

    /* synthetic */ HMIEventQueue$ModelUpdateFilter(HMIEventQueue hMIEventQueue, HMIEventQueue$1 hMIEventQueue$1) {
        this(hMIEventQueue);
    }

    static /* synthetic */ int access$500(HMIEventQueue$ModelUpdateFilter hMIEventQueue$ModelUpdateFilter) {
        return hMIEventQueue$ModelUpdateFilter.getFilteredEvents();
    }
}

