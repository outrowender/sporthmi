/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap;

import de.audi.app.bap.IPowerState;

public final class PowerState
implements IPowerState {
    private volatile int powerState = 0;
    private volatile int powerStateTrigger = -1;

    public synchronized int getPowerState() {
        return this.powerState;
    }

    public synchronized void setPowerState(int n) {
        this.powerState = n;
    }

    public synchronized int getPowerStateTrigger() {
        return this.powerStateTrigger;
    }

    public synchronized void setPowerStateTrigger(int n) {
        this.powerStateTrigger = n;
    }

    public synchronized boolean isPowerOn() {
        if (this.powerState == 4) {
            return this.powerStateTrigger == 7;
        }
        return this.powerState != 2 && this.powerState != 3;
    }
}

