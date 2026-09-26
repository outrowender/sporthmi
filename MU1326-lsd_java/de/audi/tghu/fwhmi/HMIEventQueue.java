/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.hmi.event.KeyEvent;
import de.audi.atip.hmi.event.TouchEvent;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.fwhmi.HMIEventQueue$HKFilter;
import de.audi.tghu.fwhmi.HMIEventQueue$KombiSyncFilter;
import de.audi.tghu.fwhmi.HMIEventQueue$LockFilter;
import de.audi.tghu.fwhmi.HMIEventQueue$ModelUpdateFilter;
import de.audi.tghu.fwhmi.HMIEventQueue$ScreenChangeDisturbingEventsFilter;
import de.esolutions.fw.util.commons.job.TimedJobQueue;
import java.io.PrintStream;
import java.util.List;

final class HMIEventQueue
extends TimedJobQueue {
    private final HMIEventQueue$HKFilter hkFilter = new HMIEventQueue$HKFilter(this, null);
    private final HMIEventQueue$ScreenChangeDisturbingEventsFilter screenChangeDisturbingEventsFilter = new HMIEventQueue$ScreenChangeDisturbingEventsFilter(this, null);
    private final HMIEventQueue$KombiSyncFilter kombiSyncFilter = new HMIEventQueue$KombiSyncFilter(this, null);
    private final HMIEventQueue$ModelUpdateFilter modelUpdateFilter = new HMIEventQueue$ModelUpdateFilter(this, null);
    private final HMIEventQueue$LockFilter lockFilter = new HMIEventQueue$LockFilter(this, null);
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

    @Override
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
            printStream.println(HMIEventQueue$ModelUpdateFilter.access$500(this.modelUpdateFilter));
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

    static /* synthetic */ boolean access$600(HMIEventQueue hMIEventQueue, Object object) {
        return hMIEventQueue.isHardkey(object);
    }

    static /* synthetic */ LogChannel access$700(HMIEventQueue hMIEventQueue) {
        return hMIEventQueue.log;
    }

    static /* synthetic */ boolean access$800(HMIEventQueue hMIEventQueue, Object object) {
        return hMIEventQueue.isScreenChangeDisturbing(object);
    }

    static /* synthetic */ boolean access$900(HMIEventQueue hMIEventQueue, Object object) {
        return hMIEventQueue.isSoftKey(object);
    }

    static /* synthetic */ List access$1000(HMIEventQueue hMIEventQueue) {
        return hMIEventQueue.getJobs();
    }

    static /* synthetic */ List access$1100(HMIEventQueue hMIEventQueue) {
        return hMIEventQueue.getJobs();
    }

    static /* synthetic */ List access$1200(HMIEventQueue hMIEventQueue) {
        return hMIEventQueue.getJobs();
    }
}

