/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.modelaccess.HMIModelApp;
import de.audi.atip.metrics.AbstractMetrics;

public interface MetricsModelApp
extends HMIModelApp {
    public void setMetricsListener(MetricsListener var1);

    public void setMetric(AbstractMetrics var1);

    public AbstractMetrics getMetric();

    public void formatChanged();
}

