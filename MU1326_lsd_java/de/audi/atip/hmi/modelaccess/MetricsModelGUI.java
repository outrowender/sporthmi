/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.metrics.AbstractMetrics;

public interface MetricsModelGUI {
    public AbstractMetrics getMetric();

    public void metricsUpdated(int var1);
}

