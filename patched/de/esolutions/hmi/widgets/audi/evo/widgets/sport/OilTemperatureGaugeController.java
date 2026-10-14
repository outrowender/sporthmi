/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.sport;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.MetricsModelGUI;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.Temperature;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.widgets.LabelController;

public class OilTemperatureGaugeController
extends AbstractWidgetController {
    private float temperature;
    private int temperatureUnit = 2;
    private IRenderer renderer;
    private LabelController[] scaleLabels;
    // tick values at bar fractions 0.125/0.375/0.625/0.875 for each unit range
    private static /*final*/ String[] CELSIUS_SCALE = new String[]{"30", "60", "90", "120"};
    private static /*final*/ String[] FAHRENHEIT_SCALE = new String[]{"140", "190", "240", "290"};

    protected void initializeWidget() {
        // immediate model bind fires no event; read stored metric on connect
        super.initializeWidget();
        this.updateContent();
    }

    private void updateContent() {
        if (this.model == null) {
            return;
        }
        if (this.model instanceof MetricsModelGUI) {
            this.updateWithMetrics(((MetricsModelGUI)this.model).getMetric());
        }
    }

    private void updateWithMetrics(AbstractMetrics abstractMetrics) {
        if (abstractMetrics == null) {
            logChannel.log(100000, "OilTemperatureGaugeController#updateWithMetrics: metric is null");
            return;
        }
        if (!(abstractMetrics instanceof Temperature)) {
            logChannel.log(100000, "OilTemperatureGaugeController#updateWithMetrics: metric must be Temperature: %1", (Object)abstractMetrics);
            return;
        }
        Temperature temperature = (Temperature)abstractMetrics;
        switch (temperature.getUnit()) {
            case 1: 
            case 2: {
                this.setTemperatureValues(temperature.getUnit(), temperature.getValue(temperature.getUnit()));
                break;
            }
            default: {
                logChannel.log(100000, "Unsupported temperature unit: %1", (Object)abstractMetrics.getFormattedMetricUnit());
                return;
            }
        }
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        switch (modelUpdateEvent.getUpdateType()) {
            case 1: 
            case 13: 
            case 14: {
                // 14 = deferredConnected: sync stored metric when the view binds
                this.updateContent();
                this.setCompositesDirty(true);
                break;
            }
            default: {
                logChannel.log(100000, "OilTemperatureGaugeController#processModelUpdateEvent: ignore model update event (%1) here", (Object)modelUpdateEvent);
            }
        }
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setTemperatureValues(int n, float f2) {
        this.temperatureUnit = n;
        this.temperature = f2;
        this.updateScaleLabels();
    }

    public void setScaleLabels(LabelController[] labelControllerArray) {
        this.scaleLabels = labelControllerArray;
        this.updateScaleLabels();
    }

    private void updateScaleLabels() {
        if (this.scaleLabels == null) {
            return;
        }
        String[] scale = this.temperatureUnit == 1 ? CELSIUS_SCALE : FAHRENHEIT_SCALE;
        for (int i2 = 0; i2 < this.scaleLabels.length && i2 < scale.length; ++i2) {
            if (this.scaleLabels[i2] != null) {
                this.scaleLabels[i2].setText(scale[i2]);
            }
        }
    }

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public float getTemperature() {
        return this.temperature;
    }
}

