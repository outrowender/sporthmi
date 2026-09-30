/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.tr;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class TrafficSignQueue {
    private LogChannel logChannel;
    private TrafficSignInformation queuedTrafficSign = null;

    public TrafficSignQueue(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void postTrafficSign(TrafficSignInformation trafficSignInformation) {
        this.logChannel.log(10000000, "TrafficSignQueue#postTrafficSign( %1 )", (Object)trafficSignInformation);
        TrafficSignQueue trafficSignQueue = this;
        synchronized (trafficSignQueue) {
            this.queuedTrafficSign = trafficSignInformation;
            this.notifyAll();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TrafficSignInformation waitForNextTrafficSign() {
        TrafficSignQueue trafficSignQueue = this;
        synchronized (trafficSignQueue) {
            while (this.queuedTrafficSign == null) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {
                    Thread.interrupted();
                }
            }
            TrafficSignInformation trafficSignInformation = this.queuedTrafficSign;
            this.queuedTrafficSign = null;
            return trafficSignInformation;
        }
    }
}

