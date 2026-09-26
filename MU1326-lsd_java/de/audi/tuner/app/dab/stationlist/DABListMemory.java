/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DABListMemory$DABLists;

class DABListMemory {
    private DabStation[] components = new DabStation[0];
    private DabStation[] ensembles = new DabStation[0];
    private DabStation[] services = new DabStation[0];
    private final Object mutex = new Object();

    DABListMemory() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void setLists(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
        Object object = this.mutex;
        synchronized (object) {
            this.ensembles = dabStationArray;
            this.services = dabStationArray2;
            this.components = dabStationArray3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public DABListMemory$DABLists getLists() {
        Object object = this.mutex;
        synchronized (object) {
            return new DABListMemory$DABLists(this.ensembles, this.services, this.components, null);
        }
    }
}

