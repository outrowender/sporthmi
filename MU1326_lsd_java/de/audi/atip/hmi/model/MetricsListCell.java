/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.atip.metrics.Pressure;
import de.audi.atip.metrics.Speed;
import de.audi.atip.metrics.Temperature;
import java.util.Date;

public class MetricsListCell
implements ListCell {
    private AbstractMetrics metrics;

    public MetricsListCell copy() {
        AbstractMetrics abstractMetrics = null;
        if (this.metrics instanceof Pressure) {
            Pressure pressure = (Pressure)this.metrics;
            abstractMetrics = new Pressure(pressure.getValue(), pressure.getUnit());
        } else if (this.metrics instanceof Speed) {
            Speed speed = (Speed)this.metrics;
            abstractMetrics = new Speed(speed.getValue(), speed.getUnit());
        } else if (this.metrics instanceof Temperature) {
            Temperature temperature = (Temperature)this.metrics;
            abstractMetrics = new Speed(temperature.getValue(), temperature.getUnit());
        } else if (this.metrics instanceof Distance) {
            Distance distance = (Distance)this.metrics;
            abstractMetrics = new Distance(distance.getValue(), distance.getUnit());
        } else if (this.metrics instanceof DateMetric) {
            DateMetric dateMetric = (DateMetric)this.metrics;
            abstractMetrics = new DateMetric(new Date(dateMetric.getDate().getTime()), dateMetric.getType());
        } else {
            throw new UnsupportedOperationException("MetricsListCell#copy Copying for metric type not supported.");
        }
        return new MetricsListCell(abstractMetrics);
    }

    public AbstractMetrics getMetrics() {
        return this.metrics;
    }

    public MetricsListCell(AbstractMetrics abstractMetrics) {
        this.metrics = abstractMetrics;
    }

    public void setMetrics(AbstractMetrics abstractMetrics) {
        this.metrics = abstractMetrics;
    }
}

