/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.TimedJobQueue;
import java.io.PrintStream;
import java.util.List;
import java.util.ListIterator;

final class HMIEventQueue
extends TimedJobQueue {
    private final HKFilter hkFilter = new HKFilter();
    private final ScreenChangeDisturbingEventsFilter screenChangeDisturbingEventsFilter = new ScreenChangeDisturbingEventsFilter();
    private final KombiSyncFilter kombiSyncFilter = new KombiSyncFilter();
    private final ModelUpdateFilter modelUpdateFilter = new ModelUpdateFilter();
    private final LockFilter lockFilter = new LockFilter();
    private final LogChannel log;
    private final boolean isFrontMU;

    HMIEventQueue(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, boolean bl) {
        super(iFrameworkAccess.getMonotonicTimeSource());
        this.log = logChannel;
        this.isFrontMU = iFrameworkAccess.isFrontMU();
        if (bl) {
            this.addFilter(this.modelUpdateFilter);
        }
    }

    public synchronized void dump(PrintStream printStream) {
        if (printStream != null) {
            printStream.print("Usage: ");
            printStream.println(this.isUsageLocked() ? "locked" : "allowed");
            printStream.print("Hardkeys: ");
            printStream.println(this.isHKBlocked() ? "blocked" : "allowed");
            printStream.print("Screen change disturbing events: ");
            printStream.println(this.isScreenChangeDisturbingEventsBlocked() ? "blocked" : "allowed");
            printStream.print("KombiSync Filter: ");
            printStream.println(this.iskombiSyncFilterActive() ? "KOMBI" : "HMI");
            printStream.print("Filtered ModelUpdateEvents: ");
            printStream.println(this.modelUpdateFilter.getFilteredEvents());
            printStream.println();
            super.dump(printStream);
        }
    }

    private final boolean isHardkey(Object object) {
        return object instanceof KeyEvent && KeyEvent.isHardKey((KeyEvent)object);
    }

    private boolean isHKBlocked() {
        return this.hkFilter.getNext() != null;
    }

    protected synchronized void blockHardkeys() {
        if (this.isFrontMU && !this.isHKBlocked()) {
            this.addFilter(this.hkFilter);
            this.hkFilter.removeEvents(this.getJobs());
        }
    }

    protected synchronized void unBlockHardkeys() {
        if (this.isFrontMU) {
            this.removeFilter(this.hkFilter);
        }
    }

    private final boolean isSoftKey(Object object) {
        if (object instanceof KeyEvent) {
            switch (((KeyEvent)object).getKeyCode()) {
                case 77: {
                    return true;
                }
                case 78: {
                    return true;
                }
                case 11: {
                    return true;
                }
                case 9: {
                    return true;
                }
                case 10: {
                    return true;
                }
                case 12: {
                    return true;
                }
                case 17: {
                    return true;
                }
                case 20: {
                    return true;
                }
                case 15: {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private final boolean isScreenChangeDisturbing(Object object) {
        if (object instanceof JoystickEvent) {
            return true;
        }
        if (object instanceof TouchEvent) {
            return ((TouchEvent)object).getID() != 10905;
        }
        return this.isSoftKey(object);
    }

    private boolean isScreenChangeDisturbingEventsBlocked() {
        return this.screenChangeDisturbingEventsFilter.getNext() != null;
    }

    protected synchronized void blockScreenChangeDisturbingEvents() {
        if (this.isFrontMU && !this.isScreenChangeDisturbingEventsBlocked()) {
            this.addFilter(this.screenChangeDisturbingEventsFilter);
            this.screenChangeDisturbingEventsFilter.removeEvents(this.getJobs());
        }
    }

    protected synchronized void unBlockScreenChangeDisturbingEvents() {
        if (this.isFrontMU) {
            this.removeFilter(this.screenChangeDisturbingEventsFilter);
        }
    }

    private boolean iskombiSyncFilterActive() {
        return this.kombiSyncFilter.getNext() != null;
    }

    public synchronized void setKombiSyncFocus(int n) {
        if (this.isFrontMU) {
            if (n == 1) {
                if (!this.iskombiSyncFilterActive()) {
                    this.addFilter(this.kombiSyncFilter);
                    this.kombiSyncFilter.removeEvents(this.getJobs());
                }
            } else {
                this.removeFilter(this.kombiSyncFilter);
            }
        }
    }

    public final boolean isUserInteraction(Object object) {
        return this.isHardkey(object) || this.isScreenChangeDisturbing(object);
    }

    private boolean isUsageLocked() {
        return this.lockFilter.getNext() != null;
    }

    protected synchronized void lockUsage() {
        if (this.isFrontMU && !this.isUsageLocked()) {
            this.addFilter(this.lockFilter);
            this.lockFilter.removeEvents(this.getJobs());
        }
    }

    protected synchronized void unlockUsage() {
        if (this.isFrontMU) {
            this.removeFilter(this.lockFilter);
        }
    }

    private class HKFilter
    extends BaseJobFilter {
        private HKFilter() {
        }

        public void enqueue(Job job, int n) {
            Object object = job.getPayload();
            if (HMIEventQueue.this.isHardkey(object)) {
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.postEvent(): discarded Hardkey, event =  %1", object);
            } else {
                super.enqueue(job, n);
            }
        }

        void removeEvents(List list) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Object object = ((Job)listIterator.next()).getPayload();
                if (!HMIEventQueue.this.isHardkey(object)) continue;
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.blockHardKeys(): discarded Hardkey, event =  %1", object);
                listIterator.remove();
            }
        }
    }

    private class LockFilter
    extends BaseJobFilter {
        private LockFilter() {
        }

        public void enqueue(Job job, int n) {
            Object object = job.getPayload();
            if (HMIEventQueue.this.isUserInteraction(object)) {
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.postEvent(): discarded user interaction, event =  %1", object);
            } else {
                super.enqueue(job, n);
            }
        }

        void removeEvents(List list) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Object object = ((Job)listIterator.next()).getPayload();
                if (!HMIEventQueue.this.isUserInteraction(object)) continue;
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.lockUsage(): discarded user interaction, event =  %1", object);
                listIterator.remove();
            }
        }
    }

    private class KombiSyncFilter
    extends BaseJobFilter {
        private KombiSyncFilter() {
        }

        boolean isKombiSyncKey(Object object) {
            if (object instanceof JoystickEvent) {
                return true;
            }
            if (object instanceof TouchEvent) {
                return true;
            }
            return HMIEventQueue.this.isSoftKey(object);
        }

        public void enqueue(Job job, int n) {
            Object object = job.getPayload();
            if ((object instanceof KeyEvent || object instanceof TouchEvent) && this.isKombiSyncKey(object)) {
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.postEvent(): KombiSync: KOMBI has currently focus for discarded event =  %1", object);
            } else {
                super.enqueue(job, n);
            }
        }

        void removeEvents(List list) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Object object = ((Job)listIterator.next()).getPayload();
                if (!this.isKombiSyncKey(object)) continue;
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.blockHardKeys(): discarded Hardkey, event =  %1", object);
                listIterator.remove();
            }
        }
    }

    private class ModelUpdateFilter
    extends BaseJobFilter {
        private int filteredEvents = 0;

        private ModelUpdateFilter() {
        }

        private int getFilteredEvents() {
            return this.filteredEvents;
        }

        private boolean isEventNeededInQueue(ModelUpdateEvent modelUpdateEvent) {
            if (HMIEventQueue.this.getJobs().size() > 0) {
                ListIterator listIterator = HMIEventQueue.this.getJobs().listIterator(HMIEventQueue.this.getJobs().size());
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

        public void enqueue(Job job, int n) {
            Object object = job.getPayload();
            if (object instanceof ModelUpdateEvent && this.discardEvent((ModelUpdateEvent)object)) {
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue do not post modelupdateevent (modelID: %1, is modeltype: %2), information not needed ", (long)((ModelUpdateEvent)object).getModelId(), (long)((ModelUpdateEvent)object).getModelType());
                ++this.filteredEvents;
            } else {
                super.enqueue(job, n);
            }
        }
    }

    private class ScreenChangeDisturbingEventsFilter
    extends BaseJobFilter {
        private ScreenChangeDisturbingEventsFilter() {
        }

        public void enqueue(Job job, int n) {
            Object object = job.getPayload();
            if (HMIEventQueue.this.isScreenChangeDisturbing(object)) {
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.postEvent(): discarded screen change disturbing key event =  %1", object);
            } else {
                super.enqueue(job, n);
            }
        }

        void removeEvents(List list) {
            ListIterator listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                Object object = listIterator.next();
                if (!(object instanceof KeyEvent) || !HMIEventQueue.this.isScreenChangeDisturbing(object)) continue;
                HMIEventQueue.this.log.log(10000000, "HMIEventQueue.blockScreenChangeDisturbingKeys(): discarded screen change disturbing key, event = %1", object);
                listIterator.remove();
            }
        }
    }
}

