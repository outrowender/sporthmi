/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.cartrip;

import de.audi.atip.interapp.cartrip.TripModelHandler;
import de.audi.atip.metrics.AbstractMetrics;

public interface ITripDataProvider {
    public TripModelHandler getTripModelHandler();

    public int[] getProvidedTripDataTypes();

    public AbstractMetrics getTripDataValue(int var1);
}

