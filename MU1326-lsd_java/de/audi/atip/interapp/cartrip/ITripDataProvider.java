/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.cartrip;

import de.audi.atip.interapp.cartrip.TripModelHandler;
import de.audi.atip.metrics.AbstractMetrics;

public interface ITripDataProvider {
    default public TripModelHandler getTripModelHandler() {
    }

    default public int[] getProvidedTripDataTypes() {
    }

    default public AbstractMetrics getTripDataValue(int n) {
    }
}

