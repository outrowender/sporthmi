/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.metrics.AbstractMetrics;

public interface MetricsModelGUI {
    default public AbstractMetrics getMetric() {
    }

    default public void metricsUpdated(int n) {
    }
}

