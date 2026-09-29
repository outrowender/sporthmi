/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.metrics.AbstractMetrics;

public interface MetricsModelApp
extends HMIModelApp {
    default public void setMetricsListener(MetricsListener metricsListener) {
    }

    default public void setMetric(AbstractMetrics abstractMetrics) {
    }

    default public AbstractMetrics getMetric() {
    }

    default public void formatChanged() {
    }
}

