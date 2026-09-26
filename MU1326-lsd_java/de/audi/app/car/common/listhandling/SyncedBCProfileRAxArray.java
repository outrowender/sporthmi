/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.listhandling;

import de.audi.app.car.common.listhandling.BatteryControlProfileRAx;

public class SyncedBCProfileRAxArray {
    BatteryControlProfileRAx[] array = null;
    private Object mutex = new Object();

    public SyncedBCProfileRAxArray(int n) {
        this.array = new BatteryControlProfileRAx[n];
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public BatteryControlProfileRAx get(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.length() > n) {
                return this.array[n];
            }
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void set(BatteryControlProfileRAx batteryControlProfileRAx, int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.length() > n) {
                this.array[n] = batteryControlProfileRAx;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int length() {
        Object object = this.mutex;
        synchronized (object) {
            return this.array.length;
        }
    }
}

