/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.watchdog;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.RunnableEvent;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.system.DSIHMIWatchDog;
import org.dsi.ifc.system.DSIHMIWatchDogListener;

public class HMIWatchDog
implements DSIHMIWatchDogListener {
    private final LogChannel log;
    private final IFrameworkAccess framework;
    private volatile DSIHMIWatchDog dsi;
    private volatile boolean ready;

    public HMIWatchDog(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.log = iFrameworkAccess.getLogChannel("Fw.WatchDog");
        this.ready = false;
        this.setDSI(null);
        this.log.log(1000000, "HMIWatchDog created");
    }

    public final void setDSI(DSIHMIWatchDog dSIHMIWatchDog) {
        this.log.log(10000000, "HMIWatchDog.setDSI(%1)", (Object)dSIHMIWatchDog);
        this.dsi = dSIHMIWatchDog;
        if (dSIHMIWatchDog != null) {
            dSIHMIWatchDog.setNotification(1, (DSIListener)this);
            if (this.ready) {
                this.log.log(10000000, "-> HMIWatchDog.hmiReady()");
                dSIHMIWatchDog.hmiReady();
            }
        }
    }

    public final void setReady() {
        this.log.log(10000000, "-> HMIWatchDog.setReady()");
        this.ready = true;
        DSIHMIWatchDog dSIHMIWatchDog = this.getDSI();
        if (dSIHMIWatchDog != null) {
            this.log.log(10000000, "-> HMIWatchDog.hmiReady()");
            dSIHMIWatchDog.hmiReady();
        }
    }

    private DSIHMIWatchDog getDSI() {
        return this.dsi;
    }

    public void triggerErrorLogDump() {
        this.log.log(10000000, "<- HMIWatchDog.triggerErrorLogDump()");
        this.framework.getErrorMgr().handleError(null, "Triggered by HMIWatchDog", 0, 0, 4);
        DSIHMIWatchDog dSIHMIWatchDog = this.getDSI();
        if (dSIHMIWatchDog != null) {
            this.log.log(10000000, "-> HMIWatchDog.errorlogDumpResult(OK)");
            dSIHMIWatchDog.errorlogDumpResult(0);
        }
    }

    public void updateQueryHeartbeat(int n, int n2) {
        if (n2 == 1) {
            this.log.log(10000000, "<- HMIWatchDog.updateQueryHeartbeat(%1)", (long)n);
            if (this.ready) {
                this.framework.getHMIService().getEventDispatcher().postEvent(new RunnableEvent(true, new HeartBeat(n)));
            }
        }
    }

    public void asyncException(int n, String string, int n2) {
        this.log.log(1000000, "<- HMIWatchDog.asyncException(%2,%1,%3", (Object)string, (long)n, (long)n2);
    }

    public class HeartBeat
    implements Runnable {
        final int sequenceNumber;

        HeartBeat(int n) {
            this.sequenceNumber = n;
        }

        public void run() {
            DSIHMIWatchDog dSIHMIWatchDog = HMIWatchDog.this.getDSI();
            if (dSIHMIWatchDog != null) {
                HMIWatchDog.this.log.log(10000000, "-> HMIWatchDog.heartbeat(%1)", (long)this.sequenceNumber);
                dSIHMIWatchDog.heartbeat(this.sequenceNumber);
            }
        }

        public String toString() {
            return new StringBuffer().append("Heartbeat-").append(this.sequenceNumber).toString();
        }
    }
}

