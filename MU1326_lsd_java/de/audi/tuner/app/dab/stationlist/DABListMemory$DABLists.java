/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DABListMemory$1;

class DABListMemory$DABLists {
    final DabStation[] components;
    final DabStation[] ensembles;
    final DabStation[] services;

    private DABListMemory$DABLists(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3) {
        this.ensembles = dabStationArray;
        this.services = dabStationArray2;
        this.components = dabStationArray3;
    }

    /* synthetic */ DABListMemory$DABLists(DabStation[] dabStationArray, DabStation[] dabStationArray2, DabStation[] dabStationArray3, DABListMemory$1 dABListMemory$1) {
        this(dabStationArray, dabStationArray2, dabStationArray3);
    }
}

