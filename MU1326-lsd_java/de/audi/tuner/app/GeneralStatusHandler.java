/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

public class GeneralStatusHandler {
    private final Object mutex;
    private int status;

    public GeneralStatusHandler(int n) {
        this.status = n;
        this.mutex = new Object();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setStatus(int n) {
        Object object = this.mutex;
        synchronized (object) {
            this.status = n;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int getStatus() {
        Object object = this.mutex;
        synchronized (object) {
            return this.status;
        }
    }
}

