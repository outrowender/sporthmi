/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DabStation;

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
    public DABLists getLists() {
        Object object = this.mutex;
        synchronized (object) {
            return new DABLists(this.ensembles, this.services, this.components);
        }
    }

    static class DABLists {
        final DabStation[] components;
        final DabStation[] ensembles;
        final DabStation[] services;

        private DABLists(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
            this.ensembles = dabStationArray;
            this.services = dabStationArray2;
            this.components = dabStationArray3;
        }
    }
}

