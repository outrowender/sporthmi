/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.cartrip;

import de.audi.atip.metrics.AbstractMetrics;

public interface ITripListener {
    default public void updateMetrics(int n, AbstractMetrics abstractMetrics) {
    }
}

