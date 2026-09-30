/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.sport;

import de.audi.atip.hmi.event.ModelUpdateEvent;
import de.audi.atip.hmi.modelaccess.RangeModelGUI;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;

public class ChargingAirPressureGaugeController
extends AbstractWidgetController {
    private IRenderer renderer;
    private float airPressurePercentageValue;

    private void updateContent() {
        if (this.model == null) {
            return;
        }
        if (this.model instanceof RangeModelGUI) {
            this.updateWithRangeModel((RangeModelGUI)this.model);
        }
    }

    private void updateWithRangeModel(RangeModelGUI rangeModelGUI) {
        this.setAirPressurePercentageValue(100.0f * (float)(rangeModelGUI.getValue() - rangeModelGUI.getMinimum()) / (float)(rangeModelGUI.getMaximum() - rangeModelGUI.getMinimum()));
    }

    public void processModelUpdateEvent(ModelUpdateEvent modelUpdateEvent) {
        int n = modelUpdateEvent.getUpdateType();
        switch (n) {
            case 1: 
            case 4: {
                this.updateContent();
                this.setCompositesDirty(true);
                break;
            }
            default: {
                logChannel.log(100000, "ChargingAirPressureGaugeController#processModelUpdateEvent untreated updateType: %1", (long)n);
            }
        }
    }

    public void setRenderer(IRenderer iRenderer) {
        this.renderer = iRenderer;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setAirPressurePercentageValue(float f2) {
        if (f2 < 0.0f || f2 > 100.0f) {
            logChannel.log(100000, "ChargingAirPressureGaugeController#setAirPressurePercentageValue %1", (double)f2);
            f2 = Math.max(Math.min(f2, 100.0f), 0.0f);
        }
        this.airPressurePercentageValue = f2;
    }

    public float getAirPressurePercentageValue() {
        return this.airPressurePercentageValue;
    }
}

