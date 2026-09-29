/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.MetricsListener;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelGUI;
import de.audi.atip.metrics.AbstractMetrics;
import de.esolutions.fw.util.commons.Buffer;

public class MetricsModel
extends AbstractModel
implements MetricsModelGUI,
MetricsModelApp {
    private volatile MetricsListener metricsListener = DUMMY_LISTENER;
    private AbstractMetrics metric;

    public MetricsModel(int n) {
        super(n, 0);
    }

    public MetricsModel(int n, AbstractMetrics abstractMetrics) {
        super(n, 0);
        this.metric = abstractMetrics;
    }

    public MetricsModel(int n, int n2, AbstractMetrics abstractMetrics) {
        super(n, n2);
        this.metric = abstractMetrics;
    }

    @Override
    public void resetListener() {
        this.metricsListener = DUMMY_LISTENER;
    }

    @Override
    public String dumpContent() {
        Buffer buffer = new Buffer(100);
        buffer.append(super.dumpContent());
        try {
            buffer.append("\nMetrics - Metric: ");
            buffer.append(super.getClass());
            buffer.append("\nMetrics - Value: ");
            buffer.append(this.metric.getValue());
            buffer.append("\nMetrics - Unit: ");
            buffer.append(this.metric.getUnit());
            buffer.append("\nMetrics - Formatted Value: ");
            buffer.append(this.metric.getFormattedValue());
            buffer.append("\nMetrics - Formatted Unit: ");
            buffer.append(this.metric.getFormattedMetricUnit());
        }
        catch (NullPointerException nullPointerException) {
            buffer.append("\nMetrics: null");
        }
        buffer.append("\nMetricsListener: ");
        buffer.append(this.metricsListener);
        return buffer.toString();
    }

    @Override
    public int getModelType() {
        return 9;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void copy(AbstractModel abstractModel) {
        try {
            Object object = this.mutex;
            synchronized (object) {
                MetricsModel metricsModel = (MetricsModel)abstractModel;
                this.metric = metricsModel.metric;
                super.copy(abstractModel);
            }
        }
        catch (Exception exception) {
            this.lc.log(10000, "(%2) MetricsModel.copy( %1 ) failed! ", (Object)abstractModel, (long)this.id);
            this.lc.log(10000, "ERROR: ", (Throwable)exception);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.metric == null;
    }

    @Override
    public AbstractMetrics getMetric() {
        return this.metric;
    }

    @Override
    public void setMetricsListener(MetricsListener metricsListener) {
        this.metricsListener = metricsListener != null ? metricsListener : DUMMY_LISTENER;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void setMetric(AbstractMetrics abstractMetrics) {
        Object object = this.mutex;
        synchronized (object) {
            this.metric = abstractMetrics;
            this.stateChanged();
        }
        this.fireModelUpdateEvent(1);
    }

    @Override
    public void formatChanged() {
        this.fireModelUpdateEvent(13);
    }

    @Override
    public void metricsUpdated(int n) {
        try {
            this.metricsListener.metricsUpdated(this.id, n);
        }
        catch (Exception exception) {
            this.handleListenerException(exception);
        }
    }
}

